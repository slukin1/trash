package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import java.util.concurrent.Executor;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageCapture f5735b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageCapture.OutputFileOptions f5736c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Executor f5737d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ImageCapture.OnImageSavedCallback f5738e;

    public /* synthetic */ x(ImageCapture imageCapture, ImageCapture.OutputFileOptions outputFileOptions, Executor executor, ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        this.f5735b = imageCapture;
        this.f5736c = outputFileOptions;
        this.f5737d = executor;
        this.f5738e = onImageSavedCallback;
    }

    public final void run() {
        this.f5735b.lambda$takePicture$2(this.f5736c, this.f5737d, this.f5738e);
    }
}
