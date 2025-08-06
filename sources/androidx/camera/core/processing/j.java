package androidx.camera.core.processing;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f5670b;

    public /* synthetic */ j(SurfaceRequest surfaceRequest) {
        this.f5670b = surfaceRequest;
    }

    public final void run() {
        this.f5670b.willNotProvideSurface();
    }
}
