package kotlinx.serialization.internal;

import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class y implements b<kotlin.time.b> {

    /* renamed from: a  reason: collision with root package name */
    public static final y f57790a = new y();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57791b = new m1("kotlin.time.Duration", e.i.f57638a);

    public long a(c cVar) {
        return kotlin.time.b.f56931c.c(cVar.q());
    }

    public void b(d dVar, long j11) {
        dVar.v(kotlin.time.b.F(j11));
    }

    public /* bridge */ /* synthetic */ Object deserialize(c cVar) {
        return kotlin.time.b.f(a(cVar));
    }

    public f getDescriptor() {
        return f57791b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((kotlin.time.b) obj).J());
    }
}
