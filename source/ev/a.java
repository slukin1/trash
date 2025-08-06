package ev;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class a<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public Map<K, List<V>> f22750a;

    public a(Map<K, List<V>> map) {
        this.f22750a = map;
    }

    public void a(K k11, V v11) {
        if (!this.f22750a.containsKey(k11)) {
            this.f22750a.put(k11, new ArrayList(1));
        }
        this.f22750a.get(k11).add(v11);
    }

    public void b(K k11, List<V> list) {
        for (V a11 : list) {
            a(k11, a11);
        }
    }

    public Set<Map.Entry<K, List<V>>> c() {
        return this.f22750a.entrySet();
    }

    public List<V> d(K k11) {
        return this.f22750a.get(k11);
    }

    public V e(K k11) {
        List list = this.f22750a.get(k11);
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public List<V> f(K k11) {
        return this.f22750a.remove(k11);
    }

    public void g(K k11, V v11) {
        this.f22750a.remove(k11);
        a(k11, v11);
    }

    public void h(K k11, List<V> list) {
        this.f22750a.put(k11, list);
    }
}
