package opus.address.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public final class UserWriteRepresentation implements UserActionRepresentation {
    @NotNull
    public final String username;
    @NotNull
    public final String password;
    @NotNull
    public final String email;
    @NotNull
    public final long actorId;

    @JsonCreator
    public UserWriteRepresentation(
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email,
            @JsonProperty("actorId") long actorId
    ) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.actorId = actorId;
    }
}
