package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import java.util.concurrent.Executor;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageCapture f5740b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f5741c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ImageCapture.OnImageCapturedCallback f5742d;

    public /* synthetic */ y(ImageCapture imageCapture, Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        this.f5740b = imageCapture;
        this.f5741c = executor;
        this.f5742d = onImageCapturedCallback;
    }

    public final void run() {
        this.f5740b.lambda$takePicture$1(this.f5741c, this.f5742d);
    }
}
