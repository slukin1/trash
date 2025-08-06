package com.google.android.exoplayer2;

import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

final class ExoPlayerImpl extends BasePlayer implements ExoPlayer {
    private static final String TAG = "ExoPlayerImpl";
    private final AnalyticsCollector analyticsCollector;
    private final Looper applicationLooper;
    private final CopyOnWriteArraySet<ExoPlayer.AudioOffloadListener> audioOffloadListeners;
    private Player.Commands availableCommands;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    public final TrackSelectorResult emptyTrackSelectorResult;
    private boolean foregroundMode;
    private final ExoPlayerImplInternal internalPlayer;
    private final ListenerSet<Player.EventListener> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private MediaMetadata mediaMetadata;
    private final MediaSourceFactory mediaSourceFactory;
    private final List<MediaSourceHolderSnapshot> mediaSourceHolderSnapshots;
    private boolean pauseAtEndOfMediaItems;
    private boolean pendingDiscontinuity;
    private int pendingDiscontinuityReason;
    private int pendingOperationAcks;
    private int pendingPlayWhenReadyChangeReason;
    private final Timeline.Period period;
    public final Player.Commands permanentAvailableCommands;
    private PlaybackInfo playbackInfo;
    private final HandlerWrapper playbackInfoUpdateHandler;
    private final ExoPlayerImplInternal.PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private final Renderer[] renderers;
    private int repeatMode;
    private SeekParameters seekParameters;
    private boolean shuffleModeEnabled;
    private ShuffleOrder shuffleOrder;
    private final TrackSelector trackSelector;
    private final boolean useLazyPreparation;

    public static final class MediaSourceHolderSnapshot implements MediaSourceInfoHolder {
        /* access modifiers changed from: private */
        public Timeline timeline;
        private final Object uid;

        public MediaSourceHolderSnapshot(Object obj, Timeline timeline2) {
            this.uid = obj;
            this.timeline = timeline2;
        }

        public Timeline getTimeline() {
            return this.timeline;
        }

        public Object getUid() {
            return this.uid;
        }
    }

    /* JADX WARNING: type inference failed for: r33v0, types: [com.google.android.exoplayer2.Player] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.annotation.SuppressLint({"HandlerLeak"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExoPlayerImpl(com.google.android.exoplayer2.Renderer[] r19, com.google.android.exoplayer2.trackselection.TrackSelector r20, com.google.android.exoplayer2.source.MediaSourceFactory r21, com.google.android.exoplayer2.LoadControl r22, com.google.android.exoplayer2.upstream.BandwidthMeter r23, com.google.android.exoplayer2.analytics.AnalyticsCollector r24, boolean r25, com.google.android.exoplayer2.SeekParameters r26, com.google.android.exoplayer2.LivePlaybackSpeedControl r27, long r28, boolean r30, com.google.android.exoplayer2.util.Clock r31, android.os.Looper r32, com.google.android.exoplayer2.Player r33, com.google.android.exoplayer2.Player.Commands r34) {
        /*
            r18 = this;
            r0 = r18
            r2 = r19
            r6 = r23
            r9 = r24
            r15 = r31
            r14 = r32
            r18.<init>()
            int r1 = java.lang.System.identityHashCode(r18)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            java.lang.String r3 = com.google.android.exoplayer2.util.Util.DEVICE_DEBUG_INFO
            java.lang.String r4 = java.lang.String.valueOf(r1)
            int r4 = r4.length()
            int r4 = r4 + 30
            java.lang.String r5 = java.lang.String.valueOf(r3)
            int r5 = r5.length()
            int r4 = r4 + r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Init "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = " ["
            r5.append(r1)
            java.lang.String r1 = "ExoPlayerLib/2.14.1"
            r5.append(r1)
            java.lang.String r1 = "] ["
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = "]"
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            java.lang.String r3 = "ExoPlayerImpl"
            com.google.android.exoplayer2.util.Log.i(r3, r1)
            int r1 = r2.length
            r3 = 0
            if (r1 <= 0) goto L_0x005f
            r1 = 1
            goto L_0x0060
        L_0x005f:
            r1 = r3
        L_0x0060:
            com.google.android.exoplayer2.util.Assertions.checkState(r1)
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r19)
            com.google.android.exoplayer2.Renderer[] r1 = (com.google.android.exoplayer2.Renderer[]) r1
            r0.renderers = r1
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r20)
            com.google.android.exoplayer2.trackselection.TrackSelector r1 = (com.google.android.exoplayer2.trackselection.TrackSelector) r1
            r0.trackSelector = r1
            r1 = r21
            r0.mediaSourceFactory = r1
            r0.bandwidthMeter = r6
            r0.analyticsCollector = r9
            r1 = r25
            r0.useLazyPreparation = r1
            r10 = r26
            r0.seekParameters = r10
            r12 = r30
            r0.pauseAtEndOfMediaItems = r12
            r0.applicationLooper = r14
            r0.clock = r15
            r0.repeatMode = r3
            if (r33 == 0) goto L_0x0092
            r1 = r33
            goto L_0x0093
        L_0x0092:
            r1 = r0
        L_0x0093:
            com.google.android.exoplayer2.util.ListenerSet r4 = new com.google.android.exoplayer2.util.ListenerSet
            com.google.android.exoplayer2.r r5 = new com.google.android.exoplayer2.r
            r5.<init>(r1)
            r4.<init>(r14, r15, r5)
            r0.listeners = r4
            java.util.concurrent.CopyOnWriteArraySet r4 = new java.util.concurrent.CopyOnWriteArraySet
            r4.<init>()
            r0.audioOffloadListeners = r4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r0.mediaSourceHolderSnapshots = r4
            com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder r4 = new com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder
            r4.<init>(r3)
            r0.shuffleOrder = r4
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r4 = new com.google.android.exoplayer2.trackselection.TrackSelectorResult
            int r3 = r2.length
            com.google.android.exoplayer2.RendererConfiguration[] r3 = new com.google.android.exoplayer2.RendererConfiguration[r3]
            int r5 = r2.length
            com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r5 = new com.google.android.exoplayer2.trackselection.ExoTrackSelection[r5]
            r7 = 0
            r4.<init>(r3, r5, r7)
            r0.emptyTrackSelectorResult = r4
            com.google.android.exoplayer2.Timeline$Period r3 = new com.google.android.exoplayer2.Timeline$Period
            r3.<init>()
            r0.period = r3
            com.google.android.exoplayer2.Player$Commands$Builder r3 = new com.google.android.exoplayer2.Player$Commands$Builder
            r3.<init>()
            r5 = 9
            int[] r5 = new int[r5]
            r5 = {1, 2, 8, 9, 10, 11, 12, 13, 14} // fill-array
            com.google.android.exoplayer2.Player$Commands$Builder r3 = r3.addAll((int[]) r5)
            r5 = r34
            com.google.android.exoplayer2.Player$Commands$Builder r3 = r3.addAll((com.google.android.exoplayer2.Player.Commands) r5)
            com.google.android.exoplayer2.Player$Commands r3 = r3.build()
            r0.permanentAvailableCommands = r3
            com.google.android.exoplayer2.Player$Commands$Builder r5 = new com.google.android.exoplayer2.Player$Commands$Builder
            r5.<init>()
            com.google.android.exoplayer2.Player$Commands$Builder r3 = r5.addAll((com.google.android.exoplayer2.Player.Commands) r3)
            r5 = 3
            com.google.android.exoplayer2.Player$Commands$Builder r3 = r3.add(r5)
            r5 = 7
            com.google.android.exoplayer2.Player$Commands$Builder r3 = r3.add(r5)
            com.google.android.exoplayer2.Player$Commands r3 = r3.build()
            r0.availableCommands = r3
            com.google.android.exoplayer2.MediaMetadata r3 = com.google.android.exoplayer2.MediaMetadata.EMPTY
            r0.mediaMetadata = r3
            r3 = -1
            r0.maskingWindowIndex = r3
            com.google.android.exoplayer2.util.HandlerWrapper r3 = r15.createHandler(r14, r7)
            r0.playbackInfoUpdateHandler = r3
            com.google.android.exoplayer2.e r13 = new com.google.android.exoplayer2.e
            r13.<init>(r0)
            r0.playbackInfoUpdateListener = r13
            com.google.android.exoplayer2.PlaybackInfo r3 = com.google.android.exoplayer2.PlaybackInfo.createDummy(r4)
            r0.playbackInfo = r3
            if (r9 == 0) goto L_0x0128
            r9.setPlayer(r1, r14)
            r0.addListener((com.google.android.exoplayer2.Player.Listener) r9)
            android.os.Handler r1 = new android.os.Handler
            r1.<init>(r14)
            r6.addEventListener(r1, r9)
        L_0x0128:
            com.google.android.exoplayer2.ExoPlayerImplInternal r11 = new com.google.android.exoplayer2.ExoPlayerImplInternal
            r1 = r11
            int r7 = r0.repeatMode
            boolean r8 = r0.shuffleModeEnabled
            r2 = r19
            r3 = r20
            r5 = r22
            r6 = r23
            r9 = r24
            r10 = r26
            r0 = r11
            r11 = r27
            r17 = r13
            r12 = r28
            r14 = r30
            r15 = r32
            r16 = r31
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17)
            r1 = r0
            r0 = r18
            r0.internalPlayer = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImpl.<init>(com.google.android.exoplayer2.Renderer[], com.google.android.exoplayer2.trackselection.TrackSelector, com.google.android.exoplayer2.source.MediaSourceFactory, com.google.android.exoplayer2.LoadControl, com.google.android.exoplayer2.upstream.BandwidthMeter, com.google.android.exoplayer2.analytics.AnalyticsCollector, boolean, com.google.android.exoplayer2.SeekParameters, com.google.android.exoplayer2.LivePlaybackSpeedControl, long, boolean, com.google.android.exoplayer2.util.Clock, android.os.Looper, com.google.android.exoplayer2.Player, com.google.android.exoplayer2.Player$Commands):void");
    }

    private List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders(int i11, List<MediaSource> list) {
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder(list.get(i12), this.useLazyPreparation);
            arrayList.add(mediaSourceHolder);
            this.mediaSourceHolderSnapshots.add(i12 + i11, new MediaSourceHolderSnapshot(mediaSourceHolder.uid, mediaSourceHolder.mediaSource.getTimeline()));
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndInsert(i11, arrayList.size());
        return arrayList;
    }

    private Timeline createMaskingTimeline() {
        return new PlaylistTimeline(this.mediaSourceHolderSnapshots, this.shuffleOrder);
    }

    private List<MediaSource> createMediaSources(List<MediaItem> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            arrayList.add(this.mediaSourceFactory.createMediaSource(list.get(i11)));
        }
        return arrayList;
    }

    private Pair<Boolean, Integer> evaluateMediaItemTransitionReason(PlaybackInfo playbackInfo2, PlaybackInfo playbackInfo3, boolean z11, int i11, boolean z12) {
        Timeline timeline = playbackInfo3.timeline;
        Timeline timeline2 = playbackInfo2.timeline;
        if (timeline2.isEmpty() && timeline.isEmpty()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i12 = 3;
        if (timeline2.isEmpty() != timeline.isEmpty()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (!timeline.getWindow(timeline.getPeriodByUid(playbackInfo3.periodId.periodUid, this.period).windowIndex, this.window).uid.equals(timeline2.getWindow(timeline2.getPeriodByUid(playbackInfo2.periodId.periodUid, this.period).windowIndex, this.window).uid)) {
            if (z11 && i11 == 0) {
                i12 = 1;
            } else if (z11 && i11 == 1) {
                i12 = 2;
            } else if (!z12) {
                throw new IllegalStateException();
            }
            return new Pair<>(Boolean.TRUE, Integer.valueOf(i12));
        } else if (!z11 || i11 != 0 || playbackInfo3.periodId.windowSequenceNumber >= playbackInfo2.periodId.windowSequenceNumber) {
            return new Pair<>(Boolean.FALSE, -1);
        } else {
            return new Pair<>(Boolean.TRUE, 0);
        }
    }

    private long getCurrentPositionUsInternal(PlaybackInfo playbackInfo2) {
        if (playbackInfo2.timeline.isEmpty()) {
            return C.msToUs(this.maskingWindowPositionMs);
        }
        if (playbackInfo2.periodId.isAd()) {
            return playbackInfo2.positionUs;
        }
        return periodPositionUsToWindowPositionUs(playbackInfo2.timeline, playbackInfo2.periodId, playbackInfo2.positionUs);
    }

    private int getCurrentWindowIndexInternal() {
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingWindowIndex;
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        return playbackInfo2.timeline.getPeriodByUid(playbackInfo2.periodId.periodUid, this.period).windowIndex;
    }

    private Pair<Object, Long> getPeriodPositionAfterTimelineChanged(Timeline timeline, Timeline timeline2) {
        long contentPosition = getContentPosition();
        int i11 = -1;
        if (timeline.isEmpty() || timeline2.isEmpty()) {
            boolean z11 = !timeline.isEmpty() && timeline2.isEmpty();
            if (!z11) {
                i11 = getCurrentWindowIndexInternal();
            }
            if (z11) {
                contentPosition = -9223372036854775807L;
            }
            return getPeriodPositionOrMaskWindowPosition(timeline2, i11, contentPosition);
        }
        Pair<Object, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, getCurrentWindowIndex(), C.msToUs(contentPosition));
        Object obj = ((Pair) Util.castNonNull(periodPosition)).first;
        if (timeline2.getIndexOfPeriod(obj) != -1) {
            return periodPosition;
        }
        Object resolveSubsequentPeriod = ExoPlayerImplInternal.resolveSubsequentPeriod(this.window, this.period, this.repeatMode, this.shuffleModeEnabled, obj, timeline, timeline2);
        if (resolveSubsequentPeriod == null) {
            return getPeriodPositionOrMaskWindowPosition(timeline2, -1, -9223372036854775807L);
        }
        timeline2.getPeriodByUid(resolveSubsequentPeriod, this.period);
        int i12 = this.period.windowIndex;
        return getPeriodPositionOrMaskWindowPosition(timeline2, i12, timeline2.getWindow(i12, this.window).getDefaultPositionMs());
    }

    private Pair<Object, Long> getPeriodPositionOrMaskWindowPosition(Timeline timeline, int i11, long j11) {
        if (timeline.isEmpty()) {
            this.maskingWindowIndex = i11;
            if (j11 == -9223372036854775807L) {
                j11 = 0;
            }
            this.maskingWindowPositionMs = j11;
            this.maskingPeriodIndex = 0;
            return null;
        }
        if (i11 == -1 || i11 >= timeline.getWindowCount()) {
            i11 = timeline.getFirstWindowIndex(this.shuffleModeEnabled);
            j11 = timeline.getWindow(i11, this.window).getDefaultPositionMs();
        }
        return timeline.getPeriodPosition(this.window, this.period, i11, C.msToUs(j11));
    }

    private Player.PositionInfo getPositionInfo(long j11) {
        int i11;
        Object obj;
        int currentWindowIndex = getCurrentWindowIndex();
        Object obj2 = null;
        if (!this.playbackInfo.timeline.isEmpty()) {
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            Object obj3 = playbackInfo2.periodId.periodUid;
            playbackInfo2.timeline.getPeriodByUid(obj3, this.period);
            i11 = this.playbackInfo.timeline.getIndexOfPeriod(obj3);
            obj = obj3;
            obj2 = this.playbackInfo.timeline.getWindow(currentWindowIndex, this.window).uid;
        } else {
            i11 = -1;
            obj = null;
        }
        long usToMs = C.usToMs(j11);
        long usToMs2 = this.playbackInfo.periodId.isAd() ? C.usToMs(getRequestedContentPositionUs(this.playbackInfo)) : usToMs;
        MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        return new Player.PositionInfo(obj2, currentWindowIndex, obj, i11, usToMs, usToMs2, mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
    }

    private Player.PositionInfo getPreviousPositionInfo(int i11, PlaybackInfo playbackInfo2, int i12) {
        int i13;
        Object obj;
        int i14;
        Object obj2;
        long j11;
        long j12;
        PlaybackInfo playbackInfo3 = playbackInfo2;
        Timeline.Period period2 = new Timeline.Period();
        if (!playbackInfo3.timeline.isEmpty()) {
            Object obj3 = playbackInfo3.periodId.periodUid;
            playbackInfo3.timeline.getPeriodByUid(obj3, period2);
            int i15 = period2.windowIndex;
            i14 = i15;
            obj = obj3;
            i13 = playbackInfo3.timeline.getIndexOfPeriod(obj3);
            obj2 = playbackInfo3.timeline.getWindow(i15, this.window).uid;
        } else {
            i14 = i12;
            i13 = -1;
            obj2 = null;
            obj = null;
        }
        if (i11 == 0) {
            j11 = period2.positionInWindowUs + period2.durationUs;
            if (playbackInfo3.periodId.isAd()) {
                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo3.periodId;
                j11 = period2.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
                j12 = getRequestedContentPositionUs(playbackInfo2);
                long usToMs = C.usToMs(j11);
                long usToMs2 = C.usToMs(j12);
                MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo3.periodId;
                return new Player.PositionInfo(obj2, i14, obj, i13, usToMs, usToMs2, mediaPeriodId2.adGroupIndex, mediaPeriodId2.adIndexInAdGroup);
            } else if (playbackInfo3.periodId.nextAdGroupIndex != -1 && this.playbackInfo.periodId.isAd()) {
                j11 = getRequestedContentPositionUs(this.playbackInfo);
            }
        } else if (playbackInfo3.periodId.isAd()) {
            j11 = playbackInfo3.positionUs;
            j12 = getRequestedContentPositionUs(playbackInfo2);
            long usToMs3 = C.usToMs(j11);
            long usToMs22 = C.usToMs(j12);
            MediaSource.MediaPeriodId mediaPeriodId22 = playbackInfo3.periodId;
            return new Player.PositionInfo(obj2, i14, obj, i13, usToMs3, usToMs22, mediaPeriodId22.adGroupIndex, mediaPeriodId22.adIndexInAdGroup);
        } else {
            j11 = period2.positionInWindowUs + playbackInfo3.positionUs;
        }
        j12 = j11;
        long usToMs32 = C.usToMs(j11);
        long usToMs222 = C.usToMs(j12);
        MediaSource.MediaPeriodId mediaPeriodId222 = playbackInfo3.periodId;
        return new Player.PositionInfo(obj2, i14, obj, i13, usToMs32, usToMs222, mediaPeriodId222.adGroupIndex, mediaPeriodId222.adIndexInAdGroup);
    }

    private static long getRequestedContentPositionUs(PlaybackInfo playbackInfo2) {
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period2 = new Timeline.Period();
        playbackInfo2.timeline.getPeriodByUid(playbackInfo2.periodId.periodUid, period2);
        if (playbackInfo2.requestedContentPositionUs == -9223372036854775807L) {
            return playbackInfo2.timeline.getWindow(period2.windowIndex, window).getDefaultPositionUs();
        }
        return period2.getPositionInWindowUs() + playbackInfo2.requestedContentPositionUs;
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePlaybackInfo */
    public void lambda$new$1(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        long j11;
        boolean z11;
        long j12;
        int i11 = this.pendingOperationAcks - playbackInfoUpdate.operationAcks;
        this.pendingOperationAcks = i11;
        boolean z12 = true;
        if (playbackInfoUpdate.positionDiscontinuity) {
            this.pendingDiscontinuityReason = playbackInfoUpdate.discontinuityReason;
            this.pendingDiscontinuity = true;
        }
        if (playbackInfoUpdate.hasPlayWhenReadyChangeReason) {
            this.pendingPlayWhenReadyChangeReason = playbackInfoUpdate.playWhenReadyChangeReason;
        }
        if (i11 == 0) {
            Timeline timeline = playbackInfoUpdate.playbackInfo.timeline;
            if (!this.playbackInfo.timeline.isEmpty() && timeline.isEmpty()) {
                this.maskingWindowIndex = -1;
                this.maskingWindowPositionMs = 0;
                this.maskingPeriodIndex = 0;
            }
            if (!timeline.isEmpty()) {
                List<Timeline> childTimelines = ((PlaylistTimeline) timeline).getChildTimelines();
                Assertions.checkState(childTimelines.size() == this.mediaSourceHolderSnapshots.size());
                for (int i12 = 0; i12 < childTimelines.size(); i12++) {
                    Timeline unused = this.mediaSourceHolderSnapshots.get(i12).timeline = childTimelines.get(i12);
                }
            }
            if (this.pendingDiscontinuity) {
                if (playbackInfoUpdate.playbackInfo.periodId.equals(this.playbackInfo.periodId) && playbackInfoUpdate.playbackInfo.discontinuityStartPositionUs == this.playbackInfo.positionUs) {
                    z12 = false;
                }
                if (z12) {
                    if (timeline.isEmpty() || playbackInfoUpdate.playbackInfo.periodId.isAd()) {
                        j12 = playbackInfoUpdate.playbackInfo.discontinuityStartPositionUs;
                    } else {
                        PlaybackInfo playbackInfo2 = playbackInfoUpdate.playbackInfo;
                        j12 = periodPositionUsToWindowPositionUs(timeline, playbackInfo2.periodId, playbackInfo2.discontinuityStartPositionUs);
                    }
                    j11 = j12;
                } else {
                    j11 = -9223372036854775807L;
                }
                z11 = z12;
            } else {
                j11 = -9223372036854775807L;
                z11 = false;
            }
            this.pendingDiscontinuity = false;
            updatePlaybackInfo(playbackInfoUpdate.playbackInfo, 1, this.pendingPlayWhenReadyChangeReason, false, z11, this.pendingDiscontinuityReason, j11, -1);
        }
    }

    private static boolean isPlaying(PlaybackInfo playbackInfo2) {
        return playbackInfo2.playbackState == 3 && playbackInfo2.playWhenReady && playbackInfo2.playbackSuppressionReason == 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.playbackInfoUpdateHandler.post(new s(this, playbackInfoUpdate));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onMetadata$6(Player.EventListener eventListener) {
        eventListener.onMediaMetadataChanged(this.mediaMetadata);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateAvailableCommands$21(Player.EventListener eventListener) {
        eventListener.onAvailableCommandsChanged(this.availableCommands);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$updatePlaybackInfo$14(PlaybackInfo playbackInfo2, Player.EventListener eventListener) {
        eventListener.onLoadingChanged(playbackInfo2.isLoading);
        eventListener.onIsLoadingChanged(playbackInfo2.isLoading);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$updatePlaybackInfo$7(PlaybackInfo playbackInfo2, int i11, Player.EventListener eventListener) {
        Object obj;
        if (playbackInfo2.timeline.getWindowCount() == 1) {
            obj = playbackInfo2.timeline.getWindow(0, new Timeline.Window()).manifest;
        } else {
            obj = null;
        }
        eventListener.onTimelineChanged(playbackInfo2.timeline, obj, i11);
        eventListener.onTimelineChanged(playbackInfo2.timeline, i11);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$updatePlaybackInfo$8(int i11, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.EventListener eventListener) {
        eventListener.onPositionDiscontinuity(i11);
        eventListener.onPositionDiscontinuity(positionInfo, positionInfo2, i11);
    }

    private PlaybackInfo maskTimelineAndPosition(PlaybackInfo playbackInfo2, Timeline timeline, Pair<Object, Long> pair) {
        int i11;
        long j11;
        Timeline timeline2 = timeline;
        Pair<Object, Long> pair2 = pair;
        Assertions.checkArgument(timeline.isEmpty() || pair2 != null);
        Timeline timeline3 = playbackInfo2.timeline;
        PlaybackInfo copyWithTimeline = playbackInfo2.copyWithTimeline(timeline);
        if (timeline.isEmpty()) {
            MediaSource.MediaPeriodId dummyPeriodForEmptyTimeline = PlaybackInfo.getDummyPeriodForEmptyTimeline();
            long msToUs = C.msToUs(this.maskingWindowPositionMs);
            PlaybackInfo copyWithLoadingMediaPeriodId = copyWithTimeline.copyWithNewPosition(dummyPeriodForEmptyTimeline, msToUs, msToUs, msToUs, 0, TrackGroupArray.EMPTY, this.emptyTrackSelectorResult, ImmutableList.of()).copyWithLoadingMediaPeriodId(dummyPeriodForEmptyTimeline);
            copyWithLoadingMediaPeriodId.bufferedPositionUs = copyWithLoadingMediaPeriodId.positionUs;
            return copyWithLoadingMediaPeriodId;
        }
        Object obj = copyWithTimeline.periodId.periodUid;
        boolean z11 = !obj.equals(((Pair) Util.castNonNull(pair)).first);
        MediaSource.MediaPeriodId mediaPeriodId = z11 ? new MediaSource.MediaPeriodId(pair2.first) : copyWithTimeline.periodId;
        long longValue = ((Long) pair2.second).longValue();
        long msToUs2 = C.msToUs(getContentPosition());
        if (!timeline3.isEmpty()) {
            msToUs2 -= timeline3.getPeriodByUid(obj, this.period).getPositionInWindowUs();
        }
        if (z11 || longValue < msToUs2) {
            MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
            Assertions.checkState(!mediaPeriodId2.isAd());
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId2;
            PlaybackInfo copyWithLoadingMediaPeriodId2 = copyWithTimeline.copyWithNewPosition(mediaPeriodId3, longValue, longValue, longValue, 0, z11 ? TrackGroupArray.EMPTY : copyWithTimeline.trackGroups, z11 ? this.emptyTrackSelectorResult : copyWithTimeline.trackSelectorResult, z11 ? ImmutableList.of() : copyWithTimeline.staticMetadata).copyWithLoadingMediaPeriodId(mediaPeriodId3);
            copyWithLoadingMediaPeriodId2.bufferedPositionUs = longValue;
            return copyWithLoadingMediaPeriodId2;
        }
        if (i11 == 0) {
            int indexOfPeriod = timeline2.getIndexOfPeriod(copyWithTimeline.loadingMediaPeriodId.periodUid);
            if (indexOfPeriod == -1 || timeline2.getPeriod(indexOfPeriod, this.period).windowIndex != timeline2.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex) {
                timeline2.getPeriodByUid(mediaPeriodId.periodUid, this.period);
                if (mediaPeriodId.isAd()) {
                    j11 = this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup);
                } else {
                    j11 = this.period.durationUs;
                }
                copyWithTimeline = copyWithTimeline.copyWithNewPosition(mediaPeriodId, copyWithTimeline.positionUs, copyWithTimeline.positionUs, copyWithTimeline.discontinuityStartPositionUs, j11 - copyWithTimeline.positionUs, copyWithTimeline.trackGroups, copyWithTimeline.trackSelectorResult, copyWithTimeline.staticMetadata).copyWithLoadingMediaPeriodId(mediaPeriodId);
                copyWithTimeline.bufferedPositionUs = j11;
            }
        } else {
            MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId;
            Assertions.checkState(!mediaPeriodId4.isAd());
            long max = Math.max(0, copyWithTimeline.totalBufferedDurationUs - (longValue - msToUs2));
            long j12 = copyWithTimeline.bufferedPositionUs;
            if (copyWithTimeline.loadingMediaPeriodId.equals(copyWithTimeline.periodId)) {
                j12 = longValue + max;
            }
            copyWithTimeline = copyWithTimeline.copyWithNewPosition(mediaPeriodId4, longValue, longValue, longValue, max, copyWithTimeline.trackGroups, copyWithTimeline.trackSelectorResult, copyWithTimeline.staticMetadata);
            copyWithTimeline.bufferedPositionUs = j12;
        }
        return copyWithTimeline;
    }

    private long periodPositionUsToWindowPositionUs(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j11) {
        timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return j11 + this.period.getPositionInWindowUs();
    }

    private PlaybackInfo removeMediaItemsInternal(int i11, int i12) {
        boolean z11 = false;
        Assertions.checkArgument(i11 >= 0 && i12 >= i11 && i12 <= this.mediaSourceHolderSnapshots.size());
        int currentWindowIndex = getCurrentWindowIndex();
        Timeline currentTimeline = getCurrentTimeline();
        int size = this.mediaSourceHolderSnapshots.size();
        this.pendingOperationAcks++;
        removeMediaSourceHolders(i11, i12);
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionAfterTimelineChanged(currentTimeline, createMaskingTimeline));
        int i13 = maskTimelineAndPosition.playbackState;
        if (i13 != 1 && i13 != 4 && i11 < i12 && i12 == size && currentWindowIndex >= maskTimelineAndPosition.timeline.getWindowCount()) {
            z11 = true;
        }
        if (z11) {
            maskTimelineAndPosition = maskTimelineAndPosition.copyWithPlaybackState(4);
        }
        this.internalPlayer.removeMediaSources(i11, i12, this.shuffleOrder);
        return maskTimelineAndPosition;
    }

    private void removeMediaSourceHolders(int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            this.mediaSourceHolderSnapshots.remove(i13);
        }
        this.shuffleOrder = this.shuffleOrder.cloneAndRemove(i11, i12);
    }

    private void setMediaSourcesInternal(List<MediaSource> list, int i11, long j11, boolean z11) {
        int i12;
        long j12;
        int i13 = i11;
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        long currentPosition = getCurrentPosition();
        boolean z12 = true;
        this.pendingOperationAcks++;
        if (!this.mediaSourceHolderSnapshots.isEmpty()) {
            removeMediaSourceHolders(0, this.mediaSourceHolderSnapshots.size());
        }
        List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders = addMediaSourceHolders(0, list);
        Timeline createMaskingTimeline = createMaskingTimeline();
        if (createMaskingTimeline.isEmpty() || i13 < createMaskingTimeline.getWindowCount()) {
            long j13 = j11;
            if (z11) {
                j12 = -9223372036854775807L;
                i12 = createMaskingTimeline.getFirstWindowIndex(this.shuffleModeEnabled);
            } else if (i13 == -1) {
                i12 = currentWindowIndexInternal;
                j12 = currentPosition;
            } else {
                i12 = i13;
                j12 = j13;
            }
            PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionOrMaskWindowPosition(createMaskingTimeline, i12, j12));
            int i14 = maskTimelineAndPosition.playbackState;
            if (!(i12 == -1 || i14 == 1)) {
                i14 = (createMaskingTimeline.isEmpty() || i12 >= createMaskingTimeline.getWindowCount()) ? 4 : 2;
            }
            PlaybackInfo copyWithPlaybackState = maskTimelineAndPosition.copyWithPlaybackState(i14);
            this.internalPlayer.setMediaSources(addMediaSourceHolders, i12, C.msToUs(j12), this.shuffleOrder);
            if (this.playbackInfo.periodId.periodUid.equals(copyWithPlaybackState.periodId.periodUid) || this.playbackInfo.timeline.isEmpty()) {
                z12 = false;
            }
            updatePlaybackInfo(copyWithPlaybackState, 0, 1, false, z12, 4, getCurrentPositionUsInternal(copyWithPlaybackState), -1);
            return;
        }
        throw new IllegalSeekPositionException(createMaskingTimeline, i13, j11);
    }

    private void updateAvailableCommands() {
        Player.Commands commands = this.availableCommands;
        Player.Commands availableCommands2 = getAvailableCommands(this.permanentAvailableCommands);
        this.availableCommands = availableCommands2;
        if (!availableCommands2.equals(commands)) {
            this.listeners.queueEvent(14, new u(this));
        }
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo2, int i11, int i12, boolean z11, boolean z12, int i13, long j11, int i14) {
        PlaybackInfo playbackInfo3 = playbackInfo2;
        int i15 = i13;
        PlaybackInfo playbackInfo4 = this.playbackInfo;
        this.playbackInfo = playbackInfo3;
        Pair<Boolean, Integer> evaluateMediaItemTransitionReason = evaluateMediaItemTransitionReason(playbackInfo2, playbackInfo4, z12, i13, !playbackInfo4.timeline.equals(playbackInfo3.timeline));
        boolean booleanValue = ((Boolean) evaluateMediaItemTransitionReason.first).booleanValue();
        int intValue = ((Integer) evaluateMediaItemTransitionReason.second).intValue();
        MediaMetadata mediaMetadata2 = this.mediaMetadata;
        MediaItem mediaItem = null;
        if (booleanValue) {
            if (!playbackInfo3.timeline.isEmpty()) {
                mediaItem = playbackInfo3.timeline.getWindow(playbackInfo3.timeline.getPeriodByUid(playbackInfo3.periodId.periodUid, this.period).windowIndex, this.window).mediaItem;
            }
            this.mediaMetadata = mediaItem != null ? mediaItem.mediaMetadata : MediaMetadata.EMPTY;
        }
        if (!playbackInfo4.staticMetadata.equals(playbackInfo3.staticMetadata)) {
            mediaMetadata2 = mediaMetadata2.buildUpon().populateFromMetadata(playbackInfo3.staticMetadata).build();
        }
        boolean z13 = !mediaMetadata2.equals(this.mediaMetadata);
        this.mediaMetadata = mediaMetadata2;
        if (!playbackInfo4.timeline.equals(playbackInfo3.timeline)) {
            this.listeners.queueEvent(0, new k(playbackInfo2, i11));
        }
        if (z12) {
            this.listeners.queueEvent(12, new t(i15, getPreviousPositionInfo(i15, playbackInfo4, i14), getPositionInfo(j11)));
        }
        if (booleanValue) {
            this.listeners.queueEvent(1, new w(mediaItem, intValue));
        }
        ExoPlaybackException exoPlaybackException = playbackInfo4.playbackError;
        ExoPlaybackException exoPlaybackException2 = playbackInfo3.playbackError;
        if (!(exoPlaybackException == exoPlaybackException2 || exoPlaybackException2 == null)) {
            this.listeners.queueEvent(11, new y(playbackInfo2));
        }
        TrackSelectorResult trackSelectorResult = playbackInfo4.trackSelectorResult;
        TrackSelectorResult trackSelectorResult2 = playbackInfo3.trackSelectorResult;
        if (trackSelectorResult != trackSelectorResult2) {
            this.trackSelector.onSelectionActivated(trackSelectorResult2.info);
            this.listeners.queueEvent(2, new m(playbackInfo2, new TrackSelectionArray(playbackInfo3.trackSelectorResult.selections)));
        }
        if (!playbackInfo4.staticMetadata.equals(playbackInfo3.staticMetadata)) {
            this.listeners.queueEvent(3, new z(playbackInfo2));
        }
        if (z13) {
            this.listeners.queueEvent(15, new x(this.mediaMetadata));
        }
        if (playbackInfo4.isLoading != playbackInfo3.isLoading) {
            this.listeners.queueEvent(4, new f(playbackInfo2));
        }
        if (!(playbackInfo4.playbackState == playbackInfo3.playbackState && playbackInfo4.playWhenReady == playbackInfo3.playWhenReady)) {
            this.listeners.queueEvent(-1, new g(playbackInfo2));
        }
        if (playbackInfo4.playbackState != playbackInfo3.playbackState) {
            this.listeners.queueEvent(5, new h(playbackInfo2));
        }
        if (playbackInfo4.playWhenReady != playbackInfo3.playWhenReady) {
            this.listeners.queueEvent(6, new l(playbackInfo2, i12));
        }
        if (playbackInfo4.playbackSuppressionReason != playbackInfo3.playbackSuppressionReason) {
            this.listeners.queueEvent(7, new j(playbackInfo2));
        }
        if (isPlaying(playbackInfo4) != isPlaying(playbackInfo2)) {
            this.listeners.queueEvent(8, new a0(playbackInfo2));
        }
        if (!playbackInfo4.playbackParameters.equals(playbackInfo3.playbackParameters)) {
            this.listeners.queueEvent(13, new i(playbackInfo2));
        }
        if (z11) {
            this.listeners.queueEvent(-1, q.f65971a);
        }
        updateAvailableCommands();
        this.listeners.flushEvents();
        if (playbackInfo4.offloadSchedulingEnabled != playbackInfo3.offloadSchedulingEnabled) {
            Iterator<ExoPlayer.AudioOffloadListener> it2 = this.audioOffloadListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onExperimentalOffloadSchedulingEnabledChanged(playbackInfo3.offloadSchedulingEnabled);
            }
        }
        if (playbackInfo4.sleepingForOffload != playbackInfo3.sleepingForOffload) {
            Iterator<ExoPlayer.AudioOffloadListener> it3 = this.audioOffloadListeners.iterator();
            while (it3.hasNext()) {
                it3.next().onExperimentalSleepingForOffloadChanged(playbackInfo3.sleepingForOffload);
            }
        }
    }

    public void addAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.audioOffloadListeners.add(audioOffloadListener);
    }

    public void addListener(Player.Listener listener) {
        addListener((Player.EventListener) listener);
    }

    public void addMediaItems(int i11, List<MediaItem> list) {
        addMediaSources(Math.min(i11, this.mediaSourceHolderSnapshots.size()), createMediaSources(list));
    }

    public void addMediaSource(MediaSource mediaSource) {
        addMediaSources(Collections.singletonList(mediaSource));
    }

    public void addMediaSources(List<MediaSource> list) {
        addMediaSources(this.mediaSourceHolderSnapshots.size(), list);
    }

    public void clearVideoSurface() {
    }

    public void clearVideoSurface(Surface surface) {
    }

    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
    }

    public void clearVideoSurfaceView(SurfaceView surfaceView) {
    }

    public void clearVideoTextureView(TextureView textureView) {
    }

    public PlayerMessage createMessage(PlayerMessage.Target target) {
        return new PlayerMessage(this.internalPlayer, target, this.playbackInfo.timeline, getCurrentWindowIndex(), this.clock, this.internalPlayer.getPlaybackLooper());
    }

    public void decreaseDeviceVolume() {
    }

    public boolean experimentalIsSleepingForOffload() {
        return this.playbackInfo.sleepingForOffload;
    }

    public void experimentalSetForegroundModeTimeoutMs(long j11) {
        this.internalPlayer.experimentalSetForegroundModeTimeoutMs(j11);
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean z11) {
        this.internalPlayer.experimentalSetOffloadSchedulingEnabled(z11);
    }

    public Looper getApplicationLooper() {
        return this.applicationLooper;
    }

    public AudioAttributes getAudioAttributes() {
        return AudioAttributes.DEFAULT;
    }

    public ExoPlayer.AudioComponent getAudioComponent() {
        return null;
    }

    public Player.Commands getAvailableCommands() {
        return this.availableCommands;
    }

    public long getBufferedPosition() {
        if (!isPlayingAd()) {
            return getContentBufferedPosition();
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.loadingMediaPeriodId.equals(playbackInfo2.periodId)) {
            return C.usToMs(this.playbackInfo.bufferedPositionUs);
        }
        return getDuration();
    }

    public Clock getClock() {
        return this.clock;
    }

    public long getContentBufferedPosition() {
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingWindowPositionMs;
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.loadingMediaPeriodId.windowSequenceNumber != playbackInfo2.periodId.windowSequenceNumber) {
            return playbackInfo2.timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
        }
        long j11 = playbackInfo2.bufferedPositionUs;
        if (this.playbackInfo.loadingMediaPeriodId.isAd()) {
            PlaybackInfo playbackInfo3 = this.playbackInfo;
            Timeline.Period periodByUid = playbackInfo3.timeline.getPeriodByUid(playbackInfo3.loadingMediaPeriodId.periodUid, this.period);
            long adGroupTimeUs = periodByUid.getAdGroupTimeUs(this.playbackInfo.loadingMediaPeriodId.adGroupIndex);
            j11 = adGroupTimeUs == Long.MIN_VALUE ? periodByUid.durationUs : adGroupTimeUs;
        }
        PlaybackInfo playbackInfo4 = this.playbackInfo;
        return C.usToMs(periodPositionUsToWindowPositionUs(playbackInfo4.timeline, playbackInfo4.loadingMediaPeriodId, j11));
    }

    public long getContentPosition() {
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        playbackInfo2.timeline.getPeriodByUid(playbackInfo2.periodId.periodUid, this.period);
        PlaybackInfo playbackInfo3 = this.playbackInfo;
        if (playbackInfo3.requestedContentPositionUs == -9223372036854775807L) {
            return playbackInfo3.timeline.getWindow(getCurrentWindowIndex(), this.window).getDefaultPositionMs();
        }
        return this.period.getPositionInWindowMs() + C.usToMs(this.playbackInfo.requestedContentPositionUs);
    }

    public int getCurrentAdGroupIndex() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    public int getCurrentAdIndexInAdGroup() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    public int getCurrentPeriodIndex() {
        if (this.playbackInfo.timeline.isEmpty()) {
            return this.maskingPeriodIndex;
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        return playbackInfo2.timeline.getIndexOfPeriod(playbackInfo2.periodId.periodUid);
    }

    public long getCurrentPosition() {
        return C.usToMs(getCurrentPositionUsInternal(this.playbackInfo));
    }

    public List<Metadata> getCurrentStaticMetadata() {
        return this.playbackInfo.staticMetadata;
    }

    public Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    public TrackGroupArray getCurrentTrackGroups() {
        return this.playbackInfo.trackGroups;
    }

    public TrackSelectionArray getCurrentTrackSelections() {
        return new TrackSelectionArray(this.playbackInfo.trackSelectorResult.selections);
    }

    public int getCurrentWindowIndex() {
        int currentWindowIndexInternal = getCurrentWindowIndexInternal();
        if (currentWindowIndexInternal == -1) {
            return 0;
        }
        return currentWindowIndexInternal;
    }

    public ExoPlayer.DeviceComponent getDeviceComponent() {
        return null;
    }

    public DeviceInfo getDeviceInfo() {
        return DeviceInfo.UNKNOWN;
    }

    public int getDeviceVolume() {
        return 0;
    }

    public long getDuration() {
        if (!isPlayingAd()) {
            return getContentDuration();
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo2.periodId;
        playbackInfo2.timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period);
        return C.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
    }

    public MediaMetadata getMediaMetadata() {
        return this.mediaMetadata;
    }

    public ExoPlayer.MetadataComponent getMetadataComponent() {
        return null;
    }

    public boolean getPauseAtEndOfMediaItems() {
        return this.pauseAtEndOfMediaItems;
    }

    public boolean getPlayWhenReady() {
        return this.playbackInfo.playWhenReady;
    }

    public Looper getPlaybackLooper() {
        return this.internalPlayer.getPlaybackLooper();
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.playbackInfo.playbackParameters;
    }

    public int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    public int getPlaybackSuppressionReason() {
        return this.playbackInfo.playbackSuppressionReason;
    }

    public ExoPlaybackException getPlayerError() {
        return this.playbackInfo.playbackError;
    }

    public int getRendererCount() {
        return this.renderers.length;
    }

    public int getRendererType(int i11) {
        return this.renderers[i11].getTrackType();
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    public SeekParameters getSeekParameters() {
        return this.seekParameters;
    }

    public boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    public ExoPlayer.TextComponent getTextComponent() {
        return null;
    }

    public long getTotalBufferedDuration() {
        return C.usToMs(this.playbackInfo.totalBufferedDurationUs);
    }

    public TrackSelector getTrackSelector() {
        return this.trackSelector;
    }

    public ExoPlayer.VideoComponent getVideoComponent() {
        return null;
    }

    public VideoSize getVideoSize() {
        return VideoSize.UNKNOWN;
    }

    public float getVolume() {
        return 1.0f;
    }

    public void increaseDeviceVolume() {
    }

    public boolean isDeviceMuted() {
        return false;
    }

    public boolean isLoading() {
        return this.playbackInfo.isLoading;
    }

    public boolean isPlayingAd() {
        return this.playbackInfo.periodId.isAd();
    }

    public void moveMediaItems(int i11, int i12, int i13) {
        Assertions.checkArgument(i11 >= 0 && i11 <= i12 && i12 <= this.mediaSourceHolderSnapshots.size() && i13 >= 0);
        Timeline currentTimeline = getCurrentTimeline();
        this.pendingOperationAcks++;
        int min = Math.min(i13, this.mediaSourceHolderSnapshots.size() - (i12 - i11));
        Util.moveItems(this.mediaSourceHolderSnapshots, i11, i12, min);
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionAfterTimelineChanged(currentTimeline, createMaskingTimeline));
        this.internalPlayer.moveMediaSources(i11, i12, min, this.shuffleOrder);
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }

    public void onMetadata(Metadata metadata) {
        MediaMetadata build = this.mediaMetadata.buildUpon().populateFromMetadata(metadata).build();
        if (!build.equals(this.mediaMetadata)) {
            this.mediaMetadata = build;
            this.listeners.sendEvent(15, new v(this));
        }
    }

    public void prepare() {
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.playbackState == 1) {
            PlaybackInfo copyWithPlaybackError = playbackInfo2.copyWithPlaybackError((ExoPlaybackException) null);
            PlaybackInfo copyWithPlaybackState = copyWithPlaybackError.copyWithPlaybackState(copyWithPlaybackError.timeline.isEmpty() ? 4 : 2);
            this.pendingOperationAcks++;
            this.internalPlayer.prepare();
            updatePlaybackInfo(copyWithPlaybackState, 1, 1, false, false, 5, -9223372036854775807L, -1);
        }
    }

    public void release() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = Util.DEVICE_DEBUG_INFO;
        String registeredModules = ExoPlayerLibraryInfo.registeredModules();
        StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + 36 + String.valueOf(str).length() + String.valueOf(registeredModules).length());
        sb2.append("Release ");
        sb2.append(hexString);
        sb2.append(" [");
        sb2.append(ExoPlayerLibraryInfo.VERSION_SLASHY);
        sb2.append("] [");
        sb2.append(str);
        sb2.append("] [");
        sb2.append(registeredModules);
        sb2.append("]");
        Log.i(TAG, sb2.toString());
        if (!this.internalPlayer.release()) {
            this.listeners.sendEvent(11, o.f65950a);
        }
        this.listeners.release();
        this.playbackInfoUpdateHandler.removeCallbacksAndMessages((Object) null);
        AnalyticsCollector analyticsCollector2 = this.analyticsCollector;
        if (analyticsCollector2 != null) {
            this.bandwidthMeter.removeEventListener(analyticsCollector2);
        }
        PlaybackInfo copyWithPlaybackState = this.playbackInfo.copyWithPlaybackState(1);
        this.playbackInfo = copyWithPlaybackState;
        PlaybackInfo copyWithLoadingMediaPeriodId = copyWithPlaybackState.copyWithLoadingMediaPeriodId(copyWithPlaybackState.periodId);
        this.playbackInfo = copyWithLoadingMediaPeriodId;
        copyWithLoadingMediaPeriodId.bufferedPositionUs = copyWithLoadingMediaPeriodId.positionUs;
        this.playbackInfo.totalBufferedDurationUs = 0;
    }

    public void removeAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.audioOffloadListeners.remove(audioOffloadListener);
    }

    public void removeListener(Player.Listener listener) {
        removeListener((Player.EventListener) listener);
    }

    public void removeMediaItems(int i11, int i12) {
        PlaybackInfo removeMediaItemsInternal = removeMediaItemsInternal(i11, Math.min(i12, this.mediaSourceHolderSnapshots.size()));
        updatePlaybackInfo(removeMediaItemsInternal, 0, 1, false, !removeMediaItemsInternal.periodId.periodUid.equals(this.playbackInfo.periodId.periodUid), 4, getCurrentPositionUsInternal(removeMediaItemsInternal), -1);
    }

    @Deprecated
    public void retry() {
        prepare();
    }

    public void seekTo(int i11, long j11) {
        int i12 = i11;
        long j12 = j11;
        Timeline timeline = this.playbackInfo.timeline;
        if (i12 < 0 || (!timeline.isEmpty() && i12 >= timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(timeline, i11, j12);
        }
        int i13 = 1;
        this.pendingOperationAcks++;
        if (isPlayingAd()) {
            Log.w(TAG, "seekTo ignored because an ad is playing");
            ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = new ExoPlayerImplInternal.PlaybackInfoUpdate(this.playbackInfo);
            playbackInfoUpdate.incrementPendingOperationAcks(1);
            this.playbackInfoUpdateListener.onPlaybackInfoUpdate(playbackInfoUpdate);
            return;
        }
        if (getPlaybackState() != 1) {
            i13 = 2;
        }
        int currentWindowIndex = getCurrentWindowIndex();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo.copyWithPlaybackState(i13), timeline, getPeriodPositionOrMaskWindowPosition(timeline, i11, j12));
        this.internalPlayer.seekTo(timeline, i11, C.msToUs(j11));
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, true, true, 1, getCurrentPositionUsInternal(maskTimelineAndPosition), currentWindowIndex);
    }

    public void setDeviceMuted(boolean z11) {
    }

    public void setDeviceVolume(int i11) {
    }

    public void setForegroundMode(boolean z11) {
        if (this.foregroundMode != z11) {
            this.foregroundMode = z11;
            if (!this.internalPlayer.setForegroundMode(z11)) {
                stop(false, ExoPlaybackException.createForRenderer(new ExoTimeoutException(2)));
            }
        }
    }

    public void setMediaItems(List<MediaItem> list, boolean z11) {
        setMediaSources(createMediaSources(list), z11);
    }

    public void setMediaSource(MediaSource mediaSource) {
        setMediaSources(Collections.singletonList(mediaSource));
    }

    public void setMediaSources(List<MediaSource> list) {
        setMediaSources(list, true);
    }

    public void setPauseAtEndOfMediaItems(boolean z11) {
        if (this.pauseAtEndOfMediaItems != z11) {
            this.pauseAtEndOfMediaItems = z11;
            this.internalPlayer.setPauseAtEndOfWindow(z11);
        }
    }

    public void setPlayWhenReady(boolean z11) {
        setPlayWhenReady(z11, 0, 1);
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        if (!this.playbackInfo.playbackParameters.equals(playbackParameters)) {
            PlaybackInfo copyWithPlaybackParameters = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
            this.pendingOperationAcks++;
            this.internalPlayer.setPlaybackParameters(playbackParameters);
            updatePlaybackInfo(copyWithPlaybackParameters, 0, 1, false, false, 5, -9223372036854775807L, -1);
        }
    }

    public void setRepeatMode(int i11) {
        if (this.repeatMode != i11) {
            this.repeatMode = i11;
            this.internalPlayer.setRepeatMode(i11);
            this.listeners.queueEvent(9, new p(i11));
            updateAvailableCommands();
            this.listeners.flushEvents();
        }
    }

    public void setSeekParameters(SeekParameters seekParameters2) {
        if (seekParameters2 == null) {
            seekParameters2 = SeekParameters.DEFAULT;
        }
        if (!this.seekParameters.equals(seekParameters2)) {
            this.seekParameters = seekParameters2;
            this.internalPlayer.setSeekParameters(seekParameters2);
        }
    }

    public void setShuffleModeEnabled(boolean z11) {
        if (this.shuffleModeEnabled != z11) {
            this.shuffleModeEnabled = z11;
            this.internalPlayer.setShuffleModeEnabled(z11);
            this.listeners.queueEvent(10, new n(z11));
            updateAvailableCommands();
            this.listeners.flushEvents();
        }
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder2) {
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionOrMaskWindowPosition(createMaskingTimeline, getCurrentWindowIndex(), getCurrentPosition()));
        this.pendingOperationAcks++;
        this.shuffleOrder = shuffleOrder2;
        this.internalPlayer.setShuffleOrder(shuffleOrder2);
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }

    public void setVideoSurface(Surface surface) {
    }

    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
    }

    public void setVideoSurfaceView(SurfaceView surfaceView) {
    }

    public void setVideoTextureView(TextureView textureView) {
    }

    public void setVolume(float f11) {
    }

    public void stop(boolean z11) {
        stop(z11, (ExoPlaybackException) null);
    }

    public void addListener(Player.EventListener eventListener) {
        this.listeners.add(eventListener);
    }

    public void addMediaSource(int i11, MediaSource mediaSource) {
        addMediaSources(i11, Collections.singletonList(mediaSource));
    }

    public void addMediaSources(int i11, List<MediaSource> list) {
        Assertions.checkArgument(i11 >= 0);
        Timeline currentTimeline = getCurrentTimeline();
        this.pendingOperationAcks++;
        List<MediaSourceList.MediaSourceHolder> addMediaSourceHolders = addMediaSourceHolders(i11, list);
        Timeline createMaskingTimeline = createMaskingTimeline();
        PlaybackInfo maskTimelineAndPosition = maskTimelineAndPosition(this.playbackInfo, createMaskingTimeline, getPeriodPositionAfterTimelineChanged(currentTimeline, createMaskingTimeline));
        this.internalPlayer.addMediaSources(i11, addMediaSourceHolders, this.shuffleOrder);
        updatePlaybackInfo(maskTimelineAndPosition, 0, 1, false, false, 5, -9223372036854775807L, -1);
    }

    public ImmutableList<Cue> getCurrentCues() {
        return ImmutableList.of();
    }

    public void removeListener(Player.EventListener eventListener) {
        this.listeners.remove(eventListener);
    }

    public void setMediaItems(List<MediaItem> list, int i11, long j11) {
        setMediaSources(createMediaSources(list), i11, j11);
    }

    public void setMediaSource(MediaSource mediaSource, long j11) {
        setMediaSources(Collections.singletonList(mediaSource), 0, j11);
    }

    public void setMediaSources(List<MediaSource> list, boolean z11) {
        setMediaSourcesInternal(list, -1, -9223372036854775807L, z11);
    }

    public void setPlayWhenReady(boolean z11, int i11, int i12) {
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (playbackInfo2.playWhenReady != z11 || playbackInfo2.playbackSuppressionReason != i11) {
            this.pendingOperationAcks++;
            PlaybackInfo copyWithPlayWhenReady = playbackInfo2.copyWithPlayWhenReady(z11, i11);
            this.internalPlayer.setPlayWhenReady(z11, i11);
            updatePlaybackInfo(copyWithPlayWhenReady, 0, i12, false, false, 5, -9223372036854775807L, -1);
        }
    }

    public void stop(boolean z11, ExoPlaybackException exoPlaybackException) {
        PlaybackInfo playbackInfo2;
        if (z11) {
            playbackInfo2 = removeMediaItemsInternal(0, this.mediaSourceHolderSnapshots.size()).copyWithPlaybackError((ExoPlaybackException) null);
        } else {
            PlaybackInfo playbackInfo3 = this.playbackInfo;
            playbackInfo2 = playbackInfo3.copyWithLoadingMediaPeriodId(playbackInfo3.periodId);
            playbackInfo2.bufferedPositionUs = playbackInfo2.positionUs;
            playbackInfo2.totalBufferedDurationUs = 0;
        }
        PlaybackInfo copyWithPlaybackState = playbackInfo2.copyWithPlaybackState(1);
        if (exoPlaybackException != null) {
            copyWithPlaybackState = copyWithPlaybackState.copyWithPlaybackError(exoPlaybackException);
        }
        PlaybackInfo playbackInfo4 = copyWithPlaybackState;
        this.pendingOperationAcks++;
        this.internalPlayer.stop();
        updatePlaybackInfo(playbackInfo4, 0, 1, false, playbackInfo4.timeline.isEmpty() && !this.playbackInfo.timeline.isEmpty(), 4, getCurrentPositionUsInternal(playbackInfo4), -1);
    }

    public void setMediaSources(List<MediaSource> list, int i11, long j11) {
        setMediaSourcesInternal(list, i11, j11, false);
    }

    public void setMediaSource(MediaSource mediaSource, boolean z11) {
        setMediaSources(Collections.singletonList(mediaSource), z11);
    }

    @Deprecated
    public void prepare(MediaSource mediaSource) {
        setMediaSource(mediaSource);
        prepare();
    }

    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z11, boolean z12) {
        setMediaSource(mediaSource, z11);
        prepare();
    }
}
