package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible(serializable = true)
class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    public final K key;
    public final V value;

    public ImmutableEntry(K k11, V v11) {
        this.key = k11;
        this.value = v11;
    }

    public final K getKey() {
        return this.key;
    }

    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v11) {
        throw new UnsupportedOperationException();
    }
}
