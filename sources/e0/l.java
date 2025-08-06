package e0;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.c;
import androidx.camera.view.d;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f54248b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f54249c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c.a f54250d;

    public /* synthetic */ l(d dVar, SurfaceRequest surfaceRequest, c.a aVar) {
        this.f54248b = dVar;
        this.f54249c = surfaceRequest;
        this.f54250d = aVar;
    }

    public final void run() {
        this.f54248b.o(this.f54249c, this.f54250d);
    }
}
