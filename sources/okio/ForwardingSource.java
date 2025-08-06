package okio;

import java.io.IOException;

public abstract class ForwardingSource implements Source {
    private final Source delegate;

    public ForwardingSource(Source source) {
        this.delegate = source;
    }

    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final Source m3235deprecated_delegate() {
        return this.delegate;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final Source delegate() {
        return this.delegate;
    }

    public long read(Buffer buffer, long j11) throws IOException {
        return this.delegate.read(buffer, j11);
    }

    public Timeout timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
