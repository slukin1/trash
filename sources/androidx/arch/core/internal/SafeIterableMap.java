package androidx.arch.core.internal;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    public c<K, V> f4742b;

    /* renamed from: c  reason: collision with root package name */
    public c<K, V> f4743c;

    /* renamed from: d  reason: collision with root package name */
    public WeakHashMap<f<K, V>, Boolean> f4744d = new WeakHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public int f4745e = 0;

    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        public c<K, V> b(c<K, V> cVar) {
            return cVar.f4749e;
        }

        public c<K, V> c(c<K, V> cVar) {
            return cVar.f4748d;
        }
    }

    public static class b<K, V> extends e<K, V> {
        public b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        public c<K, V> b(c<K, V> cVar) {
            return cVar.f4748d;
        }

        public c<K, V> c(c<K, V> cVar) {
            return cVar.f4749e;
        }
    }

    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final K f4746b;

        /* renamed from: c  reason: collision with root package name */
        public final V f4747c;

        /* renamed from: d  reason: collision with root package name */
        public c<K, V> f4748d;

        /* renamed from: e  reason: collision with root package name */
        public c<K, V> f4749e;

        public c(K k11, V v11) {
            this.f4746b = k11;
            this.f4747c = v11;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.f4746b.equals(cVar.f4746b) || !this.f4747c.equals(cVar.f4747c)) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.f4746b;
        }

        public V getValue() {
            return this.f4747c;
        }

        public int hashCode() {
            return this.f4746b.hashCode() ^ this.f4747c.hashCode();
        }

        public V setValue(V v11) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f4746b + ContainerUtils.KEY_VALUE_DELIMITER + this.f4747c;
        }
    }

    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public c<K, V> f4750b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4751c = true;

        public d() {
        }

        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f4750b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f4749e;
                this.f4750b = cVar3;
                this.f4751c = cVar3 == null;
            }
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            if (this.f4751c) {
                this.f4751c = false;
                this.f4750b = SafeIterableMap.this.f4742b;
            } else {
                c<K, V> cVar = this.f4750b;
                this.f4750b = cVar != null ? cVar.f4748d : null;
            }
            return this.f4750b;
        }

        public boolean hasNext() {
            if (!this.f4751c) {
                c<K, V> cVar = this.f4750b;
                if (cVar == null || cVar.f4748d == null) {
                    return false;
                }
                return true;
            } else if (SafeIterableMap.this.f4742b != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public c<K, V> f4753b;

        /* renamed from: c  reason: collision with root package name */
        public c<K, V> f4754c;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f4753b = cVar2;
            this.f4754c = cVar;
        }

        public void a(c<K, V> cVar) {
            if (this.f4753b == cVar && cVar == this.f4754c) {
                this.f4754c = null;
                this.f4753b = null;
            }
            c<K, V> cVar2 = this.f4753b;
            if (cVar2 == cVar) {
                this.f4753b = b(cVar2);
            }
            if (this.f4754c == cVar) {
                this.f4754c = e();
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        /* renamed from: d */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f4754c;
            this.f4754c = e();
            return cVar;
        }

        public final c<K, V> e() {
            c<K, V> cVar = this.f4754c;
            c<K, V> cVar2 = this.f4753b;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        public boolean hasNext() {
            return this.f4754c != null;
        }
    }

    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public Map.Entry<K, V> a() {
        return this.f4742b;
    }

    public c<K, V> b(K k11) {
        c<K, V> cVar = this.f4742b;
        while (cVar != null && !cVar.f4746b.equals(k11)) {
            cVar = cVar.f4748d;
        }
        return cVar;
    }

    public SafeIterableMap<K, V>.d c() {
        SafeIterableMap<K, V>.d dVar = new d();
        this.f4744d.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry<K, V> d() {
        return this.f4743c;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        b bVar = new b(this.f4743c, this.f4742b);
        this.f4744d.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public c<K, V> e(K k11, V v11) {
        c<K, V> cVar = new c<>(k11, v11);
        this.f4745e++;
        c<K, V> cVar2 = this.f4743c;
        if (cVar2 == null) {
            this.f4742b = cVar;
            this.f4743c = cVar;
            return cVar;
        }
        cVar2.f4748d = cVar;
        cVar.f4749e = cVar2;
        this.f4743c = cVar;
        return cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator it2 = iterator();
        Iterator it3 = safeIterableMap.iterator();
        while (it2.hasNext() && it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            Object next = it3.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it2.hasNext() || it3.hasNext()) {
            return false;
        }
        return true;
    }

    public V g(K k11, V v11) {
        c b11 = b(k11);
        if (b11 != null) {
            return b11.f4747c;
        }
        e(k11, v11);
        return null;
    }

    public V h(K k11) {
        c b11 = b(k11);
        if (b11 == null) {
            return null;
        }
        this.f4745e--;
        if (!this.f4744d.isEmpty()) {
            for (f<K, V> a11 : this.f4744d.keySet()) {
                a11.a(b11);
            }
        }
        c<K, V> cVar = b11.f4749e;
        if (cVar != null) {
            cVar.f4748d = b11.f4748d;
        } else {
            this.f4742b = b11.f4748d;
        }
        c<K, V> cVar2 = b11.f4748d;
        if (cVar2 != null) {
            cVar2.f4749e = cVar;
        } else {
            this.f4743c = cVar;
        }
        b11.f4748d = null;
        b11.f4749e = null;
        return b11.f4747c;
    }

    public int hashCode() {
        Iterator it2 = iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            i11 += ((Map.Entry) it2.next()).hashCode();
        }
        return i11;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f4742b, this.f4743c);
        this.f4744d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f4745e;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            sb2.append(((Map.Entry) it2.next()).toString());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
