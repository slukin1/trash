package kotlin.properties;

import kotlin.reflect.l;

final class NotNullVar<T> implements d<Object, T> {

    /* renamed from: a  reason: collision with root package name */
    public T f56810a;

    public T a(Object obj, l<?> lVar) {
        T t11 = this.f56810a;
        if (t11 != null) {
            return t11;
        }
        throw new IllegalStateException("Property " + lVar.getName() + " should be initialized before get.");
    }

    public void b(Object obj, l<?> lVar, T t11) {
        this.f56810a = t11;
    }
}
