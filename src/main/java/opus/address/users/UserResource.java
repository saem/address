package opus.address.users;

import opus.address.commons.http.Https;
import opus.address.security.PasswordDigester;
import org.jooq.DSLContext;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/events/user")
public final class UserResource {

    private final UserFactory userFactory;

    public UserResource(UserFactory userFactory) {
        this.userFactory = userFactory;
    }
    
    public static UserResource build(
            final String codeVersion
            
    ) {
        return new UserResource(new UserFactory(codeVersion));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/created")
    public Response userCreated(
            @Valid UserCreatedRepresentation userCreatedRepresentation,
            @Context DSLContext database
    ) {
        return Https.mapEventToResponse(
                userFactory.buildUserWriter(database)
                        .write(
                                userCreatedRepresentation.email,
                                userCreatedRepresentation.username,
                                new PasswordDigester().digestPassword(
                                        userCreatedRepresentation.password
                                ),
                                userCreatedRepresentation.actorId));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updated")
    public Response userUpdated(
            @Valid UserUpdatedRepresentation userUpdatedRepresentation,
            @Context DSLContext database
    ) {
        return Https.mapEventToResponse(
                userFactory.buildUserWriter(database)
                        .update(userUpdatedRepresentation.userId,
                                userUpdatedRepresentation.email,
                                userUpdatedRepresentation.username,
                                userUpdatedRepresentation.password,
                                userUpdatedRepresentation.actorId
                        ));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deleted")
    public Response userDeleted(
            @Valid UserDeletedRepresentation userDeletedRepresentation,
            @Context DSLContext database
    ) {
        return Https.mapEventToResponse(
                userFactory.buildUserWriter(database)
                        .delete(userDeletedRepresentation.userId,
                                userDeletedRepresentation.actorId
                        )
        );
    }
}
