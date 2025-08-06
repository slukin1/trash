package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public interface CameraInfoInternal extends CameraInfo {
    void addSessionCaptureCallback(Executor executor, CameraCaptureCallback cameraCaptureCallback);

    String getCameraId();

    Quirks getCameraQuirks();

    CameraSelector getCameraSelector();

    EncoderProfilesProvider getEncoderProfilesProvider();

    CameraInfoInternal getImplementation();

    Set<DynamicRange> getSupportedDynamicRanges();

    List<Size> getSupportedHighResolutions(int i11);

    List<Size> getSupportedResolutions(int i11);

    Timebase getTimebase();

    void removeSessionCaptureCallback(CameraCaptureCallback cameraCaptureCallback);
}
