package androidx.camera.camera2.internal;

import androidx.camera.core.impl.DeferrableSurface;

public final /* synthetic */ class j3 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f5167b;

    public /* synthetic */ j3(DeferrableSurface deferrableSurface) {
        this.f5167b = deferrableSurface;
    }

    public final void run() {
        ProcessingCaptureSession.f4967q.remove(this.f5167b);
    }
}
