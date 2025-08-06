package o;

import android.hardware.camera2.CameraCaptureSession;
import o.f;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.c f58758b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58759c;

    public /* synthetic */ o(f.c cVar, CameraCaptureSession cameraCaptureSession) {
        this.f58758b = cVar;
        this.f58759c = cameraCaptureSession;
    }

    public final void run() {
        this.f58758b.j(this.f58759c);
    }
}
