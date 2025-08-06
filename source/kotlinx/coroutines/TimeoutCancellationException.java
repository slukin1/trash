package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

public final class TimeoutCancellationException extends CancellationException implements c0<TimeoutCancellationException> {
    public final transient n1 coroutine;

    public TimeoutCancellationException(String str, n1 n1Var) {
        super(str);
        this.coroutine = n1Var;
    }

    public TimeoutCancellationException createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.coroutine);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }

    public TimeoutCancellationException(String str) {
        this(str, (n1) null);
    }
}
