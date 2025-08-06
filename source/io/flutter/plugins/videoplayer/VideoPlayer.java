package io.flutter.plugins.videoplayer;

import android.net.Uri;
import android.view.Surface;
import com.adjust.sdk.Constants;
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
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.n0;
import com.google.android.exoplayer2.o0;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.a;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import io.flutter.plugin.common.EventChannel;
import io.flutter.view.TextureRegistry;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

final class VideoPlayer {
    private static final String FORMAT_DASH = "dash";
    private static final String FORMAT_HLS = "hls";
    private static final String FORMAT_OTHER = "other";
    private static final String FORMAT_SS = "ss";
    private final EventChannel eventChannel;
    /* access modifiers changed from: private */
    public QueuingEventSink eventSink = new QueuingEventSink();
    private SimpleExoPlayer exoPlayer;
    /* access modifiers changed from: private */
    public boolean isInitialized = false;
    private final VideoPlayerOptions options;
    private Surface surface;
    private final TextureRegistry.SurfaceTextureEntry textureEntry;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: com.google.android.exoplayer2.upstream.DefaultDataSourceFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: com.google.android.exoplayer2.upstream.DefaultDataSourceFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: com.google.android.exoplayer2.upstream.DefaultDataSourceFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: com.google.android.exoplayer2.upstream.DefaultDataSourceFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: com.google.android.exoplayer2.upstream.DefaultDataSourceFactory} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VideoPlayer(android.content.Context r2, io.flutter.plugin.common.EventChannel r3, io.flutter.view.TextureRegistry.SurfaceTextureEntry r4, java.lang.String r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, io.flutter.plugins.videoplayer.VideoPlayerOptions r8) {
        /*
            r1 = this;
            r1.<init>()
            io.flutter.plugins.videoplayer.QueuingEventSink r0 = new io.flutter.plugins.videoplayer.QueuingEventSink
            r0.<init>()
            r1.eventSink = r0
            r0 = 0
            r1.isInitialized = r0
            r1.eventChannel = r3
            r1.textureEntry = r4
            r1.options = r8
            com.google.android.exoplayer2.SimpleExoPlayer$Builder r8 = new com.google.android.exoplayer2.SimpleExoPlayer$Builder
            r8.<init>(r2)
            com.google.android.exoplayer2.SimpleExoPlayer r8 = r8.build()
            r1.exoPlayer = r8
            android.net.Uri r5 = android.net.Uri.parse(r5)
            boolean r8 = isHTTP(r5)
            java.lang.String r0 = "ExoPlayer"
            if (r8 == 0) goto L_0x0044
            com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory r8 = new com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory
            r8.<init>()
            com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory r8 = r8.setUserAgent(r0)
            r0 = 1
            com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory r8 = r8.setAllowCrossProtocolRedirects(r0)
            if (r7 == 0) goto L_0x0049
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L_0x0049
            r8.setDefaultRequestProperties((java.util.Map<java.lang.String, java.lang.String>) r7)
            goto L_0x0049
        L_0x0044:
            com.google.android.exoplayer2.upstream.DefaultDataSourceFactory r8 = new com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
            r8.<init>((android.content.Context) r2, (java.lang.String) r0)
        L_0x0049:
            com.google.android.exoplayer2.source.MediaSource r2 = r1.buildMediaSource(r5, r8, r6, r2)
            com.google.android.exoplayer2.SimpleExoPlayer r5 = r1.exoPlayer
            r5.setMediaSource(r2)
            com.google.android.exoplayer2.SimpleExoPlayer r2 = r1.exoPlayer
            r2.prepare()
            r1.setupVideoPlayer(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.videoplayer.VideoPlayer.<init>(android.content.Context, io.flutter.plugin.common.EventChannel, io.flutter.view.TextureRegistry$SurfaceTextureEntry, java.lang.String, java.lang.String, java.util.Map, io.flutter.plugins.videoplayer.VideoPlayerOptions):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.source.MediaSource buildMediaSource(android.net.Uri r7, com.google.android.exoplayer2.upstream.DataSource.Factory r8, java.lang.String r9, android.content.Context r10) {
        /*
            r6 = this;
            r0 = 4
            r1 = 0
            r2 = -1
            r3 = 2
            r4 = 1
            if (r9 != 0) goto L_0x0010
            java.lang.String r9 = r7.getLastPathSegment()
            int r1 = com.google.android.exoplayer2.util.Util.inferContentType((java.lang.String) r9)
            goto L_0x004e
        L_0x0010:
            int r5 = r9.hashCode()
            switch(r5) {
                case 3680: goto L_0x003a;
                case 103407: goto L_0x002f;
                case 3075986: goto L_0x0024;
                case 106069776: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            r9 = r2
            goto L_0x0044
        L_0x0019:
            java.lang.String r5 = "other"
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x0022
            goto L_0x0017
        L_0x0022:
            r9 = 3
            goto L_0x0044
        L_0x0024:
            java.lang.String r5 = "dash"
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x002d
            goto L_0x0017
        L_0x002d:
            r9 = r3
            goto L_0x0044
        L_0x002f:
            java.lang.String r5 = "hls"
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x0038
            goto L_0x0017
        L_0x0038:
            r9 = r4
            goto L_0x0044
        L_0x003a:
            java.lang.String r5 = "ss"
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x0043
            goto L_0x0017
        L_0x0043:
            r9 = r1
        L_0x0044:
            switch(r9) {
                case 0: goto L_0x004d;
                case 1: goto L_0x004b;
                case 2: goto L_0x004e;
                case 3: goto L_0x0049;
                default: goto L_0x0047;
            }
        L_0x0047:
            r1 = r2
            goto L_0x004e
        L_0x0049:
            r1 = r0
            goto L_0x004e
        L_0x004b:
            r1 = r3
            goto L_0x004e
        L_0x004d:
            r1 = r4
        L_0x004e:
            r9 = 0
            if (r1 == 0) goto L_0x00a2
            if (r1 == r4) goto L_0x008a
            if (r1 == r3) goto L_0x007c
            if (r1 != r0) goto L_0x0065
            com.google.android.exoplayer2.source.ProgressiveMediaSource$Factory r9 = new com.google.android.exoplayer2.source.ProgressiveMediaSource$Factory
            r9.<init>(r8)
            com.google.android.exoplayer2.MediaItem r7 = com.google.android.exoplayer2.MediaItem.fromUri((android.net.Uri) r7)
            com.google.android.exoplayer2.source.ProgressiveMediaSource r7 = r9.createMediaSource((com.google.android.exoplayer2.MediaItem) r7)
            return r7
        L_0x0065:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Unsupported type: "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x007c:
            com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory r9 = new com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory
            r9.<init>((com.google.android.exoplayer2.upstream.DataSource.Factory) r8)
            com.google.android.exoplayer2.MediaItem r7 = com.google.android.exoplayer2.MediaItem.fromUri((android.net.Uri) r7)
            com.google.android.exoplayer2.source.hls.HlsMediaSource r7 = r9.createMediaSource((com.google.android.exoplayer2.MediaItem) r7)
            return r7
        L_0x008a:
            com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory r0 = new com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory
            com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory r1 = new com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory
            r1.<init>(r8)
            com.google.android.exoplayer2.upstream.DefaultDataSourceFactory r2 = new com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
            r2.<init>((android.content.Context) r10, (com.google.android.exoplayer2.upstream.TransferListener) r9, (com.google.android.exoplayer2.upstream.DataSource.Factory) r8)
            r0.<init>(r1, r2)
            com.google.android.exoplayer2.MediaItem r7 = com.google.android.exoplayer2.MediaItem.fromUri((android.net.Uri) r7)
            com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource r7 = r0.createMediaSource((com.google.android.exoplayer2.MediaItem) r7)
            return r7
        L_0x00a2:
            com.google.android.exoplayer2.source.dash.DashMediaSource$Factory r0 = new com.google.android.exoplayer2.source.dash.DashMediaSource$Factory
            com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory r1 = new com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory
            r1.<init>(r8)
            com.google.android.exoplayer2.upstream.DefaultDataSourceFactory r2 = new com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
            r2.<init>((android.content.Context) r10, (com.google.android.exoplayer2.upstream.TransferListener) r9, (com.google.android.exoplayer2.upstream.DataSource.Factory) r8)
            r0.<init>(r1, r2)
            com.google.android.exoplayer2.MediaItem r7 = com.google.android.exoplayer2.MediaItem.fromUri((android.net.Uri) r7)
            com.google.android.exoplayer2.source.dash.DashMediaSource r7 = r0.createMediaSource((com.google.android.exoplayer2.MediaItem) r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.videoplayer.VideoPlayer.buildMediaSource(android.net.Uri, com.google.android.exoplayer2.upstream.DataSource$Factory, java.lang.String, android.content.Context):com.google.android.exoplayer2.source.MediaSource");
    }

    private static boolean isHTTP(Uri uri) {
        if (uri == null || uri.getScheme() == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (scheme.equals("http") || scheme.equals(Constants.SCHEME)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void sendInitialized() {
        if (this.isInitialized) {
            HashMap hashMap = new HashMap();
            hashMap.put("event", "initialized");
            hashMap.put(IBridgeMediaLoader.COLUMN_DURATION, Long.valueOf(this.exoPlayer.getDuration()));
            if (this.exoPlayer.getVideoFormat() != null) {
                Format videoFormat = this.exoPlayer.getVideoFormat();
                int i11 = videoFormat.width;
                int i12 = videoFormat.height;
                int i13 = videoFormat.rotationDegrees;
                if (i13 == 90 || i13 == 270) {
                    i11 = this.exoPlayer.getVideoFormat().height;
                    i12 = this.exoPlayer.getVideoFormat().width;
                }
                hashMap.put("width", Integer.valueOf(i11));
                hashMap.put("height", Integer.valueOf(i12));
            }
            this.eventSink.success(hashMap);
        }
    }

    private static void setAudioAttributes(SimpleExoPlayer simpleExoPlayer, boolean z11) {
        simpleExoPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(3).build(), !z11);
    }

    private void setupVideoPlayer(EventChannel eventChannel2, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry) {
        eventChannel2.setStreamHandler(new EventChannel.StreamHandler() {
            public void onCancel(Object obj) {
                VideoPlayer.this.eventSink.setDelegate((EventChannel.EventSink) null);
            }

            public void onListen(Object obj, EventChannel.EventSink eventSink) {
                VideoPlayer.this.eventSink.setDelegate(eventSink);
            }
        });
        Surface surface2 = new Surface(surfaceTextureEntry.surfaceTexture());
        this.surface = surface2;
        this.exoPlayer.setVideoSurface(surface2);
        setAudioAttributes(this.exoPlayer, this.options.mixWithOthers);
        this.exoPlayer.addListener((Player.Listener) new Player.Listener() {
            private boolean isBuffering = false;

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

            public /* synthetic */ void onEvents(Player player, Player.Events events) {
                n0.b(this, player, events);
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

            public /* synthetic */ void onPlayWhenReadyChanged(boolean z11, int i11) {
                n0.h(this, z11, i11);
            }

            public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                n0.i(this, playbackParameters);
            }

            public void onPlaybackStateChanged(int i11) {
                if (i11 == 2) {
                    setBuffering(true);
                    VideoPlayer.this.sendBufferingUpdate();
                } else if (i11 == 3) {
                    if (!VideoPlayer.this.isInitialized) {
                        boolean unused = VideoPlayer.this.isInitialized = true;
                        VideoPlayer.this.sendInitialized();
                    }
                } else if (i11 == 4) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", "completed");
                    VideoPlayer.this.eventSink.success(hashMap);
                }
                if (i11 != 2) {
                    setBuffering(false);
                }
            }

            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i11) {
                n0.k(this, i11);
            }

            public void onPlayerError(ExoPlaybackException exoPlaybackException) {
                setBuffering(false);
                if (VideoPlayer.this.eventSink != null) {
                    QueuingEventSink access$000 = VideoPlayer.this.eventSink;
                    access$000.error("VideoError", "Video player had error " + exoPlaybackException, (Object) null);
                }
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

            public void setBuffering(boolean z11) {
                if (this.isBuffering != z11) {
                    this.isBuffering = z11;
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", this.isBuffering ? "bufferingStart" : "bufferingEnd");
                    VideoPlayer.this.eventSink.success(hashMap);
                }
            }
        });
    }

    public void dispose() {
        if (this.isInitialized) {
            this.exoPlayer.stop();
        }
        this.textureEntry.release();
        this.eventChannel.setStreamHandler((EventChannel.StreamHandler) null);
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
        }
        SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
        }
    }

    public long getPosition() {
        return this.exoPlayer.getCurrentPosition();
    }

    public void pause() {
        this.exoPlayer.setPlayWhenReady(false);
    }

    public void play() {
        this.exoPlayer.setPlayWhenReady(true);
    }

    public void seekTo(int i11) {
        this.exoPlayer.seekTo((long) i11);
    }

    public void sendBufferingUpdate() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "bufferingUpdate");
        hashMap.put("values", Collections.singletonList(Arrays.asList(new Number[]{0, Long.valueOf(this.exoPlayer.getBufferedPosition())})));
        this.eventSink.success(hashMap);
    }

    public void setLooping(boolean z11) {
        this.exoPlayer.setRepeatMode(z11 ? 2 : 0);
    }

    public void setPlaybackSpeed(double d11) {
        this.exoPlayer.setPlaybackParameters(new PlaybackParameters((float) d11));
    }

    public void setVolume(double d11) {
        this.exoPlayer.setVolume((float) Math.max(0.0d, Math.min(1.0d, d11)));
    }
}
