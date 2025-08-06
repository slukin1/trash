package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.live.TXLivePlayerJni;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

public class TXLivePlayer {
    public static final int PLAY_TYPE_LIVE_FLV = 1;
    public static final int PLAY_TYPE_LIVE_HLS = 7;
    public static final int PLAY_TYPE_LIVE_RTMP = 0;
    public static final int PLAY_TYPE_LIVE_RTMP_ACC = 5;
    public static final String TAG = "TXLivePlayer";
    private a mImpl;

    public interface ITXAudioRawDataListener {
        void onAudioInfoChanged(int i11, int i12, int i13);

        void onPcmDataAvailable(byte[] bArr, long j11);
    }

    public interface ITXAudioVolumeEvaluationListener {
        void onAudioVolumeEvaluationNotify(int i11);
    }

    public interface ITXLivePlayVideoRenderListener {
        void onRenderVideoFrame(TXLiteAVTexture tXLiteAVTexture);
    }

    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    public interface ITXVideoRawDataListener {
        void onVideoRawDataAvailable(byte[] bArr, int i11, int i12, int i13);
    }

    public static class TXLiteAVTexture {
        public Object eglContext;
        public int height;
        public int textureId;
        public int width;
    }

    static {
        r.a();
    }

    public TXLivePlayer(Context context) {
        this.mImpl = new TXLivePlayerJni(context);
    }

    public void callExperimentalAPI(String str) {
        this.mImpl.callExperimentalAPI(str);
    }

    public void enableAudioVolumeEvaluation(int i11) {
        this.mImpl.enableAudioVolumeEvaluation(i11);
    }

    public boolean enableHardwareDecode(boolean z11) {
        return this.mImpl.enableHardwareDecode(z11);
    }

    public long getCurrentRenderPts() {
        return this.mImpl.getCurrentRenderPts();
    }

    public boolean isPlaying() {
        return this.mImpl.isPlaying();
    }

    public void pause() {
        this.mImpl.pause();
    }

    public void resume() {
        this.mImpl.resume();
    }

    public void setAudioRawDataListener(ITXAudioRawDataListener iTXAudioRawDataListener) {
        this.mImpl.setAudioRawDataListener(iTXAudioRawDataListener);
    }

    public void setAudioRoute(int i11) {
        this.mImpl.setAudioRoute(i11);
    }

    public void setAudioVolumeEvaluationListener(ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.mImpl.setAudioVolumeEvaluationListener(iTXAudioVolumeEvaluationListener);
    }

    public void setConfig(TXLivePlayConfig tXLivePlayConfig) {
        this.mImpl.setConfig(tXLivePlayConfig);
    }

    public void setMute(boolean z11) {
        this.mImpl.setMute(z11);
    }

    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        this.mImpl.setPlayListener(iTXLivePlayListener);
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        this.mImpl.setPlayerView(tXCloudVideoView);
    }

    public void setRenderMode(int i11) {
        this.mImpl.setRenderMode(i11);
    }

    public void setRenderRotation(int i11) {
        this.mImpl.setRenderRotation(i11);
    }

    public void setSurface(Surface surface) {
        this.mImpl.setSurface(surface);
    }

    public void setSurfaceSize(int i11, int i12) {
        this.mImpl.setSurfaceSize(i11, i12);
    }

    public void setVideoRawDataListener(ITXVideoRawDataListener iTXVideoRawDataListener) {
        this.mImpl.setVideoRawDataListener(iTXVideoRawDataListener);
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mImpl.setVideoRecordListener(iTXVideoRecordListener);
    }

    public int setVideoRenderListener(ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj) {
        return this.mImpl.setVideoRenderListener(iTXLivePlayVideoRenderListener, obj);
    }

    public void setVolume(int i11) {
        this.mImpl.setVolume(i11);
    }

    public void showDebugView(boolean z11) {
        this.mImpl.showDebugView(z11);
    }

    public void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        this.mImpl.snapshot(iTXSnapshotListener);
    }

    public int startLivePlay(String str, int i11) {
        return this.mImpl.startLivePlay(str, i11);
    }

    public int startRecord(int i11) {
        return this.mImpl.startRecord(i11);
    }

    public int stopPlay(boolean z11) {
        return this.mImpl.stopPlay(z11);
    }

    public int stopRecord() {
        return this.mImpl.stopRecord();
    }

    public int switchStream(String str) {
        return this.mImpl.switchStream(str);
    }
}
