package opus.address.commons.persistence;

import opus.address.commons.OneTimeSet;
import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.records.Entities;
import opus.address.database.jooq.generated.tables.records.Events;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;

public final class EntityOperation implements Operation {
    private final OneTimeSet<Long> id = new OneTimeSet<>();

    @Override
    public InsertResultStep<Entities> getQuery(
            final DSLContext db,
            final Events event) {
        return db.insertInto(Tables.Entities)
                .defaultValues()
                .returning(Tables.Entities.EntityId);
    }

    public void setId(Long id) { this.id.set(id); }
    public Long getId() { return id.get(); }
    
    public opus.address.database.jooq.generated.tables.Entities getTable() {
        return Tables.Entities;
    }
}
