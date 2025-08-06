package androidx.camera.core.processing;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultSurfaceProcessor f5678b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f5679c;

    public /* synthetic */ n(DefaultSurfaceProcessor defaultSurfaceProcessor, SurfaceRequest surfaceRequest) {
        this.f5678b = defaultSurfaceProcessor;
        this.f5679c = surfaceRequest;
    }

    public final void run() {
        this.f5678b.lambda$onInputSurface$1(this.f5679c);
    }
}
