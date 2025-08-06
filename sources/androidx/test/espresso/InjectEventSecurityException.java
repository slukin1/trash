package androidx.test.espresso;

public final class InjectEventSecurityException extends androidx.test.platform.ui.InjectEventSecurityException {
    public InjectEventSecurityException(String str) {
        super(str);
        dumpThreads();
    }

    private void dumpThreads() {
    }

    public InjectEventSecurityException(Throwable th2) {
        super(th2);
        dumpThreads();
    }

    public InjectEventSecurityException(String str, Throwable th2) {
        super(str, th2);
        dumpThreads();
    }
}
