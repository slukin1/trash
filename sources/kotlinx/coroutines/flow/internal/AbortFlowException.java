package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.j0;

public final class AbortFlowException extends CancellationException {
    public final transient e<?> owner;

    public AbortFlowException(e<?> eVar) {
        super("Flow was aborted, no more elements needed");
        this.owner = eVar;
    }

    public Throwable fillInStackTrace() {
        if (j0.c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
