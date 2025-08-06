package com.tencent.trtc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Handler;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.trtc.TRTCCloudImpl;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.lang.ref.WeakReference;

public abstract class TRTCCloud extends DeprecatedTRTCCloud {
    private static a mTXLogListener;
    public static WeakReference<TRTCCloud> sInstance;

    @Deprecated
    public interface BGMNotify {
        void onBGMComplete(int i11);

        void onBGMProgress(long j11, long j12);

        void onBGMStart(int i11);
    }

    public static class TRTCViewMargin {
        public float bottomMargin = 0.0f;
        public float leftMargin = 0.0f;
        public float rightMargin = 0.0f;
        public float topMargin = 0.0f;

        public TRTCViewMargin(float f11, float f12, float f13, float f14) {
            this.leftMargin = f11;
            this.topMargin = f13;
            this.rightMargin = f12;
            this.bottomMargin = f14;
        }
    }

    public static class a implements LiteavLog.a {

        /* renamed from: a  reason: collision with root package name */
        public TRTCCloudListener.TRTCLogListener f50060a;

        public a() {
            this.f50060a = null;
            this.f50060a = null;
        }

        public final void a(int i11, String str, String str2) {
            TRTCCloudListener.TRTCLogListener tRTCLogListener = this.f50060a;
            if (tRTCLogListener != null) {
                tRTCLogListener.onLog(str2, i11, str);
            }
        }
    }

    public static void destroySharedInstance() {
        TRTCCloudImpl.a();
    }

    public static String getSDKVersion() {
        return CommonUtil.getSDKVersionStr();
    }

    public static void setConsoleEnabled(boolean z11) {
        TRTCCloudImpl.a(z11);
    }

    public static void setLogCompressEnabled(boolean z11) {
        TRTCCloudImpl.b(z11);
    }

    public static void setLogDirPath(String str) {
        TRTCCloudImpl.a(str);
    }

    public static void setLogLevel(int i11) {
        TRTCCloudImpl.a(i11);
    }

    public static void setLogListener(TRTCCloudListener.TRTCLogListener tRTCLogListener) {
        a aVar = mTXLogListener;
        if (aVar != null) {
            aVar.f50060a = null;
        }
        if (tRTCLogListener != null) {
            a aVar2 = new a();
            mTXLogListener = aVar2;
            aVar2.f50060a = tRTCLogListener;
        } else {
            mTXLogListener = null;
        }
        LiteavLog.setCallback(mTXLogListener);
        LiteavLog.nativeSetLogCallbackEnabled(mTXLogListener != null);
    }

    public static TRTCCloud sharedInstance(Context context) {
        return TRTCCloudImpl.a(context);
    }

    public abstract void ConnectOtherRoom(String str);

    public abstract void DisconnectOtherRoom();

    public abstract void addListener(TRTCCloudListener tRTCCloudListener);

    public abstract String callExperimentalAPI(String str);

    public abstract TRTCCloud createSubCloud();

    public abstract void destroySubCloud(TRTCCloud tRTCCloud);

    public abstract void enable3DSpatialAudioEffect(boolean z11);

    public abstract void enableAudioVolumeEvaluation(boolean z11, TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams);

    public abstract void enableCustomAudioCapture(boolean z11);

    public abstract void enableCustomAudioRendering(boolean z11);

    public abstract void enableCustomVideoCapture(int i11, boolean z11);

    public abstract int enableEncSmallVideoStream(boolean z11, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam);

    public abstract void enableMixExternalAudioFrame(boolean z11, boolean z12);

    public abstract int enablePayloadPrivateEncryption(boolean z11, TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig);

    public abstract void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i11);

    public abstract void exitRoom();

    public abstract long generateCustomPTS();

    public abstract int getAudioCaptureVolume();

    public abstract TXAudioEffectManager getAudioEffectManager();

    public abstract int getAudioPlayoutVolume();

    public abstract TXBeautyManager getBeautyManager();

    public abstract void getCustomAudioRenderingFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

    public abstract TXDeviceManager getDeviceManager();

    public abstract int mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

    public abstract void muteAllRemoteAudio(boolean z11);

    public abstract void muteAllRemoteVideoStreams(boolean z11);

    public abstract void muteLocalAudio(boolean z11);

    public abstract void muteLocalVideo(int i11, boolean z11);

    public abstract void muteRemoteAudio(String str, boolean z11);

    public abstract void muteRemoteVideoStream(String str, int i11, boolean z11);

    public abstract void pauseScreenCapture();

    public abstract void removeListener(TRTCCloudListener tRTCCloudListener);

    public abstract void resumeScreenCapture();

    public abstract void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame);

    public abstract boolean sendCustomCmdMsg(int i11, byte[] bArr, boolean z11, boolean z12);

    public abstract void sendCustomVideoData(int i11, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame);

    public abstract boolean sendSEIMsg(byte[] bArr, int i11);

    public abstract void set3DSpatialReceivingRange(String str, int i11);

    public abstract void setAudioCaptureVolume(int i11);

    public abstract void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener);

    public abstract void setAudioPlayoutVolume(int i11);

    public abstract void setAudioRoute(int i11);

    public abstract int setCapturedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat);

    public abstract void setDebugViewMargin(String str, TRTCViewMargin tRTCViewMargin);

    public abstract void setDefaultStreamRecvMode(boolean z11, boolean z12);

    public abstract void setGravitySensorAdaptiveMode(int i11);

    public abstract void setListenerHandler(Handler handler);

    public abstract int setLocalProcessedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat);

    public abstract void setLocalRenderParams(TRTCCloudDef.TRTCRenderParams tRTCRenderParams);

    public abstract int setLocalVideoProcessListener(int i11, int i12, TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener);

    public abstract int setLocalVideoRenderListener(int i11, int i12, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener);

    public abstract void setMixExternalAudioVolume(int i11, int i12);

    public abstract void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig);

    public abstract int setMixedPlayAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat);

    public abstract void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam);

    public abstract void setPerspectiveCorrectionPoints(String str, PointF[] pointFArr, PointF[] pointFArr2);

    public abstract void setRemoteAudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams);

    public abstract void setRemoteAudioVolume(String str, int i11);

    public abstract void setRemoteRenderParams(String str, int i11, TRTCCloudDef.TRTCRenderParams tRTCRenderParams);

    public abstract int setRemoteVideoRenderListener(String str, int i11, int i12, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener);

    public abstract int setRemoteVideoStreamType(String str, int i11);

    public abstract void setSubStreamEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam);

    public abstract void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam);

    public abstract void setVideoMuteImage(Bitmap bitmap, int i11);

    public abstract void setWatermark(Bitmap bitmap, int i11, float f11, float f12, float f13);

    public abstract void showDebugView(int i11);

    public abstract void snapshotVideo(String str, int i11, int i12, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener);

    public abstract int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams);

    public abstract void startLocalAudio(int i11);

    public abstract void startLocalPreview(boolean z11, TXCloudVideoView tXCloudVideoView);

    public abstract void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams);

    public abstract void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam);

    public abstract void startPublishMediaStream(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig);

    public abstract void startPublishing(String str, int i11);

    public abstract void startRemoteView(String str, int i11, TXCloudVideoView tXCloudVideoView);

    public abstract void startScreenCapture(int i11, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams);

    public abstract int startSpeedTest(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams);

    public abstract void startSystemAudioLoopback();

    public abstract void stopAllRemoteView();

    public abstract void stopAudioRecording();

    public abstract void stopLocalAudio();

    public abstract void stopLocalPreview();

    public abstract void stopLocalRecording();

    public abstract void stopPublishCDNStream();

    public abstract void stopPublishMediaStream(String str);

    public abstract void stopPublishing();

    public abstract void stopRemoteView(String str, int i11);

    public abstract void stopScreenCapture();

    public abstract void stopSpeedTest();

    public abstract void stopSystemAudioLoopback();

    public abstract void switchRole(int i11);

    public abstract void switchRole(int i11, String str);

    public abstract void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig);

    public abstract void updateLocalView(TXCloudVideoView tXCloudVideoView);

    public abstract void updateOtherRoomForwardMode(String str);

    public abstract void updatePublishMediaStream(String str, TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig);

    public abstract void updateRemote3DSpatialPosition(String str, int[] iArr);

    public abstract void updateRemoteView(String str, int i11, TXCloudVideoView tXCloudVideoView);

    public abstract void updateSelf3DSpatialPosition(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3);
}
