package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProcessingRequest f5536b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageProxy f5537c;

    public /* synthetic */ j(ProcessingRequest processingRequest, ImageProxy imageProxy) {
        this.f5536b = processingRequest;
        this.f5537c = imageProxy;
    }

    public final void run() {
        this.f5536b.onFinalResult(this.f5537c);
    }
}
