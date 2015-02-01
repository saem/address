package opus.address.users.writers;

import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.records.Events;
import opus.address.security.PasswordDigester;
import org.jooq.DSLContext;

public final class UserWriter {
    private final DSLContext database;
    private final PasswordDigester passwordDigester;

    public UserWriter(final DSLContext database, final PasswordDigester passwordDigester) {
        this.database = database;
        this.passwordDigester = passwordDigester;
    }

    public Events write(String email, String username, String password, Long actorId) {
        // @todo start a transaction
        
        final Events sequenceWhen = database.insertInto(Tables.Events,
                Tables.Events.Event,
                Tables.Events.Version,
                Tables.Events.Actor)
                .values("create_user", 1, actorId)
                .returning(Tables.Events.Sequence, Tables.Events.When)
                .fetchOne();

        // @todo fetch out the sequence and the when (for funsies).

        final String digestedPassword = passwordDigester.digestPassword(password);

        final Long entityId = database.insertInto(Tables.Entities)
                .defaultValues()
                .returning(Tables.Entities.EntityId)
                .fetchOne()
                .entityId();
        
        database.insertInto(Tables.Users,
                Tables.Users.EntityId)
                .values(entityId);
        
        database.insertInto(Tables.UserStates,
                Tables.UserStates.Email,
                Tables.UserStates.Password,
                Tables.UserStates.Sequence,
                Tables.UserStates.Username,
                Tables.UserStates.UserId)
                .values(
                        email, 
                        digestedPassword, 
                        sequenceWhen.sequence(), 
                        username, 
                        entityId
                );

        return sequenceWhen;
    }
}

class UserCreated {
    public final long sequence;
    public final long userId;
    
    public UserCreated(long sequence, long userId) {
        this.sequence = sequence;
        this.userId = userId;
    }
}