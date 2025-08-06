package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.internal.SegmentedByteString;

/* renamed from: okio.SegmentedByteString  reason: case insensitive filesystem */
public final class C0892SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    public C0892SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.EMPTY.getData$okio());
        this.segments = bArr;
        this.directory = iArr;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        return toByteString();
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public String base64() {
        return toByteString().base64();
    }

    public String base64Url() {
        return toByteString().base64Url();
    }

    public void copyInto(int i11, byte[] bArr, int i12, int i13) {
        int i14;
        long j11 = (long) i13;
        SegmentedByteString.checkOffsetAndCount((long) size(), (long) i11, j11);
        SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i12, j11);
        int i15 = i13 + i11;
        int segment = SegmentedByteString.segment(this, i11);
        while (i11 < i15) {
            if (segment == 0) {
                i14 = 0;
            } else {
                i14 = getDirectory$okio()[segment - 1];
            }
            int i16 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i15, (getDirectory$okio()[segment] - i14) + i14) - i11;
            int i17 = i16 + (i11 - i14);
            byte[] unused = ArraysKt___ArraysJvmKt.e(getSegments$okio()[segment], bArr, i12, i17, i17 + min);
            i12 += min;
            i11 += min;
            segment++;
        }
    }

    public ByteString digest$okio(String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        int length = getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = getDirectory$okio()[length + i11];
            int i14 = getDirectory$okio()[i11];
            instance.update(getSegments$okio()[i11], i13, i14 - i12);
            i11++;
            i12 = i14;
        }
        return new ByteString(instance.digest());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            int i14 = getDirectory$okio()[length + i11];
            int i15 = getDirectory$okio()[i11];
            byte[] bArr = getSegments$okio()[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        setHashCode$okio(i12);
        return i12;
    }

    public String hex() {
        return toByteString().hex();
    }

    public ByteString hmac$okio(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            int length = getSegments$okio().length;
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                int i13 = getDirectory$okio()[length + i11];
                int i14 = getDirectory$okio()[i11];
                instance.update(getSegments$okio()[i11], i13, i14 - i12);
                i11++;
                i12 = i14;
            }
            return new ByteString(instance.doFinal());
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public int indexOf(byte[] bArr, int i11) {
        return toByteString().indexOf(bArr, i11);
    }

    public byte[] internalArray$okio() {
        return toByteArray();
    }

    public byte internalGet$okio(int i11) {
        int i12;
        SegmentedByteString.checkOffsetAndCount((long) getDirectory$okio()[getSegments$okio().length - 1], (long) i11, 1);
        int segment = SegmentedByteString.segment(this, i11);
        if (segment == 0) {
            i12 = 0;
        } else {
            i12 = getDirectory$okio()[segment - 1];
        }
        return getSegments$okio()[segment][(i11 - i12) + getDirectory$okio()[getSegments$okio().length + segment]];
    }

    public int lastIndexOf(byte[] bArr, int i11) {
        return toByteString().lastIndexOf(bArr, i11);
    }

    public boolean rangeEquals(int i11, ByteString byteString, int i12, int i13) {
        int i14;
        if (i11 < 0 || i11 > size() - i13) {
            return false;
        }
        int i15 = i13 + i11;
        int segment = SegmentedByteString.segment(this, i11);
        while (i11 < i15) {
            if (segment == 0) {
                i14 = 0;
            } else {
                i14 = getDirectory$okio()[segment - 1];
            }
            int i16 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i15, (getDirectory$okio()[segment] - i14) + i14) - i11;
            if (!byteString.rangeEquals(i12, getSegments$okio()[segment], i16 + (i11 - i14), min)) {
                return false;
            }
            i12 += min;
            i11 += min;
            segment++;
        }
        return true;
    }

    public String string(Charset charset) {
        return toByteString().string(charset);
    }

    public ByteString substring(int i11, int i12) {
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter((ByteString) this, i12);
        int i13 = 0;
        if (i11 >= 0) {
            if (resolveDefaultParameter <= size()) {
                int i14 = resolveDefaultParameter - i11;
                if (!(i14 >= 0)) {
                    throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + i11).toString());
                } else if (i11 == 0 && resolveDefaultParameter == size()) {
                    return this;
                } else {
                    if (i11 == resolveDefaultParameter) {
                        return ByteString.EMPTY;
                    }
                    int segment = SegmentedByteString.segment(this, i11);
                    int segment2 = SegmentedByteString.segment(this, resolveDefaultParameter - 1);
                    byte[][] bArr = (byte[][]) ArraysKt___ArraysJvmKt.j(getSegments$okio(), segment, segment2 + 1);
                    int[] iArr = new int[(bArr.length * 2)];
                    if (segment <= segment2) {
                        int i15 = 0;
                        int i16 = segment;
                        while (true) {
                            iArr[i15] = Math.min(getDirectory$okio()[i16] - i11, i14);
                            int i17 = i15 + 1;
                            iArr[i15 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i16];
                            if (i16 == segment2) {
                                break;
                            }
                            i16++;
                            i15 = i17;
                        }
                    }
                    if (segment != 0) {
                        i13 = getDirectory$okio()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i11 - i13);
                    return new C0892SegmentedByteString(bArr, iArr);
                }
            } else {
                throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + size() + ')').toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex=" + i11 + " < 0").toString());
        }
    }

    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            int i14 = getDirectory$okio()[length + i11];
            int i15 = getDirectory$okio()[i11];
            int i16 = i15 - i12;
            byte[] unused = ArraysKt___ArraysJvmKt.e(getSegments$okio()[i11], bArr, i13, i14, i14 + i16);
            i13 += i16;
            i11++;
            i12 = i15;
        }
        return bArr;
    }

    public String toString() {
        return toByteString().toString();
    }

    public void write(OutputStream outputStream) throws IOException {
        int length = getSegments$okio().length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int i13 = getDirectory$okio()[length + i11];
            int i14 = getDirectory$okio()[i11];
            outputStream.write(getSegments$okio()[i11], i13, i14 - i12);
            i11++;
            i12 = i14;
        }
    }

    public void write$okio(Buffer buffer, int i11, int i12) {
        int i13;
        int i14 = i11 + i12;
        int segment = SegmentedByteString.segment(this, i11);
        while (i11 < i14) {
            if (segment == 0) {
                i13 = 0;
            } else {
                i13 = getDirectory$okio()[segment - 1];
            }
            int i15 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i14, (getDirectory$okio()[segment] - i13) + i13) - i11;
            int i16 = i15 + (i11 - i13);
            Segment segment2 = new Segment(getSegments$okio()[segment], i16, i16 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                segment3.prev.push(segment2);
            }
            i11 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) i12));
    }

    public boolean rangeEquals(int i11, byte[] bArr, int i12, int i13) {
        int i14;
        if (i11 < 0 || i11 > size() - i13 || i12 < 0 || i12 > bArr.length - i13) {
            return false;
        }
        int i15 = i13 + i11;
        int segment = SegmentedByteString.segment(this, i11);
        while (i11 < i15) {
            if (segment == 0) {
                i14 = 0;
            } else {
                i14 = getDirectory$okio()[segment - 1];
            }
            int i16 = getDirectory$okio()[getSegments$okio().length + segment];
            int min = Math.min(i15, (getDirectory$okio()[segment] - i14) + i14) - i11;
            if (!SegmentedByteString.arrayRangeEquals(getSegments$okio()[segment], i16 + (i11 - i14), bArr, i12, min)) {
                return false;
            }
            i12 += min;
            i11 += min;
            segment++;
        }
        return true;
    }
}
