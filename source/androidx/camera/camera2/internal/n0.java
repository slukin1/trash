package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class n0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f5217b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5218c;

    public /* synthetic */ n0(Camera2CameraImpl camera2CameraImpl, CallbackToFutureAdapter.a aVar) {
        this.f5217b = camera2CameraImpl;
        this.f5218c = aVar;
    }

    public final void run() {
        this.f5217b.W(this.f5218c);
    }
}
