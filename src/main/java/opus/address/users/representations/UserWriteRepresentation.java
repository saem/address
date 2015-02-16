package opus.address.users.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public final class UserWriteRepresentation {
    @NotNull
    public final String username;
    @NotNull
    public final String password;
    @NotNull
    public final String email;
    public final Boolean isDisabled;

    @JsonCreator
    public UserWriteRepresentation(
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email,
            @JsonProperty("isDisabled") Boolean isDisabled
    ) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isDisabled = isDisabled == null ? false : isDisabled;
    }
}
