package opus.address.people;

import opus.address.events.server.EventOperation;
import opus.address.events.server.OperationRepresentationMapping;
import opus.address.people.representations.PersonEventOperationWriteRepresentation;

public final class PersonOperationRepresentationMapping implements OperationRepresentationMapping<
        PersonEventOperationWriteRepresentation,
        PersonEventOperation> {
    @Override
    public String getName() {
        return PersonEventOperationWriteRepresentation.NAME;
    }

    @Override
    public Class<PersonEventOperationWriteRepresentation> toRepresentationType() {
        return PersonEventOperationWriteRepresentation.class;
    }

    @Override
    public PersonEventOperation toOperation() {
        return new PersonEventOperation();
    }
}

class PersonEventOperation implements EventOperation<PersonEventOperationWriteRepresentation> {}