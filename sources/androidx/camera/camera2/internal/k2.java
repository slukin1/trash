package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class k2 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l2 f5173b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5174c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f5175d;

    public /* synthetic */ k2(l2 l2Var, CallbackToFutureAdapter.a aVar, int i11) {
        this.f5173b = l2Var;
        this.f5174c = aVar;
        this.f5175d = i11;
    }

    public final void run() {
        this.f5173b.h(this.f5174c, this.f5175d);
    }
}
