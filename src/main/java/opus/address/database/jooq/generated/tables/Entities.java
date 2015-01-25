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
		"jOOQ version:3.5.0"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Entities extends org.jooq.impl.TableImpl<opus.address.database.jooq.generated.tables.records.Entities> {

	private static final long serialVersionUID = -1418717084;

	/**
	 * The reference instance of <code>entities</code>
	 */
	public static final opus.address.database.jooq.generated.tables.Entities Entities = new opus.address.database.jooq.generated.tables.Entities();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<opus.address.database.jooq.generated.tables.records.Entities> getRecordType() {
		return opus.address.database.jooq.generated.tables.records.Entities.class;
	}

	/**
	 * The column <code>entities.entity_id</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Entities, java.lang.Long> EntityId = createField("entity_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>entities.entity_type</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Entities, opus.address.database.jooq.generated.enums.EntityTypeEnum> EntityType = createField("entity_type", org.jooq.util.postgres.PostgresDataType.VARCHAR.asEnumDataType(opus.address.database.jooq.generated.enums.EntityTypeEnum.class), this, "");

	/**
	 * Create a <code>entities</code> table reference
	 */
	public Entities() {
		this("entities", null);
	}

	/**
	 * Create an aliased <code>entities</code> table reference
	 */
	public Entities(java.lang.String alias) {
		this(alias, opus.address.database.jooq.generated.tables.Entities.Entities);
	}

	private Entities(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.Entities> aliased) {
		this(alias, aliased, null);
	}

	private Entities(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.Entities> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<opus.address.database.jooq.generated.tables.records.Entities, java.lang.Long> getIdentity() {
		return opus.address.database.jooq.generated.Keys.IDENTITY_Entities;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Entities> getPrimaryKey() {
		return opus.address.database.jooq.generated.Keys.PK_ENTITIES_ENTITY_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Entities>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Entities>>asList(opus.address.database.jooq.generated.Keys.PK_ENTITIES_ENTITY_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public opus.address.database.jooq.generated.tables.Entities as(java.lang.String alias) {
		return new opus.address.database.jooq.generated.tables.Entities(alias, this);
	}

	/**
	 * Rename this table
	 */
	public opus.address.database.jooq.generated.tables.Entities rename(java.lang.String name) {
		return new opus.address.database.jooq.generated.tables.Entities(name, null);
	}
}
