package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.base.Function;
import java.util.HashMap;
import java.util.Map;

public final class Maps {

    /* renamed from: androidx.test.espresso.core.internal.deps.guava.collect.Maps$1  reason: invalid class name */
    public class AnonymousClass1 extends TransformedIterator {
    }

    public enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY {
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    public static boolean a(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> HashMap<K, V> b() {
        return new HashMap<>();
    }

    public static String c(Map<?, ?> map) {
        StringBuilder b11 = Collections2.b(map.size());
        b11.append('{');
        boolean z11 = true;
        for (Map.Entry next : map.entrySet()) {
            if (!z11) {
                b11.append(", ");
            }
            z11 = false;
            b11.append(next.getKey());
            b11.append('=');
            b11.append(next.getValue());
        }
        b11.append('}');
        return b11.toString();
    }

    public static <V> Function<Map.Entry<?, V>, V> d() {
        return EntryFunction.VALUE;
    }
}
