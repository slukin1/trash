package io.flutter.plugins.videoplayer;

import android.content.Context;
import android.os.Build;
import android.util.LongSparseArray;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.videoplayer.Messages;
import io.flutter.view.TextureRegistry;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Objects;
import javax.net.ssl.HttpsURLConnection;

public class VideoPlayerPlugin implements FlutterPlugin, Messages.VideoPlayerApi {
    private static final String TAG = "VideoPlayerPlugin";
    private FlutterState flutterState;
    private VideoPlayerOptions options = new VideoPlayerOptions();
    private final LongSparseArray<VideoPlayer> videoPlayers = new LongSparseArray<>();

    public static final class FlutterState {
        /* access modifiers changed from: private */
        public final Context applicationContext;
        /* access modifiers changed from: private */
        public final BinaryMessenger binaryMessenger;
        /* access modifiers changed from: private */
        public final KeyForAssetFn keyForAsset;
        /* access modifiers changed from: private */
        public final KeyForAssetAndPackageName keyForAssetAndPackageName;
        /* access modifiers changed from: private */
        public final TextureRegistry textureRegistry;

        public FlutterState(Context context, BinaryMessenger binaryMessenger2, KeyForAssetFn keyForAssetFn, KeyForAssetAndPackageName keyForAssetAndPackageName2, TextureRegistry textureRegistry2) {
            this.applicationContext = context;
            this.binaryMessenger = binaryMessenger2;
            this.keyForAsset = keyForAssetFn;
            this.keyForAssetAndPackageName = keyForAssetAndPackageName2;
            this.textureRegistry = textureRegistry2;
        }

        public void startListening(VideoPlayerPlugin videoPlayerPlugin, BinaryMessenger binaryMessenger2) {
            l.w(binaryMessenger2, videoPlayerPlugin);
        }

        public void stopListening(BinaryMessenger binaryMessenger2) {
            l.w(binaryMessenger2, (Messages.VideoPlayerApi) null);
        }
    }

    public interface KeyForAssetAndPackageName {
        String get(String str, String str2);
    }

    public interface KeyForAssetFn {
        String get(String str);
    }

    public VideoPlayerPlugin() {
    }

    private void disposeAllPlayers() {
        for (int i11 = 0; i11 < this.videoPlayers.size(); i11++) {
            this.videoPlayers.valueAt(i11).dispose();
        }
        this.videoPlayers.clear();
    }

    /* access modifiers changed from: private */
    public void onDestroy() {
        disposeAllPlayers();
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        registrar.addViewDestroyListener(new m(new VideoPlayerPlugin(registrar)));
    }

    public Messages.TextureMessage create(Messages.CreateMessage createMessage) {
        VideoPlayer videoPlayer;
        String str;
        TextureRegistry.SurfaceTextureEntry createSurfaceTexture = this.flutterState.textureRegistry.createSurfaceTexture();
        BinaryMessenger access$100 = this.flutterState.binaryMessenger;
        EventChannel eventChannel = new EventChannel(access$100, "flutter.io/videoPlayer/videoEvents" + createSurfaceTexture.id());
        if (createMessage.getAsset() != null) {
            if (createMessage.getPackageName() != null) {
                str = this.flutterState.keyForAssetAndPackageName.get(createMessage.getAsset(), createMessage.getPackageName());
            } else {
                str = this.flutterState.keyForAsset.get(createMessage.getAsset());
            }
            Context access$400 = this.flutterState.applicationContext;
            videoPlayer = new VideoPlayer(access$400, eventChannel, createSurfaceTexture, "asset:///" + str, (String) null, (Map<String, String>) null, this.options);
        } else {
            TextureRegistry.SurfaceTextureEntry surfaceTextureEntry = createSurfaceTexture;
            videoPlayer = new VideoPlayer(this.flutterState.applicationContext, eventChannel, surfaceTextureEntry, createMessage.getUri(), createMessage.getFormatHint(), createMessage.getHttpHeaders(), this.options);
        }
        this.videoPlayers.put(createSurfaceTexture.id(), videoPlayer);
        Messages.TextureMessage textureMessage = new Messages.TextureMessage();
        textureMessage.setTextureId(Long.valueOf(createSurfaceTexture.id()));
        return textureMessage;
    }

    public void dispose(Messages.TextureMessage textureMessage) {
        this.videoPlayers.get(textureMessage.getTextureId().longValue()).dispose();
        this.videoPlayers.remove(textureMessage.getTextureId().longValue());
    }

    public void initialize() {
        disposeAllPlayers();
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                HttpsURLConnection.setDefaultSSLSocketFactory(new CustomSSLSocketFactory());
            } catch (KeyManagementException | NoSuchAlgorithmException e11) {
                Log.w(TAG, "Failed to enable TLSv1.1 and TLSv1.2 Protocols for API level 19 and below.\nFor more information about Socket Security, please consult the following link:\nhttps://developer.android.com/reference/javax/net/ssl/SSLSocket", e11);
            }
        }
        FlutterInjector instance = FlutterInjector.instance();
        Context applicationContext = flutterPluginBinding.getApplicationContext();
        BinaryMessenger binaryMessenger = flutterPluginBinding.getBinaryMessenger();
        FlutterLoader flutterLoader = instance.flutterLoader();
        Objects.requireNonNull(flutterLoader);
        p pVar = new p(flutterLoader);
        FlutterLoader flutterLoader2 = instance.flutterLoader();
        Objects.requireNonNull(flutterLoader2);
        FlutterState flutterState2 = new FlutterState(applicationContext, binaryMessenger, pVar, new n(flutterLoader2), flutterPluginBinding.getTextureRegistry());
        this.flutterState = flutterState2;
        flutterState2.startListening(this, flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        if (this.flutterState == null) {
            Log.wtf(TAG, "Detached from the engine before registering to it.");
        }
        this.flutterState.stopListening(flutterPluginBinding.getBinaryMessenger());
        this.flutterState = null;
        initialize();
    }

    public void pause(Messages.TextureMessage textureMessage) {
        this.videoPlayers.get(textureMessage.getTextureId().longValue()).pause();
    }

    public void play(Messages.TextureMessage textureMessage) {
        this.videoPlayers.get(textureMessage.getTextureId().longValue()).play();
    }

    public Messages.PositionMessage position(Messages.TextureMessage textureMessage) {
        VideoPlayer videoPlayer = this.videoPlayers.get(textureMessage.getTextureId().longValue());
        Messages.PositionMessage positionMessage = new Messages.PositionMessage();
        positionMessage.setPosition(Long.valueOf(videoPlayer.getPosition()));
        videoPlayer.sendBufferingUpdate();
        return positionMessage;
    }

    public void seekTo(Messages.PositionMessage positionMessage) {
        this.videoPlayers.get(positionMessage.getTextureId().longValue()).seekTo(positionMessage.getPosition().intValue());
    }

    public void setLooping(Messages.LoopingMessage loopingMessage) {
        this.videoPlayers.get(loopingMessage.getTextureId().longValue()).setLooping(loopingMessage.getIsLooping().booleanValue());
    }

    public void setMixWithOthers(Messages.MixWithOthersMessage mixWithOthersMessage) {
        this.options.mixWithOthers = mixWithOthersMessage.getMixWithOthers().booleanValue();
    }

    public void setPlaybackSpeed(Messages.PlaybackSpeedMessage playbackSpeedMessage) {
        this.videoPlayers.get(playbackSpeedMessage.getTextureId().longValue()).setPlaybackSpeed(playbackSpeedMessage.getSpeed().doubleValue());
    }

    public void setVolume(Messages.VolumeMessage volumeMessage) {
        this.videoPlayers.get(volumeMessage.getTextureId().longValue()).setVolume(volumeMessage.getVolume().doubleValue());
    }

    private VideoPlayerPlugin(PluginRegistry.Registrar registrar) {
        FlutterState flutterState2 = new FlutterState(registrar.context(), registrar.messenger(), new q(registrar), new o(registrar), registrar.textures());
        this.flutterState = flutterState2;
        flutterState2.startListening(this, registrar.messenger());
    }
}
