package opus.address.users;

import opus.address.AddressApplication;
import opus.address.commons.http.Https;
import opus.address.commons.persistence.Persister;
import opus.address.security.PasswordDigester;
import org.jooq.DSLContext;
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
