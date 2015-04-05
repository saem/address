package opus.address.commons.http;

import opus.address.commons.Event;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.Optional;

public final class Https {
    public static Response mapEventToResponse(final Optional<? extends Event> event) {
        return event.map(u ->
                Response.created(
                        UriBuilder
                                .fromPath("/events/{sequenceId}")
                                .build(u.getSequence()))
                        .build())
                .orElseGet(() -> Response.serverError().build());
    }
}
