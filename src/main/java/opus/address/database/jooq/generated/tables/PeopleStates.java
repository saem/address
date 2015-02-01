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
public class PeopleStates extends org.jooq.impl.TableImpl<opus.address.database.jooq.generated.tables.records.PeopleStates> {

	private static final long serialVersionUID = -488348264;

	/**
	 * The reference instance of <code>people_states</code>
	 */
	public static final opus.address.database.jooq.generated.tables.PeopleStates PeopleStates = new opus.address.database.jooq.generated.tables.PeopleStates();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<opus.address.database.jooq.generated.tables.records.PeopleStates> getRecordType() {
		return opus.address.database.jooq.generated.tables.records.PeopleStates.class;
	}

	/**
	 * The column <code>people_states.sequence</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.PeopleStates, java.lang.Long> Sequence = createField("sequence", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>people_states.entity_id</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.PeopleStates, java.lang.Long> EntityId = createField("entity_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>people_states.first_name</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.PeopleStates, java.lang.String> FirstName = createField("first_name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * The column <code>people_states.last_name</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.PeopleStates, java.lang.String> LastName = createField("last_name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * The column <code>people_states.is_deleted</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.PeopleStates, java.lang.Boolean> IsDeleted = createField("is_deleted", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>people_states.primary_email</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.PeopleStates, java.lang.Long> PrimaryEmail = createField("primary_email", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * The column <code>people_states.primary_address</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.PeopleStates, java.lang.Long> PrimaryAddress = createField("primary_address", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * The column <code>people_states.primary_phone</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.PeopleStates, java.lang.Long> PrimaryPhone = createField("primary_phone", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * Create a <code>people_states</code> table reference
	 */
	public PeopleStates() {
		this("people_states", null);
	}

	/**
	 * Create an aliased <code>people_states</code> table reference
	 */
	public PeopleStates(java.lang.String alias) {
		this(alias, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates);
	}

	private PeopleStates(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.PeopleStates> aliased) {
		this(alias, aliased, null);
	}

	private PeopleStates(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.PeopleStates> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.PeopleStates> getPrimaryKey() {
		return opus.address.database.jooq.generated.Keys.PK_PEOPLE_STATES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.PeopleStates>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.PeopleStates>>asList(opus.address.database.jooq.generated.Keys.PK_PEOPLE_STATES);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PeopleStates, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PeopleStates, ?>>asList(opus.address.database.jooq.generated.Keys.PEOPLE_STATES__FK_PEOPLE_STATES_EVENTS, opus.address.database.jooq.generated.Keys.PEOPLE_STATES__FK_PEOPLE_STATES_PEOPLE, opus.address.database.jooq.generated.Keys.PEOPLE_STATES__FK_PEOPLE_STATES_EMAILS, opus.address.database.jooq.generated.Keys.PEOPLE_STATES__FK_PEOPLE_STATES_ADDRESSES, opus.address.database.jooq.generated.Keys.PEOPLE_STATES__FK_PEOPLE_STATES_PHONES);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public opus.address.database.jooq.generated.tables.PeopleStates as(java.lang.String alias) {
		return new opus.address.database.jooq.generated.tables.PeopleStates(alias, this);
	}

	/**
	 * Rename this table
	 */
	public opus.address.database.jooq.generated.tables.PeopleStates rename(java.lang.String name) {
		return new opus.address.database.jooq.generated.tables.PeopleStates(name, null);
	}
}
