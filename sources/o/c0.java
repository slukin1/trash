package o;

import android.hardware.camera2.CameraDevice;
import o.z;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z.b f58717b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f58718c;

    public /* synthetic */ c0(z.b bVar, CameraDevice cameraDevice) {
        this.f58717b = bVar;
        this.f58718c = cameraDevice;
    }

    public final void run() {
        this.f58717b.e(this.f58718c);
    }
}
