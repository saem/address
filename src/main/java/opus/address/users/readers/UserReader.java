package opus.address.users.readers;

import opus.address.database.jooq.generated.tables.UserStates;
import opus.address.database.jooq.generated.tables.pojos.UserStatesProjection;
import org.jooq.DSLContext;

import java.util.List;

public final class UserReader {
    private final DSLContext database;
    public final static Integer USER_HISTORY_LIMIT = 50;
    
    public UserReader(DSLContext database) {
        this.database = database;
    }
    
    public List<UserStatesProjection> getUserHistory(
            Long userId,
            Integer numberOfRecords,
            Integer offset
    ) {
        return database.select()
                .from(UserStates.UserStates)
                .where(UserStates.UserStates.UserId.equal(userId))
                .orderBy(UserStates.UserStates.Sequence.desc())
                .limit(Math.min(numberOfRecords, USER_HISTORY_LIMIT))
                .offset(offset)
                .fetchInto(UserStatesProjection.class);
    }
}
