package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.x0;
import androidx.camera.core.impl.CaptureConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class c1 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x0.c f5038a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CaptureConfig.Builder f5039b;

    public /* synthetic */ c1(x0.c cVar, CaptureConfig.Builder builder) {
        this.f5038a = cVar;
        this.f5039b = builder;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5038a.n(this.f5039b, aVar);
    }
}
