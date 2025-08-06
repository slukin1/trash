package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class g0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f5117a;

    public /* synthetic */ g0(Camera2CameraImpl camera2CameraImpl) {
        this.f5117a = camera2CameraImpl;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5117a.R(aVar);
    }
}
