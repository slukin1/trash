package androidx.camera.core.processing;

import androidx.camera.core.SurfaceOutput;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultSurfaceProcessor f5676b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceOutput f5677c;

    public /* synthetic */ m(DefaultSurfaceProcessor defaultSurfaceProcessor, SurfaceOutput surfaceOutput) {
        this.f5676b = defaultSurfaceProcessor;
        this.f5677c = surfaceOutput;
    }

    public final void run() {
        this.f5676b.lambda$onOutputSurface$3(this.f5677c);
    }
}
