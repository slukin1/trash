package o;

import android.hardware.camera2.CameraDevice;
import o.z;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z.b f58713b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f58714c;

    public /* synthetic */ a0(z.b bVar, CameraDevice cameraDevice) {
        this.f58713b = bVar;
        this.f58714c = cameraDevice;
    }

    public final void run() {
        this.f58713b.f(this.f58714c);
    }
}
