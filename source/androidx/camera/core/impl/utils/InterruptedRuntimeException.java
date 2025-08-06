package androidx.camera.core.impl.utils;

public class InterruptedRuntimeException extends RuntimeException {
    public InterruptedRuntimeException() {
    }

    public InterruptedRuntimeException(String str) {
        super(str);
    }

    public InterruptedRuntimeException(String str, Throwable th2) {
        super(str, th2);
    }

    public InterruptedRuntimeException(Throwable th2) {
        super(th2);
    }
}
