package rx.exceptions;

public final class OnCompletedFailedException extends RuntimeException {
    private static final long serialVersionUID = 8622579378868820554L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnCompletedFailedException(Throwable th2) {
        super(th2 == null ? new NullPointerException() : th2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnCompletedFailedException(String str, Throwable th2) {
        super(str, th2 == null ? new NullPointerException() : th2);
    }
}
