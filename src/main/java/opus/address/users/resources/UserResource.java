package opus.address.users.resources;

import io.dropwizard.jersey.params.IntParam;
import io.dropwizard.jersey.params.LongParam;
import opus.address.users.events.UserCreated;
import opus.address.users.events.UserUpdated;
import opus.address.users.factories.UserFactory;
import opus.address.users.representations.UserFactReadRepresentation;
import opus.address.users.representations.UserWriteRepresentation;
import org.jooq.DSLContext;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/users")
public final class UserResource {

    private final UserFactory userFactory;

    public UserResource(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUser(
            @Valid UserWriteRepresentation userWriteRepresentation,
            @Context DSLContext database
    ) {
//        final Optional<UserCreated> userCreated = userFactory.buildUserWriter(database)
//                .write(
//                        userWriteRepresentation.email,
//                        userWriteRepresentation.username,
//                        userWriteRepresentation.password,
//                        userWriteRepresentation.isDisabled,
//                        userWriteRepresentation.actorId);
//
//        return userCreated
//                .map(u ->
//                        Response.created(
//                                UriBuilder
//                                        .fromPath("/events/{sequenceId}/users/{userId}")
//                                        .build(u.sequence, u.userId))
//                                .build())
//                .orElseGet(() -> Response.serverError().build());
        
        return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public List<UserFactReadRepresentation> getUserHistory(
            @Context DSLContext database,
            @PathParam("userId") LongParam userId,
            @QueryParam("numberOfRecords") @DefaultValue("10") IntParam numberOfRecords,
            @QueryParam("offset") @DefaultValue("0") IntParam offset
    ){
        return UserFactory.buildUserReader(database).getUserHistory(userId.get(), numberOfRecords.get(), offset.get())
                .stream()
                .map(u -> new UserFactReadRepresentation(
                        u.sequence, 
                        u.userId, 
                        u.username, 
                        u.email, 
                        u.isDeleted, 
                        u.isDisabled, 
                        u.actorId)
                )
                .collect(Collectors.toList());
    } 
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{userId}")
    public Response putUser(
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
