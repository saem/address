package opus.address.users;

public final class UserFactProjection {
    public final Long sequence;
    public final Long userId;
    public final String username;
    public final String email;
    public final Boolean isDisabled;
    public final Boolean isDeleted;
    public final String password;
    public final long actorId;

    public UserFactProjection(
            final Long sequence,
            final Long userId,
            final String username,
            final String email,
            final Boolean isDisabled,
            final Boolean isDeleted,
            final String password,
            final long actorId
    ) {
        this.sequence = sequence;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.isDisabled = isDisabled;
        this.isDeleted = isDeleted;
        this.password = password;
        this.actorId = actorId;
    }
}
