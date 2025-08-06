package kotlinx.coroutines.internal;

public final class UndeliveredElementException extends RuntimeException {
    public UndeliveredElementException(String str, Throwable th2) {
        super(str, th2);
    }
}
