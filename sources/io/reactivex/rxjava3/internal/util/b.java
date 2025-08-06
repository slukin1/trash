package io.reactivex.rxjava3.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import o00.a;

public final class b {
    public static long a(AtomicLong atomicLong, long j11) {
        long j12;
        do {
            j12 = atomicLong.get();
            if (j12 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j12, c(j12, j11)));
        return j12;
    }

    public static long b(AtomicLong atomicLong, long j11) {
        long j12;
        do {
            j12 = atomicLong.get();
            if (j12 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j12 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j12, c(j12, j11)));
        return j12;
    }

    public static long c(long j11, long j12) {
        long j13 = j11 + j12;
        if (j13 < 0) {
            return Long.MAX_VALUE;
        }
        return j13;
    }

    public static long d(long j11, long j12) {
        long j13 = j11 * j12;
        if (((j11 | j12) >>> 31) == 0 || j13 / j11 == j12) {
            return j13;
        }
        return Long.MAX_VALUE;
    }

    public static long e(AtomicLong atomicLong, long j11) {
        long j12;
        long j13;
        do {
            j12 = atomicLong.get();
            if (j12 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j13 = j12 - j11;
            if (j13 < 0) {
                a.n(new IllegalStateException("More produced than requested: " + j13));
                j13 = 0;
            }
        } while (!atomicLong.compareAndSet(j12, j13));
        return j13;
    }

    public static long f(AtomicLong atomicLong, long j11) {
        long j12;
        long j13;
        do {
            j12 = atomicLong.get();
            if (j12 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j12 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j13 = j12 - j11;
            if (j13 < 0) {
                a.n(new IllegalStateException("More produced than requested: " + j13));
                j13 = 0;
            }
        } while (!atomicLong.compareAndSet(j12, j13));
        return j13;
    }
}
