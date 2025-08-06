package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class t extends a<Integer> implements u.g, RandomAccess, o0 {

    /* renamed from: e  reason: collision with root package name */
    public static final t f9210e;

    /* renamed from: c  reason: collision with root package name */
    public int[] f9211c;

    /* renamed from: d  reason: collision with root package name */
    public int f9212d;

    static {
        t tVar = new t(new int[0], 0);
        f9210e = tVar;
        tVar.makeImmutable();
    }

    public t() {
        this(new int[10], 0);
    }

    public boolean addAll(Collection<? extends Integer> collection) {
        a();
        u.a(collection);
        if (!(collection instanceof t)) {
            return super.addAll(collection);
        }
        t tVar = (t) collection;
        int i11 = tVar.f9212d;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.f9212d;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            int[] iArr = this.f9211c;
            if (i13 > iArr.length) {
                this.f9211c = Arrays.copyOf(iArr, i13);
            }
            System.arraycopy(tVar.f9211c, 0, this.f9211c, this.f9212d, tVar.f9212d);
            this.f9212d = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addInt(int i11) {
        a();
        int i12 = this.f9212d;
        int[] iArr = this.f9211c;
        if (i12 == iArr.length) {
            int[] iArr2 = new int[(((i12 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.f9211c = iArr2;
        }
        int[] iArr3 = this.f9211c;
        int i13 = this.f9212d;
        this.f9212d = i13 + 1;
        iArr3[i13] = i11;
    }

    /* renamed from: b */
    public void add(int i11, Integer num) {
        d(i11, num.intValue());
    }

    /* renamed from: c */
    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    public final void d(int i11, int i12) {
        int i13;
        a();
        if (i11 < 0 || i11 > (i13 = this.f9212d)) {
            throw new IndexOutOfBoundsException(h(i11));
        }
        int[] iArr = this.f9211c;
        if (i13 < iArr.length) {
            System.arraycopy(iArr, i11, iArr, i11 + 1, i13 - i11);
        } else {
            int[] iArr2 = new int[(((i13 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            System.arraycopy(this.f9211c, i11, iArr2, i11 + 1, this.f9212d - i11);
            this.f9211c = iArr2;
        }
        this.f9211c[i11] = i12;
        this.f9212d++;
        this.modCount++;
    }

    public final void e(int i11) {
        if (i11 < 0 || i11 >= this.f9212d) {
            throw new IndexOutOfBoundsException(h(i11));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return super.equals(obj);
        }
        t tVar = (t) obj;
        if (this.f9212d != tVar.f9212d) {
            return false;
        }
        int[] iArr = tVar.f9211c;
        for (int i11 = 0; i11 < this.f9212d; i11++) {
            if (this.f9211c[i11] != iArr[i11]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public Integer get(int i11) {
        return Integer.valueOf(getInt(i11));
    }

    public int getInt(int i11) {
        e(i11);
        return this.f9211c[i11];
    }

    public final String h(int i11) {
        return "Index:" + i11 + ", Size:" + this.f9212d;
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.f9212d; i12++) {
            i11 = (i11 * 31) + this.f9211c[i12];
        }
        return i11;
    }

    /* renamed from: i */
    public u.g mutableCopyWithCapacity(int i11) {
        if (i11 >= this.f9212d) {
            return new t(Arrays.copyOf(this.f9211c, i11), this.f9212d);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: j */
    public Integer remove(int i11) {
        a();
        e(i11);
        int[] iArr = this.f9211c;
        int i12 = iArr[i11];
        int i13 = this.f9212d;
        if (i11 < i13 - 1) {
            System.arraycopy(iArr, i11 + 1, iArr, i11, (i13 - i11) - 1);
        }
        this.f9212d--;
        this.modCount++;
        return Integer.valueOf(i12);
    }

    /* renamed from: k */
    public Integer set(int i11, Integer num) {
        return Integer.valueOf(setInt(i11, num.intValue()));
    }

    public void removeRange(int i11, int i12) {
        a();
        if (i12 >= i11) {
            int[] iArr = this.f9211c;
            System.arraycopy(iArr, i12, iArr, i11, this.f9212d - i12);
            this.f9212d -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int setInt(int i11, int i12) {
        a();
        e(i11);
        int[] iArr = this.f9211c;
        int i13 = iArr[i11];
        iArr[i11] = i12;
        return i13;
    }

    public int size() {
        return this.f9212d;
    }

    public t(int[] iArr, int i11) {
        this.f9211c = iArr;
        this.f9212d = i11;
    }

    public boolean remove(Object obj) {
        a();
        for (int i11 = 0; i11 < this.f9212d; i11++) {
            if (obj.equals(Integer.valueOf(this.f9211c[i11]))) {
                int[] iArr = this.f9211c;
                System.arraycopy(iArr, i11 + 1, iArr, i11, (this.f9212d - i11) - 1);
                this.f9212d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
