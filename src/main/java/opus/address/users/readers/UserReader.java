package opus.address.users.readers;

import opus.address.database.jooq.generated.tables.Events;
import opus.address.database.jooq.generated.tables.UsersFactsEmail;
import opus.address.database.jooq.generated.tables.UsersFactsIsDeleted;
import opus.address.database.jooq.generated.tables.UsersFactsUsername;
import opus.address.users.projections.UserFactProjection;
import org.jooq.DSLContext;

import java.util.List;

public final class UserReader {
    private final DSLContext database;
    public final static Integer USER_HISTORY_LIMIT = 50;
    
    public UserReader(DSLContext database) {
        this.database = database;
    }
    
//    public List<UserFactProjection> getUserHistory(
//            Long userId,
//            Integer numberOfRecords,
//            Integer offset
//    ) {
//        return database.select(
//                UsersFactsEmail.Email,
//                UsersFactsIsDeleted.IsDeleted,
//                UsersFactsUsername.Username,
//
//                UserFacts.UserFacts.IsDisabled,
//                UserFacts.UserFacts.UserId,
//                UserFacts.UserFacts.Password,
//                Events.Events.Actor
//        )
//                .from(UserFacts.UserFacts)
//                .leftOuterJoin(Events.Events).on(Events.Events.Sequence.equal(UserFacts.UserFacts.Sequence))
//                .where(UserFacts.UserFacts.UserId.equal(userId))
//                .orderBy(UserFacts.UserFacts.Sequence.desc())
//                .limit(Math.min(numberOfRecords, USER_HISTORY_LIMIT))
//                .offset(offset)
//                .fetch()
//                .map(r -> new UserFactProjection(
//                        r.value4(),
//                        r.value6(),
//                        r.value3(),
//                        r.value1(),
//                        r.value5(),
//                        r.value2(),
//                        r.value7(),
//                        r.value8()
//                ));
//    }
}
