package androidx.camera.core.impl;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraRepository f5570b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraInternal f5571c;

    public /* synthetic */ l(CameraRepository cameraRepository, CameraInternal cameraInternal) {
        this.f5570b = cameraRepository;
        this.f5571c = cameraInternal;
    }

    public final void run() {
        this.f5570b.lambda$deinit$1(this.f5571c);
    }
}
