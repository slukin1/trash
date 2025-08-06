package e0;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.e;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f54260b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f54261c;

    public /* synthetic */ r(e eVar, SurfaceRequest surfaceRequest) {
        this.f54260b = eVar;
        this.f54261c = surfaceRequest;
    }

    public final void run() {
        this.f54260b.p(this.f54261c);
    }
}
