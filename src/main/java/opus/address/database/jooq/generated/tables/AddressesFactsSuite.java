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
public class AddressesFactsSuite extends org.jooq.impl.TableImpl<opus.address.database.jooq.generated.tables.records.AddressesFactsSuite> {

	private static final long serialVersionUID = 1909581100;

	/**
	 * The reference instance of <code>addresses_facts_suite</code>
	 */
	public static final opus.address.database.jooq.generated.tables.AddressesFactsSuite AddressesFactsSuite = new opus.address.database.jooq.generated.tables.AddressesFactsSuite();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<opus.address.database.jooq.generated.tables.records.AddressesFactsSuite> getRecordType() {
		return opus.address.database.jooq.generated.tables.records.AddressesFactsSuite.class;
	}

	/**
	 * The column <code>addresses_facts_suite.sequence</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.AddressesFactsSuite, java.lang.Long> Sequence = createField("sequence", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>addresses_facts_suite.address_id</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.AddressesFactsSuite, java.lang.Long> AddressId = createField("address_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>addresses_facts_suite.suite</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.AddressesFactsSuite, java.lang.String> Suite = createField("suite", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * Create a <code>addresses_facts_suite</code> table reference
	 */
	public AddressesFactsSuite() {
		this("addresses_facts_suite", null);
	}

	/**
	 * Create an aliased <code>addresses_facts_suite</code> table reference
	 */
	public AddressesFactsSuite(java.lang.String alias) {
		this(alias, opus.address.database.jooq.generated.tables.AddressesFactsSuite.AddressesFactsSuite);
	}

	private AddressesFactsSuite(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.AddressesFactsSuite> aliased) {
		this(alias, aliased, null);
	}

	private AddressesFactsSuite(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.AddressesFactsSuite> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.AddressesFactsSuite> getPrimaryKey() {
		return opus.address.database.jooq.generated.Keys.PK_ADDRESS_FACTS_SUITE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.AddressesFactsSuite>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.AddressesFactsSuite>>asList(opus.address.database.jooq.generated.Keys.PK_ADDRESS_FACTS_SUITE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.AddressesFactsSuite, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.AddressesFactsSuite, ?>>asList(opus.address.database.jooq.generated.Keys.ADDRESSES_FACTS_SUITE__FK_ADDRESSES_FACTS_SUITE_EVENTS, opus.address.database.jooq.generated.Keys.ADDRESSES_FACTS_SUITE__FK_ADDRESSES_FACTS_SUITE_ADDRESSES);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public opus.address.database.jooq.generated.tables.AddressesFactsSuite as(java.lang.String alias) {
		return new opus.address.database.jooq.generated.tables.AddressesFactsSuite(alias, this);
	}

	/**
	 * Rename this table
	 */
	public opus.address.database.jooq.generated.tables.AddressesFactsSuite rename(java.lang.String name) {
		return new opus.address.database.jooq.generated.tables.AddressesFactsSuite(name, null);
	}
}