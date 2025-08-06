package com.google.android.exoplayer2.util;

import com.google.common.base.Charsets;
import java.nio.charset.Charset;

public final class ParsableBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    public byte[] data;

    public ParsableBitArray() {
        this.data = Util.EMPTY_BYTE_ARRAY;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.byteLimit;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void assertValidOffset() {
        /*
            r2 = this;
            int r0 = r2.byteOffset
            if (r0 < 0) goto L_0x0010
            int r1 = r2.byteLimit
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.bitOffset
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.google.android.exoplayer2.util.Assertions.checkState(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.ParsableBitArray.assertValidOffset():void");
    }

    public int bitsLeft() {
        return ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset;
    }

    public void byteAlign() {
        if (this.bitOffset != 0) {
            this.bitOffset = 0;
            this.byteOffset++;
            assertValidOffset();
        }
    }

    public int getBytePosition() {
        Assertions.checkState(this.bitOffset == 0);
        return this.byteOffset;
    }

    public int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public void putInt(int i11, int i12) {
        if (i12 < 32) {
            i11 &= (1 << i12) - 1;
        }
        int min = Math.min(8 - this.bitOffset, i12);
        int i13 = this.bitOffset;
        int i14 = (8 - i13) - min;
        byte[] bArr = this.data;
        int i15 = this.byteOffset;
        bArr[i15] = (byte) (((65280 >> i13) | ((1 << i14) - 1)) & bArr[i15]);
        int i16 = i12 - min;
        bArr[i15] = (byte) (((i11 >>> i16) << i14) | bArr[i15]);
        int i17 = i15 + 1;
        while (i16 > 8) {
            this.data[i17] = (byte) (i11 >>> (i16 - 8));
            i16 -= 8;
            i17++;
        }
        int i18 = 8 - i16;
        byte[] bArr2 = this.data;
        bArr2[i17] = (byte) (bArr2[i17] & ((1 << i18) - 1));
        bArr2[i17] = (byte) (((i11 & ((1 << i16) - 1)) << i18) | bArr2[i17]);
        skipBits(i12);
        assertValidOffset();
    }

    public boolean readBit() {
        boolean z11 = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        skipBit();
        return z11;
    }

    public int readBits(int i11) {
        int i12;
        if (i11 == 0) {
            return 0;
        }
        this.bitOffset += i11;
        int i13 = 0;
        while (true) {
            i12 = this.bitOffset;
            if (i12 <= 8) {
                break;
            }
            int i14 = i12 - 8;
            this.bitOffset = i14;
            byte[] bArr = this.data;
            int i15 = this.byteOffset;
            this.byteOffset = i15 + 1;
            i13 |= (bArr[i15] & 255) << i14;
        }
        byte[] bArr2 = this.data;
        int i16 = this.byteOffset;
        int i17 = (-1 >>> (32 - i11)) & (i13 | ((bArr2[i16] & 255) >> (8 - i12)));
        if (i12 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i16 + 1;
        }
        assertValidOffset();
        return i17;
    }

    public long readBitsToLong(int i11) {
        if (i11 <= 32) {
            return Util.toUnsignedLong(readBits(i11));
        }
        return Util.toLong(readBits(i11 - 32), readBits(32));
    }

    public void readBytes(byte[] bArr, int i11, int i12) {
        Assertions.checkState(this.bitOffset == 0);
        System.arraycopy(this.data, this.byteOffset, bArr, i11, i12);
        this.byteOffset += i12;
        assertValidOffset();
    }

    public String readBytesAsString(int i11) {
        return readBytesAsString(i11, Charsets.UTF_8);
    }

    public void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public void setPosition(int i11) {
        int i12 = i11 / 8;
        this.byteOffset = i12;
        this.bitOffset = i11 - (i12 * 8);
        assertValidOffset();
    }

    public void skipBit() {
        int i11 = this.bitOffset + 1;
        this.bitOffset = i11;
        if (i11 == 8) {
            this.bitOffset = 0;
            this.byteOffset++;
        }
        assertValidOffset();
    }

    public void skipBits(int i11) {
        int i12 = i11 / 8;
        int i13 = this.byteOffset + i12;
        this.byteOffset = i13;
        int i14 = this.bitOffset + (i11 - (i12 * 8));
        this.bitOffset = i14;
        if (i14 > 7) {
            this.byteOffset = i13 + 1;
            this.bitOffset = i14 - 8;
        }
        assertValidOffset();
    }

    public void skipBytes(int i11) {
        Assertions.checkState(this.bitOffset == 0);
        this.byteOffset += i11;
        assertValidOffset();
    }

    public String readBytesAsString(int i11, Charset charset) {
        byte[] bArr = new byte[i11];
        readBytes(bArr, 0, i11);
        return new String(bArr, charset);
    }

    public void reset(ParsableByteArray parsableByteArray) {
        reset(parsableByteArray.getData(), parsableByteArray.limit());
        setPosition(parsableByteArray.getPosition() * 8);
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ParsableBitArray(byte[] bArr, int i11) {
        this.data = bArr;
        this.byteLimit = i11;
    }

    public void reset(byte[] bArr, int i11) {
        this.data = bArr;
        this.byteOffset = 0;
        this.bitOffset = 0;
        this.byteLimit = i11;
    }

    public void readBits(byte[] bArr, int i11, int i12) {
        int i13 = (i12 >> 3) + i11;
        while (i11 < i13) {
            byte[] bArr2 = this.data;
            int i14 = this.byteOffset;
            int i15 = i14 + 1;
            this.byteOffset = i15;
            byte b11 = bArr2[i14];
            int i16 = this.bitOffset;
            bArr[i11] = (byte) (b11 << i16);
            bArr[i11] = (byte) (((255 & bArr2[i15]) >> (8 - i16)) | bArr[i11]);
            i11++;
        }
        int i17 = i12 & 7;
        if (i17 != 0) {
            bArr[i13] = (byte) (bArr[i13] & (255 >> i17));
            int i18 = this.bitOffset;
            if (i18 + i17 > 8) {
                byte b12 = bArr[i13];
                byte[] bArr3 = this.data;
                int i19 = this.byteOffset;
                this.byteOffset = i19 + 1;
                bArr[i13] = (byte) (b12 | ((bArr3[i19] & 255) << i18));
                this.bitOffset = i18 - 8;
            }
            int i21 = this.bitOffset + i17;
            this.bitOffset = i21;
            byte[] bArr4 = this.data;
            int i22 = this.byteOffset;
            bArr[i13] = (byte) (((byte) (((255 & bArr4[i22]) >> (8 - i21)) << (8 - i17))) | bArr[i13]);
            if (i21 == 8) {
                this.bitOffset = 0;
                this.byteOffset = i22 + 1;
            }
            assertValidOffset();
        }
    }
}
