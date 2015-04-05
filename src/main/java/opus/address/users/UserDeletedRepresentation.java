package opus.address.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public final class UserDeletedRepresentation implements UserActionRepresentation {
    @NotNull
    public final Long userId;
    
    @NotNull
    public final Long actorId;

    @JsonCreator
    public UserDeletedRepresentation(
            @JsonProperty("userId") final Long userId,
            @JsonProperty("actorId") final Long actorId
    ) {
        this.userId = userId;
        this.actorId = actorId;
    }
}
