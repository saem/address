package opus.address.commons.persistence;

import org.jooq.Table;

public interface EntityIdProvider extends TableBacked {
    public Long getId();
}
