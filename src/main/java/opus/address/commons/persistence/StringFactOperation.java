package opus.address.commons.persistence;

import opus.address.database.jooq.generated.tables.records.EventRecord;
import org.jooq.DSLContext;
import org.jooq.Insert;
import org.jooq.Record;
import org.jooq.TableField;
import org.jooq.impl.DSL;

public final class StringFactOperation extends FactOperation<String> {
    public StringFactOperation(
            final EntityIdProvider entity,
            final TableField<? extends Record, Long> entityField,
            final TableField<? extends Record, String> field,
            final String value
    ) {
        super(entity, entityField, field, value);
    }

    @Override
    @SuppressWarnings("unchecked")
    // We know the table field type, so therefore the field and value must match
    public Insert getQuery(DSLContext db, final EventRecord event) {
        return db.insertInto(getTable(), getField(), DSL.fieldByName(Long.class, "sequence"), entityField)
                .values(value, event.sequence(), entity.getId());
    }
}
