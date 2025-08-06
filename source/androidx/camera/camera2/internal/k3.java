package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.ProcessingCaptureSession;
import androidx.camera.core.impl.CaptureConfig;

public final /* synthetic */ class k3 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CaptureConfig f5176b;

    public /* synthetic */ k3(CaptureConfig captureConfig) {
        this.f5176b = captureConfig;
    }

    public final void run() {
        ProcessingCaptureSession.b.c(this.f5176b);
    }
}
