package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@GwtCompatible
public interface ListMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    boolean equals(Object obj);

    List<V> get(K k11);

    @CanIgnoreReturnValue
    List<V> removeAll(Object obj);

    @CanIgnoreReturnValue
    List<V> replaceValues(K k11, Iterable<? extends V> iterable);
}
