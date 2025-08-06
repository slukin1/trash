package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.List;

@GwtCompatible
final class FilteredKeyListMultimap<K, V> extends FilteredKeyMultimap<K, V> implements ListMultimap<K, V> {
    public FilteredKeyListMultimap(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        super(listMultimap, predicate);
    }

    public List<V> get(K k11) {
        return (List) super.get(k11);
    }

    public List<V> removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    public List<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        return (List) super.replaceValues(k11, iterable);
    }

    public ListMultimap<K, V> unfiltered() {
        return (ListMultimap) super.unfiltered();
    }
}
