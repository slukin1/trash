package o;

import android.hardware.camera2.CameraCaptureSession;
import o.f;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.c f58756b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58757c;

    public /* synthetic */ n(f.c cVar, CameraCaptureSession cameraCaptureSession) {
        this.f58756b = cVar;
        this.f58757c = cameraCaptureSession;
    }

    public final void run() {
        this.f58756b.h(this.f58757c);
    }
}
