package opus.address.events.representations;

import java.time.Instant;
import java.util.List;

public final class EventReadRepresentation {
    public final long sequence;
    public final String event;
    public final String codeVersion;
    public final long actorId;
    public final List<String> tablesAffected;
    public final Instant when;

    public EventReadRepresentation(
            final long sequence, 
            final String event, 
            final String codeVersion,
            final long actorId, 
            final List<String> tablesAffected, 
            final Instant when
    ) {
        this.sequence = sequence;
        this.event = event;
        this.codeVersion = codeVersion;
        this.actorId = actorId;
        this.tablesAffected = tablesAffected;
        this.when = when;
    }
}
