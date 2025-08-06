package androidx.camera.core;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.processing.SurfaceEdge;

public final /* synthetic */ class n0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Preview f5625b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge f5626c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CameraInternal f5627d;

    public /* synthetic */ n0(Preview preview, SurfaceEdge surfaceEdge, CameraInternal cameraInternal) {
        this.f5625b = preview;
        this.f5626c = surfaceEdge;
        this.f5627d = cameraInternal;
    }

    public final void run() {
        this.f5625b.lambda$createPipeline$0(this.f5626c, this.f5627d);
    }
}
