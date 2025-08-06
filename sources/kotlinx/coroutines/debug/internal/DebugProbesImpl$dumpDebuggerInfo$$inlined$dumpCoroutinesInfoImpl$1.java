package kotlinx.coroutines.debug.internal;

import d10.l;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.c;

public final class DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1 extends Lambda implements l<c.a<?>, DebuggerInfo> {
    public DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1() {
        super(1);
    }

    public final DebuggerInfo invoke(c.a<?> aVar) {
        CoroutineContext c11;
        if (!c.f57098a.e(aVar) && (c11 = aVar.f57110c.c()) != null) {
            return new DebuggerInfo(aVar.f57110c, c11);
        }
        return null;
    }
}
