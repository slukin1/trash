package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public abstract class ForwardingConcurrentMap<K, V> extends ForwardingMap<K, V> implements ConcurrentMap<K, V> {
    public abstract ConcurrentMap<K, V> delegate();

    @CanIgnoreReturnValue
    public V putIfAbsent(K k11, V v11) {
        return delegate().putIfAbsent(k11, v11);
    }

    @CanIgnoreReturnValue
    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @CanIgnoreReturnValue
    public V replace(K k11, V v11) {
        return delegate().replace(k11, v11);
    }

    @CanIgnoreReturnValue
    public boolean replace(K k11, V v11, V v12) {
        return delegate().replace(k11, v11, v12);
    }
}
