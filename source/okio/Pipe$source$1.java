package okio;

import com.huobi.points.entity.PointsPack;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;

public final class Pipe$source$1 implements Source {
    public final /* synthetic */ Pipe this$0;
    private final Timeout timeout = new Timeout();

    public Pipe$source$1(Pipe pipe) {
        this.this$0 = pipe;
    }

    public void close() {
        ReentrantLock lock = this.this$0.getLock();
        Pipe pipe = this.this$0;
        lock.lock();
        try {
            pipe.setSourceClosed$okio(true);
            pipe.getCondition().signalAll();
            Unit unit = Unit.f56620a;
        } finally {
            lock.unlock();
        }
    }

    public long read(Buffer buffer, long j11) {
        ReentrantLock lock = this.this$0.getLock();
        Pipe pipe = this.this$0;
        lock.lock();
        try {
            if (!(!pipe.getSourceClosed$okio())) {
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            } else if (!pipe.getCanceled$okio()) {
                while (pipe.getBuffer$okio().size() == 0) {
                    if (pipe.getSinkClosed$okio()) {
                        return -1;
                    }
                    this.timeout.awaitSignal(pipe.getCondition());
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                }
                long read = pipe.getBuffer$okio().read(buffer, j11);
                pipe.getCondition().signalAll();
                lock.unlock();
                return read;
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
}
