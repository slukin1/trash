package kotlinx.coroutines.debug.internal;

import d10.p;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;

public final class ConcurrentWeakMap$entries$1 extends Lambda implements p<K, V, Map.Entry<K, V>> {
    public static final ConcurrentWeakMap$entries$1 INSTANCE = new ConcurrentWeakMap$entries$1();

    public ConcurrentWeakMap$entries$1() {
        super(2);
    }

    public final Map.Entry<K, V> invoke(K k11, V v11) {
        return new ConcurrentWeakMap.b(k11, v11);
    }
}
