package kotlinx.serialization.internal;

import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class m0 implements b<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final m0 f57742a = new m0();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57743b = new m1("kotlin.Int", e.f.f57635a);

    /* renamed from: a */
    public Integer deserialize(c cVar) {
        return Integer.valueOf(cVar.u());
    }

    public void b(d dVar, int i11) {
        dVar.s(i11);
    }

    public f getDescriptor() {
        return f57743b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((Number) obj).intValue());
    }
}
