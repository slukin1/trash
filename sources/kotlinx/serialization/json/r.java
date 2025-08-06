package kotlinx.serialization.json;

import d10.l;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.json.internal.JsonDecodingException;

public final class r implements b<JsonNull> {

    /* renamed from: a  reason: collision with root package name */
    public static final r f57948a = new r();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57949b = SerialDescriptorsKt.d("kotlinx.serialization.json.JsonNull", h.b.f57646a, new f[0], (l) null, 8, (Object) null);

    /* renamed from: a */
    public JsonNull deserialize(c cVar) {
        j.g(cVar);
        if (!cVar.D()) {
            cVar.g();
            return JsonNull.INSTANCE;
        }
        throw new JsonDecodingException("Expected 'null' literal");
    }

    /* renamed from: b */
    public void serialize(d dVar, JsonNull jsonNull) {
        j.h(dVar);
        dVar.B();
    }

    public f getDescriptor() {
        return f57949b;
    }
}
