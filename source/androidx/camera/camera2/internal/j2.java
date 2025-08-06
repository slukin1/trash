package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class j2 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l2 f5165a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5166b;

    public /* synthetic */ j2(l2 l2Var, int i11) {
        this.f5165a = l2Var;
        this.f5166b = i11;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5165a.i(this.f5166b, aVar);
    }
}
