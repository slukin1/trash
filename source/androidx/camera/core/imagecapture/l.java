package androidx.camera.core.imagecapture;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class l implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RequestWithCallback f5539a;

    public /* synthetic */ l(RequestWithCallback requestWithCallback) {
        this.f5539a = requestWithCallback;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5539a.lambda$new$0(aVar);
    }
}
