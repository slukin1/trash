package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
public abstract class ForwardingSortedSetMultimap<K, V> extends ForwardingSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    public abstract SortedSetMultimap<K, V> delegate();

    public Comparator<? super V> valueComparator() {
        return delegate().valueComparator();
    }

    public SortedSet<V> get(K k11) {
        return delegate().get(k11);
    }

    public SortedSet<V> removeAll(Object obj) {
        return delegate().removeAll(obj);
    }

    public SortedSet<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        return delegate().replaceValues(k11, iterable);
    }
}
