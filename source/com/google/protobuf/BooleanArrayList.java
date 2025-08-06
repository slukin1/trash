package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final BooleanArrayList EMPTY_LIST;
    private boolean[] array;
    private int size;

    static {
        BooleanArrayList booleanArrayList = new BooleanArrayList(new boolean[0], 0);
        EMPTY_LIST = booleanArrayList;
        booleanArrayList.makeImmutable();
    }

    public BooleanArrayList() {
        this(new boolean[10], 0);
    }

    public static BooleanArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i11 = booleanArrayList.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            boolean[] zArr = this.array;
            if (i13 > zArr.length) {
                this.array = Arrays.copyOf(zArr, i13);
            }
            System.arraycopy(booleanArrayList.array, 0, this.array, this.size, booleanArrayList.size);
            this.size = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addBoolean(boolean z11) {
        ensureIsMutable();
        int i11 = this.size;
        boolean[] zArr = this.array;
        if (i11 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i11 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            this.array = zArr2;
        }
        boolean[] zArr3 = this.array;
        int i12 = this.size;
        this.size = i12 + 1;
        zArr3[i12] = z11;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.size != booleanArrayList.size) {
            return false;
        }
        boolean[] zArr = booleanArrayList.array;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (this.array[i11] != zArr[i11]) {
                return false;
            }
        }
        return true;
    }

    public boolean getBoolean(int i11) {
        ensureIndexInRange(i11);
        return this.array[i11];
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + Internal.hashBoolean(this.array[i12]);
        }
        return i11;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size2 = size();
        for (int i11 = 0; i11 < size2; i11++) {
            if (this.array[i11] == booleanValue) {
                return i11;
            }
        }
        return -1;
    }

    public void removeRange(int i11, int i12) {
        ensureIsMutable();
        if (i12 >= i11) {
            boolean[] zArr = this.array;
            System.arraycopy(zArr, i12, zArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public boolean setBoolean(int i11, boolean z11) {
        ensureIsMutable();
        ensureIndexInRange(i11);
        boolean[] zArr = this.array;
        boolean z12 = zArr[i11];
        zArr[i11] = z11;
        return z12;
    }

    public int size() {
        return this.size;
    }

    private BooleanArrayList(boolean[] zArr, int i11) {
        this.array = zArr;
        this.size = i11;
    }

    public Boolean get(int i11) {
        return Boolean.valueOf(getBoolean(i11));
    }

    public Internal.BooleanList mutableCopyWithCapacity(int i11) {
        if (i11 >= this.size) {
            return new BooleanArrayList(Arrays.copyOf(this.array, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public Boolean remove(int i11) {
        ensureIsMutable();
        ensureIndexInRange(i11);
        boolean[] zArr = this.array;
        boolean z11 = zArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(zArr, i11 + 1, zArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z11);
    }

    public Boolean set(int i11, Boolean bool) {
        return Boolean.valueOf(setBoolean(i11, bool.booleanValue()));
    }

    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    public void add(int i11, Boolean bool) {
        addBoolean(i11, bool.booleanValue());
    }

    private void addBoolean(int i11, boolean z11) {
        int i12;
        ensureIsMutable();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i11));
        }
        boolean[] zArr = this.array;
        if (i12 < zArr.length) {
            System.arraycopy(zArr, i11, zArr, i11 + 1, i12 - i11);
        } else {
            boolean[] zArr2 = new boolean[(((i12 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i11);
            System.arraycopy(this.array, i11, zArr2, i11 + 1, this.size - i11);
            this.array = zArr2;
        }
        this.array[i11] = z11;
        this.size++;
        this.modCount++;
    }
}
