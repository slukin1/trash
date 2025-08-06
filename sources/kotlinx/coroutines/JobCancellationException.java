package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.x;

public final class JobCancellationException extends CancellationException implements c0<JobCancellationException> {
    public final transient n1 job;

    public JobCancellationException(String str, Throwable th2, n1 n1Var) {
        super(str);
        this.job = n1Var;
        if (th2 != null) {
            initCause(th2);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!x.b(jobCancellationException.getMessage(), getMessage()) || !x.b(jobCancellationException.job, this.job) || !x.b(jobCancellationException.getCause(), getCause())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public Throwable fillInStackTrace() {
        if (j0.c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        int hashCode = ((getMessage().hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    public String toString() {
        return super.toString() + "; job=" + this.job;
    }

    public JobCancellationException createCopy() {
        if (j0.c()) {
            return new JobCancellationException(getMessage(), this, this.job);
        }
        return null;
    }
}
