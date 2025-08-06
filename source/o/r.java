package o;

import android.hardware.camera2.CameraCaptureSession;
import o.f;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.c f58764b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58765c;

    public /* synthetic */ r(f.c cVar, CameraCaptureSession cameraCaptureSession) {
        this.f58764b = cVar;
        this.f58765c = cameraCaptureSession;
    }

    public final void run() {
        this.f58764b.k(this.f58765c);
    }
}
