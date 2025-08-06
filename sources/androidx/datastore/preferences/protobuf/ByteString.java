package androidx.datastore.preferences.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public abstract class ByteString implements Iterable<Byte>, Serializable {
    public static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = new LiteralByteString(u.f9215c);
    public static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    public static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new b();
    private static final e byteArrayCopier = (b.c() ? new i((a) null) : new d((a) null));
    private int hash = 0;

    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        public BoundedByteString(byte[] bArr, int i11, int i12) {
            super(bArr);
            ByteString.checkRange(i11, i11 + i12, bArr.length);
            this.bytesOffset = i11;
            this.bytesLength = i12;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        public byte byteAt(int i11) {
            ByteString.checkIndex(i11, size());
            return this.bytes[this.bytesOffset + i11];
        }

        public void copyToInternal(byte[] bArr, int i11, int i12, int i13) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + i11, bArr, i12, i13);
        }

        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        public byte internalByteAt(int i11) {
            return this.bytes[this.bytesOffset + i11];
        }

        public int size() {
            return this.bytesLength;
        }

        public Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    public static abstract class LeafByteString extends ByteString {
        public abstract boolean equalsRange(ByteString byteString, int i11, int i12);

        public final int getTreeDepth() {
            return 0;
        }

        public final boolean isBalanced() {
            return true;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ByteString.super.iterator();
        }

        public void writeToReverse(ByteOutput byteOutput) throws IOException {
            writeTo(byteOutput);
        }
    }

    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        public final byte[] bytes;

        public LiteralByteString(byte[] bArr) {
            Objects.requireNonNull(bArr);
            this.bytes = bArr;
        }

        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        public byte byteAt(int i11) {
            return this.bytes[i11];
        }

        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
        }

        public void copyToInternal(byte[] bArr, int i11, int i12, int i13) {
            System.arraycopy(this.bytes, i11, bArr, i12, i13);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int peekCachedHashCode = peekCachedHashCode();
            int peekCachedHashCode2 = literalByteString.peekCachedHashCode();
            if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
                return equalsRange(literalByteString, 0, size());
            }
            return false;
        }

        public final boolean equalsRange(ByteString byteString, int i11, int i12) {
            if (i12 <= byteString.size()) {
                int i13 = i11 + i12;
                if (i13 > byteString.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i11 + ", " + i12 + ", " + byteString.size());
                } else if (!(byteString instanceof LiteralByteString)) {
                    return byteString.substring(i11, i13).equals(substring(0, i12));
                } else {
                    LiteralByteString literalByteString = (LiteralByteString) byteString;
                    byte[] bArr = this.bytes;
                    byte[] bArr2 = literalByteString.bytes;
                    int offsetIntoBytes = getOffsetIntoBytes() + i12;
                    int offsetIntoBytes2 = getOffsetIntoBytes();
                    int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i11;
                    while (offsetIntoBytes2 < offsetIntoBytes) {
                        if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                            return false;
                        }
                        offsetIntoBytes2++;
                        offsetIntoBytes3++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i12 + size());
            }
        }

        public int getOffsetIntoBytes() {
            return 0;
        }

        public byte internalByteAt(int i11) {
            return this.bytes[i11];
        }

        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return Utf8.t(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
        }

        public final g newCodedInput() {
            return g.k(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        public final int partialHash(int i11, int i12, int i13) {
            return u.i(i11, this.bytes, getOffsetIntoBytes() + i12, i13);
        }

        public final int partialIsValidUtf8(int i11, int i12, int i13) {
            int offsetIntoBytes = getOffsetIntoBytes() + i12;
            return Utf8.v(i11, this.bytes, offsetIntoBytes, i13 + offsetIntoBytes);
        }

        public int size() {
            return this.bytes.length;
        }

        public final ByteString substring(int i11, int i12) {
            int checkRange = ByteString.checkRange(i11, i12, size());
            if (checkRange == 0) {
                return ByteString.EMPTY;
            }
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + i11, checkRange);
        }

        public final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        public final void writeToInternal(OutputStream outputStream, int i11, int i12) throws IOException {
            outputStream.write(this.bytes, getOffsetIntoBytes() + i11, i12);
        }

        public final void writeTo(ByteOutput byteOutput) throws IOException {
            byteOutput.b(this.bytes, getOffsetIntoBytes(), size());
        }
    }

    public class a extends c {

        /* renamed from: b  reason: collision with root package name */
        public int f8975b = 0;

        /* renamed from: c  reason: collision with root package name */
        public final int f8976c;

        public a() {
            this.f8976c = ByteString.this.size();
        }

        public boolean hasNext() {
            return this.f8975b < this.f8976c;
        }

        public byte nextByte() {
            int i11 = this.f8975b;
            if (i11 < this.f8976c) {
                this.f8975b = i11 + 1;
                return ByteString.this.internalByteAt(i11);
            }
            throw new NoSuchElementException();
        }
    }

    public static class b implements Comparator<ByteString> {
        /* renamed from: a */
        public int compare(ByteString byteString, ByteString byteString2) {
            f it2 = byteString.iterator();
            f it3 = byteString2.iterator();
            while (it2.hasNext() && it3.hasNext()) {
                int compare = Integer.compare(ByteString.toInt(it2.nextByte()), ByteString.toInt(it3.nextByte()));
                if (compare != 0) {
                    return compare;
                }
            }
            return Integer.compare(byteString.size(), byteString2.size());
        }
    }

    public static abstract class c implements f {
        /* renamed from: a */
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static final class d implements e {
        public d() {
        }

        public byte[] copyFrom(byte[] bArr, int i11, int i12) {
            return Arrays.copyOfRange(bArr, i11, i12 + i11);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    public interface e {
        byte[] copyFrom(byte[] bArr, int i11, int i12);
    }

    public interface f extends Iterator<Byte> {
        byte nextByte();
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public final CodedOutputStream f8978a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f8979b;

        public /* synthetic */ g(int i11, a aVar) {
            this(i11);
        }

        public ByteString a() {
            this.f8978a.d();
            return new LiteralByteString(this.f8979b);
        }

        public CodedOutputStream b() {
            return this.f8978a;
        }

        public g(int i11) {
            byte[] bArr = new byte[i11];
            this.f8979b = bArr;
            this.f8978a = CodedOutputStream.h0(bArr);
        }
    }

    public static final class i implements e {
        public i() {
        }

        public byte[] copyFrom(byte[] bArr, int i11, int i12) {
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i11, bArr2, 0, i12);
            return bArr2;
        }

        public /* synthetic */ i(a aVar) {
            this();
        }
    }

    private static ByteString balancedConcat(Iterator<ByteString> it2, int i11) {
        if (i11 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i11)}));
        } else if (i11 == 1) {
            return it2.next();
        } else {
            int i12 = i11 >>> 1;
            return balancedConcat(it2, i12).concat(balancedConcat(it2, i11 - i12));
        }
    }

    public static void checkIndex(int i11, int i12) {
        if (((i12 - (i11 + 1)) | i11) >= 0) {
            return;
        }
        if (i11 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i11);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i11 + ", " + i12);
    }

    public static int checkRange(int i11, int i12, int i13) {
        int i14 = i12 - i11;
        if ((i11 | i12 | i14 | (i13 - i12)) >= 0) {
            return i14;
        }
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i11 + " < 0");
        } else if (i12 < i11) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i11 + ", " + i12);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i12 + " >= " + i13);
        }
    }

    public static ByteString copyFrom(byte[] bArr, int i11, int i12) {
        checkRange(i11, i11 + i12, bArr.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bArr, i11, i12));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(u.f9213a));
    }

    public static g newCodedBuilder(int i11) {
        return new g(i11, (a) null);
    }

    public static h newOutput(int i11) {
        return new h(i11);
    }

    private static ByteString readChunk(InputStream inputStream, int i11) throws IOException {
        byte[] bArr = new byte[i11];
        int i12 = 0;
        while (i12 < i11) {
            int read = inputStream.read(bArr, i12, i11 - i12);
            if (read == -1) {
                break;
            }
            i12 += read;
        }
        if (i12 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i12);
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    /* access modifiers changed from: private */
    public static int toInt(byte b11) {
        return b11 & 255;
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    public static ByteString wrap(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new NioByteString(byteBuffer);
        }
        return wrap(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i11);

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return RopeByteString.concatenate(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i11) {
        copyTo(bArr, 0, i11, size());
    }

    public abstract void copyToInternal(byte[] bArr, int i11, int i12, int i13);

    public final boolean endsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(size() - byteString.size()).equals(byteString);
    }

    public abstract boolean equals(Object obj);

    public abstract int getTreeDepth();

    public final int hashCode() {
        int i11 = this.hash;
        if (i11 == 0) {
            int size = size();
            i11 = partialHash(size, 0, size);
            if (i11 == 0) {
                i11 = 1;
            }
            this.hash = i11;
        }
        return i11;
    }

    public abstract byte internalByteAt(int i11);

    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    public abstract g newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int i11, int i12, int i13);

    public abstract int partialIsValidUtf8(int i11, int i12, int i13);

    public final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(0, byteString.size()).equals(byteString);
    }

    public final ByteString substring(int i11) {
        return substring(i11, size());
    }

    public abstract ByteString substring(int i11, int i12);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return u.f9215c;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e11) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e11);
            throw unsupportedEncodingException;
        }
    }

    public abstract String toStringInternal(Charset charset);

    public final String toStringUtf8() {
        return toString(u.f9213a);
    }

    public abstract void writeTo(ByteOutput byteOutput) throws IOException;

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public final void writeTo(OutputStream outputStream, int i11, int i12) throws IOException {
        checkRange(i11, i11 + i12, size());
        if (i12 > 0) {
            writeToInternal(outputStream, i11, i12);
        }
    }

    public abstract void writeToInternal(OutputStream outputStream, int i11, int i12) throws IOException;

    public abstract void writeToReverse(ByteOutput byteOutput) throws IOException;

    public static h newOutput() {
        return new h(128);
    }

    public static ByteString readFrom(InputStream inputStream, int i11) throws IOException {
        return readFrom(inputStream, i11, i11);
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i11, int i12, int i13) {
        checkRange(i11, i11 + i13, size());
        checkRange(i12, i12 + i13, bArr.length);
        if (i13 > 0) {
            copyToInternal(bArr, i11, i12, i13);
        }
    }

    public f iterator() {
        return new a();
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString readFrom(InputStream inputStream, int i11, int i12) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString readChunk = readChunk(inputStream, i11);
            if (readChunk == null) {
                return copyFrom((Iterable<ByteString>) arrayList);
            }
            arrayList.add(readChunk);
            i11 = Math.min(i11 * 2, i12);
        }
    }

    public static final class h extends OutputStream {

        /* renamed from: g  reason: collision with root package name */
        public static final byte[] f8980g = new byte[0];

        /* renamed from: b  reason: collision with root package name */
        public final int f8981b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<ByteString> f8982c;

        /* renamed from: d  reason: collision with root package name */
        public int f8983d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f8984e;

        /* renamed from: f  reason: collision with root package name */
        public int f8985f;

        public h(int i11) {
            if (i11 >= 0) {
                this.f8981b = i11;
                this.f8982c = new ArrayList<>();
                this.f8984e = new byte[i11];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        public final void a(int i11) {
            this.f8982c.add(new LiteralByteString(this.f8984e));
            int length = this.f8983d + this.f8984e.length;
            this.f8983d = length;
            this.f8984e = new byte[Math.max(this.f8981b, Math.max(i11, length >>> 1))];
            this.f8985f = 0;
        }

        public synchronized int b() {
            return this.f8983d + this.f8985f;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b())});
        }

        public synchronized void write(int i11) {
            if (this.f8985f == this.f8984e.length) {
                a(1);
            }
            byte[] bArr = this.f8984e;
            int i12 = this.f8985f;
            this.f8985f = i12 + 1;
            bArr[i12] = (byte) i11;
        }

        public synchronized void write(byte[] bArr, int i11, int i12) {
            byte[] bArr2 = this.f8984e;
            int length = bArr2.length;
            int i13 = this.f8985f;
            if (i12 <= length - i13) {
                System.arraycopy(bArr, i11, bArr2, i13, i12);
                this.f8985f += i12;
            } else {
                int length2 = bArr2.length - i13;
                System.arraycopy(bArr, i11, bArr2, i13, length2);
                int i14 = i12 - length2;
                a(i14);
                System.arraycopy(bArr, i11 + length2, this.f8984e, 0, i14);
                this.f8985f = i14;
            }
        }
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i11) {
        checkRange(0, i11, byteBuffer.remaining());
        byte[] bArr = new byte[i11];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    public static ByteString wrap(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    public static ByteString wrap(byte[] bArr, int i11, int i12) {
        return new BoundedByteString(bArr, i11, i12);
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int i11;
        if (!(iterable instanceof Collection)) {
            i11 = 0;
            Iterator<ByteString> it2 = iterable.iterator();
            while (it2.hasNext()) {
                it2.next();
                i11++;
            }
        } else {
            i11 = ((Collection) iterable).size();
        }
        if (i11 == 0) {
            return EMPTY;
        }
        return balancedConcat(iterable.iterator(), i11);
    }
}
