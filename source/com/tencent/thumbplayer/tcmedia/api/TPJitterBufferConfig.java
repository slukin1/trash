package com.tencent.thumbplayer.tcmedia.api;

public class TPJitterBufferConfig {
    private long mAdjustIntervalThresholdMs;
    private long mFrozenThresholdMs;
    private long mMaxIncreaseDurationMs;
    private long mMinDecreaseDurationMs;
    private long mPerDecreaseDurationMs;
    private long mPerIncreaseDurationMs;

    public static final class Builder {
        public static final long DEFAULT_ADJUST_INTERVAL_THRESHOLD_MS = 60000;
        public static final long DEFAULT_FROZEN_THRESHOLD_MS = 800;
        public static final long DEFAULT_MAX_DECREASE_DURATION_MS = 8000;
        public static final long DEFAULT_MIN_DECREASE_DURATION_MS = 2000;
        public static final long DEFAULT_PER_DECREASE_DURATION_MS = 500;
        public static final long DEFAULT_PER_INCREASE_DURATION_MS = 1000;
        private long mAdjustIntervalThresholdMs = 60000;
        private long mFrozenThresholdMs = 800;
        private long mMaxIncreaseDurationMs = 8000;
        private long mMinDecreaseDurationMs = 2000;
        private long mPerDecreaseDurationMs = 500;
        private long mPerIncreaseDurationMs = 1000;

        public final TPJitterBufferConfig build() {
            return new TPJitterBufferConfig(this.mMinDecreaseDurationMs, this.mMaxIncreaseDurationMs, this.mPerIncreaseDurationMs, this.mPerDecreaseDurationMs, this.mAdjustIntervalThresholdMs, this.mFrozenThresholdMs);
        }

        public final Builder setAdjustIntervalThresholdMs(long j11) {
            this.mAdjustIntervalThresholdMs = j11;
            return this;
        }

        public final Builder setFrozenThresholdMs(long j11) {
            this.mFrozenThresholdMs = j11;
            return this;
        }

        public final Builder setMaxIncreaseDurationMs(long j11) {
            this.mMaxIncreaseDurationMs = j11;
            return this;
        }

        public final Builder setMinDecreaseDurationMs(long j11) {
            this.mMinDecreaseDurationMs = j11;
            return this;
        }

        public final Builder setPerDecreaseDurationMs(long j11) {
            this.mPerDecreaseDurationMs = j11;
            return this;
        }

        public final Builder setPerIncreaseDurationMs(long j11) {
            this.mPerIncreaseDurationMs = j11;
            return this;
        }
    }

    public TPJitterBufferConfig(long j11, long j12, long j13, long j14, long j15, long j16) {
        this.mMinDecreaseDurationMs = j11;
        this.mMaxIncreaseDurationMs = j12;
        this.mPerIncreaseDurationMs = j13;
        this.mPerDecreaseDurationMs = j14;
        this.mAdjustIntervalThresholdMs = j15;
        this.mFrozenThresholdMs = j16;
    }

    public long getAdjustIntervalThresholdMs() {
        return this.mAdjustIntervalThresholdMs;
    }

    public long getFrozenThresholdMs() {
        return this.mFrozenThresholdMs;
    }

    public long getMaxIncreaseDurationMs() {
        return this.mMaxIncreaseDurationMs;
    }

    public long getMinDecreaseDurationMs() {
        return this.mMinDecreaseDurationMs;
    }

    public long getPerDecreaseDurationMs() {
        return this.mPerDecreaseDurationMs;
    }

    public long getPerIncreaseDurationMs() {
        return this.mPerIncreaseDurationMs;
    }
}
