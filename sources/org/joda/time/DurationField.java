package org.joda.time;

public abstract class DurationField implements Comparable<DurationField> {
    public abstract long add(long j11, int i11);

    public abstract long add(long j11, long j12);

    public abstract int getDifference(long j11, long j12);

    public abstract long getDifferenceAsLong(long j11, long j12);

    public abstract long getMillis(int i11);

    public abstract long getMillis(int i11, long j11);

    public abstract long getMillis(long j11);

    public abstract long getMillis(long j11, long j12);

    public abstract String getName();

    public abstract DurationFieldType getType();

    public abstract long getUnitMillis();

    public abstract int getValue(long j11);

    public abstract int getValue(long j11, long j12);

    public abstract long getValueAsLong(long j11);

    public abstract long getValueAsLong(long j11, long j12);

    public abstract boolean isPrecise();

    public abstract boolean isSupported();

    public long subtract(long j11, int i11) {
        if (i11 == Integer.MIN_VALUE) {
            return subtract(j11, (long) i11);
        }
        return add(j11, -i11);
    }

    public abstract String toString();

    public long subtract(long j11, long j12) {
        if (j12 != Long.MIN_VALUE) {
            return add(j11, -j12);
        }
        throw new ArithmeticException("Long.MIN_VALUE cannot be negated");
    }
}
