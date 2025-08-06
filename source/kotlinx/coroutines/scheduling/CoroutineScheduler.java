package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import g10.d;
import g10.f;
import g10.g;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;
import kotlin.random.Random;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k0;

public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: i  reason: collision with root package name */
    public static final a f57466i = new a((r) null);

    /* renamed from: j  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f57467j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: k  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f57468k = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: l  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57469l = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* renamed from: m  reason: collision with root package name */
    public static final c0 f57470m = new c0("NOT_IN_STACK");
    private volatile int _isTerminated;

    /* renamed from: b  reason: collision with root package name */
    public final int f57471b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57472c;
    private volatile long controlState;

    /* renamed from: d  reason: collision with root package name */
    public final long f57473d;

    /* renamed from: e  reason: collision with root package name */
    public final String f57474e;

    /* renamed from: f  reason: collision with root package name */
    public final GlobalQueue f57475f;

    /* renamed from: g  reason: collision with root package name */
    public final GlobalQueue f57476g;

    /* renamed from: h  reason: collision with root package name */
    public final x<c> f57477h;
    private volatile long parkedWorkersStack;

    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57478a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[] r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.PARKING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.BLOCKING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.DORMANT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f57478a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.b.<clinit>():void");
        }
    }

    public CoroutineScheduler(int i11, int i12, long j11, String str) {
        this.f57471b = i11;
        this.f57472c = i12;
        this.f57473d = j11;
        this.f57474e = str;
        boolean z11 = true;
        if (i11 >= 1) {
            if (i12 >= i11) {
                if (i12 <= 2097150) {
                    if (j11 <= 0 ? false : z11) {
                        this.f57475f = new GlobalQueue();
                        this.f57476g = new GlobalQueue();
                        this.f57477h = new x<>((i11 + 1) * 2);
                        this.controlState = ((long) i11) << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j11 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i12 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i12 + " should be greater than or equals to core pool size " + i11).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i11 + " should be at least 1").toString());
    }

    public static /* synthetic */ void k(CoroutineScheduler coroutineScheduler, Runnable runnable, d dVar, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            dVar = g.f54787g;
        }
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        coroutineScheduler.j(runnable, dVar, z11);
    }

    public static /* synthetic */ boolean y(CoroutineScheduler coroutineScheduler, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = f57468k.get(coroutineScheduler);
        }
        return coroutineScheduler.x(j11);
    }

    public final boolean b(Task task) {
        boolean z11 = true;
        if (task.f57494c.b() != 1) {
            z11 = false;
        }
        if (z11) {
            return this.f57476g.a(task);
        }
        return this.f57475f.a(task);
    }

    public void close() {
        t(10000);
    }

    public final int e() {
        synchronized (this.f57477h) {
            if (isTerminated()) {
                return -1;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = f57468k;
            long j11 = atomicLongFieldUpdater.get(this);
            int i11 = (int) (j11 & 2097151);
            boolean z11 = false;
            int d11 = RangesKt___RangesKt.d(i11 - ((int) ((j11 & 4398044413952L) >> 21)), 0);
            if (d11 >= this.f57471b) {
                return 0;
            }
            if (i11 >= this.f57472c) {
                return 0;
            }
            int i12 = ((int) (f57468k.get(this) & 2097151)) + 1;
            if (i12 > 0 && this.f57477h.b(i12) == null) {
                c cVar = new c(this, i12);
                this.f57477h.c(i12, cVar);
                if (i12 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    z11 = true;
                }
                if (z11) {
                    int i13 = d11 + 1;
                    cVar.start();
                    return i13;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public void execute(Runnable runnable) {
        k(this, runnable, (d) null, false, 6, (Object) null);
    }

    public final Task f(Runnable runnable, d dVar) {
        long a11 = g.f54786f.a();
        if (!(runnable instanceof Task)) {
            return new f(runnable, a11, dVar);
        }
        Task task = (Task) runnable;
        task.f57493b = a11;
        task.f57494c = dVar;
        return task;
    }

    public final c g() {
        Thread currentThread = Thread.currentThread();
        c cVar = currentThread instanceof c ? (c) currentThread : null;
        if (cVar == null || !kotlin.jvm.internal.x.b(CoroutineScheduler.this, this)) {
            return null;
        }
        return cVar;
    }

    public final boolean isTerminated() {
        return f57469l.get(this) != 0;
    }

    public final void j(Runnable runnable, d dVar, boolean z11) {
        AbstractTimeSource a11 = kotlinx.coroutines.b.a();
        if (a11 != null) {
            a11.d();
        }
        Task f11 = f(runnable, dVar);
        boolean z12 = false;
        boolean z13 = f11.f57494c.b() == 1;
        long addAndGet = z13 ? f57468k.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) : 0;
        c g11 = g();
        Task w11 = w(g11, f11, z11);
        if (w11 == null || b(w11)) {
            if (z11 && g11 != null) {
                z12 = true;
            }
            if (z13) {
                u(addAndGet, z12);
            } else if (!z12) {
                v();
            }
        } else {
            throw new RejectedExecutionException(this.f57474e + " was terminated");
        }
    }

    public final int l(c cVar) {
        Object i11 = cVar.i();
        while (i11 != f57470m) {
            if (i11 == null) {
                return 0;
            }
            c cVar2 = (c) i11;
            int h11 = cVar2.h();
            if (h11 != 0) {
                return h11;
            }
            i11 = cVar2.i();
        }
        return -1;
    }

    public final c n() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f57467j;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            c b11 = this.f57477h.b((int) (2097151 & j11));
            if (b11 == null) {
                return null;
            }
            long j12 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j11) & -2097152;
            int l11 = l(b11);
            if (l11 >= 0) {
                if (f57467j.compareAndSet(this, j11, ((long) l11) | j12)) {
                    b11.r(f57470m);
                    return b11;
                }
            }
        }
    }

    public final boolean o(c cVar) {
        long j11;
        long j12;
        int h11;
        if (cVar.i() != f57470m) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f57467j;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            int i11 = (int) (2097151 & j11);
            j12 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j11) & -2097152;
            h11 = cVar.h();
            if (j0.a()) {
                if (!(h11 != 0)) {
                    throw new AssertionError();
                }
            }
            cVar.r(this.f57477h.b(i11));
        } while (!f57467j.compareAndSet(this, j11, ((long) h11) | j12));
        return true;
    }

    public final void p(c cVar, int i11, int i12) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f57467j;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            int i13 = (int) (2097151 & j11);
            long j12 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j11) & -2097152;
            if (i13 == i11) {
                i13 = i12 == 0 ? l(cVar) : i12;
            }
            if (i13 >= 0) {
                if (f57467j.compareAndSet(this, j11, j12 | ((long) i13))) {
                    return;
                }
            }
        }
    }

    public final void r(Task task) {
        AbstractTimeSource a11;
        try {
            task.run();
            a11 = kotlinx.coroutines.b.a();
            if (a11 == null) {
                return;
            }
        } catch (Throwable th2) {
            AbstractTimeSource a12 = kotlinx.coroutines.b.a();
            if (a12 != null) {
                a12.e();
            }
            throw th2;
        }
        a11.e();
    }

    public final void t(long j11) {
        int i11;
        Task task;
        boolean z11 = false;
        if (f57469l.compareAndSet(this, 0, 1)) {
            c g11 = g();
            synchronized (this.f57477h) {
                i11 = (int) (f57468k.get(this) & 2097151);
            }
            if (1 <= i11) {
                int i12 = 1;
                while (true) {
                    c b11 = this.f57477h.b(i12);
                    if (b11 != g11) {
                        while (b11.isAlive()) {
                            LockSupport.unpark(b11);
                            b11.join(j11);
                        }
                        WorkerState workerState = b11.f57482d;
                        if (j0.a()) {
                            if (!(workerState == WorkerState.TERMINATED)) {
                                throw new AssertionError();
                            }
                        }
                        b11.f57480b.f(this.f57476g);
                    }
                    if (i12 == i11) {
                        break;
                    }
                    i12++;
                }
            }
            this.f57476g.b();
            this.f57475f.b();
            while (true) {
                if (g11 != null) {
                    task = g11.g(true);
                    if (task != null) {
                        continue;
                        r(task);
                    }
                }
                task = (Task) this.f57475f.d();
                if (task == null && (task = (Task) this.f57476g.d()) == null) {
                    break;
                }
                r(task);
            }
            if (g11 != null) {
                g11.u(WorkerState.TERMINATED);
            }
            if (j0.a()) {
                if (((int) ((f57468k.get(this) & 9223367638808264704L) >> 42)) == this.f57471b) {
                    z11 = true;
                }
                if (!z11) {
                    throw new AssertionError();
                }
            }
            f57467j.set(this, 0);
            f57468k.set(this, 0);
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a11 = this.f57477h.a();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        for (int i16 = 1; i16 < a11; i16++) {
            c b11 = this.f57477h.b(i16);
            if (b11 != null) {
                int e11 = b11.f57480b.e();
                int i17 = b.f57478a[b11.f57482d.ordinal()];
                if (i17 == 1) {
                    i13++;
                } else if (i17 == 2) {
                    i12++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(e11);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i17 == 3) {
                    i11++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(e11);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                } else if (i17 == 4) {
                    i14++;
                    if (e11 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(e11);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else if (i17 == 5) {
                    i15++;
                }
            }
        }
        long j11 = f57468k.get(this);
        return this.f57474e + '@' + k0.b(this) + "[Pool Size {core = " + this.f57471b + ", max = " + this.f57472c + "}, Worker States {CPU = " + i11 + ", blocking = " + i12 + ", parked = " + i13 + ", dormant = " + i14 + ", terminated = " + i15 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f57475f.c() + ", global blocking queue size = " + this.f57476g.c() + ", Control State {created workers= " + ((int) (2097151 & j11)) + ", blocking tasks = " + ((int) ((4398044413952L & j11) >> 21)) + ", CPUs acquired = " + (this.f57471b - ((int) ((9223367638808264704L & j11) >> 42))) + "}]";
    }

    public final void u(long j11, boolean z11) {
        if (!z11 && !z() && !x(j11)) {
            z();
        }
    }

    public final void v() {
        if (!z() && !y(this, 0, 1, (Object) null)) {
            z();
        }
    }

    public final Task w(c cVar, Task task, boolean z11) {
        if (cVar == null || cVar.f57482d == WorkerState.TERMINATED) {
            return task;
        }
        if (task.f57494c.b() == 0 && cVar.f57482d == WorkerState.BLOCKING) {
            return task;
        }
        cVar.f57486h = true;
        return cVar.f57480b.a(task, z11);
    }

    public final boolean x(long j11) {
        if (RangesKt___RangesKt.d(((int) (2097151 & j11)) - ((int) ((j11 & 4398044413952L) >> 21)), 0) < this.f57471b) {
            int e11 = e();
            if (e11 == 1 && this.f57471b > 1) {
                e();
            }
            if (e11 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean z() {
        c n11;
        do {
            n11 = n();
            if (n11 == null) {
                return false;
            }
        } while (!c.j().compareAndSet(n11, -1, 0));
        LockSupport.unpark(n11);
        return true;
    }

    public final class c extends Thread {

        /* renamed from: j  reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f57479j = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: b  reason: collision with root package name */
        public final WorkQueue f57480b;

        /* renamed from: c  reason: collision with root package name */
        public final Ref$ObjectRef<Task> f57481c;

        /* renamed from: d  reason: collision with root package name */
        public WorkerState f57482d;

        /* renamed from: e  reason: collision with root package name */
        public long f57483e;

        /* renamed from: f  reason: collision with root package name */
        public long f57484f;

        /* renamed from: g  reason: collision with root package name */
        public int f57485g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f57486h;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        public c() {
            setDaemon(true);
            this.f57480b = new WorkQueue();
            this.f57481c = new Ref$ObjectRef<>();
            this.f57482d = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f57470m;
            this.f57485g = Random.Default.nextInt();
        }

        public static final AtomicIntegerFieldUpdater j() {
            return f57479j;
        }

        public final void b(int i11) {
            if (i11 != 0) {
                CoroutineScheduler.f57468k.addAndGet(CoroutineScheduler.this, -2097152);
                WorkerState workerState = this.f57482d;
                if (workerState != WorkerState.TERMINATED) {
                    if (j0.a()) {
                        if (!(workerState == WorkerState.BLOCKING)) {
                            throw new AssertionError();
                        }
                    }
                    this.f57482d = WorkerState.DORMANT;
                }
            }
        }

        public final void c(int i11) {
            if (i11 != 0 && u(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.v();
            }
        }

        public final void d(Task task) {
            int b11 = task.f57494c.b();
            k(b11);
            c(b11);
            CoroutineScheduler.this.r(task);
            b(b11);
        }

        public final Task e(boolean z11) {
            Task o11;
            Task o12;
            if (z11) {
                boolean z12 = m(CoroutineScheduler.this.f57471b * 2) == 0;
                if (z12 && (o12 = o()) != null) {
                    return o12;
                }
                Task g11 = this.f57480b.g();
                if (g11 != null) {
                    return g11;
                }
                if (!z12 && (o11 = o()) != null) {
                    return o11;
                }
            } else {
                Task o13 = o();
                if (o13 != null) {
                    return o13;
                }
            }
            return v(3);
        }

        public final Task f() {
            Task h11 = this.f57480b.h();
            if (h11 != null) {
                return h11;
            }
            Task task = (Task) CoroutineScheduler.this.f57476g.d();
            return task == null ? v(1) : task;
        }

        public final Task g(boolean z11) {
            if (s()) {
                return e(z11);
            }
            return f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final void k(int i11) {
            this.f57483e = 0;
            if (this.f57482d == WorkerState.PARKING) {
                if (j0.a()) {
                    boolean z11 = true;
                    if (i11 != 1) {
                        z11 = false;
                    }
                    if (!z11) {
                        throw new AssertionError();
                    }
                }
                this.f57482d = WorkerState.BLOCKING;
            }
        }

        public final boolean l() {
            return this.nextParkedWorker != CoroutineScheduler.f57470m;
        }

        public final int m(int i11) {
            int i12 = this.f57485g;
            int i13 = i12 ^ (i12 << 13);
            int i14 = i13 ^ (i13 >> 17);
            int i15 = i14 ^ (i14 << 5);
            this.f57485g = i15;
            int i16 = i11 - 1;
            if ((i16 & i11) == 0) {
                return i15 & i16;
            }
            return (i15 & Integer.MAX_VALUE) % i11;
        }

        public final void n() {
            if (this.f57483e == 0) {
                this.f57483e = System.nanoTime() + CoroutineScheduler.this.f57473d;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f57473d);
            if (System.nanoTime() - this.f57483e >= 0) {
                this.f57483e = 0;
                w();
            }
        }

        public final Task o() {
            if (m(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.f57475f.d();
                if (task != null) {
                    return task;
                }
                return (Task) CoroutineScheduler.this.f57476g.d();
            }
            Task task2 = (Task) CoroutineScheduler.this.f57476g.d();
            if (task2 != null) {
                return task2;
            }
            return (Task) CoroutineScheduler.this.f57475f.d();
        }

        public final void p() {
            loop0:
            while (true) {
                boolean z11 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f57482d != WorkerState.TERMINATED) {
                    Task g11 = g(this.f57486h);
                    if (g11 != null) {
                        this.f57484f = 0;
                        d(g11);
                    } else {
                        this.f57486h = false;
                        if (this.f57484f == 0) {
                            t();
                        } else if (!z11) {
                            z11 = true;
                        } else {
                            u(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f57484f);
                            this.f57484f = 0;
                        }
                    }
                }
            }
            u(WorkerState.TERMINATED);
        }

        public final void q(int i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CoroutineScheduler.this.f57474e);
            sb2.append("-worker-");
            sb2.append(i11 == 0 ? "TERMINATED" : String.valueOf(i11));
            setName(sb2.toString());
            this.indexInArray = i11;
        }

        public final void r(Object obj) {
            this.nextParkedWorker = obj;
        }

        public void run() {
            p();
        }

        public final boolean s() {
            boolean z11;
            if (this.f57482d != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                AtomicLongFieldUpdater a11 = CoroutineScheduler.f57468k;
                while (true) {
                    long j11 = a11.get(coroutineScheduler);
                    if (((int) ((9223367638808264704L & j11) >> 42)) != 0) {
                        if (CoroutineScheduler.f57468k.compareAndSet(coroutineScheduler, j11, j11 - 4398046511104L)) {
                            z11 = true;
                            break;
                        }
                    } else {
                        z11 = false;
                        break;
                    }
                }
                if (!z11) {
                    return false;
                }
                this.f57482d = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        public final void t() {
            if (!l()) {
                CoroutineScheduler.this.o(this);
                return;
            }
            f57479j.set(this, -1);
            while (l() && f57479j.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.f57482d != WorkerState.TERMINATED) {
                u(WorkerState.PARKING);
                Thread.interrupted();
                n();
            }
        }

        public final boolean u(WorkerState workerState) {
            WorkerState workerState2 = this.f57482d;
            boolean z11 = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z11) {
                CoroutineScheduler.f57468k.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f57482d = workerState;
            }
            return z11;
        }

        public final Task v(int i11) {
            int i12 = (int) (CoroutineScheduler.f57468k.get(CoroutineScheduler.this) & 2097151);
            if (i12 < 2) {
                return null;
            }
            int m11 = m(i12);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j11 = Long.MAX_VALUE;
            for (int i13 = 0; i13 < i12; i13++) {
                m11++;
                if (m11 > i12) {
                    m11 = 1;
                }
                c b11 = coroutineScheduler.f57477h.b(m11);
                if (b11 == null || b11 == this) {
                    int i14 = i11;
                } else {
                    long n11 = b11.f57480b.n(i11, this.f57481c);
                    if (n11 == -1) {
                        Ref$ObjectRef<Task> ref$ObjectRef = this.f57481c;
                        Task task = (Task) ref$ObjectRef.element;
                        ref$ObjectRef.element = null;
                        return task;
                    } else if (n11 > 0) {
                        j11 = Math.min(j11, n11);
                    }
                }
            }
            if (j11 == Long.MAX_VALUE) {
                j11 = 0;
            }
            this.f57484f = j11;
            return null;
        }

        public final void w() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f57477h) {
                if (!coroutineScheduler.isTerminated()) {
                    if (((int) (CoroutineScheduler.f57468k.get(coroutineScheduler) & 2097151)) > coroutineScheduler.f57471b) {
                        if (f57479j.compareAndSet(this, -1, 1)) {
                            int i11 = this.indexInArray;
                            q(0);
                            coroutineScheduler.p(this, i11, 0);
                            int andDecrement = (int) (CoroutineScheduler.f57468k.getAndDecrement(coroutineScheduler) & 2097151);
                            if (andDecrement != i11) {
                                c b11 = coroutineScheduler.f57477h.b(andDecrement);
                                coroutineScheduler.f57477h.c(i11, b11);
                                b11.q(i11);
                                coroutineScheduler.p(b11, andDecrement, i11);
                            }
                            coroutineScheduler.f57477h.c(andDecrement, null);
                            Unit unit = Unit.f56620a;
                            this.f57482d = WorkerState.TERMINATED;
                        }
                    }
                }
            }
        }

        public c(CoroutineScheduler coroutineScheduler, int i11) {
            this();
            q(i11);
        }
    }
}
