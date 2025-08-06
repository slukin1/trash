package androidx.camera.video;

import androidx.camera.core.impl.DeferrableSurface;

public final /* synthetic */ class g1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoCapture f5960b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DeferrableSurface f5961c;

    public /* synthetic */ g1(VideoCapture videoCapture, DeferrableSurface deferrableSurface) {
        this.f5960b = videoCapture;
        this.f5961c = deferrableSurface;
    }

    public final void run() {
        this.f5960b.J(this.f5961c);
    }
}
