package org.bouncycastle.pqc.crypto.cmce;

abstract class BENES {
    public final int GFBITS;
    public final int SYS_N;
    public final int SYS_T;

    public BENES(int i11, int i12, int i13) {
        this.SYS_N = i11;
        this.SYS_T = i12;
        this.GFBITS = i13;
    }

    public static void transpose_64x64(long[] jArr, long[] jArr2) {
        long[][] jArr3 = {new long[]{6148914691236517205L, -6148914691236517206L}, new long[]{3689348814741910323L, -3689348814741910324L}, new long[]{1085102592571150095L, -1085102592571150096L}, new long[]{71777214294589695L, -71777214294589696L}, new long[]{281470681808895L, -281470681808896L}, new long[]{4294967295L, -4294967296L}};
        for (int i11 = 0; i11 < 64; i11++) {
            jArr[i11] = jArr2[i11];
        }
        for (int i12 = 5; i12 >= 0; i12--) {
            int i13 = 1 << i12;
            for (int i14 = 0; i14 < 64; i14 += i13 * 2) {
                for (int i15 = i14; i15 < i14 + i13; i15++) {
                    int i16 = i15 + i13;
                    long j11 = (jArr[i15] & jArr3[i12][0]) | ((jArr[i16] & jArr3[i12][0]) << i13);
                    long j12 = ((jArr[i15] & jArr3[i12][1]) >>> i13) | (jArr[i16] & jArr3[i12][1]);
                    jArr[i15 + 0] = j11;
                    jArr[i16] = j12;
                }
            }
        }
    }

    public static void transpose_64x64(long[] jArr, long[] jArr2, int i11) {
        long[][] jArr3 = {new long[]{6148914691236517205L, -6148914691236517206L}, new long[]{3689348814741910323L, -3689348814741910324L}, new long[]{1085102592571150095L, -1085102592571150096L}, new long[]{71777214294589695L, -71777214294589696L}, new long[]{281470681808895L, -281470681808896L}, new long[]{4294967295L, -4294967296L}};
        for (int i12 = 0; i12 < 64; i12++) {
            int i13 = i12 + i11;
            jArr[i13] = jArr2[i13];
        }
        for (int i14 = 5; i14 >= 0; i14--) {
            int i15 = 1 << i14;
            for (int i16 = 0; i16 < 64; i16 += i15 * 2) {
                for (int i17 = i16; i17 < i16 + i15; i17++) {
                    int i18 = i17 + i11;
                    int i19 = i17 + i15 + i11;
                    jArr[i17 + 0 + i11] = (jArr[i18] & jArr3[i14][0]) | ((jArr[i19] & jArr3[i14][0]) << i15);
                    jArr[i19] = ((jArr[i18] & jArr3[i14][1]) >>> i15) | (jArr[i19] & jArr3[i14][1]);
                }
            }
        }
    }

    public abstract void support_gen(short[] sArr, byte[] bArr);
}
