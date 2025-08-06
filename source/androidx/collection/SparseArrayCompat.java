package androidx.collection;

import i0.a;

public class SparseArrayCompat<E> implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    public static final Object f6509f = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f6510b;

    /* renamed from: c  reason: collision with root package name */
    public int[] f6511c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f6512d;

    /* renamed from: e  reason: collision with root package name */
    public int f6513e;

    public SparseArrayCompat() {
        this(10);
    }

    public void b(int i11, E e11) {
        int i12 = this.f6513e;
        if (i12 == 0 || i11 > this.f6511c[i12 - 1]) {
            if (this.f6510b && i12 >= this.f6511c.length) {
                f();
            }
            int i13 = this.f6513e;
            if (i13 >= this.f6511c.length) {
                int e12 = a.e(i13 + 1);
                int[] iArr = new int[e12];
                Object[] objArr = new Object[e12];
                int[] iArr2 = this.f6511c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f6512d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f6511c = iArr;
                this.f6512d = objArr;
            }
            this.f6511c[i13] = i11;
            this.f6512d[i13] = e11;
            this.f6513e = i13 + 1;
            return;
        }
        m(i11, e11);
    }

    public void c() {
        int i11 = this.f6513e;
        Object[] objArr = this.f6512d;
        for (int i12 = 0; i12 < i11; i12++) {
            objArr[i12] = null;
        }
        this.f6513e = 0;
        this.f6510b = false;
    }

    /* renamed from: d */
    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.f6511c = (int[]) this.f6511c.clone();
            sparseArrayCompat.f6512d = (Object[]) this.f6512d.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e11) {
            throw new AssertionError(e11);
        }
    }

    public boolean e(E e11) {
        return j(e11) >= 0;
    }

    public final void f() {
        int i11 = this.f6513e;
        int[] iArr = this.f6511c;
        Object[] objArr = this.f6512d;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = objArr[i13];
            if (obj != f6509f) {
                if (i13 != i12) {
                    iArr[i12] = iArr[i13];
                    objArr[i12] = obj;
                    objArr[i13] = null;
                }
                i12++;
            }
        }
        this.f6510b = false;
        this.f6513e = i12;
    }

    public E g(int i11) {
        return h(i11, (Object) null);
    }

    public E h(int i11, E e11) {
        int a11 = a.a(this.f6511c, this.f6513e, i11);
        if (a11 >= 0) {
            E[] eArr = this.f6512d;
            if (eArr[a11] != f6509f) {
                return eArr[a11];
            }
        }
        return e11;
    }

    public int i(int i11) {
        if (this.f6510b) {
            f();
        }
        return a.a(this.f6511c, this.f6513e, i11);
    }

    public int j(E e11) {
        if (this.f6510b) {
            f();
        }
        for (int i11 = 0; i11 < this.f6513e; i11++) {
            if (this.f6512d[i11] == e11) {
                return i11;
            }
        }
        return -1;
    }

    public boolean k() {
        return p() == 0;
    }

    public int l(int i11) {
        if (this.f6510b) {
            f();
        }
        return this.f6511c[i11];
    }

    public void m(int i11, E e11) {
        int a11 = a.a(this.f6511c, this.f6513e, i11);
        if (a11 >= 0) {
            this.f6512d[a11] = e11;
            return;
        }
        int i12 = ~a11;
        int i13 = this.f6513e;
        if (i12 < i13) {
            Object[] objArr = this.f6512d;
            if (objArr[i12] == f6509f) {
                this.f6511c[i12] = i11;
                objArr[i12] = e11;
                return;
            }
        }
        if (this.f6510b && i13 >= this.f6511c.length) {
            f();
            i12 = ~a.a(this.f6511c, this.f6513e, i11);
        }
        int i14 = this.f6513e;
        if (i14 >= this.f6511c.length) {
            int e12 = a.e(i14 + 1);
            int[] iArr = new int[e12];
            Object[] objArr2 = new Object[e12];
            int[] iArr2 = this.f6511c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f6512d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f6511c = iArr;
            this.f6512d = objArr2;
        }
        int i15 = this.f6513e;
        if (i15 - i12 != 0) {
            int[] iArr3 = this.f6511c;
            int i16 = i12 + 1;
            System.arraycopy(iArr3, i12, iArr3, i16, i15 - i12);
            Object[] objArr4 = this.f6512d;
            System.arraycopy(objArr4, i12, objArr4, i16, this.f6513e - i12);
        }
        this.f6511c[i12] = i11;
        this.f6512d[i12] = e11;
        this.f6513e++;
    }

    public void n(int i11) {
        Object[] objArr = this.f6512d;
        Object obj = objArr[i11];
        Object obj2 = f6509f;
        if (obj != obj2) {
            objArr[i11] = obj2;
            this.f6510b = true;
        }
    }

    public E o(int i11, E e11) {
        int i12 = i(i11);
        if (i12 < 0) {
            return null;
        }
        E[] eArr = this.f6512d;
        E e12 = eArr[i12];
        eArr[i12] = e11;
        return e12;
    }

    public int p() {
        if (this.f6510b) {
            f();
        }
        return this.f6513e;
    }

    public E q(int i11) {
        if (this.f6510b) {
            f();
        }
        return this.f6512d[i11];
    }

    public String toString() {
        if (p() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f6513e * 28);
        sb2.append('{');
        for (int i11 = 0; i11 < this.f6513e; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            sb2.append(l(i11));
            sb2.append('=');
            Object q11 = q(i11);
            if (q11 != this) {
                sb2.append(q11);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public SparseArrayCompat(int i11) {
        this.f6510b = false;
        if (i11 == 0) {
            this.f6511c = a.f15939a;
            this.f6512d = a.f15941c;
            return;
        }
        int e11 = a.e(i11);
        this.f6511c = new int[e11];
        this.f6512d = new Object[e11];
    }
}
