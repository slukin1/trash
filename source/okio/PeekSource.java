package okio;

import com.huobi.points.entity.PointsPack;

public final class PeekSource implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource bufferedSource) {
        this.upstream = bufferedSource;
        Buffer buffer2 = bufferedSource.getBuffer();
        this.buffer = buffer2;
        Segment segment = buffer2.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    public void close() {
        this.closed = true;
    }

    public long read(Buffer buffer2, long j11) {
        Segment segment;
        Segment segment2;
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        boolean z11 = false;
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        } else if (!this.closed) {
            Segment segment3 = this.expectedSegment;
            if (segment3 == null || (segment3 == (segment2 = this.buffer.head) && this.expectedPos == segment2.pos)) {
                z11 = true;
            }
            if (!z11) {
                throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
            } else if (i11 == 0) {
                return 0;
            } else {
                if (!this.upstream.request(this.pos + 1)) {
                    return -1;
                }
                if (this.expectedSegment == null && (segment = this.buffer.head) != null) {
                    this.expectedSegment = segment;
                    this.expectedPos = segment.pos;
                }
                long min = Math.min(j11, this.buffer.size() - this.pos);
                this.buffer.copyTo(buffer2, this.pos, min);
                this.pos += min;
                return min;
            }
        } else {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
    }

    public Timeout timeout() {
        return this.upstream.timeout();
    }
}
