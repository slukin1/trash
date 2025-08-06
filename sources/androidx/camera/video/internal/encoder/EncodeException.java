package androidx.camera.video.internal.encoder;

public class EncodeException extends Exception {
    public static final int ERROR_CODEC = 1;
    public static final int ERROR_UNKNOWN = 0;
    private final int mErrorType;

    public EncodeException(int i11, String str, Throwable th2) {
        super(str, th2);
        this.mErrorType = i11;
    }

    public int getErrorType() {
        return this.mErrorType;
    }
}
