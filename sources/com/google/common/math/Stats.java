package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.tencent.android.tpush.common.MessageKey;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

@GwtIncompatible
@Beta
public final class Stats implements Serializable {
    public static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    public Stats(long j11, double d11, double d12, double d13, double d14) {
        this.count = j11;
        this.mean = d11;
        this.sumOfSquaresOfDeltas = d12;
        this.min = d13;
        this.max = d14;
    }

    public static Stats fromByteArray(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkArgument(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iterable);
        return statsAccumulator.snapshot();
    }

    public static Stats readFrom(ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        Preconditions.checkArgument(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long count() {
        return this.count;
    }

    public boolean equals(Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        if (this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    public double max() {
        Preconditions.checkState(this.count != 0);
        return this.max;
    }

    public double mean() {
        Preconditions.checkState(this.count != 0);
        return this.mean;
    }

    public double min() {
        Preconditions.checkState(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        Preconditions.checkState(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / ((double) count());
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        Preconditions.checkState(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / ((double) (this.count - 1));
    }

    public double sum() {
        return this.mean * ((double) this.count);
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(order);
        return order.array();
    }

    public String toString() {
        if (count() > 0) {
            return MoreObjects.toStringHelper((Object) this).add("count", this.count).add("mean", this.mean).add("populationStandardDeviation", populationStandardDeviation()).add(MessageKey.MSG_ACCEPT_TIME_MIN, this.min).add("max", this.max).toString();
        }
        return MoreObjects.toStringHelper((Object) this).add("count", this.count).toString();
    }

    public void writeTo(ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer);
        Preconditions.checkArgument(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public static double meanOf(Iterator<? extends Number> it2) {
        Preconditions.checkArgument(it2.hasNext());
        double doubleValue = ((Number) it2.next()).doubleValue();
        long j11 = 1;
        while (it2.hasNext()) {
            double doubleValue2 = ((Number) it2.next()).doubleValue();
            j11++;
            if (!Doubles.isFinite(doubleValue2) || !Doubles.isFinite(doubleValue)) {
                doubleValue = StatsAccumulator.calculateNewMeanNonFinite(doubleValue, doubleValue2);
            } else {
                doubleValue += (doubleValue2 - doubleValue) / ((double) j11);
            }
        }
        return doubleValue;
    }

    public static Stats of(Iterator<? extends Number> it2) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(it2);
        return statsAccumulator.snapshot();
    }

    public static Stats of(double... dArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(dArr);
        return statsAccumulator.snapshot();
    }

    public static double meanOf(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0);
        double d11 = dArr[0];
        for (int i11 = 1; i11 < dArr.length; i11++) {
            double d12 = dArr[i11];
            if (!Doubles.isFinite(d12) || !Doubles.isFinite(d11)) {
                d11 = StatsAccumulator.calculateNewMeanNonFinite(d11, d12);
            } else {
                d11 += (d12 - d11) / ((double) (i11 + 1));
            }
        }
        return d11;
    }

    public static Stats of(int... iArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(iArr);
        return statsAccumulator.snapshot();
    }

    public static Stats of(long... jArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.addAll(jArr);
        return statsAccumulator.snapshot();
    }

    public static double meanOf(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        double d11 = (double) iArr[0];
        for (int i11 = 1; i11 < iArr.length; i11++) {
            double d12 = (double) iArr[i11];
            if (!Doubles.isFinite(d12) || !Doubles.isFinite(d11)) {
                d11 = StatsAccumulator.calculateNewMeanNonFinite(d11, d12);
            } else {
                d11 += (d12 - d11) / ((double) (i11 + 1));
            }
        }
        return d11;
    }

    public static double meanOf(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        double d11 = (double) jArr[0];
        for (int i11 = 1; i11 < jArr.length; i11++) {
            double d12 = (double) jArr[i11];
            if (!Doubles.isFinite(d12) || !Doubles.isFinite(d11)) {
                d11 = StatsAccumulator.calculateNewMeanNonFinite(d11, d12);
            } else {
                d11 += (d12 - d11) / ((double) (i11 + 1));
            }
        }
        return d11;
    }
}
