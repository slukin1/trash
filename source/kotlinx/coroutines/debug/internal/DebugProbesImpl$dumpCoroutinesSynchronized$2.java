package kotlinx.coroutines.debug.internal;

import d10.l;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.c;

final class DebugProbesImpl$dumpCoroutinesSynchronized$2 extends Lambda implements l<c.a<?>, Boolean> {
    public static final DebugProbesImpl$dumpCoroutinesSynchronized$2 INSTANCE = new DebugProbesImpl$dumpCoroutinesSynchronized$2();

    public DebugProbesImpl$dumpCoroutinesSynchronized$2() {
        super(1);
    }

    public final Boolean invoke(c.a<?> aVar) {
        return Boolean.valueOf(!c.f57098a.e(aVar));
    }
}
