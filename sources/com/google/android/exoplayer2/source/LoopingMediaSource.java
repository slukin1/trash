package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public final class LoopingMediaSource extends CompositeMediaSource<Void> {
    private final Map<MediaSource.MediaPeriodId, MediaSource.MediaPeriodId> childMediaPeriodIdToMediaPeriodId;
    private final int loopCount;
    private final MaskingMediaSource maskingMediaSource;
    private final Map<MediaPeriod, MediaSource.MediaPeriodId> mediaPeriodToChildMediaPeriodId;

    public static final class InfinitelyLoopingTimeline extends ForwardingTimeline {
        public InfinitelyLoopingTimeline(Timeline timeline) {
            super(timeline);
        }

        public int getNextWindowIndex(int i11, int i12, boolean z11) {
            int nextWindowIndex = this.timeline.getNextWindowIndex(i11, i12, z11);
            return nextWindowIndex == -1 ? getFirstWindowIndex(z11) : nextWindowIndex;
        }

        public int getPreviousWindowIndex(int i11, int i12, boolean z11) {
            int previousWindowIndex = this.timeline.getPreviousWindowIndex(i11, i12, z11);
            return previousWindowIndex == -1 ? getLastWindowIndex(z11) : previousWindowIndex;
        }
    }

    public static final class LoopingTimeline extends AbstractConcatenatedTimeline {
        private final int childPeriodCount;
        private final Timeline childTimeline;
        private final int childWindowCount;
        private final int loopCount;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoopingTimeline(Timeline timeline, int i11) {
            super(false, new ShuffleOrder.UnshuffledShuffleOrder(i11));
            boolean z11 = false;
            this.childTimeline = timeline;
            int periodCount = timeline.getPeriodCount();
            this.childPeriodCount = periodCount;
            this.childWindowCount = timeline.getWindowCount();
            this.loopCount = i11;
            if (periodCount > 0) {
                Assertions.checkState(i11 <= Integer.MAX_VALUE / periodCount ? true : z11, "LoopingMediaSource contains too many periods");
            }
        }

        public int getChildIndexByChildUid(Object obj) {
            if (!(obj instanceof Integer)) {
                return -1;
            }
            return ((Integer) obj).intValue();
        }

        public int getChildIndexByPeriodIndex(int i11) {
            return i11 / this.childPeriodCount;
        }

        public int getChildIndexByWindowIndex(int i11) {
            return i11 / this.childWindowCount;
        }

        public Object getChildUidByChildIndex(int i11) {
            return Integer.valueOf(i11);
        }

        public int getFirstPeriodIndexByChildIndex(int i11) {
            return i11 * this.childPeriodCount;
        }

        public int getFirstWindowIndexByChildIndex(int i11) {
            return i11 * this.childWindowCount;
        }

        public int getPeriodCount() {
            return this.childPeriodCount * this.loopCount;
        }

        public Timeline getTimelineByChildIndex(int i11) {
            return this.childTimeline;
        }

        public int getWindowCount() {
            return this.childWindowCount * this.loopCount;
        }
    }

    public LoopingMediaSource(MediaSource mediaSource) {
        this(mediaSource, Integer.MAX_VALUE);
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j11) {
        if (this.loopCount == Integer.MAX_VALUE) {
            return this.maskingMediaSource.createPeriod(mediaPeriodId, allocator, j11);
        }
        MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(mediaPeriodId.periodUid));
        this.childMediaPeriodIdToMediaPeriodId.put(copyWithPeriodUid, mediaPeriodId);
        MaskingMediaPeriod createPeriod = this.maskingMediaSource.createPeriod(copyWithPeriodUid, allocator, j11);
        this.mediaPeriodToChildMediaPeriodId.put(createPeriod, copyWithPeriodUid);
        return createPeriod;
    }

    public Timeline getInitialTimeline() {
        if (this.loopCount != Integer.MAX_VALUE) {
            return new LoopingTimeline(this.maskingMediaSource.getTimeline(), this.loopCount);
        }
        return new InfinitelyLoopingTimeline(this.maskingMediaSource.getTimeline());
    }

    public MediaItem getMediaItem() {
        return this.maskingMediaSource.getMediaItem();
    }

    @Deprecated
    public Object getTag() {
        return this.maskingMediaSource.getTag();
    }

    public boolean isSingleWindow() {
        return false;
    }

    public void prepareSourceInternal(TransferListener transferListener) {
        super.prepareSourceInternal(transferListener);
        prepareChildSource(null, this.maskingMediaSource);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        this.maskingMediaSource.releasePeriod(mediaPeriod);
        MediaSource.MediaPeriodId remove = this.mediaPeriodToChildMediaPeriodId.remove(mediaPeriod);
        if (remove != null) {
            this.childMediaPeriodIdToMediaPeriodId.remove(remove);
        }
    }

    public LoopingMediaSource(MediaSource mediaSource, int i11) {
        Assertions.checkArgument(i11 > 0);
        this.maskingMediaSource = new MaskingMediaSource(mediaSource, false);
        this.loopCount = i11;
        this.childMediaPeriodIdToMediaPeriodId = new HashMap();
        this.mediaPeriodToChildMediaPeriodId = new HashMap();
    }

    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Void voidR, MediaSource.MediaPeriodId mediaPeriodId) {
        return this.loopCount != Integer.MAX_VALUE ? this.childMediaPeriodIdToMediaPeriodId.get(mediaPeriodId) : mediaPeriodId;
    }

    public void onChildSourceInfoRefreshed(Void voidR, MediaSource mediaSource, Timeline timeline) {
        Timeline timeline2;
        if (this.loopCount != Integer.MAX_VALUE) {
            timeline2 = new LoopingTimeline(timeline, this.loopCount);
        } else {
            timeline2 = new InfinitelyLoopingTimeline(timeline);
        }
        refreshSourceInfo(timeline2);
    }
}
