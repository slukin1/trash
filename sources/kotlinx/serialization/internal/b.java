package kotlinx.serialization.internal;

import kotlin.KotlinNothingValueException;
import kotlin.reflect.c;
import kotlinx.serialization.SerializationException;

public final class b {
    public static final Void a(String str, c<?> cVar) {
        String str2;
        String str3 = "in the scope of '" + cVar.f() + '\'';
        if (str == null) {
            str2 = "Class discriminator was missing and no default polymorphic serializers were registered " + str3;
        } else {
            str2 = "Class '" + str + "' is not registered for polymorphic serialization " + str3 + ".\nTo be registered automatically, class '" + str + "' has to be '@Serializable', and the base class '" + cVar.f() + "' has to be sealed and '@Serializable'.\nAlternatively, register the serializer for '" + str + "' explicitly in a corresponding SerializersModule.";
        }
        throw new SerializationException(str2);
    }

    public static final Void b(c<?> cVar, c<?> cVar2) {
        String f11 = cVar.f();
        if (f11 == null) {
            f11 = String.valueOf(cVar);
        }
        a(f11, cVar2);
        throw new KotlinNothingValueException();
    }
}
