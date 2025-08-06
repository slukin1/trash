package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated = true)
public final class CacheBuilder<K, V> {
    public static final Supplier<AbstractCache.StatsCounter> CACHE_STATS_COUNTER = new Supplier<AbstractCache.StatsCounter>() {
        public AbstractCache.StatsCounter get() {
            return new AbstractCache.SimpleStatsCounter();
        }
    };
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    public static final CacheStats EMPTY_STATS = new CacheStats(0, 0, 0, 0, 0, 0);
    public static final Supplier<? extends AbstractCache.StatsCounter> NULL_STATS_COUNTER = Suppliers.ofInstance(new AbstractCache.StatsCounter() {
        public void recordEviction() {
        }

        public void recordHits(int i11) {
        }

        public void recordLoadException(long j11) {
        }

        public void recordLoadSuccess(long j11) {
        }

        public void recordMisses(int i11) {
        }

        public CacheStats snapshot() {
            return CacheBuilder.EMPTY_STATS;
        }
    });
    public static final Ticker NULL_TICKER = new Ticker() {
        public long read() {
            return 0;
        }
    };
    public static final int UNSET_INT = -1;
    private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
    public int concurrencyLevel = -1;
    public long expireAfterAccessNanos = -1;
    public long expireAfterWriteNanos = -1;
    public int initialCapacity = -1;
    public Equivalence<Object> keyEquivalence;
    public LocalCache.Strength keyStrength;
    public long maximumSize = -1;
    public long maximumWeight = -1;
    public long refreshNanos = -1;
    public RemovalListener<? super K, ? super V> removalListener;
    public Supplier<? extends AbstractCache.StatsCounter> statsCounterSupplier = NULL_STATS_COUNTER;
    public boolean strictParsing = true;
    public Ticker ticker;
    public Equivalence<Object> valueEquivalence;
    public LocalCache.Strength valueStrength;
    public Weigher<? super K, ? super V> weigher;

    public enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    public enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    private void checkNonLoadingCache() {
        Preconditions.checkState(this.refreshNanos == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher() {
        boolean z11 = true;
        if (this.weigher == null) {
            if (this.maximumWeight != -1) {
                z11 = false;
            }
            Preconditions.checkState(z11, "maximumWeight requires weigher");
        } else if (this.strictParsing) {
            if (this.maximumWeight == -1) {
                z11 = false;
            }
            Preconditions.checkState(z11, "weigher requires maximumWeight");
        } else if (this.maximumWeight == -1) {
            logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.toCacheBuilder().lenientParsing();
    }

    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder<>();
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        checkWeightWithWeigher();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public CacheBuilder<K, V> concurrencyLevel(int i11) {
        int i12 = this.concurrencyLevel;
        boolean z11 = true;
        Preconditions.checkState(i12 == -1, "concurrency level was already set to %s", i12);
        if (i11 <= 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        this.concurrencyLevel = i11;
        return this;
    }

    public CacheBuilder<K, V> expireAfterAccess(long j11, TimeUnit timeUnit) {
        long j12 = this.expireAfterAccessNanos;
        boolean z11 = true;
        Preconditions.checkState(j12 == -1, "expireAfterAccess was already set to %s ns", j12);
        if (j11 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "duration cannot be negative: %s %s", j11, (Object) timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(j11);
        return this;
    }

    public CacheBuilder<K, V> expireAfterWrite(long j11, TimeUnit timeUnit) {
        long j12 = this.expireAfterWriteNanos;
        boolean z11 = true;
        Preconditions.checkState(j12 == -1, "expireAfterWrite was already set to %s ns", j12);
        if (j11 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "duration cannot be negative: %s %s", j11, (Object) timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(j11);
        return this;
    }

    public int getConcurrencyLevel() {
        int i11 = this.concurrencyLevel;
        if (i11 == -1) {
            return 4;
        }
        return i11;
    }

    public long getExpireAfterAccessNanos() {
        long j11 = this.expireAfterAccessNanos;
        if (j11 == -1) {
            return 0;
        }
        return j11;
    }

    public long getExpireAfterWriteNanos() {
        long j11 = this.expireAfterWriteNanos;
        if (j11 == -1) {
            return 0;
        }
        return j11;
    }

    public int getInitialCapacity() {
        int i11 = this.initialCapacity;
        if (i11 == -1) {
            return 16;
        }
        return i11;
    }

    public Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    public LocalCache.Strength getKeyStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.keyStrength, LocalCache.Strength.STRONG);
    }

    public long getMaximumWeight() {
        if (this.expireAfterWriteNanos == 0 || this.expireAfterAccessNanos == 0) {
            return 0;
        }
        return this.weigher == null ? this.maximumSize : this.maximumWeight;
    }

    public long getRefreshNanos() {
        long j11 = this.refreshNanos;
        if (j11 == -1) {
            return 0;
        }
        return j11;
    }

    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener() {
        return (RemovalListener) MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
    }

    public Supplier<? extends AbstractCache.StatsCounter> getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    public Ticker getTicker(boolean z11) {
        Ticker ticker2 = this.ticker;
        if (ticker2 != null) {
            return ticker2;
        }
        return z11 ? Ticker.systemTicker() : NULL_TICKER;
    }

    public Equivalence<Object> getValueEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
    }

    public LocalCache.Strength getValueStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.valueStrength, LocalCache.Strength.STRONG);
    }

    public <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher() {
        return (Weigher) MoreObjects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> initialCapacity(int i11) {
        int i12 = this.initialCapacity;
        boolean z11 = true;
        Preconditions.checkState(i12 == -1, "initial capacity was already set to %s", i12);
        if (i11 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        this.initialCapacity = i11;
        return this;
    }

    public boolean isRecordingStats() {
        return this.statsCounterSupplier == CACHE_STATS_COUNTER;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> keyEquivalence(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.keyEquivalence;
        Preconditions.checkState(equivalence2 == null, "key equivalence was already set to %s", (Object) equivalence2);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    public CacheBuilder<K, V> maximumSize(long j11) {
        long j12 = this.maximumSize;
        boolean z11 = true;
        Preconditions.checkState(j12 == -1, "maximum size was already set to %s", j12);
        long j13 = this.maximumWeight;
        Preconditions.checkState(j13 == -1, "maximum weight was already set to %s", j13);
        Preconditions.checkState(this.weigher == null, "maximum size can not be combined with weigher");
        if (j11 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "maximum size must not be negative");
        this.maximumSize = j11;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> maximumWeight(long j11) {
        long j12 = this.maximumWeight;
        boolean z11 = true;
        Preconditions.checkState(j12 == -1, "maximum weight was already set to %s", j12);
        long j13 = this.maximumSize;
        Preconditions.checkState(j13 == -1, "maximum size was already set to %s", j13);
        this.maximumWeight = j11;
        if (j11 < 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "maximum weight must not be negative");
        return this;
    }

    public CacheBuilder<K, V> recordStats() {
        this.statsCounterSupplier = CACHE_STATS_COUNTER;
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> refreshAfterWrite(long j11, TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        long j12 = this.refreshNanos;
        boolean z11 = true;
        Preconditions.checkState(j12 == -1, "refresh was already set to %s ns", j12);
        if (j11 <= 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "duration must be positive: %s %s", j11, (Object) timeUnit);
        this.refreshNanos = timeUnit.toNanos(j11);
        return this;
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener2) {
        Preconditions.checkState(this.removalListener == null);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(removalListener2);
        return this;
    }

    public CacheBuilder<K, V> setKeyStrength(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.keyStrength;
        Preconditions.checkState(strength2 == null, "Key strength was already set to %s", (Object) strength2);
        this.keyStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    public CacheBuilder<K, V> setValueStrength(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.valueStrength;
        Preconditions.checkState(strength2 == null, "Value strength was already set to %s", (Object) strength2);
        this.valueStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> softValues() {
        return setValueStrength(LocalCache.Strength.SOFT);
    }

    public CacheBuilder<K, V> ticker(Ticker ticker2) {
        Preconditions.checkState(this.ticker == null);
        this.ticker = (Ticker) Preconditions.checkNotNull(ticker2);
        return this;
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper((Object) this);
        int i11 = this.initialCapacity;
        if (i11 != -1) {
            stringHelper.add("initialCapacity", i11);
        }
        int i12 = this.concurrencyLevel;
        if (i12 != -1) {
            stringHelper.add("concurrencyLevel", i12);
        }
        long j11 = this.maximumSize;
        if (j11 != -1) {
            stringHelper.add("maximumSize", j11);
        }
        long j12 = this.maximumWeight;
        if (j12 != -1) {
            stringHelper.add("maximumWeight", j12);
        }
        if (this.expireAfterWriteNanos != -1) {
            stringHelper.add("expireAfterWrite", (Object) this.expireAfterWriteNanos + "ns");
        }
        if (this.expireAfterAccessNanos != -1) {
            stringHelper.add("expireAfterAccess", (Object) this.expireAfterAccessNanos + "ns");
        }
        LocalCache.Strength strength = this.keyStrength;
        if (strength != null) {
            stringHelper.add("keyStrength", (Object) Ascii.toLowerCase(strength.toString()));
        }
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            stringHelper.add("valueStrength", (Object) Ascii.toLowerCase(strength2.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue((Object) "keyEquivalence");
        }
        if (this.valueEquivalence != null) {
            stringHelper.addValue((Object) "valueEquivalence");
        }
        if (this.removalListener != null) {
            stringHelper.addValue((Object) "removalListener");
        }
        return stringHelper.toString();
    }

    @GwtIncompatible
    public CacheBuilder<K, V> valueEquivalence(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.valueEquivalence;
        Preconditions.checkState(equivalence2 == null, "value equivalence was already set to %s", (Object) equivalence2);
        this.valueEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakKeys() {
        return setKeyStrength(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    public CacheBuilder<K, V> weakValues() {
        return setValueStrength(LocalCache.Strength.WEAK);
    }

    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher2) {
        boolean z11 = true;
        Preconditions.checkState(this.weigher == null);
        if (this.strictParsing) {
            long j11 = this.maximumSize;
            if (j11 != -1) {
                z11 = false;
            }
            Preconditions.checkState(z11, "weigher can not be combined with maximum size", j11);
        }
        this.weigher = (Weigher) Preconditions.checkNotNull(weigher2);
        return this;
    }

    @GwtIncompatible
    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalCache.LocalManualCache(this);
    }
}
