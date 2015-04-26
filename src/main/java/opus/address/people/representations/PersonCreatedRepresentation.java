package opus.address.people.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

public final class PersonCreatedRepresentation {
    public final String firstName;
    public final String lastName;
    @NotNull
    public final long actorId;
    public final List<ContactInformationCreatedRepresentation> contactInfo;

    @JsonCreator
    public PersonCreatedRepresentation(
            final @JsonProperty("firstName") String firstName,
            final @JsonProperty("lastName") String lastName,
            final @JsonProperty("actorId") long actorId,
            final @JsonProperty("contactInfo") List<ContactInformationCreatedRepresentation> contactInfo
    ) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
    }
}

