package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.util.Arrays;

class ErrorCorrection {
    public static short LDDecode(int i11, int i12, int i13, int i14) {
        return (short) (((((g(i11) + g(i12)) + g(i13)) + g(i14)) - 98312) >>> 31);
    }

    public static int abs(int i11) {
        int i12 = i11 >> 31;
        return (i11 ^ i12) - i12;
    }

    public static int f(int[] iArr, int i11, int i12, int i13) {
        int i14 = (i13 * 2730) >> 25;
        int i15 = i14 - ((12288 - (i13 - (i14 * Params.Q))) >> 31);
        iArr[i11] = (i15 >> 1) + (i15 & 1);
        int i16 = i15 - 1;
        iArr[i12] = (i16 >> 1) + (i16 & 1);
        return abs(i13 - ((iArr[i11] * 2) * Params.Q));
    }

    public static int g(int i11) {
        int i12 = (i11 * 2730) >> 27;
        int i13 = i12 - ((49155 - (i11 - (49156 * i12))) >> 31);
        return abs((((i13 >> 1) + (i13 & 1)) * 98312) - i11);
    }

    public static void helpRec(short[] sArr, short[] sArr2, byte[] bArr, byte b11) {
        short s11 = 8;
        byte[] bArr2 = new byte[8];
        bArr2[0] = b11;
        byte[] bArr3 = new byte[32];
        ChaCha20.process(bArr, bArr2, bArr3, 0, 32);
        int[] iArr = new int[8];
        int[] iArr2 = new int[4];
        int i11 = 0;
        while (i11 < 256) {
            int i12 = i11 + 0;
            int i13 = ((bArr3[i11 >>> 3] >>> (i11 & 7)) & 1) * 4;
            int i14 = i11 + 256;
            int i15 = i11 + 512;
            int i16 = i11 + 768;
            int f11 = (24577 - (((f(iArr, 0, 4, (sArr2[i12] * s11) + i13) + f(iArr, 1, 5, (sArr2[i14] * s11) + i13)) + f(iArr, 2, 6, (sArr2[i15] * s11) + i13)) + f(iArr, 3, 7, (sArr2[i16] * 8) + i13))) >> 31;
            int i17 = ~f11;
            iArr2[0] = (i17 & iArr[0]) ^ (f11 & iArr[4]);
            iArr2[1] = (i17 & iArr[1]) ^ (f11 & iArr[5]);
            iArr2[2] = (i17 & iArr[2]) ^ (f11 & iArr[6]);
            iArr2[3] = (i17 & iArr[3]) ^ (iArr[7] & f11);
            sArr[i12] = (short) ((iArr2[0] - iArr2[3]) & 3);
            sArr[i14] = (short) ((iArr2[1] - iArr2[3]) & 3);
            sArr[i15] = (short) ((iArr2[2] - iArr2[3]) & 3);
            sArr[i16] = (short) (3 & ((-f11) + (iArr2[3] * 2)));
            i11++;
            s11 = 8;
        }
    }

    public static void rec(byte[] bArr, short[] sArr, short[] sArr2) {
        Arrays.fill(bArr, (byte) 0);
        int[] iArr = new int[4];
        for (int i11 = 0; i11 < 256; i11++) {
            int i12 = i11 + 0;
            int i13 = i11 + 768;
            iArr[0] = ((sArr[i12] * 8) + 196624) - (((sArr2[i12] * 2) + sArr2[i13]) * Params.Q);
            int i14 = i11 + 256;
            iArr[1] = ((sArr[i14] * 8) + 196624) - (((sArr2[i14] * 2) + sArr2[i13]) * Params.Q);
            int i15 = i11 + 512;
            iArr[2] = ((sArr[i15] * 8) + 196624) - (((sArr2[i15] * 2) + sArr2[i13]) * Params.Q);
            iArr[3] = ((sArr[i13] * 8) + 196624) - (sArr2[i13] * 12289);
            int i16 = i11 >>> 3;
            bArr[i16] = (byte) ((LDDecode(iArr[0], iArr[1], iArr[2], iArr[3]) << (i11 & 7)) | bArr[i16]);
        }
    }
}
