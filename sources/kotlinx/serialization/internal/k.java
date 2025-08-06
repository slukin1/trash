package kotlinx.serialization.internal;

import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class k implements b<Byte> {

    /* renamed from: a  reason: collision with root package name */
    public static final k f57734a = new k();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57735b = new m1("kotlin.Byte", e.b.f57631a);

    /* renamed from: a */
    public Byte deserialize(c cVar) {
        return Byte.valueOf(cVar.H());
    }

    public void b(d dVar, byte b11) {
        dVar.f(b11);
    }

    public f getDescriptor() {
        return f57735b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((Number) obj).byteValue());
    }
}
