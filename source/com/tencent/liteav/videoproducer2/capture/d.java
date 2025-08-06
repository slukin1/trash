package com.tencent.liteav.videoproducer2.capture;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final NativeCameraCaptureListener f22706a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22707b;

    private d(NativeCameraCaptureListener nativeCameraCaptureListener, int i11) {
        this.f22706a = nativeCameraCaptureListener;
        this.f22707b = i11;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener, int i11) {
        return new d(nativeCameraCaptureListener, i11);
    }

    public final void run() {
        NativeCameraCaptureListener.nativeOnCameraError(this.f22706a.mNativeHandle, this.f22707b);
    }
}
