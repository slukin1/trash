package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class i0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f5154a;

    public /* synthetic */ i0(Camera2CameraImpl camera2CameraImpl) {
        this.f5154a = camera2CameraImpl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5154a.X(aVar);
    }
}
