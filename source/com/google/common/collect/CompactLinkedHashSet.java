package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@GwtIncompatible
class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;
    private transient int[] predecessor;
    private transient int[] successor;

    public CompactLinkedHashSet() {
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int i11) {
        return new CompactLinkedHashSet<>(i11);
    }

    private int getPredecessor(int i11) {
        return this.predecessor[i11];
    }

    private void setPredecessor(int i11, int i12) {
        this.predecessor[i11] = i12;
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
        this.successor[i11] = i12;
    }

    public int adjustAfterRemove(int i11, int i12) {
        return i11 >= size() ? i12 : i11;
    }

    public void allocArrays() {
        super.allocArrays();
        int length = this.elements.length;
        int[] iArr = new int[length];
        this.predecessor = iArr;
        this.successor = new int[length];
        Arrays.fill(iArr, -1);
        Arrays.fill(this.successor, -1);
    }

    public void clear() {
        if (!needsAllocArrays()) {
            this.firstEntry = -2;
            this.lastEntry = -2;
            Arrays.fill(this.predecessor, 0, size(), -1);
            Arrays.fill(this.successor, 0, size(), -1);
            super.clear();
        }
    }

    public int firstEntryIndex() {
        return this.firstEntry;
    }

    public int getSuccessor(int i11) {
        return this.successor[i11];
    }

    public void init(int i11) {
        super.init(i11);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    public void insertEntry(int i11, E e11, int i12) {
        super.insertEntry(i11, e11, i12);
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
        this.predecessor[size] = -1;
        this.successor[size] = -1;
    }

    public void resizeEntries(int i11) {
        super.resizeEntries(i11);
        int[] iArr = this.predecessor;
        int length = iArr.length;
        this.predecessor = Arrays.copyOf(iArr, i11);
        this.successor = Arrays.copyOf(this.successor, i11);
        if (length < i11) {
            Arrays.fill(this.predecessor, length, i11, -1);
            Arrays.fill(this.successor, length, i11, -1);
        }
    }

    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    public CompactLinkedHashSet(int i11) {
        super(i11);
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public <T> T[] toArray(T[] tArr) {
        return ObjectArrays.toArrayImpl(this, tArr);
    }

    public static <E> CompactLinkedHashSet<E> create(E... eArr) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
