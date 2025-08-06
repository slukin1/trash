package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Recorder f5909b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f5910c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Timebase f5911d;

    public /* synthetic */ b0(Recorder recorder, SurfaceRequest surfaceRequest, Timebase timebase) {
        this.f5909b = recorder;
        this.f5910c = surfaceRequest;
        this.f5911d = timebase;
    }

    public final void run() {
        this.f5909b.M(this.f5910c, this.f5911d);
    }
}
