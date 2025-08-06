package androidx.camera.core.processing;

import java.util.Map;

public final /* synthetic */ class g0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceProcessorNode f5660b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge f5661c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Map.Entry f5662d;

    public /* synthetic */ g0(SurfaceProcessorNode surfaceProcessorNode, SurfaceEdge surfaceEdge, Map.Entry entry) {
        this.f5660b = surfaceProcessorNode;
        this.f5661c = surfaceEdge;
        this.f5662d = entry;
    }

    public final void run() {
        this.f5660b.lambda$sendSurfaceOutputs$0(this.f5661c, this.f5662d);
    }
}
