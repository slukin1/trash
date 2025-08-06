package androidx.collection;

import i0.a;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V> {

    /* renamed from: e  reason: collision with root package name */
    public static Object[] f6502e;

    /* renamed from: f  reason: collision with root package name */
    public static int f6503f;

    /* renamed from: g  reason: collision with root package name */
    public static Object[] f6504g;

    /* renamed from: h  reason: collision with root package name */
    public static int f6505h;

    /* renamed from: b  reason: collision with root package name */
    public int[] f6506b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f6507c;

    /* renamed from: d  reason: collision with root package name */
    public int f6508d;

    public SimpleArrayMap() {
        this.f6506b = a.f15939a;
        this.f6507c = a.f15941c;
        this.f6508d = 0;
    }

    private void a(int i11) {
        Class<SimpleArrayMap> cls = SimpleArrayMap.class;
        if (i11 == 8) {
            synchronized (cls) {
                Object[] objArr = f6504g;
                if (objArr != null) {
                    this.f6507c = objArr;
                    f6504g = (Object[]) objArr[0];
                    this.f6506b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f6505h--;
                    return;
                }
            }
        } else if (i11 == 4) {
            synchronized (cls) {
                Object[] objArr2 = f6502e;
                if (objArr2 != null) {
                    this.f6507c = objArr2;
                    f6502e = (Object[]) objArr2[0];
                    this.f6506b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f6503f--;
                    return;
                }
            }
        }
        this.f6506b = new int[i11];
        this.f6507c = new Object[(i11 << 1)];
    }

    public static int c(int[] iArr, int i11, int i12) {
        try {
            return a.a(iArr, i11, i12);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void f(int[] iArr, Object[] objArr, int i11) {
        Class<SimpleArrayMap> cls = SimpleArrayMap.class;
        if (iArr.length == 8) {
            synchronized (cls) {
                if (f6505h < 10) {
                    objArr[0] = f6504g;
                    objArr[1] = iArr;
                    for (int i12 = (i11 << 1) - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f6504g = objArr;
                    f6505h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (cls) {
                if (f6503f < 10) {
                    objArr[0] = f6502e;
                    objArr[1] = iArr;
                    for (int i13 = (i11 << 1) - 1; i13 >= 2; i13--) {
                        objArr[i13] = null;
                    }
                    f6502e = objArr;
                    f6503f++;
                }
            }
        }
    }

    public void clear() {
        int i11 = this.f6508d;
        if (i11 > 0) {
            int[] iArr = this.f6506b;
            Object[] objArr = this.f6507c;
            this.f6506b = a.f15939a;
            this.f6507c = a.f15941c;
            this.f6508d = 0;
            f(iArr, objArr, i11);
        }
        if (this.f6508d > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return i(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return k(obj) >= 0;
    }

    public void d(int i11) {
        int i12 = this.f6508d;
        int[] iArr = this.f6506b;
        if (iArr.length < i11) {
            Object[] objArr = this.f6507c;
            a(i11);
            if (this.f6508d > 0) {
                System.arraycopy(iArr, 0, this.f6506b, 0, i12);
                System.arraycopy(objArr, 0, this.f6507c, 0, i12 << 1);
            }
            f(iArr, objArr, i12);
        }
        if (this.f6508d != i12) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            int i11 = 0;
            while (i11 < this.f6508d) {
                try {
                    Object l11 = l(i11);
                    Object p11 = p(i11);
                    Object obj2 = simpleArrayMap.get(l11);
                    if (p11 == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(l11)) {
                            return false;
                        }
                    } else if (!p11.equals(obj2)) {
                        return false;
                    }
                    i11++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i12 = 0;
            while (i12 < this.f6508d) {
                try {
                    Object l12 = l(i12);
                    Object p12 = p(i12);
                    Object obj3 = map.get(l12);
                    if (p12 == null) {
                        if (obj3 != null || !map.containsKey(l12)) {
                            return false;
                        }
                    } else if (!p12.equals(obj3)) {
                        return false;
                    }
                    i12++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v11) {
        int i11 = i(obj);
        return i11 >= 0 ? this.f6507c[(i11 << 1) + 1] : v11;
    }

    /* access modifiers changed from: package-private */
    public int h(Object obj, int i11) {
        int i12 = this.f6508d;
        if (i12 == 0) {
            return -1;
        }
        int c11 = c(this.f6506b, i12, i11);
        if (c11 < 0 || obj.equals(this.f6507c[c11 << 1])) {
            return c11;
        }
        int i13 = c11 + 1;
        while (i13 < i12 && this.f6506b[i13] == i11) {
            if (obj.equals(this.f6507c[i13 << 1])) {
                return i13;
            }
            i13++;
        }
        int i14 = c11 - 1;
        while (i14 >= 0 && this.f6506b[i14] == i11) {
            if (obj.equals(this.f6507c[i14 << 1])) {
                return i14;
            }
            i14--;
        }
        return ~i13;
    }

    public int hashCode() {
        int[] iArr = this.f6506b;
        Object[] objArr = this.f6507c;
        int i11 = this.f6508d;
        int i12 = 1;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            Object obj = objArr[i12];
            i14 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i13];
            i13++;
            i12 += 2;
        }
        return i14;
    }

    public int i(Object obj) {
        return obj == null ? j() : h(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f6508d <= 0;
    }

    public int j() {
        int i11 = this.f6508d;
        if (i11 == 0) {
            return -1;
        }
        int c11 = c(this.f6506b, i11, 0);
        if (c11 < 0 || this.f6507c[c11 << 1] == null) {
            return c11;
        }
        int i12 = c11 + 1;
        while (i12 < i11 && this.f6506b[i12] == 0) {
            if (this.f6507c[i12 << 1] == null) {
                return i12;
            }
            i12++;
        }
        int i13 = c11 - 1;
        while (i13 >= 0 && this.f6506b[i13] == 0) {
            if (this.f6507c[i13 << 1] == null) {
                return i13;
            }
            i13--;
        }
        return ~i12;
    }

    /* access modifiers changed from: package-private */
    public int k(Object obj) {
        int i11 = this.f6508d * 2;
        Object[] objArr = this.f6507c;
        if (obj == null) {
            for (int i12 = 1; i12 < i11; i12 += 2) {
                if (objArr[i12] == null) {
                    return i12 >> 1;
                }
            }
            return -1;
        }
        for (int i13 = 1; i13 < i11; i13 += 2) {
            if (obj.equals(objArr[i13])) {
                return i13 >> 1;
            }
        }
        return -1;
    }

    public K l(int i11) {
        return this.f6507c[i11 << 1];
    }

    public void m(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i11 = simpleArrayMap.f6508d;
        d(this.f6508d + i11);
        if (this.f6508d != 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                put(simpleArrayMap.l(i12), simpleArrayMap.p(i12));
            }
        } else if (i11 > 0) {
            System.arraycopy(simpleArrayMap.f6506b, 0, this.f6506b, 0, i11);
            System.arraycopy(simpleArrayMap.f6507c, 0, this.f6507c, 0, i11 << 1);
            this.f6508d = i11;
        }
    }

    public V n(int i11) {
        V[] vArr = this.f6507c;
        int i12 = i11 << 1;
        V v11 = vArr[i12 + 1];
        int i13 = this.f6508d;
        int i14 = 0;
        if (i13 <= 1) {
            f(this.f6506b, vArr, i13);
            this.f6506b = a.f15939a;
            this.f6507c = a.f15941c;
        } else {
            int i15 = i13 - 1;
            int[] iArr = this.f6506b;
            int i16 = 8;
            if (iArr.length <= 8 || i13 >= iArr.length / 3) {
                if (i11 < i15) {
                    int i17 = i11 + 1;
                    int i18 = i15 - i11;
                    System.arraycopy(iArr, i17, iArr, i11, i18);
                    Object[] objArr = this.f6507c;
                    System.arraycopy(objArr, i17 << 1, objArr, i12, i18 << 1);
                }
                Object[] objArr2 = this.f6507c;
                int i19 = i15 << 1;
                objArr2[i19] = null;
                objArr2[i19 + 1] = null;
            } else {
                if (i13 > 8) {
                    i16 = i13 + (i13 >> 1);
                }
                a(i16);
                if (i13 == this.f6508d) {
                    if (i11 > 0) {
                        System.arraycopy(iArr, 0, this.f6506b, 0, i11);
                        System.arraycopy(vArr, 0, this.f6507c, 0, i12);
                    }
                    if (i11 < i15) {
                        int i21 = i11 + 1;
                        int i22 = i15 - i11;
                        System.arraycopy(iArr, i21, this.f6506b, i11, i22);
                        System.arraycopy(vArr, i21 << 1, this.f6507c, i12, i22 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i14 = i15;
        }
        if (i13 == this.f6508d) {
            this.f6508d = i14;
            return v11;
        }
        throw new ConcurrentModificationException();
    }

    public V o(int i11, V v11) {
        int i12 = (i11 << 1) + 1;
        V[] vArr = this.f6507c;
        V v12 = vArr[i12];
        vArr[i12] = v11;
        return v12;
    }

    public V p(int i11) {
        return this.f6507c[(i11 << 1) + 1];
    }

    public V put(K k11, V v11) {
        int i11;
        int i12;
        int i13 = this.f6508d;
        if (k11 == null) {
            i12 = j();
            i11 = 0;
        } else {
            int hashCode = k11.hashCode();
            i11 = hashCode;
            i12 = h(k11, hashCode);
        }
        if (i12 >= 0) {
            int i14 = (i12 << 1) + 1;
            V[] vArr = this.f6507c;
            V v12 = vArr[i14];
            vArr[i14] = v11;
            return v12;
        }
        int i15 = ~i12;
        int[] iArr = this.f6506b;
        if (i13 >= iArr.length) {
            int i16 = 4;
            if (i13 >= 8) {
                i16 = (i13 >> 1) + i13;
            } else if (i13 >= 4) {
                i16 = 8;
            }
            Object[] objArr = this.f6507c;
            a(i16);
            if (i13 == this.f6508d) {
                int[] iArr2 = this.f6506b;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f6507c, 0, objArr.length);
                }
                f(iArr, objArr, i13);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i15 < i13) {
            int[] iArr3 = this.f6506b;
            int i17 = i15 + 1;
            System.arraycopy(iArr3, i15, iArr3, i17, i13 - i15);
            Object[] objArr2 = this.f6507c;
            System.arraycopy(objArr2, i15 << 1, objArr2, i17 << 1, (this.f6508d - i15) << 1);
        }
        int i18 = this.f6508d;
        if (i13 == i18) {
            int[] iArr4 = this.f6506b;
            if (i15 < iArr4.length) {
                iArr4[i15] = i11;
                Object[] objArr3 = this.f6507c;
                int i19 = i15 << 1;
                objArr3[i19] = k11;
                objArr3[i19 + 1] = v11;
                this.f6508d = i18 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k11, V v11) {
        V v12 = get(k11);
        return v12 == null ? put(k11, v11) : v12;
    }

    public V remove(Object obj) {
        int i11 = i(obj);
        if (i11 >= 0) {
            return n(i11);
        }
        return null;
    }

    public V replace(K k11, V v11) {
        int i11 = i(k11);
        if (i11 >= 0) {
            return o(i11, v11);
        }
        return null;
    }

    public int size() {
        return this.f6508d;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f6508d * 28);
        sb2.append('{');
        for (int i11 = 0; i11 < this.f6508d; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            Object l11 = l(i11);
            if (l11 != this) {
                sb2.append(l11);
            } else {
                sb2.append("(this Map)");
            }
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

    public boolean remove(Object obj, Object obj2) {
        int i11 = i(obj);
        if (i11 < 0) {
            return false;
        }
        Object p11 = p(i11);
        if (obj2 != p11 && (obj2 == null || !obj2.equals(p11))) {
            return false;
        }
        n(i11);
        return true;
    }

    public boolean replace(K k11, V v11, V v12) {
        int i11 = i(k11);
        if (i11 < 0) {
            return false;
        }
        V p11 = p(i11);
        if (p11 != v11 && (v11 == null || !v11.equals(p11))) {
            return false;
        }
        o(i11, v12);
        return true;
    }

    public SimpleArrayMap(int i11) {
        if (i11 == 0) {
            this.f6506b = a.f15939a;
            this.f6507c = a.f15941c;
        } else {
            a(i11);
        }
        this.f6508d = 0;
    }

    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            m(simpleArrayMap);
        }
    }
}
