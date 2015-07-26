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
public class EmailRecord extends org.jooq.impl.UpdatableRecordImpl<opus.address.database.jooq.generated.tables.records.EmailRecord> implements org.jooq.Record2<java.lang.Long, java.lang.Long> {

	private static final long serialVersionUID = 807857766;

	/**
	 * Setter for <code>email.email_id</code>.
	 */
	public void emailId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>email.email_id</code>.
	 */
	public java.lang.Long emailId() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>email.parent_id</code>.
	 */
	public void parentId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>email.parent_id</code>.
	 */
	public java.lang.Long parentId() {
		return (java.lang.Long) getValue(1);
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
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<java.lang.Long, java.lang.Long> fieldsRow() {
		return (org.jooq.Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row2<java.lang.Long, java.lang.Long> valuesRow() {
		return (org.jooq.Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return opus.address.database.jooq.generated.tables.Email.Email.EmailId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return opus.address.database.jooq.generated.tables.Email.Email.ParentId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value1() {
		return emailId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value2() {
		return parentId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmailRecord value1(java.lang.Long value) {
		emailId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmailRecord value2(java.lang.Long value) {
		parentId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmailRecord values(java.lang.Long value1, java.lang.Long value2) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached EmailRecord
	 */
	public EmailRecord() {
		super(opus.address.database.jooq.generated.tables.Email.Email);
	}

	/**
	 * Create a detached, initialised EmailRecord
	 */
	public EmailRecord(java.lang.Long emailId, java.lang.Long parentId) {
		super(opus.address.database.jooq.generated.tables.Email.Email);

		setValue(0, emailId);
		setValue(1, parentId);
	}
}