package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.ProcessingCaptureSession;
import androidx.camera.core.impl.CaptureConfig;

public final /* synthetic */ class n3 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CaptureConfig f5230b;

    public /* synthetic */ n3(CaptureConfig captureConfig) {
        this.f5230b = captureConfig;
    }

    public final void run() {
        ProcessingCaptureSession.c.c(this.f5230b);
    }
}
