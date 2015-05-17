package opus.address.users;

import opus.address.commons.persistence.*;
import opus.address.database.jooq.generated.Tables;

public final class UserWriter {
    private final Persister persister;

    public UserWriter(final Persister persister) {
        this.persister = persister;
    }

    public void write(
            final String email,
            final String username,
            final String password) {
        final EntityOperation entity = new EntityOperation();
        final UserEntityTypeOperation userEntity = new UserEntityTypeOperation(entity);

        persister.addOperation(userEntity)
                .addOperation(new StringFactOperation(entity, Tables.UsersFactsPassword.UserId, Tables.UsersFactsPassword.Password, password))
                .addOperation(new StringFactOperation(entity, Tables.UsersFactsEmail.UserId, Tables.UsersFactsEmail.Email, email))
                .addOperation(new StringFactOperation(entity, Tables.UsersFactsUsername.UserId, Tables.UsersFactsUsername.Username, username))
        ;
    }

    public void update(
            final long userId,
            final String email,
            final String username,
            final String password
    ) {
        final ExistingEntity entity = new ExistingEntity(userId);

        persister.addOperation(new StringFactOperation(entity, Tables.UsersFactsPassword.UserId, Tables.UsersFactsPassword.Password, password))
                .addOperation(new StringFactOperation(entity, Tables.UsersFactsEmail.UserId, Tables.UsersFactsEmail.Email, email))
                .addOperation(new StringFactOperation(entity, Tables.UsersFactsUsername.UserId, Tables.UsersFactsUsername.Username, username))
        ;
    }

    public void delete(
            final long userId
    ) {
        final ExistingEntity entity = new ExistingEntity(userId);

        persister.addOperation(new BooleanFactOperation(entity, Tables.UsersFactsIsDeleted.UserId, Tables.UsersFactsIsDeleted.IsDeleted, true))
        ;
    }
}

