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
import opus.address.events.Events;
import opus.address.events.server.EventResource;
import opus.address.events.server.OperationResolver;
import opus.address.people.People;
import opus.address.people.PersonOperationRepresentationMapping;
import opus.address.people.PersonResource;
import opus.address.users.UserOperationRepresentationMapping;
import opus.address.users.Users;
import opus.address.users.representations.UserEventOperationWriteRepresentation;
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

/*
* An Object Algebra, is an Abstract Algebra -- as in it doesn't do anything, until we make a "Concrete Algebra"
* If we combine an Abstract/Object Algebra with a "Carrier Set", we get a Concrete Algebra
* The Carrier Set defines the actual behaviours of the operations/datatypes that the Abstract/Object algebra is working over

E is known a carrier set

E could be:
    - printing for debugging
    - persisting
*/

/*

JSON ->
map to deserialize ->
PersonEventOperationWriteRepresentation:EventOperationWriteRepresentation ->
crazy voodoo ->
PersonWriteEventOperation

JSON ->
Mapper.toRepresentation(String) -> ? extends EventOperationWriteRepresentation ->
PersonEventOperationWriteRepresentation:EventOperationWriteRepresentation ->
Mapper.toEventOperation(? extends EventOperationWriteRepresentation) -> ? extends EventOperation ->
PersonWriteEventOperation

*/

interface StoreInsert {}

interface TypeApplication<C, T> {}

class IdentityTypeApplication<T> implements TypeApplication<IdentityTypeApplication.t, T> {
    public final T value;
    public IdentityTypeApplication(T value) { this.value = value; }
    public static class t {}
    public static <A> IdentityTypeApplication<A> project(TypeApplication<IdentityTypeApplication.t, A> applied) {
        return (IdentityTypeApplication<A>) applied;
    }
}

interface EventOperation<E> extends TypeApplication<EventOperation.type, E> {
    class type {}
    List<StoreInsert> getStoreOperations();
}

interface PersonWriteEventOperation extends EventOperation<PersonWriteEventOperation.type> {
    class type {}
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
