package androidx.collection;

import i0.c;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f6482f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public static final Object[] f6483g = new Object[0];

    /* renamed from: h  reason: collision with root package name */
    public static Object[] f6484h;

    /* renamed from: i  reason: collision with root package name */
    public static int f6485i;

    /* renamed from: j  reason: collision with root package name */
    public static Object[] f6486j;

    /* renamed from: k  reason: collision with root package name */
    public static int f6487k;

    /* renamed from: b  reason: collision with root package name */
    public int[] f6488b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f6489c;

    /* renamed from: d  reason: collision with root package name */
    public int f6490d;

    /* renamed from: e  reason: collision with root package name */
    public c<E, E> f6491e;

    public class a extends c<E, E> {
        public a() {
        }

        public void a() {
            ArraySet.this.clear();
        }

        public Object b(int i11, int i12) {
            return ArraySet.this.f6489c[i11];
        }

        public Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        public int d() {
            return ArraySet.this.f6490d;
        }

        public int e(Object obj) {
            return ArraySet.this.indexOf(obj);
        }

        public int f(Object obj) {
            return ArraySet.this.indexOf(obj);
        }

        public void g(E e11, E e12) {
            ArraySet.this.add(e11);
        }

        public void h(int i11) {
            ArraySet.this.h(i11);
        }

        public E i(int i11, E e11) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public ArraySet() {
        this(0);
    }

    public static void c(int[] iArr, Object[] objArr, int i11) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (f6487k < 10) {
                    objArr[0] = f6486j;
                    objArr[1] = iArr;
                    for (int i12 = i11 - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f6486j = objArr;
                    f6487k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (f6485i < 10) {
                    objArr[0] = f6484h;
                    objArr[1] = iArr;
                    for (int i13 = i11 - 1; i13 >= 2; i13--) {
                        objArr[i13] = null;
                    }
                    f6484h = objArr;
                    f6485i++;
                }
            }
        }
    }

    public final void a(int i11) {
        if (i11 == 8) {
            synchronized (ArraySet.class) {
                Object[] objArr = f6486j;
                if (objArr != null) {
                    this.f6489c = objArr;
                    f6486j = (Object[]) objArr[0];
                    this.f6488b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f6487k--;
                    return;
                }
            }
        } else if (i11 == 4) {
            synchronized (ArraySet.class) {
                Object[] objArr2 = f6484h;
                if (objArr2 != null) {
                    this.f6489c = objArr2;
                    f6484h = (Object[]) objArr2[0];
                    this.f6488b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f6485i--;
                    return;
                }
            }
        }
        this.f6488b = new int[i11];
        this.f6489c = new Object[i11];
    }

    public boolean add(E e11) {
        int i11;
        int i12;
        if (e11 == null) {
            i12 = g();
            i11 = 0;
        } else {
            int hashCode = e11.hashCode();
            i11 = hashCode;
            i12 = e(e11, hashCode);
        }
        if (i12 >= 0) {
            return false;
        }
        int i13 = ~i12;
        int i14 = this.f6490d;
        int[] iArr = this.f6488b;
        if (i14 >= iArr.length) {
            int i15 = 4;
            if (i14 >= 8) {
                i15 = (i14 >> 1) + i14;
            } else if (i14 >= 4) {
                i15 = 8;
            }
            Object[] objArr = this.f6489c;
            a(i15);
            int[] iArr2 = this.f6488b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f6489c, 0, objArr.length);
            }
            c(iArr, objArr, this.f6490d);
        }
        int i16 = this.f6490d;
        if (i13 < i16) {
            int[] iArr3 = this.f6488b;
            int i17 = i13 + 1;
            System.arraycopy(iArr3, i13, iArr3, i17, i16 - i13);
            Object[] objArr2 = this.f6489c;
            System.arraycopy(objArr2, i13, objArr2, i17, this.f6490d - i13);
        }
        this.f6488b[i13] = i11;
        this.f6489c[i13] = e11;
        this.f6490d++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        b(this.f6490d + collection.size());
        boolean z11 = false;
        for (Object add : collection) {
            z11 |= add(add);
        }
        return z11;
    }

    public void b(int i11) {
        int[] iArr = this.f6488b;
        if (iArr.length < i11) {
            Object[] objArr = this.f6489c;
            a(i11);
            int i12 = this.f6490d;
            if (i12 > 0) {
                System.arraycopy(iArr, 0, this.f6488b, 0, i12);
                System.arraycopy(objArr, 0, this.f6489c, 0, this.f6490d);
            }
            c(iArr, objArr, this.f6490d);
        }
    }

    public void clear() {
        int i11 = this.f6490d;
        if (i11 != 0) {
            c(this.f6488b, this.f6489c, i11);
            this.f6488b = f6482f;
            this.f6489c = f6483g;
            this.f6490d = 0;
        }
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final c<E, E> d() {
        if (this.f6491e == null) {
            this.f6491e = new a();
        }
        return this.f6491e;
    }

    public final int e(Object obj, int i11) {
        int i12 = this.f6490d;
        if (i12 == 0) {
            return -1;
        }
        int a11 = i0.a.a(this.f6488b, i12, i11);
        if (a11 < 0 || obj.equals(this.f6489c[a11])) {
            return a11;
        }
        int i13 = a11 + 1;
        while (i13 < i12 && this.f6488b[i13] == i11) {
            if (obj.equals(this.f6489c[i13])) {
                return i13;
            }
            i13++;
        }
        int i14 = a11 - 1;
        while (i14 >= 0 && this.f6488b[i14] == i11) {
            if (obj.equals(this.f6489c[i14])) {
                return i14;
            }
            i14--;
        }
        return ~i13;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i11 = 0;
            while (i11 < this.f6490d) {
                try {
                    if (!set.contains(i(i11))) {
                        return false;
                    }
                    i11++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        int i11 = this.f6490d;
        if (i11 == 0) {
            return -1;
        }
        int a11 = i0.a.a(this.f6488b, i11, 0);
        if (a11 < 0 || this.f6489c[a11] == null) {
            return a11;
        }
        int i12 = a11 + 1;
        while (i12 < i11 && this.f6488b[i12] == 0) {
            if (this.f6489c[i12] == null) {
                return i12;
            }
            i12++;
        }
        int i13 = a11 - 1;
        while (i13 >= 0 && this.f6488b[i13] == 0) {
            if (this.f6489c[i13] == null) {
                return i13;
            }
            i13--;
        }
        return ~i12;
    }

    public E h(int i11) {
        E[] eArr = this.f6489c;
        E e11 = eArr[i11];
        int i12 = this.f6490d;
        if (i12 <= 1) {
            c(this.f6488b, eArr, i12);
            this.f6488b = f6482f;
            this.f6489c = f6483g;
            this.f6490d = 0;
        } else {
            int[] iArr = this.f6488b;
            int i13 = 8;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                int i14 = i12 - 1;
                this.f6490d = i14;
                if (i11 < i14) {
                    int i15 = i11 + 1;
                    System.arraycopy(iArr, i15, iArr, i11, i14 - i11);
                    Object[] objArr = this.f6489c;
                    System.arraycopy(objArr, i15, objArr, i11, this.f6490d - i11);
                }
                this.f6489c[this.f6490d] = null;
            } else {
                if (i12 > 8) {
                    i13 = i12 + (i12 >> 1);
                }
                a(i13);
                this.f6490d--;
                if (i11 > 0) {
                    System.arraycopy(iArr, 0, this.f6488b, 0, i11);
                    System.arraycopy(eArr, 0, this.f6489c, 0, i11);
                }
                int i16 = this.f6490d;
                if (i11 < i16) {
                    int i17 = i11 + 1;
                    System.arraycopy(iArr, i17, this.f6488b, i11, i16 - i11);
                    System.arraycopy(eArr, i17, this.f6489c, i11, this.f6490d - i11);
                }
            }
        }
        return e11;
    }

    public int hashCode() {
        int[] iArr = this.f6488b;
        int i11 = this.f6490d;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += iArr[i13];
        }
        return i12;
    }

    public E i(int i11) {
        return this.f6489c[i11];
    }

    public int indexOf(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f6490d <= 0;
    }

    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        h(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z11 = false;
        for (Object remove : collection) {
            z11 |= remove(remove);
        }
        return z11;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z11 = false;
        for (int i11 = this.f6490d - 1; i11 >= 0; i11--) {
            if (!collection.contains(this.f6489c[i11])) {
                h(i11);
                z11 = true;
            }
        }
        return z11;
    }

    public int size() {
        return this.f6490d;
    }

    public Object[] toArray() {
        int i11 = this.f6490d;
        Object[] objArr = new Object[i11];
        System.arraycopy(this.f6489c, 0, objArr, 0, i11);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f6490d * 14);
        sb2.append('{');
        for (int i11 = 0; i11 < this.f6490d; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            Object i12 = i(i11);
            if (i12 != this) {
                sb2.append(i12);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public ArraySet(int i11) {
        if (i11 == 0) {
            this.f6488b = f6482f;
            this.f6489c = f6483g;
        } else {
            a(i11);
        }
        this.f6490d = 0;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f6490d) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f6490d);
        }
        System.arraycopy(this.f6489c, 0, tArr, 0, this.f6490d);
        int length = tArr.length;
        int i11 = this.f6490d;
        if (length > i11) {
            tArr[i11] = null;
        }
        return tArr;
    }
}
