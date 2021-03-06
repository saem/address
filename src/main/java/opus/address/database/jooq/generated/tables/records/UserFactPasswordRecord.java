/**
 * This class is generated by jOOQ
 */
package opus.address.database.jooq.generated.tables.records;

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
public class UserFactPasswordRecord extends org.jooq.impl.UpdatableRecordImpl<opus.address.database.jooq.generated.tables.records.UserFactPasswordRecord> implements org.jooq.Record3<java.lang.Long, java.lang.Long, java.lang.String> {

	private static final long serialVersionUID = -1803853828;

	/**
	 * Setter for <code>user_fact_password.sequence</code>.
	 */
	public void sequence(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>user_fact_password.sequence</code>.
	 */
	public java.lang.Long sequence() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>user_fact_password.user_id</code>.
	 */
	public void userId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>user_fact_password.user_id</code>.
	 */
	public java.lang.Long userId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>user_fact_password.password</code>.
	 */
	public void password(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>user_fact_password.password</code>.
	 */
	public java.lang.String password() {
		return (java.lang.String) getValue(2);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Long> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Long, java.lang.Long, java.lang.String> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Long, java.lang.Long, java.lang.String> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return opus.address.database.jooq.generated.tables.UserFactPassword.UserFactPassword.Sequence;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return opus.address.database.jooq.generated.tables.UserFactPassword.UserFactPassword.UserId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return opus.address.database.jooq.generated.tables.UserFactPassword.UserFactPassword.Password;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value1() {
		return sequence();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value2() {
		return userId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return password();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserFactPasswordRecord value1(java.lang.Long value) {
		sequence(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserFactPasswordRecord value2(java.lang.Long value) {
		userId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserFactPasswordRecord value3(java.lang.String value) {
		password(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserFactPasswordRecord values(java.lang.Long value1, java.lang.Long value2, java.lang.String value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UserFactPasswordRecord
	 */
	public UserFactPasswordRecord() {
		super(opus.address.database.jooq.generated.tables.UserFactPassword.UserFactPassword);
	}

	/**
	 * Create a detached, initialised UserFactPasswordRecord
	 */
	public UserFactPasswordRecord(java.lang.Long sequence, java.lang.Long userId, java.lang.String password) {
		super(opus.address.database.jooq.generated.tables.UserFactPassword.UserFactPassword);

		setValue(0, sequence);
		setValue(1, userId);
		setValue(2, password);
	}
}
