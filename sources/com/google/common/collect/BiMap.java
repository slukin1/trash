package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;

@GwtCompatible
public interface BiMap<K, V> extends Map<K, V> {
    @CanIgnoreReturnValue
    V forcePut(K k11, V v11);

    BiMap<V, K> inverse();

    @CanIgnoreReturnValue
    V put(K k11, V v11);

    void putAll(Map<? extends K, ? extends V> map);

    Set<V> values();
}
