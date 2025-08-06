package o;

import android.hardware.camera2.CameraCaptureSession;
import o.f;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.c f58762b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58763c;

    public /* synthetic */ q(f.c cVar, CameraCaptureSession cameraCaptureSession) {
        this.f58762b = cVar;
        this.f58763c = cameraCaptureSession;
    }

    public final void run() {
        this.f58762b.l(this.f58763c);
    }
}
