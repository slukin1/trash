package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.DefaultMediaClock;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender {
    private static final int ACTIVE_INTERVAL_MS = 10;
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final long MIN_RENDERER_SLEEP_DURATION_MS = 2000;
    private static final int MSG_ADD_MEDIA_SOURCES = 18;
    private static final int MSG_ATTEMPT_RENDERER_ERROR_RECOVERY = 25;
    private static final int MSG_DO_SOME_WORK = 2;
    private static final int MSG_MOVE_MEDIA_SOURCES = 19;
    private static final int MSG_PERIOD_PREPARED = 8;
    private static final int MSG_PLAYBACK_PARAMETERS_CHANGED_INTERNAL = 16;
    private static final int MSG_PLAYLIST_UPDATE_REQUESTED = 22;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_REMOVE_MEDIA_SOURCES = 20;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEND_MESSAGE = 14;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
    private static final int MSG_SET_FOREGROUND_MODE = 13;
    private static final int MSG_SET_MEDIA_SOURCES = 17;
    private static final int MSG_SET_OFFLOAD_SCHEDULING_ENABLED = 24;
    private static final int MSG_SET_PAUSE_AT_END_OF_WINDOW = 23;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_REPEAT_MODE = 11;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 12;
    private static final int MSG_SET_SHUFFLE_ORDER = 21;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 9;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 10;
    private static final String TAG = "ExoPlayerImplInternal";
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private boolean deliverPendingMessageAtStartPositionRequired;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private int enabledRendererCount;
    private boolean foregroundMode;
    /* access modifiers changed from: private */
    public final HandlerWrapper handler;
    private final HandlerThread internalPlaybackThread;
    private boolean isRebuffering;
    private final LivePlaybackSpeedControl livePlaybackSpeedControl;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private final MediaSourceList mediaSourceList;
    private int nextPendingMessageIndexHint;
    private boolean offloadSchedulingEnabled;
    private boolean pauseAtEndOfWindow;
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private boolean pendingPauseAtEndOfPeriod;
    private ExoPlaybackException pendingRecoverableRendererError;
    private final Timeline.Period period;
    private PlaybackInfo playbackInfo;
    private PlaybackInfoUpdate playbackInfoUpdate;
    private final PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private final Looper playbackLooper;
    private final MediaPeriodQueue queue;
    private final long releaseTimeoutMs;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private int repeatMode;
    /* access modifiers changed from: private */
    public boolean requestForRendererSleep;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private long setForegroundModeTimeoutMs;
    private boolean shouldContinueLoading;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    public static final class MediaSourceListUpdateMessage {
        /* access modifiers changed from: private */
        public final List<MediaSourceList.MediaSourceHolder> mediaSourceHolders;
        /* access modifiers changed from: private */
        public final long positionUs;
        /* access modifiers changed from: private */
        public final ShuffleOrder shuffleOrder;
        /* access modifiers changed from: private */
        public final int windowIndex;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder2, int i11, long j11) {
            this.mediaSourceHolders = list;
            this.shuffleOrder = shuffleOrder2;
            this.windowIndex = i11;
            this.positionUs = j11;
        }
    }

    public static class MoveMediaItemsMessage {
        public final int fromIndex;
        public final int newFromIndex;
        public final ShuffleOrder shuffleOrder;
        public final int toIndex;

        public MoveMediaItemsMessage(int i11, int i12, int i13, ShuffleOrder shuffleOrder2) {
            this.fromIndex = i11;
            this.toIndex = i12;
            this.newFromIndex = i13;
            this.shuffleOrder = shuffleOrder2;
        }
    }

    public static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public void setResolvedPosition(int i11, long j11, Object obj) {
            this.resolvedPeriodIndex = i11;
            this.resolvedPeriodTimeUs = j11;
            this.resolvedPeriodUid = obj;
        }

        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            Object obj = this.resolvedPeriodUid;
            if ((obj == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i11 = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
            if (i11 != 0) {
                return i11;
            }
            return Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
        }
    }

    public static final class PlaybackInfoUpdate {
        public int discontinuityReason;
        /* access modifiers changed from: private */
        public boolean hasPendingChange;
        public boolean hasPlayWhenReadyChangeReason;
        public int operationAcks;
        public int playWhenReadyChangeReason;
        public PlaybackInfo playbackInfo;
        public boolean positionDiscontinuity;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo2) {
            this.playbackInfo = playbackInfo2;
        }

        public void incrementPendingOperationAcks(int i11) {
            this.hasPendingChange |= i11 > 0;
            this.operationAcks += i11;
        }

        public void setPlayWhenReadyChangeReason(int i11) {
            this.hasPendingChange = true;
            this.hasPlayWhenReadyChangeReason = true;
            this.playWhenReadyChangeReason = i11;
        }

        public void setPlaybackInfo(PlaybackInfo playbackInfo2) {
            this.hasPendingChange |= this.playbackInfo != playbackInfo2;
            this.playbackInfo = playbackInfo2;
        }

        public void setPositionDiscontinuity(int i11) {
            boolean z11 = true;
            if (!this.positionDiscontinuity || this.discontinuityReason == 5) {
                this.hasPendingChange = true;
                this.positionDiscontinuity = true;
                this.discontinuityReason = i11;
                return;
            }
            if (i11 != 5) {
                z11 = false;
            }
            Assertions.checkArgument(z11);
        }
    }

    public interface PlaybackInfoUpdateListener {
        void onPlaybackInfoUpdate(PlaybackInfoUpdate playbackInfoUpdate);
    }

    public static final class PositionUpdateForPlaylistChange {
        public final boolean endPlayback;
        public final boolean forceBufferingState;
        public final MediaSource.MediaPeriodId periodId;
        public final long periodPositionUs;
        public final long requestedContentPositionUs;
        public final boolean setTargetLiveOffset;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j11, long j12, boolean z11, boolean z12, boolean z13) {
            this.periodId = mediaPeriodId;
            this.periodPositionUs = j11;
            this.requestedContentPositionUs = j12;
            this.forceBufferingState = z11;
            this.endPlayback = z12;
            this.setTargetLiveOffset = z13;
        }
    }

    public static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline2, int i11, long j11) {
            this.timeline = timeline2;
            this.windowIndex = i11;
            this.windowPositionUs = j11;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector2, TrackSelectorResult trackSelectorResult, LoadControl loadControl2, BandwidthMeter bandwidthMeter2, int i11, boolean z11, AnalyticsCollector analyticsCollector, SeekParameters seekParameters2, LivePlaybackSpeedControl livePlaybackSpeedControl2, long j11, boolean z12, Looper looper, Clock clock2, PlaybackInfoUpdateListener playbackInfoUpdateListener2) {
        Renderer[] rendererArr2 = rendererArr;
        BandwidthMeter bandwidthMeter3 = bandwidthMeter2;
        AnalyticsCollector analyticsCollector2 = analyticsCollector;
        long j12 = j11;
        Clock clock3 = clock2;
        this.playbackInfoUpdateListener = playbackInfoUpdateListener2;
        this.renderers = rendererArr2;
        this.trackSelector = trackSelector2;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl2;
        this.bandwidthMeter = bandwidthMeter3;
        this.repeatMode = i11;
        this.shuffleModeEnabled = z11;
        this.seekParameters = seekParameters2;
        this.livePlaybackSpeedControl = livePlaybackSpeedControl2;
        this.releaseTimeoutMs = j12;
        this.setForegroundModeTimeoutMs = j12;
        this.pauseAtEndOfWindow = z12;
        this.clock = clock3;
        this.backBufferDurationUs = loadControl2.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl2.retainBackBufferFromKeyframe();
        PlaybackInfo createDummy = PlaybackInfo.createDummy(trackSelectorResult);
        this.playbackInfo = createDummy;
        this.playbackInfoUpdate = new PlaybackInfoUpdate(createDummy);
        this.rendererCapabilities = new RendererCapabilities[rendererArr2.length];
        for (int i12 = 0; i12 < rendererArr2.length; i12++) {
            rendererArr2[i12].setIndex(i12);
            this.rendererCapabilities[i12] = rendererArr2[i12].getCapabilities();
        }
        this.mediaClock = new DefaultMediaClock(this, clock3);
        this.pendingMessages = new ArrayList<>();
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector2.init(this, bandwidthMeter3);
        this.deliverPendingMessageAtStartPositionRequired = true;
        Handler handler2 = new Handler(looper);
        this.queue = new MediaPeriodQueue(analyticsCollector2, handler2);
        this.mediaSourceList = new MediaSourceList(this, analyticsCollector2, handler2);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.internalPlaybackThread = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.playbackLooper = looper2;
        this.handler = clock3.createHandler(looper2, this);
    }

    private void addMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i11) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList2 = this.mediaSourceList;
        if (i11 == -1) {
            i11 = mediaSourceList2.getSize();
        }
        handleMediaSourceListInfoRefreshed(mediaSourceList2.addMediaSources(i11, mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void attemptRendererErrorRecovery() throws ExoPlaybackException {
        seekToCurrentPosition(true);
    }

    private void deliverMessage(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (!playerMessage.isCanceled()) {
            try {
                playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
            } finally {
                playerMessage.markAsProcessed(true);
            }
        }
    }

    private void disableRenderer(Renderer renderer) throws ExoPlaybackException {
        if (isRendererEnabled(renderer)) {
            this.mediaClock.onRendererDisabled(renderer);
            ensureStopped(renderer);
            renderer.disable();
            this.enabledRendererCount--;
        }
    }

    private void doSomeWork() throws ExoPlaybackException, IOException {
        boolean z11;
        boolean z12;
        boolean z13;
        int i11;
        long uptimeMillis = this.clock.uptimeMillis();
        updatePeriods();
        int i12 = this.playbackInfo.playbackState;
        if (i12 == 1 || i12 == 4) {
            this.handler.removeMessages(2);
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod == null) {
            scheduleNextWork(uptimeMillis, 10);
            return;
        }
        TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        if (playingPeriod.prepared) {
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            z12 = true;
            z11 = true;
            int i13 = 0;
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (i13 >= rendererArr.length) {
                    break;
                }
                Renderer renderer = rendererArr[i13];
                if (isRendererEnabled(renderer)) {
                    renderer.render(this.rendererPositionUs, elapsedRealtime);
                    z12 = z12 && renderer.isEnded();
                    boolean z14 = playingPeriod.sampleStreams[i13] != renderer.getStream();
                    boolean z15 = z14 || (!z14 && renderer.hasReadStreamToEnd()) || renderer.isReady() || renderer.isEnded();
                    z11 = z11 && z15;
                    if (!z15) {
                        renderer.maybeThrowStreamError();
                    }
                }
                i13++;
            }
        } else {
            playingPeriod.mediaPeriod.maybeThrowPrepareError();
            z12 = true;
            z11 = true;
        }
        long j11 = playingPeriod.info.durationUs;
        boolean z16 = z12 && playingPeriod.prepared && (j11 == -9223372036854775807L || j11 <= this.playbackInfo.positionUs);
        if (z16 && this.pendingPauseAtEndOfPeriod) {
            this.pendingPauseAtEndOfPeriod = false;
            setPlayWhenReadyInternal(false, this.playbackInfo.playbackSuppressionReason, false, 5);
        }
        if (z16 && playingPeriod.info.isFinal) {
            setState(4);
            stopRenderers();
        } else if (this.playbackInfo.playbackState == 2 && shouldTransitionToReadyState(z11)) {
            setState(3);
            this.pendingRecoverableRendererError = null;
            if (shouldPlayWhenReady()) {
                startRenderers();
            }
        } else if (this.playbackInfo.playbackState == 3 && (this.enabledRendererCount != 0 ? !z11 : !isTimelineReady())) {
            this.isRebuffering = shouldPlayWhenReady();
            setState(2);
            if (this.isRebuffering) {
                notifyTrackSelectionRebuffer();
                this.livePlaybackSpeedControl.notifyRebuffer();
            }
            stopRenderers();
        }
        if (this.playbackInfo.playbackState == 2) {
            int i14 = 0;
            while (true) {
                Renderer[] rendererArr2 = this.renderers;
                if (i14 >= rendererArr2.length) {
                    break;
                }
                if (isRendererEnabled(rendererArr2[i14]) && this.renderers[i14].getStream() == playingPeriod.sampleStreams[i14]) {
                    this.renderers[i14].maybeThrowStreamError();
                }
                i14++;
            }
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            if (!playbackInfo2.isLoading && playbackInfo2.totalBufferedDurationUs < 500000 && isLoadingPossible()) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        }
        boolean z17 = this.offloadSchedulingEnabled;
        PlaybackInfo playbackInfo3 = this.playbackInfo;
        if (z17 != playbackInfo3.offloadSchedulingEnabled) {
            this.playbackInfo = playbackInfo3.copyWithOffloadSchedulingEnabled(z17);
        }
        if ((!shouldPlayWhenReady() || this.playbackInfo.playbackState != 3) && (i11 = this.playbackInfo.playbackState) != 2) {
            if (this.enabledRendererCount == 0 || i11 == 4) {
                this.handler.removeMessages(2);
            } else {
                scheduleNextWork(uptimeMillis, 1000);
            }
            z13 = false;
        } else {
            z13 = !maybeScheduleWakeup(uptimeMillis, 10);
        }
        PlaybackInfo playbackInfo4 = this.playbackInfo;
        if (playbackInfo4.sleepingForOffload != z13) {
            this.playbackInfo = playbackInfo4.copyWithSleepingForOffload(z13);
        }
        this.requestForRendererSleep = false;
        TraceUtil.endSection();
    }

    private void enableRenderer(int i11, boolean z11) throws ExoPlaybackException {
        Renderer renderer = this.renderers[i11];
        if (!isRendererEnabled(renderer)) {
            MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
            boolean z12 = readingPeriod == this.queue.getPlayingPeriod();
            TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
            RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i11];
            Format[] formats = getFormats(trackSelectorResult.selections[i11]);
            boolean z13 = shouldPlayWhenReady() && this.playbackInfo.playbackState == 3;
            boolean z14 = !z11 && z13;
            this.enabledRendererCount++;
            renderer.enable(rendererConfiguration, formats, readingPeriod.sampleStreams[i11], this.rendererPositionUs, z14, z12, readingPeriod.getStartPositionRendererTime(), readingPeriod.getRendererOffset());
            renderer.handleMessage(103, new Renderer.WakeupListener() {
                public void onSleep(long j11) {
                    if (j11 >= 2000) {
                        boolean unused = ExoPlayerImplInternal.this.requestForRendererSleep = true;
                    }
                }

                public void onWakeup() {
                    ExoPlayerImplInternal.this.handler.sendEmptyMessage(2);
                }
            });
            this.mediaClock.onRendererEnabled(renderer);
            if (z13) {
                renderer.start();
            }
        }
    }

    private void enableRenderers() throws ExoPlaybackException {
        enableRenderers(new boolean[this.renderers.length]);
    }

    private void ensureStopped(Renderer renderer) throws ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private ImmutableList<Metadata> extractMetadataFromTrackSelectionArray(ExoTrackSelection[] exoTrackSelectionArr) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        boolean z11 = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Metadata metadata = exoTrackSelection.getFormat(0).metadata;
                if (metadata == null) {
                    builder.add((Object) new Metadata(new Metadata.Entry[0]));
                } else {
                    builder.add((Object) metadata);
                    z11 = true;
                }
            }
        }
        return z11 ? builder.build() : ImmutableList.of();
    }

    private long getCurrentLiveOffsetUs() {
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        return getLiveOffsetUs(playbackInfo2.timeline, playbackInfo2.periodId.periodUid, playbackInfo2.positionUs);
    }

    private static Format[] getFormats(ExoTrackSelection exoTrackSelection) {
        int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i11 = 0; i11 < length; i11++) {
            formatArr[i11] = exoTrackSelection.getFormat(i11);
        }
        return formatArr;
    }

    private long getLiveOffsetUs(Timeline timeline, Object obj, long j11) {
        timeline.getWindow(timeline.getPeriodByUid(obj, this.period).windowIndex, this.window);
        Timeline.Window window2 = this.window;
        if (window2.windowStartTimeMs != -9223372036854775807L && window2.isLive()) {
            Timeline.Window window3 = this.window;
            if (window3.isDynamic) {
                return C.msToUs(window3.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - (j11 + this.period.getPositionInWindowUs());
            }
        }
        return -9223372036854775807L;
    }

    private long getMaxRendererReadPositionUs() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return 0;
        }
        long rendererOffset = readingPeriod.getRendererOffset();
        if (!readingPeriod.prepared) {
            return rendererOffset;
        }
        int i11 = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i11 >= rendererArr.length) {
                return rendererOffset;
            }
            if (isRendererEnabled(rendererArr[i11]) && this.renderers[i11].getStream() == readingPeriod.sampleStreams[i11]) {
                long readingPositionUs = this.renderers[i11].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                rendererOffset = Math.max(readingPositionUs, rendererOffset);
            }
            i11++;
        }
    }

    private Pair<MediaSource.MediaPeriodId, Long> getPlaceholderFirstMediaPeriodPosition(Timeline timeline) {
        long j11 = 0;
        if (timeline.isEmpty()) {
            return Pair.create(PlaybackInfo.getDummyPeriodForEmptyTimeline(), 0L);
        }
        Timeline timeline2 = timeline;
        Pair<Object, Long> periodPosition = timeline2.getPeriodPosition(this.window, this.period, timeline.getFirstWindowIndex(this.shuffleModeEnabled), -9223372036854775807L);
        MediaSource.MediaPeriodId resolveMediaPeriodIdForAds = this.queue.resolveMediaPeriodIdForAds(timeline, periodPosition.first, 0);
        long longValue = ((Long) periodPosition.second).longValue();
        if (resolveMediaPeriodIdForAds.isAd()) {
            timeline.getPeriodByUid(resolveMediaPeriodIdForAds.periodUid, this.period);
            if (resolveMediaPeriodIdForAds.adIndexInAdGroup == this.period.getFirstAdIndexToPlay(resolveMediaPeriodIdForAds.adGroupIndex)) {
                j11 = this.period.getAdResumePositionUs();
            }
            longValue = j11;
        }
        return Pair.create(resolveMediaPeriodIdForAds, Long.valueOf(longValue));
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        }
    }

    private void handleLoadingMediaPeriodChanged(boolean z11) {
        long j11;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.f65678id;
        boolean z12 = !this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (z12) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (loadingPeriod == null) {
            j11 = playbackInfo2.positionUs;
        } else {
            j11 = loadingPeriod.getBufferedPositionUs();
        }
        playbackInfo2.bufferedPositionUs = j11;
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((z12 || z11) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0153 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x019f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleMediaSourceListInfoRefreshed(com.google.android.exoplayer2.Timeline r25, boolean r26) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r24 = this;
            r11 = r24
            r12 = r25
            com.google.android.exoplayer2.PlaybackInfo r2 = r11.playbackInfo
            com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition r3 = r11.pendingInitialSeekPosition
            com.google.android.exoplayer2.MediaPeriodQueue r4 = r11.queue
            int r5 = r11.repeatMode
            boolean r6 = r11.shuffleModeEnabled
            com.google.android.exoplayer2.Timeline$Window r7 = r11.window
            com.google.android.exoplayer2.Timeline$Period r8 = r11.period
            r1 = r25
            com.google.android.exoplayer2.ExoPlayerImplInternal$PositionUpdateForPlaylistChange r7 = resolvePositionForPlaylistChange(r1, r2, r3, r4, r5, r6, r7, r8)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r8 = r7.periodId
            long r9 = r7.requestedContentPositionUs
            boolean r0 = r7.forceBufferingState
            long r13 = r7.periodPositionUs
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r1.periodId
            boolean r1 = r1.equals(r8)
            r15 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0038
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            long r1 = r1.positionUs
            int r1 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            r16 = r5
            goto L_0x003a
        L_0x0038:
            r16 = r15
        L_0x003a:
            r17 = 3
            r6 = 0
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4 = 4
            boolean r1 = r7.endPlayback     // Catch:{ all -> 0x0124 }
            if (r1 == 0) goto L_0x0053
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo     // Catch:{ all -> 0x0124 }
            int r1 = r1.playbackState     // Catch:{ all -> 0x0124 }
            if (r1 == r15) goto L_0x0050
            r11.setState(r4)     // Catch:{ all -> 0x0124 }
        L_0x0050:
            r11.resetInternal(r5, r5, r5, r15)     // Catch:{ all -> 0x0124 }
        L_0x0053:
            if (r16 != 0) goto L_0x0075
            com.google.android.exoplayer2.MediaPeriodQueue r1 = r11.queue     // Catch:{ all -> 0x0124 }
            long r3 = r11.rendererPositionUs     // Catch:{ all -> 0x006f }
            long r21 = r24.getMaxRendererReadPositionUs()     // Catch:{ all -> 0x006f }
            r2 = r25
            r15 = -1
            r20 = 4
            r15 = r5
            r5 = r21
            boolean r0 = r1.updateQueuedPeriods(r2, r3, r5)     // Catch:{ all -> 0x0121 }
            if (r0 != 0) goto L_0x00a4
            r11.seekToCurrentPosition(r15)     // Catch:{ all -> 0x0121 }
            goto L_0x00a4
        L_0x006f:
            r0 = move-exception
            r15 = r5
            r20 = 4
            goto L_0x0128
        L_0x0075:
            r20 = r4
            r15 = r5
            boolean r1 = r25.isEmpty()     // Catch:{ all -> 0x0121 }
            if (r1 != 0) goto L_0x00a4
            com.google.android.exoplayer2.MediaPeriodQueue r1 = r11.queue     // Catch:{ all -> 0x0121 }
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r1.getPlayingPeriod()     // Catch:{ all -> 0x0121 }
        L_0x0084:
            if (r1 == 0) goto L_0x009f
            com.google.android.exoplayer2.MediaPeriodInfo r2 = r1.info     // Catch:{ all -> 0x0121 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r2.f65678id     // Catch:{ all -> 0x0121 }
            boolean r2 = r2.equals(r8)     // Catch:{ all -> 0x0121 }
            if (r2 == 0) goto L_0x009a
            com.google.android.exoplayer2.MediaPeriodQueue r2 = r11.queue     // Catch:{ all -> 0x0121 }
            com.google.android.exoplayer2.MediaPeriodInfo r3 = r1.info     // Catch:{ all -> 0x0121 }
            com.google.android.exoplayer2.MediaPeriodInfo r2 = r2.getUpdatedMediaPeriodInfo(r12, r3)     // Catch:{ all -> 0x0121 }
            r1.info = r2     // Catch:{ all -> 0x0121 }
        L_0x009a:
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r1.getNext()     // Catch:{ all -> 0x0121 }
            goto L_0x0084
        L_0x009f:
            long r0 = r11.seekToPeriodPosition(r8, r13, r0)     // Catch:{ all -> 0x0121 }
            r13 = r0
        L_0x00a4:
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r4 = r0.timeline
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r0.periodId
            boolean r0 = r7.setTargetLiveOffset
            if (r0 == 0) goto L_0x00b0
            r6 = r13
            goto L_0x00b2
        L_0x00b0:
            r6 = r18
        L_0x00b2:
            r1 = r24
            r2 = r25
            r3 = r8
            r1.updateLivePlaybackSpeedControl(r2, r3, r4, r5, r6)
            if (r16 != 0) goto L_0x00c4
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo
            long r0 = r0.requestedContentPositionUs
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0102
        L_0x00c4:
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r0.periodId
            java.lang.Object r1 = r1.periodUid
            com.google.android.exoplayer2.Timeline r0 = r0.timeline
            if (r16 == 0) goto L_0x00e3
            if (r26 == 0) goto L_0x00e3
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x00e3
            com.google.android.exoplayer2.Timeline$Period r2 = r11.period
            com.google.android.exoplayer2.Timeline$Period r0 = r0.getPeriodByUid(r1, r2)
            boolean r0 = r0.isPlaceholder
            if (r0 != 0) goto L_0x00e3
            r23 = 1
            goto L_0x00e5
        L_0x00e3:
            r23 = r15
        L_0x00e5:
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo
            long r5 = r0.discontinuityStartPositionUs
            int r0 = r12.getIndexOfPeriod(r1)
            r1 = -1
            if (r0 != r1) goto L_0x00f2
            r17 = r20
        L_0x00f2:
            r1 = r24
            r2 = r8
            r3 = r13
            r7 = r5
            r5 = r9
            r9 = r23
            r10 = r17
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.handlePositionDiscontinuity(r2, r3, r5, r7, r9, r10)
            r11.playbackInfo = r0
        L_0x0102:
            r24.resetPendingPauseAtEndOfPeriod()
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r0 = r0.timeline
            r11.resolvePendingMessagePositions(r12, r0)
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo
            com.google.android.exoplayer2.PlaybackInfo r0 = r0.copyWithTimeline(r12)
            r11.playbackInfo = r0
            boolean r0 = r25.isEmpty()
            if (r0 != 0) goto L_0x011d
            r6 = 0
            r11.pendingInitialSeekPosition = r6
        L_0x011d:
            r11.handleLoadingMediaPeriodChanged(r15)
            return
        L_0x0121:
            r0 = move-exception
            r6 = 0
            goto L_0x0128
        L_0x0124:
            r0 = move-exception
            r20 = r4
            r15 = r5
        L_0x0128:
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r4 = r1.timeline
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r1.periodId
            boolean r1 = r7.setTargetLiveOffset
            if (r1 == 0) goto L_0x0134
            r18 = r13
        L_0x0134:
            r1 = r24
            r2 = r25
            r3 = r8
            r15 = r6
            r6 = r18
            r1.updateLivePlaybackSpeedControl(r2, r3, r4, r5, r6)
            if (r16 != 0) goto L_0x0149
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            long r1 = r1.requestedContentPositionUs
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0187
        L_0x0149:
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r1.periodId
            java.lang.Object r2 = r2.periodUid
            com.google.android.exoplayer2.Timeline r1 = r1.timeline
            if (r16 == 0) goto L_0x0168
            if (r26 == 0) goto L_0x0168
            boolean r3 = r1.isEmpty()
            if (r3 != 0) goto L_0x0168
            com.google.android.exoplayer2.Timeline$Period r3 = r11.period
            com.google.android.exoplayer2.Timeline$Period r1 = r1.getPeriodByUid(r2, r3)
            boolean r1 = r1.isPlaceholder
            if (r1 != 0) goto L_0x0168
            r23 = 1
            goto L_0x016a
        L_0x0168:
            r23 = 0
        L_0x016a:
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            long r5 = r1.discontinuityStartPositionUs
            int r1 = r12.getIndexOfPeriod(r2)
            r2 = -1
            if (r1 != r2) goto L_0x0177
            r17 = r20
        L_0x0177:
            r1 = r24
            r2 = r8
            r3 = r13
            r7 = r5
            r5 = r9
            r9 = r23
            r10 = r17
            com.google.android.exoplayer2.PlaybackInfo r1 = r1.handlePositionDiscontinuity(r2, r3, r5, r7, r9, r10)
            r11.playbackInfo = r1
        L_0x0187:
            r24.resetPendingPauseAtEndOfPeriod()
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r1 = r1.timeline
            r11.resolvePendingMessagePositions(r12, r1)
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.PlaybackInfo r1 = r1.copyWithTimeline(r12)
            r11.playbackInfo = r1
            boolean r1 = r25.isEmpty()
            if (r1 != 0) goto L_0x01a1
            r11.pendingInitialSeekPosition = r15
        L_0x01a1:
            r1 = 0
            r11.handleLoadingMediaPeriodChanged(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.handleMediaSourceListInfoRefreshed(com.google.android.exoplayer2.Timeline, boolean):void");
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            loadingPeriod.handlePrepared(this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.timeline);
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
            if (loadingPeriod == this.queue.getPlayingPeriod()) {
                resetRendererPosition(loadingPeriod.info.startPositionUs);
                enableRenderers();
                PlaybackInfo playbackInfo2 = this.playbackInfo;
                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo2.periodId;
                long j11 = loadingPeriod.info.startPositionUs;
                this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, j11, playbackInfo2.requestedContentPositionUs, j11, false, 5);
            }
            maybeContinueLoading();
        }
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, boolean z11) throws ExoPlaybackException {
        handlePlaybackParameters(playbackParameters, playbackParameters.speed, true, z11);
    }

    private PlaybackInfo handlePositionDiscontinuity(MediaSource.MediaPeriodId mediaPeriodId, long j11, long j12, long j13, boolean z11, int i11) {
        ImmutableList<Metadata> immutableList;
        TrackSelectorResult trackSelectorResult;
        TrackGroupArray trackGroupArray;
        TrackGroupArray trackGroupArray2;
        TrackSelectorResult trackSelectorResult2;
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long j14 = j12;
        this.deliverPendingMessageAtStartPositionRequired = this.deliverPendingMessageAtStartPositionRequired || j11 != this.playbackInfo.positionUs || !mediaPeriodId.equals(this.playbackInfo.periodId);
        resetPendingPauseAtEndOfPeriod();
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        TrackGroupArray trackGroupArray3 = playbackInfo2.trackGroups;
        TrackSelectorResult trackSelectorResult3 = playbackInfo2.trackSelectorResult;
        List<Metadata> list = playbackInfo2.staticMetadata;
        if (this.mediaSourceList.isPrepared()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            if (playingPeriod == null) {
                trackGroupArray2 = TrackGroupArray.EMPTY;
            } else {
                trackGroupArray2 = playingPeriod.getTrackGroups();
            }
            if (playingPeriod == null) {
                trackSelectorResult2 = this.emptyTrackSelectorResult;
            } else {
                trackSelectorResult2 = playingPeriod.getTrackSelectorResult();
            }
            ImmutableList<Metadata> extractMetadataFromTrackSelectionArray = extractMetadataFromTrackSelectionArray(trackSelectorResult2.selections);
            if (playingPeriod != null) {
                MediaPeriodInfo mediaPeriodInfo = playingPeriod.info;
                if (mediaPeriodInfo.requestedContentPositionUs != j14) {
                    playingPeriod.info = mediaPeriodInfo.copyWithRequestedContentPositionUs(j14);
                }
            }
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
            immutableList = extractMetadataFromTrackSelectionArray;
        } else if (!mediaPeriodId.equals(this.playbackInfo.periodId)) {
            trackGroupArray = TrackGroupArray.EMPTY;
            trackSelectorResult = this.emptyTrackSelectorResult;
            immutableList = ImmutableList.of();
        } else {
            immutableList = list;
            trackGroupArray = trackGroupArray3;
            trackSelectorResult = trackSelectorResult3;
        }
        if (z11) {
            this.playbackInfoUpdate.setPositionDiscontinuity(i11);
        }
        return this.playbackInfo.copyWithNewPosition(mediaPeriodId, j11, j12, j13, getTotalBufferedDurationUs(), trackGroupArray, trackSelectorResult, immutableList);
    }

    private boolean hasReadingPeriodFinishedReading() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (!readingPeriod.prepared) {
            return false;
        }
        int i11 = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i11 >= rendererArr.length) {
                return true;
            }
            Renderer renderer = rendererArr[i11];
            SampleStream sampleStream = readingPeriod.sampleStreams[i11];
            if (renderer.getStream() != sampleStream || (sampleStream != null && !renderer.hasReadStreamToEnd())) {
                return false;
            }
            i11++;
        }
        return false;
    }

    private boolean isLoadingPossible() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null || loadingPeriod.getNextLoadPositionUs() == Long.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private static boolean isRendererEnabled(Renderer renderer) {
        return renderer.getState() != 0;
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        long j11 = playingPeriod.info.durationUs;
        return playingPeriod.prepared && (j11 == -9223372036854775807L || this.playbackInfo.positionUs < j11 || !shouldPlayWhenReady());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$release$0() {
        return Boolean.valueOf(this.released);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMessageToTargetThread$1(PlayerMessage playerMessage) {
        try {
            deliverMessage(playerMessage);
        } catch (ExoPlaybackException e11) {
            Log.e(TAG, "Unexpected error delivering message on external thread.", e11);
            throw new RuntimeException(e11);
        }
    }

    private void maybeContinueLoading() {
        boolean shouldContinueLoading2 = shouldContinueLoading();
        this.shouldContinueLoading = shouldContinueLoading2;
        if (shouldContinueLoading2) {
            this.queue.getLoadingPeriod().continueLoading(this.rendererPositionUs);
        }
        updateIsLoading();
    }

    private void maybeNotifyPlaybackInfoChanged() {
        this.playbackInfoUpdate.setPlaybackInfo(this.playbackInfo);
        if (this.playbackInfoUpdate.hasPendingChange) {
            this.playbackInfoUpdateListener.onPlaybackInfoUpdate(this.playbackInfoUpdate);
            this.playbackInfoUpdate = new PlaybackInfoUpdate(this.playbackInfo);
        }
    }

    private boolean maybeScheduleWakeup(long j11, long j12) {
        if (this.offloadSchedulingEnabled && this.requestForRendererSleep) {
            return false;
        }
        scheduleNextWork(j11, j12);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090 A[LOOP:1: B:24:0x0074->B:34:0x0090, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0062 A[EDGE_INSN: B:65:0x0062->B:20:0x0062 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0073 A[EDGE_INSN: B:72:0x0073->B:23:0x0073 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void maybeTriggerPendingMessages(long r8, long r10) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r7 = this;
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r0 = r7.pendingMessages
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00f7
            com.google.android.exoplayer2.PlaybackInfo r0 = r7.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.periodId
            boolean r0 = r0.isAd()
            if (r0 == 0) goto L_0x0014
            goto L_0x00f7
        L_0x0014:
            boolean r0 = r7.deliverPendingMessageAtStartPositionRequired
            if (r0 == 0) goto L_0x001e
            r0 = 1
            long r8 = r8 - r0
            r0 = 0
            r7.deliverPendingMessageAtStartPositionRequired = r0
        L_0x001e:
            com.google.android.exoplayer2.PlaybackInfo r0 = r7.playbackInfo
            com.google.android.exoplayer2.Timeline r1 = r0.timeline
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.periodId
            java.lang.Object r0 = r0.periodUid
            int r0 = r1.getIndexOfPeriod(r0)
            int r1 = r7.nextPendingMessageIndexHint
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r2 = r7.pendingMessages
            int r2 = r2.size()
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
            if (r1 <= 0) goto L_0x0044
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            int r4 = r1 + -1
            java.lang.Object r3 = r3.get(r4)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0045
        L_0x0044:
            r3 = r2
        L_0x0045:
            if (r3 == 0) goto L_0x0062
            int r4 = r3.resolvedPeriodIndex
            if (r4 > r0) goto L_0x0053
            if (r4 != r0) goto L_0x0062
            long r3 = r3.resolvedPeriodTimeUs
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x0062
        L_0x0053:
            int r1 = r1 + -1
            if (r1 <= 0) goto L_0x0044
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            int r4 = r1 + -1
            java.lang.Object r3 = r3.get(r4)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0045
        L_0x0062:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0073
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            java.lang.Object r3 = r3.get(r1)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0074
        L_0x0073:
            r3 = r2
        L_0x0074:
            if (r3 == 0) goto L_0x0099
            java.lang.Object r4 = r3.resolvedPeriodUid
            if (r4 == 0) goto L_0x0099
            int r4 = r3.resolvedPeriodIndex
            if (r4 < r0) goto L_0x0086
            if (r4 != r0) goto L_0x0099
            long r4 = r3.resolvedPeriodTimeUs
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0099
        L_0x0086:
            int r1 = r1 + 1
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0073
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            java.lang.Object r3 = r3.get(r1)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0074
        L_0x0099:
            if (r3 == 0) goto L_0x00f5
            java.lang.Object r4 = r3.resolvedPeriodUid
            if (r4 == 0) goto L_0x00f5
            int r4 = r3.resolvedPeriodIndex
            if (r4 != r0) goto L_0x00f5
            long r4 = r3.resolvedPeriodTimeUs
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x00f5
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 > 0) goto L_0x00f5
            com.google.android.exoplayer2.PlayerMessage r4 = r3.message     // Catch:{ all -> 0x00de }
            r7.sendMessageToTarget(r4)     // Catch:{ all -> 0x00de }
            com.google.android.exoplayer2.PlayerMessage r4 = r3.message
            boolean r4 = r4.getDeleteAfterDelivery()
            if (r4 != 0) goto L_0x00c6
            com.google.android.exoplayer2.PlayerMessage r3 = r3.message
            boolean r3 = r3.isCanceled()
            if (r3 == 0) goto L_0x00c3
            goto L_0x00c6
        L_0x00c3:
            int r1 = r1 + 1
            goto L_0x00cb
        L_0x00c6:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            r3.remove(r1)
        L_0x00cb:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x00dc
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r7.pendingMessages
            java.lang.Object r3 = r3.get(r1)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r3 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0099
        L_0x00dc:
            r3 = r2
            goto L_0x0099
        L_0x00de:
            r8 = move-exception
            com.google.android.exoplayer2.PlayerMessage r9 = r3.message
            boolean r9 = r9.getDeleteAfterDelivery()
            if (r9 != 0) goto L_0x00ef
            com.google.android.exoplayer2.PlayerMessage r9 = r3.message
            boolean r9 = r9.isCanceled()
            if (r9 == 0) goto L_0x00f4
        L_0x00ef:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r9 = r7.pendingMessages
            r9.remove(r1)
        L_0x00f4:
            throw r8
        L_0x00f5:
            r7.nextPendingMessageIndexHint = r1
        L_0x00f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.maybeTriggerPendingMessages(long, long):void");
    }

    private void maybeUpdateLoadingPeriod() throws ExoPlaybackException {
        MediaPeriodInfo nextMediaPeriodInfo;
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod() && (nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo)) != null) {
            MediaPeriodHolder enqueueNextMediaPeriodHolder = this.queue.enqueueNextMediaPeriodHolder(this.rendererCapabilities, this.trackSelector, this.loadControl.getAllocator(), this.mediaSourceList, nextMediaPeriodInfo, this.emptyTrackSelectorResult);
            enqueueNextMediaPeriodHolder.mediaPeriod.prepare(this, nextMediaPeriodInfo.startPositionUs);
            if (this.queue.getPlayingPeriod() == enqueueNextMediaPeriodHolder) {
                resetRendererPosition(enqueueNextMediaPeriodHolder.getStartPositionRendererTime());
            }
            handleLoadingMediaPeriodChanged(false);
        }
        if (this.shouldContinueLoading) {
            this.shouldContinueLoading = isLoadingPossible();
            updateIsLoading();
            return;
        }
        maybeContinueLoading();
    }

    private void maybeUpdatePlayingPeriod() throws ExoPlaybackException {
        boolean z11 = false;
        while (shouldAdvancePlayingPeriod()) {
            if (z11) {
                maybeNotifyPlaybackInfoChanged();
            }
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            MediaPeriodHolder advancePlayingPeriod = this.queue.advancePlayingPeriod();
            MediaPeriodInfo mediaPeriodInfo = advancePlayingPeriod.info;
            MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f65678id;
            long j11 = mediaPeriodInfo.startPositionUs;
            PlaybackInfo handlePositionDiscontinuity = handlePositionDiscontinuity(mediaPeriodId, j11, mediaPeriodInfo.requestedContentPositionUs, j11, true, 0);
            this.playbackInfo = handlePositionDiscontinuity;
            Timeline timeline = handlePositionDiscontinuity.timeline;
            updateLivePlaybackSpeedControl(timeline, advancePlayingPeriod.info.f65678id, timeline, playingPeriod.info.f65678id, -9223372036854775807L);
            resetPendingPauseAtEndOfPeriod();
            updatePlaybackPositions();
            z11 = true;
        }
    }

    private void maybeUpdateReadingPeriod() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod != null) {
            int i11 = 0;
            if (readingPeriod.getNext() == null || this.pendingPauseAtEndOfPeriod) {
                if (readingPeriod.info.isFinal || this.pendingPauseAtEndOfPeriod) {
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i11 < rendererArr.length) {
                            Renderer renderer = rendererArr[i11];
                            SampleStream sampleStream = readingPeriod.sampleStreams[i11];
                            if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                                long j11 = readingPeriod.info.durationUs;
                                setCurrentStreamFinal(renderer, (j11 == -9223372036854775807L || j11 == Long.MIN_VALUE) ? -9223372036854775807L : readingPeriod.getRendererOffset() + readingPeriod.info.durationUs);
                            }
                            i11++;
                        } else {
                            return;
                        }
                    }
                }
            } else if (hasReadingPeriodFinishedReading()) {
                if (readingPeriod.getNext().prepared || this.rendererPositionUs >= readingPeriod.getNext().getStartPositionRendererTime()) {
                    TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
                    MediaPeriodHolder advanceReadingPeriod = this.queue.advanceReadingPeriod();
                    TrackSelectorResult trackSelectorResult2 = advanceReadingPeriod.getTrackSelectorResult();
                    if (!advanceReadingPeriod.prepared || advanceReadingPeriod.mediaPeriod.readDiscontinuity() == -9223372036854775807L) {
                        for (int i12 = 0; i12 < this.renderers.length; i12++) {
                            boolean isRendererEnabled = trackSelectorResult.isRendererEnabled(i12);
                            boolean isRendererEnabled2 = trackSelectorResult2.isRendererEnabled(i12);
                            if (isRendererEnabled && !this.renderers[i12].isCurrentStreamFinal()) {
                                boolean z11 = this.rendererCapabilities[i12].getTrackType() == 7;
                                RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i12];
                                RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i12];
                                if (!isRendererEnabled2 || !rendererConfiguration2.equals(rendererConfiguration) || z11) {
                                    setCurrentStreamFinal(this.renderers[i12], advanceReadingPeriod.getStartPositionRendererTime());
                                }
                            }
                        }
                        return;
                    }
                    setAllRendererStreamsFinal(advanceReadingPeriod.getStartPositionRendererTime());
                }
            }
        }
    }

    private void maybeUpdateReadingRenderers() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod != null && this.queue.getPlayingPeriod() != readingPeriod && !readingPeriod.allRenderersInCorrectState && replaceStreamsOrDisableRendererForTransition()) {
            enableRenderers();
        }
    }

    private void mediaSourceListUpdateRequestedInternal() throws ExoPlaybackException {
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.createTimeline(), true);
    }

    private void moveMediaItemsInternal(MoveMediaItemsMessage moveMediaItemsMessage) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.moveMediaSourceRange(moveMediaItemsMessage.fromIndex, moveMediaItemsMessage.toIndex, moveMediaItemsMessage.newFromIndex, moveMediaItemsMessage.shuffleOrder), false);
    }

    private void notifyTrackSelectionDiscontinuity() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onDiscontinuity();
                }
            }
        }
    }

    private void notifyTrackSelectionPlayWhenReadyChanged(boolean z11) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlayWhenReadyChanged(z11);
                }
            }
        }
    }

    private void notifyTrackSelectionRebuffer() {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onRebuffer();
                }
            }
        }
    }

    private void prepareInternal() {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        resetInternal(false, false, false, true);
        this.loadControl.onPrepared();
        setState(this.playbackInfo.timeline.isEmpty() ? 4 : 2);
        this.mediaSourceList.prepare(this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void releaseInternal() {
        resetInternal(true, false, true, false);
        this.loadControl.onReleased();
        setState(1);
        this.internalPlaybackThread.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    private void removeMediaItemsInternal(int i11, int i12, ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.removeMediaSourceRange(i11, i12, shuffleOrder), false);
    }

    private boolean replaceStreamsOrDisableRendererForTransition() throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        int i11 = 0;
        boolean z11 = false;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i11 >= rendererArr.length) {
                return !z11;
            }
            Renderer renderer = rendererArr[i11];
            if (isRendererEnabled(renderer)) {
                boolean z12 = renderer.getStream() != readingPeriod.sampleStreams[i11];
                if (!trackSelectorResult.isRendererEnabled(i11) || z12) {
                    if (!renderer.isCurrentStreamFinal()) {
                        renderer.replaceStream(getFormats(trackSelectorResult.selections[i11]), readingPeriod.sampleStreams[i11], readingPeriod.getStartPositionRendererTime(), readingPeriod.getRendererOffset());
                    } else if (renderer.isEnded()) {
                        disableRenderer(renderer);
                    } else {
                        z11 = true;
                    }
                }
            }
            i11++;
        }
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        float f11 = this.mediaClock.getPlaybackParameters().speed;
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        boolean z11 = true;
        while (playingPeriod != null && playingPeriod.prepared) {
            TrackSelectorResult selectTracks = playingPeriod.selectTracks(f11, this.playbackInfo.timeline);
            if (!selectTracks.isEquivalent(playingPeriod.getTrackSelectorResult())) {
                if (z11) {
                    MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                    boolean removeAfter = this.queue.removeAfter(playingPeriod2);
                    boolean[] zArr = new boolean[this.renderers.length];
                    long applyTrackSelection = playingPeriod2.applyTrackSelection(selectTracks, this.playbackInfo.positionUs, removeAfter, zArr);
                    PlaybackInfo playbackInfo2 = this.playbackInfo;
                    boolean z12 = (playbackInfo2.playbackState == 4 || applyTrackSelection == playbackInfo2.positionUs) ? false : true;
                    PlaybackInfo playbackInfo3 = this.playbackInfo;
                    MediaPeriodHolder mediaPeriodHolder = playingPeriod2;
                    boolean[] zArr2 = zArr;
                    this.playbackInfo = handlePositionDiscontinuity(playbackInfo3.periodId, applyTrackSelection, playbackInfo3.requestedContentPositionUs, playbackInfo3.discontinuityStartPositionUs, z12, 5);
                    if (z12) {
                        resetRendererPosition(applyTrackSelection);
                    }
                    boolean[] zArr3 = new boolean[this.renderers.length];
                    int i11 = 0;
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i11 >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i11];
                        zArr3[i11] = isRendererEnabled(renderer);
                        SampleStream sampleStream = mediaPeriodHolder.sampleStreams[i11];
                        if (zArr3[i11]) {
                            if (sampleStream != renderer.getStream()) {
                                disableRenderer(renderer);
                            } else if (zArr2[i11]) {
                                renderer.resetPosition(this.rendererPositionUs);
                            }
                        }
                        i11++;
                    }
                    enableRenderers(zArr3);
                } else {
                    this.queue.removeAfter(playingPeriod);
                    if (playingPeriod.prepared) {
                        playingPeriod.applyTrackSelection(selectTracks, Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
                    }
                }
                handleLoadingMediaPeriodChanged(true);
                if (this.playbackInfo.playbackState != 4) {
                    maybeContinueLoading();
                    updatePlaybackPositions();
                    this.handler.sendEmptyMessage(2);
                    return;
                }
                return;
            }
            if (playingPeriod == readingPeriod) {
                z11 = false;
            }
            playingPeriod = playingPeriod.getNext();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void resetInternal(boolean r30, boolean r31, boolean r32, boolean r33) {
        /*
            r29 = this;
            r1 = r29
            com.google.android.exoplayer2.util.HandlerWrapper r0 = r1.handler
            r2 = 2
            r0.removeMessages(r2)
            r2 = 0
            r1.pendingRecoverableRendererError = r2
            r3 = 0
            r1.isRebuffering = r3
            com.google.android.exoplayer2.DefaultMediaClock r0 = r1.mediaClock
            r0.stop()
            r4 = 0
            r1.rendererPositionUs = r4
            com.google.android.exoplayer2.Renderer[] r4 = r1.renderers
            int r5 = r4.length
            r6 = r3
        L_0x001b:
            java.lang.String r7 = "ExoPlayerImplInternal"
            if (r6 >= r5) goto L_0x0030
            r0 = r4[r6]
            r1.disableRenderer(r0)     // Catch:{ ExoPlaybackException -> 0x0027, RuntimeException -> 0x0025 }
            goto L_0x002d
        L_0x0025:
            r0 = move-exception
            goto L_0x0028
        L_0x0027:
            r0 = move-exception
        L_0x0028:
            java.lang.String r8 = "Disable failed."
            com.google.android.exoplayer2.util.Log.e(r7, r8, r0)
        L_0x002d:
            int r6 = r6 + 1
            goto L_0x001b
        L_0x0030:
            if (r30 == 0) goto L_0x0048
            com.google.android.exoplayer2.Renderer[] r4 = r1.renderers
            int r5 = r4.length
            r6 = r3
        L_0x0036:
            if (r6 >= r5) goto L_0x0048
            r0 = r4[r6]
            r0.reset()     // Catch:{ RuntimeException -> 0x003e }
            goto L_0x0045
        L_0x003e:
            r0 = move-exception
            r8 = r0
            java.lang.String r0 = "Reset failed."
            com.google.android.exoplayer2.util.Log.e(r7, r0, r8)
        L_0x0045:
            int r6 = r6 + 1
            goto L_0x0036
        L_0x0048:
            r1.enabledRendererCount = r3
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r4 = r0.periodId
            long r5 = r0.positionUs
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            com.google.android.exoplayer2.Timeline$Period r7 = r1.period
            boolean r0 = shouldUseRequestedContentPosition(r0, r7)
            if (r0 == 0) goto L_0x005f
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            long r7 = r0.requestedContentPositionUs
            goto L_0x0063
        L_0x005f:
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            long r7 = r0.positionUs
        L_0x0063:
            if (r31 == 0) goto L_0x008c
            r1.pendingInitialSeekPosition = r2
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            com.google.android.exoplayer2.Timeline r0 = r0.timeline
            android.util.Pair r0 = r1.getPlaceholderFirstMediaPeriodPosition(r0)
            java.lang.Object r4 = r0.first
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r4 = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) r4
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r5 = r0.longValue()
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.periodId
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x008c
            r0 = 1
            goto L_0x008d
        L_0x008c:
            r0 = r3
        L_0x008d:
            r17 = r4
            r25 = r5
            com.google.android.exoplayer2.MediaPeriodQueue r4 = r1.queue
            r4.clear()
            r1.shouldContinueLoading = r3
            com.google.android.exoplayer2.PlaybackInfo r3 = new com.google.android.exoplayer2.PlaybackInfo
            com.google.android.exoplayer2.PlaybackInfo r4 = r1.playbackInfo
            com.google.android.exoplayer2.Timeline r5 = r4.timeline
            int r11 = r4.playbackState
            if (r33 == 0) goto L_0x00a3
            goto L_0x00a5
        L_0x00a3:
            com.google.android.exoplayer2.ExoPlaybackException r2 = r4.playbackError
        L_0x00a5:
            r12 = r2
            r13 = 0
            if (r0 == 0) goto L_0x00ac
            com.google.android.exoplayer2.source.TrackGroupArray r2 = com.google.android.exoplayer2.source.TrackGroupArray.EMPTY
            goto L_0x00ae
        L_0x00ac:
            com.google.android.exoplayer2.source.TrackGroupArray r2 = r4.trackGroups
        L_0x00ae:
            r14 = r2
            if (r0 == 0) goto L_0x00b4
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r2 = r1.emptyTrackSelectorResult
            goto L_0x00b6
        L_0x00b4:
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r2 = r4.trackSelectorResult
        L_0x00b6:
            r15 = r2
            if (r0 == 0) goto L_0x00be
            com.google.common.collect.ImmutableList r0 = com.google.common.collect.ImmutableList.of()
            goto L_0x00c0
        L_0x00be:
            java.util.List<com.google.android.exoplayer2.metadata.Metadata> r0 = r4.staticMetadata
        L_0x00c0:
            r16 = r0
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo
            boolean r2 = r0.playWhenReady
            r18 = r2
            int r2 = r0.playbackSuppressionReason
            r19 = r2
            com.google.android.exoplayer2.PlaybackParameters r0 = r0.playbackParameters
            r20 = r0
            r23 = 0
            boolean r0 = r1.offloadSchedulingEnabled
            r27 = r0
            r28 = 0
            r4 = r3
            r6 = r17
            r9 = r25
            r21 = r25
            r4.<init>(r5, r6, r7, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r25, r27, r28)
            r1.playbackInfo = r3
            if (r32 == 0) goto L_0x00eb
            com.google.android.exoplayer2.MediaSourceList r0 = r1.mediaSourceList
            r0.release()
        L_0x00eb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.resetInternal(boolean, boolean, boolean, boolean):void");
    }

    private void resetPendingPauseAtEndOfPeriod() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        this.pendingPauseAtEndOfPeriod = playingPeriod != null && playingPeriod.info.isLastInTimelineWindow && this.pauseAtEndOfWindow;
    }

    private void resetRendererPosition(long j11) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            j11 = playingPeriod.toRendererTime(j11);
        }
        this.rendererPositionUs = j11;
        this.mediaClock.resetPosition(j11);
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.resetPosition(this.rendererPositionUs);
            }
        }
        notifyTrackSelectionDiscontinuity();
    }

    private static void resolvePendingMessageEndOfStreamPosition(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window2, Timeline.Period period2) {
        int i11 = timeline.getWindow(timeline.getPeriodByUid(pendingMessageInfo.resolvedPeriodUid, period2).windowIndex, window2).lastPeriodIndex;
        Object obj = timeline.getPeriod(i11, period2, true).uid;
        long j11 = period2.durationUs;
        pendingMessageInfo.setResolvedPosition(i11, j11 != -9223372036854775807L ? j11 - 1 : Long.MAX_VALUE, obj);
    }

    private static boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i11, boolean z11, Timeline.Window window2, Timeline.Period period2) {
        long j11;
        PendingMessageInfo pendingMessageInfo2 = pendingMessageInfo;
        Timeline timeline3 = timeline;
        Timeline timeline4 = timeline2;
        Timeline.Window window3 = window2;
        Timeline.Period period3 = period2;
        Object obj = pendingMessageInfo2.resolvedPeriodUid;
        if (obj == null) {
            if (pendingMessageInfo2.message.getPositionMs() == Long.MIN_VALUE) {
                j11 = -9223372036854775807L;
            } else {
                j11 = C.msToUs(pendingMessageInfo2.message.getPositionMs());
            }
            Pair<Object, Long> resolveSeekPosition = resolveSeekPosition(timeline, new SeekPosition(pendingMessageInfo2.message.getTimeline(), pendingMessageInfo2.message.getWindowIndex(), j11), false, i11, z11, window2, period2);
            if (resolveSeekPosition == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(timeline3.getIndexOfPeriod(resolveSeekPosition.first), ((Long) resolveSeekPosition.second).longValue(), resolveSeekPosition.first);
            if (pendingMessageInfo2.message.getPositionMs() == Long.MIN_VALUE) {
                resolvePendingMessageEndOfStreamPosition(timeline3, pendingMessageInfo, window3, period3);
            }
            return true;
        }
        int indexOfPeriod = timeline3.getIndexOfPeriod(obj);
        if (indexOfPeriod == -1) {
            return false;
        }
        if (pendingMessageInfo2.message.getPositionMs() == Long.MIN_VALUE) {
            resolvePendingMessageEndOfStreamPosition(timeline3, pendingMessageInfo, window3, period3);
            return true;
        }
        pendingMessageInfo2.resolvedPeriodIndex = indexOfPeriod;
        timeline4.getPeriodByUid(pendingMessageInfo2.resolvedPeriodUid, period3);
        if (period3.isPlaceholder && timeline4.getWindow(period3.windowIndex, window3).firstPeriodIndex == timeline4.getIndexOfPeriod(pendingMessageInfo2.resolvedPeriodUid)) {
            long positionInWindowUs = pendingMessageInfo2.resolvedPeriodTimeUs + period2.getPositionInWindowUs();
            Pair<Object, Long> periodPosition = timeline.getPeriodPosition(window2, period2, timeline3.getPeriodByUid(pendingMessageInfo2.resolvedPeriodUid, period3).windowIndex, positionInWindowUs);
            pendingMessageInfo.setResolvedPosition(timeline3.getIndexOfPeriod(periodPosition.first), ((Long) periodPosition.second).longValue(), periodPosition.first);
        }
        return true;
    }

    private void resolvePendingMessagePositions(Timeline timeline, Timeline timeline2) {
        if (!timeline.isEmpty() || !timeline2.isEmpty()) {
            for (int size = this.pendingMessages.size() - 1; size >= 0; size--) {
                if (!resolvePendingMessagePosition(this.pendingMessages.get(size), timeline, timeline2, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                    this.pendingMessages.get(size).message.markAsProcessed(false);
                    this.pendingMessages.remove(size);
                }
            }
            Collections.sort(this.pendingMessages);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.ExoPlayerImplInternal.PositionUpdateForPlaylistChange resolvePositionForPlaylistChange(com.google.android.exoplayer2.Timeline r29, com.google.android.exoplayer2.PlaybackInfo r30, com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition r31, com.google.android.exoplayer2.MediaPeriodQueue r32, int r33, boolean r34, com.google.android.exoplayer2.Timeline.Window r35, com.google.android.exoplayer2.Timeline.Period r36) {
        /*
            r7 = r29
            r8 = r30
            r9 = r31
            r10 = r34
            r11 = r36
            boolean r0 = r29.isEmpty()
            if (r0 == 0) goto L_0x0025
            com.google.android.exoplayer2.ExoPlayerImplInternal$PositionUpdateForPlaylistChange r0 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PositionUpdateForPlaylistChange
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = com.google.android.exoplayer2.PlaybackInfo.getDummyPeriodForEmptyTimeline()
            r3 = 0
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 0
            r8 = 1
            r9 = 0
            r1 = r0
            r1.<init>(r2, r3, r5, r7, r8, r9)
            return r0
        L_0x0025:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r12 = r8.periodId
            java.lang.Object r13 = r12.periodUid
            boolean r0 = shouldUseRequestedContentPosition(r8, r11)
            if (r0 == 0) goto L_0x0032
            long r1 = r8.requestedContentPositionUs
            goto L_0x0034
        L_0x0032:
            long r1 = r8.positionUs
        L_0x0034:
            r14 = r1
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = -1
            r18 = 0
            r19 = 1
            if (r9 == 0) goto L_0x009b
            r2 = 1
            r0 = r29
            r1 = r31
            r3 = r33
            r4 = r34
            r5 = r35
            r20 = r12
            r12 = r6
            r6 = r36
            android.util.Pair r0 = resolveSeekPosition(r0, r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0061
            int r0 = r7.getFirstWindowIndex(r10)
            r1 = r18
            r2 = r1
            r3 = r19
            goto L_0x008e
        L_0x0061:
            long r1 = r9.windowPositionUs
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x0072
            java.lang.Object r0 = r0.first
            com.google.android.exoplayer2.Timeline$Period r0 = r7.getPeriodByUid(r0, r11)
            int r6 = r0.windowIndex
            r0 = r18
            goto L_0x007f
        L_0x0072:
            java.lang.Object r13 = r0.first
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r14 = r0.longValue()
            r6 = r12
            r0 = r19
        L_0x007f:
            int r1 = r8.playbackState
            r2 = 4
            if (r1 != r2) goto L_0x0087
            r1 = r19
            goto L_0x0089
        L_0x0087:
            r1 = r18
        L_0x0089:
            r2 = r1
            r3 = r18
            r1 = r0
            r0 = r6
        L_0x008e:
            r9 = r35
            r28 = r1
            r26 = r2
            r27 = r3
        L_0x0096:
            r6 = r20
            r3 = r0
            goto L_0x0149
        L_0x009b:
            r20 = r12
            r12 = r6
            com.google.android.exoplayer2.Timeline r1 = r8.timeline
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00b7
            int r0 = r7.getFirstWindowIndex(r10)
        L_0x00aa:
            r9 = r35
            r3 = r0
            r26 = r18
            r27 = r26
            r28 = r27
            r6 = r20
            goto L_0x0149
        L_0x00b7:
            int r1 = r7.getIndexOfPeriod(r13)
            if (r1 != r12) goto L_0x00e8
            com.google.android.exoplayer2.Timeline r5 = r8.timeline
            r0 = r35
            r1 = r36
            r2 = r33
            r3 = r34
            r4 = r13
            r6 = r29
            java.lang.Object r0 = resolveSubsequentPeriod(r0, r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x00d7
            int r0 = r7.getFirstWindowIndex(r10)
            r3 = r19
            goto L_0x00df
        L_0x00d7:
            com.google.android.exoplayer2.Timeline$Period r0 = r7.getPeriodByUid(r0, r11)
            int r0 = r0.windowIndex
            r3 = r18
        L_0x00df:
            r9 = r35
            r27 = r3
            r26 = r18
            r28 = r26
            goto L_0x0096
        L_0x00e8:
            if (r0 == 0) goto L_0x013e
            int r0 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x00f5
            com.google.android.exoplayer2.Timeline$Period r0 = r7.getPeriodByUid(r13, r11)
            int r0 = r0.windowIndex
            goto L_0x00aa
        L_0x00f5:
            com.google.android.exoplayer2.Timeline r0 = r8.timeline
            r6 = r20
            java.lang.Object r1 = r6.periodUid
            r0.getPeriodByUid(r1, r11)
            com.google.android.exoplayer2.Timeline r0 = r8.timeline
            int r1 = r11.windowIndex
            r9 = r35
            com.google.android.exoplayer2.Timeline$Window r0 = r0.getWindow(r1, r9)
            int r0 = r0.firstPeriodIndex
            com.google.android.exoplayer2.Timeline r1 = r8.timeline
            java.lang.Object r2 = r6.periodUid
            int r1 = r1.getIndexOfPeriod(r2)
            if (r0 != r1) goto L_0x0136
            long r0 = r36.getPositionInWindowUs()
            long r4 = r14 + r0
            com.google.android.exoplayer2.Timeline$Period r0 = r7.getPeriodByUid(r13, r11)
            int r3 = r0.windowIndex
            r0 = r29
            r1 = r35
            r2 = r36
            android.util.Pair r0 = r0.getPeriodPosition(r1, r2, r3, r4)
            java.lang.Object r1 = r0.first
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            r13 = r1
            r14 = r2
        L_0x0136:
            r3 = r12
            r26 = r18
            r27 = r26
            r28 = r19
            goto L_0x0149
        L_0x013e:
            r9 = r35
            r6 = r20
            r3 = r12
            r26 = r18
            r27 = r26
            r28 = r27
        L_0x0149:
            if (r3 == r12) goto L_0x0169
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0 = r29
            r1 = r35
            r2 = r36
            android.util.Pair r0 = r0.getPeriodPosition(r1, r2, r3, r4)
            java.lang.Object r13 = r0.first
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r14 = r0.longValue()
            r0 = r32
            r24 = r16
            goto L_0x016d
        L_0x0169:
            r0 = r32
            r24 = r14
        L_0x016d:
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.resolveMediaPeriodIdForAds(r7, r13, r14)
            int r1 = r0.nextAdGroupIndex
            if (r1 == r12) goto L_0x0181
            int r1 = r6.nextAdGroupIndex
            if (r1 == r12) goto L_0x017e
            int r2 = r0.adGroupIndex
            if (r2 < r1) goto L_0x017e
            goto L_0x0181
        L_0x017e:
            r1 = r18
            goto L_0x0183
        L_0x0181:
            r1 = r19
        L_0x0183:
            java.lang.Object r2 = r6.periodUid
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x019b
            boolean r2 = r6.isAd()
            if (r2 != 0) goto L_0x019b
            boolean r2 = r0.isAd()
            if (r2 != 0) goto L_0x019b
            if (r1 == 0) goto L_0x019b
            r18 = r19
        L_0x019b:
            if (r18 == 0) goto L_0x019e
            r0 = r6
        L_0x019e:
            boolean r1 = r0.isAd()
            if (r1 == 0) goto L_0x01c6
            boolean r1 = r0.equals(r6)
            if (r1 == 0) goto L_0x01af
            long r1 = r8.positionUs
        L_0x01ac:
            r22 = r1
            goto L_0x01c8
        L_0x01af:
            java.lang.Object r1 = r0.periodUid
            r7.getPeriodByUid(r1, r11)
            int r1 = r0.adIndexInAdGroup
            int r2 = r0.adGroupIndex
            int r2 = r11.getFirstAdIndexToPlay(r2)
            if (r1 != r2) goto L_0x01c3
            long r1 = r36.getAdResumePositionUs()
            goto L_0x01ac
        L_0x01c3:
            r1 = 0
            goto L_0x01ac
        L_0x01c6:
            r22 = r14
        L_0x01c8:
            com.google.android.exoplayer2.ExoPlayerImplInternal$PositionUpdateForPlaylistChange r1 = new com.google.android.exoplayer2.ExoPlayerImplInternal$PositionUpdateForPlaylistChange
            r20 = r1
            r21 = r0
            r20.<init>(r21, r22, r24, r26, r27, r28)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.resolvePositionForPlaylistChange(com.google.android.exoplayer2.Timeline, com.google.android.exoplayer2.PlaybackInfo, com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition, com.google.android.exoplayer2.MediaPeriodQueue, int, boolean, com.google.android.exoplayer2.Timeline$Window, com.google.android.exoplayer2.Timeline$Period):com.google.android.exoplayer2.ExoPlayerImplInternal$PositionUpdateForPlaylistChange");
    }

    private static Pair<Object, Long> resolveSeekPosition(Timeline timeline, SeekPosition seekPosition, boolean z11, int i11, boolean z12, Timeline.Window window2, Timeline.Period period2) {
        Object resolveSubsequentPeriod;
        Timeline timeline2 = timeline;
        SeekPosition seekPosition2 = seekPosition;
        Timeline.Period period3 = period2;
        Timeline timeline3 = seekPosition2.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        Timeline timeline4 = timeline3.isEmpty() ? timeline2 : timeline3;
        try {
            Pair<Object, Long> periodPosition = timeline4.getPeriodPosition(window2, period2, seekPosition2.windowIndex, seekPosition2.windowPositionUs);
            if (timeline.equals(timeline4)) {
                return periodPosition;
            }
            if (timeline.getIndexOfPeriod(periodPosition.first) == -1) {
                Timeline.Window window3 = window2;
                if (z11 && (resolveSubsequentPeriod = resolveSubsequentPeriod(window2, period2, i11, z12, periodPosition.first, timeline4, timeline)) != null) {
                    return timeline.getPeriodPosition(window2, period2, timeline.getPeriodByUid(resolveSubsequentPeriod, period3).windowIndex, -9223372036854775807L);
                }
                return null;
            } else if (!timeline4.getPeriodByUid(periodPosition.first, period3).isPlaceholder || timeline4.getWindow(period3.windowIndex, window2).firstPeriodIndex != timeline4.getIndexOfPeriod(periodPosition.first)) {
                return periodPosition;
            } else {
                return timeline.getPeriodPosition(window2, period2, timeline.getPeriodByUid(periodPosition.first, period3).windowIndex, seekPosition2.windowPositionUs);
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    public static Object resolveSubsequentPeriod(Timeline.Window window2, Timeline.Period period2, int i11, boolean z11, Object obj, Timeline timeline, Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int i12 = indexOfPeriod;
        int i13 = -1;
        for (int i14 = 0; i14 < periodCount && i13 == -1; i14++) {
            i12 = timeline.getNextPeriodIndex(i12, period2, window2, i11, z11);
            if (i12 == -1) {
                break;
            }
            i13 = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i12));
        }
        if (i13 == -1) {
            return null;
        }
        return timeline2.getUidOfPeriod(i13);
    }

    private void scheduleNextWork(long j11, long j12) {
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageAtTime(2, j11 + j12);
    }

    private void seekToCurrentPosition(boolean z11) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.f65678id;
        long seekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true, false);
        if (seekToPeriodPosition != this.playbackInfo.positionUs) {
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            this.playbackInfo = handlePositionDiscontinuity(mediaPeriodId, seekToPeriodPosition, playbackInfo2.requestedContentPositionUs, playbackInfo2.discontinuityStartPositionUs, z11, 5);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ac A[Catch:{ all -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00af A[Catch:{ all -> 0x0148 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void seekToInternal(com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition r19) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r18 = this;
            r11 = r18
            r0 = r19
            com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate r1 = r11.playbackInfoUpdate
            r8 = 1
            r1.incrementPendingOperationAcks(r8)
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r1 = r1.timeline
            int r4 = r11.repeatMode
            boolean r5 = r11.shuffleModeEnabled
            com.google.android.exoplayer2.Timeline$Window r6 = r11.window
            com.google.android.exoplayer2.Timeline$Period r7 = r11.period
            r3 = 1
            r2 = r19
            android.util.Pair r1 = resolveSeekPosition(r1, r2, r3, r4, r5, r6, r7)
            r2 = 0
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 0
            if (r1 != 0) goto L_0x004c
            com.google.android.exoplayer2.PlaybackInfo r7 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r7 = r7.timeline
            android.util.Pair r7 = r11.getPlaceholderFirstMediaPeriodPosition(r7)
            java.lang.Object r9 = r7.first
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r9 = (com.google.android.exoplayer2.source.MediaSource.MediaPeriodId) r9
            java.lang.Object r7 = r7.second
            java.lang.Long r7 = (java.lang.Long) r7
            long r12 = r7.longValue()
            com.google.android.exoplayer2.PlaybackInfo r7 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r7 = r7.timeline
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r8
            r10 = r7
            r16 = r4
        L_0x0047:
            r4 = r12
            r12 = r16
            goto L_0x00a2
        L_0x004c:
            java.lang.Object r7 = r1.first
            java.lang.Object r9 = r1.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            long r9 = r0.windowPositionUs
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 != 0) goto L_0x005e
            r9 = r4
            goto L_0x005f
        L_0x005e:
            r9 = r12
        L_0x005f:
            com.google.android.exoplayer2.MediaPeriodQueue r14 = r11.queue
            com.google.android.exoplayer2.PlaybackInfo r15 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r15 = r15.timeline
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r7 = r14.resolveMediaPeriodIdForAds(r15, r7, r12)
            boolean r14 = r7.isAd()
            if (r14 == 0) goto L_0x0094
            com.google.android.exoplayer2.PlaybackInfo r4 = r11.playbackInfo
            com.google.android.exoplayer2.Timeline r4 = r4.timeline
            java.lang.Object r5 = r7.periodUid
            com.google.android.exoplayer2.Timeline$Period r12 = r11.period
            r4.getPeriodByUid(r5, r12)
            com.google.android.exoplayer2.Timeline$Period r4 = r11.period
            int r5 = r7.adGroupIndex
            int r4 = r4.getFirstAdIndexToPlay(r5)
            int r5 = r7.adIndexInAdGroup
            if (r4 != r5) goto L_0x008e
            com.google.android.exoplayer2.Timeline$Period r4 = r11.period
            long r4 = r4.getAdResumePositionUs()
            r12 = r4
            goto L_0x008f
        L_0x008e:
            r12 = r2
        L_0x008f:
            r4 = r12
            r12 = r9
            r9 = r7
            r10 = r8
            goto L_0x00a2
        L_0x0094:
            long r14 = r0.windowPositionUs
            int r4 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x009c
            r4 = r8
            goto L_0x009d
        L_0x009c:
            r4 = r6
        L_0x009d:
            r16 = r9
            r10 = r4
            r9 = r7
            goto L_0x0047
        L_0x00a2:
            com.google.android.exoplayer2.PlaybackInfo r7 = r11.playbackInfo     // Catch:{ all -> 0x0148 }
            com.google.android.exoplayer2.Timeline r7 = r7.timeline     // Catch:{ all -> 0x0148 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0148 }
            if (r7 == 0) goto L_0x00af
            r11.pendingInitialSeekPosition = r0     // Catch:{ all -> 0x0148 }
            goto L_0x00be
        L_0x00af:
            r0 = 4
            if (r1 != 0) goto L_0x00c1
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo     // Catch:{ all -> 0x0148 }
            int r1 = r1.playbackState     // Catch:{ all -> 0x0148 }
            if (r1 == r8) goto L_0x00bb
            r11.setState(r0)     // Catch:{ all -> 0x0148 }
        L_0x00bb:
            r11.resetInternal(r6, r8, r6, r8)     // Catch:{ all -> 0x0148 }
        L_0x00be:
            r7 = r4
            goto L_0x0135
        L_0x00c1:
            com.google.android.exoplayer2.PlaybackInfo r1 = r11.playbackInfo     // Catch:{ all -> 0x0148 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r1.periodId     // Catch:{ all -> 0x0148 }
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x0148 }
            if (r1 == 0) goto L_0x0110
            com.google.android.exoplayer2.MediaPeriodQueue r1 = r11.queue     // Catch:{ all -> 0x0148 }
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r1.getPlayingPeriod()     // Catch:{ all -> 0x0148 }
            if (r1 == 0) goto L_0x00e4
            boolean r7 = r1.prepared     // Catch:{ all -> 0x0148 }
            if (r7 == 0) goto L_0x00e4
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00e4
            com.google.android.exoplayer2.source.MediaPeriod r1 = r1.mediaPeriod     // Catch:{ all -> 0x0148 }
            com.google.android.exoplayer2.SeekParameters r2 = r11.seekParameters     // Catch:{ all -> 0x0148 }
            long r1 = r1.getAdjustedSeekPositionUs(r4, r2)     // Catch:{ all -> 0x0148 }
            goto L_0x00e5
        L_0x00e4:
            r1 = r4
        L_0x00e5:
            long r14 = com.google.android.exoplayer2.C.usToMs(r1)     // Catch:{ all -> 0x0148 }
            com.google.android.exoplayer2.PlaybackInfo r3 = r11.playbackInfo     // Catch:{ all -> 0x0148 }
            long r6 = r3.positionUs     // Catch:{ all -> 0x0148 }
            long r6 = com.google.android.exoplayer2.C.usToMs(r6)     // Catch:{ all -> 0x0148 }
            int r3 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0111
            com.google.android.exoplayer2.PlaybackInfo r3 = r11.playbackInfo     // Catch:{ all -> 0x0148 }
            int r6 = r3.playbackState     // Catch:{ all -> 0x0148 }
            r7 = 2
            if (r6 == r7) goto L_0x00ff
            r7 = 3
            if (r6 != r7) goto L_0x0111
        L_0x00ff:
            long r7 = r3.positionUs     // Catch:{ all -> 0x0148 }
            r0 = 2
            r1 = r18
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r0
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.handlePositionDiscontinuity(r2, r3, r5, r7, r9, r10)
            r11.playbackInfo = r0
            return
        L_0x0110:
            r1 = r4
        L_0x0111:
            com.google.android.exoplayer2.PlaybackInfo r3 = r11.playbackInfo     // Catch:{ all -> 0x0148 }
            int r3 = r3.playbackState     // Catch:{ all -> 0x0148 }
            if (r3 != r0) goto L_0x0119
            r0 = r8
            goto L_0x011a
        L_0x0119:
            r0 = 0
        L_0x011a:
            long r14 = r11.seekToPeriodPosition(r9, r1, r0)     // Catch:{ all -> 0x0148 }
            int r0 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0123
            goto L_0x0124
        L_0x0123:
            r8 = 0
        L_0x0124:
            r8 = r8 | r10
            com.google.android.exoplayer2.PlaybackInfo r0 = r11.playbackInfo     // Catch:{ all -> 0x0144 }
            com.google.android.exoplayer2.Timeline r4 = r0.timeline     // Catch:{ all -> 0x0144 }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r0.periodId     // Catch:{ all -> 0x0144 }
            r1 = r18
            r2 = r4
            r3 = r9
            r6 = r12
            r1.updateLivePlaybackSpeedControl(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0144 }
            r10 = r8
            r7 = r14
        L_0x0135:
            r0 = 2
            r1 = r18
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r0
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.handlePositionDiscontinuity(r2, r3, r5, r7, r9, r10)
            r11.playbackInfo = r0
            return
        L_0x0144:
            r0 = move-exception
            r10 = r8
            r7 = r14
            goto L_0x014a
        L_0x0148:
            r0 = move-exception
            r7 = r4
        L_0x014a:
            r14 = 2
            r1 = r18
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r14
            com.google.android.exoplayer2.PlaybackInfo r1 = r1.handlePositionDiscontinuity(r2, r3, r5, r7, r9, r10)
            r11.playbackInfo = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.seekToInternal(com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition):void");
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j11, boolean z11) throws ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, j11, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod(), z11);
    }

    private void sendMessageInternal(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == -9223372036854775807L) {
            sendMessageToTarget(playerMessage);
        } else if (this.playbackInfo.timeline.isEmpty()) {
            this.pendingMessages.add(new PendingMessageInfo(playerMessage));
        } else {
            PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
            Timeline timeline = this.playbackInfo.timeline;
            if (resolvePendingMessagePosition(pendingMessageInfo, timeline, timeline, this.repeatMode, this.shuffleModeEnabled, this.window, this.period)) {
                this.pendingMessages.add(pendingMessageInfo);
                Collections.sort(this.pendingMessages);
                return;
            }
            playerMessage.markAsProcessed(false);
        }
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getLooper() == this.playbackLooper) {
            deliverMessage(playerMessage);
            int i11 = this.playbackInfo.playbackState;
            if (i11 == 3 || i11 == 2) {
                this.handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.handler.obtainMessage(15, playerMessage).sendToTarget();
    }

    private void sendMessageToTargetThread(PlayerMessage playerMessage) {
        Looper looper = playerMessage.getLooper();
        if (!looper.getThread().isAlive()) {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
            return;
        }
        this.clock.createHandler(looper, (Handler.Callback) null).post(new d0(this, playerMessage));
    }

    private void setAllRendererStreamsFinal(long j11) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getStream() != null) {
                setCurrentStreamFinal(renderer, j11);
            }
        }
    }

    private void setCurrentStreamFinal(Renderer renderer, long j11) {
        renderer.setCurrentStreamFinal();
        if (renderer instanceof TextRenderer) {
            ((TextRenderer) renderer).setFinalStreamEndPositionUs(j11);
        }
    }

    private void setForegroundModeInternal(boolean z11, AtomicBoolean atomicBoolean) {
        if (this.foregroundMode != z11) {
            this.foregroundMode = z11;
            if (!z11) {
                for (Renderer renderer : this.renderers) {
                    if (!isRendererEnabled(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void setMediaItemsInternal(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        if (mediaSourceListUpdateMessage.windowIndex != -1) {
            this.pendingInitialSeekPosition = new SeekPosition(new PlaylistTimeline(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), mediaSourceListUpdateMessage.windowIndex, mediaSourceListUpdateMessage.positionUs);
        }
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setMediaSources(mediaSourceListUpdateMessage.mediaSourceHolders, mediaSourceListUpdateMessage.shuffleOrder), false);
    }

    private void setOffloadSchedulingEnabledInternal(boolean z11) {
        if (z11 != this.offloadSchedulingEnabled) {
            this.offloadSchedulingEnabled = z11;
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            int i11 = playbackInfo2.playbackState;
            if (z11 || i11 == 4 || i11 == 1) {
                this.playbackInfo = playbackInfo2.copyWithOffloadSchedulingEnabled(z11);
            } else {
                this.handler.sendEmptyMessage(2);
            }
        }
    }

    private void setPauseAtEndOfWindowInternal(boolean z11) throws ExoPlaybackException {
        this.pauseAtEndOfWindow = z11;
        resetPendingPauseAtEndOfPeriod();
        if (this.pendingPauseAtEndOfPeriod && this.queue.getReadingPeriod() != this.queue.getPlayingPeriod()) {
            seekToCurrentPosition(true);
            handleLoadingMediaPeriodChanged(false);
        }
    }

    private void setPlayWhenReadyInternal(boolean z11, int i11, boolean z12, int i12) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(z12 ? 1 : 0);
        this.playbackInfoUpdate.setPlayWhenReadyChangeReason(i12);
        this.playbackInfo = this.playbackInfo.copyWithPlayWhenReady(z11, i11);
        this.isRebuffering = false;
        notifyTrackSelectionPlayWhenReadyChanged(z11);
        if (!shouldPlayWhenReady()) {
            stopRenderers();
            updatePlaybackPositions();
            return;
        }
        int i13 = this.playbackInfo.playbackState;
        if (i13 == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (i13 == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        this.mediaClock.setPlaybackParameters(playbackParameters);
        handlePlaybackParameters(this.mediaClock.getPlaybackParameters(), true);
    }

    private void setRepeatModeInternal(int i11) throws ExoPlaybackException {
        this.repeatMode = i11;
        if (!this.queue.updateRepeatMode(this.playbackInfo.timeline, i11)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters2) {
        this.seekParameters = seekParameters2;
    }

    private void setShuffleModeEnabledInternal(boolean z11) throws ExoPlaybackException {
        this.shuffleModeEnabled = z11;
        if (!this.queue.updateShuffleModeEnabled(this.playbackInfo.timeline, z11)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleOrderInternal(ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        handleMediaSourceListInfoRefreshed(this.mediaSourceList.setShuffleOrder(shuffleOrder), false);
    }

    private void setState(int i11) {
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.playbackState != i11) {
            this.playbackInfo = playbackInfo2.copyWithPlaybackState(i11);
        }
    }

    private boolean shouldAdvancePlayingPeriod() {
        MediaPeriodHolder playingPeriod;
        MediaPeriodHolder next;
        if (shouldPlayWhenReady() && !this.pendingPauseAtEndOfPeriod && (playingPeriod = this.queue.getPlayingPeriod()) != null && (next = playingPeriod.getNext()) != null && this.rendererPositionUs >= next.getStartPositionRendererTime() && next.allRenderersInCorrectState) {
            return true;
        }
        return false;
    }

    private boolean shouldContinueLoading() {
        long j11;
        if (!isLoadingPossible()) {
            return false;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long totalBufferedDurationUs = getTotalBufferedDurationUs(loadingPeriod.getNextLoadPositionUs());
        if (loadingPeriod == this.queue.getPlayingPeriod()) {
            j11 = loadingPeriod.toPeriodTime(this.rendererPositionUs);
        } else {
            j11 = loadingPeriod.toPeriodTime(this.rendererPositionUs) - loadingPeriod.info.startPositionUs;
        }
        return this.loadControl.shouldContinueLoading(j11, totalBufferedDurationUs, this.mediaClock.getPlaybackParameters().speed);
    }

    private boolean shouldPlayWhenReady() {
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        return playbackInfo2.playWhenReady && playbackInfo2.playbackSuppressionReason == 0;
    }

    private boolean shouldTransitionToReadyState(boolean z11) {
        if (this.enabledRendererCount == 0) {
            return isTimelineReady();
        }
        if (!z11) {
            return false;
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (!playbackInfo2.isLoading) {
            return true;
        }
        long targetLiveOffsetUs = shouldUseLivePlaybackSpeedControl(playbackInfo2.timeline, this.queue.getPlayingPeriod().info.f65678id) ? this.livePlaybackSpeedControl.getTargetLiveOffsetUs() : -9223372036854775807L;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z12 = loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal;
        boolean z13 = loadingPeriod.info.f65678id.isAd() && !loadingPeriod.prepared;
        if (z12 || z13 || this.loadControl.shouldStartPlayback(getTotalBufferedDurationUs(), this.mediaClock.getPlaybackParameters().speed, this.isRebuffering, targetLiveOffsetUs)) {
            return true;
        }
        return false;
    }

    private boolean shouldUseLivePlaybackSpeedControl(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.isAd() || timeline.isEmpty()) {
            return false;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        if (!this.window.isLive()) {
            return false;
        }
        Timeline.Window window2 = this.window;
        if (!window2.isDynamic || window2.windowStartTimeMs == -9223372036854775807L) {
            return false;
        }
        return true;
    }

    private static boolean shouldUseRequestedContentPosition(PlaybackInfo playbackInfo2, Timeline.Period period2) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo2.periodId;
        Timeline timeline = playbackInfo2.timeline;
        return mediaPeriodId.isAd() || timeline.isEmpty() || timeline.getPeriodByUid(mediaPeriodId.periodUid, period2).isPlaceholder;
    }

    private void startRenderers() throws ExoPlaybackException {
        this.isRebuffering = false;
        this.mediaClock.start();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                renderer.start();
            }
        }
    }

    private void stopInternal(boolean z11, boolean z12) {
        resetInternal(z11 || !this.foregroundMode, false, true, false);
        this.playbackInfoUpdate.incrementPendingOperationAcks(z12 ? 1 : 0);
        this.loadControl.onStopped();
        setState(1);
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (Renderer renderer : this.renderers) {
            if (isRendererEnabled(renderer)) {
                ensureStopped(renderer);
            }
        }
    }

    private void updateIsLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        boolean z11 = this.shouldContinueLoading || (loadingPeriod != null && loadingPeriod.mediaPeriod.isLoading());
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (z11 != playbackInfo2.isLoading) {
            this.playbackInfo = playbackInfo2.copyWithIsLoading(z11);
        }
    }

    private void updateLivePlaybackSpeedControl(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j11) {
        if (timeline.isEmpty() || !shouldUseLivePlaybackSpeedControl(timeline, mediaPeriodId)) {
            float f11 = this.mediaClock.getPlaybackParameters().speed;
            PlaybackParameters playbackParameters = this.playbackInfo.playbackParameters;
            if (f11 != playbackParameters.speed) {
                this.mediaClock.setPlaybackParameters(playbackParameters);
                return;
            }
            return;
        }
        timeline.getWindow(timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, this.window);
        this.livePlaybackSpeedControl.setLiveConfiguration((MediaItem.LiveConfiguration) Util.castNonNull(this.window.liveConfiguration));
        if (j11 != -9223372036854775807L) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(getLiveOffsetUs(timeline, mediaPeriodId.periodUid, j11));
            return;
        }
        Object obj = this.window.uid;
        Object obj2 = null;
        if (!timeline2.isEmpty()) {
            obj2 = timeline2.getWindow(timeline2.getPeriodByUid(mediaPeriodId2.periodUid, this.period).windowIndex, this.window).uid;
        }
        if (!Util.areEqual(obj2, obj)) {
            this.livePlaybackSpeedControl.setTargetLiveOffsetOverrideUs(-9223372036854775807L);
        }
    }

    private void updateLoadControlTrackSelection(TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.renderers, trackGroupArray, trackSelectorResult.selections);
    }

    private void updatePeriods() throws ExoPlaybackException, IOException {
        if (!this.playbackInfo.timeline.isEmpty() && this.mediaSourceList.isPrepared()) {
            maybeUpdateLoadingPeriod();
            maybeUpdateReadingPeriod();
            maybeUpdateReadingRenderers();
            maybeUpdatePlayingPeriod();
        }
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null) {
            long readDiscontinuity = playingPeriod.prepared ? playingPeriod.mediaPeriod.readDiscontinuity() : -9223372036854775807L;
            if (readDiscontinuity != -9223372036854775807L) {
                resetRendererPosition(readDiscontinuity);
                if (readDiscontinuity != this.playbackInfo.positionUs) {
                    PlaybackInfo playbackInfo2 = this.playbackInfo;
                    this.playbackInfo = handlePositionDiscontinuity(playbackInfo2.periodId, readDiscontinuity, playbackInfo2.requestedContentPositionUs, readDiscontinuity, true, 5);
                }
            } else {
                long syncAndGetPositionUs = this.mediaClock.syncAndGetPositionUs(playingPeriod != this.queue.getReadingPeriod());
                this.rendererPositionUs = syncAndGetPositionUs;
                long periodTime = playingPeriod.toPeriodTime(syncAndGetPositionUs);
                maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
                this.playbackInfo.positionUs = periodTime;
            }
            this.playbackInfo.bufferedPositionUs = this.queue.getLoadingPeriod().getBufferedPositionUs();
            this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
            PlaybackInfo playbackInfo3 = this.playbackInfo;
            if (playbackInfo3.playWhenReady && playbackInfo3.playbackState == 3 && shouldUseLivePlaybackSpeedControl(playbackInfo3.timeline, playbackInfo3.periodId) && this.playbackInfo.playbackParameters.speed == 1.0f) {
                float adjustedPlaybackSpeed = this.livePlaybackSpeedControl.getAdjustedPlaybackSpeed(getCurrentLiveOffsetUs(), getTotalBufferedDurationUs());
                if (this.mediaClock.getPlaybackParameters().speed != adjustedPlaybackSpeed) {
                    this.mediaClock.setPlaybackParameters(this.playbackInfo.playbackParameters.withSpeed(adjustedPlaybackSpeed));
                    handlePlaybackParameters(this.playbackInfo.playbackParameters, this.mediaClock.getPlaybackParameters().speed, false, false);
                }
            }
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float f11) {
        for (MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod(); playingPeriod != null; playingPeriod = playingPeriod.getNext()) {
            for (ExoTrackSelection exoTrackSelection : playingPeriod.getTrackSelectorResult().selections) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.onPlaybackSpeed(f11);
                }
            }
        }
    }

    private synchronized void waitUninterruptibly(Supplier<Boolean> supplier, long j11) {
        long elapsedRealtime = this.clock.elapsedRealtime() + j11;
        boolean z11 = false;
        while (!supplier.get().booleanValue() && j11 > 0) {
            try {
                this.clock.onThreadBlocked();
                wait(j11);
            } catch (InterruptedException unused) {
                z11 = true;
            }
            j11 = elapsedRealtime - this.clock.elapsedRealtime();
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
    }

    public void addMediaSources(int i11, List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(18, i11, 0, new MediaSourceListUpdateMessage(list, shuffleOrder, -1, -9223372036854775807L)).sendToTarget();
    }

    public void experimentalSetForegroundModeTimeoutMs(long j11) {
        this.setForegroundModeTimeoutMs = j11;
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean z11) {
        this.handler.obtainMessage(24, z11 ? 1 : 0, 0).sendToTarget();
    }

    public Looper getPlaybackLooper() {
        return this.playbackLooper;
    }

    public boolean handleMessage(Message message) {
        MediaPeriodHolder readingPeriod;
        try {
            switch (message.what) {
                case 0:
                    prepareInternal();
                    break;
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    stopInternal(false, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 9:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 10:
                    reselectTracksInternal();
                    break;
                case 11:
                    setRepeatModeInternal(message.arg1);
                    break;
                case 12:
                    setShuffleModeEnabledInternal(message.arg1 != 0);
                    break;
                case 13:
                    setForegroundModeInternal(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 15:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                case 16:
                    handlePlaybackParameters((PlaybackParameters) message.obj, false);
                    break;
                case 17:
                    setMediaItemsInternal((MediaSourceListUpdateMessage) message.obj);
                    break;
                case 18:
                    addMediaItemsInternal((MediaSourceListUpdateMessage) message.obj, message.arg1);
                    break;
                case 19:
                    moveMediaItemsInternal((MoveMediaItemsMessage) message.obj);
                    break;
                case 20:
                    removeMediaItemsInternal(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    setShuffleOrderInternal((ShuffleOrder) message.obj);
                    break;
                case 22:
                    mediaSourceListUpdateRequestedInternal();
                    break;
                case 23:
                    setPauseAtEndOfWindowInternal(message.arg1 != 0);
                    break;
                case 24:
                    setOffloadSchedulingEnabledInternal(message.arg1 == 1);
                    break;
                case 25:
                    attemptRendererErrorRecovery();
                    break;
                default:
                    return false;
            }
            maybeNotifyPlaybackInfoChanged();
        } catch (ExoPlaybackException e11) {
            e = e11;
            if (e.type == 1 && (readingPeriod = this.queue.getReadingPeriod()) != null) {
                e = e.copyWithMediaPeriodId(readingPeriod.info.f65678id);
            }
            if (!e.isRecoverable || this.pendingRecoverableRendererError != null) {
                ExoPlaybackException exoPlaybackException = this.pendingRecoverableRendererError;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.pendingRecoverableRendererError;
                }
                Log.e(TAG, "Playback error", e);
                stopInternal(true, false);
                this.playbackInfo = this.playbackInfo.copyWithPlaybackError(e);
            } else {
                Log.w(TAG, "Recoverable renderer error", e);
                this.pendingRecoverableRendererError = e;
                HandlerWrapper handlerWrapper = this.handler;
                handlerWrapper.sendMessageAtFrontOfQueue(handlerWrapper.obtainMessage(25, e));
            }
            maybeNotifyPlaybackInfoChanged();
        } catch (IOException e12) {
            ExoPlaybackException createForSource = ExoPlaybackException.createForSource(e12);
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            if (playingPeriod != null) {
                createForSource = createForSource.copyWithMediaPeriodId(playingPeriod.info.f65678id);
            }
            Log.e(TAG, "Playback error", createForSource);
            stopInternal(false, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(createForSource);
            maybeNotifyPlaybackInfoChanged();
        } catch (RuntimeException e13) {
            ExoPlaybackException createForUnexpected = ExoPlaybackException.createForUnexpected(e13);
            Log.e(TAG, "Playback error", createForUnexpected);
            stopInternal(true, false);
            this.playbackInfo = this.playbackInfo.copyWithPlaybackError(createForUnexpected);
            maybeNotifyPlaybackInfoChanged();
        }
        return true;
    }

    public void moveMediaSources(int i11, int i12, int i13, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(19, new MoveMediaItemsMessage(i11, i12, i13, shuffleOrder)).sendToTarget();
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(16, playbackParameters).sendToTarget();
    }

    public void onPlaylistUpdateRequested() {
        this.handler.sendEmptyMessage(22);
    }

    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(10);
    }

    public void prepare() {
        this.handler.obtainMessage(0).sendToTarget();
    }

    public synchronized boolean release() {
        if (!this.released) {
            if (this.internalPlaybackThread.isAlive()) {
                this.handler.sendEmptyMessage(7);
                waitUninterruptibly(new b0(this), this.releaseTimeoutMs);
                return this.released;
            }
        }
        return true;
    }

    public void removeMediaSources(int i11, int i12, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(20, i11, i12, shuffleOrder).sendToTarget();
    }

    public void seekTo(Timeline timeline, int i11, long j11) {
        this.handler.obtainMessage(3, new SeekPosition(timeline, i11, j11)).sendToTarget();
    }

    public synchronized void sendMessage(PlayerMessage playerMessage) {
        if (!this.released) {
            if (this.internalPlaybackThread.isAlive()) {
                this.handler.obtainMessage(14, playerMessage).sendToTarget();
                return;
            }
        }
        Log.w(TAG, "Ignoring messages sent after release.");
        playerMessage.markAsProcessed(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean setForegroundMode(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.released     // Catch:{ all -> 0x003f }
            r1 = 1
            if (r0 != 0) goto L_0x003d
            android.os.HandlerThread r0 = r3.internalPlaybackThread     // Catch:{ all -> 0x003f }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x000f
            goto L_0x003d
        L_0x000f:
            r0 = 13
            r2 = 0
            if (r4 == 0) goto L_0x001f
            com.google.android.exoplayer2.util.HandlerWrapper r4 = r3.handler     // Catch:{ all -> 0x003f }
            com.google.android.exoplayer2.util.HandlerWrapper$Message r4 = r4.obtainMessage(r0, r1, r2)     // Catch:{ all -> 0x003f }
            r4.sendToTarget()     // Catch:{ all -> 0x003f }
            monitor-exit(r3)
            return r1
        L_0x001f:
            java.util.concurrent.atomic.AtomicBoolean r4 = new java.util.concurrent.atomic.AtomicBoolean     // Catch:{ all -> 0x003f }
            r4.<init>()     // Catch:{ all -> 0x003f }
            com.google.android.exoplayer2.util.HandlerWrapper r1 = r3.handler     // Catch:{ all -> 0x003f }
            com.google.android.exoplayer2.util.HandlerWrapper$Message r0 = r1.obtainMessage(r0, r2, r2, r4)     // Catch:{ all -> 0x003f }
            r0.sendToTarget()     // Catch:{ all -> 0x003f }
            com.google.android.exoplayer2.c0 r0 = new com.google.android.exoplayer2.c0     // Catch:{ all -> 0x003f }
            r0.<init>(r4)     // Catch:{ all -> 0x003f }
            long r1 = r3.setForegroundModeTimeoutMs     // Catch:{ all -> 0x003f }
            r3.waitUninterruptibly(r0, r1)     // Catch:{ all -> 0x003f }
            boolean r4 = r4.get()     // Catch:{ all -> 0x003f }
            monitor-exit(r3)
            return r4
        L_0x003d:
            monitor-exit(r3)
            return r1
        L_0x003f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.setForegroundMode(boolean):boolean");
    }

    public void setMediaSources(List<MediaSourceList.MediaSourceHolder> list, int i11, long j11, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i11, j11)).sendToTarget();
    }

    public void setPauseAtEndOfWindow(boolean z11) {
        this.handler.obtainMessage(23, z11 ? 1 : 0, 0).sendToTarget();
    }

    public void setPlayWhenReady(boolean z11, int i11) {
        this.handler.obtainMessage(1, z11 ? 1 : 0, i11).sendToTarget();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setRepeatMode(int i11) {
        this.handler.obtainMessage(11, i11, 0).sendToTarget();
    }

    public void setSeekParameters(SeekParameters seekParameters2) {
        this.handler.obtainMessage(5, seekParameters2).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z11) {
        this.handler.obtainMessage(12, z11 ? 1 : 0, 0).sendToTarget();
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(21, shuffleOrder).sendToTarget();
    }

    public void stop() {
        this.handler.obtainMessage(6).sendToTarget();
    }

    private void enableRenderers(boolean[] zArr) throws ExoPlaybackException {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
        for (int i11 = 0; i11 < this.renderers.length; i11++) {
            if (!trackSelectorResult.isRendererEnabled(i11)) {
                this.renderers[i11].reset();
            }
        }
        for (int i12 = 0; i12 < this.renderers.length; i12++) {
            if (trackSelectorResult.isRendererEnabled(i12)) {
                enableRenderer(i12, zArr[i12]);
            }
        }
        readingPeriod.allRenderersInCorrectState = true;
    }

    private long getTotalBufferedDurationUs(long j11) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0;
        }
        return Math.max(0, j11 - loadingPeriod.toPeriodTime(this.rendererPositionUs));
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, float f11, boolean z11, boolean z12) throws ExoPlaybackException {
        if (z11) {
            if (z12) {
                this.playbackInfoUpdate.incrementPendingOperationAcks(1);
            }
            this.playbackInfo = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
        }
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
        for (Renderer renderer : this.renderers) {
            if (renderer != null) {
                renderer.setPlaybackSpeed(f11, playbackParameters.speed);
            }
        }
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j11, boolean z11, boolean z12) throws ExoPlaybackException {
        stopRenderers();
        this.isRebuffering = false;
        if (z12 || this.playbackInfo.playbackState == 3) {
            setState(2);
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder mediaPeriodHolder = playingPeriod;
        while (mediaPeriodHolder != null && !mediaPeriodId.equals(mediaPeriodHolder.info.f65678id)) {
            mediaPeriodHolder = mediaPeriodHolder.getNext();
        }
        if (z11 || playingPeriod != mediaPeriodHolder || (mediaPeriodHolder != null && mediaPeriodHolder.toRendererTime(j11) < 0)) {
            for (Renderer disableRenderer : this.renderers) {
                disableRenderer(disableRenderer);
            }
            if (mediaPeriodHolder != null) {
                while (this.queue.getPlayingPeriod() != mediaPeriodHolder) {
                    this.queue.advancePlayingPeriod();
                }
                this.queue.removeAfter(mediaPeriodHolder);
                mediaPeriodHolder.setRendererOffset(0);
                enableRenderers();
            }
        }
        if (mediaPeriodHolder != null) {
            this.queue.removeAfter(mediaPeriodHolder);
            if (!mediaPeriodHolder.prepared) {
                mediaPeriodHolder.info = mediaPeriodHolder.info.copyWithStartPositionUs(j11);
            } else {
                long j12 = mediaPeriodHolder.info.durationUs;
                if (j12 != -9223372036854775807L && j11 >= j12) {
                    j11 = Math.max(0, j12 - 1);
                }
                if (mediaPeriodHolder.hasEnabledTracks) {
                    long seekToUs = mediaPeriodHolder.mediaPeriod.seekToUs(j11);
                    mediaPeriodHolder.mediaPeriod.discardBuffer(seekToUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
                    j11 = seekToUs;
                }
            }
            resetRendererPosition(j11);
            maybeContinueLoading();
        } else {
            this.queue.clear();
            resetRendererPosition(j11);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return j11;
    }
}
