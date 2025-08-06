package com.google.android.exoplayer2.analytics;

import android.os.Looper;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.c;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.b;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n0;
import com.google.android.exoplayer2.o0;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ExoFlags;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.a;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class AnalyticsCollector implements Player.Listener, AudioRendererEventListener, VideoRendererEventListener, MediaSourceEventListener, BandwidthMeter.EventListener, DrmSessionEventListener {
    private final Clock clock;
    private final SparseArray<AnalyticsListener.EventTime> eventTimes;
    private boolean isSeeking;
    private ListenerSet<AnalyticsListener> listeners;
    private final MediaPeriodQueueTracker mediaPeriodQueueTracker;
    private final Timeline.Period period;
    private Player player;
    private final Timeline.Window window = new Timeline.Window();

    public static final class MediaPeriodQueueTracker {
        private MediaSource.MediaPeriodId currentPlayerMediaPeriod;
        /* access modifiers changed from: private */
        public ImmutableList<MediaSource.MediaPeriodId> mediaPeriodQueue = ImmutableList.of();
        private ImmutableMap<MediaSource.MediaPeriodId, Timeline> mediaPeriodTimelines = ImmutableMap.of();
        private final Timeline.Period period;
        private MediaSource.MediaPeriodId playingMediaPeriod;
        private MediaSource.MediaPeriodId readingMediaPeriod;

        public MediaPeriodQueueTracker(Timeline.Period period2) {
            this.period = period2;
        }

        private void addTimelineForMediaPeriodId(ImmutableMap.Builder<MediaSource.MediaPeriodId, Timeline> builder, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId != null) {
                if (timeline.getIndexOfPeriod(mediaPeriodId.periodUid) != -1) {
                    builder.put(mediaPeriodId, timeline);
                    return;
                }
                Timeline timeline2 = this.mediaPeriodTimelines.get(mediaPeriodId);
                if (timeline2 != null) {
                    builder.put(mediaPeriodId, timeline2);
                }
            }
        }

        private static MediaSource.MediaPeriodId findCurrentPlayerMediaPeriodInQueue(Player player, ImmutableList<MediaSource.MediaPeriodId> immutableList, MediaSource.MediaPeriodId mediaPeriodId, Timeline.Period period2) {
            Timeline currentTimeline = player.getCurrentTimeline();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(currentPeriodIndex);
            int adGroupIndexAfterPositionUs = (player.isPlayingAd() || currentTimeline.isEmpty()) ? -1 : currentTimeline.getPeriod(currentPeriodIndex, period2).getAdGroupIndexAfterPositionUs(C.msToUs(player.getCurrentPosition()) - period2.getPositionInWindowUs());
            for (int i11 = 0; i11 < immutableList.size(); i11++) {
                MediaSource.MediaPeriodId mediaPeriodId2 = immutableList.get(i11);
                if (isMatchingMediaPeriod(mediaPeriodId2, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId2;
                }
            }
            if (immutableList.isEmpty() && mediaPeriodId != null) {
                if (isMatchingMediaPeriod(mediaPeriodId, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId;
                }
            }
            return null;
        }

        private static boolean isMatchingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Object obj, boolean z11, int i11, int i12, int i13) {
            if (!mediaPeriodId.periodUid.equals(obj)) {
                return false;
            }
            if ((z11 && mediaPeriodId.adGroupIndex == i11 && mediaPeriodId.adIndexInAdGroup == i12) || (!z11 && mediaPeriodId.adGroupIndex == -1 && mediaPeriodId.nextAdGroupIndex == i13)) {
                return true;
            }
            return false;
        }

        private void updateMediaPeriodTimelines(Timeline timeline) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            if (this.mediaPeriodQueue.isEmpty()) {
                addTimelineForMediaPeriodId(builder, this.playingMediaPeriod, timeline);
                if (!Objects.equal(this.readingMediaPeriod, this.playingMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.readingMediaPeriod, timeline);
                }
                if (!Objects.equal(this.currentPlayerMediaPeriod, this.playingMediaPeriod) && !Objects.equal(this.currentPlayerMediaPeriod, this.readingMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.currentPlayerMediaPeriod, timeline);
                }
            } else {
                for (int i11 = 0; i11 < this.mediaPeriodQueue.size(); i11++) {
                    addTimelineForMediaPeriodId(builder, this.mediaPeriodQueue.get(i11), timeline);
                }
                if (!this.mediaPeriodQueue.contains(this.currentPlayerMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.currentPlayerMediaPeriod, timeline);
                }
            }
            this.mediaPeriodTimelines = builder.build();
        }

        public MediaSource.MediaPeriodId getCurrentPlayerMediaPeriod() {
            return this.currentPlayerMediaPeriod;
        }

        public MediaSource.MediaPeriodId getLoadingMediaPeriod() {
            if (this.mediaPeriodQueue.isEmpty()) {
                return null;
            }
            return (MediaSource.MediaPeriodId) Iterables.getLast(this.mediaPeriodQueue);
        }

        public Timeline getMediaPeriodIdTimeline(MediaSource.MediaPeriodId mediaPeriodId) {
            return this.mediaPeriodTimelines.get(mediaPeriodId);
        }

        public MediaSource.MediaPeriodId getPlayingMediaPeriod() {
            return this.playingMediaPeriod;
        }

        public MediaSource.MediaPeriodId getReadingMediaPeriod() {
            return this.readingMediaPeriod;
        }

        public void onPositionDiscontinuity(Player player) {
            this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
        }

        public void onQueueUpdated(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            this.mediaPeriodQueue = ImmutableList.copyOf(list);
            if (!list.isEmpty()) {
                this.playingMediaPeriod = list.get(0);
                this.readingMediaPeriod = (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId);
            }
            if (this.currentPlayerMediaPeriod == null) {
                this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
            }
            updateMediaPeriodTimelines(player.getCurrentTimeline());
        }

        public void onTimelineChanged(Player player) {
            this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
            updateMediaPeriodTimelines(player.getCurrentTimeline());
        }
    }

    public AnalyticsCollector(Clock clock2) {
        this.clock = (Clock) Assertions.checkNotNull(clock2);
        this.listeners = new ListenerSet<>(Util.getCurrentOrMainLooper(), clock2, b1.f65695a);
        Timeline.Period period2 = new Timeline.Period();
        this.period = period2;
        this.mediaPeriodQueueTracker = new MediaPeriodQueueTracker(period2);
        this.eventTimes = new SparseArray<>();
    }

    private AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getLoadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateMediaPeriodEventTime(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.player);
        boolean z11 = true;
        if (mediaPeriodId != null) {
            if (this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline(mediaPeriodId) == null) {
                z11 = false;
            }
            if (z11) {
                return generateEventTime(mediaPeriodId);
            }
            return generateEventTime(Timeline.EMPTY, i11, mediaPeriodId);
        }
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (i11 >= currentTimeline.getWindowCount()) {
            z11 = false;
        }
        if (!z11) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, i11, (MediaSource.MediaPeriodId) null);
    }

    private AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getPlayingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateReadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getReadingMediaPeriod());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0(AnalyticsListener analyticsListener, ExoFlags exoFlags) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onAudioDecoderInitialized$6(AnalyticsListener.EventTime eventTime, String str, long j11, long j12, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDecoderInitialized(eventTime, str, j11);
        long j13 = j11;
        analyticsListener.onAudioDecoderInitialized(eventTime, str, j12, j13);
        analyticsListener.onDecoderInitialized(eventTime, 1, str, j13);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onAudioDisabled$11(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDisabled(eventTime, decoderCounters);
        analyticsListener.onDecoderDisabled(eventTime, 1, decoderCounters);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onAudioEnabled$5(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioEnabled(eventTime, decoderCounters);
        analyticsListener.onDecoderEnabled(eventTime, 1, decoderCounters);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onAudioInputFormatChanged$7(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioInputFormatChanged(eventTime, format);
        analyticsListener.onAudioInputFormatChanged(eventTime, format, decoderReuseEvaluation);
        analyticsListener.onDecoderInputFormatChanged(eventTime, 1, format);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onDrmSessionAcquired$53(AnalyticsListener.EventTime eventTime, int i11, AnalyticsListener analyticsListener) {
        analyticsListener.onDrmSessionAcquired(eventTime);
        analyticsListener.onDrmSessionAcquired(eventTime, i11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onIsLoadingChanged$39(AnalyticsListener.EventTime eventTime, boolean z11, AnalyticsListener analyticsListener) {
        analyticsListener.onLoadingChanged(eventTime, z11);
        analyticsListener.onIsLoadingChanged(eventTime, z11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onPositionDiscontinuity$48(AnalyticsListener.EventTime eventTime, int i11, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener analyticsListener) {
        analyticsListener.onPositionDiscontinuity(eventTime, i11);
        analyticsListener.onPositionDiscontinuity(eventTime, positionInfo, positionInfo2, i11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onVideoDecoderInitialized$19(AnalyticsListener.EventTime eventTime, String str, long j11, long j12, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDecoderInitialized(eventTime, str, j11);
        long j13 = j11;
        analyticsListener.onVideoDecoderInitialized(eventTime, str, j12, j13);
        analyticsListener.onDecoderInitialized(eventTime, 2, str, j13);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onVideoDisabled$23(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDisabled(eventTime, decoderCounters);
        analyticsListener.onDecoderDisabled(eventTime, 2, decoderCounters);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onVideoEnabled$18(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoEnabled(eventTime, decoderCounters);
        analyticsListener.onDecoderEnabled(eventTime, 2, decoderCounters);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onVideoInputFormatChanged$20(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoInputFormatChanged(eventTime, format);
        analyticsListener.onVideoInputFormatChanged(eventTime, format, decoderReuseEvaluation);
        analyticsListener.onDecoderInputFormatChanged(eventTime, 2, format);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onVideoSizeChanged$24(AnalyticsListener.EventTime eventTime, VideoSize videoSize, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoSizeChanged(eventTime, videoSize);
        analyticsListener.onVideoSizeChanged(eventTime, videoSize.width, videoSize.height, videoSize.unappliedRotationDegrees, videoSize.pixelWidthHeightRatio);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setPlayer$1(Player player2, AnalyticsListener analyticsListener, ExoFlags exoFlags) {
        analyticsListener.onEvents(player2, new AnalyticsListener.Events(exoFlags, this.eventTimes));
    }

    public void addListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.listeners.add(analyticsListener);
    }

    public final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod());
    }

    @RequiresNonNull({"player"})
    public final AnalyticsListener.EventTime generateEventTime(Timeline timeline, int i11, MediaSource.MediaPeriodId mediaPeriodId) {
        long j11;
        Timeline timeline2 = timeline;
        int i12 = i11;
        MediaSource.MediaPeriodId mediaPeriodId2 = timeline.isEmpty() ? null : mediaPeriodId;
        long elapsedRealtime = this.clock.elapsedRealtime();
        boolean z11 = true;
        boolean z12 = timeline2.equals(this.player.getCurrentTimeline()) && i12 == this.player.getCurrentWindowIndex();
        long j12 = 0;
        if (mediaPeriodId2 != null && mediaPeriodId2.isAd()) {
            if (!(z12 && this.player.getCurrentAdGroupIndex() == mediaPeriodId2.adGroupIndex && this.player.getCurrentAdIndexInAdGroup() == mediaPeriodId2.adIndexInAdGroup)) {
                z11 = false;
            }
            if (z11) {
                j12 = this.player.getCurrentPosition();
            }
        } else if (z12) {
            j11 = this.player.getContentPosition();
            return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i11, mediaPeriodId2, j11, this.player.getCurrentTimeline(), this.player.getCurrentWindowIndex(), this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
        } else if (!timeline.isEmpty()) {
            j12 = timeline2.getWindow(i12, this.window).getDefaultPositionMs();
        }
        j11 = j12;
        return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i11, mediaPeriodId2, j11, this.player.getCurrentTimeline(), this.player.getCurrentWindowIndex(), this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
    }

    public final void notifySeekStarted() {
        if (!this.isSeeking) {
            AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
            this.isSeeking = true;
            sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new d1(generateCurrentPlayerMediaPeriodEventTime));
        }
    }

    public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1016, new t(generateReadingMediaPeriodEventTime, audioAttributes));
    }

    public final void onAudioCodecError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_CODEC_ERROR, new m0(generateReadingMediaPeriodEventTime, exc));
    }

    public final void onAudioDecoderInitialized(String str, long j11, long j12) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1009, new r0(generateReadingMediaPeriodEventTime, str, j12, j11));
    }

    public final void onAudioDecoderReleased(String str) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1013, new o0(generateReadingMediaPeriodEventTime, str));
    }

    public final void onAudioDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1014, new x(generatePlayingMediaPeriodEventTime, decoderCounters));
    }

    public final void onAudioEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1008, new v(generateReadingMediaPeriodEventTime, decoderCounters));
    }

    public /* synthetic */ void onAudioInputFormatChanged(Format format) {
        c.f(this, format);
    }

    public final void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1010, new o(generateReadingMediaPeriodEventTime, format, decoderReuseEvaluation));
    }

    public final void onAudioPositionAdvancing(long j11) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1011, new k(generateReadingMediaPeriodEventTime, j11));
    }

    public final void onAudioSessionIdChanged(int i11) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1015, new c(generateReadingMediaPeriodEventTime, i11));
    }

    public final void onAudioSinkError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1018, new k0(generateReadingMediaPeriodEventTime, exc));
    }

    public final void onAudioUnderrun(int i11, long j11, long j12) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1012, new i(generateReadingMediaPeriodEventTime, i11, j11, j12));
    }

    public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
        n0.a(this, commands);
    }

    public final void onBandwidthSample(int i11, long j11, long j12) {
        AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime = generateLoadingMediaPeriodEventTime();
        sendEvent(generateLoadingMediaPeriodEventTime, 1006, new h(generateLoadingMediaPeriodEventTime, i11, j11, j12));
    }

    public /* synthetic */ void onCues(List list) {
        o0.a(this, list);
    }

    public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        b.a(this, deviceInfo);
    }

    public /* synthetic */ void onDeviceVolumeChanged(int i11, boolean z11) {
        b.b(this, i11, z11);
    }

    public final void onDownstreamFormatChanged(int i11, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1004, new f0(generateMediaPeriodEventTime, mediaLoadData));
    }

    public final void onDrmKeysLoaded(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1031, new a(generateMediaPeriodEventTime));
    }

    public final void onDrmKeysRemoved(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1034, new c1(generateMediaPeriodEventTime));
    }

    public final void onDrmKeysRestored(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1033, new l(generateMediaPeriodEventTime));
    }

    public /* synthetic */ void onDrmSessionAcquired(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
        j.d(this, i11, mediaPeriodId);
    }

    public final void onDrmSessionAcquired(int i11, MediaSource.MediaPeriodId mediaPeriodId, int i12) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1030, new b(generateMediaPeriodEventTime, i12));
    }

    public final void onDrmSessionManagerError(int i11, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1032, new l0(generateMediaPeriodEventTime, exc));
    }

    public final void onDrmSessionReleased(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1035, new s0(generateMediaPeriodEventTime));
    }

    public final void onDroppedFrames(int i11, long j11) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1023, new g(generatePlayingMediaPeriodEventTime, i11, j11));
    }

    public /* synthetic */ void onEvents(Player player2, Player.Events events) {
        n0.b(this, player2, events);
    }

    public final void onIsLoadingChanged(boolean z11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 4, new u0(generateCurrentPlayerMediaPeriodEventTime, z11));
    }

    public void onIsPlayingChanged(boolean z11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 8, new v0(generateCurrentPlayerMediaPeriodEventTime, z11));
    }

    public final void onLoadCanceled(int i11, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1002, new c0(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData));
    }

    public final void onLoadCompleted(int i11, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1001, new a0(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData));
    }

    public final void onLoadError(int i11, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1003, new d0(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData, iOException, z11));
    }

    public final void onLoadStarted(int i11, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1000, new b0(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData));
    }

    public /* synthetic */ void onLoadingChanged(boolean z11) {
        n0.e(this, z11);
    }

    public final void onMediaItemTransition(MediaItem mediaItem, int i11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 1, new q(generateCurrentPlayerMediaPeriodEventTime, mediaItem, i11));
    }

    public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 15, new r(generateCurrentPlayerMediaPeriodEventTime, mediaMetadata));
    }

    public final void onMetadata(Metadata metadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 1007, new z(generateCurrentPlayerMediaPeriodEventTime, metadata));
    }

    public final void onPlayWhenReadyChanged(boolean z11, int i11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 6, new y0(generateCurrentPlayerMediaPeriodEventTime, z11, i11));
    }

    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 13, new s(generateCurrentPlayerMediaPeriodEventTime, playbackParameters));
    }

    public final void onPlaybackStateChanged(int i11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 5, new g1(generateCurrentPlayerMediaPeriodEventTime, i11));
    }

    public final void onPlaybackSuppressionReasonChanged(int i11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 7, new f1(generateCurrentPlayerMediaPeriodEventTime, i11));
    }

    public final void onPlayerError(ExoPlaybackException exoPlaybackException) {
        AnalyticsListener.EventTime eventTime;
        MediaPeriodId mediaPeriodId = exoPlaybackException.mediaPeriodId;
        if (mediaPeriodId != null) {
            eventTime = generateEventTime(new MediaSource.MediaPeriodId(mediaPeriodId));
        } else {
            eventTime = generateCurrentPlayerMediaPeriodEventTime();
        }
        sendEvent(eventTime, 11, new n(eventTime, exoPlaybackException));
    }

    public final void onPlayerStateChanged(boolean z11, int i11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new z0(generateCurrentPlayerMediaPeriodEventTime, z11, i11));
    }

    public /* synthetic */ void onPositionDiscontinuity(int i11) {
        n0.n(this, i11);
    }

    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11) {
        if (i11 == 1) {
            this.isSeeking = false;
        }
        this.mediaPeriodQueueTracker.onPositionDiscontinuity((Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 12, new j(generateCurrentPlayerMediaPeriodEventTime, i11, positionInfo, positionInfo2));
    }

    public /* synthetic */ void onRenderedFirstFrame() {
        a.a(this);
    }

    public final void onRenderedFirstFrame(Object obj, long j11) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1027, new n0(generateReadingMediaPeriodEventTime, obj, j11));
    }

    public final void onRepeatModeChanged(int i11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 9, new e(generateCurrentPlayerMediaPeriodEventTime, i11));
    }

    public final void onSeekProcessed() {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new w(generateCurrentPlayerMediaPeriodEventTime));
    }

    public final void onShuffleModeEnabledChanged(boolean z11) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 10, new x0(generateCurrentPlayerMediaPeriodEventTime, z11));
    }

    public final void onSkipSilenceEnabledChanged(boolean z11) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1017, new w0(generateReadingMediaPeriodEventTime, z11));
    }

    public final void onStaticMetadataChanged(List<Metadata> list) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 3, new t0(generateCurrentPlayerMediaPeriodEventTime, list));
    }

    public void onSurfaceSizeChanged(int i11, int i12) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1029, new f(generateReadingMediaPeriodEventTime, i11, i12));
    }

    public final void onTimelineChanged(Timeline timeline, int i11) {
        this.mediaPeriodQueueTracker.onTimelineChanged((Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 0, new d(generateCurrentPlayerMediaPeriodEventTime, i11));
    }

    public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i11) {
        n0.u(this, timeline, obj, i11);
    }

    public final void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 2, new g0(generateCurrentPlayerMediaPeriodEventTime, trackGroupArray, trackSelectionArray));
    }

    public final void onUpstreamDiscarded(int i11, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i11, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1005, new e0(generateMediaPeriodEventTime, mediaLoadData));
    }

    public final void onVideoCodecError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1038, new j0(generateReadingMediaPeriodEventTime, exc));
    }

    public final void onVideoDecoderInitialized(String str, long j11, long j12) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1021, new q0(generateReadingMediaPeriodEventTime, str, j12, j11));
    }

    public final void onVideoDecoderReleased(String str) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1024, new p0(generateReadingMediaPeriodEventTime, str));
    }

    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1025, new y(generatePlayingMediaPeriodEventTime, decoderCounters));
    }

    public final void onVideoEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1020, new u(generateReadingMediaPeriodEventTime, decoderCounters));
    }

    public final void onVideoFrameProcessingOffset(long j11, int i11) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1026, new m(generatePlayingMediaPeriodEventTime, j11, i11));
    }

    public /* synthetic */ void onVideoInputFormatChanged(Format format) {
        com.google.android.exoplayer2.video.b.i(this, format);
    }

    public final void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1022, new p(generateReadingMediaPeriodEventTime, format, decoderReuseEvaluation));
    }

    public /* synthetic */ void onVideoSizeChanged(int i11, int i12, int i13, float f11) {
        a.c(this, i11, i12, i13, f11);
    }

    public final void onVideoSizeChanged(VideoSize videoSize) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1028, new i0(generateReadingMediaPeriodEventTime, videoSize));
    }

    public final void onVolumeChanged(float f11) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1019, new e1(generateReadingMediaPeriodEventTime, f11));
    }

    public void release() {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        this.eventTimes.put(AnalyticsListener.EVENT_PLAYER_RELEASED, generateCurrentPlayerMediaPeriodEventTime);
        this.listeners.lazyRelease(AnalyticsListener.EVENT_PLAYER_RELEASED, new h0(generateCurrentPlayerMediaPeriodEventTime));
    }

    public void removeListener(AnalyticsListener analyticsListener) {
        this.listeners.remove(analyticsListener);
    }

    public final void sendEvent(AnalyticsListener.EventTime eventTime, int i11, ListenerSet.Event<AnalyticsListener> event) {
        this.eventTimes.put(i11, eventTime);
        this.listeners.sendEvent(i11, event);
    }

    public void setPlayer(Player player2, Looper looper) {
        Assertions.checkState(this.player == null || this.mediaPeriodQueueTracker.mediaPeriodQueue.isEmpty());
        this.player = (Player) Assertions.checkNotNull(player2);
        this.listeners = this.listeners.copy(looper, new a1(this, player2));
    }

    public final void updateMediaPeriodQueueInfo(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onQueueUpdated(list, mediaPeriodId, (Player) Assertions.checkNotNull(this.player));
    }

    private AnalyticsListener.EventTime generateEventTime(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline;
        Assertions.checkNotNull(this.player);
        if (mediaPeriodId == null) {
            timeline = null;
        } else {
            timeline = this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline(mediaPeriodId);
        }
        if (mediaPeriodId != null && timeline != null) {
            return generateEventTime(timeline, timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, mediaPeriodId);
        }
        int currentWindowIndex = this.player.getCurrentWindowIndex();
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (!(currentWindowIndex < currentTimeline.getWindowCount())) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, currentWindowIndex, (MediaSource.MediaPeriodId) null);
    }
}
