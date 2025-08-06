package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.x1;

public abstract class z<S extends z<S>> extends e<S> implements x1 {

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57352e = AtomicIntegerFieldUpdater.newUpdater(z.class, "cleanedAndPointers");
    private volatile int cleanedAndPointers;

    /* renamed from: d  reason: collision with root package name */
    public final long f57353d;

    public z(long j11, S s11, int i11) {
        super(s11);
        this.f57353d = j11;
        this.cleanedAndPointers = i11 << 16;
    }

    public boolean h() {
        return f57352e.get(this) == n() && !i();
    }

    public final boolean m() {
        return f57352e.addAndGet(this, -65536) == n() && !i();
    }

    public abstract int n();

    public abstract void o(int i11, Throwable th2, CoroutineContext coroutineContext);

    public final void p() {
        if (f57352e.incrementAndGet(this) == n()) {
            k();
        }
    }

    public final boolean q() {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57352e;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            if (!(i11 != n() || i())) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, 65536 + i11));
        return true;
    }
}
