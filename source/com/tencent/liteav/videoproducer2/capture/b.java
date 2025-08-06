package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final NativeCameraCaptureListener f22702a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceTexture f22703b;

    private b(NativeCameraCaptureListener nativeCameraCaptureListener, SurfaceTexture surfaceTexture) {
        this.f22702a = nativeCameraCaptureListener;
        this.f22703b = surfaceTexture;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener, SurfaceTexture surfaceTexture) {
        return new b(nativeCameraCaptureListener, surfaceTexture);
    }

    public final void run() {
        this.f22702a.runInNative(c.a(this.f22702a, this.f22703b));
    }
}
