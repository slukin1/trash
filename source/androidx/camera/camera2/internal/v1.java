package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;

public final class v1 {
    public static CameraUnavailableException a(CameraAccessExceptionCompat cameraAccessExceptionCompat) {
        int reason = cameraAccessExceptionCompat.getReason();
        int i11 = 5;
        if (reason == 1) {
            i11 = 1;
        } else if (reason == 2) {
            i11 = 2;
        } else if (reason == 3) {
            i11 = 3;
        } else if (reason == 4) {
            i11 = 4;
        } else if (reason != 5) {
            i11 = reason != 10001 ? 0 : 6;
        }
        return new CameraUnavailableException(i11, (Throwable) cameraAccessExceptionCompat);
    }
}
