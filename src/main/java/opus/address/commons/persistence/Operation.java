package opus.address.commons.persistence;

import opus.address.database.jooq.generated.tables.records.EventRecord;
import org.jooq.DSLContext;
import org.jooq.Insert;

interface Operation extends TableBacked {
    Insert getQuery(DSLContext db, final EventRecord event);
}
