package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;

@GwtCompatible
public final class CacheStats {
    private final long evictionCount;
    private final long hitCount;
    private final long loadExceptionCount;
    private final long loadSuccessCount;
    private final long missCount;
    private final long totalLoadTime;

    public CacheStats(long j11, long j12, long j13, long j14, long j15, long j16) {
        long j17 = j11;
        long j18 = j12;
        long j19 = j13;
        long j21 = j14;
        long j22 = j15;
        long j23 = j16;
        boolean z11 = true;
        Preconditions.checkArgument(j17 >= 0);
        Preconditions.checkArgument(j18 >= 0);
        Preconditions.checkArgument(j19 >= 0);
        Preconditions.checkArgument(j21 >= 0);
        Preconditions.checkArgument(j22 >= 0);
        Preconditions.checkArgument(j23 < 0 ? false : z11);
        this.hitCount = j17;
        this.missCount = j18;
        this.loadSuccessCount = j19;
        this.loadExceptionCount = j21;
        this.totalLoadTime = j22;
        this.evictionCount = j23;
    }

    public double averageLoadPenalty() {
        long saturatedAdd = LongMath.saturatedAdd(this.loadSuccessCount, this.loadExceptionCount);
        if (saturatedAdd == 0) {
            return 0.0d;
        }
        return ((double) this.totalLoadTime) / ((double) saturatedAdd);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CacheStats)) {
            return false;
        }
        CacheStats cacheStats = (CacheStats) obj;
        if (this.hitCount == cacheStats.hitCount && this.missCount == cacheStats.missCount && this.loadSuccessCount == cacheStats.loadSuccessCount && this.loadExceptionCount == cacheStats.loadExceptionCount && this.totalLoadTime == cacheStats.totalLoadTime && this.evictionCount == cacheStats.evictionCount) {
            return true;
        }
        return false;
    }

    public long evictionCount() {
        return this.evictionCount;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.hitCount), Long.valueOf(this.missCount), Long.valueOf(this.loadSuccessCount), Long.valueOf(this.loadExceptionCount), Long.valueOf(this.totalLoadTime), Long.valueOf(this.evictionCount));
    }

    public long hitCount() {
        return this.hitCount;
    }

    public double hitRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return 1.0d;
        }
        return ((double) this.hitCount) / ((double) requestCount);
    }

    public long loadCount() {
        return LongMath.saturatedAdd(this.loadSuccessCount, this.loadExceptionCount);
    }

    public long loadExceptionCount() {
        return this.loadExceptionCount;
    }

    public double loadExceptionRate() {
        long saturatedAdd = LongMath.saturatedAdd(this.loadSuccessCount, this.loadExceptionCount);
        if (saturatedAdd == 0) {
            return 0.0d;
        }
        return ((double) this.loadExceptionCount) / ((double) saturatedAdd);
    }

    public long loadSuccessCount() {
        return this.loadSuccessCount;
    }

    public CacheStats minus(CacheStats cacheStats) {
        CacheStats cacheStats2 = cacheStats;
        long max = Math.max(0, LongMath.saturatedSubtract(this.hitCount, cacheStats2.hitCount));
        long max2 = Math.max(0, LongMath.saturatedSubtract(this.missCount, cacheStats2.missCount));
        long max3 = Math.max(0, LongMath.saturatedSubtract(this.loadSuccessCount, cacheStats2.loadSuccessCount));
        return new CacheStats(max, max2, max3, Math.max(0, LongMath.saturatedSubtract(this.loadExceptionCount, cacheStats2.loadExceptionCount)), Math.max(0, LongMath.saturatedSubtract(this.totalLoadTime, cacheStats2.totalLoadTime)), Math.max(0, LongMath.saturatedSubtract(this.evictionCount, cacheStats2.evictionCount)));
    }

    public long missCount() {
        return this.missCount;
    }

    public double missRate() {
        long requestCount = requestCount();
        if (requestCount == 0) {
            return 0.0d;
        }
        return ((double) this.missCount) / ((double) requestCount);
    }

    public CacheStats plus(CacheStats cacheStats) {
        CacheStats cacheStats2 = cacheStats;
        return new CacheStats(LongMath.saturatedAdd(this.hitCount, cacheStats2.hitCount), LongMath.saturatedAdd(this.missCount, cacheStats2.missCount), LongMath.saturatedAdd(this.loadSuccessCount, cacheStats2.loadSuccessCount), LongMath.saturatedAdd(this.loadExceptionCount, cacheStats2.loadExceptionCount), LongMath.saturatedAdd(this.totalLoadTime, cacheStats2.totalLoadTime), LongMath.saturatedAdd(this.evictionCount, cacheStats2.evictionCount));
    }

    public long requestCount() {
        return LongMath.saturatedAdd(this.hitCount, this.missCount);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("hitCount", this.hitCount).add("missCount", this.missCount).add("loadSuccessCount", this.loadSuccessCount).add("loadExceptionCount", this.loadExceptionCount).add("totalLoadTime", this.totalLoadTime).add("evictionCount", this.evictionCount).toString();
    }

    public long totalLoadTime() {
        return this.totalLoadTime;
    }
}
