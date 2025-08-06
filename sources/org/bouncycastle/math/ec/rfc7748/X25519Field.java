package org.bouncycastle.math.ec.rfc7748;

import com.google.common.base.Ascii;
import org.bouncycastle.math.raw.Mod;

public abstract class X25519Field {
    private static final int M24 = 16777215;
    private static final int M25 = 33554431;
    private static final int M26 = 67108863;
    private static final int[] P32 = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
    private static final int[] ROOT_NEG_ONE = {34513072, 59165138, 4688974, 3500415, 6194736, 33281959, 54535759, 32551604, 163342, 5703241};
    public static final int SIZE = 10;

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i11 = 0; i11 < 10; i11++) {
            iArr3[i11] = iArr[i11] + iArr2[i11];
        }
    }

    public static void addOne(int[] iArr) {
        iArr[0] = iArr[0] + 1;
    }

    public static void addOne(int[] iArr, int i11) {
        iArr[i11] = iArr[i11] + 1;
    }

    public static void apm(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        for (int i11 = 0; i11 < 10; i11++) {
            int i12 = iArr[i11];
            int i13 = iArr2[i11];
            iArr3[i11] = i12 + i13;
            iArr4[i11] = i12 - i13;
        }
    }

    public static int areEqual(int[] iArr, int[] iArr2) {
        int i11 = 0;
        for (int i12 = 0; i12 < 10; i12++) {
            i11 |= iArr[i12] ^ iArr2[i12];
        }
        return (((i11 >>> 1) | (i11 & 1)) - 1) >> 31;
    }

    public static boolean areEqualVar(int[] iArr, int[] iArr2) {
        return areEqual(iArr, iArr2) != 0;
    }

    public static void carry(int[] iArr) {
        int i11 = iArr[0];
        int i12 = iArr[1];
        int i13 = iArr[2];
        int i14 = iArr[3];
        int i15 = iArr[4];
        int i16 = iArr[5];
        int i17 = iArr[6];
        int i18 = iArr[7];
        int i19 = iArr[8];
        int i21 = iArr[9];
        int i22 = i13 + (i12 >> 26);
        int i23 = i12 & M26;
        int i24 = i15 + (i14 >> 26);
        int i25 = i14 & M26;
        int i26 = i18 + (i17 >> 26);
        int i27 = i17 & M26;
        int i28 = i21 + (i19 >> 26);
        int i29 = i19 & M26;
        int i30 = i25 + (i22 >> 25);
        int i31 = i22 & M25;
        int i32 = i16 + (i24 >> 25);
        int i33 = i24 & M25;
        int i34 = i29 + (i26 >> 25);
        int i35 = i26 & M25;
        int i36 = i11 + ((i28 >> 25) * 38);
        int i37 = i28 & M25;
        int i38 = i23 + (i36 >> 26);
        int i39 = i36 & M26;
        int i40 = i27 + (i32 >> 26);
        int i41 = i32 & M26;
        int i42 = i31 + (i38 >> 26);
        int i43 = i38 & M26;
        int i44 = i33 + (i30 >> 26);
        int i45 = i30 & M26;
        int i46 = i35 + (i40 >> 26);
        int i47 = i40 & M26;
        int i48 = i34 & M26;
        iArr[0] = i39;
        iArr[1] = i43;
        iArr[2] = i42;
        iArr[3] = i45;
        iArr[4] = i44;
        iArr[5] = i41;
        iArr[6] = i47;
        iArr[7] = i46;
        iArr[8] = i48;
        iArr[9] = i37 + (i34 >> 26);
    }

    public static void cmov(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        for (int i14 = 0; i14 < 10; i14++) {
            int i15 = i13 + i14;
            int i16 = iArr2[i15];
            iArr2[i15] = i16 ^ ((iArr[i12 + i14] ^ i16) & i11);
        }
    }

    public static void cnegate(int i11, int[] iArr) {
        int i12 = 0 - i11;
        for (int i13 = 0; i13 < 10; i13++) {
            iArr[i13] = (iArr[i13] ^ i12) - i12;
        }
    }

    public static void copy(int[] iArr, int i11, int[] iArr2, int i12) {
        for (int i13 = 0; i13 < 10; i13++) {
            iArr2[i12 + i13] = iArr[i11 + i13];
        }
    }

    public static int[] create() {
        return new int[10];
    }

    public static int[] createTable(int i11) {
        return new int[(i11 * 10)];
    }

    public static void cswap(int i11, int[] iArr, int[] iArr2) {
        int i12 = 0 - i11;
        for (int i13 = 0; i13 < 10; i13++) {
            int i14 = iArr[i13];
            int i15 = iArr2[i13];
            int i16 = (i14 ^ i15) & i12;
            iArr[i13] = i14 ^ i16;
            iArr2[i13] = i15 ^ i16;
        }
    }

    public static void decode(byte[] bArr, int i11, int[] iArr) {
        decode128(bArr, i11, iArr, 0);
        decode128(bArr, i11 + 16, iArr, 5);
        iArr[9] = iArr[9] & 16777215;
    }

    public static void decode(int[] iArr, int i11, int[] iArr2) {
        decode128(iArr, i11, iArr2, 0);
        decode128(iArr, i11 + 4, iArr2, 5);
        iArr2[9] = iArr2[9] & 16777215;
    }

    private static void decode128(byte[] bArr, int i11, int[] iArr, int i12) {
        int decode32 = decode32(bArr, i11 + 0);
        int decode322 = decode32(bArr, i11 + 4);
        int decode323 = decode32(bArr, i11 + 8);
        int decode324 = decode32(bArr, i11 + 12);
        iArr[i12 + 0] = decode32 & M26;
        iArr[i12 + 1] = ((decode32 >>> 26) | (decode322 << 6)) & M26;
        iArr[i12 + 2] = ((decode323 << 12) | (decode322 >>> 20)) & M25;
        iArr[i12 + 3] = ((decode324 << 19) | (decode323 >>> 13)) & M26;
        iArr[i12 + 4] = decode324 >>> 7;
    }

    private static void decode128(int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = iArr[i11 + 0];
        int i14 = iArr[i11 + 1];
        int i15 = iArr[i11 + 2];
        int i16 = iArr[i11 + 3];
        iArr2[i12 + 0] = i13 & M26;
        iArr2[i12 + 1] = ((i13 >>> 26) | (i14 << 6)) & M26;
        iArr2[i12 + 2] = ((i15 << 12) | (i14 >>> 20)) & M25;
        iArr2[i12 + 3] = ((i16 << 19) | (i15 >>> 13)) & M26;
        iArr2[i12 + 4] = i16 >>> 7;
    }

    private static int decode32(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        return (bArr[i13 + 1] << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i12] & 255) << 8) | ((bArr[i13] & 255) << 16);
    }

    public static void encode(int[] iArr, byte[] bArr, int i11) {
        encode128(iArr, 0, bArr, i11);
        encode128(iArr, 5, bArr, i11 + 16);
    }

    public static void encode(int[] iArr, int[] iArr2, int i11) {
        encode128(iArr, 0, iArr2, i11);
        encode128(iArr, 5, iArr2, i11 + 4);
    }

    private static void encode128(int[] iArr, int i11, byte[] bArr, int i12) {
        int i13 = iArr[i11 + 0];
        int i14 = iArr[i11 + 1];
        int i15 = iArr[i11 + 2];
        int i16 = iArr[i11 + 3];
        int i17 = iArr[i11 + 4];
        encode32((i14 << 26) | i13, bArr, i12 + 0);
        encode32((i14 >>> 6) | (i15 << 20), bArr, i12 + 4);
        encode32((i15 >>> 12) | (i16 << 13), bArr, i12 + 8);
        encode32((i17 << 7) | (i16 >>> 19), bArr, i12 + 12);
    }

    private static void encode128(int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = iArr[i11 + 0];
        int i14 = iArr[i11 + 1];
        int i15 = iArr[i11 + 2];
        int i16 = iArr[i11 + 3];
        int i17 = iArr[i11 + 4];
        iArr2[i12 + 0] = i13 | (i14 << 26);
        iArr2[i12 + 1] = (i14 >>> 6) | (i15 << 20);
        iArr2[i12 + 2] = (i15 >>> 12) | (i16 << 13);
        iArr2[i12 + 3] = (i17 << 7) | (i16 >>> 19);
    }

    private static void encode32(int i11, byte[] bArr, int i12) {
        bArr[i12] = (byte) i11;
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i11 >>> 8);
        int i14 = i13 + 1;
        bArr[i14] = (byte) (i11 >>> 16);
        bArr[i14 + 1] = (byte) (i11 >>> 24);
    }

    public static void inv(int[] iArr, int[] iArr2) {
        int[] create = create();
        int[] iArr3 = new int[8];
        copy(iArr, 0, create, 0);
        normalize(create);
        encode(create, iArr3, 0);
        Mod.modOddInverse(P32, iArr3, iArr3);
        decode(iArr3, 0, iArr2);
    }

    public static void invVar(int[] iArr, int[] iArr2) {
        int[] create = create();
        int[] iArr3 = new int[8];
        copy(iArr, 0, create, 0);
        normalize(create);
        encode(create, iArr3, 0);
        Mod.modOddInverseVar(P32, iArr3, iArr3);
        decode(iArr3, 0, iArr2);
    }

    public static int isOne(int[] iArr) {
        int i11 = iArr[0] ^ 1;
        for (int i12 = 1; i12 < 10; i12++) {
            i11 |= iArr[i12];
        }
        return (((i11 >>> 1) | (i11 & 1)) - 1) >> 31;
    }

    public static boolean isOneVar(int[] iArr) {
        return isOne(iArr) != 0;
    }

    public static int isZero(int[] iArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 10; i12++) {
            i11 |= iArr[i12];
        }
        return (((i11 >>> 1) | (i11 & 1)) - 1) >> 31;
    }

    public static boolean isZeroVar(int[] iArr) {
        return isZero(iArr) != 0;
    }

    public static void mul(int[] iArr, int i11, int[] iArr2) {
        int i12 = iArr[0];
        int i13 = iArr[1];
        int i14 = iArr[2];
        int i15 = iArr[3];
        int i16 = iArr[4];
        int i17 = iArr[5];
        int i18 = iArr[6];
        int i19 = iArr[7];
        int i21 = iArr[8];
        int i22 = iArr[9];
        long j11 = (long) i11;
        long j12 = ((long) i14) * j11;
        int i23 = ((int) j12) & M25;
        long j13 = ((long) i16) * j11;
        int i24 = ((int) j13) & M25;
        long j14 = ((long) i19) * j11;
        int i25 = ((int) j14) & M25;
        long j15 = ((long) i22) * j11;
        int i26 = ((int) j15) & M25;
        long j16 = ((j15 >> 25) * 38) + (((long) i12) * j11);
        iArr2[0] = ((int) j16) & M26;
        long j17 = (j13 >> 25) + (((long) i17) * j11);
        iArr2[5] = ((int) j17) & M26;
        long j18 = (j16 >> 26) + (((long) i13) * j11);
        iArr2[1] = ((int) j18) & M26;
        long j19 = (j12 >> 25) + (((long) i15) * j11);
        iArr2[3] = ((int) j19) & M26;
        long j21 = (j17 >> 26) + (((long) i18) * j11);
        iArr2[6] = ((int) j21) & M26;
        long j22 = (j14 >> 25) + (((long) i21) * j11);
        iArr2[8] = ((int) j22) & M26;
        iArr2[2] = i23 + ((int) (j18 >> 26));
        iArr2[4] = i24 + ((int) (j19 >> 26));
        iArr2[7] = i25 + ((int) (j21 >> 26));
        iArr2[9] = i26 + ((int) (j22 >> 26));
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        int i11 = iArr[0];
        int i12 = iArr2[0];
        int i13 = iArr[1];
        int i14 = iArr2[1];
        int i15 = iArr[2];
        int i16 = iArr2[2];
        int i17 = iArr[3];
        int i18 = iArr2[3];
        int i19 = iArr[4];
        int i21 = iArr2[4];
        int i22 = iArr[5];
        int i23 = iArr2[5];
        int i24 = iArr[6];
        int i25 = iArr2[6];
        int i26 = iArr[7];
        int i27 = iArr2[7];
        int i28 = i26;
        int i29 = iArr[8];
        int i30 = iArr2[8];
        int i31 = iArr[9];
        int i32 = i22;
        long j11 = (long) i11;
        int i33 = iArr2[9];
        long j12 = (long) i12;
        long j13 = j11 * j12;
        int i34 = i12;
        int i35 = i27;
        long j14 = (long) i14;
        int i36 = i14;
        long j15 = (long) i13;
        long j16 = (j11 * j14) + (j15 * j12);
        int i37 = i21;
        int i38 = i24;
        long j17 = (long) i16;
        int i39 = i16;
        long j18 = (long) i15;
        long j19 = (j11 * j17) + (j15 * j14) + (j18 * j12);
        long j21 = j14;
        long j22 = (long) i18;
        long j23 = j11 * j22;
        long j24 = j22;
        long j25 = (long) i17;
        long j26 = (((j15 * j17) + (j18 * j14)) << 1) + j23 + (j25 * j12);
        int i40 = i18;
        long j27 = j17;
        long j28 = (long) i37;
        long j29 = (j11 * j28) + (j15 * j24) + (j25 * j21);
        long j30 = j25;
        int i41 = i19;
        long j31 = (long) i41;
        long j32 = ((j18 * j17) << 1) + j29 + (j12 * j31);
        long j33 = (((j18 * j28) + (j31 * j27)) << 1) + (j30 * j24);
        long j34 = (j30 * j28) + (j31 * j24);
        int i42 = i32;
        long j35 = (long) i42;
        int i43 = i17;
        int i44 = i23;
        long j36 = (long) i44;
        long j37 = j35 * j36;
        int i45 = i44;
        int i46 = i15;
        int i47 = i25;
        int i48 = i13;
        long j38 = (long) i47;
        int i49 = i47;
        int i50 = i42;
        long j39 = (long) i38;
        long j40 = (j35 * j38) + (j39 * j36);
        long j41 = j34;
        long j42 = (long) i35;
        long j43 = j33;
        long j44 = (long) i28;
        long j45 = (j35 * j42) + (j39 * j38) + (j44 * j36);
        long j46 = ((((j15 * j28) + (j18 * j24)) + (j30 * j27)) + (j31 * j21)) << 1;
        long j47 = (long) i30;
        long j48 = j38;
        int i51 = i50;
        long j49 = (long) i29;
        long j50 = (((j39 * j42) + (j44 * j38)) << 1) + (j35 * j47) + (j49 * j36);
        long j51 = j42;
        long j52 = (long) i33;
        long j53 = (j35 * j52) + (j39 * j47) + (j49 * j48);
        long j54 = j49;
        int i52 = i31;
        long j55 = (long) i52;
        long j56 = ((j44 * j42) << 1) + j53 + (j36 * j55);
        long j57 = (j39 * j52) + (j44 * j47) + (j54 * j51) + (j55 * j48);
        long j58 = j13 - (j57 * 76);
        long j59 = j16 - (((((j44 * j52) + (j55 * j51)) << 1) + (j54 * j47)) * 38);
        long j60 = j19 - (((j54 * j52) + (j47 * j55)) * 38);
        long j61 = j26 - ((j55 * j52) * 76);
        int i53 = i46 + i28;
        long j62 = j41 - j45;
        int i54 = i40 + i30;
        int i55 = i41 + i52;
        int i56 = i37 + i33;
        long j63 = (long) (i11 + i51);
        long j64 = j46 - j37;
        long j65 = (long) (i34 + i45);
        long j66 = j63 * j65;
        long j67 = ((j31 * j28) << 1) - j50;
        long j68 = (long) (i36 + i49);
        long j69 = (long) (i48 + i38);
        long j70 = (j63 * j68) + (j69 * j65);
        int i57 = i55;
        long j71 = (long) (i39 + i35);
        int i58 = i57;
        long j72 = (long) i53;
        long j73 = j68;
        long j74 = (long) i54;
        long j75 = j74;
        long j76 = (long) (i43 + i29);
        long j77 = (((j69 * j71) + (j72 * j68)) << 1) + (j63 * j74) + (j76 * j65);
        long j78 = j71;
        long j79 = (long) i56;
        long j80 = (long) i58;
        long j81 = (((j72 * j79) + (j80 * j78)) << 1) + (j76 * j75);
        long j82 = j67 + (j77 - j61);
        int i59 = ((int) j82) & M26;
        long j83 = (j82 >> 26) + (((((j72 * j71) << 1) + ((((j63 * j79) + (j69 * j75)) + (j76 * j73)) + (j65 * j80))) - j32) - j56);
        int i60 = ((int) j83) & M25;
        long j84 = j58 + ((((j83 >> 25) + (((((j69 * j79) + (j72 * j75)) + (j76 * j78)) + (j80 * j73)) << 1)) - j64) * 38);
        iArr3[0] = ((int) j84) & M26;
        long j85 = j43 - j40;
        long j86 = (j84 >> 26) + j59 + ((j81 - j85) * 38);
        iArr3[1] = ((int) j86) & M26;
        long j87 = (j86 >> 26) + j60 + ((((j76 * j79) + (j80 * j75)) - j62) * 38);
        iArr3[2] = ((int) j87) & M25;
        long j88 = (j87 >> 25) + j61 + ((((j80 * j79) << 1) - j67) * 38);
        iArr3[3] = ((int) j88) & M26;
        long j89 = (j88 >> 26) + j32 + (j56 * 38);
        iArr3[4] = ((int) j89) & M25;
        long j90 = (j89 >> 25) + j64 + (j66 - j58);
        iArr3[5] = ((int) j90) & M26;
        long j91 = (j90 >> 26) + j85 + (j70 - j59);
        iArr3[6] = ((int) j91) & M26;
        long j92 = (j91 >> 26) + j62 + ((((j63 * j71) + (j69 * j68)) + (j72 * j65)) - j60);
        iArr3[7] = ((int) j92) & M25;
        long j93 = (j92 >> 25) + ((long) i59);
        iArr3[8] = ((int) j93) & M26;
        iArr3[9] = i60 + ((int) (j93 >> 26));
    }

    public static void negate(int[] iArr, int[] iArr2) {
        for (int i11 = 0; i11 < 10; i11++) {
            iArr2[i11] = -iArr[i11];
        }
    }

    public static void normalize(int[] iArr) {
        int i11 = (iArr[9] >>> 23) & 1;
        reduce(iArr, i11);
        reduce(iArr, -i11);
    }

    public static void one(int[] iArr) {
        iArr[0] = 1;
        for (int i11 = 1; i11 < 10; i11++) {
            iArr[i11] = 0;
        }
    }

    private static void powPm5d8(int[] iArr, int[] iArr2, int[] iArr3) {
        sqr(iArr, iArr2);
        mul(iArr, iArr2, iArr2);
        int[] create = create();
        sqr(iArr2, create);
        mul(iArr, create, create);
        sqr(create, 2, create);
        mul(iArr2, create, create);
        int[] create2 = create();
        sqr(create, 5, create2);
        mul(create, create2, create2);
        int[] create3 = create();
        sqr(create2, 5, create3);
        mul(create, create3, create3);
        sqr(create3, 10, create);
        mul(create2, create, create);
        sqr(create, 25, create2);
        mul(create, create2, create2);
        sqr(create2, 25, create3);
        mul(create, create3, create3);
        sqr(create3, 50, create);
        mul(create2, create, create);
        sqr(create, 125, create2);
        mul(create, create2, create2);
        sqr(create2, 2, create);
        mul(create, iArr, iArr3);
    }

    private static void reduce(int[] iArr, int i11) {
        int i12 = iArr[9];
        long j11 = ((long) (((i12 >> 24) + i11) * 19)) + ((long) iArr[0]);
        iArr[0] = ((int) j11) & M26;
        long j12 = (j11 >> 26) + ((long) iArr[1]);
        iArr[1] = ((int) j12) & M26;
        long j13 = (j12 >> 26) + ((long) iArr[2]);
        iArr[2] = ((int) j13) & M25;
        long j14 = (j13 >> 25) + ((long) iArr[3]);
        iArr[3] = ((int) j14) & M26;
        long j15 = (j14 >> 26) + ((long) iArr[4]);
        iArr[4] = ((int) j15) & M25;
        long j16 = (j15 >> 25) + ((long) iArr[5]);
        iArr[5] = ((int) j16) & M26;
        long j17 = (j16 >> 26) + ((long) iArr[6]);
        iArr[6] = ((int) j17) & M26;
        long j18 = (j17 >> 26) + ((long) iArr[7]);
        iArr[7] = M25 & ((int) j18);
        long j19 = (j18 >> 25) + ((long) iArr[8]);
        iArr[8] = M26 & ((int) j19);
        iArr[9] = (16777215 & i12) + ((int) (j19 >> 26));
    }

    public static void sqr(int[] iArr, int i11, int[] iArr2) {
        sqr(iArr, iArr2);
        while (true) {
            i11--;
            if (i11 > 0) {
                sqr(iArr2, iArr2);
            } else {
                return;
            }
        }
    }

    public static void sqr(int[] iArr, int[] iArr2) {
        int i11 = iArr[0];
        int i12 = iArr[1];
        int i13 = iArr[2];
        int i14 = iArr[3];
        int i15 = iArr[4];
        int i16 = iArr[5];
        int i17 = iArr[6];
        int i18 = iArr[7];
        long j11 = (long) i11;
        long j12 = j11 * j11;
        long j13 = (long) (i12 * 2);
        long j14 = j11 * j13;
        long j15 = (long) (i13 * 2);
        int i19 = iArr[8];
        int i21 = i12;
        int i22 = i18;
        long j16 = (long) i21;
        long j17 = (j11 * j15) + (j16 * j16);
        int i23 = iArr[9];
        int i24 = i17;
        long j18 = (long) (i14 * 2);
        long j19 = (j13 * j15) + (j11 * j18);
        int i25 = i21;
        int i26 = i15;
        long j21 = (long) (i15 * 2);
        long j22 = (((long) i13) * j15) + (j11 * j21) + (j16 * j18);
        long j23 = (j13 * j21) + (j18 * j15);
        long j24 = (long) i14;
        long j25 = (j15 * j21) + (j24 * j24);
        long j26 = ((long) i26) * j21;
        long j27 = j22;
        int i27 = i16;
        int i28 = i26;
        long j28 = (long) i27;
        long j29 = j28 * j28;
        int i29 = i27;
        long j30 = (long) (i24 * 2);
        long j31 = j28 * j30;
        long j32 = j26;
        long j33 = (long) (i22 * 2);
        long j34 = j24 * j21;
        long j35 = (long) i24;
        long j36 = (j28 * j33) + (j35 * j35);
        long j37 = (long) (i19 * 2);
        long j38 = (j30 * j33) + (j28 * j37);
        long j39 = j25;
        long j40 = (long) (i23 * 2);
        long j41 = (((long) i22) * j33) + (j28 * j40) + (j35 * j37);
        long j42 = (j30 * j40) + (j37 * j33);
        int i30 = i19;
        long j43 = (long) i30;
        int i31 = i23;
        long j44 = j12 - (j42 * 38);
        long j45 = j14 - (((j33 * j40) + (j43 * j43)) * 38);
        long j46 = j17 - ((j43 * j40) * 38);
        long j47 = j19 - ((((long) i31) * j40) * 38);
        long j48 = j23 - j29;
        long j49 = j32 - j38;
        int i32 = i11 + i29;
        int i33 = i25 + i24;
        int i34 = i13 + i22;
        int i35 = i14 + i30;
        int i36 = i28 + i31;
        long j50 = j34 - j36;
        long j51 = j39 - j31;
        long j52 = j48;
        long j53 = (long) i32;
        long j54 = j53 * j53;
        long j55 = j41;
        long j56 = (long) (i33 * 2);
        long j57 = j53 * j56;
        long j58 = (long) (i34 * 2);
        long j59 = (long) i33;
        long j60 = (j53 * j58) + (j59 * j59);
        long j61 = j49;
        long j62 = (long) (i35 * 2);
        int i37 = i35;
        long j63 = (long) (i36 * 2);
        long j64 = (j56 * j63) + (j62 * j58);
        long j65 = (long) i37;
        long j66 = (j58 * j63) + (j65 * j65);
        long j67 = j65 * j63;
        long j68 = ((long) i36) * j63;
        long j69 = j61 + (((j56 * j58) + (j53 * j62)) - j47);
        int i38 = ((int) j69) & M26;
        long j70 = (j69 >> 26) + (((((((long) i34) * j58) + (j53 * j63)) + (j59 * j62)) - j27) - j55);
        int i39 = ((int) j70) & M25;
        long j71 = j44 + ((((j70 >> 25) + j64) - j52) * 38);
        iArr2[0] = ((int) j71) & M26;
        long j72 = (j71 >> 26) + j45 + ((j66 - j51) * 38);
        iArr2[1] = ((int) j72) & M26;
        long j73 = (j72 >> 26) + j46 + ((j67 - j50) * 38);
        iArr2[2] = ((int) j73) & M25;
        long j74 = (j73 >> 25) + j47 + ((j68 - j61) * 38);
        iArr2[3] = ((int) j74) & M26;
        long j75 = (j74 >> 26) + j27 + (38 * j55);
        iArr2[4] = ((int) j75) & M25;
        long j76 = (j75 >> 25) + j52 + (j54 - j44);
        iArr2[5] = ((int) j76) & M26;
        long j77 = (j76 >> 26) + j51 + (j57 - j45);
        iArr2[6] = ((int) j77) & M26;
        long j78 = (j77 >> 26) + j50 + (j60 - j46);
        iArr2[7] = ((int) j78) & M25;
        long j79 = (j78 >> 25) + ((long) i38);
        iArr2[8] = ((int) j79) & M26;
        iArr2[9] = i39 + ((int) (j79 >> 26));
    }

    public static boolean sqrtRatioVar(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = create();
        int[] create2 = create();
        mul(iArr, iArr2, create);
        sqr(iArr2, create2);
        mul(create, create2, create);
        sqr(create2, create2);
        mul(create2, create, create2);
        int[] create3 = create();
        int[] create4 = create();
        powPm5d8(create2, create3, create4);
        mul(create4, create, create4);
        int[] create5 = create();
        sqr(create4, create5);
        mul(create5, iArr2, create5);
        sub(create5, iArr, create3);
        normalize(create3);
        if (isZeroVar(create3)) {
            copy(create4, 0, iArr3, 0);
            return true;
        }
        add(create5, iArr, create3);
        normalize(create3);
        if (!isZeroVar(create3)) {
            return false;
        }
        mul(create4, ROOT_NEG_ONE, iArr3);
        return true;
    }

    public static void sub(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i11 = 0; i11 < 10; i11++) {
            iArr3[i11] = iArr[i11] - iArr2[i11];
        }
    }

    public static void subOne(int[] iArr) {
        iArr[0] = iArr[0] - 1;
    }

    public static void zero(int[] iArr) {
        for (int i11 = 0; i11 < 10; i11++) {
            iArr[i11] = 0;
        }
    }
}
