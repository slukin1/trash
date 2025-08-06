package org.bouncycastle.util.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.Arrays;

public class BufferingOutputStream extends OutputStream {
    private final byte[] buf;
    private int bufOff;
    private final OutputStream other;

    public BufferingOutputStream(OutputStream outputStream) {
        this.other = outputStream;
        this.buf = new byte[4096];
    }

    public BufferingOutputStream(OutputStream outputStream, int i11) {
        this.other = outputStream;
        this.buf = new byte[i11];
    }

    public void close() throws IOException {
        flush();
        this.other.close();
    }

    public void flush() throws IOException {
        this.other.write(this.buf, 0, this.bufOff);
        this.bufOff = 0;
        Arrays.fill(this.buf, (byte) 0);
    }

    public void write(int i11) throws IOException {
        byte[] bArr = this.buf;
        int i12 = this.bufOff;
        int i13 = i12 + 1;
        this.bufOff = i13;
        bArr[i12] = (byte) i11;
        if (i13 == bArr.length) {
            flush();
        }
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        byte[] bArr2;
        byte[] bArr3 = this.buf;
        int length = bArr3.length;
        int i13 = this.bufOff;
        if (i12 < length - i13) {
            System.arraycopy(bArr, i11, bArr3, i13, i12);
        } else {
            int length2 = bArr3.length - i13;
            System.arraycopy(bArr, i11, bArr3, i13, length2);
            this.bufOff += length2;
            flush();
            int i14 = i11 + length2;
            i12 -= length2;
            while (true) {
                bArr2 = this.buf;
                if (i12 < bArr2.length) {
                    break;
                }
                this.other.write(bArr, i14, bArr2.length);
                byte[] bArr4 = this.buf;
                i14 += bArr4.length;
                i12 -= bArr4.length;
            }
            if (i12 > 0) {
                System.arraycopy(bArr, i14, bArr2, this.bufOff, i12);
            } else {
                return;
            }
        }
        this.bufOff += i12;
    }
}
