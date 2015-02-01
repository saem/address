package opus.address.users.factories;

import opus.address.security.PasswordDigester;
import opus.address.users.readers.UserReader;
import opus.address.users.writers.UserWriter;
import org.jooq.DSLContext;

public final class UserFactory {
    public static UserReader buildUserReader(
            DSLContext database
    ) {
        return new UserReader(database);
    }

    public static UserWriter buildUserWriter(
            DSLContext database
    ) {
        return new UserWriter(database, new PasswordDigester());
    }
}
