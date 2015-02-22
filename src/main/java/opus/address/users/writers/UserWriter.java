package opus.address.users.writers;

import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.UserFacts;
import opus.address.database.jooq.generated.tables.records.Events;
import opus.address.security.PasswordDigester;
import opus.address.users.events.UserCreated;
import opus.address.users.events.UserUpdated;
import opus.address.users.projections.UserFactProjection;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.util.Optional;

public final class UserWriter {
    private final DSLContext database;
    private final PasswordDigester passwordDigester;
    private final String codeVersion;

    public UserWriter(final DSLContext database, final PasswordDigester passwordDigester, final String codeVersion) {
        this.database = database;
        this.passwordDigester = passwordDigester;
        this.codeVersion = codeVersion;
    }

    public Optional<UserCreated> write(String email, String username, String password, Boolean isDisabled, Long actorId) {
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

                    final String digestedPassword = passwordDigester.digestPassword(password);

                    final Long entityId = db.insertInto(Tables.Entities)
                            .defaultValues()
                            .returning(Tables.Entities.EntityId)
                            .fetchOne()
                            .entityId();

                    db.insertInto(Tables.Users,
                            Tables.Users.EntityId)
                            .values(entityId)
                            .execute();

                    db.insertInto(Tables.UserFacts,
                            Tables.UserFacts.Email,
                            Tables.UserFacts.Password,
                            Tables.UserFacts.Sequence,
                            Tables.UserFacts.Username,
                            Tables.UserFacts.UserId,
                            Tables.UserFacts.IsDisabled)
                            .values(
                                    email,
                                    digestedPassword,
                                    sequenceWhen.sequence(),
                                    username,
                                    entityId,
                                    isDisabled
                            )
                            .execute();

                    return new UserCreated(sequenceWhen.sequence(), entityId, sequenceWhen.when().toInstant());
                }
        ));
    }
    
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
                            .values(UserUpdated.EVENT_NAME, codeVersion, 1, actorId)
                            .returning(Tables.Events.Sequence, Tables.Events.When)
                            .fetchOne();

                    final String digestedPassword = passwordDigester.digestPassword(password);

                    final UserFactProjection existingUserFacts = db.select()
                            .from(UserFacts.UserFacts)
                            .where(UserFacts.UserFacts.UserId.equal(userId))
                            .orderBy(DSL.max(UserFacts.UserFacts.Sequence).desc())
                            .fetchOneInto(UserFactProjection.class);
                    
                    db.insertInto(Tables.UserFacts,
                            Tables.UserFacts.Email,
                            Tables.UserFacts.Password,
                            Tables.UserFacts.Sequence,
                            Tables.UserFacts.Username,
                            Tables.UserFacts.UserId,
                            Tables.UserFacts.IsDisabled,
                            Tables.UserFacts.IsDeleted)
                            .values(
                                    email,
                                    digestedPassword,
                                    sequenceWhen.sequence(),
                                    username,
                                    userId,
                                    existingUserFacts.isDisabled,
                                    existingUserFacts.isDeleted
                            )
                            .execute();

                    return new UserUpdated(sequenceWhen.sequence(), userId, sequenceWhen.when().toInstant());
                }
        ));
    }
}

