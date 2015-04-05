package opus.address;

import com.bendb.dropwizard.jooq.JooqBundle;
import com.bendb.dropwizard.jooq.JooqFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jcabi.manifests.Manifests;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import opus.address.people.PersonResource;
import opus.address.users.UserResource;
import org.joda.time.DateTimeZone;

import java.util.Optional;
import java.util.TimeZone;

public class AddressApplication extends Application<AddressConfiguration> {
    private final JooqBundle<AddressConfiguration> jooq = new JooqBundle<AddressConfiguration>() {
        @Override
        public DataSourceFactory getDataSourceFactory(AddressConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }

        @Override
        public JooqFactory getJooqFactory(AddressConfiguration configuration) {
            return configuration.getJooqFactory();
        }
    };

    public static void main(String[] args) throws Exception {
        new AddressApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<AddressConfiguration> bootstrap) {
        bootstrap.addBundle(this.jooq);
        bootstrap.addBundle(new MigrationsBundle<AddressConfiguration>() {

            @Override
            public DataSourceFactory getDataSourceFactory(AddressConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(AddressConfiguration cfg, Environment environment) throws Exception {
        // Set Joda Time Zone to UTC
        DateTimeZone.setDefault(DateTimeZone.UTC);
        // Set Java Time Zone to UTC
        TimeZone.setDefault(DateTimeZone.UTC.toTimeZone());

        final String codeVersion = Optional.ofNullable(
                Manifests.read("Implementation-Build"))
                .orElseThrow(() -> new InvalidCodeVersionException("'Implementation-Build' property was not set."));

        // Serialization Configuration
        ObjectMapper objectMapper = environment.getObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        environment.jersey().register(UserResource.build(codeVersion));
        environment.jersey().register(PersonResource.build(codeVersion));
    }
}

class InvalidCodeVersionException extends RuntimeException {
    public InvalidCodeVersionException(String message) {
        super(message);
    }
}