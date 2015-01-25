/**
 * This class is generated by jOOQ
 */
package opus.address.database.jooq.generated.tables;

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
public class Events extends org.jooq.impl.TableImpl<opus.address.database.jooq.generated.tables.records.Events> {

	private static final long serialVersionUID = -1107083633;

	/**
	 * The reference instance of <code>events</code>
	 */
	public static final opus.address.database.jooq.generated.tables.Events Events = new opus.address.database.jooq.generated.tables.Events();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<opus.address.database.jooq.generated.tables.records.Events> getRecordType() {
		return opus.address.database.jooq.generated.tables.records.Events.class;
	}

	/**
	 * The column <code>events.sequence</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Events, java.lang.Long> Sequence = createField("sequence", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>events.event</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Events, java.lang.String> Event = createField("event", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * The column <code>events.version</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Events, java.lang.Integer> Version = createField("version", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>events.actor</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Events, java.lang.Long> Actor = createField("actor", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * The column <code>events.when</code>.
	 */
	public final org.jooq.TableField<opus.address.database.jooq.generated.tables.records.Events, java.sql.Timestamp> When = createField("when", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>events</code> table reference
	 */
	public Events() {
		this("events", null);
	}

	/**
	 * Create an aliased <code>events</code> table reference
	 */
	public Events(java.lang.String alias) {
		this(alias, opus.address.database.jooq.generated.tables.Events.Events);
	}

	private Events(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.Events> aliased) {
		this(alias, aliased, null);
	}

	private Events(java.lang.String alias, org.jooq.Table<opus.address.database.jooq.generated.tables.records.Events> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, opus.address.database.jooq.generated.DefaultSchema.DEFAULT_SCHEMA, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<opus.address.database.jooq.generated.tables.records.Events, java.lang.Long> getIdentity() {
		return opus.address.database.jooq.generated.Keys.IDENTITY_Events;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Events> getPrimaryKey() {
		return opus.address.database.jooq.generated.Keys.PK_EVENTS_SEQUENCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Events>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Events>>asList(opus.address.database.jooq.generated.Keys.PK_EVENTS_SEQUENCE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Events, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Events, ?>>asList(opus.address.database.jooq.generated.Keys.EVENTS__FK_EVENTS_ENTITIES);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public opus.address.database.jooq.generated.tables.Events as(java.lang.String alias) {
		return new opus.address.database.jooq.generated.tables.Events(alias, this);
	}

	/**
	 * Rename this table
	 */
	public opus.address.database.jooq.generated.tables.Events rename(java.lang.String name) {
		return new opus.address.database.jooq.generated.tables.Events(name, null);
	}
}
