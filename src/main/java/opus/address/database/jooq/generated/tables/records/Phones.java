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
public class Phones extends org.jooq.impl.UpdatableRecordImpl<opus.address.database.jooq.generated.tables.records.Phones> implements org.jooq.Record1<java.lang.Long> {

	private static final long serialVersionUID = -336286406;

	/**
	 * Setter for <code>phones.entity_id</code>.
	 */
	public void entityId(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>phones.entity_id</code>.
	 */
	public java.lang.Long entityId() {
		return (java.lang.Long) getValue(0);
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
	// Record1 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row1<java.lang.Long> fieldsRow() {
		return (org.jooq.Row1) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row1<java.lang.Long> valuesRow() {
		return (org.jooq.Row1) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field1() {
		return opus.address.database.jooq.generated.tables.Phones.Phones.EntityId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value1() {
		return entityId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Phones value1(java.lang.Long value) {
		entityId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Phones values(java.lang.Long value1) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached Phones
	 */
	public Phones() {
		super(opus.address.database.jooq.generated.tables.Phones.Phones);
	}

	/**
	 * Create a detached, initialised Phones
	 */
	public Phones(java.lang.Long entityId) {
		super(opus.address.database.jooq.generated.tables.Phones.Phones);

		setValue(0, entityId);
	}
}
