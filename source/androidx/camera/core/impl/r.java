package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class r implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f5579a;

    public /* synthetic */ r(DeferrableSurface deferrableSurface) {
        this.f5579a = deferrableSurface;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5579a.lambda$new$0(aVar);
    }
}
