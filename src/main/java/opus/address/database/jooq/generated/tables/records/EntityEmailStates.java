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
public class EntityEmailStates extends org.jooq.impl.UpdatableRecordImpl<opus.address.database.jooq.generated.tables.records.EntityEmailStates> implements org.jooq.Record3<java.lang.Long, java.lang.Long, java.lang.Long> {

	private static final long serialVersionUID = -1126398224;

	/**
	 * Setter for <code>entity_email_states.sequence</code>.
	 */
	public void sequence(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>entity_email_states.sequence</code>.
	 */
	public java.lang.Long sequence() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>entity_email_states.entity_id</code>.
	 */
	public void entityId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>entity_email_states.entity_id</code>.
	 */
	public java.lang.Long entityId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>entity_email_states.email_id</code>.
	 */
	public void emailId(java.lang.Long value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>entity_email_states.email_id</code>.
	 */
	public java.lang.Long emailId() {
		return (java.lang.Long) getValue(2);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record3<java.lang.Long, java.lang.Long, java.lang.Long> key() {
		return (org.jooq.Record3) super.key();
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Long, java.lang.Long, java.lang.Long> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Long, java.lang.Long, java.lang.Long> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates.Sequence;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates.EntityId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field3() {
		return opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates.EmailId;
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
		return entityId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value3() {
		return emailId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityEmailStates value1(java.lang.Long value) {
		sequence(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityEmailStates value2(java.lang.Long value) {
		entityId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityEmailStates value3(java.lang.Long value) {
		emailId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityEmailStates values(java.lang.Long value1, java.lang.Long value2, java.lang.Long value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached EntityEmailStates
	 */
	public EntityEmailStates() {
		super(opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates);
	}

	/**
	 * Create a detached, initialised EntityEmailStates
	 */
	public EntityEmailStates(java.lang.Long sequence, java.lang.Long entityId, java.lang.Long emailId) {
		super(opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates);

		setValue(0, sequence);
		setValue(1, entityId);
		setValue(2, emailId);
	}
}
