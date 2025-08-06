package kotlin.coroutines.jvm.internal;

import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;

final class RunSuspend implements c<Unit> {

    /* renamed from: b  reason: collision with root package name */
    public Result<Unit> f56677b;

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public void resumeWith(Object obj) {
        synchronized (this) {
            this.f56677b = Result.m3071boximpl(obj);
            notifyAll();
            Unit unit = Unit.f56620a;
        }
    }
}
