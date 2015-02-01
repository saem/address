package opus.address.users.resources;

import opus.address.database.jooq.generated.tables.records.Events;
import opus.address.users.factories.UserFactory;
import opus.address.users.representations.UserWriteRepresentation;
import opus.address.users.writers.UserWriter;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/users")
public class UserResource {

    public UserResource() {}

    @POST
    @Path("/")
    public Response postUser(
            @Valid UserWriteRepresentation userWriteRepresentation,
            @Context DSLContext database
    ) {
        final Optional<Events>
        database.transaction(c -> {
                    final Events sequenceWhen = UserFactory.buildUserWriter(DSL.using(c))
                            .write(
                                    userWriteRepresentation.email,
                                    userWriteRepresentation.username,
                                    userWriteRepresentation.password,
                                    1L);
                    
                }
        );
        
        return Response.created(UriBuilder.fromPath("0").build())
                .build();
    }
}
