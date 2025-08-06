package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class h0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f5136a;

    public /* synthetic */ h0(Camera2CameraImpl camera2CameraImpl) {
        this.f5136a = camera2CameraImpl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5136a.P(aVar);
    }
}
