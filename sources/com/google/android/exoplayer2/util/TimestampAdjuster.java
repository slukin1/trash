package com.google.android.exoplayer2.util;

public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    private long firstSampleTimestampUs;
    private long lastSampleTimestampUs = -9223372036854775807L;
    private boolean sharedInitializationStarted;
    private long timestampOffsetUs;

    public TimestampAdjuster(long j11) {
        this.firstSampleTimestampUs = j11;
    }

    public static long ptsToUs(long j11) {
        return (j11 * 1000000) / 90000;
    }

    public static long usToNonWrappedPts(long j11) {
        return (j11 * 90000) / 1000000;
    }

    public static long usToWrappedPts(long j11) {
        return usToNonWrappedPts(j11) % MAX_PTS_PLUS_ONE;
    }

    public synchronized long adjustSampleTimestamp(long j11) {
        if (j11 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.lastSampleTimestampUs != -9223372036854775807L) {
            this.lastSampleTimestampUs = j11;
        } else {
            long j12 = this.firstSampleTimestampUs;
            if (j12 != Long.MAX_VALUE) {
                this.timestampOffsetUs = j12 - j11;
            }
            this.lastSampleTimestampUs = j11;
            notifyAll();
        }
        return j11 + this.timestampOffsetUs;
    }

    public synchronized long adjustTsTimestamp(long j11) {
        if (j11 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j12 = this.lastSampleTimestampUs;
        if (j12 != -9223372036854775807L) {
            long usToNonWrappedPts = usToNonWrappedPts(j12);
            long j13 = (4294967296L + usToNonWrappedPts) / MAX_PTS_PLUS_ONE;
            long j14 = ((j13 - 1) * MAX_PTS_PLUS_ONE) + j11;
            j11 += j13 * MAX_PTS_PLUS_ONE;
            if (Math.abs(j14 - usToNonWrappedPts) < Math.abs(j11 - usToNonWrappedPts)) {
                j11 = j14;
            }
        }
        return adjustSampleTimestamp(ptsToUs(j11));
    }

    public synchronized long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public synchronized long getLastAdjustedTimestampUs() {
        long j11;
        long j12 = this.lastSampleTimestampUs;
        j11 = -9223372036854775807L;
        if (j12 != -9223372036854775807L) {
            j11 = this.timestampOffsetUs + j12;
        } else {
            long j13 = this.firstSampleTimestampUs;
            if (j13 != Long.MAX_VALUE) {
                j11 = j13;
            }
        }
        return j11;
    }

    public synchronized long getTimestampOffsetUs() {
        long j11;
        j11 = -9223372036854775807L;
        if (this.firstSampleTimestampUs == Long.MAX_VALUE) {
            j11 = 0;
        } else if (this.lastSampleTimestampUs != -9223372036854775807L) {
            j11 = this.timestampOffsetUs;
        }
        return j11;
    }

    public synchronized void reset(long j11) {
        this.firstSampleTimestampUs = j11;
        this.lastSampleTimestampUs = -9223372036854775807L;
        this.sharedInitializationStarted = false;
    }

    public synchronized void sharedInitializeOrWait(boolean z11, long j11) throws InterruptedException {
        if (z11) {
            try {
                if (!this.sharedInitializationStarted) {
                    this.firstSampleTimestampUs = j11;
                    this.sharedInitializationStarted = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (!z11 || j11 != this.firstSampleTimestampUs) {
            while (this.lastSampleTimestampUs == -9223372036854775807L) {
                wait();
            }
        }
    }
}
