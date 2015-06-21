package opus.address.users;

import opus.address.events.server.EventOperation;
import opus.address.events.server.OperationRepresentationMapping;
import opus.address.users.representations.UserEventOperationWriteRepresentation;

public final class UserOperationRepresentationMapping implements OperationRepresentationMapping<
        UserEventOperationWriteRepresentation,
        UserEventOperation
        > {
    @Override
    public String getName() {
        return UserEventOperationWriteRepresentation.NAME;
    }

    @Override
    public Class<UserEventOperationWriteRepresentation> toRepresentationType() {
        return UserEventOperationWriteRepresentation.class;
    }

    @Override
    public UserEventOperation toOperation() {
        return new UserEventOperation();
    }
}

class UserEventOperation implements EventOperation<UserEventOperationWriteRepresentation> {}