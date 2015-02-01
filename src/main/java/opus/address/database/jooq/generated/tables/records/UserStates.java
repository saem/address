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
public class UserStates extends org.jooq.impl.UpdatableRecordImpl<opus.address.database.jooq.generated.tables.records.UserStates> implements org.jooq.Record7<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean> {

	private static final long serialVersionUID = 1776380983;

	/**
	 * Setter for <code>user_states.sequence</code>.
	 */
	public void sequence(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>user_states.sequence</code>.
	 */
	public java.lang.Long sequence() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>user_states.user_id</code>.
	 */
	public void userId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>user_states.user_id</code>.
	 */
	public java.lang.Long userId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>user_states.username</code>.
	 */
	public void username(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>user_states.username</code>.
	 */
	public java.lang.String username() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>user_states.email</code>.
	 */
	public void email(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>user_states.email</code>.
	 */
	public java.lang.String email() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>user_states.password</code>.
	 */
	public void password(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>user_states.password</code>.
	 */
	public java.lang.String password() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>user_states.is_disabled</code>.
	 */
	public void isDisabled(java.lang.Boolean value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>user_states.is_disabled</code>.
	 */
	public java.lang.Boolean isDisabled() {
		return (java.lang.Boolean) getValue(5);
	}

	/**
	 * Setter for <code>user_states.is_deleted</code>.
	 */
	public void isDeleted(java.lang.Boolean value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>user_states.is_deleted</code>.
	 */
	public java.lang.Boolean isDeleted() {
		return (java.lang.Boolean) getValue(6);
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
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean> fieldsRow() {
		return (org.jooq.Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row7<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean> valuesRow() {
		return (org.jooq.Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return opus.address.database.jooq.generated.tables.UserStates.UserStates.Sequence;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return opus.address.database.jooq.generated.tables.UserStates.UserStates.UserId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return opus.address.database.jooq.generated.tables.UserStates.UserStates.Username;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return opus.address.database.jooq.generated.tables.UserStates.UserStates.Email;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return opus.address.database.jooq.generated.tables.UserStates.UserStates.Password;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field6() {
		return opus.address.database.jooq.generated.tables.UserStates.UserStates.IsDisabled;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field7() {
		return opus.address.database.jooq.generated.tables.UserStates.UserStates.IsDeleted;
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
		return username();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return email();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return password();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value6() {
		return isDisabled();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value7() {
		return isDeleted();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserStates value1(java.lang.Long value) {
		sequence(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserStates value2(java.lang.Long value) {
		userId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserStates value3(java.lang.String value) {
		username(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserStates value4(java.lang.String value) {
		email(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserStates value5(java.lang.String value) {
		password(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserStates value6(java.lang.Boolean value) {
		isDisabled(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserStates value7(java.lang.Boolean value) {
		isDeleted(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserStates values(java.lang.Long value1, java.lang.Long value2, java.lang.String value3, java.lang.String value4, java.lang.String value5, java.lang.Boolean value6, java.lang.Boolean value7) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UserStates
	 */
	public UserStates() {
		super(opus.address.database.jooq.generated.tables.UserStates.UserStates);
	}

	/**
	 * Create a detached, initialised UserStates
	 */
	public UserStates(java.lang.Long sequence, java.lang.Long userId, java.lang.String username, java.lang.String email, java.lang.String password, java.lang.Boolean isDisabled, java.lang.Boolean isDeleted) {
		super(opus.address.database.jooq.generated.tables.UserStates.UserStates);

		setValue(0, sequence);
		setValue(1, userId);
		setValue(2, username);
		setValue(3, email);
		setValue(4, password);
		setValue(5, isDisabled);
		setValue(6, isDeleted);
	}
}
