package org.bouncycastle.crypto.modes.kgcm;

import org.bouncycastle.math.raw.Interleave;

public class KGCMUtil_128 {
    public static final int SIZE = 2;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }

    public static void copy(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
    }

    public static boolean equal(long[] jArr, long[] jArr2) {
        return ((jArr2[1] ^ jArr[1]) | ((jArr[0] ^ jArr2[0]) | 0)) == 0;
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        int i11 = 0;
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = jArr2[0];
        long j14 = jArr2[1];
        long j15 = 0;
        long j16 = 0;
        long j17 = 0;
        while (i11 < 64) {
            long j18 = j16;
            long j19 = -(j11 & 1);
            j11 >>>= 1;
            j15 ^= j13 & j19;
            long j21 = (j19 & j14) ^ j17;
            long j22 = -(j12 & 1);
            j12 >>>= 1;
            long j23 = j21 ^ (j13 & j22);
            long j24 = j18 ^ (j22 & j14);
            long j25 = j14 >> 63;
            j14 = (j14 << 1) | (j13 >>> 63);
            j13 = (j13 << 1) ^ (j25 & 135);
            i11++;
            long j26 = j23;
            j16 = j24;
            j17 = j26;
        }
        long j27 = j16;
        jArr3[0] = (((j27 ^ (j27 << 1)) ^ (j27 << 2)) ^ (j27 << 7)) ^ j15;
        jArr3[1] = (((j27 >>> 63) ^ (j27 >>> 62)) ^ (j27 >>> 57)) ^ j17;
    }

    public static void multiplyX(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        jArr2[0] = ((j12 >> 63) & 135) ^ (j11 << 1);
        jArr2[1] = (j11 >>> 63) | (j12 << 1);
    }

    public static void multiplyX8(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = j12 >>> 56;
        jArr2[0] = (j13 << 7) ^ ((((j11 << 8) ^ j13) ^ (j13 << 1)) ^ (j13 << 2));
        jArr2[1] = (j11 >>> 56) | (j12 << 8);
    }

    public static void one(long[] jArr) {
        jArr[0] = 1;
        jArr[1] = 0;
    }

    public static void square(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[4];
        Interleave.expand64To128(jArr[0], jArr3, 0);
        Interleave.expand64To128(jArr[1], jArr3, 2);
        long j11 = jArr3[0];
        long j12 = jArr3[1];
        long j13 = jArr3[2];
        long j14 = jArr3[3];
        long j15 = j13 ^ ((j14 >>> 57) ^ ((j14 >>> 63) ^ (j14 >>> 62)));
        long j16 = j11 ^ ((((j15 << 1) ^ j15) ^ (j15 << 2)) ^ (j15 << 7));
        jArr2[0] = j16;
        jArr2[1] = (j12 ^ ((((j14 << 1) ^ j14) ^ (j14 << 2)) ^ (j14 << 7))) ^ ((j15 >>> 57) ^ ((j15 >>> 63) ^ (j15 >>> 62)));
    }

    public static void x(long[] jArr) {
        jArr[0] = 2;
        jArr[1] = 0;
    }

    public static void zero(long[] jArr) {
        jArr[0] = 0;
        jArr[1] = 0;
    }
}
