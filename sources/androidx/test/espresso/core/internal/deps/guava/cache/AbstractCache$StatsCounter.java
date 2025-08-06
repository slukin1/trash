package androidx.test.espresso.core.internal.deps.guava.cache;

public interface AbstractCache$StatsCounter {
    void recordEviction();

    void recordHits(int i11);

    void recordLoadException(long j11);

    void recordLoadSuccess(long j11);

    void recordMisses(int i11);
}
