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
public class EmailFactOptedEnumProjection implements java.io.Serializable {

	private static final long serialVersionUID = 1438960892;

	private final java.lang.Long                                       sequence;
	private final java.lang.Long                                       emailId;
	private final opus.address.database.jooq.generated.enums.OptedEnum opted;

	public EmailFactOptedEnumProjection(
		java.lang.Long                                       sequence,
		java.lang.Long                                       emailId,
		opus.address.database.jooq.generated.enums.OptedEnum opted
	) {
		this.sequence = sequence;
		this.emailId = emailId;
		this.opted = opted;
	}

	public java.lang.Long sequence() {
		return this.sequence;
	}

	public java.lang.Long emailId() {
		return this.emailId;
	}

	public opus.address.database.jooq.generated.enums.OptedEnum opted() {
		return this.opted;
	}
}
