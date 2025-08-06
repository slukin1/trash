package androidx.camera.core.processing;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5650b;

    public /* synthetic */ d(CallbackToFutureAdapter.a aVar) {
        this.f5650b = aVar;
    }

    public final void run() {
        this.f5650b.f(new Exception("Failed to snapshot: OpenGLRenderer not ready."));
    }
}
