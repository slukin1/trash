package okio;

import com.huobi.points.entity.PointsPack;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField = new Buffer();
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink2) {
        this.sink = sink2;
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    public Buffer buffer() {
        return this.bufferField;
    }

    public void close() {
        if (!this.closed) {
            Throwable th2 = null;
            try {
                if (this.bufferField.size() > 0) {
                    Sink sink2 = this.sink;
                    Buffer buffer = this.bufferField;
                    sink2.write(buffer, buffer.size());
                }
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.sink.close();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                }
            }
            this.closed = true;
            if (th2 != null) {
                throw th2;
            }
        }
    }

    public BufferedSink emit() {
        if (!this.closed) {
            long size = this.bufferField.size();
            if (size > 0) {
                this.sink.write(this.bufferField, size);
            }
            return this;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink emitCompleteSegments() {
        if (!this.closed) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                this.sink.write(this.bufferField, completeSegmentByteCount);
            }
            return this;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public void flush() {
        if (!this.closed) {
            if (this.bufferField.size() > 0) {
                Sink sink2 = this.sink;
                Buffer buffer = this.bufferField;
                sink2.write(buffer, buffer.size());
            }
            this.sink.flush();
            return;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public Buffer getBuffer() {
        return this.bufferField;
    }

    public boolean isOpen() {
        return !this.closed;
    }

    public OutputStream outputStream() {
        return new RealBufferedSink$outputStream$1(this);
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        return "buffer(" + this.sink + ')';
    }

    public int write(ByteBuffer byteBuffer) {
        if (!this.closed) {
            int write = this.bufferField.write(byteBuffer);
            emitCompleteSegments();
            return write;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public long writeAll(Source source) {
        long j11 = 0;
        while (true) {
            long read = source.read(this.bufferField, 8192);
            if (read == -1) {
                return j11;
            }
            j11 += read;
            emitCompleteSegments();
        }
    }

    public BufferedSink writeByte(int i11) {
        if (!this.closed) {
            this.bufferField.writeByte(i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeDecimalLong(long j11) {
        if (!this.closed) {
            this.bufferField.writeDecimalLong(j11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeHexadecimalUnsignedLong(long j11) {
        if (!this.closed) {
            this.bufferField.writeHexadecimalUnsignedLong(j11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeInt(int i11) {
        if (!this.closed) {
            this.bufferField.writeInt(i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeIntLe(int i11) {
        if (!this.closed) {
            this.bufferField.writeIntLe(i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeLong(long j11) {
        if (!this.closed) {
            this.bufferField.writeLong(j11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeLongLe(long j11) {
        if (!this.closed) {
            this.bufferField.writeLongLe(j11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeShort(int i11) {
        if (!this.closed) {
            this.bufferField.writeShort(i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeShortLe(int i11) {
        if (!this.closed) {
            this.bufferField.writeShortLe(i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeString(String str, Charset charset) {
        if (!this.closed) {
            this.bufferField.writeString(str, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeUtf8(String str) {
        if (!this.closed) {
            this.bufferField.writeUtf8(str);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeUtf8CodePoint(int i11) {
        if (!this.closed) {
            this.bufferField.writeUtf8CodePoint(i11);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public void write(Buffer buffer, long j11) {
        if (!this.closed) {
            this.bufferField.write(buffer, j11);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeString(String str, int i11, int i12, Charset charset) {
        if (!this.closed) {
            this.bufferField.writeString(str, i11, i12, charset);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink writeUtf8(String str, int i11, int i12) {
        if (!this.closed) {
            this.bufferField.writeUtf8(str, i11, i12);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink write(ByteString byteString) {
        if (!this.closed) {
            this.bufferField.write(byteString);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink write(ByteString byteString, int i11, int i12) {
        if (!this.closed) {
            this.bufferField.write(byteString, i11, i12);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink write(byte[] bArr) {
        if (!this.closed) {
            this.bufferField.write(bArr);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink write(byte[] bArr, int i11, int i12) {
        if (!this.closed) {
            this.bufferField.write(bArr, i11, i12);
            return emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public BufferedSink write(Source source, long j11) {
        while (j11 > 0) {
            long read = source.read(this.bufferField, j11);
            if (read != -1) {
                j11 -= read;
                emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }
}
