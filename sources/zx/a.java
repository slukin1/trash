package zx;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\b¨\u0006\u000e"}, d2 = {"Lzx/a;", "T", "", "a", "()Ljava/lang/Object;", "instance", "", "c", "(Ljava/lang/Object;)Z", "b", "", "maxPoolSize", "<init>", "(I)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f29434a;

    /* renamed from: b  reason: collision with root package name */
    public int f29435b;

    public a(int i11) {
        if (i11 > 0) {
            this.f29434a = new Object[i11];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0".toString());
    }

    public T a() {
        int i11 = this.f29435b;
        if (i11 <= 0) {
            return null;
        }
        int i12 = i11 - 1;
        T[] tArr = this.f29434a;
        T t11 = tArr[i12];
        tArr[i12] = null;
        this.f29435b = i11 - 1;
        return t11;
    }

    public final boolean b(T t11) {
        int i11 = this.f29435b;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.f29434a[i12] == t11) {
                return true;
            }
        }
        return false;
    }

    public boolean c(T t11) {
        if (!b(t11)) {
            int i11 = this.f29435b;
            Object[] objArr = this.f29434a;
            if (i11 >= objArr.length) {
                return false;
            }
            objArr[i11] = t11;
            this.f29435b = i11 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!".toString());
    }
}
