package com.google.common.graph;

import java.util.Map;

class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {
    private transient CacheEntry<K, V> cacheEntry1;
    private transient CacheEntry<K, V> cacheEntry2;

    public static final class CacheEntry<K, V> {
        public final K key;
        public final V value;

        public CacheEntry(K k11, V v11) {
            this.key = k11;
            this.value = v11;
        }
    }

    public MapRetrievalCache(Map<K, V> map) {
        super(map);
    }

    private void addToCache(K k11, V v11) {
        addToCache(new CacheEntry(k11, v11));
    }

    public void clearCache() {
        super.clearCache();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    public V get(Object obj) {
        V ifCached = getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        V withoutCaching = getWithoutCaching(obj);
        if (withoutCaching != null) {
            addToCache(obj, withoutCaching);
        }
        return withoutCaching;
    }

    public V getIfCached(Object obj) {
        V ifCached = super.getIfCached(obj);
        if (ifCached != null) {
            return ifCached;
        }
        CacheEntry<K, V> cacheEntry = this.cacheEntry1;
        if (cacheEntry != null && cacheEntry.key == obj) {
            return cacheEntry.value;
        }
        CacheEntry<K, V> cacheEntry3 = this.cacheEntry2;
        if (cacheEntry3 == null || cacheEntry3.key != obj) {
            return null;
        }
        addToCache(cacheEntry3);
        return cacheEntry3.value;
    }

    private void addToCache(CacheEntry<K, V> cacheEntry) {
        this.cacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = cacheEntry;
    }
}
