package androidx.camera.camera2.internal;

import androidx.camera.core.impl.DeferrableSurface;

public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f5195b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CaptureSession f5196c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f5197d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Runnable f5198e;

    public /* synthetic */ m0(Camera2CameraImpl camera2CameraImpl, CaptureSession captureSession, DeferrableSurface deferrableSurface, Runnable runnable) {
        this.f5195b = camera2CameraImpl;
        this.f5196c = captureSession;
        this.f5197d = deferrableSurface;
        this.f5198e = runnable;
    }

    public final void run() {
        this.f5195b.N(this.f5196c, this.f5197d, this.f5198e);
    }
}
