package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

final class RopeByteString extends ByteString {
    public static final int[] minLengthByDepth = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;
    /* access modifiers changed from: private */
    public final ByteString left;
    private final int leftLength;
    /* access modifiers changed from: private */
    public final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    public class a extends ByteString.c {

        /* renamed from: b  reason: collision with root package name */
        public final c f9029b;

        /* renamed from: c  reason: collision with root package name */
        public ByteString.f f9030c = b();

        public a() {
            this.f9029b = new c(RopeByteString.this, (a) null);
        }

        public final ByteString.f b() {
            if (this.f9029b.hasNext()) {
                return this.f9029b.next().iterator();
            }
            return null;
        }

        public boolean hasNext() {
            return this.f9030c != null;
        }

        public byte nextByte() {
            ByteString.f fVar = this.f9030c;
            if (fVar != null) {
                byte nextByte = fVar.nextByte();
                if (!this.f9030c.hasNext()) {
                    this.f9030c = b();
                }
                return nextByte;
            }
            throw new NoSuchElementException();
        }
    }

    public static final class c implements Iterator<ByteString.LeafByteString> {

        /* renamed from: b  reason: collision with root package name */
        public final ArrayDeque<RopeByteString> f9033b;

        /* renamed from: c  reason: collision with root package name */
        public ByteString.LeafByteString f9034c;

        public /* synthetic */ c(ByteString byteString, a aVar) {
            this(byteString);
        }

        public final ByteString.LeafByteString a(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.f9033b.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (ByteString.LeafByteString) byteString;
        }

        public final ByteString.LeafByteString b() {
            ByteString.LeafByteString a11;
            do {
                ArrayDeque<RopeByteString> arrayDeque = this.f9033b;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                a11 = a(this.f9033b.pop().right);
            } while (a11.isEmpty());
            return a11;
        }

        /* renamed from: c */
        public ByteString.LeafByteString next() {
            ByteString.LeafByteString leafByteString = this.f9034c;
            if (leafByteString != null) {
                this.f9034c = b();
                return leafByteString;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            return this.f9034c != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public c(ByteString byteString) {
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                ArrayDeque<RopeByteString> arrayDeque = new ArrayDeque<>(ropeByteString.getTreeDepth());
                this.f9033b = arrayDeque;
                arrayDeque.push(ropeByteString);
                this.f9034c = a(ropeByteString.left);
                return;
            }
            this.f9033b = null;
            this.f9034c = (ByteString.LeafByteString) byteString;
        }
    }

    public /* synthetic */ RopeByteString(ByteString byteString, ByteString byteString2, a aVar) {
        this(byteString, byteString2);
    }

    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return concatenateBytes(byteString, byteString2);
        }
        if (byteString instanceof RopeByteString) {
            RopeByteString ropeByteString = (RopeByteString) byteString;
            if (ropeByteString.right.size() + byteString2.size() < 128) {
                return new RopeByteString(ropeByteString.left, concatenateBytes(ropeByteString.right, byteString2));
            } else if (ropeByteString.left.getTreeDepth() > ropeByteString.right.getTreeDepth() && ropeByteString.getTreeDepth() > byteString2.getTreeDepth()) {
                return new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        if (size >= minLengthByDepth[Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1]) {
            return new RopeByteString(byteString, byteString2);
        }
        return new b((a) null).b(byteString, byteString2);
    }

    private static ByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.wrap(bArr);
    }

    private boolean equalsFragments(ByteString byteString) {
        boolean z11;
        c cVar = new c(this, (a) null);
        ByteString.LeafByteString leafByteString = (ByteString.LeafByteString) cVar.next();
        c cVar2 = new c(byteString, (a) null);
        ByteString.LeafByteString leafByteString2 = (ByteString.LeafByteString) cVar2.next();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int size = leafByteString.size() - i11;
            int size2 = leafByteString2.size() - i12;
            int min = Math.min(size, size2);
            if (i11 == 0) {
                z11 = leafByteString.equalsRange(leafByteString2, i12, min);
            } else {
                z11 = leafByteString2.equalsRange(leafByteString, i11, min);
            }
            if (!z11) {
                return false;
            }
            i13 += min;
            int i14 = this.totalLength;
            if (i13 < i14) {
                if (min == size) {
                    leafByteString = (ByteString.LeafByteString) cVar.next();
                    i11 = 0;
                } else {
                    i11 += min;
                }
                if (min == size2) {
                    leafByteString2 = (ByteString.LeafByteString) cVar2.next();
                    i12 = 0;
                } else {
                    i12 += min;
                }
            } else if (i13 == i14) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public static RopeByteString newInstanceForTest(ByteString byteString, ByteString byteString2) {
        return new RopeByteString(byteString, byteString2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(this, (a) null);
        while (cVar.hasNext()) {
            arrayList.add(cVar.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    public byte byteAt(int i11) {
        ByteString.checkIndex(i11, this.totalLength);
        return internalByteAt(i11);
    }

    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    public void copyToInternal(byte[] bArr, int i11, int i12, int i13) {
        int i14 = i11 + i13;
        int i15 = this.leftLength;
        if (i14 <= i15) {
            this.left.copyToInternal(bArr, i11, i12, i13);
        } else if (i11 >= i15) {
            this.right.copyToInternal(bArr, i11 - i15, i12, i13);
        } else {
            int i16 = i15 - i11;
            this.left.copyToInternal(bArr, i11, i12, i16);
            this.right.copyToInternal(bArr, 0, i12 + i16, i13 - i16);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int peekCachedHashCode = peekCachedHashCode();
        int peekCachedHashCode2 = byteString.peekCachedHashCode();
        if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
            return equalsFragments(byteString);
        }
        return false;
    }

    public int getTreeDepth() {
        return this.treeDepth;
    }

    public byte internalByteAt(int i11) {
        int i12 = this.leftLength;
        if (i11 < i12) {
            return this.left.internalByteAt(i11);
        }
        return this.right.internalByteAt(i11 - i12);
    }

    public boolean isBalanced() {
        return this.totalLength >= minLengthByDepth[this.treeDepth];
    }

    public boolean isValidUtf8() {
        int partialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.right;
        if (byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) == 0) {
            return true;
        }
        return false;
    }

    public g newCodedInput() {
        return g.f(new d());
    }

    public InputStream newInput() {
        return new d();
    }

    public int partialHash(int i11, int i12, int i13) {
        int i14 = i12 + i13;
        int i15 = this.leftLength;
        if (i14 <= i15) {
            return this.left.partialHash(i11, i12, i13);
        }
        if (i12 >= i15) {
            return this.right.partialHash(i11, i12 - i15, i13);
        }
        int i16 = i15 - i12;
        return this.right.partialHash(this.left.partialHash(i11, i12, i16), 0, i13 - i16);
    }

    public int partialIsValidUtf8(int i11, int i12, int i13) {
        int i14 = i12 + i13;
        int i15 = this.leftLength;
        if (i14 <= i15) {
            return this.left.partialIsValidUtf8(i11, i12, i13);
        }
        if (i12 >= i15) {
            return this.right.partialIsValidUtf8(i11, i12 - i15, i13);
        }
        int i16 = i15 - i12;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i11, i12, i16), 0, i13 - i16);
    }

    public int size() {
        return this.totalLength;
    }

    public ByteString substring(int i11, int i12) {
        int checkRange = ByteString.checkRange(i11, i12, this.totalLength);
        if (checkRange == 0) {
            return ByteString.EMPTY;
        }
        if (checkRange == this.totalLength) {
            return this;
        }
        int i13 = this.leftLength;
        if (i12 <= i13) {
            return this.left.substring(i11, i12);
        }
        if (i11 >= i13) {
            return this.right.substring(i11 - i13, i12 - i13);
        }
        return new RopeByteString(this.left.substring(i11), this.right.substring(0, i12 - this.leftLength));
    }

    public String toStringInternal(Charset charset) {
        return new String(toByteArray(), charset);
    }

    public Object writeReplace() {
        return ByteString.wrap(toByteArray());
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    public void writeToInternal(OutputStream outputStream, int i11, int i12) throws IOException {
        int i13 = i11 + i12;
        int i14 = this.leftLength;
        if (i13 <= i14) {
            this.left.writeToInternal(outputStream, i11, i12);
        } else if (i11 >= i14) {
            this.right.writeToInternal(outputStream, i11 - i14, i12);
        } else {
            int i15 = i14 - i11;
            this.left.writeToInternal(outputStream, i11, i15);
            this.right.writeToInternal(outputStream, 0, i12 - i15);
        }
    }

    public void writeToReverse(ByteOutput byteOutput) throws IOException {
        this.right.writeToReverse(byteOutput);
        this.left.writeToReverse(byteOutput);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayDeque<ByteString> f9032a;

        public b() {
            this.f9032a = new ArrayDeque<>();
        }

        public final ByteString b(ByteString byteString, ByteString byteString2) {
            c(byteString);
            c(byteString2);
            ByteString pop = this.f9032a.pop();
            while (!this.f9032a.isEmpty()) {
                pop = new RopeByteString(this.f9032a.pop(), pop, (a) null);
            }
            return pop;
        }

        public final void c(ByteString byteString) {
            if (byteString.isBalanced()) {
                e(byteString);
            } else if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                c(ropeByteString.left);
                c(ropeByteString.right);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        public final int d(int i11) {
            int binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i11);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        public final void e(ByteString byteString) {
            int d11 = d(byteString.size());
            int[] iArr = RopeByteString.minLengthByDepth;
            int i11 = iArr[d11 + 1];
            if (this.f9032a.isEmpty() || this.f9032a.peek().size() >= i11) {
                this.f9032a.push(byteString);
                return;
            }
            int i12 = iArr[d11];
            ByteString pop = this.f9032a.pop();
            while (!this.f9032a.isEmpty() && this.f9032a.peek().size() < i12) {
                pop = new RopeByteString(this.f9032a.pop(), pop, (a) null);
            }
            RopeByteString ropeByteString = new RopeByteString(pop, byteString, (a) null);
            while (!this.f9032a.isEmpty()) {
                if (this.f9032a.peek().size() >= RopeByteString.minLengthByDepth[d(ropeByteString.size()) + 1]) {
                    break;
                }
                ropeByteString = new RopeByteString(this.f9032a.pop(), ropeByteString, (a) null);
            }
            this.f9032a.push(ropeByteString);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    public ByteString.f iterator() {
        return new a();
    }

    public void writeTo(ByteOutput byteOutput) throws IOException {
        this.left.writeTo(byteOutput);
        this.right.writeTo(byteOutput);
    }

    public class d extends InputStream {

        /* renamed from: b  reason: collision with root package name */
        public c f9035b;

        /* renamed from: c  reason: collision with root package name */
        public ByteString.LeafByteString f9036c;

        /* renamed from: d  reason: collision with root package name */
        public int f9037d;

        /* renamed from: e  reason: collision with root package name */
        public int f9038e;

        /* renamed from: f  reason: collision with root package name */
        public int f9039f;

        /* renamed from: g  reason: collision with root package name */
        public int f9040g;

        public d() {
            b();
        }

        public final void a() {
            int i11;
            if (this.f9036c != null && this.f9038e == (i11 = this.f9037d)) {
                this.f9039f += i11;
                this.f9038e = 0;
                if (this.f9035b.hasNext()) {
                    ByteString.LeafByteString c11 = this.f9035b.next();
                    this.f9036c = c11;
                    this.f9037d = c11.size();
                    return;
                }
                this.f9036c = null;
                this.f9037d = 0;
            }
        }

        public int available() throws IOException {
            return RopeByteString.this.size() - (this.f9039f + this.f9038e);
        }

        public final void b() {
            c cVar = new c(RopeByteString.this, (a) null);
            this.f9035b = cVar;
            ByteString.LeafByteString c11 = cVar.next();
            this.f9036c = c11;
            this.f9037d = c11.size();
            this.f9038e = 0;
            this.f9039f = 0;
        }

        public final int e(byte[] bArr, int i11, int i12) {
            int i13 = i12;
            while (true) {
                if (i13 <= 0) {
                    break;
                }
                a();
                if (this.f9036c != null) {
                    int min = Math.min(this.f9037d - this.f9038e, i13);
                    if (bArr != null) {
                        this.f9036c.copyTo(bArr, this.f9038e, i11, min);
                        i11 += min;
                    }
                    this.f9038e += min;
                    i13 -= min;
                } else if (i13 == i12) {
                    return -1;
                }
            }
            return i12 - i13;
        }

        public void mark(int i11) {
            this.f9040g = this.f9039f + this.f9038e;
        }

        public boolean markSupported() {
            return true;
        }

        public int read(byte[] bArr, int i11, int i12) {
            Objects.requireNonNull(bArr);
            if (i11 >= 0 && i12 >= 0 && i12 <= bArr.length - i11) {
                return e(bArr, i11, i12);
            }
            throw new IndexOutOfBoundsException();
        }

        public synchronized void reset() {
            b();
            e((byte[]) null, 0, this.f9040g);
        }

        public long skip(long j11) {
            if (j11 >= 0) {
                if (j11 > 2147483647L) {
                    j11 = 2147483647L;
                }
                return (long) e((byte[]) null, 0, (int) j11);
            }
            throw new IndexOutOfBoundsException();
        }

        public int read() throws IOException {
            a();
            ByteString.LeafByteString leafByteString = this.f9036c;
            if (leafByteString == null) {
                return -1;
            }
            int i11 = this.f9038e;
            this.f9038e = i11 + 1;
            return leafByteString.byteAt(i11) & 255;
        }
    }
}
