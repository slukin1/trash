package kotlinx.serialization.internal;

import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class h implements b<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public static final h f57720a = new h();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57721b = new m1("kotlin.Boolean", e.a.f57630a);

    /* renamed from: a */
    public Boolean deserialize(c cVar) {
        return Boolean.valueOf(cVar.A());
    }

    public void b(d dVar, boolean z11) {
        dVar.l(z11);
    }

    public f getDescriptor() {
        return f57721b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((Boolean) obj).booleanValue());
    }
}
