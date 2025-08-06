package kotlinx.serialization.internal;

import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class x0 implements b<Long> {

    /* renamed from: a  reason: collision with root package name */
    public static final x0 f57786a = new x0();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57787b = new m1("kotlin.Long", e.g.f57636a);

    /* renamed from: a */
    public Long deserialize(c cVar) {
        return Long.valueOf(cVar.h());
    }

    public void b(d dVar, long j11) {
        dVar.A(j11);
    }

    public f getDescriptor() {
        return f57787b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((Number) obj).longValue());
    }
}
