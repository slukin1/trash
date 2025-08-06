package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f5235b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5236c;

    public /* synthetic */ o(u uVar, CallbackToFutureAdapter.a aVar) {
        this.f5235b = uVar;
        this.f5236c = aVar;
    }

    public final void run() {
        this.f5235b.N(this.f5236c);
    }
}
