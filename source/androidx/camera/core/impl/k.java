package androidx.camera.core.impl;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class k implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraRepository f5568a;

    public /* synthetic */ k(CameraRepository cameraRepository) {
        this.f5568a = cameraRepository;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5568a.lambda$deinit$0(aVar);
    }
}
