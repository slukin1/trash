package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

@GwtIncompatible
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final float LOAD_FACTOR = 1.0f;
    private static final long NEXT_MASK = 4294967295L;
    public static final int UNSET = -1;
    @VisibleForTesting
    public transient long[] entries;
    private transient Set<Map.Entry<K, V>> entrySetView;
    private transient Set<K> keySetView;
    @VisibleForTesting
    public transient Object[] keys;
    public transient int modCount;
    /* access modifiers changed from: private */
    public transient int size;
    private transient int[] table;
    @VisibleForTesting
    public transient Object[] values;
    private transient Collection<V> valuesView;

    public class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        public EntrySetView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int access$200 = CompactHashMap.this.indexOf(entry.getKey());
            if (access$200 == -1 || !Objects.equal(CompactHashMap.this.values[access$200], entry.getValue())) {
                return false;
            }
            return true;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.entrySetIterator();
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int access$200 = CompactHashMap.this.indexOf(entry.getKey());
            if (access$200 == -1 || !Objects.equal(CompactHashMap.this.values[access$200], entry.getValue())) {
                return false;
            }
            Object unused = CompactHashMap.this.removeEntry(access$200);
            return true;
        }

        public int size() {
            return CompactHashMap.this.size;
        }
    }

    public abstract class Itr<T> implements Iterator<T> {
        public int currentIndex;
        public int expectedModCount;
        public int indexToRemove;

        private Itr() {
            this.expectedModCount = CompactHashMap.this.modCount;
            this.currentIndex = CompactHashMap.this.firstEntryIndex();
            this.indexToRemove = -1;
        }

        private void checkForConcurrentModification() {
            if (CompactHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T getOutput(int i11);

        public boolean hasNext() {
            return this.currentIndex >= 0;
        }

        public T next() {
            checkForConcurrentModification();
            if (hasNext()) {
                int i11 = this.currentIndex;
                this.indexToRemove = i11;
                T output = getOutput(i11);
                this.currentIndex = CompactHashMap.this.getSuccessor(this.currentIndex);
                return output;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.indexToRemove >= 0);
            this.expectedModCount++;
            Object unused = CompactHashMap.this.removeEntry(this.indexToRemove);
            this.currentIndex = CompactHashMap.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
            this.indexToRemove = -1;
        }
    }

    public class KeySetView extends AbstractSet<K> {
        public KeySetView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return CompactHashMap.this.keySetIterator();
        }

        public boolean remove(Object obj) {
            int access$200 = CompactHashMap.this.indexOf(obj);
            if (access$200 == -1) {
                return false;
            }
            Object unused = CompactHashMap.this.removeEntry(access$200);
            return true;
        }

        public int size() {
            return CompactHashMap.this.size;
        }
    }

    public final class MapEntry extends AbstractMapEntry<K, V> {
        private final K key;
        private int lastKnownIndex;

        public MapEntry(int i11) {
            this.key = CompactHashMap.this.keys[i11];
            this.lastKnownIndex = i11;
        }

        private void updateLastKnownIndex() {
            int i11 = this.lastKnownIndex;
            if (i11 == -1 || i11 >= CompactHashMap.this.size() || !Objects.equal(this.key, CompactHashMap.this.keys[this.lastKnownIndex])) {
                this.lastKnownIndex = CompactHashMap.this.indexOf(this.key);
            }
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            updateLastKnownIndex();
            int i11 = this.lastKnownIndex;
            if (i11 == -1) {
                return null;
            }
            return CompactHashMap.this.values[i11];
        }

        public V setValue(V v11) {
            updateLastKnownIndex();
            int i11 = this.lastKnownIndex;
            if (i11 == -1) {
                CompactHashMap.this.put(this.key, v11);
                return null;
            }
            V[] vArr = CompactHashMap.this.values;
            V v12 = vArr[i11];
            vArr[i11] = v11;
            return v12;
        }
    }

    public class ValuesView extends AbstractCollection<V> {
        public ValuesView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public Iterator<V> iterator() {
            return CompactHashMap.this.valuesIterator();
        }

        public int size() {
            return CompactHashMap.this.size;
        }
    }

    public CompactHashMap() {
        init(3);
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i11) {
        return new CompactHashMap<>(i11);
    }

    private static int getHash(long j11) {
        return (int) (j11 >>> 32);
    }

    private static int getNext(long j11) {
        return (int) j11;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    /* access modifiers changed from: private */
    public int indexOf(Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int smearedHash = Hashing.smearedHash(obj);
        int i11 = this.table[hashTableMask() & smearedHash];
        while (i11 != -1) {
            long j11 = this.entries[i11];
            if (getHash(j11) == smearedHash && Objects.equal(obj, this.keys[i11])) {
                return i11;
            }
            i11 = getNext(j11);
        }
        return -1;
    }

    private static long[] newEntries(int i11) {
        long[] jArr = new long[i11];
        Arrays.fill(jArr, -1);
        return jArr;
    }

    private static int[] newTable(int i11) {
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i11 = 0; i11 < readInt; i11++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public V removeEntry(int i11) {
        return remove(this.keys[i11], getHash(this.entries[i11]));
    }

    private void resizeMeMaybe(int i11) {
        int length = this.entries.length;
        if (i11 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    private void resizeTable(int i11) {
        int[] newTable = newTable(i11);
        long[] jArr = this.entries;
        int length = newTable.length - 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            int hash = getHash(jArr[i12]);
            int i13 = hash & length;
            int i14 = newTable[i13];
            newTable[i13] = i12;
            jArr[i12] = (((long) hash) << 32) | (((long) i14) & 4294967295L);
        }
        this.table = newTable;
    }

    private static long swapNext(long j11, int i11) {
        return (j11 & HASH_MASK) | (((long) i11) & 4294967295L);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.size);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            objectOutputStream.writeObject(this.keys[firstEntryIndex]);
            objectOutputStream.writeObject(this.values[firstEntryIndex]);
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
    }

    public void accessEntry(int i11) {
    }

    public int adjustAfterRemove(int i11, int i12) {
        return i11 - 1;
    }

    public void allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int i11 = this.modCount;
        this.table = newTable(Hashing.closedTableSize(i11, 1.0d));
        this.entries = newEntries(i11);
        this.keys = new Object[i11];
        this.values = new Object[i11];
    }

    public void clear() {
        if (!needsAllocArrays()) {
            this.modCount++;
            Arrays.fill(this.keys, 0, this.size, (Object) null);
            Arrays.fill(this.values, 0, this.size, (Object) null);
            Arrays.fill(this.table, -1);
            Arrays.fill(this.entries, 0, this.size, -1);
            this.size = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean containsValue(Object obj) {
        for (int i11 = 0; i11 < this.size; i11++) {
            if (Objects.equal(obj, this.values[i11])) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new EntrySetView();
    }

    public Set<K> createKeySet() {
        return new KeySetView();
    }

    public Collection<V> createValues() {
        return new ValuesView();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() {
            public Map.Entry<K, V> getOutput(int i11) {
                return new MapEntry(i11);
            }
        };
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public V get(Object obj) {
        int indexOf = indexOf(obj);
        accessEntry(indexOf);
        if (indexOf == -1) {
            return null;
        }
        return this.values[indexOf];
    }

    public int getSuccessor(int i11) {
        int i12 = i11 + 1;
        if (i12 < this.size) {
            return i12;
        }
        return -1;
    }

    public void init(int i11) {
        Preconditions.checkArgument(i11 >= 0, "Expected size must be non-negative");
        this.modCount = Math.max(1, i11);
    }

    public void insertEntry(int i11, K k11, V v11, int i12) {
        this.entries[i11] = (((long) i12) << 32) | 4294967295L;
        this.keys[i11] = k11;
        this.values[i11] = v11;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    public Iterator<K> keySetIterator() {
        return new CompactHashMap<K, V>.Itr<K>() {
            public K getOutput(int i11) {
                return CompactHashMap.this.keys[i11];
            }
        };
    }

    public void moveLastEntry(int i11) {
        int size2 = size() - 1;
        if (i11 < size2) {
            Object[] objArr = this.keys;
            objArr[i11] = objArr[size2];
            Object[] objArr2 = this.values;
            objArr2[i11] = objArr2[size2];
            objArr[size2] = null;
            objArr2[size2] = null;
            long[] jArr = this.entries;
            long j11 = jArr[size2];
            jArr[i11] = j11;
            jArr[size2] = -1;
            int hash = getHash(j11) & hashTableMask();
            int[] iArr = this.table;
            int i12 = iArr[hash];
            if (i12 == size2) {
                iArr[hash] = i11;
                return;
            }
            while (true) {
                long j12 = this.entries[i12];
                int next = getNext(j12);
                if (next == size2) {
                    this.entries[i12] = swapNext(j12, i11);
                    return;
                }
                i12 = next;
            }
        } else {
            this.keys[i11] = null;
            this.values[i11] = null;
            this.entries[i11] = -1;
        }
    }

    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @CanIgnoreReturnValue
    public V put(K k11, V v11) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        V[] vArr = this.values;
        int smearedHash = Hashing.smearedHash(k11);
        int hashTableMask = hashTableMask() & smearedHash;
        int i11 = this.size;
        int[] iArr = this.table;
        int i12 = iArr[hashTableMask];
        if (i12 == -1) {
            iArr[hashTableMask] = i11;
        } else {
            while (true) {
                long j11 = jArr[i12];
                if (getHash(j11) != smearedHash || !Objects.equal(k11, objArr[i12])) {
                    int next = getNext(j11);
                    if (next == -1) {
                        jArr[i12] = swapNext(j11, i11);
                        break;
                    }
                    i12 = next;
                } else {
                    V v12 = vArr[i12];
                    vArr[i12] = v11;
                    accessEntry(i12);
                    return v12;
                }
            }
        }
        if (i11 != Integer.MAX_VALUE) {
            int i13 = i11 + 1;
            resizeMeMaybe(i13);
            insertEntry(i11, k11, v11, smearedHash);
            this.size = i13;
            int length = this.table.length;
            if (Hashing.needsResizing(i11, length, 1.0d)) {
                resizeTable(length * 2);
            }
            this.modCount++;
            return null;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @CanIgnoreReturnValue
    public V remove(Object obj) {
        if (needsAllocArrays()) {
            return null;
        }
        return remove(obj, Hashing.smearedHash(obj));
    }

    public void resizeEntries(int i11) {
        this.keys = Arrays.copyOf(this.keys, i11);
        this.values = Arrays.copyOf(this.values, i11);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i11);
        if (i11 > length) {
            Arrays.fill(copyOf, length, i11, -1);
        }
        this.entries = copyOf;
    }

    public int size() {
        return this.size;
    }

    public void trimToSize() {
        if (!needsAllocArrays()) {
            int i11 = this.size;
            if (i11 < this.entries.length) {
                resizeEntries(i11);
            }
            int closedTableSize = Hashing.closedTableSize(i11, 1.0d);
            if (closedTableSize < this.table.length) {
                resizeTable(closedTableSize);
            }
        }
    }

    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    public Iterator<V> valuesIterator() {
        return new CompactHashMap<K, V>.Itr<V>() {
            public V getOutput(int i11) {
                return CompactHashMap.this.values[i11];
            }
        };
    }

    public CompactHashMap(int i11) {
        init(i11);
    }

    private V remove(Object obj, int i11) {
        int hashTableMask = hashTableMask() & i11;
        int i12 = this.table[hashTableMask];
        if (i12 == -1) {
            return null;
        }
        int i13 = -1;
        while (true) {
            if (getHash(this.entries[i12]) != i11 || !Objects.equal(obj, this.keys[i12])) {
                int next = getNext(this.entries[i12]);
                if (next == -1) {
                    return null;
                }
                int i14 = next;
                i13 = i12;
                i12 = i14;
            } else {
                V v11 = this.values[i12];
                if (i13 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i12]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i13] = swapNext(jArr[i13], getNext(jArr[i12]));
                }
                moveLastEntry(i12);
                this.size--;
                this.modCount++;
                return v11;
            }
        }
    }
}
