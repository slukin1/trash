package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public final class ClippingMediaSource extends CompositeMediaSource<Void> {
    private final boolean allowDynamicClippingUpdates;
    private IllegalClippingException clippingError;
    private ClippingTimeline clippingTimeline;
    private final boolean enableInitialDiscontinuity;
    private final long endUs;
    private final ArrayList<ClippingMediaPeriod> mediaPeriods;
    private final MediaSource mediaSource;
    private long periodEndUs;
    private long periodStartUs;
    private final boolean relativeToDefaultPosition;
    private final long startUs;
    private final Timeline.Window window;

    public static final class ClippingTimeline extends ForwardingTimeline {
        private final long durationUs;
        private final long endUs;
        private final boolean isDynamic;
        private final long startUs;

        public ClippingTimeline(Timeline timeline, long j11, long j12) throws IllegalClippingException {
            super(timeline);
            boolean z11 = false;
            if (timeline.getPeriodCount() == 1) {
                Timeline.Window window = timeline.getWindow(0, new Timeline.Window());
                long max = Math.max(0, j11);
                if (window.isPlaceholder || max == 0 || window.isSeekable) {
                    long max2 = j12 == Long.MIN_VALUE ? window.durationUs : Math.max(0, j12);
                    long j13 = window.durationUs;
                    if (j13 != -9223372036854775807L) {
                        max2 = max2 > j13 ? j13 : max2;
                        if (max > max2) {
                            throw new IllegalClippingException(2);
                        }
                    }
                    this.startUs = max;
                    this.endUs = max2;
                    int i11 = (max2 > -9223372036854775807L ? 1 : (max2 == -9223372036854775807L ? 0 : -1));
                    this.durationUs = i11 == 0 ? -9223372036854775807L : max2 - max;
                    if (window.isDynamic && (i11 == 0 || (j13 != -9223372036854775807L && max2 == j13))) {
                        z11 = true;
                    }
                    this.isDynamic = z11;
                    return;
                }
                throw new IllegalClippingException(1);
            }
            throw new IllegalClippingException(0);
        }

        public Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
            this.timeline.getPeriod(0, period, z11);
            long positionInWindowUs = period.getPositionInWindowUs() - this.startUs;
            long j11 = this.durationUs;
            return period.set(period.f65680id, period.uid, 0, j11 == -9223372036854775807L ? -9223372036854775807L : j11 - positionInWindowUs, positionInWindowUs);
        }

        public Timeline.Window getWindow(int i11, Timeline.Window window, long j11) {
            this.timeline.getWindow(0, window, 0);
            long j12 = window.positionInFirstPeriodUs;
            long j13 = this.startUs;
            window.positionInFirstPeriodUs = j12 + j13;
            window.durationUs = this.durationUs;
            window.isDynamic = this.isDynamic;
            long j14 = window.defaultPositionUs;
            if (j14 != -9223372036854775807L) {
                long max = Math.max(j14, j13);
                window.defaultPositionUs = max;
                long j15 = this.endUs;
                if (j15 != -9223372036854775807L) {
                    max = Math.min(max, j15);
                }
                window.defaultPositionUs = max;
                window.defaultPositionUs = max - this.startUs;
            }
            long usToMs = C.usToMs(this.startUs);
            long j16 = window.presentationStartTimeMs;
            if (j16 != -9223372036854775807L) {
                window.presentationStartTimeMs = j16 + usToMs;
            }
            long j17 = window.windowStartTimeMs;
            if (j17 != -9223372036854775807L) {
                window.windowStartTimeMs = j17 + usToMs;
            }
            return window;
        }
    }

    public static final class IllegalClippingException extends IOException {
        public static final int REASON_INVALID_PERIOD_COUNT = 0;
        public static final int REASON_NOT_SEEKABLE_TO_START = 1;
        public static final int REASON_START_EXCEEDS_END = 2;
        public final int reason;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public IllegalClippingException(int r4) {
            /*
                r3 = this;
                java.lang.String r0 = getReasonDescription(r4)
                java.lang.String r0 = java.lang.String.valueOf(r0)
                int r1 = r0.length()
                java.lang.String r2 = "Illegal clipping: "
                if (r1 == 0) goto L_0x0015
                java.lang.String r0 = r2.concat(r0)
                goto L_0x001a
            L_0x0015:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r2)
            L_0x001a:
                r3.<init>(r0)
                r3.reason = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ClippingMediaSource.IllegalClippingException.<init>(int):void");
        }

        private static String getReasonDescription(int i11) {
            return i11 != 0 ? i11 != 1 ? i11 != 2 ? "unknown" : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    public ClippingMediaSource(MediaSource mediaSource2, long j11, long j12) {
        this(mediaSource2, j11, j12, true, false, false);
    }

    private void refreshClippedTimeline(Timeline timeline) {
        long j11;
        timeline.getWindow(0, this.window);
        long positionInFirstPeriodUs = this.window.getPositionInFirstPeriodUs();
        long j12 = Long.MIN_VALUE;
        if (this.clippingTimeline == null || this.mediaPeriods.isEmpty() || this.allowDynamicClippingUpdates) {
            long j13 = this.startUs;
            long j14 = this.endUs;
            if (this.relativeToDefaultPosition) {
                long defaultPositionUs = this.window.getDefaultPositionUs();
                j13 += defaultPositionUs;
                j14 += defaultPositionUs;
            }
            this.periodStartUs = positionInFirstPeriodUs + j13;
            if (this.endUs != Long.MIN_VALUE) {
                j12 = positionInFirstPeriodUs + j14;
            }
            this.periodEndUs = j12;
            int size = this.mediaPeriods.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mediaPeriods.get(i11).updateClipping(this.periodStartUs, this.periodEndUs);
            }
            j11 = j13;
            j12 = j14;
        } else {
            long j15 = this.periodStartUs - positionInFirstPeriodUs;
            if (this.endUs != Long.MIN_VALUE) {
                j12 = this.periodEndUs - positionInFirstPeriodUs;
            }
            j11 = j15;
        }
        try {
            ClippingTimeline clippingTimeline2 = new ClippingTimeline(timeline, j11, j12);
            this.clippingTimeline = clippingTimeline2;
            refreshSourceInfo(clippingTimeline2);
        } catch (IllegalClippingException e11) {
            this.clippingError = e11;
        }
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.mediaSource.createPeriod(mediaPeriodId, allocator, j11), this.enableInitialDiscontinuity, this.periodStartUs, this.periodEndUs);
        this.mediaPeriods.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    public MediaItem getMediaItem() {
        return this.mediaSource.getMediaItem();
    }

    @Deprecated
    public Object getTag() {
        return this.mediaSource.getTag();
    }

    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException == null) {
            super.maybeThrowSourceInfoRefreshError();
            return;
        }
        throw illegalClippingException;
    }

    public void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.mediaSource);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        Assertions.checkState(this.mediaPeriods.remove(mediaPeriod));
        this.mediaSource.releasePeriod(((ClippingMediaPeriod) mediaPeriod).mediaPeriod);
        if (this.mediaPeriods.isEmpty() && !this.allowDynamicClippingUpdates) {
            refreshClippedTimeline(((ClippingTimeline) Assertions.checkNotNull(this.clippingTimeline)).timeline);
        }
    }

    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        this.clippingError = null;
        this.clippingTimeline = null;
    }

    public ClippingMediaSource(MediaSource mediaSource2, long j11) {
        this(mediaSource2, 0, j11, true, false, true);
    }

    public void onChildSourceInfoRefreshed(Void voidR, MediaSource mediaSource2, Timeline timeline) {
        if (this.clippingError == null) {
            refreshClippedTimeline(timeline);
        }
    }

    public ClippingMediaSource(MediaSource mediaSource2, long j11, long j12, boolean z11, boolean z12, boolean z13) {
        Assertions.checkArgument(j11 >= 0);
        this.mediaSource = (MediaSource) Assertions.checkNotNull(mediaSource2);
        this.startUs = j11;
        this.endUs = j12;
        this.enableInitialDiscontinuity = z11;
        this.allowDynamicClippingUpdates = z12;
        this.relativeToDefaultPosition = z13;
        this.mediaPeriods = new ArrayList<>();
        this.window = new Timeline.Window();
    }
}
