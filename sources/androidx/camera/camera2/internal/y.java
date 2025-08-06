package androidx.camera.camera2.internal;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f5472b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f5473c;

    public /* synthetic */ y(Camera2CameraImpl camera2CameraImpl, String str) {
        this.f5472b = camera2CameraImpl;
        this.f5473c = str;
    }

    public final void run() {
        this.f5472b.T(this.f5473c);
    }
}
