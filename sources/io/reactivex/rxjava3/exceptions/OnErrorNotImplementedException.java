package io.reactivex.rxjava3.exceptions;

public final class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnErrorNotImplementedException(String str, Throwable th2) {
        super(str, th2 == null ? new NullPointerException() : th2);
    }

    public OnErrorNotImplementedException(Throwable th2) {
        this("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + th2, th2);
    }
}
