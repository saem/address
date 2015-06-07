package opus.address.events.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public final class EventOperationsWriteRepresentation {
    @NotNull
    public final List<EventOperationWriteRepresentation> operations;

    @JsonCreator
    public EventOperationsWriteRepresentation(
            @JsonProperty("operations") final List<EventOperationWriteRepresentation> operations
    ) {
        this.operations = operations;
    }
}
