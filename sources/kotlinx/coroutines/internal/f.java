package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.h0;

public final class f implements h0 {

    /* renamed from: b  reason: collision with root package name */
    public final CoroutineContext f57307b;

    public f(CoroutineContext coroutineContext) {
        this.f57307b = coroutineContext;
    }

    public CoroutineContext getCoroutineContext() {
        return this.f57307b;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
