package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Recorder f5905b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f5906c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Timebase f5907d;

    public /* synthetic */ a0(Recorder recorder, SurfaceRequest surfaceRequest, Timebase timebase) {
        this.f5905b = recorder;
        this.f5906c = surfaceRequest;
        this.f5907d = timebase;
    }

    public final void run() {
        this.f5905b.K(this.f5906c, this.f5907d);
    }
}
