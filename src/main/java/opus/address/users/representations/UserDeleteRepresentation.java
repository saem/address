package opus.address.users.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.DefaultValue;

public final class UserDeleteRepresentation implements UserActionRepresentation {
    public final Boolean isDisabled;
    public final Boolean isDeleted;

    @JsonCreator
    public UserDeleteRepresentation(
            @JsonProperty("isDisabled") @DefaultValue("false") final Boolean isDisabled,
            @JsonProperty("isDeleted") @DefaultValue("false") final Boolean isDeleted
    ) {
        this.isDisabled = isDisabled;
        this.isDeleted = isDeleted;
    }
}
