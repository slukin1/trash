package com.tencent.liteav.videoproducer2.capture;

import android.graphics.SurfaceTexture;

final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final NativeScreenCaptureListener f22708a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceTexture f22709b;

    private e(NativeScreenCaptureListener nativeScreenCaptureListener, SurfaceTexture surfaceTexture) {
        this.f22708a = nativeScreenCaptureListener;
        this.f22709b = surfaceTexture;
    }

    public static Runnable a(NativeScreenCaptureListener nativeScreenCaptureListener, SurfaceTexture surfaceTexture) {
        return new e(nativeScreenCaptureListener, surfaceTexture);
    }

    public final void run() {
        this.f22708a.notifyFrameAvailable(this.f22709b);
    }
}
