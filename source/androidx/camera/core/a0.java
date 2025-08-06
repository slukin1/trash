package androidx.camera.core;

import androidx.camera.core.ImageCapture;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageCapture.ImageCaptureRequest f5496b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageProxy f5497c;

    public /* synthetic */ a0(ImageCapture.ImageCaptureRequest imageCaptureRequest, ImageProxy imageProxy) {
        this.f5496b = imageCaptureRequest;
        this.f5497c = imageProxy;
    }

    public final void run() {
        this.f5496b.lambda$dispatchImage$0(this.f5497c);
    }
}
