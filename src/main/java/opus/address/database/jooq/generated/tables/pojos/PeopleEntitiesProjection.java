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
		"jOOQ version:3.5.0"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PeopleEntitiesProjection implements java.io.Serializable {

	private static final long serialVersionUID = 653629506;

	private final java.lang.Long                                            entityId;
	private final opus.address.database.jooq.generated.enums.EntityTypeEnum entityType;

	public PeopleEntitiesProjection(
		java.lang.Long                                            entityId,
		opus.address.database.jooq.generated.enums.EntityTypeEnum entityType
	) {
		this.entityId = entityId;
		this.entityType = entityType;
	}

	public java.lang.Long entityId() {
		return this.entityId;
	}

	public opus.address.database.jooq.generated.enums.EntityTypeEnum entityType() {
		return this.entityType;
	}
}
