package opus.address.users;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import opus.address.users.UserActionRepresentation;
import opus.address.users.UserDeleteRepresentation;
import opus.address.users.UserWriteRepresentation;

import java.io.IOException;

public final class UserActionRepresentationDeserializer extends StdDeserializer<UserActionRepresentation> {

    public UserActionRepresentationDeserializer() {
        super(UserActionRepresentation.class);
    }

    public SimpleModule getModule()
    {
        final SimpleModule companyModule =
                new SimpleModule("PolymorphicUserActionDeserializerModule",
                        new Version(1, 0, 0, null, null, null));
        companyModule.addDeserializer(UserActionRepresentation.class, this);

        return companyModule;
    }

    @Override
    public UserActionRepresentation deserialize(
            JsonParser jp, 
            DeserializationContext deserializationContext
    ) throws IOException {
        final ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        final JsonNode root = mapper.readTree(jp);

        if(root == null) {
            return null;
        }

        final Class<? extends UserActionRepresentation> userActionClass;

        if (root.has("isDeleted")) {
            userActionClass = UserDeleteRepresentation.class;
        } else if (root.has("isDisabled")) {
            userActionClass = UserDeleteRepresentation.class;
        } else {
            userActionClass = UserWriteRepresentation.class;
        }

        return mapper.readValue(
                root.traverse(),
                userActionClass
        );
    }
}
