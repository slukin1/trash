package org.bouncycastle.pqc.crypto.cmce;

import java.lang.reflect.Array;

class BENES13 extends BENES {
    public BENES13(int i11, int i12, int i13) {
        super(i11, i12, i13);
    }

    public static void layer_ex(long[] jArr, long[] jArr2, int i11) {
        int i12 = 1 << i11;
        int i13 = 0;
        for (int i14 = 0; i14 < 128; i14 += i12 * 2) {
            int i15 = i14;
            while (i15 < i14 + i12) {
                int i16 = i15 + 0;
                int i17 = i15 + i12;
                long j11 = (jArr[i16] ^ jArr[i17]) & jArr2[i13];
                jArr[i16] = jArr[i16] ^ j11;
                jArr[i17] = jArr[i17] ^ j11;
                i15++;
                i13++;
            }
        }
    }

    public static void layer_in(long[] jArr, long[] jArr2, int i11) {
        int i12 = 1 << i11;
        int i13 = 0;
        for (int i14 = 0; i14 < 64; i14 += i12 * 2) {
            int i15 = i14;
            while (i15 < i14 + i12) {
                int i16 = i15 + 0;
                int i17 = i15 + i12;
                int i18 = i13 + 1;
                long j11 = (jArr[i16] ^ jArr[i17]) & jArr2[i13];
                jArr[i16] = jArr[i16] ^ j11;
                jArr[i17] = jArr[i17] ^ j11;
                int i19 = i15 + 64;
                int i21 = i19 + 0;
                int i22 = i19 + i12;
                long j12 = (jArr[i21] ^ jArr[i22]) & jArr2[i18];
                jArr[i21] = jArr[i21] ^ j12;
                jArr[i22] = jArr[i22] ^ j12;
                i15++;
                i13 = i18 + 1;
            }
        }
    }

    public void apply_benes(byte[] bArr, byte[] bArr2, int i11) {
        int i12;
        int i13;
        int i14;
        long[] jArr = new long[128];
        long[] jArr2 = new long[128];
        long[] jArr3 = new long[64];
        long[] jArr4 = new long[64];
        if (i11 == 0) {
            i12 = (this.SYS_T * 2) + 40;
            i13 = 0;
        } else {
            i12 = (this.SYS_T * 2) + 40 + 12288;
            i13 = -1024;
        }
        for (int i15 = 0; i15 < 64; i15++) {
            int i16 = (i15 * 16) + 0;
            jArr[i15 + 0] = Utils.load8(bArr, i16 + 0);
            jArr[i15 + 64] = Utils.load8(bArr, i16 + 8);
        }
        BENES.transpose_64x64(jArr2, jArr, 0);
        BENES.transpose_64x64(jArr2, jArr, 64);
        int i17 = 0;
        while (true) {
            if (i17 > 6) {
                break;
            }
            for (int i18 = 0; i18 < 64; i18++) {
                jArr3[i18] = Utils.load8(bArr2, i12);
                i12 += 8;
            }
            i12 += i13;
            BENES.transpose_64x64(jArr4, jArr3);
            layer_ex(jArr2, jArr4, i17);
            i17++;
        }
        BENES.transpose_64x64(jArr, jArr2, 0);
        BENES.transpose_64x64(jArr, jArr2, 64);
        for (int i19 = 0; i19 <= 5; i19++) {
            for (int i21 = 0; i21 < 64; i21++) {
                jArr3[i21] = Utils.load8(bArr2, i12);
                i12 += 8;
            }
            i12 += i13;
            layer_in(jArr, jArr3, i19);
        }
        for (int i22 = 4; i22 >= 0; i22--) {
            for (int i23 = 0; i23 < 64; i23++) {
                jArr3[i23] = Utils.load8(bArr2, i12);
                i12 += 8;
            }
            i12 += i13;
            layer_in(jArr, jArr3, i22);
        }
        BENES.transpose_64x64(jArr2, jArr, 0);
        BENES.transpose_64x64(jArr2, jArr, 64);
        for (i14 = 6; i14 >= 0; i14--) {
            for (int i24 = 0; i24 < 64; i24++) {
                jArr3[i24] = Utils.load8(bArr2, i12);
                i12 += 8;
            }
            i12 += i13;
            BENES.transpose_64x64(jArr4, jArr3);
            layer_ex(jArr2, jArr4, i14);
        }
        BENES.transpose_64x64(jArr, jArr2, 0);
        BENES.transpose_64x64(jArr, jArr2, 64);
        for (int i25 = 0; i25 < 64; i25++) {
            int i26 = (i25 * 16) + 0;
            Utils.store8(bArr, i26 + 0, jArr[i25 + 0]);
            Utils.store8(bArr, i26 + 8, jArr[i25 + 64]);
        }
    }

    public void support_gen(short[] sArr, byte[] bArr) {
        int i11 = this.GFBITS;
        int[] iArr = new int[2];
        iArr[1] = (1 << i11) / 8;
        iArr[0] = i11;
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, iArr);
        for (int i12 = 0; i12 < this.GFBITS; i12++) {
            for (int i13 = 0; i13 < (1 << this.GFBITS) / 8; i13++) {
                bArr2[i12][i13] = 0;
            }
        }
        int i14 = 0;
        while (true) {
            int i15 = this.GFBITS;
            if (i14 >= (1 << i15)) {
                break;
            }
            short bitrev = Utils.bitrev((short) i14, i15);
            for (int i16 = 0; i16 < this.GFBITS; i16++) {
                byte[] bArr3 = bArr2[i16];
                int i17 = i14 / 8;
                bArr3[i17] = (byte) (bArr3[i17] | (((bitrev >> i16) & 1) << (i14 % 8)));
            }
            i14++;
        }
        for (int i18 = 0; i18 < this.GFBITS; i18++) {
            apply_benes(bArr2[i18], bArr, 0);
        }
        for (int i19 = 0; i19 < this.SYS_N; i19++) {
            sArr[i19] = 0;
            for (int i21 = this.GFBITS - 1; i21 >= 0; i21--) {
                sArr[i19] = (short) (sArr[i19] << 1);
                sArr[i19] = (short) (sArr[i19] | ((bArr2[i21][i19 / 8] >> (i19 % 8)) & 1));
            }
        }
    }
}
