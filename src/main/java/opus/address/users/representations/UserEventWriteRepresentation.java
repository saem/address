package opus.address.users.representations;

import opus.address.entities.representations.EntityEventWriteRepresentation;

public abstract class UserEventWriteRepresentation extends EntityEventWriteRepresentation {
    public UserEventWriteRepresentation(final long actorId) {
        super(actorId);
    }
}
