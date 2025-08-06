package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCapture;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProcessingRequest f5532b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageCapture.OutputFileResults f5533c;

    public /* synthetic */ h(ProcessingRequest processingRequest, ImageCapture.OutputFileResults outputFileResults) {
        this.f5532b = processingRequest;
        this.f5533c = outputFileResults;
    }

    public final void run() {
        this.f5532b.onFinalResult(this.f5533c);
    }
}
