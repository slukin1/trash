package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final NativeCameraCaptureListener f22704a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceTexture f22705b;

    private c(NativeCameraCaptureListener nativeCameraCaptureListener, SurfaceTexture surfaceTexture) {
        this.f22704a = nativeCameraCaptureListener;
        this.f22705b = surfaceTexture;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener, SurfaceTexture surfaceTexture) {
        return new c(nativeCameraCaptureListener, surfaceTexture);
    }

    public final void run() {
        NativeCameraCaptureListener.nativeOnFrameAvailable(this.f22704a.mNativeHandle, this.f22705b);
    }
}
