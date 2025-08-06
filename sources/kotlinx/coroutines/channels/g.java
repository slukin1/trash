package kotlinx.coroutines.channels;

import d10.l;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.q2;

public final class g<E> extends z<g<E>> {

    /* renamed from: f  reason: collision with root package name */
    public final BufferedChannel<E> f57049f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicReferenceArray f57050g = new AtomicReferenceArray(BufferedChannelKt.f57019b * 2);

    public g(long j11, g<E> gVar, BufferedChannel<E> bufferedChannel, int i11) {
        super(j11, gVar, i11);
        this.f57049f = bufferedChannel;
    }

    public final void A(int i11, Object obj) {
        this.f57050g.set((i11 * 2) + 1, obj);
    }

    public final void B(int i11, E e11) {
        z(i11, e11);
    }

    public int n() {
        return BufferedChannelKt.f57019b;
    }

    public void o(int i11, Throwable th2, CoroutineContext coroutineContext) {
        l<E, Unit> lVar;
        l<E, Unit> lVar2;
        int i12 = BufferedChannelKt.f57019b;
        boolean z11 = i11 >= i12;
        if (z11) {
            i11 -= i12;
        }
        Object v11 = v(i11);
        while (true) {
            Object w11 = w(i11);
            if ((w11 instanceof q2) || (w11 instanceof n)) {
                if (r(i11, w11, z11 ? BufferedChannelKt.f57027j : BufferedChannelKt.f57028k)) {
                    s(i11);
                    x(i11, !z11);
                    if (z11 && (lVar = u().f57011c) != null) {
                        OnUndeliveredElementKt.b(lVar, v11, coroutineContext);
                        return;
                    }
                    return;
                }
            } else if (w11 == BufferedChannelKt.f57027j || w11 == BufferedChannelKt.f57028k) {
                s(i11);
            } else if (!(w11 == BufferedChannelKt.f57024g || w11 == BufferedChannelKt.f57023f)) {
                if (w11 != BufferedChannelKt.f57026i && w11 != BufferedChannelKt.f57021d && w11 != BufferedChannelKt.z()) {
                    throw new IllegalStateException(("unexpected state: " + w11).toString());
                }
                return;
            }
        }
        s(i11);
        if (z11 && (lVar2 = u().f57011c) != null) {
            OnUndeliveredElementKt.b(lVar2, v11, coroutineContext);
        }
    }

    public final boolean r(int i11, Object obj, Object obj2) {
        return this.f57050g.compareAndSet((i11 * 2) + 1, obj, obj2);
    }

    public final void s(int i11) {
        z(i11, (Object) null);
    }

    public final Object t(int i11, Object obj) {
        return this.f57050g.getAndSet((i11 * 2) + 1, obj);
    }

    public final BufferedChannel<E> u() {
        return this.f57049f;
    }

    public final E v(int i11) {
        return this.f57050g.get(i11 * 2);
    }

    public final Object w(int i11) {
        return this.f57050g.get((i11 * 2) + 1);
    }

    public final void x(int i11, boolean z11) {
        if (z11) {
            u().f1((this.f57353d * ((long) BufferedChannelKt.f57019b)) + ((long) i11));
        }
        p();
    }

    public final E y(int i11) {
        E v11 = v(i11);
        s(i11);
        return v11;
    }

    public final void z(int i11, Object obj) {
        this.f57050g.lazySet(i11 * 2, obj);
    }
}
