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
public class AddressFactAddressLine extends org.jooq.impl.TableImpl<opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord> {

	private static final long serialVersionUID = 959362767;

	/**
	 * The reference instance of <code>address_fact_address_line</code>
	 */
	public static final opus.address.database.jooq.generated.tables.AddressFactAddressLine AddressFactAddressLine = new opus.address.database.jooq.generated.tables.AddressFactAddressLine();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord> getRecordType() {
		return opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord.class;
	}

	/**
	 * The column <code>address_fact_address_line.sequence</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord, java.lang.Long> Sequence = createField("sequence", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>address_fact_address_line.address_id</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord, java.lang.Long> AddressId = createField("address_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>address_fact_address_line.address_line</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord, java.lang.String> AddressLine = createField("address_line", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * Create a <code>address_fact_address_line</code> table reference
	 */
	public AddressFactAddressLine() {
		this("address_fact_address_line", null);
	}

	/**
	 * Create an aliased <code>address_fact_address_line</code> table reference
	 */
	public AddressFactAddressLine(java.lang.String alias) {
		this(alias, opus.address.database.jooq.generated.tables.AddressFactAddressLine.AddressFactAddressLine);
	}

	private AddressFactAddressLine(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord> aliased) {
		this(alias, aliased, null);
	}

	private AddressFactAddressLine(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord> getPrimaryKey() {
		return opus.address.database.jooq.generated.Keys.PK_ADDRESS_FACT_ADDRESS_LINE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord>>asList(opus.address.database.jooq.generated.Keys.PK_ADDRESS_FACT_ADDRESS_LINE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.AddressFactAddressLineRecord, ?>>asList(opus.address.database.jooq.generated.Keys.ADDRESS_FACT_ADDRESS_LINE__FK_ADDRESS_FACT_ADDRESS_LINE_EVENT, opus.address.database.jooq.generated.Keys.ADDRESS_FACT_ADDRESS_LINE__FK_ADDRESS_FACT_ADDRESS_LINE_ADDRESS);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public opus.address.database.jooq.generated.tables.AddressFactAddressLine as(java.lang.String alias) {
		return new opus.address.database.jooq.generated.tables.AddressFactAddressLine(alias, this);
	}

	/**
	 * Rename this table
	 */
	public opus.address.database.jooq.generated.tables.AddressFactAddressLine rename(java.lang.String name) {
		return new opus.address.database.jooq.generated.tables.AddressFactAddressLine(name, null);
	}
}