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
public class AddressFactLanguageCode extends org.jooq.impl.TableImpl<opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord> {

	private static final long serialVersionUID = -185332333;

	/**
	 * The reference instance of <code>address_fact_language_code</code>
	 */
	public static final opus.address.database.jooq.generated.tables.AddressFactLanguageCode AddressFactLanguageCode = new opus.address.database.jooq.generated.tables.AddressFactLanguageCode();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord> getRecordType() {
		return opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord.class;
	}

	/**
	 * The column <code>address_fact_language_code.sequence</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord, java.lang.Long> Sequence = createField("sequence", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>address_fact_language_code.address_id</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord, java.lang.Long> AddressId = createField("address_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>address_fact_language_code.language_code</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord, java.lang.String> LanguageCode = createField("language_code", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * Create a <code>address_fact_language_code</code> table reference
	 */
	public AddressFactLanguageCode() {
		this("address_fact_language_code", null);
	}

	/**
	 * Create an aliased <code>address_fact_language_code</code> table reference
	 */
	public AddressFactLanguageCode(java.lang.String alias) {
		this(alias, opus.address.database.jooq.generated.tables.AddressFactLanguageCode.AddressFactLanguageCode);
	}

	private AddressFactLanguageCode(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord> aliased) {
		this(alias, aliased, null);
	}

	private AddressFactLanguageCode(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord> getPrimaryKey() {
		return opus.address.database.jooq.generated.Keys.PK_ADDRESS_FACT_LANGUAGE_CODE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord>>asList(opus.address.database.jooq.generated.Keys.PK_ADDRESS_FACT_LANGUAGE_CODE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.AddressFactLanguageCodeRecord, ?>>asList(opus.address.database.jooq.generated.Keys.ADDRESS_FACT_LANGUAGE_CODE__FK_ADDRESS_FACT_LANGUAGE_CODE_EVENT, opus.address.database.jooq.generated.Keys.ADDRESS_FACT_LANGUAGE_CODE__FK_ADDRESS_FACT_LANGUAGE_CODE_ADDRESS);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public opus.address.database.jooq.generated.tables.AddressFactLanguageCode as(java.lang.String alias) {
		return new opus.address.database.jooq.generated.tables.AddressFactLanguageCode(alias, this);
	}

	/**
	 * Rename this table
	 */
	public opus.address.database.jooq.generated.tables.AddressFactLanguageCode rename(java.lang.String name) {
		return new opus.address.database.jooq.generated.tables.AddressFactLanguageCode(name, null);
	}
}