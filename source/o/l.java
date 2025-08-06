package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import o.f;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.b f58747b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58748c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CaptureRequest f58749d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TotalCaptureResult f58750e;

    public /* synthetic */ l(f.b bVar, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        this.f58747b = bVar;
        this.f58748c = cameraCaptureSession;
        this.f58749d = captureRequest;
        this.f58750e = totalCaptureResult;
    }

    public final void run() {
        this.f58747b.i(this.f58748c, this.f58749d, this.f58750e);
    }
}
