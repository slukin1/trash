package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.h0;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.p0;

public abstract class EventLoopImplBase extends EventLoopImplPlatform implements p0 {

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f56946f;

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f56947g;

    /* renamed from: h  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f56948h;
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    public final class a extends c {

        /* renamed from: d  reason: collision with root package name */
        public final k<Unit> f56949d;

        public a(long j11, k<? super Unit> kVar) {
            super(j11);
            this.f56949d = kVar;
        }

        public void run() {
            this.f56949d.I(EventLoopImplBase.this, Unit.f56620a);
        }

        public String toString() {
            return super.toString() + this.f56949d;
        }
    }

    public static final class b extends c {

        /* renamed from: d  reason: collision with root package name */
        public final Runnable f56951d;

        public b(long j11, Runnable runnable) {
            super(j11);
            this.f56951d = runnable;
        }

        public void run() {
            this.f56951d.run();
        }

        public String toString() {
            return super.toString() + this.f56951d;
        }
    }

    public static abstract class c implements Runnable, Comparable<c>, x0, h0 {
        private volatile Object _heap;

        /* renamed from: b  reason: collision with root package name */
        public long f56952b;

        /* renamed from: c  reason: collision with root package name */
        public int f56953c = -1;

        public c(long j11) {
            this.f56952b = j11;
        }

        public void a(ThreadSafeHeap<?> threadSafeHeap) {
            if (this._heap != c1.f56992a) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public ThreadSafeHeap<?> c() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        public final void dispose() {
            synchronized (this) {
                Object obj = this._heap;
                if (obj != c1.f56992a) {
                    d dVar = obj instanceof d ? (d) obj : null;
                    if (dVar != null) {
                        dVar.g(this);
                    }
                    this._heap = c1.f56992a;
                    Unit unit = Unit.f56620a;
                }
            }
        }

        /* renamed from: e */
        public int compareTo(c cVar) {
            int i11 = ((this.f56952b - cVar.f56952b) > 0 ? 1 : ((this.f56952b - cVar.f56952b) == 0 ? 0 : -1));
            if (i11 > 0) {
                return 1;
            }
            return i11 < 0 ? -1 : 0;
        }

        public final int f(long j11, d dVar, EventLoopImplBase eventLoopImplBase) {
            synchronized (this) {
                if (this._heap == c1.f56992a) {
                    return 2;
                }
                synchronized (dVar) {
                    c cVar = (c) dVar.b();
                    if (eventLoopImplBase.a()) {
                        return 1;
                    }
                    if (cVar == null) {
                        dVar.f56954c = j11;
                    } else {
                        long j12 = cVar.f56952b;
                        if (j12 - j11 < 0) {
                            j11 = j12;
                        }
                        if (j11 - dVar.f56954c > 0) {
                            dVar.f56954c = j11;
                        }
                    }
                    long j13 = this.f56952b;
                    long j14 = dVar.f56954c;
                    if (j13 - j14 < 0) {
                        this.f56952b = j14;
                    }
                    dVar.a(this);
                    return 0;
                }
            }
        }

        public final boolean g(long j11) {
            return j11 - this.f56952b >= 0;
        }

        public int getIndex() {
            return this.f56953c;
        }

        public void setIndex(int i11) {
            this.f56953c = i11;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f56952b + ']';
        }
    }

    public static final class d extends ThreadSafeHeap<c> {

        /* renamed from: c  reason: collision with root package name */
        public long f56954c;

        public d(long j11) {
            this.f56954c = j11;
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<EventLoopImplBase> cls2 = EventLoopImplBase.class;
        f56946f = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_queue");
        f56947g = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_delayed");
        f56948h = AtomicIntegerFieldUpdater.newUpdater(cls2, "_isCompleted");
    }

    /* access modifiers changed from: private */
    public final boolean a() {
        return f56948h.get(this) != 0;
    }

    public long K() {
        c cVar;
        if (super.K() == 0) {
            return 0;
        }
        Object obj = f56946f.get(this);
        if (obj != null) {
            if (obj instanceof r) {
                if (!((r) obj).g()) {
                    return 0;
                }
            } else if (obj == c1.f56993b) {
                return Long.MAX_VALUE;
            } else {
                return 0;
            }
        }
        d dVar = (d) f56947g.get(this);
        if (dVar == null || (cVar = (c) dVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j11 = cVar.f56952b;
        AbstractTimeSource a11 = b.a();
        return RangesKt___RangesKt.e(j11 - (a11 != null ? a11.a() : System.nanoTime()), 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long R() {
        /*
            r9 = this;
            boolean r0 = r9.S()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f56947g
            java.lang.Object r0 = r0.get(r9)
            kotlinx.coroutines.EventLoopImplBase$d r0 = (kotlinx.coroutines.EventLoopImplBase.d) r0
            if (r0 == 0) goto L_0x0051
            boolean r3 = r0.d()
            if (r3 != 0) goto L_0x0051
            kotlinx.coroutines.AbstractTimeSource r3 = kotlinx.coroutines.b.a()
            if (r3 == 0) goto L_0x0024
            long r3 = r3.a()
            goto L_0x0028
        L_0x0024:
            long r3 = java.lang.System.nanoTime()
        L_0x0028:
            monitor-enter(r0)
            kotlinx.coroutines.internal.h0 r5 = r0.b()     // Catch:{ all -> 0x004e }
            r6 = 0
            if (r5 != 0) goto L_0x0032
            monitor-exit(r0)
            goto L_0x0049
        L_0x0032:
            kotlinx.coroutines.EventLoopImplBase$c r5 = (kotlinx.coroutines.EventLoopImplBase.c) r5     // Catch:{ all -> 0x004e }
            boolean r7 = r5.g(r3)     // Catch:{ all -> 0x004e }
            r8 = 0
            if (r7 == 0) goto L_0x0040
            boolean r5 = r9.b0(r5)     // Catch:{ all -> 0x004e }
            goto L_0x0041
        L_0x0040:
            r5 = r8
        L_0x0041:
            if (r5 == 0) goto L_0x0048
            kotlinx.coroutines.internal.h0 r5 = r0.h(r8)     // Catch:{ all -> 0x004e }
            r6 = r5
        L_0x0048:
            monitor-exit(r0)
        L_0x0049:
            kotlinx.coroutines.EventLoopImplBase$c r6 = (kotlinx.coroutines.EventLoopImplBase.c) r6
            if (r6 != 0) goto L_0x0028
            goto L_0x0051
        L_0x004e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0051:
            java.lang.Runnable r0 = r9.Z()
            if (r0 == 0) goto L_0x005b
            r0.run()
            return r1
        L_0x005b:
            long r0 = r9.K()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.R():long");
    }

    public final void Y() {
        if (!j0.a() || a()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f56946f;
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                if (obj == null) {
                    if (androidx.concurrent.futures.a.a(f56946f, this, (Object) null, c1.f56993b)) {
                        return;
                    }
                } else if (obj instanceof r) {
                    ((r) obj).d();
                    return;
                } else if (obj != c1.f56993b) {
                    r rVar = new r(8, true);
                    rVar.a((Runnable) obj);
                    if (androidx.concurrent.futures.a.a(f56946f, this, obj, rVar)) {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    public final Runnable Z() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f56946f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof r) {
                r rVar = (r) obj;
                Object j11 = rVar.j();
                if (j11 != r.f57338h) {
                    return (Runnable) j11;
                }
                androidx.concurrent.futures.a.a(f56946f, this, obj, rVar.i());
            } else if (obj == c1.f56993b) {
                return null;
            } else {
                if (androidx.concurrent.futures.a.a(f56946f, this, obj, (Object) null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    public void a0(Runnable runnable) {
        if (b0(runnable)) {
            W();
        } else {
            l0.f57369i.a0(runnable);
        }
    }

    public final boolean b0(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f56946f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (a()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f56946f, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof r) {
                r rVar = (r) obj;
                int a11 = rVar.a(runnable);
                if (a11 == 0) {
                    return true;
                }
                if (a11 == 1) {
                    androidx.concurrent.futures.a.a(f56946f, this, obj, rVar.i());
                } else if (a11 == 2) {
                    return false;
                }
            } else if (obj == c1.f56993b) {
                return false;
            } else {
                r rVar2 = new r(8, true);
                rVar2.a((Runnable) obj);
                rVar2.a(runnable);
                if (androidx.concurrent.futures.a.a(f56946f, this, obj, rVar2)) {
                    return true;
                }
            }
        }
    }

    public boolean c0() {
        if (!Q()) {
            return false;
        }
        d dVar = (d) f56947g.get(this);
        if (dVar != null && !dVar.d()) {
            return false;
        }
        Object obj = f56946f.get(this);
        if (obj != null) {
            if (obj instanceof r) {
                return ((r) obj).g();
            }
            if (obj != c1.f56993b) {
                return false;
            }
        }
        return true;
    }

    public final void d0() {
        c cVar;
        AbstractTimeSource a11 = b.a();
        long a12 = a11 != null ? a11.a() : System.nanoTime();
        while (true) {
            d dVar = (d) f56947g.get(this);
            if (dVar != null && (cVar = (c) dVar.i()) != null) {
                V(a12, cVar);
            } else {
                return;
            }
        }
    }

    public final void e0() {
        f56946f.set(this, (Object) null);
        f56947g.set(this, (Object) null);
    }

    public final void f0(long j11, c cVar) {
        int g02 = g0(j11, cVar);
        if (g02 != 0) {
            if (g02 == 1) {
                V(j11, cVar);
            } else if (g02 != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (j0(cVar)) {
            W();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.EventLoopImplBase$d} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int g0(long r4, kotlinx.coroutines.EventLoopImplBase.c r6) {
        /*
            r3 = this;
            boolean r0 = r3.a()
            if (r0 == 0) goto L_0x0008
            r4 = 1
            return r4
        L_0x0008:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = f56947g
            java.lang.Object r1 = r0.get(r3)
            kotlinx.coroutines.EventLoopImplBase$d r1 = (kotlinx.coroutines.EventLoopImplBase.d) r1
            if (r1 != 0) goto L_0x0022
            r1 = 0
            kotlinx.coroutines.EventLoopImplBase$d r2 = new kotlinx.coroutines.EventLoopImplBase$d
            r2.<init>(r4)
            androidx.concurrent.futures.a.a(r0, r3, r1, r2)
            java.lang.Object r0 = r0.get(r3)
            r1 = r0
            kotlinx.coroutines.EventLoopImplBase$d r1 = (kotlinx.coroutines.EventLoopImplBase.d) r1
        L_0x0022:
            int r4 = r6.f(r4, r1, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.g0(long, kotlinx.coroutines.EventLoopImplBase$c):int");
    }

    public final x0 h0(long j11, Runnable runnable) {
        long d11 = c1.d(j11);
        if (d11 >= 4611686018427387903L) {
            return w1.f57576b;
        }
        AbstractTimeSource a11 = b.a();
        long a12 = a11 != null ? a11.a() : System.nanoTime();
        b bVar = new b(d11 + a12, runnable);
        f0(a12, bVar);
        return bVar;
    }

    public final void i0(boolean z11) {
        f56948h.set(this, z11 ? 1 : 0);
    }

    public final boolean j0(c cVar) {
        d dVar = (d) f56947g.get(this);
        return (dVar != null ? (c) dVar.e() : null) == cVar;
    }

    public void shutdown() {
        g2.f57278a.c();
        i0(true);
        Y();
        do {
        } while (R() <= 0);
        d0();
    }

    public void t(long j11, k<? super Unit> kVar) {
        long d11 = c1.d(j11);
        if (d11 < 4611686018427387903L) {
            AbstractTimeSource a11 = b.a();
            long a12 = a11 != null ? a11.a() : System.nanoTime();
            a aVar = new a(d11 + a12, kVar);
            f0(a12, aVar);
            n.a(kVar, aVar);
        }
    }

    public x0 u(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        return p0.a.a(this, j11, runnable, coroutineContext);
    }

    public final void w(CoroutineContext coroutineContext, Runnable runnable) {
        a0(runnable);
    }
}
