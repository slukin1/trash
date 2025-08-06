package dagger.internal;

public final class c<T> implements b<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final c<Object> f53574b = new c<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    public final T f53575a;

    public c(T t11) {
        this.f53575a = t11;
    }

    public static <T> b<T> a(T t11) {
        return new c(d.c(t11, "instance cannot be null"));
    }

    public T get() {
        return this.f53575a;
    }
}
