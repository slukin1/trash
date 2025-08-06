package kotlinx.serialization.json.internal;

import kotlinx.serialization.SerializationException;

public class JsonException extends SerializationException {
    public JsonException(String str) {
        super(str);
    }
}
