package opus.address.commons.persistence;

import opus.address.database.jooq.generated.tables.Entity;

import static opus.address.database.jooq.generated.Tables.Entity;

public final class ExistingEntity implements EntityIdProvider {
    private final Long entityId;
    
    public ExistingEntity(final Long entityId) {
        this.entityId = entityId;
    }
    
    public Long getId() { return entityId; }
    
    public Entity getTable() {
        return Entity;
    }
}