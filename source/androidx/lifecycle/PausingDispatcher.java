package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.v0;

public final class PausingDispatcher extends CoroutineDispatcher {

    /* renamed from: c  reason: collision with root package name */
    public final DispatchQueue f9930c = new DispatchQueue();

    public boolean B(CoroutineContext coroutineContext) {
        if (v0.c().G().B(coroutineContext)) {
            return true;
        }
        return !this.f9930c.b();
    }

    public void w(CoroutineContext coroutineContext, Runnable runnable) {
        this.f9930c.c(coroutineContext, runnable);
    }
}
