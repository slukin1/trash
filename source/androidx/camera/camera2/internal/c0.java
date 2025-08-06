package androidx.camera.camera2.internal;

import java.util.List;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f5036b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f5037c;

    public /* synthetic */ c0(Camera2CameraImpl camera2CameraImpl, List list) {
        this.f5036b = camera2CameraImpl;
        this.f5037c = list;
    }

    public final void run() {
        this.f5036b.O(this.f5037c);
    }
}
