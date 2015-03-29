package opus.address.users;

import opus.address.commons.persistence.EntityOperation;
import opus.address.commons.persistence.EntityTypeOperation;
import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.Users;
import opus.address.database.jooq.generated.tables.records.Events;
import org.jooq.DSLContext;
import org.jooq.Insert;

public final class UserEntityTypeOperation extends EntityTypeOperation {
    UserEntityTypeOperation(final EntityOperation entity) {
        super(entity);
    }

    @Override
    public Insert getQuery(final DSLContext db, final Events event) {
        return db.insertInto(Tables.Users,
                Tables.Users.EntityId)
                .values(entity.getId());
    }
    
    public Users getTable() { return Tables.Users; }
}
