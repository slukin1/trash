package kotlinx.serialization.json;

import d10.l;
import kotlin.Unit;

public final class m {
    public static final a a(a aVar, l<? super d, Unit> lVar) {
        d dVar = new d(aVar);
        lVar.invoke(dVar);
        return new l(dVar.a(), dVar.b());
    }

    public static /* synthetic */ a b(a aVar, l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            aVar = a.f57827d;
        }
        return a(aVar, lVar);
    }
}
