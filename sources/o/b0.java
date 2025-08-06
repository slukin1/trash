package o;

import android.hardware.camera2.CameraDevice;
import o.z;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z.b f58715b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f58716c;

    public /* synthetic */ b0(z.b bVar, CameraDevice cameraDevice) {
        this.f58715b = bVar;
        this.f58716c = cameraDevice;
    }

    public final void run() {
        this.f58715b.h(this.f58716c);
    }
}
