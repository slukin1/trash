package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraState;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ExperimentalZeroShutterLag;
import androidx.camera.core.ExposureState;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ZoomState;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class ForwardingCameraInfo implements CameraInfoInternal {
    private final CameraInfoInternal mCameraInfoInternal;

    public ForwardingCameraInfo(CameraInfoInternal cameraInfoInternal) {
        this.mCameraInfoInternal = cameraInfoInternal;
    }

    public void addSessionCaptureCallback(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.mCameraInfoInternal.addSessionCaptureCallback(executor, cameraCaptureCallback);
    }

    public String getCameraId() {
        return this.mCameraInfoInternal.getCameraId();
    }

    public Quirks getCameraQuirks() {
        return this.mCameraInfoInternal.getCameraQuirks();
    }

    public CameraSelector getCameraSelector() {
        return this.mCameraInfoInternal.getCameraSelector();
    }

    public LiveData<CameraState> getCameraState() {
        return this.mCameraInfoInternal.getCameraState();
    }

    public EncoderProfilesProvider getEncoderProfilesProvider() {
        return this.mCameraInfoInternal.getEncoderProfilesProvider();
    }

    public ExposureState getExposureState() {
        return this.mCameraInfoInternal.getExposureState();
    }

    public CameraInfoInternal getImplementation() {
        return this.mCameraInfoInternal.getImplementation();
    }

    public String getImplementationType() {
        return this.mCameraInfoInternal.getImplementationType();
    }

    public float getIntrinsicZoomRatio() {
        return this.mCameraInfoInternal.getIntrinsicZoomRatio();
    }

    public int getLensFacing() {
        return this.mCameraInfoInternal.getLensFacing();
    }

    public int getSensorRotationDegrees() {
        return this.mCameraInfoInternal.getSensorRotationDegrees();
    }

    public Set<DynamicRange> getSupportedDynamicRanges() {
        return this.mCameraInfoInternal.getSupportedDynamicRanges();
    }

    public Set<Range<Integer>> getSupportedFrameRateRanges() {
        return this.mCameraInfoInternal.getSupportedFrameRateRanges();
    }

    public List<Size> getSupportedHighResolutions(int i11) {
        return this.mCameraInfoInternal.getSupportedHighResolutions(i11);
    }

    public List<Size> getSupportedResolutions(int i11) {
        return this.mCameraInfoInternal.getSupportedResolutions(i11);
    }

    public Timebase getTimebase() {
        return this.mCameraInfoInternal.getTimebase();
    }

    public LiveData<Integer> getTorchState() {
        return this.mCameraInfoInternal.getTorchState();
    }

    public LiveData<ZoomState> getZoomState() {
        return this.mCameraInfoInternal.getZoomState();
    }

    public boolean hasFlashUnit() {
        return this.mCameraInfoInternal.hasFlashUnit();
    }

    public boolean isFocusMeteringSupported(FocusMeteringAction focusMeteringAction) {
        return this.mCameraInfoInternal.isFocusMeteringSupported(focusMeteringAction);
    }

    public boolean isPrivateReprocessingSupported() {
        return this.mCameraInfoInternal.isPrivateReprocessingSupported();
    }

    @ExperimentalZeroShutterLag
    public boolean isZslSupported() {
        return this.mCameraInfoInternal.isZslSupported();
    }

    public void removeSessionCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        this.mCameraInfoInternal.removeSessionCaptureCallback(cameraCaptureCallback);
    }

    public int getSensorRotationDegrees(int i11) {
        return this.mCameraInfoInternal.getSensorRotationDegrees(i11);
    }
}
