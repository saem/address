package opus.address.users;

import io.dropwizard.jersey.params.LongParam;
import opus.address.security.PasswordDigester;
import org.jooq.DSLContext;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.Optional;

@Path("/users")
public final class UserResource {

    private final UserFactory userFactory;

    public UserResource(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAUser(
            @Valid UserWriteRepresentation userWriteRepresentation,
            @Context DSLContext database
    ) {
        final Optional<UserCreated> userCreated = userFactory.buildUserWriter(database)
                .write(
                        userWriteRepresentation.email,
                        userWriteRepresentation.username,
                        new PasswordDigester().digestPassword(
                                userWriteRepresentation.password
                        ),
                        userWriteRepresentation.actorId);

        return userCreated
                .map(u ->
                        Response.created(
                                UriBuilder
                                        .fromPath("/events/{sequenceId}/users/{userId}")
                                        .build(u.sequence, u.userId))
                                .build())
                .orElseGet(() -> Response.serverError().build());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response updateAUser(
            @PathParam("userId") LongParam userId,
            @Valid UserWriteRepresentation userWriteRepresentation,
            @Context DSLContext database
    ) {
        final Optional<UserUpdated> useUpdated = userFactory.buildUserWriter(database)
                .update(userId.get(),
                        userWriteRepresentation.email,
                        userWriteRepresentation.username,
                        userWriteRepresentation.password,
                        userWriteRepresentation.actorId
                );
        
        return useUpdated.map(u ->
                Response.created(
                        UriBuilder
                                .fromPath("/events/{sequenceId}/users/{userId}")
                                .build(u.sequence, u.userId))
                        .build())
        .orElseGet(() -> Response.serverError().build());
    }
}
