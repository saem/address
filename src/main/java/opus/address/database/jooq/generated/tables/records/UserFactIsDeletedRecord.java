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
public class UserFactIsDeletedRecord extends org.jooq.impl.UpdatableRecordImpl<opus.address.database.jooq.generated.tables.records.UserFactIsDeletedRecord> implements org.jooq.Record3<java.lang.Long, java.lang.Long, java.lang.Boolean> {

	private static final long serialVersionUID = 873763097;

	/**
	 * Setter for <code>user_fact_is_deleted.sequence</code>.
	 */
	public void sequence(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>user_fact_is_deleted.sequence</code>.
	 */
	public java.lang.Long sequence() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>user_fact_is_deleted.user_id</code>.
	 */
	public void userId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>user_fact_is_deleted.user_id</code>.
	 */
	public java.lang.Long userId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>user_fact_is_deleted.is_deleted</code>.
	 */
	public void isDeleted(java.lang.Boolean value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>user_fact_is_deleted.is_deleted</code>.
	 */
	public java.lang.Boolean isDeleted() {
		return (java.lang.Boolean) getValue(2);
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
	public org.jooq.Row3<java.lang.Long, java.lang.Long, java.lang.Boolean> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Long, java.lang.Long, java.lang.Boolean> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return opus.address.database.jooq.generated.tables.UserFactIsDeleted.UserFactIsDeleted.Sequence;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return opus.address.database.jooq.generated.tables.UserFactIsDeleted.UserFactIsDeleted.UserId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field3() {
		return opus.address.database.jooq.generated.tables.UserFactIsDeleted.UserFactIsDeleted.IsDeleted;
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
	public java.lang.Boolean value3() {
		return isDeleted();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserFactIsDeletedRecord value1(java.lang.Long value) {
		sequence(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserFactIsDeletedRecord value2(java.lang.Long value) {
		userId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserFactIsDeletedRecord value3(java.lang.Boolean value) {
		isDeleted(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserFactIsDeletedRecord values(java.lang.Long value1, java.lang.Long value2, java.lang.Boolean value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UserFactIsDeletedRecord
	 */
	public UserFactIsDeletedRecord() {
		super(opus.address.database.jooq.generated.tables.UserFactIsDeleted.UserFactIsDeleted);
	}

	/**
	 * Create a detached, initialised UserFactIsDeletedRecord
	 */
	public UserFactIsDeletedRecord(java.lang.Long sequence, java.lang.Long userId, java.lang.Boolean isDeleted) {
		super(opus.address.database.jooq.generated.tables.UserFactIsDeleted.UserFactIsDeleted);

		setValue(0, sequence);
		setValue(1, userId);
		setValue(2, isDeleted);
	}
}
