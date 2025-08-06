package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

public final class n2 extends CoroutineDispatcher {

    /* renamed from: c  reason: collision with root package name */
    public static final n2 f57384c = new n2();

    public boolean B(CoroutineContext coroutineContext) {
        return false;
    }

    public String toString() {
        return "Dispatchers.Unconfined";
    }

    public void w(CoroutineContext coroutineContext, Runnable runnable) {
        YieldContext yieldContext = (YieldContext) coroutineContext.get(YieldContext.f56974c);
        if (yieldContext != null) {
            yieldContext.f56975b = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }
}
