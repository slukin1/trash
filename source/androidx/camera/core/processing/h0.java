package androidx.camera.core.processing;

import androidx.camera.core.SurfaceOutput;

public final /* synthetic */ class h0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceProcessorWithExecutor f5665b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceOutput f5666c;

    public /* synthetic */ h0(SurfaceProcessorWithExecutor surfaceProcessorWithExecutor, SurfaceOutput surfaceOutput) {
        this.f5665b = surfaceProcessorWithExecutor;
        this.f5666c = surfaceOutput;
    }

    public final void run() {
        this.f5665b.lambda$onOutputSurface$1(this.f5666c);
    }
}
