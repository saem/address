package opus.address.users;

import java.time.Instant;

final class UserDeleted implements UserEventLogged {
    public static final String EVENT_NAME = "user_deleted";

    public final Long sequence;
    public final Long userId;
    public final Instant instant;

    public UserDeleted(final Long sequence, final Long userId, final Instant instant) {
        this.sequence = sequence;
        this.userId = userId;
        this.instant = instant;
    }

    @Override
    public long getSequence() { return sequence; }
}