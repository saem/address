package opus.address.users;

import io.dropwizard.setup.Environment;
import opus.address.events.server.OperationResolver;

public final class Users {
    public static void register(final Environment environment) {
        environment.jersey().register(new UserResource());
        OperationResolver.idMap.register(new UserOperationRepresentationMapping());
    }

    private Users() {}
}
