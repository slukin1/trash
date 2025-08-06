package kotlin.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.sequences.g;

class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    public static <K, V> Map<K, V> h() {
        return EmptyMap.INSTANCE;
    }

    public static <K, V> V i(Map<K, ? extends V> map, K k11) {
        return MapsKt__MapWithDefaultKt.a(map, k11);
    }

    public static <K, V> HashMap<K, V> j(Pair<? extends K, ? extends V>... pairArr) {
        HashMap<K, V> hashMap = new HashMap<>(MapsKt__MapsJVMKt.d(pairArr.length));
        r(hashMap, pairArr);
        return hashMap;
    }

    public static <K, V> LinkedHashMap<K, V> k(Pair<? extends K, ? extends V>... pairArr) {
        return (LinkedHashMap) x(pairArr, new LinkedHashMap(MapsKt__MapsJVMKt.d(pairArr.length)));
    }

    public static <K, V> Map<K, V> l(Pair<? extends K, ? extends V>... pairArr) {
        return pairArr.length > 0 ? x(pairArr, new LinkedHashMap(MapsKt__MapsJVMKt.d(pairArr.length))) : h();
    }

    public static <K, V> Map<K, V> m(Pair<? extends K, ? extends V>... pairArr) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.d(pairArr.length));
        r(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> n(Map<K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return h();
        }
        if (size != 1) {
            return map;
        }
        return MapsKt__MapsJVMKt.g(map);
    }

    public static <K, V> Map<K, V> o(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final <K, V> void p(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        for (Pair pair : iterable) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V> void q(Map<? super K, ? super V> map, g<? extends Pair<? extends K, ? extends V>> gVar) {
        for (Pair pair : gVar) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V> void r(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static <K, V> Map<K, V> s(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        if (!(iterable instanceof Collection)) {
            return n(t(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return h();
        }
        if (size != 1) {
            return t(iterable, new LinkedHashMap(MapsKt__MapsJVMKt.d(collection.size())));
        }
        return MapsKt__MapsJVMKt.e((Pair) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static <K, V, M extends Map<? super K, ? super V>> M t(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m11) {
        p(m11, iterable);
        return m11;
    }

    public static <K, V> Map<K, V> u(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return h();
        }
        if (size != 1) {
            return y(map);
        }
        return MapsKt__MapsJVMKt.g(map);
    }

    public static <K, V, M extends Map<? super K, ? super V>> M v(g<? extends Pair<? extends K, ? extends V>> gVar, M m11) {
        q(m11, gVar);
        return m11;
    }

    public static <K, V> Map<K, V> w(Pair<? extends K, ? extends V>[] pairArr) {
        int length = pairArr.length;
        if (length == 0) {
            return h();
        }
        if (length != 1) {
            return x(pairArr, new LinkedHashMap(MapsKt__MapsJVMKt.d(pairArr.length)));
        }
        return MapsKt__MapsJVMKt.e(pairArr[0]);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M x(Pair<? extends K, ? extends V>[] pairArr, M m11) {
        r(m11, pairArr);
        return m11;
    }

    public static <K, V> Map<K, V> y(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap(map);
    }
}
