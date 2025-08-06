package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCaptureException;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TakePictureRequest f5548b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageCaptureException f5549c;

    public /* synthetic */ s(TakePictureRequest takePictureRequest, ImageCaptureException imageCaptureException) {
        this.f5548b = takePictureRequest;
        this.f5549c = imageCaptureException;
    }

    public final void run() {
        this.f5548b.lambda$onError$0(this.f5549c);
    }
}
