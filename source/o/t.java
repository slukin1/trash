package o;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import o.f;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.c f58768b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58769c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Surface f58770d;

    public /* synthetic */ t(f.c cVar, CameraCaptureSession cameraCaptureSession, Surface surface) {
        this.f58768b = cVar;
        this.f58769c = cameraCaptureSession;
        this.f58770d = surface;
    }

    public final void run() {
        this.f58768b.n(this.f58769c, this.f58770d);
    }
}
