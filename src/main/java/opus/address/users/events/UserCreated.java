package opus.address.users.events;

import opus.address.commons.Event;

import java.time.Instant;

public final class UserCreated implements Event {
    public static final String EVENT_NAME = "user_created";

    public final long sequence;
    public final long userId;
    public final Instant instant;

    public UserCreated(long sequence, long userId, final Instant instant) {
        this.sequence = sequence;
        this.userId = userId;
        this.instant = instant;
    }
}
