package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.videoproducer.capture.VirtualDisplayManager;

@JNINamespace("liteav::video")
public class NativeScreenCaptureListener implements SurfaceTexture.OnFrameAvailableListener, VirtualDisplayManager.VirtualDisplayListener {
    private final CustomHandler mCallbackHandler = new CustomHandler(Looper.myLooper());
    private long mNativeHandle;

    public NativeScreenCaptureListener(long j11) {
        this.mNativeHandle = j11;
    }

    private static native void nativeOnCaptureError(long j11);

    private static native void nativeOnFrameAvailable(long j11, SurfaceTexture surfaceTexture);

    private static native void nativeOnStartFinish(long j11, boolean z11, boolean z12);

    /* access modifiers changed from: private */
    public synchronized void notifyCaptureError() {
        long j11 = this.mNativeHandle;
        if (j11 != 0) {
            nativeOnCaptureError(j11);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void notifyFrameAvailable(SurfaceTexture surfaceTexture) {
        long j11 = this.mNativeHandle;
        if (j11 != 0) {
            nativeOnFrameAvailable(j11, surfaceTexture);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void notifyStartFinish(boolean z11, boolean z12) {
        long j11 = this.mNativeHandle;
        if (j11 != 0) {
            nativeOnStartFinish(j11, z11, z12);
        }
    }

    public Handler getCallbackHandler() {
        return this.mCallbackHandler;
    }

    public void onCaptureError() {
        this.mCallbackHandler.runOrPost(g.a(this));
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.mCallbackHandler.runOrPost(e.a(this, surfaceTexture));
    }

    public void onStartFinish(boolean z11, boolean z12) {
        this.mCallbackHandler.runOrPost(f.a(this, z11, z12));
    }

    public synchronized void resetNativeHandle() {
        this.mNativeHandle = 0;
    }
}
