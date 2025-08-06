package androidx.camera.core.imagecapture;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class k implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RequestWithCallback f5538a;

    public /* synthetic */ k(RequestWithCallback requestWithCallback) {
        this.f5538a = requestWithCallback;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5538a.lambda$new$1(aVar);
    }
}
