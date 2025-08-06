package androidx.camera.core.processing;

import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceOutputImpl f5648b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5649c;

    public /* synthetic */ c0(SurfaceOutputImpl surfaceOutputImpl, AtomicReference atomicReference) {
        this.f5648b = surfaceOutputImpl;
        this.f5649c = atomicReference;
    }

    public final void run() {
        this.f5648b.lambda$requestClose$1(this.f5649c);
    }
}
