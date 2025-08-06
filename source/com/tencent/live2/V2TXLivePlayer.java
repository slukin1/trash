package com.tencent.live2;

import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;

public abstract class V2TXLivePlayer {
    public abstract int enableObserveAudioFrame(boolean z11);

    public abstract int enableObserveVideoFrame(boolean z11, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType);

    public abstract int enableReceiveSeiMessage(boolean z11, int i11);

    public abstract int enableVolumeEvaluation(int i11);

    public abstract ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> getStreamList();

    public abstract int isPlaying();

    public abstract int pauseAudio();

    public abstract int pauseVideo();

    public abstract int resumeAudio();

    public abstract int resumeVideo();

    public abstract int setCacheParams(float f11, float f12);

    public abstract void setObserver(V2TXLivePlayerObserver v2TXLivePlayerObserver);

    public abstract int setPlayoutVolume(int i11);

    public abstract int setProperty(String str, Object obj);

    public abstract int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode);

    public abstract int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation);

    public abstract int setRenderView(SurfaceView surfaceView);

    public abstract int setRenderView(TextureView textureView);

    public abstract int setRenderView(TXCloudVideoView tXCloudVideoView);

    public abstract void showDebugView(boolean z11);

    public abstract int snapshot();

    public abstract int startLivePlay(String str);

    public abstract int startLocalRecording(V2TXLiveDef.V2TXLiveLocalRecordingParams v2TXLiveLocalRecordingParams);

    public abstract void stopLocalRecording();

    public abstract int stopPlay();

    public abstract int switchStream(String str);
}
