package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.q;
import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class w0<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: b  reason: collision with root package name */
    public final int f9225b;

    /* renamed from: c  reason: collision with root package name */
    public List<w0<K, V>.e> f9226c;

    /* renamed from: d  reason: collision with root package name */
    public Map<K, V> f9227d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9228e;

    /* renamed from: f  reason: collision with root package name */
    public volatile w0<K, V>.g f9229f;

    /* renamed from: g  reason: collision with root package name */
    public Map<K, V> f9230g;

    /* renamed from: h  reason: collision with root package name */
    public volatile w0<K, V>.c f9231h;

    public static class a extends w0<FieldDescriptorType, Object> {
        public a(int i11) {
            super(i11, (a) null);
        }

        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return w0.super.put((q.b) obj, obj2);
        }

        public void s() {
            if (!r()) {
                for (int i11 = 0; i11 < n(); i11++) {
                    Map.Entry m11 = m(i11);
                    if (((q.b) m11.getKey()).isRepeated()) {
                        m11.setValue(Collections.unmodifiableList((List) m11.getValue()));
                    }
                }
                for (Map.Entry entry : p()) {
                    if (((q.b) entry.getKey()).isRepeated()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            w0.super.s();
        }
    }

    public class c extends w0<K, V>.g {
        public c() {
            super(w0.this, (a) null);
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new b(w0.this, (a) null);
        }

        public /* synthetic */ c(w0 w0Var, a aVar) {
            this();
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final Iterator<Object> f9236a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final Iterable<Object> f9237b = new b();

        public static class a implements Iterator<Object> {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public static class b implements Iterable<Object> {
            public Iterator<Object> iterator() {
                return d.f9236a;
            }
        }

        public static <T> Iterable<T> b() {
            return f9237b;
        }
    }

    public class e implements Map.Entry<K, V>, Comparable<w0<K, V>.e> {

        /* renamed from: b  reason: collision with root package name */
        public final K f9238b;

        /* renamed from: c  reason: collision with root package name */
        public V f9239c;

        public e(w0 w0Var, Map.Entry<K, V> entry) {
            this((Comparable) entry.getKey(), entry.getValue());
        }

        /* renamed from: a */
        public int compareTo(w0<K, V>.e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        public final boolean b(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        /* renamed from: c */
        public K getKey() {
            return this.f9238b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!b(this.f9238b, entry.getKey()) || !b(this.f9239c, entry.getValue())) {
                return false;
            }
            return true;
        }

        public V getValue() {
            return this.f9239c;
        }

        public int hashCode() {
            K k11 = this.f9238b;
            int i11 = 0;
            int hashCode = k11 == null ? 0 : k11.hashCode();
            V v11 = this.f9239c;
            if (v11 != null) {
                i11 = v11.hashCode();
            }
            return hashCode ^ i11;
        }

        public V setValue(V v11) {
            w0.this.j();
            V v12 = this.f9239c;
            this.f9239c = v11;
            return v12;
        }

        public String toString() {
            return this.f9238b + ContainerUtils.KEY_VALUE_DELIMITER + this.f9239c;
        }

        public e(K k11, V v11) {
            this.f9238b = k11;
            this.f9239c = v11;
        }
    }

    public class g extends AbstractSet<Map.Entry<K, V>> {
        public g() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            w0.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            w0.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = w0.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(w0.this, (a) null);
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            w0.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return w0.this.size();
        }

        public /* synthetic */ g(w0 w0Var, a aVar) {
            this();
        }
    }

    public /* synthetic */ w0(int i11, a aVar) {
        this(i11);
    }

    public static <FieldDescriptorType extends q.b<FieldDescriptorType>> w0<FieldDescriptorType, Object> t(int i11) {
        return new a(i11);
    }

    public void clear() {
        j();
        if (!this.f9226c.isEmpty()) {
            this.f9226c.clear();
        }
        if (!this.f9227d.isEmpty()) {
            this.f9227d.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return i(comparable) >= 0 || this.f9227d.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f9229f == null) {
            this.f9229f = new g(this, (a) null);
        }
        return this.f9229f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return super.equals(obj);
        }
        w0 w0Var = (w0) obj;
        int size = size();
        if (size != w0Var.size()) {
            return false;
        }
        int n11 = n();
        if (n11 != w0Var.n()) {
            return entrySet().equals(w0Var.entrySet());
        }
        for (int i11 = 0; i11 < n11; i11++) {
            if (!m(i11).equals(w0Var.m(i11))) {
                return false;
            }
        }
        if (n11 != size) {
            return this.f9227d.equals(w0Var.f9227d);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int i11 = i(comparable);
        if (i11 >= 0) {
            return this.f9226c.get(i11).getValue();
        }
        return this.f9227d.get(comparable);
    }

    public int hashCode() {
        int n11 = n();
        int i11 = 0;
        for (int i12 = 0; i12 < n11; i12++) {
            i11 += this.f9226c.get(i12).hashCode();
        }
        return o() > 0 ? i11 + this.f9227d.hashCode() : i11;
    }

    public final int i(K k11) {
        int size = this.f9226c.size() - 1;
        if (size >= 0) {
            int compareTo = k11.compareTo(this.f9226c.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) / 2;
            int compareTo2 = k11.compareTo(this.f9226c.get(i12).getKey());
            if (compareTo2 < 0) {
                size = i12 - 1;
            } else if (compareTo2 <= 0) {
                return i12;
            } else {
                i11 = i12 + 1;
            }
        }
        return -(i11 + 1);
    }

    public final void j() {
        if (this.f9228e) {
            throw new UnsupportedOperationException();
        }
    }

    public Set<Map.Entry<K, V>> k() {
        if (this.f9231h == null) {
            this.f9231h = new c(this, (a) null);
        }
        return this.f9231h;
    }

    public final void l() {
        j();
        if (this.f9226c.isEmpty() && !(this.f9226c instanceof ArrayList)) {
            this.f9226c = new ArrayList(this.f9225b);
        }
    }

    public Map.Entry<K, V> m(int i11) {
        return this.f9226c.get(i11);
    }

    public int n() {
        return this.f9226c.size();
    }

    public int o() {
        return this.f9227d.size();
    }

    public Iterable<Map.Entry<K, V>> p() {
        if (this.f9227d.isEmpty()) {
            return d.b();
        }
        return this.f9227d.entrySet();
    }

    public final SortedMap<K, V> q() {
        j();
        if (this.f9227d.isEmpty() && !(this.f9227d instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f9227d = treeMap;
            TreeMap treeMap2 = treeMap;
            this.f9230g = treeMap.descendingMap();
        }
        return (SortedMap) this.f9227d;
    }

    public boolean r() {
        return this.f9228e;
    }

    public V remove(Object obj) {
        j();
        Comparable comparable = (Comparable) obj;
        int i11 = i(comparable);
        if (i11 >= 0) {
            return v(i11);
        }
        if (this.f9227d.isEmpty()) {
            return null;
        }
        return this.f9227d.remove(comparable);
    }

    public void s() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.f9228e) {
            if (this.f9227d.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.f9227d);
            }
            this.f9227d = map;
            if (this.f9230g.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f9230g);
            }
            this.f9230g = map2;
            this.f9228e = true;
        }
    }

    public int size() {
        return this.f9226c.size() + this.f9227d.size();
    }

    /* renamed from: u */
    public V put(K k11, V v11) {
        j();
        int i11 = i(k11);
        if (i11 >= 0) {
            return this.f9226c.get(i11).setValue(v11);
        }
        l();
        int i12 = -(i11 + 1);
        if (i12 >= this.f9225b) {
            return q().put(k11, v11);
        }
        int size = this.f9226c.size();
        int i13 = this.f9225b;
        if (size == i13) {
            e remove = this.f9226c.remove(i13 - 1);
            q().put(remove.getKey(), remove.getValue());
        }
        this.f9226c.add(i12, new e(k11, v11));
        return null;
    }

    public final V v(int i11) {
        j();
        V value = this.f9226c.remove(i11).getValue();
        if (!this.f9227d.isEmpty()) {
            Iterator it2 = q().entrySet().iterator();
            this.f9226c.add(new e(this, (Map.Entry) it2.next()));
            it2.remove();
        }
        return value;
    }

    public class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        public int f9232b;

        /* renamed from: c  reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f9233c;

        public b() {
            this.f9232b = w0.this.f9226c.size();
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f9233c == null) {
                this.f9233c = w0.this.f9230g.entrySet().iterator();
            }
            return this.f9233c;
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            if (a().hasNext()) {
                return (Map.Entry) a().next();
            }
            List c11 = w0.this.f9226c;
            int i11 = this.f9232b - 1;
            this.f9232b = i11;
            return (Map.Entry) c11.get(i11);
        }

        public boolean hasNext() {
            int i11 = this.f9232b;
            return (i11 > 0 && i11 <= w0.this.f9226c.size()) || a().hasNext();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(w0 w0Var, a aVar) {
            this();
        }
    }

    public class f implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        public int f9241b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9242c;

        /* renamed from: d  reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f9243d;

        public f() {
            this.f9241b = -1;
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.f9243d == null) {
                this.f9243d = w0.this.f9227d.entrySet().iterator();
            }
            return this.f9243d;
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            this.f9242c = true;
            int i11 = this.f9241b + 1;
            this.f9241b = i11;
            if (i11 < w0.this.f9226c.size()) {
                return (Map.Entry) w0.this.f9226c.get(this.f9241b);
            }
            return (Map.Entry) a().next();
        }

        public boolean hasNext() {
            if (this.f9241b + 1 < w0.this.f9226c.size()) {
                return true;
            }
            if (w0.this.f9227d.isEmpty() || !a().hasNext()) {
                return false;
            }
            return true;
        }

        public void remove() {
            if (this.f9242c) {
                this.f9242c = false;
                w0.this.j();
                if (this.f9241b < w0.this.f9226c.size()) {
                    w0 w0Var = w0.this;
                    int i11 = this.f9241b;
                    this.f9241b = i11 - 1;
                    Object unused = w0Var.v(i11);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        public /* synthetic */ f(w0 w0Var, a aVar) {
            this();
        }
    }

    public w0(int i11) {
        this.f9225b = i11;
        this.f9226c = Collections.emptyList();
        this.f9227d = Collections.emptyMap();
        this.f9230g = Collections.emptyMap();
    }
}
