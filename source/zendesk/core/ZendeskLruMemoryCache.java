package zendesk.core;

import android.util.LruCache;

class ZendeskLruMemoryCache implements MemoryCache {
    public final LruCache<String, Object> cache;

    public ZendeskLruMemoryCache() {
        this(new LruCache(50));
    }

    public void clear() {
        this.cache.evictAll();
    }

    public boolean contains(String str) {
        boolean z11;
        synchronized (this) {
            z11 = this.cache.get(str) != null;
        }
        return z11;
    }

    public <T> T get(String str) {
        T t11;
        synchronized (this) {
            t11 = this.cache.get(str);
        }
        return t11;
    }

    public <T> T getOrDefault(String str, T t11) {
        T t12 = get(str);
        return t12 != null ? t12 : t11;
    }

    public void put(String str, Object obj) {
        synchronized (this) {
            this.cache.put(str, obj);
        }
    }

    public void remove(String str) {
        synchronized (this) {
            this.cache.remove(str);
        }
    }

    public ZendeskLruMemoryCache(LruCache<String, Object> lruCache) {
        this.cache = lruCache;
    }
}
