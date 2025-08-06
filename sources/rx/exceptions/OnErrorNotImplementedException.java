package rx.exceptions;

public class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnErrorNotImplementedException(String str, Throwable th2) {
        super(str, th2 == null ? new NullPointerException() : th2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnErrorNotImplementedException(Throwable th2) {
        super(th2 != null ? th2.getMessage() : null, th2 == null ? new NullPointerException() : th2);
    }
}
