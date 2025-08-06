package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;

@GwtIncompatible
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {

    @Beta
    public class StandardDescendingMap extends Maps.DescendingMap<K, V> {
        public StandardDescendingMap() {
        }

        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new Iterator<Map.Entry<K, V>>() {
                private Map.Entry<K, V> nextOrNull;
                private Map.Entry<K, V> toRemove = null;

                {
                    this.nextOrNull = StandardDescendingMap.this.forward().lastEntry();
                }

                public boolean hasNext() {
                    return this.nextOrNull != null;
                }

                public void remove() {
                    CollectPreconditions.checkRemove(this.toRemove != null);
                    StandardDescendingMap.this.forward().remove(this.toRemove.getKey());
                    this.toRemove = null;
                }

                public Map.Entry<K, V> next() {
                    if (hasNext()) {
                        try {
                            Map.Entry<K, V> entry = this.nextOrNull;
                            this.toRemove = entry;
                            this.nextOrNull = StandardDescendingMap.this.forward().lowerEntry(this.nextOrNull.getKey());
                            return entry;
                        } catch (Throwable th2) {
                            this.toRemove = this.nextOrNull;
                            this.nextOrNull = StandardDescendingMap.this.forward().lowerEntry(this.nextOrNull.getKey());
                            throw th2;
                        }
                    } else {
                        throw new NoSuchElementException();
                    }
                }
            };
        }

        public NavigableMap<K, V> forward() {
            return ForwardingNavigableMap.this;
        }
    }

    @Beta
    public class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
        public StandardNavigableKeySet() {
            super(ForwardingNavigableMap.this);
        }
    }

    public Map.Entry<K, V> ceilingEntry(K k11) {
        return delegate().ceilingEntry(k11);
    }

    public K ceilingKey(K k11) {
        return delegate().ceilingKey(k11);
    }

    public abstract NavigableMap<K, V> delegate();

    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    public Map.Entry<K, V> floorEntry(K k11) {
        return delegate().floorEntry(k11);
    }

    public K floorKey(K k11) {
        return delegate().floorKey(k11);
    }

    public NavigableMap<K, V> headMap(K k11, boolean z11) {
        return delegate().headMap(k11, z11);
    }

    public Map.Entry<K, V> higherEntry(K k11) {
        return delegate().higherEntry(k11);
    }

    public K higherKey(K k11) {
        return delegate().higherKey(k11);
    }

    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    public Map.Entry<K, V> lowerEntry(K k11) {
        return delegate().lowerEntry(k11);
    }

    public K lowerKey(K k11) {
        return delegate().lowerKey(k11);
    }

    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    public Map.Entry<K, V> standardCeilingEntry(K k11) {
        return tailMap(k11, true).firstEntry();
    }

    public K standardCeilingKey(K k11) {
        return Maps.keyOrNull(ceilingEntry(k11));
    }

    @Beta
    public NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public Map.Entry<K, V> standardFirstEntry() {
        return (Map.Entry) Iterables.getFirst(entrySet(), null);
    }

    public K standardFirstKey() {
        Map.Entry firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    public Map.Entry<K, V> standardFloorEntry(K k11) {
        return headMap(k11, true).lastEntry();
    }

    public K standardFloorKey(K k11) {
        return Maps.keyOrNull(floorEntry(k11));
    }

    public SortedMap<K, V> standardHeadMap(K k11) {
        return headMap(k11, false);
    }

    public Map.Entry<K, V> standardHigherEntry(K k11) {
        return tailMap(k11, false).firstEntry();
    }

    public K standardHigherKey(K k11) {
        return Maps.keyOrNull(higherEntry(k11));
    }

    public Map.Entry<K, V> standardLastEntry() {
        return (Map.Entry) Iterables.getFirst(descendingMap().entrySet(), null);
    }

    public K standardLastKey() {
        Map.Entry lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    public Map.Entry<K, V> standardLowerEntry(K k11) {
        return headMap(k11, false).lastEntry();
    }

    public K standardLowerKey(K k11) {
        return Maps.keyOrNull(lowerEntry(k11));
    }

    public Map.Entry<K, V> standardPollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entrySet().iterator());
    }

    public Map.Entry<K, V> standardPollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingMap().entrySet().iterator());
    }

    public SortedMap<K, V> standardSubMap(K k11, K k12) {
        return subMap(k11, true, k12, false);
    }

    public SortedMap<K, V> standardTailMap(K k11) {
        return tailMap(k11, true);
    }

    public NavigableMap<K, V> subMap(K k11, boolean z11, K k12, boolean z12) {
        return delegate().subMap(k11, z11, k12, z12);
    }

    public NavigableMap<K, V> tailMap(K k11, boolean z11) {
        return delegate().tailMap(k11, z11);
    }
}
