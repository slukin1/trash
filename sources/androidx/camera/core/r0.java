package androidx.camera.core;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class r0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f5710a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5711b;

    public /* synthetic */ r0(SurfaceRequest surfaceRequest, AtomicReference atomicReference) {
        this.f5710a = surfaceRequest;
        this.f5711b = atomicReference;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5710a.lambda$initialSurfaceRecreationCompleter$6(this.f5711b, aVar);
    }
}
