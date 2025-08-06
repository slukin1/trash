package androidx.camera.camera2.internal;

import java.util.List;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f5075b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f5076c;

    public /* synthetic */ d0(Camera2CameraImpl camera2CameraImpl, List list) {
        this.f5075b = camera2CameraImpl;
        this.f5076c = list;
    }

    public final void run() {
        this.f5075b.L(this.f5076c);
    }
}
