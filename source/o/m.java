package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import o.f;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.b f58751b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58752c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CaptureRequest f58753d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Surface f58754e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ long f58755f;

    public /* synthetic */ m(f.b bVar, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j11) {
        this.f58751b = bVar;
        this.f58752c = cameraCaptureSession;
        this.f58753d = captureRequest;
        this.f58754e = surface;
        this.f58755f = j11;
    }

    public final void run() {
        this.f58751b.h(this.f58752c, this.f58753d, this.f58754e, this.f58755f);
    }
}
