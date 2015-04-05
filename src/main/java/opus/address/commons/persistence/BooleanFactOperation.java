package opus.address.commons.persistence;

import opus.address.database.jooq.generated.tables.records.Events;
import org.jooq.DSLContext;
import org.jooq.Insert;
import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.DSL;

public final class BooleanFactOperation extends FactOperation<Boolean> {
    public BooleanFactOperation(
            final EntityIdProvider entity,
            final TableField<? extends Record, Long> entityField,
            final TableField<? extends Record, Boolean> field,
            final Boolean value
    ) {
        super(entity, entityField, field, value);
    }

    @Override
    @SuppressWarnings("unchecked")
    // We know the table field type, so therefore the field and value must match
    public Insert getQuery(DSLContext db, final Events event) {
        return db.insertInto(getTable(), getField(), DSL.fieldByName(Long.class, "sequence"), entityField)
                .values(value, event.sequence(), entity.getId());
    }
}
