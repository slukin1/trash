package androidx.test.platform.ui;

public class InjectEventSecurityException extends Exception {
    public InjectEventSecurityException(String str) {
        super(str);
    }

    public InjectEventSecurityException(Throwable th2) {
        super(th2);
    }

    public InjectEventSecurityException(String str, Throwable th2) {
        super(str, th2);
    }
}
