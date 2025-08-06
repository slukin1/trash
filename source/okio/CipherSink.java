package okio;

import com.huobi.points.entity.PointsPack;
import java.io.IOException;
import javax.crypto.Cipher;

public final class CipherSink implements Sink {
    private final int blockSize;
    private final Cipher cipher;
    private boolean closed;
    private final BufferedSink sink;

    public CipherSink(BufferedSink bufferedSink, Cipher cipher2) {
        this.sink = bufferedSink;
        this.cipher = cipher2;
        int blockSize2 = cipher2.getBlockSize();
        this.blockSize = blockSize2;
        if (!(blockSize2 > 0)) {
            throw new IllegalArgumentException(("Block cipher required " + cipher2).toString());
        }
    }

    private final Throwable doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        Throwable th2 = null;
        if (outputSize == 0) {
            return null;
        }
        if (outputSize > 8192) {
            try {
                this.sink.write(this.cipher.doFinal());
                return null;
            } catch (Throwable th3) {
                return th3;
            }
        } else {
            Buffer buffer = this.sink.getBuffer();
            Segment writableSegment$okio = buffer.writableSegment$okio(outputSize);
            try {
                int doFinal = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.limit);
                writableSegment$okio.limit += doFinal;
                buffer.setSize$okio(buffer.size() + ((long) doFinal));
            } catch (Throwable th4) {
                th2 = th4;
            }
            if (writableSegment$okio.pos == writableSegment$okio.limit) {
                buffer.head = writableSegment$okio.pop();
                SegmentPool.recycle(writableSegment$okio);
            }
            return th2;
        }
    }

    private final int update(Buffer buffer, long j11) {
        Segment segment = buffer.head;
        int min = (int) Math.min(j11, (long) (segment.limit - segment.pos));
        Buffer buffer2 = this.sink.getBuffer();
        int outputSize = this.cipher.getOutputSize(min);
        while (outputSize > 8192) {
            int i11 = this.blockSize;
            if (min <= i11) {
                this.sink.write(this.cipher.update(buffer.readByteArray(j11)));
                return (int) j11;
            }
            min -= i11;
            outputSize = this.cipher.getOutputSize(min);
        }
        Segment writableSegment$okio = buffer2.writableSegment$okio(outputSize);
        int update = this.cipher.update(segment.data, segment.pos, min, writableSegment$okio.data, writableSegment$okio.limit);
        writableSegment$okio.limit += update;
        buffer2.setSize$okio(buffer2.size() + ((long) update));
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            buffer2.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
        this.sink.emitCompleteSegments();
        buffer.setSize$okio(buffer.size() - ((long) min));
        int i12 = segment.pos + min;
        segment.pos = i12;
        if (i12 == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            Throwable doFinal = doFinal();
            try {
                this.sink.close();
            } catch (Throwable th2) {
                if (doFinal == null) {
                    doFinal = th2;
                }
            }
            if (doFinal != null) {
                throw doFinal;
            }
        }
    }

    public void flush() {
        this.sink.flush();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public void write(Buffer buffer, long j11) throws IOException {
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0, j11);
        if (!this.closed) {
            while (j11 > 0) {
                j11 -= (long) update(buffer, j11);
            }
            return;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }
}
