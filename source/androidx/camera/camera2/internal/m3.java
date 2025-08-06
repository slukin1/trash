package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.ProcessingCaptureSession;
import androidx.camera.core.impl.CaptureConfig;

public final /* synthetic */ class m3 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CaptureConfig f5206b;

    public /* synthetic */ m3(CaptureConfig captureConfig) {
        this.f5206b = captureConfig;
    }

    public final void run() {
        ProcessingCaptureSession.c.d(this.f5206b);
    }
}
