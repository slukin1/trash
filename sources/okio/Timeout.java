package okio;

import com.iproov.sdk.bridge.OptionsBridge;
import d10.a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.r;

public class Timeout {
    public static final Companion Companion = new Companion((r) null);
    public static final Timeout NONE = new Timeout$Companion$NONE$1();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final long minTimeout(long j11, long j12) {
            return (j11 != 0 && (j12 == 0 || j11 < j12)) ? j11 : j12;
        }
    }

    public final void awaitSignal(Condition condition) throws InterruptedIOException {
        try {
            boolean hasDeadline2 = hasDeadline();
            long timeoutNanos2 = timeoutNanos();
            long j11 = 0;
            if (hasDeadline2 || timeoutNanos2 != 0) {
                long nanoTime = System.nanoTime();
                if (hasDeadline2 && timeoutNanos2 != 0) {
                    timeoutNanos2 = Math.min(timeoutNanos2, deadlineNanoTime() - nanoTime);
                } else if (hasDeadline2) {
                    timeoutNanos2 = deadlineNanoTime() - nanoTime;
                }
                if (timeoutNanos2 > 0) {
                    condition.await(timeoutNanos2, TimeUnit.NANOSECONDS);
                    j11 = System.nanoTime() - nanoTime;
                }
                if (j11 >= timeoutNanos2) {
                    throw new InterruptedIOException(OptionsBridge.TIMEOUT_KEY);
                }
                return;
            }
            condition.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public final Timeout deadline(long j11, TimeUnit timeUnit) {
        if (j11 > 0) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j11));
        }
        throw new IllegalArgumentException(("duration <= 0: " + j11).toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(Timeout timeout, a<? extends T> aVar) {
        long timeoutNanos2 = timeoutNanos();
        long minTimeout = Companion.minTimeout(timeout.timeoutNanos(), timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(minTimeout, timeUnit);
        if (hasDeadline()) {
            long deadlineNanoTime2 = deadlineNanoTime();
            if (timeout.hasDeadline()) {
                deadlineNanoTime(Math.min(deadlineNanoTime(), timeout.deadlineNanoTime()));
            }
            try {
                T invoke = aVar.invoke();
                InlineMarker.b(1);
                timeout(timeoutNanos2, timeUnit);
                if (timeout.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime2);
                }
                InlineMarker.a(1);
                return invoke;
            } catch (Throwable th2) {
                InlineMarker.b(1);
                timeout(timeoutNanos2, TimeUnit.NANOSECONDS);
                if (timeout.hasDeadline()) {
                    deadlineNanoTime(deadlineNanoTime2);
                }
                InlineMarker.a(1);
                throw th2;
            }
        } else {
            if (timeout.hasDeadline()) {
                deadlineNanoTime(timeout.deadlineNanoTime());
            }
            try {
                T invoke2 = aVar.invoke();
                InlineMarker.b(1);
                timeout(timeoutNanos2, timeUnit);
                if (timeout.hasDeadline()) {
                    clearDeadline();
                }
                InlineMarker.a(1);
                return invoke2;
            } catch (Throwable th3) {
                InlineMarker.b(1);
                timeout(timeoutNanos2, TimeUnit.NANOSECONDS);
                if (timeout.hasDeadline()) {
                    clearDeadline();
                }
                InlineMarker.a(1);
                throw th3;
            }
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        } else if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout timeout(long j11, TimeUnit timeUnit) {
        if (j11 >= 0) {
            this.timeoutNanos = timeUnit.toNanos(j11);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j11).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedIOException {
        try {
            boolean hasDeadline2 = hasDeadline();
            long timeoutNanos2 = timeoutNanos();
            long j11 = 0;
            if (hasDeadline2 || timeoutNanos2 != 0) {
                long nanoTime = System.nanoTime();
                if (hasDeadline2 && timeoutNanos2 != 0) {
                    timeoutNanos2 = Math.min(timeoutNanos2, deadlineNanoTime() - nanoTime);
                } else if (hasDeadline2) {
                    timeoutNanos2 = deadlineNanoTime() - nanoTime;
                }
                if (timeoutNanos2 > 0) {
                    long j12 = timeoutNanos2 / 1000000;
                    Long.signum(j12);
                    obj.wait(j12, (int) (timeoutNanos2 - (1000000 * j12)));
                    j11 = System.nanoTime() - nanoTime;
                }
                if (j11 >= timeoutNanos2) {
                    throw new InterruptedIOException(OptionsBridge.TIMEOUT_KEY);
                }
                return;
            }
            obj.wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public Timeout deadlineNanoTime(long j11) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j11;
        return this;
    }
}
