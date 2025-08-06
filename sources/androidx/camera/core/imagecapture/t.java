package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TakePictureRequest f5550b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageProxy f5551c;

    public /* synthetic */ t(TakePictureRequest takePictureRequest, ImageProxy imageProxy) {
        this.f5550b = takePictureRequest;
        this.f5551c = imageProxy;
    }

    public final void run() {
        this.f5550b.lambda$onResult$2(this.f5551c);
    }
}
