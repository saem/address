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
public class EntityAddressStates extends org.jooq.impl.TableImpl<opus.address.database.jooq.generated.tables.records.EntityAddressStates> {

	private static final long serialVersionUID = 2043431583;

	/**
	 * The reference instance of <code>entity_address_states</code>
	 */
	public static final opus.address.database.jooq.generated.tables.EntityAddressStates EntityAddressStates = new opus.address.database.jooq.generated.tables.EntityAddressStates();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<opus.address.database.jooq.generated.tables.records.EntityAddressStates> getRecordType() {
		return opus.address.database.jooq.generated.tables.records.EntityAddressStates.class;
	}

	/**
	 * The column <code>entity_address_states.sequence</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.EntityAddressStates, java.lang.Long> Sequence = createField("sequence", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>entity_address_states.entity_id</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.EntityAddressStates, java.lang.Long> EntityId = createField("entity_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>entity_address_states.address_id</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.EntityAddressStates, java.lang.Long> AddressId = createField("address_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * Create a <code>entity_address_states</code> table reference
	 */
	public EntityAddressStates() {
		this("entity_address_states", null);
	}

	/**
	 * Create an aliased <code>entity_address_states</code> table reference
	 */
	public EntityAddressStates(java.lang.String alias) {
		this(alias, opus.address.database.jooq.generated.tables.EntityAddressStates.EntityAddressStates);
	}

	private EntityAddressStates(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.EntityAddressStates> aliased) {
		this(alias, aliased, null);
	}

	private EntityAddressStates(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.EntityAddressStates> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates> getPrimaryKey() {
		return opus.address.database.jooq.generated.Keys.PK_ENTITY_ADDRESS_STATES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates>>asList(opus.address.database.jooq.generated.Keys.PK_ENTITY_ADDRESS_STATES);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates, ?>>asList(opus.address.database.jooq.generated.Keys.ENTITY_ADDRESS_STATES__FK_ENTITY_ADDRESS_STATES_EVENTS, opus.address.database.jooq.generated.Keys.ENTITY_ADDRESS_STATES__FK_ENTITY_ADDRESS_STATES_ENTITIES, opus.address.database.jooq.generated.Keys.ENTITY_ADDRESS_STATES__FK_ENTITY_ADDRESS_STATES_ADDRESS_ENTITIES);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public opus.address.database.jooq.generated.tables.EntityAddressStates as(java.lang.String alias) {
		return new opus.address.database.jooq.generated.tables.EntityAddressStates(alias, this);
	}

	/**
	 * Rename this table
	 */
	public opus.address.database.jooq.generated.tables.EntityAddressStates rename(java.lang.String name) {
		return new opus.address.database.jooq.generated.tables.EntityAddressStates(name, null);
	}
}
