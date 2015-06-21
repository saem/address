package opus.address.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import io.dropwizard.jackson.Jackson;
import opus.address.events.representations.EventOperationsWriteRepresentation;
import opus.address.events.server.EventResource;
import opus.address.events.server.OperationResolver;
import opus.address.people.representations.PersonEventOperationWriteRepresentation;
import opus.address.users.UserEventOperationWriteRepresentation;
import org.joda.time.DateTimeZone;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.TimeZone;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public final class EventResourceTest {
    private static final ObjectMapper objectMapper = Jackson.newObjectMapper();
    private static final EventResource eventResource = new EventResource();

    @BeforeClass
    public static void setup() {
        // Set Joda Time Zone to UTC
        DateTimeZone.setDefault(DateTimeZone.UTC);
        // Set Java Time Zone to UTC
        TimeZone.setDefault(DateTimeZone.UTC.toTimeZone());

        // Serialization Configuration
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JSR310Module());

        // @todo move this into separate "module" initialization
        OperationResolver.idMap.put("user.1", UserEventOperationWriteRepresentation.class);
        OperationResolver.idMap.put("person.1", PersonEventOperationWriteRepresentation.class);
        // operationResolver.registerOperation(PersonEventOperationWriteRepresentation.class);
    }

    @Test
    public void postEventsTest() throws Exception {
        final Response response = eventResource.postEvents(
                objectMapper.readValue(
                        fixture("fixtures/json/events/post_events.json"),
                        EventOperationsWriteRepresentation.class
                )
        );
        assertThat(response.getStatus()).isEqualTo(201);
    }
}
