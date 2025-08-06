package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class b2 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CaptureSession f5025a;

    public /* synthetic */ b2(CaptureSession captureSession) {
        this.f5025a = captureSession;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5025a.u(aVar);
    }
}
