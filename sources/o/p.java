package o;

import android.hardware.camera2.CameraCaptureSession;
import o.f;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.c f58760b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58761c;

    public /* synthetic */ p(f.c cVar, CameraCaptureSession cameraCaptureSession) {
        this.f58760b = cVar;
        this.f58761c = cameraCaptureSession;
    }

    public final void run() {
        this.f58760b.i(this.f58761c);
    }
}
