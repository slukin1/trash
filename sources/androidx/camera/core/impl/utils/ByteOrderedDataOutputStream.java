package androidx.camera.core.impl.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

class ByteOrderedDataOutputStream extends FilterOutputStream {
    private ByteOrder mByteOrder;
    public final OutputStream mOutputStream;

    public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.mOutputStream = outputStream;
        this.mByteOrder = byteOrder;
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    public void write(byte[] bArr) throws IOException {
        this.mOutputStream.write(bArr);
    }

    public void writeByte(int i11) throws IOException {
        this.mOutputStream.write(i11);
    }

    public void writeInt(int i11) throws IOException {
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.mOutputStream.write((i11 >>> 0) & 255);
            this.mOutputStream.write((i11 >>> 8) & 255);
            this.mOutputStream.write((i11 >>> 16) & 255);
            this.mOutputStream.write((i11 >>> 24) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.mOutputStream.write((i11 >>> 24) & 255);
            this.mOutputStream.write((i11 >>> 16) & 255);
            this.mOutputStream.write((i11 >>> 8) & 255);
            this.mOutputStream.write((i11 >>> 0) & 255);
        }
    }

    public void writeShort(short s11) throws IOException {
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.mOutputStream.write((s11 >>> 0) & 255);
            this.mOutputStream.write((s11 >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.mOutputStream.write((s11 >>> 8) & 255);
            this.mOutputStream.write((s11 >>> 0) & 255);
        }
    }

    public void writeUnsignedInt(long j11) throws IOException {
        writeInt((int) j11);
    }

    public void writeUnsignedShort(int i11) throws IOException {
        writeShort((short) i11);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.mOutputStream.write(bArr, i11, i12);
    }
}
