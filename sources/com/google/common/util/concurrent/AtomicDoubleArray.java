package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.ImmutableLongArray;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;
import okhttp3.HttpUrl;

@GwtIncompatible
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int i11) {
        this.longs = new AtomicLongArray(i11);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        ImmutableLongArray.Builder builder = ImmutableLongArray.builder();
        for (int i11 = 0; i11 < readInt; i11++) {
            builder.add(Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.longs = new AtomicLongArray(builder.build().toArray());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int length = length();
        objectOutputStream.writeInt(length);
        for (int i11 = 0; i11 < length; i11++) {
            objectOutputStream.writeDouble(get(i11));
        }
    }

    @CanIgnoreReturnValue
    public double addAndGet(int i11, double d11) {
        long j11;
        double longBitsToDouble;
        do {
            j11 = this.longs.get(i11);
            longBitsToDouble = Double.longBitsToDouble(j11) + d11;
        } while (!this.longs.compareAndSet(i11, j11, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(int i11, double d11, double d12) {
        return this.longs.compareAndSet(i11, Double.doubleToRawLongBits(d11), Double.doubleToRawLongBits(d12));
    }

    public final double get(int i11) {
        return Double.longBitsToDouble(this.longs.get(i11));
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(int i11, double d11) {
        long j11;
        double longBitsToDouble;
        do {
            j11 = this.longs.get(i11);
            longBitsToDouble = Double.longBitsToDouble(j11);
        } while (!this.longs.compareAndSet(i11, j11, Double.doubleToRawLongBits(longBitsToDouble + d11)));
        return longBitsToDouble;
    }

    public final double getAndSet(int i11, double d11) {
        return Double.longBitsToDouble(this.longs.getAndSet(i11, Double.doubleToRawLongBits(d11)));
    }

    public final void lazySet(int i11, double d11) {
        this.longs.lazySet(i11, Double.doubleToRawLongBits(d11));
    }

    public final int length() {
        return this.longs.length();
    }

    public final void set(int i11, double d11) {
        this.longs.set(i11, Double.doubleToRawLongBits(d11));
    }

    public String toString() {
        int length = length() - 1;
        if (length == -1) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb2 = new StringBuilder((length + 1) * 19);
        sb2.append('[');
        int i11 = 0;
        while (true) {
            sb2.append(Double.longBitsToDouble(this.longs.get(i11)));
            if (i11 == length) {
                sb2.append(']');
                return sb2.toString();
            }
            sb2.append(',');
            sb2.append(' ');
            i11++;
        }
    }

    public final boolean weakCompareAndSet(int i11, double d11, double d12) {
        return this.longs.weakCompareAndSet(i11, Double.doubleToRawLongBits(d11), Double.doubleToRawLongBits(d12));
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i11 = 0; i11 < length; i11++) {
            jArr[i11] = Double.doubleToRawLongBits(dArr[i11]);
        }
        this.longs = new AtomicLongArray(jArr);
    }
}
