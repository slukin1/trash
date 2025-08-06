package okio;

final class BlackholeSink implements Sink {
    public void close() {
    }

    public void flush() {
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void write(Buffer buffer, long j11) {
        buffer.skip(j11);
    }
}
