package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class g4 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h4 f5132b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5133c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f5134d;

    public /* synthetic */ g4(h4 h4Var, CallbackToFutureAdapter.a aVar, boolean z11) {
        this.f5132b = h4Var;
        this.f5133c = aVar;
        this.f5134d = z11;
    }

    public final void run() {
        this.f5132b.g(this.f5133c, this.f5134d);
    }
}
