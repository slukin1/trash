package kotlinx.coroutines.android;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.x0;

public abstract class b extends MainCoroutineDispatcher implements p0 {
    public b() {
    }

    public /* synthetic */ b(r rVar) {
        this();
    }

    public x0 u(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        return p0.a.a(this, j11, runnable, coroutineContext);
    }
}
