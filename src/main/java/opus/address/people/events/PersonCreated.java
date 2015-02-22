package opus.address.people.events;

import opus.address.commons.Event;

import java.time.Instant;

public final class PersonCreated implements Event {
    public static final String EVENT_NAME = "person_created";

    public final long sequence;
    public final long personId;
    public final Instant instant;

    public PersonCreated(long sequence, long personId, final Instant instant) {
        this.sequence = sequence;
        this.personId = personId;
        this.instant = instant;
    }
}