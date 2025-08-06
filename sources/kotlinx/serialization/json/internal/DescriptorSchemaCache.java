package kotlinx.serialization.json.internal;

import d10.a;
import java.util.Map;
import kotlinx.serialization.descriptors.f;

public final class DescriptorSchemaCache {

    /* renamed from: a  reason: collision with root package name */
    public final Map<f, Map<Key<Object>, Object>> f57869a = u.a(16);

    public static final class Key<T> {
    }

    public final <T> T a(f fVar, Key<T> key) {
        Map map = this.f57869a.get(fVar);
        T t11 = map != null ? map.get(key) : null;
        if (t11 == null) {
            return null;
        }
        return t11;
    }

    public final <T> T b(f fVar, Key<T> key, a<? extends T> aVar) {
        T a11 = a(fVar, key);
        if (a11 != null) {
            return a11;
        }
        T invoke = aVar.invoke();
        c(fVar, key, invoke);
        return invoke;
    }

    public final <T> void c(f fVar, Key<T> key, T t11) {
        Map<f, Map<Key<Object>, Object>> map = this.f57869a;
        Map<Key<Object>, Object> map2 = map.get(fVar);
        if (map2 == null) {
            map2 = u.a(2);
            map.put(fVar, map2);
        }
        map2.put(key, t11);
    }
}
