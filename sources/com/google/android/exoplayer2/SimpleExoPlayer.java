package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.AudioBecomingNoisyManager;
import com.google.android.exoplayer2.AudioFocusManager;
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.StreamVolumeManager;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.audio.c;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.DeviceListener;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.b;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.tencent.thumbplayer.tcmedia.api.TPErrorCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

public class SimpleExoPlayer extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.MetadataComponent, ExoPlayer.DeviceComponent {
    public static final long DEFAULT_DETACH_SURFACE_TIMEOUT_MS = 2000;
    private static final String TAG = "SimpleExoPlayer";
    /* access modifiers changed from: private */
    public final AnalyticsCollector analyticsCollector;
    private final Context applicationContext;
    private AudioAttributes audioAttributes;
    private final AudioBecomingNoisyManager audioBecomingNoisyManager;
    /* access modifiers changed from: private */
    public DecoderCounters audioDecoderCounters;
    private final AudioFocusManager audioFocusManager;
    /* access modifiers changed from: private */
    public Format audioFormat;
    private final CopyOnWriteArraySet<AudioListener> audioListeners;
    private int audioSessionId;
    private float audioVolume;
    private CameraMotionListener cameraMotionListener;
    private final ComponentListener componentListener;
    private final ConditionVariable constructorFinished;
    /* access modifiers changed from: private */
    public List<Cue> currentCues;
    private final long detachSurfaceTimeoutMs;
    /* access modifiers changed from: private */
    public DeviceInfo deviceInfo;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<DeviceListener> deviceListeners;
    private final FrameMetadataListener frameMetadataListener;
    private boolean hasNotifiedFullWrongThreadWarning;
    /* access modifiers changed from: private */
    public boolean isPriorityTaskManagerRegistered;
    private AudioTrack keepSessionIdAudioTrack;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<MetadataOutput> metadataOutputs;
    private Surface ownedSurface;
    /* access modifiers changed from: private */
    public final ExoPlayerImpl player;
    private boolean playerReleased;
    /* access modifiers changed from: private */
    public PriorityTaskManager priorityTaskManager;
    public final Renderer[] renderers;
    /* access modifiers changed from: private */
    public boolean skipSilenceEnabled;
    private SphericalGLSurfaceView sphericalGLSurfaceView;
    /* access modifiers changed from: private */
    public final StreamVolumeManager streamVolumeManager;
    private int surfaceHeight;
    private SurfaceHolder surfaceHolder;
    /* access modifiers changed from: private */
    public boolean surfaceHolderSurfaceIsVideoOutput;
    private int surfaceWidth;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<TextOutput> textOutputs;
    private TextureView textureView;
    private boolean throwsWhenUsingWrongThread;
    /* access modifiers changed from: private */
    public DecoderCounters videoDecoderCounters;
    /* access modifiers changed from: private */
    public Format videoFormat;
    private VideoFrameMetadataListener videoFrameMetadataListener;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<VideoListener> videoListeners;
    /* access modifiers changed from: private */
    public Object videoOutput;
    private int videoScalingMode;
    /* access modifiers changed from: private */
    public VideoSize videoSize;
    private final WakeLockManager wakeLockManager;
    private final WifiLockManager wifiLockManager;

    public static final class Builder {
        /* access modifiers changed from: private */
        public AnalyticsCollector analyticsCollector;
        /* access modifiers changed from: private */
        public AudioAttributes audioAttributes;
        /* access modifiers changed from: private */
        public BandwidthMeter bandwidthMeter;
        private boolean buildCalled;
        /* access modifiers changed from: private */
        public Clock clock;
        /* access modifiers changed from: private */
        public final Context context;
        /* access modifiers changed from: private */
        public long detachSurfaceTimeoutMs;
        /* access modifiers changed from: private */
        public long foregroundModeTimeoutMs;
        /* access modifiers changed from: private */
        public boolean handleAudioBecomingNoisy;
        /* access modifiers changed from: private */
        public boolean handleAudioFocus;
        /* access modifiers changed from: private */
        public LivePlaybackSpeedControl livePlaybackSpeedControl;
        /* access modifiers changed from: private */
        public LoadControl loadControl;
        /* access modifiers changed from: private */
        public Looper looper;
        /* access modifiers changed from: private */
        public MediaSourceFactory mediaSourceFactory;
        /* access modifiers changed from: private */
        public boolean pauseAtEndOfMediaItems;
        /* access modifiers changed from: private */
        public PriorityTaskManager priorityTaskManager;
        /* access modifiers changed from: private */
        public long releaseTimeoutMs;
        /* access modifiers changed from: private */
        public final RenderersFactory renderersFactory;
        /* access modifiers changed from: private */
        public SeekParameters seekParameters;
        /* access modifiers changed from: private */
        public boolean skipSilenceEnabled;
        /* access modifiers changed from: private */
        public TrackSelector trackSelector;
        /* access modifiers changed from: private */
        public boolean useLazyPreparation;
        /* access modifiers changed from: private */
        public int videoScalingMode;
        /* access modifiers changed from: private */
        public int wakeMode;

        public Builder(Context context2) {
            this(context2, new DefaultRenderersFactory(context2), new DefaultExtractorsFactory());
        }

        public SimpleExoPlayer build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new SimpleExoPlayer(this);
        }

        public Builder experimentalSetForegroundModeTimeoutMs(long j11) {
            Assertions.checkState(!this.buildCalled);
            this.foregroundModeTimeoutMs = j11;
            return this;
        }

        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector2) {
            Assertions.checkState(!this.buildCalled);
            this.analyticsCollector = analyticsCollector2;
            return this;
        }

        public Builder setAudioAttributes(AudioAttributes audioAttributes2, boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.audioAttributes = audioAttributes2;
            this.handleAudioFocus = z11;
            return this;
        }

        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter2) {
            Assertions.checkState(!this.buildCalled);
            this.bandwidthMeter = bandwidthMeter2;
            return this;
        }

        public Builder setClock(Clock clock2) {
            Assertions.checkState(!this.buildCalled);
            this.clock = clock2;
            return this;
        }

        public Builder setDetachSurfaceTimeoutMs(long j11) {
            Assertions.checkState(!this.buildCalled);
            this.detachSurfaceTimeoutMs = j11;
            return this;
        }

        public Builder setHandleAudioBecomingNoisy(boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.handleAudioBecomingNoisy = z11;
            return this;
        }

        public Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl2) {
            Assertions.checkState(!this.buildCalled);
            this.livePlaybackSpeedControl = livePlaybackSpeedControl2;
            return this;
        }

        public Builder setLoadControl(LoadControl loadControl2) {
            Assertions.checkState(!this.buildCalled);
            this.loadControl = loadControl2;
            return this;
        }

        public Builder setLooper(Looper looper2) {
            Assertions.checkState(!this.buildCalled);
            this.looper = looper2;
            return this;
        }

        public Builder setMediaSourceFactory(MediaSourceFactory mediaSourceFactory2) {
            Assertions.checkState(!this.buildCalled);
            this.mediaSourceFactory = mediaSourceFactory2;
            return this;
        }

        public Builder setPauseAtEndOfMediaItems(boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.pauseAtEndOfMediaItems = z11;
            return this;
        }

        public Builder setPriorityTaskManager(PriorityTaskManager priorityTaskManager2) {
            Assertions.checkState(!this.buildCalled);
            this.priorityTaskManager = priorityTaskManager2;
            return this;
        }

        public Builder setReleaseTimeoutMs(long j11) {
            Assertions.checkState(!this.buildCalled);
            this.releaseTimeoutMs = j11;
            return this;
        }

        public Builder setSeekParameters(SeekParameters seekParameters2) {
            Assertions.checkState(!this.buildCalled);
            this.seekParameters = seekParameters2;
            return this;
        }

        public Builder setSkipSilenceEnabled(boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.skipSilenceEnabled = z11;
            return this;
        }

        public Builder setTrackSelector(TrackSelector trackSelector2) {
            Assertions.checkState(!this.buildCalled);
            this.trackSelector = trackSelector2;
            return this;
        }

        public Builder setUseLazyPreparation(boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.useLazyPreparation = z11;
            return this;
        }

        public Builder setVideoScalingMode(int i11) {
            Assertions.checkState(!this.buildCalled);
            this.videoScalingMode = i11;
            return this;
        }

        public Builder setWakeMode(int i11) {
            Assertions.checkState(!this.buildCalled);
            this.wakeMode = i11;
            return this;
        }

        public Builder(Context context2, RenderersFactory renderersFactory2) {
            this(context2, renderersFactory2, new DefaultExtractorsFactory());
        }

        public Builder(Context context2, ExtractorsFactory extractorsFactory) {
            this(context2, new DefaultRenderersFactory(context2), extractorsFactory);
        }

        public Builder(Context context2, RenderersFactory renderersFactory2, ExtractorsFactory extractorsFactory) {
            this(context2, renderersFactory2, new DefaultTrackSelector(context2), new DefaultMediaSourceFactory(context2, extractorsFactory), new DefaultLoadControl(), DefaultBandwidthMeter.getSingletonInstance(context2), new AnalyticsCollector(Clock.DEFAULT));
        }

        public Builder(Context context2, RenderersFactory renderersFactory2, TrackSelector trackSelector2, MediaSourceFactory mediaSourceFactory2, LoadControl loadControl2, BandwidthMeter bandwidthMeter2, AnalyticsCollector analyticsCollector2) {
            this.context = context2;
            this.renderersFactory = renderersFactory2;
            this.trackSelector = trackSelector2;
            this.mediaSourceFactory = mediaSourceFactory2;
            this.loadControl = loadControl2;
            this.bandwidthMeter = bandwidthMeter2;
            this.analyticsCollector = analyticsCollector2;
            this.looper = Util.getCurrentOrMainLooper();
            this.audioAttributes = AudioAttributes.DEFAULT;
            this.wakeMode = 0;
            this.videoScalingMode = 1;
            this.useLazyPreparation = true;
            this.seekParameters = SeekParameters.DEFAULT;
            this.livePlaybackSpeedControl = new DefaultLivePlaybackSpeedControl.Builder().build();
            this.clock = Clock.DEFAULT;
            this.releaseTimeoutMs = 500;
            this.detachSurfaceTimeoutMs = 2000;
        }
    }

    public final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.VideoSurfaceListener, AudioFocusManager.PlayerControl, AudioBecomingNoisyManager.EventListener, StreamVolumeManager.Listener, Player.EventListener, ExoPlayer.AudioOffloadListener {
        private ComponentListener() {
        }

        public void executePlayerCommand(int i11) {
            boolean playWhenReady = SimpleExoPlayer.this.getPlayWhenReady();
            SimpleExoPlayer.this.updatePlayWhenReady(playWhenReady, i11, SimpleExoPlayer.getPlayWhenReadyChangeReason(playWhenReady, i11));
        }

        public void onAudioBecomingNoisy() {
            SimpleExoPlayer.this.updatePlayWhenReady(false, -1, 3);
        }

        public void onAudioCodecError(Exception exc) {
            SimpleExoPlayer.this.analyticsCollector.onAudioCodecError(exc);
        }

        public void onAudioDecoderInitialized(String str, long j11, long j12) {
            SimpleExoPlayer.this.analyticsCollector.onAudioDecoderInitialized(str, j11, j12);
        }

        public void onAudioDecoderReleased(String str) {
            SimpleExoPlayer.this.analyticsCollector.onAudioDecoderReleased(str);
        }

        public void onAudioDisabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.analyticsCollector.onAudioDisabled(decoderCounters);
            Format unused = SimpleExoPlayer.this.audioFormat = null;
            DecoderCounters unused2 = SimpleExoPlayer.this.audioDecoderCounters = null;
        }

        public void onAudioEnabled(DecoderCounters decoderCounters) {
            DecoderCounters unused = SimpleExoPlayer.this.audioDecoderCounters = decoderCounters;
            SimpleExoPlayer.this.analyticsCollector.onAudioEnabled(decoderCounters);
        }

        public /* synthetic */ void onAudioInputFormatChanged(Format format) {
            c.f(this, format);
        }

        public void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Format unused = SimpleExoPlayer.this.audioFormat = format;
            SimpleExoPlayer.this.analyticsCollector.onAudioInputFormatChanged(format, decoderReuseEvaluation);
        }

        public void onAudioPositionAdvancing(long j11) {
            SimpleExoPlayer.this.analyticsCollector.onAudioPositionAdvancing(j11);
        }

        public void onAudioSinkError(Exception exc) {
            SimpleExoPlayer.this.analyticsCollector.onAudioSinkError(exc);
        }

        public void onAudioUnderrun(int i11, long j11, long j12) {
            SimpleExoPlayer.this.analyticsCollector.onAudioUnderrun(i11, j11, j12);
        }

        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
            n0.a(this, commands);
        }

        public void onCues(List<Cue> list) {
            List unused = SimpleExoPlayer.this.currentCues = list;
            Iterator it2 = SimpleExoPlayer.this.textOutputs.iterator();
            while (it2.hasNext()) {
                ((TextOutput) it2.next()).onCues(list);
            }
        }

        public void onDroppedFrames(int i11, long j11) {
            SimpleExoPlayer.this.analyticsCollector.onDroppedFrames(i11, j11);
        }

        public /* synthetic */ void onEvents(Player player, Player.Events events) {
            n0.b(this, player, events);
        }

        public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z11) {
            d.a(this, z11);
        }

        public void onExperimentalSleepingForOffloadChanged(boolean z11) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }

        public void onIsLoadingChanged(boolean z11) {
            if (SimpleExoPlayer.this.priorityTaskManager == null) {
                return;
            }
            if (z11 && !SimpleExoPlayer.this.isPriorityTaskManagerRegistered) {
                SimpleExoPlayer.this.priorityTaskManager.add(0);
                boolean unused = SimpleExoPlayer.this.isPriorityTaskManagerRegistered = true;
            } else if (!z11 && SimpleExoPlayer.this.isPriorityTaskManagerRegistered) {
                SimpleExoPlayer.this.priorityTaskManager.remove(0);
                boolean unused2 = SimpleExoPlayer.this.isPriorityTaskManagerRegistered = false;
            }
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

        public void onMetadata(Metadata metadata) {
            SimpleExoPlayer.this.analyticsCollector.onMetadata(metadata);
            SimpleExoPlayer.this.player.onMetadata(metadata);
            Iterator it2 = SimpleExoPlayer.this.metadataOutputs.iterator();
            while (it2.hasNext()) {
                ((MetadataOutput) it2.next()).onMetadata(metadata);
            }
        }

        public void onPlayWhenReadyChanged(boolean z11, int i11) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }

        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            n0.i(this, playbackParameters);
        }

        public void onPlaybackStateChanged(int i11) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
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

        public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i11) {
            n0.o(this, positionInfo, positionInfo2, i11);
        }

        public void onRenderedFirstFrame(Object obj, long j11) {
            SimpleExoPlayer.this.analyticsCollector.onRenderedFirstFrame(obj, j11);
            if (SimpleExoPlayer.this.videoOutput == obj) {
                Iterator it2 = SimpleExoPlayer.this.videoListeners.iterator();
                while (it2.hasNext()) {
                    ((VideoListener) it2.next()).onRenderedFirstFrame();
                }
            }
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

        public void onSkipSilenceEnabledChanged(boolean z11) {
            if (SimpleExoPlayer.this.skipSilenceEnabled != z11) {
                boolean unused = SimpleExoPlayer.this.skipSilenceEnabled = z11;
                SimpleExoPlayer.this.notifySkipSilenceEnabledChanged();
            }
        }

        public /* synthetic */ void onStaticMetadataChanged(List list) {
            n0.s(this, list);
        }

        public void onStreamTypeChanged(int i11) {
            DeviceInfo access$4700 = SimpleExoPlayer.createDeviceInfo(SimpleExoPlayer.this.streamVolumeManager);
            if (!access$4700.equals(SimpleExoPlayer.this.deviceInfo)) {
                DeviceInfo unused = SimpleExoPlayer.this.deviceInfo = access$4700;
                Iterator it2 = SimpleExoPlayer.this.deviceListeners.iterator();
                while (it2.hasNext()) {
                    ((DeviceListener) it2.next()).onDeviceInfoChanged(access$4700);
                }
            }
        }

        public void onStreamVolumeChanged(int i11, boolean z11) {
            Iterator it2 = SimpleExoPlayer.this.deviceListeners.iterator();
            while (it2.hasNext()) {
                ((DeviceListener) it2.next()).onDeviceVolumeChanged(i11, z11);
            }
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
            SimpleExoPlayer.this.setSurfaceTextureInternal(surfaceTexture);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i11, i12);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            SimpleExoPlayer.this.setVideoOutputInternal((Object) null);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i11, i12);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
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

        public void onVideoCodecError(Exception exc) {
            SimpleExoPlayer.this.analyticsCollector.onVideoCodecError(exc);
        }

        public void onVideoDecoderInitialized(String str, long j11, long j12) {
            SimpleExoPlayer.this.analyticsCollector.onVideoDecoderInitialized(str, j11, j12);
        }

        public void onVideoDecoderReleased(String str) {
            SimpleExoPlayer.this.analyticsCollector.onVideoDecoderReleased(str);
        }

        public void onVideoDisabled(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.analyticsCollector.onVideoDisabled(decoderCounters);
            Format unused = SimpleExoPlayer.this.videoFormat = null;
            DecoderCounters unused2 = SimpleExoPlayer.this.videoDecoderCounters = null;
        }

        public void onVideoEnabled(DecoderCounters decoderCounters) {
            DecoderCounters unused = SimpleExoPlayer.this.videoDecoderCounters = decoderCounters;
            SimpleExoPlayer.this.analyticsCollector.onVideoEnabled(decoderCounters);
        }

        public void onVideoFrameProcessingOffset(long j11, int i11) {
            SimpleExoPlayer.this.analyticsCollector.onVideoFrameProcessingOffset(j11, i11);
        }

        public /* synthetic */ void onVideoInputFormatChanged(Format format) {
            b.i(this, format);
        }

        public void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Format unused = SimpleExoPlayer.this.videoFormat = format;
            SimpleExoPlayer.this.analyticsCollector.onVideoInputFormatChanged(format, decoderReuseEvaluation);
        }

        public void onVideoSizeChanged(VideoSize videoSize) {
            VideoSize unused = SimpleExoPlayer.this.videoSize = videoSize;
            SimpleExoPlayer.this.analyticsCollector.onVideoSizeChanged(videoSize);
            Iterator it2 = SimpleExoPlayer.this.videoListeners.iterator();
            while (it2.hasNext()) {
                VideoListener videoListener = (VideoListener) it2.next();
                videoListener.onVideoSizeChanged(videoSize);
                videoListener.onVideoSizeChanged(videoSize.width, videoSize.height, videoSize.unappliedRotationDegrees, videoSize.pixelWidthHeightRatio);
            }
        }

        public void onVideoSurfaceCreated(Surface surface) {
            SimpleExoPlayer.this.setVideoOutputInternal(surface);
        }

        public void onVideoSurfaceDestroyed(Surface surface) {
            SimpleExoPlayer.this.setVideoOutputInternal((Object) null);
        }

        public void setVolumeMultiplier(float f11) {
            SimpleExoPlayer.this.sendVolumeToRenderers();
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(i12, i13);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (SimpleExoPlayer.this.surfaceHolderSurfaceIsVideoOutput) {
                SimpleExoPlayer.this.setVideoOutputInternal(surfaceHolder.getSurface());
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (SimpleExoPlayer.this.surfaceHolderSurfaceIsVideoOutput) {
                SimpleExoPlayer.this.setVideoOutputInternal((Object) null);
            }
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
        }
    }

    public static final class FrameMetadataListener implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.Target {
        public static final int MSG_SET_CAMERA_MOTION_LISTENER = 7;
        public static final int MSG_SET_SPHERICAL_SURFACE_VIEW = 10000;
        public static final int MSG_SET_VIDEO_FRAME_METADATA_LISTENER = 6;
        private CameraMotionListener cameraMotionListener;
        private CameraMotionListener internalCameraMotionListener;
        private VideoFrameMetadataListener internalVideoFrameMetadataListener;
        private VideoFrameMetadataListener videoFrameMetadataListener;

        private FrameMetadataListener() {
        }

        public void handleMessage(int i11, Object obj) {
            if (i11 == 6) {
                this.videoFrameMetadataListener = (VideoFrameMetadataListener) obj;
            } else if (i11 == 7) {
                this.cameraMotionListener = (CameraMotionListener) obj;
            } else if (i11 == 10000) {
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
                if (sphericalGLSurfaceView == null) {
                    this.internalVideoFrameMetadataListener = null;
                    this.internalCameraMotionListener = null;
                    return;
                }
                this.internalVideoFrameMetadataListener = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.internalCameraMotionListener = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }

        public void onCameraMotion(long j11, float[] fArr) {
            CameraMotionListener cameraMotionListener2 = this.internalCameraMotionListener;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.onCameraMotion(j11, fArr);
            }
            CameraMotionListener cameraMotionListener3 = this.cameraMotionListener;
            if (cameraMotionListener3 != null) {
                cameraMotionListener3.onCameraMotion(j11, fArr);
            }
        }

        public void onCameraMotionReset() {
            CameraMotionListener cameraMotionListener2 = this.internalCameraMotionListener;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.onCameraMotionReset();
            }
            CameraMotionListener cameraMotionListener3 = this.cameraMotionListener;
            if (cameraMotionListener3 != null) {
                cameraMotionListener3.onCameraMotionReset();
            }
        }

        public void onVideoFrameAboutToBeRendered(long j11, long j12, Format format, MediaFormat mediaFormat) {
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.internalVideoFrameMetadataListener;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.onVideoFrameAboutToBeRendered(j11, j12, format, mediaFormat);
            }
            VideoFrameMetadataListener videoFrameMetadataListener3 = this.videoFrameMetadataListener;
            if (videoFrameMetadataListener3 != null) {
                videoFrameMetadataListener3.onVideoFrameAboutToBeRendered(j11, j12, format, mediaFormat);
            }
        }
    }

    @Deprecated
    public SimpleExoPlayer(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector2, boolean z11, Clock clock, Looper looper) {
        this(new Builder(context, renderersFactory).setTrackSelector(trackSelector).setMediaSourceFactory(mediaSourceFactory).setLoadControl(loadControl).setBandwidthMeter(bandwidthMeter).setAnalyticsCollector(analyticsCollector2).setUseLazyPreparation(z11).setClock(clock).setLooper(looper));
    }

    /* access modifiers changed from: private */
    public static DeviceInfo createDeviceInfo(StreamVolumeManager streamVolumeManager2) {
        return new DeviceInfo(0, streamVolumeManager2.getMinVolume(), streamVolumeManager2.getMaxVolume());
    }

    /* access modifiers changed from: private */
    public static int getPlayWhenReadyChangeReason(boolean z11, int i11) {
        return (!z11 || i11 == 1) ? 1 : 2;
    }

    private int initializeKeepSessionIdAudioTrack(int i11) {
        AudioTrack audioTrack = this.keepSessionIdAudioTrack;
        if (!(audioTrack == null || audioTrack.getAudioSessionId() == i11)) {
            this.keepSessionIdAudioTrack.release();
            this.keepSessionIdAudioTrack = null;
        }
        if (this.keepSessionIdAudioTrack == null) {
            this.keepSessionIdAudioTrack = new AudioTrack(3, TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY, 4, 2, 2, 0, i11);
        }
        return this.keepSessionIdAudioTrack.getAudioSessionId();
    }

    /* access modifiers changed from: private */
    public void maybeNotifySurfaceSizeChanged(int i11, int i12) {
        if (i11 != this.surfaceWidth || i12 != this.surfaceHeight) {
            this.surfaceWidth = i11;
            this.surfaceHeight = i12;
            this.analyticsCollector.onSurfaceSizeChanged(i11, i12);
            Iterator<VideoListener> it2 = this.videoListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onSurfaceSizeChanged(i11, i12);
            }
        }
    }

    /* access modifiers changed from: private */
    public void notifySkipSilenceEnabledChanged() {
        this.analyticsCollector.onSkipSilenceEnabledChanged(this.skipSilenceEnabled);
        Iterator<AudioListener> it2 = this.audioListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onSkipSilenceEnabledChanged(this.skipSilenceEnabled);
        }
    }

    private void removeSurfaceCallbacks() {
        if (this.sphericalGLSurfaceView != null) {
            this.player.createMessage(this.frameMetadataListener).setType(10000).setPayload((Object) null).send();
            this.sphericalGLSurfaceView.removeVideoSurfaceListener(this.componentListener);
            this.sphericalGLSurfaceView = null;
        }
        TextureView textureView2 = this.textureView;
        if (textureView2 != null) {
            if (textureView2.getSurfaceTextureListener() != this.componentListener) {
                Log.w(TAG, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.textureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.textureView = null;
        }
        SurfaceHolder surfaceHolder2 = this.surfaceHolder;
        if (surfaceHolder2 != null) {
            surfaceHolder2.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    private void sendRendererMessage(int i11, int i12, Object obj) {
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == i11) {
                this.player.createMessage(renderer).setType(i12).setPayload(obj).send();
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendVolumeToRenderers() {
        sendRendererMessage(1, 2, Float.valueOf(this.audioVolume * this.audioFocusManager.getVolumeMultiplier()));
    }

    private void setNonVideoOutputSurfaceHolderInternal(SurfaceHolder surfaceHolder2) {
        this.surfaceHolderSurfaceIsVideoOutput = false;
        this.surfaceHolder = surfaceHolder2;
        surfaceHolder2.addCallback(this.componentListener);
        Surface surface = this.surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        Rect surfaceFrame = this.surfaceHolder.getSurfaceFrame();
        maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
    }

    /* access modifiers changed from: private */
    public void setSurfaceTextureInternal(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        setVideoOutputInternal(surface);
        this.ownedSurface = surface;
    }

    /* access modifiers changed from: private */
    public void setVideoOutputInternal(Object obj) {
        ArrayList<PlayerMessage> arrayList = new ArrayList<>();
        for (Renderer renderer : this.renderers) {
            if (renderer.getTrackType() == 2) {
                arrayList.add(this.player.createMessage(renderer).setType(1).setPayload(obj).send());
            }
        }
        Object obj2 = this.videoOutput;
        if (!(obj2 == null || obj2 == obj)) {
            try {
                for (PlayerMessage blockUntilDelivered : arrayList) {
                    blockUntilDelivered.blockUntilDelivered(this.detachSurfaceTimeoutMs);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                this.player.stop(false, ExoPlaybackException.createForRenderer(new ExoTimeoutException(3)));
            }
            Object obj3 = this.videoOutput;
            Surface surface = this.ownedSurface;
            if (obj3 == surface) {
                surface.release();
                this.ownedSurface = null;
            }
        }
        this.videoOutput = obj;
    }

    /* access modifiers changed from: private */
    public void updatePlayWhenReady(boolean z11, int i11, int i12) {
        int i13 = 0;
        boolean z12 = z11 && i11 != -1;
        if (z12 && i11 != 1) {
            i13 = 1;
        }
        this.player.setPlayWhenReady(z12, i13, i12);
    }

    /* access modifiers changed from: private */
    public void updateWakeAndWifiLock() {
        int playbackState = getPlaybackState();
        boolean z11 = true;
        if (playbackState != 1) {
            if (playbackState == 2 || playbackState == 3) {
                boolean experimentalIsSleepingForOffload = experimentalIsSleepingForOffload();
                WakeLockManager wakeLockManager2 = this.wakeLockManager;
                if (!getPlayWhenReady() || experimentalIsSleepingForOffload) {
                    z11 = false;
                }
                wakeLockManager2.setStayAwake(z11);
                this.wifiLockManager.setStayAwake(getPlayWhenReady());
                return;
            } else if (playbackState != 4) {
                throw new IllegalStateException();
            }
        }
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
    }

    private void verifyApplicationThread() {
        this.constructorFinished.blockUninterruptible();
        if (Thread.currentThread() != getApplicationLooper().getThread()) {
            String formatInvariant = Util.formatInvariant("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), getApplicationLooper().getThread().getName());
            if (!this.throwsWhenUsingWrongThread) {
                Log.w(TAG, formatInvariant, this.hasNotifiedFullWrongThreadWarning ? null : new IllegalStateException());
                this.hasNotifiedFullWrongThreadWarning = true;
                return;
            }
            throw new IllegalStateException(formatInvariant);
        }
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.analyticsCollector.addListener(analyticsListener);
    }

    public void addAudioListener(AudioListener audioListener) {
        Assertions.checkNotNull(audioListener);
        this.audioListeners.add(audioListener);
    }

    public void addAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.player.addAudioOffloadListener(audioOffloadListener);
    }

    public void addDeviceListener(DeviceListener deviceListener) {
        Assertions.checkNotNull(deviceListener);
        this.deviceListeners.add(deviceListener);
    }

    public void addListener(Player.Listener listener) {
        Assertions.checkNotNull(listener);
        addAudioListener(listener);
        addVideoListener(listener);
        addTextOutput(listener);
        addMetadataOutput(listener);
        addDeviceListener(listener);
        addListener((Player.EventListener) listener);
    }

    public void addMediaItems(int i11, List<MediaItem> list) {
        verifyApplicationThread();
        this.player.addMediaItems(i11, list);
    }

    public void addMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        this.player.addMediaSource(mediaSource);
    }

    public void addMediaSources(List<MediaSource> list) {
        verifyApplicationThread();
        this.player.addMediaSources(list);
    }

    public void addMetadataOutput(MetadataOutput metadataOutput) {
        Assertions.checkNotNull(metadataOutput);
        this.metadataOutputs.add(metadataOutput);
    }

    public void addTextOutput(TextOutput textOutput) {
        Assertions.checkNotNull(textOutput);
        this.textOutputs.add(textOutput);
    }

    public void addVideoListener(VideoListener videoListener) {
        Assertions.checkNotNull(videoListener);
        this.videoListeners.add(videoListener);
    }

    public void clearAuxEffectInfo() {
        setAuxEffectInfo(new AuxEffectInfo(0, 0.0f));
    }

    public void clearCameraMotionListener(CameraMotionListener cameraMotionListener2) {
        verifyApplicationThread();
        if (this.cameraMotionListener == cameraMotionListener2) {
            this.player.createMessage(this.frameMetadataListener).setType(7).setPayload((Object) null).send();
        }
    }

    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener2) {
        verifyApplicationThread();
        if (this.videoFrameMetadataListener == videoFrameMetadataListener2) {
            this.player.createMessage(this.frameMetadataListener).setType(6).setPayload((Object) null).send();
        }
    }

    public void clearVideoSurface() {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        setVideoOutputInternal((Object) null);
        maybeNotifySurfaceSizeChanged(0, 0);
    }

    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder2) {
        verifyApplicationThread();
        if (surfaceHolder2 != null && surfaceHolder2 == this.surfaceHolder) {
            clearVideoSurface();
        }
    }

    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder2;
        verifyApplicationThread();
        if (surfaceView == null) {
            surfaceHolder2 = null;
        } else {
            surfaceHolder2 = surfaceView.getHolder();
        }
        clearVideoSurfaceHolder(surfaceHolder2);
    }

    public void clearVideoTextureView(TextureView textureView2) {
        verifyApplicationThread();
        if (textureView2 != null && textureView2 == this.textureView) {
            clearVideoSurface();
        }
    }

    public PlayerMessage createMessage(PlayerMessage.Target target) {
        verifyApplicationThread();
        return this.player.createMessage(target);
    }

    public void decreaseDeviceVolume() {
        verifyApplicationThread();
        this.streamVolumeManager.decreaseVolume();
    }

    public boolean experimentalIsSleepingForOffload() {
        verifyApplicationThread();
        return this.player.experimentalIsSleepingForOffload();
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean z11) {
        verifyApplicationThread();
        this.player.experimentalSetOffloadSchedulingEnabled(z11);
    }

    public AnalyticsCollector getAnalyticsCollector() {
        return this.analyticsCollector;
    }

    public Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    public AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    public ExoPlayer.AudioComponent getAudioComponent() {
        return this;
    }

    public DecoderCounters getAudioDecoderCounters() {
        return this.audioDecoderCounters;
    }

    public Format getAudioFormat() {
        return this.audioFormat;
    }

    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    public Player.Commands getAvailableCommands() {
        verifyApplicationThread();
        return this.player.getAvailableCommands();
    }

    public long getBufferedPosition() {
        verifyApplicationThread();
        return this.player.getBufferedPosition();
    }

    public Clock getClock() {
        return this.player.getClock();
    }

    public long getContentBufferedPosition() {
        verifyApplicationThread();
        return this.player.getContentBufferedPosition();
    }

    public long getContentPosition() {
        verifyApplicationThread();
        return this.player.getContentPosition();
    }

    public int getCurrentAdGroupIndex() {
        verifyApplicationThread();
        return this.player.getCurrentAdGroupIndex();
    }

    public int getCurrentAdIndexInAdGroup() {
        verifyApplicationThread();
        return this.player.getCurrentAdIndexInAdGroup();
    }

    public List<Cue> getCurrentCues() {
        verifyApplicationThread();
        return this.currentCues;
    }

    public int getCurrentPeriodIndex() {
        verifyApplicationThread();
        return this.player.getCurrentPeriodIndex();
    }

    public long getCurrentPosition() {
        verifyApplicationThread();
        return this.player.getCurrentPosition();
    }

    public List<Metadata> getCurrentStaticMetadata() {
        verifyApplicationThread();
        return this.player.getCurrentStaticMetadata();
    }

    public Timeline getCurrentTimeline() {
        verifyApplicationThread();
        return this.player.getCurrentTimeline();
    }

    public TrackGroupArray getCurrentTrackGroups() {
        verifyApplicationThread();
        return this.player.getCurrentTrackGroups();
    }

    public TrackSelectionArray getCurrentTrackSelections() {
        verifyApplicationThread();
        return this.player.getCurrentTrackSelections();
    }

    public int getCurrentWindowIndex() {
        verifyApplicationThread();
        return this.player.getCurrentWindowIndex();
    }

    public ExoPlayer.DeviceComponent getDeviceComponent() {
        return this;
    }

    public DeviceInfo getDeviceInfo() {
        verifyApplicationThread();
        return this.deviceInfo;
    }

    public int getDeviceVolume() {
        verifyApplicationThread();
        return this.streamVolumeManager.getVolume();
    }

    public long getDuration() {
        verifyApplicationThread();
        return this.player.getDuration();
    }

    public MediaMetadata getMediaMetadata() {
        return this.player.getMediaMetadata();
    }

    public ExoPlayer.MetadataComponent getMetadataComponent() {
        return this;
    }

    public boolean getPauseAtEndOfMediaItems() {
        verifyApplicationThread();
        return this.player.getPauseAtEndOfMediaItems();
    }

    public boolean getPlayWhenReady() {
        verifyApplicationThread();
        return this.player.getPlayWhenReady();
    }

    public Looper getPlaybackLooper() {
        return this.player.getPlaybackLooper();
    }

    public PlaybackParameters getPlaybackParameters() {
        verifyApplicationThread();
        return this.player.getPlaybackParameters();
    }

    public int getPlaybackState() {
        verifyApplicationThread();
        return this.player.getPlaybackState();
    }

    public int getPlaybackSuppressionReason() {
        verifyApplicationThread();
        return this.player.getPlaybackSuppressionReason();
    }

    public ExoPlaybackException getPlayerError() {
        verifyApplicationThread();
        return this.player.getPlayerError();
    }

    public int getRendererCount() {
        verifyApplicationThread();
        return this.player.getRendererCount();
    }

    public int getRendererType(int i11) {
        verifyApplicationThread();
        return this.player.getRendererType(i11);
    }

    public int getRepeatMode() {
        verifyApplicationThread();
        return this.player.getRepeatMode();
    }

    public SeekParameters getSeekParameters() {
        verifyApplicationThread();
        return this.player.getSeekParameters();
    }

    public boolean getShuffleModeEnabled() {
        verifyApplicationThread();
        return this.player.getShuffleModeEnabled();
    }

    public boolean getSkipSilenceEnabled() {
        return this.skipSilenceEnabled;
    }

    public ExoPlayer.TextComponent getTextComponent() {
        return this;
    }

    public long getTotalBufferedDuration() {
        verifyApplicationThread();
        return this.player.getTotalBufferedDuration();
    }

    public TrackSelector getTrackSelector() {
        verifyApplicationThread();
        return this.player.getTrackSelector();
    }

    public ExoPlayer.VideoComponent getVideoComponent() {
        return this;
    }

    public DecoderCounters getVideoDecoderCounters() {
        return this.videoDecoderCounters;
    }

    public Format getVideoFormat() {
        return this.videoFormat;
    }

    public int getVideoScalingMode() {
        return this.videoScalingMode;
    }

    public VideoSize getVideoSize() {
        return this.videoSize;
    }

    public float getVolume() {
        return this.audioVolume;
    }

    public void increaseDeviceVolume() {
        verifyApplicationThread();
        this.streamVolumeManager.increaseVolume();
    }

    public boolean isDeviceMuted() {
        verifyApplicationThread();
        return this.streamVolumeManager.isMuted();
    }

    public boolean isLoading() {
        verifyApplicationThread();
        return this.player.isLoading();
    }

    public boolean isPlayingAd() {
        verifyApplicationThread();
        return this.player.isPlayingAd();
    }

    public void moveMediaItems(int i11, int i12, int i13) {
        verifyApplicationThread();
        this.player.moveMediaItems(i11, i12, i13);
    }

    public void prepare() {
        verifyApplicationThread();
        boolean playWhenReady = getPlayWhenReady();
        int updateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, 2);
        updatePlayWhenReady(playWhenReady, updateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, updateAudioFocus));
        this.player.prepare();
    }

    public void release() {
        AudioTrack audioTrack;
        verifyApplicationThread();
        if (Util.SDK_INT < 21 && (audioTrack = this.keepSessionIdAudioTrack) != null) {
            audioTrack.release();
            this.keepSessionIdAudioTrack = null;
        }
        this.audioBecomingNoisyManager.setEnabled(false);
        this.streamVolumeManager.release();
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
        this.audioFocusManager.release();
        this.player.release();
        this.analyticsCollector.release();
        removeSurfaceCallbacks();
        Surface surface = this.ownedSurface;
        if (surface != null) {
            surface.release();
            this.ownedSurface = null;
        }
        if (this.isPriorityTaskManagerRegistered) {
            ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
            this.isPriorityTaskManagerRegistered = false;
        }
        this.currentCues = Collections.emptyList();
        this.playerReleased = true;
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        this.analyticsCollector.removeListener(analyticsListener);
    }

    public void removeAudioListener(AudioListener audioListener) {
        this.audioListeners.remove(audioListener);
    }

    public void removeAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.player.removeAudioOffloadListener(audioOffloadListener);
    }

    public void removeDeviceListener(DeviceListener deviceListener) {
        this.deviceListeners.remove(deviceListener);
    }

    public void removeListener(Player.Listener listener) {
        Assertions.checkNotNull(listener);
        removeAudioListener(listener);
        removeVideoListener(listener);
        removeTextOutput(listener);
        removeMetadataOutput(listener);
        removeDeviceListener(listener);
        removeListener((Player.EventListener) listener);
    }

    public void removeMediaItems(int i11, int i12) {
        verifyApplicationThread();
        this.player.removeMediaItems(i11, i12);
    }

    public void removeMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.remove(metadataOutput);
    }

    public void removeTextOutput(TextOutput textOutput) {
        this.textOutputs.remove(textOutput);
    }

    public void removeVideoListener(VideoListener videoListener) {
        this.videoListeners.remove(videoListener);
    }

    @Deprecated
    public void retry() {
        verifyApplicationThread();
        prepare();
    }

    public void seekTo(int i11, long j11) {
        verifyApplicationThread();
        this.analyticsCollector.notifySeekStarted();
        this.player.seekTo(i11, j11);
    }

    public void setAudioAttributes(AudioAttributes audioAttributes2, boolean z11) {
        verifyApplicationThread();
        if (!this.playerReleased) {
            if (!Util.areEqual(this.audioAttributes, audioAttributes2)) {
                this.audioAttributes = audioAttributes2;
                sendRendererMessage(1, 3, audioAttributes2);
                this.streamVolumeManager.setStreamType(Util.getStreamTypeForAudioUsage(audioAttributes2.usage));
                this.analyticsCollector.onAudioAttributesChanged(audioAttributes2);
                Iterator<AudioListener> it2 = this.audioListeners.iterator();
                while (it2.hasNext()) {
                    it2.next().onAudioAttributesChanged(audioAttributes2);
                }
            }
            AudioFocusManager audioFocusManager2 = this.audioFocusManager;
            if (!z11) {
                audioAttributes2 = null;
            }
            audioFocusManager2.setAudioAttributes(audioAttributes2);
            boolean playWhenReady = getPlayWhenReady();
            int updateAudioFocus = this.audioFocusManager.updateAudioFocus(playWhenReady, getPlaybackState());
            updatePlayWhenReady(playWhenReady, updateAudioFocus, getPlayWhenReadyChangeReason(playWhenReady, updateAudioFocus));
        }
    }

    public void setAudioSessionId(int i11) {
        verifyApplicationThread();
        if (this.audioSessionId != i11) {
            if (i11 == 0) {
                if (Util.SDK_INT < 21) {
                    i11 = initializeKeepSessionIdAudioTrack(0);
                } else {
                    i11 = C.generateAudioSessionIdV21(this.applicationContext);
                }
            } else if (Util.SDK_INT < 21) {
                initializeKeepSessionIdAudioTrack(i11);
            }
            this.audioSessionId = i11;
            sendRendererMessage(1, 102, Integer.valueOf(i11));
            sendRendererMessage(2, 102, Integer.valueOf(i11));
            this.analyticsCollector.onAudioSessionIdChanged(i11);
            Iterator<AudioListener> it2 = this.audioListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onAudioSessionIdChanged(i11);
            }
        }
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        verifyApplicationThread();
        sendRendererMessage(1, 5, auxEffectInfo);
    }

    public void setCameraMotionListener(CameraMotionListener cameraMotionListener2) {
        verifyApplicationThread();
        this.cameraMotionListener = cameraMotionListener2;
        this.player.createMessage(this.frameMetadataListener).setType(7).setPayload(cameraMotionListener2).send();
    }

    public void setDeviceMuted(boolean z11) {
        verifyApplicationThread();
        this.streamVolumeManager.setMuted(z11);
    }

    public void setDeviceVolume(int i11) {
        verifyApplicationThread();
        this.streamVolumeManager.setVolume(i11);
    }

    public void setForegroundMode(boolean z11) {
        verifyApplicationThread();
        this.player.setForegroundMode(z11);
    }

    public void setHandleAudioBecomingNoisy(boolean z11) {
        verifyApplicationThread();
        if (!this.playerReleased) {
            this.audioBecomingNoisyManager.setEnabled(z11);
        }
    }

    @Deprecated
    public void setHandleWakeLock(boolean z11) {
        setWakeMode(z11 ? 1 : 0);
    }

    public void setMediaItems(List<MediaItem> list, boolean z11) {
        verifyApplicationThread();
        this.player.setMediaItems(list, z11);
    }

    public void setMediaSource(MediaSource mediaSource) {
        verifyApplicationThread();
        this.player.setMediaSource(mediaSource);
    }

    public void setMediaSources(List<MediaSource> list) {
        verifyApplicationThread();
        this.player.setMediaSources(list);
    }

    public void setPauseAtEndOfMediaItems(boolean z11) {
        verifyApplicationThread();
        this.player.setPauseAtEndOfMediaItems(z11);
    }

    public void setPlayWhenReady(boolean z11) {
        verifyApplicationThread();
        int updateAudioFocus = this.audioFocusManager.updateAudioFocus(z11, getPlaybackState());
        updatePlayWhenReady(z11, updateAudioFocus, getPlayWhenReadyChangeReason(z11, updateAudioFocus));
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        verifyApplicationThread();
        this.player.setPlaybackParameters(playbackParameters);
    }

    public void setPriorityTaskManager(PriorityTaskManager priorityTaskManager2) {
        verifyApplicationThread();
        if (!Util.areEqual(this.priorityTaskManager, priorityTaskManager2)) {
            if (this.isPriorityTaskManagerRegistered) {
                ((PriorityTaskManager) Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
            }
            if (priorityTaskManager2 == null || !isLoading()) {
                this.isPriorityTaskManagerRegistered = false;
            } else {
                priorityTaskManager2.add(0);
                this.isPriorityTaskManagerRegistered = true;
            }
            this.priorityTaskManager = priorityTaskManager2;
        }
    }

    public void setRepeatMode(int i11) {
        verifyApplicationThread();
        this.player.setRepeatMode(i11);
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        verifyApplicationThread();
        this.player.setSeekParameters(seekParameters);
    }

    public void setShuffleModeEnabled(boolean z11) {
        verifyApplicationThread();
        this.player.setShuffleModeEnabled(z11);
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        verifyApplicationThread();
        this.player.setShuffleOrder(shuffleOrder);
    }

    public void setSkipSilenceEnabled(boolean z11) {
        verifyApplicationThread();
        if (this.skipSilenceEnabled != z11) {
            this.skipSilenceEnabled = z11;
            sendRendererMessage(1, 101, Boolean.valueOf(z11));
            notifySkipSilenceEnabledChanged();
        }
    }

    @Deprecated
    public void setThrowsWhenUsingWrongThread(boolean z11) {
        this.throwsWhenUsingWrongThread = z11;
    }

    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener2) {
        verifyApplicationThread();
        this.videoFrameMetadataListener = videoFrameMetadataListener2;
        this.player.createMessage(this.frameMetadataListener).setType(6).setPayload(videoFrameMetadataListener2).send();
    }

    public void setVideoScalingMode(int i11) {
        verifyApplicationThread();
        this.videoScalingMode = i11;
        sendRendererMessage(2, 4, Integer.valueOf(i11));
    }

    public void setVideoSurface(Surface surface) {
        verifyApplicationThread();
        removeSurfaceCallbacks();
        setVideoOutputInternal(surface);
        int i11 = surface == null ? 0 : -1;
        maybeNotifySurfaceSizeChanged(i11, i11);
    }

    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder2) {
        verifyApplicationThread();
        if (surfaceHolder2 == null) {
            clearVideoSurface();
            return;
        }
        removeSurfaceCallbacks();
        this.surfaceHolderSurfaceIsVideoOutput = true;
        this.surfaceHolder = surfaceHolder2;
        surfaceHolder2.addCallback(this.componentListener);
        Surface surface = surfaceHolder2.getSurface();
        if (surface == null || !surface.isValid()) {
            setVideoOutputInternal((Object) null);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        setVideoOutputInternal(surface);
        Rect surfaceFrame = surfaceHolder2.getSurfaceFrame();
        maybeNotifySurfaceSizeChanged(surfaceFrame.width(), surfaceFrame.height());
    }

    public void setVideoSurfaceView(SurfaceView surfaceView) {
        SurfaceHolder surfaceHolder2;
        verifyApplicationThread();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            removeSurfaceCallbacks();
            setVideoOutputInternal(surfaceView);
            setNonVideoOutputSurfaceHolderInternal(surfaceView.getHolder());
        } else if (surfaceView instanceof SphericalGLSurfaceView) {
            removeSurfaceCallbacks();
            this.sphericalGLSurfaceView = (SphericalGLSurfaceView) surfaceView;
            this.player.createMessage(this.frameMetadataListener).setType(10000).setPayload(this.sphericalGLSurfaceView).send();
            this.sphericalGLSurfaceView.addVideoSurfaceListener(this.componentListener);
            setVideoOutputInternal(this.sphericalGLSurfaceView.getVideoSurface());
            setNonVideoOutputSurfaceHolderInternal(surfaceView.getHolder());
        } else {
            if (surfaceView == null) {
                surfaceHolder2 = null;
            } else {
                surfaceHolder2 = surfaceView.getHolder();
            }
            setVideoSurfaceHolder(surfaceHolder2);
        }
    }

    public void setVideoTextureView(TextureView textureView2) {
        verifyApplicationThread();
        if (textureView2 == null) {
            clearVideoSurface();
            return;
        }
        removeSurfaceCallbacks();
        this.textureView = textureView2;
        if (textureView2.getSurfaceTextureListener() != null) {
            Log.w(TAG, "Replacing existing SurfaceTextureListener.");
        }
        textureView2.setSurfaceTextureListener(this.componentListener);
        SurfaceTexture surfaceTexture = textureView2.isAvailable() ? textureView2.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            setVideoOutputInternal((Object) null);
            maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        setSurfaceTextureInternal(surfaceTexture);
        maybeNotifySurfaceSizeChanged(textureView2.getWidth(), textureView2.getHeight());
    }

    public void setVolume(float f11) {
        verifyApplicationThread();
        float constrainValue = Util.constrainValue(f11, 0.0f, 1.0f);
        if (this.audioVolume != constrainValue) {
            this.audioVolume = constrainValue;
            sendVolumeToRenderers();
            this.analyticsCollector.onVolumeChanged(constrainValue);
            Iterator<AudioListener> it2 = this.audioListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onVolumeChanged(constrainValue);
            }
        }
    }

    public void setWakeMode(int i11) {
        verifyApplicationThread();
        if (i11 == 0) {
            this.wakeLockManager.setEnabled(false);
            this.wifiLockManager.setEnabled(false);
        } else if (i11 == 1) {
            this.wakeLockManager.setEnabled(true);
            this.wifiLockManager.setEnabled(false);
        } else if (i11 == 2) {
            this.wakeLockManager.setEnabled(true);
            this.wifiLockManager.setEnabled(true);
        }
    }

    public void stop(boolean z11) {
        verifyApplicationThread();
        this.audioFocusManager.updateAudioFocus(getPlayWhenReady(), 1);
        this.player.stop(z11);
        this.currentCues = Collections.emptyList();
    }

    public void addMediaSource(int i11, MediaSource mediaSource) {
        verifyApplicationThread();
        this.player.addMediaSource(i11, mediaSource);
    }

    public void addMediaSources(int i11, List<MediaSource> list) {
        verifyApplicationThread();
        this.player.addMediaSources(i11, list);
    }

    public void setMediaItems(List<MediaItem> list, int i11, long j11) {
        verifyApplicationThread();
        this.player.setMediaItems(list, i11, j11);
    }

    public void setMediaSource(MediaSource mediaSource, boolean z11) {
        verifyApplicationThread();
        this.player.setMediaSource(mediaSource, z11);
    }

    public void setMediaSources(List<MediaSource> list, boolean z11) {
        verifyApplicationThread();
        this.player.setMediaSources(list, z11);
    }

    public void clearVideoSurface(Surface surface) {
        verifyApplicationThread();
        if (surface != null && surface == this.videoOutput) {
            clearVideoSurface();
        }
    }

    public void setMediaSource(MediaSource mediaSource, long j11) {
        verifyApplicationThread();
        this.player.setMediaSource(mediaSource, j11);
    }

    public void setMediaSources(List<MediaSource> list, int i11, long j11) {
        verifyApplicationThread();
        this.player.setMediaSources(list, i11, j11);
    }

    @Deprecated
    public void prepare(MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    public void addListener(Player.EventListener eventListener) {
        Assertions.checkNotNull(eventListener);
        this.player.addListener(eventListener);
    }

    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z11, boolean z12) {
        verifyApplicationThread();
        setMediaSources(Collections.singletonList(mediaSource), z11);
        prepare();
    }

    public void removeListener(Player.EventListener eventListener) {
        this.player.removeListener(eventListener);
    }

    public SimpleExoPlayer(Builder builder) {
        SimpleExoPlayer simpleExoPlayer;
        ConditionVariable conditionVariable = new ConditionVariable();
        this.constructorFinished = conditionVariable;
        try {
            Context applicationContext2 = builder.context.getApplicationContext();
            this.applicationContext = applicationContext2;
            AnalyticsCollector access$100 = builder.analyticsCollector;
            this.analyticsCollector = access$100;
            this.priorityTaskManager = builder.priorityTaskManager;
            this.audioAttributes = builder.audioAttributes;
            this.videoScalingMode = builder.videoScalingMode;
            this.skipSilenceEnabled = builder.skipSilenceEnabled;
            this.detachSurfaceTimeoutMs = builder.detachSurfaceTimeoutMs;
            ComponentListener componentListener2 = new ComponentListener();
            this.componentListener = componentListener2;
            FrameMetadataListener frameMetadataListener2 = new FrameMetadataListener();
            this.frameMetadataListener = frameMetadataListener2;
            this.videoListeners = new CopyOnWriteArraySet<>();
            this.audioListeners = new CopyOnWriteArraySet<>();
            this.textOutputs = new CopyOnWriteArraySet<>();
            this.metadataOutputs = new CopyOnWriteArraySet<>();
            this.deviceListeners = new CopyOnWriteArraySet<>();
            Handler handler = new Handler(builder.looper);
            Renderer[] createRenderers = builder.renderersFactory.createRenderers(handler, componentListener2, componentListener2, componentListener2, componentListener2);
            this.renderers = createRenderers;
            this.audioVolume = 1.0f;
            if (Util.SDK_INT < 21) {
                this.audioSessionId = initializeKeepSessionIdAudioTrack(0);
            } else {
                this.audioSessionId = C.generateAudioSessionIdV21(applicationContext2);
            }
            this.currentCues = Collections.emptyList();
            this.throwsWhenUsingWrongThread = true;
            ConditionVariable conditionVariable2 = conditionVariable;
            ExoPlayerImpl exoPlayerImpl = r1;
            Handler handler2 = handler;
            FrameMetadataListener frameMetadataListener3 = frameMetadataListener2;
            ComponentListener componentListener3 = componentListener2;
            try {
                ExoPlayerImpl exoPlayerImpl2 = new ExoPlayerImpl(createRenderers, builder.trackSelector, builder.mediaSourceFactory, builder.loadControl, builder.bandwidthMeter, access$100, builder.useLazyPreparation, builder.seekParameters, builder.livePlaybackSpeedControl, builder.releaseTimeoutMs, builder.pauseAtEndOfMediaItems, builder.clock, builder.looper, this, new Player.Commands.Builder().addAll(15, 16, 17, 18, 19, 20, 21, 22).build());
                simpleExoPlayer = this;
                try {
                    simpleExoPlayer.player = exoPlayerImpl;
                    ComponentListener componentListener4 = componentListener3;
                    exoPlayerImpl.addListener((Player.EventListener) componentListener4);
                    exoPlayerImpl.addAudioOffloadListener(componentListener4);
                    if (builder.foregroundModeTimeoutMs > 0) {
                        exoPlayerImpl.experimentalSetForegroundModeTimeoutMs(builder.foregroundModeTimeoutMs);
                    }
                    Handler handler3 = handler2;
                    AudioBecomingNoisyManager audioBecomingNoisyManager2 = new AudioBecomingNoisyManager(builder.context, handler3, componentListener4);
                    simpleExoPlayer.audioBecomingNoisyManager = audioBecomingNoisyManager2;
                    audioBecomingNoisyManager2.setEnabled(builder.handleAudioBecomingNoisy);
                    AudioFocusManager audioFocusManager2 = new AudioFocusManager(builder.context, handler3, componentListener4);
                    simpleExoPlayer.audioFocusManager = audioFocusManager2;
                    audioFocusManager2.setAudioAttributes(builder.handleAudioFocus ? simpleExoPlayer.audioAttributes : null);
                    StreamVolumeManager streamVolumeManager2 = new StreamVolumeManager(builder.context, handler3, componentListener4);
                    simpleExoPlayer.streamVolumeManager = streamVolumeManager2;
                    streamVolumeManager2.setStreamType(Util.getStreamTypeForAudioUsage(simpleExoPlayer.audioAttributes.usage));
                    WakeLockManager wakeLockManager2 = new WakeLockManager(builder.context);
                    simpleExoPlayer.wakeLockManager = wakeLockManager2;
                    wakeLockManager2.setEnabled(builder.wakeMode != 0);
                    WifiLockManager wifiLockManager2 = new WifiLockManager(builder.context);
                    simpleExoPlayer.wifiLockManager = wifiLockManager2;
                    wifiLockManager2.setEnabled(builder.wakeMode == 2);
                    simpleExoPlayer.deviceInfo = createDeviceInfo(streamVolumeManager2);
                    simpleExoPlayer.videoSize = VideoSize.UNKNOWN;
                    simpleExoPlayer.sendRendererMessage(1, 102, Integer.valueOf(simpleExoPlayer.audioSessionId));
                    simpleExoPlayer.sendRendererMessage(2, 102, Integer.valueOf(simpleExoPlayer.audioSessionId));
                    simpleExoPlayer.sendRendererMessage(1, 3, simpleExoPlayer.audioAttributes);
                    simpleExoPlayer.sendRendererMessage(2, 4, Integer.valueOf(simpleExoPlayer.videoScalingMode));
                    simpleExoPlayer.sendRendererMessage(1, 101, Boolean.valueOf(simpleExoPlayer.skipSilenceEnabled));
                    FrameMetadataListener frameMetadataListener4 = frameMetadataListener3;
                    simpleExoPlayer.sendRendererMessage(2, 6, frameMetadataListener4);
                    simpleExoPlayer.sendRendererMessage(6, 7, frameMetadataListener4);
                    conditionVariable2.open();
                } catch (Throwable th2) {
                    th = th2;
                    simpleExoPlayer.constructorFinished.open();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                simpleExoPlayer = this;
                simpleExoPlayer.constructorFinished.open();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            simpleExoPlayer = this;
            simpleExoPlayer.constructorFinished.open();
            throw th;
        }
    }
}
