package okio;

import d10.l;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.InlineMarker;

public final class Pipe {
    private final Buffer buffer = new Buffer();
    private boolean canceled;
    private final Condition condition;
    private Sink foldedSink;
    private final ReentrantLock lock;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j11) {
        this.maxBufferSize = j11;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        if (j11 >= 1) {
            this.sink = new Pipe$sink$1(this);
            this.source = new Pipe$source$1(this);
            return;
        }
        throw new IllegalArgumentException(("maxBufferSize < 1: " + j11).toString());
    }

    private final void forward(Sink sink2, l<? super Sink, Unit> lVar) {
        Timeout timeout = sink2.timeout();
        Timeout timeout2 = sink().timeout();
        long timeoutNanos = timeout.timeoutNanos();
        long minTimeout = Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(minTimeout, timeUnit);
        if (timeout.hasDeadline()) {
            long deadlineNanoTime = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                lVar.invoke(sink2);
                Unit unit = Unit.f56620a;
                InlineMarker.b(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                InlineMarker.a(1);
            } catch (Throwable th2) {
                InlineMarker.b(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(deadlineNanoTime);
                }
                InlineMarker.a(1);
                throw th2;
            }
        } else {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                lVar.invoke(sink2);
                Unit unit2 = Unit.f56620a;
                InlineMarker.b(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.a(1);
            } catch (Throwable th3) {
                InlineMarker.b(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.a(1);
                throw th3;
            }
        }
    }

    /* renamed from: -deprecated_sink  reason: not valid java name */
    public final Sink m3239deprecated_sink() {
        return this.sink;
    }

    /* renamed from: -deprecated_source  reason: not valid java name */
    public final Source m3240deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.canceled = true;
            this.buffer.clear();
            this.condition.signalAll();
            Unit unit = Unit.f56620a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void fold(Sink sink2) throws IOException {
        ReentrantLock reentrantLock;
        while (true) {
            ReentrantLock reentrantLock2 = this.lock;
            reentrantLock2.lock();
            try {
                if (!(this.foldedSink == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                } else if (this.canceled) {
                    this.foldedSink = sink2;
                    throw new IOException("canceled");
                } else if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink2;
                    reentrantLock2.unlock();
                    return;
                } else {
                    boolean z11 = this.sinkClosed;
                    Buffer buffer2 = new Buffer();
                    Buffer buffer3 = this.buffer;
                    buffer2.write(buffer3, buffer3.size());
                    this.condition.signalAll();
                    Unit unit = Unit.f56620a;
                    try {
                        sink2.write(buffer2, buffer2.size());
                        if (z11) {
                            sink2.close();
                        } else {
                            sink2.flush();
                        }
                    } catch (Throwable th2) {
                        reentrantLock.unlock();
                        throw th2;
                    }
                }
            } finally {
                reentrantLock2.unlock();
            }
        }
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean z11) {
        this.canceled = z11;
    }

    public final void setFoldedSink$okio(Sink sink2) {
        this.foldedSink = sink2;
    }

    public final void setSinkClosed$okio(boolean z11) {
        this.sinkClosed = z11;
    }

    public final void setSourceClosed$okio(boolean z11) {
        this.sourceClosed = z11;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
