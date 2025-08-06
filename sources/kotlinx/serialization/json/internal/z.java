package kotlinx.serialization.json.internal;

import kotlinx.serialization.g;
import kotlinx.serialization.json.a;
import kotlinx.serialization.json.k;

public final class z {
    public static final <T> void a(a aVar, g0 g0Var, g<? super T> gVar, T t11) {
        new k0(g0Var, aVar, WriteMode.OBJ, new k[WriteMode.values().length]).e(gVar, t11);
    }
}
