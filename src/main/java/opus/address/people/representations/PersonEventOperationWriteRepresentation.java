package opus.address.people.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import opus.address.events.representations.EventOperationWriteRepresentation;
import opus.address.events.server.OperationResolver;

public final class PersonEventOperationWriteRepresentation extends EventOperationWriteRepresentation {
    public static final String NAME = "person.1";

    @JsonCreator
    public PersonEventOperationWriteRepresentation(
            @JsonProperty(value = "@operation") final String operation
    ) {
        super(operation);
    }

    public String getName() { return NAME; }
}
