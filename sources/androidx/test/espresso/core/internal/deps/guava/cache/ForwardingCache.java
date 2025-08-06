package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.collect.ForwardingObject;

public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {
    public abstract Cache<K, V> delegate();

    public V getIfPresent(Object obj) {
        return delegate().getIfPresent(obj);
    }

    public void invalidateAll() {
        delegate().invalidateAll();
    }

    public void put(K k11, V v11) {
        delegate().put(k11, v11);
    }
}
