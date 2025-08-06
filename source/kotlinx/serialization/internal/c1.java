package kotlinx.serialization.internal;

import kotlinx.serialization.SerializationException;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class c1 implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final c1 f57701a = new c1();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57702b = b1.f57695a;

    /* renamed from: a */
    public Void deserialize(c cVar) {
        throw new SerializationException("'kotlin.Nothing' does not have instances");
    }

    /* renamed from: b */
    public void serialize(d dVar, Void voidR) {
        throw new SerializationException("'kotlin.Nothing' cannot be serialized");
    }

    public f getDescriptor() {
        return f57702b;
    }
}
