package opus.address.commons.http;

import opus.address.commons.EventLogged;
import opus.address.commons.Try;
import org.jooq.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.sql.SQLException;

public final class Https {
    private static final Logger LOGGER = LoggerFactory.getLogger(Https.class);
    public static Response mapEventToResponse(final Try<? extends EventLogged> event) {
        return event.map(u ->
                Response.created(
                        UriBuilder
                                .fromPath("/events/{sequenceId}")
                                .build(u.getSequence()))
                        .build())
                .orElseGet(f -> {
                    LOGGER.debug("SQL Exception", f.getException());
                    if (f.getException().getCause() instanceof DataAccessException) {
                        if( f.getException().getCause().getCause() instanceof SQLException) {}
                        for (Throwable e:((SQLException) f.getException().getCause().getCause())) {
                            if (e instanceof SQLException && ((SQLException) e).getSQLState().equals("23503")) {
                                return Response.status(Response.Status.NOT_FOUND).build();
                            }
                        }
                    }
                    
                    return Response.serverError().build();
                });
    }
}
