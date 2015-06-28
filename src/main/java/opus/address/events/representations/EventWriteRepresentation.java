package opus.address.events.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public final class EventWriteRepresentation {
    @NotNull
    public final String event;

    @NotNull
    public final EventMetaDataWriteRepresentation metadata;

    @NotNull
    public final List<EventOperationWriteRepresentation> operations;

    @JsonCreator
    public EventWriteRepresentation(
            final @JsonProperty("event") String event,
            final @JsonProperty("metadata") EventMetaDataWriteRepresentation metadata,
            final @JsonProperty("operations") List<EventOperationWriteRepresentation> operations
    ) {
        this.event = event;
        this.metadata = metadata;
        this.operations = operations;
    }
}
