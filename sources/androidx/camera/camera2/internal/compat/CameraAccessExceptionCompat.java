package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CameraAccessExceptionCompat extends Exception {
    public static final int CAMERA_CHARACTERISTICS_CREATION_ERROR = 10002;
    public static final int CAMERA_DEPRECATED_HAL = 1000;
    public static final int CAMERA_DISABLED = 1;
    public static final int CAMERA_DISCONNECTED = 2;
    public static final int CAMERA_ERROR = 3;
    public static final int CAMERA_IN_USE = 4;
    public static final int CAMERA_UNAVAILABLE_DO_NOT_DISTURB = 10001;
    public static final Set<Integer> COMPAT_ERRORS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{10001, 10002})));
    public static final int MAX_CAMERAS_IN_USE = 5;
    public static final Set<Integer> PLATFORM_ERRORS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{4, 5, 1, 2, 3})));
    private final CameraAccessException mCameraAccessException;
    private final int mReason;

    public CameraAccessExceptionCompat(int i11) {
        super(getDefaultMessage(i11));
        this.mReason = i11;
        this.mCameraAccessException = PLATFORM_ERRORS.contains(Integer.valueOf(i11)) ? new CameraAccessException(i11) : null;
    }

    private static String getCombinedMessage(int i11, String str) {
        return String.format("%s (%d): %s", new Object[]{getProblemString(i11), Integer.valueOf(i11), str});
    }

    private static String getDefaultMessage(int i11) {
        if (i11 == 1) {
            return "The camera is disabled due to a device policy, and cannot be opened.";
        }
        if (i11 == 2) {
            return "The camera device is removable and has been disconnected from the Android device, or the camera service has shut down the connection due to a higher-priority access request for the camera device.";
        }
        if (i11 == 3) {
            return "The camera device is currently in the error state; no further calls to it will succeed.";
        }
        if (i11 == 4) {
            return "The camera device is in use already";
        }
        if (i11 == 5) {
            return "The system-wide limit for number of open cameras has been reached, and more camera devices cannot be opened until previous instances are closed.";
        }
        if (i11 == 10001) {
            return "Some API 28 devices cannot access the camera when the device is in \"Do Not Disturb\" mode. The camera will not be accessible until \"Do Not Disturb\" mode is disabled.";
        }
        if (i11 != 10002) {
            return null;
        }
        return "Failed to create CameraCharacteristics.";
    }

    private static String getProblemString(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? i11 != 1000 ? i11 != 10001 ? i11 != 10002 ? "<UNKNOWN ERROR>" : "CAMERA_CHARACTERISTICS_CREATION_ERROR" : "CAMERA_UNAVAILABLE_DO_NOT_DISTURB" : "CAMERA_DEPRECATED_HAL" : "MAX_CAMERAS_IN_USE" : "CAMERA_IN_USE" : "CAMERA_ERROR" : "CAMERA_DISCONNECTED" : "CAMERA_DISABLED";
    }

    public static CameraAccessExceptionCompat toCameraAccessExceptionCompat(CameraAccessException cameraAccessException) {
        Objects.requireNonNull(cameraAccessException, "cameraAccessException should not be null");
        return new CameraAccessExceptionCompat(cameraAccessException);
    }

    public final int getReason() {
        return this.mReason;
    }

    public CameraAccessException toCameraAccessException() {
        return this.mCameraAccessException;
    }

    public CameraAccessExceptionCompat(int i11, String str) {
        super(getCombinedMessage(i11, str));
        this.mReason = i11;
        this.mCameraAccessException = PLATFORM_ERRORS.contains(Integer.valueOf(i11)) ? new CameraAccessException(i11, str) : null;
    }

    public CameraAccessExceptionCompat(int i11, String str, Throwable th2) {
        super(getCombinedMessage(i11, str), th2);
        this.mReason = i11;
        this.mCameraAccessException = PLATFORM_ERRORS.contains(Integer.valueOf(i11)) ? new CameraAccessException(i11, str, th2) : null;
    }

    public CameraAccessExceptionCompat(int i11, Throwable th2) {
        super(getDefaultMessage(i11), th2);
        this.mReason = i11;
        this.mCameraAccessException = PLATFORM_ERRORS.contains(Integer.valueOf(i11)) ? new CameraAccessException(i11, (String) null, th2) : null;
    }

    private CameraAccessExceptionCompat(CameraAccessException cameraAccessException) {
        super(cameraAccessException.getMessage(), cameraAccessException.getCause());
        this.mReason = cameraAccessException.getReason();
        this.mCameraAccessException = cameraAccessException;
    }
}
