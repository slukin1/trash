package io.reactivex.rxjava3.internal.queue;

import io.reactivex.rxjava3.internal.util.f;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import k00.e;

public final class a<T> implements e<T> {

    /* renamed from: j  reason: collision with root package name */
    public static final int f55612j = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* renamed from: k  reason: collision with root package name */
    public static final Object f55613k = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final AtomicLong f55614b = new AtomicLong();

    /* renamed from: c  reason: collision with root package name */
    public int f55615c;

    /* renamed from: d  reason: collision with root package name */
    public long f55616d;

    /* renamed from: e  reason: collision with root package name */
    public final int f55617e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicReferenceArray<Object> f55618f;

    /* renamed from: g  reason: collision with root package name */
    public final int f55619g;

    /* renamed from: h  reason: collision with root package name */
    public AtomicReferenceArray<Object> f55620h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicLong f55621i = new AtomicLong();

    public a(int i11) {
        int a11 = f.a(Math.max(8, i11));
        int i12 = a11 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a11 + 1);
        this.f55618f = atomicReferenceArray;
        this.f55617e = i12;
        a(a11);
        this.f55620h = atomicReferenceArray;
        this.f55619g = i12;
        this.f55616d = (long) (i12 - 1);
        r(0);
    }

    public static int b(int i11) {
        return i11;
    }

    public static int c(long j11, int i11) {
        return b(((int) j11) & i11);
    }

    public static Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i11) {
        return atomicReferenceArray.get(i11);
    }

    public static void p(AtomicReferenceArray<Object> atomicReferenceArray, int i11, Object obj) {
        atomicReferenceArray.lazySet(i11, obj);
    }

    public final void a(int i11) {
        this.f55615c = Math.min(i11 / 4, f55612j);
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final long d() {
        return this.f55621i.get();
    }

    public final long e() {
        return this.f55614b.get();
    }

    public final long f() {
        return this.f55621i.get();
    }

    public final AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray, int i11) {
        int b11 = b(i11);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, b11);
        p(atomicReferenceArray, b11, (Object) null);
        return atomicReferenceArray2;
    }

    public final long i() {
        return this.f55614b.get();
    }

    public boolean isEmpty() {
        return i() == f();
    }

    public final T j(AtomicReferenceArray<Object> atomicReferenceArray, long j11, int i11) {
        this.f55620h = atomicReferenceArray;
        return g(atomicReferenceArray, c(j11, i11));
    }

    public final T k(AtomicReferenceArray<Object> atomicReferenceArray, long j11, int i11) {
        this.f55620h = atomicReferenceArray;
        int c11 = c(j11, i11);
        T g11 = g(atomicReferenceArray, c11);
        if (g11 != null) {
            p(atomicReferenceArray, c11, (Object) null);
            o(j11 + 1);
        }
        return g11;
    }

    public boolean l(T t11, T t12) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f55618f;
        long i11 = i();
        int i12 = this.f55617e;
        long j11 = 2 + i11;
        if (g(atomicReferenceArray, c(j11, i12)) == null) {
            int c11 = c(i11, i12);
            p(atomicReferenceArray, c11 + 1, t12);
            p(atomicReferenceArray, c11, t11);
            r(j11);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f55618f = atomicReferenceArray2;
        int c12 = c(i11, i12);
        p(atomicReferenceArray2, c12 + 1, t12);
        p(atomicReferenceArray2, c12, t11);
        q(atomicReferenceArray, atomicReferenceArray2);
        p(atomicReferenceArray, c12, f55613k);
        r(j11);
        return true;
    }

    public final void m(AtomicReferenceArray<Object> atomicReferenceArray, long j11, int i11, T t11, long j12) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f55618f = atomicReferenceArray2;
        this.f55616d = (j12 + j11) - 1;
        p(atomicReferenceArray2, i11, t11);
        q(atomicReferenceArray, atomicReferenceArray2);
        p(atomicReferenceArray, i11, f55613k);
        r(j11 + 1);
    }

    public int n() {
        long f11 = f();
        while (true) {
            long i11 = i();
            long f12 = f();
            if (f11 == f12) {
                return (int) (i11 - f12);
            }
            f11 = f12;
        }
    }

    public final void o(long j11) {
        this.f55621i.lazySet(j11);
    }

    public boolean offer(T t11) {
        Objects.requireNonNull(t11, "Null is not a valid element");
        AtomicReferenceArray<Object> atomicReferenceArray = this.f55618f;
        long e11 = e();
        int i11 = this.f55617e;
        int c11 = c(e11, i11);
        if (e11 < this.f55616d) {
            return s(atomicReferenceArray, t11, e11, c11);
        }
        long j11 = ((long) this.f55615c) + e11;
        if (g(atomicReferenceArray, c(j11, i11)) == null) {
            this.f55616d = j11 - 1;
            return s(atomicReferenceArray, t11, e11, c11);
        } else if (g(atomicReferenceArray, c(1 + e11, i11)) == null) {
            return s(atomicReferenceArray, t11, e11, c11);
        } else {
            m(atomicReferenceArray, e11, c11, t11, (long) i11);
            return true;
        }
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f55620h;
        long d11 = d();
        int i11 = this.f55619g;
        T g11 = g(atomicReferenceArray, c(d11, i11));
        return g11 == f55613k ? j(h(atomicReferenceArray, i11 + 1), d11, i11) : g11;
    }

    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f55620h;
        long d11 = d();
        int i11 = this.f55619g;
        int c11 = c(d11, i11);
        T g11 = g(atomicReferenceArray, c11);
        boolean z11 = g11 == f55613k;
        if (g11 != null && !z11) {
            p(atomicReferenceArray, c11, (Object) null);
            o(d11 + 1);
            return g11;
        } else if (z11) {
            return k(h(atomicReferenceArray, i11 + 1), d11, i11);
        } else {
            return null;
        }
    }

    public final void q(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        p(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    public final void r(long j11) {
        this.f55614b.lazySet(j11);
    }

    public final boolean s(AtomicReferenceArray<Object> atomicReferenceArray, T t11, long j11, int i11) {
        p(atomicReferenceArray, i11, t11);
        r(j11 + 1);
        return true;
    }
}
