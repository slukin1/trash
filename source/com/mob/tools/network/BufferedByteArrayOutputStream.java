package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

@Deprecated
public class BufferedByteArrayOutputStream extends ByteArrayOutputStream implements PublicMemberKeeper {
    public BufferedByteArrayOutputStream() {
    }

    public byte[] getBuffer() {
        return this.buf;
    }

    public int getBufferSize() {
        return this.buf.length;
    }

    public boolean switchBuffer(byte[] bArr) {
        if (bArr == null || bArr.length != this.buf.length) {
            return false;
        }
        this.buf = bArr;
        return true;
    }

    public void write(ByteBuffer byteBuffer) throws IOException {
        write(byteBuffer, byteBuffer.limit());
    }

    public BufferedByteArrayOutputStream(int i11) {
        super(i11);
    }

    public void write(ByteBuffer byteBuffer, int i11) throws IOException {
        byte[] bArr = this.buf;
        int length = bArr.length;
        int i12 = this.count;
        if (length - i12 >= i11) {
            byteBuffer.get(bArr, i12, i11);
            this.count += i11;
            return;
        }
        byte[] bArr2 = new byte[i11];
        byteBuffer.get(bArr2);
        write(bArr2);
    }
}
