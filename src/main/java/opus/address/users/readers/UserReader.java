package opus.address.users.readers;

import org.jooq.DSLContext;

public final class UserReader {
    private final DSLContext database;

    public UserReader(DSLContext database) {
        this.database = database;
    }
}
