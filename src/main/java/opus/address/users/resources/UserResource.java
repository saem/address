package opus.address.users.resources;

import opus.address.users.representations.UserWriteRepresentation;
import org.jooq.DSLContext;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/users")
public class UserResource {

    public UserResource() {
    }

    @POST
    @Path("/")
    public Response postUser(
            @Valid UserWriteRepresentation userWriteRepresentation,
            @Context DSLContext database
    ) {
//        pub


        return Response.created(UriBuilder.fromPath("0").build())
                .build();
    }
}
