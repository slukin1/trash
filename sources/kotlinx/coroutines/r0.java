package kotlinx.coroutines;

import d10.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.internal.j;
import kotlinx.coroutines.internal.y;

public final class r0<T> extends y<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57391f = AtomicIntegerFieldUpdater.newUpdater(r0.class, "_decision");
    private volatile int _decision;

    public r0(CoroutineContext coroutineContext, c<? super T> cVar) {
        super(coroutineContext, cVar);
    }

    public void U(Object obj) {
        b1(obj);
    }

    public void b1(Object obj) {
        if (!g1()) {
            j.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.f57351e), a0.a(obj, this.f57351e), (l) null, 2, (Object) null);
        }
    }

    public final Object f1() {
        if (h1()) {
            return IntrinsicsKt__IntrinsicsKt.d();
        }
        Object h11 = s1.h(s0());
        if (!(h11 instanceof y)) {
            return h11;
        }
        throw ((y) h11).f57583a;
    }

    public final boolean g1() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57391f;
        do {
            int i11 = atomicIntegerFieldUpdater.get(this);
            if (i11 != 0) {
                if (i11 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f57391f.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean h1() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57391f;
        do {
            int i11 = atomicIntegerFieldUpdater.get(this);
            if (i11 != 0) {
                if (i11 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f57391f.compareAndSet(this, 0, 1));
        return true;
    }
}
