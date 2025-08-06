package kotlin.collections.builders;

import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.f;

public abstract class AbstractMapBuilderEntrySet<E extends Map.Entry<? extends K, ? extends V>, K, V> extends f<E> {
    public final boolean a(E e11) {
        return b(e11);
    }

    public abstract boolean b(Map.Entry<? extends K, ? extends V> entry);

    public /* bridge */ boolean c(Map.Entry<?, ?> entry) {
        return super.remove(entry);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return a((Map.Entry) obj);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return c((Map.Entry) obj);
    }
}
