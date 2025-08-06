package kotlinx.coroutines.rx3;

import h00.l;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.a;

public final class d<T> extends a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final l<T> f57450e;

    public d(CoroutineContext coroutineContext, l<T> lVar) {
        super(coroutineContext, false, true);
        this.f57450e = lVar;
    }

    public void c1(Throwable th2, boolean z11) {
        try {
            if (this.f57450e.tryOnError(th2)) {
                return;
            }
        } catch (Throwable th3) {
            ExceptionsKt__ExceptionsKt.a(th2, th3);
        }
        b.a(th2, getContext());
    }

    public void d1(T t11) {
        try {
            this.f57450e.onSuccess(t11);
        } catch (Throwable th2) {
            b.a(th2, getContext());
        }
    }
}
