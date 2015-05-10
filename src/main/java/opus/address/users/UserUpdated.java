package opus.address.users;

import java.time.Instant;

final class UserUpdated implements UserEventLogged {
    public static final String EVENT_NAME = "user_updated";

    public final Long sequence;
    public final Long userId;
    public final Instant instant;

    public UserUpdated(final Long sequence, final Long userId, final Instant instant) {

        this.sequence = sequence;
        this.userId = userId;
        this.instant = instant;
    }

    public long getSequence() { return sequence; }
}
