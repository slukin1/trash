package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.LinkedHashSet;

public interface CameraInternal extends Camera, UseCase.StateChangeCallback {

    public enum State {
        PENDING_OPEN(false),
        OPENING(true),
        OPEN(true),
        CONFIGURED(true),
        CLOSING(true),
        CLOSED(false),
        RELEASING(true),
        RELEASED(false);
        
        private final boolean mHoldsCameraSlot;

        private State(boolean z11) {
            this.mHoldsCameraSlot = z11;
        }

        public boolean holdsCameraSlot() {
            return this.mHoldsCameraSlot;
        }
    }

    void attachUseCases(Collection<UseCase> collection);

    void close();

    void detachUseCases(Collection<UseCase> collection);

    CameraControl getCameraControl();

    CameraControlInternal getCameraControlInternal();

    CameraInfo getCameraInfo();

    CameraInfoInternal getCameraInfoInternal();

    LinkedHashSet<CameraInternal> getCameraInternals();

    Observable<State> getCameraState();

    CameraConfig getExtendedConfig();

    boolean getHasTransform();

    boolean isFrontFacing();

    void open();

    ListenableFuture<Void> release();

    void setActiveResumingMode(boolean z11);

    void setExtendedConfig(CameraConfig cameraConfig);
}
