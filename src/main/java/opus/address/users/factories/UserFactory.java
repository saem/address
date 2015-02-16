package opus.address.users.factories;

import opus.address.security.PasswordDigester;
import opus.address.users.readers.UserReader;
import opus.address.users.writers.UserWriter;
import org.jooq.DSLContext;

public final class UserFactory {
    private final String codeVersion;

    public UserFactory(String codeVersion) {
        this.codeVersion = codeVersion;
    }
    
    public static UserReader buildUserReader(
            DSLContext database
    ) {
        return new UserReader(database);
    }

    public UserWriter buildUserWriter(
            DSLContext database
    ) {
        return new UserWriter(database, new PasswordDigester(), codeVersion);
    }
}
