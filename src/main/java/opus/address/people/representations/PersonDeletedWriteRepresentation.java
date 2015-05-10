package opus.address.people.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public final class PersonDeletedWriteRepresentation extends PersonEventWriteRepresentation {
    private static final String EVENT_NAME = "person_deleted";
    @NotNull
    public final long personId;

    @JsonCreator
    public PersonDeletedWriteRepresentation(
            final @JsonProperty("personId") long personId,
            final @JsonProperty("actorId") long actorId
    ) {
        super(actorId);
        this.personId = personId;
    }

    @Override
    public String getName() {
        return EVENT_NAME;
    }
}
