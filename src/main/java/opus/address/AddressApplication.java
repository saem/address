package opus.address;

import com.bendb.dropwizard.jooq.JooqBundle;
import com.bendb.dropwizard.jooq.JooqFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.jcabi.manifests.Manifests;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import opus.address.events.server.EventResource;
import opus.address.events.server.OperationResolver;
import opus.address.people.PersonResource;
import opus.address.people.representations.PersonEventOperationWriteRepresentation;
import opus.address.users.UserEventOperationWriteRepresentation;
import opus.address.users.UserResource;
import org.joda.time.DateTimeZone;

import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

public class AddressApplication extends Application<AddressConfiguration> {
    public static final String CODE_VERSION = Optional.ofNullable(
            Manifests.read("Implementation-Build"))
            .orElseThrow(() -> new InvalidCodeVersionException("'Implementation-Build' property was not set."));

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

        // Serialization Configuration
        ObjectMapper objectMapper = environment.getObjectMapper();
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.registerModule(new JSR310Module());

        // @todo move this into separate "module" initialization
        OperationResolver.idMap.put("user.1", UserEventOperationWriteRepresentation.class);
        OperationResolver.idMap.put("person.1", PersonEventOperationWriteRepresentation.class);
        // operationResolver.registerOperation(PersonEventOperationWriteRepresentation.class);

        environment.jersey().register(new UserResource());
        environment.jersey().register(new PersonResource());
        environment.jersey().register(new EventResource());
    }
}

class InvalidCodeVersionException extends RuntimeException {
    public InvalidCodeVersionException(String message) {
        super(message);
    }
}

/*
* An Object Algebra, is an Abstract Algebra -- as in it doesn't do anything, until we make a "Concrete Algebra"
* If we combine an Abstract/Object Algebra with a "Carrier Set", we get a Concrete Algebra
* The Carrier Set defines the actual behaviours of the operations/datatypes that the Abstract/Object algebra is working over

E is known a carrier set

E could be:
    - printing for debugging
    - persisting
*/

interface StoreInsert {}

interface EventOperation {
    List<StoreInsert> getStoreOperations();
}

interface OperationAlgebra<E> {
    CompletableOperationAlgebra<E> add(EventOperation operation);
}

interface CompletableOperationAlgebra<E> extends OperationAlgebra<E> {
    OperationAlgebra<E> complete();
}

// tried a few factories, not sure how to dispatch dynamically such that a specific operation
// will be handled by a specific method, on a specific Writer.
// eg PersonEventOperationWriteRepresentation means we call PersonWriter.write(...)
// Under the current regime we'd have another map from EventOperation to Writers
