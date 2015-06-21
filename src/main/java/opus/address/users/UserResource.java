package opus.address.users;

import opus.address.AddressApplication;
import opus.address.commons.http.Https;
import opus.address.commons.persistence.*;
import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.Users;
import opus.address.database.jooq.generated.tables.records.Events;
import opus.address.security.PasswordDigester;
import opus.address.users.representations.UserCreatedRepresentation;
import opus.address.users.representations.UserDeletedRepresentation;
import opus.address.users.representations.UserUpdatedRepresentation;
import org.jooq.DSLContext;
import org.jooq.Insert;
import org.jooq.impl.DSL;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/events/user")
public final class UserResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/created")
    public Response userCreated(
            @Valid UserCreatedRepresentation userCreatedRepresentation,
            @Context DSLContext database
    ) {
        final Persister persister = new Persister(AddressApplication.CODE_VERSION, userCreatedRepresentation.actorId, userCreatedRepresentation.getName());

        new UserWriter(persister)
                .write(
                        userCreatedRepresentation.email,
                        userCreatedRepresentation.username,
                        new PasswordDigester().digestPassword(
                                userCreatedRepresentation.password
                        ));

        return database.transactionResult(c -> Https.mapEventToResponse(persister.persist(DSL.using(c))));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updated")
    public Response userUpdated(
            @Valid UserUpdatedRepresentation userUpdatedRepresentation,
            @Context DSLContext database
    ) {
        final Persister persister = new Persister(AddressApplication.CODE_VERSION, userUpdatedRepresentation.actorId, userUpdatedRepresentation.getName());
        new UserWriter(persister)
                .update(userUpdatedRepresentation.userId,
                        userUpdatedRepresentation.email,
                        userUpdatedRepresentation.username,
                        userUpdatedRepresentation.password
                );
        return database.transactionResult(c -> Https.mapEventToResponse(persister.persist(DSL.using(c))));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deleted")
    public Response userDeleted(
            @Valid UserDeletedRepresentation userDeletedRepresentation,
            @Context DSLContext database
    ) {
        final Persister persister = new Persister(AddressApplication.CODE_VERSION, userDeletedRepresentation.actorId, userDeletedRepresentation.getName());
        new UserWriter(persister)
                .delete(userDeletedRepresentation.userId
                );
        return database.transactionResult(c -> Https.mapEventToResponse(persister.persist(DSL.using(c))));
    }
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
                .addOperation(new StringFactOperation(entity, Tables.UsersFactsPassword.UserId, Tables.UsersFactsPassword.Password, password))
                .addOperation(new StringFactOperation(entity, Tables.UsersFactsEmail.UserId, Tables.UsersFactsEmail.Email, email))
                .addOperation(new StringFactOperation(entity, Tables.UsersFactsUsername.UserId, Tables.UsersFactsUsername.Username, username))
        ;
    }

    public void update(
            final long userId,
            final String email,
            final String username,
            final String password
    ) {
        final ExistingEntity entity = new ExistingEntity(userId);

        persister.addOperation(new StringFactOperation(entity, Tables.UsersFactsPassword.UserId, Tables.UsersFactsPassword.Password, password))
                .addOperation(new StringFactOperation(entity, Tables.UsersFactsEmail.UserId, Tables.UsersFactsEmail.Email, email))
                .addOperation(new StringFactOperation(entity, Tables.UsersFactsUsername.UserId, Tables.UsersFactsUsername.Username, username))
        ;
    }

    public void delete(
            final long userId
    ) {
        final ExistingEntity entity = new ExistingEntity(userId);

        persister.addOperation(new BooleanFactOperation(entity, Tables.UsersFactsIsDeleted.UserId, Tables.UsersFactsIsDeleted.IsDeleted, true))
        ;
    }
}

final class UserEntityTypeOperation extends EntityTypeOperation {
    UserEntityTypeOperation(final EntityOperation entity) {
        super(entity);
    }

    @Override
    public Insert getQuery(final DSLContext db, final Events event) {
        return db.insertInto(Tables.Users,
                Tables.Users.EntityId)
                .values(entity.getId());
    }

    public Users getTable() { return Tables.Users; }
}
