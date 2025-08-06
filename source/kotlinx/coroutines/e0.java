package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.h;

public final class e0 {
    public static final void a(CoroutineContext coroutineContext, Throwable th2) {
        try {
            d0 d0Var = (d0) coroutineContext.get(d0.f57063q0);
            if (d0Var != null) {
                d0Var.handleException(coroutineContext, th2);
            } else {
                h.a(coroutineContext, th2);
            }
        } catch (Throwable th3) {
            h.a(coroutineContext, b(th2, th3));
        }
    }

    public static final Throwable b(Throwable th2, Throwable th3) {
        if (th2 == th3) {
            return th2;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th3);
        ExceptionsKt__ExceptionsKt.a(runtimeException, th2);
        return runtimeException;
    }
}
