package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public class DefaultLoadControl implements LoadControl {
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 13107200;
    public static final int DEFAULT_BACK_BUFFER_DURATION_MS = 0;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_CAMERA_MOTION_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_METADATA_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MIN_BUFFER_MS = 50000;
    public static final int DEFAULT_MIN_BUFFER_SIZE = 13107200;
    public static final int DEFAULT_MUXED_BUFFER_SIZE = 144310272;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = false;
    public static final boolean DEFAULT_RETAIN_BACK_BUFFER_FROM_KEYFRAME = false;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
    public static final int DEFAULT_TEXT_BUFFER_SIZE = 131072;
    public static final int DEFAULT_VIDEO_BUFFER_SIZE = 131072000;
    private final DefaultAllocator allocator;
    private final long backBufferDurationUs;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean isLoading;
    private final long maxBufferUs;
    private final long minBufferUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final boolean retainBackBufferFromKeyframe;
    private int targetBufferBytes;
    private final int targetBufferBytesOverwrite;

    public static final class Builder {
        private DefaultAllocator allocator;
        private int backBufferDurationMs = 0;
        private int bufferForPlaybackAfterRebufferMs = 5000;
        private int bufferForPlaybackMs = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS;
        private boolean buildCalled;
        private int maxBufferMs = 50000;
        private int minBufferMs = 50000;
        private boolean prioritizeTimeOverSizeThresholds = false;
        private boolean retainBackBufferFromKeyframe = false;
        private int targetBufferBytes = -1;

        public DefaultLoadControl build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            if (this.allocator == null) {
                this.allocator = new DefaultAllocator(true, 65536);
            }
            return new DefaultLoadControl(this.allocator, this.minBufferMs, this.maxBufferMs, this.bufferForPlaybackMs, this.bufferForPlaybackAfterRebufferMs, this.targetBufferBytes, this.prioritizeTimeOverSizeThresholds, this.backBufferDurationMs, this.retainBackBufferFromKeyframe);
        }

        @Deprecated
        public DefaultLoadControl createDefaultLoadControl() {
            return build();
        }

        public Builder setAllocator(DefaultAllocator defaultAllocator) {
            Assertions.checkState(!this.buildCalled);
            this.allocator = defaultAllocator;
            return this;
        }

        public Builder setBackBuffer(int i11, boolean z11) {
            Assertions.checkState(!this.buildCalled);
            DefaultLoadControl.assertGreaterOrEqual(i11, 0, "backBufferDurationMs", "0");
            this.backBufferDurationMs = i11;
            this.retainBackBufferFromKeyframe = z11;
            return this;
        }

        public Builder setBufferDurationsMs(int i11, int i12, int i13, int i14) {
            Assertions.checkState(!this.buildCalled);
            DefaultLoadControl.assertGreaterOrEqual(i13, 0, "bufferForPlaybackMs", "0");
            DefaultLoadControl.assertGreaterOrEqual(i14, 0, "bufferForPlaybackAfterRebufferMs", "0");
            DefaultLoadControl.assertGreaterOrEqual(i11, i13, "minBufferMs", "bufferForPlaybackMs");
            DefaultLoadControl.assertGreaterOrEqual(i11, i14, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            DefaultLoadControl.assertGreaterOrEqual(i12, i11, "maxBufferMs", "minBufferMs");
            this.minBufferMs = i11;
            this.maxBufferMs = i12;
            this.bufferForPlaybackMs = i13;
            this.bufferForPlaybackAfterRebufferMs = i14;
            return this;
        }

        public Builder setPrioritizeTimeOverSizeThresholds(boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.prioritizeTimeOverSizeThresholds = z11;
            return this;
        }

        public Builder setTargetBufferBytes(int i11) {
            Assertions.checkState(!this.buildCalled);
            this.targetBufferBytes = i11;
            return this;
        }
    }

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536), 50000, 50000, DEFAULT_BUFFER_FOR_PLAYBACK_MS, 5000, -1, false, 0, false);
    }

    /* access modifiers changed from: private */
    public static void assertGreaterOrEqual(int i11, int i12, String str, String str2) {
        boolean z11 = i11 >= i12;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(" cannot be less than ");
        sb2.append(str2);
        Assertions.checkArgument(z11, sb2.toString());
    }

    private static int getDefaultBufferSize(int i11) {
        if (i11 == 0) {
            return DEFAULT_MUXED_BUFFER_SIZE;
        }
        if (i11 == 1) {
            return 13107200;
        }
        if (i11 == 2) {
            return DEFAULT_VIDEO_BUFFER_SIZE;
        }
        if (i11 == 3 || i11 == 5 || i11 == 6) {
            return 131072;
        }
        if (i11 == 7) {
            return 0;
        }
        throw new IllegalArgumentException();
    }

    private void reset(boolean z11) {
        int i11 = this.targetBufferBytesOverwrite;
        if (i11 == -1) {
            i11 = 13107200;
        }
        this.targetBufferBytes = i11;
        this.isLoading = false;
        if (z11) {
            this.allocator.reset();
        }
    }

    public int calculateTargetBufferBytes(Renderer[] rendererArr, ExoTrackSelection[] exoTrackSelectionArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < rendererArr.length; i12++) {
            if (exoTrackSelectionArr[i12] != null) {
                i11 += getDefaultBufferSize(rendererArr[i12].getTrackType());
            }
        }
        return Math.max(13107200, i11);
    }

    public Allocator getAllocator() {
        return this.allocator;
    }

    public long getBackBufferDurationUs() {
        return this.backBufferDurationUs;
    }

    public void onPrepared() {
        reset(false);
    }

    public void onReleased() {
        reset(true);
    }

    public void onStopped() {
        reset(true);
    }

    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        int i11 = this.targetBufferBytesOverwrite;
        if (i11 == -1) {
            i11 = calculateTargetBufferBytes(rendererArr, exoTrackSelectionArr);
        }
        this.targetBufferBytes = i11;
        this.allocator.setTargetBufferSize(i11);
    }

    public boolean retainBackBufferFromKeyframe() {
        return this.retainBackBufferFromKeyframe;
    }

    public boolean shouldContinueLoading(long j11, long j12, float f11) {
        boolean z11 = true;
        boolean z12 = this.allocator.getTotalBytesAllocated() >= this.targetBufferBytes;
        long j13 = this.minBufferUs;
        if (f11 > 1.0f) {
            j13 = Math.min(Util.getMediaDurationForPlayoutDuration(j13, f11), this.maxBufferUs);
        }
        if (j12 < Math.max(j13, 500000)) {
            if (!this.prioritizeTimeOverSizeThresholds && z12) {
                z11 = false;
            }
            this.isLoading = z11;
            if (!z11 && j12 < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j12 >= this.maxBufferUs || z12) {
            this.isLoading = false;
        }
        return this.isLoading;
    }

    public boolean shouldStartPlayback(long j11, float f11, boolean z11, long j12) {
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(j11, f11);
        long j13 = z11 ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
        if (j12 != -9223372036854775807L) {
            j13 = Math.min(j12 / 2, j13);
        }
        return j13 <= 0 || playoutDurationForMediaDuration >= j13 || (!this.prioritizeTimeOverSizeThresholds && this.allocator.getTotalBytesAllocated() >= this.targetBufferBytes);
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i11, int i12, int i13, int i14, int i15, boolean z11, int i16, boolean z12) {
        assertGreaterOrEqual(i13, 0, "bufferForPlaybackMs", "0");
        assertGreaterOrEqual(i14, 0, "bufferForPlaybackAfterRebufferMs", "0");
        assertGreaterOrEqual(i11, i13, "minBufferMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(i11, i14, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(i12, i11, "maxBufferMs", "minBufferMs");
        assertGreaterOrEqual(i16, 0, "backBufferDurationMs", "0");
        this.allocator = defaultAllocator;
        this.minBufferUs = C.msToUs((long) i11);
        this.maxBufferUs = C.msToUs((long) i12);
        this.bufferForPlaybackUs = C.msToUs((long) i13);
        this.bufferForPlaybackAfterRebufferUs = C.msToUs((long) i14);
        this.targetBufferBytesOverwrite = i15;
        this.targetBufferBytes = i15 == -1 ? 13107200 : i15;
        this.prioritizeTimeOverSizeThresholds = z11;
        this.backBufferDurationUs = C.msToUs((long) i16);
        this.retainBackBufferFromKeyframe = z12;
    }
}
