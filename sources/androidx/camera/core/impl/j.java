package androidx.camera.core.impl;

import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import java.util.Collections;
import java.util.LinkedHashSet;

public final /* synthetic */ class j {
    public static CameraControl a(CameraInternal cameraInternal) {
        return cameraInternal.getCameraControlInternal();
    }

    public static CameraInfo b(CameraInternal cameraInternal) {
        return cameraInternal.getCameraInfoInternal();
    }

    public static LinkedHashSet c(CameraInternal cameraInternal) {
        return new LinkedHashSet(Collections.singleton(cameraInternal));
    }

    public static CameraConfig d(CameraInternal cameraInternal) {
        return CameraConfigs.emptyConfig();
    }

    public static boolean e(CameraInternal cameraInternal) {
        return true;
    }

    public static boolean f(CameraInternal cameraInternal) {
        return cameraInternal.getCameraInfo().getLensFacing() == 0;
    }

    public static void g(CameraInternal cameraInternal, boolean z11) {
    }

    public static void h(CameraInternal cameraInternal, CameraConfig cameraConfig) {
    }
}
