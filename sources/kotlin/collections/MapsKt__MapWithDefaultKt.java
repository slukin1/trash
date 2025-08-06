package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;

class MapsKt__MapWithDefaultKt {
    public static final <K, V> V a(Map<K, ? extends V> map, K k11) {
        if (map instanceof p) {
            return ((p) map).e(k11);
        }
        V v11 = map.get(k11);
        if (v11 != null || map.containsKey(k11)) {
            return v11;
        }
        throw new NoSuchElementException("Key " + k11 + " is missing in the map.");
    }
}
