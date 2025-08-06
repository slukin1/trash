package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class r extends a<Float> implements u.f, RandomAccess, o0 {

    /* renamed from: e  reason: collision with root package name */
    public static final r f9202e;

    /* renamed from: c  reason: collision with root package name */
    public float[] f9203c;

    /* renamed from: d  reason: collision with root package name */
    public int f9204d;

    static {
        r rVar = new r(new float[0], 0);
        f9202e = rVar;
        rVar.makeImmutable();
    }

    public r() {
        this(new float[10], 0);
    }

    public boolean addAll(Collection<? extends Float> collection) {
        a();
        u.a(collection);
        if (!(collection instanceof r)) {
            return super.addAll(collection);
        }
        r rVar = (r) collection;
        int i11 = rVar.f9204d;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.f9204d;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            float[] fArr = this.f9203c;
            if (i13 > fArr.length) {
                this.f9203c = Arrays.copyOf(fArr, i13);
            }
            System.arraycopy(rVar.f9203c, 0, this.f9203c, this.f9204d, rVar.f9204d);
            this.f9204d = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addFloat(float f11) {
        a();
        int i11 = this.f9204d;
        float[] fArr = this.f9203c;
        if (i11 == fArr.length) {
            float[] fArr2 = new float[(((i11 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            this.f9203c = fArr2;
        }
        float[] fArr3 = this.f9203c;
        int i12 = this.f9204d;
        this.f9204d = i12 + 1;
        fArr3[i12] = f11;
    }

    /* renamed from: b */
    public void add(int i11, Float f11) {
        d(i11, f11.floatValue());
    }

    /* renamed from: c */
    public boolean add(Float f11) {
        addFloat(f11.floatValue());
        return true;
    }

    public final void d(int i11, float f11) {
        int i12;
        a();
        if (i11 < 0 || i11 > (i12 = this.f9204d)) {
            throw new IndexOutOfBoundsException(h(i11));
        }
        float[] fArr = this.f9203c;
        if (i12 < fArr.length) {
            System.arraycopy(fArr, i11, fArr, i11 + 1, i12 - i11);
        } else {
            float[] fArr2 = new float[(((i12 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            System.arraycopy(this.f9203c, i11, fArr2, i11 + 1, this.f9204d - i11);
            this.f9203c = fArr2;
        }
        this.f9203c[i11] = f11;
        this.f9204d++;
        this.modCount++;
    }

    public final void e(int i11) {
        if (i11 < 0 || i11 >= this.f9204d) {
            throw new IndexOutOfBoundsException(h(i11));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return super.equals(obj);
        }
        r rVar = (r) obj;
        if (this.f9204d != rVar.f9204d) {
            return false;
        }
        float[] fArr = rVar.f9203c;
        for (int i11 = 0; i11 < this.f9204d; i11++) {
            if (Float.floatToIntBits(this.f9203c[i11]) != Float.floatToIntBits(fArr[i11])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public Float get(int i11) {
        return Float.valueOf(getFloat(i11));
    }

    public float getFloat(int i11) {
        e(i11);
        return this.f9203c[i11];
    }

    public final String h(int i11) {
        return "Index:" + i11 + ", Size:" + this.f9204d;
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.f9204d; i12++) {
            i11 = (i11 * 31) + Float.floatToIntBits(this.f9203c[i12]);
        }
        return i11;
    }

    /* renamed from: i */
    public u.f mutableCopyWithCapacity(int i11) {
        if (i11 >= this.f9204d) {
            return new r(Arrays.copyOf(this.f9203c, i11), this.f9204d);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: j */
    public Float remove(int i11) {
        a();
        e(i11);
        float[] fArr = this.f9203c;
        float f11 = fArr[i11];
        int i12 = this.f9204d;
        if (i11 < i12 - 1) {
            System.arraycopy(fArr, i11 + 1, fArr, i11, (i12 - i11) - 1);
        }
        this.f9204d--;
        this.modCount++;
        return Float.valueOf(f11);
    }

    /* renamed from: k */
    public Float set(int i11, Float f11) {
        return Float.valueOf(setFloat(i11, f11.floatValue()));
    }

    public void removeRange(int i11, int i12) {
        a();
        if (i12 >= i11) {
            float[] fArr = this.f9203c;
            System.arraycopy(fArr, i12, fArr, i11, this.f9204d - i12);
            this.f9204d -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public float setFloat(int i11, float f11) {
        a();
        e(i11);
        float[] fArr = this.f9203c;
        float f12 = fArr[i11];
        fArr[i11] = f11;
        return f12;
    }

    public int size() {
        return this.f9204d;
    }

    public r(float[] fArr, int i11) {
        this.f9203c = fArr;
        this.f9204d = i11;
    }

    public boolean remove(Object obj) {
        a();
        for (int i11 = 0; i11 < this.f9204d; i11++) {
            if (obj.equals(Float.valueOf(this.f9203c[i11]))) {
                float[] fArr = this.f9203c;
                System.arraycopy(fArr, i11 + 1, fArr, i11, (this.f9204d - i11) - 1);
                this.f9204d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
