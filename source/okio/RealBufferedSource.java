package okio;

import com.huobi.points.entity.PointsPack;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import net.sf.scuba.smartcards.ISO7816;
import okio.internal.Buffer;

public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField = new Buffer();
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source source2) {
        this.source = source2;
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    public Buffer buffer() {
        return this.bufferField;
    }

    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.bufferField.clear();
        }
    }

    public boolean exhausted() {
        if (!(!this.closed)) {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        } else if (!this.bufferField.exhausted() || this.source.read(this.bufferField, 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public Buffer getBuffer() {
        return this.bufferField;
    }

    public long indexOf(byte b11) {
        return indexOf(b11, 0, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new RealBufferedSource$inputStream$1(this);
    }

    public boolean isOpen() {
        return !this.closed;
    }

    public BufferedSource peek() {
        return Okio.buffer((Source) new PeekSource(this));
    }

    public boolean rangeEquals(long j11, ByteString byteString) {
        return rangeEquals(j11, byteString, 0, byteString.size());
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public long readAll(Sink sink) {
        long j11 = 0;
        while (this.source.read(this.bufferField, 8192) != -1) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j11 += completeSegmentByteCount;
                sink.write(this.bufferField, completeSegmentByteCount);
            }
        }
        if (this.bufferField.size() <= 0) {
            return j11;
        }
        long size = j11 + this.bufferField.size();
        Buffer buffer = this.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public byte readByte() {
        require(1);
        return this.bufferField.readByte();
    }

    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    public long readDecimalLong() {
        int i11;
        require(1);
        long j11 = 0;
        while (true) {
            long j12 = j11 + 1;
            if (!request(j12)) {
                break;
            }
            byte b11 = this.bufferField.getByte(j11);
            if ((b11 >= 48 && b11 <= 57) || (j11 == 0 && b11 == 45)) {
                j11 = j12;
            } else if (i11 == 0) {
                throw new NumberFormatException("Expected a digit or '-' but was 0x" + Integer.toString(b11, CharsKt__CharJVMKt.a(CharsKt__CharJVMKt.a(16))));
            }
        }
        return this.bufferField.readDecimalLong();
    }

    public void readFully(byte[] bArr) {
        try {
            require((long) bArr.length);
            this.bufferField.readFully(bArr);
        } catch (EOFException e11) {
            int i11 = 0;
            while (this.bufferField.size() > 0) {
                Buffer buffer = this.bufferField;
                int read = buffer.read(bArr, i11, (int) buffer.size());
                if (read != -1) {
                    i11 += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e11;
        }
    }

    public long readHexadecimalUnsignedLong() {
        require(1);
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            if (!request((long) i12)) {
                break;
            }
            byte b11 = this.bufferField.getByte((long) i11);
            if ((b11 >= 48 && b11 <= 57) || ((b11 >= 97 && b11 <= 102) || (b11 >= 65 && b11 <= 70))) {
                i11 = i12;
            } else if (i11 == 0) {
                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toString(b11, CharsKt__CharJVMKt.a(CharsKt__CharJVMKt.a(16))));
            }
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    public int readInt() {
        require(4);
        return this.bufferField.readInt();
    }

    public int readIntLe() {
        require(4);
        return this.bufferField.readIntLe();
    }

    public long readLong() {
        require(8);
        return this.bufferField.readLong();
    }

    public long readLongLe() {
        require(8);
        return this.bufferField.readLongLe();
    }

    public short readShort() {
        require(2);
        return this.bufferField.readShort();
    }

    public short readShortLe() {
        require(2);
        return this.bufferField.readShortLe();
    }

    public String readString(long j11, Charset charset) {
        require(j11);
        return this.bufferField.readString(j11, charset);
    }

    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    public int readUtf8CodePoint() {
        require(1);
        byte b11 = this.bufferField.getByte(0);
        if ((b11 & ISO7816.INS_CREATE_FILE) == 192) {
            require(2);
        } else if ((b11 & 240) == 224) {
            require(3);
        } else if ((b11 & 248) == 240) {
            require(4);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return Buffer.readUtf8Line(this.bufferField, indexOf);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j11) {
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        } else if (!this.closed) {
            while (this.bufferField.size() < j11) {
                if (this.source.read(this.bufferField, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
    }

    public void require(long j11) {
        if (!request(j11)) {
            throw new EOFException();
        }
    }

    public int select(Options options) {
        if (!this.closed) {
            while (true) {
                int selectPrefix = Buffer.selectPrefix(this.bufferField, options, true);
                if (selectPrefix == -2) {
                    if (this.source.read(this.bufferField, 8192) == -1) {
                        break;
                    }
                } else if (selectPrefix != -1) {
                    this.bufferField.skip((long) options.getByteStrings$okio()[selectPrefix].size());
                    return selectPrefix;
                }
            }
            return -1;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public void skip(long j11) {
        if (!this.closed) {
            while (j11 > 0) {
                if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j11, this.bufferField.size());
                this.bufferField.skip(min);
                j11 -= min;
            }
            return;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }

    public long indexOf(byte b11, long j11) {
        return indexOf(b11, j11, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString, long j11) {
        if (!this.closed) {
            while (true) {
                long indexOfElement = this.bufferField.indexOfElement(byteString, j11);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                long size = this.bufferField.size();
                if (this.source.read(this.bufferField, 8192) == -1) {
                    return -1;
                }
                j11 = Math.max(j11, size);
            }
        } else {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
    }

    public long read(Buffer buffer, long j11) {
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        } else if (!(!this.closed)) {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        } else if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
            return -1;
        } else {
            return this.bufferField.read(buffer, Math.min(j11, this.bufferField.size()));
        }
    }

    public String readUtf8LineStrict(long j11) {
        if (j11 >= 0) {
            long j12 = j11 == Long.MAX_VALUE ? Long.MAX_VALUE : j11 + 1;
            long indexOf = indexOf((byte) 10, 0, j12);
            if (indexOf != -1) {
                return Buffer.readUtf8Line(this.bufferField, indexOf);
            }
            if (j12 < Long.MAX_VALUE && request(j12) && this.bufferField.getByte(j12 - 1) == 13 && request(1 + j12) && this.bufferField.getByte(j12) == 10) {
                return Buffer.readUtf8Line(this.bufferField, j12);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.bufferField;
            buffer2.copyTo(buffer, 0, Math.min((long) 32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), j11) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j11).toString());
    }

    public long indexOf(ByteString byteString) {
        return indexOf(byteString, 0);
    }

    public boolean rangeEquals(long j11, ByteString byteString, int i11, int i12) {
        if (!this.closed) {
            if (j11 >= 0 && i11 >= 0 && i12 >= 0 && byteString.size() - i11 >= i12) {
                int i13 = 0;
                while (i13 < i12) {
                    long j12 = ((long) i13) + j11;
                    if (request(1 + j12) && this.bufferField.getByte(j12) == byteString.getByte(i11 + i13)) {
                        i13++;
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public long indexOf(byte b11, long j11, long j12) {
        boolean z11 = true;
        if (!this.closed) {
            if (0 > j11 || j11 > j12) {
                z11 = false;
            }
            if (z11) {
                while (j11 < j12) {
                    long indexOf = this.bufferField.indexOf(b11, j11, j12);
                    if (indexOf != -1) {
                        return indexOf;
                    }
                    long size = this.bufferField.size();
                    if (size >= j12 || this.source.read(this.bufferField, 8192) == -1) {
                        return -1;
                    }
                    j11 = Math.max(j11, size);
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j11 + " toIndex=" + j12).toString());
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public String readString(Charset charset) {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    public byte[] readByteArray(long j11) {
        require(j11);
        return this.bufferField.readByteArray(j11);
    }

    public ByteString readByteString(long j11) {
        require(j11);
        return this.bufferField.readByteString(j11);
    }

    public String readUtf8(long j11) {
        require(j11);
        return this.bufferField.readUtf8(j11);
    }

    public void readFully(Buffer buffer, long j11) {
        try {
            require(j11);
            this.bufferField.readFully(buffer, j11);
        } catch (EOFException e11) {
            buffer.writeAll(this.bufferField);
            throw e11;
        }
    }

    public int read(byte[] bArr, int i11, int i12) {
        long j11 = (long) i12;
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i11, j11);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(bArr, i11, (int) Math.min(j11, this.bufferField.size()));
    }

    public long indexOf(ByteString byteString, long j11) {
        if (!this.closed) {
            while (true) {
                long indexOf = this.bufferField.indexOf(byteString, j11);
                if (indexOf != -1) {
                    return indexOf;
                }
                long size = this.bufferField.size();
                if (this.source.read(this.bufferField, 8192) == -1) {
                    return -1;
                }
                j11 = Math.max(j11, (size - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
    }

    public int read(ByteBuffer byteBuffer) {
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(byteBuffer);
    }
}
