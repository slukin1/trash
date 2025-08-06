package androidx.camera.core.processing;

import androidx.camera.core.DynamicRange;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultSurfaceProcessor f5672b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DynamicRange f5673c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ShaderProvider f5674d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5675e;

    public /* synthetic */ l(DefaultSurfaceProcessor defaultSurfaceProcessor, DynamicRange dynamicRange, ShaderProvider shaderProvider, CallbackToFutureAdapter.a aVar) {
        this.f5672b = defaultSurfaceProcessor;
        this.f5673c = dynamicRange;
        this.f5674d = shaderProvider;
        this.f5675e = aVar;
    }

    public final void run() {
        this.f5672b.lambda$initGlRenderer$8(this.f5673c, this.f5674d, this.f5675e);
    }
}
