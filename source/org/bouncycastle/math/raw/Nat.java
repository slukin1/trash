package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

public abstract class Nat {
    private static final long M = 4294967295L;

    public static int add(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            long j12 = j11 + (((long) iArr[i12]) & 4294967295L) + (4294967295L & ((long) iArr2[i12]));
            iArr3[i12] = (int) j12;
            j11 = j12 >>> 32;
        }
        return (int) j11;
    }

    public static int add33At(int i11, int i12, int[] iArr, int i13) {
        int i14 = i13 + 0;
        long j11 = (((long) iArr[i14]) & 4294967295L) + (((long) i12) & 4294967295L);
        iArr[i14] = (int) j11;
        int i15 = i13 + 1;
        long j12 = (j11 >>> 32) + (4294967295L & ((long) iArr[i15])) + 1;
        iArr[i15] = (int) j12;
        if ((j12 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, i13 + 2);
    }

    public static int add33At(int i11, int i12, int[] iArr, int i13, int i14) {
        int i15 = i13 + i14;
        long j11 = (((long) iArr[i15]) & 4294967295L) + (((long) i12) & 4294967295L);
        iArr[i15] = (int) j11;
        int i16 = i15 + 1;
        long j12 = (j11 >>> 32) + (4294967295L & ((long) iArr[i16])) + 1;
        iArr[i16] = (int) j12;
        if ((j12 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, i13, i14 + 2);
    }

    public static int add33To(int i11, int i12, int[] iArr) {
        long j11 = (((long) iArr[0]) & 4294967295L) + (((long) i12) & 4294967295L);
        iArr[0] = (int) j11;
        long j12 = (j11 >>> 32) + (4294967295L & ((long) iArr[1])) + 1;
        iArr[1] = (int) j12;
        if ((j12 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, 2);
    }

    public static int add33To(int i11, int i12, int[] iArr, int i13) {
        int i14 = i13 + 0;
        long j11 = (((long) iArr[i14]) & 4294967295L) + (((long) i12) & 4294967295L);
        iArr[i14] = (int) j11;
        int i15 = i13 + 1;
        long j12 = (j11 >>> 32) + (4294967295L & ((long) iArr[i15])) + 1;
        iArr[i15] = (int) j12;
        if ((j12 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, i13, 2);
    }

    public static int addBothTo(int i11, int[] iArr, int i12, int[] iArr2, int i13, int[] iArr3, int i14) {
        long j11 = 0;
        int i15 = i11;
        for (int i16 = 0; i16 < i15; i16++) {
            int i17 = i14 + i16;
            long j12 = j11 + (((long) iArr[i12 + i16]) & 4294967295L) + (((long) iArr2[i13 + i16]) & 4294967295L) + (4294967295L & ((long) iArr3[i17]));
            iArr3[i17] = (int) j12;
            j11 = j12 >>> 32;
        }
        return (int) j11;
    }

    public static int addBothTo(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            long j12 = j11 + (((long) iArr[i12]) & 4294967295L) + (((long) iArr2[i12]) & 4294967295L) + (4294967295L & ((long) iArr3[i12]));
            iArr3[i12] = (int) j12;
            j11 = j12 >>> 32;
        }
        return (int) j11;
    }

    public static int addDWordAt(int i11, long j11, int[] iArr, int i12) {
        int i13 = i12 + 0;
        long j12 = (((long) iArr[i13]) & 4294967295L) + (j11 & 4294967295L);
        iArr[i13] = (int) j12;
        int i14 = i12 + 1;
        long j13 = (j12 >>> 32) + (4294967295L & ((long) iArr[i14])) + (j11 >>> 32);
        iArr[i14] = (int) j13;
        if ((j13 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, i12 + 2);
    }

    public static int addDWordAt(int i11, long j11, int[] iArr, int i12, int i13) {
        int i14 = i12 + i13;
        long j12 = (((long) iArr[i14]) & 4294967295L) + (j11 & 4294967295L);
        iArr[i14] = (int) j12;
        int i15 = i14 + 1;
        long j13 = (j12 >>> 32) + (4294967295L & ((long) iArr[i15])) + (j11 >>> 32);
        iArr[i15] = (int) j13;
        if ((j13 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, i12, i13 + 2);
    }

    public static int addDWordTo(int i11, long j11, int[] iArr) {
        long j12 = (((long) iArr[0]) & 4294967295L) + (j11 & 4294967295L);
        iArr[0] = (int) j12;
        long j13 = (j12 >>> 32) + (4294967295L & ((long) iArr[1])) + (j11 >>> 32);
        iArr[1] = (int) j13;
        if ((j13 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, 2);
    }

    public static int addDWordTo(int i11, long j11, int[] iArr, int i12) {
        int i13 = i12 + 0;
        long j12 = (((long) iArr[i13]) & 4294967295L) + (j11 & 4294967295L);
        iArr[i13] = (int) j12;
        int i14 = i12 + 1;
        long j13 = (j12 >>> 32) + (4294967295L & ((long) iArr[i14])) + (j11 >>> 32);
        iArr[i14] = (int) j13;
        if ((j13 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, i12, 2);
    }

    public static int addTo(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        long j11 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i13 + i14;
            long j12 = j11 + (((long) iArr[i12 + i14]) & 4294967295L) + (4294967295L & ((long) iArr2[i15]));
            iArr2[i15] = (int) j12;
            j11 = j12 >>> 32;
        }
        return (int) j11;
    }

    public static int addTo(int i11, int[] iArr, int i12, int[] iArr2, int i13, int i14) {
        long j11 = ((long) i14) & 4294967295L;
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = i13 + i15;
            long j12 = j11 + (((long) iArr[i12 + i15]) & 4294967295L) + (((long) iArr2[i16]) & 4294967295L);
            iArr2[i16] = (int) j12;
            j11 = j12 >>> 32;
        }
        return (int) j11;
    }

    public static int addTo(int i11, int[] iArr, int[] iArr2) {
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            long j12 = j11 + (((long) iArr[i12]) & 4294967295L) + (4294967295L & ((long) iArr2[i12]));
            iArr2[i12] = (int) j12;
            j11 = j12 >>> 32;
        }
        return (int) j11;
    }

    public static int addToEachOther(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        long j11 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i12 + i14;
            int i16 = i13 + i14;
            long j12 = j11 + (((long) iArr[i15]) & 4294967295L) + (4294967295L & ((long) iArr2[i16]));
            int i17 = (int) j12;
            iArr[i15] = i17;
            iArr2[i16] = i17;
            j11 = j12 >>> 32;
        }
        return (int) j11;
    }

    public static int addWordAt(int i11, int i12, int[] iArr, int i13) {
        long j11 = (((long) i12) & 4294967295L) + (4294967295L & ((long) iArr[i13]));
        iArr[i13] = (int) j11;
        if ((j11 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, i13 + 1);
    }

    public static int addWordAt(int i11, int i12, int[] iArr, int i13, int i14) {
        int i15 = i13 + i14;
        long j11 = (((long) i12) & 4294967295L) + (4294967295L & ((long) iArr[i15]));
        iArr[i15] = (int) j11;
        if ((j11 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, i13, i14 + 1);
    }

    public static int addWordTo(int i11, int i12, int[] iArr) {
        long j11 = (((long) i12) & 4294967295L) + (4294967295L & ((long) iArr[0]));
        iArr[0] = (int) j11;
        if ((j11 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, 1);
    }

    public static int addWordTo(int i11, int i12, int[] iArr, int i13) {
        long j11 = (((long) i12) & 4294967295L) + (4294967295L & ((long) iArr[i13]));
        iArr[i13] = (int) j11;
        if ((j11 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, i13, 1);
    }

    public static int cadd(int i11, int i12, int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = ((long) (-(i12 & 1))) & 4294967295L;
        long j12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            long j13 = j12 + (((long) iArr[i13]) & 4294967295L) + (((long) iArr2[i13]) & j11);
            iArr3[i13] = (int) j13;
            j12 = j13 >>> 32;
        }
        return (int) j12;
    }

    public static void cmov(int i11, int i12, int[] iArr, int i13, int[] iArr2, int i14) {
        int i15 = -(i12 & 1);
        for (int i16 = 0; i16 < i11; i16++) {
            int i17 = i14 + i16;
            int i18 = iArr2[i17];
            iArr2[i17] = i18 ^ ((iArr[i13 + i16] ^ i18) & i15);
        }
    }

    public static int compare(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        for (int i14 = i11 - 1; i14 >= 0; i14--) {
            int i15 = iArr[i12 + i14] ^ Integer.MIN_VALUE;
            int i16 = Integer.MIN_VALUE ^ iArr2[i13 + i14];
            if (i15 < i16) {
                return -1;
            }
            if (i15 > i16) {
                return 1;
            }
        }
        return 0;
    }

    public static int compare(int i11, int[] iArr, int[] iArr2) {
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            int i13 = iArr[i12] ^ Integer.MIN_VALUE;
            int i14 = Integer.MIN_VALUE ^ iArr2[i12];
            if (i13 < i14) {
                return -1;
            }
            if (i13 > i14) {
                return 1;
            }
        }
        return 0;
    }

    public static void copy(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        System.arraycopy(iArr, i12, iArr2, i13, i11);
    }

    public static void copy(int i11, int[] iArr, int[] iArr2) {
        System.arraycopy(iArr, 0, iArr2, 0, i11);
    }

    public static int[] copy(int i11, int[] iArr) {
        int[] iArr2 = new int[i11];
        System.arraycopy(iArr, 0, iArr2, 0, i11);
        return iArr2;
    }

    public static void copy64(int i11, long[] jArr, int i12, long[] jArr2, int i13) {
        System.arraycopy(jArr, i12, jArr2, i13, i11);
    }

    public static void copy64(int i11, long[] jArr, long[] jArr2) {
        System.arraycopy(jArr, 0, jArr2, 0, i11);
    }

    public static long[] copy64(int i11, long[] jArr) {
        long[] jArr2 = new long[i11];
        System.arraycopy(jArr, 0, jArr2, 0, i11);
        return jArr2;
    }

    public static int[] create(int i11) {
        return new int[i11];
    }

    public static long[] create64(int i11) {
        return new long[i11];
    }

    public static int csub(int i11, int i12, int[] iArr, int i13, int[] iArr2, int i14, int[] iArr3, int i15) {
        long j11 = ((long) (-(i12 & 1))) & 4294967295L;
        long j12 = 0;
        int i16 = i11;
        for (int i17 = 0; i17 < i16; i17++) {
            long j13 = j12 + ((((long) iArr[i13 + i17]) & 4294967295L) - (((long) iArr2[i14 + i17]) & j11));
            iArr3[i15 + i17] = (int) j13;
            j12 = j13 >> 32;
        }
        return (int) j12;
    }

    public static int csub(int i11, int i12, int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = ((long) (-(i12 & 1))) & 4294967295L;
        long j12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            long j13 = j12 + ((((long) iArr[i13]) & 4294967295L) - (((long) iArr2[i13]) & j11));
            iArr3[i13] = (int) j13;
            j12 = j13 >> 32;
        }
        return (int) j12;
    }

    public static int dec(int i11, int[] iArr) {
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = iArr[i12] - 1;
            iArr[i12] = i13;
            if (i13 != -1) {
                return 0;
            }
        }
        return -1;
    }

    public static int dec(int i11, int[] iArr, int[] iArr2) {
        int i12 = 0;
        while (i12 < i11) {
            int i13 = iArr[i12] - 1;
            iArr2[i12] = i13;
            i12++;
            if (i13 != -1) {
                while (i12 < i11) {
                    iArr2[i12] = iArr[i12];
                    i12++;
                }
                return 0;
            }
        }
        return -1;
    }

    public static int decAt(int i11, int[] iArr, int i12) {
        while (i12 < i11) {
            int i13 = iArr[i12] - 1;
            iArr[i12] = i13;
            if (i13 != -1) {
                return 0;
            }
            i12++;
        }
        return -1;
    }

    public static int decAt(int i11, int[] iArr, int i12, int i13) {
        while (i13 < i11) {
            int i14 = i12 + i13;
            int i15 = iArr[i14] - 1;
            iArr[i14] = i15;
            if (i15 != -1) {
                return 0;
            }
            i13++;
        }
        return -1;
    }

    public static boolean diff(int i11, int[] iArr, int i12, int[] iArr2, int i13, int[] iArr3, int i14) {
        boolean gte = gte(i11, iArr, i12, iArr2, i13);
        if (gte) {
            sub(i11, iArr, i12, iArr2, i13, iArr3, i14);
        } else {
            sub(i11, iArr2, i13, iArr, i12, iArr3, i14);
        }
        return gte;
    }

    public static boolean eq(int i11, int[] iArr, int[] iArr2) {
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            if (iArr[i12] != iArr2[i12]) {
                return false;
            }
        }
        return true;
    }

    public static int equalTo(int i11, int[] iArr, int i12) {
        int i13 = i12 ^ iArr[0];
        for (int i14 = 1; i14 < i11; i14++) {
            i13 |= iArr[i14];
        }
        return (((i13 >>> 1) | (i13 & 1)) - 1) >> 31;
    }

    public static int equalTo(int i11, int[] iArr, int i12, int i13) {
        int i14 = i13 ^ iArr[i12];
        for (int i15 = 1; i15 < i11; i15++) {
            i14 |= iArr[i12 + i15];
        }
        return (((i14 >>> 1) | (i14 & 1)) - 1) >> 31;
    }

    public static int equalTo(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        int i14 = 0;
        for (int i15 = 0; i15 < i11; i15++) {
            i14 |= iArr[i12 + i15] ^ iArr2[i13 + i15];
        }
        return (((i14 >>> 1) | (i14 & 1)) - 1) >> 31;
    }

    public static int equalTo(int i11, int[] iArr, int[] iArr2) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 |= iArr[i13] ^ iArr2[i13];
        }
        return (((i12 >>> 1) | (i12 & 1)) - 1) >> 31;
    }

    public static int equalToZero(int i11, int[] iArr) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 |= iArr[i13];
        }
        return (((i12 >>> 1) | (i12 & 1)) - 1) >> 31;
    }

    public static int equalToZero(int i11, int[] iArr, int i12) {
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            i13 |= iArr[i12 + i14];
        }
        return (((i13 >>> 1) | (i13 & 1)) - 1) >> 31;
    }

    public static int[] fromBigInteger(int i11, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i11) {
            throw new IllegalArgumentException();
        }
        int i12 = (i11 + 31) >> 5;
        int[] create = create(i12);
        for (int i13 = 0; i13 < i12; i13++) {
            create[i13] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return create;
    }

    public static long[] fromBigInteger64(int i11, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i11) {
            throw new IllegalArgumentException();
        }
        int i12 = (i11 + 63) >> 6;
        long[] create64 = create64(i12);
        for (int i13 = 0; i13 < i12; i13++) {
            create64[i13] = bigInteger.longValue();
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
            if (i13 < 0 || i13 >= iArr.length) {
                return 0;
            }
            i12 = iArr[i13] >>> (i11 & 31);
        }
        return i12 & 1;
    }

    public static boolean gte(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        for (int i14 = i11 - 1; i14 >= 0; i14--) {
            int i15 = iArr[i12 + i14] ^ Integer.MIN_VALUE;
            int i16 = Integer.MIN_VALUE ^ iArr2[i13 + i14];
            if (i15 < i16) {
                return false;
            }
            if (i15 > i16) {
                return true;
            }
        }
        return true;
    }

    public static boolean gte(int i11, int[] iArr, int[] iArr2) {
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            int i13 = iArr[i12] ^ Integer.MIN_VALUE;
            int i14 = Integer.MIN_VALUE ^ iArr2[i12];
            if (i13 < i14) {
                return false;
            }
            if (i13 > i14) {
                return true;
            }
        }
        return true;
    }

    public static int inc(int i11, int[] iArr) {
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = iArr[i12] + 1;
            iArr[i12] = i13;
            if (i13 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int inc(int i11, int[] iArr, int[] iArr2) {
        int i12 = 0;
        while (i12 < i11) {
            int i13 = iArr[i12] + 1;
            iArr2[i12] = i13;
            i12++;
            if (i13 != 0) {
                while (i12 < i11) {
                    iArr2[i12] = iArr[i12];
                    i12++;
                }
                return 0;
            }
        }
        return 1;
    }

    public static int incAt(int i11, int[] iArr, int i12) {
        while (i12 < i11) {
            int i13 = iArr[i12] + 1;
            iArr[i12] = i13;
            if (i13 != 0) {
                return 0;
            }
            i12++;
        }
        return 1;
    }

    public static int incAt(int i11, int[] iArr, int i12, int i13) {
        while (i13 < i11) {
            int i14 = i12 + i13;
            int i15 = iArr[i14] + 1;
            iArr[i14] = i15;
            if (i15 != 0) {
                return 0;
            }
            i13++;
        }
        return 1;
    }

    public static boolean isOne(int i11, int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i12 = 1; i12 < i11; i12++) {
            if (iArr[i12] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isZero(int i11, int[] iArr) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (iArr[i12] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int lessThan(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        long j11 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            j11 = (j11 + ((((long) iArr[i12 + i14]) & 4294967295L) - (4294967295L & ((long) iArr2[i13 + i14])))) >> 32;
        }
        return (int) j11;
    }

    public static int lessThan(int i11, int[] iArr, int[] iArr2) {
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = (j11 + ((((long) iArr[i12]) & 4294967295L) - (4294967295L & ((long) iArr2[i12])))) >> 32;
        }
        return (int) j11;
    }

    public static void mul(int i11, int[] iArr, int i12, int[] iArr2, int i13, int[] iArr3, int i14) {
        iArr3[i14 + i11] = mulWord(i11, iArr[i12], iArr2, i13, iArr3, i14);
        for (int i15 = 1; i15 < i11; i15++) {
            int i16 = i14 + i15;
            iArr3[i16 + i11] = mulWordAddTo(i11, iArr[i12 + i15], iArr2, i13, iArr3, i16);
        }
    }

    public static void mul(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        iArr3[i11] = mulWord(i11, iArr[0], iArr2, iArr3);
        for (int i12 = 1; i12 < i11; i12++) {
            iArr3[i12 + i11] = mulWordAddTo(i11, iArr[i12], iArr2, 0, iArr3, i12);
        }
    }

    public static void mul(int[] iArr, int i11, int i12, int[] iArr2, int i13, int i14, int[] iArr3, int i15) {
        iArr3[i15 + i14] = mulWord(i14, iArr[i11], iArr2, i13, iArr3, i15);
        for (int i16 = 1; i16 < i12; i16++) {
            int i17 = i15 + i16;
            iArr3[i17 + i14] = mulWordAddTo(i14, iArr[i11 + i16], iArr2, i13, iArr3, i17);
        }
    }

    public static int mul31BothAdd(int i11, int i12, int[] iArr, int i13, int[] iArr2, int[] iArr3, int i14) {
        long j11 = ((long) i12) & 4294967295L;
        long j12 = ((long) i13) & 4294967295L;
        long j13 = 0;
        int i15 = 0;
        do {
            int i16 = i14 + i15;
            long j14 = j13 + ((((long) iArr[i15]) & 4294967295L) * j11) + ((((long) iArr2[i15]) & 4294967295L) * j12) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j14;
            j13 = j14 >>> 32;
            i15++;
        } while (i15 < i11);
        return (int) j13;
    }

    public static int mulAddTo(int i11, int[] iArr, int i12, int[] iArr2, int i13, int[] iArr3, int i14) {
        long j11 = 0;
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = i14 + i11;
            long mulWordAddTo = j11 + (((long) mulWordAddTo(i11, iArr[i12 + i15], iArr2, i13, iArr3, i14)) & 4294967295L) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) mulWordAddTo;
            j11 = mulWordAddTo >>> 32;
            i14++;
        }
        return (int) j11;
    }

    public static int mulAddTo(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i12 + i11;
            long mulWordAddTo = j11 + (((long) mulWordAddTo(i11, iArr[i12], iArr2, 0, iArr3, i12)) & 4294967295L) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) mulWordAddTo;
            j11 = mulWordAddTo >>> 32;
        }
        return (int) j11;
    }

    public static int mulWord(int i11, int i12, int[] iArr, int i13, int[] iArr2, int i14) {
        long j11 = ((long) i12) & 4294967295L;
        long j12 = 0;
        int i15 = 0;
        do {
            long j13 = j12 + ((((long) iArr[i13 + i15]) & 4294967295L) * j11);
            iArr2[i14 + i15] = (int) j13;
            j12 = j13 >>> 32;
            i15++;
        } while (i15 < i11);
        return (int) j12;
    }

    public static int mulWord(int i11, int i12, int[] iArr, int[] iArr2) {
        long j11 = ((long) i12) & 4294967295L;
        long j12 = 0;
        int i13 = 0;
        do {
            long j13 = j12 + ((((long) iArr[i13]) & 4294967295L) * j11);
            iArr2[i13] = (int) j13;
            j12 = j13 >>> 32;
            i13++;
        } while (i13 < i11);
        return (int) j12;
    }

    public static int mulWordAddTo(int i11, int i12, int[] iArr, int i13, int[] iArr2, int i14) {
        long j11 = ((long) i12) & 4294967295L;
        long j12 = 0;
        int i15 = 0;
        do {
            int i16 = i14 + i15;
            long j13 = j12 + ((((long) iArr[i13 + i15]) & 4294967295L) * j11) + (((long) iArr2[i16]) & 4294967295L);
            iArr2[i16] = (int) j13;
            j12 = j13 >>> 32;
            i15++;
        } while (i15 < i11);
        return (int) j12;
    }

    public static int mulWordDwordAddAt(int i11, int i12, long j11, int[] iArr, int i13) {
        long j12 = ((long) i12) & 4294967295L;
        int i14 = i13 + 0;
        long j13 = ((j11 & 4294967295L) * j12) + (((long) iArr[i14]) & 4294967295L) + 0;
        iArr[i14] = (int) j13;
        long j14 = j12 * (j11 >>> 32);
        int i15 = i13 + 1;
        long j15 = (j13 >>> 32) + j14 + (((long) iArr[i15]) & 4294967295L);
        iArr[i15] = (int) j15;
        int i16 = i13 + 2;
        long j16 = (j15 >>> 32) + (((long) iArr[i16]) & 4294967295L);
        iArr[i16] = (int) j16;
        if ((j16 >>> 32) == 0) {
            return 0;
        }
        return incAt(i11, iArr, i13 + 3);
    }

    public static int shiftDownBit(int i11, int[] iArr, int i12) {
        while (true) {
            i11--;
            if (i11 < 0) {
                return i12 << 31;
            }
            int i13 = iArr[i11];
            iArr[i11] = (i12 << 31) | (i13 >>> 1);
            i12 = i13;
        }
    }

    public static int shiftDownBit(int i11, int[] iArr, int i12, int i13) {
        while (true) {
            i11--;
            if (i11 < 0) {
                return i13 << 31;
            }
            int i14 = i12 + i11;
            int i15 = iArr[i14];
            iArr[i14] = (i13 << 31) | (i15 >>> 1);
            i13 = i15;
        }
    }

    public static int shiftDownBit(int i11, int[] iArr, int i12, int i13, int[] iArr2, int i14) {
        while (true) {
            i11--;
            if (i11 < 0) {
                return i13 << 31;
            }
            int i15 = iArr[i12 + i11];
            iArr2[i14 + i11] = (i13 << 31) | (i15 >>> 1);
            i13 = i15;
        }
    }

    public static int shiftDownBit(int i11, int[] iArr, int i12, int[] iArr2) {
        while (true) {
            i11--;
            if (i11 < 0) {
                return i12 << 31;
            }
            int i13 = iArr[i11];
            iArr2[i11] = (i12 << 31) | (i13 >>> 1);
            i12 = i13;
        }
    }

    public static int shiftDownBits(int i11, int[] iArr, int i12, int i13) {
        while (true) {
            i11--;
            if (i11 < 0) {
                return i13 << (-i12);
            }
            int i14 = iArr[i11];
            iArr[i11] = (i13 << (-i12)) | (i14 >>> i12);
            i13 = i14;
        }
    }

    public static int shiftDownBits(int i11, int[] iArr, int i12, int i13, int i14) {
        while (true) {
            i11--;
            if (i11 < 0) {
                return i14 << (-i13);
            }
            int i15 = i12 + i11;
            int i16 = iArr[i15];
            iArr[i15] = (i14 << (-i13)) | (i16 >>> i13);
            i14 = i16;
        }
    }

    public static int shiftDownBits(int i11, int[] iArr, int i12, int i13, int i14, int[] iArr2, int i15) {
        while (true) {
            i11--;
            if (i11 < 0) {
                return i14 << (-i13);
            }
            int i16 = iArr[i12 + i11];
            iArr2[i15 + i11] = (i14 << (-i13)) | (i16 >>> i13);
            i14 = i16;
        }
    }

    public static int shiftDownBits(int i11, int[] iArr, int i12, int i13, int[] iArr2) {
        while (true) {
            i11--;
            if (i11 < 0) {
                return i13 << (-i12);
            }
            int i14 = iArr[i11];
            iArr2[i11] = (i13 << (-i12)) | (i14 >>> i12);
            i13 = i14;
        }
    }

    public static int shiftDownWord(int i11, int[] iArr, int i12) {
        while (true) {
            i11--;
            if (i11 < 0) {
                return i12;
            }
            int i13 = iArr[i11];
            iArr[i11] = i12;
            i12 = i13;
        }
    }

    public static int shiftUpBit(int i11, int[] iArr, int i12) {
        int i13 = 0;
        while (i13 < i11) {
            int i14 = iArr[i13];
            iArr[i13] = (i12 >>> 31) | (i14 << 1);
            i13++;
            i12 = i14;
        }
        return i12 >>> 31;
    }

    public static int shiftUpBit(int i11, int[] iArr, int i12, int i13) {
        int i14 = 0;
        while (i14 < i11) {
            int i15 = i12 + i14;
            int i16 = iArr[i15];
            iArr[i15] = (i13 >>> 31) | (i16 << 1);
            i14++;
            i13 = i16;
        }
        return i13 >>> 31;
    }

    public static int shiftUpBit(int i11, int[] iArr, int i12, int i13, int[] iArr2, int i14) {
        int i15 = 0;
        while (i15 < i11) {
            int i16 = iArr[i12 + i15];
            iArr2[i14 + i15] = (i13 >>> 31) | (i16 << 1);
            i15++;
            i13 = i16;
        }
        return i13 >>> 31;
    }

    public static int shiftUpBit(int i11, int[] iArr, int i12, int[] iArr2) {
        int i13 = 0;
        while (i13 < i11) {
            int i14 = iArr[i13];
            iArr2[i13] = (i12 >>> 31) | (i14 << 1);
            i13++;
            i12 = i14;
        }
        return i12 >>> 31;
    }

    public static long shiftUpBit64(int i11, long[] jArr, int i12, long j11, long[] jArr2, int i13) {
        int i14 = 0;
        while (i14 < i11) {
            long j12 = jArr[i12 + i14];
            jArr2[i13 + i14] = (j11 >>> 63) | (j12 << 1);
            i14++;
            j11 = j12;
        }
        return j11 >>> 63;
    }

    public static int shiftUpBits(int i11, int[] iArr, int i12, int i13) {
        int i14 = 0;
        while (i14 < i11) {
            int i15 = iArr[i14];
            iArr[i14] = (i13 >>> (-i12)) | (i15 << i12);
            i14++;
            i13 = i15;
        }
        return i13 >>> (-i12);
    }

    public static int shiftUpBits(int i11, int[] iArr, int i12, int i13, int i14) {
        int i15 = 0;
        while (i15 < i11) {
            int i16 = i12 + i15;
            int i17 = iArr[i16];
            iArr[i16] = (i14 >>> (-i13)) | (i17 << i13);
            i15++;
            i14 = i17;
        }
        return i14 >>> (-i13);
    }

    public static int shiftUpBits(int i11, int[] iArr, int i12, int i13, int i14, int[] iArr2, int i15) {
        int i16 = 0;
        while (i16 < i11) {
            int i17 = iArr[i12 + i16];
            iArr2[i15 + i16] = (i14 >>> (-i13)) | (i17 << i13);
            i16++;
            i14 = i17;
        }
        return i14 >>> (-i13);
    }

    public static int shiftUpBits(int i11, int[] iArr, int i12, int i13, int[] iArr2) {
        int i14 = 0;
        while (i14 < i11) {
            int i15 = iArr[i14];
            iArr2[i14] = (i13 >>> (-i12)) | (i15 << i12);
            i14++;
            i13 = i15;
        }
        return i13 >>> (-i12);
    }

    public static long shiftUpBits64(int i11, long[] jArr, int i12, int i13, long j11) {
        int i14 = 0;
        while (i14 < i11) {
            int i15 = i12 + i14;
            long j12 = jArr[i15];
            jArr[i15] = (j11 >>> (-i13)) | (j12 << i13);
            i14++;
            j11 = j12;
        }
        return j11 >>> (-i13);
    }

    public static long shiftUpBits64(int i11, long[] jArr, int i12, int i13, long j11, long[] jArr2, int i14) {
        int i15 = 0;
        while (i15 < i11) {
            long j12 = jArr[i12 + i15];
            jArr2[i14 + i15] = (j11 >>> (-i13)) | (j12 << i13);
            i15++;
            j11 = j12;
        }
        return j11 >>> (-i13);
    }

    public static void square(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        int i14;
        int i15 = i11 << 1;
        int i16 = 0;
        int i17 = i11;
        int i18 = i15;
        do {
            i17--;
            long j11 = ((long) iArr[i12 + i17]) & 4294967295L;
            long j12 = j11 * j11;
            int i19 = i18 - 1;
            iArr2[i13 + i19] = (i16 << 31) | ((int) (j12 >>> 33));
            i18 = i19 - 1;
            i14 = 1;
            iArr2[i13 + i18] = (int) (j12 >>> 1);
            i16 = (int) j12;
        } while (i17 > 0);
        long j13 = 0;
        int i21 = i13 + 2;
        while (i14 < i11) {
            long squareWordAddTo = j13 + (((long) squareWordAddTo(iArr, i12, i14, iArr2, i13)) & 4294967295L) + (((long) iArr2[i21]) & 4294967295L);
            int i22 = i21 + 1;
            iArr2[i21] = (int) squareWordAddTo;
            long j14 = (squareWordAddTo >>> 32) + (((long) iArr2[i22]) & 4294967295L);
            iArr2[i22] = (int) j14;
            j13 = j14 >>> 32;
            i14++;
            i21 = i22 + 1;
        }
        shiftUpBit(i15, iArr2, i13, iArr[i12] << 31);
    }

    public static void square(int i11, int[] iArr, int[] iArr2) {
        int i12;
        int i13 = i11 << 1;
        int i14 = i11;
        int i15 = i13;
        int i16 = 0;
        while (true) {
            i14--;
            long j11 = ((long) iArr[i14]) & 4294967295L;
            long j12 = j11 * j11;
            int i17 = i15 - 1;
            iArr2[i17] = (i16 << 31) | ((int) (j12 >>> 33));
            i15 = i17 - 1;
            i12 = 1;
            iArr2[i15] = (int) (j12 >>> 1);
            int i18 = (int) j12;
            if (i14 <= 0) {
                break;
            }
            i16 = i18;
        }
        long j13 = 0;
        int i19 = 2;
        while (i12 < i11) {
            long squareWordAddTo = j13 + (((long) squareWordAddTo(iArr, i12, iArr2)) & 4294967295L) + (((long) iArr2[i19]) & 4294967295L);
            int i21 = i19 + 1;
            iArr2[i19] = (int) squareWordAddTo;
            long j14 = (squareWordAddTo >>> 32) + (((long) iArr2[i21]) & 4294967295L);
            iArr2[i21] = (int) j14;
            j13 = j14 >>> 32;
            i12++;
            i19 = i21 + 1;
        }
        shiftUpBit(i13, iArr2, iArr[0] << 31);
    }

    public static int squareWordAddTo(int[] iArr, int i11, int i12, int[] iArr2, int i13) {
        int i14 = i12;
        long j11 = ((long) iArr[i11 + i14]) & 4294967295L;
        int i15 = 0;
        long j12 = 0;
        int i16 = i13;
        do {
            int i17 = i14 + i16;
            long j13 = j12 + ((((long) iArr[i11 + i15]) & 4294967295L) * j11) + (((long) iArr2[i17]) & 4294967295L);
            iArr2[i17] = (int) j13;
            j12 = j13 >>> 32;
            i16++;
            i15++;
        } while (i15 < i14);
        return (int) j12;
    }

    public static int squareWordAddTo(int[] iArr, int i11, int[] iArr2) {
        long j11 = ((long) iArr[i11]) & 4294967295L;
        long j12 = 0;
        int i12 = 0;
        do {
            int i13 = i11 + i12;
            long j13 = j12 + ((((long) iArr[i12]) & 4294967295L) * j11) + (((long) iArr2[i13]) & 4294967295L);
            iArr2[i13] = (int) j13;
            j12 = j13 >>> 32;
            i12++;
        } while (i12 < i11);
        return (int) j12;
    }

    public static int sub(int i11, int[] iArr, int i12, int[] iArr2, int i13, int[] iArr3, int i14) {
        long j11 = 0;
        for (int i15 = 0; i15 < i11; i15++) {
            long j12 = j11 + ((((long) iArr[i12 + i15]) & 4294967295L) - (4294967295L & ((long) iArr2[i13 + i15])));
            iArr3[i14 + i15] = (int) j12;
            j11 = j12 >> 32;
        }
        return (int) j11;
    }

    public static int sub(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            long j12 = j11 + ((((long) iArr[i12]) & 4294967295L) - (4294967295L & ((long) iArr2[i12])));
            iArr3[i12] = (int) j12;
            j11 = j12 >> 32;
        }
        return (int) j11;
    }

    public static int sub33At(int i11, int i12, int[] iArr, int i13) {
        int i14 = i13 + 0;
        long j11 = (((long) iArr[i14]) & 4294967295L) - (((long) i12) & 4294967295L);
        iArr[i14] = (int) j11;
        int i15 = i13 + 1;
        long j12 = (j11 >> 32) + ((4294967295L & ((long) iArr[i15])) - 1);
        iArr[i15] = (int) j12;
        if ((j12 >> 32) == 0) {
            return 0;
        }
        return decAt(i11, iArr, i13 + 2);
    }

    public static int sub33At(int i11, int i12, int[] iArr, int i13, int i14) {
        int i15 = i13 + i14;
        long j11 = (((long) iArr[i15]) & 4294967295L) - (((long) i12) & 4294967295L);
        iArr[i15] = (int) j11;
        int i16 = i15 + 1;
        long j12 = (j11 >> 32) + ((4294967295L & ((long) iArr[i16])) - 1);
        iArr[i16] = (int) j12;
        if ((j12 >> 32) == 0) {
            return 0;
        }
        return decAt(i11, iArr, i13, i14 + 2);
    }

    public static int sub33From(int i11, int i12, int[] iArr) {
        long j11 = (((long) iArr[0]) & 4294967295L) - (((long) i12) & 4294967295L);
        iArr[0] = (int) j11;
        long j12 = (j11 >> 32) + ((4294967295L & ((long) iArr[1])) - 1);
        iArr[1] = (int) j12;
        if ((j12 >> 32) == 0) {
            return 0;
        }
        return decAt(i11, iArr, 2);
    }

    public static int sub33From(int i11, int i12, int[] iArr, int i13) {
        int i14 = i13 + 0;
        long j11 = (((long) iArr[i14]) & 4294967295L) - (((long) i12) & 4294967295L);
        iArr[i14] = (int) j11;
        int i15 = i13 + 1;
        long j12 = (j11 >> 32) + ((4294967295L & ((long) iArr[i15])) - 1);
        iArr[i15] = (int) j12;
        if ((j12 >> 32) == 0) {
            return 0;
        }
        return decAt(i11, iArr, i13, 2);
    }

    public static int subBothFrom(int i11, int[] iArr, int i12, int[] iArr2, int i13, int[] iArr3, int i14) {
        long j11 = 0;
        int i15 = i11;
        for (int i16 = 0; i16 < i15; i16++) {
            int i17 = i14 + i16;
            long j12 = j11 + (((((long) iArr3[i17]) & 4294967295L) - (((long) iArr[i12 + i16]) & 4294967295L)) - (4294967295L & ((long) iArr2[i13 + i16])));
            iArr3[i17] = (int) j12;
            j11 = j12 >> 32;
        }
        return (int) j11;
    }

    public static int subBothFrom(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            long j12 = j11 + (((((long) iArr3[i12]) & 4294967295L) - (((long) iArr[i12]) & 4294967295L)) - (4294967295L & ((long) iArr2[i12])));
            iArr3[i12] = (int) j12;
            j11 = j12 >> 32;
        }
        return (int) j11;
    }

    public static int subDWordAt(int i11, long j11, int[] iArr, int i12) {
        int i13 = i12 + 0;
        long j12 = (((long) iArr[i13]) & 4294967295L) - (j11 & 4294967295L);
        iArr[i13] = (int) j12;
        int i14 = i12 + 1;
        long j13 = (j12 >> 32) + ((4294967295L & ((long) iArr[i14])) - (j11 >>> 32));
        iArr[i14] = (int) j13;
        if ((j13 >> 32) == 0) {
            return 0;
        }
        return decAt(i11, iArr, i12 + 2);
    }

    public static int subDWordAt(int i11, long j11, int[] iArr, int i12, int i13) {
        int i14 = i12 + i13;
        long j12 = (((long) iArr[i14]) & 4294967295L) - (j11 & 4294967295L);
        iArr[i14] = (int) j12;
        int i15 = i14 + 1;
        long j13 = (j12 >> 32) + ((4294967295L & ((long) iArr[i15])) - (j11 >>> 32));
        iArr[i15] = (int) j13;
        if ((j13 >> 32) == 0) {
            return 0;
        }
        return decAt(i11, iArr, i12, i13 + 2);
    }

    public static int subDWordFrom(int i11, long j11, int[] iArr) {
        long j12 = (((long) iArr[0]) & 4294967295L) - (j11 & 4294967295L);
        iArr[0] = (int) j12;
        long j13 = (j12 >> 32) + ((4294967295L & ((long) iArr[1])) - (j11 >>> 32));
        iArr[1] = (int) j13;
        if ((j13 >> 32) == 0) {
            return 0;
        }
        return decAt(i11, iArr, 2);
    }

    public static int subDWordFrom(int i11, long j11, int[] iArr, int i12) {
        int i13 = i12 + 0;
        long j12 = (((long) iArr[i13]) & 4294967295L) - (j11 & 4294967295L);
        iArr[i13] = (int) j12;
        int i14 = i12 + 1;
        long j13 = (j12 >> 32) + ((4294967295L & ((long) iArr[i14])) - (j11 >>> 32));
        iArr[i14] = (int) j13;
        if ((j13 >> 32) == 0) {
            return 0;
        }
        return decAt(i11, iArr, i12, 2);
    }

    public static int subFrom(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        long j11 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = i13 + i14;
            long j12 = j11 + ((((long) iArr2[i15]) & 4294967295L) - (4294967295L & ((long) iArr[i12 + i14])));
            iArr2[i15] = (int) j12;
            j11 = j12 >> 32;
        }
        return (int) j11;
    }

    public static int subFrom(int i11, int[] iArr, int[] iArr2) {
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            long j12 = j11 + ((((long) iArr2[i12]) & 4294967295L) - (4294967295L & ((long) iArr[i12])));
            iArr2[i12] = (int) j12;
            j11 = j12 >> 32;
        }
        return (int) j11;
    }

    public static int subWordAt(int i11, int i12, int[] iArr, int i13) {
        long j11 = (((long) iArr[i13]) & 4294967295L) - (4294967295L & ((long) i12));
        iArr[i13] = (int) j11;
        if ((j11 >> 32) == 0) {
            return 0;
        }
        return decAt(i11, iArr, i13 + 1);
    }

    public static int subWordAt(int i11, int i12, int[] iArr, int i13, int i14) {
        int i15 = i13 + i14;
        long j11 = (((long) iArr[i15]) & 4294967295L) - (4294967295L & ((long) i12));
        iArr[i15] = (int) j11;
        if ((j11 >> 32) == 0) {
            return 0;
        }
        return decAt(i11, iArr, i13, i14 + 1);
    }

    public static int subWordFrom(int i11, int i12, int[] iArr) {
        long j11 = (((long) iArr[0]) & 4294967295L) - (4294967295L & ((long) i12));
        iArr[0] = (int) j11;
        if ((j11 >> 32) == 0) {
            return 0;
        }
        return decAt(i11, iArr, 1);
    }

    public static int subWordFrom(int i11, int i12, int[] iArr, int i13) {
        int i14 = i13 + 0;
        long j11 = (((long) iArr[i14]) & 4294967295L) - (4294967295L & ((long) i12));
        iArr[i14] = (int) j11;
        if ((j11 >> 32) == 0) {
            return 0;
        }
        return decAt(i11, iArr, i13, 1);
    }

    public static BigInteger toBigInteger(int i11, int[] iArr) {
        byte[] bArr = new byte[(i11 << 2)];
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = iArr[i12];
            if (i13 != 0) {
                Pack.intToBigEndian(i13, bArr, ((i11 - 1) - i12) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void zero(int i11, int[] iArr) {
        for (int i12 = 0; i12 < i11; i12++) {
            iArr[i12] = 0;
        }
    }

    public static void zero(int i11, int[] iArr, int i12) {
        for (int i13 = 0; i13 < i11; i13++) {
            iArr[i12 + i13] = 0;
        }
    }

    public static void zero64(int i11, long[] jArr) {
        for (int i12 = 0; i12 < i11; i12++) {
            jArr[i12] = 0;
        }
    }
}
