package androidx.camera.core.imagecapture;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TakePictureManager f5543b;

    public /* synthetic */ p(TakePictureManager takePictureManager) {
        this.f5543b = takePictureManager;
    }

    public final void run() {
        this.f5543b.lambda$trackCurrentRequests$0();
    }
}
