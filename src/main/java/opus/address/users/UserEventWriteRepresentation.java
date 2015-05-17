package opus.address.users;

import javax.validation.constraints.NotNull;

public abstract class UserEventWriteRepresentation {
    @NotNull
    public final long actorId;

    public UserEventWriteRepresentation(final long actorId) { this.actorId = actorId; }

    public abstract String getName();
}
