/**
 * This class is generated by jOOQ
 */
package opus.address.database.jooq.generated;

/**
 * Convenience access to all sequences in 
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.1"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

	/**
	 * The sequence <code>entities_entity_id_seq</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> entities_entity_id_seq = new org.jooq.impl.SequenceImpl<java.lang.Long>("entities_entity_id_seq", opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, org.jooq.impl.SQLDataType.BIGINT.nullable(false));

	/**
	 * The sequence <code>events_sequence_seq</code>
	 */
	public static final org.jooq.Sequence<java.lang.Long> events_sequence_seq = new org.jooq.impl.SequenceImpl<java.lang.Long>("events_sequence_seq", opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, org.jooq.impl.SQLDataType.BIGINT.nullable(false));
}
