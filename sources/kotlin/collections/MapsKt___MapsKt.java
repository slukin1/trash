package kotlin.collections;

import java.util.Map;
import kotlin.sequences.g;

class MapsKt___MapsKt extends MapsKt___MapsJvmKt {
    public static <K, V> g<Map.Entry<K, V>> A(Map<? extends K, ? extends V> map) {
        return CollectionsKt___CollectionsKt.P(map.entrySet());
    }

    public static <K, V> boolean z(Map<? extends K, ? extends V> map) {
        return !map.isEmpty();
    }
}
