package dagger.internal;

public final class a<T> implements q00.a<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f53571c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public volatile q00.a<T> f53572a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f53573b = f53571c;

    public a(q00.a<T> aVar) {
        this.f53572a = aVar;
    }

    public static <P extends q00.a<T>, T> q00.a<T> a(P p11) {
        d.b(p11);
        if (p11 instanceof a) {
            return p11;
        }
        return new a(p11);
    }

    public static Object b(Object obj, Object obj2) {
        if (!(obj != f53571c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t11 = this.f53573b;
        T t12 = f53571c;
        if (t11 == t12) {
            synchronized (this) {
                t11 = this.f53573b;
                if (t11 == t12) {
                    t11 = this.f53572a.get();
                    this.f53573b = b(this.f53573b, t11);
                    this.f53572a = null;
                }
            }
        }
        return t11;
    }
}
