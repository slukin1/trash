package org.bouncycastle.crypto.util;

import com.google.common.base.Ascii;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

class SSHBuffer {
    private final byte[] buffer;
    private int pos = 0;

    public SSHBuffer(byte[] bArr) {
        this.buffer = bArr;
    }

    public SSHBuffer(byte[] bArr, byte[] bArr2) {
        int i11 = 0;
        this.buffer = bArr2;
        while (i11 != bArr.length) {
            if (bArr[i11] == bArr2[i11]) {
                i11++;
            } else {
                throw new IllegalArgumentException("magic-number incorrect");
            }
        }
        this.pos += bArr.length;
    }

    public byte[] getBuffer() {
        return Arrays.clone(this.buffer);
    }

    public boolean hasRemaining() {
        return this.pos < this.buffer.length;
    }

    public BigInteger readBigNumPositive() {
        int readU32 = readU32();
        int i11 = this.pos;
        int i12 = i11 + readU32;
        byte[] bArr = this.buffer;
        if (i12 <= bArr.length) {
            int i13 = readU32 + i11;
            this.pos = i13;
            return new BigInteger(1, Arrays.copyOfRange(bArr, i11, i13));
        }
        throw new IllegalArgumentException("not enough data for big num");
    }

    public byte[] readBlock() {
        int readU32 = readU32();
        if (readU32 == 0) {
            return new byte[0];
        }
        int i11 = this.pos;
        byte[] bArr = this.buffer;
        if (i11 <= bArr.length - readU32) {
            int i12 = readU32 + i11;
            this.pos = i12;
            return Arrays.copyOfRange(bArr, i11, i12);
        }
        throw new IllegalArgumentException("not enough data for block");
    }

    public byte[] readPaddedBlock() {
        return readPaddedBlock(8);
    }

    public byte[] readPaddedBlock(int i11) {
        byte b11;
        int readU32 = readU32();
        if (readU32 == 0) {
            return new byte[0];
        }
        int i12 = this.pos;
        byte[] bArr = this.buffer;
        if (i12 > bArr.length - readU32) {
            throw new IllegalArgumentException("not enough data for block");
        } else if (readU32 % i11 == 0) {
            int i13 = i12 + readU32;
            this.pos = i13;
            if (readU32 > 0 && (b11 = bArr[i13 - 1] & 255) > 0 && b11 < i11) {
                i13 -= b11;
                int i14 = 1;
                int i15 = i13;
                while (i14 <= b11) {
                    if (i14 == (this.buffer[i15] & 255)) {
                        i14++;
                        i15++;
                    } else {
                        throw new IllegalArgumentException("incorrect padding");
                    }
                }
            }
            return Arrays.copyOfRange(this.buffer, i12, i13);
        } else {
            throw new IllegalArgumentException("missing padding");
        }
    }

    public String readString() {
        return Strings.fromByteArray(readBlock());
    }

    public int readU32() {
        int i11 = this.pos;
        byte[] bArr = this.buffer;
        if (i11 <= bArr.length - 4) {
            int i12 = i11 + 1;
            this.pos = i12;
            int i13 = (bArr[i11] & 255) << Ascii.CAN;
            int i14 = i12 + 1;
            this.pos = i14;
            byte b11 = i13 | ((bArr[i12] & 255) << 16);
            int i15 = i14 + 1;
            this.pos = i15;
            byte b12 = b11 | ((bArr[i14] & 255) << 8);
            this.pos = i15 + 1;
            return b12 | (bArr[i15] & 255);
        }
        throw new IllegalArgumentException("4 bytes for U32 exceeds buffer.");
    }

    public void skipBlock() {
        int readU32 = readU32();
        int i11 = this.pos;
        if (i11 <= this.buffer.length - readU32) {
            this.pos = i11 + readU32;
            return;
        }
        throw new IllegalArgumentException("not enough data for block");
    }
}
