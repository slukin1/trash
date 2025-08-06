package com.tencent.live2.impl;

import android.content.Context;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.live.V2TXLivePlayerJni;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;

public class V2TXLivePlayerImpl extends V2TXLivePlayer {
    private V2TXLivePlayer mImpl;

    static {
        r.a();
    }

    public V2TXLivePlayerImpl(Context context) {
        this.mImpl = new V2TXLivePlayerJni(context, this);
    }

    public int enableObserveAudioFrame(boolean z11) {
        return this.mImpl.enableObserveAudioFrame(z11);
    }

    public int enableObserveVideoFrame(boolean z11, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        return this.mImpl.enableObserveVideoFrame(z11, v2TXLivePixelFormat, v2TXLiveBufferType);
    }

    public int enableReceiveSeiMessage(boolean z11, int i11) {
        return this.mImpl.enableReceiveSeiMessage(z11, i11);
    }

    public int enableVolumeEvaluation(int i11) {
        return this.mImpl.enableVolumeEvaluation(i11);
    }

    public ArrayList<V2TXLiveDef.V2TXLiveStreamInfo> getStreamList() {
        return this.mImpl.getStreamList();
    }

    public int isPlaying() {
        return this.mImpl.isPlaying();
    }

    public int pauseAudio() {
        return this.mImpl.pauseAudio();
    }

    public int pauseVideo() {
        return this.mImpl.pauseVideo();
    }

    public int resumeAudio() {
        return this.mImpl.resumeAudio();
    }

    public int resumeVideo() {
        return this.mImpl.resumeVideo();
    }

    public int setCacheParams(float f11, float f12) {
        return this.mImpl.setCacheParams(f11, f12);
    }

    public void setObserver(V2TXLivePlayerObserver v2TXLivePlayerObserver) {
        this.mImpl.setObserver(v2TXLivePlayerObserver);
    }

    public int setPlayoutVolume(int i11) {
        return this.mImpl.setPlayoutVolume(i11);
    }

    public int setProperty(String str, Object obj) {
        return this.mImpl.setProperty(str, obj);
    }

    public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode) {
        return this.mImpl.setRenderFillMode(v2TXLiveFillMode);
    }

    public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        return this.mImpl.setRenderRotation(v2TXLiveRotation);
    }

    public int setRenderView(TXCloudVideoView tXCloudVideoView) {
        return this.mImpl.setRenderView(tXCloudVideoView);
    }

    public void showDebugView(boolean z11) {
        this.mImpl.showDebugView(z11);
    }

    public int snapshot() {
        return this.mImpl.snapshot();
    }

    public int startLivePlay(String str) {
        return this.mImpl.startLivePlay(str);
    }

    public int startLocalRecording(V2TXLiveDef.V2TXLiveLocalRecordingParams v2TXLiveLocalRecordingParams) {
        return this.mImpl.startLocalRecording(v2TXLiveLocalRecordingParams);
    }

    public void stopLocalRecording() {
        this.mImpl.stopLocalRecording();
    }

    public int stopPlay() {
        return this.mImpl.stopPlay();
    }

    public int switchStream(String str) {
        return this.mImpl.switchStream(str);
    }

    public int setRenderView(TextureView textureView) {
        return this.mImpl.setRenderView(textureView);
    }

    public int setRenderView(SurfaceView surfaceView) {
        return this.mImpl.setRenderView(surfaceView);
    }
}
