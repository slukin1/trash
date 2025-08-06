package androidx.camera.core.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class ByteBufferOutputStream extends OutputStream {
    private final ByteBuffer mByteBuffer;

    public ByteBufferOutputStream(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
    }

    public void write(int i11) throws IOException {
        if (this.mByteBuffer.hasRemaining()) {
            this.mByteBuffer.put((byte) i11);
            return;
        }
        throw new EOFException("Output ByteBuffer has no bytes remaining.");
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        Objects.requireNonNull(bArr);
        if (i11 < 0 || i11 > bArr.length || i12 < 0 || (i13 = i11 + i12) > bArr.length || i13 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i12 != 0) {
            if (this.mByteBuffer.remaining() >= i12) {
                this.mByteBuffer.put(bArr, i11, i12);
                return;
            }
            throw new EOFException("Output ByteBuffer has insufficient bytes remaining.");
        }
    }
}
