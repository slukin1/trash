package kotlinx.serialization.internal;

import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class u1 implements b<Short> {

    /* renamed from: a  reason: collision with root package name */
    public static final u1 f57773a = new u1();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57774b = new m1("kotlin.Short", e.h.f57637a);

    /* renamed from: a */
    public Short deserialize(c cVar) {
        return Short.valueOf(cVar.m());
    }

    public void b(d dVar, short s11) {
        dVar.k(s11);
    }

    public f getDescriptor() {
        return f57774b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((Number) obj).shortValue());
    }
}
