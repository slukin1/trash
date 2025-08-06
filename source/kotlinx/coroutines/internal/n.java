package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.x0;

public final class n extends CoroutineDispatcher implements p0 {

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57325h = AtomicIntegerFieldUpdater.newUpdater(n.class, "runningWorkers");

    /* renamed from: c  reason: collision with root package name */
    public final CoroutineDispatcher f57326c;

    /* renamed from: d  reason: collision with root package name */
    public final int f57327d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ p0 f57328e;

    /* renamed from: f  reason: collision with root package name */
    public final q<Runnable> f57329f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f57330g;
    private volatile int runningWorkers;

    public final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public Runnable f57331b;

        public a(Runnable runnable) {
            this.f57331b = runnable;
        }

        public void run() {
            int i11 = 0;
            while (true) {
                try {
                    this.f57331b.run();
                } catch (Throwable th2) {
                    e0.a(EmptyCoroutineContext.INSTANCE, th2);
                }
                Runnable H = n.this.I();
                if (H != null) {
                    this.f57331b = H;
                    i11++;
                    if (i11 >= 16 && n.this.f57326c.B(n.this)) {
                        n.this.f57326c.w(n.this, this);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public n(CoroutineDispatcher coroutineDispatcher, int i11) {
        this.f57326c = coroutineDispatcher;
        this.f57327d = i11;
        p0 p0Var = coroutineDispatcher instanceof p0 ? (p0) coroutineDispatcher : null;
        this.f57328e = p0Var == null ? m0.a() : p0Var;
        this.f57329f = new q<>(false);
        this.f57330g = new Object();
    }

    public final Runnable I() {
        while (true) {
            Runnable d11 = this.f57329f.d();
            if (d11 != null) {
                return d11;
            }
            synchronized (this.f57330g) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57325h;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f57329f.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean J() {
        synchronized (this.f57330g) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57325h;
            if (atomicIntegerFieldUpdater.get(this) >= this.f57327d) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    public void t(long j11, k<? super Unit> kVar) {
        this.f57328e.t(j11, kVar);
    }

    public x0 u(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f57328e.u(j11, runnable, coroutineContext);
    }

    public void w(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable I;
        this.f57329f.a(runnable);
        if (f57325h.get(this) < this.f57327d && J() && (I = I()) != null) {
            this.f57326c.w(this, new a(I));
        }
    }

    public void x(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable I;
        this.f57329f.a(runnable);
        if (f57325h.get(this) < this.f57327d && J() && (I = I()) != null) {
            this.f57326c.x(this, new a(I));
        }
    }
}
