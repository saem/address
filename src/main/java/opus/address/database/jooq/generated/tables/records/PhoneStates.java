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
public class PhoneStates extends org.jooq.impl.UpdatableRecordImpl<opus.address.database.jooq.generated.tables.records.PhoneStates> implements org.jooq.Record7<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Boolean> {

	private static final long serialVersionUID = -1530115297;

	/**
	 * Setter for <code>phone_states.sequence</code>.
	 */
	public void sequence(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>phone_states.sequence</code>.
	 */
	public java.lang.Long sequence() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>phone_states.phone_id</code>.
	 */
	public void phoneId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>phone_states.phone_id</code>.
	 */
	public java.lang.Long phoneId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>phone_states.number</code>.
	 */
	public void number(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>phone_states.number</code>.
	 */
	public java.lang.String number() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>phone_states.extension</code>.
	 */
	public void extension(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>phone_states.extension</code>.
	 */
	public java.lang.String extension() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>phone_states.type</code>.
	 */
	public void type(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>phone_states.type</code>.
	 */
	public java.lang.String type() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>phone_states.do_not_call</code>.
	 */
	public void doNotCall(java.lang.Boolean value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>phone_states.do_not_call</code>.
	 */
	public java.lang.Boolean doNotCall() {
		return (java.lang.Boolean) getValue(5);
	}

	/**
	 * Setter for <code>phone_states.is_deleted</code>.
	 */
	public void isDeleted(java.lang.Boolean value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>phone_states.is_deleted</code>.
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
	public org.jooq.Record2<java.lang.Long, java.lang.Long> key() {
		return (org.jooq.Record2) super.key();
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
		return opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates.Sequence;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates.PhoneId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates.Number;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates.Extension;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates.Type;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field6() {
		return opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates.DoNotCall;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field7() {
		return opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates.IsDeleted;
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
		return phoneId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return number();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return extension();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return type();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value6() {
		return doNotCall();
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
	public PhoneStates value1(java.lang.Long value) {
		sequence(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PhoneStates value2(java.lang.Long value) {
		phoneId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PhoneStates value3(java.lang.String value) {
		number(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PhoneStates value4(java.lang.String value) {
		extension(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PhoneStates value5(java.lang.String value) {
		type(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PhoneStates value6(java.lang.Boolean value) {
		doNotCall(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PhoneStates value7(java.lang.Boolean value) {
		isDeleted(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PhoneStates values(java.lang.Long value1, java.lang.Long value2, java.lang.String value3, java.lang.String value4, java.lang.String value5, java.lang.Boolean value6, java.lang.Boolean value7) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached PhoneStates
	 */
	public PhoneStates() {
		super(opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates);
	}

	/**
	 * Create a detached, initialised PhoneStates
	 */
	public PhoneStates(java.lang.Long sequence, java.lang.Long phoneId, java.lang.String number, java.lang.String extension, java.lang.String type, java.lang.Boolean doNotCall, java.lang.Boolean isDeleted) {
		super(opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates);

		setValue(0, sequence);
		setValue(1, phoneId);
		setValue(2, number);
		setValue(3, extension);
		setValue(4, type);
		setValue(5, doNotCall);
		setValue(6, isDeleted);
	}
}
