package kotlinx.serialization;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.encoding.a;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.b;

public final class d {
    public static final <T> a<T> a(AbstractPolymorphicSerializer<T> abstractPolymorphicSerializer, a aVar, String str) {
        a<T> c11 = abstractPolymorphicSerializer.c(aVar, str);
        if (c11 != null) {
            return c11;
        }
        b.a(str, abstractPolymorphicSerializer.e());
        throw new KotlinNothingValueException();
    }

    public static final <T> g<T> b(AbstractPolymorphicSerializer<T> abstractPolymorphicSerializer, kotlinx.serialization.encoding.d dVar, T t11) {
        g<T> d11 = abstractPolymorphicSerializer.d(dVar, t11);
        if (d11 != null) {
            return d11;
        }
        b.b(Reflection.b(t11.getClass()), abstractPolymorphicSerializer.e());
        throw new KotlinNothingValueException();
    }
}
