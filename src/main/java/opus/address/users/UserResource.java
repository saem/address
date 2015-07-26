package opus.address.users;

import opus.address.commons.persistence.*;
import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.User;
import opus.address.database.jooq.generated.tables.records.EventRecord;
import org.jooq.DSLContext;
import org.jooq.Insert;

import javax.ws.rs.Path;

@Path("/user")
public final class UserResource {

}

final class UserWriter {
    private final Persister persister;

    public UserWriter(final Persister persister) {
        this.persister = persister;
    }

    public void write(
            final String email,
            final String username,
            final String password) {
        final EntityOperation entity = new EntityOperation();
        final UserEntityTypeOperation userEntity = new UserEntityTypeOperation(entity);

        persister.addOperation(userEntity)
                .addOperation(new StringFactOperation(entity, Tables.UserFactPassword.UserId, Tables.UserFactPassword.Password, password))
                .addOperation(new StringFactOperation(entity, Tables.UserFactEmail.UserId, Tables.UserFactEmail.Email, email))
                .addOperation(new StringFactOperation(entity, Tables.UserFactUsername.UserId, Tables.UserFactUsername.Username, username))
        ;
    }

    public void update(
            final long userId,
            final String email,
            final String username,
            final String password
    ) {
        final ExistingEntity entity = new ExistingEntity(userId);

        persister.addOperation(new StringFactOperation(entity, Tables.UserFactPassword.UserId, Tables.UserFactPassword.Password, password))
                .addOperation(new StringFactOperation(entity, Tables.UserFactEmail.UserId, Tables.UserFactEmail.Email, email))
                .addOperation(new StringFactOperation(entity, Tables.UserFactUsername.UserId, Tables.UserFactUsername.Username, username))
        ;
    }

    public void delete(
            final long userId
    ) {
        final ExistingEntity entity = new ExistingEntity(userId);

        persister.addOperation(new BooleanFactOperation(entity, Tables.UserFactIsDeleted.UserId, Tables.UserFactIsDeleted.IsDeleted, true))
        ;
    }
}

final class UserEntityTypeOperation extends EntityTypeOperation {
    UserEntityTypeOperation(final EntityOperation entity) {
        super(entity);
    }

    @Override
    public Insert getQuery(final DSLContext db, final EventRecord event) {
        return db.insertInto(Tables.User,
                Tables.User.EntityId)
                .values(entity.getId());
    }

    public User getTable() { return Tables.User; }
}
