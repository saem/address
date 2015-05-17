package opus.address.people;

import opus.address.AddressApplication;
import opus.address.commons.http.Https;
import opus.address.commons.persistence.*;
import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.records.Events;
import opus.address.people.representations.PersonCreatedWriteRepresentation;
import opus.address.people.representations.PersonDeletedWriteRepresentation;
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

@Path("/events/person")
public final class PersonResource {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/created")
    public Response personCreated(
            final @Valid PersonCreatedWriteRepresentation personCreatedRepresentation,
            final @Context DSLContext database
    ) {
//        final List<ContactInformationCreatedRepresentation> contactInfo

        final Persister persister = new Persister(AddressApplication.CODE_VERSION, personCreatedRepresentation.actorId, personCreatedRepresentation.getName());
        new PersonWriter(persister)
                .write(
                        personCreatedRepresentation.firstName,
                        personCreatedRepresentation.lastName
                );
        return database.transactionResult(c -> Https.mapEventToResponse(persister.persist(DSL.using(c))));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updated")
    public Response personUpdated(
            @Valid PersonUpdatedWriteRepresentation personUpdatedRepresentation,
            @Context DSLContext database
    ) {
        final Persister persister = new Persister(AddressApplication.CODE_VERSION, personUpdatedRepresentation.actorId, personUpdatedRepresentation.getName());
        new PersonWriter(persister)
                .update(personUpdatedRepresentation.personId,
                        personUpdatedRepresentation.firstName,
                        personUpdatedRepresentation.lastName
                );
        return database.transactionResult(c -> Https.mapEventToResponse(persister.persist(DSL.using(c))));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deleted")
    public Response personDeleted(
            @Valid PersonDeletedWriteRepresentation personDeletedRepresentation,
            @Context DSLContext database
    ) {
        final Persister persister = new Persister(AddressApplication.CODE_VERSION, personDeletedRepresentation.actorId, personDeletedRepresentation.getName());
        new PersonWriter(persister).delete(personDeletedRepresentation.personId);
        return database.transactionResult(c -> Https.mapEventToResponse(persister.persist(DSL.using(c))));
    }
}

final class PersonWriter {
    private final Persister persister;

    public PersonWriter(
            final Persister persister
    ) {
        this.persister = persister;
    }

    public void write(
            final String firstName,
            final String lastName
    ) {
        final EntityOperation entity = new EntityOperation();
        final PersonEntityTypeOperation personEntity = new PersonEntityTypeOperation(entity);

        persister.addOperation(personEntity)
                .addOperation(new StringFactOperation(entity, Tables.PeopleFactsFirstName.EntityId, Tables.PeopleFactsFirstName.FirstName, firstName))
                .addOperation(new StringFactOperation(entity, Tables.PeopleFactsLastName.EntityId, Tables.PeopleFactsLastName.LastName, lastName));
    }

    public void update(
            final long personId,
            final String firstName,
            final String lastName
    ) {
        final ExistingEntity entity = new ExistingEntity(personId);

        persister.addOperation(new StringFactOperation(entity, Tables.PeopleFactsFirstName.EntityId, Tables.PeopleFactsFirstName.FirstName, firstName))
                .addOperation(new StringFactOperation(entity, Tables.PeopleFactsLastName.EntityId, Tables.PeopleFactsLastName.LastName, lastName));
    }

    public void delete(
            final long personId
    ) {
        final ExistingEntity entity = new ExistingEntity(personId);

        persister.addOperation(new BooleanFactOperation(entity, Tables.EntitiesFactsIsDeleted.EntityId, Tables.EntitiesFactsIsDeleted.IsDeleted, true));
    }
}

final class PersonEntityTypeOperation extends EntityTypeOperation {
    PersonEntityTypeOperation(final EntityOperation entity) {
        super(entity);
    }

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
