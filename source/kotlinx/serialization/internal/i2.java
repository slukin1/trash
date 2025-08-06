package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.b0;
import kotlin.t;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class i2 implements b<t> {

    /* renamed from: a  reason: collision with root package name */
    public static final i2 f57727a = new i2();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57728b = j0.a("kotlin.UShort", a.H(b0.f56768a));

    public short a(c cVar) {
        return t.b(cVar.x(getDescriptor()).m());
    }

    public void b(d dVar, short s11) {
        dVar.h(getDescriptor()).k(s11);
    }

    public /* bridge */ /* synthetic */ Object deserialize(c cVar) {
        return t.a(a(cVar));
    }

    public f getDescriptor() {
        return f57728b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((t) obj).g());
    }
}
