package opus.address.events.server;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import com.fasterxml.jackson.databind.type.TypeFactory;
import opus.address.events.representations.EventOperationWriteRepresentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class OperationResolver extends TypeIdResolverBase {
    private JavaType baseType;
    public final static OperationRepresentationMap idMap = new OperationRepresentationMap() {
        private final Map<String, OperationRepresentationMapping> representationMap =
                new HashMap<>();

        private final Map<Class<? extends EventOperationWriteRepresentation>, OperationRepresentationMapping> operationMap =
                new HashMap<>();

        @Override
        public void register(final OperationRepresentationMapping mapping) {
            representationMap.put(mapping.getName(), mapping);
        }

        @Override
        @SuppressWarnings("unchecked")
        public Class<? extends EventOperationWriteRepresentation> toRepresentation(final String string) {
            return representationMap.get(string).toRepresentationType();
        }

        @Override
        public EventOperation toEventOperation(final EventOperationWriteRepresentation op) {
            return operationMap.get(op.getClass()).toOperation();
        }
    };

    @Override
    public void init(final JavaType baseType) {
        this.baseType = baseType;
    }

    @Override
    public String idFromValue(final Object value) {
        return idFromValueAndType(value, value.getClass());
    }

    @Override
    public String idFromValueAndType(final Object value, final Class<?> suggestedType) {
        if (value instanceof EventOperationWriteRepresentation) {
            final EventOperationWriteRepresentation eventOp = (EventOperationWriteRepresentation) value;
            return eventOp.getName();
        }
        throw new IllegalStateException("Class " + suggestedType.getName() + " is not an operation");
    }

    @Override
    public JavaType typeFromId(DatabindContext context, String id) {
        return TypeFactory.defaultInstance().constructSpecializedType(
                baseType,
                Optional.ofNullable(idMap.toRepresentation(id))
                        .orElseThrow(() -> new IllegalStateException("No type registered for name " + id))
        );
    }

    @Override
    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CUSTOM;
    }
}