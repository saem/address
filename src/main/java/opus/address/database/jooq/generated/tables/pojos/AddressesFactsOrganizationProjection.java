/**
 * This class is generated by jOOQ
 */
package opus.address.database.jooq.generated.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.1"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AddressesFactsOrganizationProjection implements java.io.Serializable {

	private static final long serialVersionUID = 120714272;

	private final java.lang.Long   sequence;
	private final java.lang.Long   addressId;
	private final java.lang.String organization;

	public AddressesFactsOrganizationProjection(
		java.lang.Long   sequence,
		java.lang.Long   addressId,
		java.lang.String organization
	) {
		this.sequence = sequence;
		this.addressId = addressId;
		this.organization = organization;
	}

	public java.lang.Long sequence() {
		return this.sequence;
	}

	public java.lang.Long addressId() {
		return this.addressId;
	}

	public java.lang.String organization() {
		return this.organization;
	}
}