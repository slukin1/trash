package i0;

import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class c<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public c<K, V>.b f15942a;

    /* renamed from: b  reason: collision with root package name */
    public c<K, V>.c f15943b;

    /* renamed from: c  reason: collision with root package name */
    public c<K, V>.e f15944c;

    public final class a<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        public final int f15945b;

        /* renamed from: c  reason: collision with root package name */
        public int f15946c;

        /* renamed from: d  reason: collision with root package name */
        public int f15947d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f15948e = false;

        public a(int i11) {
            this.f15945b = i11;
            this.f15946c = c.this.d();
        }

        public boolean hasNext() {
            return this.f15947d < this.f15946c;
        }

        public T next() {
            if (hasNext()) {
                T b11 = c.this.b(this.f15947d, this.f15945b);
                this.f15947d++;
                this.f15948e = true;
                return b11;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f15948e) {
                int i11 = this.f15947d - 1;
                this.f15947d = i11;
                this.f15946c--;
                this.f15948e = false;
                c.this.h(i11);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final class b implements Set<Map.Entry<K, V>> {
        public b() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int d11 = c.this.d();
            for (Map.Entry entry : collection) {
                c.this.g(entry.getKey(), entry.getValue());
            }
            return d11 != c.this.d();
        }

        public void clear() {
            c.this.a();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e11 = c.this.e(entry.getKey());
            if (e11 < 0) {
                return false;
            }
            return a.c(c.this.b(e11, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return c.k(this, obj);
        }

        public int hashCode() {
            int i11;
            int i12;
            int i13 = 0;
            for (int d11 = c.this.d() - 1; d11 >= 0; d11--) {
                Object b11 = c.this.b(d11, 0);
                Object b12 = c.this.b(d11, 1);
                if (b11 == null) {
                    i11 = 0;
                } else {
                    i11 = b11.hashCode();
                }
                if (b12 == null) {
                    i12 = 0;
                } else {
                    i12 = b12.hashCode();
                }
                i13 += i11 ^ i12;
            }
            return i13;
        }

        public boolean isEmpty() {
            return c.this.d() == 0;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return c.this.d();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: i0.c$c  reason: collision with other inner class name */
    public final class C0085c implements Set<K> {
        public C0085c() {
        }

        public boolean add(K k11) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            c.this.a();
        }

        public boolean contains(Object obj) {
            return c.this.e(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return c.j(c.this.c(), collection);
        }

        public boolean equals(Object obj) {
            return c.k(this, obj);
        }

        public int hashCode() {
            int i11;
            int i12 = 0;
            for (int d11 = c.this.d() - 1; d11 >= 0; d11--) {
                Object b11 = c.this.b(d11, 0);
                if (b11 == null) {
                    i11 = 0;
                } else {
                    i11 = b11.hashCode();
                }
                i12 += i11;
            }
            return i12;
        }

        public boolean isEmpty() {
            return c.this.d() == 0;
        }

        public Iterator<K> iterator() {
            return new a(0);
        }

        public boolean remove(Object obj) {
            int e11 = c.this.e(obj);
            if (e11 < 0) {
                return false;
            }
            c.this.h(e11);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return c.o(c.this.c(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return c.p(c.this.c(), collection);
        }

        public int size() {
            return c.this.d();
        }

        public Object[] toArray() {
            return c.this.q(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return c.this.r(tArr, 0);
        }
    }

    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public int f15952b;

        /* renamed from: c  reason: collision with root package name */
        public int f15953c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f15954d = false;

        public d() {
            this.f15952b = c.this.d() - 1;
            this.f15953c = -1;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f15953c++;
                this.f15954d = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object obj) {
            if (!this.f15954d) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                if (!a.c(entry.getKey(), c.this.b(this.f15953c, 0)) || !a.c(entry.getValue(), c.this.b(this.f15953c, 1))) {
                    return false;
                }
                return true;
            }
        }

        public K getKey() {
            if (this.f15954d) {
                return c.this.b(this.f15953c, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f15954d) {
                return c.this.b(this.f15953c, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f15953c < this.f15952b;
        }

        public int hashCode() {
            int i11;
            if (this.f15954d) {
                int i12 = 0;
                Object b11 = c.this.b(this.f15953c, 0);
                Object b12 = c.this.b(this.f15953c, 1);
                if (b11 == null) {
                    i11 = 0;
                } else {
                    i11 = b11.hashCode();
                }
                if (b12 != null) {
                    i12 = b12.hashCode();
                }
                return i11 ^ i12;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.f15954d) {
                c.this.h(this.f15953c);
                this.f15953c--;
                this.f15952b--;
                this.f15954d = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v11) {
            if (this.f15954d) {
                return c.this.i(this.f15953c, v11);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }
    }

    public final class e implements Collection<V> {
        public e() {
        }

        public boolean add(V v11) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            c.this.a();
        }

        public boolean contains(Object obj) {
            return c.this.f(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return c.this.d() == 0;
        }

        public Iterator<V> iterator() {
            return new a(1);
        }

        public boolean remove(Object obj) {
            int f11 = c.this.f(obj);
            if (f11 < 0) {
                return false;
            }
            c.this.h(f11);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int d11 = c.this.d();
            int i11 = 0;
            boolean z11 = false;
            while (i11 < d11) {
                if (collection.contains(c.this.b(i11, 1))) {
                    c.this.h(i11);
                    i11--;
                    d11--;
                    z11 = true;
                }
                i11++;
            }
            return z11;
        }

        public boolean retainAll(Collection<?> collection) {
            int d11 = c.this.d();
            int i11 = 0;
            boolean z11 = false;
            while (i11 < d11) {
                if (!collection.contains(c.this.b(i11, 1))) {
                    c.this.h(i11);
                    i11--;
                    d11--;
                    z11 = true;
                }
                i11++;
            }
            return z11;
        }

        public int size() {
            return c.this.d();
        }

        public Object[] toArray() {
            return c.this.q(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return c.this.r(tArr, 1);
        }
    }

    public static <K, V> boolean j(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static <K, V> boolean o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            if (!collection.contains(it2.next())) {
                it2.remove();
            }
        }
        return size != map.size();
    }

    public abstract void a();

    public abstract Object b(int i11, int i12);

    public abstract Map<K, V> c();

    public abstract int d();

    public abstract int e(Object obj);

    public abstract int f(Object obj);

    public abstract void g(K k11, V v11);

    public abstract void h(int i11);

    public abstract V i(int i11, V v11);

    public Set<Map.Entry<K, V>> l() {
        if (this.f15942a == null) {
            this.f15942a = new b();
        }
        return this.f15942a;
    }

    public Set<K> m() {
        if (this.f15943b == null) {
            this.f15943b = new C0085c();
        }
        return this.f15943b;
    }

    public Collection<V> n() {
        if (this.f15944c == null) {
            this.f15944c = new e();
        }
        return this.f15944c;
    }

    public Object[] q(int i11) {
        int d11 = d();
        Object[] objArr = new Object[d11];
        for (int i12 = 0; i12 < d11; i12++) {
            objArr[i12] = b(i12, i11);
        }
        return objArr;
    }

    public <T> T[] r(T[] tArr, int i11) {
        int d11 = d();
        if (tArr.length < d11) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), d11);
        }
        for (int i12 = 0; i12 < d11; i12++) {
            tArr[i12] = b(i12, i11);
        }
        if (tArr.length > d11) {
            tArr[d11] = null;
        }
        return tArr;
    }
}
