package kotlinx.serialization.internal;

import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class c0 implements b<Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f57699a = new c0();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57700b = new m1("kotlin.Float", e.C0669e.f57634a);

    /* renamed from: a */
    public Float deserialize(c cVar) {
        return Float.valueOf(cVar.y());
    }

    public void b(d dVar, float f11) {
        dVar.m(f11);
    }

    public f getDescriptor() {
        return f57700b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((Number) obj).floatValue());
    }
}
