package okio.internal;

import com.huobi.points.entity.PointsPack;
import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* renamed from: okio.internal.-RealBufferedSink  reason: invalid class name */
public final class RealBufferedSink {
    public static final void commonClose(okio.RealBufferedSink realBufferedSink) {
        if (!realBufferedSink.closed) {
            Throwable th2 = null;
            try {
                if (realBufferedSink.bufferField.size() > 0) {
                    Sink sink = realBufferedSink.sink;
                    Buffer buffer = realBufferedSink.bufferField;
                    sink.write(buffer, buffer.size());
                }
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                realBufferedSink.sink.close();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                }
            }
            realBufferedSink.closed = true;
            if (th2 != null) {
                throw th2;
            }
        }
    }

    public static final BufferedSink commonEmit(okio.RealBufferedSink realBufferedSink) {
        if (!realBufferedSink.closed) {
            long size = realBufferedSink.bufferField.size();
            if (size > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, size);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonEmitCompleteSegments(okio.RealBufferedSink realBufferedSink) {
        if (!realBufferedSink.closed) {
            long completeSegmentByteCount = realBufferedSink.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, completeSegmentByteCount);
            }
            return realBufferedSink;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final void commonFlush(okio.RealBufferedSink realBufferedSink) {
        if (!realBufferedSink.closed) {
            if (realBufferedSink.bufferField.size() > 0) {
                Sink sink = realBufferedSink.sink;
                Buffer buffer = realBufferedSink.bufferField;
                sink.write(buffer, buffer.size());
            }
            realBufferedSink.sink.flush();
            return;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final Timeout commonTimeout(okio.RealBufferedSink realBufferedSink) {
        return realBufferedSink.sink.timeout();
    }

    public static final String commonToString(okio.RealBufferedSink realBufferedSink) {
        return "buffer(" + realBufferedSink.sink + ')';
    }

    public static final void commonWrite(okio.RealBufferedSink realBufferedSink, Buffer buffer, long j11) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(buffer, j11);
            realBufferedSink.emitCompleteSegments();
            return;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final long commonWriteAll(okio.RealBufferedSink realBufferedSink, Source source) {
        long j11 = 0;
        while (true) {
            long read = source.read(realBufferedSink.bufferField, 8192);
            if (read == -1) {
                return j11;
            }
            j11 += read;
            realBufferedSink.emitCompleteSegments();
        }
    }

    public static final BufferedSink commonWriteByte(okio.RealBufferedSink realBufferedSink, int i11) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeByte(i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWriteDecimalLong(okio.RealBufferedSink realBufferedSink, long j11) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeDecimalLong(j11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(okio.RealBufferedSink realBufferedSink, long j11) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWriteInt(okio.RealBufferedSink realBufferedSink, int i11) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeInt(i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWriteIntLe(okio.RealBufferedSink realBufferedSink, int i11) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeIntLe(i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWriteLong(okio.RealBufferedSink realBufferedSink, long j11) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeLong(j11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWriteLongLe(okio.RealBufferedSink realBufferedSink, long j11) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeLongLe(j11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWriteShort(okio.RealBufferedSink realBufferedSink, int i11) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeShort(i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWriteShortLe(okio.RealBufferedSink realBufferedSink, int i11) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeShortLe(i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWriteUtf8(okio.RealBufferedSink realBufferedSink, String str) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWriteUtf8CodePoint(okio.RealBufferedSink realBufferedSink, int i11) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8CodePoint(i11);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWrite(okio.RealBufferedSink realBufferedSink, ByteString byteString) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWriteUtf8(okio.RealBufferedSink realBufferedSink, String str, int i11, int i12) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str, i11, i12);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWrite(okio.RealBufferedSink realBufferedSink, ByteString byteString, int i11, int i12) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString, i11, i12);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWrite(okio.RealBufferedSink realBufferedSink, byte[] bArr) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWrite(okio.RealBufferedSink realBufferedSink, byte[] bArr, int i11, int i12) {
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr, i11, i12);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final BufferedSink commonWrite(okio.RealBufferedSink realBufferedSink, Source source, long j11) {
        while (j11 > 0) {
            long read = source.read(realBufferedSink.bufferField, j11);
            if (read != -1) {
                j11 -= read;
                realBufferedSink.emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return realBufferedSink;
    }
}
