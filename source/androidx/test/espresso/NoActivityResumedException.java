package androidx.test.espresso;

public final class NoActivityResumedException extends RuntimeException {
    public NoActivityResumedException(String str) {
        super(str);
    }

    public NoActivityResumedException(String str, Throwable th2) {
        super(str, th2);
    }
}
