package kotlinx.serialization.internal;

import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class x implements b<Double> {

    /* renamed from: a  reason: collision with root package name */
    public static final x f57784a = new x();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57785b = new m1("kotlin.Double", e.d.f57633a);

    /* renamed from: a */
    public Double deserialize(c cVar) {
        return Double.valueOf(cVar.n());
    }

    public void b(d dVar, double d11) {
        dVar.x(d11);
    }

    public f getDescriptor() {
        return f57785b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((Number) obj).doubleValue());
    }
}
