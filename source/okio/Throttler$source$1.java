package okio;

import java.io.InterruptedIOException;

public final class Throttler$source$1 extends ForwardingSource {
    public final /* synthetic */ Throttler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Throttler$source$1(Source source, Throttler throttler) {
        super(source);
        this.this$0 = throttler;
    }

    public long read(Buffer buffer, long j11) {
        try {
            return super.read(buffer, this.this$0.take$okio(j11));
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
