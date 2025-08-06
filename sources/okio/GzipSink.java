package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc = new CRC32();
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final RealBufferedSink sink;

    public GzipSink(Sink sink2) {
        RealBufferedSink realBufferedSink = new RealBufferedSink(sink2);
        this.sink = realBufferedSink;
        Deflater deflater2 = new Deflater(-1, true);
        this.deflater = deflater2;
        this.deflaterSink = new DeflaterSink((BufferedSink) realBufferedSink, deflater2);
        Buffer buffer = realBufferedSink.bufferField;
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    private final void updateCrc(Buffer buffer, long j11) {
        Segment segment = buffer.head;
        while (j11 > 0) {
            int min = (int) Math.min(j11, (long) (segment.limit - segment.pos));
            this.crc.update(segment.data, segment.pos, min);
            j11 -= (long) min;
            segment = segment.next;
        }
    }

    private final void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    /* renamed from: -deprecated_deflater  reason: not valid java name */
    public final Deflater m3236deprecated_deflater() {
        return this.deflater;
    }

    public void close() throws IOException {
        if (!this.closed) {
            Throwable th2 = null;
            try {
                this.deflaterSink.finishDeflate$okio();
                writeFooter();
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

    public final Deflater deflater() {
        return this.deflater;
    }

    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public void write(Buffer buffer, long j11) throws IOException {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        } else if (i11 != 0) {
            updateCrc(buffer, j11);
            this.deflaterSink.write(buffer, j11);
        }
    }
}
