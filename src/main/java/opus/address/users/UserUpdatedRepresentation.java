package opus.address.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public final class UserUpdatedRepresentation implements UserActionRepresentation {
    @NotNull
    public final long userId;
    @NotNull
    public final String username;
    @NotNull
    public final String password;
    @NotNull
    public final String email;
    @NotNull
    public final long actorId;

    @JsonCreator
    public UserUpdatedRepresentation(
            @JsonProperty("userId") long userId,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email,
            @JsonProperty("actorId") long actorId
    ) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.actorId = actorId;
    }
}
