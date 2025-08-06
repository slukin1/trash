package kotlinx.coroutines;

import d10.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;

public final class l2 implements l<Throwable, Unit> {

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57373e = AtomicIntegerFieldUpdater.newUpdater(l2.class, "_state");
    private volatile int _state;

    /* renamed from: b  reason: collision with root package name */
    public final n1 f57374b;

    /* renamed from: c  reason: collision with root package name */
    public final Thread f57375c = Thread.currentThread();

    /* renamed from: d  reason: collision with root package name */
    public x0 f57376d;

    public l2(n1 n1Var) {
        this.f57374b = n1Var;
    }

    public final void a() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57373e;
        while (true) {
            int i11 = atomicIntegerFieldUpdater.get(this);
            if (i11 != 0) {
                if (i11 != 2) {
                    if (i11 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i11);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f57373e.compareAndSet(this, i11, 1)) {
                x0 x0Var = this.f57376d;
                if (x0Var != null) {
                    x0Var.dispose();
                    return;
                }
                return;
            }
        }
    }

    public final Void b(int i11) {
        throw new IllegalStateException(("Illegal state " + i11).toString());
    }

    public void c(Throwable th2) {
        int i11;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = f57373e;
        do {
            i11 = atomicIntegerFieldUpdater2.get(this);
            if (i11 == 0) {
                atomicIntegerFieldUpdater = f57373e;
            } else if (i11 != 1 && i11 != 2 && i11 != 3) {
                b(i11);
                throw new KotlinNothingValueException();
            } else {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, 2));
        this.f57375c.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
    }

    public final void d() {
        int i11;
        this.f57376d = this.f57374b.E(true, true, this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57373e;
        do {
            i11 = atomicIntegerFieldUpdater.get(this);
            if (i11 != 0) {
                if (i11 != 2 && i11 != 3) {
                    b(i11);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!f57373e.compareAndSet(this, i11, 0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        c((Throwable) obj);
        return Unit.f56620a;
    }
}
