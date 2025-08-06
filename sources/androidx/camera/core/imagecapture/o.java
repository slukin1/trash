package androidx.camera.core.imagecapture;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TakePictureManager f5542b;

    public /* synthetic */ o(TakePictureManager takePictureManager) {
        this.f5542b = takePictureManager;
    }

    public final void run() {
        this.f5542b.issueNextRequest();
    }
}
