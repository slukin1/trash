package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.ProcessingCaptureSession;
import androidx.camera.core.impl.CaptureConfig;

public final /* synthetic */ class l3 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CaptureConfig f5190b;

    public /* synthetic */ l3(CaptureConfig captureConfig) {
        this.f5190b = captureConfig;
    }

    public final void run() {
        ProcessingCaptureSession.b.d(this.f5190b);
    }
}
