package opus.address.people.representations;

import javax.validation.constraints.NotNull;

public abstract class PersonEventWriteRepresentation {
    @NotNull
    public final long actorId;

    public PersonEventWriteRepresentation(final long actorId) { this.actorId = actorId; }

    public abstract String getName();
}
