package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import o.f;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.b f58735b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58736c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CaptureRequest f58737d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CaptureFailure f58738e;

    public /* synthetic */ j(f.b bVar, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        this.f58735b = bVar;
        this.f58736c = cameraCaptureSession;
        this.f58737d = captureRequest;
        this.f58738e = captureFailure;
    }

    public final void run() {
        this.f58735b.j(this.f58736c, this.f58737d, this.f58738e);
    }
}
