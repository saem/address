package opus.address.people.representations;

import opus.address.entities.representations.EntityEventWriteRepresentation;

public abstract class PersonEventWriteRepresentation extends EntityEventWriteRepresentation {
    public PersonEventWriteRepresentation(final long actorId) {
        super(actorId);
    }
}
