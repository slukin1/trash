package com.google.android.exoplayer2.util;

import java.util.Arrays;

public final class TimedValueQueue<V> {
    private static final int INITIAL_BUFFER_SIZE = 10;
    private int first;
    private int size;
    private long[] timestamps;
    private V[] values;

    public TimedValueQueue() {
        this(10);
    }

    private void addUnchecked(long j11, V v11) {
        int i11 = this.first;
        int i12 = this.size;
        V[] vArr = this.values;
        int length = (i11 + i12) % vArr.length;
        this.timestamps[length] = j11;
        vArr[length] = v11;
        this.size = i12 + 1;
    }

    private void clearBufferOnTimeDiscontinuity(long j11) {
        int i11 = this.size;
        if (i11 > 0) {
            if (j11 <= this.timestamps[((this.first + i11) - 1) % this.values.length]) {
                clear();
            }
        }
    }

    private void doubleCapacityIfFull() {
        int length = this.values.length;
        if (this.size >= length) {
            int i11 = length * 2;
            long[] jArr = new long[i11];
            V[] newArray = newArray(i11);
            int i12 = this.first;
            int i13 = length - i12;
            System.arraycopy(this.timestamps, i12, jArr, 0, i13);
            System.arraycopy(this.values, this.first, newArray, 0, i13);
            int i14 = this.first;
            if (i14 > 0) {
                System.arraycopy(this.timestamps, 0, jArr, i13, i14);
                System.arraycopy(this.values, 0, newArray, i13, this.first);
            }
            this.timestamps = jArr;
            this.values = newArray;
            this.first = 0;
        }
    }

    private static <V> V[] newArray(int i11) {
        return new Object[i11];
    }

    private V popFirst() {
        Assertions.checkState(this.size > 0);
        V[] vArr = this.values;
        int i11 = this.first;
        V v11 = vArr[i11];
        vArr[i11] = null;
        this.first = (i11 + 1) % vArr.length;
        this.size--;
        return v11;
    }

    public synchronized void add(long j11, V v11) {
        clearBufferOnTimeDiscontinuity(j11);
        doubleCapacityIfFull();
        addUnchecked(j11, v11);
    }

    public synchronized void clear() {
        this.first = 0;
        this.size = 0;
        Arrays.fill(this.values, (Object) null);
    }

    public synchronized V poll(long j11) {
        return poll(j11, false);
    }

    public synchronized V pollFirst() {
        return this.size == 0 ? null : popFirst();
    }

    public synchronized V pollFloor(long j11) {
        return poll(j11, true);
    }

    public synchronized int size() {
        return this.size;
    }

    public TimedValueQueue(int i11) {
        this.timestamps = new long[i11];
        this.values = newArray(i11);
    }

    private V poll(long j11, boolean z11) {
        V v11 = null;
        long j12 = Long.MAX_VALUE;
        while (this.size > 0) {
            long j13 = j11 - this.timestamps[this.first];
            if (j13 < 0 && (z11 || (-j13) >= j12)) {
                break;
            }
            v11 = popFirst();
            j12 = j13;
        }
        return v11;
    }
}
