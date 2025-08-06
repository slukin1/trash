package androidx.camera.core.processing;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge f5699b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5700c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f5701d;

    public /* synthetic */ y(SurfaceEdge surfaceEdge, int i11, int i12) {
        this.f5699b = surfaceEdge;
        this.f5700c = i11;
        this.f5701d = i12;
    }

    public final void run() {
        this.f5699b.lambda$updateTransformation$3(this.f5700c, this.f5701d);
    }
}
