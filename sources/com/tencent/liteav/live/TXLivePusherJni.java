package com.tencent.liteav.live;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Bundle;
import android.view.Surface;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.i;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.TXBeautyManagerImpl;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.b;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import com.youth.banner.config.BannerConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@JNINamespace("liteav")
public class TXLivePusherJni implements ITXLivePushListener, TXLivePusher.AudioCustomProcessListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.ITXSnapshotListener, TXLivePusher.OnBGMNotify, TXLivePusher.VideoCustomProcessListener, b, TXCloudVideoView.b {
    private TXLivePusher.AudioCustomProcessListener mAudioCustomProcessListener;
    private TXAudioEffectManager mAudioEffectManager;
    private TXBeautyManagerImpl mBeautyManager;
    private TXLivePushConfig mConfig;
    private TXLivePusher.ITXAudioVolumeEvaluationListener mITXAudioVolumeEvaluationListener;
    private ITXLivePushListener mITXLivePushListener;
    private TXLivePusher.ITXSnapshotListener mITXSnapshotListener;
    private TXRecordCommon.ITXVideoRecordListener mITXVideoRecordListener;
    private long mNativeTXLivePusherJni = 0;
    private TXLivePusher.OnBGMNotify mOnBGMNotify;
    private TXLivePusher.VideoCustomProcessListener mVideoCustomProcessListener;
    private int mVideoQuality = -1;

    public TXLivePusherJni(Context context) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        this.mConfig = new TXLivePushConfig();
        long nativeCreate = nativeCreate(new WeakReference(this));
        this.mNativeTXLivePusherJni = nativeCreate;
        this.mAudioEffectManager = new TXAudioEffectManagerImpl(nativeCreateAudioEffectManager(nativeCreate));
        this.mBeautyManager = new TXBeautyManagerImpl(nativeCreateBeautyManager(this.mNativeTXLivePusherJni));
        if (context instanceof Activity) {
            i.a().a((Activity) context);
        }
    }

    public static String[] getMapKeys(HashMap<String, String> hashMap) {
        String[] strArr = new String[hashMap.size()];
        int i11 = 0;
        for (String str : hashMap.keySet()) {
            strArr[i11] = str;
            i11++;
        }
        return strArr;
    }

    public static String[] getMapValues(HashMap<String, String> hashMap, String[] strArr) {
        String[] strArr2 = new String[hashMap.size()];
        int length = strArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            strArr2[i12] = hashMap.get(strArr[i11]);
            i11++;
            i12++;
        }
        return strArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isMapValid(java.util.HashMap<java.lang.String, java.lang.String> r2) {
        /*
            java.util.Set r0 = r2.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x001e
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x001c
            java.lang.Object r1 = r2.get(r1)
            if (r1 != 0) goto L_0x0008
        L_0x001c:
            r2 = 0
            return r2
        L_0x001e:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.live.TXLivePusherJni.isMapValid(java.util.HashMap):boolean");
    }

    private static native void nativeCallExperimentalAPI(long j11, String str);

    private static native long nativeCreate(WeakReference<TXLivePusherJni> weakReference);

    private static native long nativeCreateAudioEffectManager(long j11);

    private static native long nativeCreateBeautyManager(long j11);

    private static native void nativeDestroy(long j11);

    private static native void nativeEnableAudioVolumeEvaluation(long j11, int i11);

    private static native int nativeGetMaxZoom(long j11);

    private static native int nativeGetMusicDuration(long j11, String str);

    private static native boolean nativeIsPushing(long j11);

    private static native void nativeOnLogRecord(long j11, String str);

    private static native boolean nativePauseBGM(long j11);

    private static native void nativePausePusher(long j11);

    private static native boolean nativePlayBGM(long j11, String str);

    private static native boolean nativeResumeBGM(long j11);

    private static native void nativeResumePusher(long j11);

    private static native void nativeSendCustomPCMData(long j11, byte[] bArr);

    private static native void nativeSendCustomVideoFrame(long j11, int i11, int i12, int i13, int i14, int i15, Object obj, byte[] bArr);

    private static native void nativeSendMessage(long j11, byte[] bArr);

    private static native boolean nativeSendMessageEx(long j11, byte[] bArr);

    private static native void nativeSetAudioConfig(long j11, int i11, int i12, int i13, boolean z11, boolean z12);

    private static native void nativeSetBGMPitch(long j11, float f11);

    private static native boolean nativeSetBGMPosition(long j11, int i11);

    private static native boolean nativeSetBGMVolume(long j11, float f11);

    private static native boolean nativeSetBeautyFilter(long j11, int i11, int i12, int i13, int i14);

    private static native void nativeSetCaptureConfig(long j11, int i11, int i12, Bitmap bitmap, int i13, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i14);

    private static native void nativeSetEncoderConfig(long j11, int i11, int i12, boolean z11, int i13, int i14, int i15, int i16, int i17, boolean z12, int i18, boolean z13);

    private static native void nativeSetExposureCompensation(long j11, float f11);

    private static native void nativeSetFilter(long j11, Bitmap bitmap);

    private static native void nativeSetFocusPosition(long j11, float f11, float f12);

    private static native boolean nativeSetMicVolume(long j11, float f11);

    private static native boolean nativeSetMirror(long j11, boolean z11);

    private static native void nativeSetMute(long j11, boolean z11);

    private static native void nativeSetNetworkConfig(long j11, int i11, boolean z11, int i12, int i13, int i14, HashMap hashMap);

    private static native void nativeSetRenderRotation(long j11, int i11);

    private static native void nativeSetReverb(long j11, int i11);

    private static native void nativeSetSpecialRatio(long j11, float f11);

    private static native void nativeSetView(long j11, DisplayTarget displayTarget);

    private static native void nativeSetVoiceChangerType(long j11, int i11);

    private static native void nativeSetWaterMark(long j11, Bitmap bitmap, float f11, float f12, float f13);

    private static native boolean nativeSetZoom(long j11, int i11);

    private static native void nativeShowDebugView(long j11, boolean z11);

    private static native void nativeSnapshot(long j11);

    private static native void nativeStartCamera(long j11);

    private static native int nativeStartPusher(long j11, String str);

    private static native int nativeStartRecord(long j11, String str);

    private static native void nativeStartScreenCapture(long j11);

    private static native boolean nativeStopBGM(long j11);

    private static native void nativeStopCameraPreview(long j11, boolean z11);

    private static native void nativeStopPusher(long j11);

    private static native void nativeStopRecord(long j11);

    private static native void nativeStopScreenCapture(long j11);

    private static native void nativeSwitchCamera(long j11);

    private static native boolean nativeTurnOnFlashLight(long j11, boolean z11);

    public static TXLivePusherJni weakToStrongReference(WeakReference<TXLivePusherJni> weakReference) {
        return (TXLivePusherJni) weakReference.get();
    }

    public void callExperimentalAPI(String str) {
        nativeCallExperimentalAPI(this.mNativeTXLivePusherJni, str);
    }

    public void enableAudioVolumeEvaluation(int i11) {
        nativeEnableAudioVolumeEvaluation(this.mNativeTXLivePusherJni, i11);
    }

    public void finalize() throws Throwable {
        super.finalize();
        release();
    }

    public TXAudioEffectManager getAudioEffectManager() {
        return this.mAudioEffectManager;
    }

    public TXBeautyManager getBeautyManager() {
        return this.mBeautyManager;
    }

    public TXLivePushConfig getConfig() {
        return this.mConfig;
    }

    public int getMaxZoom() {
        return nativeGetMaxZoom(this.mNativeTXLivePusherJni);
    }

    public int getMusicDuration(String str) {
        return nativeGetMusicDuration(this.mNativeTXLivePusherJni, str);
    }

    public boolean isPushing() {
        return nativeIsPushing(this.mNativeTXLivePusherJni);
    }

    public void onAudioVolumeEvaluationNotify(int i11) {
        TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener = this.mITXAudioVolumeEvaluationListener;
        if (iTXAudioVolumeEvaluationListener != null) {
            iTXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(i11);
        }
    }

    public void onBGMComplete(int i11) {
        TXLivePusher.OnBGMNotify onBGMNotify = this.mOnBGMNotify;
        if (onBGMNotify != null) {
            onBGMNotify.onBGMComplete(i11);
        }
    }

    public void onBGMProgress(long j11, long j12) {
        TXLivePusher.OnBGMNotify onBGMNotify = this.mOnBGMNotify;
        if (onBGMNotify != null) {
            onBGMNotify.onBGMProgress(j11, j12);
        }
    }

    public void onBGMStart() {
        TXLivePusher.OnBGMNotify onBGMNotify = this.mOnBGMNotify;
        if (onBGMNotify != null) {
            onBGMNotify.onBGMStart();
        }
    }

    public int onCustomPreprocessFrame(int i11, int i12, int i13) {
        return onTextureCustomProcess(i11, i12, i13);
    }

    public void onDetectFacePoints(float[] fArr) {
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.mVideoCustomProcessListener;
        if (videoCustomProcessListener != null) {
            videoCustomProcessListener.onDetectFacePoints(fArr);
        }
    }

    public void onLogRecord(String str) {
        nativeOnLogRecord(this.mNativeTXLivePusherJni, str);
    }

    public byte[] onNativeRecordPcmData(byte[] bArr, long j11, int i11, int i12, int i13) {
        onRecordPcmData(bArr, j11, i11, i12, i13);
        return bArr;
    }

    public byte[] onNativeRecordRawPcmData(byte[] bArr, long j11, int i11, int i12, int i13, boolean z11) {
        onRecordRawPcmData(bArr, j11, i11, i12, i13, z11);
        return bArr;
    }

    public void onNetStatus(Bundle bundle) {
        ITXLivePushListener iTXLivePushListener = this.mITXLivePushListener;
        if (iTXLivePushListener != null) {
            iTXLivePushListener.onNetStatus(bundle);
        }
    }

    public void onPushEvent(int i11, Bundle bundle) {
        ITXLivePushListener iTXLivePushListener = this.mITXLivePushListener;
        if (iTXLivePushListener != null) {
            iTXLivePushListener.onPushEvent(i11, bundle);
        }
    }

    public void onRecordComplete(int i11, String str, String str2, String str3) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mITXVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
            if (i11 == 0) {
                tXRecordResult.retCode = 0;
            } else {
                tXRecordResult.retCode = -1;
            }
            tXRecordResult.descMsg = str;
            tXRecordResult.videoPath = str2;
            tXRecordResult.coverPath = str3;
            iTXVideoRecordListener.onRecordComplete(tXRecordResult);
        }
    }

    public void onRecordEvent(int i11, Bundle bundle) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mITXVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordEvent(i11, bundle);
        }
    }

    public void onRecordPcmData(byte[] bArr, long j11, int i11, int i12, int i13) {
        TXLivePusher.AudioCustomProcessListener audioCustomProcessListener = this.mAudioCustomProcessListener;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordPcmData(bArr, j11, i11, i12, i13);
        }
    }

    public void onRecordProgress(long j11) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mITXVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordProgress(j11);
        }
    }

    public void onRecordRawPcmData(byte[] bArr, long j11, int i11, int i12, int i13, boolean z11) {
        TXLivePusher.AudioCustomProcessListener audioCustomProcessListener = this.mAudioCustomProcessListener;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordRawPcmData(bArr, j11, i11, i12, i13, z11);
        }
    }

    public void onShowLog(boolean z11) {
        nativeShowDebugView(this.mNativeTXLivePusherJni, z11);
    }

    public void onSnapshot(Bitmap bitmap) {
        TXLivePusher.ITXSnapshotListener iTXSnapshotListener = this.mITXSnapshotListener;
        if (iTXSnapshotListener != null) {
            iTXSnapshotListener.onSnapshot(bitmap);
        }
    }

    public int onTextureCustomProcess(int i11, int i12, int i13) {
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.mVideoCustomProcessListener;
        if (videoCustomProcessListener != null) {
            return videoCustomProcessListener.onTextureCustomProcess(i11, i12, i13);
        }
        return -1;
    }

    public void onTextureDestoryed() {
        TXLivePusher.VideoCustomProcessListener videoCustomProcessListener = this.mVideoCustomProcessListener;
        if (videoCustomProcessListener != null) {
            videoCustomProcessListener.onTextureDestoryed();
        }
    }

    public boolean pauseBGM() {
        return nativePauseBGM(this.mNativeTXLivePusherJni);
    }

    public void pausePusher() {
        nativePausePusher(this.mNativeTXLivePusherJni);
    }

    public boolean playBGM(String str) {
        return nativePlayBGM(this.mNativeTXLivePusherJni, str);
    }

    public void release() {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.mBeautyManager;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.clear();
        }
        long j11 = this.mNativeTXLivePusherJni;
        if (j11 != 0) {
            nativeDestroy(j11);
            this.mNativeTXLivePusherJni = 0;
        }
    }

    public boolean resumeBGM() {
        return nativeResumeBGM(this.mNativeTXLivePusherJni);
    }

    public void resumePusher() {
        nativeResumePusher(this.mNativeTXLivePusherJni);
    }

    public void sendCustomPCMData(byte[] bArr) {
        nativeSendCustomPCMData(this.mNativeTXLivePusherJni, bArr);
    }

    public int sendCustomVideoData(byte[] bArr, int i11, int i12, int i13) {
        GLConstants.PixelFormatType pixelFormatType;
        if (i11 == 3) {
            pixelFormatType = GLConstants.PixelFormatType.I420;
        } else if (i11 != 5) {
            return -3;
        } else {
            pixelFormatType = GLConstants.PixelFormatType.RGBA;
        }
        nativeSendCustomVideoFrame(this.mNativeTXLivePusherJni, i12, i13, GLConstants.a.BYTE_ARRAY.mValue, pixelFormatType.getValue(), -1, (Object) null, bArr);
        return 0;
    }

    public int sendCustomVideoTexture(int i11, int i12, int i13) {
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        if (eglGetCurrentContext == null) {
            return -1;
        }
        nativeSendCustomVideoFrame(this.mNativeTXLivePusherJni, i12, i13, GLConstants.a.TEXTURE_2D.mValue, GLConstants.PixelFormatType.RGBA.getValue(), i11, eglGetCurrentContext, (byte[]) null);
        return 0;
    }

    public void sendMessage(byte[] bArr) {
        nativeSendMessage(this.mNativeTXLivePusherJni, bArr);
    }

    public boolean sendMessageEx(byte[] bArr) {
        return nativeSendMessageEx(this.mNativeTXLivePusherJni, bArr);
    }

    public void setAudioProcessListener(TXLivePusher.AudioCustomProcessListener audioCustomProcessListener) {
        this.mAudioCustomProcessListener = audioCustomProcessListener;
    }

    public void setAudioVolumeEvaluationListener(TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.mITXAudioVolumeEvaluationListener = iTXAudioVolumeEvaluationListener;
    }

    public void setBGMNofify(TXLivePusher.OnBGMNotify onBGMNotify) {
        this.mOnBGMNotify = onBGMNotify;
    }

    public void setBGMPitch(float f11) {
        nativeSetBGMPitch(this.mNativeTXLivePusherJni, f11);
    }

    public boolean setBGMPosition(int i11) {
        return nativeSetBGMPosition(this.mNativeTXLivePusherJni, i11);
    }

    public boolean setBGMVolume(float f11) {
        return nativeSetBGMVolume(this.mNativeTXLivePusherJni, f11);
    }

    public boolean setBeautyFilter(int i11, int i12, int i13, int i14) {
        return nativeSetBeautyFilter(this.mNativeTXLivePusherJni, i11, i12, i13, i14);
    }

    public void setChinLevel(int i11) {
        this.mBeautyManager.setChinLevel((float) i11);
    }

    public void setConfig(TXLivePushConfig tXLivePushConfig) {
        TXLivePushConfig tXLivePushConfig2 = tXLivePushConfig;
        if (tXLivePushConfig2 != null) {
            this.mConfig = tXLivePushConfig2;
            nativeSetCaptureConfig(this.mNativeTXLivePusherJni, tXLivePushConfig2.mCustomModeType, tXLivePushConfig2.mLocalVideoMirrorType, tXLivePushConfig2.mPauseImg, tXLivePushConfig2.mPauseFps, tXLivePushConfig2.mFrontCamera, tXLivePushConfig2.mTouchFocus, tXLivePushConfig2.mEnableZoom, tXLivePushConfig2.mEnableScreenCaptureAutoRotate, tXLivePushConfig2.mEnableHighResolutionCapture, tXLivePushConfig2.mPauseFlag);
            long j11 = this.mNativeTXLivePusherJni;
            TXLivePushConfig tXLivePushConfig3 = this.mConfig;
            int i11 = tXLivePushConfig3.mHomeOrientation;
            int ordinal = tXLivePushConfig3.mVideoResolution.ordinal();
            TXLivePushConfig tXLivePushConfig4 = this.mConfig;
            nativeSetEncoderConfig(j11, i11, ordinal, tXLivePushConfig4.mAutoAdjustBitrate, tXLivePushConfig4.mVideoBitrate, tXLivePushConfig4.mMaxVideoBitrate, tXLivePushConfig4.mMinVideoBitrate, tXLivePushConfig4.mVideoEncodeGop, tXLivePushConfig4.mVideoFPS, tXLivePushConfig4.mVideoEncoderXMirror, tXLivePushConfig4.mHardwareAccel, tXLivePushConfig4.mEnableVideoHardEncoderMainProfile);
            long j12 = this.mNativeTXLivePusherJni;
            TXLivePushConfig tXLivePushConfig5 = this.mConfig;
            nativeSetWaterMark(j12, tXLivePushConfig5.mWatermark, tXLivePushConfig5.mWatermarkXF, tXLivePushConfig5.mWatermarkYF, tXLivePushConfig5.mWatermarkWidth);
            long j13 = this.mNativeTXLivePusherJni;
            TXLivePushConfig tXLivePushConfig6 = this.mConfig;
            nativeSetAudioConfig(j13, tXLivePushConfig6.mAudioChannels, tXLivePushConfig6.mAudioSample, tXLivePushConfig6.mVolumeType, tXLivePushConfig6.mEnableAudioPreview, tXLivePushConfig6.mEnableAns);
            long j14 = this.mNativeTXLivePusherJni;
            TXLivePushConfig tXLivePushConfig7 = this.mConfig;
            nativeSetNetworkConfig(j14, tXLivePushConfig7.mAutoAdjustStrategy, tXLivePushConfig7.mEnablePureAudioPush, tXLivePushConfig7.mConnectRetryCount, tXLivePushConfig7.mConnectRetryInterval, tXLivePushConfig7.mRtmpChannelType, tXLivePushConfig7.mMetaData);
        }
    }

    public void setExposureCompensation(float f11) {
        nativeSetExposureCompensation(this.mNativeTXLivePusherJni, f11);
    }

    public void setEyeScaleLevel(int i11) {
        this.mBeautyManager.setEyeScaleLevel((float) i11);
    }

    public void setFaceShortLevel(int i11) {
        this.mBeautyManager.setFaceShortLevel((float) i11);
    }

    public void setFaceSlimLevel(int i11) {
        this.mBeautyManager.setFaceSlimLevel((float) i11);
    }

    public void setFaceVLevel(int i11) {
        this.mBeautyManager.setFaceVLevel((float) i11);
    }

    public void setFilter(Bitmap bitmap) {
        nativeSetFilter(this.mNativeTXLivePusherJni, bitmap);
    }

    public void setFocusPosition(float f11, float f12) {
        nativeSetFocusPosition(this.mNativeTXLivePusherJni, f11, f12);
    }

    public boolean setGreenScreenFile(String str) {
        return this.mBeautyManager.setGreenScreenFile(str) != 0;
    }

    public boolean setMicVolume(float f11) {
        return nativeSetMicVolume(this.mNativeTXLivePusherJni, f11);
    }

    public boolean setMirror(boolean z11) {
        return nativeSetMirror(this.mNativeTXLivePusherJni, z11);
    }

    public void setMotionMute(boolean z11) {
        this.mBeautyManager.setMotionMute(z11);
    }

    public void setMotionTmpl(String str) {
        this.mBeautyManager.setMotionTmpl(str);
    }

    public void setMute(boolean z11) {
        nativeSetMute(this.mNativeTXLivePusherJni, z11);
    }

    public void setNoseSlimLevel(int i11) {
        this.mBeautyManager.setNoseSlimLevel((float) i11);
    }

    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        this.mITXLivePushListener = iTXLivePushListener;
    }

    public void setRenderRotation(int i11) {
        nativeSetRenderRotation(this.mNativeTXLivePusherJni, i11);
    }

    public void setReverb(int i11) {
        nativeSetReverb(this.mNativeTXLivePusherJni, i11);
    }

    public void setSpecialRatio(float f11) {
        nativeSetSpecialRatio(this.mNativeTXLivePusherJni, f11);
    }

    public void setSurface(Surface surface) {
        nativeSetView(this.mNativeTXLivePusherJni, new DisplayTarget(surface));
    }

    public void setSurfaceSize(int i11, int i12) {
    }

    public void setVideoProcessListener(TXLivePusher.VideoCustomProcessListener videoCustomProcessListener) {
        this.mVideoCustomProcessListener = videoCustomProcessListener;
    }

    public void setVideoQuality(int i11, boolean z11, boolean z12) {
        int i12 = i11;
        boolean z13 = z11;
        boolean z14 = z12;
        boolean z15 = z13 && z14;
        this.mConfig.setHardwareAcceleration(1);
        this.mConfig.setAutoAdjustBitrate(z13);
        switch (i12) {
            case 1:
                this.mConfig.setVideoResolution(0);
                this.mConfig.setAutoAdjustStrategy(z14 ? 1 : 0);
                this.mConfig.setVideoEncodeGop(3);
                if (z15) {
                    this.mConfig.setMinVideoBitrate(301);
                } else {
                    this.mConfig.setMinVideoBitrate(500);
                }
                this.mConfig.setVideoBitrate(TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE);
                this.mConfig.setMaxVideoBitrate(900);
                break;
            case 2:
                this.mConfig.setVideoResolution(1);
                this.mConfig.setAutoAdjustStrategy(z14);
                this.mConfig.setVideoEncodeGop(3);
                if (z15) {
                    this.mConfig.setMinVideoBitrate(BannerConfig.SCROLL_TIME);
                } else {
                    this.mConfig.setMinVideoBitrate(TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE);
                }
                this.mConfig.setVideoBitrate(1200);
                this.mConfig.setMaxVideoBitrate(1500);
                break;
            case 3:
                this.mConfig.setVideoResolution(2);
                this.mConfig.setAutoAdjustStrategy(z14);
                this.mConfig.setVideoEncodeGop(3);
                if (z15) {
                    this.mConfig.setMinVideoBitrate(BannerConfig.SCROLL_TIME);
                } else {
                    this.mConfig.setMinVideoBitrate(1000);
                }
                this.mConfig.setVideoBitrate(1800);
                this.mConfig.setMaxVideoBitrate(1800);
                break;
            case 4:
                int i13 = this.mVideoQuality;
                if (i13 == 1) {
                    this.mConfig.setVideoResolution(0);
                    this.mConfig.setMinVideoBitrate(500);
                    this.mConfig.setVideoBitrate(TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE);
                    this.mConfig.setMaxVideoBitrate(900);
                } else if (i13 == 3) {
                    this.mConfig.setVideoResolution(2);
                    this.mConfig.setMinVideoBitrate(1000);
                    this.mConfig.setVideoBitrate(1800);
                    this.mConfig.setMaxVideoBitrate(1800);
                } else if (i13 == 7) {
                    this.mConfig.setVideoResolution(30);
                    this.mConfig.setMinVideoBitrate(2000);
                    this.mConfig.setVideoBitrate(3000);
                    this.mConfig.setMaxVideoBitrate(3000);
                } else {
                    this.mConfig.setVideoResolution(1);
                    this.mConfig.setMinVideoBitrate(TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE);
                    this.mConfig.setVideoBitrate(1200);
                    this.mConfig.setMaxVideoBitrate(1500);
                }
                this.mConfig.setAutoAdjustStrategy(4);
                this.mConfig.setVideoEncodeGop(1);
                break;
            case 5:
                this.mConfig.setVideoResolution(6);
                this.mConfig.setMinVideoBitrate(350);
                this.mConfig.setVideoBitrate(350);
                this.mConfig.setMaxVideoBitrate(350);
                this.mConfig.setAutoAdjustStrategy(4);
                this.mConfig.setVideoEncodeGop(1);
                break;
            case 6:
                this.mConfig.setVideoResolution(0);
                this.mConfig.setAutoAdjustStrategy(5);
                this.mConfig.setVideoEncodeGop(1);
                this.mConfig.setMinVideoBitrate(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
                this.mConfig.setVideoBitrate(400);
                this.mConfig.setMaxVideoBitrate(810);
                break;
            case 7:
                this.mConfig.setVideoResolution(30);
                this.mConfig.setAutoAdjustStrategy(z14);
                this.mConfig.setVideoEncodeGop(3);
                if (z15) {
                    this.mConfig.setMinVideoBitrate(BannerConfig.SCROLL_TIME);
                } else {
                    this.mConfig.setMinVideoBitrate(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS);
                }
                this.mConfig.setVideoBitrate(3000);
                this.mConfig.setMaxVideoBitrate(3000);
                break;
            default:
                return;
        }
        this.mVideoQuality = i12;
        setConfig(this.mConfig);
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mITXVideoRecordListener = iTXVideoRecordListener;
    }

    public void setVoiceChangerType(int i11) {
        nativeSetVoiceChangerType(this.mNativeTXLivePusherJni, i11);
    }

    public boolean setZoom(int i11) {
        return nativeSetZoom(this.mNativeTXLivePusherJni, i11);
    }

    public void snapshot(TXLivePusher.ITXSnapshotListener iTXSnapshotListener) {
        this.mITXSnapshotListener = iTXSnapshotListener;
        nativeSnapshot(this.mNativeTXLivePusherJni);
    }

    public void startCameraPreview(TXCloudVideoView tXCloudVideoView) {
        if (tXCloudVideoView != null) {
            a.a(tXCloudVideoView, new WeakReference(this));
            nativeShowDebugView(this.mNativeTXLivePusherJni, a.a(tXCloudVideoView));
        }
        nativeSetView(this.mNativeTXLivePusherJni, new DisplayTarget(tXCloudVideoView));
        nativeStartCamera(this.mNativeTXLivePusherJni);
    }

    public int startPusher(String str) {
        return nativeStartPusher(this.mNativeTXLivePusherJni, str);
    }

    public int startRecord(String str) {
        return nativeStartRecord(this.mNativeTXLivePusherJni, str);
    }

    public void startScreenCapture() {
        nativeStartScreenCapture(this.mNativeTXLivePusherJni);
    }

    public boolean stopBGM() {
        return nativeStopBGM(this.mNativeTXLivePusherJni);
    }

    public void stopCameraPreview(boolean z11) {
        nativeStopCameraPreview(this.mNativeTXLivePusherJni, z11);
    }

    public void stopPusher() {
        nativeStopPusher(this.mNativeTXLivePusherJni);
    }

    public void stopRecord() {
        nativeStopRecord(this.mNativeTXLivePusherJni);
    }

    public void stopScreenCapture() {
        nativeStopScreenCapture(this.mNativeTXLivePusherJni);
    }

    public void switchCamera() {
        TXLivePushConfig tXLivePushConfig = this.mConfig;
        tXLivePushConfig.setFrontCamera(!tXLivePushConfig.mFrontCamera);
        nativeSwitchCamera(this.mNativeTXLivePusherJni);
    }

    public boolean turnOnFlashLight(boolean z11) {
        return nativeTurnOnFlashLight(this.mNativeTXLivePusherJni, z11);
    }
}
