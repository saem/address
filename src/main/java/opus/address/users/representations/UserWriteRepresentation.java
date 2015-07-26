package opus.address.users.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class UserWriteRepresentation {
    public final String username;
    public final String password;
    public final String email;

    @JsonCreator
    public UserWriteRepresentation(
            final @JsonProperty("username") String username,
            final @JsonProperty("password") String password,
            final @JsonProperty("email") String email
    ) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
