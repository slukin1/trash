package androidx.camera.camera2.internal;

import androidx.camera.core.ZoomState;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class k4 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m4 f5177b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5178c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ZoomState f5179d;

    public /* synthetic */ k4(m4 m4Var, CallbackToFutureAdapter.a aVar, ZoomState zoomState) {
        this.f5177b = m4Var;
        this.f5178c = aVar;
        this.f5179d = zoomState;
    }

    public final void run() {
        this.f5177b.n(this.f5178c, this.f5179d);
    }
}
