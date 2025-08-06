package okio;

import java.io.IOException;
import java.io.InterruptedIOException;

public final class Throttler$sink$1 extends ForwardingSink {
    public final /* synthetic */ Throttler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Throttler$sink$1(Sink sink, Throttler throttler) {
        super(sink);
        this.this$0 = throttler;
    }

    public void write(Buffer buffer, long j11) throws IOException {
        while (j11 > 0) {
            try {
                long take$okio = this.this$0.take$okio(j11);
                super.write(buffer, take$okio);
                j11 -= take$okio;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException("interrupted");
            }
        }
    }
}
