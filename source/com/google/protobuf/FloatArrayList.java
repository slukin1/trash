package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final FloatArrayList EMPTY_LIST;
    private float[] array;
    private int size;

    static {
        FloatArrayList floatArrayList = new FloatArrayList(new float[0], 0);
        EMPTY_LIST = floatArrayList;
        floatArrayList.makeImmutable();
    }

    public FloatArrayList() {
        this(new float[10], 0);
    }

    public static FloatArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i11 = floatArrayList.size;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.size;
        if (Integer.MAX_VALUE - i12 >= i11) {
            int i13 = i12 + i11;
            float[] fArr = this.array;
            if (i13 > fArr.length) {
                this.array = Arrays.copyOf(fArr, i13);
            }
            System.arraycopy(floatArrayList.array, 0, this.array, this.size, floatArrayList.size);
            this.size = i13;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addFloat(float f11) {
        ensureIsMutable();
        int i11 = this.size;
        float[] fArr = this.array;
        if (i11 == fArr.length) {
            float[] fArr2 = new float[(((i11 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            this.array = fArr2;
        }
        float[] fArr3 = this.array;
        int i12 = this.size;
        this.size = i12 + 1;
        fArr3[i12] = f11;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.size != floatArrayList.size) {
            return false;
        }
        float[] fArr = floatArrayList.array;
        for (int i11 = 0; i11 < this.size; i11++) {
            if (Float.floatToIntBits(this.array[i11]) != Float.floatToIntBits(fArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public float getFloat(int i11) {
        ensureIndexInRange(i11);
        return this.array[i11];
    }

    public int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            i11 = (i11 * 31) + Float.floatToIntBits(this.array[i12]);
        }
        return i11;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size2 = size();
        for (int i11 = 0; i11 < size2; i11++) {
            if (this.array[i11] == floatValue) {
                return i11;
            }
        }
        return -1;
    }

    public void removeRange(int i11, int i12) {
        ensureIsMutable();
        if (i12 >= i11) {
            float[] fArr = this.array;
            System.arraycopy(fArr, i12, fArr, i11, this.size - i12);
            this.size -= i12 - i11;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public float setFloat(int i11, float f11) {
        ensureIsMutable();
        ensureIndexInRange(i11);
        float[] fArr = this.array;
        float f12 = fArr[i11];
        fArr[i11] = f11;
        return f12;
    }

    public int size() {
        return this.size;
    }

    private FloatArrayList(float[] fArr, int i11) {
        this.array = fArr;
        this.size = i11;
    }

    public Float get(int i11) {
        return Float.valueOf(getFloat(i11));
    }

    public Internal.FloatList mutableCopyWithCapacity(int i11) {
        if (i11 >= this.size) {
            return new FloatArrayList(Arrays.copyOf(this.array, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public Float remove(int i11) {
        ensureIsMutable();
        ensureIndexInRange(i11);
        float[] fArr = this.array;
        float f11 = fArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(fArr, i11 + 1, fArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f11);
    }

    public Float set(int i11, Float f11) {
        return Float.valueOf(setFloat(i11, f11.floatValue()));
    }

    public boolean add(Float f11) {
        addFloat(f11.floatValue());
        return true;
    }

    public void add(int i11, Float f11) {
        addFloat(i11, f11.floatValue());
    }

    private void addFloat(int i11, float f11) {
        int i12;
        ensureIsMutable();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i11));
        }
        float[] fArr = this.array;
        if (i12 < fArr.length) {
            System.arraycopy(fArr, i11, fArr, i11 + 1, i12 - i11);
        } else {
            float[] fArr2 = new float[(((i12 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i11);
            System.arraycopy(this.array, i11, fArr2, i11 + 1, this.size - i11);
            this.array = fArr2;
        }
        this.array[i11] = f11;
        this.size++;
        this.modCount++;
    }
}
