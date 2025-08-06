package com.google.android.exoplayer2.util;

import java.util.NoSuchElementException;

public final class IntArrayQueue {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private int[] data;
    private int headIndex = 0;
    private int size = 0;
    private int tailIndex = -1;
    private int wrapAroundMask;

    public IntArrayQueue() {
        int[] iArr = new int[16];
        this.data = iArr;
        this.wrapAroundMask = iArr.length - 1;
    }

    private void doubleArraySize() {
        int[] iArr = this.data;
        int length = iArr.length << 1;
        if (length >= 0) {
            int[] iArr2 = new int[length];
            int length2 = iArr.length;
            int i11 = this.headIndex;
            int i12 = length2 - i11;
            System.arraycopy(iArr, i11, iArr2, 0, i12);
            System.arraycopy(this.data, 0, iArr2, i12, i11);
            this.headIndex = 0;
            this.tailIndex = this.size - 1;
            this.data = iArr2;
            this.wrapAroundMask = iArr2.length - 1;
            return;
        }
        throw new IllegalStateException();
    }

    public void add(int i11) {
        if (this.size == this.data.length) {
            doubleArraySize();
        }
        int i12 = (this.tailIndex + 1) & this.wrapAroundMask;
        this.tailIndex = i12;
        this.data[i12] = i11;
        this.size++;
    }

    public int capacity() {
        return this.data.length;
    }

    public void clear() {
        this.headIndex = 0;
        this.tailIndex = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int remove() {
        int i11 = this.size;
        if (i11 != 0) {
            int[] iArr = this.data;
            int i12 = this.headIndex;
            int i13 = iArr[i12];
            this.headIndex = (i12 + 1) & this.wrapAroundMask;
            this.size = i11 - 1;
            return i13;
        }
        throw new NoSuchElementException();
    }

    public int size() {
        return this.size;
    }
}
