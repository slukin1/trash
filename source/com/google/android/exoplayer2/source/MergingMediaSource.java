package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class MergingMediaSource extends CompositeMediaSource<Integer> {
    private static final MediaItem EMPTY_MEDIA_ITEM = new MediaItem.Builder().setMediaId("MergingMediaSource").build();
    private static final int PERIOD_COUNT_UNSET = -1;
    private final boolean adjustPeriodTimeOffsets;
    private final boolean clipDurations;
    private final Map<Object, Long> clippedDurationsUs;
    private final Multimap<Object, ClippingMediaPeriod> clippedMediaPeriods;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final MediaSource[] mediaSources;
    private IllegalMergeException mergeError;
    private final ArrayList<MediaSource> pendingTimelineSources;
    private int periodCount;
    private long[][] periodTimeOffsetsUs;
    private final Timeline[] timelines;

    public static final class ClippedTimeline extends ForwardingTimeline {
        private final long[] periodDurationsUs;
        private final long[] windowDurationsUs;

        public ClippedTimeline(Timeline timeline, Map<Object, Long> map) {
            super(timeline);
            int windowCount = timeline.getWindowCount();
            this.windowDurationsUs = new long[timeline.getWindowCount()];
            Timeline.Window window = new Timeline.Window();
            for (int i11 = 0; i11 < windowCount; i11++) {
                this.windowDurationsUs[i11] = timeline.getWindow(i11, window).durationUs;
            }
            int periodCount = timeline.getPeriodCount();
            this.periodDurationsUs = new long[periodCount];
            Timeline.Period period = new Timeline.Period();
            for (int i12 = 0; i12 < periodCount; i12++) {
                timeline.getPeriod(i12, period, true);
                long longValue = ((Long) Assertions.checkNotNull(map.get(period.uid))).longValue();
                long[] jArr = this.periodDurationsUs;
                jArr[i12] = longValue == Long.MIN_VALUE ? period.durationUs : longValue;
                long j11 = period.durationUs;
                if (j11 != -9223372036854775807L) {
                    long[] jArr2 = this.windowDurationsUs;
                    int i13 = period.windowIndex;
                    jArr2[i13] = jArr2[i13] - (j11 - jArr[i12]);
                }
            }
        }

        public Timeline.Period getPeriod(int i11, Timeline.Period period, boolean z11) {
            super.getPeriod(i11, period, z11);
            period.durationUs = this.periodDurationsUs[i11];
            return period;
        }

        public Timeline.Window getWindow(int i11, Timeline.Window window, long j11) {
            long j12;
            super.getWindow(i11, window, j11);
            long j13 = this.windowDurationsUs[i11];
            window.durationUs = j13;
            if (j13 != -9223372036854775807L) {
                long j14 = window.defaultPositionUs;
                if (j14 != -9223372036854775807L) {
                    j12 = Math.min(j14, j13);
                    window.defaultPositionUs = j12;
                    return window;
                }
            }
            j12 = window.defaultPositionUs;
            window.defaultPositionUs = j12;
            return window;
        }
    }

    public static final class IllegalMergeException extends IOException {
        public static final int REASON_PERIOD_COUNT_MISMATCH = 0;
        public final int reason;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalMergeException(int i11) {
            this.reason = i11;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    private void computePeriodTimeOffsets() {
        Timeline.Period period = new Timeline.Period();
        for (int i11 = 0; i11 < this.periodCount; i11++) {
            long j11 = -this.timelines[0].getPeriod(i11, period).getPositionInWindowUs();
            int i12 = 1;
            while (true) {
                Timeline[] timelineArr = this.timelines;
                if (i12 >= timelineArr.length) {
                    break;
                }
                this.periodTimeOffsetsUs[i11][i12] = j11 - (-timelineArr[i12].getPeriod(i11, period).getPositionInWindowUs());
                i12++;
            }
        }
    }

    private void updateClippedDuration() {
        Timeline[] timelineArr;
        Timeline.Period period = new Timeline.Period();
        for (int i11 = 0; i11 < this.periodCount; i11++) {
            int i12 = 0;
            long j11 = Long.MIN_VALUE;
            while (true) {
                timelineArr = this.timelines;
                if (i12 >= timelineArr.length) {
                    break;
                }
                long durationUs = timelineArr[i12].getPeriod(i11, period).getDurationUs();
                if (durationUs != -9223372036854775807L) {
                    long j12 = durationUs + this.periodTimeOffsetsUs[i11][i12];
                    if (j11 == Long.MIN_VALUE || j12 < j11) {
                        j11 = j12;
                    }
                }
                i12++;
            }
            Object uidOfPeriod = timelineArr[0].getUidOfPeriod(i11);
            this.clippedDurationsUs.put(uidOfPeriod, Long.valueOf(j11));
            for (ClippingMediaPeriod updateClipping : this.clippedMediaPeriods.get(uidOfPeriod)) {
                updateClipping.updateClipping(0, j11);
            }
        }
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        int length = this.mediaSources.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        int indexOfPeriod = this.timelines[0].getIndexOfPeriod(mediaPeriodId.periodUid);
        for (int i11 = 0; i11 < length; i11++) {
            mediaPeriodArr[i11] = this.mediaSources[i11].createPeriod(mediaPeriodId.copyWithPeriodUid(this.timelines[i11].getUidOfPeriod(indexOfPeriod)), allocator, j11 - this.periodTimeOffsetsUs[indexOfPeriod][i11]);
        }
        MergingMediaPeriod mergingMediaPeriod = new MergingMediaPeriod(this.compositeSequenceableLoaderFactory, this.periodTimeOffsetsUs[indexOfPeriod], mediaPeriodArr);
        if (!this.clipDurations) {
            return mergingMediaPeriod;
        }
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(mergingMediaPeriod, true, 0, ((Long) Assertions.checkNotNull(this.clippedDurationsUs.get(mediaPeriodId.periodUid))).longValue());
        this.clippedMediaPeriods.put(mediaPeriodId.periodUid, clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    public MediaItem getMediaItem() {
        MediaSource[] mediaSourceArr = this.mediaSources;
        return mediaSourceArr.length > 0 ? mediaSourceArr[0].getMediaItem() : EMPTY_MEDIA_ITEM;
    }

    @Deprecated
    public Object getTag() {
        MediaSource[] mediaSourceArr = this.mediaSources;
        if (mediaSourceArr.length > 0) {
            return mediaSourceArr[0].getTag();
        }
        return null;
    }

    public void maybeThrowSourceInfoRefreshError() throws IOException {
        IllegalMergeException illegalMergeException = this.mergeError;
        if (illegalMergeException == null) {
            super.maybeThrowSourceInfoRefreshError();
            return;
        }
        throw illegalMergeException;
    }

    public void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        for (int i11 = 0; i11 < this.mediaSources.length; i11++) {
            prepareChildSource(Integer.valueOf(i11), this.mediaSources[i11]);
        }
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        if (this.clipDurations) {
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) mediaPeriod;
            Iterator<Map.Entry<Object, ClippingMediaPeriod>> it2 = this.clippedMediaPeriods.entries().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (((ClippingMediaPeriod) next.getValue()).equals(clippingMediaPeriod)) {
                    this.clippedMediaPeriods.remove(next.getKey(), next.getValue());
                    break;
                }
            }
            mediaPeriod = clippingMediaPeriod.mediaPeriod;
        }
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        int i11 = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.mediaSources;
            if (i11 < mediaSourceArr.length) {
                mediaSourceArr[i11].releasePeriod(mergingMediaPeriod.getChildPeriod(i11));
                i11++;
            } else {
                return;
            }
        }
    }

    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        Arrays.fill(this.timelines, (Object) null);
        this.periodCount = -1;
        this.mergeError = null;
        this.pendingTimelineSources.clear();
        Collections.addAll(this.pendingTimelineSources, this.mediaSources);
    }

    public MergingMediaSource(boolean z11, MediaSource... mediaSourceArr) {
        this(z11, false, mediaSourceArr);
    }

    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() == 0) {
            return mediaPeriodId;
        }
        return null;
    }

    public void onChildSourceInfoRefreshed(Integer num, MediaSource mediaSource, Timeline timeline) {
        if (this.mergeError == null) {
            if (this.periodCount == -1) {
                this.periodCount = timeline.getPeriodCount();
            } else if (timeline.getPeriodCount() != this.periodCount) {
                this.mergeError = new IllegalMergeException(0);
                return;
            }
            if (this.periodTimeOffsetsUs.length == 0) {
                int i11 = this.periodCount;
                int[] iArr = new int[2];
                iArr[1] = this.timelines.length;
                iArr[0] = i11;
                this.periodTimeOffsetsUs = (long[][]) Array.newInstance(long.class, iArr);
            }
            this.pendingTimelineSources.remove(mediaSource);
            this.timelines[num.intValue()] = timeline;
            if (this.pendingTimelineSources.isEmpty()) {
                if (this.adjustPeriodTimeOffsets) {
                    computePeriodTimeOffsets();
                }
                ClippedTimeline clippedTimeline = this.timelines[0];
                if (this.clipDurations) {
                    updateClippedDuration();
                    clippedTimeline = new ClippedTimeline(clippedTimeline, this.clippedDurationsUs);
                }
                refreshSourceInfo(clippedTimeline);
            }
        }
    }

    public MergingMediaSource(boolean z11, boolean z12, MediaSource... mediaSourceArr) {
        this(z11, z12, new DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    public MergingMediaSource(boolean z11, boolean z12, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2, MediaSource... mediaSourceArr) {
        this.adjustPeriodTimeOffsets = z11;
        this.clipDurations = z12;
        this.mediaSources = mediaSourceArr;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory2;
        this.pendingTimelineSources = new ArrayList<>(Arrays.asList(mediaSourceArr));
        this.periodCount = -1;
        this.timelines = new Timeline[mediaSourceArr.length];
        this.periodTimeOffsetsUs = new long[0][];
        this.clippedDurationsUs = new HashMap();
        this.clippedMediaPeriods = MultimapBuilder.hashKeys().arrayListValues().build();
    }
}
