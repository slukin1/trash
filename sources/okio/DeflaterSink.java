package okio;

import java.io.IOException;
import java.util.zip.Deflater;

public final class DeflaterSink implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater2) {
        this.sink = bufferedSink;
        this.deflater = deflater2;
    }

    private final void deflate(boolean z11) {
        Segment writableSegment$okio;
        int i11;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            writableSegment$okio = buffer.writableSegment$okio(1);
            if (z11) {
                try {
                    Deflater deflater2 = this.deflater;
                    byte[] bArr = writableSegment$okio.data;
                    int i12 = writableSegment$okio.limit;
                    i11 = deflater2.deflate(bArr, i12, 8192 - i12, 2);
                } catch (NullPointerException e11) {
                    throw new IOException("Deflater already closed", e11);
                }
            } else {
                Deflater deflater3 = this.deflater;
                byte[] bArr2 = writableSegment$okio.data;
                int i13 = writableSegment$okio.limit;
                i11 = deflater3.deflate(bArr2, i13, 8192 - i13);
            }
            if (i11 > 0) {
                writableSegment$okio.limit += i11;
                buffer.setSize$okio(buffer.size() + ((long) i11));
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            Throwable th2 = null;
            try {
                finishDeflate$okio();
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.deflater.end();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                }
            }
            try {
                this.sink.close();
            } catch (Throwable th5) {
                if (th2 == null) {
                    th2 = th5;
                }
            }
            this.closed = true;
            if (th2 != null) {
                throw th2;
            }
        }
    }

    public final void finishDeflate$okio() {
        this.deflater.finish();
        deflate(false);
    }

    public void flush() throws IOException {
        deflate(true);
        this.sink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    public void write(Buffer buffer, long j11) throws IOException {
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0, j11);
        while (j11 > 0) {
            Segment segment = buffer.head;
            int min = (int) Math.min(j11, (long) (segment.limit - segment.pos));
            this.deflater.setInput(segment.data, segment.pos, min);
            deflate(false);
            long j12 = (long) min;
            buffer.setSize$okio(buffer.size() - j12);
            int i11 = segment.pos + min;
            segment.pos = i11;
            if (i11 == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            j11 -= j12;
        }
    }

    public DeflaterSink(Sink sink2, Deflater deflater2) {
        this(Okio.buffer(sink2), deflater2);
    }
}
