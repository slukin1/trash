package androidx.camera.video;

import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.processing.SurfaceEdge;
import x.a;

public final /* synthetic */ class h1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoCapture f5964b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge f5965c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CameraInternal f5966d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f5967e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Timebase f5968f;

    public /* synthetic */ h1(VideoCapture videoCapture, SurfaceEdge surfaceEdge, CameraInternal cameraInternal, a aVar, Timebase timebase) {
        this.f5964b = videoCapture;
        this.f5965c = surfaceEdge;
        this.f5966d = cameraInternal;
        this.f5967e = aVar;
        this.f5968f = timebase;
    }

    public final void run() {
        this.f5964b.I(this.f5965c, this.f5966d, this.f5967e, this.f5968f);
    }
}
