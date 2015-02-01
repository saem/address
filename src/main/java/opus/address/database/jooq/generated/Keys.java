/**
 * This class is generated by jOOQ
 */
package opus.address.database.jooq.generated;

/**
 * A class modelling foreign key relationships between tables of the <code></code> 
 * schema
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.1"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.Identity<opus.address.database.jooq.generated.tables.records.Entities, java.lang.Long> IDENTITY_Entities = Identities0.IDENTITY_Entities;
	public static final org.jooq.Identity<opus.address.database.jooq.generated.tables.records.Events, java.lang.Long> IDENTITY_Events = Identities0.IDENTITY_Events;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Addresses> PK_ADDRESSES = UniqueKeys0.PK_ADDRESSES;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.AddressStates> PK_ADDRESS_STATES = UniqueKeys0.PK_ADDRESS_STATES;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Databasechangeloglock> PK_DATABASECHANGELOGLOCK = UniqueKeys0.PK_DATABASECHANGELOGLOCK;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Emails> PK_EMAILS = UniqueKeys0.PK_EMAILS;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.EmailStates> PK_EMAIL_STATES = UniqueKeys0.PK_EMAIL_STATES;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Entities> PK_ENTITIES_ENTITY_ID = UniqueKeys0.PK_ENTITIES_ENTITY_ID;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates> PK_ENTITY_ADDRESS_STATES = UniqueKeys0.PK_ENTITY_ADDRESS_STATES;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.EntityEmailStates> PK_ENTITY_EMAIL_STATES = UniqueKeys0.PK_ENTITY_EMAIL_STATES;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.EntityPhoneStates> PK_ENTITY_PHONE_STATES = UniqueKeys0.PK_ENTITY_PHONE_STATES;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Events> PK_EVENTS_SEQUENCE = UniqueKeys0.PK_EVENTS_SEQUENCE;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.People> PK_PEOPLE = UniqueKeys0.PK_PEOPLE;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.PeopleStates> PK_PEOPLE_STATES = UniqueKeys0.PK_PEOPLE_STATES;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Phones> PK_PHONES = UniqueKeys0.PK_PHONES;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.PhoneStates> PK_PHONE_STATES = UniqueKeys0.PK_PHONE_STATES;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.System> PK_SYSTEM = UniqueKeys0.PK_SYSTEM;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Users> PK_USERS = UniqueKeys0.PK_USERS;
	public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.UserStates> PK_USER_STATES_SEQUENCE = UniqueKeys0.PK_USER_STATES_SEQUENCE;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Addresses, opus.address.database.jooq.generated.tables.records.Entities> ADDRESSES__FK_ADDRESSES_ENTITIES = ForeignKeys0.ADDRESSES__FK_ADDRESSES_ENTITIES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.AddressStates, opus.address.database.jooq.generated.tables.records.Events> ADDRESS_STATES__FK_ADDRESS_STATES_EVENTS = ForeignKeys0.ADDRESS_STATES__FK_ADDRESS_STATES_EVENTS;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.AddressStates, opus.address.database.jooq.generated.tables.records.Addresses> ADDRESS_STATES__FK_ADDRESS_STATES_ADDRESSES = ForeignKeys0.ADDRESS_STATES__FK_ADDRESS_STATES_ADDRESSES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Emails, opus.address.database.jooq.generated.tables.records.Entities> EMAILS__FK_EMAILS_ENTITIES = ForeignKeys0.EMAILS__FK_EMAILS_ENTITIES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EmailStates, opus.address.database.jooq.generated.tables.records.Events> EMAIL_STATES__FK_EMAIL_STATES_EVENTS = ForeignKeys0.EMAIL_STATES__FK_EMAIL_STATES_EVENTS;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EmailStates, opus.address.database.jooq.generated.tables.records.Emails> EMAIL_STATES__FK_EMAIL_STATES_EMAILS = ForeignKeys0.EMAIL_STATES__FK_EMAIL_STATES_EMAILS;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates, opus.address.database.jooq.generated.tables.records.Events> ENTITY_ADDRESS_STATES__FK_ENTITY_ADDRESS_STATES_EVENTS = ForeignKeys0.ENTITY_ADDRESS_STATES__FK_ENTITY_ADDRESS_STATES_EVENTS;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates, opus.address.database.jooq.generated.tables.records.Entities> ENTITY_ADDRESS_STATES__FK_ENTITY_ADDRESS_STATES_ENTITIES = ForeignKeys0.ENTITY_ADDRESS_STATES__FK_ENTITY_ADDRESS_STATES_ENTITIES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates, opus.address.database.jooq.generated.tables.records.Addresses> ENTITY_ADDRESS_STATES__FK_ENTITY_ADDRESS_STATES_ADDRESSES = ForeignKeys0.ENTITY_ADDRESS_STATES__FK_ENTITY_ADDRESS_STATES_ADDRESSES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityEmailStates, opus.address.database.jooq.generated.tables.records.Events> ENTITY_EMAIL_STATES__FK_ENTITY_EMAIL_STATES_EVENTS = ForeignKeys0.ENTITY_EMAIL_STATES__FK_ENTITY_EMAIL_STATES_EVENTS;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityEmailStates, opus.address.database.jooq.generated.tables.records.Entities> ENTITY_EMAIL_STATES__FK_ENTITY_EMAIL_STATES_ENTITIES = ForeignKeys0.ENTITY_EMAIL_STATES__FK_ENTITY_EMAIL_STATES_ENTITIES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityEmailStates, opus.address.database.jooq.generated.tables.records.Emails> ENTITY_EMAIL_STATES__FK_ENTITY_EMAIL_STATES_EMAILS = ForeignKeys0.ENTITY_EMAIL_STATES__FK_ENTITY_EMAIL_STATES_EMAILS;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityPhoneStates, opus.address.database.jooq.generated.tables.records.Events> ENTITY_PHONE_STATES__FK_ENTITY_PHONE_STATES_EVENTS = ForeignKeys0.ENTITY_PHONE_STATES__FK_ENTITY_PHONE_STATES_EVENTS;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityPhoneStates, opus.address.database.jooq.generated.tables.records.Entities> ENTITY_PHONE_STATES__FK_ENTITY_PHONE_STATES_ENTITIES = ForeignKeys0.ENTITY_PHONE_STATES__FK_ENTITY_PHONE_STATES_ENTITIES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityPhoneStates, opus.address.database.jooq.generated.tables.records.Phones> ENTITY_PHONE_STATES__FK_ENTITY_PHONE_STATES_PHONES = ForeignKeys0.ENTITY_PHONE_STATES__FK_ENTITY_PHONE_STATES_PHONES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Events, opus.address.database.jooq.generated.tables.records.Users> EVENTS__FK_EVENTS_USERS = ForeignKeys0.EVENTS__FK_EVENTS_USERS;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.People, opus.address.database.jooq.generated.tables.records.Entities> PEOPLE__FK_PEOPLE_ENTITIES = ForeignKeys0.PEOPLE__FK_PEOPLE_ENTITIES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PeopleStates, opus.address.database.jooq.generated.tables.records.Events> PEOPLE_STATES__FK_PEOPLE_STATES_EVENTS = ForeignKeys0.PEOPLE_STATES__FK_PEOPLE_STATES_EVENTS;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PeopleStates, opus.address.database.jooq.generated.tables.records.People> PEOPLE_STATES__FK_PEOPLE_STATES_PEOPLE = ForeignKeys0.PEOPLE_STATES__FK_PEOPLE_STATES_PEOPLE;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PeopleStates, opus.address.database.jooq.generated.tables.records.Emails> PEOPLE_STATES__FK_PEOPLE_STATES_EMAILS = ForeignKeys0.PEOPLE_STATES__FK_PEOPLE_STATES_EMAILS;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PeopleStates, opus.address.database.jooq.generated.tables.records.Addresses> PEOPLE_STATES__FK_PEOPLE_STATES_ADDRESSES = ForeignKeys0.PEOPLE_STATES__FK_PEOPLE_STATES_ADDRESSES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PeopleStates, opus.address.database.jooq.generated.tables.records.Phones> PEOPLE_STATES__FK_PEOPLE_STATES_PHONES = ForeignKeys0.PEOPLE_STATES__FK_PEOPLE_STATES_PHONES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Phones, opus.address.database.jooq.generated.tables.records.Entities> PHONES__FK_PHONES = ForeignKeys0.PHONES__FK_PHONES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PhoneStates, opus.address.database.jooq.generated.tables.records.Events> PHONE_STATES__FK_PHONE_STATES_EVENTS = ForeignKeys0.PHONE_STATES__FK_PHONE_STATES_EVENTS;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PhoneStates, opus.address.database.jooq.generated.tables.records.Phones> PHONE_STATES__FK_PHONE_STATES_PHONES = ForeignKeys0.PHONE_STATES__FK_PHONE_STATES_PHONES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.System, opus.address.database.jooq.generated.tables.records.Entities> SYSTEM__FK_SYSTEM_ENTITIES = ForeignKeys0.SYSTEM__FK_SYSTEM_ENTITIES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Users, opus.address.database.jooq.generated.tables.records.Entities> USERS__FK_USERS_ENTITIES = ForeignKeys0.USERS__FK_USERS_ENTITIES;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.UserStates, opus.address.database.jooq.generated.tables.records.Events> USER_STATES__FK_USER_STATES_EVENTS = ForeignKeys0.USER_STATES__FK_USER_STATES_EVENTS;
	public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.UserStates, opus.address.database.jooq.generated.tables.records.Users> USER_STATES__FK_USER_STATES_USERS = ForeignKeys0.USER_STATES__FK_USER_STATES_USERS;

	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends org.jooq.impl.AbstractKeys {
		public static org.jooq.Identity<opus.address.database.jooq.generated.tables.records.Entities, java.lang.Long> IDENTITY_Entities = createIdentity(opus.address.database.jooq.generated.tables.Entities.Entities, opus.address.database.jooq.generated.tables.Entities.Entities.EntityId);
		public static org.jooq.Identity<opus.address.database.jooq.generated.tables.records.Events, java.lang.Long> IDENTITY_Events = createIdentity(opus.address.database.jooq.generated.tables.Events.Events, opus.address.database.jooq.generated.tables.Events.Events.Sequence);
	}

	private static class UniqueKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Addresses> PK_ADDRESSES = createUniqueKey(opus.address.database.jooq.generated.tables.Addresses.Addresses, opus.address.database.jooq.generated.tables.Addresses.Addresses.EntityId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.AddressStates> PK_ADDRESS_STATES = createUniqueKey(opus.address.database.jooq.generated.tables.AddressStates.AddressStates, opus.address.database.jooq.generated.tables.AddressStates.AddressStates.Sequence, opus.address.database.jooq.generated.tables.AddressStates.AddressStates.AddressId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Databasechangeloglock> PK_DATABASECHANGELOGLOCK = createUniqueKey(opus.address.database.jooq.generated.tables.Databasechangeloglock.Databasechangeloglock, opus.address.database.jooq.generated.tables.Databasechangeloglock.Databasechangeloglock.Id);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Emails> PK_EMAILS = createUniqueKey(opus.address.database.jooq.generated.tables.Emails.Emails, opus.address.database.jooq.generated.tables.Emails.Emails.EntityId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.EmailStates> PK_EMAIL_STATES = createUniqueKey(opus.address.database.jooq.generated.tables.EmailStates.EmailStates, opus.address.database.jooq.generated.tables.EmailStates.EmailStates.Sequence, opus.address.database.jooq.generated.tables.EmailStates.EmailStates.EmailId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Entities> PK_ENTITIES_ENTITY_ID = createUniqueKey(opus.address.database.jooq.generated.tables.Entities.Entities, opus.address.database.jooq.generated.tables.Entities.Entities.EntityId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates> PK_ENTITY_ADDRESS_STATES = createUniqueKey(opus.address.database.jooq.generated.tables.EntityAddressStates.EntityAddressStates, opus.address.database.jooq.generated.tables.EntityAddressStates.EntityAddressStates.Sequence, opus.address.database.jooq.generated.tables.EntityAddressStates.EntityAddressStates.EntityId, opus.address.database.jooq.generated.tables.EntityAddressStates.EntityAddressStates.AddressId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.EntityEmailStates> PK_ENTITY_EMAIL_STATES = createUniqueKey(opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates, opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates.Sequence, opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates.EntityId, opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates.EmailId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.EntityPhoneStates> PK_ENTITY_PHONE_STATES = createUniqueKey(opus.address.database.jooq.generated.tables.EntityPhoneStates.EntityPhoneStates, opus.address.database.jooq.generated.tables.EntityPhoneStates.EntityPhoneStates.Sequence, opus.address.database.jooq.generated.tables.EntityPhoneStates.EntityPhoneStates.EntityId, opus.address.database.jooq.generated.tables.EntityPhoneStates.EntityPhoneStates.PhoneId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Events> PK_EVENTS_SEQUENCE = createUniqueKey(opus.address.database.jooq.generated.tables.Events.Events, opus.address.database.jooq.generated.tables.Events.Events.Sequence);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.People> PK_PEOPLE = createUniqueKey(opus.address.database.jooq.generated.tables.People.People, opus.address.database.jooq.generated.tables.People.People.EntityId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.PeopleStates> PK_PEOPLE_STATES = createUniqueKey(opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates.Sequence, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates.EntityId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Phones> PK_PHONES = createUniqueKey(opus.address.database.jooq.generated.tables.Phones.Phones, opus.address.database.jooq.generated.tables.Phones.Phones.EntityId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.PhoneStates> PK_PHONE_STATES = createUniqueKey(opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates, opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates.Sequence, opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates.PhoneId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.System> PK_SYSTEM = createUniqueKey(opus.address.database.jooq.generated.tables.System.System, opus.address.database.jooq.generated.tables.System.System.EntityId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.Users> PK_USERS = createUniqueKey(opus.address.database.jooq.generated.tables.Users.Users, opus.address.database.jooq.generated.tables.Users.Users.EntityId);
		public static final org.jooq.UniqueKey<opus.address.database.jooq.generated.tables.records.UserStates> PK_USER_STATES_SEQUENCE = createUniqueKey(opus.address.database.jooq.generated.tables.UserStates.UserStates, opus.address.database.jooq.generated.tables.UserStates.UserStates.Sequence);
	}

	private static class ForeignKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Addresses, opus.address.database.jooq.generated.tables.records.Entities> ADDRESSES__FK_ADDRESSES_ENTITIES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_ENTITIES_ENTITY_ID, opus.address.database.jooq.generated.tables.Addresses.Addresses, opus.address.database.jooq.generated.tables.Addresses.Addresses.EntityId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.AddressStates, opus.address.database.jooq.generated.tables.records.Events> ADDRESS_STATES__FK_ADDRESS_STATES_EVENTS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_EVENTS_SEQUENCE, opus.address.database.jooq.generated.tables.AddressStates.AddressStates, opus.address.database.jooq.generated.tables.AddressStates.AddressStates.Sequence);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.AddressStates, opus.address.database.jooq.generated.tables.records.Addresses> ADDRESS_STATES__FK_ADDRESS_STATES_ADDRESSES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_ADDRESSES, opus.address.database.jooq.generated.tables.AddressStates.AddressStates, opus.address.database.jooq.generated.tables.AddressStates.AddressStates.AddressId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Emails, opus.address.database.jooq.generated.tables.records.Entities> EMAILS__FK_EMAILS_ENTITIES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_ENTITIES_ENTITY_ID, opus.address.database.jooq.generated.tables.Emails.Emails, opus.address.database.jooq.generated.tables.Emails.Emails.EntityId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EmailStates, opus.address.database.jooq.generated.tables.records.Events> EMAIL_STATES__FK_EMAIL_STATES_EVENTS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_EVENTS_SEQUENCE, opus.address.database.jooq.generated.tables.EmailStates.EmailStates, opus.address.database.jooq.generated.tables.EmailStates.EmailStates.Sequence);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EmailStates, opus.address.database.jooq.generated.tables.records.Emails> EMAIL_STATES__FK_EMAIL_STATES_EMAILS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_EMAILS, opus.address.database.jooq.generated.tables.EmailStates.EmailStates, opus.address.database.jooq.generated.tables.EmailStates.EmailStates.EmailId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates, opus.address.database.jooq.generated.tables.records.Events> ENTITY_ADDRESS_STATES__FK_ENTITY_ADDRESS_STATES_EVENTS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_EVENTS_SEQUENCE, opus.address.database.jooq.generated.tables.EntityAddressStates.EntityAddressStates, opus.address.database.jooq.generated.tables.EntityAddressStates.EntityAddressStates.Sequence);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates, opus.address.database.jooq.generated.tables.records.Entities> ENTITY_ADDRESS_STATES__FK_ENTITY_ADDRESS_STATES_ENTITIES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_ENTITIES_ENTITY_ID, opus.address.database.jooq.generated.tables.EntityAddressStates.EntityAddressStates, opus.address.database.jooq.generated.tables.EntityAddressStates.EntityAddressStates.EntityId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityAddressStates, opus.address.database.jooq.generated.tables.records.Addresses> ENTITY_ADDRESS_STATES__FK_ENTITY_ADDRESS_STATES_ADDRESSES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_ADDRESSES, opus.address.database.jooq.generated.tables.EntityAddressStates.EntityAddressStates, opus.address.database.jooq.generated.tables.EntityAddressStates.EntityAddressStates.AddressId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityEmailStates, opus.address.database.jooq.generated.tables.records.Events> ENTITY_EMAIL_STATES__FK_ENTITY_EMAIL_STATES_EVENTS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_EVENTS_SEQUENCE, opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates, opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates.Sequence);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityEmailStates, opus.address.database.jooq.generated.tables.records.Entities> ENTITY_EMAIL_STATES__FK_ENTITY_EMAIL_STATES_ENTITIES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_ENTITIES_ENTITY_ID, opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates, opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates.EntityId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityEmailStates, opus.address.database.jooq.generated.tables.records.Emails> ENTITY_EMAIL_STATES__FK_ENTITY_EMAIL_STATES_EMAILS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_EMAILS, opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates, opus.address.database.jooq.generated.tables.EntityEmailStates.EntityEmailStates.EmailId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityPhoneStates, opus.address.database.jooq.generated.tables.records.Events> ENTITY_PHONE_STATES__FK_ENTITY_PHONE_STATES_EVENTS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_EVENTS_SEQUENCE, opus.address.database.jooq.generated.tables.EntityPhoneStates.EntityPhoneStates, opus.address.database.jooq.generated.tables.EntityPhoneStates.EntityPhoneStates.Sequence);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityPhoneStates, opus.address.database.jooq.generated.tables.records.Entities> ENTITY_PHONE_STATES__FK_ENTITY_PHONE_STATES_ENTITIES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_ENTITIES_ENTITY_ID, opus.address.database.jooq.generated.tables.EntityPhoneStates.EntityPhoneStates, opus.address.database.jooq.generated.tables.EntityPhoneStates.EntityPhoneStates.EntityId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.EntityPhoneStates, opus.address.database.jooq.generated.tables.records.Phones> ENTITY_PHONE_STATES__FK_ENTITY_PHONE_STATES_PHONES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_PHONES, opus.address.database.jooq.generated.tables.EntityPhoneStates.EntityPhoneStates, opus.address.database.jooq.generated.tables.EntityPhoneStates.EntityPhoneStates.PhoneId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Events, opus.address.database.jooq.generated.tables.records.Users> EVENTS__FK_EVENTS_USERS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_USERS, opus.address.database.jooq.generated.tables.Events.Events, opus.address.database.jooq.generated.tables.Events.Events.Actor);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.People, opus.address.database.jooq.generated.tables.records.Entities> PEOPLE__FK_PEOPLE_ENTITIES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_ENTITIES_ENTITY_ID, opus.address.database.jooq.generated.tables.People.People, opus.address.database.jooq.generated.tables.People.People.EntityId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PeopleStates, opus.address.database.jooq.generated.tables.records.Events> PEOPLE_STATES__FK_PEOPLE_STATES_EVENTS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_EVENTS_SEQUENCE, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates.Sequence);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PeopleStates, opus.address.database.jooq.generated.tables.records.People> PEOPLE_STATES__FK_PEOPLE_STATES_PEOPLE = createForeignKey(opus.address.database.jooq.generated.Keys.PK_PEOPLE, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates.EntityId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PeopleStates, opus.address.database.jooq.generated.tables.records.Emails> PEOPLE_STATES__FK_PEOPLE_STATES_EMAILS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_EMAILS, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates.PrimaryEmail);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PeopleStates, opus.address.database.jooq.generated.tables.records.Addresses> PEOPLE_STATES__FK_PEOPLE_STATES_ADDRESSES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_ADDRESSES, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates.PrimaryAddress);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PeopleStates, opus.address.database.jooq.generated.tables.records.Phones> PEOPLE_STATES__FK_PEOPLE_STATES_PHONES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_PHONES, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates, opus.address.database.jooq.generated.tables.PeopleStates.PeopleStates.PrimaryPhone);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Phones, opus.address.database.jooq.generated.tables.records.Entities> PHONES__FK_PHONES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_ENTITIES_ENTITY_ID, opus.address.database.jooq.generated.tables.Phones.Phones, opus.address.database.jooq.generated.tables.Phones.Phones.EntityId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PhoneStates, opus.address.database.jooq.generated.tables.records.Events> PHONE_STATES__FK_PHONE_STATES_EVENTS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_EVENTS_SEQUENCE, opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates, opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates.Sequence);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.PhoneStates, opus.address.database.jooq.generated.tables.records.Phones> PHONE_STATES__FK_PHONE_STATES_PHONES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_PHONES, opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates, opus.address.database.jooq.generated.tables.PhoneStates.PhoneStates.PhoneId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.System, opus.address.database.jooq.generated.tables.records.Entities> SYSTEM__FK_SYSTEM_ENTITIES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_ENTITIES_ENTITY_ID, opus.address.database.jooq.generated.tables.System.System, opus.address.database.jooq.generated.tables.System.System.EntityId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.Users, opus.address.database.jooq.generated.tables.records.Entities> USERS__FK_USERS_ENTITIES = createForeignKey(opus.address.database.jooq.generated.Keys.PK_ENTITIES_ENTITY_ID, opus.address.database.jooq.generated.tables.Users.Users, opus.address.database.jooq.generated.tables.Users.Users.EntityId);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.UserStates, opus.address.database.jooq.generated.tables.records.Events> USER_STATES__FK_USER_STATES_EVENTS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_EVENTS_SEQUENCE, opus.address.database.jooq.generated.tables.UserStates.UserStates, opus.address.database.jooq.generated.tables.UserStates.UserStates.Sequence);
		public static final org.jooq.ForeignKey<opus.address.database.jooq.generated.tables.records.UserStates, opus.address.database.jooq.generated.tables.records.Users> USER_STATES__FK_USER_STATES_USERS = createForeignKey(opus.address.database.jooq.generated.Keys.PK_USERS, opus.address.database.jooq.generated.tables.UserStates.UserStates, opus.address.database.jooq.generated.tables.UserStates.UserStates.UserId);
	}
}
