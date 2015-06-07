package opus.address.people.representations;

import com.fasterxml.jackson.annotation.JsonProperty;
import opus.address.events.representations.EventOperationWriteRepresentation;
import opus.address.events.server.OperationResolver;

public final class PersonEventOperationWriteRepresentation extends EventOperationWriteRepresentation {
    public static final String NAME = "person.1";

    static { OperationResolver.idMap.put(NAME, PersonEventOperationWriteRepresentation.class); }

    public PersonEventOperationWriteRepresentation(@JsonProperty(value = "@operation") final String operation) {
        super(operation);
    }

    public String getName() { return NAME; }
}
