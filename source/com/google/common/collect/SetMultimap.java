package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
public interface SetMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    Set<Map.Entry<K, V>> entries();

    boolean equals(Object obj);

    Set<V> get(K k11);

    @CanIgnoreReturnValue
    Set<V> removeAll(Object obj);

    @CanIgnoreReturnValue
    Set<V> replaceValues(K k11, Iterable<? extends V> iterable);
}
