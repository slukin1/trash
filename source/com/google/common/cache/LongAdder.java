package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.Striped64;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@GwtCompatible(emulated = true)
final class LongAdder extends Striped64 implements LongAddable {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    public void add(long j11) {
        int length;
        Striped64.Cell cell;
        Striped64.Cell[] cellArr = this.cells;
        if (cellArr == null) {
            long j12 = this.base;
            if (casBase(j12, j12 + j11)) {
                return;
            }
        }
        int[] iArr = Striped64.threadHashCode.get();
        boolean z11 = true;
        if (!(iArr == null || cellArr == null || (length = cellArr.length) < 1 || (cell = cellArr[(length - 1) & iArr[0]]) == null)) {
            long j13 = cell.value;
            z11 = cell.cas(j13, j13 + j11);
            if (z11) {
                return;
            }
        }
        retryUpdate(j11, iArr, z11);
    }

    public void decrement() {
        add(-1);
    }

    public double doubleValue() {
        return (double) sum();
    }

    public float floatValue() {
        return (float) sum();
    }

    public final long fn(long j11, long j12) {
        return j11 + j12;
    }

    public void increment() {
        add(1);
    }

    public int intValue() {
        return (int) sum();
    }

    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0);
    }

    public long sum() {
        long j11 = this.base;
        Striped64.Cell[] cellArr = this.cells;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j11 += cell.value;
                }
            }
        }
        return j11;
    }

    public long sumThenReset() {
        long j11 = this.base;
        Striped64.Cell[] cellArr = this.cells;
        this.base = 0;
        if (cellArr != null) {
            for (Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j11 += cell.value;
                    cell.value = 0;
                }
            }
        }
        return j11;
    }

    public String toString() {
        return Long.toString(sum());
    }
}
