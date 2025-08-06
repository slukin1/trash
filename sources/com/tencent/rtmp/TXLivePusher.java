package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.live.TXLivePusherJni;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;

public class TXLivePusher implements b {
    public static final int RGB_BGRA = 4;
    public static final int RGB_RGBA = 5;
    private static final String TAG = "TXLivePusher";
    public static final int YUV_420P = 3;
    public static final int YUV_420SP = 1;
    public static final int YUV_420YpCbCr = 2;
    private b mImpl;

    public interface AudioCustomProcessListener {
        void onRecordPcmData(byte[] bArr, long j11, int i11, int i12, int i13);

        void onRecordRawPcmData(byte[] bArr, long j11, int i11, int i12, int i13, boolean z11);
    }

    public interface ITXAudioVolumeEvaluationListener {
        void onAudioVolumeEvaluationNotify(int i11);
    }

    public interface ITXSnapshotListener {
        void onSnapshot(Bitmap bitmap);
    }

    @Deprecated
    public interface OnBGMNotify {
        void onBGMComplete(int i11);

        void onBGMProgress(long j11, long j12);

        void onBGMStart();
    }

    public interface VideoCustomProcessListener {
        void onDetectFacePoints(float[] fArr);

        int onTextureCustomProcess(int i11, int i12, int i13);

        void onTextureDestoryed();
    }

    static {
        r.a();
    }

    public TXLivePusher(Context context) {
        this.mImpl = new TXLivePusherJni(context);
        LiteavLog.i(TAG, "Create instance:" + this.mImpl.toString());
    }

    public synchronized void callExperimentalAPI(String str) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.callExperimentalAPI(str);
        }
    }

    public synchronized void enableAudioVolumeEvaluation(int i11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.enableAudioVolumeEvaluation(i11);
        }
    }

    public synchronized TXAudioEffectManager getAudioEffectManager() {
        b bVar = this.mImpl;
        if (bVar == null) {
            return null;
        }
        return bVar.getAudioEffectManager();
    }

    public synchronized TXBeautyManager getBeautyManager() {
        b bVar = this.mImpl;
        if (bVar == null) {
            return null;
        }
        return bVar.getBeautyManager();
    }

    public synchronized TXLivePushConfig getConfig() {
        b bVar = this.mImpl;
        if (bVar == null) {
            return new TXLivePushConfig();
        }
        return bVar.getConfig();
    }

    public synchronized int getMaxZoom() {
        b bVar = this.mImpl;
        if (bVar == null) {
            return 0;
        }
        return bVar.getMaxZoom();
    }

    @Deprecated
    public synchronized int getMusicDuration(String str) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return 0;
        }
        return bVar.getMusicDuration(str);
    }

    public synchronized boolean isPushing() {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.isPushing();
    }

    public synchronized void onLogRecord(String str) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.onLogRecord(str);
        }
    }

    @Deprecated
    public synchronized boolean pauseBGM() {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.pauseBGM();
    }

    public synchronized void pausePusher() {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.pausePusher();
        }
    }

    @Deprecated
    public synchronized boolean playBGM(String str) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.playBGM(str);
    }

    public synchronized void release() {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.release();
            LiteavLog.i(TAG, "Release instance:" + this.mImpl.toString());
            this.mImpl = null;
        }
    }

    @Deprecated
    public synchronized boolean resumeBGM() {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.resumeBGM();
    }

    public synchronized void resumePusher() {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.resumePusher();
        }
    }

    public synchronized void sendCustomPCMData(byte[] bArr) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.sendCustomPCMData(bArr);
        }
    }

    public synchronized int sendCustomVideoData(byte[] bArr, int i11, int i12, int i13) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return -1;
        }
        return bVar.sendCustomVideoData(bArr, i11, i12, i13);
    }

    public synchronized int sendCustomVideoTexture(int i11, int i12, int i13) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return -1;
        }
        return bVar.sendCustomVideoTexture(i11, i12, i13);
    }

    @Deprecated
    public synchronized void sendMessage(byte[] bArr) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.sendMessage(bArr);
        }
    }

    public synchronized boolean sendMessageEx(byte[] bArr) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.sendMessageEx(bArr);
    }

    public synchronized void setAudioProcessListener(AudioCustomProcessListener audioCustomProcessListener) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setAudioProcessListener(audioCustomProcessListener);
        }
    }

    public synchronized void setAudioVolumeEvaluationListener(ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setAudioVolumeEvaluationListener(iTXAudioVolumeEvaluationListener);
        }
    }

    @Deprecated
    public synchronized void setBGMNofify(OnBGMNotify onBGMNotify) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setBGMNofify(onBGMNotify);
        }
    }

    @Deprecated
    public synchronized void setBGMPitch(float f11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setBGMPitch(f11);
        }
    }

    @Deprecated
    public synchronized boolean setBGMPosition(int i11) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setBGMPosition(i11);
    }

    @Deprecated
    public synchronized boolean setBGMVolume(float f11) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setBGMVolume(f11);
    }

    public synchronized boolean setBeautyFilter(int i11, int i12, int i13, int i14) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setBeautyFilter(i11, i12, i13, i14);
    }

    @Deprecated
    public synchronized void setChinLevel(int i11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setChinLevel(i11);
        }
    }

    public synchronized void setConfig(TXLivePushConfig tXLivePushConfig) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setConfig(tXLivePushConfig);
        }
    }

    public synchronized void setExposureCompensation(float f11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setExposureCompensation(f11);
        }
    }

    @Deprecated
    public synchronized void setEyeScaleLevel(int i11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setEyeScaleLevel(i11);
        }
    }

    @Deprecated
    public synchronized void setFaceShortLevel(int i11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setFaceShortLevel(i11);
        }
    }

    @Deprecated
    public synchronized void setFaceSlimLevel(int i11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setFaceSlimLevel(i11);
        }
    }

    @Deprecated
    public synchronized void setFaceVLevel(int i11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setFaceVLevel(i11);
        }
    }

    @Deprecated
    public synchronized void setFilter(Bitmap bitmap) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setFilter(bitmap);
        }
    }

    public synchronized void setFocusPosition(float f11, float f12) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setFocusPosition(f11, f12);
        }
    }

    @Deprecated
    public synchronized boolean setGreenScreenFile(String str) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setGreenScreenFile(str);
    }

    @Deprecated
    public synchronized boolean setMicVolume(float f11) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setMicVolume(f11);
    }

    public synchronized boolean setMirror(boolean z11) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setMirror(z11);
    }

    @Deprecated
    public synchronized void setMotionMute(boolean z11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setMotionMute(z11);
        }
    }

    @Deprecated
    public synchronized void setMotionTmpl(String str) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setMotionTmpl(str);
        }
    }

    public synchronized void setMute(boolean z11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setMute(z11);
        }
    }

    @Deprecated
    public synchronized void setNoseSlimLevel(int i11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setNoseSlimLevel(i11);
        }
    }

    public synchronized void setPushListener(ITXLivePushListener iTXLivePushListener) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setPushListener(iTXLivePushListener);
        }
    }

    public synchronized void setRenderRotation(int i11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setRenderRotation(i11);
        }
    }

    @Deprecated
    public synchronized void setReverb(int i11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setReverb(i11);
        }
    }

    @Deprecated
    public synchronized void setSpecialRatio(float f11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setSpecialRatio(f11);
        }
    }

    public synchronized void setSurface(Surface surface) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setSurface(surface);
        }
    }

    @Deprecated
    public synchronized void setSurfaceSize(int i11, int i12) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setSurfaceSize(i11, i12);
        }
    }

    public synchronized void setVideoProcessListener(VideoCustomProcessListener videoCustomProcessListener) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setVideoProcessListener(videoCustomProcessListener);
        }
    }

    public synchronized void setVideoQuality(int i11, boolean z11, boolean z12) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setVideoQuality(i11, z11, z12);
        }
    }

    public synchronized void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setVideoRecordListener(iTXVideoRecordListener);
        }
    }

    @Deprecated
    public synchronized void setVoiceChangerType(int i11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.setVoiceChangerType(i11);
        }
    }

    public synchronized boolean setZoom(int i11) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.setZoom(i11);
    }

    public synchronized void snapshot(ITXSnapshotListener iTXSnapshotListener) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.snapshot(iTXSnapshotListener);
        }
    }

    public synchronized void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.startCameraPreview(tXCloudVideoView);
        }
    }

    public synchronized int startPusher(String str) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return -1;
        }
        return bVar.startPusher(str);
    }

    public synchronized int startRecord(String str) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return -3;
        }
        return bVar.startRecord(str);
    }

    public synchronized void startScreenCapture() {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.startScreenCapture();
        }
    }

    @Deprecated
    public synchronized boolean stopBGM() {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.stopBGM();
    }

    public synchronized void stopCameraPreview(boolean z11) {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.stopCameraPreview(z11);
        }
    }

    public synchronized void stopPusher() {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.stopPusher();
        }
    }

    public synchronized void stopRecord() {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.stopRecord();
        }
    }

    public synchronized void stopScreenCapture() {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.stopScreenCapture();
        }
    }

    public synchronized void switchCamera() {
        b bVar = this.mImpl;
        if (bVar != null) {
            bVar.switchCamera();
        }
    }

    public synchronized boolean turnOnFlashLight(boolean z11) {
        b bVar = this.mImpl;
        if (bVar == null) {
            return false;
        }
        return bVar.turnOnFlashLight(z11);
    }
}
