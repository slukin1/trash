package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class MapIteratorCache<K, V> {
    /* access modifiers changed from: private */
    public final Map<K, V> backingMap;
    /* access modifiers changed from: private */
    public transient Map.Entry<K, V> entrySetCache;

    public MapIteratorCache(Map<K, V> map) {
        this.backingMap = (Map) Preconditions.checkNotNull(map);
    }

    public void clear() {
        clearCache();
        this.backingMap.clear();
    }

    public void clearCache() {
        this.entrySetCache = null;
    }

    public final boolean containsKey(Object obj) {
        return getIfCached(obj) != null || this.backingMap.containsKey(obj);
    }

    public V get(Object obj) {
        V ifCached = getIfCached(obj);
        return ifCached != null ? ifCached : getWithoutCaching(obj);
    }

    public V getIfCached(Object obj) {
        Map.Entry<K, V> entry = this.entrySetCache;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    public final V getWithoutCaching(Object obj) {
        return this.backingMap.get(obj);
    }

    @CanIgnoreReturnValue
    public V put(K k11, V v11) {
        clearCache();
        return this.backingMap.put(k11, v11);
    }

    @CanIgnoreReturnValue
    public V remove(Object obj) {
        clearCache();
        return this.backingMap.remove(obj);
    }

    public final Set<K> unmodifiableKeySet() {
        return new AbstractSet<K>() {
            public boolean contains(Object obj) {
                return MapIteratorCache.this.containsKey(obj);
            }

            public int size() {
                return MapIteratorCache.this.backingMap.size();
            }

            public UnmodifiableIterator<K> iterator() {
                final Iterator it2 = MapIteratorCache.this.backingMap.entrySet().iterator();
                return new UnmodifiableIterator<K>() {
                    public boolean hasNext() {
                        return it2.hasNext();
                    }

                    public K next() {
                        Map.Entry entry = (Map.Entry) it2.next();
                        Map.Entry unused = MapIteratorCache.this.entrySetCache = entry;
                        return entry.getKey();
                    }
                };
            }
        };
    }
}
