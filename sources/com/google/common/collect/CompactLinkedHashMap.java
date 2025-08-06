package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

@GwtIncompatible
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int ENDPOINT = -2;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;
    @VisibleForTesting
    public transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> create() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> createWithExpectedSize(int i11) {
        return new CompactLinkedHashMap<>(i11);
    }

    private int getPredecessor(int i11) {
        return (int) (this.links[i11] >>> 32);
    }

    private void setPredecessor(int i11, int i12) {
        long[] jArr = this.links;
        jArr[i11] = (jArr[i11] & 4294967295L) | (((long) i12) << 32);
    }

    private void setSucceeds(int i11, int i12) {
        if (i11 == -2) {
            this.firstEntry = i12;
        } else {
            setSuccessor(i11, i12);
        }
        if (i12 == -2) {
            this.lastEntry = i11;
        } else {
            setPredecessor(i12, i11);
        }
    }

    private void setSuccessor(int i11, int i12) {
        long[] jArr = this.links;
        jArr[i11] = (jArr[i11] & -4294967296L) | (((long) i12) & 4294967295L);
    }

    public void accessEntry(int i11) {
        if (this.accessOrder) {
            setSucceeds(getPredecessor(i11), getSuccessor(i11));
            setSucceeds(this.lastEntry, i11);
            setSucceeds(i11, -2);
            this.modCount++;
        }
    }

    public int adjustAfterRemove(int i11, int i12) {
        return i11 >= size() ? i12 : i11;
    }

    public void allocArrays() {
        super.allocArrays();
        long[] jArr = new long[this.keys.length];
        this.links = jArr;
        Arrays.fill(jArr, -1);
    }

    public void clear() {
        if (!needsAllocArrays()) {
            this.firstEntry = -2;
            this.lastEntry = -2;
            Arrays.fill(this.links, 0, size(), -1);
            super.clear();
        }
    }

    public int firstEntryIndex() {
        return this.firstEntry;
    }

    public int getSuccessor(int i11) {
        return (int) this.links[i11];
    }

    public void init(int i11) {
        super.init(i11);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    public void insertEntry(int i11, K k11, V v11, int i12) {
        super.insertEntry(i11, k11, v11, i12);
        setSucceeds(this.lastEntry, i11);
        setSucceeds(i11, -2);
    }

    public void moveLastEntry(int i11) {
        int size = size() - 1;
        super.moveLastEntry(i11);
        setSucceeds(getPredecessor(i11), getSuccessor(i11));
        if (i11 < size) {
            setSucceeds(getPredecessor(size), i11);
            setSucceeds(i11, getSuccessor(size));
        }
        this.links[size] = -1;
    }

    public void resizeEntries(int i11) {
        super.resizeEntries(i11);
        long[] jArr = this.links;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i11);
        this.links = copyOf;
        if (length < i11) {
            Arrays.fill(copyOf, length, i11, -1);
        }
    }

    public CompactLinkedHashMap(int i11) {
        this(i11, false);
    }

    public CompactLinkedHashMap(int i11, boolean z11) {
        super(i11);
        this.accessOrder = z11;
    }
}
