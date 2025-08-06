package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@GwtCompatible
class FilteredKeyMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    public final Predicate<? super K> keyPredicate;
    public final Multimap<K, V> unfiltered;

    public static class AddRejectingList<K, V> extends ForwardingList<V> {
        public final K key;

        public AddRejectingList(K k11) {
            this.key = k11;
        }

        public boolean add(V v11) {
            add(0, v11);
            return true;
        }

        public boolean addAll(Collection<? extends V> collection) {
            addAll(0, collection);
            return true;
        }

        public void add(int i11, V v11) {
            Preconditions.checkPositionIndex(i11, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        @CanIgnoreReturnValue
        public boolean addAll(int i11, Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            Preconditions.checkPositionIndex(i11, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        public List<V> delegate() {
            return Collections.emptyList();
        }
    }

    public class Entries extends ForwardingCollection<Map.Entry<K, V>> {
        public Entries() {
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!FilteredKeyMultimap.this.unfiltered.containsKey(entry.getKey()) || !FilteredKeyMultimap.this.keyPredicate.apply(entry.getKey())) {
                return false;
            }
            return FilteredKeyMultimap.this.unfiltered.remove(entry.getKey(), entry.getValue());
        }

        public Collection<Map.Entry<K, V>> delegate() {
            return Collections2.filter(FilteredKeyMultimap.this.unfiltered.entries(), FilteredKeyMultimap.this.entryPredicate());
        }
    }

    public FilteredKeyMultimap(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        this.unfiltered = (Multimap) Preconditions.checkNotNull(multimap);
        this.keyPredicate = (Predicate) Preconditions.checkNotNull(predicate);
    }

    public void clear() {
        keySet().clear();
    }

    public boolean containsKey(Object obj) {
        if (this.unfiltered.containsKey(obj)) {
            return this.keyPredicate.apply(obj);
        }
        return false;
    }

    public Map<K, Collection<V>> createAsMap() {
        return Maps.filterKeys(this.unfiltered.asMap(), this.keyPredicate);
    }

    public Collection<Map.Entry<K, V>> createEntries() {
        return new Entries();
    }

    public Set<K> createKeySet() {
        return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
    }

    public Multiset<K> createKeys() {
        return Multisets.filter(this.unfiltered.keys(), this.keyPredicate);
    }

    public Collection<V> createValues() {
        return new FilteredMultimapValues(this);
    }

    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    public Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return Maps.keyPredicateOnEntries(this.keyPredicate);
    }

    public Collection<V> get(K k11) {
        if (this.keyPredicate.apply(k11)) {
            return this.unfiltered.get(k11);
        }
        if (this.unfiltered instanceof SetMultimap) {
            return new AddRejectingSet(k11);
        }
        return new AddRejectingList(k11);
    }

    public Collection<V> removeAll(Object obj) {
        return containsKey(obj) ? this.unfiltered.removeAll(obj) : unmodifiableEmptyCollection();
    }

    public int size() {
        int i11 = 0;
        for (Collection size : asMap().values()) {
            i11 += size.size();
        }
        return i11;
    }

    public Multimap<K, V> unfiltered() {
        return this.unfiltered;
    }

    public Collection<V> unmodifiableEmptyCollection() {
        if (this.unfiltered instanceof SetMultimap) {
            return ImmutableSet.of();
        }
        return ImmutableList.of();
    }

    public static class AddRejectingSet<K, V> extends ForwardingSet<V> {
        public final K key;

        public AddRejectingSet(K k11) {
            this.key = k11;
        }

        public boolean add(V v11) {
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        public boolean addAll(Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.key);
        }

        public Set<V> delegate() {
            return Collections.emptySet();
        }
    }
}
