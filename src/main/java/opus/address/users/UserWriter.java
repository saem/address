package opus.address.users;

import opus.address.commons.Try;
import opus.address.commons.persistence.*;
import opus.address.database.jooq.generated.Tables;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public final class UserWriter {
    private final DSLContext database;
    private final String codeVersion;

    public UserWriter(
            final DSLContext database, 
            final String codeVersion
    ) {
        this.database = database;
        this.codeVersion = codeVersion;
    }

    public Try<UserCreated> write(
            final String email,
            final String username,
            final String password,
            final Long actorId) {
        final Persister persister = new Persister(codeVersion, 1, actorId, UserCreated.EVENT_NAME);
        return database.transactionResult(c -> {
                    final DSLContext db = DSL.using(c);

                    final EntityOperation entity = new EntityOperation();
                    final UserEntityTypeOperation userEntity = new UserEntityTypeOperation(entity);

                    persister.addOperation(userEntity)
                            .addOperation(new StringFactOperation(entity, Tables.UsersFactsPassword.UserId, Tables.UsersFactsPassword.Password, password))
                            .addOperation(new StringFactOperation(entity, Tables.UsersFactsEmail.UserId, Tables.UsersFactsEmail.Email, email))
                            .addOperation(new StringFactOperation(entity, Tables.UsersFactsUsername.UserId, Tables.UsersFactsUsername.Username, username))
                    ;

                    return persister.persist(db)
                            .map(event -> new UserCreated(event.sequence(), entity.getId(), event.when().toInstant()));
                }
        );
    }

    public Try<UserUpdated> update(
            final long userId,
            final String email,
            final String username,
            final String password,
            final long actorId
    ) {
        final Persister persister = new Persister(codeVersion, 1, actorId, UserUpdated.EVENT_NAME);
        return database.transactionResult(c -> {
                    final DSLContext db = DSL.using(c);
                    final ExistingEntity entity = new ExistingEntity(userId);

                    persister.addOperation(new StringFactOperation(entity, Tables.UsersFactsPassword.UserId, Tables.UsersFactsPassword.Password, password))
                            .addOperation(new StringFactOperation(entity, Tables.UsersFactsEmail.UserId, Tables.UsersFactsEmail.Email, email))
                            .addOperation(new StringFactOperation(entity, Tables.UsersFactsUsername.UserId, Tables.UsersFactsUsername.Username, username))
                    ;

                    return persister.persist(db)
                            .map(event -> new UserUpdated(event.sequence(), userId, event.when().toInstant()));
                }
        );
    }

    public Try<UserDeleted> delete(
            final long userId,
            final long actorId
    ) {
        final Persister persister = new Persister(codeVersion, 1, actorId, UserUpdated.EVENT_NAME);
        return database.transactionResult(c -> {
                    final DSLContext db = DSL.using(c);
                    final ExistingEntity entity = new ExistingEntity(userId);

                    persister.addOperation(new BooleanFactOperation(entity, Tables.UsersFactsIsDeleted.UserId, Tables.UsersFactsIsDeleted.IsDeleted, true))
                    ;

                    return persister.persist(db)
                            .map(event -> new UserDeleted(event.sequence(), userId, event.when().toInstant()));
                }
        );
    }
}

