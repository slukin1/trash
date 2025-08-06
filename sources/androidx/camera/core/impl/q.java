package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class q implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f5578a;

    public /* synthetic */ q(DeferrableSurface deferrableSurface) {
        this.f5578a = deferrableSurface;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5578a.lambda$new$1(aVar);
    }
}
