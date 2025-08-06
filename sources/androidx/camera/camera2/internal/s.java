package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureCallback f5295b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureFailure f5296c;

    public /* synthetic */ s(CameraCaptureCallback cameraCaptureCallback, CameraCaptureFailure cameraCaptureFailure) {
        this.f5295b = cameraCaptureCallback;
        this.f5296c = cameraCaptureFailure;
    }

    public final void run() {
        this.f5295b.onCaptureFailed(this.f5296c);
    }
}
