package com.tencent.ugc;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.datereport.UGCDataReport;

public class TXUGCRecord {
    private static final String TAG = "TXUGCRecord";
    private static TXUGCRecord instance;
    private UGCRecorderJni mUGCRecorder;

    public interface VideoCustomProcessListener {
        void onDetectFacePoints(float[] fArr);

        int onTextureCustomProcess(int i11, int i12, int i13);

        void onTextureDestroyed();
    }

    public TXUGCRecord(Context context) {
        UGCRecorderJni uGCRecorderJni = new UGCRecorderJni(context);
        this.mUGCRecorder = uGCRecorderJni;
        uGCRecorderJni.setBGMLoop(true);
        UGCDataReport.reportLicenseIsValid();
    }

    public static synchronized TXUGCRecord getInstance(Context context) {
        TXUGCRecord tXUGCRecord;
        synchronized (TXUGCRecord.class) {
            if (instance == null) {
                instance = new TXUGCRecord(context);
            }
            tXUGCRecord = instance;
        }
        return tXUGCRecord;
    }

    public TXBeautyManager getBeautyManager() {
        return this.mUGCRecorder.getBeautyManager();
    }

    public int getMaxZoom() {
        return this.mUGCRecorder.getMaxZoom();
    }

    public int getMusicDuration(String str) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.getMusicDuration(str);
        }
        LiteavLog.e(TAG, "setBGMVolume is not supported in UGC_Smart license");
        return 0;
    }

    public TXUGCPartsManager getPartsManager() {
        return this.mUGCRecorder.getPartsManager();
    }

    public boolean pauseBGM() {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.pauseBGM();
        }
        LiteavLog.e(TAG, "pauseBGM is not supported in UGC_Smart license");
        return false;
    }

    public int pauseRecord() {
        return this.mUGCRecorder.pauseRecord();
    }

    public boolean playBGMFromTime(int i11, int i12) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.playBGMFromTime(i11, i12);
        }
        LiteavLog.e(TAG, "playBGMFromTime is not supported in UGC_Smart license");
        return false;
    }

    public void release() {
        this.mUGCRecorder.release();
    }

    public boolean resumeBGM() {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.resumeBGM();
        }
        LiteavLog.e(TAG, "resumeBGM is not supported in UGC_Smart license");
        return false;
    }

    public int resumeRecord() {
        return this.mUGCRecorder.resumeRecord();
    }

    public boolean seekBGM(int i11, int i12) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.seekBGM(i11, i12);
        }
        LiteavLog.e(TAG, "seekBGM is not supported in UGC_Smart license");
        return false;
    }

    public void setAspectRatio(int i11) {
        this.mUGCRecorder.setAspectRatio(i11);
    }

    public int setBGM(String str) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.setBGM(str);
        }
        LiteavLog.e(TAG, "setBGM is not supported in UGC_Smart license");
        return -1;
    }

    public void setBGMLoop(boolean z11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setBGMLoop is not supported in UGC_Smart license");
        } else {
            this.mUGCRecorder.setBGMLoop(z11);
        }
    }

    public void setBGMNofify(TXRecordCommon.ITXBGMNotify iTXBGMNotify) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setBGMNofify is not supported in UGC_Smart license");
        } else {
            this.mUGCRecorder.setBGMNotify(iTXBGMNotify);
        }
    }

    public boolean setBGMVolume(float f11) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.setBGMVolume(f11);
        }
        LiteavLog.e(TAG, "setBGMVolume is not supported in UGC_Smart license");
        return false;
    }

    @Deprecated
    public void setBeautyDepth(int i11, int i12, int i13, int i14) {
        this.mUGCRecorder.setBeautyDepth(i11, i12, i13, i14);
    }

    @Deprecated
    public void setBeautyStyle(int i11) {
        this.mUGCRecorder.setBeautyStyle(i11);
    }

    @Deprecated
    public void setChinLevel(int i11) {
        if (!UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            LiteavLog.e(TAG, "setChinLevel is not supported below enterprise pro license");
        } else {
            this.mUGCRecorder.setChinLevel(i11);
        }
    }

    @Deprecated
    public void setEyeScaleLevel(float f11) {
        if (!UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            LiteavLog.e(TAG, "setEyeScaleLevel is not supported below enterprise pro license");
        } else {
            this.mUGCRecorder.setEyeScaleLevel(f11);
        }
    }

    @Deprecated
    public void setFaceScaleLevel(float f11) {
        if (!UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            LiteavLog.e(TAG, "setFaceScaleLevel is not supported below enterprise pro license");
        } else {
            this.mUGCRecorder.setFaceScaleLevel(f11);
        }
    }

    @Deprecated
    public void setFaceShortLevel(int i11) {
        if (!UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            LiteavLog.e(TAG, "setFaceVLevel is not supported below enterprise pro license");
        } else {
            this.mUGCRecorder.setFaceShortLevel(i11);
        }
    }

    @Deprecated
    public void setFaceVLevel(int i11) {
        if (!UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            LiteavLog.e(TAG, "setFaceVLevel is not supported below enterprise pro license");
        } else {
            this.mUGCRecorder.setFaceVLevel(i11);
        }
    }

    @Deprecated
    public void setFilter(Bitmap bitmap) {
        this.mUGCRecorder.setFilter(bitmap);
    }

    public void setFocusPosition(float f11, float f12) {
        this.mUGCRecorder.setFocusPosition(f11, f12);
    }

    @Deprecated
    public void setGreenScreenFile(String str, boolean z11) {
        if (!UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            LiteavLog.e(TAG, "setGreenScreenFile is not supported below enterprise license");
        } else {
            this.mUGCRecorder.setGreenScreenFile(str, z11);
        }
    }

    public void setHomeOrientation(int i11) {
        this.mUGCRecorder.setHomeOrientation(i11);
    }

    public boolean setMicVolume(float f11) {
        return this.mUGCRecorder.setMicVolume(f11);
    }

    @Deprecated
    public void setMotionMute(boolean z11) {
        if (!UGCLicenseChecker.isEnterpriseFunctionSupport()) {
            LiteavLog.e(TAG, "setMotionMute is not supported below enterprise license");
        } else {
            this.mUGCRecorder.setMotionMute(z11);
        }
    }

    @Deprecated
    public void setMotionTmpl(String str) {
        if (!UGCLicenseChecker.isEnterpriseFunctionSupport()) {
            LiteavLog.e(TAG, "setMotionTmpl is not supported below enterprise license");
        } else {
            this.mUGCRecorder.setMotionTmpl(str);
        }
    }

    public void setMute(boolean z11) {
        this.mUGCRecorder.setMute(z11);
    }

    @Deprecated
    public void setNoseSlimLevel(int i11) {
        if (!UGCLicenseChecker.isEnterpriseProFunctionSupport()) {
            LiteavLog.e(TAG, "setNoseSlimLevel is not supported below enterprise pro license");
        } else {
            this.mUGCRecorder.setNoseSlimLevel(i11);
        }
    }

    public void setRecordSpeed(int i11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setRecordSpeed is not supported in UGC_Smart license");
        } else {
            this.mUGCRecorder.setRecordSpeed(i11);
        }
    }

    public void setRenderRotation(int i11) {
        this.mUGCRecorder.setRenderRotation(i11);
    }

    public void setReverb(int i11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setReverb is not supported in UGC_Smart license");
        } else {
            this.mUGCRecorder.setReverb(i11);
        }
    }

    @Deprecated
    public void setSpecialRatio(float f11) {
        this.mUGCRecorder.setSpecialRatio(f11);
    }

    public void setVideoBitrate(int i11) {
        this.mUGCRecorder.setVideoBitrate(i11);
    }

    public void setVideoEncoderMirror(boolean z11) {
        this.mUGCRecorder.setVideoEncoderMirror(z11);
    }

    public void setVideoProcessListener(VideoCustomProcessListener videoCustomProcessListener) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setVideoProcessListener is not supported in UGC_Smart license");
        } else {
            this.mUGCRecorder.setVideoProcessListener(videoCustomProcessListener);
        }
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mUGCRecorder.setVideoRecordListener(iTXVideoRecordListener);
    }

    public void setVideoRenderMirrorType(int i11) {
        this.mUGCRecorder.setVideoRenderMirrorType(i11);
    }

    public void setVideoRenderMode(int i11) {
        this.mUGCRecorder.setVideoRenderMode(i11);
    }

    public void setVideoResolution(int i11) {
        this.mUGCRecorder.setVideoResolution(i11);
    }

    public void setVoiceChangerType(int i11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setVoiceChangerType is not supported in UGC_Smart license");
        } else {
            this.mUGCRecorder.setVoiceChangerType(i11);
        }
    }

    public void setWatermark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setWatermark is not supported in UGC_Smart license");
        } else {
            this.mUGCRecorder.setWatermark(bitmap, tXRect);
        }
    }

    public boolean setZoom(int i11) {
        return this.mUGCRecorder.setZoom(i11);
    }

    public void snapshot(TXRecordCommon.ITXSnapshotListener iTXSnapshotListener) {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            this.mUGCRecorder.snapshot(iTXSnapshotListener);
        }
    }

    public int startCameraCustomPreview(TXRecordCommon.TXUGCCustomConfig tXUGCCustomConfig, TXCloudVideoView tXCloudVideoView) {
        return this.mUGCRecorder.startCameraCustomPreview(tXUGCCustomConfig, tXCloudVideoView);
    }

    public int startCameraSimplePreview(TXRecordCommon.TXUGCSimpleConfig tXUGCSimpleConfig, TXCloudVideoView tXCloudVideoView) {
        return this.mUGCRecorder.startCameraSimplePreview(tXUGCSimpleConfig, tXCloudVideoView);
    }

    public int startRecord() {
        if (!UGCLicenseChecker.isSimpleFunctionSupport()) {
            return -5;
        }
        return this.mUGCRecorder.startRecord();
    }

    public boolean stopBGM() {
        if (UGCLicenseChecker.isStandardFunctionSupport()) {
            return this.mUGCRecorder.stopBGM();
        }
        LiteavLog.e(TAG, "stopBGM is not supported in UGC_Smart license");
        return false;
    }

    public void stopCameraPreview() {
        this.mUGCRecorder.stopCameraPreview();
    }

    public int stopRecord() {
        return this.mUGCRecorder.stopRecord();
    }

    public boolean switchCamera(boolean z11) {
        return this.mUGCRecorder.switchCamera(z11);
    }

    public boolean toggleTorch(boolean z11) {
        return this.mUGCRecorder.toggleTorch(z11);
    }

    public void setFilter(Bitmap bitmap, float f11, Bitmap bitmap2, float f12, float f13) {
        this.mUGCRecorder.setFilter(bitmap, f11, bitmap2, f12, f13);
    }

    public int startRecord(String str, String str2) {
        if (!UGCLicenseChecker.isSimpleFunctionSupport()) {
            return -5;
        }
        return this.mUGCRecorder.startRecord(str, str2);
    }

    public int startRecord(String str, String str2, String str3) {
        if (!UGCLicenseChecker.isSimpleFunctionSupport()) {
            return -5;
        }
        return this.mUGCRecorder.startRecord(str, str2, str3);
    }
}
