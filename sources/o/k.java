package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import o.f;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.b f58741b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58742c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CaptureRequest f58743d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CaptureResult f58744e;

    public /* synthetic */ k(f.b bVar, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        this.f58741b = bVar;
        this.f58742c = cameraCaptureSession;
        this.f58743d = captureRequest;
        this.f58744e = captureResult;
    }

    public final void run() {
        this.f58741b.k(this.f58742c, this.f58743d, this.f58744e);
    }
}
