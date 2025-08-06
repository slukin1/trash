package androidx.camera.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CameraUnavailableException extends Exception {
    public static final int CAMERA_DISABLED = 1;
    public static final int CAMERA_DISCONNECTED = 2;
    public static final int CAMERA_ERROR = 3;
    public static final int CAMERA_IN_USE = 4;
    public static final int CAMERA_MAX_IN_USE = 5;
    public static final int CAMERA_UNAVAILABLE_DO_NOT_DISTURB = 6;
    public static final int CAMERA_UNKNOWN_ERROR = 0;
    private final int mReason;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Reason {
    }

    public CameraUnavailableException(int i11) {
        this.mReason = i11;
    }

    public int getReason() {
        return this.mReason;
    }

    public CameraUnavailableException(int i11, String str) {
        super(str);
        this.mReason = i11;
    }

    public CameraUnavailableException(int i11, String str, Throwable th2) {
        super(str, th2);
        this.mReason = i11;
    }

    public CameraUnavailableException(int i11, Throwable th2) {
        super(th2);
        this.mReason = i11;
    }
}
