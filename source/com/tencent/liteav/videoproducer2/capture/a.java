package com.tencent.liteav.videoproducer2.capture;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final NativeCameraCaptureListener f22700a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22701b;

    private a(NativeCameraCaptureListener nativeCameraCaptureListener, int i11) {
        this.f22700a = nativeCameraCaptureListener;
        this.f22701b = i11;
    }

    public static Runnable a(NativeCameraCaptureListener nativeCameraCaptureListener, int i11) {
        return new a(nativeCameraCaptureListener, i11);
    }

    public final void run() {
        this.f22700a.runInNative(d.a(this.f22700a, this.f22701b));
    }
}
