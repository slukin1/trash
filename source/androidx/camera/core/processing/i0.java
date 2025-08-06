package androidx.camera.core.processing;

import androidx.camera.core.SurfaceRequest;

public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceProcessorWithExecutor f5668b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f5669c;

    public /* synthetic */ i0(SurfaceProcessorWithExecutor surfaceProcessorWithExecutor, SurfaceRequest surfaceRequest) {
        this.f5668b = surfaceProcessorWithExecutor;
        this.f5669c = surfaceRequest;
    }

    public final void run() {
        this.f5668b.lambda$onInputSurface$0(this.f5669c);
    }
}
