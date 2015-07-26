package opus.address.commons.persistence;

import opus.address.database.jooq.generated.tables.records.EventRecord;

import java.util.List;
import java.util.Map;

public final class EventReport {
    public final EventRecord event;
    public final Map<String, List<Long>> entitiesAffected;

    public EventReport(final EventRecord event, final Map<String, List<Long>> entitiesAffected) {
        this.event = event;
        this.entitiesAffected = entitiesAffected;
    }
}
