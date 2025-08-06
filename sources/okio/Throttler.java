package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private final Condition condition;
    private final ReentrantLock lock;
    private long maxByteCount;
    private long waitByteCount;

    public Throttler(long j11) {
        this.allocatedUntil = j11;
        this.waitByteCount = 8192;
        this.maxByteCount = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long j11, long j12, long j13, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j12 = throttler.waitByteCount;
        }
        long j14 = j12;
        if ((i11 & 4) != 0) {
            j13 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(j11, j14, j13);
    }

    private final long bytesToNanos(long j11) {
        return (j11 * 1000000000) / this.bytesPerSecond;
    }

    private final long nanosToBytes(long j11) {
        return (j11 * this.bytesPerSecond) / 1000000000;
    }

    public final long byteCountOrWaitNanos$okio(long j11, long j12) {
        if (this.bytesPerSecond == 0) {
            return j12;
        }
        long max = Math.max(this.allocatedUntil - j11, 0);
        long nanosToBytes = this.maxByteCount - nanosToBytes(max);
        if (nanosToBytes >= j12) {
            this.allocatedUntil = j11 + max + bytesToNanos(j12);
            return j12;
        }
        long j13 = this.waitByteCount;
        if (nanosToBytes >= j13) {
            this.allocatedUntil = j11 + bytesToNanos(this.maxByteCount);
            return nanosToBytes;
        }
        long min = Math.min(j13, j12);
        long bytesToNanos = max + bytesToNanos(min - this.maxByteCount);
        if (bytesToNanos != 0) {
            return -bytesToNanos;
        }
        this.allocatedUntil = j11 + bytesToNanos(this.maxByteCount);
        return min;
    }

    public final void bytesPerSecond(long j11) {
        bytesPerSecond$default(this, j11, 0, 0, 6, (Object) null);
    }

    public final void bytesPerSecond(long j11, long j12) {
        bytesPerSecond$default(this, j11, j12, 0, 4, (Object) null);
    }

    public final void bytesPerSecond(long j11, long j12, long j13) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        boolean z11 = true;
        if (j11 >= 0) {
            if (j12 > 0) {
                if (j13 < j12) {
                    z11 = false;
                }
                if (z11) {
                    try {
                        this.bytesPerSecond = j11;
                        this.waitByteCount = j12;
                        this.maxByteCount = j13;
                        this.condition.signalAll();
                        Unit unit = Unit.f56620a;
                    } finally {
                        reentrantLock.unlock();
                    }
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final Sink sink(Sink sink) {
        return new Throttler$sink$1(sink, this);
    }

    public final Source source(Source source) {
        return new Throttler$source$1(source, this);
    }

    public final long take$okio(long j11) {
        if (j11 > 0) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            while (true) {
                try {
                    long byteCountOrWaitNanos$okio = byteCountOrWaitNanos$okio(System.nanoTime(), j11);
                    if (byteCountOrWaitNanos$okio >= 0) {
                        return byteCountOrWaitNanos$okio;
                    }
                    this.condition.awaitNanos(-byteCountOrWaitNanos$okio);
                } finally {
                    reentrantLock.unlock();
                }
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
