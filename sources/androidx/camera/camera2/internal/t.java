package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureCallback f5326b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CameraCaptureResult f5327c;

    public /* synthetic */ t(CameraCaptureCallback cameraCaptureCallback, CameraCaptureResult cameraCaptureResult) {
        this.f5326b = cameraCaptureCallback;
        this.f5327c = cameraCaptureResult;
    }

    public final void run() {
        this.f5326b.onCaptureCompleted(this.f5327c);
    }
}
