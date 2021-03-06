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
public class RelationshipFactIsRelatedRecord extends org.jooq.impl.UpdatableRecordImpl<opus.address.database.jooq.generated.tables.records.RelationshipFactIsRelatedRecord> implements org.jooq.Record3<java.lang.Long, java.lang.Long, java.lang.Boolean> {

	private static final long serialVersionUID = 969985670;

	/**
	 * Setter for <code>relationship_fact_is_related.sequence</code>.
	 */
	public void sequence(java.lang.Long value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>relationship_fact_is_related.sequence</code>.
	 */
	public java.lang.Long sequence() {
		return (java.lang.Long) getValue(0);
	}

	/**
	 * Setter for <code>relationship_fact_is_related.relationship_id</code>.
	 */
	public void relationshipId(java.lang.Long value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>relationship_fact_is_related.relationship_id</code>.
	 */
	public java.lang.Long relationshipId() {
		return (java.lang.Long) getValue(1);
	}

	/**
	 * Setter for <code>relationship_fact_is_related.is_related</code>.
	 */
	public void isRelated(java.lang.Boolean value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>relationship_fact_is_related.is_related</code>.
	 */
	public java.lang.Boolean isRelated() {
		return (java.lang.Boolean) getValue(2);
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
		return opus.address.database.jooq.generated.tables.RelationshipFactIsRelated.RelationshipFactIsRelated.Sequence;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field2() {
		return opus.address.database.jooq.generated.tables.RelationshipFactIsRelated.RelationshipFactIsRelated.RelationshipId;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field3() {
		return opus.address.database.jooq.generated.tables.RelationshipFactIsRelated.RelationshipFactIsRelated.IsRelated;
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
		return relationshipId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value3() {
		return isRelated();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RelationshipFactIsRelatedRecord value1(java.lang.Long value) {
		sequence(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RelationshipFactIsRelatedRecord value2(java.lang.Long value) {
		relationshipId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RelationshipFactIsRelatedRecord value3(java.lang.Boolean value) {
		isRelated(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RelationshipFactIsRelatedRecord values(java.lang.Long value1, java.lang.Long value2, java.lang.Boolean value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached RelationshipFactIsRelatedRecord
	 */
	public RelationshipFactIsRelatedRecord() {
		super(opus.address.database.jooq.generated.tables.RelationshipFactIsRelated.RelationshipFactIsRelated);
	}

	/**
	 * Create a detached, initialised RelationshipFactIsRelatedRecord
	 */
	public RelationshipFactIsRelatedRecord(java.lang.Long sequence, java.lang.Long relationshipId, java.lang.Boolean isRelated) {
		super(opus.address.database.jooq.generated.tables.RelationshipFactIsRelated.RelationshipFactIsRelated);

		setValue(0, sequence);
		setValue(1, relationshipId);
		setValue(2, isRelated);
	}
}
