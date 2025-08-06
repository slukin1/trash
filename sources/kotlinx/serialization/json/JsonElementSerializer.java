package kotlinx.serialization.json;

import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.d;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;

public final class JsonElementSerializer implements b<g> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonElementSerializer f57821a = new JsonElementSerializer();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57822b = SerialDescriptorsKt.c("kotlinx.serialization.json.JsonElement", d.b.f57629a, new f[0], JsonElementSerializer$descriptor$1.INSTANCE);

    /* renamed from: a */
    public g deserialize(c cVar) {
        return j.d(cVar).t();
    }

    /* renamed from: b */
    public void serialize(kotlinx.serialization.encoding.d dVar, g gVar) {
        j.h(dVar);
        if (gVar instanceof t) {
            dVar.e(u.f57955a, gVar);
        } else if (gVar instanceof JsonObject) {
            dVar.e(s.f57950a, gVar);
        } else if (gVar instanceof b) {
            dVar.e(c.f57832a, gVar);
        }
    }

    public f getDescriptor() {
        return f57822b;
    }
}
