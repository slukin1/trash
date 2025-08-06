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
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtIncompatible
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    @VisibleForTesting
    public static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final float LOAD_FACTOR = 1.0f;
    private static final long NEXT_MASK = 4294967295L;
    public static final int UNSET = -1;
    public transient Object[] elements;
    /* access modifiers changed from: private */
    public transient long[] entries;
    public transient int modCount;
    private transient int size;
    private transient int[] table;

    public CompactHashSet() {
        init(3);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i11) {
        return new CompactHashSet<>(i11);
    }

    /* access modifiers changed from: private */
    public static int getHash(long j11) {
        return (int) (j11 >>> 32);
    }

    private static int getNext(long j11) {
        return (int) j11;
    }

    private int hashTableMask() {
        return this.table.length - 1;
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
                add(objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
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
            objectOutputStream.writeObject(this.elements[firstEntryIndex]);
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
    }

    @CanIgnoreReturnValue
    public boolean add(E e11) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        long[] jArr = this.entries;
        Object[] objArr = this.elements;
        int smearedHash = Hashing.smearedHash(e11);
        int hashTableMask = hashTableMask() & smearedHash;
        int i11 = this.size;
        int[] iArr = this.table;
        int i12 = iArr[hashTableMask];
        if (i12 == -1) {
            iArr[hashTableMask] = i11;
        } else {
            while (true) {
                long j11 = jArr[i12];
                if (getHash(j11) == smearedHash && Objects.equal(e11, objArr[i12])) {
                    return false;
                }
                int next = getNext(j11);
                if (next == -1) {
                    jArr[i12] = swapNext(j11, i11);
                    break;
                }
                i12 = next;
            }
        }
        if (i11 != Integer.MAX_VALUE) {
            int i13 = i11 + 1;
            resizeMeMaybe(i13);
            insertEntry(i11, e11, smearedHash);
            this.size = i13;
            int length = this.table.length;
            if (Hashing.needsResizing(i11, length, 1.0d)) {
                resizeTable(length * 2);
            }
            this.modCount++;
            return true;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    public int adjustAfterRemove(int i11, int i12) {
        return i11 - 1;
    }

    public void allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int i11 = this.modCount;
        this.table = newTable(Hashing.closedTableSize(i11, 1.0d));
        this.entries = newEntries(i11);
        this.elements = new Object[i11];
    }

    public void clear() {
        if (!needsAllocArrays()) {
            this.modCount++;
            Arrays.fill(this.elements, 0, this.size, (Object) null);
            Arrays.fill(this.table, -1);
            Arrays.fill(this.entries, 0, this.size, -1);
            this.size = 0;
        }
    }

    public boolean contains(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        int smearedHash = Hashing.smearedHash(obj);
        int i11 = this.table[hashTableMask() & smearedHash];
        while (i11 != -1) {
            long j11 = this.entries[i11];
            if (getHash(j11) == smearedHash && Objects.equal(obj, this.elements[i11])) {
                return true;
            }
            i11 = getNext(j11);
        }
        return false;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public int getSuccessor(int i11) {
        int i12 = i11 + 1;
        if (i12 < this.size) {
            return i12;
        }
        return -1;
    }

    public void init(int i11) {
        Preconditions.checkArgument(i11 >= 0, "Initial capacity must be non-negative");
        this.modCount = Math.max(1, i11);
    }

    public void insertEntry(int i11, E e11, int i12) {
        this.entries[i11] = (((long) i12) << 32) | 4294967295L;
        this.elements[i11] = e11;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public int currentIndex;
            public int expectedModCount;
            public int indexToRemove = -1;

            {
                this.expectedModCount = CompactHashSet.this.modCount;
                this.currentIndex = CompactHashSet.this.firstEntryIndex();
            }

            private void checkForConcurrentModification() {
                if (CompactHashSet.this.modCount != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                return this.currentIndex >= 0;
            }

            public E next() {
                checkForConcurrentModification();
                if (hasNext()) {
                    int i11 = this.currentIndex;
                    this.indexToRemove = i11;
                    CompactHashSet compactHashSet = CompactHashSet.this;
                    E e11 = compactHashSet.elements[i11];
                    this.currentIndex = compactHashSet.getSuccessor(i11);
                    return e11;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                checkForConcurrentModification();
                CollectPreconditions.checkRemove(this.indexToRemove >= 0);
                this.expectedModCount++;
                CompactHashSet compactHashSet = CompactHashSet.this;
                boolean unused = compactHashSet.remove(compactHashSet.elements[this.indexToRemove], CompactHashSet.getHash(compactHashSet.entries[this.indexToRemove]));
                this.currentIndex = CompactHashSet.this.adjustAfterRemove(this.currentIndex, this.indexToRemove);
                this.indexToRemove = -1;
            }
        };
    }

    public void moveLastEntry(int i11) {
        int size2 = size() - 1;
        if (i11 < size2) {
            Object[] objArr = this.elements;
            objArr[i11] = objArr[size2];
            objArr[size2] = null;
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
            this.elements[i11] = null;
            this.entries[i11] = -1;
        }
    }

    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @CanIgnoreReturnValue
    public boolean remove(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        return remove(obj, Hashing.smearedHash(obj));
    }

    public void resizeEntries(int i11) {
        this.elements = Arrays.copyOf(this.elements, i11);
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

    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        return Arrays.copyOf(this.elements, this.size);
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

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public CompactHashSet(int i11) {
        init(i11);
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public boolean remove(Object obj, int i11) {
        int hashTableMask = hashTableMask() & i11;
        int i12 = this.table[hashTableMask];
        if (i12 == -1) {
            return false;
        }
        int i13 = -1;
        while (true) {
            if (getHash(this.entries[i12]) != i11 || !Objects.equal(obj, this.elements[i12])) {
                int next = getNext(this.entries[i12]);
                if (next == -1) {
                    return false;
                }
                int i14 = next;
                i13 = i12;
                i12 = i14;
            } else {
                if (i13 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i12]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i13] = swapNext(jArr[i13], getNext(jArr[i12]));
                }
                moveLastEntry(i12);
                this.size--;
                this.modCount++;
                return true;
            }
        }
    }

    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        if (!needsAllocArrays()) {
            return ObjectArrays.toArrayImpl(this.elements, 0, this.size, tArr);
        }
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
