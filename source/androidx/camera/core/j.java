package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraX f5603b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5604c;

    public /* synthetic */ j(CameraX cameraX, CallbackToFutureAdapter.a aVar) {
        this.f5603b = cameraX;
        this.f5604c = aVar;
    }

    public final void run() {
        this.f5603b.lambda$shutdownInternal$3(this.f5604c);
    }
}
