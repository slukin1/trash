package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

final class NioByteString extends ByteString.LeafByteString {
    /* access modifiers changed from: private */
    public final ByteBuffer buffer;

    public NioByteString(ByteBuffer byteBuffer) {
        u.b(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private ByteBuffer slice(int i11, int i12) {
        if (i11 < this.buffer.position() || i12 > this.buffer.limit() || i11 > i12) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12)}));
        }
        ByteBuffer slice = this.buffer.slice();
        slice.position(i11 - this.buffer.position());
        slice.limit(i12 - this.buffer.position());
        return slice;
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    public byte byteAt(int i11) {
        try {
            return this.buffer.get(i11);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw e11;
        } catch (IndexOutOfBoundsException e12) {
            throw new ArrayIndexOutOfBoundsException(e12.getMessage());
        }
    }

    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    public void copyToInternal(byte[] bArr, int i11, int i12, int i13) {
        ByteBuffer slice = this.buffer.slice();
        slice.position(i11);
        slice.get(bArr, i12, i13);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.buffer.equals(((NioByteString) obj).buffer);
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        return this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    public boolean equalsRange(ByteString byteString, int i11, int i12) {
        return substring(0, i12).equals(byteString.substring(i11, i12 + i11));
    }

    public byte internalByteAt(int i11) {
        return byteAt(i11);
    }

    public boolean isValidUtf8() {
        return Utf8.r(this.buffer);
    }

    public g newCodedInput() {
        return g.h(this.buffer, true);
    }

    public InputStream newInput() {
        return new a();
    }

    public int partialHash(int i11, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + this.buffer.get(i14);
        }
        return i11;
    }

    public int partialIsValidUtf8(int i11, int i12, int i13) {
        return Utf8.u(i11, this.buffer, i12, i13 + i12);
    }

    public int size() {
        return this.buffer.remaining();
    }

    public ByteString substring(int i11, int i12) {
        try {
            return new NioByteString(slice(i11, i12));
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw e11;
        } catch (IndexOutOfBoundsException e12) {
            throw new ArrayIndexOutOfBoundsException(e12.getMessage());
        }
    }

    public String toStringInternal(Charset charset) {
        int i11;
        int i12;
        byte[] bArr;
        if (this.buffer.hasArray()) {
            bArr = this.buffer.array();
            i12 = this.buffer.arrayOffset() + this.buffer.position();
            i11 = this.buffer.remaining();
        } else {
            bArr = toByteArray();
            i12 = 0;
            i11 = bArr.length;
        }
        return new String(bArr, i12, i11, charset);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    public void writeToInternal(OutputStream outputStream, int i11, int i12) throws IOException {
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + i11, i12);
            return;
        }
        f.g(slice(i11, i12 + i11), outputStream);
    }

    public class a extends InputStream {

        /* renamed from: b  reason: collision with root package name */
        public final ByteBuffer f9026b;

        public a() {
            this.f9026b = NioByteString.this.buffer.slice();
        }

        public int available() throws IOException {
            return this.f9026b.remaining();
        }

        public void mark(int i11) {
            this.f9026b.mark();
        }

        public boolean markSupported() {
            return true;
        }

        public int read() throws IOException {
            if (!this.f9026b.hasRemaining()) {
                return -1;
            }
            return this.f9026b.get() & 255;
        }

        public void reset() throws IOException {
            try {
                this.f9026b.reset();
            } catch (InvalidMarkException e11) {
                throw new IOException(e11);
            }
        }

        public int read(byte[] bArr, int i11, int i12) throws IOException {
            if (!this.f9026b.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i12, this.f9026b.remaining());
            this.f9026b.get(bArr, i11, min);
            return min;
        }
    }

    public void writeTo(ByteOutput byteOutput) throws IOException {
        byteOutput.a(this.buffer.slice());
    }
}
