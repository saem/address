package opus.address.events.server;

import opus.address.events.representations.EventOperationWriteRepresentation;

public interface OperationRepresentationMapping<
        R extends EventOperationWriteRepresentation,
        O extends EventOperation<R>> {
    String getName();
    Class<R> toRepresentationType();
    O toOperation();
}
