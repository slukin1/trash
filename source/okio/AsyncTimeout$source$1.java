package okio;

import java.io.IOException;
import kotlin.Unit;

public final class AsyncTimeout$source$1 implements Source {
    public final /* synthetic */ Source $source;
    public final /* synthetic */ AsyncTimeout this$0;

    public AsyncTimeout$source$1(AsyncTimeout asyncTimeout, Source source) {
        this.this$0 = asyncTimeout;
        this.$source = source;
    }

    public void close() {
        AsyncTimeout asyncTimeout = this.this$0;
        Source source = this.$source;
        asyncTimeout.enter();
        try {
            source.close();
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

    public long read(Buffer buffer, long j11) {
        AsyncTimeout asyncTimeout = this.this$0;
        Source source = this.$source;
        asyncTimeout.enter();
        try {
            long read = source.read(buffer, j11);
            if (!asyncTimeout.exit()) {
                return read;
            }
            throw asyncTimeout.access$newTimeoutException((IOException) null);
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
        return "AsyncTimeout.source(" + this.$source + ')';
    }

    public AsyncTimeout timeout() {
        return this.this$0;
    }
}
