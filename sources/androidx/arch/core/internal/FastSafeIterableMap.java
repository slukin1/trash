package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* renamed from: f  reason: collision with root package name */
    public HashMap<K, SafeIterableMap.c<K, V>> f4741f = new HashMap<>();

    public SafeIterableMap.c<K, V> b(K k11) {
        return this.f4741f.get(k11);
    }

    public boolean contains(K k11) {
        return this.f4741f.containsKey(k11);
    }

    public V g(K k11, V v11) {
        SafeIterableMap.c b11 = b(k11);
        if (b11 != null) {
            return b11.f4747c;
        }
        this.f4741f.put(k11, e(k11, v11));
        return null;
    }

    public V h(K k11) {
        V h11 = super.h(k11);
        this.f4741f.remove(k11);
        return h11;
    }

    public Map.Entry<K, V> i(K k11) {
        if (contains(k11)) {
            return this.f4741f.get(k11).f4749e;
        }
        return null;
    }
}
