package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final IntArrayList EMPTY_LIST;
    private int[] array;
    private int size;

    static {
        IntArrayList intArrayList = new IntArrayList(new int[0], 0);
        EMPTY_LIST = intArrayList;
        intArrayList.makeImmutable();
    }

    public IntArrayList() {
        this(new int[10], 0);
    }

    public static IntArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i11 = intArrayList.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            int[] iArr = this.array;
            if (i13 > iArr.length) {
                this.array = Arrays.copyOf(iArr, i13);
            }
            System.arraycopy(intArrayList.array, 0, this.array, this.size, intArrayList.size);
            this.size = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addInt(int i11) {
        ensureIsMutable();
        int i12 = this.size;
        int[] iArr = this.array;
        if (i12 == iArr.length) {
            int[] iArr2 = new int[(((i12 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.array = iArr2;
        }
        int[] iArr3 = this.array;
        int i13 = this.size;
        this.size = i13 + 1;
        iArr3[i13] = i11;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.size != intArrayList.size) {
            return false;
        }
        int[] iArr = intArrayList.array;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.array[i11] != iArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public int getInt(int i11) {
        ensureIndexInRange(i11);
        return this.array[i11];
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + this.array[i12];
        }
        return i11;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size2 = size();
        for (int i11 = 0; i11 < size2; i11++) {
            if (this.array[i11] == intValue) {
                return i11;
            }
        }
        return -1;
    }

    public void removeRange(int i11, int i12) {
        ensureIsMutable();
        if (i12 >= i11) {
            int[] iArr = this.array;
            System.arraycopy(iArr, i12, iArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int setInt(int i11, int i12) {
        ensureIsMutable();
        ensureIndexInRange(i11);
        int[] iArr = this.array;
        int i13 = iArr[i11];
        iArr[i11] = i12;
        return i13;
    }

    public int size() {
        return this.size;
    }

    private IntArrayList(int[] iArr, int i11) {
        this.array = iArr;
        this.size = i11;
    }

    public Integer get(int i11) {
        return Integer.valueOf(getInt(i11));
    }

    public Internal.IntList mutableCopyWithCapacity(int i11) {
        if (i11 >= this.size) {
            return new IntArrayList(Arrays.copyOf(this.array, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public Integer remove(int i11) {
        ensureIsMutable();
        ensureIndexInRange(i11);
        int[] iArr = this.array;
        int i12 = iArr[i11];
        int i13 = this.size;
        if (i11 < i13 - 1) {
            System.arraycopy(iArr, i11 + 1, iArr, i11, (i13 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i12);
    }

    public Integer set(int i11, Integer num) {
        return Integer.valueOf(setInt(i11, num.intValue()));
    }

    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    public void add(int i11, Integer num) {
        addInt(i11, num.intValue());
    }

    private void addInt(int i11, int i12) {
        int i13;
        ensureIsMutable();
        if (i11 < 0 || i11 > (i13 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i11));
        }
        int[] iArr = this.array;
        if (i13 < iArr.length) {
            System.arraycopy(iArr, i11, iArr, i11 + 1, i13 - i11);
        } else {
            int[] iArr2 = new int[(((i13 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            System.arraycopy(this.array, i11, iArr2, i11 + 1, this.size - i11);
            this.array = iArr2;
        }
        this.array[i11] = i12;
        this.size++;
        this.modCount++;
    }
}
