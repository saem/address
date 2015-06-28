package opus.address.events.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class UpdateEntityEventWriteRepresentation extends EventOperationWriteRepresentation {
    public static final String NAME = "update_entity.1";

    public final long id;
    public final List<EntityTypeEventWriteRepresentation> types;
    public final List<ChildrenEventWriteRepresentation> children;

    @JsonCreator
    public UpdateEntityEventWriteRepresentation(
            @JsonProperty("operation") final String operation,
            @JsonProperty("id") final long id,
            @JsonProperty("types") final List<EntityTypeEventWriteRepresentation> types,
            @JsonProperty("children") final List<ChildrenEventWriteRepresentation> children
    ) {
        super(operation);
        this.id = id;
        this.types = types;
        this.children = children;
    }


    @Override
    public String getName() {
        return NAME;
    }
}
