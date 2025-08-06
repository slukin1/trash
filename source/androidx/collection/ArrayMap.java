package androidx.collection;

import i0.c;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* renamed from: i  reason: collision with root package name */
    public c<K, V> f6480i;

    public class a extends c<K, V> {
        public a() {
        }

        public void a() {
            ArrayMap.this.clear();
        }

        public Object b(int i11, int i12) {
            return ArrayMap.this.f6507c[(i11 << 1) + i12];
        }

        public Map<K, V> c() {
            return ArrayMap.this;
        }

        public int d() {
            return ArrayMap.this.f6508d;
        }

        public int e(Object obj) {
            return ArrayMap.this.i(obj);
        }

        public int f(Object obj) {
            return ArrayMap.this.k(obj);
        }

        public void g(K k11, V v11) {
            ArrayMap.this.put(k11, v11);
        }

        public void h(int i11) {
            ArrayMap.this.n(i11);
        }

        public V i(int i11, V v11) {
            return ArrayMap.this.o(i11, v11);
        }
    }

    public ArrayMap() {
    }

    private c<K, V> q() {
        if (this.f6480i == null) {
            this.f6480i = new a();
        }
        return this.f6480i;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return q().l();
    }

    public Set<K> keySet() {
        return q().m();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        d(this.f6508d + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public boolean r(Collection<?> collection) {
        return c.p(this, collection);
    }

    public Collection<V> values() {
        return q().n();
    }

    public ArrayMap(int i11) {
        super(i11);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
