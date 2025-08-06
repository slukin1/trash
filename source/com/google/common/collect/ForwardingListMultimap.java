package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;

@GwtCompatible
public abstract class ForwardingListMultimap<K, V> extends ForwardingMultimap<K, V> implements ListMultimap<K, V> {
    public abstract ListMultimap<K, V> delegate();

    public List<V> get(K k11) {
        return delegate().get(k11);
    }

    @CanIgnoreReturnValue
    public List<V> removeAll(Object obj) {
        return delegate().removeAll(obj);
    }

    @CanIgnoreReturnValue
    public List<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        return delegate().replaceValues(k11, iterable);
    }
}
