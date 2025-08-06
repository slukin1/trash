package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

public abstract class Nat128 {
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
        return (int) (j14 >>> 32);
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
        return (int) (j14 >>> 32);
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
        long j14 = (j13 >>> 32) + (((long) iArr[i11 + 3]) & 4294967295L) + (4294967295L & ((long) iArr2[i17]));
        iArr2[i17] = (int) j14;
        return (int) (j14 >>> 32);
    }

    public static int addTo(int[] iArr, int[] iArr2) {
        long j11 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr2[1] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr2[2] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[3]) & 4294967295L) + (4294967295L & ((long) iArr2[3]));
        iArr2[3] = (int) j14;
        return (int) (j14 >>> 32);
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
        long j14 = (j13 >>> 32) + (((long) iArr[i23]) & 4294967295L) + (4294967295L & ((long) iArr2[i24]));
        int i25 = (int) j14;
        iArr[i23] = i25;
        iArr2[i24] = i25;
        return (int) (j14 >>> 32);
    }

    public static void copy(int[] iArr, int i11, int[] iArr2, int i12) {
        iArr2[i12 + 0] = iArr[i11 + 0];
        iArr2[i12 + 1] = iArr[i11 + 1];
        iArr2[i12 + 2] = iArr[i11 + 2];
        iArr2[i12 + 3] = iArr[i11 + 3];
    }

    public static void copy(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
    }

    public static void copy64(long[] jArr, int i11, long[] jArr2, int i12) {
        jArr2[i12 + 0] = jArr[i11 + 0];
        jArr2[i12 + 1] = jArr[i11 + 1];
    }

    public static void copy64(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
    }

    public static int[] create() {
        return new int[4];
    }

    public static long[] create64() {
        return new long[2];
    }

    public static int[] createExt() {
        return new int[8];
    }

    public static long[] createExt64() {
        return new long[4];
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
        for (int i11 = 3; i11 >= 0; i11--) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    public static boolean eq64(long[] jArr, long[] jArr2) {
        for (int i11 = 1; i11 >= 0; i11--) {
            if (jArr[i11] != jArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    public static int[] fromBigInteger(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        int[] create = create();
        for (int i11 = 0; i11 < 4; i11++) {
            create[i11] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return create;
    }

    public static long[] fromBigInteger64(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        long[] create64 = create64();
        for (int i11 = 0; i11 < 2; i11++) {
            create64[i11] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return create64;
    }

    public static int getBit(int[] iArr, int i11) {
        int i12;
        if (i11 == 0) {
            i12 = iArr[0];
        } else {
            int i13 = i11 >> 5;
            if (i13 < 0 || i13 >= 4) {
                return 0;
            }
            i12 = iArr[i13] >>> (i11 & 31);
        }
        return i12 & 1;
    }

    public static boolean gte(int[] iArr, int i11, int[] iArr2, int i12) {
        for (int i13 = 3; i13 >= 0; i13--) {
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
        for (int i11 = 3; i11 >= 0; i11--) {
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
        for (int i11 = 1; i11 < 4; i11++) {
            if (iArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOne64(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i11 = 1; i11 < 2; i11++) {
            if (jArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int[] iArr) {
        for (int i11 = 0; i11 < 4; i11++) {
            if (iArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero64(long[] jArr) {
        for (int i11 = 0; i11 < 2; i11++) {
            if (jArr[i11] != 0) {
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
        long j15 = ((long) iArr[i11 + 0]) & 4294967295L;
        long j16 = (j15 * j11) + 0;
        iArr3[i13 + 0] = (int) j16;
        long j17 = (j16 >>> 32) + (j15 * j12);
        iArr3[i13 + 1] = (int) j17;
        long j18 = (j17 >>> 32) + (j15 * j13);
        iArr3[i13 + 2] = (int) j18;
        long j19 = (j18 >>> 32) + (j15 * j14);
        iArr3[i13 + 3] = (int) j19;
        iArr3[i13 + 4] = (int) (j19 >>> 32);
        int i14 = 1;
        int i15 = i13;
        int i16 = 1;
        while (i16 < 4) {
            i15 += i14;
            long j21 = ((long) iArr[i11 + i16]) & 4294967295L;
            int i17 = i15 + 0;
            long j22 = j11;
            long j23 = (j21 * j11) + (((long) iArr3[i17]) & 4294967295L) + 0;
            iArr3[i17] = (int) j23;
            int i18 = i15 + 1;
            long j24 = (j23 >>> 32) + (j21 * j12) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j24;
            int i19 = i15 + 2;
            long j25 = j12;
            long j26 = (j24 >>> 32) + (j21 * j13) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j26;
            int i21 = i15 + 3;
            long j27 = (j26 >>> 32) + (j21 * j14) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j27;
            iArr3[i15 + 4] = (int) (j27 >>> 32);
            i16++;
            j12 = j25;
            j11 = j22;
            i14 = 1;
        }
    }

    public static void mul(int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = ((long) iArr2[0]) & 4294967295L;
        int i11 = 1;
        long j12 = ((long) iArr2[1]) & 4294967295L;
        long j13 = ((long) iArr2[2]) & 4294967295L;
        long j14 = ((long) iArr2[3]) & 4294967295L;
        long j15 = ((long) iArr[0]) & 4294967295L;
        long j16 = (j15 * j11) + 0;
        iArr3[0] = (int) j16;
        char c11 = ' ';
        long j17 = (j16 >>> 32) + (j15 * j12);
        iArr3[1] = (int) j17;
        long j18 = (j17 >>> 32) + (j15 * j13);
        iArr3[2] = (int) j18;
        long j19 = (j18 >>> 32) + (j15 * j14);
        iArr3[3] = (int) j19;
        iArr3[4] = (int) (j19 >>> 32);
        for (int i12 = 4; i11 < i12; i12 = 4) {
            long j21 = ((long) iArr[i11]) & 4294967295L;
            int i13 = i11 + 0;
            int i14 = i11;
            long j22 = (j21 * j11) + (((long) iArr3[i13]) & 4294967295L) + 0;
            iArr3[i13] = (int) j22;
            int i15 = i14 + 1;
            long j23 = j11;
            long j24 = (j22 >>> c11) + (j21 * j12) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j24;
            int i16 = i14 + 2;
            int i17 = i15;
            long j25 = (j24 >>> 32) + (j21 * j13) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j25;
            c11 = ' ';
            int i18 = i14 + 3;
            long j26 = (j25 >>> 32) + (j21 * j14) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j26;
            iArr3[i14 + 4] = (int) (j26 >>> 32);
            i11 = i17;
            j11 = j23;
            j12 = j12;
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
        long j21 = (j18 >>> 32) + (j11 * j19) + j17 + (4294967295L & ((long) iArr2[i13 + 3]));
        iArr3[i14 + 3] = (int) j21;
        return (j21 >>> 32) + j19;
    }

    public static int mul33DWordAdd(int i11, long j11, int[] iArr, int i12) {
        long j12 = ((long) i11) & 4294967295L;
        long j13 = j11 & 4294967295L;
        int i13 = i12 + 0;
        long j14 = (j12 * j13) + (((long) iArr[i13]) & 4294967295L) + 0;
        iArr[i13] = (int) j14;
        long j15 = j11 >>> 32;
        long j16 = (j12 * j15) + j13;
        int i14 = i12 + 1;
        long j17 = (j14 >>> 32) + j16 + (((long) iArr[i14]) & 4294967295L);
        iArr[i14] = (int) j17;
        int i15 = i12 + 2;
        long j18 = (j17 >>> 32) + j15 + (((long) iArr[i15]) & 4294967295L);
        iArr[i15] = (int) j18;
        int i16 = i12 + 3;
        long j19 = (j18 >>> 32) + (((long) iArr[i16]) & 4294967295L);
        iArr[i16] = (int) j19;
        return (int) (j19 >>> 32);
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
        return Nat.incAt(4, iArr, i13, 3);
    }

    public static int mulAddTo(int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j11 = 4294967295L;
        long j12 = ((long) iArr2[i12 + 0]) & 4294967295L;
        long j13 = ((long) iArr2[i12 + 1]) & 4294967295L;
        long j14 = ((long) iArr2[i12 + 2]) & 4294967295L;
        long j15 = ((long) iArr2[i12 + 3]) & 4294967295L;
        int i14 = 0;
        long j16 = 0;
        int i15 = i13;
        while (i14 < 4) {
            long j17 = ((long) iArr[i11 + i14]) & j11;
            int i16 = i15 + 0;
            long j18 = (j17 * j12) + (((long) iArr3[i16]) & j11) + 0;
            iArr3[i16] = (int) j18;
            int i17 = i15 + 1;
            long j19 = j13;
            long j21 = (j18 >>> 32) + (j17 * j13) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j21;
            int i18 = i15 + 2;
            long j22 = (j21 >>> 32) + (j17 * j14) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j22;
            int i19 = i15 + 3;
            long j23 = (j22 >>> 32) + (j17 * j15) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j23;
            int i21 = i15 + 4;
            long j24 = j16 + (j23 >>> 32) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j24;
            j16 = j24 >>> 32;
            i14++;
            i15 = i17;
            j12 = j12;
            j11 = 4294967295L;
            j13 = j19;
            j14 = j14;
        }
        return (int) j16;
    }

    public static int mulAddTo(int[] iArr, int[] iArr2, int[] iArr3) {
        int i11 = 0;
        long j11 = 4294967295L;
        long j12 = ((long) iArr2[0]) & 4294967295L;
        long j13 = ((long) iArr2[1]) & 4294967295L;
        long j14 = ((long) iArr2[2]) & 4294967295L;
        long j15 = ((long) iArr2[3]) & 4294967295L;
        long j16 = 0;
        while (i11 < 4) {
            long j17 = ((long) iArr[i11]) & j11;
            int i12 = i11 + 0;
            long j18 = (j17 * j12) + (((long) iArr3[i12]) & j11) + 0;
            iArr3[i12] = (int) j18;
            int i13 = i11 + 1;
            long j19 = (j18 >>> 32) + (j17 * j13) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j19;
            int i14 = i11 + 2;
            int i15 = i13;
            long j21 = (j19 >>> 32) + (j17 * j14) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j21;
            int i16 = i11 + 3;
            long j22 = (j21 >>> 32) + (j17 * j15) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j22;
            int i17 = i11 + 4;
            long j23 = j16 + (j22 >>> 32) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j23;
            j16 = j23 >>> 32;
            i11 = i15;
            j11 = 4294967295L;
            j12 = j12;
            j13 = j13;
        }
        return (int) j16;
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
        } while (i13 < 4);
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
        long j15 = (j14 >>> 32) + (j11 * (((long) iArr[i12 + 3]) & 4294967295L)) + (((long) iArr2[i17]) & 4294967295L);
        iArr2[i17] = (int) j15;
        return (int) (j15 >>> 32);
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
        return Nat.incAt(4, iArr, i12, 3);
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
        return Nat.incAt(4, iArr, i13, 2);
    }

    public static void square(int[] iArr, int i11, int[] iArr2, int i12) {
        long j11 = ((long) iArr[i11 + 0]) & 4294967295L;
        int i13 = 0;
        int i14 = 8;
        int i15 = 3;
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
                long j25 = ((long) iArr[i11 + 3]) & 4294967295L;
                int i26 = i12 + 5;
                int i27 = i26;
                long j26 = (((long) iArr2[i26]) & 4294967295L) + (j24 >>> 32);
                int i28 = i12 + 6;
                long j27 = 4294967295L & j26;
                long j28 = (j23 & 4294967295L) + (j11 * j25);
                int i29 = (int) j28;
                iArr2[i22] = (i29 << 1) | i25;
                long j29 = (j24 & 4294967295L) + (j28 >>> 32) + (j25 * j19);
                long j30 = j27 + (j29 >>> 32) + (j25 * j18);
                long j31 = (((long) iArr2[i28]) & 4294967295L) + (j26 >>> 32) + (j30 >>> 32);
                int i30 = (int) j29;
                iArr2[i23] = (i29 >>> 31) | (i30 << 1);
                int i31 = i30 >>> 31;
                int i32 = (int) j30;
                iArr2[i27] = i31 | (i32 << 1);
                int i33 = i32 >>> 31;
                int i34 = (int) j31;
                iArr2[i28] = i33 | (i34 << 1);
                int i35 = i34 >>> 31;
                int i36 = i12 + 7;
                iArr2[i36] = i35 | ((iArr2[i36] + ((int) (j31 >>> 32))) << 1);
                return;
            }
            i15 = i16;
        }
    }

    public static void square(int[] iArr, int[] iArr2) {
        long j11 = 4294967295L;
        long j12 = ((long) iArr[0]) & 4294967295L;
        char c11 = 3;
        int i11 = 8;
        int i12 = 0;
        int i13 = 3;
        while (true) {
            int i14 = i13 - 1;
            long j13 = ((long) iArr[i13]) & j11;
            long j14 = j13 * j13;
            int i15 = i11 - 1;
            iArr2[i15] = (i12 << 31) | ((int) (j14 >>> 33));
            i11 = i15 - 1;
            iArr2[i11] = (int) (j14 >>> 1);
            int i16 = (int) j14;
            if (i14 <= 0) {
                long j15 = j12 * j12;
                long j16 = (((long) (i16 << 31)) & j11) | (j15 >>> 33);
                iArr2[0] = (int) j15;
                long j17 = ((long) iArr[1]) & j11;
                long j18 = j16 + (j17 * j12);
                int i17 = (int) j18;
                iArr2[1] = (i17 << 1) | (((int) (j15 >>> 32)) & 1);
                long j19 = (((long) iArr2[2]) & j11) + (j18 >>> 32);
                long j21 = ((long) iArr[2]) & j11;
                long j22 = ((long) iArr2[c11]) & j11;
                long j23 = ((long) iArr2[4]) & j11;
                long j24 = j19 + (j21 * j12);
                int i18 = (int) j24;
                iArr2[2] = (i18 << 1) | (i17 >>> 31);
                long j25 = j22 + (j24 >>> 32) + (j21 * j17);
                long j26 = j23 + (j25 >>> 32);
                long j27 = ((long) iArr[3]) & 4294967295L;
                long j28 = j21;
                long j29 = (((long) iArr2[5]) & 4294967295L) + (j26 >>> 32);
                long j30 = (j25 & 4294967295L) + (j12 * j27);
                int i19 = (int) j30;
                iArr2[3] = (i19 << 1) | (i18 >>> 31);
                long j31 = (j26 & 4294967295L) + (j30 >>> 32) + (j17 * j27);
                long j32 = (j29 & 4294967295L) + (j31 >>> 32) + (j27 * j28);
                long j33 = (((long) iArr2[6]) & 4294967295L) + (j29 >>> 32) + (j32 >>> 32);
                int i21 = (int) j31;
                iArr2[4] = (i19 >>> 31) | (i21 << 1);
                int i22 = (int) (4294967295L & j32);
                iArr2[5] = (i21 >>> 31) | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j33;
                iArr2[6] = i23 | (i24 << 1);
                iArr2[7] = (i24 >>> 31) | ((iArr2[7] + ((int) (j33 >>> 32))) << 1);
                return;
            }
            long j34 = j11;
            long j35 = j34;
            i13 = i14;
            i12 = i16;
            c11 = c11;
            j11 = j34;
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
        return (int) (j14 >> 32);
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
        return (int) (j14 >> 32);
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
        return (int) (j14 >> 32);
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
        return (int) (j14 >> 32);
    }

    public static int subFrom(int[] iArr, int[] iArr2) {
        long j11 = ((((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
        iArr2[0] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L));
        iArr2[1] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L));
        iArr2[2] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr2[3]) & 4294967295L) - (4294967295L & ((long) iArr[3])));
        iArr2[3] = (int) j14;
        return (int) (j14 >> 32);
    }

    public static BigInteger toBigInteger(int[] iArr) {
        byte[] bArr = new byte[16];
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = iArr[i11];
            if (i12 != 0) {
                Pack.intToBigEndian(i12, bArr, (3 - i11) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static BigInteger toBigInteger64(long[] jArr) {
        byte[] bArr = new byte[16];
        for (int i11 = 0; i11 < 2; i11++) {
            long j11 = jArr[i11];
            if (j11 != 0) {
                Pack.longToBigEndian(j11, bArr, (1 - i11) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
    }
}
