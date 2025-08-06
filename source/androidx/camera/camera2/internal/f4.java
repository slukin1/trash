package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class f4 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h4 f5113a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f5114b;

    public /* synthetic */ f4(h4 h4Var, boolean z11) {
        this.f5113a = h4Var;
        this.f5114b = z11;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5113a.h(this.f5114b, aVar);
    }
}
