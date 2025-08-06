package okio.internal;

import com.google.common.base.Ascii;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import d10.p;
import java.io.EOFException;
import java.util.Objects;
import net.sf.scuba.smartcards.ISO7816;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.C0892SegmentedByteString;
import okio.Options;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio._JvmPlatformKt;

/* renamed from: okio.internal.-Buffer  reason: invalid class name */
public final class Buffer {
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(okio.Buffer buffer) {
        buffer.skip(buffer.size());
    }

    public static final void commonClose(Buffer.UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            unsafeCursor.buffer = null;
            unsafeCursor.setSegment$okio((Segment) null);
            unsafeCursor.offset = -1;
            unsafeCursor.data = null;
            unsafeCursor.start = -1;
            unsafeCursor.end = -1;
            return;
        }
        throw new IllegalStateException("not attached to a buffer".toString());
    }

    public static final long commonCompleteSegmentByteCount(okio.Buffer buffer) {
        long size = buffer.size();
        if (size == 0) {
            return 0;
        }
        Segment segment = buffer.head.prev;
        int i11 = segment.limit;
        return (i11 >= 8192 || !segment.owner) ? size : size - ((long) (i11 - segment.pos));
    }

    public static final okio.Buffer commonCopy(okio.Buffer buffer) {
        okio.Buffer buffer2 = new okio.Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            sharedCopy.prev.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    public static final okio.Buffer commonCopyTo(okio.Buffer buffer, okio.Buffer buffer2, long j11, long j12) {
        SegmentedByteString.checkOffsetAndCount(buffer.size(), j11, j12);
        if (j12 == 0) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + j12);
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
            Segment sharedCopy = segment.sharedCopy();
            int i13 = sharedCopy.pos + ((int) j11);
            sharedCopy.pos = i13;
            sharedCopy.limit = Math.min(i13 + ((int) j12), sharedCopy.limit);
            Segment segment2 = buffer2.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                buffer2.head = sharedCopy;
            } else {
                segment2.prev.push(sharedCopy);
            }
            j12 -= (long) (sharedCopy.limit - sharedCopy.pos);
            segment = segment.next;
            j11 = 0;
        }
        return buffer;
    }

    /* JADX WARNING: type inference failed for: r19v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean commonEquals(okio.Buffer r18, java.lang.Object r19) {
        /*
            r0 = r18
            r1 = r19
            r2 = 1
            if (r0 != r1) goto L_0x0008
            return r2
        L_0x0008:
            boolean r3 = r1 instanceof okio.Buffer
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            long r5 = r18.size()
            okio.Buffer r1 = (okio.Buffer) r1
            long r7 = r1.size()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x001d
            return r4
        L_0x001d:
            long r5 = r18.size()
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0028
            return r2
        L_0x0028:
            okio.Segment r3 = r0.head
            okio.Segment r1 = r1.head
            int r5 = r3.pos
            int r6 = r1.pos
            r9 = r7
        L_0x0031:
            long r11 = r18.size()
            int r11 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0072
            int r11 = r3.limit
            int r11 = r11 - r5
            int r12 = r1.limit
            int r12 = r12 - r6
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = r7
        L_0x0045:
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x0060
            byte[] r15 = r3.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.data
            int r17 = r6 + 1
            byte r6 = r15[r6]
            if (r5 == r6) goto L_0x0058
            return r4
        L_0x0058:
            r5 = 1
            long r13 = r13 + r5
            r5 = r16
            r6 = r17
            goto L_0x0045
        L_0x0060:
            int r13 = r3.limit
            if (r5 != r13) goto L_0x0068
            okio.Segment r3 = r3.next
            int r5 = r3.pos
        L_0x0068:
            int r13 = r1.limit
            if (r6 != r13) goto L_0x0070
            okio.Segment r1 = r1.next
            int r6 = r1.pos
        L_0x0070:
            long r9 = r9 + r11
            goto L_0x0031
        L_0x0072:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.Buffer.commonEquals(okio.Buffer, java.lang.Object):boolean");
    }

    public static final long commonExpandBuffer(Buffer.UnsafeCursor unsafeCursor, int i11) {
        boolean z11 = true;
        if (i11 > 0) {
            if (i11 > 8192) {
                z11 = false;
            }
            if (z11) {
                okio.Buffer buffer = unsafeCursor.buffer;
                if (buffer == null) {
                    throw new IllegalStateException("not attached to a buffer".toString());
                } else if (unsafeCursor.readWrite) {
                    long size = buffer.size();
                    Segment writableSegment$okio = buffer.writableSegment$okio(i11);
                    int i12 = 8192 - writableSegment$okio.limit;
                    writableSegment$okio.limit = 8192;
                    long j11 = (long) i12;
                    buffer.setSize$okio(size + j11);
                    unsafeCursor.setSegment$okio(writableSegment$okio);
                    unsafeCursor.offset = size;
                    unsafeCursor.data = writableSegment$okio.data;
                    unsafeCursor.start = 8192 - i12;
                    unsafeCursor.end = 8192;
                    return j11;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
                }
            } else {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + i11).toString());
            }
        } else {
            throw new IllegalArgumentException(("minByteCount <= 0: " + i11).toString());
        }
    }

    public static final byte commonGet(okio.Buffer buffer, long j11) {
        SegmentedByteString.checkOffsetAndCount(buffer.size(), j11, 1);
        Segment segment = buffer.head;
        Objects.requireNonNull(segment);
        if (buffer.size() - j11 < j11) {
            long size = buffer.size();
            while (size > j11) {
                segment = segment.prev;
                size -= (long) (segment.limit - segment.pos);
            }
            return segment.data[(int) ((((long) segment.pos) + j11) - size)];
        }
        long j12 = 0;
        while (true) {
            long j13 = ((long) (segment.limit - segment.pos)) + j12;
            if (j13 > j11) {
                return segment.data[(int) ((((long) segment.pos) + j11) - j12)];
            }
            segment = segment.next;
            j12 = j13;
        }
    }

    public static final int commonHashCode(okio.Buffer buffer) {
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i11 = 1;
        do {
            int i12 = segment.limit;
            for (int i13 = segment.pos; i13 < i12; i13++) {
                i11 = (i11 * 31) + segment.data[i13];
            }
            segment = segment.next;
        } while (segment != buffer.head);
        return i11;
    }

    public static final long commonIndexOf(okio.Buffer buffer, byte b11, long j11, long j12) {
        Segment segment;
        long j13;
        int i11;
        long j14 = 0;
        boolean z11 = false;
        if (0 <= j11 && j11 <= j12) {
            z11 = true;
        }
        if (z11) {
            if (j12 > buffer.size()) {
                j12 = buffer.size();
            }
            if (j11 == j12 || (segment = buffer.head) == null) {
                return -1;
            }
            if (buffer.size() - j11 < j11) {
                j13 = buffer.size();
                while (j13 > j11) {
                    segment = segment.prev;
                    j13 -= (long) (segment.limit - segment.pos);
                }
                while (j13 < j12) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j12) - j13);
                    i11 = (int) ((((long) segment.pos) + j11) - j13);
                    while (i11 < min) {
                        if (bArr[i11] != b11) {
                            i11++;
                        }
                    }
                    j13 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    j11 = j13;
                }
                return -1;
            }
            while (true) {
                long j15 = ((long) (segment.limit - segment.pos)) + j14;
                if (j15 > j11) {
                    break;
                }
                segment = segment.next;
                j14 = j15;
            }
            while (j13 < j12) {
                byte[] bArr2 = segment.data;
                int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + j12) - j13);
                int i12 = (int) ((((long) segment.pos) + j11) - j13);
                while (i11 < min2) {
                    if (bArr2[i11] != b11) {
                        i12 = i11 + 1;
                    }
                }
                j14 = j13 + ((long) (segment.limit - segment.pos));
                segment = segment.next;
                j11 = j14;
            }
            return -1;
            return ((long) (i11 - segment.pos)) + j13;
        }
        throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j11 + " toIndex=" + j12).toString());
    }

    public static final long commonIndexOfElement(okio.Buffer buffer, ByteString byteString, long j11) {
        long j12;
        int i11;
        int i12;
        int i13;
        long j13 = 0;
        if (j11 >= 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                return -1;
            }
            if (buffer.size() - j11 < j11) {
                j12 = buffer.size();
                while (j12 > j11) {
                    segment = segment.prev;
                    j12 -= (long) (segment.limit - segment.pos);
                }
                if (byteString.size() == 2) {
                    byte b11 = byteString.getByte(0);
                    byte b12 = byteString.getByte(1);
                    while (j12 < buffer.size()) {
                        byte[] bArr = segment.data;
                        i12 = (int) ((((long) segment.pos) + j11) - j12);
                        int i14 = segment.limit;
                        while (i12 < i14) {
                            byte b13 = bArr[i12];
                            if (!(b13 == b11 || b13 == b12)) {
                                i12++;
                            }
                        }
                        j12 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        j11 = j12;
                    }
                } else {
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    while (j12 < buffer.size()) {
                        byte[] bArr2 = segment.data;
                        i11 = (int) ((((long) segment.pos) + j11) - j12);
                        int i15 = segment.limit;
                        while (i11 < i15) {
                            byte b14 = bArr2[i11];
                            for (byte b15 : internalArray$okio) {
                                if (b14 == b15) {
                                    i13 = segment.pos;
                                    return ((long) (i12 - i13)) + j12;
                                }
                            }
                            i11++;
                        }
                        j12 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        j11 = j12;
                    }
                }
                return -1;
            }
            while (true) {
                long j14 = ((long) (segment.limit - segment.pos)) + j13;
                if (j14 > j11) {
                    break;
                }
                segment = segment.next;
                j13 = j14;
            }
            if (byteString.size() == 2) {
                byte b16 = byteString.getByte(0);
                byte b17 = byteString.getByte(1);
                while (j12 < buffer.size()) {
                    byte[] bArr3 = segment.data;
                    int i16 = (int) ((((long) segment.pos) + j11) - j12);
                    int i17 = segment.limit;
                    while (i12 < i17) {
                        byte b18 = bArr3[i12];
                        if (!(b18 == b16 || b18 == b17)) {
                            i16 = i12 + 1;
                        }
                    }
                    j13 = j12 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    j11 = j13;
                }
            } else {
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                while (j12 < buffer.size()) {
                    byte[] bArr4 = segment.data;
                    int i18 = (int) ((((long) segment.pos) + j11) - j12);
                    int i19 = segment.limit;
                    while (i11 < i19) {
                        byte b19 = bArr4[i11];
                        for (byte b21 : internalArray$okio2) {
                            if (b19 == b21) {
                                i13 = segment.pos;
                                return ((long) (i12 - i13)) + j12;
                            }
                        }
                        i18 = i11 + 1;
                    }
                    j13 = j12 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    j11 = j13;
                }
            }
            return -1;
            i13 = segment.pos;
            return ((long) (i12 - i13)) + j12;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j11).toString());
    }

    public static final int commonNext(Buffer.UnsafeCursor unsafeCursor) {
        if (unsafeCursor.offset != unsafeCursor.buffer.size()) {
            long j11 = unsafeCursor.offset;
            return unsafeCursor.seek(j11 == -1 ? 0 : j11 + ((long) (unsafeCursor.end - unsafeCursor.start)));
        }
        throw new IllegalStateException("no more bytes".toString());
    }

    public static final boolean commonRangeEquals(okio.Buffer buffer, long j11, ByteString byteString, int i11, int i12) {
        if (j11 < 0 || i11 < 0 || i12 < 0 || buffer.size() - j11 < ((long) i12) || byteString.size() - i11 < i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (buffer.getByte(((long) i13) + j11) != byteString.getByte(i11 + i13)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(okio.Buffer buffer, byte[] bArr) {
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final long commonReadAll(okio.Buffer buffer, Sink sink) {
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final Buffer.UnsafeCursor commonReadAndWriteUnsafe(okio.Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        Buffer.UnsafeCursor resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = true;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final byte commonReadByte(okio.Buffer buffer) {
        if (buffer.size() != 0) {
            Segment segment = buffer.head;
            int i11 = segment.pos;
            int i12 = segment.limit;
            int i13 = i11 + 1;
            byte b11 = segment.data[i11];
            buffer.setSize$okio(buffer.size() - 1);
            if (i13 == i12) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return b11;
        }
        throw new EOFException();
    }

    public static final byte[] commonReadByteArray(okio.Buffer buffer) {
        return buffer.readByteArray(buffer.size());
    }

    public static final ByteString commonReadByteString(okio.Buffer buffer) {
        return buffer.readByteString(buffer.size());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a0, code lost:
        if (r6 == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a2, code lost:
        r14 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        r14 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a5, code lost:
        if (r5 >= r14) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00af, code lost:
        if (r18.size() == 0) goto L_0x00dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b1, code lost:
        if (r6 == false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b3, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b6, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00db, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio.SegmentedByteString.toHexString(r0.getByte(0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e1, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e2, code lost:
        if (r6 == false) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        return -r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        return r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadDecimalLong(okio.Buffer r18) {
        /*
            r0 = r18
            long r1 = r18.size()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00e7
            r1 = -7
            r5 = 0
            r8 = r3
            r6 = r5
            r7 = r6
        L_0x0012:
            okio.Segment r10 = r0.head
            byte[] r11 = r10.data
            int r12 = r10.pos
            int r13 = r10.limit
        L_0x001a:
            if (r12 >= r13) goto L_0x007e
            byte r15 = r11[r12]
            r14 = 48
            if (r15 < r14) goto L_0x006c
            r14 = 57
            if (r15 > r14) goto L_0x006c
            int r14 = 48 - r15
            r16 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r16 < 0) goto L_0x003f
            if (r16 != 0) goto L_0x0039
            long r3 = (long) r14
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0039
            goto L_0x003f
        L_0x0039:
            r3 = 10
            long r8 = r8 * r3
            long r3 = (long) r14
            long r8 = r8 + r3
            goto L_0x0076
        L_0x003f:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeDecimalLong((long) r8)
            okio.Buffer r0 = r0.writeByte((int) r15)
            if (r6 != 0) goto L_0x0051
            r0.readByte()
        L_0x0051:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x006c:
            r3 = 45
            if (r15 != r3) goto L_0x007d
            if (r5 != 0) goto L_0x007d
            r3 = 1
            long r1 = r1 - r3
            r6 = 1
        L_0x0076:
            int r12 = r12 + 1
            int r5 = r5 + 1
            r3 = 0
            goto L_0x001a
        L_0x007d:
            r7 = 1
        L_0x007e:
            if (r12 != r13) goto L_0x008a
            okio.Segment r3 = r10.pop()
            r0.head = r3
            okio.SegmentPool.recycle(r10)
            goto L_0x008c
        L_0x008a:
            r10.pos = r12
        L_0x008c:
            if (r7 != 0) goto L_0x0097
            okio.Segment r3 = r0.head
            if (r3 != 0) goto L_0x0093
            goto L_0x0097
        L_0x0093:
            r3 = 0
            goto L_0x0012
        L_0x0097:
            long r1 = r18.size()
            long r3 = (long) r5
            long r1 = r1 - r3
            r0.setSize$okio(r1)
            if (r6 == 0) goto L_0x00a4
            r14 = 2
            goto L_0x00a5
        L_0x00a4:
            r14 = 1
        L_0x00a5:
            if (r5 >= r14) goto L_0x00e2
            long r1 = r18.size()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00dc
            if (r6 == 0) goto L_0x00b6
            java.lang.String r1 = "Expected a digit"
            goto L_0x00b8
        L_0x00b6:
            java.lang.String r1 = "Expected a digit or '-'"
        L_0x00b8:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            java.lang.String r1 = " but was 0x"
            r3.append(r1)
            r4 = 0
            byte r0 = r0.getByte(r4)
            java.lang.String r0 = okio.SegmentedByteString.toHexString((byte) r0)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        L_0x00dc:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        L_0x00e2:
            if (r6 == 0) goto L_0x00e5
            goto L_0x00e6
        L_0x00e5:
            long r8 = -r8
        L_0x00e6:
            return r8
        L_0x00e7:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.Buffer.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(okio.Buffer buffer, byte[] bArr) {
        int i11 = 0;
        while (i11 < bArr.length) {
            int read = buffer.read(bArr, i11, bArr.length - i11);
            if (read != -1) {
                i11 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0093, code lost:
        if (r8 != r9) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0095, code lost:
        r14.head = r6.pop();
        okio.SegmentPool.recycle(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009f, code lost:
        r6.pos = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
        if (r1 != false) goto L_0x00a7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0078 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadHexadecimalUnsignedLong(okio.Buffer r14) {
        /*
            long r0 = r14.size()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x00b1
            r0 = 0
            r1 = r0
            r4 = r2
        L_0x000d:
            okio.Segment r6 = r14.head
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x0015:
            if (r8 >= r9) goto L_0x0093
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0024
            r11 = 57
            if (r10 > r11) goto L_0x0024
            int r11 = r10 + -48
            goto L_0x003c
        L_0x0024:
            r11 = 97
            if (r10 < r11) goto L_0x0031
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x0031
            int r11 = r10 + -97
        L_0x002e:
            int r11 = r11 + 10
            goto L_0x003c
        L_0x0031:
            r11 = 65
            if (r10 < r11) goto L_0x0074
            r11 = 70
            if (r10 > r11) goto L_0x0074
            int r11 = r10 + -65
            goto L_0x002e
        L_0x003c:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x004c
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0015
        L_0x004c:
            okio.Buffer r14 = new okio.Buffer
            r14.<init>()
            okio.Buffer r14 = r14.writeHexadecimalUnsignedLong((long) r4)
            okio.Buffer r14 = r14.writeByte((int) r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r14 = r14.readUtf8()
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            r0.<init>(r14)
            throw r0
        L_0x0074:
            if (r0 == 0) goto L_0x0078
            r1 = 1
            goto L_0x0093
        L_0x0078:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = okio.SegmentedByteString.toHexString((byte) r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L_0x0093:
            if (r8 != r9) goto L_0x009f
            okio.Segment r7 = r6.pop()
            r14.head = r7
            okio.SegmentPool.recycle(r6)
            goto L_0x00a1
        L_0x009f:
            r6.pos = r8
        L_0x00a1:
            if (r1 != 0) goto L_0x00a7
            okio.Segment r6 = r14.head
            if (r6 != 0) goto L_0x000d
        L_0x00a7:
            long r1 = r14.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.setSize$okio(r1)
            return r4
        L_0x00b1:
            java.io.EOFException r14 = new java.io.EOFException
            r14.<init>()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.Buffer.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(okio.Buffer buffer) {
        if (buffer.size() >= 4) {
            Segment segment = buffer.head;
            int i11 = segment.pos;
            int i12 = segment.limit;
            if (((long) (i12 - i11)) < 4) {
                return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << Ascii.CAN) | ((buffer.readByte() & 255) << 16) | ((buffer.readByte() & 255) << 8);
            }
            byte[] bArr = segment.data;
            int i13 = i11 + 1;
            int i14 = i13 + 1;
            byte b11 = ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i13] & 255) << 16);
            int i15 = i14 + 1;
            byte b12 = b11 | ((bArr[i14] & 255) << 8);
            int i16 = i15 + 1;
            byte b13 = b12 | (bArr[i15] & 255);
            buffer.setSize$okio(buffer.size() - 4);
            if (i16 == i12) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i16;
            }
            return b13;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(okio.Buffer buffer) {
        if (buffer.size() >= 8) {
            Segment segment = buffer.head;
            int i11 = segment.pos;
            int i12 = segment.limit;
            if (((long) (i12 - i11)) < 8) {
                return ((((long) buffer.readInt()) & 4294967295L) << 32) | (4294967295L & ((long) buffer.readInt()));
            }
            byte[] bArr = segment.data;
            int i13 = i11 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int i17 = i16 + 1;
            int i18 = i17 + 1;
            long j11 = ((((long) bArr[i11]) & 255) << 56) | ((((long) bArr[i13]) & 255) << 48) | ((((long) bArr[i14]) & 255) << 40) | ((((long) bArr[i15]) & 255) << 32) | ((((long) bArr[i16]) & 255) << 24) | ((((long) bArr[i17]) & 255) << 16);
            int i19 = i18 + 1;
            int i21 = i19 + 1;
            long j12 = j11 | ((((long) bArr[i18]) & 255) << 8) | (((long) bArr[i19]) & 255);
            buffer.setSize$okio(buffer.size() - 8);
            if (i21 == i12) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i21;
            }
            return j12;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(okio.Buffer buffer) {
        if (buffer.size() >= 2) {
            Segment segment = buffer.head;
            int i11 = segment.pos;
            int i12 = segment.limit;
            if (i12 - i11 < 2) {
                return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
            }
            byte[] bArr = segment.data;
            int i13 = i11 + 1;
            int i14 = i13 + 1;
            byte b11 = ((bArr[i11] & 255) << 8) | (bArr[i13] & 255);
            buffer.setSize$okio(buffer.size() - 2);
            if (i14 == i12) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i14;
            }
            return (short) b11;
        }
        throw new EOFException();
    }

    public static final Buffer.UnsafeCursor commonReadUnsafe(okio.Buffer buffer, Buffer.UnsafeCursor unsafeCursor) {
        Buffer.UnsafeCursor resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(unsafeCursor);
        if (resolveDefaultParameter.buffer == null) {
            resolveDefaultParameter.buffer = buffer;
            resolveDefaultParameter.readWrite = false;
            return resolveDefaultParameter;
        }
        throw new IllegalStateException("already attached to a buffer".toString());
    }

    public static final String commonReadUtf8(okio.Buffer buffer, long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (!(i11 >= 0 && j11 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j11).toString());
        } else if (buffer.size() < j11) {
            throw new EOFException();
        } else if (i11 == 0) {
            return "";
        } else {
            Segment segment = buffer.head;
            int i12 = segment.pos;
            if (((long) i12) + j11 > ((long) segment.limit)) {
                return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j11), 0, 0, 3, (Object) null);
            }
            int i13 = (int) j11;
            String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i12, i12 + i13);
            segment.pos += i13;
            buffer.setSize$okio(buffer.size() - j11);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return commonToUtf8String;
        }
    }

    public static final int commonReadUtf8CodePoint(okio.Buffer buffer) {
        byte b11;
        int i11;
        byte b12;
        if (buffer.size() != 0) {
            byte b13 = buffer.getByte(0);
            boolean z11 = false;
            if ((b13 & 128) == 0) {
                b12 = b13 & Ascii.DEL;
                b11 = 0;
                i11 = 1;
            } else if ((b13 & ISO7816.INS_CREATE_FILE) == 192) {
                b12 = b13 & Ascii.US;
                i11 = 2;
                b11 = 128;
            } else if ((b13 & 240) == 224) {
                b12 = b13 & 15;
                i11 = 3;
                b11 = 2048;
            } else if ((b13 & 248) == 240) {
                b12 = b13 & 7;
                i11 = 4;
                b11 = 65536;
            } else {
                buffer.skip(1);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j11 = (long) i11;
            if (buffer.size() >= j11) {
                int i12 = 1;
                while (i12 < i11) {
                    long j12 = (long) i12;
                    byte b14 = buffer.getByte(j12);
                    if ((b14 & ISO7816.INS_GET_RESPONSE) == 128) {
                        b12 = (b12 << 6) | (b14 & Utf8.REPLACEMENT_BYTE);
                        i12++;
                    } else {
                        buffer.skip(j12);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                buffer.skip(j11);
                if (b12 > 1114111) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                if (55296 <= b12 && b12 < 57344) {
                    z11 = true;
                }
                if (!z11 && b12 >= b11) {
                    return b12;
                }
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            throw new EOFException("size < " + i11 + l.f34627b + buffer.size() + " (to read code point prefixed 0x" + SegmentedByteString.toHexString(b13) + ')');
        }
        throw new EOFException();
    }

    public static final String commonReadUtf8Line(okio.Buffer buffer) {
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(okio.Buffer buffer, long j11) {
        if (j11 >= 0) {
            long j12 = Long.MAX_VALUE;
            if (j11 != Long.MAX_VALUE) {
                j12 = j11 + 1;
            }
            long indexOf = buffer.indexOf((byte) 10, 0, j12);
            if (indexOf != -1) {
                return readUtf8Line(buffer, indexOf);
            }
            if (j12 < buffer.size() && buffer.getByte(j12 - 1) == 13 && buffer.getByte(j12) == 10) {
                return readUtf8Line(buffer, j12);
            }
            okio.Buffer buffer2 = new okio.Buffer();
            buffer.copyTo(buffer2, 0, Math.min((long) 32, buffer.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j11) + " content=" + buffer2.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j11).toString());
    }

    public static final long commonResizeBuffer(Buffer.UnsafeCursor unsafeCursor, long j11) {
        Buffer.UnsafeCursor unsafeCursor2 = unsafeCursor;
        long j12 = j11;
        okio.Buffer buffer = unsafeCursor2.buffer;
        if (buffer == null) {
            throw new IllegalStateException("not attached to a buffer".toString());
        } else if (unsafeCursor2.readWrite) {
            long size = buffer.size();
            int i11 = (j12 > size ? 1 : (j12 == size ? 0 : -1));
            int i12 = 1;
            if (i11 <= 0) {
                if (j12 >= 0) {
                    long j13 = size - j12;
                    while (true) {
                        if (j13 <= 0) {
                            break;
                        }
                        Segment segment = buffer.head.prev;
                        int i13 = segment.limit;
                        long j14 = (long) (i13 - segment.pos);
                        if (j14 > j13) {
                            segment.limit = i13 - ((int) j13);
                            break;
                        }
                        buffer.head = segment.pop();
                        SegmentPool.recycle(segment);
                        j13 -= j14;
                    }
                    unsafeCursor2.setSegment$okio((Segment) null);
                    unsafeCursor2.offset = j12;
                    unsafeCursor2.data = null;
                    unsafeCursor2.start = -1;
                    unsafeCursor2.end = -1;
                } else {
                    throw new IllegalArgumentException(("newSize < 0: " + j12).toString());
                }
            } else if (i11 > 0) {
                long j15 = j12 - size;
                boolean z11 = true;
                while (j15 > 0) {
                    Segment writableSegment$okio = buffer.writableSegment$okio(i12);
                    int min = (int) Math.min(j15, (long) (8192 - writableSegment$okio.limit));
                    writableSegment$okio.limit += min;
                    j15 -= (long) min;
                    if (z11) {
                        unsafeCursor2.setSegment$okio(writableSegment$okio);
                        unsafeCursor2.offset = size;
                        unsafeCursor2.data = writableSegment$okio.data;
                        int i14 = writableSegment$okio.limit;
                        unsafeCursor2.start = i14 - min;
                        unsafeCursor2.end = i14;
                        z11 = false;
                    }
                    i12 = 1;
                }
            }
            buffer.setSize$okio(j12);
            return size;
        } else {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        }
    }

    public static final int commonSeek(Buffer.UnsafeCursor unsafeCursor, long j11) {
        Segment segment;
        okio.Buffer buffer = unsafeCursor.buffer;
        if (buffer != null) {
            int i11 = (j11 > -1 ? 1 : (j11 == -1 ? 0 : -1));
            if (i11 < 0 || j11 > buffer.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + j11 + " > size=" + buffer.size());
            } else if (i11 == 0 || j11 == buffer.size()) {
                unsafeCursor.setSegment$okio((Segment) null);
                unsafeCursor.offset = j11;
                unsafeCursor.data = null;
                unsafeCursor.start = -1;
                unsafeCursor.end = -1;
                return -1;
            } else {
                long j12 = 0;
                long size = buffer.size();
                Segment segment2 = buffer.head;
                if (unsafeCursor.getSegment$okio() != null) {
                    long j13 = unsafeCursor.offset - ((long) (unsafeCursor.start - unsafeCursor.getSegment$okio().pos));
                    if (j13 > j11) {
                        Segment segment3 = segment2;
                        segment2 = unsafeCursor.getSegment$okio();
                        size = j13;
                        segment = segment3;
                    } else {
                        long j14 = j13;
                        segment = unsafeCursor.getSegment$okio();
                        j12 = j14;
                    }
                } else {
                    segment = segment2;
                }
                if (size - j11 > j11 - j12) {
                    while (true) {
                        int i12 = segment.limit;
                        int i13 = segment.pos;
                        if (j11 < ((long) (i12 - i13)) + j12) {
                            break;
                        }
                        j12 += (long) (i12 - i13);
                        segment = segment.next;
                    }
                } else {
                    while (size > j11) {
                        segment2 = segment2.prev;
                        size -= (long) (segment2.limit - segment2.pos);
                    }
                    j12 = size;
                    segment = segment2;
                }
                if (unsafeCursor.readWrite && segment.shared) {
                    Segment unsharedCopy = segment.unsharedCopy();
                    if (buffer.head == segment) {
                        buffer.head = unsharedCopy;
                    }
                    segment = segment.push(unsharedCopy);
                    segment.prev.pop();
                }
                unsafeCursor.setSegment$okio(segment);
                unsafeCursor.offset = j11;
                unsafeCursor.data = segment.data;
                int i14 = segment.pos + ((int) (j11 - j12));
                unsafeCursor.start = i14;
                int i15 = segment.limit;
                unsafeCursor.end = i15;
                return i15 - i14;
            }
        } else {
            throw new IllegalStateException("not attached to a buffer".toString());
        }
    }

    public static final int commonSelect(okio.Buffer buffer, Options options) {
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, (Object) null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(okio.Buffer buffer, long j11) {
        while (j11 > 0) {
            Segment segment = buffer.head;
            if (segment != null) {
                int min = (int) Math.min(j11, (long) (segment.limit - segment.pos));
                long j12 = (long) min;
                buffer.setSize$okio(buffer.size() - j12);
                j11 -= j12;
                int i11 = segment.pos + min;
                segment.pos = i11;
                if (i11 == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public static final ByteString commonSnapshot(okio.Buffer buffer) {
        if (buffer.size() <= 2147483647L) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer.size()).toString());
    }

    public static final Segment commonWritableSegment(okio.Buffer buffer, int i11) {
        boolean z11 = true;
        if (i11 < 1 || i11 > 8192) {
            z11 = false;
        }
        if (z11) {
            Segment segment = buffer.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                buffer.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            Segment segment2 = segment.prev;
            return (segment2.limit + i11 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public static final okio.Buffer commonWrite(okio.Buffer buffer, ByteString byteString, int i11, int i12) {
        byteString.write$okio(buffer, i11, i12);
        return buffer;
    }

    public static /* synthetic */ okio.Buffer commonWrite$default(okio.Buffer buffer, ByteString byteString, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = byteString.size();
        }
        byteString.write$okio(buffer, i11, i12);
        return buffer;
    }

    public static final long commonWriteAll(okio.Buffer buffer, Source source) {
        long j11 = 0;
        while (true) {
            long read = source.read(buffer, 8192);
            if (read == -1) {
                return j11;
            }
            j11 += read;
        }
    }

    public static final okio.Buffer commonWriteByte(okio.Buffer buffer, int i11) {
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        writableSegment$okio.limit = i12 + 1;
        bArr[i12] = (byte) i11;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    public static final okio.Buffer commonWriteDecimalLong(okio.Buffer buffer, long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 == 0) {
            return buffer.writeByte(48);
        }
        boolean z11 = false;
        int i12 = 1;
        if (i11 < 0) {
            j11 = -j11;
            if (j11 < 0) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            z11 = true;
        }
        if (j11 >= 100000000) {
            i12 = j11 < 1000000000000L ? j11 < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j11 < 1000000000 ? 9 : 10 : j11 < 100000000000L ? 11 : 12 : j11 < 1000000000000000L ? j11 < 10000000000000L ? 13 : j11 < 100000000000000L ? 14 : 15 : j11 < 100000000000000000L ? j11 < 10000000000000000L ? 16 : 17 : j11 < 1000000000000000000L ? 18 : 19;
        } else if (j11 >= 10000) {
            i12 = j11 < 1000000 ? j11 < IndexSeeker.MIN_TIME_BETWEEN_POINTS_US ? 5 : 6 : j11 < 10000000 ? 7 : 8;
        } else if (j11 >= 100) {
            i12 = j11 < 1000 ? 3 : 4;
        } else if (j11 >= 10) {
            i12 = 2;
        }
        if (z11) {
            i12++;
        }
        Segment writableSegment$okio = buffer.writableSegment$okio(i12);
        byte[] bArr = writableSegment$okio.data;
        int i13 = writableSegment$okio.limit + i12;
        while (j11 != 0) {
            long j12 = (long) 10;
            i13--;
            bArr[i13] = getHEX_DIGIT_BYTES()[(int) (j11 % j12)];
            j11 /= j12;
        }
        if (z11) {
            bArr[i13 - 1] = Framer.STDIN_FRAME_PREFIX;
        }
        writableSegment$okio.limit += i12;
        buffer.setSize$okio(buffer.size() + ((long) i12));
        return buffer;
    }

    public static final okio.Buffer commonWriteHexadecimalUnsignedLong(okio.Buffer buffer, long j11) {
        if (j11 == 0) {
            return buffer.writeByte(48);
        }
        long j12 = (j11 >>> 1) | j11;
        long j13 = j12 | (j12 >>> 2);
        long j14 = j13 | (j13 >>> 4);
        long j15 = j14 | (j14 >>> 8);
        long j16 = j15 | (j15 >>> 16);
        long j17 = j16 | (j16 >>> 32);
        long j18 = j17 - ((j17 >>> 1) & 6148914691236517205L);
        long j19 = ((j18 >>> 2) & 3689348814741910323L) + (j18 & 3689348814741910323L);
        long j21 = ((j19 >>> 4) + j19) & 1085102592571150095L;
        long j22 = j21 + (j21 >>> 8);
        long j23 = j22 + (j22 >>> 16);
        int i11 = (int) ((((j23 & 63) + ((j23 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment writableSegment$okio = buffer.writableSegment$okio(i11);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        for (int i13 = (i12 + i11) - 1; i13 >= i12; i13--) {
            bArr[i13] = getHEX_DIGIT_BYTES()[(int) (15 & j11)];
            j11 >>>= 4;
        }
        writableSegment$okio.limit += i11;
        buffer.setSize$okio(buffer.size() + ((long) i11));
        return buffer;
    }

    public static final okio.Buffer commonWriteInt(okio.Buffer buffer, int i11) {
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i11 >>> 24) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i11 >>> 16) & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((i11 >>> 8) & 255);
        bArr[i15] = (byte) (i11 & 255);
        writableSegment$okio.limit = i15 + 1;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    public static final okio.Buffer commonWriteLong(okio.Buffer buffer, long j11) {
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i11 = writableSegment$okio.limit;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((int) ((j11 >>> 56) & 255));
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((int) ((j11 >>> 48) & 255));
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((int) ((j11 >>> 40) & 255));
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((int) ((j11 >>> 32) & 255));
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((int) ((j11 >>> 24) & 255));
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((int) ((j11 >>> 16) & 255));
        int i18 = i17 + 1;
        bArr[i17] = (byte) ((int) ((j11 >>> 8) & 255));
        bArr[i18] = (byte) ((int) (j11 & 255));
        writableSegment$okio.limit = i18 + 1;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    public static final okio.Buffer commonWriteShort(okio.Buffer buffer, int i11) {
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i11 >>> 8) & 255);
        bArr[i13] = (byte) (i11 & 255);
        writableSegment$okio.limit = i13 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    public static final okio.Buffer commonWriteUtf8(okio.Buffer buffer, String str, int i11, int i12) {
        char charAt;
        if (i11 >= 0) {
            if (i12 >= i11) {
                if (i12 <= str.length()) {
                    while (i11 < i12) {
                        char charAt2 = str.charAt(i11);
                        if (charAt2 < 128) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(1);
                            byte[] bArr = writableSegment$okio.data;
                            int i13 = writableSegment$okio.limit - i11;
                            int min = Math.min(i12, 8192 - i13);
                            int i14 = i11 + 1;
                            bArr[i11 + i13] = (byte) charAt2;
                            while (true) {
                                i11 = i14;
                                if (i11 >= min || (charAt = str.charAt(i11)) >= 128) {
                                    int i15 = writableSegment$okio.limit;
                                    int i16 = (i13 + i11) - i15;
                                    writableSegment$okio.limit = i15 + i16;
                                    buffer.setSize$okio(buffer.size() + ((long) i16));
                                } else {
                                    i14 = i11 + 1;
                                    bArr[i11 + i13] = (byte) charAt;
                                }
                            }
                            int i152 = writableSegment$okio.limit;
                            int i162 = (i13 + i11) - i152;
                            writableSegment$okio.limit = i152 + i162;
                            buffer.setSize$okio(buffer.size() + ((long) i162));
                        } else {
                            if (charAt2 < 2048) {
                                Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                                byte[] bArr2 = writableSegment$okio2.data;
                                int i17 = writableSegment$okio2.limit;
                                bArr2[i17] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i17 + 1] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio2.limit = i17 + 2;
                                buffer.setSize$okio(buffer.size() + 2);
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                                byte[] bArr3 = writableSegment$okio3.data;
                                int i18 = writableSegment$okio3.limit;
                                bArr3[i18] = (byte) ((charAt2 >> 12) | 224);
                                bArr3[i18 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i18 + 2] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio3.limit = i18 + 3;
                                buffer.setSize$okio(buffer.size() + 3);
                            } else {
                                int i19 = i11 + 1;
                                char charAt3 = i19 < i12 ? str.charAt(i19) : 0;
                                if (charAt2 <= 56319) {
                                    if (56320 <= charAt3 && charAt3 < 57344) {
                                        int i21 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 0;
                                        Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                                        byte[] bArr4 = writableSegment$okio4.data;
                                        int i22 = writableSegment$okio4.limit;
                                        bArr4[i22] = (byte) ((i21 >> 18) | 240);
                                        bArr4[i22 + 1] = (byte) (((i21 >> 12) & 63) | 128);
                                        bArr4[i22 + 2] = (byte) (((i21 >> 6) & 63) | 128);
                                        bArr4[i22 + 3] = (byte) ((i21 & 63) | 128);
                                        writableSegment$okio4.limit = i22 + 4;
                                        buffer.setSize$okio(buffer.size() + 4);
                                        i11 += 2;
                                    }
                                }
                                buffer.writeByte(63);
                                i11 = i19;
                            }
                            i11++;
                        }
                    }
                    return buffer;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i12 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i12 + " < " + i11).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i11).toString());
    }

    public static final okio.Buffer commonWriteUtf8CodePoint(okio.Buffer buffer, int i11) {
        if (i11 < 128) {
            buffer.writeByte(i11);
        } else if (i11 < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i12 = writableSegment$okio.limit;
            bArr[i12] = (byte) ((i11 >> 6) | 192);
            bArr[i12 + 1] = (byte) ((i11 & 63) | 128);
            writableSegment$okio.limit = i12 + 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else {
            boolean z11 = false;
            if (55296 <= i11 && i11 < 57344) {
                z11 = true;
            }
            if (z11) {
                buffer.writeByte(63);
            } else if (i11 < 65536) {
                Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
                byte[] bArr2 = writableSegment$okio2.data;
                int i13 = writableSegment$okio2.limit;
                bArr2[i13] = (byte) ((i11 >> 12) | 224);
                bArr2[i13 + 1] = (byte) (((i11 >> 6) & 63) | 128);
                bArr2[i13 + 2] = (byte) ((i11 & 63) | 128);
                writableSegment$okio2.limit = i13 + 3;
                buffer.setSize$okio(buffer.size() + 3);
            } else if (i11 <= 1114111) {
                Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
                byte[] bArr3 = writableSegment$okio3.data;
                int i14 = writableSegment$okio3.limit;
                bArr3[i14] = (byte) ((i11 >> 18) | 240);
                bArr3[i14 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                bArr3[i14 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                bArr3[i14 + 3] = (byte) ((i11 & 63) | 128);
                writableSegment$okio3.limit = i14 + 4;
                buffer.setSize$okio(buffer.size() + 4);
            } else {
                throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(i11));
            }
        }
        return buffer;
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static /* synthetic */ void getHEX_DIGIT_BYTES$annotations() {
    }

    public static final boolean rangeEquals(Segment segment, int i11, byte[] bArr, int i12, int i13) {
        int i14 = segment.limit;
        byte[] bArr2 = segment.data;
        while (i12 < i13) {
            if (i11 == i14) {
                segment = segment.next;
                byte[] bArr3 = segment.data;
                int i15 = segment.pos;
                bArr2 = bArr3;
                i11 = i15;
                i14 = segment.limit;
            }
            if (bArr2[i11] != bArr[i12]) {
                return false;
            }
            i11++;
            i12++;
        }
        return true;
    }

    public static final String readUtf8Line(okio.Buffer buffer, long j11) {
        if (j11 > 0) {
            long j12 = j11 - 1;
            if (buffer.getByte(j12) == 13) {
                String readUtf8 = buffer.readUtf8(j12);
                buffer.skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j11);
        buffer.skip(1);
        return readUtf82;
    }

    public static final <T> T seek(okio.Buffer buffer, long j11, p<? super Segment, ? super Long, ? extends T> pVar) {
        Segment segment = buffer.head;
        if (segment == null) {
            return pVar.invoke(null, -1L);
        }
        if (buffer.size() - j11 < j11) {
            long size = buffer.size();
            while (size > j11) {
                segment = segment.prev;
                size -= (long) (segment.limit - segment.pos);
            }
            return pVar.invoke(segment, Long.valueOf(size));
        }
        long j12 = 0;
        while (true) {
            long j13 = ((long) (segment.limit - segment.pos)) + j12;
            if (j13 > j11) {
                return pVar.invoke(segment, Long.valueOf(j12));
            }
            segment = segment.next;
            j12 = j13;
        }
    }

    public static final int selectPrefix(okio.Buffer buffer, Options options, boolean z11) {
        int i11;
        int i12;
        int i13;
        Segment segment;
        int i14;
        Segment segment2 = buffer.head;
        if (segment2 == null) {
            return z11 ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i15 = segment2.pos;
        int i16 = segment2.limit;
        int[] trie$okio = options.getTrie$okio();
        Segment segment3 = segment2;
        int i17 = -1;
        int i18 = 0;
        loop0:
        while (true) {
            int i19 = i18 + 1;
            int i21 = trie$okio[i18];
            int i22 = i19 + 1;
            int i23 = trie$okio[i19];
            if (i23 != -1) {
                i17 = i23;
            }
            if (segment3 == null) {
                break;
            }
            if (i21 < 0) {
                int i24 = i22 + (i21 * -1);
                while (true) {
                    int i25 = i15 + 1;
                    int i26 = i22 + 1;
                    if ((bArr[i15] & 255) != trie$okio[i22]) {
                        return i17;
                    }
                    boolean z12 = i26 == i24;
                    if (i25 == i16) {
                        Segment segment4 = segment3.next;
                        i14 = segment4.pos;
                        byte[] bArr2 = segment4.data;
                        i13 = segment4.limit;
                        if (segment4 == segment2) {
                            if (!z12) {
                                break loop0;
                            }
                            bArr = bArr2;
                            segment = null;
                        } else {
                            byte[] bArr3 = bArr2;
                            segment = segment4;
                            bArr = bArr3;
                        }
                    } else {
                        Segment segment5 = segment3;
                        i13 = i16;
                        i14 = i25;
                        segment = segment5;
                    }
                    if (z12) {
                        i12 = trie$okio[i26];
                        i11 = i14;
                        i16 = i13;
                        segment3 = segment;
                        break;
                    }
                    i15 = i14;
                    i16 = i13;
                    i22 = i26;
                    segment3 = segment;
                }
            } else {
                i11 = i15 + 1;
                byte b11 = bArr[i15] & 255;
                int i27 = i22 + i21;
                while (i22 != i27) {
                    if (b11 == trie$okio[i22]) {
                        i12 = trie$okio[i22 + i21];
                        if (i11 == i16) {
                            segment3 = segment3.next;
                            i11 = segment3.pos;
                            bArr = segment3.data;
                            i16 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i22++;
                    }
                }
                return i17;
            }
            if (i12 >= 0) {
                return i12;
            }
            i18 = -i12;
            i15 = i11;
        }
        if (z11) {
            return -2;
        }
        return i17;
    }

    public static /* synthetic */ int selectPrefix$default(okio.Buffer buffer, Options options, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return selectPrefix(buffer, options, z11);
    }

    public static final int commonRead(okio.Buffer buffer, byte[] bArr, int i11, int i12) {
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i11, (long) i12);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i12, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i13 = segment.pos;
        byte[] unused = ArraysKt___ArraysJvmKt.e(bArr2, bArr, i11, i13, i13 + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - ((long) min));
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public static final byte[] commonReadByteArray(okio.Buffer buffer, long j11) {
        if (!(j11 >= 0 && j11 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j11).toString());
        } else if (buffer.size() >= j11) {
            byte[] bArr = new byte[((int) j11)];
            buffer.readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public static final ByteString commonReadByteString(okio.Buffer buffer, long j11) {
        if (!(j11 >= 0 && j11 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j11).toString());
        } else if (buffer.size() < j11) {
            throw new EOFException();
        } else if (j11 < 4096) {
            return new ByteString(buffer.readByteArray(j11));
        } else {
            ByteString snapshot = buffer.snapshot((int) j11);
            buffer.skip(j11);
            return snapshot;
        }
    }

    public static final okio.Buffer commonWrite(okio.Buffer buffer, byte[] bArr) {
        return buffer.write(bArr, 0, bArr.length);
    }

    public static final okio.Buffer commonWrite(okio.Buffer buffer, byte[] bArr, int i11, int i12) {
        long j11 = (long) i12;
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i11, j11);
        int i13 = i12 + i11;
        while (i11 < i13) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i13 - i11, 8192 - writableSegment$okio.limit);
            int i14 = i11 + min;
            byte[] unused = ArraysKt___ArraysJvmKt.e(bArr, writableSegment$okio.data, writableSegment$okio.limit, i11, i14);
            writableSegment$okio.limit += min;
            i11 = i14;
        }
        buffer.setSize$okio(buffer.size() + j11);
        return buffer;
    }

    public static final void commonReadFully(okio.Buffer buffer, okio.Buffer buffer2, long j11) {
        if (buffer.size() >= j11) {
            buffer2.write(buffer, j11);
        } else {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    public static final ByteString commonSnapshot(okio.Buffer buffer, int i11) {
        if (i11 == 0) {
            return ByteString.EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(buffer.size(), 0, (long) i11);
        Segment segment = buffer.head;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            int i15 = segment.limit;
            int i16 = segment.pos;
            if (i15 != i16) {
                i13 += i15 - i16;
                i14++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i14][];
        int[] iArr = new int[(i14 * 2)];
        Segment segment2 = buffer.head;
        int i17 = 0;
        while (i12 < i11) {
            bArr[i17] = segment2.data;
            i12 += segment2.limit - segment2.pos;
            iArr[i17] = Math.min(i12, i11);
            iArr[i17 + i14] = segment2.pos;
            segment2.shared = true;
            i17++;
            segment2 = segment2.next;
        }
        return new C0892SegmentedByteString(bArr, iArr);
    }

    public static final okio.Buffer commonWrite(okio.Buffer buffer, Source source, long j11) {
        while (j11 > 0) {
            long read = source.read(buffer, j11);
            if (read != -1) {
                j11 -= read;
            } else {
                throw new EOFException();
            }
        }
        return buffer;
    }

    public static final long commonRead(okio.Buffer buffer, okio.Buffer buffer2, long j11) {
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        } else if (buffer.size() == 0) {
            return -1;
        } else {
            if (j11 > buffer.size()) {
                j11 = buffer.size();
            }
            buffer2.write(buffer, j11);
            return j11;
        }
    }

    public static final void commonWrite(okio.Buffer buffer, okio.Buffer buffer2, long j11) {
        if (buffer2 != buffer) {
            SegmentedByteString.checkOffsetAndCount(buffer2.size(), 0, j11);
            while (j11 > 0) {
                if (j11 < ((long) (buffer2.head.limit - buffer2.head.pos))) {
                    Segment segment = buffer.head;
                    Segment segment2 = segment != null ? segment.prev : null;
                    if (segment2 != null && segment2.owner) {
                        if ((((long) segment2.limit) + j11) - ((long) (segment2.shared ? 0 : segment2.pos)) <= 8192) {
                            buffer2.head.writeTo(segment2, (int) j11);
                            buffer2.setSize$okio(buffer2.size() - j11);
                            buffer.setSize$okio(buffer.size() + j11);
                            return;
                        }
                    }
                    buffer2.head = buffer2.head.split((int) j11);
                }
                Segment segment3 = buffer2.head;
                long j12 = (long) (segment3.limit - segment3.pos);
                buffer2.head = segment3.pop();
                Segment segment4 = buffer.head;
                if (segment4 == null) {
                    buffer.head = segment3;
                    segment3.prev = segment3;
                    segment3.next = segment3;
                } else {
                    segment4.prev.push(segment3).compact();
                }
                buffer2.setSize$okio(buffer2.size() - j12);
                buffer.setSize$okio(buffer.size() + j12);
                j11 -= j12;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonIndexOf(okio.Buffer buffer, ByteString byteString, long j11) {
        long j12;
        int i11;
        long j13 = j11;
        if (byteString.size() > 0) {
            long j14 = 0;
            if (j13 >= 0) {
                Segment segment = buffer.head;
                if (segment == null) {
                    return -1;
                }
                if (buffer.size() - j13 < j13) {
                    j12 = buffer.size();
                    while (j12 > j13) {
                        segment = segment.prev;
                        j12 -= (long) (segment.limit - segment.pos);
                    }
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    byte b11 = internalArray$okio[0];
                    int size = byteString.size();
                    long size2 = (buffer.size() - ((long) size)) + 1;
                    while (j12 < size2) {
                        byte[] bArr = segment.data;
                        int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size2) - j12);
                        i11 = (int) ((((long) segment.pos) + j13) - j12);
                        while (i11 < min) {
                            if (bArr[i11] != b11 || !rangeEquals(segment, i11 + 1, internalArray$okio, 1, size)) {
                                i11++;
                            }
                        }
                        j12 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        j13 = j12;
                    }
                    return -1;
                }
                while (true) {
                    long j15 = ((long) (segment.limit - segment.pos)) + j14;
                    if (j15 > j13) {
                        break;
                    }
                    segment = segment.next;
                    j14 = j15;
                }
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                byte b12 = internalArray$okio2[0];
                int size3 = byteString.size();
                long size4 = (buffer.size() - ((long) size3)) + 1;
                long j16 = j14;
                while (j12 < size4) {
                    byte[] bArr2 = segment.data;
                    byte b13 = b12;
                    int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + size4) - j12);
                    int i12 = (int) ((((long) segment.pos) + j13) - j12);
                    while (i11 < min2) {
                        byte b14 = b13;
                        if (bArr2[i11] == b14) {
                            if (rangeEquals(segment, i11 + 1, internalArray$okio2, 1, size3)) {
                            }
                        }
                        i12 = i11 + 1;
                        b13 = b14;
                    }
                    b12 = b13;
                    j16 = j12 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    j13 = j16;
                }
                return -1;
                return ((long) (i11 - segment.pos)) + j12;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j13).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }
}
