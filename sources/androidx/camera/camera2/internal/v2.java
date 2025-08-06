package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class v2 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x2 f5371b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5372c;

    public /* synthetic */ v2(x2 x2Var, CallbackToFutureAdapter.a aVar) {
        this.f5371b = x2Var;
        this.f5372c = aVar;
    }

    public final void run() {
        this.f5371b.E(this.f5372c);
    }
}
