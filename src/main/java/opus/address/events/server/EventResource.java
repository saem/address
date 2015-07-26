package opus.address.events.server;

import io.dropwizard.jersey.params.LongParam;
import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.Event;
import opus.address.database.jooq.generated.tables.pojos.EventProjection;
import opus.address.events.representations.EventReadRepresentation;
import org.jooq.DSLContext;
import org.jooq.Record6;
import org.jooq.SelectJoinStep;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/events")
public final class EventResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{eventId}")
    public EventReadRepresentation getEvent(
            final @PathParam("eventId") LongParam eventId,
            final @Context DSLContext database
    ) {
        return EventReader.build(database)
                .find(eventId.get())
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EventReadRepresentation> getEvents(
            final @QueryParam("last_event_id") @DefaultValue("0") LongParam lastEventId,
            final @Context DSLContext database
    ) {
        return EventReader.build(database).findAll(lastEventId.get());
    }
}

final class EventReader {
    private final EventProvider provider;

    public static EventReader build(final DSLContext db) {
        return new EventReader(new EventProvider(db));
    }

    public Optional<EventReadRepresentation> find(final long eventId) {
        return provider.find(eventId).map(this::mapEventToRead);
    }

    public List<EventReadRepresentation> findAll(final long lastEventId) {
        return provider
                .findAll(lastEventId)
                .stream()
                .map(this::mapEventToRead)
                .collect(Collectors.toList());
    }

    private EventReader(EventProvider provider) {
        this.provider = provider;
    }

    private EventReadRepresentation mapEventToRead(final EventProjection projection) {
        return new EventReadRepresentation(
                projection.sequence(),
                projection.eventName(),
                projection.codeVersion(),
                projection.actor(),
                Arrays.asList(projection.tablesAffected().split(",")),
                projection.when().toInstant()
        );
    }
}

final class EventProvider {
    private static final int MAX_FETCH = 1000;
    private final DSLContext database;

    public EventProvider(final DSLContext database) {
        this.database = database;
    }

    public Optional<EventProjection> find(
            final long eventId
    ) {
        return Optional.ofNullable(
                queryBuilder()
                        .where(Tables.Event.Sequence.eq(eventId))
                        .limit(1)
                        .fetchOneInto(EventProjection.class)
        );
    }

    public List<EventProjection> findAll(final long startFrom) {
        return queryBuilder()
                .where(Event.Event.Sequence.gt(startFrom))
                .limit(MAX_FETCH)
                .fetchInto(EventProjection.class);
    }

    private SelectJoinStep<Record6<Long, String, String, Long, String, Timestamp>>
    queryBuilder() {
        return database.select(
                Tables.Event.Sequence,
                Tables.Event.EventName,
                Tables.Event.CodeVersion,
                Tables.Event.Actor,
                Tables.Event.TablesAffected,
                Tables.Event.When)
                .from(Tables.Event);

    }
}