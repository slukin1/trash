package okio.internal;

import com.huobi.points.entity.PointsPack;
import java.io.EOFException;
import net.sf.scuba.smartcards.ISO7816;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* renamed from: okio.internal.-RealBufferedSource  reason: invalid class name */
public final class RealBufferedSource {
    public static final void commonClose(okio.RealBufferedSource realBufferedSource) {
        if (!realBufferedSource.closed) {
            realBufferedSource.closed = true;
            realBufferedSource.source.close();
            realBufferedSource.bufferField.clear();
        }
    }

    public static final boolean commonExhausted(okio.RealBufferedSource realBufferedSource) {
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        } else if (!realBufferedSource.bufferField.exhausted() || realBufferedSource.source.read(realBufferedSource.bufferField, 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public static final long commonIndexOf(okio.RealBufferedSource realBufferedSource, byte b11, long j11, long j12) {
        boolean z11 = true;
        if (!realBufferedSource.closed) {
            if (0 > j11 || j11 > j12) {
                z11 = false;
            }
            if (z11) {
                while (j11 < j12) {
                    long indexOf = realBufferedSource.bufferField.indexOf(b11, j11, j12);
                    if (indexOf == -1) {
                        long size = realBufferedSource.bufferField.size();
                        if (size >= j12 || realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                            break;
                        }
                        j11 = Math.max(j11, size);
                    } else {
                        return indexOf;
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j11 + " toIndex=" + j12).toString());
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final long commonIndexOfElement(okio.RealBufferedSource realBufferedSource, ByteString byteString, long j11) {
        if (!realBufferedSource.closed) {
            while (true) {
                long indexOfElement = realBufferedSource.bufferField.indexOfElement(byteString, j11);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                long size = realBufferedSource.bufferField.size();
                if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                    return -1;
                }
                j11 = Math.max(j11, size);
            }
        } else {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
    }

    public static final BufferedSource commonPeek(okio.RealBufferedSource realBufferedSource) {
        return Okio.buffer((Source) new PeekSource(realBufferedSource));
    }

    public static final boolean commonRangeEquals(okio.RealBufferedSource realBufferedSource, long j11, ByteString byteString, int i11, int i12) {
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        } else if (j11 < 0 || i11 < 0 || i12 < 0 || byteString.size() - i11 < i12) {
            return false;
        } else {
            for (int i13 = 0; i13 < i12; i13++) {
                long j12 = ((long) i13) + j11;
                if (!realBufferedSource.request(1 + j12) || realBufferedSource.bufferField.getByte(j12) != byteString.getByte(i11 + i13)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final long commonRead(okio.RealBufferedSource realBufferedSource, Buffer buffer, long j11) {
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        } else if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        } else if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
            return -1;
        } else {
            return realBufferedSource.bufferField.read(buffer, Math.min(j11, realBufferedSource.bufferField.size()));
        }
    }

    public static final long commonReadAll(okio.RealBufferedSource realBufferedSource, Sink sink) {
        long j11 = 0;
        while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) != -1) {
            long completeSegmentByteCount = realBufferedSource.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j11 += completeSegmentByteCount;
                sink.write(realBufferedSource.bufferField, completeSegmentByteCount);
            }
        }
        if (realBufferedSource.bufferField.size() <= 0) {
            return j11;
        }
        long size = j11 + realBufferedSource.bufferField.size();
        Buffer buffer = realBufferedSource.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public static final byte commonReadByte(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.require(1);
        return realBufferedSource.bufferField.readByte();
    }

    public static final byte[] commonReadByteArray(okio.RealBufferedSource realBufferedSource, long j11) {
        realBufferedSource.require(j11);
        return realBufferedSource.bufferField.readByteArray(j11);
    }

    public static final ByteString commonReadByteString(okio.RealBufferedSource realBufferedSource, long j11) {
        realBufferedSource.require(j11);
        return realBufferedSource.bufferField.readByteString(j11);
    }

    public static final long commonReadDecimalLong(okio.RealBufferedSource realBufferedSource) {
        int i11;
        realBufferedSource.require(1);
        long j11 = 0;
        while (true) {
            long j12 = j11 + 1;
            if (!realBufferedSource.request(j12)) {
                break;
            }
            byte b11 = realBufferedSource.bufferField.getByte(j11);
            if ((b11 >= 48 && b11 <= 57) || (j11 == 0 && b11 == 45)) {
                j11 = j12;
            } else if (i11 == 0) {
                throw new NumberFormatException("Expected a digit or '-' but was 0x" + Integer.toString(b11, CharsKt__CharJVMKt.a(CharsKt__CharJVMKt.a(16))));
            }
        }
        return realBufferedSource.bufferField.readDecimalLong();
    }

    public static final void commonReadFully(okio.RealBufferedSource realBufferedSource, byte[] bArr) {
        try {
            realBufferedSource.require((long) bArr.length);
            realBufferedSource.bufferField.readFully(bArr);
        } catch (EOFException e11) {
            int i11 = 0;
            while (realBufferedSource.bufferField.size() > 0) {
                Buffer buffer = realBufferedSource.bufferField;
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

    public static final long commonReadHexadecimalUnsignedLong(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.require(1);
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            if (!realBufferedSource.request((long) i12)) {
                break;
            }
            byte b11 = realBufferedSource.bufferField.getByte((long) i11);
            if ((b11 >= 48 && b11 <= 57) || ((b11 >= 97 && b11 <= 102) || (b11 >= 65 && b11 <= 70))) {
                i11 = i12;
            } else if (i11 == 0) {
                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toString(b11, CharsKt__CharJVMKt.a(CharsKt__CharJVMKt.a(16))));
            }
        }
        return realBufferedSource.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.require(4);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.require(4);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.require(8);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.require(8);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.require(2);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.require(2);
        return realBufferedSource.bufferField.readShortLe();
    }

    public static final String commonReadUtf8(okio.RealBufferedSource realBufferedSource, long j11) {
        realBufferedSource.require(j11);
        return realBufferedSource.bufferField.readUtf8(j11);
    }

    public static final int commonReadUtf8CodePoint(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.require(1);
        byte b11 = realBufferedSource.bufferField.getByte(0);
        if ((b11 & ISO7816.INS_CREATE_FILE) == 192) {
            realBufferedSource.require(2);
        } else if ((b11 & 240) == 224) {
            realBufferedSource.require(3);
        } else if ((b11 & 248) == 240) {
            realBufferedSource.require(4);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    public static final String commonReadUtf8Line(okio.RealBufferedSource realBufferedSource) {
        long indexOf = realBufferedSource.indexOf((byte) 10);
        if (indexOf != -1) {
            return Buffer.readUtf8Line(realBufferedSource.bufferField, indexOf);
        }
        if (realBufferedSource.bufferField.size() != 0) {
            return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(okio.RealBufferedSource realBufferedSource, long j11) {
        if (j11 >= 0) {
            long j12 = j11 == Long.MAX_VALUE ? Long.MAX_VALUE : j11 + 1;
            long indexOf = realBufferedSource.indexOf((byte) 10, 0, j12);
            if (indexOf != -1) {
                return Buffer.readUtf8Line(realBufferedSource.bufferField, indexOf);
            }
            if (j12 < Long.MAX_VALUE && realBufferedSource.request(j12) && realBufferedSource.bufferField.getByte(j12 - 1) == 13 && realBufferedSource.request(1 + j12) && realBufferedSource.bufferField.getByte(j12) == 10) {
                return Buffer.readUtf8Line(realBufferedSource.bufferField, j12);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = realBufferedSource.bufferField;
            buffer2.copyTo(buffer, 0, Math.min((long) 32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource.bufferField.size(), j11) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j11).toString());
    }

    public static final boolean commonRequest(okio.RealBufferedSource realBufferedSource, long j11) {
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        } else if (!realBufferedSource.closed) {
            while (realBufferedSource.bufferField.size() < j11) {
                if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
    }

    public static final void commonRequire(okio.RealBufferedSource realBufferedSource, long j11) {
        if (!realBufferedSource.request(j11)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(okio.RealBufferedSource realBufferedSource, Options options) {
        if (!realBufferedSource.closed) {
            do {
                int selectPrefix = Buffer.selectPrefix(realBufferedSource.bufferField, options, true);
                if (selectPrefix != -2) {
                    if (selectPrefix == -1) {
                        return -1;
                    }
                    realBufferedSource.bufferField.skip((long) options.getByteStrings$okio()[selectPrefix].size());
                    return selectPrefix;
                }
            } while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) != -1);
            return -1;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final void commonSkip(okio.RealBufferedSource realBufferedSource, long j11) {
        if (!realBufferedSource.closed) {
            while (j11 > 0) {
                if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j11, realBufferedSource.bufferField.size());
                realBufferedSource.bufferField.skip(min);
                j11 -= min;
            }
            return;
        }
        throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
    }

    public static final Timeout commonTimeout(okio.RealBufferedSource realBufferedSource) {
        return realBufferedSource.source.timeout();
    }

    public static final String commonToString(okio.RealBufferedSource realBufferedSource) {
        return "buffer(" + realBufferedSource.source + ')';
    }

    public static final byte[] commonReadByteArray(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    public static final ByteString commonReadByteString(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    public static final String commonReadUtf8(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final void commonReadFully(okio.RealBufferedSource realBufferedSource, Buffer buffer, long j11) {
        try {
            realBufferedSource.require(j11);
            realBufferedSource.bufferField.readFully(buffer, j11);
        } catch (EOFException e11) {
            buffer.writeAll(realBufferedSource.bufferField);
            throw e11;
        }
    }

    public static final long commonIndexOf(okio.RealBufferedSource realBufferedSource, ByteString byteString, long j11) {
        if (!realBufferedSource.closed) {
            while (true) {
                long indexOf = realBufferedSource.bufferField.indexOf(byteString, j11);
                if (indexOf != -1) {
                    return indexOf;
                }
                long size = realBufferedSource.bufferField.size();
                if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                    return -1;
                }
                j11 = Math.max(j11, (size - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
    }

    public static final int commonRead(okio.RealBufferedSource realBufferedSource, byte[] bArr, int i11, int i12) {
        long j11 = (long) i12;
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i11, j11);
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
            return -1;
        }
        return realBufferedSource.bufferField.read(bArr, i11, (int) Math.min(j11, realBufferedSource.bufferField.size()));
    }
}
