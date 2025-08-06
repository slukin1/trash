package com.alibaba.fastjson.util;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public class AntiCollisionHashMap<K, V> extends AbstractMap<K, V> implements Cloneable, Serializable {
    public static final int DEFAULT_INITIAL_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    public static final int KEY = 16777619;
    public static final int MAXIMUM_CAPACITY = 1073741824;
    public static final int M_MASK = -2023358765;
    public static final int SEED = -2128831035;
    private static final long serialVersionUID = 362498820763181265L;
    private transient Set<Map.Entry<K, V>> entrySet;
    public volatile transient Set<K> keySet;
    public final float loadFactor;
    public volatile transient int modCount;
    public final int random;
    public transient int size;
    public transient b<K, V>[] table;
    public int threshold;
    public volatile transient Collection<V> values;

    public static class b<K, V> implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final K f14384b;

        /* renamed from: c  reason: collision with root package name */
        public V f14385c;

        /* renamed from: d  reason: collision with root package name */
        public b<K, V> f14386d;

        /* renamed from: e  reason: collision with root package name */
        public final int f14387e;

        public b(int i11, K k11, V v11, b<K, V> bVar) {
            this.f14385c = v11;
            this.f14386d = bVar;
            this.f14384b = k11;
            this.f14387e = i11;
        }

        public void a(AntiCollisionHashMap<K, V> antiCollisionHashMap) {
        }

        public void b(AntiCollisionHashMap<K, V> antiCollisionHashMap) {
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = getKey();
            Object key2 = entry.getKey();
            if (key == key2 || (key != null && key.equals(key2))) {
                Object value = getValue();
                Object value2 = entry.getValue();
                if (value == value2) {
                    return true;
                }
                if (value == null || !value.equals(value2)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final K getKey() {
            return this.f14384b;
        }

        public final V getValue() {
            return this.f14385c;
        }

        public final int hashCode() {
            K k11 = this.f14384b;
            int i11 = 0;
            int hashCode = k11 == null ? 0 : k11.hashCode();
            V v11 = this.f14385c;
            if (v11 != null) {
                i11 = v11.hashCode();
            }
            return hashCode ^ i11;
        }

        public final V setValue(V v11) {
            V v12 = this.f14385c;
            this.f14385c = v11;
            return v12;
        }

        public final String toString() {
            return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
        }
    }

    public final class c extends AntiCollisionHashMap<K, V>.e<Map.Entry<K, V>> {
        public c() {
            super();
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            return a();
        }
    }

    public final class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            b entry2 = AntiCollisionHashMap.this.getEntry(entry.getKey());
            if (entry2 == null || !entry2.equals(entry)) {
                return false;
            }
            return true;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return AntiCollisionHashMap.this.newEntryIterator();
        }

        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeMapping(obj) != null;
        }

        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    public abstract class e<E> implements Iterator<E> {

        /* renamed from: b  reason: collision with root package name */
        public b<K, V> f14390b;

        /* renamed from: c  reason: collision with root package name */
        public int f14391c;

        /* renamed from: d  reason: collision with root package name */
        public int f14392d;

        /* renamed from: e  reason: collision with root package name */
        public b<K, V> f14393e;

        public e() {
            b<K, V> bVar;
            this.f14391c = AntiCollisionHashMap.this.modCount;
            if (AntiCollisionHashMap.this.size > 0) {
                b<K, V>[] bVarArr = AntiCollisionHashMap.this.table;
                do {
                    int i11 = this.f14392d;
                    if (i11 < bVarArr.length) {
                        this.f14392d = i11 + 1;
                        bVar = bVarArr[i11];
                        this.f14390b = bVar;
                    } else {
                        return;
                    }
                } while (bVar == null);
            }
        }

        public final b<K, V> a() {
            b<K, V> bVar;
            if (AntiCollisionHashMap.this.modCount == this.f14391c) {
                b<K, V> bVar2 = this.f14390b;
                if (bVar2 != null) {
                    b<K, V> bVar3 = bVar2.f14386d;
                    this.f14390b = bVar3;
                    if (bVar3 == null) {
                        b<K, V>[] bVarArr = AntiCollisionHashMap.this.table;
                        do {
                            int i11 = this.f14392d;
                            if (i11 >= bVarArr.length) {
                                break;
                            }
                            this.f14392d = i11 + 1;
                            bVar = bVarArr[i11];
                            this.f14390b = bVar;
                        } while (bVar == null);
                    }
                    this.f14393e = bVar2;
                    return bVar2;
                }
                throw new NoSuchElementException();
            }
            throw new ConcurrentModificationException();
        }

        public final boolean hasNext() {
            return this.f14390b != null;
        }

        public void remove() {
            if (this.f14393e == null) {
                throw new IllegalStateException();
            } else if (AntiCollisionHashMap.this.modCount == this.f14391c) {
                K k11 = this.f14393e.f14384b;
                this.f14393e = null;
                AntiCollisionHashMap.this.removeEntryForKey(k11);
                this.f14391c = AntiCollisionHashMap.this.modCount;
            } else {
                throw new ConcurrentModificationException();
            }
        }
    }

    public final class f extends AntiCollisionHashMap<K, V>.e<K> {
        public f() {
            super();
        }

        public K next() {
            return a().getKey();
        }
    }

    public final class g extends AbstractSet<K> {
        public g() {
        }

        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return AntiCollisionHashMap.this.newKeyIterator();
        }

        public boolean remove(Object obj) {
            return AntiCollisionHashMap.this.removeEntryForKey(obj) != null;
        }

        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    public final class h extends AntiCollisionHashMap<K, V>.e<V> {
        public h() {
            super();
        }

        public V next() {
            return a().f14385c;
        }
    }

    public final class i extends AbstractCollection<V> {
        public i() {
        }

        public void clear() {
            AntiCollisionHashMap.this.clear();
        }

        public boolean contains(Object obj) {
            return AntiCollisionHashMap.this.containsValue(obj);
        }

        public Iterator<V> iterator() {
            return AntiCollisionHashMap.this.newValueIterator();
        }

        public int size() {
            return AntiCollisionHashMap.this.size;
        }
    }

    public AntiCollisionHashMap(int i11, float f11) {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        if (i11 >= 0) {
            i11 = i11 > 1073741824 ? 1073741824 : i11;
            if (f11 <= 0.0f || Float.isNaN(f11)) {
                throw new IllegalArgumentException("Illegal load factor: " + f11);
            }
            int i12 = 1;
            while (i12 < i11) {
                i12 <<= 1;
            }
            this.loadFactor = f11;
            this.threshold = (int) (((float) i12) * f11);
            this.table = new b[i12];
            init();
            return;
        }
        throw new IllegalArgumentException("Illegal initial capacity: " + i11);
    }

    private boolean containsNullValue() {
        b<K, V>[] bVarArr = this.table;
        for (b<K, V> bVar : bVarArr) {
            while (bVar != null) {
                if (bVar.f14385c == null) {
                    return true;
                }
                bVar = bVar.f14386d;
            }
        }
        return false;
    }

    private Set<Map.Entry<K, V>> entrySet0() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        d dVar = new d();
        this.entrySet = dVar;
        return dVar;
    }

    private V getForNullKey() {
        for (b<K, V> bVar = this.table[0]; bVar != null; bVar = bVar.f14386d) {
            if (bVar.f14384b == null) {
                return bVar.f14385c;
            }
        }
        return null;
    }

    public static int hash(int i11) {
        int i12 = i11 * i11;
        int i13 = i12 ^ ((i12 >>> 20) ^ (i12 >>> 12));
        return (i13 >>> 4) ^ ((i13 >>> 7) ^ i13);
    }

    private int hashString(String str) {
        int i11 = this.random * SEED;
        for (int i12 = 0; i12 < str.length(); i12++) {
            i11 = (i11 * KEY) ^ str.charAt(i12);
        }
        return ((i11 >> 1) ^ i11) & M_MASK;
    }

    public static int indexFor(int i11, int i12) {
        return i11 & (i12 - 1);
    }

    private void putAllForCreate(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            putForCreate(next.getKey(), next.getValue());
        }
    }

    private void putForCreate(K k11, V v11) {
        int i11;
        K k12;
        if (k11 == null) {
            i11 = 0;
        } else if (k11 instanceof String) {
            i11 = hash(hashString((String) k11));
        } else {
            i11 = hash(k11.hashCode());
        }
        int indexFor = indexFor(i11, this.table.length);
        b<K, V> bVar = this.table[indexFor];
        while (bVar != null) {
            if (bVar.f14387e != i11 || ((k12 = bVar.f14384b) != k11 && (k11 == null || !k11.equals(k12)))) {
                bVar = bVar.f14386d;
            } else {
                bVar.f14385c = v11;
                return;
            }
        }
        createEntry(i11, k11, v11, indexFor);
    }

    private V putForNullKey(V v11) {
        for (b<K, V> bVar = this.table[0]; bVar != null; bVar = bVar.f14386d) {
            if (bVar.f14384b == null) {
                V v12 = bVar.f14385c;
                bVar.f14385c = v11;
                bVar.a(this);
                return v12;
            }
        }
        this.modCount++;
        addEntry(0, (Object) null, v11, 0);
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.table = new b[objectInputStream.readInt()];
        init();
        int readInt = objectInputStream.readInt();
        for (int i11 = 0; i11 < readInt; i11++) {
            putForCreate(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Iterator it2 = this.size > 0 ? entrySet0().iterator() : null;
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.table.length);
        objectOutputStream.writeInt(this.size);
        if (it2 != null) {
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
        }
    }

    public void addEntry(int i11, K k11, V v11, int i12) {
        b<K, V>[] bVarArr = this.table;
        bVarArr[i12] = new b<>(i11, k11, v11, bVarArr[i12]);
        int i13 = this.size;
        this.size = i13 + 1;
        if (i13 >= this.threshold) {
            resize(this.table.length * 2);
        }
    }

    public int capacity() {
        return this.table.length;
    }

    public void clear() {
        this.modCount++;
        b<K, V>[] bVarArr = this.table;
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            bVarArr[i11] = null;
        }
        this.size = 0;
    }

    public Object clone() {
        AntiCollisionHashMap antiCollisionHashMap;
        try {
            antiCollisionHashMap = (AntiCollisionHashMap) super.clone();
        } catch (CloneNotSupportedException unused) {
            antiCollisionHashMap = null;
        }
        antiCollisionHashMap.table = new b[this.table.length];
        antiCollisionHashMap.entrySet = null;
        antiCollisionHashMap.modCount = 0;
        antiCollisionHashMap.size = 0;
        antiCollisionHashMap.init();
        antiCollisionHashMap.putAllForCreate(this);
        return antiCollisionHashMap;
    }

    public boolean containsKey(Object obj) {
        return getEntry(obj) != null;
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            return containsNullValue();
        }
        b<K, V>[] bVarArr = this.table;
        for (b<K, V> bVar : bVarArr) {
            while (bVar != null) {
                if (obj.equals(bVar.f14385c)) {
                    return true;
                }
                bVar = bVar.f14386d;
            }
        }
        return false;
    }

    public void createEntry(int i11, K k11, V v11, int i12) {
        b<K, V>[] bVarArr = this.table;
        bVarArr[i12] = new b<>(i11, k11, v11, bVarArr[i12]);
        this.size++;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet0();
    }

    public V get(Object obj) {
        int i11;
        K k11;
        if (obj == null) {
            return getForNullKey();
        }
        if (obj instanceof String) {
            i11 = hash(hashString((String) obj));
        } else {
            i11 = hash(obj.hashCode());
        }
        b<K, V>[] bVarArr = this.table;
        for (b<K, V> bVar = bVarArr[indexFor(i11, bVarArr.length)]; bVar != null; bVar = bVar.f14386d) {
            if (bVar.f14387e == i11 && ((k11 = bVar.f14384b) == obj || obj.equals(k11))) {
                return bVar.f14385c;
            }
        }
        return null;
    }

    public final b<K, V> getEntry(Object obj) {
        int i11;
        K k11;
        if (obj == null) {
            i11 = 0;
        } else if (obj instanceof String) {
            i11 = hash(hashString((String) obj));
        } else {
            i11 = hash(obj.hashCode());
        }
        b<K, V>[] bVarArr = this.table;
        for (b<K, V> bVar = bVarArr[indexFor(i11, bVarArr.length)]; bVar != null; bVar = bVar.f14386d) {
            if (bVar.f14387e == i11 && ((k11 = bVar.f14384b) == obj || (obj != null && obj.equals(k11)))) {
                return bVar;
            }
        }
        return null;
    }

    public void init() {
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.keySet = gVar;
        return gVar;
    }

    public float loadFactor() {
        return this.loadFactor;
    }

    public Iterator<Map.Entry<K, V>> newEntryIterator() {
        return new c();
    }

    public Iterator<K> newKeyIterator() {
        return new f();
    }

    public Iterator<V> newValueIterator() {
        return new h();
    }

    public V put(K k11, V v11) {
        int i11;
        K k12;
        if (k11 == null) {
            return putForNullKey(v11);
        }
        if (k11 instanceof String) {
            i11 = hash(hashString((String) k11));
        } else {
            i11 = hash(k11.hashCode());
        }
        int indexFor = indexFor(i11, this.table.length);
        b<K, V> bVar = this.table[indexFor];
        while (bVar != null) {
            if (bVar.f14387e != i11 || ((k12 = bVar.f14384b) != k11 && !k11.equals(k12))) {
                bVar = bVar.f14386d;
            } else {
                V v12 = bVar.f14385c;
                bVar.f14385c = v11;
                bVar.a(this);
                return v12;
            }
        }
        this.modCount++;
        addEntry(i11, k11, v11, indexFor);
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size2 = map.size();
        if (size2 != 0) {
            if (size2 > this.threshold) {
                int i11 = (int) ((((float) size2) / this.loadFactor) + 1.0f);
                if (i11 > 1073741824) {
                    i11 = 1073741824;
                }
                int length = this.table.length;
                while (length < i11) {
                    length <<= 1;
                }
                if (length > this.table.length) {
                    resize(length);
                }
            }
            for (Map.Entry next : map.entrySet()) {
                put(next.getKey(), next.getValue());
            }
        }
    }

    public V remove(Object obj) {
        b removeEntryForKey = removeEntryForKey(obj);
        if (removeEntryForKey == null) {
            return null;
        }
        return removeEntryForKey.f14385c;
    }

    public final b<K, V> removeEntryForKey(Object obj) {
        int i11;
        K k11;
        if (obj == null) {
            i11 = 0;
        } else if (obj instanceof String) {
            i11 = hash(hashString((String) obj));
        } else {
            i11 = hash(obj.hashCode());
        }
        int indexFor = indexFor(i11, this.table.length);
        b<K, V> bVar = this.table[indexFor];
        b<K, V> bVar2 = bVar;
        while (bVar != null) {
            b<K, V> bVar3 = bVar.f14386d;
            if (bVar.f14387e != i11 || ((k11 = bVar.f14384b) != obj && (obj == null || !obj.equals(k11)))) {
                bVar2 = bVar;
                bVar = bVar3;
            } else {
                this.modCount++;
                this.size--;
                if (bVar2 == bVar) {
                    this.table[indexFor] = bVar3;
                } else {
                    bVar2.f14386d = bVar3;
                }
                bVar.b(this);
                return bVar;
            }
        }
        return bVar;
    }

    public final b<K, V> removeMapping(Object obj) {
        int i11;
        if (!(obj instanceof Map.Entry)) {
            return null;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        if (key == null) {
            i11 = 0;
        } else if (key instanceof String) {
            i11 = hash(hashString((String) key));
        } else {
            i11 = hash(key.hashCode());
        }
        int indexFor = indexFor(i11, this.table.length);
        b<K, V> bVar = this.table[indexFor];
        b<K, V> bVar2 = bVar;
        while (bVar != null) {
            b<K, V> bVar3 = bVar.f14386d;
            if (bVar.f14387e != i11 || !bVar.equals(entry)) {
                bVar2 = bVar;
                bVar = bVar3;
            } else {
                this.modCount++;
                this.size--;
                if (bVar2 == bVar) {
                    this.table[indexFor] = bVar3;
                } else {
                    bVar2.f14386d = bVar3;
                }
                bVar.b(this);
                return bVar;
            }
        }
        return bVar;
    }

    public void resize(int i11) {
        if (this.table.length == 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        b<K, V>[] bVarArr = new b[i11];
        transfer(bVarArr);
        this.table = bVarArr;
        this.threshold = (int) (((float) i11) * this.loadFactor);
    }

    public int size() {
        return this.size;
    }

    public void transfer(b[] bVarArr) {
        b<K, V>[] bVarArr2 = this.table;
        int length = bVarArr.length;
        for (int i11 = 0; i11 < bVarArr2.length; i11++) {
            b<K, V> bVar = bVarArr2[i11];
            if (bVar != null) {
                bVarArr2[i11] = null;
                while (true) {
                    b<K, V> bVar2 = bVar.f14386d;
                    int indexFor = indexFor(bVar.f14387e, length);
                    bVar.f14386d = bVarArr[indexFor];
                    bVarArr[indexFor] = bVar;
                    if (bVar2 == null) {
                        break;
                    }
                    bVar = bVar2;
                }
            }
        }
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        i iVar = new i();
        this.values = iVar;
        return iVar;
    }

    public AntiCollisionHashMap(int i11) {
        this(i11, 0.75f);
    }

    public AntiCollisionHashMap() {
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(99999);
        this.entrySet = null;
        this.loadFactor = 0.75f;
        this.threshold = 12;
        this.table = new b[16];
        init();
    }

    public AntiCollisionHashMap(Map<? extends K, ? extends V> map) {
        this(Math.max(((int) (((float) map.size()) / 0.75f)) + 1, 16), 0.75f);
        putAllForCreate(map);
    }
}
