package androidx.camera.camera2.internal;

public final /* synthetic */ class e0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f5082b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f5083c;

    public /* synthetic */ e0(Camera2CameraImpl camera2CameraImpl, boolean z11) {
        this.f5082b = camera2CameraImpl;
        this.f5083c = z11;
    }

    public final void run() {
        this.f5082b.Z(this.f5083c);
    }
}
