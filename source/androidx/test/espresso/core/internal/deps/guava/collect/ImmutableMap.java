package androidx.test.espresso.core.internal.deps.guava.collect;

import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;

public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {
    public static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableCollection<V> values;

    public static class Builder<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public Comparator<? super V> f11313a;

        /* renamed from: b  reason: collision with root package name */
        public Object[] f11314b;

        /* renamed from: c  reason: collision with root package name */
        public int f11315c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11316d;

        public Builder() {
            this(4);
        }

        public ImmutableMap<K, V> a() {
            f();
            this.f11316d = true;
            return RegularImmutableMap.create(this.f11315c, this.f11314b);
        }

        public final void b(int i11) {
            int i12 = i11 * 2;
            Object[] objArr = this.f11314b;
            if (i12 > objArr.length) {
                this.f11314b = Arrays.copyOf(objArr, ImmutableCollection.Builder.a(objArr.length, i12));
                this.f11316d = false;
            }
        }

        public Builder<K, V> c(K k11, V v11) {
            b(this.f11315c + 1);
            CollectPreconditions.a(k11, v11);
            Object[] objArr = this.f11314b;
            int i11 = this.f11315c;
            objArr[i11 * 2] = k11;
            objArr[(i11 * 2) + 1] = v11;
            this.f11315c = i11 + 1;
            return this;
        }

        public Builder<K, V> d(Map.Entry<? extends K, ? extends V> entry) {
            return c(entry.getKey(), entry.getValue());
        }

        public Builder<K, V> e(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                b(this.f11315c + ((Collection) iterable).size());
            }
            for (Map.Entry d11 : iterable) {
                d(d11);
            }
            return this;
        }

        public void f() {
            int i11;
            if (this.f11313a != null) {
                if (this.f11316d) {
                    this.f11314b = Arrays.copyOf(this.f11314b, this.f11315c * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.f11315c];
                int i12 = 0;
                while (true) {
                    i11 = this.f11315c;
                    if (i12 >= i11) {
                        break;
                    }
                    Object[] objArr = this.f11314b;
                    int i13 = i12 * 2;
                    entryArr[i12] = new AbstractMap.SimpleImmutableEntry(objArr[i13], objArr[i13 + 1]);
                    i12++;
                }
                Arrays.sort(entryArr, 0, i11, Ordering.from(this.f11313a).onResultOf(Maps.d()));
                for (int i14 = 0; i14 < this.f11315c; i14++) {
                    int i15 = i14 * 2;
                    this.f11314b[i15] = entryArr[i14].getKey();
                    this.f11314b[i15 + 1] = entryArr[i14].getValue();
                }
            }
        }

        public Builder(int i11) {
            this.f11314b = new Object[(i11 * 2)];
            this.f11315c = 0;
            this.f11316d = false;
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        public SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            UnmodifiableIterator<Map.Entry<?, ?>> it2 = immutableMap.entrySet().iterator();
            int i11 = 0;
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                this.keys[i11] = next.getKey();
                this.values[i11] = next.getValue();
                i11++;
            }
        }

        public Object createMap(Builder<Object, Object> builder) {
            int i11 = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i11 >= objArr.length) {
                    return builder.a();
                }
                builder.c(objArr[i11], this.values[i11]);
                i11++;
            }
        }

        public Object readResolve() {
            return createMap(new Builder(this.keys.length));
        }
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        }
        return copyOf(map.entrySet());
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    public abstract ImmutableSet<K> createKeySet();

    public abstract ImmutableCollection<V> createValues();

    public boolean equals(Object obj) {
        return Maps.a(this, obj);
    }

    public abstract V get(Object obj);

    public final V getOrDefault(Object obj, V v11) {
        V v12 = get(obj);
        return v12 != null ? v12 : v11;
    }

    public int hashCode() {
        return Sets.b(entrySet());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isPartialView();

    @Deprecated
    public final V put(K k11, V v11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.c(this);
    }

    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> createKeySet = createKeySet();
        this.keySet = createKeySet;
        return createKeySet;
    }

    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> createValues = createValues();
        this.values = createValues;
        return createValues;
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Builder builder = new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        builder.e(iterable);
        return builder.a();
    }
}
