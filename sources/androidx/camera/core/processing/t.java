package androidx.camera.core.processing;

import androidx.camera.core.impl.DeferrableSurface;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f5694b;

    public /* synthetic */ t(DeferrableSurface deferrableSurface) {
        this.f5694b = deferrableSurface;
    }

    public final void run() {
        this.f5694b.close();
    }
}
