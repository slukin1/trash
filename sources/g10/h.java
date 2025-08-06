package g10;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.o;

public final class h extends CoroutineDispatcher {

    /* renamed from: c  reason: collision with root package name */
    public static final h f54789c = new h();

    public CoroutineDispatcher D(int i11) {
        o.a(i11);
        if (i11 >= g.f54784d) {
            return this;
        }
        return super.D(i11);
    }

    public void w(CoroutineContext coroutineContext, Runnable runnable) {
        b.f54777i.H(runnable, g.f54788h, false);
    }

    public void x(CoroutineContext coroutineContext, Runnable runnable) {
        b.f54777i.H(runnable, g.f54788h, true);
    }
}
