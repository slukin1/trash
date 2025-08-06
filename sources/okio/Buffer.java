package okio;

import com.google.common.base.Ascii;
import com.huochat.community.util.FileTool;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.x;
import kotlin.text.b;
import net.sf.scuba.smartcards.ISO7816;
import okhttp3.internal.connection.RealConnection;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    private long size;

    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        private Segment segment;
        public int start = -1;

        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                setSegment$okio((Segment) null);
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final long expandBuffer(int i11) {
            boolean z11 = true;
            if (i11 > 0) {
                if (i11 > 8192) {
                    z11 = false;
                }
                if (z11) {
                    Buffer buffer2 = this.buffer;
                    if (buffer2 == null) {
                        throw new IllegalStateException("not attached to a buffer".toString());
                    } else if (this.readWrite) {
                        long size = buffer2.size();
                        Segment writableSegment$okio = buffer2.writableSegment$okio(i11);
                        int i12 = 8192 - writableSegment$okio.limit;
                        writableSegment$okio.limit = 8192;
                        long j11 = (long) i12;
                        buffer2.setSize$okio(size + j11);
                        setSegment$okio(writableSegment$okio);
                        this.offset = size;
                        this.data = writableSegment$okio.data;
                        this.start = 8192 - i12;
                        this.end = 8192;
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

        public final Segment getSegment$okio() {
            return this.segment;
        }

        public final int next() {
            if (this.offset != this.buffer.size()) {
                long j11 = this.offset;
                return seek(j11 == -1 ? 0 : j11 + ((long) (this.end - this.start)));
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        public final long resizeBuffer(long j11) {
            long j12 = j11;
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            } else if (this.readWrite) {
                long size = buffer2.size();
                int i11 = (j12 > size ? 1 : (j12 == size ? 0 : -1));
                int i12 = 1;
                if (i11 <= 0) {
                    if (j12 >= 0) {
                        long j13 = size - j12;
                        while (true) {
                            if (j13 <= 0) {
                                break;
                            }
                            Segment segment2 = buffer2.head.prev;
                            int i13 = segment2.limit;
                            long j14 = (long) (i13 - segment2.pos);
                            if (j14 > j13) {
                                segment2.limit = i13 - ((int) j13);
                                break;
                            }
                            buffer2.head = segment2.pop();
                            SegmentPool.recycle(segment2);
                            j13 -= j14;
                        }
                        setSegment$okio((Segment) null);
                        this.offset = j12;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException(("newSize < 0: " + j12).toString());
                    }
                } else if (i11 > 0) {
                    long j15 = j12 - size;
                    boolean z11 = true;
                    while (j15 > 0) {
                        Segment writableSegment$okio = buffer2.writableSegment$okio(i12);
                        int min = (int) Math.min(j15, (long) (8192 - writableSegment$okio.limit));
                        writableSegment$okio.limit += min;
                        j15 -= (long) min;
                        if (z11) {
                            setSegment$okio(writableSegment$okio);
                            this.offset = size;
                            this.data = writableSegment$okio.data;
                            int i14 = writableSegment$okio.limit;
                            this.start = i14 - min;
                            this.end = i14;
                            z11 = false;
                        }
                        i12 = 1;
                    }
                }
                buffer2.setSize$okio(j12);
                return size;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
        }

        public final int seek(long j11) {
            Segment segment2;
            Buffer buffer2 = this.buffer;
            if (buffer2 != null) {
                int i11 = (j11 > -1 ? 1 : (j11 == -1 ? 0 : -1));
                if (i11 < 0 || j11 > buffer2.size()) {
                    throw new ArrayIndexOutOfBoundsException("offset=" + j11 + " > size=" + buffer2.size());
                } else if (i11 == 0 || j11 == buffer2.size()) {
                    setSegment$okio((Segment) null);
                    this.offset = j11;
                    this.data = null;
                    this.start = -1;
                    this.end = -1;
                    return -1;
                } else {
                    long j12 = 0;
                    long size = buffer2.size();
                    Segment segment3 = buffer2.head;
                    if (getSegment$okio() != null) {
                        long j13 = this.offset - ((long) (this.start - getSegment$okio().pos));
                        if (j13 > j11) {
                            Segment segment4 = segment3;
                            segment3 = getSegment$okio();
                            size = j13;
                            segment2 = segment4;
                        } else {
                            long j14 = j13;
                            segment2 = getSegment$okio();
                            j12 = j14;
                        }
                    } else {
                        segment2 = segment3;
                    }
                    if (size - j11 > j11 - j12) {
                        while (true) {
                            int i12 = segment2.limit;
                            int i13 = segment2.pos;
                            if (j11 < ((long) (i12 - i13)) + j12) {
                                break;
                            }
                            j12 += (long) (i12 - i13);
                            segment2 = segment2.next;
                        }
                    } else {
                        while (size > j11) {
                            segment3 = segment3.prev;
                            size -= (long) (segment3.limit - segment3.pos);
                        }
                        j12 = size;
                        segment2 = segment3;
                    }
                    if (this.readWrite && segment2.shared) {
                        Segment unsharedCopy = segment2.unsharedCopy();
                        if (buffer2.head == segment2) {
                            buffer2.head = unsharedCopy;
                        }
                        segment2 = segment2.push(unsharedCopy);
                        segment2.prev.pop();
                    }
                    setSegment$okio(segment2);
                    this.offset = j11;
                    this.data = segment2.data;
                    int i14 = segment2.pos + ((int) (j11 - j12));
                    this.start = i14;
                    int i15 = segment2.limit;
                    this.end = i15;
                    return i15 - i14;
                }
            } else {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
        }

        public final void setSegment$okio(Segment segment2) {
            this.segment = segment2;
        }
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, OutputStream outputStream, long j11, long j12, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        long j13 = j11;
        if ((i11 & 4) != 0) {
            j12 = buffer.size - j13;
        }
        return buffer.copyTo(outputStream, j13, j12);
    }

    private final ByteString digest(String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        Segment segment = this.head;
        if (segment != null) {
            byte[] bArr = segment.data;
            int i11 = segment.pos;
            instance.update(bArr, i11, segment.limit - i11);
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                byte[] bArr2 = segment2.data;
                int i12 = segment2.pos;
                instance.update(bArr2, i12, segment2.limit - i12);
            }
        }
        return new ByteString(instance.digest());
    }

    private final ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.internalArray$okio(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i11 = segment.pos;
                instance.update(bArr, i11, segment.limit - i11);
                for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                    byte[] bArr2 = segment2.data;
                    int i12 = segment2.pos;
                    instance.update(bArr2, i12, segment2.limit - i12);
                }
            }
            return new ByteString(instance.doFinal());
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            unsafeCursor = SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(unsafeCursor);
    }

    public static /* synthetic */ UnsafeCursor readUnsafe$default(Buffer buffer, UnsafeCursor unsafeCursor, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            unsafeCursor = SegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readUnsafe(unsafeCursor);
    }

    public static /* synthetic */ Buffer writeTo$default(Buffer buffer, OutputStream outputStream, long j11, int i11, Object obj) throws IOException {
        if ((i11 & 2) != 0) {
            j11 = buffer.size;
        }
        return buffer.writeTo(outputStream, j11);
    }

    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m3220deprecated_getByte(long j11) {
        return getByte(j11);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final long m3221deprecated_size() {
        return this.size;
    }

    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        skip(size());
    }

    public void close() {
    }

    public final long completeSegmentByteCount() {
        long size2 = size();
        if (size2 == 0) {
            return 0;
        }
        Segment segment = this.head.prev;
        int i11 = segment.limit;
        if (i11 < 8192 && segment.owner) {
            size2 -= (long) (i11 - segment.pos);
        }
        return size2;
    }

    public final Buffer copy() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.head;
            Segment sharedCopy = segment.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = sharedCopy;
            sharedCopy.next = sharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                sharedCopy.prev.push(segment2.sharedCopy());
            }
            buffer.setSize$okio(size());
        }
        return buffer;
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo$default(this, outputStream, 0, 0, 6, (Object) null);
    }

    public final Buffer copyTo(OutputStream outputStream, long j11) throws IOException {
        return copyTo$default(this, outputStream, j11, 0, 4, (Object) null);
    }

    public final Buffer copyTo(OutputStream outputStream, long j11, long j12) throws IOException {
        SegmentedByteString.checkOffsetAndCount(this.size, j11, j12);
        if (j12 == 0) {
            return this;
        }
        Segment segment = this.head;
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
            outputStream.write(segment.data, i13, min);
            j12 -= (long) min;
            segment = segment.next;
            j11 = 0;
        }
        return this;
    }

    public Buffer emit() {
        return this;
    }

    public Buffer emitCompleteSegments() {
        return this;
    }

    /* JADX WARNING: type inference failed for: r21v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x000b
        L_0x0008:
            r2 = r3
            goto L_0x0075
        L_0x000b:
            boolean r4 = r1 instanceof okio.Buffer
            if (r4 != 0) goto L_0x0010
            goto L_0x0075
        L_0x0010:
            long r4 = r20.size()
            okio.Buffer r1 = (okio.Buffer) r1
            long r6 = r1.size()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
            goto L_0x0075
        L_0x001f:
            long r4 = r20.size()
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x002a
            goto L_0x0008
        L_0x002a:
            okio.Segment r4 = r0.head
            okio.Segment r1 = r1.head
            int r5 = r4.pos
            int r8 = r1.pos
            r9 = r6
        L_0x0033:
            long r11 = r20.size()
            int r11 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0008
            int r11 = r4.limit
            int r11 = r11 - r5
            int r12 = r1.limit
            int r12 = r12 - r8
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = r6
        L_0x0047:
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x0063
            byte[] r15 = r4.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.data
            int r17 = r8 + 1
            byte r8 = r15[r8]
            if (r5 == r8) goto L_0x005a
            goto L_0x0075
        L_0x005a:
            r18 = 1
            long r13 = r13 + r18
            r5 = r16
            r8 = r17
            goto L_0x0047
        L_0x0063:
            int r13 = r4.limit
            if (r5 != r13) goto L_0x006b
            okio.Segment r4 = r4.next
            int r5 = r4.pos
        L_0x006b:
            int r13 = r1.limit
            if (r8 != r13) goto L_0x0073
            okio.Segment r1 = r1.next
            int r8 = r1.pos
        L_0x0073:
            long r9 = r9 + r11
            goto L_0x0033
        L_0x0075:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.equals(java.lang.Object):boolean");
    }

    public boolean exhausted() {
        return this.size == 0;
    }

    public void flush() {
    }

    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j11) {
        SegmentedByteString.checkOffsetAndCount(size(), j11, 1);
        Segment segment = this.head;
        Objects.requireNonNull(segment);
        if (size() - j11 < j11) {
            long size2 = size();
            while (size2 > j11) {
                segment = segment.prev;
                size2 -= (long) (segment.limit - segment.pos);
            }
            return segment.data[(int) ((((long) segment.pos) + j11) - size2)];
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

    public int hashCode() {
        Segment segment = this.head;
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
        } while (segment != this.head);
        return i11;
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    public long indexOf(byte b11) {
        return indexOf(b11, 0, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public InputStream inputStream() {
        return new Buffer$inputStream$1(this);
    }

    public boolean isOpen() {
        return true;
    }

    public final ByteString md5() {
        return digest(FileTool.HASH_TYPE_MD5);
    }

    public OutputStream outputStream() {
        return new Buffer$outputStream$1(this);
    }

    public BufferedSource peek() {
        return Okio.buffer((Source) new PeekSource(this));
    }

    public boolean rangeEquals(long j11, ByteString byteString) {
        return rangeEquals(j11, byteString, 0, byteString.size());
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i11 = segment.pos + min;
        segment.pos = i11;
        this.size -= (long) min;
        if (i11 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public long readAll(Sink sink) throws IOException {
        long size2 = size();
        if (size2 > 0) {
            sink.write(this, size2);
        }
        return size2;
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, (UnsafeCursor) null, 1, (Object) null);
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        return okio.internal.Buffer.commonReadAndWriteUnsafe(this, unsafeCursor);
    }

    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.head;
            int i11 = segment.pos;
            int i12 = segment.limit;
            int i13 = i11 + 1;
            byte b11 = segment.data[i11];
            setSize$okio(size() - 1);
            if (i13 == i12) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i13;
            }
            return b11;
        }
        throw new EOFException();
    }

    public byte[] readByteArray() {
        return readByteArray(size());
    }

    public ByteString readByteString() {
        return readByteString(size());
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
        if (size() == 0) goto L_0x00dc;
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
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio.SegmentedByteString.toHexString(getByte(0)));
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
    public long readDecimalLong() throws java.io.EOFException {
        /*
            r18 = this;
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
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.Buffer r1 = r1.writeDecimalLong((long) r8)
            okio.Buffer r1 = r1.writeByte((int) r15)
            if (r6 != 0) goto L_0x0051
            r1.readByte()
        L_0x0051:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            r3.append(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
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
            byte r1 = r0.getByte(r4)
            java.lang.String r1 = okio.SegmentedByteString.toHexString((byte) r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x00dc:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        L_0x00e2:
            if (r6 == 0) goto L_0x00e5
            goto L_0x00e6
        L_0x00e5:
            long r8 = -r8
        L_0x00e6:
            return r8
        L_0x00e7:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public void readFully(Buffer buffer, long j11) throws EOFException {
        if (size() >= j11) {
            buffer.write(this, j11);
        } else {
            buffer.write(this, size());
            throw new EOFException();
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
    public long readHexadecimalUnsignedLong() throws java.io.EOFException {
        /*
            r14 = this;
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
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong((long) r4)
            okio.Buffer r0 = r0.writeByte((int) r10)
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
        L_0x0074:
            if (r0 == 0) goto L_0x0078
            r1 = 1
            goto L_0x0093
        L_0x0078:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = okio.SegmentedByteString.toHexString((byte) r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
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
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.head;
            int i11 = segment.pos;
            int i12 = segment.limit;
            if (((long) (i12 - i11)) < 4) {
                return ((readByte() & 255) << Ascii.CAN) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            int i13 = i11 + 1;
            int i14 = i13 + 1;
            byte b11 = ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i13] & 255) << 16);
            int i15 = i14 + 1;
            byte b12 = b11 | ((bArr[i14] & 255) << 8);
            int i16 = i15 + 1;
            byte b13 = b12 | (bArr[i15] & 255);
            setSize$okio(size() - 4);
            if (i16 == i12) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i16;
            }
            return b13;
        }
        throw new EOFException();
    }

    public int readIntLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readInt());
    }

    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.head;
            int i11 = segment.pos;
            int i12 = segment.limit;
            if (((long) (i12 - i11)) < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
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
            setSize$okio(size() - 8);
            if (i21 == i12) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i21;
            }
            return j12;
        }
        throw new EOFException();
    }

    public long readLongLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readLong());
    }

    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.head;
            int i11 = segment.pos;
            int i12 = segment.limit;
            if (i12 - i11 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i13 = i11 + 1;
            int i14 = i13 + 1;
            byte b11 = ((bArr[i11] & 255) << 8) | (bArr[i13] & 255);
            setSize$okio(size() - 2);
            if (i14 == i12) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i14;
            }
            return (short) b11;
        }
        throw new EOFException();
    }

    public short readShortLe() throws EOFException {
        return SegmentedByteString.reverseBytes(readShort());
    }

    public String readString(Charset charset) {
        return readString(this.size, charset);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, (UnsafeCursor) null, 1, (Object) null);
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        return okio.internal.Buffer.commonReadUnsafe(this, unsafeCursor);
    }

    public String readUtf8() {
        return readString(this.size, b.f56908b);
    }

    public int readUtf8CodePoint() throws EOFException {
        byte b11;
        int i11;
        byte b12;
        if (size() != 0) {
            byte b13 = getByte(0);
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
                skip(1);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j11 = (long) i11;
            if (size() >= j11) {
                int i12 = 1;
                while (i12 < i11) {
                    long j12 = (long) i12;
                    byte b14 = getByte(j12);
                    if ((b14 & ISO7816.INS_GET_RESPONSE) == 128) {
                        b12 = (b12 << 6) | (b14 & Utf8.REPLACEMENT_BYTE);
                        i12++;
                    } else {
                        skip(j12);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                skip(j11);
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
            throw new EOFException("size < " + i11 + l.f34627b + size() + " (to read code point prefixed 0x" + SegmentedByteString.toHexString(b13) + ')');
        }
        throw new EOFException();
    }

    public String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return okio.internal.Buffer.readUtf8Line(this, indexOf);
        }
        if (size() != 0) {
            return readUtf8(size());
        }
        return null;
    }

    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public boolean request(long j11) {
        return this.size >= j11;
    }

    public void require(long j11) throws EOFException {
        if (this.size < j11) {
            throw new EOFException();
        }
    }

    public int select(Options options) {
        int selectPrefix$default = okio.internal.Buffer.selectPrefix$default(this, options, false, 2, (Object) null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public final void setSize$okio(long j11) {
        this.size = j11;
    }

    public final ByteString sha1() {
        return digest(McElieceCCA2KeyGenParameterSpec.SHA1);
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    public final long size() {
        return this.size;
    }

    public void skip(long j11) throws EOFException {
        while (j11 > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j11, (long) (segment.limit - segment.pos));
                long j12 = (long) min;
                setSize$okio(size() - j12);
                j11 -= j12;
                int i11 = segment.pos + min;
                segment.pos = i11;
                if (i11 == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final ByteString snapshot() {
        if (size() <= 2147483647L) {
            return snapshot((int) size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + size()).toString());
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public final Segment writableSegment$okio(int i11) {
        boolean z11 = true;
        if (i11 < 1 || i11 > 8192) {
            z11 = false;
        }
        if (z11) {
            Segment segment = this.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                this.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            Segment segment2 = segment.prev;
            if (segment2.limit + i11 > 8192 || !segment2.owner) {
                return segment2.push(SegmentPool.take());
            }
            return segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    public long writeAll(Source source) throws IOException {
        long j11 = 0;
        while (true) {
            long read = source.read(this, 8192);
            if (read == -1) {
                return j11;
            }
            j11 += read;
        }
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo$default(this, outputStream, 0, 2, (Object) null);
    }

    public final Buffer writeTo(OutputStream outputStream, long j11) throws IOException {
        SegmentedByteString.checkOffsetAndCount(this.size, 0, j11);
        Segment segment = this.head;
        while (j11 > 0) {
            int min = (int) Math.min(j11, (long) (segment.limit - segment.pos));
            outputStream.write(segment.data, segment.pos, min);
            int i11 = segment.pos + min;
            segment.pos = i11;
            long j12 = (long) min;
            this.size -= j12;
            j11 -= j12;
            if (i11 == segment.limit) {
                Segment pop = segment.pop();
                this.head = pop;
                SegmentPool.recycle(segment);
                segment = pop;
            }
        }
        return this;
    }

    public Buffer clone() {
        return copy();
    }

    public long indexOf(byte b11, long j11) {
        return indexOf(b11, j11, Long.MAX_VALUE);
    }

    public long indexOfElement(ByteString byteString, long j11) {
        int i11;
        long j12;
        int i12;
        int i13;
        long j13 = 0;
        if (j11 >= 0) {
            Segment segment = this.head;
            if (segment == null) {
                return -1;
            }
            if (size() - j11 < j11) {
                j12 = size();
                while (j12 > j11) {
                    segment = segment.prev;
                    j12 -= (long) (segment.limit - segment.pos);
                }
                if (byteString.size() == 2) {
                    byte b11 = byteString.getByte(0);
                    byte b12 = byteString.getByte(1);
                    while (j12 < size()) {
                        byte[] bArr = segment.data;
                        i11 = (int) ((((long) segment.pos) + j11) - j12);
                        int i14 = segment.limit;
                        while (i11 < i14) {
                            byte b13 = bArr[i11];
                            if (!(b13 == b11 || b13 == b12)) {
                                i11++;
                            }
                        }
                        j12 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        j11 = j12;
                    }
                    return -1;
                }
                byte[] internalArray$okio = byteString.internalArray$okio();
                while (j12 < size()) {
                    byte[] bArr2 = segment.data;
                    i13 = (int) ((((long) segment.pos) + j11) - j12);
                    int i15 = segment.limit;
                    while (i13 < i15) {
                        byte b14 = bArr2[i13];
                        for (byte b15 : internalArray$okio) {
                            if (b14 == b15) {
                                i12 = segment.pos;
                                return ((long) (i11 - i12)) + j12;
                            }
                        }
                        i13++;
                    }
                    j12 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    j11 = j12;
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
                while (j12 < size()) {
                    byte[] bArr3 = segment.data;
                    int i16 = (int) ((((long) segment.pos) + j11) - j12);
                    int i17 = segment.limit;
                    while (i11 < i17) {
                        byte b18 = bArr3[i11];
                        if (!(b18 == b16 || b18 == b17)) {
                            i16 = i11 + 1;
                        }
                    }
                    j13 = j12 + ((long) (segment.limit - segment.pos));
                    segment = segment.next;
                    j11 = j13;
                }
                return -1;
            }
            byte[] internalArray$okio2 = byteString.internalArray$okio();
            while (j12 < size()) {
                byte[] bArr4 = segment.data;
                int i18 = (int) ((((long) segment.pos) + j11) - j12);
                int i19 = segment.limit;
                while (i13 < i19) {
                    byte b19 = bArr4[i13];
                    for (byte b21 : internalArray$okio2) {
                        if (b19 == b21) {
                            i12 = segment.pos;
                            return ((long) (i11 - i12)) + j12;
                        }
                    }
                    i18 = i13 + 1;
                }
                j13 = j12 + ((long) (segment.limit - segment.pos));
                segment = segment.next;
                j11 = j13;
            }
            return -1;
            i12 = segment.pos;
            return ((long) (i11 - i12)) + j12;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j11).toString());
    }

    public boolean rangeEquals(long j11, ByteString byteString, int i11, int i12) {
        if (j11 < 0 || i11 < 0 || i12 < 0 || size() - j11 < ((long) i12) || byteString.size() - i11 < i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (getByte(((long) i13) + j11) != byteString.getByte(i11 + i13)) {
                return false;
            }
        }
        return true;
    }

    public byte[] readByteArray(long j11) throws EOFException {
        if (!(j11 >= 0 && j11 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j11).toString());
        } else if (size() >= j11) {
            byte[] bArr = new byte[((int) j11)];
            readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    public ByteString readByteString(long j11) throws EOFException {
        if (!(j11 >= 0 && j11 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j11).toString());
        } else if (size() < j11) {
            throw new EOFException();
        } else if (j11 < 4096) {
            return new ByteString(readByteArray(j11));
        } else {
            ByteString snapshot = snapshot((int) j11);
            skip(j11);
            return snapshot;
        }
    }

    public final Buffer readFrom(InputStream inputStream, long j11) throws IOException {
        if (j11 >= 0) {
            readFrom(inputStream, j11, false);
            return this;
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
    }

    public String readString(long j11, Charset charset) throws EOFException {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (!(i11 >= 0 && j11 <= 2147483647L)) {
            throw new IllegalArgumentException(("byteCount: " + j11).toString());
        } else if (this.size < j11) {
            throw new EOFException();
        } else if (i11 == 0) {
            return "";
        } else {
            Segment segment = this.head;
            int i12 = segment.pos;
            if (((long) i12) + j11 > ((long) segment.limit)) {
                return new String(readByteArray(j11), charset);
            }
            int i13 = (int) j11;
            String str = new String(segment.data, i12, i13, charset);
            int i14 = segment.pos + i13;
            segment.pos = i14;
            this.size -= j11;
            if (i14 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        }
    }

    public String readUtf8(long j11) throws EOFException {
        return readString(j11, b.f56908b);
    }

    public String readUtf8LineStrict(long j11) throws EOFException {
        if (j11 >= 0) {
            long j12 = Long.MAX_VALUE;
            if (j11 != Long.MAX_VALUE) {
                j12 = j11 + 1;
            }
            long indexOf = indexOf((byte) 10, 0, j12);
            if (indexOf != -1) {
                return okio.internal.Buffer.readUtf8Line(this, indexOf);
            }
            if (j12 < size() && getByte(j12 - 1) == 13 && getByte(j12) == 10) {
                return okio.internal.Buffer.readUtf8Line(this, j12);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min((long) 32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j11) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException(("limit < 0: " + j11).toString());
    }

    public Buffer writeByte(int i11) {
        Segment writableSegment$okio = writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        writableSegment$okio.limit = i12 + 1;
        bArr[i12] = (byte) i11;
        setSize$okio(size() + 1);
        return this;
    }

    public Buffer writeDecimalLong(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 == 0) {
            return writeByte(48);
        }
        boolean z11 = false;
        int i12 = 1;
        if (i11 < 0) {
            j11 = -j11;
            if (j11 < 0) {
                return writeUtf8("-9223372036854775808");
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
        Segment writableSegment$okio = writableSegment$okio(i12);
        byte[] bArr = writableSegment$okio.data;
        int i13 = writableSegment$okio.limit + i12;
        while (j11 != 0) {
            long j12 = (long) 10;
            i13--;
            bArr[i13] = okio.internal.Buffer.getHEX_DIGIT_BYTES()[(int) (j11 % j12)];
            j11 /= j12;
        }
        if (z11) {
            bArr[i13 - 1] = Framer.STDIN_FRAME_PREFIX;
        }
        writableSegment$okio.limit += i12;
        setSize$okio(size() + ((long) i12));
        return this;
    }

    public Buffer writeHexadecimalUnsignedLong(long j11) {
        if (j11 == 0) {
            return writeByte(48);
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
        Segment writableSegment$okio = writableSegment$okio(i11);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        for (int i13 = (i12 + i11) - 1; i13 >= i12; i13--) {
            bArr[i13] = okio.internal.Buffer.getHEX_DIGIT_BYTES()[(int) (15 & j11)];
            j11 >>>= 4;
        }
        writableSegment$okio.limit += i11;
        setSize$okio(size() + ((long) i11));
        return this;
    }

    public Buffer writeInt(int i11) {
        Segment writableSegment$okio = writableSegment$okio(4);
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
        setSize$okio(size() + 4);
        return this;
    }

    public Buffer writeIntLe(int i11) {
        return writeInt(SegmentedByteString.reverseBytes(i11));
    }

    public Buffer writeLong(long j11) {
        Segment writableSegment$okio = writableSegment$okio(8);
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
        setSize$okio(size() + 8);
        return this;
    }

    public Buffer writeLongLe(long j11) {
        return writeLong(SegmentedByteString.reverseBytes(j11));
    }

    public Buffer writeShort(int i11) {
        Segment writableSegment$okio = writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i12 = writableSegment$okio.limit;
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i11 >>> 8) & 255);
        bArr[i13] = (byte) (i11 & 255);
        writableSegment$okio.limit = i13 + 1;
        setSize$okio(size() + 2);
        return this;
    }

    public Buffer writeShortLe(int i11) {
        return writeShort((int) SegmentedByteString.reverseBytes((short) i11));
    }

    public Buffer writeUtf8CodePoint(int i11) {
        if (i11 < 128) {
            writeByte(i11);
        } else if (i11 < 2048) {
            Segment writableSegment$okio = writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i12 = writableSegment$okio.limit;
            bArr[i12] = (byte) ((i11 >> 6) | 192);
            bArr[i12 + 1] = (byte) ((i11 & 63) | 128);
            writableSegment$okio.limit = i12 + 2;
            setSize$okio(size() + 2);
        } else {
            boolean z11 = false;
            if (55296 <= i11 && i11 < 57344) {
                z11 = true;
            }
            if (z11) {
                writeByte(63);
            } else if (i11 < 65536) {
                Segment writableSegment$okio2 = writableSegment$okio(3);
                byte[] bArr2 = writableSegment$okio2.data;
                int i13 = writableSegment$okio2.limit;
                bArr2[i13] = (byte) ((i11 >> 12) | 224);
                bArr2[i13 + 1] = (byte) (((i11 >> 6) & 63) | 128);
                bArr2[i13 + 2] = (byte) ((i11 & 63) | 128);
                writableSegment$okio2.limit = i13 + 3;
                setSize$okio(size() + 3);
            } else if (i11 <= 1114111) {
                Segment writableSegment$okio3 = writableSegment$okio(4);
                byte[] bArr3 = writableSegment$okio3.data;
                int i14 = writableSegment$okio3.limit;
                bArr3[i14] = (byte) ((i11 >> 18) | 240);
                bArr3[i14 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                bArr3[i14 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                bArr3[i14 + 3] = (byte) ((i11 & 63) | 128);
                writableSegment$okio3.limit = i14 + 4;
                setSize$okio(size() + 4);
            } else {
                throw new IllegalArgumentException("Unexpected code point: 0x" + SegmentedByteString.toHexString(i11));
            }
        }
        return this;
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j11, long j12, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        return buffer.copyTo(buffer2, j11, j12);
    }

    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    public static /* synthetic */ Buffer copyTo$default(Buffer buffer, Buffer buffer2, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 0;
        }
        return buffer.copyTo(buffer2, j11);
    }

    private final void readFrom(InputStream inputStream, long j11, boolean z11) throws IOException {
        while (true) {
            if (j11 > 0 || z11) {
                Segment writableSegment$okio = writableSegment$okio(1);
                int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j11, (long) (8192 - writableSegment$okio.limit)));
                if (read == -1) {
                    if (writableSegment$okio.pos == writableSegment$okio.limit) {
                        this.head = writableSegment$okio.pop();
                        SegmentPool.recycle(writableSegment$okio);
                    }
                    if (!z11) {
                        throw new EOFException();
                    }
                    return;
                }
                writableSegment$okio.limit += read;
                long j12 = (long) read;
                this.size += j12;
                j11 -= j12;
            } else {
                return;
            }
        }
    }

    public long indexOf(byte b11, long j11, long j12) {
        Segment segment;
        int i11;
        long j13;
        long j14 = 0;
        boolean z11 = false;
        if (0 <= j11 && j11 <= j12) {
            z11 = true;
        }
        if (z11) {
            if (j12 > size()) {
                j12 = size();
            }
            if (j11 == j12 || (segment = this.head) == null) {
                return -1;
            }
            if (size() - j11 < j11) {
                j13 = size();
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
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j11 + " toIndex=" + j12).toString());
    }

    public final ByteString snapshot(int i11) {
        if (i11 == 0) {
            return ByteString.EMPTY;
        }
        SegmentedByteString.checkOffsetAndCount(size(), 0, (long) i11);
        Segment segment = this.head;
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
        Segment segment2 = this.head;
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

    public Buffer writeUtf8(String str, int i11, int i12) {
        char charAt;
        if (i11 >= 0) {
            if (i12 >= i11) {
                if (i12 <= str.length()) {
                    while (i11 < i12) {
                        char charAt2 = str.charAt(i11);
                        if (charAt2 < 128) {
                            Segment writableSegment$okio = writableSegment$okio(1);
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
                                    setSize$okio(size() + ((long) i16));
                                } else {
                                    i14 = i11 + 1;
                                    bArr[i11 + i13] = (byte) charAt;
                                }
                            }
                            int i152 = writableSegment$okio.limit;
                            int i162 = (i13 + i11) - i152;
                            writableSegment$okio.limit = i152 + i162;
                            setSize$okio(size() + ((long) i162));
                        } else {
                            if (charAt2 < 2048) {
                                Segment writableSegment$okio2 = writableSegment$okio(2);
                                byte[] bArr2 = writableSegment$okio2.data;
                                int i17 = writableSegment$okio2.limit;
                                bArr2[i17] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i17 + 1] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio2.limit = i17 + 2;
                                setSize$okio(size() + 2);
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                Segment writableSegment$okio3 = writableSegment$okio(3);
                                byte[] bArr3 = writableSegment$okio3.data;
                                int i18 = writableSegment$okio3.limit;
                                bArr3[i18] = (byte) ((charAt2 >> 12) | 224);
                                bArr3[i18 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i18 + 2] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio3.limit = i18 + 3;
                                setSize$okio(size() + 3);
                            } else {
                                int i19 = i11 + 1;
                                char charAt3 = i19 < i12 ? str.charAt(i19) : 0;
                                if (charAt2 <= 56319) {
                                    if (56320 <= charAt3 && charAt3 < 57344) {
                                        int i21 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 0;
                                        Segment writableSegment$okio4 = writableSegment$okio(4);
                                        byte[] bArr4 = writableSegment$okio4.data;
                                        int i22 = writableSegment$okio4.limit;
                                        bArr4[i22] = (byte) ((i21 >> 18) | 240);
                                        bArr4[i22 + 1] = (byte) (((i21 >> 12) & 63) | 128);
                                        bArr4[i22 + 2] = (byte) (((i21 >> 6) & 63) | 128);
                                        bArr4[i22 + 3] = (byte) ((i21 & 63) | 128);
                                        writableSegment$okio4.limit = i22 + 4;
                                        setSize$okio(size() + 4);
                                        i11 += 2;
                                    }
                                }
                                writeByte(63);
                                i11 = i19;
                            }
                            i11++;
                        }
                    }
                    return this;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i12 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i12 + " < " + i11).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i11).toString());
    }

    public void readFully(byte[] bArr) throws EOFException {
        int i11 = 0;
        while (i11 < bArr.length) {
            int read = read(bArr, i11, bArr.length - i11);
            if (read != -1) {
                i11 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public Buffer writeString(String str, int i11, int i12, Charset charset) {
        boolean z11 = true;
        if (i11 >= 0) {
            if (i12 >= i11) {
                if (i12 > str.length()) {
                    z11 = false;
                }
                if (!z11) {
                    throw new IllegalArgumentException(("endIndex > string.length: " + i12 + " > " + str.length()).toString());
                } else if (x.b(charset, b.f56908b)) {
                    return writeUtf8(str, i11, i12);
                } else {
                    byte[] bytes = str.substring(i11, i12).getBytes(charset);
                    return write(bytes, 0, bytes.length);
                }
            } else {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i12 + " < " + i11).toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex < 0: " + i11).toString());
        }
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        int remaining = byteBuffer.remaining();
        int i11 = remaining;
        while (i11 > 0) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i11, 8192 - writableSegment$okio.limit);
            byteBuffer.get(writableSegment$okio.data, writableSegment$okio.limit, min);
            i11 -= min;
            writableSegment$okio.limit += min;
        }
        this.size += (long) remaining;
        return remaining;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final Buffer copyTo(Buffer buffer, long j11) {
        return copyTo(buffer, j11, this.size - j11);
    }

    public int read(byte[] bArr, int i11, int i12) {
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i11, (long) i12);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i12, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i13 = segment.pos;
        byte[] unused = ArraysKt___ArraysJvmKt.e(bArr2, bArr, i11, i13, i13 + min);
        segment.pos += min;
        setSize$okio(size() - ((long) min));
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    public final Buffer copyTo(Buffer buffer, long j11, long j12) {
        SegmentedByteString.checkOffsetAndCount(size(), j11, j12);
        if (j12 != 0) {
            buffer.setSize$okio(buffer.size() + j12);
            Segment segment = this.head;
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
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    buffer.head = sharedCopy;
                } else {
                    segment2.prev.push(sharedCopy);
                }
                j12 -= (long) (sharedCopy.limit - sharedCopy.pos);
                segment = segment.next;
                j11 = 0;
            }
        }
        return this;
    }

    public Buffer write(ByteString byteString) {
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }

    public Buffer write(ByteString byteString, int i11, int i12) {
        byteString.write$okio(this, i11, i12);
        return this;
    }

    public Buffer write(byte[] bArr) {
        return write(bArr, 0, bArr.length);
    }

    public Buffer write(byte[] bArr, int i11, int i12) {
        long j11 = (long) i12;
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i11, j11);
        int i13 = i12 + i11;
        while (i11 < i13) {
            Segment writableSegment$okio = writableSegment$okio(1);
            int min = Math.min(i13 - i11, 8192 - writableSegment$okio.limit);
            int i14 = i11 + min;
            byte[] unused = ArraysKt___ArraysJvmKt.e(bArr, writableSegment$okio.data, writableSegment$okio.limit, i11, i14);
            writableSegment$okio.limit += min;
            i11 = i14;
        }
        setSize$okio(size() + j11);
        return this;
    }

    public long read(Buffer buffer, long j11) {
        if (!(j11 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
        } else if (size() == 0) {
            return -1;
        } else {
            if (j11 > size()) {
                j11 = size();
            }
            buffer.write(this, j11);
            return j11;
        }
    }

    public Buffer write(Source source, long j11) throws IOException {
        while (j11 > 0) {
            long read = source.read(this, j11);
            if (read != -1) {
                j11 -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public long indexOf(ByteString byteString, long j11) throws IOException {
        long j12 = j11;
        if (byteString.size() > 0) {
            long j13 = 0;
            if (j12 >= 0) {
                Segment segment = this.head;
                if (segment != null) {
                    if (size() - j12 < j12) {
                        long size2 = size();
                        while (size2 > j12) {
                            segment = segment.prev;
                            size2 -= (long) (segment.limit - segment.pos);
                        }
                        byte[] internalArray$okio = byteString.internalArray$okio();
                        byte b11 = internalArray$okio[0];
                        int size3 = byteString.size();
                        long size4 = (size() - ((long) size3)) + 1;
                        while (size2 < size4) {
                            byte[] bArr = segment.data;
                            long j14 = size2;
                            int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size4) - size2);
                            long j15 = ((long) segment.pos) + j12;
                            long j16 = j14;
                            for (int i11 = (int) (j15 - j16); i11 < min; i11++) {
                                if (bArr[i11] == b11 && okio.internal.Buffer.rangeEquals(segment, i11 + 1, internalArray$okio, 1, size3)) {
                                    return ((long) (i11 - segment.pos)) + j16;
                                }
                            }
                            size2 = j16 + ((long) (segment.limit - segment.pos));
                            segment = segment.next;
                            j12 = size2;
                        }
                    } else {
                        while (true) {
                            long j17 = ((long) (segment.limit - segment.pos)) + j13;
                            if (j17 > j12) {
                                break;
                            }
                            segment = segment.next;
                            j13 = j17;
                        }
                        byte[] internalArray$okio2 = byteString.internalArray$okio();
                        byte b12 = internalArray$okio2[0];
                        int size5 = byteString.size();
                        long size6 = (size() - ((long) size5)) + 1;
                        while (j13 < size6) {
                            byte[] bArr2 = segment.data;
                            long j18 = size6;
                            int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + size6) - j13);
                            for (int i12 = (int) ((((long) segment.pos) + j12) - j13); i12 < min2; i12++) {
                                if (bArr2[i12] == b12) {
                                    if (okio.internal.Buffer.rangeEquals(segment, i12 + 1, internalArray$okio2, 1, size5)) {
                                        return ((long) (i12 - segment.pos)) + j13;
                                    }
                                }
                            }
                            j13 += (long) (segment.limit - segment.pos);
                            segment = segment.next;
                            j12 = j13;
                            size6 = j18;
                        }
                    }
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex < 0: " + j12).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    public void write(Buffer buffer, long j11) {
        if (buffer != this) {
            SegmentedByteString.checkOffsetAndCount(buffer.size(), 0, j11);
            while (j11 > 0) {
                if (j11 < ((long) (buffer.head.limit - buffer.head.pos))) {
                    Segment segment = this.head;
                    Segment segment2 = segment != null ? segment.prev : null;
                    if (segment2 != null && segment2.owner) {
                        if ((((long) segment2.limit) + j11) - ((long) (segment2.shared ? 0 : segment2.pos)) <= 8192) {
                            buffer.head.writeTo(segment2, (int) j11);
                            buffer.setSize$okio(buffer.size() - j11);
                            setSize$okio(size() + j11);
                            return;
                        }
                    }
                    buffer.head = buffer.head.split((int) j11);
                }
                Segment segment3 = buffer.head;
                long j12 = (long) (segment3.limit - segment3.pos);
                buffer.head = segment3.pop();
                Segment segment4 = this.head;
                if (segment4 == null) {
                    this.head = segment3;
                    segment3.prev = segment3;
                    segment3.next = segment3;
                } else {
                    segment4.prev.push(segment3).compact();
                }
                buffer.setSize$okio(buffer.size() - j12);
                setSize$okio(size() + j12);
                j11 -= j12;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }
}
