package kotlinx.serialization.modules;

import kotlin.reflect.c;

final class SerializerAlreadyRegisteredException extends IllegalArgumentException {
    public SerializerAlreadyRegisteredException(String str) {
        super(str);
    }

    public SerializerAlreadyRegisteredException(c<?> cVar, c<?> cVar2) {
        this("Serializer for " + cVar2 + " already registered in the scope of " + cVar);
    }
}
