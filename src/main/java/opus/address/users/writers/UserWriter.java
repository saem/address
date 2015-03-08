package opus.address.users.writers;

import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.records.Events;
import opus.address.users.events.UserCreated;
import opus.address.users.events.UserUpdated;
import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.impl.DSL;

import java.util.Optional;

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

    public Optional<UserCreated> write(
            final String email,
            final String username,
            final String password,
            final Long actorId) {
        return Optional.ofNullable(database.transactionResult(c -> {
                    final DSLContext db = DSL.using(c);

                    final Events sequenceWhen = db.insertInto(Tables.Events,
                            Tables.Events.Event,
                            Tables.Events.CodeVersion,
                            Tables.Events.EventVersion,
                            Tables.Events.Actor)
                            .values(UserCreated.EVENT_NAME, codeVersion, 1, actorId)
                            .returning(Tables.Events.Sequence, Tables.Events.When)
                            .fetchOne();
 
                    final Long entityId = db.insertInto(Tables.Entities)
                            .defaultValues()
                            .returning(Tables.Entities.EntityId)
                            .fetchOne()
                            .entityId();

                    db.batch(                    
                            buildWriteQuery(
                                    entityId, 
                                    db
                            ),
                            buildPasswordQuery(
                                    password,
                                    entityId,
                                    sequenceWhen.sequence(),
                                    db
                            ),
                            buildEmailQuery(
                                    email,
                                    entityId,
                                    sequenceWhen.sequence(),
                                    db
                            ),
                            buildUsernameQuery(
                                    username,
                                    entityId,
                                    sequenceWhen.sequence(),
                                    db
                            )
                    ).execute();

                    return new UserCreated(sequenceWhen.sequence(), entityId, sequenceWhen.when().toInstant());
                }
        ));
    }

    private static Query buildEmailQuery(
            final String email,
            final long entityId,
            final long sequence,
            final DSLContext db
    ) {
        return db.insertInto(Tables.UsersFactsEmail,
                Tables.UsersFactsEmail.Email,
                Tables.UsersFactsEmail.Sequence,
                Tables.UsersFactsEmail.UserId)
                .values(
                        email,
                        sequence,
                        entityId
                );
    }

    private static Query buildIsDeletedQuery(
            final boolean isDeleted,
            final long entityId,
            final long sequence,
            final DSLContext db
    ) {
        return db.insertInto(Tables.UsersFactsIsDeleted,
                Tables.UsersFactsIsDeleted.IsDeleted,
                Tables.UsersFactsIsDeleted.Sequence,
                Tables.UsersFactsIsDeleted.UserId)
                .values(
                        isDeleted,
                        sequence,
                        entityId
                );
    }

    private static Query buildPasswordQuery(
            final String password,
            final long entityId,
            final long sequence,
            final DSLContext db
    ) {
        return db.insertInto(Tables.UsersFactsPassword,
                Tables.UsersFactsPassword.Password,
                Tables.UsersFactsPassword.Sequence,
                Tables.UsersFactsPassword.UserId)
                .values(
                        password,
                        sequence,
                        entityId
                );
    }

    private static Query buildUsernameQuery(
            final String username,
            final long entityId,
            final long sequence,
            final DSLContext db
    ) {
        return db.insertInto(Tables.UsersFactsUsername,
                Tables.UsersFactsUsername.Username,
                Tables.UsersFactsUsername.Sequence,
                Tables.UsersFactsUsername.UserId)
                .values(
                        username,
                        sequence,
                        entityId
                );
    }
    
    private static Query buildWriteQuery(
            final long entityId,
            final DSLContext db
    ) {
        return db.insertInto(Tables.Users,
                Tables.Users.EntityId)
                .values(entityId);
    }
    
//    public Optional<UserDeleted> delete(
//            long userId
//    ) {
//        
//        
//    }
    
    public Optional<UserUpdated> update(
            Long userId,
            String email, 
            String username, 
            String password,
            Long actorId
    ) {
        return Optional.ofNullable(database.transactionResult(c -> {
                    final DSLContext db = DSL.using(c);

                    final Events sequenceWhen = db.insertInto(Tables.Events,
                            Tables.Events.Event,
                            Tables.Events.CodeVersion,
                            Tables.Events.EventVersion,
                            Tables.Events.Actor)
                            .values(UserCreated.EVENT_NAME, codeVersion, 1, actorId)
                            .returning(Tables.Events.Sequence, Tables.Events.When)
                            .fetchOne();

                    db.batch(
                            buildPasswordQuery(
                                    password,
                                    userId,
                                    sequenceWhen.sequence(),
                                    db
                            ),
                            buildEmailQuery(
                                    email,
                                    userId,
                                    sequenceWhen.sequence(),
                                    db
                            ),
                            buildUsernameQuery(
                                    username,
                                    userId,
                                    sequenceWhen.sequence(),
                                    db
                            )
                    ).execute();

                    return new UserUpdated(sequenceWhen.sequence(), userId, sequenceWhen.when().toInstant());
                }
        ));
    }
}

