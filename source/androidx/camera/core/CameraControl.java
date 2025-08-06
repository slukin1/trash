package androidx.camera.core;

import com.google.common.util.concurrent.ListenableFuture;

public interface CameraControl {

    public static final class OperationCanceledException extends Exception {
        public OperationCanceledException(String str) {
            super(str);
        }

        public OperationCanceledException(String str, Throwable th2) {
            super(str, th2);
        }
    }

    ListenableFuture<Void> cancelFocusAndMetering();

    ListenableFuture<Void> enableTorch(boolean z11);

    ListenableFuture<Integer> setExposureCompensationIndex(int i11);

    ListenableFuture<Void> setLinearZoom(float f11);

    ListenableFuture<Void> setZoomRatio(float f11);

    ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction focusMeteringAction);
}
