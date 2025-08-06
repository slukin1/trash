package kotlinx.serialization.json;

import d10.l;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.json.internal.w;

public final class u implements b<t> {

    /* renamed from: a  reason: collision with root package name */
    public static final u f57955a = new u();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57956b = SerialDescriptorsKt.d("kotlinx.serialization.json.JsonPrimitive", e.i.f57638a, new f[0], (l) null, 8, (Object) null);

    /* renamed from: a */
    public t deserialize(c cVar) {
        g t11 = j.d(cVar).t();
        if (t11 instanceof t) {
            return (t) t11;
        }
        throw w.f(-1, "Unexpected JSON element, expected JsonPrimitive, had " + Reflection.b(t11.getClass()), t11.toString());
    }

    /* renamed from: b */
    public void serialize(d dVar, t tVar) {
        j.h(dVar);
        if (tVar instanceof JsonNull) {
            dVar.e(r.f57948a, JsonNull.INSTANCE);
        } else {
            dVar.e(o.f57946a, (n) tVar);
        }
    }

    public f getDescriptor() {
        return f57956b;
    }
}
