package okio;

import com.tencent.android.tpush.common.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class GzipSource implements Source {
    private final CRC32 crc = new CRC32();
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(Source source2) {
        RealBufferedSource realBufferedSource = new RealBufferedSource(source2);
        this.source = realBufferedSource;
        Inflater inflater2 = new Inflater(true);
        this.inflater = inflater2;
        this.inflaterSource = new InflaterSource((BufferedSource) realBufferedSource, inflater2);
    }

    private final void checkEqual(String str, int i11, int i12) {
        if (i12 != i11) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i12), Integer.valueOf(i11)}, 3)));
        }
    }

    private final void consumeHeader() throws IOException {
        this.source.require(10);
        byte b11 = this.source.bufferField.getByte(3);
        boolean z11 = true;
        boolean z12 = ((b11 >> 1) & 1) == 1;
        if (z12) {
            updateCrc(this.source.bufferField, 0, 10);
        }
        checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8);
        if (((b11 >> 2) & 1) == 1) {
            this.source.require(2);
            if (z12) {
                updateCrc(this.source.bufferField, 0, 2);
            }
            long readShortLe = (long) (this.source.bufferField.readShortLe() & Constants.PROTOCOL_NONE);
            this.source.require(readShortLe);
            if (z12) {
                updateCrc(this.source.bufferField, 0, readShortLe);
            }
            this.source.skip(readShortLe);
        }
        if (((b11 >> 3) & 1) == 1) {
            long indexOf = this.source.indexOf((byte) 0);
            if (indexOf != -1) {
                if (z12) {
                    updateCrc(this.source.bufferField, 0, indexOf + 1);
                }
                this.source.skip(indexOf + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b11 >> 4) & 1) != 1) {
            z11 = false;
        }
        if (z11) {
            long indexOf2 = this.source.indexOf((byte) 0);
            if (indexOf2 != -1) {
                if (z12) {
                    updateCrc(this.source.bufferField, 0, indexOf2 + 1);
                }
                this.source.skip(indexOf2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z12) {
            checkEqual("FHCRC", this.source.readShortLe(), (short) ((int) this.crc.getValue()));
            this.crc.reset();
        }
    }

    private final void consumeTrailer() throws IOException {
        checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
        checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
    }

    private final void updateCrc(Buffer buffer, long j11, long j12) {
        Segment segment = buffer.head;
        while (true) {
            int i11 = segment.limit;
            int i12 = segment.pos;
            if (j11 < ((long) (i11 - i12))) {
                break;
            }
            j11 -= (long) (i11 - i12);
            segment = segment.next;
        }
        while (j12 > 0) {
            int i13 = (int) (((long) segment.pos) + j11);
            int min = (int) Math.min((long) (segment.limit - i13), j12);
            this.crc.update(segment.data, i13, min);
            j12 -= (long) min;
            segment = segment.next;
            j11 = 0;
        }
    }

    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public long read(Buffer buffer, long j11) throws IOException {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        } else if (i11 == 0) {
            return 0;
        } else {
            if (this.section == 0) {
                consumeHeader();
                this.section = 1;
            }
            if (this.section == 1) {
                long size = buffer.size();
                long read = this.inflaterSource.read(buffer, j11);
                if (read != -1) {
                    updateCrc(buffer, size, read);
                    return read;
                }
                this.section = 2;
            }
            if (this.section == 2) {
                consumeTrailer();
                this.section = 3;
                if (!this.source.exhausted()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }
}
