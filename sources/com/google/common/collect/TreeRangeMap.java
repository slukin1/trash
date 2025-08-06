package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;

@GwtIncompatible
@Beta
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {
    private static final RangeMap EMPTY_SUB_RANGE_MAP = new RangeMap() {
        public Map<Range, Object> asDescendingMapOfRanges() {
            return Collections.emptyMap();
        }

        public Map<Range, Object> asMapOfRanges() {
            return Collections.emptyMap();
        }

        public void clear() {
        }

        public Object get(Comparable comparable) {
            return null;
        }

        public Map.Entry<Range, Object> getEntry(Comparable comparable) {
            return null;
        }

        public void put(Range range, Object obj) {
            Preconditions.checkNotNull(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        public void putAll(RangeMap rangeMap) {
            if (!rangeMap.asMapOfRanges().isEmpty()) {
                throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
            }
        }

        public void putCoalescing(Range range, Object obj) {
            Preconditions.checkNotNull(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        public void remove(Range range) {
            Preconditions.checkNotNull(range);
        }

        public Range span() {
            throw new NoSuchElementException();
        }

        public RangeMap subRangeMap(Range range) {
            Preconditions.checkNotNull(range);
            return this;
        }
    };
    /* access modifiers changed from: private */
    public final NavigableMap<Cut<K>, RangeMapEntry<K, V>> entriesByLowerBound = Maps.newTreeMap();

    public final class AsMapOfRanges extends Maps.IteratorBasedAbstractMap<Range<K>, V> {
        public final Iterable<Map.Entry<Range<K>, V>> entryIterable;

        public AsMapOfRanges(Iterable<RangeMapEntry<K, V>> iterable) {
            this.entryIterable = iterable;
        }

        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        public Iterator<Map.Entry<Range<K>, V>> entryIterator() {
            return this.entryIterable.iterator();
        }

        public V get(Object obj) {
            if (!(obj instanceof Range)) {
                return null;
            }
            Range range = (Range) obj;
            RangeMapEntry rangeMapEntry = (RangeMapEntry) TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
            if (rangeMapEntry == null || !rangeMapEntry.getKey().equals(range)) {
                return null;
            }
            return rangeMapEntry.getValue();
        }

        public int size() {
            return TreeRangeMap.this.entriesByLowerBound.size();
        }
    }

    public static final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {
        private final Range<K> range;
        private final V value;

        public RangeMapEntry(Cut<K> cut, Cut<K> cut2, V v11) {
            this(Range.create(cut, cut2), v11);
        }

        public boolean contains(K k11) {
            return this.range.contains(k11);
        }

        public Cut<K> getLowerBound() {
            return this.range.lowerBound;
        }

        public Cut<K> getUpperBound() {
            return this.range.upperBound;
        }

        public V getValue() {
            return this.value;
        }

        public RangeMapEntry(Range<K> range2, V v11) {
            this.range = range2;
            this.value = v11;
        }

        public Range<K> getKey() {
            return this.range;
        }
    }

    public class SubRangeMap implements RangeMap<K, V> {
        /* access modifiers changed from: private */
        public final Range<K> subRange;

        public class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {
            public SubRangeMapAsMap() {
            }

            /* access modifiers changed from: private */
            public boolean removeEntryIf(Predicate<? super Map.Entry<Range<K>, V>> predicate) {
                ArrayList<Range> newArrayList = Lists.newArrayList();
                for (Map.Entry entry : entrySet()) {
                    if (predicate.apply(entry)) {
                        newArrayList.add(entry.getKey());
                    }
                }
                for (Range remove : newArrayList) {
                    TreeRangeMap.this.remove(remove);
                }
                return !newArrayList.isEmpty();
            }

            public void clear() {
                SubRangeMap.this.clear();
            }

            public boolean containsKey(Object obj) {
                return get(obj) != null;
            }

            public Iterator<Map.Entry<Range<K>, V>> entryIterator() {
                if (SubRangeMap.this.subRange.isEmpty()) {
                    return Iterators.emptyIterator();
                }
                final Iterator it2 = TreeRangeMap.this.entriesByLowerBound.tailMap((Cut) MoreObjects.firstNonNull(TreeRangeMap.this.entriesByLowerBound.floorKey(SubRangeMap.this.subRange.lowerBound), SubRangeMap.this.subRange.lowerBound), true).values().iterator();
                return new AbstractIterator<Map.Entry<Range<K>, V>>() {
                    public Map.Entry<Range<K>, V> computeNext() {
                        while (it2.hasNext()) {
                            RangeMapEntry rangeMapEntry = (RangeMapEntry) it2.next();
                            if (rangeMapEntry.getLowerBound().compareTo(SubRangeMap.this.subRange.upperBound) >= 0) {
                                return (Map.Entry) endOfData();
                            }
                            if (rangeMapEntry.getUpperBound().compareTo(SubRangeMap.this.subRange.lowerBound) > 0) {
                                return Maps.immutableEntry(rangeMapEntry.getKey().intersection(SubRangeMap.this.subRange), rangeMapEntry.getValue());
                            }
                        }
                        return (Map.Entry) endOfData();
                    }
                };
            }

            public Set<Map.Entry<Range<K>, V>> entrySet() {
                return new Maps.EntrySet<Range<K>, V>() {
                    public boolean isEmpty() {
                        return !iterator().hasNext();
                    }

                    public Iterator<Map.Entry<Range<K>, V>> iterator() {
                        return SubRangeMapAsMap.this.entryIterator();
                    }

                    public Map<Range<K>, V> map() {
                        return SubRangeMapAsMap.this;
                    }

                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.not(Predicates.in(collection)));
                    }

                    public int size() {
                        return Iterators.size(iterator());
                    }
                };
            }

            public V get(Object obj) {
                RangeMapEntry rangeMapEntry;
                try {
                    if (obj instanceof Range) {
                        Range range = (Range) obj;
                        if (SubRangeMap.this.subRange.encloses(range)) {
                            if (!range.isEmpty()) {
                                if (range.lowerBound.compareTo(SubRangeMap.this.subRange.lowerBound) == 0) {
                                    Map.Entry<K, V> floorEntry = TreeRangeMap.this.entriesByLowerBound.floorEntry(range.lowerBound);
                                    rangeMapEntry = floorEntry != null ? (RangeMapEntry) floorEntry.getValue() : null;
                                } else {
                                    rangeMapEntry = (RangeMapEntry) TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
                                }
                                if (rangeMapEntry != null && rangeMapEntry.getKey().isConnected(SubRangeMap.this.subRange) && rangeMapEntry.getKey().intersection(SubRangeMap.this.subRange).equals(range)) {
                                    return rangeMapEntry.getValue();
                                }
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            public Set<Range<K>> keySet() {
                return new Maps.KeySet<Range<K>, V>(this) {
                    public boolean remove(Object obj) {
                        return SubRangeMapAsMap.this.remove(obj) != null;
                    }

                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.keyFunction()));
                    }
                };
            }

            public V remove(Object obj) {
                V v11 = get(obj);
                if (v11 == null) {
                    return null;
                }
                TreeRangeMap.this.remove((Range) obj);
                return v11;
            }

            public Collection<V> values() {
                return new Maps.Values<Range<K>, V>(this) {
                    public boolean removeAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.in(collection), Maps.valueFunction()));
                    }

                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.valueFunction()));
                    }
                };
            }
        }

        public SubRangeMap(Range<K> range) {
            this.subRange = range;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [java.util.Map<com.google.common.collect.Range<K>, V>, com.google.common.collect.TreeRangeMap$SubRangeMap$1] */
        public Map<Range<K>, V> asDescendingMapOfRanges() {
            return new TreeRangeMap<K, V>.SubRangeMap.SubRangeMapAsMap() {
                public Iterator<Map.Entry<Range<K>, V>> entryIterator() {
                    if (SubRangeMap.this.subRange.isEmpty()) {
                        return Iterators.emptyIterator();
                    }
                    final Iterator it2 = TreeRangeMap.this.entriesByLowerBound.headMap(SubRangeMap.this.subRange.upperBound, false).descendingMap().values().iterator();
                    return new AbstractIterator<Map.Entry<Range<K>, V>>() {
                        public Map.Entry<Range<K>, V> computeNext() {
                            if (!it2.hasNext()) {
                                return (Map.Entry) endOfData();
                            }
                            RangeMapEntry rangeMapEntry = (RangeMapEntry) it2.next();
                            if (rangeMapEntry.getUpperBound().compareTo(SubRangeMap.this.subRange.lowerBound) <= 0) {
                                return (Map.Entry) endOfData();
                            }
                            return Maps.immutableEntry(rangeMapEntry.getKey().intersection(SubRangeMap.this.subRange), rangeMapEntry.getValue());
                        }
                    };
                }
            };
        }

        public Map<Range<K>, V> asMapOfRanges() {
            return new SubRangeMapAsMap();
        }

        public void clear() {
            TreeRangeMap.this.remove(this.subRange);
        }

        public boolean equals(Object obj) {
            if (obj instanceof RangeMap) {
                return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
            }
            return false;
        }

        public V get(K k11) {
            if (this.subRange.contains(k11)) {
                return TreeRangeMap.this.get(k11);
            }
            return null;
        }

        public Map.Entry<Range<K>, V> getEntry(K k11) {
            Map.Entry entry;
            if (!this.subRange.contains(k11) || (entry = TreeRangeMap.this.getEntry(k11)) == null) {
                return null;
            }
            return Maps.immutableEntry(((Range) entry.getKey()).intersection(this.subRange), entry.getValue());
        }

        public int hashCode() {
            return asMapOfRanges().hashCode();
        }

        public void put(Range<K> range, V v11) {
            Preconditions.checkArgument(this.subRange.encloses(range), "Cannot put range %s into a subRangeMap(%s)", (Object) range, (Object) this.subRange);
            TreeRangeMap.this.put(range, v11);
        }

        public void putAll(RangeMap<K, V> rangeMap) {
            if (!rangeMap.asMapOfRanges().isEmpty()) {
                Range<K> span = rangeMap.span();
                Preconditions.checkArgument(this.subRange.encloses(span), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", (Object) span, (Object) this.subRange);
                TreeRangeMap.this.putAll(rangeMap);
            }
        }

        public void putCoalescing(Range<K> range, V v11) {
            if (TreeRangeMap.this.entriesByLowerBound.isEmpty() || range.isEmpty() || !this.subRange.encloses(range)) {
                put(range, v11);
            } else {
                put(TreeRangeMap.this.coalescedRange(range, Preconditions.checkNotNull(v11)).intersection(this.subRange), v11);
            }
        }

        public void remove(Range<K> range) {
            if (range.isConnected(this.subRange)) {
                TreeRangeMap.this.remove(range.intersection(this.subRange));
            }
        }

        public Range<K> span() {
            Cut<C> cut;
            Cut<C> cut2;
            Map.Entry<K, V> floorEntry = TreeRangeMap.this.entriesByLowerBound.floorEntry(this.subRange.lowerBound);
            if (floorEntry == null || ((RangeMapEntry) floorEntry.getValue()).getUpperBound().compareTo(this.subRange.lowerBound) <= 0) {
                cut = (Cut) TreeRangeMap.this.entriesByLowerBound.ceilingKey(this.subRange.lowerBound);
                if (cut == null || cut.compareTo(this.subRange.upperBound) >= 0) {
                    throw new NoSuchElementException();
                }
            } else {
                cut = this.subRange.lowerBound;
            }
            Map.Entry<K, V> lowerEntry = TreeRangeMap.this.entriesByLowerBound.lowerEntry(this.subRange.upperBound);
            if (lowerEntry != null) {
                if (((RangeMapEntry) lowerEntry.getValue()).getUpperBound().compareTo(this.subRange.upperBound) >= 0) {
                    cut2 = this.subRange.upperBound;
                } else {
                    cut2 = ((RangeMapEntry) lowerEntry.getValue()).getUpperBound();
                }
                return Range.create(cut, cut2);
            }
            throw new NoSuchElementException();
        }

        public RangeMap<K, V> subRangeMap(Range<K> range) {
            if (!range.isConnected(this.subRange)) {
                return TreeRangeMap.this.emptySubRangeMap();
            }
            return TreeRangeMap.this.subRangeMap(range.intersection(this.subRange));
        }

        public String toString() {
            return asMapOfRanges().toString();
        }
    }

    private TreeRangeMap() {
    }

    private static <K extends Comparable, V> Range<K> coalesce(Range<K> range, V v11, Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry) {
        return (entry == null || !entry.getValue().getKey().isConnected(range) || !entry.getValue().getValue().equals(v11)) ? range : range.span(entry.getValue().getKey());
    }

    /* access modifiers changed from: private */
    public Range<K> coalescedRange(Range<K> range, V v11) {
        return coalesce(coalesce(range, v11, this.entriesByLowerBound.lowerEntry(range.lowerBound)), v11, this.entriesByLowerBound.floorEntry(range.upperBound));
    }

    public static <K extends Comparable, V> TreeRangeMap<K, V> create() {
        return new TreeRangeMap<>();
    }

    /* access modifiers changed from: private */
    public RangeMap<K, V> emptySubRangeMap() {
        return EMPTY_SUB_RANGE_MAP;
    }

    private void putRangeMapEntry(Cut<K> cut, Cut<K> cut2, V v11) {
        this.entriesByLowerBound.put(cut, new RangeMapEntry(cut, cut2, v11));
    }

    public Map<Range<K>, V> asDescendingMapOfRanges() {
        return new AsMapOfRanges(this.entriesByLowerBound.descendingMap().values());
    }

    public Map<Range<K>, V> asMapOfRanges() {
        return new AsMapOfRanges(this.entriesByLowerBound.values());
    }

    public void clear() {
        this.entriesByLowerBound.clear();
    }

    public boolean equals(Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    public V get(K k11) {
        Map.Entry entry = getEntry(k11);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public Map.Entry<Range<K>, V> getEntry(K k11) {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> floorEntry = this.entriesByLowerBound.floorEntry(Cut.belowValue(k11));
        if (floorEntry == null || !floorEntry.getValue().contains(k11)) {
            return null;
        }
        return floorEntry.getValue();
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    public void put(Range<K> range, V v11) {
        if (!range.isEmpty()) {
            Preconditions.checkNotNull(v11);
            remove(range);
            this.entriesByLowerBound.put(range.lowerBound, new RangeMapEntry(range, v11));
        }
    }

    public void putAll(RangeMap<K, V> rangeMap) {
        for (Map.Entry next : rangeMap.asMapOfRanges().entrySet()) {
            put((Range) next.getKey(), next.getValue());
        }
    }

    public void putCoalescing(Range<K> range, V v11) {
        if (this.entriesByLowerBound.isEmpty()) {
            put(range, v11);
        } else {
            put(coalescedRange(range, Preconditions.checkNotNull(v11)), v11);
        }
    }

    public void remove(Range<K> range) {
        if (!range.isEmpty()) {
            Map.Entry<Cut<K>, RangeMapEntry<K, V>> lowerEntry = this.entriesByLowerBound.lowerEntry(range.lowerBound);
            if (lowerEntry != null) {
                RangeMapEntry value = lowerEntry.getValue();
                if (value.getUpperBound().compareTo(range.lowerBound) > 0) {
                    if (value.getUpperBound().compareTo(range.upperBound) > 0) {
                        putRangeMapEntry(range.upperBound, value.getUpperBound(), lowerEntry.getValue().getValue());
                    }
                    putRangeMapEntry(value.getLowerBound(), range.lowerBound, lowerEntry.getValue().getValue());
                }
            }
            Map.Entry<Cut<K>, RangeMapEntry<K, V>> lowerEntry2 = this.entriesByLowerBound.lowerEntry(range.upperBound);
            if (lowerEntry2 != null) {
                RangeMapEntry value2 = lowerEntry2.getValue();
                if (value2.getUpperBound().compareTo(range.upperBound) > 0) {
                    putRangeMapEntry(range.upperBound, value2.getUpperBound(), lowerEntry2.getValue().getValue());
                }
            }
            this.entriesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
        }
    }

    public Range<K> span() {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> firstEntry = this.entriesByLowerBound.firstEntry();
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> lastEntry = this.entriesByLowerBound.lastEntry();
        if (firstEntry != null) {
            return Range.create(firstEntry.getValue().getKey().lowerBound, lastEntry.getValue().getKey().upperBound);
        }
        throw new NoSuchElementException();
    }

    public RangeMap<K, V> subRangeMap(Range<K> range) {
        if (range.equals(Range.all())) {
            return this;
        }
        return new SubRangeMap(range);
    }

    public String toString() {
        return this.entriesByLowerBound.values().toString();
    }
}
