package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.cache.LocalCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
public final class CacheBuilderSpec {
    private static final Splitter KEYS_SPLITTER = Splitter.on(',').trimResults();
    private static final Splitter KEY_VALUE_SPLITTER = Splitter.on('=').trimResults();
    private static final ImmutableMap<String, ValueParser> VALUE_PARSERS;
    @VisibleForTesting
    public long accessExpirationDuration;
    @VisibleForTesting
    public TimeUnit accessExpirationTimeUnit;
    @VisibleForTesting
    public Integer concurrencyLevel;
    @VisibleForTesting
    public Integer initialCapacity;
    @VisibleForTesting
    public LocalCache.Strength keyStrength;
    @VisibleForTesting
    public Long maximumSize;
    @VisibleForTesting
    public Long maximumWeight;
    @VisibleForTesting
    public Boolean recordStats;
    @VisibleForTesting
    public long refreshDuration;
    @VisibleForTesting
    public TimeUnit refreshTimeUnit;
    private final String specification;
    @VisibleForTesting
    public LocalCache.Strength valueStrength;
    @VisibleForTesting
    public long writeExpirationDuration;
    @VisibleForTesting
    public TimeUnit writeExpirationTimeUnit;

    /* renamed from: com.google.common.cache.CacheBuilderSpec$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$common$cache$LocalCache$Strength;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.common.cache.LocalCache$Strength[] r0 = com.google.common.cache.LocalCache.Strength.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$common$cache$LocalCache$Strength = r0
                com.google.common.cache.LocalCache$Strength r1 = com.google.common.cache.LocalCache.Strength.WEAK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$common$cache$LocalCache$Strength     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.cache.LocalCache$Strength r1 = com.google.common.cache.LocalCache.Strength.SOFT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.CacheBuilderSpec.AnonymousClass1.<clinit>():void");
        }
    }

    public static class AccessDurationParser extends DurationParser {
        public void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j11, TimeUnit timeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.accessExpirationTimeUnit == null, "expireAfterAccess already set");
            cacheBuilderSpec.accessExpirationDuration = j11;
            cacheBuilderSpec.accessExpirationTimeUnit = timeUnit;
        }
    }

    public static class ConcurrencyLevelParser extends IntegerParser {
        public void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i11) {
            Integer num = cacheBuilderSpec.concurrencyLevel;
            Preconditions.checkArgument(num == null, "concurrency level was already set to ", (Object) num);
            cacheBuilderSpec.concurrencyLevel = Integer.valueOf(i11);
        }
    }

    public static abstract class DurationParser implements ValueParser {
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            TimeUnit timeUnit;
            Preconditions.checkArgument(str2 != null && !str2.isEmpty(), "value of key %s omitted", (Object) str);
            try {
                char charAt = str2.charAt(str2.length() - 1);
                if (charAt == 'd') {
                    timeUnit = TimeUnit.DAYS;
                } else if (charAt == 'h') {
                    timeUnit = TimeUnit.HOURS;
                } else if (charAt == 'm') {
                    timeUnit = TimeUnit.MINUTES;
                } else if (charAt == 's') {
                    timeUnit = TimeUnit.SECONDS;
                } else {
                    throw new IllegalArgumentException(CacheBuilderSpec.format("key %s invalid format.  was %s, must end with one of [dDhHmMsS]", str, str2));
                }
                parseDuration(cacheBuilderSpec, Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", str, str2));
            }
        }

        public abstract void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j11, TimeUnit timeUnit);
    }

    public static class InitialCapacityParser extends IntegerParser {
        public void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i11) {
            Integer num = cacheBuilderSpec.initialCapacity;
            Preconditions.checkArgument(num == null, "initial capacity was already set to ", (Object) num);
            cacheBuilderSpec.initialCapacity = Integer.valueOf(i11);
        }
    }

    public static abstract class IntegerParser implements ValueParser {
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            Preconditions.checkArgument(str2 != null && !str2.isEmpty(), "value of key %s omitted", (Object) str);
            try {
                parseInteger(cacheBuilderSpec, Integer.parseInt(str2));
            } catch (NumberFormatException e11) {
                throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", str, str2), e11);
            }
        }

        public abstract void parseInteger(CacheBuilderSpec cacheBuilderSpec, int i11);
    }

    public static class KeyStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public KeyStrengthParser(LocalCache.Strength strength2) {
            this.strength = strength2;
        }

        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            boolean z11 = true;
            Preconditions.checkArgument(str2 == null, "key %s does not take values", (Object) str);
            LocalCache.Strength strength2 = cacheBuilderSpec.keyStrength;
            if (strength2 != null) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "%s was already set to %s", (Object) str, (Object) strength2);
            cacheBuilderSpec.keyStrength = this.strength;
        }
    }

    public static abstract class LongParser implements ValueParser {
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            Preconditions.checkArgument(str2 != null && !str2.isEmpty(), "value of key %s omitted", (Object) str);
            try {
                parseLong(cacheBuilderSpec, Long.parseLong(str2));
            } catch (NumberFormatException e11) {
                throw new IllegalArgumentException(CacheBuilderSpec.format("key %s value set to %s, must be integer", str, str2), e11);
            }
        }

        public abstract void parseLong(CacheBuilderSpec cacheBuilderSpec, long j11);
    }

    public static class MaximumSizeParser extends LongParser {
        public void parseLong(CacheBuilderSpec cacheBuilderSpec, long j11) {
            Long l11 = cacheBuilderSpec.maximumSize;
            boolean z11 = true;
            Preconditions.checkArgument(l11 == null, "maximum size was already set to ", (Object) l11);
            Long l12 = cacheBuilderSpec.maximumWeight;
            if (l12 != null) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "maximum weight was already set to ", (Object) l12);
            cacheBuilderSpec.maximumSize = Long.valueOf(j11);
        }
    }

    public static class MaximumWeightParser extends LongParser {
        public void parseLong(CacheBuilderSpec cacheBuilderSpec, long j11) {
            Long l11 = cacheBuilderSpec.maximumWeight;
            boolean z11 = true;
            Preconditions.checkArgument(l11 == null, "maximum weight was already set to ", (Object) l11);
            Long l12 = cacheBuilderSpec.maximumSize;
            if (l12 != null) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "maximum size was already set to ", (Object) l12);
            cacheBuilderSpec.maximumWeight = Long.valueOf(j11);
        }
    }

    public static class RecordStatsParser implements ValueParser {
        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            boolean z11 = true;
            Preconditions.checkArgument(str2 == null, "recordStats does not take values");
            if (cacheBuilderSpec.recordStats != null) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "recordStats already set");
            cacheBuilderSpec.recordStats = Boolean.TRUE;
        }
    }

    public static class RefreshDurationParser extends DurationParser {
        public void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j11, TimeUnit timeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.refreshTimeUnit == null, "refreshAfterWrite already set");
            cacheBuilderSpec.refreshDuration = j11;
            cacheBuilderSpec.refreshTimeUnit = timeUnit;
        }
    }

    public interface ValueParser {
        void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2);
    }

    public static class ValueStrengthParser implements ValueParser {
        private final LocalCache.Strength strength;

        public ValueStrengthParser(LocalCache.Strength strength2) {
            this.strength = strength2;
        }

        public void parse(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
            boolean z11 = true;
            Preconditions.checkArgument(str2 == null, "key %s does not take values", (Object) str);
            LocalCache.Strength strength2 = cacheBuilderSpec.valueStrength;
            if (strength2 != null) {
                z11 = false;
            }
            Preconditions.checkArgument(z11, "%s was already set to %s", (Object) str, (Object) strength2);
            cacheBuilderSpec.valueStrength = this.strength;
        }
    }

    public static class WriteDurationParser extends DurationParser {
        public void parseDuration(CacheBuilderSpec cacheBuilderSpec, long j11, TimeUnit timeUnit) {
            Preconditions.checkArgument(cacheBuilderSpec.writeExpirationTimeUnit == null, "expireAfterWrite already set");
            cacheBuilderSpec.writeExpirationDuration = j11;
            cacheBuilderSpec.writeExpirationTimeUnit = timeUnit;
        }
    }

    static {
        ImmutableMap.Builder put = ImmutableMap.builder().put("initialCapacity", new InitialCapacityParser()).put("maximumSize", new MaximumSizeParser()).put("maximumWeight", new MaximumWeightParser()).put("concurrencyLevel", new ConcurrencyLevelParser());
        LocalCache.Strength strength = LocalCache.Strength.WEAK;
        VALUE_PARSERS = put.put("weakKeys", new KeyStrengthParser(strength)).put("softValues", new ValueStrengthParser(LocalCache.Strength.SOFT)).put("weakValues", new ValueStrengthParser(strength)).put("recordStats", new RecordStatsParser()).put("expireAfterAccess", new AccessDurationParser()).put("expireAfterWrite", new WriteDurationParser()).put("refreshAfterWrite", new RefreshDurationParser()).put("refreshInterval", new RefreshDurationParser()).build();
    }

    private CacheBuilderSpec(String str) {
        this.specification = str;
    }

    public static CacheBuilderSpec disableCaching() {
        return parse("maximumSize=0");
    }

    private static Long durationInNanos(long j11, TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j11));
    }

    /* access modifiers changed from: private */
    public static String format(String str, Object... objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public static CacheBuilderSpec parse(String str) {
        CacheBuilderSpec cacheBuilderSpec = new CacheBuilderSpec(str);
        if (!str.isEmpty()) {
            for (String next : KEYS_SPLITTER.split(str)) {
                ImmutableList<E> copyOf = ImmutableList.copyOf(KEY_VALUE_SPLITTER.split(next));
                Preconditions.checkArgument(!copyOf.isEmpty(), "blank key-value pair");
                boolean z11 = false;
                Preconditions.checkArgument(copyOf.size() <= 2, "key-value pair %s with more than one equals sign", (Object) next);
                String str2 = (String) copyOf.get(0);
                ValueParser valueParser = VALUE_PARSERS.get(str2);
                if (valueParser != null) {
                    z11 = true;
                }
                Preconditions.checkArgument(z11, "unknown key %s", (Object) str2);
                valueParser.parse(cacheBuilderSpec, str2, copyOf.size() == 1 ? null : (String) copyOf.get(1));
            }
        }
        return cacheBuilderSpec;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        if (!Objects.equal(this.initialCapacity, cacheBuilderSpec.initialCapacity) || !Objects.equal(this.maximumSize, cacheBuilderSpec.maximumSize) || !Objects.equal(this.maximumWeight, cacheBuilderSpec.maximumWeight) || !Objects.equal(this.concurrencyLevel, cacheBuilderSpec.concurrencyLevel) || !Objects.equal(this.keyStrength, cacheBuilderSpec.keyStrength) || !Objects.equal(this.valueStrength, cacheBuilderSpec.valueStrength) || !Objects.equal(this.recordStats, cacheBuilderSpec.recordStats) || !Objects.equal(durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(cacheBuilderSpec.writeExpirationDuration, cacheBuilderSpec.writeExpirationTimeUnit)) || !Objects.equal(durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(cacheBuilderSpec.accessExpirationDuration, cacheBuilderSpec.accessExpirationTimeUnit)) || !Objects.equal(durationInNanos(this.refreshDuration, this.refreshTimeUnit), durationInNanos(cacheBuilderSpec.refreshDuration, cacheBuilderSpec.refreshTimeUnit))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.initialCapacity, this.maximumSize, this.maximumWeight, this.concurrencyLevel, this.keyStrength, this.valueStrength, this.recordStats, durationInNanos(this.writeExpirationDuration, this.writeExpirationTimeUnit), durationInNanos(this.accessExpirationDuration, this.accessExpirationTimeUnit), durationInNanos(this.refreshDuration, this.refreshTimeUnit));
    }

    public CacheBuilder<Object, Object> toCacheBuilder() {
        CacheBuilder<Object, Object> newBuilder = CacheBuilder.newBuilder();
        Integer num = this.initialCapacity;
        if (num != null) {
            newBuilder.initialCapacity(num.intValue());
        }
        Long l11 = this.maximumSize;
        if (l11 != null) {
            newBuilder.maximumSize(l11.longValue());
        }
        Long l12 = this.maximumWeight;
        if (l12 != null) {
            newBuilder.maximumWeight(l12.longValue());
        }
        Integer num2 = this.concurrencyLevel;
        if (num2 != null) {
            newBuilder.concurrencyLevel(num2.intValue());
        }
        LocalCache.Strength strength = this.keyStrength;
        if (strength != null) {
            if (AnonymousClass1.$SwitchMap$com$google$common$cache$LocalCache$Strength[strength.ordinal()] == 1) {
                newBuilder.weakKeys();
            } else {
                throw new AssertionError();
            }
        }
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            int i11 = AnonymousClass1.$SwitchMap$com$google$common$cache$LocalCache$Strength[strength2.ordinal()];
            if (i11 == 1) {
                newBuilder.weakValues();
            } else if (i11 == 2) {
                newBuilder.softValues();
            } else {
                throw new AssertionError();
            }
        }
        Boolean bool = this.recordStats;
        if (bool != null && bool.booleanValue()) {
            newBuilder.recordStats();
        }
        TimeUnit timeUnit = this.writeExpirationTimeUnit;
        if (timeUnit != null) {
            newBuilder.expireAfterWrite(this.writeExpirationDuration, timeUnit);
        }
        TimeUnit timeUnit2 = this.accessExpirationTimeUnit;
        if (timeUnit2 != null) {
            newBuilder.expireAfterAccess(this.accessExpirationDuration, timeUnit2);
        }
        TimeUnit timeUnit3 = this.refreshTimeUnit;
        if (timeUnit3 != null) {
            newBuilder.refreshAfterWrite(this.refreshDuration, timeUnit3);
        }
        return newBuilder;
    }

    public String toParsableString() {
        return this.specification;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).addValue((Object) toParsableString()).toString();
    }
}
