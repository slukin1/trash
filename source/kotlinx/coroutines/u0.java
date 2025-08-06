package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;

public final class u0 implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public final CoroutineDispatcher f57568b;

    public void execute(Runnable runnable) {
        CoroutineDispatcher coroutineDispatcher = this.f57568b;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        if (coroutineDispatcher.B(emptyCoroutineContext)) {
            this.f57568b.w(emptyCoroutineContext, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.f57568b.toString();
    }
}
