package androidx.camera.core.impl.utils;

import androidx.camera.core.Logger;

public final class CameraOrientationUtil {
    private static final String TAG = "CameraOrientationUtil";

    private CameraOrientationUtil() {
    }

    public static int degreesToSurfaceRotation(int i11) {
        if (i11 == 0) {
            return 0;
        }
        if (i11 == 90) {
            return 1;
        }
        if (i11 == 180) {
            return 2;
        }
        if (i11 == 270) {
            return 3;
        }
        throw new IllegalStateException("Invalid sensor rotation: " + i11);
    }

    public static int getRelativeImageRotation(int i11, int i12, boolean z11) {
        int i13;
        if (z11) {
            i13 = ((i12 - i11) + 360) % 360;
        } else {
            i13 = (i12 + i11) % 360;
        }
        if (Logger.isDebugEnabled(TAG)) {
            Logger.d(TAG, String.format("getRelativeImageRotation: destRotationDegrees=%s, sourceRotationDegrees=%s, isOppositeFacing=%s, result=%s", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Boolean.valueOf(z11), Integer.valueOf(i13)}));
        }
        return i13;
    }

    public static int surfaceRotationToDegrees(int i11) {
        if (i11 == 0) {
            return 0;
        }
        if (i11 == 1) {
            return 90;
        }
        if (i11 == 2) {
            return 180;
        }
        if (i11 == 3) {
            return 270;
        }
        throw new IllegalArgumentException("Unsupported surface rotation: " + i11);
    }
}
