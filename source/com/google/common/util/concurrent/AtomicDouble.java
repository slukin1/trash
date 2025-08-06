package com.google.common.util.concurrent;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicDouble extends Number {
    private static final long serialVersionUID = 0;
    private transient AtomicLong value;

    public AtomicDouble(double d11) {
        this.value = new AtomicLong(Double.doubleToRawLongBits(d11));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.value = new AtomicLong();
        set(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(get());
    }

    @CanIgnoreReturnValue
    public final double addAndGet(double d11) {
        long j11;
        double longBitsToDouble;
        do {
            j11 = this.value.get();
            longBitsToDouble = Double.longBitsToDouble(j11) + d11;
        } while (!this.value.compareAndSet(j11, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(double d11, double d12) {
        return this.value.compareAndSet(Double.doubleToRawLongBits(d11), Double.doubleToRawLongBits(d12));
    }

    public double doubleValue() {
        return get();
    }

    public float floatValue() {
        return (float) get();
    }

    public final double get() {
        return Double.longBitsToDouble(this.value.get());
    }

    @CanIgnoreReturnValue
    public final double getAndAdd(double d11) {
        long j11;
        double longBitsToDouble;
        do {
            j11 = this.value.get();
            longBitsToDouble = Double.longBitsToDouble(j11);
        } while (!this.value.compareAndSet(j11, Double.doubleToRawLongBits(longBitsToDouble + d11)));
        return longBitsToDouble;
    }

    public final double getAndSet(double d11) {
        return Double.longBitsToDouble(this.value.getAndSet(Double.doubleToRawLongBits(d11)));
    }

    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double d11) {
        this.value.lazySet(Double.doubleToRawLongBits(d11));
    }

    public long longValue() {
        return (long) get();
    }

    public final void set(double d11) {
        this.value.set(Double.doubleToRawLongBits(d11));
    }

    public String toString() {
        return Double.toString(get());
    }

    public final boolean weakCompareAndSet(double d11, double d12) {
        return this.value.weakCompareAndSet(Double.doubleToRawLongBits(d11), Double.doubleToRawLongBits(d12));
    }

    public AtomicDouble() {
        this(0.0d);
    }
}
