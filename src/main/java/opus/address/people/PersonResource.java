package opus.address.people;

import opus.address.commons.EventLogged;
import opus.address.commons.Try;
import opus.address.commons.http.Https;
import opus.address.commons.persistence.*;
import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.records.Events;
import opus.address.people.representations.PersonCreatedWriteRepresentation;
import opus.address.people.representations.PersonDeletedWriteRepresentation;
import opus.address.people.representations.PersonEventWriteRepresentation;
import opus.address.people.representations.PersonUpdatedWriteRepresentation;
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
            final @Valid PersonCreatedWriteRepresentation personCreatedRepresentation,
            final @Context DSLContext database
    ) {

//        final List<ContactInformationCreatedRepresentation> contactInfo
        return database.transactionResult(c -> Https.mapEventToResponse(
                personFactory.buildPersonWriter(personCreatedRepresentation)
                        .write(
                                personCreatedRepresentation.firstName,
                                personCreatedRepresentation.lastName
                        )
                        .apply(DSL.using(c))
        ));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updated")
    public Response personUpdated(
            @Valid PersonUpdatedWriteRepresentation personUpdatedRepresentation,
            @Context DSLContext database
    ) {
        return database.transactionResult(c -> Https.mapEventToResponse(
                personFactory.buildPersonWriter(personUpdatedRepresentation)
                        .update(personUpdatedRepresentation.personId,
                                personUpdatedRepresentation.firstName,
                                personUpdatedRepresentation.lastName
                        )
                        .apply(DSL.using(c))
        ));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deleted")
    public Response personDeleted(
            @Valid PersonDeletedWriteRepresentation personDeletedRepresentation,
            @Context DSLContext database
    ) {
        return database.transactionResult(c -> Https.mapEventToResponse(
                personFactory.buildPersonWriter(personDeletedRepresentation)
                        .delete(personDeletedRepresentation.personId
                        )
                        .apply(DSL.using(c))
        ));
    }
}

final class PersonFactory {
    private final String codeVersion;

    public PersonFactory(final String codeVersion) {
        this.codeVersion = codeVersion;
    }

    public PersonWriter buildPersonWriter(final PersonEventWriteRepresentation event) {
        return new PersonWriter(new Persister(codeVersion, event.actorId, event.getName()));
    }
}

class PersisterContext<A> implements Function<DSLContext, A> {
    private final Function<DSLContext, A> computation;
    
    public PersisterContext(final Function<DSLContext, A> computation) {
        this.computation = computation;
    }

    public <B> PersisterContext<B> flatMap(final Function<A,PersisterContext<B>> mapper) {
        return new PersisterContext<>(dslContext ->
                mapper
                        .apply(computation.apply(dslContext))
                        .apply(dslContext));
    }

    public A apply(final DSLContext db) {
        return computation.apply(db);
    } 
}

final class PersonWriter {
    private final Persister persister;

    public PersonWriter(
            final Persister persister
    ) {
        this.persister = persister;
    }

    public PersisterContext<Try<PersonCreateLogged>> write(
            final String firstName,
            final String lastName) {
        final EntityOperation entity = new EntityOperation();
        final PersonEntityTypeOperation personEntity = new PersonEntityTypeOperation(entity);

        persister.addOperation(personEntity)
                .addOperation(new StringFactOperation(entity, Tables.PeopleFactsFirstName.EntityId, Tables.PeopleFactsFirstName.FirstName, firstName))
                .addOperation(new StringFactOperation(entity, Tables.PeopleFactsLastName.EntityId, Tables.PeopleFactsLastName.LastName, lastName));

        return new PersisterContext<>(dslContext -> persister.persist(dslContext)
                .map(event -> new PersonCreateLogged(event.sequence(), entity.getId(), event.when().toInstant())));
    }

    public PersisterContext<Try<PersonUpdateLogged>> update(
            final long personId,
            final String firstName,
            final String lastName
    ) {
        final ExistingEntity entity = new ExistingEntity(personId);

        persister.addOperation(new StringFactOperation(entity, Tables.PeopleFactsFirstName.EntityId, Tables.PeopleFactsFirstName.FirstName, firstName))
                .addOperation(new StringFactOperation(entity, Tables.PeopleFactsLastName.EntityId, Tables.PeopleFactsLastName.LastName, lastName));

        return new PersisterContext<>(dslContext -> persister.persist(dslContext)
                .map(event -> new PersonUpdateLogged(event.sequence(), entity.getId(), event.when().toInstant())));
    }

    public PersisterContext<Try<PersonDeleteLogged>> delete(
            final long personId
    ) {
        final ExistingEntity entity = new ExistingEntity(personId);

        persister.addOperation(new BooleanFactOperation(entity, Tables.EntitiesFactsIsDeleted.EntityId, Tables.EntitiesFactsIsDeleted.IsDeleted, true));

        return new PersisterContext<>(dslContext -> persister.persist(dslContext)
                .map(event -> new PersonDeleteLogged(event.sequence(), personId, event.when().toInstant())));
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

abstract class PersonEventLogged implements EventLogged {
    public final long sequence;
    public final long personId;
    public final Instant instant;

    public PersonEventLogged(long sequence, long personId, final Instant instant) {
        this.sequence = sequence;
        this.personId = personId;
        this.instant = instant;
    }

    @Override
    public long getSequence() {
        return sequence;
    }
}

final class PersonUpdateLogged extends PersonEventLogged {
    public PersonUpdateLogged(long sequence, long personId, final Instant instant) {
        super(sequence, personId, instant);
    }
}

final class PersonDeleteLogged extends PersonEventLogged {
    public PersonDeleteLogged(long sequence, long personId, final Instant instant) {
        super(sequence, personId, instant);
    }
}

final class PersonCreateLogged extends PersonEventLogged {
    public PersonCreateLogged(long sequence, long personId, final Instant instant) {
        super(sequence, personId, instant);
    }
}