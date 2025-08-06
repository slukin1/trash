package androidx.core.util;

public class f<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f8480a;

    /* renamed from: b  reason: collision with root package name */
    public int f8481b;

    public f(int i11) {
        if (i11 > 0) {
            this.f8480a = new Object[i11];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    public final boolean a(T t11) {
        for (int i11 = 0; i11 < this.f8481b; i11++) {
            if (this.f8480a[i11] == t11) {
                return true;
            }
        }
        return false;
    }

    public T acquire() {
        int i11 = this.f8481b;
        if (i11 <= 0) {
            return null;
        }
        int i12 = i11 - 1;
        T[] tArr = this.f8480a;
        T t11 = tArr[i12];
        tArr[i12] = null;
        this.f8481b = i11 - 1;
        return t11;
    }

    public boolean release(T t11) {
        if (!a(t11)) {
            int i11 = this.f8481b;
            Object[] objArr = this.f8480a;
            if (i11 >= objArr.length) {
                return false;
            }
            objArr[i11] = t11;
            this.f8481b = i11 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
