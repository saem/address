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
public class UserFactUsername extends org.jooq.impl.TableImpl<opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord> {

	private static final long serialVersionUID = -1182615104;

	/**
	 * The reference instance of <code>user_fact_username</code>
	 */
	public static final opus.address.database.jooq.generated.tables.UserFactUsername UserFactUsername = new opus.address.database.jooq.generated.tables.UserFactUsername();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord> getRecordType() {
		return opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord.class;
	}

	/**
	 * The column <code>user_fact_username.sequence</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord, java.lang.Long> Sequence = createField("sequence", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>user_fact_username.user_id</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord, java.lang.Long> UserId = createField("user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>user_fact_username.username</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord, java.lang.String> Username = createField("username", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * Create a <code>user_fact_username</code> table reference
	 */
	public UserFactUsername() {
		this("user_fact_username", null);
	}

	/**
	 * Create an aliased <code>user_fact_username</code> table reference
	 */
	public UserFactUsername(java.lang.String alias) {
		this(alias, opus.address.database.jooq.generated.tables.UserFactUsername.UserFactUsername);
	}

	private UserFactUsername(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord> aliased) {
		this(alias, aliased, null);
	}

	private UserFactUsername(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord> getPrimaryKey() {
		return opus.address.database.jooq.generated.Keys.PK_USER_FACT_USERNAME_SEQUENCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord>>asList(opus.address.database.jooq.generated.Keys.PK_USER_FACT_USERNAME_SEQUENCE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.UserFactUsernameRecord, ?>>asList(opus.address.database.jooq.generated.Keys.USER_FACT_USERNAME__FK_USER_FACT_USERNAME_EVENT, opus.address.database.jooq.generated.Keys.USER_FACT_USERNAME__FK_USER_FACT_USERNAME_USER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public opus.address.database.jooq.generated.tables.UserFactUsername as(java.lang.String alias) {
		return new opus.address.database.jooq.generated.tables.UserFactUsername(alias, this);
	}

	/**
	 * Rename this table
	 */
	public opus.address.database.jooq.generated.tables.UserFactUsername rename(java.lang.String name) {
		return new opus.address.database.jooq.generated.tables.UserFactUsername(name, null);
	}
}
