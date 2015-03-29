package opus.address.commons.persistence;

import opus.address.database.jooq.generated.tables.records.Events;
import org.jooq.*;
import org.jooq.impl.DSL;

public final class StringFactOperation extends FactOperation<String> {
    public StringFactOperation(
            final EntityOperation entity,
            final TableField<? extends Record, Long> entityField,
            final TableField<? extends Record, String> field,
            final String value
    ) {
        super(entity, entityField, field, value);
    }

    @Override
    @SuppressWarnings("unchecked")
    // We know the table field type, so therefore the field and value must match
    public Insert getQuery(DSLContext db, final Events event) {
        // @todo this is seriously busted because it doesn't save the entity id or event sequence
        return db.insertInto(getTable(), getField(), DSL.fieldByName(Long.class, "sequence"), entityField)
                .values(value, event.sequence(), entity.getId());
    }
}
