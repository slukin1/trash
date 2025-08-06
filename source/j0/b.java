package j0;

public class b<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f16005a;

    /* renamed from: b  reason: collision with root package name */
    public int f16006b;

    public b(int i11) {
        if (i11 > 0) {
            this.f16005a = new Object[i11];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public void a(T[] tArr, int i11) {
        if (i11 > tArr.length) {
            i11 = tArr.length;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            T t11 = tArr[i12];
            int i13 = this.f16006b;
            Object[] objArr = this.f16005a;
            if (i13 < objArr.length) {
                objArr[i13] = t11;
                this.f16006b = i13 + 1;
            }
        }
    }

    public T acquire() {
        int i11 = this.f16006b;
        if (i11 <= 0) {
            return null;
        }
        int i12 = i11 - 1;
        T[] tArr = this.f16005a;
        T t11 = tArr[i12];
        tArr[i12] = null;
        this.f16006b = i11 - 1;
        return t11;
    }

    public boolean release(T t11) {
        int i11 = this.f16006b;
        Object[] objArr = this.f16005a;
        if (i11 >= objArr.length) {
            return false;
        }
        objArr[i11] = t11;
        this.f16006b = i11 + 1;
        return true;
    }
}
