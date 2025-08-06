package androidx.camera.video.internal.encoder;

public class InvalidConfigException extends Exception {
    public InvalidConfigException(String str) {
        super(str);
    }

    public InvalidConfigException(String str, Throwable th2) {
        super(str, th2);
    }

    public InvalidConfigException(Throwable th2) {
        super(th2);
    }
}
