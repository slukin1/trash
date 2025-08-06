package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.videoproducer.capture.CameraControllerInterface;
import com.tencent.liteav.videoproducer.capture.CameraEventCallback;

@JNINamespace("liteav::video")
public class NativeCameraCaptureListener implements SurfaceTexture.OnFrameAvailableListener, CameraEventCallback {
    private final CustomHandler mCallbackHandler = new CustomHandler(Looper.myLooper());
    private long mNativeHandle;

    public NativeCameraCaptureListener(long j11) {
        this.mNativeHandle = j11;
    }

    /* access modifiers changed from: private */
    public static native void nativeOnCameraError(long j11, int i11);

    /* access modifiers changed from: private */
    public static native void nativeOnFrameAvailable(long j11, SurfaceTexture surfaceTexture);

    /* access modifiers changed from: private */
    public synchronized void runInNative(Runnable runnable) {
        if (this.mNativeHandle != 0) {
            runnable.run();
        }
    }

    public Handler getCallbackHandler() {
        return this.mCallbackHandler;
    }

    public void onCameraError(CameraControllerInterface cameraControllerInterface, int i11) {
        this.mCallbackHandler.runOrPost(a.a(this, i11));
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.mCallbackHandler.runOrPost(b.a(this, surfaceTexture));
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandle = 0;
    }
}
