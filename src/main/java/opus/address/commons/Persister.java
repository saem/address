package opus.address.commons;

import opus.address.database.jooq.generated.Tables;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;

import java.util.ArrayList;
import java.util.List;

public class Persister {
    private final List<Operation> operations = new ArrayList<>();

    public final Persister addOperation(Operation operation) {
        this.operations.add(operation);
        return this;
    }

    public final void makeGo() {
        // group by
        // stage 1: insert of the event
        //  return ids
        //  complete all event futures

        // stage 2: insert of the entities
        //  return ids
        //  complete all entity futures

        // stage 3: insert of entity type operations
        //  return ids
        //  complete all trait futures

        // stage 4: insert of facts
    }
}

final class OneTimeSet<V> {
    private boolean notSet = true;
    private V value;

    public void set(V value) {
        if (notSet) {
            this.value = value;
            notSet = false;
        }
    }

    public V get() { return value; }
}

// @todo get rid of Comparable?

interface Operation {
    public InsertResultStep getQuery(DSLContext db);
}

final class EventOperation implements Operation {
    private final OneTimeSet<Long> id = new OneTimeSet<>();
    private final String codeVersion;
    private final long actorId;
    private final String eventName;

    public EventOperation(
            final String codeVersion,
            final long actorId,
            final String eventName) {
        this.codeVersion = codeVersion;
        this.actorId = actorId;
        this.eventName = eventName;
    }

    public InsertResultStep getQuery(DSLContext db) {
        return db.insertInto(Tables.Events,
                Tables.Events.Event,
                Tables.Events.CodeVersion,
                Tables.Events.EventVersion,
                Tables.Events.Actor)
                .values(eventName, codeVersion, 1, actorId)
                .returning(Tables.Events.Sequence, Tables.Events.When);
    }

    public void setId(Long id) { this.id.set(id); }
    public OneTimeSet<Long> getId() { return id; }
}

final class EntityOperation implements Operation {
    private final OneTimeSet<Long> id = new OneTimeSet<>();

    public InsertResultStep getQuery(DSLContext db) {
        return db.insertInto(Tables.Entities)
                .defaultValues()
                .returning(Tables.Entities.EntityId);
    }

    public void setId(Long id) { this.id.set(id); }
    public OneTimeSet<Long> getId() { return id; }
}

interface EntityTypeOperation extends Operation {}

final class UserEntityTypeOperation implements EntityTypeOperation {
    private final EntityOperation entity;

    UserEntityTypeOperation(
            final EntityOperation entity) {
        this.entity = entity;
    }

    @Override
    public InsertResultStep getQuery(final DSLContext db) {
        return db.insertInto(Tables.Users,
                Tables.Users.EntityId)
                .values(entity.getId().get())
                .returning();
    }
}

abstract class FactOperation<V> implements Operation {
    private final EventOperation event;
    private final EntityOperation entity;
    private final V value;

    protected FactOperation(
            final EventOperation event,
            final EntityOperation entity,
            final V value
    ) {
        this.event = event;
        this.entity = entity;
        this.value = value;
    }
}

final class StringFactOperation extends FactOperation<String> {
    public StringFactOperation(
            final EventOperation event,
            final EntityOperation entity,
            final String value
    ) {
        super(event, entity, value);
    }

    @Override
    public InsertResultStep getQuery(DSLContext db) {
        return null;
    }
}

