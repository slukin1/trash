package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.m;
import kotlinx.coroutines.e0;

public final class j<E> extends e<E> implements k<E> {
    public j(CoroutineContext coroutineContext, d<E> dVar) {
        super(coroutineContext, dVar, true, true);
    }

    public void c1(Throwable th2, boolean z11) {
        if (!g1().K(th2) && !z11) {
            e0.a(getContext(), th2);
        }
    }

    public /* bridge */ /* synthetic */ m getChannel() {
        return f1();
    }

    /* renamed from: h1 */
    public void d1(Unit unit) {
        m.a.a(g1(), (Throwable) null, 1, (Object) null);
    }

    public boolean isActive() {
        return super.isActive();
    }
}
