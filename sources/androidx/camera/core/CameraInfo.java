package androidx.camera.core;

import android.util.Range;
import androidx.lifecycle.LiveData;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

public interface CameraInfo {
    public static final String IMPLEMENTATION_TYPE_CAMERA2 = "androidx.camera.camera2";
    public static final String IMPLEMENTATION_TYPE_CAMERA2_LEGACY = "androidx.camera.camera2.legacy";
    public static final String IMPLEMENTATION_TYPE_FAKE = "androidx.camera.fake";
    public static final String IMPLEMENTATION_TYPE_UNKNOWN = "<unknown>";
    public static final float INTRINSIC_ZOOM_RATIO_UNKNOWN = 1.0f;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ImplementationType {
    }

    CameraSelector getCameraSelector();

    LiveData<CameraState> getCameraState();

    ExposureState getExposureState();

    String getImplementationType();

    float getIntrinsicZoomRatio();

    int getLensFacing();

    int getSensorRotationDegrees();

    int getSensorRotationDegrees(int i11);

    Set<Range<Integer>> getSupportedFrameRateRanges();

    LiveData<Integer> getTorchState();

    LiveData<ZoomState> getZoomState();

    boolean hasFlashUnit();

    boolean isFocusMeteringSupported(FocusMeteringAction focusMeteringAction);

    boolean isPrivateReprocessingSupported();

    @ExperimentalZeroShutterLag
    boolean isZslSupported();
}
