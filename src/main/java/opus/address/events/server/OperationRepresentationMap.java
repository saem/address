package opus.address.events.server;

import opus.address.events.representations.EventOperationWriteRepresentation;

public interface OperationRepresentationMap {
    void register(OperationRepresentationMapping mapper);
    Class<? extends EventOperationWriteRepresentation> toRepresentation(String string);
    EventOperation toEventOperation(EventOperationWriteRepresentation op);
}
