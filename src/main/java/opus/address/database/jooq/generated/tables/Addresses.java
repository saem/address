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
public class Addresses extends org.jooq.impl.TableImpl<opus.address.database.jooq.generated.tables.records.Addresses> {

	private static final long serialVersionUID = 380636571;

	/**
	 * The reference instance of <code>addresses</code>
	 */
	public static final opus.address.database.jooq.generated.tables.Addresses Addresses = new opus.address.database.jooq.generated.tables.Addresses();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<opus.address.database.jooq.generated.tables.records.Addresses> getRecordType() {
		return opus.address.database.jooq.generated.tables.records.Addresses.class;
	}

	/**
	 * The column <code>addresses.entity_id</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Addresses, java.lang.Long> EntityId = createField("entity_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * Create a <code>addresses</code> table reference
	 */
	public Addresses() {
		this("addresses", null);
	}

	/**
	 * Create an aliased <code>addresses</code> table reference
	 */
	public Addresses(java.lang.String alias) {
		this(alias, opus.address.database.jooq.generated.tables.Addresses.Addresses);
	}

	private Addresses(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.Addresses> aliased) {
		this(alias, aliased, null);
	}

	private Addresses(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.Addresses> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Addresses> getPrimaryKey() {
		return opus.address.database.jooq.generated.Keys.PK_ADDRESSES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Addresses>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Addresses>>asList(opus.address.database.jooq.generated.Keys.PK_ADDRESSES);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Addresses, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Addresses, ?>>asList(opus.address.database.jooq.generated.Keys.ADDRESSES__FK_ADDRESSES_ENTITIES);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public opus.address.database.jooq.generated.tables.Addresses as(java.lang.String alias) {
		return new opus.address.database.jooq.generated.tables.Addresses(alias, this);
	}

	/**
	 * Rename this table
	 */
	public opus.address.database.jooq.generated.tables.Addresses rename(java.lang.String name) {
		return new opus.address.database.jooq.generated.tables.Addresses(name, null);
	}
}
