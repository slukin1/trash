package kotlinx.coroutines.debug.internal;

import d10.l;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.c;

public final class DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1 extends Lambda implements l<c.a<?>, b> {
    public DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1() {
        super(1);
    }

    public final b invoke(c.a<?> aVar) {
        CoroutineContext c11;
        if (!c.f57098a.e(aVar) && (c11 = aVar.f57110c.c()) != null) {
            return new b(aVar.f57110c, c11);
        }
        return null;
    }
}
