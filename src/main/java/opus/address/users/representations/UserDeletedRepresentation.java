package opus.address.users.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public final class UserDeletedRepresentation extends UserEventWriteRepresentation {
    private static final String EVENT_NAME = "user_deleted";

    @NotNull
    public final Long userId;

    @JsonCreator
    public UserDeletedRepresentation(
            @JsonProperty("userId") final Long userId,
            @JsonProperty("actorId") final Long actorId
    ) {
        super(actorId);
        this.userId = userId;
    }

    @Override
    public String getName() {
        return EVENT_NAME;
    }
}
