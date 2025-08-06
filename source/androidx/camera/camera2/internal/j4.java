package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class j4 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m4 f5168a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ZoomState f5169b;

    public /* synthetic */ j4(m4 m4Var, ZoomState zoomState) {
        this.f5168a = m4Var;
        this.f5169b = zoomState;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5168a.m(this.f5169b, aVar);
    }
}
