package androidx.test.espresso.core.internal.deps.guava.cache;

public final class AbstractCache$SimpleStatsCounter implements AbstractCache$StatsCounter {

    /* renamed from: a  reason: collision with root package name */
    public final LongAddable f11171a = LongAddables.a();

    /* renamed from: b  reason: collision with root package name */
    public final LongAddable f11172b = LongAddables.a();

    /* renamed from: c  reason: collision with root package name */
    public final LongAddable f11173c = LongAddables.a();

    /* renamed from: d  reason: collision with root package name */
    public final LongAddable f11174d = LongAddables.a();

    /* renamed from: e  reason: collision with root package name */
    public final LongAddable f11175e = LongAddables.a();

    /* renamed from: f  reason: collision with root package name */
    public final LongAddable f11176f = LongAddables.a();

    public void recordEviction() {
        this.f11176f.increment();
    }

    public void recordHits(int i11) {
        this.f11171a.add((long) i11);
    }

    public void recordLoadException(long j11) {
        this.f11174d.increment();
        this.f11175e.add(j11);
    }

    public void recordLoadSuccess(long j11) {
        this.f11173c.increment();
        this.f11175e.add(j11);
    }

    public void recordMisses(int i11) {
        this.f11172b.add((long) i11);
    }
}
