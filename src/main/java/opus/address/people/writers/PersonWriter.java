package opus.address.people.writers;

import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.records.Events;
import opus.address.people.events.PersonCreated;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.util.Optional;

public final class PersonWriter {
    private final DSLContext database;
    private final String codeVersion;

    public PersonWriter(
            final DSLContext database, 
            final String codeVersion) {
        this.database = database;
        this.codeVersion = codeVersion;
    }

    public Optional<PersonCreated> write(
            final String email, 
            final String username, 
            final String password, 
            final Boolean isDisabled, 
            final Long actorId
    ) {
        return Optional.ofNullable(database.transactionResult(c -> {
                    final DSLContext db = DSL.using(c);

                    final Events sequenceWhen = db.insertInto(Tables.Events,
                            Tables.Events.Event,
                            Tables.Events.CodeVersion,
                            Tables.Events.EventVersion,
                            Tables.Events.Actor)
                            .values(PersonCreated.EVENT_NAME, codeVersion, 1, actorId)
                            .returning(Tables.Events.Sequence, Tables.Events.When)
                            .fetchOne();

                    final Long entityId = db.insertInto(Tables.Entities)
                            .defaultValues()
                            .returning(Tables.Entities.EntityId)
                            .fetchOne()
                            .entityId();

                    db.insertInto(Tables.People,
                            Tables.People.EntityId)
                            .values(entityId)
                            .execute();

                    db.insertInto(Tables.PeopleFacts,
                            
                            
                            Tables.PeopleFacts.Email,
                            Tables.PeopleFacts.Password,
                            Tables.PeopleFacts.Sequence,
                            Tables.PeopleFacts.Username,
                            Tables.PeopleFacts.UserId,
                            Tables.PeopleFacts.IsDisabled)
                            .values(
                                    email,
                                    sequenceWhen.sequence(),
                                    username,
                                    entityId,
                                    isDisabled
                            )
                            .execute();

                    return new PersonCreated(sequenceWhen.sequence(), entityId, sequenceWhen.when().toInstant());
                }
        ));
    }
}
