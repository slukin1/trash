package g10;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.internal.f0;

public final class a extends ExecutorCoroutineDispatcher implements Executor {

    /* renamed from: d  reason: collision with root package name */
    public static final a f54775d = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final CoroutineDispatcher f54776e = h.f54789c.D(f0.e("kotlinx.coroutines.io.parallelism", RangesKt___RangesKt.d(64, d0.a()), 0, 0, 12, (Object) null));

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public void execute(Runnable runnable) {
        w(EmptyCoroutineContext.INSTANCE, runnable);
    }

    public String toString() {
        return "Dispatchers.IO";
    }

    public void w(CoroutineContext coroutineContext, Runnable runnable) {
        f54776e.w(coroutineContext, runnable);
    }

    public void x(CoroutineContext coroutineContext, Runnable runnable) {
        f54776e.x(coroutineContext, runnable);
    }
}
