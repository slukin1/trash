package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Map;
import java.util.Set;

@GwtCompatible
final class FilteredKeySetMultimap<K, V> extends FilteredKeyMultimap<K, V> implements FilteredSetMultimap<K, V> {

    public class EntrySet extends FilteredKeyMultimap<K, V>.Entries implements Set<Map.Entry<K, V>> {
        public EntrySet() {
            super();
        }

        public boolean equals(Object obj) {
            return Sets.equalsImpl(this, obj);
        }

        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    public FilteredKeySetMultimap(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
        super(setMultimap, predicate);
    }

    public Set<Map.Entry<K, V>> createEntries() {
        return new EntrySet();
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
