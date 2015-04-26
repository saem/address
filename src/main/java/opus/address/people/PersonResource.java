package opus.address.people;

import opus.address.commons.Event;
import opus.address.commons.Try;
import opus.address.commons.http.Https;
import opus.address.commons.persistence.*;
import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.records.Events;
import opus.address.people.representations.ContactInformationCreatedRepresentation;
import opus.address.people.representations.PersonCreatedRepresentation;
import opus.address.people.representations.PersonDeletedRepresentation;
import opus.address.people.representations.PersonUpdatedRepresentation;
import opus.address.phones.PhoneCreatedRepresentation;
import org.jooq.DSLContext;
import org.jooq.Insert;
import org.jooq.Table;
import org.jooq.impl.DSL;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Path("/events/person")
public final class PersonResource {
    private final PersonFactory personFactory;

    public PersonResource(final PersonFactory personFactory) {
        this.personFactory = personFactory;
    }

    public static PersonResource build(
            final String codeVersion
    ) {
        return new PersonResource(new PersonFactory(codeVersion));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/created")
    public Response personCreated(
            final @Valid PersonCreatedRepresentation personCreatedRepresentation,
            final @Context DSLContext database
    ) {
        
        
        return Https.mapEventToResponse(
                personFactory.buildPersonWriter(database)
                        .write(
                                personCreatedRepresentation.firstName,
                                personCreatedRepresentation.lastName,
                                personCreatedRepresentation.actorId,
                                personCreatedRepresentation.contactInfo
                        )
        );
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updated")
    public Response personUpdated(
            @Valid PersonUpdatedRepresentation personUpdatedRepresentation,
            @Context DSLContext database
    ) {
        return Https.mapEventToResponse(
                personFactory.buildPersonWriter(database)
                        .update(personUpdatedRepresentation.personId,
                                personUpdatedRepresentation.firstName,
                                personUpdatedRepresentation.lastName,
                                personUpdatedRepresentation.actorId
                        ));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deleted")
    public Response personDeleted(
            @Valid PersonDeletedRepresentation personDeletedRepresentation,
            @Context DSLContext database
    ) {
        return Https.mapEventToResponse(
                personFactory.buildPersonWriter(database)
                        .delete(personDeletedRepresentation.personId,
                                personDeletedRepresentation.actorId
                        )
        );
    }
}

final class PersonFactory {
    private final String codeVersion;

    public PersonFactory(final String codeVersion) {
        this.codeVersion = codeVersion;
    }
    
    public PersonWriter buildPersonWriter(
            final DSLContext database
    ) {
        return new PersonWriter(database, codeVersion);
    }
}

final class PersisterContext<T> {
    private final Persister persister;

    public PersisterContext(final String codeVersion,
                            final int eventVersion,
                            final long actorId,
                            final String eventName) {
        this.persister = new Persister(codeVersion, eventVersion, actorId, eventName);
    }
    
    // something that takes a function, which uses a persister and returns a PersisterContext
}

/*
getLine() {
    // I have access to variables/state that let me read something
}




Optional<T> (T -> U) OPtional<U>

Where U <> Persister
PersisterContext<Persister> (Persister->U) PersisterContext<Persister>

(DSLContext?, codeVersion) ->
PersistenceContext.build(actorId, eventName, eventVersion) ->
Persister

Writer(Persister) ->
.write { Persister.addOperations(operations) }

Persister.persist(DSLContext?) ->
mapToEvent

*/

final class PersonWriter {
    private final DSLContext database;
    private final String codeVersion;

    public PersonWriter(
            final DSLContext database,
            final String codeVersion) {
        this.database = database;
        this.codeVersion = codeVersion;
    }

    public Try<PersonCreated> write(
            final String firstName,
            final String lastName,
            final Long actorId,
            final List<ContactInformationCreatedRepresentation> contactInfo) {
        final Persister persister = new Persister(codeVersion, 1, actorId, PersonCreated.EVENT_NAME);

        final EntityOperation entity = new EntityOperation();
        final PersonEntityTypeOperation personEntity = new PersonEntityTypeOperation(entity);

        persister.addOperation(personEntity)
                .addOperation(new StringFactOperation(entity, Tables.PeopleFactsFirstName.EntityId, Tables.PeopleFactsFirstName.FirstName, firstName))
                .addOperation(new StringFactOperation(entity, Tables.PeopleFactsLastName.EntityId, Tables.PeopleFactsLastName.LastName, lastName));

        return database.transactionResult(c -> {
                    return persister.persist(DSL.using(c))
                            .map(event -> new PersonCreated(event.sequence(), entity.getId(), event.when().toInstant()));
                }
        );
    }

    public Try<PersonUpdated> update(
            final long personId,
            final String firstName,
            final String lastName,
            final Long actorId
    ) {
        final Persister persister = new Persister(codeVersion, 1, actorId, PersonUpdated.EVENT_NAME);
        final ExistingEntity entity = new ExistingEntity(personId);

        persister.addOperation(new StringFactOperation(entity, Tables.PeopleFactsFirstName.EntityId, Tables.PeopleFactsFirstName.FirstName, firstName))
                .addOperation(new StringFactOperation(entity, Tables.PeopleFactsLastName.EntityId, Tables.PeopleFactsLastName.LastName, lastName));

        return database.transactionResult(c -> {
                    return persister.persist(DSL.using(c))
                            .map(event -> new PersonUpdated(event.sequence(), entity.getId(), event.when().toInstant()));
                }
        );
    }

    public Try<PersonDeleted> delete(
            final long personId,
            final long actorId
    ) {
        final Persister persister = new Persister(codeVersion, 1, actorId, PersonDeleted.EVENT_NAME);
        final ExistingEntity entity = new ExistingEntity(personId);

        persister.addOperation(new BooleanFactOperation(entity, Tables.EntitiesFactsIsDeleted.EntityId, Tables.EntitiesFactsIsDeleted.IsDeleted, true));
        
        return database.transactionResult(c -> {
                    return persister.persist(DSL.using(c))
                            .map(event -> new PersonDeleted(event.sequence(), personId, event.when().toInstant()));
                }
        );
    }
}

final class PersonEntityTypeOperation extends EntityTypeOperation {
    PersonEntityTypeOperation(final EntityOperation entity) { super(entity); }

    @Override
    public Insert getQuery(final DSLContext db, final Events event) {
        return db.insertInto(Tables.People,
                Tables.People.EntityId)
                .values(entity.getId());
    }

    @Override
    public Table getTable() {
        return Tables.People;
    }
}

final class PersonUpdated implements Event {
    public static final String EVENT_NAME = "person_updated";

    public final long sequence;
    public final long personId;
    public final Instant instant;

    public PersonUpdated(long sequence, long personId, final Instant instant) {
        this.sequence = sequence;
        this.personId = personId;
        this.instant = instant;
    }

    @Override
    public long getSequence() {
        return sequence;
    }
}

final class PersonDeleted implements Event {
    public static final String EVENT_NAME = "person_deleted";

    public final long sequence;
    public final long personId;
    public final Instant instant;

    public PersonDeleted(long sequence, long personId, final Instant instant) {
        this.sequence = sequence;
        this.personId = personId;
        this.instant = instant;
    }

    @Override
    public long getSequence() {
        return sequence;
    }
}

final class PersonCreated implements Event {
    public static final String EVENT_NAME = "person_created";

    public final long sequence;
    public final long personId;
    public final Instant instant;

    public PersonCreated(long sequence, long personId, final Instant instant) {
        this.sequence = sequence;
        this.personId = personId;
        this.instant = instant;
    }

    @Override
    public long getSequence() {
        return sequence;
    }
}