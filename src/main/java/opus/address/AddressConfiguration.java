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
    @JsonProperty("database")
    private DataSourceFactory dataSource;

    @Valid
    @JsonProperty("jooq")
    private JooqFactory jooqFactory = new JooqFactory();

    public DataSourceFactory getDataSourceFactory() {
        return dataSource;
    }

    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataSource = dataSourceFactory;
    }

    public JooqFactory getJooqFactory() {
        return jooqFactory;
    }
}
