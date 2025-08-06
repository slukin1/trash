package kotlin.collections;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class e<K, V> extends AbstractMap<K, V> implements e10.e {
    public abstract Set a();

    public abstract /* bridge */ Set<Object> c();

    public abstract /* bridge */ int d();

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    public /* bridge */ Collection<Object> f() {
        return super.values();
    }

    public final /* bridge */ Set<K> keySet() {
        return c();
    }

    public final /* bridge */ int size() {
        return d();
    }

    public final /* bridge */ Collection<V> values() {
        return f();
    }
}
