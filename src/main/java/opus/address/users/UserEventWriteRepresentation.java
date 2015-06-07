package opus.address.users;

import opus.address.entities.representations.EntityEventWriteRepresentation;

public abstract class UserEventWriteRepresentation extends EntityEventWriteRepresentation {
    public UserEventWriteRepresentation(final long actorId) {
        super(actorId);
    }
}
