package opus.address.commons.persistence;

import opus.address.commons.Try;
import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.records.Events;
import org.jooq.DSLContext;
import org.jooq.Table;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Persister {
    private final Set<EntityOperation> entities = new HashSet<>();
    private final Set<EntityTypeOperation> entityTypes = new HashSet<>();
    private final Set<FactOperation> facts = new HashSet<>();

    private final String codeVersion;
    private final long actorId;
    private final String eventName;
    private final int eventVersion;

    public Persister(final String codeVersion,
                     final int eventVersion,
                     final long actorId,
                     final String eventName) {
        this.codeVersion = codeVersion;
        this.eventVersion = eventVersion;
        this.actorId = actorId;
        this.eventName = eventName;
    }

    public Persister addOperation(final EntityOperation operation) {
        this.entities.add(operation);
        return this;
    }

    public Persister addOperation(final EntityTypeOperation operation) {
        this.entityTypes.add(operation);
        this.entities.add(operation.entity);
        return this;
    }

    public Persister addOperation(final FactOperation operation) {
        this.facts.add(operation);
        return this;
    }

    // @todo This should return the sequence and when
    public Try<Events> persist(final DSLContext database) {
        // stage 1: insert of the event
        //  return ids
        //  complete all event futures
        return Try.attempt(() -> {
            final String tablesAffected = Stream.concat(
                    Stream.concat(entities.stream().map(EntityOperation::getTable),
                            entityTypes.stream().map(Operation::getTable)),
                    facts.stream().map(FactOperation::getTable)
            ).distinct().map(Table::getName).collect(Collectors.joining(","));

            final Events event = database.insertInto(Tables.Events,
                    Tables.Events.Event,
                    Tables.Events.CodeVersion,
                    Tables.Events.EventVersion,
                    Tables.Events.Actor,
                    Tables.Events.TablesAffected)
                    .values(eventName, codeVersion, eventVersion, actorId, tablesAffected)
                    .returning(Tables.Events.Sequence, Tables.Events.When)
                    .fetchOne();

            // stage 2: insert of the entities
            //  return ids
            //  complete all entity futures
            entities.forEach(o -> o.setId(o.getQuery(database, event).fetchOne().entityId()));

            // stage 3: insert of entity type operations
            batchExecute(database, event, entityTypes);

            // stage 4: insert of facts
            batchExecute(database, event, facts);

            return event;
        });
    }
    
    private void batchExecute(
            final DSLContext database, 
            final Events event, 
            final Set<? extends Operation> operations) {
        database.batch(
                operations.stream().map(o -> o.getQuery(database, event)).collect(Collectors.toList()))
                .execute();
    }
}

