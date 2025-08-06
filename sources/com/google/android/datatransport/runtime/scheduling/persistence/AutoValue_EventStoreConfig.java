package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreConfig;

final class AutoValue_EventStoreConfig extends EventStoreConfig {
    private final int criticalSectionEnterTimeoutMs;
    private final long eventCleanUpAge;
    private final int loadBatchSize;
    private final int maxBlobByteSizePerRow;
    private final long maxStorageSizeInBytes;

    public static final class Builder extends EventStoreConfig.Builder {
        private Integer criticalSectionEnterTimeoutMs;
        private Long eventCleanUpAge;
        private Integer loadBatchSize;
        private Integer maxBlobByteSizePerRow;
        private Long maxStorageSizeInBytes;

        public EventStoreConfig build() {
            String str = "";
            if (this.maxStorageSizeInBytes == null) {
                str = str + " maxStorageSizeInBytes";
            }
            if (this.loadBatchSize == null) {
                str = str + " loadBatchSize";
            }
            if (this.criticalSectionEnterTimeoutMs == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.eventCleanUpAge == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.maxBlobByteSizePerRow == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new AutoValue_EventStoreConfig(this.maxStorageSizeInBytes.longValue(), this.loadBatchSize.intValue(), this.criticalSectionEnterTimeoutMs.intValue(), this.eventCleanUpAge.longValue(), this.maxBlobByteSizePerRow.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public EventStoreConfig.Builder setCriticalSectionEnterTimeoutMs(int i11) {
            this.criticalSectionEnterTimeoutMs = Integer.valueOf(i11);
            return this;
        }

        public EventStoreConfig.Builder setEventCleanUpAge(long j11) {
            this.eventCleanUpAge = Long.valueOf(j11);
            return this;
        }

        public EventStoreConfig.Builder setLoadBatchSize(int i11) {
            this.loadBatchSize = Integer.valueOf(i11);
            return this;
        }

        public EventStoreConfig.Builder setMaxBlobByteSizePerRow(int i11) {
            this.maxBlobByteSizePerRow = Integer.valueOf(i11);
            return this;
        }

        public EventStoreConfig.Builder setMaxStorageSizeInBytes(long j11) {
            this.maxStorageSizeInBytes = Long.valueOf(j11);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventStoreConfig)) {
            return false;
        }
        EventStoreConfig eventStoreConfig = (EventStoreConfig) obj;
        if (this.maxStorageSizeInBytes == eventStoreConfig.getMaxStorageSizeInBytes() && this.loadBatchSize == eventStoreConfig.getLoadBatchSize() && this.criticalSectionEnterTimeoutMs == eventStoreConfig.getCriticalSectionEnterTimeoutMs() && this.eventCleanUpAge == eventStoreConfig.getEventCleanUpAge() && this.maxBlobByteSizePerRow == eventStoreConfig.getMaxBlobByteSizePerRow()) {
            return true;
        }
        return false;
    }

    public int getCriticalSectionEnterTimeoutMs() {
        return this.criticalSectionEnterTimeoutMs;
    }

    public long getEventCleanUpAge() {
        return this.eventCleanUpAge;
    }

    public int getLoadBatchSize() {
        return this.loadBatchSize;
    }

    public int getMaxBlobByteSizePerRow() {
        return this.maxBlobByteSizePerRow;
    }

    public long getMaxStorageSizeInBytes() {
        return this.maxStorageSizeInBytes;
    }

    public int hashCode() {
        long j11 = this.maxStorageSizeInBytes;
        long j12 = this.eventCleanUpAge;
        return ((((((((((int) (j11 ^ (j11 >>> 32))) ^ 1000003) * 1000003) ^ this.loadBatchSize) * 1000003) ^ this.criticalSectionEnterTimeoutMs) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003) ^ this.maxBlobByteSizePerRow;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.maxStorageSizeInBytes + ", loadBatchSize=" + this.loadBatchSize + ", criticalSectionEnterTimeoutMs=" + this.criticalSectionEnterTimeoutMs + ", eventCleanUpAge=" + this.eventCleanUpAge + ", maxBlobByteSizePerRow=" + this.maxBlobByteSizePerRow + "}";
    }

    private AutoValue_EventStoreConfig(long j11, int i11, int i12, long j12, int i13) {
        this.maxStorageSizeInBytes = j11;
        this.loadBatchSize = i11;
        this.criticalSectionEnterTimeoutMs = i12;
        this.eventCleanUpAge = j12;
        this.maxBlobByteSizePerRow = i13;
    }
}
