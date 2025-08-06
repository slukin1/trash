package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class g implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraX f5507a;

    public /* synthetic */ g(CameraX cameraX) {
        this.f5507a = cameraX;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5507a.lambda$shutdownInternal$4(aVar);
    }
}
