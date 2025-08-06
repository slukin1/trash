package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraX f5607b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f5608c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f5609d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5610e;

    public /* synthetic */ k(CameraX cameraX, Executor executor, long j11, CallbackToFutureAdapter.a aVar) {
        this.f5607b = cameraX;
        this.f5608c = executor;
        this.f5609d = j11;
        this.f5610e = aVar;
    }

    public final void run() {
        this.f5607b.lambda$initAndRetryRecursively$1(this.f5608c, this.f5609d, this.f5610e);
    }
}
