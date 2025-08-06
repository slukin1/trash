package com.tencent.liteav.videoproducer2.capture;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final NativeScreenCaptureListener f22710a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22711b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22712c;

    private f(NativeScreenCaptureListener nativeScreenCaptureListener, boolean z11, boolean z12) {
        this.f22710a = nativeScreenCaptureListener;
        this.f22711b = z11;
        this.f22712c = z12;
    }

    public static Runnable a(NativeScreenCaptureListener nativeScreenCaptureListener, boolean z11, boolean z12) {
        return new f(nativeScreenCaptureListener, z11, z12);
    }

    public final void run() {
        this.f22710a.notifyStartFinish(this.f22711b, this.f22712c);
    }
}
