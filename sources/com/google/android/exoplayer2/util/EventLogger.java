package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.h1;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.video.VideoSize;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import okhttp3.HttpUrl;

public class EventLogger implements AnalyticsListener {
    private static final String DEFAULT_TAG = "EventLogger";
    private static final int MAX_TIMELINE_ITEM_LINES = 3;
    private static final NumberFormat TIME_FORMAT;
    private final Timeline.Period period;
    private final long startTimeMs;
    private final String tag;
    private final MappingTrackSelector trackSelector;
    private final Timeline.Window window;

    static {
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        TIME_FORMAT = instance;
        instance.setMinimumFractionDigits(2);
        instance.setMaximumFractionDigits(2);
        instance.setGroupingUsed(false);
    }

    public EventLogger(MappingTrackSelector mappingTrackSelector) {
        this(mappingTrackSelector, DEFAULT_TAG);
    }

    private static String getAdaptiveSupportString(int i11, int i12) {
        if (i11 < 2) {
            return "N/A";
        }
        if (i12 == 0) {
            return "NO";
        }
        if (i12 == 8) {
            return "YES_NOT_SEAMLESS";
        }
        if (i12 == 16) {
            return "YES";
        }
        throw new IllegalStateException();
    }

    private static String getDiscontinuityReasonString(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? "?" : "INTERNAL" : "REMOVE" : "SKIP" : "SEEK_ADJUSTMENT" : "SEEK" : "AUTO_TRANSITION";
    }

    private String getEventString(AnalyticsListener.EventTime eventTime, String str, String str2, Throwable th2) {
        String eventTimeString = getEventTimeString(eventTime);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(eventTimeString).length());
        sb2.append(str);
        sb2.append(" [");
        sb2.append(eventTimeString);
        String sb3 = sb2.toString();
        if (str2 != null) {
            String valueOf = String.valueOf(sb3);
            StringBuilder sb4 = new StringBuilder(valueOf.length() + 2 + str2.length());
            sb4.append(valueOf);
            sb4.append(", ");
            sb4.append(str2);
            sb3 = sb4.toString();
        }
        String throwableString = Log.getThrowableString(th2);
        if (!TextUtils.isEmpty(throwableString)) {
            String valueOf2 = String.valueOf(sb3);
            String replace = throwableString.replace("\n", "\n  ");
            StringBuilder sb5 = new StringBuilder(valueOf2.length() + 4 + String.valueOf(replace).length());
            sb5.append(valueOf2);
            sb5.append("\n  ");
            sb5.append(replace);
            sb5.append(10);
            sb3 = sb5.toString();
        }
        return String.valueOf(sb3).concat("]");
    }

    private String getEventTimeString(AnalyticsListener.EventTime eventTime) {
        int i11 = eventTime.windowIndex;
        StringBuilder sb2 = new StringBuilder(18);
        sb2.append("window=");
        sb2.append(i11);
        String sb3 = sb2.toString();
        if (eventTime.mediaPeriodId != null) {
            String valueOf = String.valueOf(sb3);
            int indexOfPeriod = eventTime.timeline.getIndexOfPeriod(eventTime.mediaPeriodId.periodUid);
            StringBuilder sb4 = new StringBuilder(valueOf.length() + 20);
            sb4.append(valueOf);
            sb4.append(", period=");
            sb4.append(indexOfPeriod);
            sb3 = sb4.toString();
            if (eventTime.mediaPeriodId.isAd()) {
                String valueOf2 = String.valueOf(sb3);
                int i12 = eventTime.mediaPeriodId.adGroupIndex;
                StringBuilder sb5 = new StringBuilder(valueOf2.length() + 21);
                sb5.append(valueOf2);
                sb5.append(", adGroup=");
                sb5.append(i12);
                String valueOf3 = String.valueOf(sb5.toString());
                int i13 = eventTime.mediaPeriodId.adIndexInAdGroup;
                StringBuilder sb6 = new StringBuilder(valueOf3.length() + 16);
                sb6.append(valueOf3);
                sb6.append(", ad=");
                sb6.append(i13);
                sb3 = sb6.toString();
            }
        }
        String timeString = getTimeString(eventTime.realtimeMs - this.startTimeMs);
        String timeString2 = getTimeString(eventTime.eventPlaybackPositionMs);
        StringBuilder sb7 = new StringBuilder(String.valueOf(timeString).length() + 23 + String.valueOf(timeString2).length() + String.valueOf(sb3).length());
        sb7.append("eventTime=");
        sb7.append(timeString);
        sb7.append(", mediaPos=");
        sb7.append(timeString2);
        sb7.append(", ");
        sb7.append(sb3);
        return sb7.toString();
    }

    private static String getMediaItemTransitionReasonString(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? "?" : "PLAYLIST_CHANGED" : "SEEK" : "AUTO" : "REPEAT";
    }

    private static String getPlayWhenReadyChangeReasonString(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? "?" : "END_OF_MEDIA_ITEM" : "REMOTE" : "AUDIO_BECOMING_NOISY" : "AUDIO_FOCUS_LOSS" : "USER_REQUEST";
    }

    private static String getPlaybackSuppressionReasonString(int i11) {
        return i11 != 0 ? i11 != 1 ? "?" : "TRANSIENT_AUDIO_FOCUS_LOSS" : "NONE";
    }

    private static String getRepeatModeString(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? "?" : "ALL" : "ONE" : "OFF";
    }

    private static String getStateString(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "?" : "ENDED" : "READY" : "BUFFERING" : "IDLE";
    }

    private static String getTimeString(long j11) {
        return j11 == -9223372036854775807L ? "?" : TIME_FORMAT.format((double) (((float) j11) / 1000.0f));
    }

    private static String getTimelineChangeReasonString(int i11) {
        return i11 != 0 ? i11 != 1 ? "?" : "SOURCE_UPDATE" : "PLAYLIST_CHANGED";
    }

    private static String getTrackStatusString(TrackSelection trackSelection, TrackGroup trackGroup, int i11) {
        return getTrackStatusString((trackSelection == null || trackSelection.getTrackGroup() != trackGroup || trackSelection.indexOf(i11) == -1) ? false : true);
    }

    private static String getTrackStatusString(boolean z11) {
        return z11 ? "[X]" : "[ ]";
    }

    private void printInternalError(AnalyticsListener.EventTime eventTime, String str, Exception exc) {
        loge(eventTime, "internalError", str, exc);
    }

    private void printMetadata(Metadata metadata, String str) {
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            String valueOf = String.valueOf(metadata.get(i11));
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + valueOf.length());
            sb2.append(str);
            sb2.append(valueOf);
            logd(sb2.toString());
        }
    }

    public void logd(String str) {
        Log.d(this.tag, str);
    }

    public void loge(String str) {
        Log.e(this.tag, str);
    }

    public void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        int i11 = audioAttributes.contentType;
        int i12 = audioAttributes.flags;
        int i13 = audioAttributes.usage;
        int i14 = audioAttributes.allowedCapturePolicy;
        StringBuilder sb2 = new StringBuilder(47);
        sb2.append(i11);
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append(i12);
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append(i13);
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb2.append(i14);
        logd(eventTime, "audioAttributes", sb2.toString());
    }

    public /* synthetic */ void onAudioCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        h1.b(this, eventTime, exc);
    }

    public void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11) {
        logd(eventTime, "audioDecoderInitialized", str);
    }

    public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11, long j12) {
        h1.d(this, eventTime, str, j11, j12);
    }

    public void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        logd(eventTime, "audioDecoderReleased", str);
    }

    public void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "audioDisabled");
    }

    public void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "audioEnabled");
    }

    public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        h1.h(this, eventTime, format);
    }

    public void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        logd(eventTime, "audioInputFormat", Format.toLogString(format));
    }

    public /* synthetic */ void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j11) {
        h1.j(this, eventTime, j11);
    }

    public void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i11) {
        logd(eventTime, "audioSessionId", Integer.toString(i11));
    }

    public /* synthetic */ void onAudioSinkError(AnalyticsListener.EventTime eventTime, Exception exc) {
        h1.l(this, eventTime, exc);
    }

    public void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i11, long j11, long j12) {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append(i11);
        sb2.append(", ");
        sb2.append(j11);
        sb2.append(", ");
        sb2.append(j12);
        loge(eventTime, "audioTrackUnderrun", sb2.toString(), (Throwable) null);
    }

    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i11, long j11, long j12) {
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
        logd(eventTime, "downstreamFormat", Format.toLogString(mediaLoadData.trackFormat));
    }

    public void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysLoaded");
    }

    public void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRemoved");
    }

    public void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmKeysRestored");
    }

    public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
        h1.w(this, eventTime);
    }

    public void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime, int i11) {
        StringBuilder sb2 = new StringBuilder(17);
        sb2.append("state=");
        sb2.append(i11);
        logd(eventTime, "drmSessionAcquired", sb2.toString());
    }

    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        printInternalError(eventTime, "drmSessionManagerError", exc);
    }

    public void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
        logd(eventTime, "drmSessionReleased");
    }

    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i11, long j11) {
        logd(eventTime, "droppedFrames", Integer.toString(i11));
    }

    public /* synthetic */ void onEvents(Player player, AnalyticsListener.Events events) {
        h1.B(this, player, events);
    }

    public void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        logd(eventTime, "loading", Boolean.toString(z11));
    }

    public void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        logd(eventTime, "isPlaying", Boolean.toString(z11));
    }

    public void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z11) {
        printInternalError(eventTime, "loadError", iOException);
    }

    public void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        h1.I(this, eventTime, z11);
    }

    public void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i11) {
        String eventTimeString = getEventTimeString(eventTime);
        String mediaItemTransitionReasonString = getMediaItemTransitionReasonString(i11);
        StringBuilder sb2 = new StringBuilder(String.valueOf(eventTimeString).length() + 21 + String.valueOf(mediaItemTransitionReasonString).length());
        sb2.append("mediaItem [");
        sb2.append(eventTimeString);
        sb2.append(", reason=");
        sb2.append(mediaItemTransitionReasonString);
        sb2.append("]");
        logd(sb2.toString());
    }

    public /* synthetic */ void onMediaMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        h1.K(this, eventTime, mediaMetadata);
    }

    public void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        String valueOf = String.valueOf(getEventTimeString(eventTime));
        logd(valueOf.length() != 0 ? "metadata [".concat(valueOf) : new String("metadata ["));
        printMetadata(metadata, "  ");
        logd("]");
    }

    public void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z11, int i11) {
        String playWhenReadyChangeReasonString = getPlayWhenReadyChangeReasonString(i11);
        StringBuilder sb2 = new StringBuilder(String.valueOf(playWhenReadyChangeReasonString).length() + 7);
        sb2.append(z11);
        sb2.append(", ");
        sb2.append(playWhenReadyChangeReasonString);
        logd(eventTime, "playWhenReady", sb2.toString());
    }

    public void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        logd(eventTime, "playbackParameters", playbackParameters.toString());
    }

    public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i11) {
        logd(eventTime, "state", getStateString(i11));
    }

    public void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i11) {
        logd(eventTime, "playbackSuppressionReason", getPlaybackSuppressionReasonString(i11));
    }

    public void onPlayerError(AnalyticsListener.EventTime eventTime, ExoPlaybackException exoPlaybackException) {
        loge(eventTime, "playerFailed", exoPlaybackException);
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
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reason=");
        sb2.append(getDiscontinuityReasonString(i11));
        sb2.append(", PositionInfo:old [");
        sb2.append("window=");
        sb2.append(positionInfo.windowIndex);
        sb2.append(", period=");
        sb2.append(positionInfo.periodIndex);
        sb2.append(", pos=");
        sb2.append(positionInfo.positionMs);
        if (positionInfo.adGroupIndex != -1) {
            sb2.append(", contentPos=");
            sb2.append(positionInfo.contentPositionMs);
            sb2.append(", adGroup=");
            sb2.append(positionInfo.adGroupIndex);
            sb2.append(", ad=");
            sb2.append(positionInfo.adIndexInAdGroup);
        }
        sb2.append("], PositionInfo:new [");
        sb2.append("window=");
        sb2.append(positionInfo2.windowIndex);
        sb2.append(", period=");
        sb2.append(positionInfo2.periodIndex);
        sb2.append(", pos=");
        sb2.append(positionInfo2.positionMs);
        if (positionInfo2.adGroupIndex != -1) {
            sb2.append(", contentPos=");
            sb2.append(positionInfo2.contentPositionMs);
            sb2.append(", adGroup=");
            sb2.append(positionInfo2.adGroupIndex);
            sb2.append(", ad=");
            sb2.append(positionInfo2.adIndexInAdGroup);
        }
        sb2.append("]");
        logd(eventTime, "positionDiscontinuity", sb2.toString());
    }

    public void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Object obj, long j11) {
        logd(eventTime, "renderedFirstFrame", String.valueOf(obj));
    }

    public void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i11) {
        logd(eventTime, "repeatMode", getRepeatModeString(i11));
    }

    public /* synthetic */ void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
        h1.X(this, eventTime);
    }

    public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
        h1.Y(this, eventTime);
    }

    public void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        logd(eventTime, "shuffleModeEnabled", Boolean.toString(z11));
    }

    public void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z11) {
        logd(eventTime, "skipSilenceEnabled", Boolean.toString(z11));
    }

    public void onStaticMetadataChanged(AnalyticsListener.EventTime eventTime, List<Metadata> list) {
        String valueOf = String.valueOf(getEventTimeString(eventTime));
        logd(valueOf.length() != 0 ? "staticMetadata [".concat(valueOf) : new String("staticMetadata ["));
        for (int i11 = 0; i11 < list.size(); i11++) {
            Metadata metadata = list.get(i11);
            if (metadata.length() != 0) {
                StringBuilder sb2 = new StringBuilder(24);
                sb2.append("  Metadata:");
                sb2.append(i11);
                sb2.append(" [");
                logd(sb2.toString());
                printMetadata(metadata, "    ");
                logd("  ]");
            }
        }
        logd("]");
    }

    public void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i11, int i12) {
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append(i11);
        sb2.append(", ");
        sb2.append(i12);
        logd(eventTime, "surfaceSize", sb2.toString());
    }

    public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i11) {
        int periodCount = eventTime.timeline.getPeriodCount();
        int windowCount = eventTime.timeline.getWindowCount();
        String eventTimeString = getEventTimeString(eventTime);
        String timelineChangeReasonString = getTimelineChangeReasonString(i11);
        StringBuilder sb2 = new StringBuilder(String.valueOf(eventTimeString).length() + 69 + String.valueOf(timelineChangeReasonString).length());
        sb2.append("timeline [");
        sb2.append(eventTimeString);
        sb2.append(", periodCount=");
        sb2.append(periodCount);
        sb2.append(", windowCount=");
        sb2.append(windowCount);
        sb2.append(", reason=");
        sb2.append(timelineChangeReasonString);
        logd(sb2.toString());
        for (int i12 = 0; i12 < Math.min(periodCount, 3); i12++) {
            eventTime.timeline.getPeriod(i12, this.period);
            String timeString = getTimeString(this.period.getDurationMs());
            StringBuilder sb3 = new StringBuilder(String.valueOf(timeString).length() + 11);
            sb3.append("  period [");
            sb3.append(timeString);
            sb3.append("]");
            logd(sb3.toString());
        }
        if (periodCount > 3) {
            logd("  ...");
        }
        for (int i13 = 0; i13 < Math.min(windowCount, 3); i13++) {
            eventTime.timeline.getWindow(i13, this.window);
            String timeString2 = getTimeString(this.window.getDurationMs());
            Timeline.Window window2 = this.window;
            boolean z11 = window2.isSeekable;
            boolean z12 = window2.isDynamic;
            StringBuilder sb4 = new StringBuilder(String.valueOf(timeString2).length() + 42);
            sb4.append("  window [");
            sb4.append(timeString2);
            sb4.append(", seekable=");
            sb4.append(z11);
            sb4.append(", dynamic=");
            sb4.append(z12);
            sb4.append("]");
            logd(sb4.toString());
        }
        if (windowCount > 3) {
            logd("  ...");
        }
        logd("]");
    }

    public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        String str;
        String str2;
        MappingTrackSelector mappingTrackSelector = this.trackSelector;
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo = mappingTrackSelector != null ? mappingTrackSelector.getCurrentMappedTrackInfo() : null;
        if (currentMappedTrackInfo == null) {
            logd(eventTime, "tracks", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        AnalyticsListener.EventTime eventTime2 = eventTime;
        String valueOf = String.valueOf(getEventTimeString(eventTime));
        logd(valueOf.length() != 0 ? "tracks [".concat(valueOf) : new String("tracks ["));
        int rendererCount = currentMappedTrackInfo.getRendererCount();
        int i11 = 0;
        while (true) {
            str = "    Group:";
            str2 = " [";
            if (i11 >= rendererCount) {
                break;
            }
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i11);
            TrackSelection trackSelection = trackSelectionArray.get(i11);
            int i12 = rendererCount;
            if (trackGroups.length == 0) {
                String rendererName = currentMappedTrackInfo.getRendererName(i11);
                StringBuilder sb2 = new StringBuilder(String.valueOf(rendererName).length() + 5);
                sb2.append("  ");
                sb2.append(rendererName);
                sb2.append(" []");
                logd(sb2.toString());
            } else {
                String rendererName2 = currentMappedTrackInfo.getRendererName(i11);
                String str3 = "  ]";
                StringBuilder sb3 = new StringBuilder(String.valueOf(rendererName2).length() + 4);
                sb3.append("  ");
                sb3.append(rendererName2);
                sb3.append(str2);
                logd(sb3.toString());
                int i13 = 0;
                while (i13 < trackGroups.length) {
                    TrackGroup trackGroup = trackGroups.get(i13);
                    TrackGroupArray trackGroupArray2 = trackGroups;
                    String adaptiveSupportString = getAdaptiveSupportString(trackGroup.length, currentMappedTrackInfo.getAdaptiveSupport(i11, i13, false));
                    StringBuilder sb4 = new StringBuilder(String.valueOf(adaptiveSupportString).length() + 44);
                    sb4.append(str);
                    sb4.append(i13);
                    sb4.append(", adaptive_supported=");
                    sb4.append(adaptiveSupportString);
                    sb4.append(str2);
                    logd(sb4.toString());
                    int i14 = 0;
                    while (i14 < trackGroup.length) {
                        String trackStatusString = getTrackStatusString(trackSelection, trackGroup, i14);
                        String formatSupportString = C.getFormatSupportString(currentMappedTrackInfo.getTrackSupport(i11, i13, i14));
                        TrackGroup trackGroup2 = trackGroup;
                        String logString = Format.toLogString(trackGroup.getFormat(i14));
                        String str4 = str;
                        StringBuilder sb5 = new StringBuilder(String.valueOf(trackStatusString).length() + 38 + String.valueOf(logString).length() + String.valueOf(formatSupportString).length());
                        sb5.append("      ");
                        sb5.append(trackStatusString);
                        sb5.append(" Track:");
                        sb5.append(i14);
                        sb5.append(", ");
                        sb5.append(logString);
                        sb5.append(", supported=");
                        sb5.append(formatSupportString);
                        logd(sb5.toString());
                        i14++;
                        str = str4;
                        trackGroup = trackGroup2;
                        str2 = str2;
                    }
                    String str5 = str;
                    String str6 = str2;
                    logd("    ]");
                    i13++;
                    trackGroups = trackGroupArray2;
                }
                if (trackSelection != null) {
                    int i15 = 0;
                    while (true) {
                        if (i15 >= trackSelection.length()) {
                            break;
                        }
                        Metadata metadata = trackSelection.getFormat(i15).metadata;
                        if (metadata != null) {
                            logd("    Metadata [");
                            printMetadata(metadata, "      ");
                            logd("    ]");
                            break;
                        }
                        i15++;
                    }
                }
                logd(str3);
            }
            i11++;
            rendererCount = i12;
        }
        String str7 = str;
        String str8 = "  ]";
        String str9 = str2;
        TrackGroupArray unmappedTrackGroups = currentMappedTrackInfo.getUnmappedTrackGroups();
        if (unmappedTrackGroups.length > 0) {
            logd("  Unmapped [");
            int i16 = 0;
            while (i16 < unmappedTrackGroups.length) {
                StringBuilder sb6 = new StringBuilder(23);
                String str10 = str7;
                sb6.append(str10);
                sb6.append(i16);
                String str11 = str9;
                sb6.append(str11);
                logd(sb6.toString());
                TrackGroup trackGroup3 = unmappedTrackGroups.get(i16);
                int i17 = 0;
                while (i17 < trackGroup3.length) {
                    String trackStatusString2 = getTrackStatusString(false);
                    String formatSupportString2 = C.getFormatSupportString(0);
                    String logString2 = Format.toLogString(trackGroup3.getFormat(i17));
                    String str12 = str10;
                    StringBuilder sb7 = new StringBuilder(String.valueOf(trackStatusString2).length() + 38 + String.valueOf(logString2).length() + String.valueOf(formatSupportString2).length());
                    sb7.append("      ");
                    sb7.append(trackStatusString2);
                    sb7.append(" Track:");
                    sb7.append(i17);
                    sb7.append(", ");
                    sb7.append(logString2);
                    sb7.append(", supported=");
                    sb7.append(formatSupportString2);
                    logd(sb7.toString());
                    i17++;
                    unmappedTrackGroups = unmappedTrackGroups;
                    str10 = str12;
                }
                TrackGroupArray trackGroupArray3 = unmappedTrackGroups;
                str7 = str10;
                logd("    ]");
                i16++;
                str9 = str11;
            }
            logd(str8);
        }
        logd("]");
    }

    public void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        logd(eventTime, "upstreamDiscarded", Format.toLogString(mediaLoadData.trackFormat));
    }

    public /* synthetic */ void onVideoCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
        h1.g0(this, eventTime, exc);
    }

    public void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11) {
        logd(eventTime, "videoDecoderInitialized", str);
    }

    public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j11, long j12) {
        h1.i0(this, eventTime, str, j11, j12);
    }

    public void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
        logd(eventTime, "videoDecoderReleased", str);
    }

    public void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "videoDisabled");
    }

    public void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        logd(eventTime, "videoEnabled");
    }

    public /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j11, int i11) {
        h1.m0(this, eventTime, j11, i11);
    }

    public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
        h1.n0(this, eventTime, format);
    }

    public void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        logd(eventTime, "videoInputFormat", Format.toLogString(format));
    }

    public /* synthetic */ void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i11, int i12, int i13, float f11) {
        h1.p0(this, eventTime, i11, i12, i13, f11);
    }

    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        int i11 = videoSize.width;
        int i12 = videoSize.height;
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append(i11);
        sb2.append(", ");
        sb2.append(i12);
        logd(eventTime, "videoSize", sb2.toString());
    }

    public void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f11) {
        logd(eventTime, "volume", Float.toString(f11));
    }

    public EventLogger(MappingTrackSelector mappingTrackSelector, String str) {
        this.trackSelector = mappingTrackSelector;
        this.tag = str;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.startTimeMs = SystemClock.elapsedRealtime();
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str) {
        logd(getEventString(eventTime, str, (String) null, (Throwable) null));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, Throwable th2) {
        loge(getEventString(eventTime, str, (String) null, th2));
    }

    private void logd(AnalyticsListener.EventTime eventTime, String str, String str2) {
        logd(getEventString(eventTime, str, str2, (Throwable) null));
    }

    private void loge(AnalyticsListener.EventTime eventTime, String str, String str2, Throwable th2) {
        loge(getEventString(eventTime, str, str2, th2));
    }
}
