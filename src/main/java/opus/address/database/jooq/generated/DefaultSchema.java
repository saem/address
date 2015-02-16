/**
 * This class is generated by jOOQ
 */
package opus.address.database.jooq.generated;

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
public class DefaultSchema extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = -2061616213;

	/**
	 * The reference instance of <code></code>
	 */
	public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

	/**
	 * No further instances allowed
	 */
	private DefaultSchema() {
		super("");
	}

	@Override
	public final java.util.List<org.jooq.Sequence<?>> getSequences() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getSequences0());
		return result;
	}

	private final java.util.List<org.jooq.Sequence<?>> getSequences0() {
		return java.util.Arrays.<org.jooq.Sequence<?>>asList(
			opus.address.database.jooq.generated.Sequences.entities_entity_id_seq,
			opus.address.database.jooq.generated.Sequences.events_sequence_seq);
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			opus.address.database.jooq.generated.tables.Addresses.Addresses,
			opus.address.database.jooq.generated.tables.AddressStates.AddressStates,
			opus.address.database.jooq.generated.tables.Databasechangelog.Databasechangelog,
			opus.address.database.jooq.generated.tables.Databasechangeloglock.Databasechangeloglock,
			opus.address.database.jooq.generated.tables.Emails.Emails,
			opus.address.database.jooq.generated.tables.EmailStates.EmailStates,
			opus.address.database.jooq.generated.tables.Entities.Entities,
			opus.address.database.jooq.generated.tables.EntityAddressStates.EntityAddressStates,
			opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates,
			opus.address.database.jooq.generated.tables.EntityPhoneStates.EntityPhoneStates,
			opus.address.database.jooq.generated.tables.Events.Events,
			opus.address.database.jooq.generated.tables.People.People,
			opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates,
			opus.address.database.jooq.generated.tables.Phones.Phones,
			opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates,
			opus.address.database.jooq.generated.tables.System.System,
			opus.address.database.jooq.generated.tables.Users.Users,
			opus.address.database.jooq.generated.tables.UserStates.UserStates);
	}
}
