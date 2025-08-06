package gx;

public abstract class c<T, V> {

    /* renamed from: a  reason: collision with root package name */
    public final String f29023a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<V> f29024b;

    public c(Class<V> cls, String str) {
        this.f29023a = str;
        this.f29024b = cls;
    }

    public abstract V a(T t11);

    public String b() {
        return this.f29023a;
    }

    public void c(T t11, V v11) {
        throw new UnsupportedOperationException("Property " + b() + " is read-only");
    }
}
