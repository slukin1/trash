package dagger.internal;

import q00.a;

public final class e<T> implements a<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f53576c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public volatile a<T> f53577a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f53578b = f53576c;

    public e(a<T> aVar) {
        this.f53577a = aVar;
    }

    public static <P extends a<T>, T> a<T> a(P p11) {
        return ((p11 instanceof e) || (p11 instanceof a)) ? p11 : new e((a) d.b(p11));
    }

    public T get() {
        T t11 = this.f53578b;
        if (t11 != f53576c) {
            return t11;
        }
        a<T> aVar = this.f53577a;
        if (aVar == null) {
            return this.f53578b;
        }
        T t12 = aVar.get();
        this.f53578b = t12;
        this.f53577a = null;
        return t12;
    }
}
