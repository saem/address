package opus.address.events.server;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;

public final class EventReadRepresentation {
    // @todo do smart things with constants
    @JsonProperty("@context")
    public final static String context = "http://pglocal/contexts/event.jsonld";
    public final long sequence;
    public final String event;
    public final int eventVersion;
    public final String codeVersion;
    public final long actorId;
    public final List<String> tablesAffected;
    public final ZonedDateTime when;
    public final ActorType actorType; 

    public EventReadRepresentation(
            final long sequence, 
            final String event, 
            final int eventVersion, 
            final String codeVersion, 
            final long actorId, 
            final List<String> tablesAffected, 
            final ZonedDateTime when,
            final ActorType actorType
    ) {
        this.sequence = sequence;
        this.event = event;
        this.eventVersion = eventVersion;
        this.codeVersion = codeVersion;
        this.actorId = actorId;
        this.tablesAffected = tablesAffected;
        this.when = when;
        this.actorType = actorType;
    }

    @JsonProperty("@id")
    public String getId() {
        return "/events/" + sequence;
    }
}
