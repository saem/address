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
public class EntityPhoneStatesProjection implements java.io.Serializable {

	private static final long serialVersionUID = -752990357;

	private final java.lang.Long sequence;
	private final java.lang.Long entityId;
	private final java.lang.Long phoneId;

	public EntityPhoneStatesProjection(
		java.lang.Long sequence,
		java.lang.Long entityId,
		java.lang.Long phoneId
	) {
		this.sequence = sequence;
		this.entityId = entityId;
		this.phoneId = phoneId;
	}

	public java.lang.Long sequence() {
		return this.sequence;
	}

	public java.lang.Long entityId() {
		return this.entityId;
	}

	public java.lang.Long phoneId() {
		return this.phoneId;
	}
}
