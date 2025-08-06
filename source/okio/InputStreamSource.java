package okio;

import java.io.IOException;
import java.io.InputStream;

class InputStreamSource implements Source {
    private final InputStream input;
    private final Timeout timeout;

    public InputStreamSource(InputStream inputStream, Timeout timeout2) {
        this.input = inputStream;
        this.timeout = timeout2;
    }

    public void close() {
        this.input.close();
    }

    public long read(Buffer buffer, long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 == 0) {
            return 0;
        }
        if (i11 >= 0) {
            try {
                this.timeout.throwIfReached();
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                int read = this.input.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j11, (long) (8192 - writableSegment$okio.limit)));
                if (read != -1) {
                    writableSegment$okio.limit += read;
                    long j12 = (long) read;
                    buffer.setSize$okio(buffer.size() + j12);
                    return j12;
                } else if (writableSegment$okio.pos != writableSegment$okio.limit) {
                    return -1;
                } else {
                    buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                    return -1;
                }
            } catch (AssertionError e11) {
                if (Okio.isAndroidGetsocknameError(e11)) {
                    throw new IOException(e11);
                }
                throw e11;
            }
        } else {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        }
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "source(" + this.input + ')';
    }
}
