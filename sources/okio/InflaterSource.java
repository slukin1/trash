package okio;

import com.huobi.points.entity.PointsPack;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater2) {
        this.source = bufferedSource;
        this.inflater = inflater2;
    }

    private final void releaseBytesAfterInflate() {
        int i11 = this.bufferBytesHeldByInflater;
        if (i11 != 0) {
            int remaining = i11 - this.inflater.getRemaining();
            this.bufferBytesHeldByInflater -= remaining;
            this.source.skip((long) remaining);
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.inflater.end();
            this.closed = true;
            this.source.close();
        }
    }

    public long read(Buffer buffer, long j11) throws IOException {
        do {
            long readOrInflate = readOrInflate(buffer, j11);
            if (readOrInflate > 0) {
                return readOrInflate;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1;
            }
        } while (!this.source.exhausted());
        throw new EOFException("source exhausted prematurely");
    }

    public final long readOrInflate(Buffer buffer, long j11) throws IOException {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        } else if (!(!this.closed)) {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        } else if (i11 == 0) {
            return 0;
        } else {
            try {
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                refill();
                int inflate = this.inflater.inflate(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j11, (long) (8192 - writableSegment$okio.limit)));
                releaseBytesAfterInflate();
                if (inflate > 0) {
                    writableSegment$okio.limit += inflate;
                    long j12 = (long) inflate;
                    buffer.setSize$okio(buffer.size() + j12);
                    return j12;
                }
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    buffer.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                return 0;
            } catch (DataFormatException e11) {
                throw new IOException(e11);
            }
        }
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment segment = this.source.getBuffer().head;
        int i11 = segment.limit;
        int i12 = segment.pos;
        int i13 = i11 - i12;
        this.bufferBytesHeldByInflater = i13;
        this.inflater.setInput(segment.data, i12, i13);
        return false;
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    public InflaterSource(Source source2, Inflater inflater2) {
        this(Okio.buffer(source2), inflater2);
    }
}
