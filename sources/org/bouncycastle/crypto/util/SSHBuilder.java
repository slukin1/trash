package org.bouncycastle.crypto.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Strings;

class SSHBuilder {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    public byte[] getBytes() {
        return this.bos.toByteArray();
    }

    public byte[] getPaddedBytes() {
        return getPaddedBytes(8);
    }

    public byte[] getPaddedBytes(int i11) {
        int size = this.bos.size() % i11;
        if (size != 0) {
            int i12 = i11 - size;
            for (int i13 = 1; i13 <= i12; i13++) {
                this.bos.write(i13);
            }
        }
        return this.bos.toByteArray();
    }

    public void u32(int i11) {
        this.bos.write((i11 >>> 24) & 255);
        this.bos.write((i11 >>> 16) & 255);
        this.bos.write((i11 >>> 8) & 255);
        this.bos.write(i11 & 255);
    }

    public void writeBigNum(BigInteger bigInteger) {
        writeBlock(bigInteger.toByteArray());
    }

    public void writeBlock(byte[] bArr) {
        u32(bArr.length);
        try {
            this.bos.write(bArr);
        } catch (IOException e11) {
            throw new IllegalStateException(e11.getMessage(), e11);
        }
    }

    public void writeBytes(byte[] bArr) {
        try {
            this.bos.write(bArr);
        } catch (IOException e11) {
            throw new IllegalStateException(e11.getMessage(), e11);
        }
    }

    public void writeString(String str) {
        writeBlock(Strings.toByteArray(str));
    }
}
