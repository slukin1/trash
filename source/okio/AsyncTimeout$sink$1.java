package okio;

import java.io.IOException;
import kotlin.Unit;

public final class AsyncTimeout$sink$1 implements Sink {
    public final /* synthetic */ Sink $sink;
    public final /* synthetic */ AsyncTimeout this$0;

    public AsyncTimeout$sink$1(AsyncTimeout asyncTimeout, Sink sink) {
        this.this$0 = asyncTimeout;
        this.$sink = sink;
    }

    public void close() {
        AsyncTimeout asyncTimeout = this.this$0;
        Sink sink = this.$sink;
        asyncTimeout.enter();
        try {
            sink.close();
            Unit unit = Unit.f56620a;
            if (asyncTimeout.exit()) {
                throw asyncTimeout.access$newTimeoutException((IOException) null);
            }
        } catch (IOException e11) {
            e = e11;
            if (asyncTimeout.exit()) {
                e = asyncTimeout.access$newTimeoutException(e);
            }
            throw e;
        } finally {
            boolean exit = asyncTimeout.exit();
        }
    }

    public void flush() {
        AsyncTimeout asyncTimeout = this.this$0;
        Sink sink = this.$sink;
        asyncTimeout.enter();
        try {
            sink.flush();
            Unit unit = Unit.f56620a;
            if (asyncTimeout.exit()) {
                throw asyncTimeout.access$newTimeoutException((IOException) null);
            }
        } catch (IOException e11) {
            e = e11;
            if (asyncTimeout.exit()) {
                e = asyncTimeout.access$newTimeoutException(e);
            }
            throw e;
        } finally {
            boolean exit = asyncTimeout.exit();
        }
    }

    public String toString() {
        return "AsyncTimeout.sink(" + this.$sink + ')';
    }

    public void write(Buffer buffer, long j11) {
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0, j11);
        while (true) {
            long j12 = 0;
            if (j11 > 0) {
                Segment segment = buffer.head;
                while (true) {
                    if (j12 >= 65536) {
                        break;
                    }
                    j12 += (long) (segment.limit - segment.pos);
                    if (j12 >= j11) {
                        j12 = j11;
                        break;
                    }
                    segment = segment.next;
                }
                AsyncTimeout asyncTimeout = this.this$0;
                Sink sink = this.$sink;
                asyncTimeout.enter();
                try {
                    sink.write(buffer, j12);
                    Unit unit = Unit.f56620a;
                    if (!asyncTimeout.exit()) {
                        j11 -= j12;
                    } else {
                        throw asyncTimeout.access$newTimeoutException((IOException) null);
                    }
                } catch (IOException e11) {
                    e = e11;
                    if (asyncTimeout.exit()) {
                        e = asyncTimeout.access$newTimeoutException(e);
                    }
                    throw e;
                } finally {
                    boolean exit = asyncTimeout.exit();
                }
            } else {
                return;
            }
        }
    }

    public AsyncTimeout timeout() {
        return this.this$0;
    }
}
