package opus.address.events.server;

import io.dropwizard.jersey.params.IntParam;
import io.dropwizard.jersey.params.LongParam;
import opus.address.database.jooq.generated.Tables;
import opus.address.events.representations.EventReadRepresentation;
import org.jooq.DSLContext;
import org.jooq.Record7;
import org.jooq.Record8;
import org.jooq.SelectOnConditionStep;
import org.jooq.impl.DSL;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
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
        final Optional<EventProjection> event =
                new EventProvider(database).find(eventId.get());

        return event.map(this::mapEventToRead)
                .orElseThrow(() -> new WebApplicationException(Response.Status.NOT_FOUND));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EventReadRepresentation> getEvents(
            final @QueryParam("offset") @DefaultValue("0") IntParam offset,
            final @Context DSLContext database
    ) {
        final List<EventProjection> events = new EventProvider(database)
                .findAll(offset.get());

        return events.stream().map(this::mapEventToRead).collect(Collectors.toList());
    }

    private EventReadRepresentation mapEventToRead(final EventProjection projection) {
        return new EventReadRepresentation(
                projection.sequence,
                projection.event,
                projection.codeVersion,
                projection.actorId,
                Arrays.asList(projection.tablesAffected.split(",")),
                projection.when,
                projection.actorType
        );
    }
}

final class EventProvider {
    private static final int MAX_FETCH = 1000;
    private static final String ACTOR_TYPE = "actorType";
    private final DSLContext database;

    public EventProvider(final DSLContext database) {
        this.database = database;
    }

    public Optional<EventProjection> find(
            final long eventId
    ) {
        return queryBuilder()
                .where(Tables.Event.Sequence.eq(eventId))
                .limit(1)
                .fetch()
                .map(this::map)
                .stream()
                .findFirst();
    }

    public List<EventProjection> findAll(final int startFrom) {
        return queryBuilder()
                .limit(startFrom, MAX_FETCH)
                .fetch()
                .map(this::map);
    }

    private
    SelectOnConditionStep<Record7<Long, String, String, Long, String, Timestamp, String>>
    queryBuilder() {
        return database.select(
                Tables.Event.Sequence,
                Tables.Event.EventName,
                Tables.Event.CodeVersion,
                Tables.Event.Actor,
                Tables.Event.TablesAffected,
                Tables.Event.When,
                DSL.decode().when(Tables.System.EntityId.isNotNull(), ActorType.SYSTEM.name())
                        .otherwise(ActorType.USER.name())
                        .as(ACTOR_TYPE)
        )
                .from(Tables.Event)
                .leftOuterJoin(Tables.System).on(
                        Tables.Event.Actor
                                .eq(
                                        Tables.System.EntityId
                                )
                )
                .leftOuterJoin(Tables.User).on(
                        Tables.Event.Actor
                                .eq(
                                        Tables.User.EntityId
                                )
                );

    }
    
    private EventProjection map(
            final Record7<Long, String, String, Long, String, Timestamp, String> record
    ) {
        return new EventProjection(
                record.value1(),
                record.value2(),
                record.value3(),
                record.value4(),
                record.value5(),
                ZonedDateTime.ofInstant(record.value6().toInstant(), ZoneOffset.UTC),
                ActorType.valueOf(record.value7())
        );
    }
}

final class EventProjection {
    public final long sequence;
    public final String event;
    public final String codeVersion;
    public final long actorId;
    public final String tablesAffected;
    public final ZonedDateTime when;
    public final ActorType actorType;

    public EventProjection(
            final long sequence,
            final String event,
            final String codeVersion,
            final long actorId,
            final String tablesAffected,
            final ZonedDateTime when,
            final ActorType actorType
    ) {
        this.sequence = sequence;
        this.event = event;
        this.codeVersion = codeVersion;
        this.actorId = actorId;
        this.tablesAffected = tablesAffected;
        this.when = when;
        this.actorType = actorType;
    }
}
