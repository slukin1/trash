package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class IDEAEngine implements BlockCipher {
    private static final int BASE = 65537;
    public static final int BLOCK_SIZE = 8;
    private static final int MASK = 65535;
    private int[] workingKey = null;

    private int bytesToWord(byte[] bArr, int i11) {
        return ((bArr[i11] << 8) & 65280) + (bArr[i11 + 1] & 255);
    }

    private int[] expandKey(byte[] bArr) {
        int i11;
        int[] iArr = new int[52];
        int i12 = 0;
        if (bArr.length < 16) {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
            bArr = bArr2;
        }
        while (true) {
            if (i12 >= 8) {
                break;
            }
            iArr[i12] = bytesToWord(bArr, i12 * 2);
            i12++;
        }
        for (i11 = 8; i11 < 52; i11++) {
            int i13 = i11 & 7;
            if (i13 < 6) {
                iArr[i11] = (((iArr[i11 - 7] & 127) << 9) | (iArr[i11 - 6] >> 7)) & 65535;
            } else if (i13 == 6) {
                iArr[i11] = (((iArr[i11 - 7] & 127) << 9) | (iArr[i11 - 14] >> 7)) & 65535;
            } else {
                iArr[i11] = (((iArr[i11 - 15] & 127) << 9) | (iArr[i11 - 14] >> 7)) & 65535;
            }
        }
        return iArr;
    }

    private int[] generateWorkingKey(boolean z11, byte[] bArr) {
        return z11 ? expandKey(bArr) : invertKey(expandKey(bArr));
    }

    private void ideaFunc(int[] iArr, byte[] bArr, int i11, byte[] bArr2, int i12) {
        int bytesToWord = bytesToWord(bArr, i11);
        int bytesToWord2 = bytesToWord(bArr, i11 + 2);
        int bytesToWord3 = bytesToWord(bArr, i11 + 4);
        int bytesToWord4 = bytesToWord(bArr, i11 + 6);
        int i13 = 0;
        int i14 = bytesToWord3;
        int i15 = bytesToWord2;
        int i16 = bytesToWord;
        int i17 = 0;
        while (i13 < 8) {
            int i18 = i17 + 1;
            int mul = mul(i16, iArr[i17]);
            int i19 = i18 + 1;
            int i21 = (i15 + iArr[i18]) & 65535;
            int i22 = i19 + 1;
            int i23 = (i14 + iArr[i19]) & 65535;
            int i24 = i22 + 1;
            int mul2 = mul(bytesToWord4, iArr[i22]);
            int i25 = i24 + 1;
            int mul3 = mul(i23 ^ mul, iArr[i24]);
            int mul4 = mul(((i21 ^ mul2) + mul3) & 65535, iArr[i25]);
            int i26 = (mul3 + mul4) & 65535;
            bytesToWord4 = mul2 ^ i26;
            i14 = i26 ^ i21;
            i13++;
            i15 = i23 ^ mul4;
            i16 = mul ^ mul4;
            i17 = i25 + 1;
        }
        int i27 = i17 + 1;
        wordToBytes(mul(i16, iArr[i17]), bArr2, i12);
        int i28 = i27 + 1;
        wordToBytes(i14 + iArr[i27], bArr2, i12 + 2);
        wordToBytes(i15 + iArr[i28], bArr2, i12 + 4);
        wordToBytes(mul(bytesToWord4, iArr[i28 + 1]), bArr2, i12 + 6);
    }

    private int[] invertKey(int[] iArr) {
        int[] iArr2 = new int[52];
        int mulInv = mulInv(iArr[0]);
        int i11 = 1;
        int addInv = addInv(iArr[1]);
        int addInv2 = addInv(iArr[2]);
        iArr2[51] = mulInv(iArr[3]);
        iArr2[50] = addInv2;
        iArr2[49] = addInv;
        int i12 = 48;
        iArr2[48] = mulInv;
        int i13 = 4;
        while (i11 < 8) {
            int i14 = i13 + 1;
            int i15 = iArr[i13];
            int i16 = i14 + 1;
            int i17 = i12 - 1;
            iArr2[i17] = iArr[i14];
            int i18 = i17 - 1;
            iArr2[i18] = i15;
            int i19 = i16 + 1;
            int mulInv2 = mulInv(iArr[i16]);
            int i21 = i19 + 1;
            int addInv3 = addInv(iArr[i19]);
            int i22 = i21 + 1;
            int addInv4 = addInv(iArr[i21]);
            int i23 = i18 - 1;
            iArr2[i23] = mulInv(iArr[i22]);
            int i24 = i23 - 1;
            iArr2[i24] = addInv3;
            int i25 = i24 - 1;
            iArr2[i25] = addInv4;
            i12 = i25 - 1;
            iArr2[i12] = mulInv2;
            i11++;
            i13 = i22 + 1;
        }
        int i26 = i13 + 1;
        int i27 = iArr[i13];
        int i28 = i26 + 1;
        int i29 = i12 - 1;
        iArr2[i29] = iArr[i26];
        int i30 = i29 - 1;
        iArr2[i30] = i27;
        int i31 = i28 + 1;
        int mulInv3 = mulInv(iArr[i28]);
        int i32 = i31 + 1;
        int addInv5 = addInv(iArr[i31]);
        int i33 = i32 + 1;
        int addInv6 = addInv(iArr[i32]);
        int i34 = i30 - 1;
        iArr2[i34] = mulInv(iArr[i33]);
        int i35 = i34 - 1;
        iArr2[i35] = addInv6;
        int i36 = i35 - 1;
        iArr2[i36] = addInv5;
        iArr2[i36 - 1] = mulInv3;
        return iArr2;
    }

    private int mul(int i11, int i12) {
        int i13;
        if (i11 == 0) {
            i13 = 65537 - i12;
        } else if (i12 == 0) {
            i13 = 65537 - i11;
        } else {
            int i14 = i11 * i12;
            int i15 = i14 & 65535;
            int i16 = i14 >>> 16;
            i13 = (i15 - i16) + (i15 < i16 ? 1 : 0);
        }
        return i13 & 65535;
    }

    private int mulInv(int i11) {
        if (i11 < 2) {
            return i11;
        }
        int i12 = 65537 / i11;
        int i13 = 65537 % i11;
        int i14 = 1;
        while (i13 != 1) {
            int i15 = i11 / i13;
            i11 %= i13;
            i14 = (i14 + (i15 * i12)) & 65535;
            if (i11 == 1) {
                return i14;
            }
            int i16 = i13 / i11;
            i13 %= i11;
            i12 = (i12 + (i16 * i14)) & 65535;
        }
        return (1 - i12) & 65535;
    }

    private void wordToBytes(int i11, byte[] bArr, int i12) {
        bArr[i12] = (byte) (i11 >>> 8);
        bArr[i12 + 1] = (byte) i11;
    }

    public int addInv(int i11) {
        return (0 - i11) & 65535;
    }

    public String getAlgorithmName() {
        return "IDEA";
    }

    public int getBlockSize() {
        return 8;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(z11, ((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to IDEA init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int[] iArr = this.workingKey;
        if (iArr == null) {
            throw new IllegalStateException("IDEA engine not initialised");
        } else if (i11 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + 8 <= bArr2.length) {
            ideaFunc(iArr, bArr, i11, bArr2, i12);
            return 8;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
