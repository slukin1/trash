package org.bouncycastle.pqc.crypto.cmce;

import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.util.Arrays;

class CMCEEngine {
    private int COND_BYTES;
    private int GFBITS;
    private int GFMASK;
    private int IRR_BYTES;
    private int PK_NCOLS;
    private int PK_NROWS;
    private int PK_ROW_BYTES;
    private int SYND_BYTES;
    private int SYS_N;
    private int SYS_T;
    private BENES benes;
    private boolean countErrorIndices;
    private final int defaultKeySize;

    /* renamed from: gf  reason: collision with root package name */
    private GF f59511gf;
    private int[] poly;
    private boolean usePadding;
    private boolean usePivots;

    public CMCEEngine(int i11, int i12, int i13, int[] iArr, boolean z11, int i14) {
        BENES benes2;
        this.usePivots = z11;
        this.SYS_N = i12;
        this.SYS_T = i13;
        this.GFBITS = i11;
        this.poly = iArr;
        this.defaultKeySize = i14;
        this.IRR_BYTES = i13 * 2;
        boolean z12 = true;
        this.COND_BYTES = (1 << (i11 - 4)) * ((i11 * 2) - 1);
        int i15 = i13 * i11;
        this.PK_NROWS = i15;
        int i16 = i12 - i15;
        this.PK_NCOLS = i16;
        this.PK_ROW_BYTES = (i16 + 7) / 8;
        this.SYND_BYTES = (i15 + 7) / 8;
        this.GFMASK = (1 << i11) - 1;
        if (i11 == 12) {
            this.f59511gf = new GF12(i11);
            benes2 = new BENES12(this.SYS_N, this.SYS_T, this.GFBITS);
        } else {
            this.f59511gf = new GF13(i11);
            benes2 = new BENES13(this.SYS_N, this.SYS_T, this.GFBITS);
        }
        this.benes = benes2;
        this.usePadding = this.SYS_T % 8 != 0;
        this.countErrorIndices = (1 << this.GFBITS) <= this.SYS_N ? false : z12;
    }

    private void GF_mul(short[] sArr, short[] sArr2, short[] sArr3) {
        int i11;
        int i12;
        short[] sArr4 = new short[((this.SYS_T * 2) - 1)];
        for (int i13 = 0; i13 < (this.SYS_T * 2) - 1; i13++) {
            sArr4[i13] = 0;
        }
        int i14 = 0;
        while (true) {
            i11 = this.SYS_T;
            if (i14 >= i11) {
                break;
            }
            for (int i15 = 0; i15 < this.SYS_T; i15++) {
                int i16 = i14 + i15;
                sArr4[i16] = (short) (this.f59511gf.gf_mul(sArr2[i14], sArr3[i15]) ^ sArr4[i16]);
            }
            i14++;
        }
        int i17 = (i11 - 1) * 2;
        while (true) {
            i12 = this.SYS_T;
            if (i17 < i12) {
                break;
            }
            int i18 = 0;
            while (true) {
                int[] iArr = this.poly;
                if (i18 == iArr.length) {
                    break;
                }
                int i19 = iArr[i18];
                if (i19 == 0 && this.GFBITS == 12) {
                    int i21 = i17 - this.SYS_T;
                    sArr4[i21] = (short) (sArr4[i21] ^ this.f59511gf.gf_mul(sArr4[i17], 2));
                } else {
                    int i22 = (i17 - this.SYS_T) + i19;
                    sArr4[i22] = (short) (sArr4[i22] ^ sArr4[i17]);
                }
                i18++;
            }
            i17--;
        }
        System.arraycopy(sArr4, 0, sArr, 0, i12);
        for (int i23 = 0; i23 < this.SYS_T; i23++) {
            sArr[i23] = sArr4[i23];
        }
    }

    private void bm(short[] sArr, short[] sArr2) {
        int i11;
        int i12 = this.SYS_T;
        short[] sArr3 = new short[(i12 + 1)];
        short[] sArr4 = new short[(i12 + 1)];
        short[] sArr5 = new short[(i12 + 1)];
        int i13 = 0;
        for (int i14 = 0; i14 < this.SYS_T + 1; i14++) {
            sArr5[i14] = 0;
            sArr4[i14] = 0;
        }
        sArr4[0] = 1;
        sArr5[1] = 1;
        short s11 = 1;
        short s12 = 0;
        short s13 = 0;
        while (s12 < this.SYS_T * 2) {
            int i15 = i13;
            short s14 = i15;
            while (i15 <= min(s12, this.SYS_T)) {
                s14 = (short) (s14 ^ this.f59511gf.gf_mul(sArr4[i15], sArr2[s12 - i15]));
                i15++;
            }
            short s15 = (short) (((short) (((short) (((short) (s14 - 1)) >> 15)) & 1)) - 1);
            short s16 = (short) (((short) (((short) (((short) (((short) (s12 - (s13 * 2))) >> 15)) & 1)) - 1)) & s15);
            for (int i16 = i13; i16 <= this.SYS_T; i16++) {
                sArr3[i16] = sArr4[i16];
            }
            short gf_frac = this.f59511gf.gf_frac(s11, s14);
            for (int i17 = i13; i17 <= this.SYS_T; i17++) {
                sArr4[i17] = (short) ((this.f59511gf.gf_mul(gf_frac, sArr5[i17]) & s15) ^ sArr4[i17]);
            }
            int i18 = ~s16;
            int i19 = s12 + 1;
            s13 = (short) (((i19 - s13) & s16) | (s13 & i18));
            int i21 = 0;
            while (true) {
                i11 = this.SYS_T;
                if (i21 > i11) {
                    break;
                }
                sArr5[i21] = (short) ((sArr5[i21] & i18) | (sArr3[i21] & s16));
                i21++;
            }
            s11 = (short) ((i18 & s11) | (s14 & s16));
            while (i11 >= 1) {
                sArr5[i11] = sArr5[i11 - 1];
                i11--;
            }
            i13 = 0;
            sArr5[0] = 0;
            s12 = (short) i19;
        }
        while (true) {
            int i22 = this.SYS_T;
            if (i13 <= i22) {
                sArr[i13] = sArr4[i22 - i13];
                i13++;
            } else {
                return;
            }
        }
    }

    public static void cbrecursion(byte[] bArr, long j11, long j12, short[] sArr, int i11, long j13, long j14, int[] iArr) {
        long j15;
        int i12 = i11;
        long j16 = j14;
        int[] iArr2 = iArr;
        if (j13 == 1) {
            int i13 = (int) (j11 >> 3);
            bArr[i13] = (byte) ((get_q_short(iArr2, i12) << ((int) (j11 & 7))) ^ bArr[i13]);
            return;
        }
        if (sArr != null) {
            for (long j17 = 0; j17 < j16; j17++) {
                int i14 = (int) j17;
                iArr2[i14] = sArr[(int) (j17 ^ 1)] | ((sArr[i14] ^ 1) << 16);
            }
        } else {
            for (long j18 = 0; j18 < j16; j18++) {
                long j19 = (long) i12;
                iArr2[(int) j18] = ((get_q_short(iArr2, (int) (j19 + j18)) ^ 1) << 16) | get_q_short(iArr2, (int) (j19 + (j18 ^ 1)));
            }
        }
        int i15 = (int) j16;
        sort32(iArr2, 0, i15);
        for (long j21 = 0; j21 < j16; j21++) {
            int i16 = (int) j21;
            int i17 = 65535 & iArr2[i16];
            if (j21 >= ((long) i17)) {
                i16 = i17;
            }
            iArr2[(int) (j16 + j21)] = i16 | (i17 << 16);
        }
        for (long j22 = 0; j22 < j16; j22++) {
            int i18 = (int) j22;
            iArr2[i18] = (int) (((long) (iArr2[i18] << 16)) | j22);
        }
        sort32(iArr2, 0, i15);
        for (long j23 = 0; j23 < j16; j23++) {
            int i19 = (int) j23;
            iArr2[i19] = (iArr2[i19] << 16) + (iArr2[(int) (j16 + j23)] >> 16);
        }
        sort32(iArr2, 0, i15);
        if (j13 <= 10) {
            for (long j24 = 0; j24 < j16; j24++) {
                int i21 = (int) (j16 + j24);
                iArr2[i21] = ((iArr2[(int) j24] & 65535) << 10) | (iArr2[i21] & 1023);
            }
            long j25 = 1;
            for (long j26 = 1; j25 < j13 - j26; j26 = 1) {
                long j27 = 0;
                while (j27 < j16) {
                    iArr2[(int) j27] = (int) (((long) ((iArr2[(int) (j16 + j27)] & -1024) << 6)) | j27);
                    j27++;
                    j25 = j25;
                }
                long j28 = j25;
                sort32(iArr2, 0, i15);
                for (long j29 = 0; j29 < j16; j29++) {
                    int i22 = (int) j29;
                    iArr2[i22] = (iArr2[i22] << 20) | iArr2[(int) (j16 + j29)];
                }
                sort32(iArr2, 0, i15);
                for (long j30 = 0; j30 < j16; j30++) {
                    int i23 = (int) j30;
                    int i24 = iArr2[i23] & 1048575;
                    int i25 = (int) (j16 + j30);
                    int i26 = (iArr2[i23] & 1047552) | (iArr2[i25] & 1023);
                    if (i24 >= i26) {
                        i24 = i26;
                    }
                    iArr2[i25] = i24;
                }
                j25 = j28 + 1;
            }
            for (long j31 = 0; j31 < j16; j31++) {
                int i27 = (int) (j16 + j31);
                iArr2[i27] = iArr2[i27] & 1023;
            }
        } else {
            for (long j32 = 0; j32 < j16; j32++) {
                int i28 = (int) (j16 + j32);
                iArr2[i28] = (iArr2[(int) j32] << 16) | (iArr2[i28] & 65535);
            }
            long j33 = 1;
            for (long j34 = 1; j33 < j13 - j34; j34 = 1) {
                for (long j35 = 0; j35 < j16; j35++) {
                    iArr2[(int) j35] = (int) (((long) (iArr2[(int) (j16 + j35)] & -65536)) | j35);
                }
                sort32(iArr2, 0, i15);
                for (long j36 = 0; j36 < j16; j36++) {
                    int i29 = (int) j36;
                    iArr2[i29] = (iArr2[i29] << 16) | (iArr2[(int) (j16 + j36)] & 65535);
                }
                if (j33 < j13 - 2) {
                    for (long j37 = 0; j37 < j16; j37++) {
                        int i30 = (int) (j16 + j37);
                        iArr2[i30] = (iArr2[(int) j37] & -65536) | (iArr2[i30] >> 16);
                    }
                    sort32(iArr2, i15, (int) (j16 * 2));
                    for (long j38 = 0; j38 < j16; j38++) {
                        int i31 = (int) (j16 + j38);
                        iArr2[i31] = (iArr2[i31] << 16) | (iArr2[(int) j38] & 65535);
                    }
                }
                sort32(iArr2, 0, i15);
                for (long j39 = 0; j39 < j16; j39++) {
                    int i32 = (int) (j16 + j39);
                    int i33 = (iArr2[i32] & -65536) | (iArr2[(int) j39] & 65535);
                    if (i33 < iArr2[i32]) {
                        iArr2[i32] = i33;
                    }
                }
                j33++;
            }
            for (long j40 = 0; j40 < j16; j40++) {
                int i34 = (int) (j16 + j40);
                iArr2[i34] = iArr2[i34] & 65535;
            }
        }
        long j41 = 0;
        if (sArr != null) {
            while (j41 < j16) {
                int i35 = (int) j41;
                iArr2[i35] = (int) (((long) (sArr[i35] << 16)) + j41);
                j41++;
            }
        } else {
            while (j41 < j16) {
                iArr2[(int) j41] = (int) (((long) (get_q_short(iArr2, (int) (((long) i12) + j41)) << 16)) + j41);
                j41++;
            }
        }
        sort32(iArr2, 0, i15);
        long j42 = j11;
        long j43 = 2;
        long j44 = 0;
        while (true) {
            j15 = j16 / j43;
            if (j44 >= j15) {
                break;
            }
            long j45 = j44 * j43;
            long j46 = j16 + j45;
            int i36 = (int) j46;
            int i37 = iArr2[i36] & 1;
            int i38 = (int) (((long) i37) + j45);
            long j47 = j46;
            int i39 = (int) (j42 >> 3);
            bArr[i39] = (byte) ((i37 << ((int) (j42 & 7))) ^ bArr[i39]);
            j42 += j12;
            long j48 = j45;
            iArr2[i36] = (iArr2[(int) j48] << 16) | i38;
            iArr2[(int) (j47 + 1)] = (iArr2[(int) (j48 + 1)] << 16) | (i38 ^ 1);
            j44++;
            j16 = j14;
            i15 = i15;
            j43 = 2;
        }
        int i40 = i15;
        long j49 = j43;
        long j50 = j14 * j49;
        sort32(iArr2, i15, (int) j50);
        long j51 = j13 * j49;
        long j52 = j42 + ((j51 - 3) * j12 * j15);
        long j53 = 0;
        while (j53 < j15) {
            long j54 = j53 * j49;
            long j55 = j14 + j54;
            int i41 = (int) j55;
            int i42 = iArr2[i41] & 1;
            long j56 = j52;
            int i43 = (int) (((long) i42) + j54);
            long j57 = j50;
            int i44 = (int) (j56 >> 3);
            bArr[i44] = (byte) (bArr[i44] ^ (i42 << ((int) (j56 & 7))));
            iArr2[(int) j54] = (iArr2[i41] & 65535) | (i43 << 16);
            iArr2[(int) (j54 + 1)] = (iArr2[(int) (j55 + 1)] & 65535) | ((i43 ^ 1) << 16);
            j53++;
            j52 = j56 + j12;
            j50 = j57;
            j51 = j51;
            j49 = 2;
        }
        long j58 = j50;
        sort32(iArr2, 0, i15);
        long j59 = 2;
        long j60 = j52 - (((j51 - 2) * j12) * j15);
        short[] sArr2 = new short[(i15 * 4)];
        long j61 = 0;
        while (j61 < j58) {
            long j62 = j61 * j59;
            int i45 = (int) j61;
            sArr2[(int) (j62 + 0)] = (short) iArr2[i45];
            sArr2[(int) (j62 + 1)] = (short) ((iArr2[i45] & -65536) >> 16);
            j61++;
            j59 = 2;
        }
        for (long j63 = 0; j63 < j15; j63++) {
            long j64 = j63 * 2;
            sArr2[(int) j63] = (short) ((iArr2[(int) j64] & 65535) >>> 1);
            sArr2[(int) (j63 + j15)] = (short) ((iArr2[(int) (j64 + 1)] & 65535) >>> 1);
        }
        for (long j65 = 0; j65 < j15; j65++) {
            long j66 = j65 * 2;
            iArr2[(int) (j14 + (j14 / 4) + j65)] = (sArr2[(int) (j66 + 1)] << 16) | sArr2[(int) j66];
        }
        long j67 = j12 * 2;
        long j68 = j14 + (j14 / 4);
        byte[] bArr2 = bArr;
        long j69 = j13 - 1;
        cbrecursion(bArr2, j60, j67, (short[]) null, ((int) j68) * 2, j69, j15, iArr);
        cbrecursion(bArr2, j60 + j12, j67, (short[]) null, (int) ((j68 * 2) + j15), j69, j15, iArr);
    }

    private static void controlbitsfrompermutation(byte[] bArr, short[] sArr, long j11, long j12) {
        byte[] bArr2 = bArr;
        long j13 = j12;
        long j14 = 2;
        int[] iArr = new int[((int) (j13 * 2))];
        int i11 = (int) j13;
        short[] sArr2 = new short[i11];
        while (true) {
            short s11 = 0;
            for (int i12 = 0; ((long) i12) < (((((j11 * j14) - 1) * j13) / j14) + 7) / 8; i12++) {
                bArr2[i12] = 0;
            }
            int i13 = i11;
            short[] sArr3 = sArr2;
            int[] iArr2 = iArr;
            cbrecursion(bArr, 0, 1, sArr, 0, j11, j12, iArr);
            for (int i14 = 0; ((long) i14) < j13; i14++) {
                sArr3[i14] = (short) i14;
            }
            short[] sArr4 = sArr3;
            int i15 = 0;
            for (int i16 = 0; ((long) i16) < j11; i16++) {
                layer(sArr4, bArr2, i15, i16, i13);
                i15 = (int) (((long) i15) + (j13 >> 4));
            }
            for (int i17 = (int) (j11 - 2); i17 >= 0; i17--) {
                layer(sArr4, bArr2, i15, i17, i13);
                i15 = (int) (((long) i15) + (j13 >> 4));
            }
            int i18 = 0;
            while (((long) i18) < j13) {
                i18++;
                s11 = (short) (s11 | (sArr[i18] ^ sArr4[i18]));
            }
            if (s11 != 0) {
                sArr2 = sArr4;
                i11 = i13;
                iArr = iArr2;
                j14 = 2;
            } else {
                return;
            }
        }
    }

    private static int ctz(long j11) {
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 64; i13++) {
            int i14 = (int) ((j11 >> i13) & 1);
            i12 |= i14;
            i11 += (i14 ^ 1) & (i12 ^ 1);
        }
        return i11;
    }

    private int decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i11;
        int i12;
        int i13 = this.SYS_T;
        short[] sArr = new short[(i13 + 1)];
        int i14 = this.SYS_N;
        short[] sArr2 = new short[i14];
        short[] sArr3 = new short[(i13 * 2)];
        short[] sArr4 = new short[(i13 * 2)];
        short[] sArr5 = new short[(i13 + 1)];
        short[] sArr6 = new short[i14];
        byte[] bArr4 = new byte[(i14 / 8)];
        int i15 = 0;
        while (true) {
            i11 = this.SYND_BYTES;
            if (i15 >= i11) {
                break;
            }
            bArr4[i15] = bArr3[i15];
            i15++;
        }
        while (i11 < this.SYS_N / 8) {
            bArr4[i11] = 0;
            i11++;
        }
        int i16 = 0;
        while (true) {
            i12 = this.SYS_T;
            if (i16 >= i12) {
                break;
            }
            sArr[i16] = Utils.load_gf(bArr2, (i16 * 2) + 40, this.GFMASK);
            i16++;
        }
        sArr[i12] = 1;
        this.benes.support_gen(sArr2, bArr2);
        synd(sArr3, sArr, sArr2, bArr4);
        bm(sArr5, sArr3);
        root(sArr6, sArr5, sArr2);
        for (int i17 = 0; i17 < this.SYS_N / 8; i17++) {
            bArr[i17] = 0;
        }
        int i18 = 0;
        for (int i19 = 0; i19 < this.SYS_N; i19++) {
            short gf_iszero = (short) (this.f59511gf.gf_iszero(sArr6[i19]) & 1);
            int i21 = i19 / 8;
            bArr[i21] = (byte) (bArr[i21] | (gf_iszero << (i19 % 8)));
            i18 += gf_iszero;
        }
        synd(sArr4, sArr, sArr2, bArr);
        short s11 = this.SYS_T ^ i18;
        for (int i22 = 0; i22 < this.SYS_T * 2; i22++) {
            s11 |= sArr3[i22] ^ sArr4[i22];
        }
        return (((s11 - 1) >> 15) & 1) ^ 1;
    }

    private void encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, SecureRandom secureRandom) {
        generate_error_vector(bArr3, secureRandom);
        syndrome(bArr, bArr2, bArr3);
    }

    private short eval(short[] sArr, short s11) {
        int i11 = this.SYS_T;
        short s12 = sArr[i11];
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            s12 = this.f59511gf.gf_add(this.f59511gf.gf_mul(s12, s11), sArr[i12]);
        }
        return s12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x000a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void generate_error_vector(byte[] r11, java.security.SecureRandom r12) {
        /*
            r10 = this;
            int r0 = r10.SYS_T
            int r1 = r0 * 2
            short[] r1 = new short[r1]
            short[] r2 = new short[r0]
            byte[] r0 = new byte[r0]
        L_0x000a:
            boolean r3 = r10.countErrorIndices
            r4 = 0
            if (r3 == 0) goto L_0x0049
            int r3 = r10.SYS_T
            int r3 = r3 * 4
            byte[] r3 = new byte[r3]
            r12.nextBytes(r3)
            r5 = r4
        L_0x0019:
            int r6 = r10.SYS_T
            int r6 = r6 * 2
            if (r5 >= r6) goto L_0x002c
            int r6 = r5 * 2
            int r7 = r10.GFMASK
            short r6 = org.bouncycastle.pqc.crypto.cmce.Utils.load_gf(r3, r6, r7)
            r1[r5] = r6
            int r5 = r5 + 1
            goto L_0x0019
        L_0x002c:
            r3 = r4
            r5 = r3
        L_0x002e:
            int r6 = r10.SYS_T
            int r7 = r6 * 2
            if (r3 >= r7) goto L_0x0046
            if (r5 >= r6) goto L_0x0046
            short r6 = r1[r3]
            int r7 = r10.SYS_N
            if (r6 >= r7) goto L_0x0043
            int r6 = r5 + 1
            short r7 = r1[r3]
            r2[r5] = r7
            r5 = r6
        L_0x0043:
            int r3 = r3 + 1
            goto L_0x002e
        L_0x0046:
            if (r5 >= r6) goto L_0x0064
            goto L_0x000a
        L_0x0049:
            int r3 = r10.SYS_T
            int r3 = r3 * 2
            byte[] r3 = new byte[r3]
            r12.nextBytes(r3)
            r5 = r4
        L_0x0053:
            int r6 = r10.SYS_T
            if (r5 >= r6) goto L_0x0064
            int r6 = r5 * 2
            int r7 = r10.GFMASK
            short r6 = org.bouncycastle.pqc.crypto.cmce.Utils.load_gf(r3, r6, r7)
            r2[r5] = r6
            int r5 = r5 + 1
            goto L_0x0053
        L_0x0064:
            r3 = 1
            r5 = r3
            r6 = r4
        L_0x0067:
            int r7 = r10.SYS_T
            if (r5 >= r7) goto L_0x007e
            if (r6 == r3) goto L_0x007e
            r7 = r4
        L_0x006e:
            if (r7 >= r5) goto L_0x007b
            short r8 = r2[r5]
            short r9 = r2[r7]
            if (r8 != r9) goto L_0x0078
            r6 = r3
            goto L_0x007b
        L_0x0078:
            int r7 = r7 + 1
            goto L_0x006e
        L_0x007b:
            int r5 = r5 + 1
            goto L_0x0067
        L_0x007e:
            if (r6 != 0) goto L_0x000a
            r12 = r4
        L_0x0081:
            int r1 = r10.SYS_T
            if (r12 >= r1) goto L_0x0091
            short r1 = r2[r12]
            r1 = r1 & 7
            int r1 = r3 << r1
            byte r1 = (byte) r1
            r0[r12] = r1
            int r12 = r12 + 1
            goto L_0x0081
        L_0x0091:
            r12 = r4
        L_0x0092:
            int r1 = r10.SYS_N
            int r1 = r1 / 8
            if (r12 >= r1) goto L_0x00bc
            r11[r12] = r4
            r1 = r4
        L_0x009b:
            int r3 = r10.SYS_T
            if (r1 >= r3) goto L_0x00b8
            short r3 = r2[r1]
            int r3 = r3 >> 3
            short r3 = (short) r3
            byte r3 = same_mask32(r12, r3)
            short r3 = (short) r3
            r3 = r3 & 255(0xff, float:3.57E-43)
            short r3 = (short) r3
            byte r5 = r11[r12]
            byte r6 = r0[r1]
            r3 = r3 & r6
            r3 = r3 | r5
            byte r3 = (byte) r3
            r11[r12] = r3
            int r1 = r1 + 1
            goto L_0x009b
        L_0x00b8:
            int r12 = r12 + 1
            short r12 = (short) r12
            goto L_0x0092
        L_0x00bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.cmce.CMCEEngine.generate_error_vector(byte[], java.security.SecureRandom):void");
    }

    private int generate_irr_poly(short[] sArr) {
        int i11 = this.SYS_T;
        int[] iArr = new int[2];
        iArr[1] = i11;
        iArr[0] = i11 + 1;
        short[][] sArr2 = (short[][]) Array.newInstance(short.class, iArr);
        sArr2[0][0] = 1;
        for (int i12 = 1; i12 < this.SYS_T; i12++) {
            sArr2[0][i12] = 0;
        }
        for (int i13 = 0; i13 < this.SYS_T; i13++) {
            sArr2[1][i13] = sArr[i13];
        }
        for (int i14 = 2; i14 <= this.SYS_T; i14++) {
            GF_mul(sArr2[i14], sArr2[i14 - 1], sArr);
        }
        int i15 = 0;
        while (i15 < this.SYS_T) {
            int i16 = i15 + 1;
            for (int i17 = i16; i17 < this.SYS_T; i17++) {
                short gf_iszero = this.f59511gf.gf_iszero(sArr2[i15][i15]);
                for (int i18 = i15; i18 < this.SYS_T + 1; i18++) {
                    sArr2[i18][i15] = (short) (sArr2[i18][i15] ^ (sArr2[i18][i17] & gf_iszero));
                }
            }
            if (sArr2[i15][i15] == 0) {
                return -1;
            }
            short gf_inv = this.f59511gf.gf_inv(sArr2[i15][i15]);
            for (int i19 = i15; i19 < this.SYS_T + 1; i19++) {
                sArr2[i19][i15] = this.f59511gf.gf_mul(sArr2[i19][i15], gf_inv);
            }
            for (int i21 = 0; i21 < this.SYS_T; i21++) {
                if (i21 != i15) {
                    short s11 = sArr2[i15][i21];
                    for (int i22 = i15; i22 < this.SYS_T + 1; i22++) {
                        short[] sArr3 = sArr2[i22];
                        sArr3[i21] = (short) (sArr3[i21] ^ this.f59511gf.gf_mul(sArr2[i22][i15], s11));
                    }
                }
            }
            i15 = i16;
        }
        int i23 = 0;
        while (true) {
            int i24 = this.SYS_T;
            if (i23 >= i24) {
                return 0;
            }
            sArr[i23] = sArr2[i24][i23];
            i23++;
        }
    }

    public static short get_q_short(int[] iArr, int i11) {
        int i12 = i11 / 2;
        return (short) (i11 % 2 == 0 ? iArr[i12] : (iArr[i12] & -65536) >> 16);
    }

    private static void layer(short[] sArr, byte[] bArr, int i11, int i12, int i13) {
        int i14 = 1 << i12;
        int i15 = 0;
        for (int i16 = 0; i16 < i13; i16 += i14 * 2) {
            for (int i17 = 0; i17 < i14; i17++) {
                int i18 = i16 + i17;
                int i19 = i18 + i14;
                short s11 = (sArr[i18] ^ sArr[i19]) & (-((bArr[(i15 >> 3) + i11] >> (i15 & 7)) & 1));
                sArr[i18] = (short) (sArr[i18] ^ s11);
                sArr[i19] = (short) (sArr[i19] ^ s11);
                i15++;
            }
        }
    }

    private static int min(short s11, int i11) {
        return s11 < i11 ? s11 : i11;
    }

    private int mov_columns(byte[][] bArr, short[] sArr, long[] jArr) {
        long j11;
        byte[] bArr2;
        long[] jArr2 = new long[64];
        int i11 = 32;
        long[] jArr3 = new long[32];
        byte[] bArr3 = new byte[9];
        int i12 = this.PK_NROWS - 32;
        int i13 = i12 / 8;
        int i14 = i12 % 8;
        if (this.usePadding) {
            for (int i15 = 0; i15 < 32; i15++) {
                for (int i16 = 0; i16 < 9; i16++) {
                    bArr3[i16] = bArr[i12 + i15][i13 + i16];
                }
                int i17 = 0;
                while (i17 < 8) {
                    int i18 = i17 + 1;
                    bArr3[i17] = (byte) (((bArr3[i17] & 255) >> i14) | (bArr3[i18] << (8 - i14)));
                    i17 = i18;
                }
                jArr2[i15] = Utils.load8(bArr3, 0);
            }
        } else {
            for (int i19 = 0; i19 < 32; i19++) {
                jArr2[i19] = Utils.load8(bArr[i12 + i19], i13);
            }
        }
        long j12 = 0;
        jArr[0] = 0;
        int i21 = 0;
        while (i21 < 32) {
            long j13 = jArr2[i21];
            int i22 = i21 + 1;
            for (int i23 = i22; i23 < 32; i23++) {
                j13 |= jArr2[i23];
            }
            if (j13 == j12) {
                return -1;
            }
            int ctz = ctz(j13);
            jArr3[i21] = (long) ctz;
            byte[] bArr4 = bArr3;
            jArr[0] = (1 << ((int) jArr3[i21])) | jArr[0];
            for (int i24 = i22; i24 < 32; i24++) {
                jArr2[i21] = jArr2[i21] ^ (jArr2[i24] & (((jArr2[i21] >> ctz) & 1) - 1));
            }
            for (int i25 = i22; i25 < 32; i25++) {
                jArr2[i25] = jArr2[i25] ^ (jArr2[i21] & (-((jArr2[i25] >> ctz) & 1)));
            }
            i21 = i22;
            bArr3 = bArr4;
            j12 = 0;
        }
        byte[] bArr5 = bArr3;
        int i26 = 0;
        while (i26 < 32) {
            int i27 = i26 + 1;
            for (int i28 = i27; i28 < 64; i28++) {
                int i29 = i12 + i26;
                int i30 = i12 + i28;
                int i31 = i30;
                long same_mask64 = ((long) (sArr[i29] ^ sArr[i30])) & same_mask64((short) i28, (short) ((int) jArr3[i26]));
                sArr[i29] = (short) ((int) (((long) sArr[i29]) ^ same_mask64));
                sArr[i31] = (short) ((int) (((long) sArr[i31]) ^ same_mask64));
            }
            i26 = i27;
        }
        int i32 = 0;
        while (i32 < this.PK_NROWS) {
            if (this.usePadding) {
                for (int i33 = 0; i33 < 9; i33++) {
                    bArr5[i33] = bArr[i32][i13 + i33];
                }
                int i34 = 0;
                while (i34 < 8) {
                    int i35 = i34 + 1;
                    bArr5[i34] = (byte) (((bArr5[i34] & 255) >> i14) | (bArr5[i35] << (8 - i14)));
                    i34 = i35;
                }
                bArr2 = bArr5;
                j11 = Utils.load8(bArr2, 0);
            } else {
                bArr2 = bArr5;
                j11 = Utils.load8(bArr[i32], i13);
            }
            int i36 = 0;
            while (i36 < i11) {
                long j14 = ((j11 >> ((int) jArr3[i36])) ^ (j11 >> i36)) & 1;
                j11 = (j11 ^ (j14 << ((int) jArr3[i36]))) ^ (j14 << i36);
                i36++;
                i11 = 32;
            }
            if (this.usePadding) {
                Utils.store8(bArr2, 0, j11);
                int i37 = i13 + 8;
                int i38 = 8 - i14;
                bArr[i32][i37] = (byte) ((((bArr[i32][i37] & 255) >>> i14) << i14) | ((bArr2[7] & 255) >>> i38));
                bArr[i32][i13 + 0] = (byte) (((bArr2[0] & 255) << i14) | (((bArr[i32][i13] & 255) << i38) >>> i38));
                for (int i39 = 7; i39 >= 1; i39--) {
                    bArr[i32][i13 + i39] = (byte) (((bArr2[i39] & 255) << i14) | ((bArr2[i39 - 1] & 255) >>> i38));
                }
            } else {
                Utils.store8(bArr[i32], i13, j11);
            }
            i32++;
            bArr5 = bArr2;
            i11 = 32;
        }
        return 0;
    }

    private int pk_gen(byte[] bArr, byte[] bArr2, int[] iArr, short[] sArr, long[] jArr) {
        int i11;
        int i12;
        short[] sArr2 = sArr;
        int i13 = this.SYS_T;
        short[] sArr3 = new short[(i13 + 1)];
        sArr3[i13] = 1;
        for (int i14 = 0; i14 < this.SYS_T; i14++) {
            sArr3[i14] = Utils.load_gf(bArr2, (i14 * 2) + 40, this.GFMASK);
        }
        int i15 = 1 << this.GFBITS;
        long[] jArr2 = new long[i15];
        for (int i16 = 0; i16 < (1 << this.GFBITS); i16++) {
            jArr2[i16] = (long) iArr[i16];
            jArr2[i16] = jArr2[i16] << 31;
            jArr2[i16] = jArr2[i16] | ((long) i16);
            jArr2[i16] = jArr2[i16] & Long.MAX_VALUE;
        }
        sort64(jArr2, 0, i15);
        for (int i17 = 1; i17 < (1 << this.GFBITS); i17++) {
            if ((jArr2[i17 - 1] >> 31) == (jArr2[i17] >> 31)) {
                return -1;
            }
        }
        short[] sArr4 = new short[this.SYS_N];
        for (int i18 = 0; i18 < (1 << this.GFBITS); i18++) {
            sArr2[i18] = (short) ((int) (jArr2[i18] & ((long) this.GFMASK)));
        }
        int i19 = 0;
        while (true) {
            i11 = this.SYS_N;
            if (i19 >= i11) {
                break;
            }
            sArr4[i19] = Utils.bitrev(sArr2[i19], this.GFBITS);
            i19++;
        }
        short[] sArr5 = new short[i11];
        root(sArr5, sArr3, sArr4);
        int i21 = 0;
        while (true) {
            i12 = this.SYS_N;
            if (i21 >= i12) {
                break;
            }
            sArr5[i21] = this.f59511gf.gf_inv(sArr5[i21]);
            i21++;
        }
        int i22 = this.PK_NROWS;
        int[] iArr2 = new int[2];
        iArr2[1] = i12 / 8;
        iArr2[0] = i22;
        byte[][] bArr3 = (byte[][]) Array.newInstance(byte.class, iArr2);
        for (int i23 = 0; i23 < this.PK_NROWS; i23++) {
            for (int i24 = 0; i24 < this.SYS_N / 8; i24++) {
                bArr3[i23][i24] = 0;
            }
        }
        for (int i25 = 0; i25 < this.SYS_T; i25++) {
            for (int i26 = 0; i26 < this.SYS_N; i26 += 8) {
                int i27 = 0;
                while (true) {
                    int i28 = this.GFBITS;
                    if (i27 >= i28) {
                        break;
                    }
                    bArr3[(i28 * i25) + i27][i26 / 8] = (byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) ((sArr5[i26 + 7] >>> i27) & 1)) << 1)) | ((sArr5[i26 + 6] >>> i27) & 1))) << 1)) | ((sArr5[i26 + 5] >>> i27) & 1))) << 1)) | ((sArr5[i26 + 4] >>> i27) & 1))) << 1)) | ((sArr5[i26 + 3] >>> i27) & 1))) << 1)) | ((sArr5[i26 + 2] >>> i27) & 1))) << 1)) | ((sArr5[i26 + 1] >>> i27) & 1))) << 1)) | ((sArr5[i26 + 0] >>> i27) & 1));
                    i27++;
                }
            }
            for (int i29 = 0; i29 < this.SYS_N; i29++) {
                sArr5[i29] = this.f59511gf.gf_mul(sArr5[i29], sArr4[i29]);
            }
        }
        int i30 = 0;
        while (true) {
            int i31 = this.PK_NROWS;
            if (i30 < (i31 + 7) / 8) {
                for (int i32 = 0; i32 < 8; i32++) {
                    int i33 = (i30 * 8) + i32;
                    int i34 = this.PK_NROWS;
                    if (i33 >= i34) {
                        continue;
                        break;
                    }
                    if (!this.usePivots || i33 != i34 - 32) {
                        long[] jArr3 = jArr;
                    } else if (mov_columns(bArr3, sArr2, jArr) != 0) {
                        return -1;
                    }
                    for (int i35 = i33 + 1; i35 < this.PK_NROWS; i35++) {
                        byte b11 = (byte) (-((byte) (((byte) (((byte) (bArr3[i33][i30] ^ bArr3[i35][i30])) >> i32)) & 1)));
                        for (int i36 = 0; i36 < this.SYS_N / 8; i36++) {
                            byte[] bArr4 = bArr3[i33];
                            bArr4[i36] = (byte) (bArr4[i36] ^ (bArr3[i35][i36] & b11));
                        }
                    }
                    if (((bArr3[i33][i30] >> i32) & 1) == 0) {
                        return -1;
                    }
                    for (int i37 = 0; i37 < this.PK_NROWS; i37++) {
                        if (i37 != i33) {
                            byte b12 = (byte) (-((byte) (((byte) (bArr3[i37][i30] >> i32)) & 1)));
                            for (int i38 = 0; i38 < this.SYS_N / 8; i38++) {
                                byte[] bArr5 = bArr3[i37];
                                bArr5[i38] = (byte) (bArr5[i38] ^ (bArr3[i33][i38] & b12));
                            }
                        }
                    }
                }
                long[] jArr4 = jArr;
                i30++;
            } else {
                if (bArr != null) {
                    if (this.usePadding) {
                        int i39 = i31 % 8;
                        int i40 = 0;
                        int i41 = 0;
                        while (true) {
                            int i42 = this.PK_NROWS;
                            if (i40 >= i42) {
                                break;
                            }
                            int i43 = (i42 - 1) / 8;
                            while (i43 < (this.SYS_N / 8) - 1) {
                                i43++;
                                bArr[i41] = (byte) (((bArr3[i40][i43] & 255) >>> i39) | (bArr3[i40][i43] << (8 - i39)));
                                i41++;
                            }
                            bArr[i41] = (byte) ((bArr3[i40][i43] & 255) >>> i39);
                            i40++;
                            i41++;
                        }
                    } else {
                        for (int i44 = 0; i44 < this.PK_NROWS; i44++) {
                            int i45 = 0;
                            int i46 = 0;
                            while (true) {
                                int i47 = this.SYS_N;
                                int i48 = this.PK_NROWS;
                                if (i45 >= ((i47 - i48) + 7) / 8) {
                                    break;
                                }
                                bArr[((((i47 - i48) + 7) / 8) * i44) + i46] = bArr3[i44][(i48 / 8) + i45];
                                i46++;
                                i45++;
                            }
                        }
                    }
                }
                return 0;
            }
        }
    }

    private void root(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i11 = 0; i11 < this.SYS_N; i11++) {
            sArr[i11] = eval(sArr2, sArr3[i11]);
        }
    }

    private static byte same_mask32(short s11, short s12) {
        return (byte) ((-(((s11 ^ s12) - 1) >>> 31)) & 255);
    }

    private static long same_mask64(short s11, short s12) {
        return -((((long) (s11 ^ s12)) - 1) >>> 63);
    }

    private static void sort32(int[] iArr, int i11, int i12) {
        int i13 = i12 - i11;
        if (i13 >= 2) {
            int i14 = 1;
            while (i14 < i13 - i14) {
                i14 += i14;
            }
            for (int i15 = i14; i15 > 0; i15 >>>= 1) {
                int i16 = 0;
                for (int i17 = 0; i17 < i13 - i15; i17++) {
                    if ((i17 & i15) == 0) {
                        int i18 = i11 + i17;
                        int i19 = i18 + i15;
                        int i21 = iArr[i19] ^ iArr[i18];
                        int i22 = iArr[i19] - iArr[i18];
                        int i23 = i21 & ((i22 ^ ((iArr[i19] ^ i22) & i21)) >> 31);
                        iArr[i18] = iArr[i18] ^ i23;
                        iArr[i19] = iArr[i19] ^ i23;
                    }
                }
                for (int i24 = i14; i24 > i15; i24 >>>= 1) {
                    while (i16 < i13 - i24) {
                        if ((i16 & i15) == 0) {
                            int i25 = i11 + i16;
                            int i26 = i25 + i15;
                            int i27 = iArr[i26];
                            for (int i28 = i24; i28 > i15; i28 >>>= 1) {
                                int i29 = i25 + i28;
                                int i30 = iArr[i29] ^ i27;
                                int i31 = iArr[i29] - i27;
                                int i32 = i30 & ((i31 ^ ((iArr[i29] ^ i31) & i30)) >> 31);
                                i27 ^= i32;
                                iArr[i29] = i32 ^ iArr[i29];
                            }
                            iArr[i26] = i27;
                        }
                        i16++;
                    }
                }
            }
        }
    }

    private static void sort64(long[] jArr, int i11, int i12) {
        int i13 = i12 - i11;
        if (i13 >= 2) {
            int i14 = 1;
            while (i14 < i13 - i14) {
                i14 += i14;
            }
            for (int i15 = i14; i15 > 0; i15 >>>= 1) {
                int i16 = 0;
                for (int i17 = 0; i17 < i13 - i15; i17++) {
                    if ((i17 & i15) == 0) {
                        int i18 = i11 + i17;
                        int i19 = i18 + i15;
                        long j11 = (-((jArr[i19] - jArr[i18]) >>> 63)) & (jArr[i18] ^ jArr[i19]);
                        jArr[i18] = jArr[i18] ^ j11;
                        jArr[i19] = jArr[i19] ^ j11;
                    }
                }
                for (int i21 = i14; i21 > i15; i21 >>>= 1) {
                    while (i16 < i13 - i21) {
                        if ((i16 & i15) == 0) {
                            int i22 = i11 + i16;
                            int i23 = i22 + i15;
                            long j12 = jArr[i23];
                            for (int i24 = i21; i24 > i15; i24 >>>= 1) {
                                int i25 = i22 + i24;
                                long j13 = (-((jArr[i25] - j12) >>> 63)) & (jArr[i25] ^ j12);
                                j12 ^= j13;
                                jArr[i25] = j13 ^ jArr[i25];
                            }
                            jArr[i23] = j12;
                        }
                        i16++;
                    }
                }
            }
        }
    }

    private void synd(short[] sArr, short[] sArr2, short[] sArr3, byte[] bArr) {
        for (int i11 = 0; i11 < this.SYS_T * 2; i11++) {
            sArr[i11] = 0;
        }
        for (int i12 = 0; i12 < this.SYS_N; i12++) {
            short s11 = (short) ((bArr[i12 / 8] >> (i12 % 8)) & 1);
            short eval = eval(sArr2, sArr3[i12]);
            GF gf2 = this.f59511gf;
            short gf_inv = gf2.gf_inv(gf2.gf_mul(eval, eval));
            for (int i13 = 0; i13 < this.SYS_T * 2; i13++) {
                GF gf3 = this.f59511gf;
                sArr[i13] = gf3.gf_add(sArr[i13], gf3.gf_mul(gf_inv, s11));
                gf_inv = this.f59511gf.gf_mul(gf_inv, sArr3[i12]);
            }
        }
    }

    private void syndrome(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        short[] sArr = new short[(this.SYS_N / 8)];
        int i11 = this.PK_NROWS % 8;
        for (int i12 = 0; i12 < this.SYND_BYTES; i12++) {
            bArr[i12] = 0;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.PK_NROWS; i14++) {
            for (int i15 = 0; i15 < this.SYS_N / 8; i15++) {
                sArr[i15] = 0;
            }
            int i16 = 0;
            while (true) {
                int i17 = this.PK_ROW_BYTES;
                if (i16 >= i17) {
                    break;
                }
                sArr[((this.SYS_N / 8) - i17) + i16] = (short) bArr2[i13 + i16];
                i16++;
            }
            if (this.usePadding) {
                for (int i18 = (this.SYS_N / 8) - 1; i18 >= (this.SYS_N / 8) - this.PK_ROW_BYTES; i18--) {
                    sArr[i18] = (short) ((((sArr[i18] & 255) << i11) | ((sArr[i18 - 1] & 255) >>> (8 - i11))) & 255);
                }
            }
            int i19 = i14 / 8;
            int i21 = i14 % 8;
            sArr[i19] = (short) (sArr[i19] | (1 << i21));
            byte b11 = 0;
            for (int i22 = 0; i22 < this.SYS_N / 8; i22++) {
                b11 = (byte) (b11 ^ (sArr[i22] & bArr3[i22]));
            }
            byte b12 = (byte) ((b11 >>> 4) ^ b11);
            byte b13 = (byte) (b12 ^ (b12 >>> 2));
            bArr[i19] = (byte) ((((byte) (1 & ((byte) (b13 ^ (b13 >>> 1))))) << i21) | bArr[i19]);
            i13 += this.PK_ROW_BYTES;
        }
    }

    public int check_c_padding(byte[] bArr) {
        return ((byte) ((((byte) (((byte) ((bArr[this.SYND_BYTES - 1] & 255) >>> (this.PK_NROWS % 8))) - 1)) & 255) >>> 7)) - 1;
    }

    public int check_pk_padding(byte[] bArr) {
        byte b11 = 0;
        for (int i11 = 0; i11 < this.PK_NROWS; i11++) {
            int i12 = this.PK_ROW_BYTES;
            b11 = (byte) (b11 | bArr[((i11 * i12) + i12) - 1]);
        }
        return ((byte) ((((byte) (((byte) ((b11 & 255) >>> (this.PK_NCOLS % 8))) - 1)) & 255) >>> 7)) - 1;
    }

    public byte[] decompress_private_key(byte[] bArr) {
        int i11;
        byte[] bArr2 = bArr;
        byte[] bArr3 = new byte[getPrivateKeySize()];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        int i12 = (this.SYS_N / 8) + ((1 << this.GFBITS) * 4) + this.IRR_BYTES + 32;
        byte[] bArr4 = new byte[i12];
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.update(SignedBytes.MAX_POWER_OF_TWO);
        sHAKEDigest.update(bArr2, 0, 32);
        sHAKEDigest.doFinal(bArr4, 0, i12);
        if (bArr2.length <= 40) {
            short[] sArr = new short[this.SYS_T];
            int i13 = this.IRR_BYTES;
            byte[] bArr5 = new byte[i13];
            int i14 = (i12 - 32) - i13;
            for (int i15 = 0; i15 < this.SYS_T; i15++) {
                sArr[i15] = Utils.load_gf(bArr4, (i15 * 2) + i14, this.GFMASK);
            }
            generate_irr_poly(sArr);
            for (int i16 = 0; i16 < this.SYS_T; i16++) {
                Utils.store_gf(bArr5, i16 * 2, sArr[i16]);
            }
            System.arraycopy(bArr5, 0, bArr3, 40, this.IRR_BYTES);
        }
        int length = bArr2.length;
        int i17 = this.IRR_BYTES;
        if (length <= i17 + 40) {
            int i18 = this.GFBITS;
            int[] iArr = new int[(1 << i18)];
            short[] sArr2 = new short[(1 << i18)];
            int i19 = ((i12 - 32) - i17) - ((1 << i18) * 4);
            int i21 = 0;
            while (true) {
                i11 = this.GFBITS;
                if (i21 >= (1 << i11)) {
                    break;
                }
                iArr[i21] = Utils.load4(bArr4, (i21 * 4) + i19);
                i21++;
            }
            if (this.usePivots) {
                pk_gen((byte[]) null, bArr3, iArr, sArr2, new long[]{0});
            } else {
                int i22 = 1 << i11;
                long[] jArr = new long[i22];
                for (int i23 = 0; i23 < (1 << this.GFBITS); i23++) {
                    jArr[i23] = (long) iArr[i23];
                    jArr[i23] = jArr[i23] << 31;
                    jArr[i23] = ((long) i23) | jArr[i23];
                    jArr[i23] = jArr[i23] & Long.MAX_VALUE;
                }
                sort64(jArr, 0, i22);
                for (int i24 = 0; i24 < (1 << this.GFBITS); i24++) {
                    sArr2[i24] = (short) ((int) (jArr[i24] & ((long) this.GFMASK)));
                }
            }
            int i25 = this.COND_BYTES;
            byte[] bArr6 = new byte[i25];
            int i26 = this.GFBITS;
            controlbitsfrompermutation(bArr6, sArr2, (long) i26, (long) (1 << i26));
            System.arraycopy(bArr6, 0, bArr3, this.IRR_BYTES + 40, i25);
        }
        int privateKeySize = getPrivateKeySize();
        int i27 = this.SYS_N;
        System.arraycopy(bArr4, 0, bArr3, privateKeySize - (i27 / 8), i27 / 8);
        return bArr3;
    }

    public byte[] generate_public_key_from_private_key(byte[] bArr) {
        byte[] bArr2 = new byte[getPublicKeySize()];
        int i11 = this.GFBITS;
        short[] sArr = new short[(1 << i11)];
        long[] jArr = {0};
        int[] iArr = new int[(1 << i11)];
        int i12 = (this.SYS_N / 8) + ((1 << i11) * 4);
        byte[] bArr3 = new byte[i12];
        int i13 = ((i12 - 32) - this.IRR_BYTES) - ((1 << i11) * 4);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.update(SignedBytes.MAX_POWER_OF_TWO);
        sHAKEDigest.update(bArr, 0, 32);
        sHAKEDigest.doFinal(bArr3, 0, i12);
        for (int i14 = 0; i14 < (1 << this.GFBITS); i14++) {
            iArr[i14] = Utils.load4(bArr3, (i14 * 4) + i13);
        }
        pk_gen(bArr2, bArr, iArr, sArr, jArr);
        return bArr2;
    }

    public int getCipherTextSize() {
        return this.SYND_BYTES + 32;
    }

    public int getCondBytes() {
        return this.COND_BYTES;
    }

    public int getDefaultSessionKeySize() {
        return this.defaultKeySize;
    }

    public int getIrrBytes() {
        return this.IRR_BYTES;
    }

    public int getPrivateKeySize() {
        return this.COND_BYTES + this.IRR_BYTES + (this.SYS_N / 8) + 40;
    }

    public int getPublicKeySize() {
        if (!this.usePadding) {
            return (this.PK_NROWS * this.PK_NCOLS) / 8;
        }
        int i11 = this.PK_NROWS;
        return i11 * ((this.SYS_N / 8) - ((i11 - 1) / 8));
    }

    public int kem_dec(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = bArr;
        byte[] bArr5 = bArr2;
        byte[] bArr6 = bArr3;
        byte[] bArr7 = new byte[32];
        int i11 = this.SYS_N / 8;
        byte[] bArr8 = new byte[i11];
        int check_c_padding = this.usePadding ? check_c_padding(bArr5) : 0;
        byte decrypt = (byte) decrypt(bArr8, bArr6, bArr5);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.update((byte) 2);
        sHAKEDigest.update(bArr8, 0, i11);
        sHAKEDigest.doFinal(bArr7, 0, 32);
        byte b11 = 0;
        for (int i12 = 0; i12 < 32; i12++) {
            b11 = (byte) (b11 | (bArr7[i12] ^ bArr5[this.SYND_BYTES + i12]));
        }
        short s11 = (short) (((short) (((short) (((short) (decrypt | b11)) - 1)) >> 8)) & 255);
        int i13 = (this.SYS_N / 8) + 1 + this.SYND_BYTES + 32;
        byte[] bArr9 = new byte[i13];
        bArr9[0] = (byte) (s11 & 1);
        int i14 = 0;
        while (i14 < this.SYS_N / 8) {
            int i15 = i14 + 1;
            bArr9[i15] = (byte) ((bArr6[i14 + 40 + this.IRR_BYTES + this.COND_BYTES] & (~s11)) | (bArr8[i14] & s11));
            i14 = i15;
        }
        for (int i16 = 0; i16 < this.SYND_BYTES + 32; i16++) {
            bArr9[(this.SYS_N / 8) + 1 + i16] = bArr5[i16];
        }
        SHAKEDigest sHAKEDigest2 = new SHAKEDigest(256);
        sHAKEDigest2.update(bArr9, 0, i13);
        sHAKEDigest2.doFinal(bArr4, 0, bArr4.length);
        if (!this.usePadding) {
            return 0;
        }
        byte b12 = (byte) check_c_padding;
        for (int i17 = 0; i17 < bArr4.length; i17++) {
            bArr4[i17] = (byte) (bArr4[i17] | b12);
        }
        return check_c_padding;
    }

    public int kem_enc(byte[] bArr, byte[] bArr2, byte[] bArr3, SecureRandom secureRandom) {
        int i11 = this.SYS_N / 8;
        byte[] bArr4 = new byte[i11];
        int check_pk_padding = this.usePadding ? check_pk_padding(bArr3) : 0;
        encrypt(bArr, bArr3, bArr4, secureRandom);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.update((byte) 2);
        sHAKEDigest.update(bArr4, 0, i11);
        sHAKEDigest.doFinal(bArr, this.SYND_BYTES, 32);
        sHAKEDigest.update((byte) 1);
        sHAKEDigest.update(bArr4, 0, i11);
        sHAKEDigest.update(bArr, 0, bArr.length);
        sHAKEDigest.doFinal(bArr2, 0, bArr2.length);
        if (!this.usePadding) {
            return 0;
        }
        byte b11 = (byte) (((byte) check_pk_padding) ^ 255);
        for (int i12 = 0; i12 < this.SYND_BYTES + 32; i12++) {
            bArr[i12] = (byte) (bArr[i12] & b11);
        }
        for (int i13 = 0; i13 < 32; i13++) {
            bArr2[i13] = (byte) (bArr2[i13] & b11);
        }
        return check_pk_padding;
    }

    public void kem_keypair(byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        byte[] bArr3;
        int i11;
        int i12;
        short[] sArr;
        int i13;
        long j11;
        byte[] bArr4 = bArr2;
        int i14 = 32;
        byte[] bArr5 = new byte[32];
        byte[] bArr6 = {SignedBytes.MAX_POWER_OF_TWO};
        secureRandom.nextBytes(bArr5);
        int i15 = (this.SYS_N / 8) + ((1 << this.GFBITS) * 4) + (this.SYS_T * 2) + 32;
        byte[] bArr7 = new byte[i15];
        long[] jArr = {0};
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        byte[] bArr8 = bArr5;
        while (true) {
            sHAKEDigest.update(bArr6, 0, 1);
            sHAKEDigest.update(bArr5, 0, bArr5.length);
            sHAKEDigest.doFinal(bArr7, 0, i15);
            int i16 = i15 - 32;
            byte[] copyOfRange = Arrays.copyOfRange(bArr7, i16, i16 + 32);
            System.arraycopy(bArr8, 0, bArr4, 0, i14);
            byte[] copyOfRange2 = Arrays.copyOfRange(copyOfRange, 0, i14);
            int i17 = this.SYS_T;
            short[] sArr2 = new short[i17];
            int i18 = i16 - (i17 * 2);
            for (int i19 = 0; i19 < this.SYS_T; i19++) {
                sArr2[i19] = Utils.load_gf(bArr7, (i19 * 2) + i18, this.GFMASK);
            }
            if (generate_irr_poly(sArr2) != -1) {
                for (int i21 = 0; i21 < this.SYS_T; i21++) {
                    Utils.store_gf(bArr4, 40 + (i21 * 2), sArr2[i21]);
                }
                int i22 = this.GFBITS;
                int[] iArr = new int[(1 << i22)];
                i11 = i18 - ((1 << i22) * 4);
                int i23 = 0;
                while (true) {
                    i12 = this.GFBITS;
                    if (i23 >= (1 << i12)) {
                        break;
                    }
                    iArr[i23] = Utils.load4(bArr7, i11 + (i23 * 4));
                    i23++;
                }
                short[] sArr3 = new short[(1 << i12)];
                sArr = sArr3;
                bArr3 = copyOfRange;
                if (pk_gen(bArr, bArr2, iArr, sArr3, jArr) != -1) {
                    break;
                }
            } else {
                bArr3 = copyOfRange;
            }
            bArr8 = copyOfRange2;
            bArr5 = bArr3;
            i14 = 32;
        }
        int i24 = this.COND_BYTES;
        byte[] bArr9 = new byte[i24];
        int i25 = this.GFBITS;
        controlbitsfrompermutation(bArr9, sArr, (long) i25, (long) (1 << i25));
        System.arraycopy(bArr9, 0, bArr4, this.IRR_BYTES + 40, i24);
        int i26 = this.SYS_N;
        System.arraycopy(bArr7, i11 - (i26 / 8), bArr4, bArr4.length - (i26 / 8), i26 / 8);
        if (!this.usePivots) {
            j11 = 4294967295L;
            i13 = 32;
        } else {
            i13 = 32;
            j11 = jArr[0];
        }
        Utils.store8(bArr4, i13, j11);
    }
}
