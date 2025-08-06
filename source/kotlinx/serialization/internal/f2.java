package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.z;
import kotlin.q;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class f2 implements b<q> {

    /* renamed from: a  reason: collision with root package name */
    public static final f2 f57714a = new f2();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57715b = j0.a("kotlin.ULong", a.G(z.f56799a));

    public long a(c cVar) {
        return q.b(cVar.x(getDescriptor()).h());
    }

    public void b(d dVar, long j11) {
        dVar.h(getDescriptor()).A(j11);
    }

    public /* bridge */ /* synthetic */ Object deserialize(c cVar) {
        return q.a(a(cVar));
    }

    public f getDescriptor() {
        return f57715b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((q) obj).g());
    }
}
