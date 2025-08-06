package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureCallback f5285b;

    public /* synthetic */ r(CameraCaptureCallback cameraCaptureCallback) {
        this.f5285b = cameraCaptureCallback;
    }

    public final void run() {
        this.f5285b.onCaptureCancelled();
    }
}
