package androidx.core.util;

public class g<T> extends f<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Object f8482c = new Object();

    public g(int i11) {
        super(i11);
    }

    public T acquire() {
        T acquire;
        synchronized (this.f8482c) {
            acquire = super.acquire();
        }
        return acquire;
    }

    public boolean release(T t11) {
        boolean release;
        synchronized (this.f8482c) {
            release = super.release(t11);
        }
        return release;
    }
}
