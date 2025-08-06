package com.tencent.rtmp;

import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

public interface b {
    void callExperimentalAPI(String str);

    void enableAudioVolumeEvaluation(int i11);

    TXAudioEffectManager getAudioEffectManager();

    TXBeautyManager getBeautyManager();

    TXLivePushConfig getConfig();

    int getMaxZoom();

    @Deprecated
    int getMusicDuration(String str);

    boolean isPushing();

    void onLogRecord(String str);

    @Deprecated
    boolean pauseBGM();

    void pausePusher();

    @Deprecated
    boolean playBGM(String str);

    void release();

    @Deprecated
    boolean resumeBGM();

    void resumePusher();

    void sendCustomPCMData(byte[] bArr);

    int sendCustomVideoData(byte[] bArr, int i11, int i12, int i13);

    int sendCustomVideoTexture(int i11, int i12, int i13);

    @Deprecated
    void sendMessage(byte[] bArr);

    boolean sendMessageEx(byte[] bArr);

    void setAudioProcessListener(TXLivePusher.AudioCustomProcessListener audioCustomProcessListener);

    void setAudioVolumeEvaluationListener(TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener);

    @Deprecated
    void setBGMNofify(TXLivePusher.OnBGMNotify onBGMNotify);

    @Deprecated
    void setBGMPitch(float f11);

    @Deprecated
    boolean setBGMPosition(int i11);

    @Deprecated
    boolean setBGMVolume(float f11);

    boolean setBeautyFilter(int i11, int i12, int i13, int i14);

    @Deprecated
    void setChinLevel(int i11);

    void setConfig(TXLivePushConfig tXLivePushConfig);

    void setExposureCompensation(float f11);

    @Deprecated
    void setEyeScaleLevel(int i11);

    @Deprecated
    void setFaceShortLevel(int i11);

    @Deprecated
    void setFaceSlimLevel(int i11);

    @Deprecated
    void setFaceVLevel(int i11);

    @Deprecated
    void setFilter(Bitmap bitmap);

    void setFocusPosition(float f11, float f12);

    @Deprecated
    boolean setGreenScreenFile(String str);

    @Deprecated
    boolean setMicVolume(float f11);

    boolean setMirror(boolean z11);

    @Deprecated
    void setMotionMute(boolean z11);

    @Deprecated
    void setMotionTmpl(String str);

    void setMute(boolean z11);

    @Deprecated
    void setNoseSlimLevel(int i11);

    void setPushListener(ITXLivePushListener iTXLivePushListener);

    void setRenderRotation(int i11);

    @Deprecated
    void setReverb(int i11);

    @Deprecated
    void setSpecialRatio(float f11);

    void setSurface(Surface surface);

    @Deprecated
    void setSurfaceSize(int i11, int i12);

    void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener videoCustomProcessListener);

    void setVideoQuality(int i11, boolean z11, boolean z12);

    void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener);

    @Deprecated
    void setVoiceChangerType(int i11);

    boolean setZoom(int i11);

    void snapshot(TXLivePusher.ITXSnapshotListener iTXSnapshotListener);

    void startCameraPreview(TXCloudVideoView tXCloudVideoView);

    int startPusher(String str);

    int startRecord(String str);

    void startScreenCapture();

    @Deprecated
    boolean stopBGM();

    void stopCameraPreview(boolean z11);

    void stopPusher();

    void stopRecord();

    void stopScreenCapture();

    void switchCamera();

    boolean turnOnFlashLight(boolean z11);
}
