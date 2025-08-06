package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@GwtCompatible
abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements ListMultimap<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    public AbstractListMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    public abstract List<V> createCollection();

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @CanIgnoreReturnValue
    public boolean put(K k11, V v11) {
        return super.put(k11, v11);
    }

    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    public Collection<V> wrapCollection(K k11, Collection<V> collection) {
        return wrapList(k11, (List) collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
    }

    public List<V> createUnmodifiableEmptyCollection() {
        return Collections.emptyList();
    }

    public List<V> get(K k11) {
        return (List) super.get(k11);
    }

    @CanIgnoreReturnValue
    public List<V> removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    @CanIgnoreReturnValue
    public List<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        return (List) super.replaceValues(k11, iterable);
    }
}
