package com.google.android.exoplayer2.util;

public final class ParsableNalUnitBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    private byte[] data;

    public ParsableNalUnitBitArray(byte[] bArr, int i11, int i12) {
        reset(bArr, i11, i12);
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.ParsableNalUnitBitArray.assertValidOffset():void");
    }

    private int readExpGolombCodeNum() {
        int i11 = 0;
        int i12 = 0;
        while (!readBit()) {
            i12++;
        }
        int i13 = (1 << i12) - 1;
        if (i12 > 0) {
            i11 = readBits(i12);
        }
        return i13 + i11;
    }

    private boolean shouldSkipByte(int i11) {
        if (2 <= i11 && i11 < this.byteLimit) {
            byte[] bArr = this.data;
            return bArr[i11] == 3 && bArr[i11 + -2] == 0 && bArr[i11 - 1] == 0;
        }
    }

    public boolean canReadBits(int i11) {
        int i12 = this.byteOffset;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        int i15 = (this.bitOffset + i11) - (i13 * 8);
        if (i15 > 7) {
            i14++;
            i15 -= 8;
        }
        while (true) {
            i12++;
            if (i12 > i14 || i14 >= this.byteLimit) {
                int i16 = this.byteLimit;
            } else if (shouldSkipByte(i12)) {
                i14++;
                i12 += 2;
            }
        }
        int i162 = this.byteLimit;
        if (i14 < i162) {
            return true;
        }
        if (i14 == i162 && i15 == 0) {
            return true;
        }
        return false;
    }

    public boolean canReadExpGolombCodedNum() {
        int i11 = this.byteOffset;
        int i12 = this.bitOffset;
        int i13 = 0;
        while (this.byteOffset < this.byteLimit && !readBit()) {
            i13++;
        }
        boolean z11 = this.byteOffset == this.byteLimit;
        this.byteOffset = i11;
        this.bitOffset = i12;
        if (z11 || !canReadBits((i13 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public boolean readBit() {
        boolean z11 = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        skipBit();
        return z11;
    }

    public int readBits(int i11) {
        int i12;
        int i13;
        this.bitOffset += i11;
        int i14 = 0;
        while (true) {
            i12 = this.bitOffset;
            i13 = 2;
            if (i12 <= 8) {
                break;
            }
            int i15 = i12 - 8;
            this.bitOffset = i15;
            byte[] bArr = this.data;
            int i16 = this.byteOffset;
            i14 |= (bArr[i16] & 255) << i15;
            if (!shouldSkipByte(i16 + 1)) {
                i13 = 1;
            }
            this.byteOffset = i16 + i13;
        }
        byte[] bArr2 = this.data;
        int i17 = this.byteOffset;
        int i18 = (-1 >>> (32 - i11)) & (i14 | ((bArr2[i17] & 255) >> (8 - i12)));
        if (i12 == 8) {
            this.bitOffset = 0;
            if (!shouldSkipByte(i17 + 1)) {
                i13 = 1;
            }
            this.byteOffset = i17 + i13;
        }
        assertValidOffset();
        return i18;
    }

    public int readSignedExpGolombCodedInt() {
        int readExpGolombCodeNum = readExpGolombCodeNum();
        return (readExpGolombCodeNum % 2 == 0 ? -1 : 1) * ((readExpGolombCodeNum + 1) / 2);
    }

    public int readUnsignedExpGolombCodedInt() {
        return readExpGolombCodeNum();
    }

    public void reset(byte[] bArr, int i11, int i12) {
        this.data = bArr;
        this.byteOffset = i11;
        this.byteLimit = i12;
        this.bitOffset = 0;
        assertValidOffset();
    }

    public void skipBit() {
        int i11 = 1;
        int i12 = this.bitOffset + 1;
        this.bitOffset = i12;
        if (i12 == 8) {
            this.bitOffset = 0;
            int i13 = this.byteOffset;
            if (shouldSkipByte(i13 + 1)) {
                i11 = 2;
            }
            this.byteOffset = i13 + i11;
        }
        assertValidOffset();
    }

    public void skipBits(int i11) {
        int i12 = this.byteOffset;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        this.byteOffset = i14;
        int i15 = this.bitOffset + (i11 - (i13 * 8));
        this.bitOffset = i15;
        if (i15 > 7) {
            this.byteOffset = i14 + 1;
            this.bitOffset = i15 - 8;
        }
        while (true) {
            i12++;
            if (i12 > this.byteOffset) {
                assertValidOffset();
                return;
            } else if (shouldSkipByte(i12)) {
                this.byteOffset++;
                i12 += 2;
            }
        }
    }
}
