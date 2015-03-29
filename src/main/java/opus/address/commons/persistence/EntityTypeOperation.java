package opus.address.commons.persistence;

public abstract class EntityTypeOperation implements Operation {
    protected final EntityOperation entity;

    public EntityTypeOperation(final EntityOperation entity) {
        this.entity = entity;
    }
}
