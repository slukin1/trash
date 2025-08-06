package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCaptureException;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProcessingRequest f5534b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageCaptureException f5535c;

    public /* synthetic */ i(ProcessingRequest processingRequest, ImageCaptureException imageCaptureException) {
        this.f5534b = processingRequest;
        this.f5535c = imageCaptureException;
    }

    public final void run() {
        this.f5534b.onProcessFailure(this.f5535c);
    }
}
