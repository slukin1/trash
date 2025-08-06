package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.ranges.h;

public final class MapBuilder<K, V> implements Map<K, V>, Serializable, e10.e {
    private static final a Companion = new a((r) null);
    @Deprecated
    private static final int INITIAL_CAPACITY = 8;
    @Deprecated
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    @Deprecated
    private static final int MAGIC = -1640531527;
    @Deprecated
    private static final int TOMBSTONE = -1;
    private b<K, V> entriesView;
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;
    /* access modifiers changed from: private */
    public K[] keysArray;
    private c<K> keysView;
    /* access modifiers changed from: private */
    public int length;
    private int maxProbeDistance;
    /* access modifiers changed from: private */
    public int[] presenceArray;
    private int size;
    /* access modifiers changed from: private */
    public V[] valuesArray;
    private d<V> valuesView;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final int c(int i11) {
            return Integer.highestOneBit(RangesKt___RangesKt.d(i11, 1) * 3);
        }

        public final int d(int i11) {
            return Integer.numberOfLeadingZeros(i11) + 1;
        }
    }

    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, e10.a {
        public b(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
        }

        /* renamed from: h */
        public c<K, V> next() {
            if (a() < c().length) {
                int a11 = a();
                f(a11 + 1);
                g(a11);
                c<K, V> cVar = new c<>(c(), b());
                d();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final void i(StringBuilder sb2) {
            if (a() < c().length) {
                int a11 = a();
                f(a11 + 1);
                g(a11);
                Object obj = c().keysArray[b()];
                if (x.b(obj, c())) {
                    sb2.append("(this Map)");
                } else {
                    sb2.append(obj);
                }
                sb2.append('=');
                Object obj2 = c().valuesArray[b()];
                if (x.b(obj2, c())) {
                    sb2.append("(this Map)");
                } else {
                    sb2.append(obj2);
                }
                d();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int j() {
            if (a() < c().length) {
                int a11 = a();
                f(a11 + 1);
                g(a11);
                Object obj = c().keysArray[b()];
                int i11 = 0;
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object obj2 = c().valuesArray[b()];
                if (obj2 != null) {
                    i11 = obj2.hashCode();
                }
                int i12 = hashCode ^ i11;
                d();
                return i12;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class c<K, V> implements Map.Entry<K, V>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final MapBuilder<K, V> f56644b;

        /* renamed from: c  reason: collision with root package name */
        public final int f56645c;

        public c(MapBuilder<K, V> mapBuilder, int i11) {
            this.f56644b = mapBuilder;
            this.f56645c = i11;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return x.b(entry.getKey(), getKey()) && x.b(entry.getValue(), getValue());
            }
        }

        public K getKey() {
            return this.f56644b.keysArray[this.f56645c];
        }

        public V getValue() {
            return this.f56644b.valuesArray[this.f56645c];
        }

        public int hashCode() {
            Object key = getKey();
            int i11 = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            if (value != null) {
                i11 = value.hashCode();
            }
            return hashCode ^ i11;
        }

        public V setValue(V v11) {
            this.f56644b.checkIsMutable$kotlin_stdlib();
            V[] access$allocateValuesArray = this.f56644b.allocateValuesArray();
            int i11 = this.f56645c;
            V v12 = access$allocateValuesArray[i11];
            access$allocateValuesArray[i11] = v11;
            return v12;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append('=');
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    public static class d<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final MapBuilder<K, V> f56646b;

        /* renamed from: c  reason: collision with root package name */
        public int f56647c;

        /* renamed from: d  reason: collision with root package name */
        public int f56648d = -1;

        public d(MapBuilder<K, V> mapBuilder) {
            this.f56646b = mapBuilder;
            d();
        }

        public final int a() {
            return this.f56647c;
        }

        public final int b() {
            return this.f56648d;
        }

        public final MapBuilder<K, V> c() {
            return this.f56646b;
        }

        public final void d() {
            while (this.f56647c < this.f56646b.length) {
                int[] access$getPresenceArray$p = this.f56646b.presenceArray;
                int i11 = this.f56647c;
                if (access$getPresenceArray$p[i11] < 0) {
                    this.f56647c = i11 + 1;
                } else {
                    return;
                }
            }
        }

        public final void f(int i11) {
            this.f56647c = i11;
        }

        public final void g(int i11) {
            this.f56648d = i11;
        }

        public final boolean hasNext() {
            return this.f56647c < this.f56646b.length;
        }

        public final void remove() {
            if (this.f56648d != -1) {
                this.f56646b.checkIsMutable$kotlin_stdlib();
                this.f56646b.removeKeyAt(this.f56648d);
                this.f56648d = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    public static final class e<K, V> extends d<K, V> implements Iterator<K>, e10.a {
        public e(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
        }

        public K next() {
            if (a() < c().length) {
                int a11 = a();
                f(a11 + 1);
                g(a11);
                K k11 = c().keysArray[b()];
                d();
                return k11;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class f<K, V> extends d<K, V> implements Iterator<V>, e10.a {
        public f(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
        }

        public V next() {
            if (a() < c().length) {
                int a11 = a();
                f(a11 + 1);
                g(a11);
                V v11 = c().valuesArray[b()];
                d();
                return v11;
            }
            throw new NoSuchElementException();
        }
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i11, int i12) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i11;
        this.length = i12;
        this.hashShift = Companion.d(getHashSize());
    }

    /* access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] d11 = a.d(getCapacity());
        this.valuesArray = d11;
        return d11;
    }

    private final void compact() {
        int i11;
        V[] vArr = this.valuesArray;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            i11 = this.length;
            if (i12 >= i11) {
                break;
            }
            if (this.presenceArray[i12] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i13] = kArr[i12];
                if (vArr != null) {
                    vArr[i13] = vArr[i12];
                }
                i13++;
            }
            i12++;
        }
        a.g(this.keysArray, i13, i11);
        if (vArr != null) {
            a.g(vArr, i13, this.length);
        }
        this.length = i13;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    private final void ensureCapacity(int i11) {
        if (i11 < 0) {
            throw new OutOfMemoryError();
        } else if (i11 > getCapacity()) {
            int capacity = (getCapacity() * 3) / 2;
            if (i11 <= capacity) {
                i11 = capacity;
            }
            this.keysArray = a.e(this.keysArray, i11);
            V[] vArr = this.valuesArray;
            this.valuesArray = vArr != null ? a.e(vArr, i11) : null;
            this.presenceArray = Arrays.copyOf(this.presenceArray, i11);
            int a11 = Companion.c(i11);
            if (a11 > getHashSize()) {
                rehash(a11);
            }
        } else if ((this.length + i11) - size() > getCapacity()) {
            rehash(getHashSize());
        }
    }

    private final void ensureExtraCapacity(int i11) {
        ensureCapacity(this.length + i11);
    }

    private final int findKey(K k11) {
        int hash = hash(k11);
        int i11 = this.maxProbeDistance;
        while (true) {
            int i12 = this.hashArray[hash];
            if (i12 == 0) {
                return -1;
            }
            if (i12 > 0) {
                int i13 = i12 - 1;
                if (x.b(this.keysArray[i13], k11)) {
                    return i13;
                }
            }
            i11--;
            if (i11 < 0) {
                return -1;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final int findValue(V v11) {
        int i11 = this.length;
        while (true) {
            i11--;
            if (i11 < 0) {
                return -1;
            }
            if (this.presenceArray[i11] >= 0 && x.b(this.valuesArray[i11], v11)) {
                return i11;
            }
        }
    }

    private final int getCapacity() {
        return this.keysArray.length;
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k11) {
        return ((k11 != null ? k11.hashCode() : 0) * -1640531527) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z11 = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        for (Map.Entry putEntry : collection) {
            if (putEntry(putEntry)) {
                z11 = true;
            }
        }
        return z11;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        Object[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib >= 0) {
            allocateValuesArray[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i11 = (-addKey$kotlin_stdlib) - 1;
        if (x.b(entry.getValue(), allocateValuesArray[i11])) {
            return false;
        }
        allocateValuesArray[i11] = entry.getValue();
        return true;
    }

    private final boolean putRehash(int i11) {
        int hash = hash(this.keysArray[i11]);
        int i12 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[hash] == 0) {
                iArr[hash] = i11 + 1;
                this.presenceArray[i11] = hash;
                return true;
            }
            i12--;
            if (i12 < 0) {
                return false;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final void rehash(int i11) {
        if (this.length > size()) {
            compact();
        }
        int i12 = 0;
        if (i11 != getHashSize()) {
            this.hashArray = new int[i11];
            this.hashShift = Companion.d(i11);
        } else {
            ArraysKt___ArraysJvmKt.l(this.hashArray, 0, 0, getHashSize());
        }
        while (i12 < this.length) {
            int i13 = i12 + 1;
            if (putRehash(i12)) {
                i12 = i13;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    private final void removeHashAt(int i11) {
        int g11 = RangesKt___RangesKt.g(this.maxProbeDistance * 2, getHashSize() / 2);
        int i12 = 0;
        int i13 = i11;
        do {
            i11 = i11 == 0 ? getHashSize() - 1 : i11 - 1;
            i12++;
            if (i12 > this.maxProbeDistance) {
                this.hashArray[i13] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i14 = iArr[i11];
            if (i14 == 0) {
                iArr[i13] = 0;
                return;
            }
            if (i14 < 0) {
                iArr[i13] = -1;
            } else {
                int i15 = i14 - 1;
                if (((hash(this.keysArray[i15]) - i11) & (getHashSize() - 1)) >= i12) {
                    this.hashArray[i13] = i14;
                    this.presenceArray[i15] = i13;
                }
                g11--;
            }
            i13 = i11;
            i12 = 0;
            g11--;
        } while (g11 >= 0);
        this.hashArray[i13] = -1;
    }

    /* access modifiers changed from: private */
    public final void removeKeyAt(int i11) {
        a.f(this.keysArray, i11);
        removeHashAt(this.presenceArray[i11]);
        this.presenceArray[i11] = -1;
        this.size = size() - 1;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K k11) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k11);
            int g11 = RangesKt___RangesKt.g(this.maxProbeDistance * 2, getHashSize() / 2);
            int i11 = 0;
            while (true) {
                int i12 = this.hashArray[hash];
                if (i12 <= 0) {
                    if (this.length >= getCapacity()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i13 = this.length;
                        int i14 = i13 + 1;
                        this.length = i14;
                        this.keysArray[i13] = k11;
                        this.presenceArray[i13] = hash;
                        this.hashArray[hash] = i14;
                        this.size = size() + 1;
                        if (i11 > this.maxProbeDistance) {
                            this.maxProbeDistance = i11;
                        }
                        return i13;
                    }
                } else if (x.b(this.keysArray[i12 - 1], k11)) {
                    return -i12;
                } else {
                    i11++;
                    if (i11 > g11) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    hash = hash == 0 ? getHashSize() - 1 : hash - 1;
                }
            }
        }
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        checkIsMutable$kotlin_stdlib();
        IntIterator d11 = new h(0, this.length - 1).iterator();
        while (d11.hasNext()) {
            int a11 = d11.a();
            int[] iArr = this.presenceArray;
            int i11 = iArr[a11];
            if (i11 >= 0) {
                this.hashArray[i11] = 0;
                iArr[a11] = -1;
            }
        }
        a.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            a.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> collection) {
        for (Object next : collection) {
            if (next != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) next)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        return x.b(this.valuesArray[findKey], entry.getValue());
    }

    public boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return findValue(obj) >= 0;
    }

    public final b<K, V> entriesIterator$kotlin_stdlib() {
        return new b<>(this);
    }

    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && contentEquals((Map) obj));
    }

    public V get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        return this.valuesArray[findKey];
    }

    public Set<Map.Entry<K, V>> getEntries() {
        b<K, V> bVar = this.entriesView;
        if (bVar != null) {
            return bVar;
        }
        b<K, V> bVar2 = new b<>(this);
        this.entriesView = bVar2;
        return bVar2;
    }

    public Set<K> getKeys() {
        c<K> cVar = this.keysView;
        if (cVar != null) {
            return cVar;
        }
        c<K> cVar2 = new c<>(this);
        this.keysView = cVar2;
        return cVar2;
    }

    public int getSize() {
        return this.size;
    }

    public Collection<V> getValues() {
        d<V> dVar = this.valuesView;
        if (dVar != null) {
            return dVar;
        }
        d<V> dVar2 = new d<>(this);
        this.valuesView = dVar2;
        return dVar2;
    }

    public int hashCode() {
        b entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i11 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i11 += entriesIterator$kotlin_stdlib.j();
        }
        return i11;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final e<K, V> keysIterator$kotlin_stdlib() {
        return new e<>(this);
    }

    public V put(K k11, V v11) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k11);
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib < 0) {
            int i11 = (-addKey$kotlin_stdlib) - 1;
            V v12 = allocateValuesArray[i11];
            allocateValuesArray[i11] = v11;
            return v12;
        }
        allocateValuesArray[addKey$kotlin_stdlib] = v11;
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        checkIsMutable$kotlin_stdlib();
        putAllEntries(map.entrySet());
    }

    public V remove(Object obj) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        V v11 = vArr[removeKey$kotlin_stdlib];
        a.f(vArr, removeKey$kotlin_stdlib);
        return v11;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(entry.getKey());
        if (findKey < 0 || !x.b(this.valuesArray[findKey], entry.getValue())) {
            return false;
        }
        removeKeyAt(findKey);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k11) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(k11);
        if (findKey < 0) {
            return -1;
        }
        removeKeyAt(findKey);
        return findKey;
    }

    public final boolean removeValue$kotlin_stdlib(V v11) {
        checkIsMutable$kotlin_stdlib();
        int findValue = findValue(v11);
        if (findValue < 0) {
            return false;
        }
        removeKeyAt(findValue);
        return true;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append("{");
        b entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i11 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            entriesIterator$kotlin_stdlib.i(sb2);
            i11++;
        }
        sb2.append("}");
        return sb2.toString();
    }

    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i11) {
        this(a.d(i11), (V[]) null, new int[i11], new int[Companion.c(i11)], 2, 0);
    }
}
