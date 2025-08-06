package kotlin.properties;

import kotlin.reflect.l;

public abstract class b<V> implements d<Object, V> {

    /* renamed from: a  reason: collision with root package name */
    public V f56812a;

    public b(V v11) {
        this.f56812a = v11;
    }

    public V a(Object obj, l<?> lVar) {
        return this.f56812a;
    }

    public void b(Object obj, l<?> lVar, V v11) {
        V v12 = this.f56812a;
        if (d(lVar, v12, v11)) {
            this.f56812a = v11;
            c(lVar, v12, v11);
        }
    }

    public abstract void c(l<?> lVar, V v11, V v12);

    public boolean d(l<?> lVar, V v11, V v12) {
        return true;
    }
}
