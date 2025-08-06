package kotlinx.serialization.internal;

import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class v1 implements b<String> {

    /* renamed from: a  reason: collision with root package name */
    public static final v1 f57779a = new v1();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57780b = new m1("kotlin.String", e.i.f57638a);

    /* renamed from: a */
    public String deserialize(c cVar) {
        return cVar.q();
    }

    /* renamed from: b */
    public void serialize(d dVar, String str) {
        dVar.v(str);
    }

    public f getDescriptor() {
        return f57780b;
    }
}
