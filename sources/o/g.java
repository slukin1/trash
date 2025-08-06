package o;

import android.hardware.camera2.CameraCaptureSession;
import o.f;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.b f58722b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58723c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58724d;

    public /* synthetic */ g(f.b bVar, CameraCaptureSession cameraCaptureSession, int i11) {
        this.f58722b = bVar;
        this.f58723c = cameraCaptureSession;
        this.f58724d = i11;
    }

    public final void run() {
        this.f58722b.l(this.f58723c, this.f58724d);
    }
}
