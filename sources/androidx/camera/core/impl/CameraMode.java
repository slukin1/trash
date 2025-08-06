package androidx.camera.core.impl;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CameraMode {
    public static final int CONCURRENT_CAMERA = 1;
    public static final int DEFAULT = 0;
    public static final int ULTRA_HIGH_RESOLUTION_CAMERA = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    private CameraMode() {
    }

    public static String toLabelString(int i11) {
        return i11 != 1 ? i11 != 2 ? MessengerShareContentUtility.PREVIEW_DEFAULT : "ULTRA_HIGH_RESOLUTION_CAMERA" : "CONCURRENT_CAMERA";
    }
}
