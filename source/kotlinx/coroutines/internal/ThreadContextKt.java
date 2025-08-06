package kotlinx.coroutines.internal;

import d10.p;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.f2;

public final class ThreadContextKt {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f57289a = new c0("NO_THREAD_ELEMENTS");

    /* renamed from: b  reason: collision with root package name */
    public static final p<Object, CoroutineContext.a, Object> f57290b = ThreadContextKt$countAll$1.INSTANCE;

    /* renamed from: c  reason: collision with root package name */
    public static final p<f2<?>, CoroutineContext.a, f2<?>> f57291c = ThreadContextKt$findOne$1.INSTANCE;

    /* renamed from: d  reason: collision with root package name */
    public static final p<i0, CoroutineContext.a, i0> f57292d = ThreadContextKt$updateState$1.INSTANCE;

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj != f57289a) {
            if (obj instanceof i0) {
                ((i0) obj).b(coroutineContext);
            } else {
                ((f2) coroutineContext.fold(null, f57291c)).n(coroutineContext, obj);
            }
        }
    }

    public static final Object b(CoroutineContext coroutineContext) {
        return coroutineContext.fold(0, f57290b);
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return f57289a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new i0(coroutineContext, ((Number) obj).intValue()), f57292d);
        }
        return ((f2) obj).M(coroutineContext);
    }
}
