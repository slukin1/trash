package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.j0;

public final class r<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f57335e = new a((kotlin.jvm.internal.r) null);

    /* renamed from: f  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57336f;

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicLongFieldUpdater f57337g;

    /* renamed from: h  reason: collision with root package name */
    public static final c0 f57338h = new c0("REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: a  reason: collision with root package name */
    public final int f57339a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f57340b;

    /* renamed from: c  reason: collision with root package name */
    public final int f57341c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReferenceArray f57342d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final int a(long j11) {
            return (j11 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j11, int i11) {
            return d(j11, 1073741823) | (((long) i11) << 0);
        }

        public final long c(long j11, int i11) {
            return d(j11, 1152921503533105152L) | (((long) i11) << 30);
        }

        public final long d(long j11, long j12) {
            return j11 & (~j12);
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f57343a;

        public b(int i11) {
            this.f57343a = i11;
        }
    }

    static {
        Class<r> cls = r.class;
        f57336f = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_next");
        f57337g = AtomicLongFieldUpdater.newUpdater(cls, "_state");
    }

    public r(int i11, boolean z11) {
        this.f57339a = i11;
        this.f57340b = z11;
        int i12 = i11 - 1;
        this.f57341c = i12;
        this.f57342d = new AtomicReferenceArray(i11);
        boolean z12 = false;
        if (i12 <= 1073741823) {
            if (!((i11 & i12) == 0 ? true : z12)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d A[LOOP:1: B:20:0x006d->B:23:0x0082, LOOP_START, PHI: r0 
      PHI: (r0v3 kotlinx.coroutines.internal.r) = (r0v2 kotlinx.coroutines.internal.r), (r0v5 kotlinx.coroutines.internal.r) binds: [B:19:0x0065, B:23:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(E r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f57337g
        L_0x0002:
            long r3 = r0.get(r14)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0016
            kotlinx.coroutines.internal.r$a r15 = f57335e
            int r15 = r15.a(r3)
            return r15
        L_0x0016:
            kotlinx.coroutines.internal.r$a r1 = f57335e
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            r9 = 0
            long r5 = r5 >> r9
            int r2 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r10 = 30
            long r5 = r5 >> r10
            int r10 = (int) r5
            int r11 = r14.f57341c
            int r5 = r10 + 2
            r5 = r5 & r11
            r6 = r2 & r11
            r12 = 1
            if (r5 != r6) goto L_0x0034
            return r12
        L_0x0034:
            boolean r5 = r14.f57340b
            r6 = 1073741823(0x3fffffff, float:1.9999999)
            if (r5 != 0) goto L_0x0053
            java.util.concurrent.atomic.AtomicReferenceArray r5 = r14.f57342d
            r13 = r10 & r11
            java.lang.Object r5 = r5.get(r13)
            if (r5 == 0) goto L_0x0053
            int r1 = r14.f57339a
            r3 = 1024(0x400, float:1.435E-42)
            if (r1 < r3) goto L_0x0052
            int r10 = r10 - r2
            r2 = r10 & r6
            int r1 = r1 >> 1
            if (r2 <= r1) goto L_0x0002
        L_0x0052:
            return r12
        L_0x0053:
            int r2 = r10 + 1
            r2 = r2 & r6
            java.util.concurrent.atomic.AtomicLongFieldUpdater r5 = f57337g
            long r12 = r1.c(r3, r2)
            r1 = r5
            r2 = r14
            r5 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L_0x0002
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r14.f57342d
            r1 = r10 & r11
            r0.set(r1, r15)
            r0 = r14
        L_0x006d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = f57337g
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0084
            kotlinx.coroutines.internal.r r0 = r0.i()
            kotlinx.coroutines.internal.r r0 = r0.e(r10, r15)
            if (r0 != 0) goto L_0x006d
        L_0x0084:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.r.a(java.lang.Object):int");
    }

    public final r<E> b(long j11) {
        r<E> rVar = new r<>(this.f57339a * 2, this.f57340b);
        int i11 = (int) ((1073741823 & j11) >> 0);
        int i12 = (int) ((1152921503533105152L & j11) >> 30);
        while (true) {
            int i13 = this.f57341c;
            if ((i11 & i13) != (i12 & i13)) {
                Object obj = this.f57342d.get(i13 & i11);
                if (obj == null) {
                    obj = new b(i11);
                }
                rVar.f57342d.set(rVar.f57341c & i11, obj);
                i11++;
            } else {
                f57337g.set(rVar, f57335e.d(j11, 1152921504606846976L));
                return rVar;
            }
        }
    }

    public final r<E> c(long j11) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57336f;
        while (true) {
            r<E> rVar = (r) atomicReferenceFieldUpdater.get(this);
            if (rVar != null) {
                return rVar;
            }
            androidx.concurrent.futures.a.a(f57336f, this, (Object) null, b(j11));
        }
    }

    public final boolean d() {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f57337g;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if ((j11 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j11) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, j11 | 2305843009213693952L));
        return true;
    }

    public final r<E> e(int i11, E e11) {
        Object obj = this.f57342d.get(this.f57341c & i11);
        if (!(obj instanceof b) || ((b) obj).f57343a != i11) {
            return null;
        }
        this.f57342d.set(i11 & this.f57341c, e11);
        return this;
    }

    public final int f() {
        long j11 = f57337g.get(this);
        return (((int) ((j11 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j11) >> 0))) & 1073741823;
    }

    public final boolean g() {
        long j11 = f57337g.get(this);
        return ((int) ((1073741823 & j11) >> 0)) == ((int) ((j11 & 1152921503533105152L) >> 30));
    }

    public final long h() {
        long j11;
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f57337g;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if ((j11 & 1152921504606846976L) != 0) {
                return j11;
            }
            j12 = j11 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, j12));
        return j12;
    }

    public final r<E> i() {
        return c(h());
    }

    public final Object j() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f57337g;
        while (true) {
            long j11 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j11) != 0) {
                return f57338h;
            }
            a aVar = f57335e;
            int i11 = (int) ((1073741823 & j11) >> 0);
            int i12 = (int) ((1152921503533105152L & j11) >> 30);
            int i13 = this.f57341c;
            if ((i12 & i13) == (i11 & i13)) {
                return null;
            }
            Object obj = this.f57342d.get(i13 & i11);
            if (obj == null) {
                if (this.f57340b) {
                    return null;
                }
            } else if (obj instanceof b) {
                return null;
            } else {
                int i14 = (i11 + 1) & 1073741823;
                if (f57337g.compareAndSet(this, j11, aVar.b(j11, i14))) {
                    this.f57342d.set(this.f57341c & i11, (Object) null);
                    return obj;
                } else if (this.f57340b) {
                    r rVar = this;
                    do {
                        rVar = rVar.k(i11, i14);
                    } while (rVar != null);
                    return obj;
                }
            }
        }
    }

    public final r<E> k(int i11, int i12) {
        long j11;
        a aVar;
        int i13;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f57337g;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            aVar = f57335e;
            boolean z11 = false;
            i13 = (int) ((1073741823 & j11) >> 0);
            if (j0.a()) {
                if (i13 == i11) {
                    z11 = true;
                }
                if (!z11) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j11) != 0) {
                return i();
            }
        } while (!f57337g.compareAndSet(this, j11, aVar.b(j11, i12)));
        this.f57342d.set(this.f57341c & i13, (Object) null);
        return null;
    }
}
