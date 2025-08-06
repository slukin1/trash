package kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class u {
    public static final <K, V> Map<K, V> a(int i11) {
        return new ConcurrentHashMap(i11);
    }
}
