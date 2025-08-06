package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.Objects;

public final class x1 extends CameraCaptureCallback {

    /* renamed from: a  reason: collision with root package name */
    public final CameraCaptureSession.CaptureCallback f5444a;

    public x1(CameraCaptureSession.CaptureCallback captureCallback) {
        Objects.requireNonNull(captureCallback, "captureCallback is null");
        this.f5444a = captureCallback;
    }

    public static x1 a(CameraCaptureSession.CaptureCallback captureCallback) {
        return new x1(captureCallback);
    }

    public CameraCaptureSession.CaptureCallback b() {
        return this.f5444a;
    }
}
