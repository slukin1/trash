package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.SessionConfig;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public class ForwardingCameraControl implements CameraControlInternal {
    private final CameraControlInternal mCameraControlInternal;

    public ForwardingCameraControl(CameraControlInternal cameraControlInternal) {
        this.mCameraControlInternal = cameraControlInternal;
    }

    public void addInteropConfig(Config config) {
        this.mCameraControlInternal.addInteropConfig(config);
    }

    public void addZslConfig(SessionConfig.Builder builder) {
        this.mCameraControlInternal.addZslConfig(builder);
    }

    public ListenableFuture<Void> cancelFocusAndMetering() {
        return this.mCameraControlInternal.cancelFocusAndMetering();
    }

    public void clearInteropConfig() {
        this.mCameraControlInternal.clearInteropConfig();
    }

    public ListenableFuture<Void> enableTorch(boolean z11) {
        return this.mCameraControlInternal.enableTorch(z11);
    }

    public int getFlashMode() {
        return this.mCameraControlInternal.getFlashMode();
    }

    public CameraControlInternal getImplementation() {
        return this.mCameraControlInternal.getImplementation();
    }

    public Config getInteropConfig() {
        return this.mCameraControlInternal.getInteropConfig();
    }

    public Rect getSensorRect() {
        return this.mCameraControlInternal.getSensorRect();
    }

    public SessionConfig getSessionConfig() {
        return this.mCameraControlInternal.getSessionConfig();
    }

    public boolean isZslDisabledByByUserCaseConfig() {
        return this.mCameraControlInternal.isZslDisabledByByUserCaseConfig();
    }

    public ListenableFuture<Integer> setExposureCompensationIndex(int i11) {
        return this.mCameraControlInternal.setExposureCompensationIndex(i11);
    }

    public void setFlashMode(int i11) {
        this.mCameraControlInternal.setFlashMode(i11);
    }

    public ListenableFuture<Void> setLinearZoom(float f11) {
        return this.mCameraControlInternal.setLinearZoom(f11);
    }

    public ListenableFuture<Void> setZoomRatio(float f11) {
        return this.mCameraControlInternal.setZoomRatio(f11);
    }

    public void setZslDisabledByUserCaseConfig(boolean z11) {
        this.mCameraControlInternal.setZslDisabledByUserCaseConfig(z11);
    }

    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
        return this.mCameraControlInternal.startFocusAndMetering(focusMeteringAction);
    }

    public ListenableFuture<List<Void>> submitStillCaptureRequests(List<CaptureConfig> list, int i11, int i12) {
        return this.mCameraControlInternal.submitStillCaptureRequests(list, i11, i12);
    }
}
