package opus.address.emails;

import opus.address.people.representations.ContactInformationCreatedRepresentation;
import opus.address.people.representations.ContactType;

public final class EmailCreatedRepresentation implements EmailActionRepresentation, ContactInformationCreatedRepresentation{
    public final boolean opted;
    public final String localPart;
    public final String domain;

    public EmailCreatedRepresentation(
            final boolean opted, 
            final String localPart, 
            final String domain
    ) {
        this.opted = opted;
        this.localPart = localPart;
        this.domain = domain;
    }

    @Override
    public ContactType getType() {
        return () -> EmailCreatedRepresentation.class;
    }
}
