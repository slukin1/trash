package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final DoubleArrayList EMPTY_LIST;
    private double[] array;
    private int size;

    static {
        DoubleArrayList doubleArrayList = new DoubleArrayList(new double[0], 0);
        EMPTY_LIST = doubleArrayList;
        doubleArrayList.makeImmutable();
    }

    public DoubleArrayList() {
        this(new double[10], 0);
    }

    public static DoubleArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int i11 = doubleArrayList.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            double[] dArr = this.array;
            if (i13 > dArr.length) {
                this.array = Arrays.copyOf(dArr, i13);
            }
            System.arraycopy(doubleArrayList.array, 0, this.array, this.size, doubleArrayList.size);
            this.size = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addDouble(double d11) {
        ensureIsMutable();
        int i11 = this.size;
        double[] dArr = this.array;
        if (i11 == dArr.length) {
            double[] dArr2 = new double[(((i11 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i11);
            this.array = dArr2;
        }
        double[] dArr3 = this.array;
        int i12 = this.size;
        this.size = i12 + 1;
        dArr3[i12] = d11;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.size != doubleArrayList.size) {
            return false;
        }
        double[] dArr = doubleArrayList.array;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (Double.doubleToLongBits(this.array[i11]) != Double.doubleToLongBits(dArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public double getDouble(int i11) {
        ensureIndexInRange(i11);
        return this.array[i11];
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + Internal.hashLong(Double.doubleToLongBits(this.array[i12]));
        }
        return i11;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size2 = size();
        for (int i11 = 0; i11 < size2; i11++) {
            if (this.array[i11] == doubleValue) {
                return i11;
            }
        }
        return -1;
    }

    public void removeRange(int i11, int i12) {
        ensureIsMutable();
        if (i12 >= i11) {
            double[] dArr = this.array;
            System.arraycopy(dArr, i12, dArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public double setDouble(int i11, double d11) {
        ensureIsMutable();
        ensureIndexInRange(i11);
        double[] dArr = this.array;
        double d12 = dArr[i11];
        dArr[i11] = d11;
        return d12;
    }

    public int size() {
        return this.size;
    }

    private DoubleArrayList(double[] dArr, int i11) {
        this.array = dArr;
        this.size = i11;
    }

    public Double get(int i11) {
        return Double.valueOf(getDouble(i11));
    }

    public Internal.DoubleList mutableCopyWithCapacity(int i11) {
        if (i11 >= this.size) {
            return new DoubleArrayList(Arrays.copyOf(this.array, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public Double remove(int i11) {
        ensureIsMutable();
        ensureIndexInRange(i11);
        double[] dArr = this.array;
        double d11 = dArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(dArr, i11 + 1, dArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d11);
    }

    public Double set(int i11, Double d11) {
        return Double.valueOf(setDouble(i11, d11.doubleValue()));
    }

    public boolean add(Double d11) {
        addDouble(d11.doubleValue());
        return true;
    }

    public void add(int i11, Double d11) {
        addDouble(i11, d11.doubleValue());
    }

    private void addDouble(int i11, double d11) {
        int i12;
        ensureIsMutable();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i11));
        }
        double[] dArr = this.array;
        if (i12 < dArr.length) {
            System.arraycopy(dArr, i11, dArr, i11 + 1, i12 - i11);
        } else {
            double[] dArr2 = new double[(((i12 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i11);
            System.arraycopy(this.array, i11, dArr2, i11 + 1, this.size - i11);
            this.array = dArr2;
        }
        this.array[i11] = d11;
        this.size++;
        this.modCount++;
    }
}
