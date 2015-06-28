package opus.address.people;

import io.dropwizard.setup.Environment;
import opus.address.events.server.OperationResolver;

public final class People {
    public static void register(final Environment environment) {
        OperationResolver.idMap.register(new PersonOperationRepresentationMapping());
        environment.jersey().register(new PersonResource());
    }

    private People() {}
}
