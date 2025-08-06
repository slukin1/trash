package androidx.camera.core.imagecapture;

import androidx.camera.core.impl.CaptureConfig;
import java.util.List;

public final class CameraRequest {
    private final TakePictureCallback mCallback;
    private final List<CaptureConfig> mCaptureConfigs;

    public CameraRequest(List<CaptureConfig> list, TakePictureCallback takePictureCallback) {
        this.mCaptureConfigs = list;
        this.mCallback = takePictureCallback;
    }

    public List<CaptureConfig> getCaptureConfigs() {
        return this.mCaptureConfigs;
    }

    public boolean isAborted() {
        return this.mCallback.isAborted();
    }
}
