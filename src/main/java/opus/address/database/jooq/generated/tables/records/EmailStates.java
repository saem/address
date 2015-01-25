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
		"jOOQ version:3.5.0"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EmailStates extends org.jooq.impl.UpdatableRecordImpl<opus.address.database.jooq.generated.tables.records.EmailStates> implements org.jooq.Record6<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, opus.address.database.jooq.generated.enums.OptedEnum, java.lang.Boolean> {

	private static final long serialVersionUID = -1866503606;

	/**
	 * Setter for <code>email_states.sequence</code>.
	 */
	public void sequence(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>email_states.sequence</code>.
	 */
	public java.lang.Long sequence() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>email_states.email_id</code>.
	 */
	public void emailId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>email_states.email_id</code>.
	 */
	public java.lang.Long emailId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>email_states.local_part</code>.
	 */
	public void localPart(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>email_states.local_part</code>.
	 */
	public java.lang.String localPart() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>email_states.domain</code>.
	 */
	public void domain(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>email_states.domain</code>.
	 */
	public java.lang.String domain() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>email_states.opted</code>.
	 */
	public void opted(opus.address.database.jooq.generated.enums.OptedEnum value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>email_states.opted</code>.
	 */
	public opus.address.database.jooq.generated.enums.OptedEnum opted() {
		return (opus.address.database.jooq.generated.enums.OptedEnum) getValue(4);
	}

	/**
	 * Setter for <code>email_states.is_deleted</code>.
	 */
	public void isDeleted(java.lang.Boolean value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>email_states.is_deleted</code>.
	 */
	public java.lang.Boolean isDeleted() {
		return (java.lang.Boolean) getValue(5);
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
	// Record6 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row6<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, opus.address.database.jooq.generated.enums.OptedEnum, java.lang.Boolean> fieldsRow() {
		return (org.jooq.Row6) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row6<java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, opus.address.database.jooq.generated.enums.OptedEnum, java.lang.Boolean> valuesRow() {
		return (org.jooq.Row6) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return opus.address.database.jooq.generated.tables.EmailStates.EmailStates.Sequence;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return opus.address.database.jooq.generated.tables.EmailStates.EmailStates.EmailId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return opus.address.database.jooq.generated.tables.EmailStates.EmailStates.LocalPart;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return opus.address.database.jooq.generated.tables.EmailStates.EmailStates.Domain;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<opus.address.database.jooq.generated.enums.OptedEnum> field5() {
		return opus.address.database.jooq.generated.tables.EmailStates.EmailStates.Opted;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field6() {
		return opus.address.database.jooq.generated.tables.EmailStates.EmailStates.IsDeleted;
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
		return emailId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value3() {
		return localPart();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return domain();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public opus.address.database.jooq.generated.enums.OptedEnum value5() {
		return opted();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value6() {
		return isDeleted();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmailStates value1(java.lang.Long value) {
		sequence(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmailStates value2(java.lang.Long value) {
		emailId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmailStates value3(java.lang.String value) {
		localPart(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmailStates value4(java.lang.String value) {
		domain(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmailStates value5(opus.address.database.jooq.generated.enums.OptedEnum value) {
		opted(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmailStates value6(java.lang.Boolean value) {
		isDeleted(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmailStates values(java.lang.Long value1, java.lang.Long value2, java.lang.String value3, java.lang.String value4, opus.address.database.jooq.generated.enums.OptedEnum value5, java.lang.Boolean value6) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached EmailStates
	 */
	public EmailStates() {
		super(opus.address.database.jooq.generated.tables.EmailStates.EmailStates);
	}

	/**
	 * Create a detached, initialised EmailStates
	 */
	public EmailStates(java.lang.Long sequence, java.lang.Long emailId, java.lang.String localPart, java.lang.String domain, opus.address.database.jooq.generated.enums.OptedEnum opted, java.lang.Boolean isDeleted) {
		super(opus.address.database.jooq.generated.tables.EmailStates.EmailStates);

		setValue(0, sequence);
		setValue(1, emailId);
		setValue(2, localPart);
		setValue(3, domain);
		setValue(4, opted);
		setValue(5, isDeleted);
	}
}
