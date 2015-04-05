package opus.address.commons.persistence;

import opus.address.database.jooq.generated.tables.records.Events;
import org.jooq.DSLContext;
import org.jooq.Insert;
import org.jooq.InsertResultStep;
import org.jooq.Table;

interface Operation extends TableBacked {
    public Insert getQuery(DSLContext db, final Events event);
}
