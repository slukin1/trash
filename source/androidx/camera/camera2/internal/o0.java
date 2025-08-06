package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class o0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f5237b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5238c;

    public /* synthetic */ o0(Camera2CameraImpl camera2CameraImpl, CallbackToFutureAdapter.a aVar) {
        this.f5237b = camera2CameraImpl;
        this.f5238c = aVar;
    }

    public final void run() {
        this.f5237b.Q(this.f5238c);
    }
}
