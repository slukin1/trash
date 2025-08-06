package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.reflect.c;
import kotlinx.serialization.internal.p1;
import kotlinx.serialization.modules.d;

public final class b {
    public static final c<?> a(f fVar) {
        if (fVar instanceof c) {
            return ((c) fVar).f57626b;
        }
        if (fVar instanceof p1) {
            return a(((p1) fVar).j());
        }
        return null;
    }

    public static final f b(d dVar, f fVar) {
        kotlinx.serialization.b c11;
        c<?> a11 = a(fVar);
        if (a11 == null || (c11 = d.c(dVar, a11, (List) null, 2, (Object) null)) == null) {
            return null;
        }
        return c11.getDescriptor();
    }

    public static final f c(f fVar, c<?> cVar) {
        return new c(fVar, cVar);
    }
}
