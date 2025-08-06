package com.google.zxing.common;

public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i11) {
        if (i11 <= 0 || i11 > 32 || i11 > available()) {
            throw new IllegalArgumentException(String.valueOf(i11));
        }
        int i12 = this.bitOffset;
        byte b11 = 0;
        if (i12 > 0) {
            int i13 = 8 - i12;
            int i14 = i11 < i13 ? i11 : i13;
            int i15 = i13 - i14;
            byte[] bArr = this.bytes;
            int i16 = this.byteOffset;
            int i17 = (((255 >> (8 - i14)) << i15) & bArr[i16]) >> i15;
            i11 -= i14;
            int i18 = i12 + i14;
            this.bitOffset = i18;
            if (i18 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i16 + 1;
            }
            b11 = i17;
        }
        if (i11 <= 0) {
            return b11;
        }
        while (i11 >= 8) {
            int i19 = b11 << 8;
            byte[] bArr2 = this.bytes;
            int i21 = this.byteOffset;
            b11 = (bArr2[i21] & 255) | i19;
            this.byteOffset = i21 + 1;
            i11 -= 8;
        }
        if (i11 <= 0) {
            return b11;
        }
        int i22 = 8 - i11;
        int i23 = (b11 << i11) | ((((255 >> i22) << i22) & this.bytes[this.byteOffset]) >> i22);
        this.bitOffset += i11;
        return i23;
    }
}
