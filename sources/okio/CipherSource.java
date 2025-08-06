package okio;

import com.huobi.points.entity.PointsPack;
import java.io.IOException;
import javax.crypto.Cipher;

public final class CipherSource implements Source {
    private final int blockSize;
    private final Buffer buffer = new Buffer();
    private final Cipher cipher;
    private boolean closed;

    /* renamed from: final  reason: not valid java name */
    private boolean f3456final;
    private final BufferedSource source;

    public CipherSource(BufferedSource bufferedSource, Cipher cipher2) {
        this.source = bufferedSource;
        this.cipher = cipher2;
        int blockSize2 = cipher2.getBlockSize();
        this.blockSize = blockSize2;
        if (!(blockSize2 > 0)) {
            throw new IllegalArgumentException(("Block cipher required " + cipher2).toString());
        }
    }

    private final void doFinal() {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize != 0) {
            Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
            int doFinal = this.cipher.doFinal(writableSegment$okio.data, writableSegment$okio.pos);
            writableSegment$okio.limit += doFinal;
            Buffer buffer2 = this.buffer;
            buffer2.setSize$okio(buffer2.size() + ((long) doFinal));
            if (writableSegment$okio.pos == writableSegment$okio.limit) {
                this.buffer.head = writableSegment$okio.pop();
                SegmentPool.recycle(writableSegment$okio);
            }
        }
    }

    private final void refill() {
        while (this.buffer.size() == 0 && !this.f3456final) {
            if (this.source.exhausted()) {
                this.f3456final = true;
                doFinal();
                return;
            }
            update();
        }
    }

    private final void update() {
        Segment segment = this.source.getBuffer().head;
        int i11 = segment.limit - segment.pos;
        int outputSize = this.cipher.getOutputSize(i11);
        while (outputSize > 8192) {
            int i12 = this.blockSize;
            if (i11 <= i12) {
                this.f3456final = true;
                this.buffer.write(this.cipher.doFinal(this.source.readByteArray()));
                return;
            }
            i11 -= i12;
            outputSize = this.cipher.getOutputSize(i11);
        }
        Segment writableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int update = this.cipher.update(segment.data, segment.pos, i11, writableSegment$okio.data, writableSegment$okio.pos);
        this.source.skip((long) i11);
        writableSegment$okio.limit += update;
        Buffer buffer2 = this.buffer;
        buffer2.setSize$okio(buffer2.size() + ((long) update));
        if (writableSegment$okio.pos == writableSegment$okio.limit) {
            this.buffer.head = writableSegment$okio.pop();
            SegmentPool.recycle(writableSegment$okio);
        }
    }

    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public long read(Buffer buffer2, long j11) throws IOException {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        } else if (!(true ^ this.closed)) {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        } else if (i11 == 0) {
            return 0;
        } else {
            refill();
            return this.buffer.read(buffer2, j11);
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }
}
