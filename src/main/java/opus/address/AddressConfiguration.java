package opus.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AddressConfiguration extends Configuration {
    @Valid
    @NotNull
    private DataSourceFactory dataSource;
    
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSource;
    }

    @JsonProperty("database")
    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
        this.dataSource = dataSourceFactory;
    }
}
