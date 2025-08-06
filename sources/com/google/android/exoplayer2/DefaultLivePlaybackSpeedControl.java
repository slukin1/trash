package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Longs;

public final class DefaultLivePlaybackSpeedControl implements LivePlaybackSpeedControl {
    public static final float DEFAULT_FALLBACK_MAX_PLAYBACK_SPEED = 1.03f;
    public static final float DEFAULT_FALLBACK_MIN_PLAYBACK_SPEED = 0.97f;
    public static final long DEFAULT_MAX_LIVE_OFFSET_ERROR_MS_FOR_UNIT_SPEED = 20;
    public static final float DEFAULT_MIN_POSSIBLE_LIVE_OFFSET_SMOOTHING_FACTOR = 0.999f;
    public static final long DEFAULT_MIN_UPDATE_INTERVAL_MS = 1000;
    public static final float DEFAULT_PROPORTIONAL_CONTROL_FACTOR = 0.1f;
    public static final long DEFAULT_TARGET_LIVE_OFFSET_INCREMENT_ON_REBUFFER_MS = 500;
    private float adjustedPlaybackSpeed;
    private long currentTargetLiveOffsetUs;
    private final float fallbackMaxPlaybackSpeed;
    private final float fallbackMinPlaybackSpeed;
    private long idealTargetLiveOffsetUs;
    private long lastPlaybackSpeedUpdateMs;
    private final long maxLiveOffsetErrorUsForUnitSpeed;
    private float maxPlaybackSpeed;
    private long maxTargetLiveOffsetUs;
    private long mediaConfigurationTargetLiveOffsetUs;
    private float minPlaybackSpeed;
    private final float minPossibleLiveOffsetSmoothingFactor;
    private long minTargetLiveOffsetUs;
    private final long minUpdateIntervalMs;
    private final float proportionalControlFactor;
    private long smoothedMinPossibleLiveOffsetDeviationUs;
    private long smoothedMinPossibleLiveOffsetUs;
    private long targetLiveOffsetOverrideUs;
    private final long targetLiveOffsetRebufferDeltaUs;

    public static final class Builder {
        private float fallbackMaxPlaybackSpeed = 1.03f;
        private float fallbackMinPlaybackSpeed = 0.97f;
        private long maxLiveOffsetErrorUsForUnitSpeed = C.msToUs(20);
        private float minPossibleLiveOffsetSmoothingFactor = 0.999f;
        private long minUpdateIntervalMs = 1000;
        private float proportionalControlFactorUs = 1.0E-7f;
        private long targetLiveOffsetIncrementOnRebufferUs = C.msToUs(500);

        public DefaultLivePlaybackSpeedControl build() {
            return new DefaultLivePlaybackSpeedControl(this.fallbackMinPlaybackSpeed, this.fallbackMaxPlaybackSpeed, this.minUpdateIntervalMs, this.proportionalControlFactorUs, this.maxLiveOffsetErrorUsForUnitSpeed, this.targetLiveOffsetIncrementOnRebufferUs, this.minPossibleLiveOffsetSmoothingFactor);
        }

        public Builder setFallbackMaxPlaybackSpeed(float f11) {
            Assertions.checkArgument(f11 >= 1.0f);
            this.fallbackMaxPlaybackSpeed = f11;
            return this;
        }

        public Builder setFallbackMinPlaybackSpeed(float f11) {
            Assertions.checkArgument(0.0f < f11 && f11 <= 1.0f);
            this.fallbackMinPlaybackSpeed = f11;
            return this;
        }

        public Builder setMaxLiveOffsetErrorMsForUnitSpeed(long j11) {
            Assertions.checkArgument(j11 > 0);
            this.maxLiveOffsetErrorUsForUnitSpeed = C.msToUs(j11);
            return this;
        }

        public Builder setMinPossibleLiveOffsetSmoothingFactor(float f11) {
            Assertions.checkArgument(f11 >= 0.0f && f11 < 1.0f);
            this.minPossibleLiveOffsetSmoothingFactor = f11;
            return this;
        }

        public Builder setMinUpdateIntervalMs(long j11) {
            Assertions.checkArgument(j11 > 0);
            this.minUpdateIntervalMs = j11;
            return this;
        }

        public Builder setProportionalControlFactor(float f11) {
            Assertions.checkArgument(f11 > 0.0f);
            this.proportionalControlFactorUs = f11 / 1000000.0f;
            return this;
        }

        public Builder setTargetLiveOffsetIncrementOnRebufferMs(long j11) {
            Assertions.checkArgument(j11 >= 0);
            this.targetLiveOffsetIncrementOnRebufferUs = C.msToUs(j11);
            return this;
        }
    }

    private void adjustTargetLiveOffsetUs(long j11) {
        long j12 = this.smoothedMinPossibleLiveOffsetUs + (this.smoothedMinPossibleLiveOffsetDeviationUs * 3);
        if (this.currentTargetLiveOffsetUs > j12) {
            float msToUs = (float) C.msToUs(this.minUpdateIntervalMs);
            this.currentTargetLiveOffsetUs = Longs.max(j12, this.idealTargetLiveOffsetUs, this.currentTargetLiveOffsetUs - (((long) ((this.adjustedPlaybackSpeed - 1.0f) * msToUs)) + ((long) ((this.maxPlaybackSpeed - 1.0f) * msToUs))));
            return;
        }
        long constrainValue = Util.constrainValue(j11 - ((long) (Math.max(0.0f, this.adjustedPlaybackSpeed - 1.0f) / this.proportionalControlFactor)), this.currentTargetLiveOffsetUs, j12);
        this.currentTargetLiveOffsetUs = constrainValue;
        long j13 = this.maxTargetLiveOffsetUs;
        if (j13 != -9223372036854775807L && constrainValue > j13) {
            this.currentTargetLiveOffsetUs = j13;
        }
    }

    private void maybeResetTargetLiveOffsetUs() {
        long j11 = this.mediaConfigurationTargetLiveOffsetUs;
        if (j11 != -9223372036854775807L) {
            long j12 = this.targetLiveOffsetOverrideUs;
            if (j12 != -9223372036854775807L) {
                j11 = j12;
            }
            long j13 = this.minTargetLiveOffsetUs;
            if (j13 != -9223372036854775807L && j11 < j13) {
                j11 = j13;
            }
            long j14 = this.maxTargetLiveOffsetUs;
            if (j14 != -9223372036854775807L && j11 > j14) {
                j11 = j14;
            }
        } else {
            j11 = -9223372036854775807L;
        }
        if (this.idealTargetLiveOffsetUs != j11) {
            this.idealTargetLiveOffsetUs = j11;
            this.currentTargetLiveOffsetUs = j11;
            this.smoothedMinPossibleLiveOffsetUs = -9223372036854775807L;
            this.smoothedMinPossibleLiveOffsetDeviationUs = -9223372036854775807L;
            this.lastPlaybackSpeedUpdateMs = -9223372036854775807L;
        }
    }

    private static long smooth(long j11, long j12, float f11) {
        return (long) ((((float) j11) * f11) + ((1.0f - f11) * ((float) j12)));
    }

    private void updateSmoothedMinPossibleLiveOffsetUs(long j11, long j12) {
        long j13 = j11 - j12;
        long j14 = this.smoothedMinPossibleLiveOffsetUs;
        if (j14 == -9223372036854775807L) {
            this.smoothedMinPossibleLiveOffsetUs = j13;
            this.smoothedMinPossibleLiveOffsetDeviationUs = 0;
            return;
        }
        long max = Math.max(j13, smooth(j14, j13, this.minPossibleLiveOffsetSmoothingFactor));
        this.smoothedMinPossibleLiveOffsetUs = max;
        this.smoothedMinPossibleLiveOffsetDeviationUs = smooth(this.smoothedMinPossibleLiveOffsetDeviationUs, Math.abs(j13 - max), this.minPossibleLiveOffsetSmoothingFactor);
    }

    public float getAdjustedPlaybackSpeed(long j11, long j12) {
        if (this.mediaConfigurationTargetLiveOffsetUs == -9223372036854775807L) {
            return 1.0f;
        }
        updateSmoothedMinPossibleLiveOffsetUs(j11, j12);
        if (this.lastPlaybackSpeedUpdateMs != -9223372036854775807L && SystemClock.elapsedRealtime() - this.lastPlaybackSpeedUpdateMs < this.minUpdateIntervalMs) {
            return this.adjustedPlaybackSpeed;
        }
        this.lastPlaybackSpeedUpdateMs = SystemClock.elapsedRealtime();
        adjustTargetLiveOffsetUs(j11);
        long j13 = j11 - this.currentTargetLiveOffsetUs;
        if (Math.abs(j13) < this.maxLiveOffsetErrorUsForUnitSpeed) {
            this.adjustedPlaybackSpeed = 1.0f;
        } else {
            this.adjustedPlaybackSpeed = Util.constrainValue((this.proportionalControlFactor * ((float) j13)) + 1.0f, this.minPlaybackSpeed, this.maxPlaybackSpeed);
        }
        return this.adjustedPlaybackSpeed;
    }

    public long getTargetLiveOffsetUs() {
        return this.currentTargetLiveOffsetUs;
    }

    public void notifyRebuffer() {
        long j11 = this.currentTargetLiveOffsetUs;
        if (j11 != -9223372036854775807L) {
            long j12 = j11 + this.targetLiveOffsetRebufferDeltaUs;
            this.currentTargetLiveOffsetUs = j12;
            long j13 = this.maxTargetLiveOffsetUs;
            if (j13 != -9223372036854775807L && j12 > j13) {
                this.currentTargetLiveOffsetUs = j13;
            }
            this.lastPlaybackSpeedUpdateMs = -9223372036854775807L;
        }
    }

    public void setLiveConfiguration(MediaItem.LiveConfiguration liveConfiguration) {
        this.mediaConfigurationTargetLiveOffsetUs = C.msToUs(liveConfiguration.targetOffsetMs);
        this.minTargetLiveOffsetUs = C.msToUs(liveConfiguration.minOffsetMs);
        this.maxTargetLiveOffsetUs = C.msToUs(liveConfiguration.maxOffsetMs);
        float f11 = liveConfiguration.minPlaybackSpeed;
        if (f11 == -3.4028235E38f) {
            f11 = this.fallbackMinPlaybackSpeed;
        }
        this.minPlaybackSpeed = f11;
        float f12 = liveConfiguration.maxPlaybackSpeed;
        if (f12 == -3.4028235E38f) {
            f12 = this.fallbackMaxPlaybackSpeed;
        }
        this.maxPlaybackSpeed = f12;
        maybeResetTargetLiveOffsetUs();
    }

    public void setTargetLiveOffsetOverrideUs(long j11) {
        this.targetLiveOffsetOverrideUs = j11;
        maybeResetTargetLiveOffsetUs();
    }

    private DefaultLivePlaybackSpeedControl(float f11, float f12, long j11, float f13, long j12, long j13, float f14) {
        this.fallbackMinPlaybackSpeed = f11;
        this.fallbackMaxPlaybackSpeed = f12;
        this.minUpdateIntervalMs = j11;
        this.proportionalControlFactor = f13;
        this.maxLiveOffsetErrorUsForUnitSpeed = j12;
        this.targetLiveOffsetRebufferDeltaUs = j13;
        this.minPossibleLiveOffsetSmoothingFactor = f14;
        this.mediaConfigurationTargetLiveOffsetUs = -9223372036854775807L;
        this.targetLiveOffsetOverrideUs = -9223372036854775807L;
        this.minTargetLiveOffsetUs = -9223372036854775807L;
        this.maxTargetLiveOffsetUs = -9223372036854775807L;
        this.minPlaybackSpeed = f11;
        this.maxPlaybackSpeed = f12;
        this.adjustedPlaybackSpeed = 1.0f;
        this.lastPlaybackSpeedUpdateMs = -9223372036854775807L;
        this.idealTargetLiveOffsetUs = -9223372036854775807L;
        this.currentTargetLiveOffsetUs = -9223372036854775807L;
        this.smoothedMinPossibleLiveOffsetUs = -9223372036854775807L;
        this.smoothedMinPossibleLiveOffsetDeviationUs = -9223372036854775807L;
    }
}
