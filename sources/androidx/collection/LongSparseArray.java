package androidx.collection;

import i0.a;

public class LongSparseArray<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f6497f = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f6498b;

    /* renamed from: c  reason: collision with root package name */
    public long[] f6499c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f6500d;

    /* renamed from: e  reason: collision with root package name */
    public int f6501e;

    public LongSparseArray() {
        this(10);
    }

    public void b(long j11, E e11) {
        int i11 = this.f6501e;
        if (i11 == 0 || j11 > this.f6499c[i11 - 1]) {
            if (this.f6498b && i11 >= this.f6499c.length) {
                f();
            }
            int i12 = this.f6501e;
            if (i12 >= this.f6499c.length) {
                int f11 = a.f(i12 + 1);
                long[] jArr = new long[f11];
                Object[] objArr = new Object[f11];
                long[] jArr2 = this.f6499c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f6500d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f6499c = jArr;
                this.f6500d = objArr;
            }
            this.f6499c[i12] = j11;
            this.f6500d[i12] = e11;
            this.f6501e = i12 + 1;
            return;
        }
        l(j11, e11);
    }

    public void c() {
        int i11 = this.f6501e;
        Object[] objArr = this.f6500d;
        for (int i12 = 0; i12 < i11; i12++) {
            objArr[i12] = null;
        }
        this.f6501e = 0;
        this.f6498b = false;
    }

    /* renamed from: d */
    public LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.f6499c = (long[]) this.f6499c.clone();
            longSparseArray.f6500d = (Object[]) this.f6500d.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e11) {
            throw new AssertionError(e11);
        }
    }

    public boolean e(long j11) {
        return i(j11) >= 0;
    }

    public final void f() {
        int i11 = this.f6501e;
        long[] jArr = this.f6499c;
        Object[] objArr = this.f6500d;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[i13];
            if (obj != f6497f) {
                if (i13 != i12) {
                    jArr[i12] = jArr[i13];
                    objArr[i12] = obj;
                    objArr[i13] = null;
                }
                i12++;
            }
        }
        this.f6498b = false;
        this.f6501e = i12;
    }

    public E g(long j11) {
        return h(j11, (Object) null);
    }

    public E h(long j11, E e11) {
        int b11 = a.b(this.f6499c, this.f6501e, j11);
        if (b11 >= 0) {
            E[] eArr = this.f6500d;
            if (eArr[b11] != f6497f) {
                return eArr[b11];
            }
        }
        return e11;
    }

    public int i(long j11) {
        if (this.f6498b) {
            f();
        }
        return a.b(this.f6499c, this.f6501e, j11);
    }

    public boolean j() {
        return o() == 0;
    }

    public long k(int i11) {
        if (this.f6498b) {
            f();
        }
        return this.f6499c[i11];
    }

    public void l(long j11, E e11) {
        int b11 = a.b(this.f6499c, this.f6501e, j11);
        if (b11 >= 0) {
            this.f6500d[b11] = e11;
            return;
        }
        int i11 = ~b11;
        int i12 = this.f6501e;
        if (i11 < i12) {
            Object[] objArr = this.f6500d;
            if (objArr[i11] == f6497f) {
                this.f6499c[i11] = j11;
                objArr[i11] = e11;
                return;
            }
        }
        if (this.f6498b && i12 >= this.f6499c.length) {
            f();
            i11 = ~a.b(this.f6499c, this.f6501e, j11);
        }
        int i13 = this.f6501e;
        if (i13 >= this.f6499c.length) {
            int f11 = a.f(i13 + 1);
            long[] jArr = new long[f11];
            Object[] objArr2 = new Object[f11];
            long[] jArr2 = this.f6499c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f6500d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f6499c = jArr;
            this.f6500d = objArr2;
        }
        int i14 = this.f6501e;
        if (i14 - i11 != 0) {
            long[] jArr3 = this.f6499c;
            int i15 = i11 + 1;
            System.arraycopy(jArr3, i11, jArr3, i15, i14 - i11);
            Object[] objArr4 = this.f6500d;
            System.arraycopy(objArr4, i11, objArr4, i15, this.f6501e - i11);
        }
        this.f6499c[i11] = j11;
        this.f6500d[i11] = e11;
        this.f6501e++;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.f6500d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.f6499c
            int r1 = r2.f6501e
            int r3 = i0.a.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.f6500d
            r0 = r4[r3]
            java.lang.Object r1 = f6497f
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.f6498b = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongSparseArray.m(long):void");
    }

    public void n(int i11) {
        Object[] objArr = this.f6500d;
        Object obj = objArr[i11];
        Object obj2 = f6497f;
        if (obj != obj2) {
            objArr[i11] = obj2;
            this.f6498b = true;
        }
    }

    public int o() {
        if (this.f6498b) {
            f();
        }
        return this.f6501e;
    }

    public E p(int i11) {
        if (this.f6498b) {
            f();
        }
        return this.f6500d[i11];
    }

    public String toString() {
        if (o() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f6501e * 28);
        sb2.append('{');
        for (int i11 = 0; i11 < this.f6501e; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            sb2.append(k(i11));
            sb2.append('=');
            Object p11 = p(i11);
            if (p11 != this) {
                sb2.append(p11);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public LongSparseArray(int i11) {
        this.f6498b = false;
        if (i11 == 0) {
            this.f6499c = a.f15940b;
            this.f6500d = a.f15941c;
            return;
        }
        int f11 = a.f(i11);
        this.f6499c = new long[f11];
        this.f6500d = new Object[f11];
    }
}
