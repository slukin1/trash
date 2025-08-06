package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.DeviceListener;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.util.List;

public interface ExoPlayer extends Player {
    public static final long DEFAULT_RELEASE_TIMEOUT_MS = 500;

    public interface AudioComponent {
        @Deprecated
        void addAudioListener(AudioListener audioListener);

        void clearAuxEffectInfo();

        AudioAttributes getAudioAttributes();

        int getAudioSessionId();

        boolean getSkipSilenceEnabled();

        float getVolume();

        @Deprecated
        void removeAudioListener(AudioListener audioListener);

        void setAudioAttributes(AudioAttributes audioAttributes, boolean z11);

        void setAudioSessionId(int i11);

        void setAuxEffectInfo(AuxEffectInfo auxEffectInfo);

        void setSkipSilenceEnabled(boolean z11);

        void setVolume(float f11);
    }

    public interface AudioOffloadListener {
        void onExperimentalOffloadSchedulingEnabledChanged(boolean z11);

        void onExperimentalSleepingForOffloadChanged(boolean z11);
    }

    public interface DeviceComponent {
        @Deprecated
        void addDeviceListener(DeviceListener deviceListener);

        void decreaseDeviceVolume();

        DeviceInfo getDeviceInfo();

        int getDeviceVolume();

        void increaseDeviceVolume();

        boolean isDeviceMuted();

        @Deprecated
        void removeDeviceListener(DeviceListener deviceListener);

        void setDeviceMuted(boolean z11);

        void setDeviceVolume(int i11);
    }

    public interface MetadataComponent {
        @Deprecated
        void addMetadataOutput(MetadataOutput metadataOutput);

        @Deprecated
        void removeMetadataOutput(MetadataOutput metadataOutput);
    }

    public interface TextComponent {
        @Deprecated
        void addTextOutput(TextOutput textOutput);

        List<Cue> getCurrentCues();

        @Deprecated
        void removeTextOutput(TextOutput textOutput);
    }

    public interface VideoComponent {
        @Deprecated
        void addVideoListener(VideoListener videoListener);

        void clearCameraMotionListener(CameraMotionListener cameraMotionListener);

        void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        void clearVideoSurface();

        void clearVideoSurface(Surface surface);

        void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder);

        void clearVideoSurfaceView(SurfaceView surfaceView);

        void clearVideoTextureView(TextureView textureView);

        int getVideoScalingMode();

        VideoSize getVideoSize();

        @Deprecated
        void removeVideoListener(VideoListener videoListener);

        void setCameraMotionListener(CameraMotionListener cameraMotionListener);

        void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

        void setVideoScalingMode(int i11);

        void setVideoSurface(Surface surface);

        void setVideoSurfaceHolder(SurfaceHolder surfaceHolder);

        void setVideoSurfaceView(SurfaceView surfaceView);

        void setVideoTextureView(TextureView textureView);
    }

    void addAudioOffloadListener(AudioOffloadListener audioOffloadListener);

    void addMediaSource(int i11, MediaSource mediaSource);

    void addMediaSource(MediaSource mediaSource);

    void addMediaSources(int i11, List<MediaSource> list);

    void addMediaSources(List<MediaSource> list);

    PlayerMessage createMessage(PlayerMessage.Target target);

    boolean experimentalIsSleepingForOffload();

    void experimentalSetOffloadSchedulingEnabled(boolean z11);

    AudioComponent getAudioComponent();

    Clock getClock();

    DeviceComponent getDeviceComponent();

    MetadataComponent getMetadataComponent();

    boolean getPauseAtEndOfMediaItems();

    Looper getPlaybackLooper();

    int getRendererCount();

    int getRendererType(int i11);

    SeekParameters getSeekParameters();

    TextComponent getTextComponent();

    TrackSelector getTrackSelector();

    VideoComponent getVideoComponent();

    @Deprecated
    void prepare(MediaSource mediaSource);

    @Deprecated
    void prepare(MediaSource mediaSource, boolean z11, boolean z12);

    void removeAudioOffloadListener(AudioOffloadListener audioOffloadListener);

    @Deprecated
    void retry();

    void setForegroundMode(boolean z11);

    void setMediaSource(MediaSource mediaSource);

    void setMediaSource(MediaSource mediaSource, long j11);

    void setMediaSource(MediaSource mediaSource, boolean z11);

    void setMediaSources(List<MediaSource> list);

    void setMediaSources(List<MediaSource> list, int i11, long j11);

    void setMediaSources(List<MediaSource> list, boolean z11);

    void setPauseAtEndOfMediaItems(boolean z11);

    void setSeekParameters(SeekParameters seekParameters);

    void setShuffleOrder(ShuffleOrder shuffleOrder);

    @Deprecated
    public static final class Builder {
        private AnalyticsCollector analyticsCollector;
        private BandwidthMeter bandwidthMeter;
        private boolean buildCalled;
        private Clock clock;
        private LivePlaybackSpeedControl livePlaybackSpeedControl;
        private LoadControl loadControl;
        private Looper looper;
        private MediaSourceFactory mediaSourceFactory;
        private boolean pauseAtEndOfMediaItems;
        private long releaseTimeoutMs;
        private final Renderer[] renderers;
        private SeekParameters seekParameters;
        private long setForegroundModeTimeoutMs;
        private TrackSelector trackSelector;
        private boolean useLazyPreparation;

        public Builder(Context context, Renderer... rendererArr) {
            this(rendererArr, new DefaultTrackSelector(context), new DefaultMediaSourceFactory(context), new DefaultLoadControl(), DefaultBandwidthMeter.getSingletonInstance(context));
        }

        public ExoPlayer build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            ExoPlayerImpl exoPlayerImpl = new ExoPlayerImpl(this.renderers, this.trackSelector, this.mediaSourceFactory, this.loadControl, this.bandwidthMeter, this.analyticsCollector, this.useLazyPreparation, this.seekParameters, this.livePlaybackSpeedControl, this.releaseTimeoutMs, this.pauseAtEndOfMediaItems, this.clock, this.looper, (Player) null, Player.Commands.EMPTY);
            long j11 = this.setForegroundModeTimeoutMs;
            if (j11 > 0) {
                exoPlayerImpl.experimentalSetForegroundModeTimeoutMs(j11);
            }
            return exoPlayerImpl;
        }

        public Builder experimentalSetForegroundModeTimeoutMs(long j11) {
            Assertions.checkState(!this.buildCalled);
            this.setForegroundModeTimeoutMs = j11;
            return this;
        }

        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector2) {
            Assertions.checkState(!this.buildCalled);
            this.analyticsCollector = analyticsCollector2;
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

        public Builder(Renderer[] rendererArr, TrackSelector trackSelector2, MediaSourceFactory mediaSourceFactory2, LoadControl loadControl2, BandwidthMeter bandwidthMeter2) {
            Assertions.checkArgument(rendererArr.length > 0);
            this.renderers = rendererArr;
            this.trackSelector = trackSelector2;
            this.mediaSourceFactory = mediaSourceFactory2;
            this.loadControl = loadControl2;
            this.bandwidthMeter = bandwidthMeter2;
            this.looper = Util.getCurrentOrMainLooper();
            this.useLazyPreparation = true;
            this.seekParameters = SeekParameters.DEFAULT;
            this.livePlaybackSpeedControl = new DefaultLivePlaybackSpeedControl.Builder().build();
            this.clock = Clock.DEFAULT;
            this.releaseTimeoutMs = 500;
        }
    }
}
