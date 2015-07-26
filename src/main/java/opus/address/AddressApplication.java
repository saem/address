package opus.address;

import com.bendb.dropwizard.jooq.JooqBundle;
import com.bendb.dropwizard.jooq.JooqFactory;
import com.bendb.dropwizard.jooq.JooqHealthCheck;
import com.bendb.dropwizard.jooq.jersey.JooqBinder;
import com.bendb.dropwizard.jooq.jersey.LoggingDataAccessExceptionMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.jcabi.manifests.Manifests;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import opus.address.events.Events;
import opus.address.people.People;
import opus.address.users.Users;
import org.joda.time.DateTimeZone;
import org.jooq.Configuration;

import java.util.Optional;
import java.util.TimeZone;

public class AddressApplication extends Application<AddressConfiguration> {
    public static final String CODE_VERSION = Optional.ofNullable(
            Manifests.read("Implementation-Build"))
            .orElseThrow(() -> new InvalidCodeVersionException("'Implementation-Build' property was not set."));

    private final JooqBundle<AddressConfiguration> jooqEvent = new JooqBundle<AddressConfiguration>() {
        @Override
        public DataSourceFactory getDataSourceFactory(AddressConfiguration configuration) {
            return configuration.getEventDataSourceFactory();
        }
    };

    public static void main(String[] args) throws Exception {
        new AddressApplication().run(args);
    }

    private final JooqBundle<AddressConfiguration> jooqViews = new JooqBundle<AddressConfiguration>() {
        @Override
        public DataSourceFactory getDataSourceFactory(final AddressConfiguration configuration) {
            return configuration.getViewDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<AddressConfiguration> bootstrap) {
        bootstrap.addBundle(this.jooqEvent);
        bootstrap.addBundle(new MigrationsBundle<AddressConfiguration>() {

            @Override
            public DataSourceFactory getDataSourceFactory(AddressConfiguration configuration) {
                return configuration.getEventDataSourceFactory();
            }
        });
    }

    @Override
    public void run(AddressConfiguration cfg, Environment environment) throws Exception {
        // Set Joda Time Zone to UTC
        DateTimeZone.setDefault(DateTimeZone.UTC);
        // Set Java Time Zone to UTC
        TimeZone.setDefault(DateTimeZone.UTC.toTimeZone());

        // Serialization Configuration
        ObjectMapper objectMapper = environment.getObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JSR310Module());

        Users.register(environment);
        People.register(environment);
        Events.register(environment);
    }
}

class InvalidCodeVersionException extends RuntimeException {
    public InvalidCodeVersionException(String message) {
        super(message);
    }
}
