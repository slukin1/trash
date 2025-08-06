package com.tencent.trtc;

import android.graphics.Bitmap;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;

public abstract class DeprecatedTRTCCloud {
    @Deprecated
    public abstract int checkAudioCapabilitySupport(int i11);

    public abstract void enableAudioEarMonitoring(boolean z11);

    @Deprecated
    public abstract void enableAudioVolumeEvaluation(int i11);

    @Deprecated
    public abstract void enableAudioVolumeEvaluation(int i11, boolean z11);

    @Deprecated
    public abstract void enableCustomVideoCapture(boolean z11);

    @Deprecated
    public abstract boolean enableTorch(boolean z11);

    @Deprecated
    public abstract int getBGMDuration(String str);

    @Deprecated
    public abstract boolean isCameraAutoFocusFaceModeSupported();

    @Deprecated
    public abstract boolean isCameraFocusPositionInPreviewSupported();

    @Deprecated
    public abstract boolean isCameraTorchSupported();

    @Deprecated
    public abstract boolean isCameraZoomSupported();

    @Deprecated
    public abstract void muteLocalVideo(boolean z11);

    @Deprecated
    public abstract void muteRemoteVideoStream(String str, boolean z11);

    @Deprecated
    public abstract void pauseAudioEffect(int i11);

    @Deprecated
    public abstract void pauseBGM();

    @Deprecated
    public abstract void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam tRTCAudioEffectParam);

    @Deprecated
    public abstract void playBGM(String str, TRTCCloud.BGMNotify bGMNotify);

    @Deprecated
    public abstract void resumeAudioEffect(int i11);

    @Deprecated
    public abstract void resumeBGM();

    @Deprecated
    public abstract void selectMotionTmpl(String str);

    @Deprecated
    public abstract void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame);

    @Deprecated
    public abstract void setAllAudioEffectsVolume(int i11);

    @Deprecated
    public abstract void setAudioEffectVolume(int i11, int i12);

    @Deprecated
    public abstract void setAudioQuality(int i11);

    @Deprecated
    public abstract void setBGMPlayoutVolume(int i11);

    @Deprecated
    public abstract int setBGMPosition(int i11);

    @Deprecated
    public abstract void setBGMPublishVolume(int i11);

    @Deprecated
    public abstract void setBGMVolume(int i11);

    @Deprecated
    public abstract void setBeautyStyle(int i11, int i12, int i13, int i14);

    @Deprecated
    public abstract void setChinLevel(int i11);

    @Deprecated
    public abstract void setEyeScaleLevel(int i11);

    @Deprecated
    public abstract void setFaceShortLevel(int i11);

    @Deprecated
    public abstract void setFaceSlimLevel(int i11);

    @Deprecated
    public abstract void setFaceVLevel(int i11);

    @Deprecated
    public abstract void setFilter(Bitmap bitmap);

    @Deprecated
    public abstract void setFilterConcentration(float f11);

    @Deprecated
    public abstract void setFocusPosition(int i11, int i12);

    @Deprecated
    public abstract void setGSensorMode(int i11);

    @Deprecated
    public abstract boolean setGreenScreenFile(String str);

    @Deprecated
    public abstract void setListener(TRTCCloudListener tRTCCloudListener);

    @Deprecated
    public abstract void setLocalViewFillMode(int i11);

    @Deprecated
    public abstract void setLocalViewMirror(int i11);

    @Deprecated
    public abstract void setLocalViewRotation(int i11);

    @Deprecated
    public abstract void setMicVolumeOnMixing(int i11);

    @Deprecated
    public abstract void setMotionMute(boolean z11);

    @Deprecated
    public abstract void setNoseSlimLevel(int i11);

    @Deprecated
    public abstract int setPriorRemoteVideoStreamType(int i11);

    @Deprecated
    public abstract void setRemoteSubStreamViewFillMode(String str, int i11);

    @Deprecated
    public abstract void setRemoteSubStreamViewRotation(String str, int i11);

    @Deprecated
    public abstract void setRemoteViewFillMode(String str, int i11);

    @Deprecated
    public abstract void setRemoteViewRotation(String str, int i11);

    @Deprecated
    public abstract void setReverbType(int i11);

    public abstract void setSystemVolumeType(int i11);

    @Deprecated
    public abstract void setVideoEncoderMirror(boolean z11);

    @Deprecated
    public abstract void setVideoEncoderRotation(int i11);

    @Deprecated
    public abstract boolean setVoiceChangerType(int i11);

    @Deprecated
    public abstract void setZoom(int i11);

    @Deprecated
    public abstract void snapshotVideo(String str, int i11, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener);

    @Deprecated
    public abstract void startLocalAudio();

    @Deprecated
    public abstract void startRemoteSubStreamView(String str, TXCloudVideoView tXCloudVideoView);

    @Deprecated
    public abstract void startRemoteView(String str, TXCloudVideoView tXCloudVideoView);

    @Deprecated
    public abstract void startScreenCapture(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams);

    @Deprecated
    public abstract void startSpeedTest(int i11, String str, String str2);

    @Deprecated
    public abstract void stopAllAudioEffects();

    @Deprecated
    public abstract void stopAudioEffect(int i11);

    @Deprecated
    public abstract void stopBGM();

    @Deprecated
    public abstract void stopRemoteSubStreamView(String str);

    @Deprecated
    public abstract void stopRemoteView(String str);

    @Deprecated
    public abstract void switchCamera();
}
