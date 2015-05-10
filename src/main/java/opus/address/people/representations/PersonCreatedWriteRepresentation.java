package opus.address.people.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class PersonCreatedWriteRepresentation extends PersonEventWriteRepresentation {
    private static final String EVENT_NAME = "person_created";
    public final String firstName;
    public final String lastName;

    public final List<ContactInformationCreatedRepresentation> contactInfo;

    @JsonCreator
    public PersonCreatedWriteRepresentation(
            final @JsonProperty("firstName") String firstName,
            final @JsonProperty("lastName") String lastName,
            final @JsonProperty("actorId") long actorId,
            final @JsonProperty("contactInfo") List<ContactInformationCreatedRepresentation> contactInfo
    ) {
        super(actorId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
    }

    @Override
    public String getName() {
        return EVENT_NAME;
    }
}

