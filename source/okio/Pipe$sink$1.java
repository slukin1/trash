package okio;

import com.huobi.points.entity.PointsPack;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

public final class Pipe$sink$1 implements Sink {
    public final /* synthetic */ Pipe this$0;
    private final Timeout timeout = new Timeout();

    public Pipe$sink$1(Pipe pipe) {
        this.this$0 = pipe;
    }

    public void close() {
        ReentrantLock lock = this.this$0.getLock();
        Pipe pipe = this.this$0;
        lock.lock();
        try {
            if (!pipe.getSinkClosed$okio()) {
                Sink foldedSink$okio = pipe.getFoldedSink$okio();
                if (foldedSink$okio == null) {
                    if (pipe.getSourceClosed$okio()) {
                        if (pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    pipe.setSinkClosed$okio(true);
                    pipe.getCondition().signalAll();
                    foldedSink$okio = null;
                }
                Unit unit = Unit.f56620a;
                lock.unlock();
                if (foldedSink$okio != null) {
                    Pipe pipe2 = this.this$0;
                    Timeout timeout2 = foldedSink$okio.timeout();
                    Timeout timeout3 = pipe2.sink().timeout();
                    long timeoutNanos = timeout2.timeoutNanos();
                    long minTimeout = Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos());
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    timeout2.timeout(minTimeout, timeUnit);
                    if (timeout2.hasDeadline()) {
                        long deadlineNanoTime = timeout2.deadlineNanoTime();
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.close();
                            timeout2.timeout(timeoutNanos, timeUnit);
                            if (timeout3.hasDeadline()) {
                                timeout2.deadlineNanoTime(deadlineNanoTime);
                            }
                        } catch (Throwable th2) {
                            timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout3.hasDeadline()) {
                                timeout2.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th2;
                        }
                    } else {
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                        }
                        try {
                            foldedSink$okio.close();
                            timeout2.timeout(timeoutNanos, timeUnit);
                            if (timeout3.hasDeadline()) {
                                timeout2.clearDeadline();
                            }
                        } catch (Throwable th3) {
                            timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout3.hasDeadline()) {
                                timeout2.clearDeadline();
                            }
                            throw th3;
                        }
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void flush() {
        ReentrantLock lock = this.this$0.getLock();
        Pipe pipe = this.this$0;
        lock.lock();
        try {
            if (!(!pipe.getSinkClosed$okio())) {
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            } else if (!pipe.getCanceled$okio()) {
                Sink foldedSink$okio = pipe.getFoldedSink$okio();
                if (foldedSink$okio == null) {
                    if (pipe.getSourceClosed$okio()) {
                        if (pipe.getBuffer$okio().size() > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    foldedSink$okio = null;
                }
                Unit unit = Unit.f56620a;
                if (foldedSink$okio != null) {
                    Pipe pipe2 = this.this$0;
                    Timeout timeout2 = foldedSink$okio.timeout();
                    Timeout timeout3 = pipe2.sink().timeout();
                    long timeoutNanos = timeout2.timeoutNanos();
                    long minTimeout = Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos());
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    timeout2.timeout(minTimeout, timeUnit);
                    if (timeout2.hasDeadline()) {
                        long deadlineNanoTime = timeout2.deadlineNanoTime();
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.flush();
                            timeout2.timeout(timeoutNanos, timeUnit);
                            if (timeout3.hasDeadline()) {
                                timeout2.deadlineNanoTime(deadlineNanoTime);
                            }
                        } catch (Throwable th2) {
                            timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout3.hasDeadline()) {
                                timeout2.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th2;
                        }
                    } else {
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                        }
                        try {
                            foldedSink$okio.flush();
                            timeout2.timeout(timeoutNanos, timeUnit);
                            if (timeout3.hasDeadline()) {
                                timeout2.clearDeadline();
                            }
                        } catch (Throwable th3) {
                            timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout3.hasDeadline()) {
                                timeout2.clearDeadline();
                            }
                            throw th3;
                        }
                    }
                }
            } else {
                throw new IOException("canceled");
            }
        } finally {
            lock.unlock();
        }
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public void write(Buffer buffer, long j11) {
        Sink sink;
        ReentrantLock lock = this.this$0.getLock();
        Pipe pipe = this.this$0;
        lock.lock();
        try {
            if (!(!pipe.getSinkClosed$okio())) {
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            } else if (!pipe.getCanceled$okio()) {
                while (true) {
                    if (j11 <= 0) {
                        sink = null;
                        break;
                    }
                    sink = pipe.getFoldedSink$okio();
                    if (sink != null) {
                        break;
                    } else if (!pipe.getSourceClosed$okio()) {
                        long maxBufferSize$okio = pipe.getMaxBufferSize$okio() - pipe.getBuffer$okio().size();
                        if (maxBufferSize$okio == 0) {
                            this.timeout.awaitSignal(pipe.getCondition());
                            if (pipe.getCanceled$okio()) {
                                throw new IOException("canceled");
                            }
                        } else {
                            long min = Math.min(maxBufferSize$okio, j11);
                            pipe.getBuffer$okio().write(buffer, min);
                            j11 -= min;
                            pipe.getCondition().signalAll();
                        }
                    } else {
                        throw new IOException("source is closed");
                    }
                }
                Unit unit = Unit.f56620a;
                if (sink != null) {
                    Pipe pipe2 = this.this$0;
                    Timeout timeout2 = sink.timeout();
                    Timeout timeout3 = pipe2.sink().timeout();
                    long timeoutNanos = timeout2.timeoutNanos();
                    long minTimeout = Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos());
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    timeout2.timeout(minTimeout, timeUnit);
                    if (timeout2.hasDeadline()) {
                        long deadlineNanoTime = timeout2.deadlineNanoTime();
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                        }
                        try {
                            sink.write(buffer, j11);
                            timeout2.timeout(timeoutNanos, timeUnit);
                            if (timeout3.hasDeadline()) {
                                timeout2.deadlineNanoTime(deadlineNanoTime);
                            }
                        } catch (Throwable th2) {
                            timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout3.hasDeadline()) {
                                timeout2.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th2;
                        }
                    } else {
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                        }
                        try {
                            sink.write(buffer, j11);
                            timeout2.timeout(timeoutNanos, timeUnit);
                            if (timeout3.hasDeadline()) {
                                timeout2.clearDeadline();
                            }
                        } catch (Throwable th3) {
                            timeout2.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout3.hasDeadline()) {
                                timeout2.clearDeadline();
                            }
                            throw th3;
                        }
                    }
                }
            } else {
                throw new IOException("canceled");
            }
        } finally {
            lock.unlock();
        }
    }
}
