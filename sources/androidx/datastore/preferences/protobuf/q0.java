package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

public final class q0<E> extends a<E> implements RandomAccess {

    /* renamed from: e  reason: collision with root package name */
    public static final q0<Object> f9199e;

    /* renamed from: c  reason: collision with root package name */
    public E[] f9200c;

    /* renamed from: d  reason: collision with root package name */
    public int f9201d;

    static {
        q0<Object> q0Var = new q0<>(new Object[0], 0);
        f9199e = q0Var;
        q0Var.makeImmutable();
    }

    public q0(E[] eArr, int i11) {
        this.f9200c = eArr;
        this.f9201d = i11;
    }

    public static <E> E[] b(int i11) {
        return new Object[i11];
    }

    public static <E> q0<E> c() {
        return f9199e;
    }

    public boolean add(E e11) {
        a();
        int i11 = this.f9201d;
        E[] eArr = this.f9200c;
        if (i11 == eArr.length) {
            this.f9200c = Arrays.copyOf(eArr, ((i11 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f9200c;
        int i12 = this.f9201d;
        this.f9201d = i12 + 1;
        eArr2[i12] = e11;
        this.modCount++;
        return true;
    }

    public final void d(int i11) {
        if (i11 < 0 || i11 >= this.f9201d) {
            throw new IndexOutOfBoundsException(e(i11));
        }
    }

    public final String e(int i11) {
        return "Index:" + i11 + ", Size:" + this.f9201d;
    }

    /* renamed from: g */
    public q0<E> mutableCopyWithCapacity(int i11) {
        if (i11 >= this.f9201d) {
            return new q0<>(Arrays.copyOf(this.f9200c, i11), this.f9201d);
        }
        throw new IllegalArgumentException();
    }

    public E get(int i11) {
        d(i11);
        return this.f9200c[i11];
    }

    public E remove(int i11) {
        a();
        d(i11);
        E[] eArr = this.f9200c;
        E e11 = eArr[i11];
        int i12 = this.f9201d;
        if (i11 < i12 - 1) {
            System.arraycopy(eArr, i11 + 1, eArr, i11, (i12 - i11) - 1);
        }
        this.f9201d--;
        this.modCount++;
        return e11;
    }

    public E set(int i11, E e11) {
        a();
        d(i11);
        E[] eArr = this.f9200c;
        E e12 = eArr[i11];
        eArr[i11] = e11;
        this.modCount++;
        return e12;
    }

    public int size() {
        return this.f9201d;
    }

    public void add(int i11, E e11) {
        int i12;
        a();
        if (i11 < 0 || i11 > (i12 = this.f9201d)) {
            throw new IndexOutOfBoundsException(e(i11));
        }
        E[] eArr = this.f9200c;
        if (i12 < eArr.length) {
            System.arraycopy(eArr, i11, eArr, i11 + 1, i12 - i11);
        } else {
            E[] b11 = b(((i12 * 3) / 2) + 1);
            System.arraycopy(this.f9200c, 0, b11, 0, i11);
            System.arraycopy(this.f9200c, i11, b11, i11 + 1, this.f9201d - i11);
            this.f9200c = b11;
        }
        this.f9200c[i11] = e11;
        this.f9201d++;
        this.modCount++;
    }
}
