package opus.address.entities.representations;

import javax.validation.constraints.NotNull;

public abstract class EntityEventWriteRepresentation {
    @NotNull
    public final long actorId;

    public EntityEventWriteRepresentation(final long actorId) {
        this.actorId = actorId;
    }

    public abstract String getName();
}
