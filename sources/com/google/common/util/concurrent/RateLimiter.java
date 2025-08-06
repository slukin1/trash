package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
@Beta
public abstract class RateLimiter {
    private volatile Object mutexDoNotUseDirectly;
    private final SleepingStopwatch stopwatch;

    public static abstract class SleepingStopwatch {
        public static SleepingStopwatch createFromSystemTimer() {
            return new SleepingStopwatch() {
                public final Stopwatch stopwatch = Stopwatch.createStarted();

                public long readMicros() {
                    return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
                }

                public void sleepMicrosUninterruptibly(long j11) {
                    if (j11 > 0) {
                        Uninterruptibles.sleepUninterruptibly(j11, TimeUnit.MICROSECONDS);
                    }
                }
            };
        }

        public abstract long readMicros();

        public abstract void sleepMicrosUninterruptibly(long j11);
    }

    public RateLimiter(SleepingStopwatch sleepingStopwatch) {
        this.stopwatch = (SleepingStopwatch) Preconditions.checkNotNull(sleepingStopwatch);
    }

    private boolean canAcquire(long j11, long j12) {
        return queryEarliestAvailable(j11) - j12 <= j11;
    }

    private static void checkPermits(int i11) {
        Preconditions.checkArgument(i11 > 0, "Requested permits (%s) must be positive", i11);
    }

    public static RateLimiter create(double d11) {
        return create(d11, SleepingStopwatch.createFromSystemTimer());
    }

    private Object mutex() {
        Object obj = this.mutexDoNotUseDirectly;
        if (obj == null) {
            synchronized (this) {
                obj = this.mutexDoNotUseDirectly;
                if (obj == null) {
                    obj = new Object();
                    this.mutexDoNotUseDirectly = obj;
                }
            }
        }
        return obj;
    }

    @CanIgnoreReturnValue
    public double acquire() {
        return acquire(1);
    }

    public abstract double doGetRate();

    public abstract void doSetRate(double d11, long j11);

    public final double getRate() {
        double doGetRate;
        synchronized (mutex()) {
            doGetRate = doGetRate();
        }
        return doGetRate;
    }

    public abstract long queryEarliestAvailable(long j11);

    public final long reserve(int i11) {
        long reserveAndGetWaitLength;
        checkPermits(i11);
        synchronized (mutex()) {
            reserveAndGetWaitLength = reserveAndGetWaitLength(i11, this.stopwatch.readMicros());
        }
        return reserveAndGetWaitLength;
    }

    public final long reserveAndGetWaitLength(int i11, long j11) {
        return Math.max(reserveEarliestAvailable(i11, j11) - j11, 0);
    }

    public abstract long reserveEarliestAvailable(int i11, long j11);

    public final void setRate(double d11) {
        Preconditions.checkArgument(d11 > 0.0d && !Double.isNaN(d11), "rate must be positive");
        synchronized (mutex()) {
            doSetRate(d11, this.stopwatch.readMicros());
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[]{Double.valueOf(getRate())});
    }

    public boolean tryAcquire(long j11, TimeUnit timeUnit) {
        return tryAcquire(1, j11, timeUnit);
    }

    @VisibleForTesting
    public static RateLimiter create(double d11, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothBursty smoothBursty = new SmoothRateLimiter.SmoothBursty(sleepingStopwatch, 1.0d);
        smoothBursty.setRate(d11);
        return smoothBursty;
    }

    @CanIgnoreReturnValue
    public double acquire(int i11) {
        long reserve = reserve(i11);
        this.stopwatch.sleepMicrosUninterruptibly(reserve);
        return (((double) reserve) * 1.0d) / ((double) TimeUnit.SECONDS.toMicros(1));
    }

    public boolean tryAcquire(int i11) {
        return tryAcquire(i11, 0, TimeUnit.MICROSECONDS);
    }

    public boolean tryAcquire() {
        return tryAcquire(1, 0, TimeUnit.MICROSECONDS);
    }

    public static RateLimiter create(double d11, long j11, TimeUnit timeUnit) {
        Preconditions.checkArgument(j11 >= 0, "warmupPeriod must not be negative: %s", j11);
        return create(d11, j11, timeUnit, 3.0d, SleepingStopwatch.createFromSystemTimer());
    }

    public boolean tryAcquire(int i11, long j11, TimeUnit timeUnit) {
        long max = Math.max(timeUnit.toMicros(j11), 0);
        checkPermits(i11);
        synchronized (mutex()) {
            long readMicros = this.stopwatch.readMicros();
            if (!canAcquire(readMicros, max)) {
                return false;
            }
            long reserveAndGetWaitLength = reserveAndGetWaitLength(i11, readMicros);
            this.stopwatch.sleepMicrosUninterruptibly(reserveAndGetWaitLength);
            return true;
        }
    }

    @VisibleForTesting
    public static RateLimiter create(double d11, long j11, TimeUnit timeUnit, double d12, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new SmoothRateLimiter.SmoothWarmingUp(sleepingStopwatch, j11, timeUnit, d12);
        smoothWarmingUp.setRate(d11);
        return smoothWarmingUp;
    }
}
