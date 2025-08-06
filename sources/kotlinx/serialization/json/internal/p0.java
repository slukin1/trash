package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.descriptors.i;
import kotlinx.serialization.json.a;
import kotlinx.serialization.modules.d;

public final class p0 {
    public static final f a(f fVar, d dVar) {
        f a11;
        if (!x.b(fVar.getKind(), h.a.f57645a)) {
            return fVar.isInline() ? a(fVar.d(0), dVar) : fVar;
        }
        f b11 = b.b(dVar, fVar);
        if (b11 == null || (a11 = a(b11, dVar)) == null) {
            return fVar;
        }
        return a11;
    }

    public static final WriteMode b(a aVar, f fVar) {
        h kind = fVar.getKind();
        if (kind instanceof kotlinx.serialization.descriptors.d) {
            return WriteMode.POLY_OBJ;
        }
        if (x.b(kind, i.b.f57648a)) {
            return WriteMode.LIST;
        }
        if (!x.b(kind, i.c.f57649a)) {
            return WriteMode.OBJ;
        }
        f a11 = a(fVar.d(0), aVar.a());
        h kind2 = a11.getKind();
        if ((kind2 instanceof e) || x.b(kind2, h.b.f57646a)) {
            return WriteMode.MAP;
        }
        if (aVar.f().b()) {
            return WriteMode.LIST;
        }
        throw w.d(a11);
    }
}
