package com.tencent.live2.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.live.V2TXLivePusherJni;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class V2TXLivePusherImpl extends V2TXLivePusher {
    private static final String TAG = "V2TXLivePusherImpl";
    private V2TXLivePusherJni mImpl;

    static {
        r.a();
    }

    public V2TXLivePusherImpl(Context context, V2TXLiveDef.V2TXLiveMode v2TXLiveMode) {
        this(context, v2TXLiveMode.ordinal());
    }

    public int enableAudioProcessObserver(boolean z11, V2TXLiveDef.V2TXLiveAudioFrameObserverFormat v2TXLiveAudioFrameObserverFormat) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.enableAudioProcessObserver(z11, v2TXLiveAudioFrameObserverFormat);
    }

    public synchronized int enableCustomAudioCapture(boolean z11) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.enableCustomAudioCapture(z11);
    }

    public synchronized int enableCustomVideoCapture(boolean z11) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.enableCustomVideoCapture(z11);
    }

    public synchronized int enableCustomVideoProcess(boolean z11, V2TXLiveDef.V2TXLivePixelFormat v2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType v2TXLiveBufferType) {
        return this.mImpl.enableCustomVideoProcess(z11, v2TXLivePixelFormat, v2TXLiveBufferType);
    }

    public synchronized int enableVolumeEvaluation(int i11) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.enableVolumeEvaluation(i11);
    }

    public synchronized TXAudioEffectManager getAudioEffectManager() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return null;
        }
        return v2TXLivePusherJni.getAudioEffectManager();
    }

    public synchronized TXBeautyManager getBeautyManager() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return null;
        }
        return v2TXLivePusherJni.getBeautyManager();
    }

    public synchronized TXDeviceManager getDeviceManager() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return null;
        }
        return v2TXLivePusherJni.getDeviceManager();
    }

    public synchronized int isPushing() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.isPushing();
    }

    public synchronized int pauseAudio() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.pauseAudio();
    }

    public synchronized int pauseVideo() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.pauseVideo();
    }

    public synchronized void release() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni != null) {
            v2TXLivePusherJni.release();
            LiteavLog.i(TAG, "Release instance:" + this.mImpl.toString());
            this.mImpl = null;
        }
    }

    public synchronized int resumeAudio() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.resumeAudio();
    }

    public synchronized int resumeVideo() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.resumeVideo();
    }

    public synchronized int sendCustomAudioFrame(V2TXLiveDef.V2TXLiveAudioFrame v2TXLiveAudioFrame) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.sendCustomAudioFrame(v2TXLiveAudioFrame);
    }

    public synchronized int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.sendCustomVideoFrame(v2TXLiveVideoFrame);
    }

    public synchronized int sendSeiMessage(int i11, byte[] bArr) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.sendSeiMessage(i11, bArr);
    }

    public synchronized int setAudioQuality(V2TXLiveDef.V2TXLiveAudioQuality v2TXLiveAudioQuality) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setAudioQuality(v2TXLiveAudioQuality);
    }

    public synchronized int setEncoderMirror(boolean z11) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setEncoderMirror(z11);
    }

    public synchronized int setMixTranscodingConfig(V2TXLiveDef.V2TXLiveTranscodingConfig v2TXLiveTranscodingConfig) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setMixTranscodingConfig(v2TXLiveTranscodingConfig);
    }

    public synchronized void setObserver(V2TXLivePusherObserver v2TXLivePusherObserver) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni != null) {
            v2TXLivePusherJni.setObserver(v2TXLivePusherObserver);
        }
    }

    public synchronized int setProperty(String str, Object obj) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setProperty(str, obj);
    }

    public synchronized int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode v2TXLiveFillMode) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setRenderFillMode(v2TXLiveFillMode);
    }

    public synchronized int setRenderMirror(V2TXLiveDef.V2TXLiveMirrorType v2TXLiveMirrorType) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setRenderMirror(v2TXLiveMirrorType);
    }

    public synchronized int setRenderRotation(V2TXLiveDef.V2TXLiveRotation v2TXLiveRotation) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setRenderRotation(v2TXLiveRotation);
    }

    public synchronized int setRenderView(TXCloudVideoView tXCloudVideoView) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setRenderView(tXCloudVideoView);
    }

    public synchronized int setVideoQuality(V2TXLiveDef.V2TXLiveVideoEncoderParam v2TXLiveVideoEncoderParam) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setVideoQuality(v2TXLiveVideoEncoderParam);
    }

    public synchronized int setWatermark(Bitmap bitmap, float f11, float f12, float f13) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setWatermark(bitmap, f11, f12, f13);
    }

    public synchronized void showDebugView(boolean z11) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni != null) {
            v2TXLivePusherJni.showDebugView(z11);
        }
    }

    public synchronized int snapshot() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.snapshot();
    }

    public synchronized int startCamera(boolean z11) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.startCamera(z11);
    }

    public synchronized int startLocalRecording(V2TXLiveDef.V2TXLiveLocalRecordingParams v2TXLiveLocalRecordingParams) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.startLocalRecording(v2TXLiveLocalRecordingParams);
    }

    public synchronized int startMicrophone() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.startMicrophone();
    }

    public synchronized int startPush(String str) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.startPush(str);
    }

    public synchronized int startScreenCapture() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.startScreenCapture();
    }

    public synchronized int startSystemAudioLoopback() {
        if (this.mImpl == null) {
            return -3;
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() < 29) {
            LiteavLog.e(TAG, "current system don't support system audio loopback");
            return -4;
        }
        return this.mImpl.startSystemAudioLoopback();
    }

    public synchronized int startVirtualCamera(Bitmap bitmap) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.startVirtualCamera(bitmap);
    }

    public synchronized int stopCamera() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.stopCamera();
    }

    public synchronized void stopLocalRecording() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni != null) {
            v2TXLivePusherJni.stopLocalRecording();
        }
    }

    public synchronized int stopMicrophone() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.stopMicrophone();
    }

    public synchronized int stopPush() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.stopPush();
    }

    public synchronized int stopScreenCapture() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.stopScreenCapture();
    }

    public synchronized int stopSystemAudioLoopback() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.stopSystemAudioLoopback();
    }

    public synchronized int stopVirtualCamera() {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.stopVirtualCamera();
    }

    private V2TXLivePusherImpl(Context context, int i11) {
        this.mImpl = new V2TXLivePusherJni(context, i11);
        LiteavLog.i(TAG, "Create instance:" + this.mImpl.toString());
    }

    public synchronized int setRenderView(TextureView textureView) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setRenderView(textureView);
    }

    public synchronized int setRenderView(SurfaceView surfaceView) {
        V2TXLivePusherJni v2TXLivePusherJni = this.mImpl;
        if (v2TXLivePusherJni == null) {
            return -3;
        }
        return v2TXLivePusherJni.setRenderView(surfaceView);
    }
}
