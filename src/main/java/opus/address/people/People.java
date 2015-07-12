package opus.address.people;

import io.dropwizard.setup.Environment;

public final class People {
    public static void register(final Environment environment) {
        environment.jersey().register(new PersonResource());
    }

    private People() {}
}
