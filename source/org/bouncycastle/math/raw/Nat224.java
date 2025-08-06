package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

public abstract class Nat224 {
    private static final long M = 4294967295L;

    public static int add(int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j11 = (((long) iArr[i11 + 0]) & 4294967295L) + (((long) iArr2[i12 + 0]) & 4294967295L) + 0;
        iArr3[i13 + 0] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[i11 + 1]) & 4294967295L) + (((long) iArr2[i12 + 1]) & 4294967295L);
        iArr3[i13 + 1] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[i11 + 2]) & 4294967295L) + (((long) iArr2[i12 + 2]) & 4294967295L);
        iArr3[i13 + 2] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[i11 + 3]) & 4294967295L) + (((long) iArr2[i12 + 3]) & 4294967295L);
        iArr3[i13 + 3] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[i11 + 4]) & 4294967295L) + (((long) iArr2[i12 + 4]) & 4294967295L);
        iArr3[i13 + 4] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[i11 + 5]) & 4294967295L) + (((long) iArr2[i12 + 5]) & 4294967295L);
        iArr3[i13 + 5] = (int) j16;
        long j17 = (j16 >>> 32) + (((long) iArr[i11 + 6]) & 4294967295L) + (((long) iArr2[i12 + 6]) & 4294967295L);
        iArr3[i13 + 6] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int add(int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr3[1] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr3[2] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr3[3] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L);
        iArr3[4] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L);
        iArr3[5] = (int) j16;
        long j17 = (j16 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L);
        iArr3[6] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int addBothTo(int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        int i14 = i13 + 0;
        long j11 = (((long) iArr[i11 + 0]) & 4294967295L) + (((long) iArr2[i12 + 0]) & 4294967295L) + (((long) iArr3[i14]) & 4294967295L) + 0;
        iArr3[i14] = (int) j11;
        int i15 = i13 + 1;
        long j12 = (j11 >>> 32) + (((long) iArr[i11 + 1]) & 4294967295L) + (((long) iArr2[i12 + 1]) & 4294967295L) + (((long) iArr3[i15]) & 4294967295L);
        iArr3[i15] = (int) j12;
        int i16 = i13 + 2;
        long j13 = (j12 >>> 32) + (((long) iArr[i11 + 2]) & 4294967295L) + (((long) iArr2[i12 + 2]) & 4294967295L) + (((long) iArr3[i16]) & 4294967295L);
        iArr3[i16] = (int) j13;
        int i17 = i13 + 3;
        long j14 = (j13 >>> 32) + (((long) iArr[i11 + 3]) & 4294967295L) + (((long) iArr2[i12 + 3]) & 4294967295L) + (((long) iArr3[i17]) & 4294967295L);
        iArr3[i17] = (int) j14;
        int i18 = i13 + 4;
        long j15 = (j14 >>> 32) + (((long) iArr[i11 + 4]) & 4294967295L) + (((long) iArr2[i12 + 4]) & 4294967295L) + (((long) iArr3[i18]) & 4294967295L);
        iArr3[i18] = (int) j15;
        int i19 = i13 + 5;
        long j16 = (j15 >>> 32) + (((long) iArr[i11 + 5]) & 4294967295L) + (((long) iArr2[i12 + 5]) & 4294967295L) + (((long) iArr3[i19]) & 4294967295L);
        iArr3[i19] = (int) j16;
        int i21 = i13 + 6;
        long j17 = (j16 >>> 32) + (((long) iArr[i11 + 6]) & 4294967295L) + (((long) iArr2[i12 + 6]) & 4294967295L) + (((long) iArr3[i21]) & 4294967295L);
        iArr3[i21] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int addBothTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + (((long) iArr3[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (((long) iArr3[1]) & 4294967295L);
        iArr3[1] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (((long) iArr3[2]) & 4294967295L);
        iArr3[2] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (((long) iArr3[3]) & 4294967295L);
        iArr3[3] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (((long) iArr3[4]) & 4294967295L);
        iArr3[4] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (((long) iArr3[5]) & 4294967295L);
        iArr3[5] = (int) j16;
        long j17 = (j16 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L) + (((long) iArr3[6]) & 4294967295L);
        iArr3[6] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int addTo(int[] iArr, int i11, int[] iArr2, int i12, int i13) {
        int i14 = i12 + 0;
        long j11 = (((long) i13) & 4294967295L) + (((long) iArr[i11 + 0]) & 4294967295L) + (((long) iArr2[i14]) & 4294967295L);
        iArr2[i14] = (int) j11;
        int i15 = i12 + 1;
        long j12 = (j11 >>> 32) + (((long) iArr[i11 + 1]) & 4294967295L) + (((long) iArr2[i15]) & 4294967295L);
        iArr2[i15] = (int) j12;
        int i16 = i12 + 2;
        long j13 = (j12 >>> 32) + (((long) iArr[i11 + 2]) & 4294967295L) + (((long) iArr2[i16]) & 4294967295L);
        iArr2[i16] = (int) j13;
        int i17 = i12 + 3;
        long j14 = (j13 >>> 32) + (((long) iArr[i11 + 3]) & 4294967295L) + (((long) iArr2[i17]) & 4294967295L);
        iArr2[i17] = (int) j14;
        int i18 = i12 + 4;
        long j15 = (j14 >>> 32) + (((long) iArr[i11 + 4]) & 4294967295L) + (((long) iArr2[i18]) & 4294967295L);
        iArr2[i18] = (int) j15;
        int i19 = i12 + 5;
        long j16 = (j15 >>> 32) + (((long) iArr[i11 + 5]) & 4294967295L) + (((long) iArr2[i19]) & 4294967295L);
        iArr2[i19] = (int) j16;
        int i21 = i12 + 6;
        long j17 = (j16 >>> 32) + (((long) iArr[i11 + 6]) & 4294967295L) + (4294967295L & ((long) iArr2[i21]));
        iArr2[i21] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j11 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr2[1] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr2[2] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr2[3] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L);
        iArr2[4] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L);
        iArr2[5] = (int) j16;
        long j17 = (j16 >>> 32) + (((long) iArr[6]) & 4294967295L) + (4294967295L & ((long) iArr2[6]));
        iArr2[6] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int addToEachOther(int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = i11 + 0;
        int i14 = i12 + 0;
        long j11 = (((long) iArr[i13]) & 4294967295L) + (((long) iArr2[i14]) & 4294967295L) + 0;
        int i15 = (int) j11;
        iArr[i13] = i15;
        iArr2[i14] = i15;
        int i16 = i11 + 1;
        int i17 = i12 + 1;
        long j12 = (j11 >>> 32) + (((long) iArr[i16]) & 4294967295L) + (((long) iArr2[i17]) & 4294967295L);
        int i18 = (int) j12;
        iArr[i16] = i18;
        iArr2[i17] = i18;
        int i19 = i11 + 2;
        int i21 = i12 + 2;
        long j13 = (j12 >>> 32) + (((long) iArr[i19]) & 4294967295L) + (((long) iArr2[i21]) & 4294967295L);
        int i22 = (int) j13;
        iArr[i19] = i22;
        iArr2[i21] = i22;
        int i23 = i11 + 3;
        int i24 = i12 + 3;
        long j14 = (j13 >>> 32) + (((long) iArr[i23]) & 4294967295L) + (((long) iArr2[i24]) & 4294967295L);
        int i25 = (int) j14;
        iArr[i23] = i25;
        iArr2[i24] = i25;
        int i26 = i11 + 4;
        int i27 = i12 + 4;
        long j15 = (j14 >>> 32) + (((long) iArr[i26]) & 4294967295L) + (((long) iArr2[i27]) & 4294967295L);
        int i28 = (int) j15;
        iArr[i26] = i28;
        iArr2[i27] = i28;
        int i29 = i11 + 5;
        int i30 = i12 + 5;
        long j16 = (j15 >>> 32) + (((long) iArr[i29]) & 4294967295L) + (((long) iArr2[i30]) & 4294967295L);
        int i31 = (int) j16;
        iArr[i29] = i31;
        iArr2[i30] = i31;
        int i32 = i11 + 6;
        int i33 = i12 + 6;
        long j17 = (j16 >>> 32) + (((long) iArr[i32]) & 4294967295L) + (4294967295L & ((long) iArr2[i33]));
        int i34 = (int) j17;
        iArr[i32] = i34;
        iArr2[i33] = i34;
        return (int) (j17 >>> 32);
    }

    public static void copy(int[] iArr, int i11, int[] iArr2, int i12) {
        iArr2[i12 + 0] = iArr[i11 + 0];
        iArr2[i12 + 1] = iArr[i11 + 1];
        iArr2[i12 + 2] = iArr[i11 + 2];
        iArr2[i12 + 3] = iArr[i11 + 3];
        iArr2[i12 + 4] = iArr[i11 + 4];
        iArr2[i12 + 5] = iArr[i11 + 5];
        iArr2[i12 + 6] = iArr[i11 + 6];
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
    }

    public static int[] create() {
        return new int[7];
    }

    public static int[] createExt() {
        return new int[14];
    }

    public static boolean diff(int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        boolean gte = gte(iArr, i11, iArr2, i12);
        if (gte) {
            sub(iArr, i11, iArr2, i12, iArr3, i13);
        } else {
            sub(iArr2, i12, iArr, i11, iArr3, i13);
        }
        return gte;
    }

    public static boolean eq(int[] iArr, int[] iArr2) {
        for (int i11 = 6; i11 >= 0; i11--) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 224) {
            throw new IllegalArgumentException();
        }
        int[] create = create();
        for (int i11 = 0; i11 < 7; i11++) {
            create[i11] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return create;
    }

    public static int getBit(int[] iArr, int i11) {
        int i12;
        if (i11 == 0) {
            i12 = iArr[0];
        } else {
            int i13 = i11 >> 5;
            if (i13 < 0 || i13 >= 7) {
                return 0;
            }
            i12 = iArr[i13] >>> (i11 & 31);
        }
        return i12 & 1;
    }

    public static boolean gte(int[] iArr, int i11, int[] iArr2, int i12) {
        for (int i13 = 6; i13 >= 0; i13--) {
            int i14 = iArr[i11 + i13] ^ Integer.MIN_VALUE;
            int i15 = Integer.MIN_VALUE ^ iArr2[i12 + i13];
            if (i14 < i15) {
                return false;
            }
            if (i14 > i15) {
                return true;
            }
        }
        return true;
    }

    public static boolean gte(int[] iArr, int[] iArr2) {
        for (int i11 = 6; i11 >= 0; i11--) {
            int i12 = iArr[i11] ^ Integer.MIN_VALUE;
            int i13 = Integer.MIN_VALUE ^ iArr2[i11];
            if (i12 < i13) {
                return false;
            }
            if (i12 > i13) {
                return true;
            }
        }
        return true;
    }

    public static boolean isOne(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i11 = 1; i11 < 7; i11++) {
            if (iArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i11 = 0; i11 < 7; i11++) {
            if (iArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void mul(int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j11 = ((long) iArr2[i12 + 0]) & 4294967295L;
        long j12 = ((long) iArr2[i12 + 1]) & 4294967295L;
        long j13 = ((long) iArr2[i12 + 2]) & 4294967295L;
        long j14 = ((long) iArr2[i12 + 3]) & 4294967295L;
        long j15 = ((long) iArr2[i12 + 4]) & 4294967295L;
        long j16 = ((long) iArr2[i12 + 5]) & 4294967295L;
        long j17 = ((long) iArr2[i12 + 6]) & 4294967295L;
        long j18 = ((long) iArr[i11 + 0]) & 4294967295L;
        long j19 = (j18 * j11) + 0;
        long j21 = j11;
        iArr3[i13 + 0] = (int) j19;
        long j22 = (j19 >>> 32) + (j18 * j12);
        long j23 = j12;
        iArr3[i13 + 1] = (int) j22;
        long j24 = (j22 >>> 32) + (j18 * j13);
        iArr3[i13 + 2] = (int) j24;
        long j25 = (j24 >>> 32) + (j18 * j14);
        iArr3[i13 + 3] = (int) j25;
        long j26 = (j25 >>> 32) + (j18 * j15);
        iArr3[i13 + 4] = (int) j26;
        long j27 = (j26 >>> 32) + (j18 * j16);
        iArr3[i13 + 5] = (int) j27;
        long j28 = j17;
        long j29 = (j27 >>> 32) + (j18 * j28);
        iArr3[i13 + 6] = (int) j29;
        iArr3[i13 + 7] = (int) (j29 >>> 32);
        int i14 = 1;
        int i15 = i13;
        int i16 = 1;
        while (i16 < 7) {
            i15 += i14;
            long j30 = ((long) iArr[i11 + i16]) & 4294967295L;
            int i17 = i15 + 0;
            long j31 = (j30 * j21) + (((long) iArr3[i17]) & 4294967295L) + 0;
            iArr3[i17] = (int) j31;
            int i18 = i15 + 1;
            long j32 = j28;
            long j33 = (j31 >>> 32) + (j30 * j23) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j33;
            int i19 = i15 + 2;
            long j34 = j13;
            long j35 = (j33 >>> 32) + (j30 * j13) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j35;
            int i21 = i15 + 3;
            long j36 = (j35 >>> 32) + (j30 * j14) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j36;
            int i22 = i15 + 4;
            long j37 = (j36 >>> 32) + (j30 * j15) + (((long) iArr3[i22]) & 4294967295L);
            iArr3[i22] = (int) j37;
            int i23 = i15 + 5;
            long j38 = (j37 >>> 32) + (j30 * j16) + (((long) iArr3[i23]) & 4294967295L);
            iArr3[i23] = (int) j38;
            int i24 = i15 + 6;
            long j39 = (j38 >>> 32) + (j30 * j32) + (((long) iArr3[i24]) & 4294967295L);
            iArr3[i24] = (int) j39;
            iArr3[i15 + 7] = (int) (j39 >>> 32);
            i16++;
            j13 = j34;
            j28 = j32;
            j14 = j14;
            i14 = 1;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = ((long) iArr2[0]) & 4294967295L;
        long j12 = ((long) iArr2[1]) & 4294967295L;
        long j13 = ((long) iArr2[3]) & 4294967295L;
        long j14 = ((long) iArr2[4]) & 4294967295L;
        long j15 = ((long) iArr2[2]) & 4294967295L;
        long j16 = ((long) iArr2[5]) & 4294967295L;
        long j17 = ((long) iArr2[6]) & 4294967295L;
        long j18 = ((long) iArr[0]) & 4294967295L;
        long j19 = (j18 * j11) + 0;
        iArr3[0] = (int) j19;
        long j21 = (j19 >>> 32) + (j18 * j12);
        iArr3[1] = (int) j21;
        long j22 = (j21 >>> 32) + (j18 * j15);
        iArr3[2] = (int) j22;
        long j23 = (j22 >>> 32) + (j18 * j13);
        iArr3[3] = (int) j23;
        long j24 = (j23 >>> 32) + (j18 * j14);
        iArr3[4] = (int) j24;
        long j25 = (j24 >>> 32) + (j18 * j16);
        iArr3[5] = (int) j25;
        long j26 = (j25 >>> 32) + (j18 * j17);
        iArr3[6] = (int) j26;
        iArr3[7] = (int) (j26 >>> 32);
        int i11 = 1;
        for (int i12 = 7; i11 < i12; i12 = 7) {
            long j27 = ((long) iArr[i11]) & 4294967295L;
            int i13 = i11 + 0;
            long j28 = (j27 * j11) + (((long) iArr3[i13]) & 4294967295L) + 0;
            iArr3[i13] = (int) j28;
            int i14 = i11 + 1;
            long j29 = j12;
            long j30 = (j28 >>> 32) + (j27 * j12) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j30;
            int i15 = i11 + 2;
            long j31 = j16;
            long j32 = (j30 >>> 32) + (j27 * j15) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j32;
            int i16 = i11 + 3;
            long j33 = (j32 >>> 32) + (j27 * j13) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j33;
            int i17 = i11 + 4;
            long j34 = (j33 >>> 32) + (j27 * j14) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j34;
            int i18 = i11 + 5;
            long j35 = (j34 >>> 32) + (j27 * j31) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j35;
            int i19 = i11 + 6;
            long j36 = (j35 >>> 32) + (j27 * j17) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j36;
            iArr3[i11 + 7] = (int) (j36 >>> 32);
            i11 = i14;
            j11 = j11;
            j12 = j29;
            j16 = j31;
        }
    }

    public static long mul33Add(int i11, int[] iArr, int i12, int[] iArr2, int i13, int[] iArr3, int i14) {
        long j11 = ((long) i11) & 4294967295L;
        long j12 = ((long) iArr[i12 + 0]) & 4294967295L;
        long j13 = (j11 * j12) + (((long) iArr2[i13 + 0]) & 4294967295L) + 0;
        iArr3[i14 + 0] = (int) j13;
        long j14 = ((long) iArr[i12 + 1]) & 4294967295L;
        long j15 = (j13 >>> 32) + (j11 * j14) + j12 + (((long) iArr2[i13 + 1]) & 4294967295L);
        iArr3[i14 + 1] = (int) j15;
        long j16 = j15 >>> 32;
        long j17 = ((long) iArr[i12 + 2]) & 4294967295L;
        long j18 = j16 + (j11 * j17) + j14 + (((long) iArr2[i13 + 2]) & 4294967295L);
        iArr3[i14 + 2] = (int) j18;
        long j19 = ((long) iArr[i12 + 3]) & 4294967295L;
        long j21 = (j18 >>> 32) + (j11 * j19) + j17 + (((long) iArr2[i13 + 3]) & 4294967295L);
        iArr3[i14 + 3] = (int) j21;
        long j22 = ((long) iArr[i12 + 4]) & 4294967295L;
        long j23 = (j21 >>> 32) + (j11 * j22) + j19 + (((long) iArr2[i13 + 4]) & 4294967295L);
        iArr3[i14 + 4] = (int) j23;
        long j24 = ((long) iArr[i12 + 5]) & 4294967295L;
        long j25 = (j23 >>> 32) + (j11 * j24) + j22 + (((long) iArr2[i13 + 5]) & 4294967295L);
        iArr3[i14 + 5] = (int) j25;
        long j26 = ((long) iArr[i12 + 6]) & 4294967295L;
        long j27 = (j25 >>> 32) + (j11 * j26) + j24 + (4294967295L & ((long) iArr2[i13 + 6]));
        iArr3[i14 + 6] = (int) j27;
        return (j27 >>> 32) + j26;
    }

    public static int mul33DWordAdd(int i11, long j11, int[] iArr, int i12) {
        int[] iArr2 = iArr;
        int i13 = i12;
        long j12 = ((long) i11) & 4294967295L;
        long j13 = j11 & 4294967295L;
        int i14 = i13 + 0;
        long j14 = (j12 * j13) + (((long) iArr2[i14]) & 4294967295L) + 0;
        iArr2[i14] = (int) j14;
        long j15 = j11 >>> 32;
        long j16 = (j12 * j15) + j13;
        int i15 = i13 + 1;
        long j17 = (j14 >>> 32) + j16 + (((long) iArr2[i15]) & 4294967295L);
        iArr2[i15] = (int) j17;
        int i16 = i13 + 2;
        long j18 = (j17 >>> 32) + j15 + (((long) iArr2[i16]) & 4294967295L);
        iArr2[i16] = (int) j18;
        int i17 = i13 + 3;
        long j19 = (j18 >>> 32) + (4294967295L & ((long) iArr2[i17]));
        iArr2[i17] = (int) j19;
        if ((j19 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(7, iArr2, i13, 4);
    }

    public static int mul33WordAdd(int i11, int i12, int[] iArr, int i13) {
        long j11 = ((long) i12) & 4294967295L;
        int i14 = i13 + 0;
        long j12 = ((((long) i11) & 4294967295L) * j11) + (((long) iArr[i14]) & 4294967295L) + 0;
        iArr[i14] = (int) j12;
        int i15 = i13 + 1;
        long j13 = (j12 >>> 32) + j11 + (((long) iArr[i15]) & 4294967295L);
        iArr[i15] = (int) j13;
        long j14 = j13 >>> 32;
        int i16 = i13 + 2;
        long j15 = j14 + (((long) iArr[i16]) & 4294967295L);
        iArr[i16] = (int) j15;
        if ((j15 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(7, iArr, i13, 3);
    }

    public static int mulAddTo(int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j11 = ((long) iArr2[i12 + 0]) & 4294967295L;
        long j12 = ((long) iArr2[i12 + 1]) & 4294967295L;
        long j13 = ((long) iArr2[i12 + 2]) & 4294967295L;
        long j14 = ((long) iArr2[i12 + 3]) & 4294967295L;
        long j15 = ((long) iArr2[i12 + 4]) & 4294967295L;
        long j16 = ((long) iArr2[i12 + 5]) & 4294967295L;
        long j17 = ((long) iArr2[i12 + 6]) & 4294967295L;
        long j18 = 0;
        int i14 = 0;
        int i15 = i13;
        while (i14 < 7) {
            int i16 = i14;
            long j19 = ((long) iArr[i11 + i14]) & 4294967295L;
            int i17 = i15 + 0;
            long j21 = j11;
            long j22 = (j19 * j11) + (((long) iArr3[i17]) & 4294967295L) + 0;
            long j23 = j17;
            iArr3[i17] = (int) j22;
            int i18 = i15 + 1;
            long j24 = (j22 >>> 32) + (j19 * j12) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j24;
            int i19 = i15 + 2;
            long j25 = (j24 >>> 32) + (j19 * j13) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j25;
            int i21 = i15 + 3;
            long j26 = (j25 >>> 32) + (j19 * j14) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j26;
            int i22 = i15 + 4;
            long j27 = (j26 >>> 32) + (j19 * j15) + (((long) iArr3[i22]) & 4294967295L);
            iArr3[i22] = (int) j27;
            int i23 = i15 + 5;
            long j28 = (j27 >>> 32) + (j19 * j16) + (((long) iArr3[i23]) & 4294967295L);
            iArr3[i23] = (int) j28;
            int i24 = i15 + 6;
            long j29 = (j28 >>> 32) + (j19 * j23) + (((long) iArr3[i24]) & 4294967295L);
            iArr3[i24] = (int) j29;
            int i25 = i15 + 7;
            long j30 = (j29 >>> 32) + (((long) iArr3[i25]) & 4294967295L) + j18;
            iArr3[i25] = (int) j30;
            j18 = j30 >>> 32;
            i14 = i16 + 1;
            i15 = i18;
            j17 = j23;
            j11 = j21;
            j12 = j12;
        }
        return (int) j18;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[2]) & 4294967295L;
        long j13 = ((long) iArr2[3]) & 4294967295L;
        long j14 = ((long) iArr2[4]) & 4294967295L;
        long j15 = ((long) iArr2[5]) & 4294967295L;
        long j16 = ((long) iArr2[0]) & 4294967295L;
        long j17 = ((long) iArr2[6]) & 4294967295L;
        long j18 = 0;
        int i11 = 0;
        while (i11 < 7) {
            long j19 = j17;
            long j21 = ((long) iArr[i11]) & 4294967295L;
            int i12 = i11 + 0;
            long j22 = j15;
            long j23 = (j21 * j16) + (((long) iArr3[i12]) & 4294967295L) + 0;
            iArr3[i12] = (int) j23;
            int i13 = i11 + 1;
            long j24 = j11;
            long j25 = (j23 >>> 32) + (j21 * j11) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j25;
            int i14 = i11 + 2;
            long j26 = (j25 >>> 32) + (j21 * j12) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j26;
            int i15 = i11 + 3;
            long j27 = (j26 >>> 32) + (j21 * j13) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j27;
            int i16 = i11 + 4;
            long j28 = (j27 >>> 32) + (j21 * j14) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j28;
            int i17 = i11 + 5;
            long j29 = (j28 >>> 32) + (j21 * j22) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j29;
            int i18 = i11 + 6;
            long j30 = (j29 >>> 32) + (j21 * j19) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j30;
            int i19 = i11 + 7;
            long j31 = (j30 >>> 32) + (((long) iArr3[i19]) & 4294967295L) + j18;
            iArr3[i19] = (int) j31;
            j18 = j31 >>> 32;
            i11 = i13;
            j17 = j19;
            j15 = j22;
            j11 = j24;
        }
        return (int) j18;
    }

    public static int mulByWord(int i11, int[] iArr) {
        long j11 = ((long) i11) & 4294967295L;
        long j12 = ((((long) iArr[0]) & 4294967295L) * j11) + 0;
        iArr[0] = (int) j12;
        long j13 = (j12 >>> 32) + ((((long) iArr[1]) & 4294967295L) * j11);
        iArr[1] = (int) j13;
        long j14 = (j13 >>> 32) + ((((long) iArr[2]) & 4294967295L) * j11);
        iArr[2] = (int) j14;
        long j15 = (j14 >>> 32) + ((((long) iArr[3]) & 4294967295L) * j11);
        iArr[3] = (int) j15;
        long j16 = (j15 >>> 32) + ((((long) iArr[4]) & 4294967295L) * j11);
        iArr[4] = (int) j16;
        long j17 = (j16 >>> 32) + ((((long) iArr[5]) & 4294967295L) * j11);
        iArr[5] = (int) j17;
        long j18 = (j17 >>> 32) + (j11 * (4294967295L & ((long) iArr[6])));
        iArr[6] = (int) j18;
        return (int) (j18 >>> 32);
    }

    public static int mulByWordAddTo(int i11, int[] iArr, int[] iArr2) {
        long j11 = ((long) i11) & 4294967295L;
        long j12 = ((((long) iArr2[0]) & 4294967295L) * j11) + (((long) iArr[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j12;
        long j13 = (j12 >>> 32) + ((((long) iArr2[1]) & 4294967295L) * j11) + (((long) iArr[1]) & 4294967295L);
        iArr2[1] = (int) j13;
        long j14 = (j13 >>> 32) + ((((long) iArr2[2]) & 4294967295L) * j11) + (((long) iArr[2]) & 4294967295L);
        iArr2[2] = (int) j14;
        long j15 = (j14 >>> 32) + ((((long) iArr2[3]) & 4294967295L) * j11) + (((long) iArr[3]) & 4294967295L);
        iArr2[3] = (int) j15;
        long j16 = (j15 >>> 32) + ((((long) iArr2[4]) & 4294967295L) * j11) + (((long) iArr[4]) & 4294967295L);
        iArr2[4] = (int) j16;
        long j17 = (j16 >>> 32) + ((((long) iArr2[5]) & 4294967295L) * j11) + (((long) iArr[5]) & 4294967295L);
        iArr2[5] = (int) j17;
        long j18 = (j17 >>> 32) + (j11 * (((long) iArr2[6]) & 4294967295L)) + (4294967295L & ((long) iArr[6]));
        iArr2[6] = (int) j18;
        return (int) (j18 >>> 32);
    }

    public static int mulWord(int i11, int[] iArr, int[] iArr2, int i12) {
        long j11 = ((long) i11) & 4294967295L;
        long j12 = 0;
        int i13 = 0;
        do {
            long j13 = j12 + ((((long) iArr[i13]) & 4294967295L) * j11);
            iArr2[i12 + i13] = (int) j13;
            j12 = j13 >>> 32;
            i13++;
        } while (i13 < 7);
        return (int) j12;
    }

    public static int mulWordAddTo(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        long j11 = ((long) i11) & 4294967295L;
        int i14 = i13 + 0;
        long j12 = ((((long) iArr[i12 + 0]) & 4294967295L) * j11) + (((long) iArr2[i14]) & 4294967295L) + 0;
        iArr2[i14] = (int) j12;
        int i15 = i13 + 1;
        long j13 = (j12 >>> 32) + ((((long) iArr[i12 + 1]) & 4294967295L) * j11) + (((long) iArr2[i15]) & 4294967295L);
        iArr2[i15] = (int) j13;
        int i16 = i13 + 2;
        long j14 = (j13 >>> 32) + ((((long) iArr[i12 + 2]) & 4294967295L) * j11) + (((long) iArr2[i16]) & 4294967295L);
        iArr2[i16] = (int) j14;
        int i17 = i13 + 3;
        long j15 = (j14 >>> 32) + ((((long) iArr[i12 + 3]) & 4294967295L) * j11) + (((long) iArr2[i17]) & 4294967295L);
        iArr2[i17] = (int) j15;
        int i18 = i13 + 4;
        long j16 = (j15 >>> 32) + ((((long) iArr[i12 + 4]) & 4294967295L) * j11) + (((long) iArr2[i18]) & 4294967295L);
        iArr2[i18] = (int) j16;
        int i19 = i13 + 5;
        long j17 = (j16 >>> 32) + ((((long) iArr[i12 + 5]) & 4294967295L) * j11) + (((long) iArr2[i19]) & 4294967295L);
        iArr2[i19] = (int) j17;
        int i21 = i13 + 6;
        long j18 = (j17 >>> 32) + (j11 * (((long) iArr[i12 + 6]) & 4294967295L)) + (((long) iArr2[i21]) & 4294967295L);
        iArr2[i21] = (int) j18;
        return (int) (j18 >>> 32);
    }

    public static int mulWordDwordAdd(int i11, long j11, int[] iArr, int i12) {
        long j12 = ((long) i11) & 4294967295L;
        int i13 = i12 + 0;
        long j13 = ((j11 & 4294967295L) * j12) + (((long) iArr[i13]) & 4294967295L) + 0;
        iArr[i13] = (int) j13;
        long j14 = j12 * (j11 >>> 32);
        int i14 = i12 + 1;
        long j15 = (j13 >>> 32) + j14 + (((long) iArr[i14]) & 4294967295L);
        iArr[i14] = (int) j15;
        int i15 = i12 + 2;
        long j16 = (j15 >>> 32) + (((long) iArr[i15]) & 4294967295L);
        iArr[i15] = (int) j16;
        if ((j16 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(7, iArr, i12, 3);
    }

    public static void square(int[] iArr, int i11, int[] iArr2, int i12) {
        long j11 = ((long) iArr[i11 + 0]) & 4294967295L;
        int i13 = 0;
        int i14 = 14;
        int i15 = 6;
        while (true) {
            int i16 = i15 - 1;
            long j12 = ((long) iArr[i11 + i15]) & 4294967295L;
            long j13 = j12 * j12;
            int i17 = i14 - 1;
            iArr2[i12 + i17] = (i13 << 31) | ((int) (j13 >>> 33));
            i14 = i17 - 1;
            iArr2[i12 + i14] = (int) (j13 >>> 1);
            i13 = (int) j13;
            if (i16 <= 0) {
                long j14 = j11 * j11;
                iArr2[i12 + 0] = (int) j14;
                long j15 = ((long) iArr[i11 + 1]) & 4294967295L;
                int i18 = i12 + 2;
                long j16 = ((((long) (i13 << 31)) & 4294967295L) | (j14 >>> 33)) + (j15 * j11);
                int i19 = (int) j16;
                iArr2[i12 + 1] = (i19 << 1) | (((int) (j14 >>> 32)) & 1);
                int i21 = i19 >>> 31;
                long j17 = (((long) iArr2[i18]) & 4294967295L) + (j16 >>> 32);
                long j18 = ((long) iArr[i11 + 2]) & 4294967295L;
                int i22 = i12 + 3;
                long j19 = j15;
                int i23 = i12 + 4;
                long j21 = ((long) iArr2[i22]) & 4294967295L;
                long j22 = j17 + (j18 * j11);
                int i24 = (int) j22;
                iArr2[i18] = (i24 << 1) | i21;
                int i25 = i24 >>> 31;
                long j23 = j21 + (j22 >>> 32) + (j18 * j19);
                long j24 = (((long) iArr2[i23]) & 4294967295L) + (j23 >>> 32);
                long j25 = j18;
                long j26 = ((long) iArr[i11 + 3]) & 4294967295L;
                int i26 = i12 + 5;
                long j27 = (((long) iArr2[i26]) & 4294967295L) + (j24 >>> 32);
                int i27 = i12 + 6;
                int i28 = i26;
                long j28 = (((long) iArr2[i27]) & 4294967295L) + (j27 >>> 32);
                long j29 = (j23 & 4294967295L) + (j26 * j11);
                int i29 = (int) j29;
                iArr2[i22] = (i29 << 1) | i25;
                long j30 = (j24 & 4294967295L) + (j29 >>> 32) + (j26 * j19);
                long j31 = (j27 & 4294967295L) + (j30 >>> 32) + (j26 * j25);
                long j32 = j28 + (j31 >>> 32);
                long j33 = j31 & 4294967295L;
                long j34 = ((long) iArr[i11 + 4]) & 4294967295L;
                int i30 = i12 + 7;
                long j35 = j26;
                long j36 = (((long) iArr2[i30]) & 4294967295L) + (j32 >>> 32);
                int i31 = i12 + 8;
                int i32 = i30;
                long j37 = j32 & 4294967295L;
                long j38 = (((long) iArr2[i31]) & 4294967295L) + (j36 >>> 32);
                long j39 = (j30 & 4294967295L) + (j34 * j11);
                int i33 = (int) j39;
                iArr2[i23] = (i29 >>> 31) | (i33 << 1);
                int i34 = i33 >>> 31;
                long j40 = j33 + (j39 >>> 32) + (j34 * j19);
                long j41 = j37 + (j40 >>> 32) + (j34 * j25);
                long j42 = (j36 & 4294967295L) + (j41 >>> 32) + (j34 * j35);
                long j43 = j38 + (j42 >>> 32);
                long j44 = j34;
                long j45 = ((long) iArr[i11 + 5]) & 4294967295L;
                int i35 = i12 + 9;
                long j46 = j42 & 4294967295L;
                long j47 = (((long) iArr2[i35]) & 4294967295L) + (j43 >>> 32);
                int i36 = i12 + 10;
                int i37 = i35;
                long j48 = (j40 & 4294967295L) + (j45 * j11);
                int i38 = (int) j48;
                iArr2[i28] = i34 | (i38 << 1);
                int i39 = i38 >>> 31;
                long j49 = (j41 & 4294967295L) + (j48 >>> 32) + (j45 * j19);
                long j50 = j46 + (j49 >>> 32) + (j45 * j25);
                long j51 = (j43 & 4294967295L) + (j50 >>> 32) + (j45 * j35);
                long j52 = (j47 & 4294967295L) + (j51 >>> 32) + (j45 * j44);
                long j53 = (((long) iArr2[i36]) & 4294967295L) + (j47 >>> 32) + (j52 >>> 32);
                long j54 = j45;
                long j55 = ((long) iArr[i11 + 6]) & 4294967295L;
                int i40 = i12 + 11;
                long j56 = j52 & 4294967295L;
                long j57 = (((long) iArr2[i40]) & 4294967295L) + (j53 >>> 32);
                int i41 = i12 + 12;
                int i42 = i40;
                long j58 = (j49 & 4294967295L) + (j11 * j55);
                int i43 = (int) j58;
                iArr2[i27] = (i43 << 1) | i39;
                long j59 = (j50 & 4294967295L) + (j58 >>> 32) + (j55 * j19);
                long j60 = (j51 & 4294967295L) + (j59 >>> 32) + (j55 * j25);
                long j61 = j56 + (j60 >>> 32) + (j55 * j35);
                long j62 = (j53 & 4294967295L) + (j61 >>> 32) + (j55 * j44);
                long j63 = (j57 & 4294967295L) + (j62 >>> 32) + (j55 * j54);
                long j64 = (((long) iArr2[i41]) & 4294967295L) + (j57 >>> 32) + (j63 >>> 32);
                int i44 = (int) j59;
                iArr2[i32] = (i43 >>> 31) | (i44 << 1);
                int i45 = (int) j60;
                iArr2[i31] = (i44 >>> 31) | (i45 << 1);
                int i46 = i45 >>> 31;
                int i47 = (int) j61;
                iArr2[i37] = i46 | (i47 << 1);
                int i48 = i47 >>> 31;
                int i49 = (int) j62;
                iArr2[i36] = i48 | (i49 << 1);
                int i50 = i49 >>> 31;
                int i51 = (int) j63;
                iArr2[i42] = i50 | (i51 << 1);
                int i52 = i51 >>> 31;
                int i53 = (int) j64;
                iArr2[i41] = i52 | (i53 << 1);
                int i54 = i53 >>> 31;
                int i55 = i12 + 13;
                iArr2[i55] = i54 | ((iArr2[i55] + ((int) (j64 >>> 32))) << 1);
                return;
            }
            i15 = i16;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j11 = ((long) iArr[0]) & 4294967295L;
        int i11 = 14;
        int i12 = 0;
        int i13 = 6;
        while (true) {
            int i14 = i13 - 1;
            long j12 = ((long) iArr[i13]) & 4294967295L;
            long j13 = j12 * j12;
            int i15 = i11 - 1;
            iArr2[i15] = (i12 << 31) | ((int) (j13 >>> 33));
            i11 = i15 - 1;
            iArr2[i11] = (int) (j13 >>> 1);
            int i16 = (int) j13;
            if (i14 <= 0) {
                long j14 = j11 * j11;
                long j15 = (((long) (i16 << 31)) & 4294967295L) | (j14 >>> 33);
                iArr2[0] = (int) j14;
                long j16 = ((long) iArr[1]) & 4294967295L;
                long j17 = j15 + (j16 * j11);
                int i17 = (int) j17;
                iArr2[1] = (i17 << 1) | (((int) (j14 >>> 32)) & 1);
                long j18 = (((long) iArr2[2]) & 4294967295L) + (j17 >>> 32);
                long j19 = ((long) iArr[2]) & 4294967295L;
                long j21 = j18 + (j19 * j11);
                int i18 = (int) j21;
                iArr2[2] = (i18 << 1) | (i17 >>> 31);
                long j22 = (((long) iArr2[3]) & 4294967295L) + (j21 >>> 32) + (j19 * j16);
                long j23 = (((long) iArr2[4]) & 4294967295L) + (j22 >>> 32);
                long j24 = ((long) iArr[3]) & 4294967295L;
                long j25 = j19;
                long j26 = (((long) iArr2[5]) & 4294967295L) + (j23 >>> 32);
                long j27 = j23 & 4294967295L;
                long j28 = (((long) iArr2[6]) & 4294967295L) + (j26 >>> 32);
                long j29 = (j22 & 4294967295L) + (j24 * j11);
                int i19 = (int) j29;
                iArr2[3] = (i19 << 1) | (i18 >>> 31);
                long j30 = j27 + (j29 >>> 32) + (j24 * j16);
                long j31 = (j26 & 4294967295L) + (j30 >>> 32) + (j24 * j25);
                long j32 = j28 + (j31 >>> 32);
                long j33 = j24;
                long j34 = ((long) iArr[4]) & 4294967295L;
                long j35 = j31 & 4294967295L;
                long j36 = (((long) iArr2[7]) & 4294967295L) + (j32 >>> 32);
                long j37 = j32 & 4294967295L;
                long j38 = (((long) iArr2[8]) & 4294967295L) + (j36 >>> 32);
                long j39 = (j30 & 4294967295L) + (j34 * j11);
                int i21 = (int) j39;
                iArr2[4] = (i19 >>> 31) | (i21 << 1);
                long j40 = j35 + (j39 >>> 32) + (j34 * j16);
                long j41 = j37 + (j40 >>> 32) + (j34 * j25);
                long j42 = (j36 & 4294967295L) + (j41 >>> 32) + (j34 * j33);
                long j43 = j38 + (j42 >>> 32);
                long j44 = j34;
                long j45 = ((long) iArr[5]) & 4294967295L;
                long j46 = (((long) iArr2[9]) & 4294967295L) + (j43 >>> 32);
                long j47 = j43 & 4294967295L;
                long j48 = (((long) iArr2[10]) & 4294967295L) + (j46 >>> 32);
                long j49 = (j40 & 4294967295L) + (j45 * j11);
                int i22 = (int) j49;
                iArr2[5] = (i22 << 1) | (i21 >>> 31);
                long j50 = (j41 & 4294967295L) + (j49 >>> 32) + (j45 * j16);
                long j51 = (j42 & 4294967295L) + (j50 >>> 32) + (j45 * j25);
                long j52 = j47 + (j51 >>> 32) + (j45 * j33);
                long j53 = (j46 & 4294967295L) + (j52 >>> 32) + (j45 * j44);
                long j54 = j48 + (j53 >>> 32);
                long j55 = j45;
                long j56 = ((long) iArr[6]) & 4294967295L;
                long j57 = j53 & 4294967295L;
                long j58 = (((long) iArr2[11]) & 4294967295L) + (j54 >>> 32);
                long j59 = (j50 & 4294967295L) + (j11 * j56);
                int i23 = (int) j59;
                iArr2[6] = (i22 >>> 31) | (i23 << 1);
                int i24 = i23 >>> 31;
                long j60 = (j51 & 4294967295L) + (j59 >>> 32) + (j16 * j56);
                long j61 = (j52 & 4294967295L) + (j60 >>> 32) + (j56 * j25);
                long j62 = j57 + (j61 >>> 32) + (j56 * j33);
                long j63 = (j54 & 4294967295L) + (j62 >>> 32) + (j56 * j44);
                long j64 = (j58 & 4294967295L) + (j63 >>> 32) + (j56 * j55);
                long j65 = (((long) iArr2[12]) & 4294967295L) + (j58 >>> 32) + (j64 >>> 32);
                int i25 = (int) j60;
                iArr2[7] = i24 | (i25 << 1);
                int i26 = (int) j61;
                iArr2[8] = (i25 >>> 31) | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) j62;
                iArr2[9] = i27 | (i28 << 1);
                int i29 = i28 >>> 31;
                int i30 = (int) j63;
                iArr2[10] = i29 | (i30 << 1);
                int i31 = i30 >>> 31;
                int i32 = (int) j64;
                iArr2[11] = i31 | (i32 << 1);
                int i33 = i32 >>> 31;
                int i34 = (int) j65;
                iArr2[12] = i33 | (i34 << 1);
                iArr2[13] = (i34 >>> 31) | ((iArr2[13] + ((int) (j65 >>> 32))) << 1);
                return;
            }
            i13 = i14;
            i12 = i16;
        }
    }

    public static int sub(int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j11 = ((((long) iArr[i11 + 0]) & 4294967295L) - (((long) iArr2[i12 + 0]) & 4294967295L)) + 0;
        iArr3[i13 + 0] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr[i11 + 1]) & 4294967295L) - (((long) iArr2[i12 + 1]) & 4294967295L));
        iArr3[i13 + 1] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr[i11 + 2]) & 4294967295L) - (((long) iArr2[i12 + 2]) & 4294967295L));
        iArr3[i13 + 2] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr[i11 + 3]) & 4294967295L) - (((long) iArr2[i12 + 3]) & 4294967295L));
        iArr3[i13 + 3] = (int) j14;
        long j15 = (j14 >> 32) + ((((long) iArr[i11 + 4]) & 4294967295L) - (((long) iArr2[i12 + 4]) & 4294967295L));
        iArr3[i13 + 4] = (int) j15;
        long j16 = (j15 >> 32) + ((((long) iArr[i11 + 5]) & 4294967295L) - (((long) iArr2[i12 + 5]) & 4294967295L));
        iArr3[i13 + 5] = (int) j16;
        long j17 = (j16 >> 32) + ((((long) iArr[i11 + 6]) & 4294967295L) - (((long) iArr2[i12 + 6]) & 4294967295L));
        iArr3[i13 + 6] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static int sub(int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j14;
        long j15 = (j14 >> 32) + ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j15;
        long j16 = (j15 >> 32) + ((((long) iArr[5]) & 4294967295L) - (((long) iArr2[5]) & 4294967295L));
        iArr3[5] = (int) j16;
        long j17 = (j16 >> 32) + ((((long) iArr[6]) & 4294967295L) - (((long) iArr2[6]) & 4294967295L));
        iArr3[6] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static int subBothFrom(int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = (((((long) iArr3[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j11;
        long j12 = (j11 >> 32) + (((((long) iArr3[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j12;
        long j13 = (j12 >> 32) + (((((long) iArr3[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j13;
        long j14 = (j13 >> 32) + (((((long) iArr3[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j14;
        long j15 = (j14 >> 32) + (((((long) iArr3[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L)) - (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j15;
        long j16 = (j15 >> 32) + (((((long) iArr3[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L)) - (((long) iArr2[5]) & 4294967295L));
        iArr3[5] = (int) j16;
        long j17 = (j16 >> 32) + (((((long) iArr3[6]) & 4294967295L) - (((long) iArr[6]) & 4294967295L)) - (((long) iArr2[6]) & 4294967295L));
        iArr3[6] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static int subFrom(int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = i12 + 0;
        long j11 = ((((long) iArr2[i13]) & 4294967295L) - (((long) iArr[i11 + 0]) & 4294967295L)) + 0;
        iArr2[i13] = (int) j11;
        int i14 = i12 + 1;
        long j12 = (j11 >> 32) + ((((long) iArr2[i14]) & 4294967295L) - (((long) iArr[i11 + 1]) & 4294967295L));
        iArr2[i14] = (int) j12;
        int i15 = i12 + 2;
        long j13 = (j12 >> 32) + ((((long) iArr2[i15]) & 4294967295L) - (((long) iArr[i11 + 2]) & 4294967295L));
        iArr2[i15] = (int) j13;
        int i16 = i12 + 3;
        long j14 = (j13 >> 32) + ((((long) iArr2[i16]) & 4294967295L) - (((long) iArr[i11 + 3]) & 4294967295L));
        iArr2[i16] = (int) j14;
        int i17 = i12 + 4;
        long j15 = (j14 >> 32) + ((((long) iArr2[i17]) & 4294967295L) - (((long) iArr[i11 + 4]) & 4294967295L));
        iArr2[i17] = (int) j15;
        int i18 = i12 + 5;
        long j16 = (j15 >> 32) + ((((long) iArr2[i18]) & 4294967295L) - (((long) iArr[i11 + 5]) & 4294967295L));
        iArr2[i18] = (int) j16;
        int i19 = i12 + 6;
        long j17 = (j16 >> 32) + ((((long) iArr2[i19]) & 4294967295L) - (((long) iArr[i11 + 6]) & 4294967295L));
        iArr2[i19] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j11 = ((((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
        iArr2[0] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L));
        iArr2[1] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L));
        iArr2[2] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L));
        iArr2[3] = (int) j14;
        long j15 = (j14 >> 32) + ((((long) iArr2[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L));
        iArr2[4] = (int) j15;
        long j16 = (j15 >> 32) + ((((long) iArr2[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L));
        iArr2[5] = (int) j16;
        long j17 = (j16 >> 32) + ((((long) iArr2[6]) & 4294967295L) - (4294967295L & ((long) iArr[6])));
        iArr2[6] = (int) j17;
        return (int) (j17 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i11 = 0; i11 < 7; i11++) {
            int i12 = iArr[i11];
            if (i12 != 0) {
                Pack.intToBigEndian(i12, bArr, (6 - i11) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
    }
}
