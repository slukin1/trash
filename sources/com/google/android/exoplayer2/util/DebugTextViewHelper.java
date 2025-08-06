package com.google.android.exoplayer2.util;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.b;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n0;
import com.google.android.exoplayer2.o0;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.a;
import java.util.List;
import java.util.Locale;

public class DebugTextViewHelper implements Player.Listener, Runnable {
    private static final int REFRESH_INTERVAL_MS = 1000;
    private final SimpleExoPlayer player;
    private boolean started;
    private final TextView textView;

    public DebugTextViewHelper(SimpleExoPlayer simpleExoPlayer, TextView textView2) {
        Assertions.checkArgument(simpleExoPlayer.getApplicationLooper() == Looper.getMainLooper());
        this.player = simpleExoPlayer;
        this.textView = textView2;
    }

    private static String getDecoderCountersBufferCountString(DecoderCounters decoderCounters) {
        if (decoderCounters == null) {
            return "";
        }
        decoderCounters.ensureUpdated();
        int i11 = decoderCounters.skippedInputBufferCount;
        int i12 = decoderCounters.skippedOutputBufferCount;
        int i13 = decoderCounters.renderedOutputBufferCount;
        int i14 = decoderCounters.droppedBufferCount;
        int i15 = decoderCounters.maxConsecutiveDroppedBufferCount;
        int i16 = decoderCounters.droppedToKeyframeCount;
        StringBuilder sb2 = new StringBuilder(93);
        sb2.append(" sib:");
        sb2.append(i11);
        sb2.append(" sb:");
        sb2.append(i12);
        sb2.append(" rb:");
        sb2.append(i13);
        sb2.append(" db:");
        sb2.append(i14);
        sb2.append(" mcdb:");
        sb2.append(i15);
        sb2.append(" dk:");
        sb2.append(i16);
        return sb2.toString();
    }

    private static String getPixelAspectRatioString(float f11) {
        if (f11 == -1.0f || f11 == 1.0f) {
            return "";
        }
        String valueOf = String.valueOf(String.format(Locale.US, "%.02f", new Object[]{Float.valueOf(f11)}));
        return valueOf.length() != 0 ? " par:".concat(valueOf) : new String(" par:");
    }

    private static String getVideoFrameProcessingOffsetAverageString(long j11, int i11) {
        return i11 == 0 ? "N/A" : String.valueOf((long) (((double) j11) / ((double) i11)));
    }

    public String getAudioString() {
        Format audioFormat = this.player.getAudioFormat();
        DecoderCounters audioDecoderCounters = this.player.getAudioDecoderCounters();
        if (audioFormat == null || audioDecoderCounters == null) {
            return "";
        }
        String str = audioFormat.sampleMimeType;
        String str2 = audioFormat.f65676id;
        int i11 = audioFormat.sampleRate;
        int i12 = audioFormat.channelCount;
        String decoderCountersBufferCountString = getDecoderCountersBufferCountString(audioDecoderCounters);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length() + String.valueOf(decoderCountersBufferCountString).length());
        sb2.append("\n");
        sb2.append(str);
        sb2.append("(id:");
        sb2.append(str2);
        sb2.append(" hz:");
        sb2.append(i11);
        sb2.append(" ch:");
        sb2.append(i12);
        sb2.append(decoderCountersBufferCountString);
        sb2.append(")");
        return sb2.toString();
    }

    public String getDebugString() {
        String playerStateString = getPlayerStateString();
        String videoString = getVideoString();
        String audioString = getAudioString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(playerStateString).length() + String.valueOf(videoString).length() + String.valueOf(audioString).length());
        sb2.append(playerStateString);
        sb2.append(videoString);
        sb2.append(audioString);
        return sb2.toString();
    }

    public String getPlayerStateString() {
        int playbackState = this.player.getPlaybackState();
        return String.format("playWhenReady:%s playbackState:%s window:%s", new Object[]{Boolean.valueOf(this.player.getPlayWhenReady()), playbackState != 1 ? playbackState != 2 ? playbackState != 3 ? playbackState != 4 ? "unknown" : "ended" : "ready" : "buffering" : "idle", Integer.valueOf(this.player.getCurrentWindowIndex())});
    }

    public String getVideoString() {
        Format videoFormat = this.player.getVideoFormat();
        DecoderCounters videoDecoderCounters = this.player.getVideoDecoderCounters();
        if (videoFormat == null || videoDecoderCounters == null) {
            return "";
        }
        String str = videoFormat.sampleMimeType;
        String str2 = videoFormat.f65676id;
        int i11 = videoFormat.width;
        int i12 = videoFormat.height;
        String pixelAspectRatioString = getPixelAspectRatioString(videoFormat.pixelWidthHeightRatio);
        String decoderCountersBufferCountString = getDecoderCountersBufferCountString(videoDecoderCounters);
        String videoFrameProcessingOffsetAverageString = getVideoFrameProcessingOffsetAverageString(videoDecoderCounters.totalVideoFrameProcessingOffsetUs, videoDecoderCounters.videoFrameProcessingOffsetCount);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length() + String.valueOf(pixelAspectRatioString).length() + String.valueOf(decoderCountersBufferCountString).length() + String.valueOf(videoFrameProcessingOffsetAverageString).length());
        sb2.append("\n");
        sb2.append(str);
        sb2.append("(id:");
        sb2.append(str2);
        sb2.append(" r:");
        sb2.append(i11);
        sb2.append("x");
        sb2.append(i12);
        sb2.append(pixelAspectRatioString);
        sb2.append(decoderCountersBufferCountString);
        sb2.append(" vfpo: ");
        sb2.append(videoFrameProcessingOffsetAverageString);
        sb2.append(")");
        return sb2.toString();
    }

    public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        b.a(this, audioAttributes);
    }

    public /* synthetic */ void onAudioSessionIdChanged(int i11) {
        b.b(this, i11);
    }

    public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
        n0.a(this, commands);
    }

    public /* synthetic */ void onCues(List list) {
        o0.a(this, list);
    }

    public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        com.google.android.exoplayer2.device.b.a(this, deviceInfo);
    }

    public /* synthetic */ void onDeviceVolumeChanged(int i11, boolean z11) {
        com.google.android.exoplayer2.device.b.b(this, i11, z11);
    }

    public /* synthetic */ void onEvents(Player player2, Player.Events events) {
        n0.b(this, player2, events);
    }

    public /* synthetic */ void onIsLoadingChanged(boolean z11) {
        n0.c(this, z11);
    }

    public /* synthetic */ void onIsPlayingChanged(boolean z11) {
        n0.d(this, z11);
    }

    public /* synthetic */ void onLoadingChanged(boolean z11) {
        n0.e(this, z11);
    }

    public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i11) {
        n0.f(this, mediaItem, i11);
    }

    public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        n0.g(this, mediaMetadata);
    }

    public /* synthetic */ void onMetadata(Metadata metadata) {
        o0.b(this, metadata);
    }

    public final void onPlayWhenReadyChanged(boolean z11, int i11) {
        updateAndPost();
    }

    public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        n0.i(this, playbackParameters);
    }

    public final void onPlaybackStateChanged(int i11) {
        updateAndPost();
    }

    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i11) {
        n0.k(this, i11);
    }

    public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
        n0.l(this, exoPlaybackException);
    }

    public /* synthetic */ void onPlayerStateChanged(boolean z11, int i11) {
        n0.m(this, z11, i11);
    }

    public /* synthetic */ void onPositionDiscontinuity(int i11) {
        n0.n(this, i11);
    }

    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11) {
        updateAndPost();
    }

    public /* synthetic */ void onRenderedFirstFrame() {
        a.a(this);
    }

    public /* synthetic */ void onRepeatModeChanged(int i11) {
        n0.p(this, i11);
    }

    public /* synthetic */ void onSeekProcessed() {
        n0.q(this);
    }

    public /* synthetic */ void onShuffleModeEnabledChanged(boolean z11) {
        n0.r(this, z11);
    }

    public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z11) {
        b.c(this, z11);
    }

    public /* synthetic */ void onStaticMetadataChanged(List list) {
        n0.s(this, list);
    }

    public /* synthetic */ void onSurfaceSizeChanged(int i11, int i12) {
        a.b(this, i11, i12);
    }

    public /* synthetic */ void onTimelineChanged(Timeline timeline, int i11) {
        n0.t(this, timeline, i11);
    }

    public /* synthetic */ void onTimelineChanged(Timeline timeline, Object obj, int i11) {
        n0.u(this, timeline, obj, i11);
    }

    public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        n0.v(this, trackGroupArray, trackSelectionArray);
    }

    public /* synthetic */ void onVideoSizeChanged(int i11, int i12, int i13, float f11) {
        a.c(this, i11, i12, i13, f11);
    }

    public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
        a.d(this, videoSize);
    }

    public /* synthetic */ void onVolumeChanged(float f11) {
        b.d(this, f11);
    }

    public final void run() {
        updateAndPost();
    }

    public final void start() {
        if (!this.started) {
            this.started = true;
            this.player.addListener((Player.Listener) this);
            updateAndPost();
        }
    }

    public final void stop() {
        if (this.started) {
            this.started = false;
            this.player.removeListener((Player.Listener) this);
            this.textView.removeCallbacks(this);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void updateAndPost() {
        this.textView.setText(getDebugString());
        this.textView.removeCallbacks(this);
        this.textView.postDelayed(this, 1000);
    }
}
