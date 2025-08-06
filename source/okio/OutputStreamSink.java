package okio;

import java.io.OutputStream;

final class OutputStreamSink implements Sink {
    private final OutputStream out;
    private final Timeout timeout;

    public OutputStreamSink(OutputStream outputStream, Timeout timeout2) {
        this.out = outputStream;
        this.timeout = timeout2;
    }

    public void close() {
        this.out.close();
    }

    public void flush() {
        this.out.flush();
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }

    public void write(Buffer buffer, long j11) {
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0, j11);
        while (j11 > 0) {
            this.timeout.throwIfReached();
            Segment segment = buffer.head;
            int min = (int) Math.min(j11, (long) (segment.limit - segment.pos));
            this.out.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j12 = (long) min;
            j11 -= j12;
            buffer.setSize$okio(buffer.size() - j12);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }
}
