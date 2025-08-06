package androidx.camera.core.imagecapture;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TakePictureManager f5544b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RequestWithCallback f5545c;

    public /* synthetic */ q(TakePictureManager takePictureManager, RequestWithCallback requestWithCallback) {
        this.f5544b = takePictureManager;
        this.f5545c = requestWithCallback;
    }

    public final void run() {
        this.f5544b.lambda$trackCurrentRequests$1(this.f5545c);
    }
}
