package com.tencent.liteav.videoproducer2.capture;

final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final NativeScreenCaptureListener f22713a;

    private g(NativeScreenCaptureListener nativeScreenCaptureListener) {
        this.f22713a = nativeScreenCaptureListener;
    }

    public static Runnable a(NativeScreenCaptureListener nativeScreenCaptureListener) {
        return new g(nativeScreenCaptureListener);
    }

    public final void run() {
        this.f22713a.notifyCaptureError();
    }
}
