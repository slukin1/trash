package androidx.camera.core;

import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraInternal;
import java.util.LinkedHashSet;

public interface Camera {
    CameraControl getCameraControl();

    CameraInfo getCameraInfo();

    LinkedHashSet<CameraInternal> getCameraInternals();

    CameraConfig getExtendedConfig();

    boolean isUseCasesCombinationSupported(UseCase... useCaseArr);

    void setExtendedConfig(CameraConfig cameraConfig);
}
