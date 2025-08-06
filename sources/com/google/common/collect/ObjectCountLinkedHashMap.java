package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

@GwtCompatible(emulated = true, serializable = true)
class ObjectCountLinkedHashMap<K> extends ObjectCountHashMap<K> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;
    @VisibleForTesting
    public transient long[] links;

    public ObjectCountLinkedHashMap() {
        this(3);
    }

    public static <K> ObjectCountLinkedHashMap<K> create() {
        return new ObjectCountLinkedHashMap<>();
    }

    public static <K> ObjectCountLinkedHashMap<K> createWithExpectedSize(int i11) {
        return new ObjectCountLinkedHashMap<>(i11);
    }

    private int getPredecessor(int i11) {
        return (int) (this.links[i11] >>> 32);
    }

    private int getSuccessor(int i11) {
        return (int) this.links[i11];
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

    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    public int firstIndex() {
        int i11 = this.firstEntry;
        if (i11 == -2) {
            return -1;
        }
        return i11;
    }

    public void init(int i11, float f11) {
        super.init(i11, f11);
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] jArr = new long[i11];
        this.links = jArr;
        Arrays.fill(jArr, -1);
    }

    public void insertEntry(int i11, K k11, int i12, int i13) {
        super.insertEntry(i11, k11, i12, i13);
        setSucceeds(this.lastEntry, i11);
        setSucceeds(i11, -2);
    }

    public void moveLastEntry(int i11) {
        int size = size() - 1;
        setSucceeds(getPredecessor(i11), getSuccessor(i11));
        if (i11 < size) {
            setSucceeds(getPredecessor(size), i11);
            setSucceeds(i11, getSuccessor(size));
        }
        super.moveLastEntry(i11);
    }

    public int nextIndex(int i11) {
        int successor = getSuccessor(i11);
        if (successor == -2) {
            return -1;
        }
        return successor;
    }

    public int nextIndexAfterRemove(int i11, int i12) {
        return i11 == size() ? i12 : i11;
    }

    public void resizeEntries(int i11) {
        super.resizeEntries(i11);
        long[] jArr = this.links;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i11);
        this.links = copyOf;
        Arrays.fill(copyOf, length, i11, -1);
    }

    public ObjectCountLinkedHashMap(int i11) {
        this(i11, 1.0f);
    }

    public ObjectCountLinkedHashMap(int i11, float f11) {
        super(i11, f11);
    }

    public ObjectCountLinkedHashMap(ObjectCountHashMap<K> objectCountHashMap) {
        init(objectCountHashMap.size(), 1.0f);
        int firstIndex = objectCountHashMap.firstIndex();
        while (firstIndex != -1) {
            put(objectCountHashMap.getKey(firstIndex), objectCountHashMap.getValue(firstIndex));
            firstIndex = objectCountHashMap.nextIndex(firstIndex);
        }
    }
}
