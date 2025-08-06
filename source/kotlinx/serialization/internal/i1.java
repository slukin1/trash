package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.g;
import kotlinx.serialization.descriptors.h;

public final class i1 {
    public static final int a(f fVar, f[] fVarArr) {
        int hashCode = (fVar.h().hashCode() * 31) + Arrays.hashCode(fVarArr);
        Iterable<f> a11 = g.a(fVar);
        Iterator<f> it2 = a11.iterator();
        int i11 = 1;
        int i12 = 1;
        while (true) {
            int i13 = 0;
            if (!it2.hasNext()) {
                break;
            }
            int i14 = i12 * 31;
            String h11 = it2.next().h();
            if (h11 != null) {
                i13 = h11.hashCode();
            }
            i12 = i14 + i13;
        }
        for (f kind : a11) {
            int i15 = i11 * 31;
            h kind2 = kind.getKind();
            i11 = i15 + (kind2 != null ? kind2.hashCode() : 0);
        }
        return (((hashCode * 31) + i12) * 31) + i11;
    }
}
