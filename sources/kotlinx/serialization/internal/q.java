package kotlinx.serialization.internal;

import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class q implements b<Character> {

    /* renamed from: a  reason: collision with root package name */
    public static final q f57759a = new q();

    /* renamed from: b  reason: collision with root package name */
    public static final f f57760b = new m1("kotlin.Char", e.c.f57632a);

    /* renamed from: a */
    public Character deserialize(c cVar) {
        return Character.valueOf(cVar.o());
    }

    public void b(d dVar, char c11) {
        dVar.D(c11);
    }

    public f getDescriptor() {
        return f57760b;
    }

    public /* bridge */ /* synthetic */ void serialize(d dVar, Object obj) {
        b(dVar, ((Character) obj).charValue());
    }
}
