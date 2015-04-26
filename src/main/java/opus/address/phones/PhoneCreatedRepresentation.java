package opus.address.phones;

import opus.address.people.representations.ContactInformationCreatedRepresentation;
import opus.address.people.representations.ContactType;

public final class PhoneCreatedRepresentation implements PhoneActionRepresentation, ContactInformationCreatedRepresentation {
    public final String number;
    public final String extension;
    public final String type;
    public final boolean doNotCall;

    public PhoneCreatedRepresentation(
            final String number,
            final String extension,
            final String type,
            final boolean doNotCall
    ) {
        this.number = number;
        this.extension = extension;
        this.type = type;
        this.doNotCall = doNotCall;
    }

    @Override
    public ContactType getType() {
        return () -> PhoneCreatedRepresentation.class;
    }
}
