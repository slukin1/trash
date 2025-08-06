package rx.exceptions;

public final class UnsubscribeFailedException extends RuntimeException {
    private static final long serialVersionUID = 4594672310593167598L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnsubscribeFailedException(Throwable th2) {
        super(th2 == null ? new NullPointerException() : th2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnsubscribeFailedException(String str, Throwable th2) {
        super(str, th2 == null ? new NullPointerException() : th2);
    }
}
