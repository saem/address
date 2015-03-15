package opus.address.users;

import org.jooq.DSLContext;

public final class UserFactory {
    private final String codeVersion;

    public UserFactory(String codeVersion) {
        this.codeVersion = codeVersion;
    }

    public UserWriter buildUserWriter(
            DSLContext database
    ) {
        return new UserWriter(database, codeVersion);
    }
}
