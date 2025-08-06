package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureFailure;
import androidx.camera.core.impl.CameraCaptureFailure;

public final class e extends CameraCaptureFailure {

    /* renamed from: a  reason: collision with root package name */
    public final CaptureFailure f5081a;

    public e(CameraCaptureFailure.Reason reason, CaptureFailure captureFailure) {
        super(reason);
        this.f5081a = captureFailure;
    }

    public CaptureFailure a() {
        return this.f5081a;
    }
}
