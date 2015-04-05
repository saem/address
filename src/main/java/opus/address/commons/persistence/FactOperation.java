package opus.address.commons.persistence;

import org.jooq.Record;
import org.jooq.Table;
import org.jooq.TableField;

public abstract class FactOperation<V> implements Operation {
    protected final EntityIdProvider entity;
    protected final V value;
    protected final TableField<? extends Record, Long> entityField;
    private final TableField<? extends Record, V> field;

    protected FactOperation(
            final EntityIdProvider entity,
            final TableField<? extends Record, Long>  entityField,
            final TableField<? extends Record, V> field,
            final V value
    ) {
        this.entity = entity;
        this.entityField = entityField;
        this.field = field;
        this.value = value;
    }
    
    public Table getTable() {
        return field.getTable();
    }
    
    protected TableField<? extends Record, V> getField() {
        return field;
    }
}
