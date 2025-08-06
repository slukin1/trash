package androidx.camera.core.impl;

import android.util.Range;
import android.util.Rational;
import androidx.camera.core.ExposureState;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ZoomState;
import androidx.camera.core.internal.ImmutableZoomState;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class RestrictedCameraInfo extends ForwardingCameraInfo {
    private final CameraInfoInternal mCameraInfo;
    private final RestrictedCameraControl mRestrictedCameraControl;

    public RestrictedCameraInfo(CameraInfoInternal cameraInfoInternal, RestrictedCameraControl restrictedCameraControl) {
        super(cameraInfoInternal);
        this.mCameraInfo = cameraInfoInternal;
        this.mRestrictedCameraControl = restrictedCameraControl;
    }

    public ExposureState getExposureState() {
        if (!this.mRestrictedCameraControl.isOperationSupported(7)) {
            return new ExposureState() {
                public int getExposureCompensationIndex() {
                    return 0;
                }

                public Range<Integer> getExposureCompensationRange() {
                    return new Range<>(0, 0);
                }

                public Rational getExposureCompensationStep() {
                    return Rational.ZERO;
                }

                public boolean isExposureCompensationSupported() {
                    return false;
                }
            };
        }
        return this.mCameraInfo.getExposureState();
    }

    public CameraInfoInternal getImplementation() {
        return this.mCameraInfo;
    }

    public LiveData<Integer> getTorchState() {
        if (!this.mRestrictedCameraControl.isOperationSupported(6)) {
            return new MutableLiveData(0);
        }
        return this.mCameraInfo.getTorchState();
    }

    public LiveData<ZoomState> getZoomState() {
        if (!this.mRestrictedCameraControl.isOperationSupported(0)) {
            return new MutableLiveData(ImmutableZoomState.create(1.0f, 1.0f, 1.0f, 0.0f));
        }
        return this.mCameraInfo.getZoomState();
    }

    public boolean hasFlashUnit() {
        if (!this.mRestrictedCameraControl.isOperationSupported(5)) {
            return false;
        }
        return this.mCameraInfo.hasFlashUnit();
    }

    public boolean isFocusMeteringSupported(FocusMeteringAction focusMeteringAction) {
        if (this.mRestrictedCameraControl.getModifiedFocusMeteringAction(focusMeteringAction) == null) {
            return false;
        }
        return this.mCameraInfo.isFocusMeteringSupported(focusMeteringAction);
    }
}
