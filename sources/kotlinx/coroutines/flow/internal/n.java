package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;

public final class n<T> implements c<T>, kotlin.coroutines.jvm.internal.c {

    /* renamed from: b  reason: collision with root package name */
    public final c<T> f57269b;

    /* renamed from: c  reason: collision with root package name */
    public final CoroutineContext f57270c;

    public n(c<? super T> cVar, CoroutineContext coroutineContext) {
        this.f57269b = cVar;
        this.f57270c = coroutineContext;
    }

    public kotlin.coroutines.jvm.internal.c getCallerFrame() {
        c<T> cVar = this.f57269b;
        if (cVar instanceof kotlin.coroutines.jvm.internal.c) {
            return (kotlin.coroutines.jvm.internal.c) cVar;
        }
        return null;
    }

    public CoroutineContext getContext() {
        return this.f57270c;
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public void resumeWith(Object obj) {
        this.f57269b.resumeWith(obj);
    }
}
