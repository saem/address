package opus.address.users.representations;

public final class UserStateReadRepresentation {
    public final Long sequence;
    public final Long userId;
    public final String username;
    public final String email;
    public final Boolean deleted;
    public final Boolean disabled;
    public final long actorId;

    public UserStateReadRepresentation(
            final Long sequence, 
            final Long userId, 
            final String username, 
            final String email, 
            final Boolean deleted, 
            final Boolean disabled,
            final long actorId
    ) {
        this.sequence = sequence;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.deleted = deleted;
        this.disabled = disabled;
        this.actorId = actorId;
    }
}
