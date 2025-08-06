package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import o.f;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.b f58729b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58730c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CaptureRequest f58731d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f58732e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ long f58733f;

    public /* synthetic */ i(f.b bVar, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j11, long j12) {
        this.f58729b = bVar;
        this.f58730c = cameraCaptureSession;
        this.f58731d = captureRequest;
        this.f58732e = j11;
        this.f58733f = j12;
    }

    public final void run() {
        this.f58729b.n(this.f58730c, this.f58731d, this.f58732e, this.f58733f);
    }
}
