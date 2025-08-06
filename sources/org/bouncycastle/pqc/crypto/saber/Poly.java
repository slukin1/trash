package org.bouncycastle.pqc.crypto.saber;

import com.sumsub.sns.internal.ml.autocapture.b;
import org.bouncycastle.crypto.digests.SHAKEDigest;

class Poly {
    private static final int KARATSUBA_N = 64;
    private static int SCHB_N = 16;
    private final int N_RES;
    private final int N_SB;
    private final int N_SB_RES;
    private final int SABER_L;
    private final int SABER_N;
    private final SABEREngine engine;
    private final Utils utils;

    public Poly(SABEREngine sABEREngine) {
        this.engine = sABEREngine;
        this.SABER_L = sABEREngine.getSABER_L();
        int saber_n = sABEREngine.getSABER_N();
        this.SABER_N = saber_n;
        this.N_RES = saber_n << 1;
        int i11 = saber_n >> 2;
        this.N_SB = i11;
        this.N_SB_RES = (i11 * 2) - 1;
        this.utils = sABEREngine.getUtils();
    }

    private short OVERFLOWING_MUL(int i11, int i12) {
        return (short) (i11 * i12);
    }

    private void cbd(short[] sArr, byte[] bArr, int i11) {
        byte[] bArr2 = bArr;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        if (this.engine.getSABER_MU() == 6) {
            for (int i12 = 0; i12 < this.SABER_N / 4; i12++) {
                int load_littleendian = (int) load_littleendian(bArr2, i11 + (i12 * 3), 3);
                int i13 = 0;
                for (int i14 = 0; i14 < 3; i14++) {
                    i13 += (load_littleendian >> i14) & 2396745;
                }
                iArr[0] = i13 & 7;
                iArr2[0] = (i13 >>> 3) & 7;
                iArr[1] = (i13 >>> 6) & 7;
                iArr2[1] = (i13 >>> 9) & 7;
                iArr[2] = (i13 >>> 12) & 7;
                iArr2[2] = (i13 >>> 15) & 7;
                iArr[3] = (i13 >>> 18) & 7;
                iArr2[3] = i13 >>> 21;
                int i15 = i12 * 4;
                sArr[i15 + 0] = (short) (iArr[0] - iArr2[0]);
                sArr[i15 + 1] = (short) (iArr[1] - iArr2[1]);
                sArr[i15 + 2] = (short) (iArr[2] - iArr2[2]);
                sArr[i15 + 3] = (short) (iArr[3] - iArr2[3]);
            }
        } else if (this.engine.getSABER_MU() == 8) {
            for (int i16 = 0; i16 < this.SABER_N / 4; i16++) {
                int i17 = i16 * 4;
                int load_littleendian2 = (int) load_littleendian(bArr2, i11 + i17, 4);
                int i18 = 0;
                for (int i19 = 0; i19 < 4; i19++) {
                    i18 += (load_littleendian2 >>> i19) & 286331153;
                }
                iArr[0] = i18 & 15;
                iArr2[0] = (i18 >>> 4) & 15;
                iArr[1] = (i18 >>> 8) & 15;
                iArr2[1] = (i18 >>> 12) & 15;
                iArr[2] = (i18 >>> 16) & 15;
                iArr2[2] = (i18 >>> 20) & 15;
                iArr[3] = (i18 >>> 24) & 15;
                iArr2[3] = i18 >>> 28;
                sArr[i17 + 0] = (short) (iArr[0] - iArr2[0]);
                sArr[i17 + 1] = (short) (iArr[1] - iArr2[1]);
                sArr[i17 + 2] = (short) (iArr[2] - iArr2[2]);
                sArr[i17 + 3] = (short) (iArr[3] - iArr2[3]);
            }
        } else if (this.engine.getSABER_MU() == 10) {
            for (int i21 = 0; i21 < this.SABER_N / 4; i21++) {
                long load_littleendian3 = load_littleendian(bArr2, i11 + (i21 * 5), 5);
                long j11 = 0;
                for (int i22 = 0; i22 < 5; i22++) {
                    j11 += (load_littleendian3 >>> i22) & 35468117025L;
                }
                iArr[0] = (int) (j11 & 31);
                iArr2[0] = (int) ((j11 >>> 5) & 31);
                iArr[1] = (int) ((j11 >>> 10) & 31);
                iArr2[1] = (int) ((j11 >>> 15) & 31);
                iArr[2] = (int) ((j11 >>> 20) & 31);
                iArr2[2] = (int) ((j11 >>> 25) & 31);
                iArr[3] = (int) ((j11 >>> 30) & 31);
                iArr2[3] = (int) (j11 >>> 35);
                int i23 = i21 * 4;
                sArr[i23 + 0] = (short) (iArr[0] - iArr2[0]);
                sArr[i23 + 1] = (short) (iArr[1] - iArr2[1]);
                sArr[i23 + 2] = (short) (iArr[2] - iArr2[2]);
                sArr[i23 + 3] = (short) (iArr[3] - iArr2[3]);
            }
        }
    }

    private void karatsuba_simple(int[] iArr, int[] iArr2, int[] iArr3) {
        int i11 = 31;
        int[] iArr4 = new int[31];
        int[] iArr5 = new int[31];
        int[] iArr6 = new int[31];
        int[] iArr7 = new int[63];
        int i12 = 0;
        while (true) {
            if (i12 >= 16) {
                break;
            }
            int i13 = iArr[i12];
            int i14 = iArr[i12 + 16];
            int i15 = iArr[i12 + 32];
            int i16 = iArr[i12 + 48];
            int i17 = 0;
            for (int i18 = 16; i17 < i18; i18 = 16) {
                int i19 = iArr2[i17];
                int i21 = iArr2[i17 + 16];
                int i22 = i12 + i17;
                int i23 = i22 + 0;
                iArr3[i23] = iArr3[i23] + OVERFLOWING_MUL(i13, i19);
                int i24 = i22 + 32;
                iArr3[i24] = iArr3[i24] + OVERFLOWING_MUL(i14, i21);
                int i25 = i19 + i21;
                int i26 = i21;
                int i27 = i13;
                int[] iArr8 = iArr7;
                iArr4[i22] = (int) (((long) iArr4[i22]) + (((long) i25) * ((long) (i13 + i14))));
                int i28 = iArr2[i17 + 32];
                int i29 = iArr2[i17 + 48];
                int i30 = i22 + 64;
                iArr3[i30] = iArr3[i30] + OVERFLOWING_MUL(i28, i15);
                int i31 = i22 + 96;
                iArr3[i31] = iArr3[i31] + OVERFLOWING_MUL(i29, i16);
                iArr6[i22] = iArr6[i22] + OVERFLOWING_MUL(i15 + i16, i28 + i29);
                int i32 = i19 + i28;
                int i33 = i27 + i15;
                iArr8[i23] = iArr8[i23] + OVERFLOWING_MUL(i32, i33);
                int i34 = i26 + i29;
                int i35 = i14 + i16;
                iArr8[i24] = iArr8[i24] + OVERFLOWING_MUL(i34, i35);
                iArr5[i22] = iArr5[i22] + OVERFLOWING_MUL(i32 + i34, i33 + i35);
                i17++;
                i13 = i27;
                i12 = i12;
                iArr7 = iArr8;
            }
            int[] iArr9 = iArr7;
            i12++;
            i11 = 31;
        }
        int[] iArr10 = iArr7;
        int i36 = i11;
        int i37 = 0;
        while (i37 < i36) {
            int i38 = i37 + 0;
            int i39 = i37 + 32;
            iArr5[i37] = (iArr5[i37] - iArr10[i38]) - iArr10[i39];
            iArr4[i37] = (iArr4[i37] - iArr3[i38]) - iArr3[i39];
            iArr6[i37] = (iArr6[i37] - iArr3[i37 + 64]) - iArr3[i37 + 96];
            i37++;
            i36 = 31;
        }
        for (int i40 = 0; i40 < i36; i40++) {
            int i41 = i40 + 16;
            iArr10[i41] = iArr10[i41] + iArr5[i40];
            iArr3[i41] = iArr3[i41] + iArr4[i40];
            int i42 = i40 + 80;
            iArr3[i42] = iArr3[i42] + iArr6[i40];
        }
        for (int i43 = 0; i43 < 63; i43++) {
            iArr10[i43] = (iArr10[i43] - iArr3[i43]) - iArr3[i43 + 64];
        }
        for (int i44 = 0; i44 < 63; i44++) {
            int i45 = i44 + 32;
            iArr3[i45] = iArr3[i45] + iArr10[i44];
        }
    }

    private long load_littleendian(byte[] bArr, int i11, int i12) {
        long j11 = (long) (bArr[i11 + 0] & 255);
        for (int i13 = 1; i13 < i12; i13++) {
            j11 |= ((long) (bArr[i11 + i13] & 255)) << (i13 * 8);
        }
        return j11;
    }

    private void poly_mul_acc(short[] sArr, short[] sArr2, short[] sArr3) {
        short[] sArr4 = new short[(this.SABER_N * 2)];
        toom_cook_4way(sArr, sArr2, sArr4);
        int i11 = this.SABER_N;
        while (true) {
            int i12 = this.SABER_N;
            if (i11 < i12 * 2) {
                int i13 = i11 - i12;
                sArr3[i13] = (short) (sArr3[i13] + (sArr4[i11 - i12] - sArr4[i11]));
                i11++;
            } else {
                return;
            }
        }
    }

    private void toom_cook_4way(short[] sArr, short[] sArr2, short[] sArr3) {
        int i11 = this.N_SB;
        int[] iArr = new int[i11];
        int[] iArr2 = new int[i11];
        int[] iArr3 = new int[i11];
        int[] iArr4 = new int[i11];
        int[] iArr5 = new int[i11];
        int[] iArr6 = new int[i11];
        int[] iArr7 = new int[i11];
        int[] iArr8 = new int[i11];
        int[] iArr9 = new int[i11];
        int[] iArr10 = new int[i11];
        int[] iArr11 = new int[i11];
        int[] iArr12 = new int[i11];
        int[] iArr13 = new int[i11];
        int[] iArr14 = new int[i11];
        int i12 = this.N_SB_RES;
        int[] iArr15 = iArr8;
        int[] iArr16 = new int[i12];
        int[] iArr17 = new int[i12];
        int[] iArr18 = new int[i12];
        int[] iArr19 = new int[i12];
        int[] iArr20 = new int[i12];
        int[] iArr21 = new int[i12];
        int[] iArr22 = new int[i12];
        int i13 = 0;
        while (true) {
            int i14 = this.N_SB;
            if (i13 >= i14) {
                break;
            }
            short s11 = sArr[i13];
            short s12 = sArr[i13 + i14];
            short s13 = sArr[i13 + (i14 * 2)];
            short s14 = sArr[(i14 * 3) + i13];
            int[] iArr23 = iArr14;
            int i15 = (short) (s11 + s13);
            int[] iArr24 = iArr9;
            int i16 = (short) (s12 + s14);
            iArr3[i13] = (short) (i15 + i16);
            iArr4[i13] = (short) (i15 - i16);
            int i17 = (short) (((s11 << 2) + s13) << 1);
            int i18 = (short) ((s12 << 2) + s14);
            iArr5[i13] = (short) (i17 + i18);
            iArr6[i13] = (short) (i17 - i18);
            iArr2[i13] = (short) ((s14 << 3) + (s13 << 2) + (s12 << 1) + s11);
            iArr7[i13] = s11;
            iArr[i13] = s14;
            i13++;
            iArr14 = iArr23;
            iArr9 = iArr24;
            iArr13 = iArr13;
        }
        int[] iArr25 = iArr14;
        int[] iArr26 = iArr9;
        int[] iArr27 = iArr13;
        int i19 = 0;
        while (true) {
            int i21 = this.N_SB;
            if (i19 >= i21) {
                break;
            }
            short s15 = sArr2[i19];
            short s16 = sArr2[i19 + i21];
            short s17 = sArr2[(i21 * 2) + i19];
            short s18 = sArr2[(i21 * 3) + i19];
            int i22 = s15 + s17;
            int i23 = s16 + s18;
            iArr10[i19] = i22 + i23;
            iArr11[i19] = i22 - i23;
            int i24 = ((s15 << 2) + s17) << 1;
            int i25 = (s16 << 2) + s18;
            iArr12[i19] = i24 + i25;
            iArr27[i19] = i24 - i25;
            iArr26[i19] = (s18 << 3) + (s17 << 2) + (s16 << 1) + s15;
            iArr25[i19] = s15;
            iArr15[i19] = s18;
            i19++;
        }
        int[] iArr28 = iArr16;
        karatsuba_simple(iArr, iArr15, iArr28);
        int[] iArr29 = iArr17;
        karatsuba_simple(iArr2, iArr26, iArr29);
        int[] iArr30 = iArr18;
        karatsuba_simple(iArr3, iArr10, iArr30);
        int[] iArr31 = iArr19;
        karatsuba_simple(iArr4, iArr11, iArr31);
        int[] iArr32 = iArr20;
        karatsuba_simple(iArr5, iArr12, iArr32);
        int[] iArr33 = iArr21;
        karatsuba_simple(iArr6, iArr27, iArr33);
        int[] iArr34 = iArr22;
        karatsuba_simple(iArr7, iArr25, iArr34);
        for (int i26 = 0; i26 < this.N_SB_RES; i26++) {
            int i27 = iArr28[i26];
            int i28 = iArr29[i26];
            int i29 = iArr30[i26];
            int i30 = iArr31[i26];
            int i31 = iArr32[i26];
            int i32 = iArr33[i26];
            int i33 = iArr34[i26];
            int i34 = i32 - i31;
            int i35 = ((i30 & 65535) - (i29 & 65535)) >>> 1;
            int i36 = i29 + i35;
            int i37 = ((i28 + i31) - (i36 << 6)) - i36;
            int i38 = (i36 - i33) - i27;
            int i39 = i37 + (i38 * 45);
            int i40 = (((((((i31 - i27) - (i33 << 6)) << 1) + i34) & 65535) - (i38 << 3)) * 43691) >> 3;
            int i41 = i34 + i39;
            int i42 = (((i39 & 65535) + ((i35 & 65535) << 4)) * 36409) >> 1;
            int i43 = ((((i42 & 65535) * 30) - (i41 & 65535)) * 61167) >> 2;
            int i44 = i38 - i40;
            int i45 = i42 - i43;
            sArr3[i26] = (short) (sArr3[i26] + (i33 & 65535));
            int i46 = i26 + 64;
            sArr3[i46] = (short) (sArr3[i46] + (i43 & 65535));
            int i47 = i26 + 128;
            sArr3[i47] = (short) (sArr3[i47] + (i40 & 65535));
            int i48 = i26 + 192;
            sArr3[i48] = (short) (sArr3[i48] + ((-(i35 + i42)) & 65535));
            int i49 = i26 + 256;
            sArr3[i49] = (short) (sArr3[i49] + (i44 & 65535));
            int i50 = i26 + 320;
            sArr3[i50] = (short) (sArr3[i50] + (i45 & 65535));
            int i51 = i26 + b.f34945b;
            sArr3[i51] = (short) (sArr3[i51] + (i27 & 65535));
        }
    }

    public void GenMatrix(short[][][] sArr, byte[] bArr) {
        int saber_polyvecbytes = this.SABER_L * this.engine.getSABER_POLYVECBYTES();
        byte[] bArr2 = new byte[saber_polyvecbytes];
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        sHAKEDigest.update(bArr, 0, this.engine.getSABER_SEEDBYTES());
        sHAKEDigest.doFinal(bArr2, 0, saber_polyvecbytes);
        for (int i11 = 0; i11 < this.SABER_L; i11++) {
            this.utils.BS2POLVECq(bArr2, this.engine.getSABER_POLYVECBYTES() * i11, sArr[i11]);
        }
    }

    public void GenSecret(short[][] sArr, byte[] bArr) {
        int saber_polycoinbytes = this.SABER_L * this.engine.getSABER_POLYCOINBYTES();
        byte[] bArr2 = new byte[saber_polycoinbytes];
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        sHAKEDigest.update(bArr, 0, this.engine.getSABER_NOISE_SEEDBYTES());
        sHAKEDigest.doFinal(bArr2, 0, saber_polycoinbytes);
        for (int i11 = 0; i11 < this.SABER_L; i11++) {
            cbd(sArr[i11], bArr2, this.engine.getSABER_POLYCOINBYTES() * i11);
        }
    }

    public void InnerProd(short[][] sArr, short[][] sArr2, short[] sArr3) {
        for (int i11 = 0; i11 < this.SABER_L; i11++) {
            poly_mul_acc(sArr[i11], sArr2[i11], sArr3);
        }
    }

    public void MatrixVectorMul(short[][][] sArr, short[][] sArr2, short[][] sArr3, int i11) {
        for (int i12 = 0; i12 < this.SABER_L; i12++) {
            for (int i13 = 0; i13 < this.SABER_L; i13++) {
                if (i11 == 1) {
                    poly_mul_acc(sArr[i13][i12], sArr2[i13], sArr3[i12]);
                } else {
                    poly_mul_acc(sArr[i12][i13], sArr2[i13], sArr3[i12]);
                }
            }
        }
    }
}
