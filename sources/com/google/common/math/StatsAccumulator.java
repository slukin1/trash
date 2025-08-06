package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@GwtIncompatible
@Beta
public final class StatsAccumulator {
    private long count = 0;
    private double max = Double.NaN;
    private double mean = 0.0d;
    private double min = Double.NaN;
    private double sumOfSquaresOfDeltas = 0.0d;

    public static double calculateNewMeanNonFinite(double d11, double d12) {
        if (Doubles.isFinite(d11)) {
            return d12;
        }
        if (Doubles.isFinite(d12) || d11 == d12) {
            return d11;
        }
        return Double.NaN;
    }

    public void add(double d11) {
        long j11 = this.count;
        if (j11 == 0) {
            this.count = 1;
            this.mean = d11;
            this.min = d11;
            this.max = d11;
            if (!Doubles.isFinite(d11)) {
                this.sumOfSquaresOfDeltas = Double.NaN;
                return;
            }
            return;
        }
        this.count = j11 + 1;
        if (!Doubles.isFinite(d11) || !Doubles.isFinite(this.mean)) {
            this.mean = calculateNewMeanNonFinite(this.mean, d11);
            this.sumOfSquaresOfDeltas = Double.NaN;
        } else {
            double d12 = this.mean;
            double d13 = d11 - d12;
            double d14 = d12 + (d13 / ((double) this.count));
            this.mean = d14;
            this.sumOfSquaresOfDeltas += d13 * (d11 - d14);
        }
        this.min = Math.min(this.min, d11);
        this.max = Math.max(this.max, d11);
    }

    public void addAll(Iterable<? extends Number> iterable) {
        for (Number doubleValue : iterable) {
            add(doubleValue.doubleValue());
        }
    }

    public long count() {
        return this.count;
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

    public final double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public final double populationVariance() {
        Preconditions.checkState(this.count != 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / ((double) this.count);
    }

    public final double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public final double sampleVariance() {
        Preconditions.checkState(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / ((double) (this.count - 1));
    }

    public Stats snapshot() {
        return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
    }

    public final double sum() {
        return this.mean * ((double) this.count);
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public void addAll(Iterator<? extends Number> it2) {
        while (it2.hasNext()) {
            add(((Number) it2.next()).doubleValue());
        }
    }

    public void addAll(double... dArr) {
        for (double add : dArr) {
            add(add);
        }
    }

    public void addAll(int... iArr) {
        for (int i11 : iArr) {
            add((double) i11);
        }
    }

    public void addAll(long... jArr) {
        for (long j11 : jArr) {
            add((double) j11);
        }
    }

    public void addAll(Stats stats) {
        if (stats.count() != 0) {
            long j11 = this.count;
            if (j11 == 0) {
                this.count = stats.count();
                this.mean = stats.mean();
                this.sumOfSquaresOfDeltas = stats.sumOfSquaresOfDeltas();
                this.min = stats.min();
                this.max = stats.max();
                return;
            }
            this.count = j11 + stats.count();
            if (!Doubles.isFinite(this.mean) || !Doubles.isFinite(stats.mean())) {
                this.mean = calculateNewMeanNonFinite(this.mean, stats.mean());
                this.sumOfSquaresOfDeltas = Double.NaN;
            } else {
                double mean2 = stats.mean();
                double d11 = this.mean;
                double d12 = mean2 - d11;
                this.mean = d11 + ((((double) stats.count()) * d12) / ((double) this.count));
                this.sumOfSquaresOfDeltas += stats.sumOfSquaresOfDeltas() + (d12 * (stats.mean() - this.mean) * ((double) stats.count()));
            }
            this.min = Math.min(this.min, stats.min());
            this.max = Math.max(this.max, stats.max());
        }
    }
}
