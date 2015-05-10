package opus.address.people.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public final class PersonUpdatedWriteRepresentation extends PersonEventWriteRepresentation {
    private static final String EVENT_NAME = "person_updated";
    @NotNull
    public final long personId;
    public final String firstName;
    public final String lastName;

    @JsonCreator
    public PersonUpdatedWriteRepresentation(
            final @JsonProperty("personId") long personId,
            final @JsonProperty("firstName") String firstName,
            final @JsonProperty("lastName") String lastName,
            final @JsonProperty("actorId") long actorId) {
        super(actorId);
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getName() {
        return EVENT_NAME;
    }
}
