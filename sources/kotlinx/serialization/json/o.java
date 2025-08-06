package kotlinx.serialization.json;

import h10.a;
import kotlin.jvm.internal.Reflection;
import kotlin.q;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.json.internal.w;

public final class o implements b<n> {

    /* renamed from: a  reason: collision with root package name */
    public static final o f57946a = new o();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57947b = SerialDescriptorsKt.a("kotlinx.serialization.json.JsonLiteral", e.i.f57638a);

    /* renamed from: a */
    public n deserialize(c cVar) {
        g t11 = j.d(cVar).t();
        if (t11 instanceof n) {
            return (n) t11;
        }
        throw w.f(-1, "Unexpected JSON element, expected JsonLiteral, had " + Reflection.b(t11.getClass()), t11.toString());
    }

    /* renamed from: b */
    public void serialize(d dVar, n nVar) {
        j.h(dVar);
        if (nVar.c()) {
            dVar.v(nVar.a());
        } else if (nVar.d() != null) {
            dVar.h(nVar.d()).v(nVar.a());
        } else {
            Long o11 = i.o(nVar);
            if (o11 != null) {
                dVar.A(o11.longValue());
                return;
            }
            q h11 = kotlin.text.o.h(nVar.a());
            if (h11 != null) {
                dVar.h(a.x(q.f56813c).getDescriptor()).A(h11.g());
                return;
            }
            Double h12 = i.h(nVar);
            if (h12 != null) {
                dVar.x(h12.doubleValue());
                return;
            }
            Boolean e11 = i.e(nVar);
            if (e11 != null) {
                dVar.l(e11.booleanValue());
            } else {
                dVar.v(nVar.a());
            }
        }
    }

    public f getDescriptor() {
        return f57947b;
    }
}
