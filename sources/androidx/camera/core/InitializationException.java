package androidx.camera.core;

public class InitializationException extends Exception {
    public InitializationException(String str) {
        super(str);
    }

    public InitializationException(String str, Throwable th2) {
        super(str, th2);
    }

    public InitializationException(Throwable th2) {
        super(th2);
    }
}
