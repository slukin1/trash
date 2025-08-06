package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;

@GwtCompatible
public abstract class ForwardingSetMultimap<K, V> extends ForwardingMultimap<K, V> implements SetMultimap<K, V> {
    public abstract SetMultimap<K, V> delegate();

    public Set<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    public Set<V> get(K k11) {
        return delegate().get(k11);
    }

    @CanIgnoreReturnValue
    public Set<V> removeAll(Object obj) {
        return delegate().removeAll(obj);
    }

    @CanIgnoreReturnValue
    public Set<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        return delegate().replaceValues(k11, iterable);
    }
}
