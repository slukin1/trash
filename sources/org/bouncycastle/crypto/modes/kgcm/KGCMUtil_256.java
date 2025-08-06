package org.bouncycastle.crypto.modes.kgcm;

import org.bouncycastle.math.raw.Interleave;

public class KGCMUtil_256 {
    public static final int SIZE = 4;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    public static void copy(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    public static boolean equal(long[] jArr, long[] jArr2) {
        return ((jArr2[3] ^ jArr[3]) | ((((jArr[0] ^ jArr2[0]) | 0) | (jArr[1] ^ jArr2[1])) | (jArr[2] ^ jArr2[2]))) == 0;
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        int i11;
        long j11;
        long j12 = jArr[0];
        long j13 = jArr[1];
        long j14 = jArr[2];
        long j15 = jArr[3];
        long j16 = jArr2[0];
        long j17 = jArr2[1];
        long j18 = jArr2[2];
        long j19 = jArr2[3];
        long j21 = 0;
        int i12 = 0;
        long j22 = 0;
        long j23 = 0;
        long j24 = 0;
        long j25 = 0;
        while (true) {
            j11 = j14;
            if (i12 >= 64) {
                break;
            }
            long j26 = -(j12 & 1);
            j21 ^= j16 & j26;
            long j27 = -(j13 & 1);
            j13 >>>= 1;
            j22 = (j22 ^ (j17 & j26)) ^ (j16 & j27);
            j23 = (j23 ^ (j18 & j26)) ^ (j17 & j27);
            j24 = (j24 ^ (j19 & j26)) ^ (j18 & j27);
            j25 ^= j19 & j27;
            long j28 = j19 >> 63;
            j19 = (j19 << 1) | (j18 >>> 63);
            j18 = (j18 << 1) | (j17 >>> 63);
            j17 = (j16 >>> 63) | (j17 << 1);
            j16 = (j16 << 1) ^ (j28 & 1061);
            i12++;
            j12 >>>= 1;
            j14 = j11;
        }
        long j29 = (((j19 >>> 62) ^ j16) ^ (j19 >>> 59)) ^ (j19 >>> 54);
        long j30 = j18;
        int i13 = 0;
        long j31 = j17;
        long j32 = j15;
        long j33 = ((j19 ^ (j19 << 2)) ^ (j19 << 5)) ^ (j19 << 10);
        long j34 = j11;
        for (i11 = 64; i13 < i11; i11 = 64) {
            long j35 = -(j34 & 1);
            j34 >>>= 1;
            j21 ^= j33 & j35;
            long j36 = j33;
            long j37 = -(j32 & 1);
            j32 >>>= 1;
            j22 = (j22 ^ (j29 & j35)) ^ (j36 & j37);
            j23 = (j23 ^ (j31 & j35)) ^ (j29 & j37);
            j24 = (j24 ^ (j30 & j35)) ^ (j31 & j37);
            j25 ^= j30 & j37;
            long j38 = j30 >> 63;
            j30 = (j30 << 1) | (j31 >>> 63);
            j31 = (j29 >>> 63) | (j31 << 1);
            j29 = (j29 << 1) | (j36 >>> 63);
            j33 = (j36 << 1) ^ (j38 & 1061);
            i13++;
        }
        jArr3[0] = j21 ^ (((j25 ^ (j25 << 2)) ^ (j25 << 5)) ^ (j25 << 10));
        jArr3[1] = j22 ^ (((j25 >>> 62) ^ (j25 >>> 59)) ^ (j25 >>> 54));
        jArr3[2] = j23;
        jArr3[3] = j24;
    }

    public static void multiplyX(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = jArr[2];
        long j14 = jArr[3];
        jArr2[0] = ((j14 >> 63) & 1061) ^ (j11 << 1);
        jArr2[1] = (j11 >>> 63) | (j12 << 1);
        jArr2[2] = (j13 << 1) | (j12 >>> 63);
        jArr2[3] = (j14 << 1) | (j13 >>> 63);
    }

    public static void multiplyX8(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = jArr[2];
        long j14 = jArr[3];
        long j15 = j14 >>> 56;
        jArr2[0] = ((((j11 << 8) ^ j15) ^ (j15 << 2)) ^ (j15 << 5)) ^ (j15 << 10);
        jArr2[1] = (j11 >>> 56) | (j12 << 8);
        jArr2[2] = (j13 << 8) | (j12 >>> 56);
        jArr2[3] = (j14 << 8) | (j13 >>> 56);
    }

    public static void one(long[] jArr) {
        jArr[0] = 1;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
    }

    public static void square(long[] jArr, long[] jArr2) {
        int i11 = 8;
        long[] jArr3 = new long[8];
        for (int i12 = 0; i12 < 4; i12++) {
            Interleave.expand64To128(jArr[i12], jArr3, i12 << 1);
        }
        while (true) {
            i11--;
            if (i11 >= 4) {
                long j11 = jArr3[i11];
                int i13 = i11 - 4;
                jArr3[i13] = jArr3[i13] ^ ((((j11 << 2) ^ j11) ^ (j11 << 5)) ^ (j11 << 10));
                int i14 = i13 + 1;
                jArr3[i14] = ((j11 >>> 54) ^ ((j11 >>> 62) ^ (j11 >>> 59))) ^ jArr3[i14];
            } else {
                copy(jArr3, jArr2);
                return;
            }
        }
    }

    public static void x(long[] jArr) {
        jArr[0] = 2;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
    }

    public static void zero(long[] jArr) {
        jArr[0] = 0;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
    }
}
