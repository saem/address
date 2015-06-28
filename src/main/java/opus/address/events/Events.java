package opus.address.events;

import io.dropwizard.setup.Environment;
import opus.address.events.server.EventResource;

public final class Events {
    public static void register(final Environment environment) {
        environment.jersey().register(new EventResource());
    }

    private Events() {}
}
