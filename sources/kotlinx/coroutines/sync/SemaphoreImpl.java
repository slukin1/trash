package kotlinx.coroutines.sync;

import d10.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n;
import kotlinx.coroutines.q2;

public class SemaphoreImpl implements b {

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57551c;

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f57552d;

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57553e;

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f57554f;

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57555g;
    private volatile int _availablePermits;

    /* renamed from: a  reason: collision with root package name */
    public final int f57556a;

    /* renamed from: b  reason: collision with root package name */
    public final l<Throwable, Unit> f57557b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    static {
        Class<Object> cls = Object.class;
        Class<SemaphoreImpl> cls2 = SemaphoreImpl.class;
        f57551c = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, TtmlNode.TAG_HEAD);
        f57552d = AtomicLongFieldUpdater.newUpdater(cls2, "deqIdx");
        f57553e = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "tail");
        f57554f = AtomicLongFieldUpdater.newUpdater(cls2, "enqIdx");
        f57555g = AtomicIntegerFieldUpdater.newUpdater(cls2, "_availablePermits");
    }

    public SemaphoreImpl(int i11, int i12) {
        this.f57556a = i11;
        boolean z11 = true;
        if (i11 > 0) {
            if ((i12 < 0 || i12 > i11) ? false : z11) {
                c cVar = new c(0, (c) null, 2);
                this.head = cVar;
                this.tail = cVar;
                this._availablePermits = i11 - i12;
                this.f57557b = new SemaphoreImpl$onCancellationRelease$1(this);
                return;
            }
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i11).toString());
        }
        throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i11).toString());
    }

    public static /* synthetic */ Object h(SemaphoreImpl semaphoreImpl, c<? super Unit> cVar) {
        if (semaphoreImpl.l() > 0) {
            return Unit.f56620a;
        }
        Object i11 = semaphoreImpl.i(cVar);
        return i11 == IntrinsicsKt__IntrinsicsKt.d() ? i11 : Unit.f56620a;
    }

    public Object c(c<? super Unit> cVar) {
        return h(this, cVar);
    }

    public final void g(k<? super Unit> kVar) {
        while (l() <= 0) {
            if (j((q2) kVar)) {
                return;
            }
        }
        kVar.h(Unit.f56620a, this.f57557b);
    }

    public final Object i(c<? super Unit> cVar) {
        kotlinx.coroutines.l b11 = n.b(IntrinsicsKt__IntrinsicsJvmKt.c(cVar));
        try {
            if (!j(b11)) {
                g(b11);
            }
            Object v11 = b11.v();
            if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
                f.c(cVar);
            }
            if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
                return v11;
            }
            return Unit.f56620a;
        } catch (Throwable th2) {
            b11.L();
            throw th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0051, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0037, code lost:
        r10 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(kotlinx.coroutines.q2 r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = f57553e
            java.lang.Object r3 = r2.get(r0)
            kotlinx.coroutines.sync.c r3 = (kotlinx.coroutines.sync.c) r3
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = f57554f
            long r4 = r4.getAndIncrement(r0)
            kotlinx.coroutines.sync.SemaphoreImpl$addAcquireToQueue$createNewSegment$1 r6 = kotlinx.coroutines.sync.SemaphoreImpl$addAcquireToQueue$createNewSegment$1.INSTANCE
            int r7 = kotlinx.coroutines.sync.SemaphoreKt.f57563f
            long r7 = (long) r7
            long r7 = r4 / r7
        L_0x001b:
            java.lang.Object r9 = kotlinx.coroutines.internal.d.c(r3, r7, r6)
            boolean r10 = kotlinx.coroutines.internal.a0.c(r9)
            if (r10 != 0) goto L_0x005e
            kotlinx.coroutines.internal.z r10 = kotlinx.coroutines.internal.a0.b(r9)
        L_0x0029:
            java.lang.Object r13 = r2.get(r0)
            kotlinx.coroutines.internal.z r13 = (kotlinx.coroutines.internal.z) r13
            long r14 = r13.f57353d
            long r11 = r10.f57353d
            int r11 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
            if (r11 < 0) goto L_0x0039
        L_0x0037:
            r10 = 1
            goto L_0x0051
        L_0x0039:
            boolean r11 = r10.q()
            if (r11 != 0) goto L_0x0041
            r10 = 0
            goto L_0x0051
        L_0x0041:
            boolean r11 = androidx.concurrent.futures.a.a(r2, r0, r13, r10)
            if (r11 == 0) goto L_0x0054
            boolean r10 = r13.m()
            if (r10 == 0) goto L_0x0037
            r13.k()
            goto L_0x0037
        L_0x0051:
            if (r10 == 0) goto L_0x001b
            goto L_0x005e
        L_0x0054:
            boolean r11 = r10.m()
            if (r11 == 0) goto L_0x0029
            r10.k()
            goto L_0x0029
        L_0x005e:
            kotlinx.coroutines.internal.z r2 = kotlinx.coroutines.internal.a0.b(r9)
            kotlinx.coroutines.sync.c r2 = (kotlinx.coroutines.sync.c) r2
            int r3 = kotlinx.coroutines.sync.SemaphoreKt.f57563f
            long r6 = (long) r3
            long r4 = r4 % r6
            int r3 = (int) r4
            r4 = 0
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r2.r()
            boolean r4 = r5.compareAndSet(r3, r4, r1)
            if (r4 == 0) goto L_0x007b
            r1.b(r2, r3)
            r1 = 1
            return r1
        L_0x007b:
            kotlinx.coroutines.internal.c0 r4 = kotlinx.coroutines.sync.SemaphoreKt.f57559b
            kotlinx.coroutines.internal.c0 r5 = kotlinx.coroutines.sync.SemaphoreKt.f57560c
            java.util.concurrent.atomic.AtomicReferenceArray r6 = r2.r()
            boolean r4 = r6.compareAndSet(r3, r4, r5)
            if (r4 == 0) goto L_0x00c4
            boolean r2 = r1 instanceof kotlinx.coroutines.k
            if (r2 == 0) goto L_0x009c
            kotlinx.coroutines.k r1 = (kotlinx.coroutines.k) r1
            kotlin.Unit r2 = kotlin.Unit.f56620a
            d10.l<java.lang.Throwable, kotlin.Unit> r3 = r0.f57557b
            r1.h(r2, r3)
        L_0x009a:
            r1 = 1
            goto L_0x00a8
        L_0x009c:
            boolean r2 = r1 instanceof kotlinx.coroutines.selects.k
            if (r2 == 0) goto L_0x00a9
            kotlinx.coroutines.selects.k r1 = (kotlinx.coroutines.selects.k) r1
            kotlin.Unit r2 = kotlin.Unit.f56620a
            r1.d(r2)
            goto L_0x009a
        L_0x00a8:
            return r1
        L_0x00a9:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "unexpected: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x00c4:
            r1 = 1
            boolean r4 = kotlinx.coroutines.j0.a()
            if (r4 == 0) goto L_0x00e5
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r2.r()
            java.lang.Object r2 = r2.get(r3)
            kotlinx.coroutines.internal.c0 r3 = kotlinx.coroutines.sync.SemaphoreKt.f57561d
            if (r2 != r3) goto L_0x00db
            r12 = r1
            goto L_0x00dc
        L_0x00db:
            r12 = 0
        L_0x00dc:
            if (r12 == 0) goto L_0x00df
            goto L_0x00e5
        L_0x00df:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x00e5:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.j(kotlinx.coroutines.q2):boolean");
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void k() {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f57555g
            int r1 = r0.get(r3)
            int r2 = r3.f57556a
            if (r1 <= r2) goto L_0x0010
            boolean r0 = r0.compareAndSet(r3, r1, r2)
            if (r0 == 0) goto L_0x0000
        L_0x0010:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.k():void");
    }

    public final int l() {
        int andDecrement;
        do {
            andDecrement = f57555g.getAndDecrement(this);
        } while (andDecrement > this.f57556a);
        return andDecrement;
    }

    public int m() {
        return Math.max(f57555g.get(this), 0);
    }

    public final void n(kotlinx.coroutines.selects.k<?> kVar, Object obj) {
        while (l() <= 0) {
            if (j((q2) kVar)) {
                return;
            }
        }
        kVar.d(Unit.f56620a);
    }

    public boolean o() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57555g;
            int i11 = atomicIntegerFieldUpdater.get(this);
            if (i11 > this.f57556a) {
                k();
            } else if (i11 <= 0) {
                return false;
            } else {
                if (atomicIntegerFieldUpdater.compareAndSet(this, i11, i11 - 1)) {
                    return true;
                }
            }
        }
    }

    public final boolean p(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            Object D = kVar.D(Unit.f56620a, (Object) null, this.f57557b);
            if (D == null) {
                return false;
            }
            kVar.w(D);
            return true;
        } else if (obj instanceof kotlinx.coroutines.selects.k) {
            return ((kotlinx.coroutines.selects.k) obj).f(this, Unit.f56620a);
        } else {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x004e, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0034, code lost:
        r9 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean q() {
        /*
            r15 = this;
            r0 = r15
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f57551c
            java.lang.Object r2 = r1.get(r15)
            kotlinx.coroutines.sync.c r2 = (kotlinx.coroutines.sync.c) r2
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = f57552d
            long r3 = r3.getAndIncrement(r15)
            int r5 = kotlinx.coroutines.sync.SemaphoreKt.f57563f
            long r5 = (long) r5
            long r5 = r3 / r5
            kotlinx.coroutines.sync.SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1 r7 = kotlinx.coroutines.sync.SemaphoreImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE
        L_0x0018:
            java.lang.Object r8 = kotlinx.coroutines.internal.d.c(r2, r5, r7)
            boolean r9 = kotlinx.coroutines.internal.a0.c(r8)
            if (r9 != 0) goto L_0x005b
            kotlinx.coroutines.internal.z r9 = kotlinx.coroutines.internal.a0.b(r8)
        L_0x0026:
            java.lang.Object r12 = r1.get(r15)
            kotlinx.coroutines.internal.z r12 = (kotlinx.coroutines.internal.z) r12
            long r13 = r12.f57353d
            long r10 = r9.f57353d
            int r10 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r10 < 0) goto L_0x0036
        L_0x0034:
            r9 = 1
            goto L_0x004e
        L_0x0036:
            boolean r10 = r9.q()
            if (r10 != 0) goto L_0x003e
            r9 = 0
            goto L_0x004e
        L_0x003e:
            boolean r10 = androidx.concurrent.futures.a.a(r1, r15, r12, r9)
            if (r10 == 0) goto L_0x0051
            boolean r9 = r12.m()
            if (r9 == 0) goto L_0x0034
            r12.k()
            goto L_0x0034
        L_0x004e:
            if (r9 == 0) goto L_0x0018
            goto L_0x005b
        L_0x0051:
            boolean r10 = r9.m()
            if (r10 == 0) goto L_0x0026
            r9.k()
            goto L_0x0026
        L_0x005b:
            kotlinx.coroutines.internal.z r1 = kotlinx.coroutines.internal.a0.b(r8)
            kotlinx.coroutines.sync.c r1 = (kotlinx.coroutines.sync.c) r1
            r1.b()
            long r7 = r1.f57353d
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x006c
            r2 = 0
            return r2
        L_0x006c:
            int r2 = kotlinx.coroutines.sync.SemaphoreKt.f57563f
            long r5 = (long) r2
            long r3 = r3 % r5
            int r2 = (int) r3
            kotlinx.coroutines.internal.c0 r3 = kotlinx.coroutines.sync.SemaphoreKt.f57559b
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r1.r()
            java.lang.Object r3 = r4.getAndSet(r2, r3)
            if (r3 != 0) goto L_0x00af
            int r3 = kotlinx.coroutines.sync.SemaphoreKt.f57558a
            r10 = 0
        L_0x0086:
            if (r10 >= r3) goto L_0x009c
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r1.r()
            java.lang.Object r4 = r4.get(r2)
            kotlinx.coroutines.internal.c0 r5 = kotlinx.coroutines.sync.SemaphoreKt.f57560c
            if (r4 != r5) goto L_0x0098
            r4 = 1
            return r4
        L_0x0098:
            r4 = 1
            int r10 = r10 + 1
            goto L_0x0086
        L_0x009c:
            r4 = 1
            kotlinx.coroutines.internal.c0 r3 = kotlinx.coroutines.sync.SemaphoreKt.f57559b
            kotlinx.coroutines.internal.c0 r5 = kotlinx.coroutines.sync.SemaphoreKt.f57561d
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r1.r()
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            r1 = r1 ^ r4
            return r1
        L_0x00af:
            kotlinx.coroutines.internal.c0 r1 = kotlinx.coroutines.sync.SemaphoreKt.f57562e
            if (r3 != r1) goto L_0x00b7
            r1 = 0
            return r1
        L_0x00b7:
            boolean r1 = r15.p(r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.q():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void release() {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = f57555g
            int r0 = r0.getAndIncrement(r3)
            int r1 = r3.f57556a
            if (r0 >= r1) goto L_0x0014
            if (r0 < 0) goto L_0x000d
            return
        L_0x000d:
            boolean r0 = r3.q()
            if (r0 == 0) goto L_0x0000
            return
        L_0x0014:
            r3.k()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "The number of released permits cannot be greater than "
            r1.append(r2)
            int r2 = r3.f57556a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreImpl.release():void");
    }
}
