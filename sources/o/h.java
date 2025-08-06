package o;

import android.hardware.camera2.CameraCaptureSession;
import o.f;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.b f58725b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f58726c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58727d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f58728e;

    public /* synthetic */ h(f.b bVar, CameraCaptureSession cameraCaptureSession, int i11, long j11) {
        this.f58725b = bVar;
        this.f58726c = cameraCaptureSession;
        this.f58727d = i11;
        this.f58728e = j11;
    }

    public final void run() {
        this.f58725b.m(this.f58726c, this.f58727d, this.f58728e);
    }
}
