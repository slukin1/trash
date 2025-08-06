package kotlinx.coroutines.rx3;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.e0;
import o00.a;

public final class b {
    public static final void a(Throwable th2, CoroutineContext coroutineContext) {
        if (!(th2 instanceof CancellationException)) {
            try {
                a.n(th2);
            } catch (Throwable th3) {
                ExceptionsKt__ExceptionsKt.a(th2, th3);
                e0.a(coroutineContext, th2);
            }
        }
    }
}
