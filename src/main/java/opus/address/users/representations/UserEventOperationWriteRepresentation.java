package opus.address.users.representations;

import com.fasterxml.jackson.annotation.JsonProperty;
import opus.address.events.representations.EventOperationWriteRepresentation;
import opus.address.events.server.OperationResolver;

public final class UserEventOperationWriteRepresentation extends EventOperationWriteRepresentation {
    public static final String NAME = "user.1";

    public UserEventOperationWriteRepresentation(@JsonProperty(value = "@operation") final String operation) {
        super(operation);
    }

    public String getName() { return NAME; }
}
