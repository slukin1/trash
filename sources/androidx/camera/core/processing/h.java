package androidx.camera.core.processing;

import androidx.camera.core.SurfaceOutput;
import androidx.core.util.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultSurfaceProcessor f5663b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceOutput f5664c;

    public /* synthetic */ h(DefaultSurfaceProcessor defaultSurfaceProcessor, SurfaceOutput surfaceOutput) {
        this.f5663b = defaultSurfaceProcessor;
        this.f5664c = surfaceOutput;
    }

    public final void accept(Object obj) {
        this.f5663b.lambda$onOutputSurface$2(this.f5664c, (SurfaceOutput.Event) obj);
    }
}
