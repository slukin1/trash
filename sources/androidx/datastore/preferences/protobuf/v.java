package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

public class v extends LazyFieldLite {

    /* renamed from: f  reason: collision with root package name */
    public final f0 f9218f;

    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: b  reason: collision with root package name */
        public Map.Entry<K, v> f9219b;

        public v a() {
            return this.f9219b.getValue();
        }

        public K getKey() {
            return this.f9219b.getKey();
        }

        public Object getValue() {
            v value = this.f9219b.getValue();
            if (value == null) {
                return null;
            }
            return value.f();
        }

        public Object setValue(Object obj) {
            if (obj instanceof f0) {
                return this.f9219b.getValue().d((f0) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        public b(Map.Entry<K, v> entry) {
            this.f9219b = entry;
        }
    }

    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: b  reason: collision with root package name */
        public Iterator<Map.Entry<K, Object>> f9220b;

        public c(Iterator<Map.Entry<K, Object>> it2) {
            this.f9220b = it2;
        }

        /* renamed from: a */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f9220b.next();
            return next.getValue() instanceof v ? new b(next) : next;
        }

        public boolean hasNext() {
            return this.f9220b.hasNext();
        }

        public void remove() {
            this.f9220b.remove();
        }
    }

    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public f0 f() {
        return c(this.f9218f);
    }

    public int hashCode() {
        return f().hashCode();
    }

    public String toString() {
        return f().toString();
    }
}
