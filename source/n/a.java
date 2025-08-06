package n;

import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureResult;
import androidx.camera.camera2.internal.e;
import androidx.camera.camera2.internal.f;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;

public final class a {
    public static CaptureFailure a(CameraCaptureFailure cameraCaptureFailure) {
        if (cameraCaptureFailure instanceof e) {
            return ((e) cameraCaptureFailure).a();
        }
        return null;
    }

    public static CaptureResult b(CameraCaptureResult cameraCaptureResult) {
        if (cameraCaptureResult instanceof f) {
            return ((f) cameraCaptureResult).getCaptureResult();
        }
        return null;
    }
}
