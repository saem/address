package opus.address.users;

import opus.address.AddressApplication;
import opus.address.commons.persistence.*;
import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.User;
import opus.address.database.jooq.generated.tables.records.EventRecord;
import opus.address.users.representations.UserWriteRepresentation;
import org.jooq.DSLContext;
import org.jooq.Insert;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public final class UserResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response write(
            final UserWriteRepresentation userWrite,
            final @Context DSLContext database
    ) {
        return UserWriter.build(database)
                .write(userWrite)
                .map(this::writeToResponse);
    }
}

final class Actor {
    public final long actorId = 1L;
}

interface Command {
    Actor getActor();
    String getEventName();
}

final class CreateUserCommand implements Command {
    public final UserWriteRepresentation userWrite;

    public CreateUserCommand(final UserWriteRepresentation userWrite) {
        this.userWrite = userWrite;
    }

    public Actor getActor() {
        return new Actor();
    }

    public String getEventName() { return "UserCreated.1"; }
}

final class CreateUserReport {}

final class UserWriter {
    private final DSLContext userReservationDatabase;
    private final DSLContext eventStoreDatabase;

    public UserWriter(
            final DSLContext userReservationDatabase,
            final DSLContext eventStoreDatabase
    ) {
        this.userReservationDatabase = userReservationDatabase;
        this.eventStoreDatabase = eventStoreDatabase;
    }

    public CreateUserReport command(CreateUserCommand command) {
        // write to command log
        // validate, username at least
        // run command

        // write event
        final Persister persister = new Persister(
                AddressApplication.CODE_VERSION,
                command.getActor().actorId,
                command.getEventName());
        final UserPersister userPersister = new UserPersister(persister);
        userPersister.write(
                command.userWrite.email,
                command.userWrite.username,
                command.userWrite.password
        );
        persister.persist(eventStoreDatabase);

        // return report

        return new CreateUserReport();
    }
}

final class UserPersister {
    private final Persister persister;

    public UserPersister(final Persister persister) {
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
