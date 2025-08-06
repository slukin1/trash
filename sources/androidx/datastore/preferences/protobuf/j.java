package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.u;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class j extends a<Double> implements u.b, RandomAccess, o0 {

    /* renamed from: e  reason: collision with root package name */
    public static final j f9170e;

    /* renamed from: c  reason: collision with root package name */
    public double[] f9171c;

    /* renamed from: d  reason: collision with root package name */
    public int f9172d;

    static {
        j jVar = new j(new double[0], 0);
        f9170e = jVar;
        jVar.makeImmutable();
    }

    public j() {
        this(new double[10], 0);
    }

    public boolean addAll(Collection<? extends Double> collection) {
        a();
        u.a(collection);
        if (!(collection instanceof j)) {
            return super.addAll(collection);
        }
        j jVar = (j) collection;
        int i11 = jVar.f9172d;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.f9172d;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            double[] dArr = this.f9171c;
            if (i13 > dArr.length) {
                this.f9171c = Arrays.copyOf(dArr, i13);
            }
            System.arraycopy(jVar.f9171c, 0, this.f9171c, this.f9172d, jVar.f9172d);
            this.f9172d = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addDouble(double d11) {
        a();
        int i11 = this.f9172d;
        double[] dArr = this.f9171c;
        if (i11 == dArr.length) {
            double[] dArr2 = new double[(((i11 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i11);
            this.f9171c = dArr2;
        }
        double[] dArr3 = this.f9171c;
        int i12 = this.f9172d;
        this.f9172d = i12 + 1;
        dArr3[i12] = d11;
    }

    /* renamed from: b */
    public void add(int i11, Double d11) {
        d(i11, d11.doubleValue());
    }

    /* renamed from: c */
    public boolean add(Double d11) {
        addDouble(d11.doubleValue());
        return true;
    }

    public final void d(int i11, double d11) {
        int i12;
        a();
        if (i11 < 0 || i11 > (i12 = this.f9172d)) {
            throw new IndexOutOfBoundsException(h(i11));
        }
        double[] dArr = this.f9171c;
        if (i12 < dArr.length) {
            System.arraycopy(dArr, i11, dArr, i11 + 1, i12 - i11);
        } else {
            double[] dArr2 = new double[(((i12 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i11);
            System.arraycopy(this.f9171c, i11, dArr2, i11 + 1, this.f9172d - i11);
            this.f9171c = dArr2;
        }
        this.f9171c[i11] = d11;
        this.f9172d++;
        this.modCount++;
    }

    public final void e(int i11) {
        if (i11 < 0 || i11 >= this.f9172d) {
            throw new IndexOutOfBoundsException(h(i11));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return super.equals(obj);
        }
        j jVar = (j) obj;
        if (this.f9172d != jVar.f9172d) {
            return false;
        }
        double[] dArr = jVar.f9171c;
        for (int i11 = 0; i11 < this.f9172d; i11++) {
            if (Double.doubleToLongBits(this.f9171c[i11]) != Double.doubleToLongBits(dArr[i11])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public Double get(int i11) {
        return Double.valueOf(getDouble(i11));
    }

    public double getDouble(int i11) {
        e(i11);
        return this.f9171c[i11];
    }

    public final String h(int i11) {
        return "Index:" + i11 + ", Size:" + this.f9172d;
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.f9172d; i12++) {
            i11 = (i11 * 31) + u.f(Double.doubleToLongBits(this.f9171c[i12]));
        }
        return i11;
    }

    /* renamed from: i */
    public u.b mutableCopyWithCapacity(int i11) {
        if (i11 >= this.f9172d) {
            return new j(Arrays.copyOf(this.f9171c, i11), this.f9172d);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: j */
    public Double remove(int i11) {
        a();
        e(i11);
        double[] dArr = this.f9171c;
        double d11 = dArr[i11];
        int i12 = this.f9172d;
        if (i11 < i12 - 1) {
            System.arraycopy(dArr, i11 + 1, dArr, i11, (i12 - i11) - 1);
        }
        this.f9172d--;
        this.modCount++;
        return Double.valueOf(d11);
    }

    /* renamed from: k */
    public Double set(int i11, Double d11) {
        return Double.valueOf(setDouble(i11, d11.doubleValue()));
    }

    public void removeRange(int i11, int i12) {
        a();
        if (i12 >= i11) {
            double[] dArr = this.f9171c;
            System.arraycopy(dArr, i12, dArr, i11, this.f9172d - i12);
            this.f9172d -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public double setDouble(int i11, double d11) {
        a();
        e(i11);
        double[] dArr = this.f9171c;
        double d12 = dArr[i11];
        dArr[i11] = d11;
        return d12;
    }

    public int size() {
        return this.f9172d;
    }

    public j(double[] dArr, int i11) {
        this.f9171c = dArr;
        this.f9172d = i11;
    }

    public boolean remove(Object obj) {
        a();
        for (int i11 = 0; i11 < this.f9172d; i11++) {
            if (obj.equals(Double.valueOf(this.f9171c[i11]))) {
                double[] dArr = this.f9171c;
                System.arraycopy(dArr, i11 + 1, dArr, i11, (this.f9172d - i11) - 1);
                this.f9172d--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }
}
