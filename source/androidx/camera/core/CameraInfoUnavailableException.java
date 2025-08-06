package androidx.camera.core;

public final class CameraInfoUnavailableException extends Exception {
    public CameraInfoUnavailableException(String str, Throwable th2) {
        super(str, th2);
    }

    public CameraInfoUnavailableException(String str) {
        super(str);
    }
}
