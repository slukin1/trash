package androidx.camera.core;

final class CameraClosedException extends RuntimeException {
    public CameraClosedException(String str, Throwable th2) {
        super(str, th2);
    }

    public CameraClosedException(String str) {
        super(str);
    }
}
