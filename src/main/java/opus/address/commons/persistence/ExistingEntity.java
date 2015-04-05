package opus.address.commons.persistence;

import opus.address.database.jooq.generated.Tables;

public final class ExistingEntity implements EntityIdProvider {
    private final Long entityId;
    
    public ExistingEntity(final Long entityId) {
        this.entityId = entityId;
    }
    
    public Long getId() { return entityId; }
    
    public opus.address.database.jooq.generated.tables.Entities getTable() {
        return Tables.Entities;
    }
}