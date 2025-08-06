package o;

import android.hardware.camera2.CameraCaptureSession;
import o.f;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.c f58766b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58767c;

    public /* synthetic */ s(f.c cVar, CameraCaptureSession cameraCaptureSession) {
        this.f58766b = cVar;
        this.f58767c = cameraCaptureSession;
    }

    public final void run() {
        this.f58766b.m(this.f58767c);
    }
}
