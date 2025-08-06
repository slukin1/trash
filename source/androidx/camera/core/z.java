package androidx.camera.core;

import androidx.camera.core.ImageCapture;

public final /* synthetic */ class z implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageCapture.ImageCaptureRequest f5745b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5746c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f5747d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Throwable f5748e;

    public /* synthetic */ z(ImageCapture.ImageCaptureRequest imageCaptureRequest, int i11, String str, Throwable th2) {
        this.f5745b = imageCaptureRequest;
        this.f5746c = i11;
        this.f5747d = str;
        this.f5748e = th2;
    }

    public final void run() {
        this.f5745b.lambda$notifyCallbackError$1(this.f5746c, this.f5747d, this.f5748e);
    }
}
