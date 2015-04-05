package opus.address.commons.persistence;

public abstract class EntityTypeOperation implements Operation, EntityIdProvider {
    protected final EntityOperation entity;

    public EntityTypeOperation(final EntityOperation entity) {
        this.entity = entity;
    }
    
    public Long getId() { return entity.getId(); }
}
