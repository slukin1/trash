package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.base.MoreObjects;
import androidx.test.espresso.core.internal.deps.guava.base.Objects;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;

public final class CacheStats {

    /* renamed from: a  reason: collision with root package name */
    public final long f11198a;

    /* renamed from: b  reason: collision with root package name */
    public final long f11199b;

    /* renamed from: c  reason: collision with root package name */
    public final long f11200c;

    /* renamed from: d  reason: collision with root package name */
    public final long f11201d;

    /* renamed from: e  reason: collision with root package name */
    public final long f11202e;

    /* renamed from: f  reason: collision with root package name */
    public final long f11203f;

    public CacheStats(long j11, long j12, long j13, long j14, long j15, long j16) {
        long j17 = j11;
        long j18 = j12;
        long j19 = j13;
        long j21 = j14;
        long j22 = j15;
        long j23 = j16;
        boolean z11 = true;
        Preconditions.d(j17 >= 0);
        Preconditions.d(j18 >= 0);
        Preconditions.d(j19 >= 0);
        Preconditions.d(j21 >= 0);
        Preconditions.d(j22 >= 0);
        Preconditions.d(j23 < 0 ? false : z11);
        this.f11198a = j17;
        this.f11199b = j18;
        this.f11200c = j19;
        this.f11201d = j21;
        this.f11202e = j22;
        this.f11203f = j23;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CacheStats)) {
            return false;
        }
        CacheStats cacheStats = (CacheStats) obj;
        if (this.f11198a == cacheStats.f11198a && this.f11199b == cacheStats.f11199b && this.f11200c == cacheStats.f11200c && this.f11201d == cacheStats.f11201d && this.f11202e == cacheStats.f11202e && this.f11203f == cacheStats.f11203f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.b(Long.valueOf(this.f11198a), Long.valueOf(this.f11199b), Long.valueOf(this.f11200c), Long.valueOf(this.f11201d), Long.valueOf(this.f11202e), Long.valueOf(this.f11203f));
    }

    public String toString() {
        return MoreObjects.b(this).c("hitCount", this.f11198a).c("missCount", this.f11199b).c("loadSuccessCount", this.f11200c).c("loadExceptionCount", this.f11201d).c("totalLoadTime", this.f11202e).c("evictionCount", this.f11203f).toString();
    }
}
