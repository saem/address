package opus.address.users.writers;

import static opus.address.database.jooq.generated.Tables.Events;
import opus.address.database.jooq.generated.tables.Events;
import opus.address.database.jooq.generated.tables.pojos.EventsProjection;
import org.jooq.DSLContext;

public final class UserWriter {
    private final DSLContext database;

    public UserWriter(DSLContext database) {
        this.database = database;
    }

    public void write(String email, String username, String password, Long actorId) {
        // @todo start a transaction

        database.insertInto(Events,
                Events.Event,
                Events.Version,
                Events.Actor)
                .values("create_user", 1, actorId)
                .returning(Events.Sequence, Events.When)
                .fetchOne();

        // @todo fetch out the sequence and the when (for funsies).
    }
}
