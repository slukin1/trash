package com.google.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST;
    private E[] array;
    private int size;

    static {
        ProtobufArrayList<Object> protobufArrayList = new ProtobufArrayList<>(new Object[0], 0);
        EMPTY_LIST = protobufArrayList;
        protobufArrayList.makeImmutable();
    }

    public ProtobufArrayList() {
        this(new Object[10], 0);
    }

    private static <E> E[] createArray(int i11) {
        return new Object[i11];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
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

    public boolean add(E e11) {
        ensureIsMutable();
        int i11 = this.size;
        E[] eArr = this.array;
        if (i11 == eArr.length) {
            this.array = Arrays.copyOf(eArr, ((i11 * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i12 = this.size;
        this.size = i12 + 1;
        eArr2[i12] = e11;
        this.modCount++;
        return true;
    }

    public E get(int i11) {
        ensureIndexInRange(i11);
        return this.array[i11];
    }

    public E remove(int i11) {
        ensureIsMutable();
        ensureIndexInRange(i11);
        E[] eArr = this.array;
        E e11 = eArr[i11];
        int i12 = this.size;
        if (i11 < i12 - 1) {
            System.arraycopy(eArr, i11 + 1, eArr, i11, (i12 - i11) - 1);
        }
        this.size--;
        this.modCount++;
        return e11;
    }

    public E set(int i11, E e11) {
        ensureIsMutable();
        ensureIndexInRange(i11);
        E[] eArr = this.array;
        E e12 = eArr[i11];
        eArr[i11] = e11;
        this.modCount++;
        return e12;
    }

    public int size() {
        return this.size;
    }

    private ProtobufArrayList(E[] eArr, int i11) {
        this.array = eArr;
        this.size = i11;
    }

    public ProtobufArrayList<E> mutableCopyWithCapacity(int i11) {
        if (i11 >= this.size) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.array, i11), this.size);
        }
        throw new IllegalArgumentException();
    }

    public void add(int i11, E e11) {
        int i12;
        ensureIsMutable();
        if (i11 < 0 || i11 > (i12 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i11));
        }
        E[] eArr = this.array;
        if (i12 < eArr.length) {
            System.arraycopy(eArr, i11, eArr, i11 + 1, i12 - i11);
        } else {
            E[] createArray = createArray(((i12 * 3) / 2) + 1);
            System.arraycopy(this.array, 0, createArray, 0, i11);
            System.arraycopy(this.array, i11, createArray, i11 + 1, this.size - i11);
            this.array = createArray;
        }
        this.array[i11] = e11;
        this.size++;
        this.modCount++;
    }
}
