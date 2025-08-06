package androidx.camera.core.processing;

import androidx.camera.core.processing.SurfaceEdge;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge.SettableSurface f5695b;

    public /* synthetic */ u(SurfaceEdge.SettableSurface settableSurface) {
        this.f5695b = settableSurface;
    }

    public final void run() {
        this.f5695b.decrementUseCount();
    }
}
