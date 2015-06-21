package opus.address.users.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public final class UserUpdatedRepresentation extends UserEventWriteRepresentation {
    private static final String EVENT_NAME = "user_updated";

    @NotNull
    public final long userId;
    @NotNull
    public final String username;
    @NotNull
    public final String password;
    @NotNull
    public final String email;

    @JsonCreator
    public UserUpdatedRepresentation(
            @JsonProperty("userId") long userId,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email,
            @JsonProperty("actorId") long actorId
    ) {
        super(actorId);
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String getName() {
        return EVENT_NAME;
    }
}
