package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final LongArrayList EMPTY_LIST;
    private long[] array;
    private int size;

    static {
        LongArrayList longArrayList = new LongArrayList(new long[0], 0);
        EMPTY_LIST = longArrayList;
        longArrayList.makeImmutable();
    }

    public LongArrayList() {
        this(new long[10], 0);
    }

    public static LongArrayList emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int i11) {
        if (i11 < 0 || i11 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i11));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i11) {
        return "Index:" + i11 + ", Size:" + this.size;
    }

    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i11 = longArrayList.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            long[] jArr = this.array;
            if (i13 > jArr.length) {
                this.array = Arrays.copyOf(jArr, i13);
            }
            System.arraycopy(longArrayList.array, 0, this.array, this.size, longArrayList.size);
            this.size = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addLong(long j11) {
        ensureIsMutable();
        int i11 = this.size;
        long[] jArr = this.array;
        if (i11 == jArr.length) {
            long[] jArr2 = new long[(((i11 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            this.array = jArr2;
        }
        long[] jArr3 = this.array;
        int i12 = this.size;
        this.size = i12 + 1;
        jArr3[i12] = j11;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.size != longArrayList.size) {
            return false;
        }
        long[] jArr = longArrayList.array;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.array[i11] != jArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public long getLong(int i11) {
        ensureIndexInRange(i11);
        return this.array[i11];
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + Internal.hashLong(this.array[i12]);
        }
        return i11;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size2 = size();
        for (int i11 = 0; i11 < size2; i11++) {
            if (this.array[i11] == longValue) {
                return i11;
            }
        }
        return -1;
    }

    public void removeRange(int i11, int i12) {
        ensureIsMutable();
        if (i12 >= i11) {
            long[] jArr = this.array;
            System.arraycopy(jArr, i12, jArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public long setLong(int i11, long j11) {
        ensureIsMutable();
        ensureIndexInRange(i11);
        long[] jArr = this.array;
        long j12 = jArr[i11];
        jArr[i11] = j11;
        return j12;
    }

    public int size() {
        return this.size;
    }

    private LongArrayList(long[] jArr, int i11) {
        this.array = jArr;
        this.size = i11;
    }

    public Long get(int i11) {
        return Long.valueOf(getLong(i11));
    }

    public Internal.LongList mutableCopyWithCapacity(int i11) {
        if (i11 >= this.size) {
            return new LongArrayList(Arrays.copyOf(this.array, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public Long remove(int i11) {
        ensureIsMutable();
        ensureIndexInRange(i11);
        long[] jArr = this.array;
        long j11 = jArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(jArr, i11 + 1, jArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j11);
    }

    public Long set(int i11, Long l11) {
        return Long.valueOf(setLong(i11, l11.longValue()));
    }

    public boolean add(Long l11) {
        addLong(l11.longValue());
        return true;
    }

    public void add(int i11, Long l11) {
        addLong(i11, l11.longValue());
    }

    private void addLong(int i11, long j11) {
        int i12;
        ensureIsMutable();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i11));
        }
        long[] jArr = this.array;
        if (i12 < jArr.length) {
            System.arraycopy(jArr, i11, jArr, i11 + 1, i12 - i11);
        } else {
            long[] jArr2 = new long[(((i12 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            System.arraycopy(this.array, i11, jArr2, i11 + 1, this.size - i11);
            this.array = jArr2;
        }
        this.array[i11] = j11;
        this.size++;
        this.modCount++;
    }
}
