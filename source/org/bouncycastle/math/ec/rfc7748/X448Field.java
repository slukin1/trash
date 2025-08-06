package org.bouncycastle.math.ec.rfc7748;

import com.google.common.base.Ascii;
import org.bouncycastle.math.raw.Mod;

public abstract class X448Field {
    private static final int M28 = 268435455;
    private static final int[] P32 = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
    public static final int SIZE = 16;
    private static final long U32 = 4294967295L;

    public static void add(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i11 = 0; i11 < 16; i11++) {
            iArr3[i11] = iArr[i11] + iArr2[i11];
        }
    }

    public static void addOne(int[] iArr) {
        iArr[0] = iArr[0] + 1;
    }

    public static void addOne(int[] iArr, int i11) {
        iArr[i11] = iArr[i11] + 1;
    }

    public static int areEqual(int[] iArr, int[] iArr2) {
        int i11 = 0;
        for (int i12 = 0; i12 < 16; i12++) {
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
        int i22 = iArr[10];
        int i23 = iArr[11];
        int i24 = iArr[12];
        int i25 = iArr[13];
        int i26 = iArr[14];
        int i27 = iArr[15];
        int i28 = i12 + (i11 >>> 28);
        int i29 = i11 & M28;
        int i30 = i16 + (i15 >>> 28);
        int i31 = i15 & M28;
        int i32 = i21 + (i19 >>> 28);
        int i33 = i19 & M28;
        int i34 = i25 + (i24 >>> 28);
        int i35 = i24 & M28;
        int i36 = i13 + (i28 >>> 28);
        int i37 = i28 & M28;
        int i38 = i17 + (i30 >>> 28);
        int i39 = i30 & M28;
        int i40 = i22 + (i32 >>> 28);
        int i41 = i32 & M28;
        int i42 = i26 + (i34 >>> 28);
        int i43 = i34 & M28;
        int i44 = i14 + (i36 >>> 28);
        int i45 = i36 & M28;
        int i46 = i18 + (i38 >>> 28);
        int i47 = i38 & M28;
        int i48 = i23 + (i40 >>> 28);
        int i49 = i40 & M28;
        int i50 = i27 + (i42 >>> 28);
        int i51 = i42 & M28;
        int i52 = i50 >>> 28;
        int i53 = i50 & M28;
        int i54 = i29 + i52;
        int i55 = i31 + (i44 >>> 28);
        int i56 = i44 & M28;
        int i57 = i33 + i52 + (i46 >>> 28);
        int i58 = i46 & M28;
        int i59 = i35 + (i48 >>> 28);
        int i60 = i48 & M28;
        int i61 = i37 + (i54 >>> 28);
        int i62 = i54 & M28;
        int i63 = i39 + (i55 >>> 28);
        int i64 = i55 & M28;
        int i65 = i41 + (i57 >>> 28);
        int i66 = i57 & M28;
        int i67 = i59 & M28;
        iArr[0] = i62;
        iArr[1] = i61;
        iArr[2] = i45;
        iArr[3] = i56;
        iArr[4] = i64;
        iArr[5] = i63;
        iArr[6] = i47;
        iArr[7] = i58;
        iArr[8] = i66;
        iArr[9] = i65;
        iArr[10] = i49;
        iArr[11] = i60;
        iArr[12] = i67;
        iArr[13] = i43 + (i59 >>> 28);
        iArr[14] = i51;
        iArr[15] = i53;
    }

    public static void cmov(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        for (int i14 = 0; i14 < 16; i14++) {
            int i15 = i13 + i14;
            int i16 = iArr2[i15];
            iArr2[i15] = i16 ^ ((iArr[i12 + i14] ^ i16) & i11);
        }
    }

    public static void cnegate(int i11, int[] iArr) {
        int[] create = create();
        sub(create, iArr, create);
        cmov(-i11, create, 0, iArr, 0);
    }

    public static void copy(int[] iArr, int i11, int[] iArr2, int i12) {
        for (int i13 = 0; i13 < 16; i13++) {
            iArr2[i12 + i13] = iArr[i11 + i13];
        }
    }

    public static int[] create() {
        return new int[16];
    }

    public static int[] createTable(int i11) {
        return new int[(i11 * 16)];
    }

    public static void cswap(int i11, int[] iArr, int[] iArr2) {
        int i12 = 0 - i11;
        for (int i13 = 0; i13 < 16; i13++) {
            int i14 = iArr[i13];
            int i15 = iArr2[i13];
            int i16 = (i14 ^ i15) & i12;
            iArr[i13] = i14 ^ i16;
            iArr2[i13] = i15 ^ i16;
        }
    }

    public static void decode(byte[] bArr, int i11, int[] iArr) {
        decode56(bArr, i11, iArr, 0);
        decode56(bArr, i11 + 7, iArr, 2);
        decode56(bArr, i11 + 14, iArr, 4);
        decode56(bArr, i11 + 21, iArr, 6);
        decode56(bArr, i11 + 28, iArr, 8);
        decode56(bArr, i11 + 35, iArr, 10);
        decode56(bArr, i11 + 42, iArr, 12);
        decode56(bArr, i11 + 49, iArr, 14);
    }

    public static void decode(int[] iArr, int i11, int[] iArr2) {
        decode224(iArr, i11, iArr2, 0);
        decode224(iArr, i11 + 7, iArr2, 8);
    }

    private static void decode224(int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = iArr[i11 + 0];
        int i14 = iArr[i11 + 1];
        int i15 = iArr[i11 + 2];
        int i16 = iArr[i11 + 3];
        int i17 = iArr[i11 + 4];
        int i18 = iArr[i11 + 5];
        int i19 = iArr[i11 + 6];
        iArr2[i12 + 0] = i13 & M28;
        iArr2[i12 + 1] = ((i13 >>> 28) | (i14 << 4)) & M28;
        iArr2[i12 + 2] = ((i14 >>> 24) | (i15 << 8)) & M28;
        iArr2[i12 + 3] = ((i15 >>> 20) | (i16 << 12)) & M28;
        iArr2[i12 + 4] = ((i16 >>> 16) | (i17 << 16)) & M28;
        iArr2[i12 + 5] = ((i17 >>> 12) | (i18 << 20)) & M28;
        iArr2[i12 + 6] = ((i18 >>> 8) | (i19 << 24)) & M28;
        iArr2[i12 + 7] = i19 >>> 4;
    }

    private static int decode24(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        return ((bArr[i12 + 1] & 255) << 16) | (bArr[i11] & 255) | ((bArr[i12] & 255) << 8);
    }

    private static int decode32(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        return (bArr[i13 + 1] << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i12] & 255) << 8) | ((bArr[i13] & 255) << 16);
    }

    private static void decode56(byte[] bArr, int i11, int[] iArr, int i12) {
        int decode32 = decode32(bArr, i11);
        int decode24 = decode24(bArr, i11 + 4);
        iArr[i12] = M28 & decode32;
        iArr[i12 + 1] = (decode24 << 4) | (decode32 >>> 28);
    }

    public static void encode(int[] iArr, byte[] bArr, int i11) {
        encode56(iArr, 0, bArr, i11);
        encode56(iArr, 2, bArr, i11 + 7);
        encode56(iArr, 4, bArr, i11 + 14);
        encode56(iArr, 6, bArr, i11 + 21);
        encode56(iArr, 8, bArr, i11 + 28);
        encode56(iArr, 10, bArr, i11 + 35);
        encode56(iArr, 12, bArr, i11 + 42);
        encode56(iArr, 14, bArr, i11 + 49);
    }

    public static void encode(int[] iArr, int[] iArr2, int i11) {
        encode224(iArr, 0, iArr2, i11);
        encode224(iArr, 8, iArr2, i11 + 7);
    }

    private static void encode224(int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = iArr[i11 + 0];
        int i14 = iArr[i11 + 1];
        int i15 = iArr[i11 + 2];
        int i16 = iArr[i11 + 3];
        int i17 = iArr[i11 + 4];
        int i18 = iArr[i11 + 5];
        int i19 = iArr[i11 + 6];
        int i21 = iArr[i11 + 7];
        iArr2[i12 + 0] = i13 | (i14 << 28);
        iArr2[i12 + 1] = (i14 >>> 4) | (i15 << 24);
        iArr2[i12 + 2] = (i15 >>> 8) | (i16 << 20);
        iArr2[i12 + 3] = (i16 >>> 12) | (i17 << 16);
        iArr2[i12 + 4] = (i17 >>> 16) | (i18 << 12);
        iArr2[i12 + 5] = (i18 >>> 20) | (i19 << 8);
        iArr2[i12 + 6] = (i21 << 4) | (i19 >>> 24);
    }

    private static void encode24(int i11, byte[] bArr, int i12) {
        bArr[i12] = (byte) i11;
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i11 >>> 8);
        bArr[i13 + 1] = (byte) (i11 >>> 16);
    }

    private static void encode32(int i11, byte[] bArr, int i12) {
        bArr[i12] = (byte) i11;
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i11 >>> 8);
        int i14 = i13 + 1;
        bArr[i14] = (byte) (i11 >>> 16);
        bArr[i14 + 1] = (byte) (i11 >>> 24);
    }

    private static void encode56(int[] iArr, int i11, byte[] bArr, int i12) {
        int i13 = iArr[i11];
        int i14 = iArr[i11 + 1];
        encode32((i14 << 28) | i13, bArr, i12);
        encode24(i14 >>> 4, bArr, i12 + 4);
    }

    public static void inv(int[] iArr, int[] iArr2) {
        int[] create = create();
        int[] iArr3 = new int[14];
        copy(iArr, 0, create, 0);
        normalize(create);
        encode(create, iArr3, 0);
        Mod.modOddInverse(P32, iArr3, iArr3);
        decode(iArr3, 0, iArr2);
    }

    public static void invVar(int[] iArr, int[] iArr2) {
        int[] create = create();
        int[] iArr3 = new int[14];
        copy(iArr, 0, create, 0);
        normalize(create);
        encode(create, iArr3, 0);
        Mod.modOddInverseVar(P32, iArr3, iArr3);
        decode(iArr3, 0, iArr2);
    }

    public static int isOne(int[] iArr) {
        int i11 = iArr[0] ^ 1;
        for (int i12 = 1; i12 < 16; i12++) {
            i11 |= iArr[i12];
        }
        return (((i11 >>> 1) | (i11 & 1)) - 1) >> 31;
    }

    public static boolean isOneVar(int[] iArr) {
        return isOne(iArr) != 0;
    }

    public static int isZero(int[] iArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 16; i12++) {
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
        int i23 = iArr[10];
        int i24 = iArr[11];
        int i25 = iArr[12];
        int i26 = iArr[13];
        int i27 = iArr[14];
        int i28 = i16;
        long j11 = (long) i13;
        long j12 = (long) i11;
        long j13 = j11 * j12;
        int i29 = i12;
        int i30 = i25;
        long j14 = ((long) i17) * j12;
        int i31 = ((int) j13) & M28;
        long j15 = ((long) i22) * j12;
        int i32 = ((int) j14) & M28;
        long j16 = ((long) i26) * j12;
        int i33 = ((int) j15) & M28;
        int i34 = ((int) j16) & M28;
        long j17 = (j13 >>> 28) + (((long) i14) * j12);
        iArr2[2] = ((int) j17) & M28;
        long j18 = j17 >>> 28;
        long j19 = (j14 >>> 28) + (((long) i18) * j12);
        iArr2[6] = ((int) j19) & M28;
        long j21 = (j15 >>> 28) + (((long) i23) * j12);
        iArr2[10] = ((int) j21) & M28;
        long j22 = (j16 >>> 28) + (((long) i27) * j12);
        iArr2[14] = ((int) j22) & M28;
        long j23 = j18 + (((long) i15) * j12);
        iArr2[3] = ((int) j23) & M28;
        long j24 = (j19 >>> 28) + (((long) i19) * j12);
        iArr2[7] = ((int) j24) & M28;
        long j25 = (j21 >>> 28) + (((long) i24) * j12);
        iArr2[11] = ((int) j25) & M28;
        long j26 = (j22 >>> 28) + (((long) iArr[15]) * j12);
        iArr2[15] = ((int) j26) & M28;
        long j27 = j26 >>> 28;
        long j28 = (j23 >>> 28) + (((long) i28) * j12);
        iArr2[4] = ((int) j28) & M28;
        long j29 = (j24 >>> 28) + j27 + (((long) i21) * j12);
        iArr2[8] = ((int) j29) & M28;
        long j30 = (j25 >>> 28) + (((long) i30) * j12);
        iArr2[12] = ((int) j30) & M28;
        long j31 = j27 + (((long) i29) * j12);
        iArr2[0] = ((int) j31) & M28;
        iArr2[1] = i31 + ((int) (j31 >>> 28));
        iArr2[5] = i32 + ((int) (j28 >>> 28));
        iArr2[9] = i33 + ((int) (j29 >>> 28));
        iArr2[13] = i34 + ((int) (j30 >>> 28));
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
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
        int i22 = iArr[10];
        int i23 = iArr[11];
        int i24 = iArr[12];
        int i25 = iArr[13];
        int i26 = iArr[14];
        int i27 = i18;
        int i28 = iArr[15];
        int i29 = iArr2[0];
        int i30 = iArr2[1];
        int i31 = iArr2[2];
        int i32 = iArr2[3];
        int i33 = iArr2[4];
        int i34 = iArr2[5];
        int i35 = iArr2[6];
        int i36 = iArr2[7];
        int i37 = iArr2[8];
        int i38 = iArr2[9];
        int i39 = iArr2[10];
        int i40 = iArr2[11];
        int i41 = iArr2[12];
        int i42 = iArr2[13];
        int i43 = iArr2[14];
        int i44 = iArr2[15];
        int i45 = i11 + i19;
        int i46 = i12 + i21;
        int i47 = i13 + i22;
        int i48 = i14 + i23;
        int i49 = i15 + i24;
        int i50 = i16 + i25;
        int i51 = i17 + i26;
        int i52 = i27 + i28;
        int i53 = i30 + i38;
        int i54 = i32 + i40;
        int i55 = i34 + i42;
        int i56 = i36 + i44;
        long j11 = (long) i11;
        int i57 = i19;
        long j12 = (long) i29;
        long j13 = j11 * j12;
        long j14 = j11;
        long j15 = (long) i27;
        long j16 = j12;
        long j17 = (long) i30;
        long j18 = j15 * j17;
        long j19 = j15;
        long j21 = (long) i17;
        long j22 = j17;
        long j23 = (long) i31;
        long j24 = j18 + (j21 * j23);
        long j25 = j21;
        long j26 = (long) i16;
        long j27 = j23;
        long j28 = (long) i32;
        long j29 = j24 + (j26 * j28);
        long j30 = j26;
        long j31 = (long) i15;
        long j32 = j28;
        long j33 = (long) i33;
        long j34 = j29 + (j31 * j33);
        long j35 = j31;
        long j36 = (long) i14;
        long j37 = j33;
        long j38 = (long) i34;
        long j39 = j34 + (j36 * j38);
        long j40 = j36;
        long j41 = (long) i13;
        long j42 = j38;
        long j43 = (long) i35;
        long j44 = j39 + (j41 * j43);
        long j45 = j41;
        long j46 = (long) i12;
        long j47 = j43;
        long j48 = (long) i36;
        long j49 = j44 + (j46 * j48);
        long j50 = j48;
        long j51 = (long) i57;
        long j52 = j46;
        long j53 = (long) i37;
        long j54 = j51 * j53;
        long j55 = j51;
        long j56 = (long) i28;
        long j57 = j53;
        long j58 = (long) i38;
        long j59 = j56 * j58;
        long j60 = (long) i26;
        long j61 = j56;
        long j62 = (long) i39;
        long j63 = j59 + (j60 * j62);
        long j64 = (long) i25;
        long j65 = j60;
        long j66 = (long) i40;
        long j67 = (long) i24;
        long j68 = j64;
        long j69 = (long) i41;
        long j70 = j63 + (j64 * j66) + (j67 * j69);
        long j71 = (long) i23;
        long j72 = j67;
        long j73 = (long) i42;
        long j74 = (long) i22;
        long j75 = j71;
        long j76 = (long) i43;
        long j77 = j70 + (j71 * j73) + (j74 * j76);
        long j78 = j74;
        long j79 = (long) i21;
        long j80 = j76;
        long j81 = (long) i44;
        long j82 = j77 + (j79 * j81);
        long j83 = j81;
        long j84 = (long) i45;
        long j85 = j73;
        long j86 = (long) (i29 + i37);
        long j87 = j84 * j86;
        int i58 = i52;
        long j88 = j84;
        long j89 = (long) i58;
        long j90 = j86;
        long j91 = (long) i53;
        long j92 = j89 * j91;
        long j93 = j89;
        long j94 = (long) i51;
        long j95 = j91;
        long j96 = (long) (i31 + i39);
        long j97 = j92 + (j94 * j96);
        int i59 = i50;
        long j98 = j94;
        long j99 = (long) i59;
        long j100 = j96;
        long j101 = (long) i54;
        long j102 = j97 + (j99 * j101);
        long j103 = j99;
        long j104 = (long) i49;
        long j105 = j101;
        long j106 = (long) (i33 + i41);
        long j107 = j102 + (j104 * j106);
        int i60 = i48;
        long j108 = j104;
        long j109 = (long) i60;
        long j110 = j106;
        long j111 = (long) i55;
        long j112 = j107 + (j109 * j111);
        long j113 = j109;
        long j114 = (long) i47;
        long j115 = j111;
        long j116 = (long) (i35 + i43);
        long j117 = j114;
        long j118 = (long) i46;
        int i61 = i56;
        long j119 = j116;
        long j120 = (long) i61;
        long j121 = j112 + (j114 * j116) + (j118 * j120);
        long j122 = j120;
        long j123 = ((j13 + j54) + j121) - j49;
        long j124 = (j82 + j87) - j13;
        long j125 = j123 >>> 28;
        long j126 = j124 + j121;
        int i62 = ((int) j123) & M28;
        long j127 = (j52 * j16) + (j14 * j22);
        long j128 = j80;
        long j129 = (j118 * j90) + (j88 * j95);
        long j130 = (j93 * j100) + (j98 * j105) + (j103 * j110) + (j108 * j115) + (j113 * j119) + (j117 * j122);
        long j131 = ((j127 + ((j79 * j57) + (j55 * j58))) + j130) - ((((((j19 * j27) + (j25 * j32)) + (j30 * j37)) + (j35 * j42)) + (j40 * j47)) + (j45 * j50));
        long j132 = j118;
        long j133 = j125 + j131;
        int i63 = ((int) j126) & M28;
        long j134 = (j126 >>> 28) + ((((((((j61 * j62) + (j65 * j66)) + (j68 * j69)) + (j72 * j85)) + (j75 * j128)) + (j78 * j83)) + j129) - j127) + j130;
        int i64 = ((int) j133) & M28;
        long j135 = (j45 * j16) + (j52 * j22) + (j14 * j27);
        long j136 = (j93 * j105) + (j98 * j110) + (j103 * j115) + (j108 * j119) + (j113 * j122);
        long j137 = (j133 >>> 28) + (((j135 + (((j78 * j57) + (j79 * j58)) + (j55 * j62))) + j136) - (((((j19 * j32) + (j25 * j37)) + (j30 * j42)) + (j35 * j47)) + (j40 * j50)));
        int i65 = ((int) j134) & M28;
        long j138 = (j134 >>> 28) + (((((((j61 * j66) + (j65 * j69)) + (j68 * j85)) + (j72 * j128)) + (j75 * j83)) + (((j117 * j90) + (j132 * j95)) + (j88 * j100))) - j135) + j136;
        int i66 = ((int) j137) & M28;
        long j139 = (j40 * j16) + (j45 * j22) + (j52 * j27) + (j14 * j32);
        long j140 = (j93 * j110) + (j98 * j115) + (j103 * j119) + (j108 * j122);
        long j141 = (j137 >>> 28) + (((j139 + ((((j75 * j57) + (j78 * j58)) + (j79 * j62)) + (j55 * j66))) + j140) - ((((j19 * j37) + (j25 * j42)) + (j30 * j47)) + (j35 * j50)));
        int i67 = ((int) j138) & M28;
        long j142 = (j138 >>> 28) + ((((((j61 * j69) + (j65 * j85)) + (j68 * j128)) + (j72 * j83)) + ((((j113 * j90) + (j117 * j95)) + (j132 * j100)) + (j88 * j105))) - j139) + j140;
        int i68 = ((int) j141) & M28;
        long j143 = (j35 * j16) + (j40 * j22) + (j45 * j27) + (j52 * j32) + (j14 * j37);
        long j144 = (j93 * j115) + (j98 * j119) + (j103 * j122);
        long j145 = (j141 >>> 28) + (((j143 + (((((j72 * j57) + (j75 * j58)) + (j78 * j62)) + (j79 * j66)) + (j55 * j69))) + j144) - (((j19 * j42) + (j25 * j47)) + (j30 * j50)));
        int i69 = ((int) j142) & M28;
        long j146 = (j142 >>> 28) + (((((j61 * j85) + (j65 * j128)) + (j68 * j83)) + (((((j108 * j90) + (j113 * j95)) + (j117 * j100)) + (j132 * j105)) + (j88 * j110))) - j143) + j144;
        int i70 = ((int) j145) & M28;
        long j147 = (j30 * j16) + (j35 * j22) + (j40 * j27) + (j45 * j32) + (j52 * j37) + (j14 * j42);
        long j148 = (j93 * j119) + (j98 * j122);
        long j149 = (j145 >>> 28) + (((j147 + ((((((j68 * j57) + (j72 * j58)) + (j75 * j62)) + (j78 * j66)) + (j79 * j69)) + (j55 * j85))) + j148) - ((j19 * j47) + (j25 * j50)));
        int i71 = ((int) j146) & M28;
        long j150 = (j146 >>> 28) + ((((j61 * j128) + (j65 * j83)) + ((((((j103 * j90) + (j108 * j95)) + (j113 * j100)) + (j117 * j105)) + (j132 * j110)) + (j88 * j115))) - j147) + j148;
        int i72 = ((int) j149) & M28;
        long j151 = (j25 * j16) + (j30 * j22) + (j35 * j27) + (j40 * j32) + (j45 * j37) + (j52 * j42) + (j14 * j47);
        long j152 = j93 * j122;
        long j153 = (j149 >>> 28) + (((j151 + (((((((j65 * j57) + (j68 * j58)) + (j72 * j62)) + (j75 * j66)) + (j78 * j69)) + (j79 * j85)) + (j55 * j128))) + j152) - (j19 * j50));
        int i73 = ((int) j150) & M28;
        long j154 = (j150 >>> 28) + (((j61 * j83) + (((((((j98 * j90) + (j103 * j95)) + (j108 * j100)) + (j113 * j105)) + (j117 * j110)) + (j132 * j115)) + (j88 * j119))) - j151) + j152;
        int i74 = ((int) j153) & M28;
        int i75 = ((int) j154) & M28;
        long j155 = (j16 * j19) + (j22 * j25) + (j30 * j27) + (j35 * j32) + (j40 * j37) + (j45 * j42) + (j52 * j47) + (j14 * j50);
        long j156 = (j153 >>> 28) + j155 + (j61 * j57) + (j58 * j65) + (j68 * j62) + (j72 * j66) + (j75 * j69) + (j78 * j85) + (j79 * j128) + (j55 * j83);
        int i76 = ((int) j156) & M28;
        long j157 = (j154 >>> 28) + (((((((((j93 * j90) + (j98 * j95)) + (j103 * j100)) + (j108 * j105)) + (j113 * j110)) + (j117 * j115)) + (j132 * j119)) + (j88 * j122)) - j155);
        int i77 = ((int) j157) & M28;
        long j158 = j157 >>> 28;
        long j159 = (j156 >>> 28) + j158 + ((long) i63);
        int i78 = ((int) j159) & M28;
        long j160 = j158 + ((long) i62);
        iArr3[0] = ((int) j160) & M28;
        iArr3[1] = i64 + ((int) (j160 >>> 28));
        iArr3[2] = i66;
        iArr3[3] = i68;
        iArr3[4] = i70;
        iArr3[5] = i72;
        iArr3[6] = i74;
        iArr3[7] = i76;
        iArr3[8] = i78;
        iArr3[9] = i65 + ((int) (j159 >>> 28));
        iArr3[10] = i67;
        iArr3[11] = i69;
        iArr3[12] = i71;
        iArr3[13] = i73;
        iArr3[14] = i75;
        iArr3[15] = i77;
    }

    public static void negate(int[] iArr, int[] iArr2) {
        sub(create(), iArr, iArr2);
    }

    public static void normalize(int[] iArr) {
        reduce(iArr, 1);
        reduce(iArr, -1);
    }

    public static void one(int[] iArr) {
        iArr[0] = 1;
        for (int i11 = 1; i11 < 16; i11++) {
            iArr[i11] = 0;
        }
    }

    private static void powPm3d4(int[] iArr, int[] iArr2) {
        int[] create = create();
        sqr(iArr, create);
        mul(iArr, create, create);
        int[] create2 = create();
        sqr(create, create2);
        mul(iArr, create2, create2);
        int[] create3 = create();
        sqr(create2, 3, create3);
        mul(create2, create3, create3);
        int[] create4 = create();
        sqr(create3, 3, create4);
        mul(create2, create4, create4);
        int[] create5 = create();
        sqr(create4, 9, create5);
        mul(create4, create5, create5);
        int[] create6 = create();
        sqr(create5, create6);
        mul(iArr, create6, create6);
        int[] create7 = create();
        sqr(create6, 18, create7);
        mul(create5, create7, create7);
        int[] create8 = create();
        sqr(create7, 37, create8);
        mul(create7, create8, create8);
        int[] create9 = create();
        sqr(create8, 37, create9);
        mul(create7, create9, create9);
        int[] create10 = create();
        sqr(create9, 111, create10);
        mul(create9, create10, create10);
        int[] create11 = create();
        sqr(create10, create11);
        mul(iArr, create11, create11);
        int[] create12 = create();
        sqr(create11, 223, create12);
        mul(create12, create10, iArr2);
    }

    private static void reduce(int[] iArr, int i11) {
        int i12;
        int i13 = iArr[15];
        int i14 = i13 & M28;
        long j11 = (long) ((i13 >>> 28) + i11);
        int i15 = 0;
        long j12 = j11;
        while (true) {
            if (i15 >= 8) {
                break;
            }
            long j13 = j12 + (4294967295L & ((long) iArr[i15]));
            iArr[i15] = ((int) j13) & M28;
            j12 = j13 >> 28;
            i15++;
        }
        long j14 = j12 + j11;
        for (i12 = 8; i12 < 15; i12++) {
            long j15 = j14 + (((long) iArr[i12]) & 4294967295L);
            iArr[i12] = ((int) j15) & M28;
            j14 = j15 >> 28;
        }
        iArr[15] = i14 + ((int) j14);
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
        int i19 = iArr[8];
        int i21 = iArr[9];
        int i22 = iArr[10];
        int i23 = iArr[11];
        int i24 = iArr[12];
        int i25 = iArr[13];
        int i26 = iArr[14];
        int i27 = iArr[15];
        int i28 = i11 * 2;
        int i29 = i12 * 2;
        int i30 = i13 * 2;
        int i31 = i14 * 2;
        int i32 = i15 * 2;
        int i33 = i16 * 2;
        int i34 = i17 * 2;
        int i35 = i19 * 2;
        int i36 = i21 * 2;
        int i37 = i22 * 2;
        int i38 = i23 * 2;
        int i39 = i24 * 2;
        int i40 = i25 * 2;
        int i41 = i26 * 2;
        int i42 = i11 + i19;
        int i43 = i19;
        int i44 = i12 + i21;
        int i45 = i21;
        int i46 = i13 + i22;
        int i47 = i22;
        int i48 = i14 + i23;
        int i49 = i23;
        int i50 = i15 + i24;
        int i51 = i14;
        int i52 = i16 + i25;
        int i53 = i13;
        int i54 = i17 + i26;
        int i55 = i12;
        int i56 = i42 * 2;
        int i57 = i44 * 2;
        int i58 = i44;
        int i59 = i46 * 2;
        int i60 = i46;
        int i61 = i48 * 2;
        int i62 = i48;
        int i63 = i50 * 2;
        int i64 = i52 * 2;
        int i65 = i52;
        int i66 = i50;
        long j11 = (long) i11;
        long j12 = j11 * j11;
        long j13 = (long) i18;
        int i67 = i29;
        int i68 = i59;
        long j14 = (long) i67;
        long j15 = j13 * j14;
        long j16 = j14;
        long j17 = (long) i17;
        long j18 = j13;
        long j19 = (long) i30;
        long j21 = (long) i16;
        long j22 = j17;
        long j23 = (long) i31;
        long j24 = j21;
        long j25 = (long) i15;
        long j26 = j15 + (j17 * j19) + (j21 * j23) + (j25 * j25);
        long j27 = j25;
        long j28 = (long) i43;
        long j29 = j23;
        long j30 = (long) i27;
        long j31 = j19;
        long j32 = (long) i36;
        long j33 = j30 * j32;
        int i69 = i54 * 2;
        long j34 = (long) i26;
        long j35 = j32;
        long j36 = (long) i37;
        long j37 = j33 + (j34 * j36);
        long j38 = j34;
        long j39 = (long) i25;
        long j40 = j36;
        long j41 = (long) i38;
        long j42 = j37 + (j39 * j41);
        long j43 = j39;
        long j44 = (long) i24;
        long j45 = j44;
        long j46 = (long) i42;
        long j47 = j41;
        long j48 = (long) (i18 + i27);
        long j49 = ((long) i57) & 4294967295L;
        long j50 = j48 * j49;
        long j51 = (long) i54;
        long j52 = j49;
        long j53 = ((long) i68) & 4294967295L;
        long j54 = j50 + (j51 * j53);
        long j55 = j51;
        long j56 = (long) i65;
        int i70 = i69;
        long j57 = ((long) i61) & 4294967295L;
        int i71 = i66;
        long j58 = j56;
        long j59 = (long) i71;
        long j60 = j54 + (j56 * j57) + (j59 * j59);
        long j61 = ((j12 + (j28 * j28)) + j60) - j26;
        long j62 = (((j42 + (j44 * j44)) + (j46 * j46)) - j12) + j60;
        int i72 = ((int) j61) & M28;
        int i73 = ((int) j62) & M28;
        int i74 = i55;
        long j63 = j59;
        long j64 = (long) i74;
        long j65 = j62 >>> 28;
        long j66 = (long) i28;
        long j67 = j64 * j66;
        long j68 = j64;
        long j69 = (long) i32;
        long j70 = (j18 * j31) + (j22 * j29) + (j24 * j69);
        long j71 = j69;
        long j72 = (long) i45;
        long j73 = j66;
        long j74 = (long) i35;
        long j75 = j72 * j74;
        long j76 = (j30 * j40) + (j38 * j47);
        long j77 = j30;
        long j78 = (long) i39;
        long j79 = j76 + (j43 * j78);
        long j80 = j78;
        long j81 = (long) i58;
        int i75 = i56;
        long j82 = j72;
        long j83 = ((long) i75) & 4294967295L;
        long j84 = (j48 * j53) + (j55 * j57);
        long j85 = j53;
        long j86 = ((long) i63) & 4294967295L;
        long j87 = j84 + (j58 * j86);
        long j88 = (j61 >>> 28) + (((j67 + j75) + j87) - j70);
        int i76 = i70;
        long j89 = j65 + ((j79 + (j81 * j83)) - j67) + j87;
        long j90 = j89 >>> 28;
        int i77 = ((int) j88) & M28;
        long j91 = (long) i53;
        long j92 = (j91 * j73) + (j68 * j68);
        long j93 = j91;
        long j94 = (long) i47;
        long j95 = (j94 * j74) + (j82 * j82);
        long j96 = j94;
        long j97 = (long) i60;
        long j98 = (j97 * j83) + (j81 * j81);
        long j99 = (j48 * j57) + (j55 * j86) + (j58 * j58);
        long j100 = ((j92 + j95) + j99) - (((j18 * j29) + (j22 * j71)) + (j24 * j24));
        long j101 = j57;
        int i78 = ((int) j89) & M28;
        long j102 = (j88 >>> 28) + j100;
        long j103 = j90 + (((((j77 * j47) + (j38 * j80)) + (j43 * j43)) + j98) - j92) + j99;
        int i79 = ((int) j102) & M28;
        int i80 = ((int) j103) & M28;
        int i81 = i51;
        int i82 = i78;
        long j104 = (long) i81;
        long j105 = (j104 * j73) + (j93 * j16);
        long j106 = j104;
        long j107 = (long) i33;
        long j108 = (j18 * j71) + (j22 * j107);
        long j109 = j107;
        long j110 = (long) i49;
        long j111 = (j110 * j74) + (j96 * j35);
        long j112 = j77 * j80;
        long j113 = j110;
        long j114 = (long) i40;
        long j115 = j112 + (j38 * j114);
        long j116 = j114;
        long j117 = (long) i62;
        long j118 = j86 * j48;
        long j119 = j48;
        long j120 = ((long) i64) & 4294967295L;
        long j121 = j118 + (j55 * j120);
        long j122 = (j102 >>> 28) + (((j105 + j111) + j121) - j108);
        long j123 = j120;
        int i83 = ((int) j122) & M28;
        long j124 = (j103 >>> 28) + ((j115 + ((j117 * j83) + (j97 * j52))) - j105) + j121;
        long j125 = (j27 * j73) + (j106 * j16) + (j93 * j93);
        long j126 = (j63 * j83) + (j117 * j52) + (j97 * j97);
        long j127 = (j119 * j123) + (j55 * j55);
        long j128 = (j122 >>> 28) + (((j125 + (((j45 * j74) + (j113 * j35)) + (j96 * j96))) + j127) - ((j18 * j109) + (j22 * j22)));
        int i84 = ((int) j124) & M28;
        int i85 = ((int) j128) & M28;
        long j129 = (j124 >>> 28) + ((((j77 * j116) + (j38 * j38)) + j126) - j125) + j127;
        long j130 = (j24 * j73) + (j27 * j16) + (j106 * j31);
        int i86 = i34;
        int i87 = ((int) j129) & M28;
        int i88 = i85;
        int i89 = i41;
        int i90 = i83;
        long j131 = (j58 * j83) + (j63 * j52) + (j117 * j85);
        long j132 = j117;
        long j133 = (((long) i76) & 4294967295L) * j119;
        long j134 = (j128 >>> 28) + (((j130 + (((j43 * j74) + (j45 * j35)) + (j113 * j40))) + j133) - (((long) i86) * j18));
        int i91 = ((int) j134) & M28;
        long j135 = (j129 >>> 28) + (((((long) i89) * j77) + j131) - j130) + j133;
        int i92 = ((int) j135) & M28;
        long j136 = (j22 * j73) + (j24 * j16) + (j27 * j31) + (j106 * j106);
        long j137 = (j55 * j83) + (j58 * j52) + (j63 * j85) + (j132 * j132);
        long j138 = j119 * j119;
        long j139 = (j134 >>> 28) + (((j136 + ((((j38 * j74) + (j43 * j35)) + (j45 * j40)) + (j113 * j113))) + j138) - (j18 * j18));
        int i93 = ((int) j139) & M28;
        long j140 = (j135 >>> 28) + (((j77 * j77) + j137) - j136) + j138;
        int i94 = ((int) j140) & M28;
        long j141 = (j18 * j73) + (j22 * j16) + (j24 * j31) + (j27 * j29);
        long j142 = (j139 >>> 28) + (j74 * j77) + (j38 * j35) + (j43 * j40) + (j45 * j47) + j141;
        int i95 = ((int) j142) & M28;
        long j143 = (j140 >>> 28) + (((((j83 * j119) + (j55 * j52)) + (j58 * j85)) + (j63 * j101)) - j141);
        int i96 = ((int) j143) & M28;
        long j144 = j143 >>> 28;
        long j145 = (j142 >>> 28) + j144 + ((long) i73);
        int i97 = ((int) j145) & M28;
        long j146 = j144 + ((long) i72);
        iArr2[0] = ((int) j146) & M28;
        iArr2[1] = i77 + ((int) (j146 >>> 28));
        iArr2[2] = i79;
        iArr2[3] = i90;
        iArr2[4] = i88;
        iArr2[5] = i91;
        iArr2[6] = i93;
        iArr2[7] = i95;
        iArr2[8] = i97;
        iArr2[9] = i82 + ((int) (j145 >>> 28));
        iArr2[10] = i80;
        iArr2[11] = i84;
        iArr2[12] = i87;
        iArr2[13] = i92;
        iArr2[14] = i94;
        iArr2[15] = i96;
    }

    public static boolean sqrtRatioVar(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] create = create();
        int[] create2 = create();
        sqr(iArr, create);
        mul(create, iArr2, create);
        sqr(create, create2);
        mul(create, iArr, create);
        mul(create2, iArr, create2);
        mul(create2, iArr2, create2);
        int[] create3 = create();
        powPm3d4(create2, create3);
        mul(create3, create, create3);
        int[] create4 = create();
        sqr(create3, create4);
        mul(create4, iArr2, create4);
        sub(iArr, create4, create4);
        normalize(create4);
        if (!isZeroVar(create4)) {
            return false;
        }
        copy(create3, 0, iArr3, 0);
        return true;
    }

    public static void sub(int[] iArr, int[] iArr2, int[] iArr3) {
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
        int i22 = iArr[10];
        int i23 = iArr[11];
        int i24 = iArr[12];
        int i25 = iArr[13];
        int i26 = iArr[14];
        int i27 = iArr[15];
        int i28 = iArr2[0];
        int i29 = iArr2[1];
        int i30 = iArr2[2];
        int i31 = iArr2[3];
        int i32 = iArr2[4];
        int i33 = iArr2[5];
        int i34 = iArr2[6];
        int i35 = iArr2[7];
        int i36 = iArr2[8];
        int i37 = iArr2[9];
        int i38 = iArr2[10];
        int i39 = iArr2[11];
        int i40 = iArr2[12];
        int i41 = iArr2[13];
        int i42 = iArr2[14];
        int i43 = (i12 + 536870910) - i29;
        int i44 = (i16 + 536870910) - i33;
        int i45 = (i21 + 536870910) - i37;
        int i46 = (i25 + 536870910) - i41;
        int i47 = ((i13 + 536870910) - i30) + (i43 >>> 28);
        int i48 = i43 & M28;
        int i49 = ((i17 + 536870910) - i34) + (i44 >>> 28);
        int i50 = i44 & M28;
        int i51 = ((i22 + 536870910) - i38) + (i45 >>> 28);
        int i52 = i45 & M28;
        int i53 = ((i26 + 536870910) - i42) + (i46 >>> 28);
        int i54 = i46 & M28;
        int i55 = ((i14 + 536870910) - i31) + (i47 >>> 28);
        int i56 = i47 & M28;
        int i57 = ((i18 + 536870910) - i35) + (i49 >>> 28);
        int i58 = i49 & M28;
        int i59 = ((i23 + 536870910) - i39) + (i51 >>> 28);
        int i60 = i51 & M28;
        int i61 = ((i27 + 536870910) - iArr2[15]) + (i53 >>> 28);
        int i62 = i53 & M28;
        int i63 = i61 >>> 28;
        int i64 = i61 & M28;
        int i65 = ((i11 + 536870910) - i28) + i63;
        int i66 = ((i15 + 536870910) - i32) + (i55 >>> 28);
        int i67 = i55 & M28;
        int i68 = ((i19 + 536870908) - i36) + i63 + (i57 >>> 28);
        int i69 = i57 & M28;
        int i70 = ((i24 + 536870910) - i40) + (i59 >>> 28);
        int i71 = i59 & M28;
        int i72 = i48 + (i65 >>> 28);
        int i73 = i65 & M28;
        int i74 = i50 + (i66 >>> 28);
        int i75 = i66 & M28;
        int i76 = i52 + (i68 >>> 28);
        int i77 = i68 & M28;
        int i78 = i70 & M28;
        iArr3[0] = i73;
        iArr3[1] = i72;
        iArr3[2] = i56;
        iArr3[3] = i67;
        iArr3[4] = i75;
        iArr3[5] = i74;
        iArr3[6] = i58;
        iArr3[7] = i69;
        iArr3[8] = i77;
        iArr3[9] = i76;
        iArr3[10] = i60;
        iArr3[11] = i71;
        iArr3[12] = i78;
        iArr3[13] = i54 + (i70 >>> 28);
        iArr3[14] = i62;
        iArr3[15] = i64;
    }

    public static void subOne(int[] iArr) {
        int[] create = create();
        create[0] = 1;
        sub(iArr, create, iArr);
    }

    public static void zero(int[] iArr) {
        for (int i11 = 0; i11 < 16; i11++) {
            iArr[i11] = 0;
        }
    }
}
