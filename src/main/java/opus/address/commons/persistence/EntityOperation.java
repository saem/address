package opus.address.commons.persistence;

import opus.address.commons.OneTimeSet;
import opus.address.database.jooq.generated.tables.Entity;
import opus.address.database.jooq.generated.tables.records.EntityRecord;
import opus.address.database.jooq.generated.tables.records.EventRecord;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;

import static opus.address.database.jooq.generated.tables.Entity.Entity;

public final class EntityOperation implements Operation, EntityIdProvider {
    private final OneTimeSet<Long> id = new OneTimeSet<>();

    @Override
    public InsertResultStep<EntityRecord> getQuery(
            final DSLContext db,
            final EventRecord event) {
        return db.insertInto(Entity)
                .defaultValues()
                .returning(Entity.EntityId);
    }

    public void setId(Long id) { this.id.set(id); }
    public Long getId() { return id.get(); }
    
    public Entity getTable() {
        return Entity;
    }
}
