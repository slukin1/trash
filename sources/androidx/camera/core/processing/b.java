package androidx.camera.core.processing;

import androidx.camera.core.processing.DefaultSurfaceProcessor;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultSurfaceProcessor f5642b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DefaultSurfaceProcessor.PendingSnapshot f5643c;

    public /* synthetic */ b(DefaultSurfaceProcessor defaultSurfaceProcessor, DefaultSurfaceProcessor.PendingSnapshot pendingSnapshot) {
        this.f5642b = defaultSurfaceProcessor;
        this.f5643c = pendingSnapshot;
    }

    public final void run() {
        this.f5642b.lambda$snapshot$5(this.f5643c);
    }
}
