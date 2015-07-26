package opus.address;

import com.bendb.dropwizard.jooq.JooqFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AddressConfiguration extends Configuration {
    @Valid
    @NotNull
    @JsonProperty("event_database")
    private DataSourceFactory eventDataSourceFactory;

    @Valid
    @NotNull
    @JsonProperty("view_database")
    private DataSourceFactory viewDataSourceFactory;

    @Valid
    @JsonProperty("jooq")
    private JooqFactory jooqFactory = new JooqFactory();

    public DataSourceFactory getEventDataSourceFactory() {
        return eventDataSourceFactory;
    }

    public void setEventDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.eventDataSourceFactory = dataSourceFactory;
    }

    public DataSourceFactory getViewDataSourceFactory() {
        return viewDataSourceFactory;
    }

    public void setViewDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.viewDataSourceFactory = dataSourceFactory;
    }

    public JooqFactory getJooqFactory() {
        return jooqFactory;
    }
}
