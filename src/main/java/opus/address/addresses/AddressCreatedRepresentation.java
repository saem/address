package opus.address.addresses;

import opus.address.people.representations.ContactInformationCreatedRepresentation;
import opus.address.people.representations.ContactType;

public final class AddressCreatedRepresentation implements AddressActionRepresentation, ContactInformationCreatedRepresentation {
    public final String countryCode;
    public final String addressLine;
    public final String administrativeArea;
    public final String locality;
    public final String suite;
    public final String dependentLocality;
    public final String postalCode;
    public final String sortingCode;
    public final String organization;
    public final String recipient;
    public final String languageCode;

    public AddressCreatedRepresentation(
            final String countryCode,
            final String addressLine,
            final String administrativeArea,
            final String locality,
            final String suite,
            final String dependentLocality,
            final String postalCode,
            final String sortingCode,
            final String organization,
            final String recipient,
            final String languageCode
    ) {
        this.countryCode = countryCode;
        this.addressLine = addressLine;
        this.administrativeArea = administrativeArea;
        this.locality = locality;
        this.suite = suite;
        this.dependentLocality = dependentLocality;
        this.postalCode = postalCode;
        this.sortingCode = sortingCode;
        this.organization = organization;
        this.recipient = recipient;
        this.languageCode = languageCode;
    }

    @Override
    public ContactType getType() {
        return () -> AddressCreatedRepresentation.class;
    }
}
