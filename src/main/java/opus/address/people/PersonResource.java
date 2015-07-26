package opus.address.people;

import opus.address.commons.persistence.*;
import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.records.EventRecord;
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
                .addOperation(new StringFactOperation(entity, Tables.PersonFactFirstName.EntityId, Tables.PersonFactFirstName.FirstName, firstName))
                .addOperation(new StringFactOperation(entity, Tables.PersonFactLastName.EntityId, Tables.PersonFactLastName.LastName, lastName));
    }

    public void update(
            final long personId,
            final String firstName,
            final String lastName
    ) {
        final ExistingEntity entity = new ExistingEntity(personId);

        persister.addOperation(new StringFactOperation(entity, Tables.PersonFactFirstName.EntityId, Tables.PersonFactFirstName.FirstName, firstName))
                .addOperation(new StringFactOperation(entity, Tables.PersonFactLastName.EntityId, Tables.PersonFactLastName.LastName, lastName));
    }

    public void delete(
            final long personId
    ) {
        final ExistingEntity entity = new ExistingEntity(personId);

        persister.addOperation(new BooleanFactOperation(entity, Tables.EntityFactIsDeleted.EntityId, Tables.EntityFactIsDeleted.IsDeleted, true));
    }
}

final class PersonEntityTypeOperation extends EntityTypeOperation {
    PersonEntityTypeOperation(final EntityOperation entity) {
        super(entity);
    }

    @Override
    public Insert getQuery(final DSLContext db, final EventRecord event) {
        return db.insertInto(Tables.Person,
                Tables.Person.EntityId)
                .values(entity.getId());
    }

    @Override
    public Table getTable() {
        return Tables.Person;
    }
}
