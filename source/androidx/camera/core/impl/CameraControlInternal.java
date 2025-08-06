package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public interface CameraControlInternal extends CameraControl {
    public static final CameraControlInternal DEFAULT_EMPTY_INSTANCE = new CameraControlInternal() {
        public void addInteropConfig(Config config) {
        }

        public void addZslConfig(SessionConfig.Builder builder) {
        }

        public ListenableFuture<Void> cancelFocusAndMetering() {
            return Futures.immediateFuture(null);
        }

        public void clearInteropConfig() {
        }

        public ListenableFuture<Void> enableTorch(boolean z11) {
            return Futures.immediateFuture(null);
        }

        public int getFlashMode() {
            return 2;
        }

        public /* synthetic */ CameraControlInternal getImplementation() {
            return e.a(this);
        }

        public Config getInteropConfig() {
            return null;
        }

        public Rect getSensorRect() {
            return new Rect();
        }

        public SessionConfig getSessionConfig() {
            return SessionConfig.defaultEmptySessionConfig();
        }

        public boolean isZslDisabledByByUserCaseConfig() {
            return false;
        }

        public ListenableFuture<Integer> setExposureCompensationIndex(int i11) {
            return Futures.immediateFuture(0);
        }

        public void setFlashMode(int i11) {
        }

        public ListenableFuture<Void> setLinearZoom(float f11) {
            return Futures.immediateFuture(null);
        }

        public ListenableFuture<Void> setZoomRatio(float f11) {
            return Futures.immediateFuture(null);
        }

        public void setZslDisabledByUserCaseConfig(boolean z11) {
        }

        public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
            return Futures.immediateFuture(FocusMeteringResult.emptyInstance());
        }

        public ListenableFuture<List<Void>> submitStillCaptureRequests(List<CaptureConfig> list, int i11, int i12) {
            return Futures.immediateFuture(Collections.emptyList());
        }
    };

    public interface ControlUpdateCallback {
        void onCameraControlCaptureRequests(List<CaptureConfig> list);

        void onCameraControlUpdateSessionConfig();
    }

    void addInteropConfig(Config config);

    void addZslConfig(SessionConfig.Builder builder);

    void clearInteropConfig();

    int getFlashMode();

    CameraControlInternal getImplementation();

    Config getInteropConfig();

    Rect getSensorRect();

    SessionConfig getSessionConfig();

    boolean isZslDisabledByByUserCaseConfig();

    void setFlashMode(int i11);

    void setZslDisabledByUserCaseConfig(boolean z11);

    ListenableFuture<List<Void>> submitStillCaptureRequests(List<CaptureConfig> list, int i11, int i12);

    public static final class CameraControlException extends Exception {
        private CameraCaptureFailure mCameraCaptureFailure;

        public CameraControlException(CameraCaptureFailure cameraCaptureFailure) {
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }

        public CameraCaptureFailure getCameraCaptureFailure() {
            return this.mCameraCaptureFailure;
        }

        public CameraControlException(CameraCaptureFailure cameraCaptureFailure, Throwable th2) {
            super(th2);
            this.mCameraCaptureFailure = cameraCaptureFailure;
        }
    }
}
