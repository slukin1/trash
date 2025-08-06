package com.google.android.exoplayer2.analytics;

import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.analytics.PlaybackStats;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PlaybackStatsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    private Format audioFormat;
    private long bandwidthBytes;
    private long bandwidthTimeMs;
    private final Callback callback;
    private long discontinuityFromPositionMs;
    private String discontinuityFromSession;
    private int discontinuityReason;
    private int droppedFrames;
    private PlaybackStats finishedPlaybackStats = PlaybackStats.EMPTY;
    private final boolean keepHistory;
    private Exception nonFatalException;
    private final Timeline.Period period = new Timeline.Period();
    private final Map<String, PlaybackStatsTracker> playbackStatsTrackers = new HashMap();
    private final PlaybackSessionManager sessionManager;
    private final Map<String, AnalyticsListener.EventTime> sessionStartEventTimes = new HashMap();
    private Format videoFormat;
    private VideoSize videoSize = VideoSize.UNKNOWN;

    public interface Callback {
        void onPlaybackStatsReady(AnalyticsListener.EventTime eventTime, PlaybackStats playbackStats);
    }

    public static final class PlaybackStatsTracker {
        private long audioFormatBitrateTimeProduct;
        private final List<PlaybackStats.EventTimeAndFormat> audioFormatHistory;
        private long audioFormatTimeMs;
        private long audioUnderruns;
        private long bandwidthBytes;
        private long bandwidthTimeMs;
        private Format currentAudioFormat;
        private float currentPlaybackSpeed;
        private int currentPlaybackState;
        private long currentPlaybackStateStartTimeMs;
        private Format currentVideoFormat;
        private long droppedFrames;
        private int fatalErrorCount;
        private final List<PlaybackStats.EventTimeAndException> fatalErrorHistory;
        private long firstReportedTimeMs;
        private boolean hasBeenReady;
        private boolean hasEnded;
        private boolean hasFatalError;
        private long initialAudioFormatBitrate;
        private long initialVideoFormatBitrate;
        private int initialVideoFormatHeight;
        private final boolean isAd;
        private boolean isForeground;
        private boolean isInterruptedByAd;
        private boolean isJoinTimeInvalid;
        private boolean isSeeking;
        private final boolean keepHistory;
        private long lastAudioFormatStartTimeMs;
        private long lastRebufferStartTimeMs;
        private long lastVideoFormatStartTimeMs;
        private long maxRebufferTimeMs;
        private final List<long[]> mediaTimeHistory;
        private int nonFatalErrorCount;
        private final List<PlaybackStats.EventTimeAndException> nonFatalErrorHistory;
        private int pauseBufferCount;
        private int pauseCount;
        private final long[] playbackStateDurationsMs = new long[16];
        private final List<PlaybackStats.EventTimeAndPlaybackState> playbackStateHistory;
        private int rebufferCount;
        private int seekCount;
        private boolean startedLoading;
        private long videoFormatBitrateTimeMs;
        private long videoFormatBitrateTimeProduct;
        private long videoFormatHeightTimeMs;
        private long videoFormatHeightTimeProduct;
        private final List<PlaybackStats.EventTimeAndFormat> videoFormatHistory;

        public PlaybackStatsTracker(boolean z11, AnalyticsListener.EventTime eventTime) {
            this.keepHistory = z11;
            this.playbackStateHistory = z11 ? new ArrayList<>() : Collections.emptyList();
            this.mediaTimeHistory = z11 ? new ArrayList<>() : Collections.emptyList();
            this.videoFormatHistory = z11 ? new ArrayList<>() : Collections.emptyList();
            this.audioFormatHistory = z11 ? new ArrayList<>() : Collections.emptyList();
            this.fatalErrorHistory = z11 ? new ArrayList<>() : Collections.emptyList();
            this.nonFatalErrorHistory = z11 ? new ArrayList<>() : Collections.emptyList();
            boolean z12 = false;
            this.currentPlaybackState = 0;
            this.currentPlaybackStateStartTimeMs = eventTime.realtimeMs;
            this.firstReportedTimeMs = -9223372036854775807L;
            this.maxRebufferTimeMs = -9223372036854775807L;
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.mediaPeriodId;
            if (mediaPeriodId != null && mediaPeriodId.isAd()) {
                z12 = true;
            }
            this.isAd = z12;
            this.initialAudioFormatBitrate = -1;
            this.initialVideoFormatBitrate = -1;
            this.initialVideoFormatHeight = -1;
            this.currentPlaybackSpeed = 1.0f;
        }

        private long[] guessMediaTimeBasedOnElapsedRealtime(long j11) {
            List<long[]> list = this.mediaTimeHistory;
            long[] jArr = list.get(list.size() - 1);
            return new long[]{j11, jArr[1] + ((long) (((float) (j11 - jArr[0])) * this.currentPlaybackSpeed))};
        }

        private static boolean isInvalidJoinTransition(int i11, int i12) {
            return ((i11 != 1 && i11 != 2 && i11 != 14) || i12 == 1 || i12 == 2 || i12 == 14 || i12 == 3 || i12 == 4 || i12 == 9 || i12 == 11) ? false : true;
        }

        private static boolean isPausedState(int i11) {
            return i11 == 4 || i11 == 7;
        }

        private static boolean isReadyState(int i11) {
            return i11 == 3 || i11 == 4 || i11 == 9;
        }

        private static boolean isRebufferingState(int i11) {
            return i11 == 6 || i11 == 7 || i11 == 10;
        }

        private void maybeRecordAudioFormatTime(long j11) {
            Format format;
            int i11;
            if (!(this.currentPlaybackState != 3 || (format = this.currentAudioFormat) == null || (i11 = format.bitrate) == -1)) {
                long j12 = (long) (((float) (j11 - this.lastAudioFormatStartTimeMs)) * this.currentPlaybackSpeed);
                this.audioFormatTimeMs += j12;
                this.audioFormatBitrateTimeProduct += j12 * ((long) i11);
            }
            this.lastAudioFormatStartTimeMs = j11;
        }

        private void maybeRecordVideoFormatTime(long j11) {
            Format format;
            if (this.currentPlaybackState == 3 && (format = this.currentVideoFormat) != null) {
                long j12 = (long) (((float) (j11 - this.lastVideoFormatStartTimeMs)) * this.currentPlaybackSpeed);
                int i11 = format.height;
                if (i11 != -1) {
                    this.videoFormatHeightTimeMs += j12;
                    this.videoFormatHeightTimeProduct += ((long) i11) * j12;
                }
                int i12 = format.bitrate;
                if (i12 != -1) {
                    this.videoFormatBitrateTimeMs += j12;
                    this.videoFormatBitrateTimeProduct += j12 * ((long) i12);
                }
            }
            this.lastVideoFormatStartTimeMs = j11;
        }

        private void maybeUpdateAudioFormat(AnalyticsListener.EventTime eventTime, Format format) {
            int i11;
            if (!Util.areEqual(this.currentAudioFormat, format)) {
                maybeRecordAudioFormatTime(eventTime.realtimeMs);
                if (!(format == null || this.initialAudioFormatBitrate != -1 || (i11 = format.bitrate) == -1)) {
                    this.initialAudioFormatBitrate = (long) i11;
                }
                this.currentAudioFormat = format;
                if (this.keepHistory) {
                    this.audioFormatHistory.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
                }
            }
        }

        private void maybeUpdateMaxRebufferTimeMs(long j11) {
            if (isRebufferingState(this.currentPlaybackState)) {
                long j12 = j11 - this.lastRebufferStartTimeMs;
                long j13 = this.maxRebufferTimeMs;
                if (j13 == -9223372036854775807L || j12 > j13) {
                    this.maxRebufferTimeMs = j12;
                }
            }
        }

        private void maybeUpdateMediaTimeHistory(long j11, long j12) {
            long[] jArr;
            if (this.keepHistory) {
                if (this.currentPlaybackState != 3) {
                    if (j12 != -9223372036854775807L) {
                        if (!this.mediaTimeHistory.isEmpty()) {
                            List<long[]> list = this.mediaTimeHistory;
                            long j13 = list.get(list.size() - 1)[1];
                            if (j13 != j12) {
                                this.mediaTimeHistory.add(new long[]{j11, j13});
                            }
                        }
                    } else {
                        return;
                    }
                }
                List<long[]> list2 = this.mediaTimeHistory;
                if (j12 == -9223372036854775807L) {
                    jArr = guessMediaTimeBasedOnElapsedRealtime(j11);
                } else {
                    jArr = new long[]{j11, j12};
                }
                list2.add(jArr);
            }
        }

        private void maybeUpdateVideoFormat(AnalyticsListener.EventTime eventTime, Format format) {
            int i11;
            int i12;
            if (!Util.areEqual(this.currentVideoFormat, format)) {
                maybeRecordVideoFormatTime(eventTime.realtimeMs);
                if (format != null) {
                    if (this.initialVideoFormatHeight == -1 && (i12 = format.height) != -1) {
                        this.initialVideoFormatHeight = i12;
                    }
                    if (this.initialVideoFormatBitrate == -1 && (i11 = format.bitrate) != -1) {
                        this.initialVideoFormatBitrate = (long) i11;
                    }
                }
                this.currentVideoFormat = format;
                if (this.keepHistory) {
                    this.videoFormatHistory.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
                }
            }
        }

        private int resolveNewPlaybackState(Player player) {
            int playbackState = player.getPlaybackState();
            if (this.isSeeking && this.isForeground) {
                return 5;
            }
            if (this.hasFatalError) {
                return 13;
            }
            if (!this.isForeground) {
                return this.startedLoading ? 1 : 0;
            }
            if (this.isInterruptedByAd) {
                return 14;
            }
            if (playbackState == 4) {
                return 11;
            }
            if (playbackState == 2) {
                int i11 = this.currentPlaybackState;
                if (i11 == 0 || i11 == 1 || i11 == 2 || i11 == 14) {
                    return 2;
                }
                if (!player.getPlayWhenReady()) {
                    return 7;
                }
                return player.getPlaybackSuppressionReason() != 0 ? 10 : 6;
            } else if (playbackState == 3) {
                if (!player.getPlayWhenReady()) {
                    return 4;
                }
                if (player.getPlaybackSuppressionReason() != 0) {
                    return 9;
                }
                return 3;
            } else if (playbackState != 1 || this.currentPlaybackState == 0) {
                return this.currentPlaybackState;
            } else {
                return 12;
            }
        }

        private void updatePlaybackState(int i11, AnalyticsListener.EventTime eventTime) {
            boolean z11 = false;
            Assertions.checkArgument(eventTime.realtimeMs >= this.currentPlaybackStateStartTimeMs);
            long j11 = eventTime.realtimeMs;
            long[] jArr = this.playbackStateDurationsMs;
            int i12 = this.currentPlaybackState;
            jArr[i12] = jArr[i12] + (j11 - this.currentPlaybackStateStartTimeMs);
            if (this.firstReportedTimeMs == -9223372036854775807L) {
                this.firstReportedTimeMs = j11;
            }
            this.isJoinTimeInvalid |= isInvalidJoinTransition(i12, i11);
            this.hasBeenReady |= isReadyState(i11);
            boolean z12 = this.hasEnded;
            if (i11 == 11) {
                z11 = true;
            }
            this.hasEnded = z12 | z11;
            if (!isPausedState(this.currentPlaybackState) && isPausedState(i11)) {
                this.pauseCount++;
            }
            if (i11 == 5) {
                this.seekCount++;
            }
            if (!isRebufferingState(this.currentPlaybackState) && isRebufferingState(i11)) {
                this.rebufferCount++;
                this.lastRebufferStartTimeMs = eventTime.realtimeMs;
            }
            if (isRebufferingState(this.currentPlaybackState) && this.currentPlaybackState != 7 && i11 == 7) {
                this.pauseBufferCount++;
            }
            maybeUpdateMaxRebufferTimeMs(eventTime.realtimeMs);
            this.currentPlaybackState = i11;
            this.currentPlaybackStateStartTimeMs = eventTime.realtimeMs;
            if (this.keepHistory) {
                this.playbackStateHistory.add(new PlaybackStats.EventTimeAndPlaybackState(eventTime, i11));
            }
        }

        public PlaybackStats build(boolean z11) {
            ArrayList arrayList;
            long[] jArr;
            long j11;
            long[] jArr2 = this.playbackStateDurationsMs;
            List<long[]> list = this.mediaTimeHistory;
            if (!z11) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long[] copyOf = Arrays.copyOf(this.playbackStateDurationsMs, 16);
                long max = Math.max(0, elapsedRealtime - this.currentPlaybackStateStartTimeMs);
                int i11 = this.currentPlaybackState;
                copyOf[i11] = copyOf[i11] + max;
                maybeUpdateMaxRebufferTimeMs(elapsedRealtime);
                maybeRecordVideoFormatTime(elapsedRealtime);
                maybeRecordAudioFormatTime(elapsedRealtime);
                ArrayList arrayList2 = new ArrayList(this.mediaTimeHistory);
                if (this.keepHistory && this.currentPlaybackState == 3) {
                    arrayList2.add(guessMediaTimeBasedOnElapsedRealtime(elapsedRealtime));
                }
                jArr = copyOf;
                arrayList = arrayList2;
            } else {
                jArr = jArr2;
                arrayList = list;
            }
            int i12 = (this.isJoinTimeInvalid || !this.hasBeenReady) ? 1 : 0;
            if (i12 != 0) {
                j11 = -9223372036854775807L;
            } else {
                j11 = jArr[2];
            }
            long j12 = j11;
            int i13 = jArr[1] > 0 ? 1 : 0;
            List arrayList3 = z11 ? this.videoFormatHistory : new ArrayList(this.videoFormatHistory);
            List arrayList4 = z11 ? this.audioFormatHistory : new ArrayList(this.audioFormatHistory);
            List arrayList5 = z11 ? this.playbackStateHistory : new ArrayList(this.playbackStateHistory);
            long j13 = this.firstReportedTimeMs;
            boolean z12 = this.isForeground;
            boolean z13 = !this.hasBeenReady;
            boolean z14 = this.hasEnded;
            int i14 = i12 ^ 1;
            int i15 = this.pauseCount;
            int i16 = this.pauseBufferCount;
            int i17 = this.seekCount;
            int i18 = this.rebufferCount;
            int i19 = i16;
            long j14 = this.maxRebufferTimeMs;
            boolean z15 = this.isAd;
            long[] jArr3 = jArr;
            long j15 = this.videoFormatHeightTimeMs;
            long j16 = this.videoFormatHeightTimeProduct;
            long j17 = this.videoFormatBitrateTimeMs;
            long j18 = this.videoFormatBitrateTimeProduct;
            long j19 = this.audioFormatTimeMs;
            long j21 = this.audioFormatBitrateTimeProduct;
            int i21 = this.initialVideoFormatHeight;
            int i22 = i21;
            int i23 = i21 == -1 ? 0 : 1;
            long j22 = this.initialVideoFormatBitrate;
            long j23 = j22;
            int i24 = j22 == -1 ? 0 : 1;
            long j24 = this.initialAudioFormatBitrate;
            long j25 = j24;
            int i25 = j24 == -1 ? 0 : 1;
            long j26 = this.bandwidthTimeMs;
            long j27 = this.bandwidthBytes;
            long j28 = this.droppedFrames;
            long j29 = this.audioUnderruns;
            int i26 = this.fatalErrorCount;
            return new PlaybackStats(1, jArr3, arrayList5, arrayList, j13, z12 ? 1 : 0, z13 ? 1 : 0, z14 ? 1 : 0, i13, j12, i14, i15, i19, i17, i18, j14, z15 ? 1 : 0, arrayList3, arrayList4, j15, j16, j17, j18, j19, j21, i23, i24, i22, j23, i25, j25, j26, j27, j28, j29, i26 > 0 ? 1 : 0, i26, this.nonFatalErrorCount, this.fatalErrorHistory, this.nonFatalErrorHistory);
        }

        public void onEvents(Player player, AnalyticsListener.EventTime eventTime, boolean z11, long j11, boolean z12, int i11, boolean z13, boolean z14, ExoPlaybackException exoPlaybackException, Exception exc, long j12, long j13, Format format, Format format2, VideoSize videoSize) {
            AnalyticsListener.EventTime eventTime2 = eventTime;
            long j14 = j11;
            ExoPlaybackException exoPlaybackException2 = exoPlaybackException;
            Exception exc2 = exc;
            Format format3 = format;
            Format format4 = format2;
            VideoSize videoSize2 = videoSize;
            if (j14 != -9223372036854775807L) {
                maybeUpdateMediaTimeHistory(eventTime2.realtimeMs, j14);
                this.isSeeking = true;
            }
            if (player.getPlaybackState() != 2) {
                this.isSeeking = false;
            }
            int playbackState = player.getPlaybackState();
            if (playbackState == 1 || playbackState == 4 || z12) {
                this.isInterruptedByAd = false;
            }
            if (exoPlaybackException2 != null) {
                this.hasFatalError = true;
                this.fatalErrorCount++;
                if (this.keepHistory) {
                    this.fatalErrorHistory.add(new PlaybackStats.EventTimeAndException(eventTime2, exoPlaybackException2));
                }
            } else if (player.getPlayerError() == null) {
                this.hasFatalError = false;
            }
            if (this.isForeground && !this.isInterruptedByAd) {
                boolean z15 = false;
                boolean z16 = false;
                for (TrackSelection trackSelection : player.getCurrentTrackSelections().getAll()) {
                    if (trackSelection != null && trackSelection.length() > 0) {
                        int trackType = MimeTypes.getTrackType(trackSelection.getFormat(0).sampleMimeType);
                        if (trackType == 2) {
                            z15 = true;
                        } else if (trackType == 1) {
                            z16 = true;
                        }
                    }
                }
                if (!z15) {
                    maybeUpdateVideoFormat(eventTime2, (Format) null);
                }
                if (!z16) {
                    maybeUpdateAudioFormat(eventTime2, (Format) null);
                }
            }
            if (format3 != null) {
                maybeUpdateVideoFormat(eventTime2, format3);
            }
            if (format4 != null) {
                maybeUpdateAudioFormat(eventTime2, format4);
            }
            Format format5 = this.currentVideoFormat;
            if (!(format5 == null || format5.height != -1 || videoSize2 == null)) {
                maybeUpdateVideoFormat(eventTime2, format5.buildUpon().setWidth(videoSize2.width).setHeight(videoSize2.height).build());
            }
            if (z14) {
                this.startedLoading = true;
            }
            if (z13) {
                this.audioUnderruns++;
            }
            this.droppedFrames += (long) i11;
            this.bandwidthTimeMs += j12;
            this.bandwidthBytes += j13;
            if (exc2 != null) {
                this.nonFatalErrorCount++;
                if (this.keepHistory) {
                    this.nonFatalErrorHistory.add(new PlaybackStats.EventTimeAndException(eventTime2, exc2));
                }
            }
            int resolveNewPlaybackState = resolveNewPlaybackState(player);
            float f11 = player.getPlaybackParameters().speed;
            if (!(this.currentPlaybackState == resolveNewPlaybackState && this.currentPlaybackSpeed == f11)) {
                maybeUpdateMediaTimeHistory(eventTime2.realtimeMs, z11 ? eventTime2.eventPlaybackPositionMs : -9223372036854775807L);
                maybeRecordVideoFormatTime(eventTime2.realtimeMs);
                maybeRecordAudioFormatTime(eventTime2.realtimeMs);
            }
            this.currentPlaybackSpeed = f11;
            if (this.currentPlaybackState != resolveNewPlaybackState) {
                updatePlaybackState(resolveNewPlaybackState, eventTime2);
            }
        }

        public void onFinished(AnalyticsListener.EventTime eventTime, boolean z11, long j11) {
            int i11 = 11;
            if (this.currentPlaybackState != 11 && !z11) {
                i11 = 15;
            }
            maybeUpdateMediaTimeHistory(eventTime.realtimeMs, j11);
            maybeRecordVideoFormatTime(eventTime.realtimeMs);
            maybeRecordAudioFormatTime(eventTime.realtimeMs);
            updatePlaybackState(i11, eventTime);
        }

        public void onForeground() {
            this.isForeground = true;
        }

        public void onInterruptedByAd() {
            this.isInterruptedByAd = true;
            this.isSeeking = false;
        }
    }

    public PlaybackStatsListener(boolean z11, Callback callback2) {
        this.callback = callback2;
        this.keepHistory = z11;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.sessionManager = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.setListener(this);
    }

    private Pair<AnalyticsListener.EventTime, Boolean> findBestEventTime(AnalyticsListener.Events events, String str) {
        MediaSource.MediaPeriodId mediaPeriodId;
        AnalyticsListener.Events events2 = events;
        String str2 = str;
        AnalyticsListener.EventTime eventTime = null;
        boolean z11 = false;
        for (int i11 = 0; i11 < events.size(); i11++) {
            AnalyticsListener.EventTime eventTime2 = events2.getEventTime(events2.get(i11));
            boolean belongsToSession = this.sessionManager.belongsToSession(eventTime2, str2);
            if (eventTime == null || ((belongsToSession && !z11) || (belongsToSession == z11 && eventTime2.realtimeMs > eventTime.realtimeMs))) {
                eventTime = eventTime2;
                z11 = belongsToSession;
            }
        }
        Assertions.checkNotNull(eventTime);
        if (!z11 && (mediaPeriodId = eventTime.mediaPeriodId) != null && mediaPeriodId.isAd()) {
            long adGroupTimeUs = eventTime.timeline.getPeriodByUid(eventTime.mediaPeriodId.periodUid, this.period).getAdGroupTimeUs(eventTime.mediaPeriodId.adGroupIndex);
            if (adGroupTimeUs == Long.MIN_VALUE) {
                adGroupTimeUs = this.period.durationUs;
            }
            long positionInWindowUs = adGroupTimeUs + this.period.getPositionInWindowUs();
            long j11 = eventTime.realtimeMs;
            Timeline timeline = eventTime.timeline;
            int i12 = eventTime.windowIndex;
            MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.mediaPeriodId;
            AnalyticsListener.EventTime eventTime3 = new AnalyticsListener.EventTime(j11, timeline, i12, new MediaSource.MediaPeriodId(mediaPeriodId2.periodUid, mediaPeriodId2.windowSequenceNumber, mediaPeriodId2.adGroupIndex), C.usToMs(positionInWindowUs), eventTime.timeline, eventTime.currentWindowIndex, eventTime.currentMediaPeriodId, eventTime.currentPlaybackPositionMs, eventTime.totalBufferedDurationMs);
            z11 = this.sessionManager.belongsToSession(eventTime3, str);
            eventTime = eventTime3;
        }
        return Pair.create(eventTime, Boolean.valueOf(z11));
    }

    private boolean hasEvent(AnalyticsListener.Events events, String str, int i11) {
        return events.contains(i11) && this.sessionManager.belongsToSession(events.getEventTime(i11), str);
    }

    private void maybeAddSessions(AnalyticsListener.Events events) {
        for (int i11 = 0; i11 < events.size(); i11++) {
            int i12 = events.get(i11);
            AnalyticsListener.EventTime eventTime = events.getEventTime(i12);
            if (i12 == 0) {
                this.sessionManager.updateSessionsWithTimelineChange(eventTime);
            } else if (i12 == 12) {
                this.sessionManager.updateSessionsWithDiscontinuity(eventTime, this.discontinuityReason);
            } else {
                this.sessionManager.updateSessions(eventTime);
            }
        }
    }

    public PlaybackStats getCombinedPlaybackStats() {
        int i11 = 1;
        PlaybackStats[] playbackStatsArr = new PlaybackStats[(this.playbackStatsTrackers.size() + 1)];
        playbackStatsArr[0] = this.finishedPlaybackStats;
        for (PlaybackStatsTracker build : this.playbackStatsTrackers.values()) {
            playbackStatsArr[i11] = build.build(false);
            i11++;
        }
        return PlaybackStats.merge(playbackStatsArr);
    }

    public PlaybackStats getPlaybackStats() {
        PlaybackStatsTracker playbackStatsTracker;
        String activeSessionId = this.sessionManager.getActiveSessionId();
        if (activeSessionId == null) {
            playbackStatsTracker = null;
        } else {
            playbackStatsTracker = this.playbackStatsTrackers.get(activeSessionId);
        }
        if (playbackStatsTracker == null) {
            return null;
        }
        return playbackStatsTracker.build(false);
    }

    public void onAdPlaybackStarted(AnalyticsListener.EventTime eventTime, String str, String str2) {
        ((PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.get(str))).onInterruptedByAd();
    }

    public /* synthetic */ void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        h1.a(this, eventTime, audioAttributes);
    }

    public /* synthetic */ void onAudioCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        h1.b(this, eventTime, exc);
    }

    public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11) {
        h1.c(this, eventTime, str, j11);
    }

    public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11, long j12) {
        h1.d(this, eventTime, str, j11, j12);
    }

    public /* synthetic */ void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        h1.e(this, eventTime, str);
    }

    public /* synthetic */ void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        h1.f(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        h1.g(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        h1.h(this, eventTime, format);
    }

    public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        h1.i(this, eventTime, format, decoderReuseEvaluation);
    }

    public /* synthetic */ void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j11) {
        h1.j(this, eventTime, j11);
    }

    public /* synthetic */ void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i11) {
        h1.k(this, eventTime, i11);
    }

    public /* synthetic */ void onAudioSinkError(AnalyticsListener.EventTime eventTime, Exception exc) {
        h1.l(this, eventTime, exc);
    }

    public /* synthetic */ void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i11, long j11, long j12) {
        h1.m(this, eventTime, i11, j11, j12);
    }

    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i11, long j11, long j12) {
        this.bandwidthTimeMs = (long) i11;
        this.bandwidthBytes = j11;
    }

    public /* synthetic */ void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i11, DecoderCounters decoderCounters) {
        h1.o(this, eventTime, i11, decoderCounters);
    }

    public /* synthetic */ void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i11, DecoderCounters decoderCounters) {
        h1.p(this, eventTime, i11, decoderCounters);
    }

    public /* synthetic */ void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i11, String str, long j11) {
        h1.q(this, eventTime, i11, str, j11);
    }

    public /* synthetic */ void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i11, Format format) {
        h1.r(this, eventTime, i11, format);
    }

    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        int i11 = mediaLoadData.trackType;
        if (i11 == 2 || i11 == 0) {
            this.videoFormat = mediaLoadData.trackFormat;
        } else if (i11 == 1) {
            this.audioFormat = mediaLoadData.trackFormat;
        }
    }

    public /* synthetic */ void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        h1.t(this, eventTime);
    }

    public /* synthetic */ void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        h1.u(this, eventTime);
    }

    public /* synthetic */ void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        h1.v(this, eventTime);
    }

    public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        h1.w(this, eventTime);
    }

    public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime, int i11) {
        h1.x(this, eventTime, i11);
    }

    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.nonFatalException = exc;
    }

    public /* synthetic */ void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        h1.z(this, eventTime);
    }

    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i11, long j11) {
        this.droppedFrames = i11;
    }

    public void onEvents(Player player, AnalyticsListener.Events events) {
        AnalyticsListener.Events events2 = events;
        if (events.size() != 0) {
            maybeAddSessions(events2);
            for (String next : this.playbackStatsTrackers.keySet()) {
                Pair<AnalyticsListener.EventTime, Boolean> findBestEventTime = findBestEventTime(events2, next);
                PlaybackStatsTracker playbackStatsTracker = this.playbackStatsTrackers.get(next);
                boolean hasEvent = hasEvent(events2, next, 12);
                boolean hasEvent2 = hasEvent(events2, next, 1023);
                boolean hasEvent3 = hasEvent(events2, next, 1012);
                boolean hasEvent4 = hasEvent(events2, next, 1000);
                boolean hasEvent5 = hasEvent(events2, next, 11);
                boolean z11 = hasEvent(events2, next, 1003) || hasEvent(events2, next, 1032);
                boolean hasEvent6 = hasEvent(events2, next, 1006);
                boolean hasEvent7 = hasEvent(events2, next, 1004);
                playbackStatsTracker.onEvents(player, (AnalyticsListener.EventTime) findBestEventTime.first, ((Boolean) findBestEventTime.second).booleanValue(), next.equals(this.discontinuityFromSession) ? this.discontinuityFromPositionMs : -9223372036854775807L, hasEvent, hasEvent2 ? this.droppedFrames : 0, hasEvent3, hasEvent4, hasEvent5 ? player.getPlayerError() : null, z11 ? this.nonFatalException : null, hasEvent6 ? this.bandwidthTimeMs : 0, hasEvent6 ? this.bandwidthBytes : 0, hasEvent7 ? this.videoFormat : null, hasEvent7 ? this.audioFormat : null, hasEvent(events2, next, 1028) ? this.videoSize : null);
            }
            this.videoFormat = null;
            this.audioFormat = null;
            this.discontinuityFromSession = null;
            if (events2.contains(AnalyticsListener.EVENT_PLAYER_RELEASED)) {
                this.sessionManager.finishAllSessions(events2.getEventTime(AnalyticsListener.EVENT_PLAYER_RELEASED));
            }
        }
    }

    public /* synthetic */ void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        h1.C(this, eventTime, z11);
    }

    public /* synthetic */ void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        h1.D(this, eventTime, z11);
    }

    public /* synthetic */ void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        h1.E(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        h1.F(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
        this.nonFatalException = iOException;
    }

    public /* synthetic */ void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        h1.H(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        h1.I(this, eventTime, z11);
    }

    public /* synthetic */ void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i11) {
        h1.J(this, eventTime, mediaItem, i11);
    }

    public /* synthetic */ void onMediaMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        h1.K(this, eventTime, mediaMetadata);
    }

    public /* synthetic */ void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        h1.L(this, eventTime, metadata);
    }

    public /* synthetic */ void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z11, int i11) {
        h1.M(this, eventTime, z11, i11);
    }

    public /* synthetic */ void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        h1.N(this, eventTime, playbackParameters);
    }

    public /* synthetic */ void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i11) {
        h1.O(this, eventTime, i11);
    }

    public /* synthetic */ void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i11) {
        h1.P(this, eventTime, i11);
    }

    public /* synthetic */ void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        h1.Q(this, eventTime, exoPlaybackException);
    }

    public /* synthetic */ void onPlayerReleased(AnalyticsListener.EventTime eventTime) {
        h1.R(this, eventTime);
    }

    public /* synthetic */ void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z11, int i11) {
        h1.S(this, eventTime, z11, i11);
    }

    public /* synthetic */ void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i11) {
        h1.T(this, eventTime, i11);
    }

    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11) {
        if (this.discontinuityFromSession == null) {
            this.discontinuityFromSession = this.sessionManager.getActiveSessionId();
            this.discontinuityFromPositionMs = positionInfo.positionMs;
        }
        this.discontinuityReason = i11;
    }

    public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Object obj, long j11) {
        h1.V(this, eventTime, obj, j11);
    }

    public /* synthetic */ void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i11) {
        h1.W(this, eventTime, i11);
    }

    public /* synthetic */ void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        h1.X(this, eventTime);
    }

    public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        h1.Y(this, eventTime);
    }

    public void onSessionActive(AnalyticsListener.EventTime eventTime, String str) {
        ((PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.get(str))).onForeground();
    }

    public void onSessionCreated(AnalyticsListener.EventTime eventTime, String str) {
        this.playbackStatsTrackers.put(str, new PlaybackStatsTracker(this.keepHistory, eventTime));
        this.sessionStartEventTimes.put(str, eventTime);
    }

    public void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z11) {
        PlaybackStatsTracker playbackStatsTracker = (PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.remove(str));
        AnalyticsListener.EventTime eventTime2 = (AnalyticsListener.EventTime) Assertions.checkNotNull(this.sessionStartEventTimes.remove(str));
        playbackStatsTracker.onFinished(eventTime, z11, str.equals(this.discontinuityFromSession) ? this.discontinuityFromPositionMs : -9223372036854775807L);
        PlaybackStats build = playbackStatsTracker.build(true);
        this.finishedPlaybackStats = PlaybackStats.merge(this.finishedPlaybackStats, build);
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onPlaybackStatsReady(eventTime2, build);
        }
    }

    public /* synthetic */ void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        h1.Z(this, eventTime, z11);
    }

    public /* synthetic */ void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        h1.a0(this, eventTime, z11);
    }

    public /* synthetic */ void onStaticMetadataChanged(AnalyticsListener.EventTime eventTime, List list) {
        h1.b0(this, eventTime, list);
    }

    public /* synthetic */ void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i11, int i12) {
        h1.c0(this, eventTime, i11, i12);
    }

    public /* synthetic */ void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i11) {
        h1.d0(this, eventTime, i11);
    }

    public /* synthetic */ void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        h1.e0(this, eventTime, trackGroupArray, trackSelectionArray);
    }

    public /* synthetic */ void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        h1.f0(this, eventTime, mediaLoadData);
    }

    public /* synthetic */ void onVideoCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        h1.g0(this, eventTime, exc);
    }

    public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11) {
        h1.h0(this, eventTime, str, j11);
    }

    public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11, long j12) {
        h1.i0(this, eventTime, str, j11, j12);
    }

    public /* synthetic */ void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        h1.j0(this, eventTime, str);
    }

    public /* synthetic */ void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        h1.k0(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        h1.l0(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j11, int i11) {
        h1.m0(this, eventTime, j11, i11);
    }

    public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        h1.n0(this, eventTime, format);
    }

    public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        h1.o0(this, eventTime, format, decoderReuseEvaluation);
    }

    public /* synthetic */ void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i11, int i12, int i13, float f11) {
        h1.p0(this, eventTime, i11, i12, i13, f11);
    }

    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize2) {
        this.videoSize = videoSize2;
    }

    public /* synthetic */ void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f11) {
        h1.r0(this, eventTime, f11);
    }
}
