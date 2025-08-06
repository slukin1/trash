package androidx.camera.core.processing;

import androidx.camera.core.SurfaceOutput;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceOutput f5667b;

    public /* synthetic */ i(SurfaceOutput surfaceOutput) {
        this.f5667b = surfaceOutput;
    }

    public final void run() {
        this.f5667b.close();
    }
}
