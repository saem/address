package opus.address.people;

import opus.address.commons.persistence.*;
import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.records.Events;
import org.jooq.DSLContext;
import org.jooq.Insert;
import org.jooq.Table;

import javax.ws.rs.Path;

@Path("/person")
public final class PersonResource {

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
