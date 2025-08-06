package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class l4 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m4 f5191b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5192c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ZoomState f5193d;

    public /* synthetic */ l4(m4 m4Var, CallbackToFutureAdapter.a aVar, ZoomState zoomState) {
        this.f5191b = m4Var;
        this.f5192c = aVar;
        this.f5193d = zoomState;
    }

    public final void run() {
        this.f5191b.l(this.f5192c, this.f5193d);
    }
}
