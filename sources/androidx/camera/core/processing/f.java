package androidx.camera.core.processing;

import androidx.camera.core.DynamicRange;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class f implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultSurfaceProcessor f5653a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DynamicRange f5654b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ShaderProvider f5655c;

    public /* synthetic */ f(DefaultSurfaceProcessor defaultSurfaceProcessor, DynamicRange dynamicRange, ShaderProvider shaderProvider) {
        this.f5653a = defaultSurfaceProcessor;
        this.f5654b = dynamicRange;
        this.f5655c = shaderProvider;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5653a.lambda$initGlRenderer$9(this.f5654b, this.f5655c, aVar);
    }
}
