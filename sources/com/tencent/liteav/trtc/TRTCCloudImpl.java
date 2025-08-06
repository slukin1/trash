package com.tencent.liteav.trtc;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Handler;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.base.util.f;
import com.tencent.liteav.base.util.i;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.TXBeautyManagerImpl;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.device.TXDeviceManagerImpl;
import com.tencent.liteav.videobase.common.c;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class TRTCCloudImpl extends TRTCCloud implements TXAudioEffectManager.TXMusicPlayObserver {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f21675a = false;

    /* renamed from: b  reason: collision with root package name */
    private static TRTCCloudImpl f21676b;

    /* renamed from: c  reason: collision with root package name */
    private Context f21677c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TRTCCloudListener f21678d;

    /* renamed from: e  reason: collision with root package name */
    private TrtcCloudJni f21679e;

    /* renamed from: f  reason: collision with root package name */
    private TRTCCloud.BGMNotify f21680f;

    /* renamed from: g  reason: collision with root package name */
    private TXAudioEffectManagerImpl f21681g;

    /* renamed from: h  reason: collision with root package name */
    private TXDeviceManagerImpl f21682h;

    /* renamed from: i  reason: collision with root package name */
    private TXBeautyManagerImpl f21683i;

    /* renamed from: j  reason: collision with root package name */
    private int f21684j;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<TRTCCloudImpl> f21685k = new ArrayList<>();

    private TRTCCloudImpl(Context context, boolean z11) {
        b(context);
        this.f21677c = context;
        a(context, 0, z11);
    }

    private static void b(Context context) {
        synchronized (TRTCCloudImpl.class) {
            if (!f21675a) {
                ContextUtils.initApplicationContext(context.getApplicationContext());
                ContextUtils.setDataDirectorySuffix("liteav");
                TrtcCloudJni.init(0);
                f21675a = true;
            }
            if (context instanceof Activity) {
                i.a().a((Activity) context);
            }
        }
    }

    private String c() {
        return this.f21677c.getCacheDir() + File.separator + "liteav_effect";
    }

    public static TRTCCloud createInstance(Context context) {
        return new TRTCCloudImpl(context, false);
    }

    public static void destroyInstance(TRTCCloud tRTCCloud) {
        if (tRTCCloud instanceof TRTCCloudImpl) {
            ((TRTCCloudImpl) tRTCCloud).b();
        } else {
            LiteavLog.w("TRTCCloudImpl", "destroyInstance trtcCloud=".concat(String.valueOf(tRTCCloud)));
        }
    }

    public void ConnectOtherRoom(String str) {
        this.f21679e.connectOtherRoom(str);
    }

    public void DisconnectOtherRoom() {
        this.f21679e.disconnectOtherRoom();
    }

    public void addListener(TRTCCloudListener tRTCCloudListener) {
        this.f21679e.addListener(tRTCCloudListener);
    }

    public String callExperimentalAPI(String str) {
        return this.f21679e.callExperimentalAPI(str);
    }

    public int checkAudioCapabilitySupport(int i11) {
        return (i11 != 2 || !this.f21682h.isLowLatencyEarMonitorSupported()) ? 0 : 1;
    }

    public TRTCCloud createSubCloud() {
        TRTCCloudImpl tRTCCloudImpl;
        synchronized (TRTCCloudImpl.class) {
            tRTCCloudImpl = new TRTCCloudImpl(ContextUtils.getApplicationContext(), this.f21679e.getTrtcCloudJni());
            this.f21685k.add(tRTCCloudImpl);
        }
        return tRTCCloudImpl;
    }

    public void destroySubCloud(TRTCCloud tRTCCloud) {
        synchronized (TRTCCloudImpl.class) {
            if (tRTCCloud instanceof TRTCCloudImpl) {
                LiteavLog.i("TRTCCloudImpl", "destructor destroySubCloud");
                ((TRTCCloudImpl) tRTCCloud).b();
                this.f21685k.remove(tRTCCloud);
            }
        }
    }

    public void enable3DSpatialAudioEffect(boolean z11) {
        this.f21679e.enable3DSpatialAudioEffect(z11);
    }

    public void enableAudioEarMonitoring(boolean z11) {
        this.f21681g.enableVoiceEarMonitor(z11);
    }

    public void enableAudioVolumeEvaluation(boolean z11, TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams) {
        this.f21679e.enableAudioVolumeEvaluation(z11, tRTCAudioVolumeEvaluateParams);
    }

    public void enableCustomAudioCapture(boolean z11) {
        this.f21679e.enableCustomAudioCapture(z11);
    }

    public void enableCustomAudioRendering(boolean z11) {
        this.f21679e.enableCustomAudioRendering(z11);
    }

    public void enableCustomVideoCapture(int i11, boolean z11) {
        this.f21679e.enableCustomVideoCapture(i11, z11);
    }

    public int enableEncSmallVideoStream(boolean z11, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        return this.f21679e.enableEncSmallVideoStream(z11, tRTCVideoEncParam);
    }

    public void enableMixExternalAudioFrame(boolean z11, boolean z12) {
        this.f21679e.enableMixExternalAudioFrame(z11, z12);
    }

    public int enablePayloadPrivateEncryption(boolean z11, TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig) {
        return this.f21679e.enablePayloadPrivateEncryption(z11, tRTCPayloadPrivateEncryptionConfig);
    }

    public boolean enableTorch(boolean z11) {
        return this.f21682h.enableCameraTorch(z11);
    }

    public void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i11) {
        this.f21679e.enterRoom(tRTCParams, i11);
    }

    public void exitRoom() {
        this.f21679e.exitRoom();
        try {
            File file = new File(c());
            if (file.exists() && file.isDirectory() && f.a(file, 5) > 52428800) {
                for (File delete : file.listFiles()) {
                    delete.delete();
                }
            }
        } catch (Exception e11) {
            LiteavLog.w("TRTCCloudImpl", "clearCache error " + e11.toString());
        }
    }

    public long generateCustomPTS() {
        return TimeUtil.c();
    }

    public int getAudioCaptureVolume() {
        return this.f21679e.getAudioCaptureVolume();
    }

    public TXAudioEffectManager getAudioEffectManager() {
        return this.f21681g;
    }

    public int getAudioPlayoutVolume() {
        return this.f21679e.getAudioPlayoutVolume();
    }

    public int getBGMDuration(String str) {
        return (int) this.f21681g.getMusicDurationInMS(str);
    }

    public TXBeautyManager getBeautyManager() {
        return this.f21683i;
    }

    public void getCustomAudioRenderingFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        if (tRTCAudioFrame != null) {
            this.f21679e.getCustomAudioRenderingFrame(tRTCAudioFrame);
        }
    }

    public TXDeviceManager getDeviceManager() {
        return this.f21682h;
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        return this.f21682h.isCameraAutoFocusFaceModeSupported();
    }

    public boolean isCameraFocusPositionInPreviewSupported() {
        return this.f21682h.isCameraFocusPositionInPreviewSupported();
    }

    public boolean isCameraTorchSupported() {
        return this.f21682h.isCameraTorchSupported();
    }

    public boolean isCameraZoomSupported() {
        return this.f21682h.isCameraZoomSupported();
    }

    public int mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        if (tRTCAudioFrame == null) {
            return -1;
        }
        return this.f21679e.mixExternalAudioFrame(tRTCAudioFrame);
    }

    public void muteAllRemoteAudio(boolean z11) {
        this.f21679e.muteAllRemoteAudio(z11);
    }

    public void muteAllRemoteVideoStreams(boolean z11) {
        this.f21679e.muteAllRemoteVideoStreams(z11);
    }

    public void muteLocalAudio(boolean z11) {
        this.f21679e.muteLocalAudio(z11);
    }

    public void muteLocalVideo(int i11, boolean z11) {
        this.f21679e.muteLocalVideo(i11, z11);
    }

    public void muteRemoteAudio(String str, boolean z11) {
        this.f21679e.muteRemoteAudio(str, z11);
    }

    public void muteRemoteVideoStream(String str, int i11, boolean z11) {
        this.f21679e.muteRemoteVideoStream(str, i11, z11);
    }

    public void onComplete(int i11, int i12) {
        TRTCCloud.BGMNotify bGMNotify = this.f21680f;
        if (bGMNotify != null) {
            bGMNotify.onBGMComplete(i12);
        }
    }

    public void onPlayProgress(int i11, long j11, long j12) {
        TRTCCloud.BGMNotify bGMNotify = this.f21680f;
        if (bGMNotify != null) {
            bGMNotify.onBGMProgress(j11, j12);
        }
    }

    public void onStart(int i11, int i12) {
        TRTCCloud.BGMNotify bGMNotify = this.f21680f;
        if (bGMNotify != null) {
            bGMNotify.onBGMStart(i12);
        }
    }

    public void pauseAudioEffect(int i11) {
        this.f21681g.pauseAudioEffect(i11);
    }

    public void pauseBGM() {
        this.f21681g.pausePlayMusic(Integer.MAX_VALUE);
    }

    public void pauseScreenCapture() {
        this.f21679e.pauseScreenCapture(this.f21684j);
    }

    public void playAudioEffect(TRTCCloudDef.TRTCAudioEffectParam tRTCAudioEffectParam) {
        if (tRTCAudioEffectParam != null) {
            final int i11 = tRTCAudioEffectParam.effectId;
            TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(i11, b(tRTCAudioEffectParam.path));
            audioMusicParam.publish = tRTCAudioEffectParam.publish;
            audioMusicParam.loopCount = tRTCAudioEffectParam.loopCount;
            audioMusicParam.isShortFile = true;
            this.f21681g.playAudioEffect(audioMusicParam);
            this.f21681g.setEffectObserver(i11, new TXAudioEffectManager.TXMusicPlayObserver() {
                public final void onComplete(int i11, int i12) {
                    TRTCCloudListener a11 = TRTCCloudImpl.this.f21678d;
                    if (a11 != null) {
                        a11.onAudioEffectFinished(i11, i12);
                    }
                }

                public final void onPlayProgress(int i11, long j11, long j12) {
                }

                public final void onStart(int i11, int i12) {
                    TRTCCloudListener a11 = TRTCCloudImpl.this.f21678d;
                    if (a11 != null && i12 < 0) {
                        a11.onAudioEffectFinished(i11, i12);
                    }
                }
            });
        }
    }

    public void playBGM(String str, TRTCCloud.BGMNotify bGMNotify) {
        this.f21680f = bGMNotify;
        TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(Integer.MAX_VALUE, str);
        audioMusicParam.publish = true;
        audioMusicParam.loopCount = 0;
        this.f21681g.setMusicObserver(Integer.MAX_VALUE, this);
        this.f21681g.startPlayMusic(audioMusicParam);
    }

    public void removeListener(TRTCCloudListener tRTCCloudListener) {
        this.f21679e.removeListener(tRTCCloudListener);
    }

    public void resumeAudioEffect(int i11) {
        this.f21681g.resumeAudioEffect(i11);
    }

    public void resumeBGM() {
        this.f21681g.resumePlayMusic(Integer.MAX_VALUE);
    }

    public void resumeScreenCapture() {
        this.f21679e.resumeScreenCapture(this.f21684j);
    }

    public void selectMotionTmpl(String str) {
        this.f21683i.setMotionTmpl(str);
    }

    public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        if (tRTCAudioFrame != null) {
            this.f21679e.sendCustomAudioData(tRTCAudioFrame);
        }
    }

    public boolean sendCustomCmdMsg(int i11, byte[] bArr, boolean z11, boolean z12) {
        if (bArr != null) {
            return this.f21679e.sendCustomCmdMsg(i11, bArr, z11, z12);
        }
        LiteavLog.w("TRTCCloudImpl", "custom msg data is null.");
        return false;
    }

    public void sendCustomVideoData(int i11, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        if (tRTCVideoFrame == null) {
            LiteavLog.w("TRTCCloudImpl", "sendCustomVideoData frame is null");
            return;
        }
        if (tRTCVideoFrame.bufferType == 3) {
            GLES20.glFinish();
        }
        this.f21679e.sendCustomVideoData(i11, tRTCVideoFrame);
    }

    public boolean sendSEIMsg(byte[] bArr, int i11) {
        if (bArr != null && i11 != 0) {
            return this.f21679e.sendSEIMsg(bArr, i11);
        }
        LiteavLog.w("TRTCCloudImpl", "sei msg data is null or repeatCount is zero.");
        return false;
    }

    public void set3DSpatialReceivingRange(String str, int i11) {
        this.f21679e.set3DSpatialReceivingRange(str, i11);
    }

    public void setAllAudioEffectsVolume(int i11) {
        this.f21681g.setAllAudioEffectsVolume(i11);
    }

    public void setAudioCaptureVolume(int i11) {
        this.f21679e.setAudioCaptureVolume(i11);
    }

    public void setAudioEffectVolume(int i11, int i12) {
        this.f21681g.setAudioEffectVolume(i11, i12);
    }

    public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener) {
        this.f21679e.setAudioFrameListener(tRTCAudioFrameListener);
    }

    public void setAudioPlayoutVolume(int i11) {
        this.f21679e.setAudioPlayoutVolume(i11);
    }

    public void setAudioQuality(int i11) {
        this.f21679e.setAudioQuality(i11);
    }

    public void setAudioRoute(int i11) {
        this.f21682h.setAudioRoute(TXDeviceManagerImpl.audioRouteFromInt(i11));
    }

    public void setBGMPlayoutVolume(int i11) {
        this.f21681g.setMusicPlayoutVolume(Integer.MAX_VALUE, i11);
    }

    public int setBGMPosition(int i11) {
        this.f21681g.seekMusicToPosInMS(Integer.MAX_VALUE, i11);
        return 0;
    }

    public void setBGMPublishVolume(int i11) {
        this.f21681g.setMusicPublishVolume(Integer.MAX_VALUE, i11);
    }

    public void setBGMVolume(int i11) {
        this.f21681g.setMusicPlayoutVolume(Integer.MAX_VALUE, i11);
        this.f21681g.setMusicPublishVolume(Integer.MAX_VALUE, i11);
    }

    public void setBeautyStyle(int i11, int i12, int i13, int i14) {
        this.f21683i.setBeautyStyle(i11);
        this.f21683i.setBeautyLevel((float) i12);
        this.f21683i.setWhitenessLevel((float) i13);
        this.f21683i.setRuddyLevel((float) i14);
    }

    public int setCapturedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat) {
        if (tRTCAudioFrameCallbackFormat == null) {
            return -1;
        }
        return this.f21679e.setCapturedAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat.sampleRate, tRTCAudioFrameCallbackFormat.channel, tRTCAudioFrameCallbackFormat.samplesPerCall, tRTCAudioFrameCallbackFormat.mode);
    }

    public void setChinLevel(int i11) {
        this.f21683i.setChinLevel((float) i11);
    }

    public void setDebugViewMargin(String str, TRTCCloud.TRTCViewMargin tRTCViewMargin) {
    }

    public void setDefaultStreamRecvMode(boolean z11, boolean z12) {
        this.f21679e.setDefaultStreamRecvMode(z11, z12);
    }

    public void setEyeScaleLevel(int i11) {
        this.f21683i.setEyeScaleLevel((float) i11);
    }

    public void setFaceShortLevel(int i11) {
        this.f21683i.setFaceShortLevel((float) i11);
    }

    public void setFaceSlimLevel(int i11) {
        this.f21683i.setFaceSlimLevel((float) i11);
    }

    public void setFaceVLevel(int i11) {
        this.f21683i.setFaceVLevel((float) i11);
    }

    public void setFilter(Bitmap bitmap) {
        this.f21683i.setFilter(bitmap);
    }

    public void setFilterConcentration(float f11) {
        this.f21683i.setFilterStrength(f11);
    }

    public void setFocusPosition(int i11, int i12) {
        this.f21682h.setCameraFocusPosition(i11, i12);
    }

    public void setGSensorMode(int i11) {
        this.f21679e.setGSensorMode(0, i11);
    }

    public void setGravitySensorAdaptiveMode(int i11) {
        this.f21679e.setGravitySensorAdaptiveMode(i11);
    }

    public boolean setGreenScreenFile(String str) {
        return false;
    }

    public void setListener(TRTCCloudListener tRTCCloudListener) {
        Log.d("TRTCCloudImpl", "setListener ".concat(String.valueOf(tRTCCloudListener)), new Object[0]);
        this.f21678d = tRTCCloudListener;
        this.f21679e.setListener(tRTCCloudListener);
    }

    public void setListenerHandler(Handler handler) {
        this.f21679e.setListenerHandler(handler);
    }

    public int setLocalProcessedAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat) {
        if (tRTCAudioFrameCallbackFormat == null) {
            return -1;
        }
        return this.f21679e.setLocalProcessedAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat.sampleRate, tRTCAudioFrameCallbackFormat.channel, tRTCAudioFrameCallbackFormat.samplesPerCall, tRTCAudioFrameCallbackFormat.mode);
    }

    public void setLocalRenderParams(TRTCCloudDef.TRTCRenderParams tRTCRenderParams) {
        setLocalViewFillMode(tRTCRenderParams.fillMode);
        setLocalViewRotation(tRTCRenderParams.rotation);
        setLocalViewMirror(tRTCRenderParams.mirrorType);
    }

    public int setLocalVideoProcessListener(int i11, int i12, TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener) {
        return this.f21679e.setLocalVideoProcessListener(0, i11, i12, tRTCVideoFrameListener);
    }

    public int setLocalVideoRenderListener(int i11, int i12, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        return this.f21679e.setLocalVideoRenderListener(i11, i12, tRTCVideoRenderListener);
    }

    public void setLocalViewFillMode(int i11) {
        this.f21679e.setLocalViewFillMode(i11);
    }

    public void setLocalViewMirror(int i11) {
        this.f21679e.setLocalViewMirror(i11);
    }

    public void setLocalViewRotation(int i11) {
        this.f21679e.setLocalViewRotation(b(i11));
    }

    public void setMicVolumeOnMixing(int i11) {
        this.f21681g.setVoiceCaptureVolume(i11);
    }

    public void setMixExternalAudioVolume(int i11, int i12) {
        this.f21679e.setMixExternalAudioVolume(i11, i12);
    }

    public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        this.f21679e.setMixTranscodingConfig(tRTCTranscodingConfig);
    }

    public int setMixedPlayAudioFrameCallbackFormat(TRTCCloudDef.TRTCAudioFrameCallbackFormat tRTCAudioFrameCallbackFormat) {
        if (tRTCAudioFrameCallbackFormat == null) {
            return -1;
        }
        return this.f21679e.setMixedPlayAudioFrameCallbackFormat(tRTCAudioFrameCallbackFormat.sampleRate, tRTCAudioFrameCallbackFormat.channel, tRTCAudioFrameCallbackFormat.samplesPerCall, tRTCAudioFrameCallbackFormat.mode);
    }

    public void setMotionMute(boolean z11) {
        this.f21683i.setMotionMute(z11);
    }

    public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
        this.f21679e.setNetworkQosParam(tRTCNetworkQosParam);
    }

    public void setNoseSlimLevel(int i11) {
        this.f21683i.setNoseSlimLevel((float) i11);
    }

    public void setPerspectiveCorrectionPoints(String str, PointF[] pointFArr, PointF[] pointFArr2) {
        this.f21679e.setPerspectiveCorrectionPoints(str, pointFArr, pointFArr2);
    }

    public int setPriorRemoteVideoStreamType(int i11) {
        return this.f21679e.setPriorRemoteVideoStreamType(i11);
    }

    public void setRemoteAudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
        this.f21679e.setRemoteAudioParallelParams(tRTCAudioParallelParams);
    }

    public void setRemoteAudioVolume(String str, int i11) {
        this.f21679e.setRemoteAudioVolume(str, i11);
    }

    public void setRemoteRenderParams(String str, int i11, TRTCCloudDef.TRTCRenderParams tRTCRenderParams) {
        this.f21679e.setRemoteViewFillMode(str, i11, tRTCRenderParams.fillMode);
        this.f21679e.setRemoteViewRotation(str, i11, b(tRTCRenderParams.rotation));
        this.f21679e.setRemoteViewMirror(str, i11, tRTCRenderParams.mirrorType);
    }

    public void setRemoteSubStreamViewFillMode(String str, int i11) {
        this.f21679e.setRemoteViewFillMode(str, 2, i11);
    }

    public void setRemoteSubStreamViewRotation(String str, int i11) {
        this.f21679e.setRemoteViewRotation(str, 2, b(i11));
    }

    public int setRemoteVideoRenderListener(String str, int i11, int i12, TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener) {
        return this.f21679e.setRemoteVideoRenderListener(str, i11, i12, tRTCVideoRenderListener);
    }

    public int setRemoteVideoStreamType(String str, int i11) {
        return this.f21679e.setRemoteVideoStreamType(str, i11);
    }

    public void setRemoteViewFillMode(String str, int i11) {
        this.f21679e.setRemoteViewFillMode(str, 0, i11);
    }

    public void setRemoteViewRotation(String str, int i11) {
        this.f21679e.setRemoteViewRotation(str, 0, b(i11));
    }

    public void setReverbType(int i11) {
        this.f21681g.setVoiceReverbType(TXAudioEffectManagerImpl.voiceReverbTypeFromInt(i11));
    }

    public void setSubStreamEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.f21679e.setVideoEncoderParams(2, tRTCVideoEncParam);
    }

    public void setSystemVolumeType(int i11) {
        this.f21682h.setSystemVolumeType(TXDeviceManagerImpl.systemVolumeTypefromInt(i11));
    }

    public void setVideoEncoderMirror(boolean z11) {
        this.f21679e.setVideoEncoderMirror(z11);
    }

    public void setVideoEncoderParam(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        if (tRTCVideoEncParam != null) {
            this.f21679e.setVideoEncoderParams(0, tRTCVideoEncParam);
        }
    }

    public void setVideoEncoderRotation(int i11) {
        this.f21679e.setVideoEncoderRotation(b(i11));
    }

    public void setVideoMuteImage(Bitmap bitmap, int i11) {
        this.f21679e.setVideoMuteImage(bitmap, i11);
    }

    public boolean setVoiceChangerType(int i11) {
        this.f21681g.setVoiceChangerType(TXAudioEffectManagerImpl.voiceChangerTypeFromInt(i11));
        return true;
    }

    public void setWatermark(Bitmap bitmap, int i11, float f11, float f12, float f13) {
        this.f21679e.setWatermark(bitmap, i11, f11, f12, f13);
    }

    public void setZoom(int i11) {
        this.f21682h.setCameraZoomRatio((float) i11);
    }

    public void showDebugView(int i11) {
        this.f21679e.showDashboardManager(i11);
    }

    public void snapshotVideo(String str, int i11, int i12, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        this.f21679e.snapshotVideo(str, i11, i12, tRTCSnapshotListener);
    }

    public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
        return this.f21679e.startAudioRecording(tRTCAudioRecordingParams);
    }

    public void startLocalAudio(int i11) {
        this.f21679e.startLocalAudio(i11);
    }

    public void startLocalPreview(boolean z11, TXCloudVideoView tXCloudVideoView) {
        this.f21679e.startLocalPreview(z11, tXCloudVideoView);
    }

    public void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
        this.f21679e.startLocalRecording(tRTCLocalRecordingParams);
    }

    public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        this.f21679e.startPublishCDNStream(tRTCPublishCDNParam);
    }

    public void startPublishMediaStream(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        this.f21679e.startPublishMediaStream(tRTCPublishTarget, tRTCStreamEncoderParam, tRTCStreamMixingConfig);
    }

    public void startPublishing(String str, int i11) {
        this.f21679e.startPublishing(str, i11);
    }

    public void startRemoteSubStreamView(String str, TXCloudVideoView tXCloudVideoView) {
        startRemoteView(str, 2, tXCloudVideoView);
    }

    public void startRemoteView(String str, int i11, TXCloudVideoView tXCloudVideoView) {
        this.f21679e.startRemoteView(str, i11, tXCloudVideoView);
    }

    public void startScreenCapture(int i11, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        this.f21684j = i11;
        this.f21679e.startScreenCapture(i11, tRTCVideoEncParam, tRTCScreenShareParams);
    }

    public int startSpeedTest(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
        this.f21679e.startSpeedTest(tRTCSpeedTestParams);
        return 0;
    }

    public void startSystemAudioLoopback() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 29) {
            LiteavLog.e("TRTCCloudImpl", "current system don't support system audio loopback");
        } else {
            this.f21679e.startSystemAudioLoopback();
        }
    }

    public void stopAllAudioEffects() {
        this.f21681g.stopAllAudioEffects();
    }

    public void stopAllRemoteView() {
        this.f21679e.stopAllRemoteView();
    }

    public void stopAudioEffect(int i11) {
        this.f21681g.stopAudioEffect(i11);
    }

    public void stopAudioRecording() {
        this.f21679e.stopAudioRecording();
    }

    public void stopBGM() {
        this.f21681g.stopPlayMusic(Integer.MAX_VALUE);
        this.f21681g.setMusicObserver(Integer.MAX_VALUE, (TXAudioEffectManager.TXMusicPlayObserver) null);
    }

    public void stopLocalAudio() {
        this.f21679e.stopLocalAudio();
    }

    public void stopLocalPreview() {
        this.f21679e.stopLocalPreview();
    }

    public void stopLocalRecording() {
        this.f21679e.stopLocalRecording();
    }

    public void stopPublishCDNStream() {
        this.f21679e.stopPublishCDNStream();
    }

    public void stopPublishMediaStream(String str) {
        this.f21679e.stopPublishMediaStream(str);
    }

    public void stopPublishing() {
        this.f21679e.stopPublishing();
    }

    public void stopRemoteSubStreamView(String str) {
        stopRemoteView(str, 2);
    }

    public void stopRemoteView(String str, int i11) {
        this.f21679e.stopRemoteView(str, i11);
    }

    public void stopScreenCapture() {
        this.f21679e.stopScreenCapture(this.f21684j);
    }

    public void stopSpeedTest() {
        this.f21679e.stopSpeedTest();
    }

    public void stopSystemAudioLoopback() {
        this.f21679e.stopSystemAudioLoopback();
    }

    public void switchCamera() {
        this.f21682h.switchCamera(!this.f21682h.isFrontCamera());
    }

    public void switchRole(int i11) {
        this.f21679e.switchRole(i11);
    }

    public void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
        this.f21679e.switchRoom(tRTCSwitchRoomConfig);
    }

    public void updateLocalView(TXCloudVideoView tXCloudVideoView) {
        this.f21679e.updateLocalView(tXCloudVideoView);
    }

    public void updateOtherRoomForwardMode(String str) {
        this.f21679e.updateOtherRoomForwardMode(str);
    }

    public void updatePublishMediaStream(String str, TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        this.f21679e.updatePublishMediaStream(str, tRTCPublishTarget, tRTCStreamEncoderParam, tRTCStreamMixingConfig);
    }

    public void updateRemote3DSpatialPosition(String str, int[] iArr) {
        this.f21679e.updateRemote3DSpatialPosition(str, iArr);
    }

    public void updateRemoteView(String str, int i11, TXCloudVideoView tXCloudVideoView) {
        this.f21679e.updateRemoteView(str, i11, tXCloudVideoView);
    }

    public void updateSelf3DSpatialPosition(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3) {
        this.f21679e.updateSelf3DSpatialPosition(iArr, fArr, fArr2, fArr3);
    }

    public static TRTCCloud a(Context context) {
        TRTCCloudImpl tRTCCloudImpl;
        synchronized (TRTCCloudImpl.class) {
            if (f21676b == null) {
                f21676b = new TRTCCloudImpl(context, true);
            }
            tRTCCloudImpl = f21676b;
        }
        return tRTCCloudImpl;
    }

    public void enableAudioVolumeEvaluation(int i11, boolean z11) {
        TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams = new TRTCCloudDef.TRTCAudioVolumeEvaluateParams();
        tRTCAudioVolumeEvaluateParams.interval = i11;
        tRTCAudioVolumeEvaluateParams.enableVadDetection = z11;
        tRTCAudioVolumeEvaluateParams.enablePitchCalculation = false;
        tRTCAudioVolumeEvaluateParams.enableSpectrumCalculation = false;
        enableAudioVolumeEvaluation(true, tRTCAudioVolumeEvaluateParams);
    }

    public void enableCustomVideoCapture(boolean z11) {
        enableCustomVideoCapture(0, z11);
    }

    public void muteLocalVideo(boolean z11) {
        this.f21679e.muteLocalVideo(0, z11);
    }

    public void muteRemoteVideoStream(String str, boolean z11) {
        muteRemoteVideoStream(str, 0, z11);
    }

    public void snapshotVideo(String str, int i11, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        this.f21679e.snapshotVideo(str, i11, c.VIEW.mValue, tRTCSnapshotListener);
    }

    public void startLocalAudio() {
        this.f21679e.startLocalAudio();
    }

    public void startRemoteView(String str, TXCloudVideoView tXCloudVideoView) {
        this.f21679e.startRemoteView(str, tXCloudVideoView);
    }

    public void startSpeedTest(int i11, String str, String str2) {
        this.f21679e.startSpeedTest(i11, str, str2);
    }

    public void stopRemoteView(String str) {
        this.f21679e.stopRemoteView(str);
    }

    public void switchRole(int i11, String str) {
        this.f21679e.switchRole(i11, str);
    }

    public void startScreenCapture(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        this.f21684j = 0;
        startScreenCapture(0, tRTCVideoEncParam, tRTCScreenShareParams);
    }

    public void sendCustomVideoData(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        sendCustomVideoData(0, tRTCVideoFrame);
    }

    private TRTCCloudImpl(Context context, long j11) {
        b(context);
        this.f21677c = context;
        a(context, j11, false);
    }

    public static void a() {
        synchronized (TRTCCloudImpl.class) {
            if (f21676b != null) {
                LiteavLog.i("TRTCCloudImpl", "destructor destroySharedInstance");
                Iterator<TRTCCloudImpl> it2 = f21676b.f21685k.iterator();
                while (it2.hasNext()) {
                    it2.next().b();
                }
                f21676b.b();
                f21676b = null;
            }
        }
    }

    public void enableAudioVolumeEvaluation(int i11) {
        enableAudioVolumeEvaluation(i11, false);
    }

    private void b() {
        TXBeautyManagerImpl tXBeautyManagerImpl = this.f21683i;
        if (tXBeautyManagerImpl != null) {
            tXBeautyManagerImpl.clear();
        }
        this.f21679e.destroy();
    }

    public static void b(boolean z11) {
        TrtcCloudJni.setLogCompressEnabled(z11);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x00f8 */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e8 A[SYNTHETIC, Splitter:B:54:0x00e8] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f2 A[SYNTHETIC, Splitter:B:60:0x00f2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "TRTCCloudImpl"
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 == 0) goto L_0x0009
            return r10
        L_0x0009:
            java.lang.String r1 = "/assets/"
            boolean r1 = r10.startsWith(r1)
            if (r1 != 0) goto L_0x0012
            return r10
        L_0x0012:
            r1 = 8
            java.lang.String r1 = r10.substring(r1)
            android.content.Context r2 = r9.f21677c     // Catch:{ Exception -> 0x0027 }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ Exception -> 0x0027 }
            android.content.res.AssetFileDescriptor r2 = r2.openFd(r1)     // Catch:{ Exception -> 0x0027 }
            long r2 = r2.getLength()     // Catch:{ Exception -> 0x0027 }
            goto L_0x003f
        L_0x0027:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r4 = "playAudioEffect openFd error "
            r3.<init>(r4)     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00f9 }
            r3.append(r2)     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x00f9 }
            com.tencent.liteav.base.util.LiteavLog.e(r0, r2)     // Catch:{ Exception -> 0x00f9 }
            r2 = 0
        L_0x003f:
            java.lang.String r4 = r9.c()     // Catch:{ Exception -> 0x00f9 }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00f9 }
            r5.<init>(r4)     // Catch:{ Exception -> 0x00f9 }
            boolean r6 = r5.exists()     // Catch:{ Exception -> 0x00f9 }
            if (r6 != 0) goto L_0x0052
            r5.mkdirs()     // Catch:{ Exception -> 0x00f9 }
            goto L_0x005e
        L_0x0052:
            boolean r6 = r5.isFile()     // Catch:{ Exception -> 0x00f9 }
            if (r6 == 0) goto L_0x005e
            r5.delete()     // Catch:{ Exception -> 0x00f9 }
            r5.mkdirs()     // Catch:{ Exception -> 0x00f9 }
        L_0x005e:
            char r5 = java.io.File.separatorChar     // Catch:{ Exception -> 0x00f9 }
            int r5 = r1.lastIndexOf(r5)     // Catch:{ Exception -> 0x00f9 }
            r6 = -1
            java.lang.String r7 = "_"
            if (r5 == r6) goto L_0x008a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f9 }
            r6.<init>()     // Catch:{ Exception -> 0x00f9 }
            r6.append(r4)     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r4 = java.io.File.separator     // Catch:{ Exception -> 0x00f9 }
            r6.append(r4)     // Catch:{ Exception -> 0x00f9 }
            r6.append(r2)     // Catch:{ Exception -> 0x00f9 }
            r6.append(r7)     // Catch:{ Exception -> 0x00f9 }
            int r5 = r5 + 1
            java.lang.String r2 = r1.substring(r5)     // Catch:{ Exception -> 0x00f9 }
            r6.append(r2)     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r10 = r6.toString()     // Catch:{ Exception -> 0x00f9 }
            goto L_0x00a4
        L_0x008a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f9 }
            r5.<init>()     // Catch:{ Exception -> 0x00f9 }
            r5.append(r4)     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r4 = java.io.File.separator     // Catch:{ Exception -> 0x00f9 }
            r5.append(r4)     // Catch:{ Exception -> 0x00f9 }
            r5.append(r2)     // Catch:{ Exception -> 0x00f9 }
            r5.append(r7)     // Catch:{ Exception -> 0x00f9 }
            r5.append(r1)     // Catch:{ Exception -> 0x00f9 }
            java.lang.String r10 = r5.toString()     // Catch:{ Exception -> 0x00f9 }
        L_0x00a4:
            boolean r2 = com.tencent.liteav.base.util.f.a((java.lang.String) r10)     // Catch:{ Exception -> 0x00f9 }
            if (r2 != 0) goto L_0x010f
            android.content.Context r2 = r9.f21677c     // Catch:{ Exception -> 0x00f9 }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ Exception -> 0x00f9 }
            r3 = 0
            java.io.InputStream r1 = r2.open(r1)     // Catch:{ IOException -> 0x00d8, all -> 0x00d3 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00ce, all -> 0x00c9 }
            r2.<init>(r10)     // Catch:{ IOException -> 0x00ce, all -> 0x00c9 }
            com.tencent.liteav.base.util.f.a((java.io.InputStream) r1, (java.io.OutputStream) r2)     // Catch:{ IOException -> 0x00c7 }
            com.tencent.liteav.base.util.f.a((java.io.Closeable) r1)     // Catch:{ Exception -> 0x00f9 }
            r2.flush()     // Catch:{ IOException -> 0x010f }
        L_0x00c3:
            r2.close()     // Catch:{ IOException -> 0x010f }
            goto L_0x010f
        L_0x00c7:
            r3 = move-exception
            goto L_0x00dc
        L_0x00c9:
            r2 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
            goto L_0x00ed
        L_0x00ce:
            r2 = move-exception
            r8 = r3
            r3 = r2
            r2 = r8
            goto L_0x00dc
        L_0x00d3:
            r1 = move-exception
            r2 = r3
            r3 = r1
            r1 = r2
            goto L_0x00ed
        L_0x00d8:
            r1 = move-exception
            r2 = r3
            r3 = r1
            r1 = r2
        L_0x00dc:
            java.lang.String r4 = "FileUtil"
            java.lang.String r5 = "copy asset file failed."
            com.tencent.liteav.base.util.LiteavLog.e((java.lang.String) r4, (java.lang.String) r5, (java.lang.Throwable) r3)     // Catch:{ all -> 0x00ec }
            com.tencent.liteav.base.util.f.a((java.io.Closeable) r1)     // Catch:{ Exception -> 0x00f9 }
            if (r2 == 0) goto L_0x010f
            r2.flush()     // Catch:{ IOException -> 0x010f }
            goto L_0x00c3
        L_0x00ec:
            r3 = move-exception
        L_0x00ed:
            com.tencent.liteav.base.util.f.a((java.io.Closeable) r1)     // Catch:{ Exception -> 0x00f9 }
            if (r2 == 0) goto L_0x00f8
            r2.flush()     // Catch:{ IOException -> 0x00f8 }
            r2.close()     // Catch:{ IOException -> 0x00f8 }
        L_0x00f8:
            throw r3     // Catch:{ Exception -> 0x00f9 }
        L_0x00f9:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "playAudioEffect error "
            r2.<init>(r3)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.tencent.liteav.base.util.LiteavLog.e(r0, r1)
        L_0x010f:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.trtc.TRTCCloudImpl.b(java.lang.String):java.lang.String");
    }

    private void a(Context context, long j11, boolean z11) {
        this.f21677c = context.getApplicationContext();
        if (j11 == 0) {
            this.f21679e = new TrtcCloudJni(z11);
        } else {
            this.f21679e = new TrtcCloudJni(j11, z11);
        }
        this.f21682h = new TXDeviceManagerImpl(this.f21679e.createDeviceManager());
        this.f21681g = new TXAudioEffectManagerImpl(this.f21679e.createAudioEffectManager());
        this.f21683i = new TXBeautyManagerImpl(this.f21679e.createBeautyManager());
    }

    public static void a(int i11) {
        TrtcCloudJni.setLogLevel(i11);
    }

    public static void a(boolean z11) {
        TrtcCloudJni.setConsoleEnabled(z11);
    }

    public static void a(String str) {
        TrtcCloudJni.setLogDirPath(str);
    }

    private static int b(int i11) {
        if (i11 < 0) {
            return 0;
        }
        return i11 > 3 ? (i11 / 90) % 4 : i11;
    }
}
