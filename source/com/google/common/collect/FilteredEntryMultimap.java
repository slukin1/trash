package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtCompatible
class FilteredEntryMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    public final Predicate<? super Map.Entry<K, V>> predicate;
    public final Multimap<K, V> unfiltered;

    public class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        public AsMap() {
        }

        public void clear() {
            FilteredEntryMultimap.this.clear();
        }

        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        public Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new Maps.EntrySet<K, Collection<V>>() {
                public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                    return new AbstractIterator<Map.Entry<K, Collection<V>>>() {
                        public final Iterator<Map.Entry<K, Collection<V>>> backingIterator;

                        {
                            this.backingIterator = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
                        }

                        public Map.Entry<K, Collection<V>> computeNext() {
                            while (this.backingIterator.hasNext()) {
                                Map.Entry next = this.backingIterator.next();
                                Object key = next.getKey();
                                Collection filterCollection = FilteredEntryMultimap.filterCollection((Collection) next.getValue(), new ValuePredicate(key));
                                if (!filterCollection.isEmpty()) {
                                    return Maps.immutableEntry(key, filterCollection);
                                }
                            }
                            return (Map.Entry) endOfData();
                        }
                    };
                }

                public Map<K, Collection<V>> map() {
                    return AsMap.this;
                }

                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Predicates.in(collection));
                }

                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Predicates.not(Predicates.in(collection)));
                }

                public int size() {
                    return Iterators.size(iterator());
                }
            };
        }

        public Set<K> createKeySet() {
            return new Maps.KeySet<K, Collection<V>>() {
                public boolean remove(Object obj) {
                    return AsMap.this.remove(obj) != null;
                }

                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.in(collection)));
                }

                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection))));
                }
            };
        }

        public Collection<Collection<V>> createValues() {
            return new Maps.Values<K, Collection<V>>() {
                public boolean remove(Object obj) {
                    if (!(obj instanceof Collection)) {
                        return false;
                    }
                    Collection collection = (Collection) obj;
                    Iterator<Map.Entry<K, Collection<V>>> it2 = FilteredEntryMultimap.this.unfiltered.asMap().entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry next = it2.next();
                        Collection filterCollection = FilteredEntryMultimap.filterCollection((Collection) next.getValue(), new ValuePredicate(next.getKey()));
                        if (!filterCollection.isEmpty() && collection.equals(filterCollection)) {
                            if (filterCollection.size() == ((Collection) next.getValue()).size()) {
                                it2.remove();
                                return true;
                            }
                            filterCollection.clear();
                            return true;
                        }
                    }
                    return false;
                }

                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.in(collection)));
                }

                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.removeEntriesIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection))));
                }
            };
        }

        public Collection<V> get(Object obj) {
            Collection collection = FilteredEntryMultimap.this.unfiltered.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> filterCollection = FilteredEntryMultimap.filterCollection(collection, new ValuePredicate(obj));
            if (filterCollection.isEmpty()) {
                return null;
            }
            return filterCollection;
        }

        public Collection<V> remove(Object obj) {
            Collection collection = FilteredEntryMultimap.this.unfiltered.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            ArrayList newArrayList = Lists.newArrayList();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (FilteredEntryMultimap.this.satisfies(obj, next)) {
                    it2.remove();
                    newArrayList.add(next);
                }
            }
            if (newArrayList.isEmpty()) {
                return null;
            }
            if (FilteredEntryMultimap.this.unfiltered instanceof SetMultimap) {
                return Collections.unmodifiableSet(Sets.newLinkedHashSet(newArrayList));
            }
            return Collections.unmodifiableList(newArrayList);
        }
    }

    public class Keys extends Multimaps.Keys<K, V> {
        public Keys() {
            super(FilteredEntryMultimap.this);
        }

        public Set<Multiset.Entry<K>> entrySet() {
            return new Multisets.EntrySet<K>() {
                private boolean removeEntriesIf(final Predicate<? super Multiset.Entry<K>> predicate) {
                    return FilteredEntryMultimap.this.removeEntriesIf(new Predicate<Map.Entry<K, Collection<V>>>() {
                        public boolean apply(Map.Entry<K, Collection<V>> entry) {
                            return predicate.apply(Multisets.immutableEntry(entry.getKey(), entry.getValue().size()));
                        }
                    });
                }

                public Iterator<Multiset.Entry<K>> iterator() {
                    return Keys.this.entryIterator();
                }

                public Multiset<K> multiset() {
                    return Keys.this;
                }

                public boolean removeAll(Collection<?> collection) {
                    return removeEntriesIf(Predicates.in(collection));
                }

                public boolean retainAll(Collection<?> collection) {
                    return removeEntriesIf(Predicates.not(Predicates.in(collection)));
                }

                public int size() {
                    return FilteredEntryMultimap.this.keySet().size();
                }
            };
        }

        public int remove(Object obj, int i11) {
            CollectPreconditions.checkNonnegative(i11, "occurrences");
            if (i11 == 0) {
                return count(obj);
            }
            Collection collection = FilteredEntryMultimap.this.unfiltered.asMap().get(obj);
            int i12 = 0;
            if (collection == null) {
                return 0;
            }
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                if (FilteredEntryMultimap.this.satisfies(obj, it2.next()) && (i12 = i12 + 1) <= i11) {
                    it2.remove();
                }
            }
            return i12;
        }
    }

    public final class ValuePredicate implements Predicate<V> {
        private final K key;

        public ValuePredicate(K k11) {
            this.key = k11;
        }

        public boolean apply(V v11) {
            return FilteredEntryMultimap.this.satisfies(this.key, v11);
        }
    }

    public FilteredEntryMultimap(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate2) {
        this.unfiltered = (Multimap) Preconditions.checkNotNull(multimap);
        this.predicate = (Predicate) Preconditions.checkNotNull(predicate2);
    }

    public static <E> Collection<E> filterCollection(Collection<E> collection, Predicate<? super E> predicate2) {
        if (collection instanceof Set) {
            return Sets.filter((Set) collection, predicate2);
        }
        return Collections2.filter(collection, predicate2);
    }

    /* access modifiers changed from: private */
    public boolean satisfies(K k11, V v11) {
        return this.predicate.apply(Maps.immutableEntry(k11, v11));
    }

    public void clear() {
        entries().clear();
    }

    public boolean containsKey(Object obj) {
        return asMap().get(obj) != null;
    }

    public Map<K, Collection<V>> createAsMap() {
        return new AsMap();
    }

    public Collection<Map.Entry<K, V>> createEntries() {
        return filterCollection(this.unfiltered.entries(), this.predicate);
    }

    public Set<K> createKeySet() {
        return asMap().keySet();
    }

    public Multiset<K> createKeys() {
        return new Keys();
    }

    public Collection<V> createValues() {
        return new FilteredMultimapValues(this);
    }

    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    public Predicate<? super Map.Entry<K, V>> entryPredicate() {
        return this.predicate;
    }

    public Collection<V> get(K k11) {
        return filterCollection(this.unfiltered.get(k11), new ValuePredicate(k11));
    }

    public Collection<V> removeAll(Object obj) {
        return (Collection) MoreObjects.firstNonNull(asMap().remove(obj), unmodifiableEmptyCollection());
    }

    public boolean removeEntriesIf(Predicate<? super Map.Entry<K, Collection<V>>> predicate2) {
        Iterator<Map.Entry<K, Collection<V>>> it2 = this.unfiltered.asMap().entrySet().iterator();
        boolean z11 = false;
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            Object key = next.getKey();
            Collection filterCollection = filterCollection((Collection) next.getValue(), new ValuePredicate(key));
            if (!filterCollection.isEmpty() && predicate2.apply(Maps.immutableEntry(key, filterCollection))) {
                if (filterCollection.size() == ((Collection) next.getValue()).size()) {
                    it2.remove();
                } else {
                    filterCollection.clear();
                }
                z11 = true;
            }
        }
        return z11;
    }

    public int size() {
        return entries().size();
    }

    public Multimap<K, V> unfiltered() {
        return this.unfiltered;
    }

    public Collection<V> unmodifiableEmptyCollection() {
        if (this.unfiltered instanceof SetMultimap) {
            return Collections.emptySet();
        }
        return Collections.emptyList();
    }
}
