package rx.exceptions;

public class OnErrorFailedException extends RuntimeException {
    private static final long serialVersionUID = -419289748403337611L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnErrorFailedException(String str, Throwable th2) {
        super(str, th2 == null ? new NullPointerException() : th2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnErrorFailedException(Throwable th2) {
        super(th2 != null ? th2.getMessage() : null, th2 == null ? new NullPointerException() : th2);
    }
}
