package opus.address.users;

import org.jooq.DSLContext;

final class UserFactory {
    private final String codeVersion;

    public UserFactory(final String codeVersion) {
        this.codeVersion = codeVersion;
    }

    public UserWriter buildUserWriter(
            final DSLContext database
    ) {
        return new UserWriter(database, codeVersion);
    }
}
