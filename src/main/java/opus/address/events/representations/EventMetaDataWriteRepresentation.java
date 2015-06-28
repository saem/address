package opus.address.events.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class EventMetaDataWriteRepresentation {
    public final long actorId;

    @JsonCreator
    public EventMetaDataWriteRepresentation(
            @JsonProperty final long actorId
    ) {
        this.actorId = actorId;
    }
}
