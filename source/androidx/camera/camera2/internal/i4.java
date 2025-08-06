package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class i4 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m4 f5159a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ZoomState f5160b;

    public /* synthetic */ i4(m4 m4Var, ZoomState zoomState) {
        this.f5159a = m4Var;
        this.f5160b = zoomState;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5159a.o(this.f5160b, aVar);
    }
}
