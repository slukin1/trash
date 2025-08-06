package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import java.util.Collections;
import java.util.List;

public final class PlaybackStats {
    public static final PlaybackStats EMPTY = merge(new PlaybackStats[0]);
    public static final int PLAYBACK_STATE_ABANDONED = 15;
    public static final int PLAYBACK_STATE_BUFFERING = 6;
    public static final int PLAYBACK_STATE_COUNT = 16;
    public static final int PLAYBACK_STATE_ENDED = 11;
    public static final int PLAYBACK_STATE_FAILED = 13;
    public static final int PLAYBACK_STATE_INTERRUPTED_BY_AD = 14;
    public static final int PLAYBACK_STATE_JOINING_BACKGROUND = 1;
    public static final int PLAYBACK_STATE_JOINING_FOREGROUND = 2;
    public static final int PLAYBACK_STATE_NOT_STARTED = 0;
    public static final int PLAYBACK_STATE_PAUSED = 4;
    public static final int PLAYBACK_STATE_PAUSED_BUFFERING = 7;
    public static final int PLAYBACK_STATE_PLAYING = 3;
    public static final int PLAYBACK_STATE_SEEKING = 5;
    public static final int PLAYBACK_STATE_STOPPED = 12;
    public static final int PLAYBACK_STATE_SUPPRESSED = 9;
    public static final int PLAYBACK_STATE_SUPPRESSED_BUFFERING = 10;
    public final int abandonedBeforeReadyCount;
    public final int adPlaybackCount;
    public final List<EventTimeAndFormat> audioFormatHistory;
    public final int backgroundJoiningCount;
    public final int endedCount;
    public final int fatalErrorCount;
    public final List<EventTimeAndException> fatalErrorHistory;
    public final int fatalErrorPlaybackCount;
    public final long firstReportedTimeMs;
    public final int foregroundPlaybackCount;
    public final int initialAudioFormatBitrateCount;
    public final int initialVideoFormatBitrateCount;
    public final int initialVideoFormatHeightCount;
    public final long maxRebufferTimeMs;
    public final List<long[]> mediaTimeHistory;
    public final int nonFatalErrorCount;
    public final List<EventTimeAndException> nonFatalErrorHistory;
    public final int playbackCount;
    private final long[] playbackStateDurationsMs;
    public final List<EventTimeAndPlaybackState> playbackStateHistory;
    public final long totalAudioFormatBitrateTimeProduct;
    public final long totalAudioFormatTimeMs;
    public final long totalAudioUnderruns;
    public final long totalBandwidthBytes;
    public final long totalBandwidthTimeMs;
    public final long totalDroppedFrames;
    public final long totalInitialAudioFormatBitrate;
    public final long totalInitialVideoFormatBitrate;
    public final int totalInitialVideoFormatHeight;
    public final int totalPauseBufferCount;
    public final int totalPauseCount;
    public final int totalRebufferCount;
    public final int totalSeekCount;
    public final long totalValidJoinTimeMs;
    public final long totalVideoFormatBitrateTimeMs;
    public final long totalVideoFormatBitrateTimeProduct;
    public final long totalVideoFormatHeightTimeMs;
    public final long totalVideoFormatHeightTimeProduct;
    public final int validJoinTimeCount;
    public final List<EventTimeAndFormat> videoFormatHistory;

    public static final class EventTimeAndException {
        public final AnalyticsListener.EventTime eventTime;
        public final Exception exception;

        public EventTimeAndException(AnalyticsListener.EventTime eventTime2, Exception exc) {
            this.eventTime = eventTime2;
            this.exception = exc;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EventTimeAndException.class != obj.getClass()) {
                return false;
            }
            EventTimeAndException eventTimeAndException = (EventTimeAndException) obj;
            if (!this.eventTime.equals(eventTimeAndException.eventTime)) {
                return false;
            }
            return this.exception.equals(eventTimeAndException.exception);
        }

        public int hashCode() {
            return (this.eventTime.hashCode() * 31) + this.exception.hashCode();
        }
    }

    public static final class EventTimeAndFormat {
        public final AnalyticsListener.EventTime eventTime;
        public final Format format;

        public EventTimeAndFormat(AnalyticsListener.EventTime eventTime2, Format format2) {
            this.eventTime = eventTime2;
            this.format = format2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EventTimeAndFormat.class != obj.getClass()) {
                return false;
            }
            EventTimeAndFormat eventTimeAndFormat = (EventTimeAndFormat) obj;
            if (!this.eventTime.equals(eventTimeAndFormat.eventTime)) {
                return false;
            }
            Format format2 = this.format;
            Format format3 = eventTimeAndFormat.format;
            if (format2 != null) {
                return format2.equals(format3);
            }
            if (format3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.eventTime.hashCode() * 31;
            Format format2 = this.format;
            return hashCode + (format2 != null ? format2.hashCode() : 0);
        }
    }

    public static final class EventTimeAndPlaybackState {
        public final AnalyticsListener.EventTime eventTime;
        public final int playbackState;

        public EventTimeAndPlaybackState(AnalyticsListener.EventTime eventTime2, int i11) {
            this.eventTime = eventTime2;
            this.playbackState = i11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EventTimeAndPlaybackState.class != obj.getClass()) {
                return false;
            }
            EventTimeAndPlaybackState eventTimeAndPlaybackState = (EventTimeAndPlaybackState) obj;
            if (this.playbackState != eventTimeAndPlaybackState.playbackState) {
                return false;
            }
            return this.eventTime.equals(eventTimeAndPlaybackState.eventTime);
        }

        public int hashCode() {
            return (this.eventTime.hashCode() * 31) + this.playbackState;
        }
    }

    public PlaybackStats(int i11, long[] jArr, List<EventTimeAndPlaybackState> list, List<long[]> list2, long j11, int i12, int i13, int i14, int i15, long j12, int i16, int i17, int i18, int i19, int i21, long j13, int i22, List<EventTimeAndFormat> list3, List<EventTimeAndFormat> list4, long j14, long j15, long j16, long j17, long j18, long j19, int i23, int i24, int i25, long j21, int i26, long j22, long j23, long j24, long j25, long j26, int i27, int i28, int i29, List<EventTimeAndException> list5, List<EventTimeAndException> list6) {
        this.playbackCount = i11;
        this.playbackStateDurationsMs = jArr;
        this.playbackStateHistory = Collections.unmodifiableList(list);
        this.mediaTimeHistory = Collections.unmodifiableList(list2);
        this.firstReportedTimeMs = j11;
        this.foregroundPlaybackCount = i12;
        this.abandonedBeforeReadyCount = i13;
        this.endedCount = i14;
        this.backgroundJoiningCount = i15;
        this.totalValidJoinTimeMs = j12;
        this.validJoinTimeCount = i16;
        this.totalPauseCount = i17;
        this.totalPauseBufferCount = i18;
        this.totalSeekCount = i19;
        this.totalRebufferCount = i21;
        this.maxRebufferTimeMs = j13;
        this.adPlaybackCount = i22;
        this.videoFormatHistory = Collections.unmodifiableList(list3);
        this.audioFormatHistory = Collections.unmodifiableList(list4);
        this.totalVideoFormatHeightTimeMs = j14;
        this.totalVideoFormatHeightTimeProduct = j15;
        this.totalVideoFormatBitrateTimeMs = j16;
        this.totalVideoFormatBitrateTimeProduct = j17;
        this.totalAudioFormatTimeMs = j18;
        this.totalAudioFormatBitrateTimeProduct = j19;
        this.initialVideoFormatHeightCount = i23;
        this.initialVideoFormatBitrateCount = i24;
        this.totalInitialVideoFormatHeight = i25;
        this.totalInitialVideoFormatBitrate = j21;
        this.initialAudioFormatBitrateCount = i26;
        this.totalInitialAudioFormatBitrate = j22;
        this.totalBandwidthTimeMs = j23;
        this.totalBandwidthBytes = j24;
        this.totalDroppedFrames = j25;
        this.totalAudioUnderruns = j26;
        this.fatalErrorPlaybackCount = i27;
        this.fatalErrorCount = i28;
        this.nonFatalErrorCount = i29;
        this.fatalErrorHistory = Collections.unmodifiableList(list5);
        this.nonFatalErrorHistory = Collections.unmodifiableList(list6);
    }

    public static PlaybackStats merge(PlaybackStats... playbackStatsArr) {
        int i11;
        PlaybackStats[] playbackStatsArr2 = playbackStatsArr;
        int i12 = 16;
        long[] jArr = new long[16];
        int length = playbackStatsArr2.length;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        long j16 = 0;
        long j17 = 0;
        long j18 = 0;
        long j19 = 0;
        long j21 = 0;
        int i13 = -1;
        long j22 = -9223372036854775807L;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        long j23 = -9223372036854775807L;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        long j24 = -9223372036854775807L;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        long j25 = -1;
        int i29 = 0;
        long j26 = -1;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        while (i16 < length) {
            PlaybackStats playbackStats = playbackStatsArr2[i16];
            int i33 = i14 + playbackStats.playbackCount;
            int i34 = 0;
            while (i34 < i12) {
                jArr[i34] = jArr[i34] + playbackStats.playbackStateDurationsMs[i34];
                i34++;
                i12 = 16;
            }
            if (j23 == -9223372036854775807L) {
                j23 = playbackStats.firstReportedTimeMs;
            } else {
                long j27 = playbackStats.firstReportedTimeMs;
                if (j27 != -9223372036854775807L) {
                    j23 = Math.min(j23, j27);
                }
            }
            i15 += playbackStats.foregroundPlaybackCount;
            i17 += playbackStats.abandonedBeforeReadyCount;
            i18 += playbackStats.endedCount;
            i19 += playbackStats.backgroundJoiningCount;
            if (j24 == -9223372036854775807L) {
                j24 = playbackStats.totalValidJoinTimeMs;
            } else {
                long j28 = playbackStats.totalValidJoinTimeMs;
                if (j28 != -9223372036854775807L) {
                    j24 += j28;
                }
            }
            i21 += playbackStats.validJoinTimeCount;
            i22 += playbackStats.totalPauseCount;
            i23 += playbackStats.totalPauseBufferCount;
            i24 += playbackStats.totalSeekCount;
            i25 += playbackStats.totalRebufferCount;
            if (j22 == -9223372036854775807L) {
                j22 = playbackStats.maxRebufferTimeMs;
                i11 = i33;
            } else {
                i11 = i33;
                long j29 = playbackStats.maxRebufferTimeMs;
                if (j29 != -9223372036854775807L) {
                    j22 = Math.max(j22, j29);
                }
            }
            i26 += playbackStats.adPlaybackCount;
            j11 += playbackStats.totalVideoFormatHeightTimeMs;
            j12 += playbackStats.totalVideoFormatHeightTimeProduct;
            j13 += playbackStats.totalVideoFormatBitrateTimeMs;
            j14 += playbackStats.totalVideoFormatBitrateTimeProduct;
            j15 += playbackStats.totalAudioFormatTimeMs;
            j16 += playbackStats.totalAudioFormatBitrateTimeProduct;
            i27 += playbackStats.initialVideoFormatHeightCount;
            i28 += playbackStats.initialVideoFormatBitrateCount;
            if (i13 == -1) {
                i13 = playbackStats.totalInitialVideoFormatHeight;
            } else {
                int i35 = playbackStats.totalInitialVideoFormatHeight;
                if (i35 != -1) {
                    i13 += i35;
                }
            }
            if (j25 == -1) {
                j25 = playbackStats.totalInitialVideoFormatBitrate;
            } else {
                long j30 = playbackStats.totalInitialVideoFormatBitrate;
                if (j30 != -1) {
                    j25 += j30;
                }
            }
            i29 += playbackStats.initialAudioFormatBitrateCount;
            if (j26 == -1) {
                j26 = playbackStats.totalInitialAudioFormatBitrate;
            } else {
                long j31 = playbackStats.totalInitialAudioFormatBitrate;
                if (j31 != -1) {
                    j26 += j31;
                }
            }
            j17 += playbackStats.totalBandwidthTimeMs;
            j18 += playbackStats.totalBandwidthBytes;
            j19 += playbackStats.totalDroppedFrames;
            j21 += playbackStats.totalAudioUnderruns;
            i30 += playbackStats.fatalErrorPlaybackCount;
            i31 += playbackStats.fatalErrorCount;
            i32 += playbackStats.nonFatalErrorCount;
            i16++;
            playbackStatsArr2 = playbackStatsArr;
            i14 = i11;
            i12 = 16;
        }
        return new PlaybackStats(i14, jArr, Collections.emptyList(), Collections.emptyList(), j23, i15, i17, i18, i19, j24, i21, i22, i23, i24, i25, j22, i26, Collections.emptyList(), Collections.emptyList(), j11, j12, j13, j14, j15, j16, i27, i28, i13, j25, i29, j26, j17, j18, j19, j21, i30, i31, i32, Collections.emptyList(), Collections.emptyList());
    }

    public float getAbandonedBeforeReadyRatio() {
        int i11 = this.abandonedBeforeReadyCount;
        int i12 = this.playbackCount;
        int i13 = this.foregroundPlaybackCount;
        int i14 = i11 - (i12 - i13);
        if (i13 == 0) {
            return 0.0f;
        }
        return ((float) i14) / ((float) i13);
    }

    public float getAudioUnderrunRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.totalAudioUnderruns) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public float getDroppedFramesRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.totalDroppedFrames) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public float getEndedRatio() {
        int i11 = this.foregroundPlaybackCount;
        if (i11 == 0) {
            return 0.0f;
        }
        return ((float) this.endedCount) / ((float) i11);
    }

    public float getFatalErrorRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.fatalErrorCount) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public float getFatalErrorRatio() {
        int i11 = this.foregroundPlaybackCount;
        if (i11 == 0) {
            return 0.0f;
        }
        return ((float) this.fatalErrorPlaybackCount) / ((float) i11);
    }

    public float getJoinTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return ((float) getTotalJoinTimeMs()) / ((float) totalPlayAndWaitTimeMs);
    }

    public int getMeanAudioFormatBitrate() {
        long j11 = this.totalAudioFormatTimeMs;
        if (j11 == 0) {
            return -1;
        }
        return (int) (this.totalAudioFormatBitrateTimeProduct / j11);
    }

    public int getMeanBandwidth() {
        long j11 = this.totalBandwidthTimeMs;
        if (j11 == 0) {
            return -1;
        }
        return (int) ((this.totalBandwidthBytes * 8000) / j11);
    }

    public long getMeanElapsedTimeMs() {
        if (this.playbackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalElapsedTimeMs() / ((long) this.playbackCount);
    }

    public int getMeanInitialAudioFormatBitrate() {
        int i11 = this.initialAudioFormatBitrateCount;
        if (i11 == 0) {
            return -1;
        }
        return (int) (this.totalInitialAudioFormatBitrate / ((long) i11));
    }

    public int getMeanInitialVideoFormatBitrate() {
        int i11 = this.initialVideoFormatBitrateCount;
        if (i11 == 0) {
            return -1;
        }
        return (int) (this.totalInitialVideoFormatBitrate / ((long) i11));
    }

    public int getMeanInitialVideoFormatHeight() {
        int i11 = this.initialVideoFormatHeightCount;
        if (i11 == 0) {
            return -1;
        }
        return this.totalInitialVideoFormatHeight / i11;
    }

    public long getMeanJoinTimeMs() {
        int i11 = this.validJoinTimeCount;
        if (i11 == 0) {
            return -9223372036854775807L;
        }
        return this.totalValidJoinTimeMs / ((long) i11);
    }

    public float getMeanNonFatalErrorCount() {
        int i11 = this.foregroundPlaybackCount;
        if (i11 == 0) {
            return 0.0f;
        }
        return ((float) this.nonFatalErrorCount) / ((float) i11);
    }

    public float getMeanPauseBufferCount() {
        int i11 = this.foregroundPlaybackCount;
        if (i11 == 0) {
            return 0.0f;
        }
        return ((float) this.totalPauseBufferCount) / ((float) i11);
    }

    public float getMeanPauseCount() {
        int i11 = this.foregroundPlaybackCount;
        if (i11 == 0) {
            return 0.0f;
        }
        return ((float) this.totalPauseCount) / ((float) i11);
    }

    public long getMeanPausedTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalPausedTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public long getMeanPlayAndWaitTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalPlayAndWaitTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public long getMeanPlayTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalPlayTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public float getMeanRebufferCount() {
        int i11 = this.foregroundPlaybackCount;
        if (i11 == 0) {
            return 0.0f;
        }
        return ((float) this.totalRebufferCount) / ((float) i11);
    }

    public long getMeanRebufferTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalRebufferTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public float getMeanSeekCount() {
        int i11 = this.foregroundPlaybackCount;
        if (i11 == 0) {
            return 0.0f;
        }
        return ((float) this.totalSeekCount) / ((float) i11);
    }

    public long getMeanSeekTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalSeekTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public long getMeanSingleRebufferTimeMs() {
        if (this.totalRebufferCount == 0) {
            return -9223372036854775807L;
        }
        return (getPlaybackStateDurationMs(6) + getPlaybackStateDurationMs(7)) / ((long) this.totalRebufferCount);
    }

    public long getMeanSingleSeekTimeMs() {
        if (this.totalSeekCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalSeekTimeMs() / ((long) this.totalSeekCount);
    }

    public float getMeanTimeBetweenFatalErrors() {
        return 1.0f / getFatalErrorRate();
    }

    public float getMeanTimeBetweenNonFatalErrors() {
        return 1.0f / getNonFatalErrorRate();
    }

    public float getMeanTimeBetweenRebuffers() {
        return 1.0f / getRebufferRate();
    }

    public int getMeanVideoFormatBitrate() {
        long j11 = this.totalVideoFormatBitrateTimeMs;
        if (j11 == 0) {
            return -1;
        }
        return (int) (this.totalVideoFormatBitrateTimeProduct / j11);
    }

    public int getMeanVideoFormatHeight() {
        long j11 = this.totalVideoFormatHeightTimeMs;
        if (j11 == 0) {
            return -1;
        }
        return (int) (this.totalVideoFormatHeightTimeProduct / j11);
    }

    public long getMeanWaitTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return -9223372036854775807L;
        }
        return getTotalWaitTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public long getMediaTimeMsAtRealtimeMs(long j11) {
        if (this.mediaTimeHistory.isEmpty()) {
            return -9223372036854775807L;
        }
        int i11 = 0;
        while (i11 < this.mediaTimeHistory.size() && this.mediaTimeHistory.get(i11)[0] <= j11) {
            i11++;
        }
        if (i11 == 0) {
            return this.mediaTimeHistory.get(0)[1];
        }
        if (i11 == this.mediaTimeHistory.size()) {
            List<long[]> list = this.mediaTimeHistory;
            return list.get(list.size() - 1)[1];
        }
        int i12 = i11 - 1;
        long j12 = this.mediaTimeHistory.get(i12)[0];
        long j13 = this.mediaTimeHistory.get(i12)[1];
        long j14 = this.mediaTimeHistory.get(i11)[0];
        long j15 = this.mediaTimeHistory.get(i11)[1];
        long j16 = j14 - j12;
        if (j16 == 0) {
            return j13;
        }
        return j13 + ((long) (((float) (j15 - j13)) * (((float) (j11 - j12)) / ((float) j16))));
    }

    public float getNonFatalErrorRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.nonFatalErrorCount) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public int getPlaybackStateAtTime(long j11) {
        int i11 = 0;
        for (EventTimeAndPlaybackState next : this.playbackStateHistory) {
            if (next.eventTime.realtimeMs > j11) {
                break;
            }
            i11 = next.playbackState;
        }
        return i11;
    }

    public long getPlaybackStateDurationMs(int i11) {
        return this.playbackStateDurationsMs[i11];
    }

    public float getRebufferRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.totalRebufferCount) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public float getRebufferTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return ((float) getTotalRebufferTimeMs()) / ((float) totalPlayAndWaitTimeMs);
    }

    public float getSeekTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return ((float) getTotalSeekTimeMs()) / ((float) totalPlayAndWaitTimeMs);
    }

    public long getTotalElapsedTimeMs() {
        long j11 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            j11 += this.playbackStateDurationsMs[i11];
        }
        return j11;
    }

    public long getTotalJoinTimeMs() {
        return getPlaybackStateDurationMs(2);
    }

    public long getTotalPausedTimeMs() {
        return getPlaybackStateDurationMs(4) + getPlaybackStateDurationMs(7);
    }

    public long getTotalPlayAndWaitTimeMs() {
        return getTotalPlayTimeMs() + getTotalWaitTimeMs();
    }

    public long getTotalPlayTimeMs() {
        return getPlaybackStateDurationMs(3);
    }

    public long getTotalRebufferTimeMs() {
        return getPlaybackStateDurationMs(6);
    }

    public long getTotalSeekTimeMs() {
        return getPlaybackStateDurationMs(5);
    }

    public long getTotalWaitTimeMs() {
        return getPlaybackStateDurationMs(2) + getPlaybackStateDurationMs(6) + getPlaybackStateDurationMs(5);
    }

    public float getWaitTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return ((float) getTotalWaitTimeMs()) / ((float) totalPlayAndWaitTimeMs);
    }
}
