package opus.address.commons.persistence;

import opus.address.database.jooq.generated.Tables;
import opus.address.database.jooq.generated.tables.records.Entities;
import opus.address.database.jooq.generated.tables.records.Events;
import org.jooq.*;
import org.jooq.conf.ParamType;
import org.jooq.exception.DataAccessException;
import org.jooq.exception.DataTypeException;

import java.util.List;
import java.util.Map;

public final class ExistingEntityOperation implements Operation {
    private final Long entityId;
    
    public ExistingEntityOperation(final Long entityId) {
        this.entityId = entityId;
    }
    
    @Override
    public InsertResultStep<Entities> getQuery(
            final DSLContext db,
            final Events event) {
        final Entities entity = new Entities();
        entity.entityId(entityId);
        return new NoOpInsertResultStep(entity);
    }

    public void setId(Long id) {}
    public Long getId() { return entityId; }
    
    public opus.address.database.jooq.generated.tables.Entities getTable() {
        return Tables.Entities;
    }
}

final class NoOpInsertResultStep implements  InsertResultStep {

    private final Entities entity;

    public NoOpInsertResultStep(final Entities entity) {
        this.entity = entity;
        
    }

    @Override
    public Result fetch() throws DataAccessException {
        return null;
    }

    @Override
    public Record fetchOne() throws DataAccessException {
        return entity;
    }

    @Override
    public int execute() throws DataAccessException {
        return 0;
    }

    @Override
    public boolean isExecutable() {
        return false;
    }

    @Override
    public String getSQL() {
        return null;
    }

    @Override
    public String getSQL(final boolean inline) {
        return null;
    }

    @Override
    public String getSQL(final ParamType paramType) {
        return null;
    }

    @Override
    public List<Object> getBindValues() {
        return null;
    }

    @Override
    public Map<String, Param<?>> getParams() {
        return null;
    }

    @Override
    public Param<?> getParam(final String name) {
        return null;
    }

    @Override
    public Query bind(final String param, final Object value) throws IllegalArgumentException, DataTypeException {
        return null;
    }

    @Override
    public Query bind(final int index, final Object value) throws IllegalArgumentException, DataTypeException {
        return null;
    }

    @Override
    public Query queryTimeout(final int timeout) {
        return null;
    }

    @Override
    public Query keepStatement(final boolean keepStatement) {
        return null;
    }

    @Override
    public void close() throws DataAccessException {

    }

    @Override
    public void cancel() throws DataAccessException {

    }

    @Override
    public void attach(final Configuration configuration) {

    }

    @Override
    public void detach() {

    }
}