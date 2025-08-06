package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class e extends a<Boolean> implements u.a, RandomAccess, o0 {

    /* renamed from: e  reason: collision with root package name */
    public static final e f9104e;

    /* renamed from: c  reason: collision with root package name */
    public boolean[] f9105c;

    /* renamed from: d  reason: collision with root package name */
    public int f9106d;

    static {
        e eVar = new e(new boolean[0], 0);
        f9104e = eVar;
        eVar.makeImmutable();
    }

    public e() {
        this(new boolean[10], 0);
    }

    public boolean addAll(Collection<? extends Boolean> collection) {
        a();
        u.a(collection);
        if (!(collection instanceof e)) {
            return super.addAll(collection);
        }
        e eVar = (e) collection;
        int i11 = eVar.f9106d;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.f9106d;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            boolean[] zArr = this.f9105c;
            if (i13 > zArr.length) {
                this.f9105c = Arrays.copyOf(zArr, i13);
            }
            System.arraycopy(eVar.f9105c, 0, this.f9105c, this.f9106d, eVar.f9106d);
            this.f9106d = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addBoolean(boolean z11) {
        a();
        int i11 = this.f9106d;
        boolean[] zArr = this.f9105c;
        if (i11 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i11 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            this.f9105c = zArr2;
        }
        boolean[] zArr3 = this.f9105c;
        int i12 = this.f9106d;
        this.f9106d = i12 + 1;
        zArr3[i12] = z11;
    }

    /* renamed from: b */
    public void add(int i11, Boolean bool) {
        d(i11, bool.booleanValue());
    }

    /* renamed from: c */
    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    public final void d(int i11, boolean z11) {
        int i12;
        a();
        if (i11 < 0 || i11 > (i12 = this.f9106d)) {
            throw new IndexOutOfBoundsException(h(i11));
        }
        boolean[] zArr = this.f9105c;
        if (i12 < zArr.length) {
            System.arraycopy(zArr, i11, zArr, i11 + 1, i12 - i11);
        } else {
            boolean[] zArr2 = new boolean[(((i12 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            System.arraycopy(this.f9105c, i11, zArr2, i11 + 1, this.f9106d - i11);
            this.f9105c = zArr2;
        }
        this.f9105c[i11] = z11;
        this.f9106d++;
        this.modCount++;
    }

    public final void e(int i11) {
        if (i11 < 0 || i11 >= this.f9106d) {
            throw new IndexOutOfBoundsException(h(i11));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return super.equals(obj);
        }
        e eVar = (e) obj;
        if (this.f9106d != eVar.f9106d) {
            return false;
        }
        boolean[] zArr = eVar.f9105c;
        for (int i11 = 0; i11 < this.f9106d; i11++) {
            if (this.f9105c[i11] != zArr[i11]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public Boolean get(int i11) {
        return Boolean.valueOf(getBoolean(i11));
    }

    public boolean getBoolean(int i11) {
        e(i11);
        return this.f9105c[i11];
    }

    public final String h(int i11) {
        return "Index:" + i11 + ", Size:" + this.f9106d;
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.f9106d; i12++) {
            i11 = (i11 * 31) + u.c(this.f9105c[i12]);
        }
        return i11;
    }

    /* renamed from: i */
    public u.a mutableCopyWithCapacity(int i11) {
        if (i11 >= this.f9106d) {
            return new e(Arrays.copyOf(this.f9105c, i11), this.f9106d);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: j */
    public Boolean remove(int i11) {
        a();
        e(i11);
        boolean[] zArr = this.f9105c;
        boolean z11 = zArr[i11];
        int i12 = this.f9106d;
        if (i11 < i12 - 1) {
            System.arraycopy(zArr, i11 + 1, zArr, i11, (i12 - i11) - 1);
        }
        this.f9106d--;
        this.modCount++;
        return Boolean.valueOf(z11);
    }

    /* renamed from: k */
    public Boolean set(int i11, Boolean bool) {
        return Boolean.valueOf(setBoolean(i11, bool.booleanValue()));
    }

    public void removeRange(int i11, int i12) {
        a();
        if (i12 >= i11) {
            boolean[] zArr = this.f9105c;
            System.arraycopy(zArr, i12, zArr, i11, this.f9106d - i12);
            this.f9106d -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public boolean setBoolean(int i11, boolean z11) {
        a();
        e(i11);
        boolean[] zArr = this.f9105c;
        boolean z12 = zArr[i11];
        zArr[i11] = z11;
        return z12;
    }

    public int size() {
        return this.f9106d;
    }

    public e(boolean[] zArr, int i11) {
        this.f9105c = zArr;
        this.f9106d = i11;
    }

    public boolean remove(Object obj) {
        a();
        for (int i11 = 0; i11 < this.f9106d; i11++) {
            if (obj.equals(Boolean.valueOf(this.f9105c[i11]))) {
                boolean[] zArr = this.f9105c;
                System.arraycopy(zArr, i11 + 1, zArr, i11, (this.f9106d - i11) - 1);
                this.f9106d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
