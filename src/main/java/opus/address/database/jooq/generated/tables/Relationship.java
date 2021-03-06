/**
 * This class is generated by jOOQ
 */
package opus.address.database.jooq.generated.tables;

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
public class Relationship extends org.jooq.impl.TableImpl<opus.address.database.jooq.generated.tables.records.RelationshipRecord> {

	private static final long serialVersionUID = 316158960;

	/**
	 * The reference instance of <code>relationship</code>
	 */
	public static final opus.address.database.jooq.generated.tables.Relationship Relationship = new opus.address.database.jooq.generated.tables.Relationship();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<opus.address.database.jooq.generated.tables.records.RelationshipRecord> getRecordType() {
		return opus.address.database.jooq.generated.tables.records.RelationshipRecord.class;
	}

	/**
	 * The column <code>relationship.relationship_id</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.RelationshipRecord, java.lang.Long> RelationshipId = createField("relationship_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>relationship.entity_id_min</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.RelationshipRecord, java.lang.Long> EntityIdMin = createField("entity_id_min", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>relationship.entity_id_max</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.RelationshipRecord, java.lang.Long> EntityIdMax = createField("entity_id_max", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * Create a <code>relationship</code> table reference
	 */
	public Relationship() {
		this("relationship", null);
	}

	/**
	 * Create an aliased <code>relationship</code> table reference
	 */
	public Relationship(java.lang.String alias) {
		this(alias, opus.address.database.jooq.generated.tables.Relationship.Relationship);
	}

	private Relationship(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.RelationshipRecord> aliased) {
		this(alias, aliased, null);
	}

	private Relationship(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.RelationshipRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.RelationshipRecord> getPrimaryKey() {
		return opus.address.database.jooq.generated.Keys.PK_RELATIONSHIP_RELATIONSHIP_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.RelationshipRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.RelationshipRecord>>asList(opus.address.database.jooq.generated.Keys.PK_RELATIONSHIP_RELATIONSHIP_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.RelationshipRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.RelationshipRecord, ?>>asList(opus.address.database.jooq.generated.Keys.RELATIONSHIP__FK_ENTITY_ENTITY, opus.address.database.jooq.generated.Keys.RELATIONSHIP__FK_RELATIONSHIP_ENTITY_MIN, opus.address.database.jooq.generated.Keys.RELATIONSHIP__FK_RELATIONSHIP_ENTITY_MAX);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public opus.address.database.jooq.generated.tables.Relationship as(java.lang.String alias) {
		return new opus.address.database.jooq.generated.tables.Relationship(alias, this);
	}

	/**
	 * Rename this table
	 */
	public opus.address.database.jooq.generated.tables.Relationship rename(java.lang.String name) {
		return new opus.address.database.jooq.generated.tables.Relationship(name, null);
	}
}
