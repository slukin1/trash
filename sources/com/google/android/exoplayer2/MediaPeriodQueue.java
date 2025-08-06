package com.google.android.exoplayer2;

import android.os.Handler;
import android.util.Pair;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;

final class MediaPeriodQueue {
    private static final int MAXIMUM_BUFFER_AHEAD_PERIODS = 100;
    private final AnalyticsCollector analyticsCollector;
    private final Handler analyticsCollectorHandler;
    private int length;
    private MediaPeriodHolder loading;
    private long nextWindowSequenceNumber;
    private Object oldFrontPeriodUid;
    private long oldFrontPeriodWindowSequenceNumber;
    private final Timeline.Period period = new Timeline.Period();
    private MediaPeriodHolder playing;
    private MediaPeriodHolder reading;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final Timeline.Window window = new Timeline.Window();

    public MediaPeriodQueue(AnalyticsCollector analyticsCollector2, Handler handler) {
        this.analyticsCollector = analyticsCollector2;
        this.analyticsCollectorHandler = handler;
    }

    private boolean areDurationsCompatible(long j11, long j12) {
        return j11 == -9223372036854775807L || j11 == j12;
    }

    private boolean canKeepMediaPeriodHolder(MediaPeriodInfo mediaPeriodInfo, MediaPeriodInfo mediaPeriodInfo2) {
        return mediaPeriodInfo.startPositionUs == mediaPeriodInfo2.startPositionUs && mediaPeriodInfo.f65678id.equals(mediaPeriodInfo2.f65678id);
    }

    private MediaPeriodInfo getFirstMediaPeriodInfo(PlaybackInfo playbackInfo) {
        return getMediaPeriodInfo(playbackInfo.timeline, playbackInfo.periodId, playbackInfo.requestedContentPositionUs, playbackInfo.positionUs);
    }

    private MediaPeriodInfo getFollowingMediaPeriodInfo(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j11) {
        long j12;
        Timeline timeline2 = timeline;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.info;
        long rendererOffset = (mediaPeriodHolder.getRendererOffset() + mediaPeriodInfo.durationUs) - j11;
        if (mediaPeriodInfo.isLastInTimelinePeriod) {
            long j13 = 0;
            int nextPeriodIndex = timeline.getNextPeriodIndex(timeline2.getIndexOfPeriod(mediaPeriodInfo.f65678id.periodUid), this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i11 = timeline2.getPeriod(nextPeriodIndex, this.period, true).windowIndex;
            Object obj = this.period.uid;
            long j14 = mediaPeriodInfo.f65678id.windowSequenceNumber;
            if (timeline2.getWindow(i11, this.window).firstPeriodIndex == nextPeriodIndex) {
                Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, i11, -9223372036854775807L, Math.max(0, rendererOffset));
                if (periodPosition == null) {
                    return null;
                }
                obj = periodPosition.first;
                long longValue = ((Long) periodPosition.second).longValue();
                MediaPeriodHolder next = mediaPeriodHolder.getNext();
                if (next == null || !next.uid.equals(obj)) {
                    j14 = this.nextWindowSequenceNumber;
                    this.nextWindowSequenceNumber = 1 + j14;
                } else {
                    j14 = next.info.f65678id.windowSequenceNumber;
                }
                j12 = longValue;
                j13 = -9223372036854775807L;
            } else {
                j12 = 0;
            }
            return getMediaPeriodInfo(timeline, resolveMediaPeriodIdForAds(timeline, obj, j12, j14, this.period), j13, j12);
        }
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f65678id;
        timeline2.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            int i12 = mediaPeriodId.adGroupIndex;
            int adCountInAdGroup = this.period.getAdCountInAdGroup(i12);
            if (adCountInAdGroup == -1) {
                return null;
            }
            int nextAdIndexToPlay = this.period.getNextAdIndexToPlay(i12, mediaPeriodId.adIndexInAdGroup);
            if (nextAdIndexToPlay < adCountInAdGroup) {
                return getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, i12, nextAdIndexToPlay, mediaPeriodInfo.requestedContentPositionUs, mediaPeriodId.windowSequenceNumber);
            }
            long j15 = mediaPeriodInfo.requestedContentPositionUs;
            if (j15 == -9223372036854775807L) {
                Timeline.Window window2 = this.window;
                Timeline.Period period2 = this.period;
                Pair<Object, Long> periodPosition2 = timeline.getPeriodPosition(window2, period2, period2.windowIndex, -9223372036854775807L, Math.max(0, rendererOffset));
                if (periodPosition2 == null) {
                    return null;
                }
                j15 = ((Long) periodPosition2.second).longValue();
            }
            return getMediaPeriodInfoForContent(timeline, mediaPeriodId.periodUid, j15, mediaPeriodInfo.requestedContentPositionUs, mediaPeriodId.windowSequenceNumber);
        }
        int firstAdIndexToPlay = this.period.getFirstAdIndexToPlay(mediaPeriodId.nextAdGroupIndex);
        if (firstAdIndexToPlay == this.period.getAdCountInAdGroup(mediaPeriodId.nextAdGroupIndex)) {
            Object obj2 = mediaPeriodId.periodUid;
            long j16 = mediaPeriodInfo.durationUs;
            return getMediaPeriodInfoForContent(timeline, obj2, j16, j16, mediaPeriodId.windowSequenceNumber);
        }
        return getMediaPeriodInfoForAd(timeline, mediaPeriodId.periodUid, mediaPeriodId.nextAdGroupIndex, firstAdIndexToPlay, mediaPeriodInfo.durationUs, mediaPeriodId.windowSequenceNumber);
    }

    private MediaPeriodInfo getMediaPeriodInfo(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j11, long j12) {
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        Timeline timeline2 = timeline;
        timeline.getPeriodByUid(mediaPeriodId2.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            return getMediaPeriodInfoForAd(timeline, mediaPeriodId2.periodUid, mediaPeriodId2.adGroupIndex, mediaPeriodId2.adIndexInAdGroup, j11, mediaPeriodId2.windowSequenceNumber);
        }
        return getMediaPeriodInfoForContent(timeline, mediaPeriodId2.periodUid, j12, j11, mediaPeriodId2.windowSequenceNumber);
    }

    private MediaPeriodInfo getMediaPeriodInfoForAd(Timeline timeline, Object obj, int i11, int i12, long j11, long j12) {
        int i13 = i12;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i11, i13, j12);
        long adDurationUs = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        long adResumePositionUs = i13 == this.period.getFirstAdIndexToPlay(i11) ? this.period.getAdResumePositionUs() : 0;
        return new MediaPeriodInfo(mediaPeriodId, (adDurationUs == -9223372036854775807L || adResumePositionUs < adDurationUs) ? adResumePositionUs : Math.max(0, adDurationUs - 1), j11, -9223372036854775807L, adDurationUs, false, false, false);
    }

    private MediaPeriodInfo getMediaPeriodInfoForContent(Timeline timeline, Object obj, long j11, long j12, long j13) {
        long j14;
        Timeline timeline2 = timeline;
        Object obj2 = obj;
        long j15 = j11;
        timeline2.getPeriodByUid(obj2, this.period);
        int adGroupIndexAfterPositionUs = this.period.getAdGroupIndexAfterPositionUs(j15);
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj2, j13, adGroupIndexAfterPositionUs);
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId);
        boolean isLastInWindow = isLastInWindow(timeline2, mediaPeriodId);
        boolean isLastInTimeline = isLastInTimeline(timeline2, mediaPeriodId, isLastInPeriod);
        long adGroupTimeUs = adGroupIndexAfterPositionUs != -1 ? this.period.getAdGroupTimeUs(adGroupIndexAfterPositionUs) : -9223372036854775807L;
        if (adGroupTimeUs == -9223372036854775807L || adGroupTimeUs == Long.MIN_VALUE) {
            j14 = this.period.durationUs;
        } else {
            j14 = adGroupTimeUs;
        }
        if (j14 != -9223372036854775807L && j15 >= j14) {
            j15 = Math.max(0, j14 - 1);
        }
        return new MediaPeriodInfo(mediaPeriodId, j15, j12, adGroupTimeUs, j14, isLastInPeriod, isLastInWindow, isLastInTimeline);
    }

    private boolean isLastInPeriod(MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.isAd() && mediaPeriodId.nextAdGroupIndex == -1;
    }

    private boolean isLastInTimeline(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, boolean z11) {
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodId.periodUid);
        if (!timeline.getWindow(timeline.getPeriod(indexOfPeriod, this.period).windowIndex, this.window).isDynamic) {
            return timeline.isLastPeriod(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled) && z11;
        }
    }

    private boolean isLastInWindow(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (!isLastInPeriod(mediaPeriodId)) {
            return false;
        }
        int i11 = timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex;
        if (timeline.getWindow(i11, this.window).lastPeriodIndex == timeline.getIndexOfPeriod(mediaPeriodId.periodUid)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyQueueUpdate$0(ImmutableList.Builder builder, MediaSource.MediaPeriodId mediaPeriodId) {
        this.analyticsCollector.updateMediaPeriodQueueInfo(builder.build(), mediaPeriodId);
    }

    private void notifyQueueUpdate() {
        if (this.analyticsCollector != null) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (MediaPeriodHolder mediaPeriodHolder = this.playing; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.getNext()) {
                builder.add((Object) mediaPeriodHolder.info.f65678id);
            }
            MediaPeriodHolder mediaPeriodHolder2 = this.reading;
            this.analyticsCollectorHandler.post(new j0(this, builder, mediaPeriodHolder2 == null ? null : mediaPeriodHolder2.info.f65678id));
        }
    }

    private long resolvePeriodIndexToWindowSequenceNumber(Timeline timeline, Object obj) {
        int indexOfPeriod;
        int i11 = timeline.getPeriodByUid(obj, this.period).windowIndex;
        Object obj2 = this.oldFrontPeriodUid;
        if (obj2 != null && (indexOfPeriod = timeline.getIndexOfPeriod(obj2)) != -1 && timeline.getPeriod(indexOfPeriod, this.period).windowIndex == i11) {
            return this.oldFrontPeriodWindowSequenceNumber;
        }
        for (MediaPeriodHolder mediaPeriodHolder = this.playing; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.getNext()) {
            if (mediaPeriodHolder.uid.equals(obj)) {
                return mediaPeriodHolder.info.f65678id.windowSequenceNumber;
            }
        }
        for (MediaPeriodHolder mediaPeriodHolder2 = this.playing; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.getNext()) {
            int indexOfPeriod2 = timeline.getIndexOfPeriod(mediaPeriodHolder2.uid);
            if (indexOfPeriod2 != -1 && timeline.getPeriod(indexOfPeriod2, this.period).windowIndex == i11) {
                return mediaPeriodHolder2.info.f65678id.windowSequenceNumber;
            }
        }
        long j11 = this.nextWindowSequenceNumber;
        this.nextWindowSequenceNumber = 1 + j11;
        if (this.playing == null) {
            this.oldFrontPeriodUid = obj;
            this.oldFrontPeriodWindowSequenceNumber = j11;
        }
        return j11;
    }

    private boolean updateForPlaybackModeChange(Timeline timeline) {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder == null) {
            return true;
        }
        int indexOfPeriod = timeline.getIndexOfPeriod(mediaPeriodHolder.uid);
        while (true) {
            indexOfPeriod = timeline.getNextPeriodIndex(indexOfPeriod, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            while (mediaPeriodHolder.getNext() != null && !mediaPeriodHolder.info.isLastInTimelinePeriod) {
                mediaPeriodHolder = mediaPeriodHolder.getNext();
            }
            MediaPeriodHolder next = mediaPeriodHolder.getNext();
            if (indexOfPeriod == -1 || next == null || timeline.getIndexOfPeriod(next.uid) != indexOfPeriod) {
                boolean removeAfter = removeAfter(mediaPeriodHolder);
                mediaPeriodHolder.info = getUpdatedMediaPeriodInfo(timeline, mediaPeriodHolder.info);
            } else {
                mediaPeriodHolder = next;
            }
        }
        boolean removeAfter2 = removeAfter(mediaPeriodHolder);
        mediaPeriodHolder.info = getUpdatedMediaPeriodInfo(timeline, mediaPeriodHolder.info);
        return !removeAfter2;
    }

    public MediaPeriodHolder advancePlayingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.reading) {
            this.reading = mediaPeriodHolder.getNext();
        }
        this.playing.release();
        int i11 = this.length - 1;
        this.length = i11;
        if (i11 == 0) {
            this.loading = null;
            MediaPeriodHolder mediaPeriodHolder2 = this.playing;
            this.oldFrontPeriodUid = mediaPeriodHolder2.uid;
            this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder2.info.f65678id.windowSequenceNumber;
        }
        this.playing = this.playing.getNext();
        notifyQueueUpdate();
        return this.playing;
    }

    public MediaPeriodHolder advanceReadingPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.reading;
        Assertions.checkState((mediaPeriodHolder == null || mediaPeriodHolder.getNext() == null) ? false : true);
        this.reading = this.reading.getNext();
        notifyQueueUpdate();
        return this.reading;
    }

    public void clear() {
        if (this.length != 0) {
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.checkStateNotNull(this.playing);
            this.oldFrontPeriodUid = mediaPeriodHolder.uid;
            this.oldFrontPeriodWindowSequenceNumber = mediaPeriodHolder.info.f65678id.windowSequenceNumber;
            while (mediaPeriodHolder != null) {
                mediaPeriodHolder.release();
                mediaPeriodHolder = mediaPeriodHolder.getNext();
            }
            this.playing = null;
            this.loading = null;
            this.reading = null;
            this.length = 0;
            notifyQueueUpdate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        if (r1 != -9223372036854775807L) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.exoplayer2.MediaPeriodHolder enqueueNextMediaPeriodHolder(com.google.android.exoplayer2.RendererCapabilities[] r12, com.google.android.exoplayer2.trackselection.TrackSelector r13, com.google.android.exoplayer2.upstream.Allocator r14, com.google.android.exoplayer2.MediaSourceList r15, com.google.android.exoplayer2.MediaPeriodInfo r16, com.google.android.exoplayer2.trackselection.TrackSelectorResult r17) {
        /*
            r11 = this;
            r0 = r11
            r8 = r16
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r0.loading
            if (r1 != 0) goto L_0x001e
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r8.f65678id
            boolean r1 = r1.isAd()
            if (r1 == 0) goto L_0x001b
            long r1 = r8.requestedContentPositionUs
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x001b
            goto L_0x002c
        L_0x001b:
            r1 = 0
            goto L_0x002c
        L_0x001e:
            long r1 = r1.getRendererOffset()
            com.google.android.exoplayer2.MediaPeriodHolder r3 = r0.loading
            com.google.android.exoplayer2.MediaPeriodInfo r3 = r3.info
            long r3 = r3.durationUs
            long r1 = r1 + r3
            long r3 = r8.startPositionUs
            long r1 = r1 - r3
        L_0x002c:
            r3 = r1
            com.google.android.exoplayer2.MediaPeriodHolder r10 = new com.google.android.exoplayer2.MediaPeriodHolder
            r1 = r10
            r2 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r1.<init>(r2, r3, r5, r6, r7, r8, r9)
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r0.loading
            if (r1 == 0) goto L_0x0043
            r1.setNext(r10)
            goto L_0x0047
        L_0x0043:
            r0.playing = r10
            r0.reading = r10
        L_0x0047:
            r1 = 0
            r0.oldFrontPeriodUid = r1
            r0.loading = r10
            int r1 = r0.length
            int r1 = r1 + 1
            r0.length = r1
            r11.notifyQueueUpdate()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.MediaPeriodQueue.enqueueNextMediaPeriodHolder(com.google.android.exoplayer2.RendererCapabilities[], com.google.android.exoplayer2.trackselection.TrackSelector, com.google.android.exoplayer2.upstream.Allocator, com.google.android.exoplayer2.MediaSourceList, com.google.android.exoplayer2.MediaPeriodInfo, com.google.android.exoplayer2.trackselection.TrackSelectorResult):com.google.android.exoplayer2.MediaPeriodHolder");
    }

    public MediaPeriodHolder getLoadingPeriod() {
        return this.loading;
    }

    public MediaPeriodInfo getNextMediaPeriodInfo(long j11, PlaybackInfo playbackInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder == null) {
            return getFirstMediaPeriodInfo(playbackInfo);
        }
        return getFollowingMediaPeriodInfo(playbackInfo.timeline, mediaPeriodHolder, j11);
    }

    public MediaPeriodHolder getPlayingPeriod() {
        return this.playing;
    }

    public MediaPeriodHolder getReadingPeriod() {
        return this.reading;
    }

    public MediaPeriodInfo getUpdatedMediaPeriodInfo(Timeline timeline, MediaPeriodInfo mediaPeriodInfo) {
        long j11;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f65678id;
        boolean isLastInPeriod = isLastInPeriod(mediaPeriodId);
        boolean isLastInWindow = isLastInWindow(timeline, mediaPeriodId);
        boolean isLastInTimeline = isLastInTimeline(timeline, mediaPeriodId, isLastInPeriod);
        timeline.getPeriodByUid(mediaPeriodInfo.f65678id.periodUid, this.period);
        if (mediaPeriodId.isAd()) {
            j11 = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
        } else {
            j11 = mediaPeriodInfo.endPositionUs;
            if (j11 == -9223372036854775807L || j11 == Long.MIN_VALUE) {
                j11 = this.period.getDurationUs();
            }
        }
        return new MediaPeriodInfo(mediaPeriodId, mediaPeriodInfo.startPositionUs, mediaPeriodInfo.requestedContentPositionUs, mediaPeriodInfo.endPositionUs, j11, isLastInPeriod, isLastInWindow, isLastInTimeline);
    }

    public boolean isLoading(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder != null && mediaPeriodHolder.mediaPeriod == mediaPeriod;
    }

    public void reevaluateBuffer(long j11) {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.reevaluateBuffer(j11);
        }
    }

    public boolean removeAfter(MediaPeriodHolder mediaPeriodHolder) {
        boolean z11 = false;
        Assertions.checkState(mediaPeriodHolder != null);
        if (mediaPeriodHolder.equals(this.loading)) {
            return false;
        }
        this.loading = mediaPeriodHolder;
        while (mediaPeriodHolder.getNext() != null) {
            mediaPeriodHolder = mediaPeriodHolder.getNext();
            if (mediaPeriodHolder == this.reading) {
                this.reading = this.playing;
                z11 = true;
            }
            mediaPeriodHolder.release();
            this.length--;
        }
        this.loading.setNext((MediaPeriodHolder) null);
        notifyQueueUpdate();
        return z11;
    }

    public MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object obj, long j11) {
        return resolveMediaPeriodIdForAds(timeline, obj, j11, resolvePeriodIndexToWindowSequenceNumber(timeline, obj), this.period);
    }

    public boolean shouldLoadNextMediaPeriod() {
        MediaPeriodHolder mediaPeriodHolder = this.loading;
        return mediaPeriodHolder == null || (!mediaPeriodHolder.info.isFinal && mediaPeriodHolder.isFullyBuffered() && this.loading.info.durationUs != -9223372036854775807L && this.length < 100);
    }

    public boolean updateQueuedPeriods(Timeline timeline, long j11, long j12) {
        MediaPeriodInfo mediaPeriodInfo;
        long j13;
        MediaPeriodHolder mediaPeriodHolder = this.playing;
        MediaPeriodHolder mediaPeriodHolder2 = null;
        while (mediaPeriodHolder != null) {
            MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.info;
            if (mediaPeriodHolder2 == null) {
                mediaPeriodInfo = getUpdatedMediaPeriodInfo(timeline, mediaPeriodInfo2);
            } else {
                MediaPeriodInfo followingMediaPeriodInfo = getFollowingMediaPeriodInfo(timeline, mediaPeriodHolder2, j11);
                if (followingMediaPeriodInfo == null) {
                    return !removeAfter(mediaPeriodHolder2);
                }
                if (!canKeepMediaPeriodHolder(mediaPeriodInfo2, followingMediaPeriodInfo)) {
                    return !removeAfter(mediaPeriodHolder2);
                }
                mediaPeriodInfo = followingMediaPeriodInfo;
            }
            mediaPeriodHolder.info = mediaPeriodInfo.copyWithRequestedContentPositionUs(mediaPeriodInfo2.requestedContentPositionUs);
            if (!areDurationsCompatible(mediaPeriodInfo2.durationUs, mediaPeriodInfo.durationUs)) {
                long j14 = mediaPeriodInfo.durationUs;
                if (j14 == -9223372036854775807L) {
                    j13 = Long.MAX_VALUE;
                } else {
                    j13 = mediaPeriodHolder.toRendererTime(j14);
                }
                boolean z11 = mediaPeriodHolder == this.reading && (j12 == Long.MIN_VALUE || j12 >= j13);
                if (removeAfter(mediaPeriodHolder) || z11) {
                    return false;
                }
                return true;
            }
            mediaPeriodHolder2 = mediaPeriodHolder;
            mediaPeriodHolder = mediaPeriodHolder.getNext();
        }
        return true;
    }

    public boolean updateRepeatMode(Timeline timeline, int i11) {
        this.repeatMode = i11;
        return updateForPlaybackModeChange(timeline);
    }

    public boolean updateShuffleModeEnabled(Timeline timeline, boolean z11) {
        this.shuffleModeEnabled = z11;
        return updateForPlaybackModeChange(timeline);
    }

    private static MediaSource.MediaPeriodId resolveMediaPeriodIdForAds(Timeline timeline, Object obj, long j11, long j12, Timeline.Period period2) {
        timeline.getPeriodByUid(obj, period2);
        int adGroupIndexForPositionUs = period2.getAdGroupIndexForPositionUs(j11);
        if (adGroupIndexForPositionUs == -1) {
            return new MediaSource.MediaPeriodId(obj, j12, period2.getAdGroupIndexAfterPositionUs(j11));
        }
        return new MediaSource.MediaPeriodId(obj, adGroupIndexForPositionUs, period2.getFirstAdIndexToPlay(adGroupIndexForPositionUs), j12);
    }
}
