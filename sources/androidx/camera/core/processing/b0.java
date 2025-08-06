package androidx.camera.core.processing;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class b0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SurfaceOutputImpl f5644a;

    public /* synthetic */ b0(SurfaceOutputImpl surfaceOutputImpl) {
        this.f5644a = surfaceOutputImpl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5644a.lambda$new$0(aVar);
    }
}
