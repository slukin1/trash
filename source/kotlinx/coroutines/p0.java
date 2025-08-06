package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

public interface p0 {

    public static final class a {
        public static x0 a(p0 p0Var, long j11, Runnable runnable, CoroutineContext coroutineContext) {
            return m0.a().u(j11, runnable, coroutineContext);
        }
    }

    void t(long j11, k<? super Unit> kVar);

    x0 u(long j11, Runnable runnable, CoroutineContext coroutineContext);
}
