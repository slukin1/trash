package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.w;
import kotlin.o;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class c2 implements b<o> {

    /* renamed from: a  reason: collision with root package name */
    public static final c2 f57703a = new c2();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57704b = j0.a("kotlin.UInt", a.F(w.f56798a));

    public int a(c cVar) {
        return o.b(cVar.x(getDescriptor()).u());
    }

    public void b(d dVar, int i11) {
        dVar.h(getDescriptor()).s(i11);
    }

    public /* bridge */ /* synthetic */ Object deserialize(c cVar) {
        return o.a(a(cVar));
    }

    public f getDescriptor() {
        return f57704b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((o) obj).g());
    }
}
