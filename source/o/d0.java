package o;

import android.hardware.camera2.CameraDevice;
import o.z;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z.b f58719b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f58720c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58721d;

    public /* synthetic */ d0(z.b bVar, CameraDevice cameraDevice, int i11) {
        this.f58719b = bVar;
        this.f58720c = cameraDevice;
        this.f58721d = i11;
    }

    public final void run() {
        this.f58719b.g(this.f58720c, this.f58721d);
    }
}
