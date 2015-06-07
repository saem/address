package opus.address.events.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import opus.address.events.server.OperationResolver;

@JsonTypeInfo(use = JsonTypeInfo.Id.CUSTOM, include = JsonTypeInfo.As.PROPERTY, property = "@operation", visible = true)
@JsonTypeIdResolver(OperationResolver.class)
public abstract class EventOperationWriteRepresentation {
    public final String operation;

    @JsonCreator
    public EventOperationWriteRepresentation(
            @JsonProperty(value = "@operation") final String operation
    ) {
        this.operation = operation;
    }

    public abstract String getName();
}
