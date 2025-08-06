package androidx.camera.core;

import androidx.camera.core.Preview;

public final /* synthetic */ class l0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Preview.SurfaceProvider f5616b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f5617c;

    public /* synthetic */ l0(Preview.SurfaceProvider surfaceProvider, SurfaceRequest surfaceRequest) {
        this.f5616b = surfaceProvider;
        this.f5617c = surfaceRequest;
    }

    public final void run() {
        this.f5616b.onSurfaceRequested(this.f5617c);
    }
}
