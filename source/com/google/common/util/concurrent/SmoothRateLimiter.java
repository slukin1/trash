package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
abstract class SmoothRateLimiter extends RateLimiter {
    public double maxPermits;
    private long nextFreeTicketMicros;
    public double stableIntervalMicros;
    public double storedPermits;

    public static final class SmoothBursty extends SmoothRateLimiter {
        public final double maxBurstSeconds;

        public SmoothBursty(RateLimiter.SleepingStopwatch sleepingStopwatch, double d11) {
            super(sleepingStopwatch);
            this.maxBurstSeconds = d11;
        }

        public double coolDownIntervalMicros() {
            return this.stableIntervalMicros;
        }

        public void doSetRate(double d11, double d12) {
            double d13 = this.maxPermits;
            double d14 = this.maxBurstSeconds * d11;
            this.maxPermits = d14;
            if (d13 == Double.POSITIVE_INFINITY) {
                this.storedPermits = d14;
                return;
            }
            double d15 = 0.0d;
            if (d13 != 0.0d) {
                d15 = (this.storedPermits * d14) / d13;
            }
            this.storedPermits = d15;
        }

        public long storedPermitsToWaitTime(double d11, double d12) {
            return 0;
        }
    }

    public static final class SmoothWarmingUp extends SmoothRateLimiter {
        private double coldFactor;
        private double slope;
        private double thresholdPermits;
        private final long warmupPeriodMicros;

        public SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j11, TimeUnit timeUnit, double d11) {
            super(sleepingStopwatch);
            this.warmupPeriodMicros = timeUnit.toMicros(j11);
            this.coldFactor = d11;
        }

        private double permitsToTime(double d11) {
            return this.stableIntervalMicros + (d11 * this.slope);
        }

        public double coolDownIntervalMicros() {
            return ((double) this.warmupPeriodMicros) / this.maxPermits;
        }

        public void doSetRate(double d11, double d12) {
            double d13 = this.maxPermits;
            double d14 = this.coldFactor * d12;
            long j11 = this.warmupPeriodMicros;
            double d15 = (((double) j11) * 0.5d) / d12;
            this.thresholdPermits = d15;
            double d16 = ((((double) j11) * 2.0d) / (d12 + d14)) + d15;
            this.maxPermits = d16;
            this.slope = (d14 - d12) / (d16 - d15);
            if (d13 == Double.POSITIVE_INFINITY) {
                this.storedPermits = 0.0d;
                return;
            }
            if (d13 != 0.0d) {
                d16 = (this.storedPermits * d16) / d13;
            }
            this.storedPermits = d16;
        }

        public long storedPermitsToWaitTime(double d11, double d12) {
            long j11;
            double d13 = d11 - this.thresholdPermits;
            if (d13 > 0.0d) {
                double min = Math.min(d13, d12);
                j11 = (long) (((permitsToTime(d13) + permitsToTime(d13 - min)) * min) / 2.0d);
                d12 -= min;
            } else {
                j11 = 0;
            }
            return j11 + ((long) (this.stableIntervalMicros * d12));
        }
    }

    public abstract double coolDownIntervalMicros();

    public final double doGetRate() {
        return ((double) TimeUnit.SECONDS.toMicros(1)) / this.stableIntervalMicros;
    }

    public abstract void doSetRate(double d11, double d12);

    public final void doSetRate(double d11, long j11) {
        resync(j11);
        double micros = ((double) TimeUnit.SECONDS.toMicros(1)) / d11;
        this.stableIntervalMicros = micros;
        doSetRate(d11, micros);
    }

    public final long queryEarliestAvailable(long j11) {
        return this.nextFreeTicketMicros;
    }

    public final long reserveEarliestAvailable(int i11, long j11) {
        resync(j11);
        long j12 = this.nextFreeTicketMicros;
        double d11 = (double) i11;
        double min = Math.min(d11, this.storedPermits);
        this.nextFreeTicketMicros = LongMath.saturatedAdd(this.nextFreeTicketMicros, storedPermitsToWaitTime(this.storedPermits, min) + ((long) ((d11 - min) * this.stableIntervalMicros)));
        this.storedPermits -= min;
        return j12;
    }

    public void resync(long j11) {
        long j12 = this.nextFreeTicketMicros;
        if (j11 > j12) {
            this.storedPermits = Math.min(this.maxPermits, this.storedPermits + (((double) (j11 - j12)) / coolDownIntervalMicros()));
            this.nextFreeTicketMicros = j11;
        }
    }

    public abstract long storedPermitsToWaitTime(double d11, double d12);

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.nextFreeTicketMicros = 0;
    }
}
