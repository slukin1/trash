package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f5215b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureCallback f5216c;

    public /* synthetic */ n(u uVar, CameraCaptureCallback cameraCaptureCallback) {
        this.f5215b = uVar;
        this.f5216c = cameraCaptureCallback;
    }

    public final void run() {
        this.f5215b.L(this.f5216c);
    }
}
