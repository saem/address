package opus.address.users;

import io.dropwizard.setup.Environment;

public final class Users {
    public static void register(final Environment environment) {
        environment.jersey().register(new UserResource());
    }

    private Users() {}
}
