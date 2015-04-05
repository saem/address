package opus.address.people.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public final class PersonDeletedRepresentation {
    @NotNull
    public final long personId;
    @NotNull
    public final long actorId;

    @JsonCreator
    public PersonDeletedRepresentation(
            final @JsonProperty("personId") long personId,
            final @JsonProperty("actorId") long actorId
    ) {
        this.personId = personId;
        this.actorId = actorId;
    }
}
