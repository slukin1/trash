package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.e0;

public final class h {
    public static final void a(CoroutineContext coroutineContext, Throwable th2) {
        for (d0 handleException : g.a()) {
            try {
                handleException.handleException(coroutineContext, th2);
            } catch (ExceptionSuccessfullyProcessed unused) {
                return;
            } catch (Throwable th3) {
                g.b(e0.b(th2, th3));
            }
        }
        try {
            ExceptionsKt__ExceptionsKt.a(th2, new DiagnosticCoroutineContextException(coroutineContext));
        } catch (Throwable unused2) {
        }
        g.b(th2);
    }
}
