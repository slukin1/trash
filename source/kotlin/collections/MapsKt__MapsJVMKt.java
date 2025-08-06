package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;

class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {
    public static <K, V> Map<K, V> b(Map<K, V> map) {
        return ((MapBuilder) map).build();
    }

    public static <K, V> Map<K, V> c(int i11) {
        return new MapBuilder(i11);
    }

    public static int d(int i11) {
        if (i11 < 0) {
            return i11;
        }
        if (i11 < 3) {
            return i11 + 1;
        }
        if (i11 < 1073741824) {
            return (int) ((((float) i11) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <K, V> Map<K, V> e(Pair<? extends K, ? extends V> pair) {
        return Collections.singletonMap(pair.getFirst(), pair.getSecond());
    }

    public static <K extends Comparable<? super K>, V> SortedMap<K, V> f(Pair<? extends K, ? extends V>... pairArr) {
        TreeMap treeMap = new TreeMap();
        MapsKt__MapsKt.r(treeMap, pairArr);
        return treeMap;
    }

    public static final <K, V> Map<K, V> g(Map<? extends K, ? extends V> map) {
        Map.Entry next = map.entrySet().iterator().next();
        return Collections.singletonMap(next.getKey(), next.getValue());
    }
}
