package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.h0;
import kotlinx.coroutines.j0;

public class ThreadSafeHeap<T extends h0 & Comparable<? super T>> {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57293b = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size");
    private volatile int _size;

    /* renamed from: a  reason: collision with root package name */
    public T[] f57294a;

    public final void a(T t11) {
        if (j0.a()) {
            if (!(t11.c() == null)) {
                throw new AssertionError();
            }
        }
        t11.a(this);
        h0[] f11 = f();
        int c11 = c();
        j(c11 + 1);
        f11[c11] = t11;
        t11.setIndex(c11);
        l(c11);
    }

    public final T b() {
        T[] tArr = this.f57294a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return f57293b.get(this);
    }

    public final boolean d() {
        return c() == 0;
    }

    public final T e() {
        T b11;
        synchronized (this) {
            b11 = b();
        }
        return b11;
    }

    public final T[] f() {
        T[] tArr = this.f57294a;
        if (tArr == null) {
            T[] tArr2 = new h0[4];
            this.f57294a = tArr2;
            return tArr2;
        } else if (c() < tArr.length) {
            return tArr;
        } else {
            T[] tArr3 = (h0[]) Arrays.copyOf(tArr, c() * 2);
            this.f57294a = tArr3;
            return tArr3;
        }
    }

    public final boolean g(T t11) {
        boolean z11;
        synchronized (this) {
            z11 = true;
            boolean z12 = false;
            if (t11.c() == null) {
                z11 = false;
            } else {
                int index = t11.getIndex();
                if (j0.a()) {
                    if (index >= 0) {
                        z12 = true;
                    }
                    if (!z12) {
                        throw new AssertionError();
                    }
                }
                h(index);
            }
        }
        return z11;
    }

    public final T h(int i11) {
        boolean z11 = false;
        if (j0.a()) {
            if (!(c() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.f57294a;
        j(c() - 1);
        if (i11 < c()) {
            m(i11, c());
            int i12 = (i11 - 1) / 2;
            if (i11 <= 0 || ((Comparable) tArr[i11]).compareTo(tArr[i12]) >= 0) {
                k(i11);
            } else {
                m(i11, i12);
                l(i12);
            }
        }
        T t11 = tArr[c()];
        if (j0.a()) {
            if (t11.c() == this) {
                z11 = true;
            }
            if (!z11) {
                throw new AssertionError();
            }
        }
        t11.a((ThreadSafeHeap<?>) null);
        t11.setIndex(-1);
        tArr[c()] = null;
        return t11;
    }

    public final T i() {
        T h11;
        synchronized (this) {
            h11 = c() > 0 ? h(0) : null;
        }
        return h11;
    }

    public final void j(int i11) {
        f57293b.set(this, i11);
    }

    public final void k(int i11) {
        while (true) {
            int i12 = (i11 * 2) + 1;
            if (i12 < c()) {
                T[] tArr = this.f57294a;
                int i13 = i12 + 1;
                if (i13 < c() && ((Comparable) tArr[i13]).compareTo(tArr[i12]) < 0) {
                    i12 = i13;
                }
                if (((Comparable) tArr[i11]).compareTo(tArr[i12]) > 0) {
                    m(i11, i12);
                    i11 = i12;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void l(int i11) {
        while (i11 > 0) {
            T[] tArr = this.f57294a;
            int i12 = (i11 - 1) / 2;
            if (((Comparable) tArr[i12]).compareTo(tArr[i11]) > 0) {
                m(i11, i12);
                i11 = i12;
            } else {
                return;
            }
        }
    }

    public final void m(int i11, int i12) {
        T[] tArr = this.f57294a;
        T t11 = tArr[i12];
        T t12 = tArr[i11];
        tArr[i11] = t11;
        tArr[i12] = t12;
        t11.setIndex(i11);
        t12.setIndex(i12);
    }
}
