package androidx.camera.core.processing;

import androidx.camera.core.processing.SurfaceEdge;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class z implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge.SettableSurface f5702a;

    public /* synthetic */ z(SurfaceEdge.SettableSurface settableSurface) {
        this.f5702a = settableSurface;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5702a.lambda$new$0(aVar);
    }
}
