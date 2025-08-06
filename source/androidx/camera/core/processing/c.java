package androidx.camera.core.processing;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultSurfaceProcessor f5645b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f5646c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f5647d;

    public /* synthetic */ c(DefaultSurfaceProcessor defaultSurfaceProcessor, Runnable runnable, Runnable runnable2) {
        this.f5645b = defaultSurfaceProcessor;
        this.f5646c = runnable;
        this.f5647d = runnable2;
    }

    public final void run() {
        this.f5645b.lambda$executeSafely$11(this.f5646c, this.f5647d);
    }
}
