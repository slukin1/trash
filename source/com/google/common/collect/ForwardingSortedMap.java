package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;

@GwtCompatible
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {

    @Beta
    public class StandardKeySet extends Maps.SortedKeySet<K, V> {
        public StandardKeySet() {
            super(ForwardingSortedMap.this);
        }
    }

    private int unsafeCompare(Object obj, Object obj2) {
        Comparator comparator = comparator();
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    public abstract SortedMap<K, V> delegate();

    public K firstKey() {
        return delegate().firstKey();
    }

    public SortedMap<K, V> headMap(K k11) {
        return delegate().headMap(k11);
    }

    public K lastKey() {
        return delegate().lastKey();
    }

    @Beta
    public boolean standardContainsKey(Object obj) {
        try {
            if (unsafeCompare(tailMap(obj).firstKey(), obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    @Beta
    public SortedMap<K, V> standardSubMap(K k11, K k12) {
        Preconditions.checkArgument(unsafeCompare(k11, k12) <= 0, "fromKey must be <= toKey");
        return tailMap(k11).headMap(k12);
    }

    public SortedMap<K, V> subMap(K k11, K k12) {
        return delegate().subMap(k11, k12);
    }

    public SortedMap<K, V> tailMap(K k11) {
        return delegate().tailMap(k11);
    }
}
