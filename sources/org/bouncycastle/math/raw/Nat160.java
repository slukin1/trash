package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

public abstract class Nat160 {
    private static final long M = 4294967295L;

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
        return (int) (j15 >>> 32);
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
        return (int) (j15 >>> 32);
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
        long j15 = (j14 >>> 32) + (((long) iArr[i11 + 4]) & 4294967295L) + (4294967295L & ((long) iArr2[i18]));
        iArr2[i18] = (int) j15;
        return (int) (j15 >>> 32);
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
        long j15 = (j14 >>> 32) + (((long) iArr[4]) & 4294967295L) + (4294967295L & ((long) iArr2[4]));
        iArr2[4] = (int) j15;
        return (int) (j15 >>> 32);
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
        long j15 = (j14 >>> 32) + (((long) iArr[i26]) & 4294967295L) + (4294967295L & ((long) iArr2[i27]));
        int i28 = (int) j15;
        iArr[i26] = i28;
        iArr2[i27] = i28;
        return (int) (j15 >>> 32);
    }

    public static void copy(int[] iArr, int i11, int[] iArr2, int i12) {
        iArr2[i12 + 0] = iArr[i11 + 0];
        iArr2[i12 + 1] = iArr[i11 + 1];
        iArr2[i12 + 2] = iArr[i11 + 2];
        iArr2[i12 + 3] = iArr[i11 + 3];
        iArr2[i12 + 4] = iArr[i11 + 4];
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
    }

    public static int[] create() {
        return new int[5];
    }

    public static int[] createExt() {
        return new int[10];
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
        for (int i11 = 4; i11 >= 0; i11--) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 160) {
            throw new IllegalArgumentException();
        }
        int[] create = create();
        for (int i11 = 0; i11 < 5; i11++) {
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
            if (i13 < 0 || i13 >= 5) {
                return 0;
            }
            i12 = iArr[i13] >>> (i11 & 31);
        }
        return i12 & 1;
    }

    public static boolean gte(int[] iArr, int i11, int[] iArr2, int i12) {
        for (int i13 = 4; i13 >= 0; i13--) {
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
        for (int i11 = 4; i11 >= 0; i11--) {
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
        for (int i11 = 1; i11 < 5; i11++) {
            if (iArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i11 = 0; i11 < 5; i11++) {
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
        long j16 = ((long) iArr[i11 + 0]) & 4294967295L;
        long j17 = (j16 * j11) + 0;
        iArr3[i13 + 0] = (int) j17;
        long j18 = (j17 >>> 32) + (j16 * j12);
        long j19 = j12;
        iArr3[i13 + 1] = (int) j18;
        long j21 = (j18 >>> 32) + (j16 * j13);
        iArr3[i13 + 2] = (int) j21;
        long j22 = (j21 >>> 32) + (j16 * j14);
        iArr3[i13 + 3] = (int) j22;
        long j23 = (j22 >>> 32) + (j16 * j15);
        iArr3[i13 + 4] = (int) j23;
        iArr3[i13 + 5] = (int) (j23 >>> 32);
        int i14 = 1;
        int i15 = i13;
        int i16 = 1;
        while (i16 < 5) {
            i15 += i14;
            long j24 = ((long) iArr[i11 + i16]) & 4294967295L;
            int i17 = i15 + 0;
            long j25 = (j24 * j11) + (((long) iArr3[i17]) & 4294967295L) + 0;
            iArr3[i17] = (int) j25;
            int i18 = i15 + 1;
            long j26 = (j25 >>> 32) + (j24 * j19) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j26;
            int i19 = i15 + 2;
            long j27 = (j26 >>> 32) + (j24 * j13) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j27;
            int i21 = i15 + 3;
            long j28 = (j27 >>> 32) + (j24 * j14) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j28;
            int i22 = i15 + 4;
            long j29 = (j28 >>> 32) + (j24 * j15) + (((long) iArr3[i22]) & 4294967295L);
            iArr3[i22] = (int) j29;
            iArr3[i15 + 5] = (int) (j29 >>> 32);
            i16++;
            j13 = j13;
            j11 = j11;
            i14 = 1;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = ((long) iArr2[0]) & 4294967295L;
        int i11 = 1;
        long j12 = ((long) iArr2[1]) & 4294967295L;
        long j13 = ((long) iArr2[3]) & 4294967295L;
        long j14 = ((long) iArr2[4]) & 4294967295L;
        long j15 = ((long) iArr2[2]) & 4294967295L;
        long j16 = ((long) iArr[0]) & 4294967295L;
        long j17 = (j16 * j11) + 0;
        iArr3[0] = (int) j17;
        long j18 = (j17 >>> 32) + (j16 * j12);
        iArr3[1] = (int) j18;
        long j19 = (j18 >>> 32) + (j16 * j15);
        iArr3[2] = (int) j19;
        long j21 = (j19 >>> 32) + (j16 * j13);
        iArr3[3] = (int) j21;
        long j22 = (j21 >>> 32) + (j16 * j14);
        iArr3[4] = (int) j22;
        iArr3[5] = (int) (j22 >>> 32);
        for (int i12 = 5; i11 < i12; i12 = 5) {
            long j23 = ((long) iArr[i11]) & 4294967295L;
            int i13 = i11 + 0;
            long j24 = (j23 * j11) + (((long) iArr3[i13]) & 4294967295L) + 0;
            iArr3[i13] = (int) j24;
            int i14 = i11 + 1;
            long j25 = j12;
            long j26 = (j24 >>> 32) + (j23 * j12) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j26;
            int i15 = i11 + 2;
            long j27 = j14;
            long j28 = (j26 >>> 32) + (j23 * j15) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j28;
            int i16 = i11 + 3;
            long j29 = (j28 >>> 32) + (j23 * j13) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j29;
            int i17 = i11 + 4;
            long j30 = (j29 >>> 32) + (j23 * j27) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j30;
            iArr3[i11 + 5] = (int) (j30 >>> 32);
            i11 = i14;
            j14 = j27;
            j11 = j11;
            j12 = j25;
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
        long j23 = (j21 >>> 32) + (j11 * j22) + j19 + (4294967295L & ((long) iArr2[i13 + 4]));
        iArr3[i14 + 4] = (int) j23;
        return (j23 >>> 32) + j22;
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
        return Nat.incAt(5, iArr2, i13, 4);
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
        return Nat.incAt(5, iArr, i13, 3);
    }

    public static int mulAddTo(int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j11 = 4294967295L;
        long j12 = ((long) iArr2[i12 + 0]) & 4294967295L;
        long j13 = ((long) iArr2[i12 + 1]) & 4294967295L;
        long j14 = ((long) iArr2[i12 + 2]) & 4294967295L;
        long j15 = ((long) iArr2[i12 + 3]) & 4294967295L;
        long j16 = ((long) iArr2[i12 + 4]) & 4294967295L;
        int i14 = 0;
        long j17 = 0;
        int i15 = i13;
        while (i14 < 5) {
            long j18 = ((long) iArr[i11 + i14]) & j11;
            int i16 = i15 + 0;
            long j19 = (j18 * j12) + (((long) iArr3[i16]) & j11) + 0;
            iArr3[i16] = (int) j19;
            int i17 = i15 + 1;
            long j21 = j13;
            long j22 = (j19 >>> 32) + (j18 * j13) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j22;
            int i18 = i15 + 2;
            long j23 = j14;
            long j24 = (j22 >>> 32) + (j18 * j14) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j24;
            int i19 = i15 + 3;
            long j25 = (j24 >>> 32) + (j18 * j15) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j25;
            int i21 = i15 + 4;
            long j26 = (j25 >>> 32) + (j18 * j16) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j26;
            int i22 = i15 + 5;
            long j27 = (j26 >>> 32) + (((long) iArr3[i22]) & 4294967295L) + j17;
            iArr3[i22] = (int) j27;
            j17 = j27 >>> 32;
            i14++;
            i15 = i17;
            j12 = j12;
            j11 = 4294967295L;
            j13 = j21;
            j14 = j23;
        }
        return (int) j17;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i11 = 0;
        long j11 = 4294967295L;
        long j12 = ((long) iArr2[0]) & 4294967295L;
        long j13 = ((long) iArr2[1]) & 4294967295L;
        long j14 = ((long) iArr2[2]) & 4294967295L;
        long j15 = ((long) iArr2[3]) & 4294967295L;
        long j16 = ((long) iArr2[4]) & 4294967295L;
        long j17 = 0;
        while (i11 < 5) {
            long j18 = ((long) iArr[i11]) & j11;
            int i12 = i11 + 0;
            long j19 = (j18 * j12) + (((long) iArr3[i12]) & j11) + 0;
            iArr3[i12] = (int) j19;
            int i13 = i11 + 1;
            long j21 = j13;
            long j22 = (j19 >>> 32) + (j18 * j13) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j22;
            int i14 = i11 + 2;
            long j23 = j14;
            long j24 = (j22 >>> 32) + (j18 * j14) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j24;
            int i15 = i11 + 3;
            long j25 = (j24 >>> 32) + (j18 * j15) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j25;
            int i16 = i11 + 4;
            long j26 = (j25 >>> 32) + (j18 * j16) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j26;
            int i17 = i11 + 5;
            long j27 = (j26 >>> 32) + (((long) iArr3[i17]) & 4294967295L) + j17;
            iArr3[i17] = (int) j27;
            j17 = j27 >>> 32;
            i11 = i13;
            j11 = 4294967295L;
            j12 = j12;
            j14 = j23;
            j13 = j21;
        }
        return (int) j17;
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
        } while (i13 < 5);
        return (int) j12;
    }

    public static int mulWordAddExt(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
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
        long j16 = (j15 >>> 32) + (j11 * (((long) iArr[i12 + 4]) & 4294967295L)) + (((long) iArr2[i18]) & 4294967295L);
        iArr2[i18] = (int) j16;
        return (int) (j16 >>> 32);
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
        return Nat.incAt(5, iArr, i12, 3);
    }

    public static int mulWordsAdd(int i11, int i12, int[] iArr, int i13) {
        int i14 = i13 + 0;
        long j11 = ((((long) i12) & 4294967295L) * (((long) i11) & 4294967295L)) + (((long) iArr[i14]) & 4294967295L) + 0;
        iArr[i14] = (int) j11;
        int i15 = i13 + 1;
        long j12 = (j11 >>> 32) + (4294967295L & ((long) iArr[i15]));
        iArr[i15] = (int) j12;
        if ((j12 >>> 32) == 0) {
            return 0;
        }
        return Nat.incAt(5, iArr, i13, 2);
    }

    public static void square(int[] iArr, int i11, int[] iArr2, int i12) {
        long j11 = ((long) iArr[i11 + 0]) & 4294967295L;
        int i13 = 0;
        int i14 = 10;
        int i15 = 4;
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
                long j37 = (j30 & 4294967295L) + (j11 * j34);
                int i33 = (int) j37;
                iArr2[i23] = (i33 << 1) | (i29 >>> 31);
                long j38 = j33 + (j37 >>> 32) + (j34 * j19);
                long j39 = (j32 & 4294967295L) + (j38 >>> 32) + (j34 * j25);
                long j40 = (j36 & 4294967295L) + (j39 >>> 32) + (j34 * j35);
                long j41 = (((long) iArr2[i31]) & 4294967295L) + (j36 >>> 32) + (j40 >>> 32);
                int i34 = (int) j38;
                iArr2[i28] = (i33 >>> 31) | (i34 << 1);
                int i35 = (int) j39;
                iArr2[i27] = (i34 >>> 31) | (i35 << 1);
                int i36 = i35 >>> 31;
                int i37 = (int) j40;
                iArr2[i32] = i36 | (i37 << 1);
                int i38 = i37 >>> 31;
                int i39 = (int) j41;
                iArr2[i31] = i38 | (i39 << 1);
                int i40 = i39 >>> 31;
                int i41 = i12 + 9;
                iArr2[i41] = i40 | ((iArr2[i41] + ((int) (j41 >>> 32))) << 1);
                return;
            }
            i15 = i16;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j11 = ((long) iArr[0]) & 4294967295L;
        int i11 = 10;
        int i12 = 0;
        int i13 = 4;
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
                int i19 = i18 >>> 31;
                long j22 = (((long) iArr2[3]) & 4294967295L) + (j21 >>> 32) + (j19 * j16);
                long j23 = (((long) iArr2[4]) & 4294967295L) + (j22 >>> 32);
                long j24 = ((long) iArr[3]) & 4294967295L;
                long j25 = j19;
                long j26 = (((long) iArr2[5]) & 4294967295L) + (j23 >>> 32);
                long j27 = j16;
                long j28 = (((long) iArr2[6]) & 4294967295L) + (j26 >>> 32);
                long j29 = (j22 & 4294967295L) + (j24 * j11);
                int i21 = (int) j29;
                iArr2[3] = (i21 << 1) | i19;
                int i22 = i21 >>> 31;
                long j30 = (j23 & 4294967295L) + (j29 >>> 32) + (j24 * j27);
                long j31 = (j26 & 4294967295L) + (j30 >>> 32) + (j24 * j25);
                long j32 = j28 + (j31 >>> 32);
                long j33 = ((long) iArr[4]) & 4294967295L;
                long j34 = (((long) iArr2[7]) & 4294967295L) + (j32 >>> 32);
                long j35 = (j30 & 4294967295L) + (j11 * j33);
                int i23 = (int) j35;
                iArr2[4] = (i23 << 1) | i22;
                long j36 = (j31 & 4294967295L) + (j35 >>> 32) + (j33 * j27);
                long j37 = (j32 & 4294967295L) + (j36 >>> 32) + (j33 * j25);
                long j38 = (4294967295L & j34) + (j37 >>> 32) + (j33 * j24);
                long j39 = (((long) iArr2[8]) & 4294967295L) + (j34 >>> 32) + (j38 >>> 32);
                int i24 = (int) j36;
                iArr2[5] = (i23 >>> 31) | (i24 << 1);
                int i25 = (int) j37;
                iArr2[6] = (i24 >>> 31) | (i25 << 1);
                int i26 = i25 >>> 31;
                int i27 = (int) j38;
                iArr2[7] = i26 | (i27 << 1);
                int i28 = i27 >>> 31;
                int i29 = (int) j39;
                iArr2[8] = i28 | (i29 << 1);
                iArr2[9] = (i29 >>> 31) | ((iArr2[9] + ((int) (j39 >>> 32))) << 1);
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
        return (int) (j15 >> 32);
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
        return (int) (j15 >> 32);
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
        return (int) (j15 >> 32);
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
        return (int) (j15 >> 32);
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
        long j15 = (j14 >> 32) + ((((long) iArr2[4]) & 4294967295L) - (4294967295L & ((long) iArr[4])));
        iArr2[4] = (int) j15;
        return (int) (j15 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[20];
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 != 0) {
                Pack.intToBigEndian(i12, bArr, (4 - i11) << 2);
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
    }
}
