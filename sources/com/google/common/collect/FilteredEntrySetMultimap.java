package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Map;
import java.util.Set;

@GwtCompatible
final class FilteredEntrySetMultimap<K, V> extends FilteredEntryMultimap<K, V> implements FilteredSetMultimap<K, V> {
    public FilteredEntrySetMultimap(SetMultimap<K, V> setMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        super(setMultimap, predicate);
    }

    public Set<Map.Entry<K, V>> createEntries() {
        return Sets.filter(unfiltered().entries(), entryPredicate());
    }

    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    public Set<V> get(K k11) {
        return (Set) super.get(k11);
    }

    public Set<V> removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    public Set<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues(k11, iterable);
    }

    public SetMultimap<K, V> unfiltered() {
        return (SetMultimap) this.unfiltered;
    }
}
