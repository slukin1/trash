package androidx.camera.core.processing;

import androidx.camera.core.impl.DeferrableSurface;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f5641b;

    public /* synthetic */ a0(DeferrableSurface deferrableSurface) {
        this.f5641b = deferrableSurface;
    }

    public final void run() {
        this.f5641b.decrementUseCount();
    }
}
