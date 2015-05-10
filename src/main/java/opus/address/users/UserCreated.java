package opus.address.users;

import java.time.Instant;

final class UserCreated implements UserEventLogged {
    public static final String EVENT_NAME = "user_created";

    public final long sequence;
    public final long userId;
    public final Instant instant;

    public UserCreated(long sequence, long userId, final Instant instant) {
        this.sequence = sequence;
        this.userId = userId;
        this.instant = instant;
    }
    
    public long getSequence() { return sequence; }
}
