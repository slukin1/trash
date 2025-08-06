package androidx.camera.core.processing;

public final /* synthetic */ class w implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge f5697b;

    public /* synthetic */ w(SurfaceEdge surfaceEdge) {
        this.f5697b = surfaceEdge;
    }

    public final void run() {
        this.f5697b.disconnectWithoutCheckingClosed();
    }
}
