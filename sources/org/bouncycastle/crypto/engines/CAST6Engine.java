package org.bouncycastle.crypto.engines;

public final class CAST6Engine extends CAST5Engine {
    public static final int BLOCK_SIZE = 16;
    public static final int ROUNDS = 12;
    public int[] _Km = new int[48];
    public int[] _Kr = new int[48];
    public int[] _Tm = new int[192];
    public int[] _Tr = new int[192];
    private int[] _workingKey = new int[8];

    public final void CAST_Decipher(int i11, int i12, int i13, int i14, int[] iArr) {
        int i15;
        int i16 = 0;
        while (true) {
            if (i16 >= 6) {
                break;
            }
            int i17 = (11 - i16) * 4;
            i13 ^= F1(i14, this._Km[i17], this._Kr[i17]);
            int i18 = i17 + 1;
            i12 ^= F2(i13, this._Km[i18], this._Kr[i18]);
            int i19 = i17 + 2;
            i11 ^= F3(i12, this._Km[i19], this._Kr[i19]);
            int i21 = i17 + 3;
            i14 ^= F1(i11, this._Km[i21], this._Kr[i21]);
            i16++;
        }
        for (i15 = 6; i15 < 12; i15++) {
            int i22 = (11 - i15) * 4;
            int i23 = i22 + 3;
            i14 ^= F1(i11, this._Km[i23], this._Kr[i23]);
            int i24 = i22 + 2;
            i11 ^= F3(i12, this._Km[i24], this._Kr[i24]);
            int i25 = i22 + 1;
            i12 ^= F2(i13, this._Km[i25], this._Kr[i25]);
            i13 ^= F1(i14, this._Km[i22], this._Kr[i22]);
        }
        iArr[0] = i11;
        iArr[1] = i12;
        iArr[2] = i13;
        iArr[3] = i14;
    }

    public final void CAST_Encipher(int i11, int i12, int i13, int i14, int[] iArr) {
        int i15;
        int i16 = 0;
        while (true) {
            if (i16 >= 6) {
                break;
            }
            int i17 = i16 * 4;
            i13 ^= F1(i14, this._Km[i17], this._Kr[i17]);
            int i18 = i17 + 1;
            i12 ^= F2(i13, this._Km[i18], this._Kr[i18]);
            int i19 = i17 + 2;
            i11 ^= F3(i12, this._Km[i19], this._Kr[i19]);
            int i21 = i17 + 3;
            i14 ^= F1(i11, this._Km[i21], this._Kr[i21]);
            i16++;
        }
        for (i15 = 6; i15 < 12; i15++) {
            int i22 = i15 * 4;
            int i23 = i22 + 3;
            i14 ^= F1(i11, this._Km[i23], this._Kr[i23]);
            int i24 = i22 + 2;
            i11 ^= F3(i12, this._Km[i24], this._Kr[i24]);
            int i25 = i22 + 1;
            i12 ^= F2(i13, this._Km[i25], this._Kr[i25]);
            i13 ^= F1(i14, this._Km[i22], this._Kr[i22]);
        }
        iArr[0] = i11;
        iArr[1] = i12;
        iArr[2] = i13;
        iArr[3] = i14;
    }

    public int decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int[] iArr = new int[4];
        CAST_Decipher(BytesTo32bits(bArr, i11), BytesTo32bits(bArr, i11 + 4), BytesTo32bits(bArr, i11 + 8), BytesTo32bits(bArr, i11 + 12), iArr);
        Bits32ToBytes(iArr[0], bArr2, i12);
        Bits32ToBytes(iArr[1], bArr2, i12 + 4);
        Bits32ToBytes(iArr[2], bArr2, i12 + 8);
        Bits32ToBytes(iArr[3], bArr2, i12 + 12);
        return 16;
    }

    public int encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int[] iArr = new int[4];
        CAST_Encipher(BytesTo32bits(bArr, i11), BytesTo32bits(bArr, i11 + 4), BytesTo32bits(bArr, i11 + 8), BytesTo32bits(bArr, i11 + 12), iArr);
        Bits32ToBytes(iArr[0], bArr2, i12);
        Bits32ToBytes(iArr[1], bArr2, i12 + 4);
        Bits32ToBytes(iArr[2], bArr2, i12 + 8);
        Bits32ToBytes(iArr[3], bArr2, i12 + 12);
        return 16;
    }

    public String getAlgorithmName() {
        return "CAST6";
    }

    public int getBlockSize() {
        return 16;
    }

    public void reset() {
    }

    public void setKey(byte[] bArr) {
        byte[] bArr2 = bArr;
        int i11 = 1518500249;
        int i12 = 19;
        for (int i13 = 0; i13 < 24; i13++) {
            for (int i14 = 0; i14 < 8; i14++) {
                int i15 = (i13 * 8) + i14;
                this._Tm[i15] = i11;
                i11 += 1859775393;
                this._Tr[i15] = i12;
                i12 = (i12 + 17) & 31;
            }
        }
        byte[] bArr3 = new byte[64];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        for (int i16 = 0; i16 < 8; i16++) {
            this._workingKey[i16] = BytesTo32bits(bArr3, i16 * 4);
        }
        for (int i17 = 0; i17 < 12; i17++) {
            int i18 = i17 * 2;
            int i19 = i18 * 8;
            int[] iArr = this._workingKey;
            iArr[6] = iArr[6] ^ F1(iArr[7], this._Tm[i19], this._Tr[i19]);
            int[] iArr2 = this._workingKey;
            int i21 = i19 + 1;
            iArr2[5] = iArr2[5] ^ F2(iArr2[6], this._Tm[i21], this._Tr[i21]);
            int[] iArr3 = this._workingKey;
            int i22 = i19 + 2;
            iArr3[4] = iArr3[4] ^ F3(iArr3[5], this._Tm[i22], this._Tr[i22]);
            int[] iArr4 = this._workingKey;
            int i23 = i19 + 3;
            iArr4[3] = F1(iArr4[4], this._Tm[i23], this._Tr[i23]) ^ iArr4[3];
            int[] iArr5 = this._workingKey;
            int i24 = i19 + 4;
            iArr5[2] = F2(iArr5[3], this._Tm[i24], this._Tr[i24]) ^ iArr5[2];
            int[] iArr6 = this._workingKey;
            int i25 = i19 + 5;
            iArr6[1] = F3(iArr6[2], this._Tm[i25], this._Tr[i25]) ^ iArr6[1];
            int[] iArr7 = this._workingKey;
            int i26 = i19 + 6;
            iArr7[0] = iArr7[0] ^ F1(iArr7[1], this._Tm[i26], this._Tr[i26]);
            int[] iArr8 = this._workingKey;
            int i27 = i19 + 7;
            iArr8[7] = F2(iArr8[0], this._Tm[i27], this._Tr[i27]) ^ iArr8[7];
            int i28 = (i18 + 1) * 8;
            int[] iArr9 = this._workingKey;
            iArr9[6] = iArr9[6] ^ F1(iArr9[7], this._Tm[i28], this._Tr[i28]);
            int[] iArr10 = this._workingKey;
            int i29 = i28 + 1;
            iArr10[5] = iArr10[5] ^ F2(iArr10[6], this._Tm[i29], this._Tr[i29]);
            int[] iArr11 = this._workingKey;
            int i30 = i28 + 2;
            iArr11[4] = iArr11[4] ^ F3(iArr11[5], this._Tm[i30], this._Tr[i30]);
            int[] iArr12 = this._workingKey;
            int i31 = i28 + 3;
            iArr12[3] = F1(iArr12[4], this._Tm[i31], this._Tr[i31]) ^ iArr12[3];
            int[] iArr13 = this._workingKey;
            int i32 = i28 + 4;
            iArr13[2] = F2(iArr13[3], this._Tm[i32], this._Tr[i32]) ^ iArr13[2];
            int[] iArr14 = this._workingKey;
            int i33 = i28 + 5;
            iArr14[1] = F3(iArr14[2], this._Tm[i33], this._Tr[i33]) ^ iArr14[1];
            int[] iArr15 = this._workingKey;
            int i34 = i28 + 6;
            iArr15[0] = iArr15[0] ^ F1(iArr15[1], this._Tm[i34], this._Tr[i34]);
            int[] iArr16 = this._workingKey;
            int i35 = i28 + 7;
            iArr16[7] = F2(iArr16[0], this._Tm[i35], this._Tr[i35]) ^ iArr16[7];
            int[] iArr17 = this._Kr;
            int i36 = i17 * 4;
            int[] iArr18 = this._workingKey;
            iArr17[i36] = iArr18[0] & 31;
            int i37 = i36 + 1;
            iArr17[i37] = iArr18[2] & 31;
            int i38 = i36 + 2;
            iArr17[i38] = iArr18[4] & 31;
            int i39 = i36 + 3;
            iArr17[i39] = iArr18[6] & 31;
            int[] iArr19 = this._Km;
            iArr19[i36] = iArr18[7];
            iArr19[i37] = iArr18[5];
            iArr19[i38] = iArr18[3];
            iArr19[i39] = iArr18[1];
        }
    }
}
