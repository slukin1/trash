package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageCapture;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TakePictureRequest f5546b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageCapture.OutputFileResults f5547c;

    public /* synthetic */ r(TakePictureRequest takePictureRequest, ImageCapture.OutputFileResults outputFileResults) {
        this.f5546b = takePictureRequest;
        this.f5547c = outputFileResults;
    }

    public final void run() {
        this.f5546b.lambda$onResult$1(this.f5547c);
    }
}
