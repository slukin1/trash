package org.bouncycastle.crypto.modes.kgcm;

import org.bouncycastle.math.raw.Interleave;

public class KGCMUtil_512 {
    public static final int SIZE = 8;

    public static void add(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr2[7] ^ jArr[7];
    }

    public static void copy(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
        jArr2[7] = jArr[7];
    }

    public static boolean equal(long[] jArr, long[] jArr2) {
        return ((jArr2[7] ^ jArr[7]) | ((((((((jArr[0] ^ jArr2[0]) | 0) | (jArr[1] ^ jArr2[1])) | (jArr[2] ^ jArr2[2])) | (jArr[3] ^ jArr2[3])) | (jArr[4] ^ jArr2[4])) | (jArr[5] ^ jArr2[5])) | (jArr[6] ^ jArr2[6]))) == 0;
    }

    public static void multiply(long[] jArr, long[] jArr2, long[] jArr3) {
        int i11 = 0;
        long j11 = jArr2[0];
        long j12 = jArr2[1];
        char c11 = 2;
        long j13 = jArr2[2];
        long j14 = jArr2[3];
        long j15 = jArr2[4];
        long j16 = jArr2[5];
        long j17 = jArr2[6];
        long j18 = jArr2[7];
        long j19 = 0;
        int i12 = 0;
        long j21 = 0;
        long j22 = 0;
        long j23 = 0;
        long j24 = 0;
        long j25 = 0;
        long j26 = 0;
        long j27 = 0;
        long j28 = 0;
        while (i12 < 8) {
            long j29 = jArr[i12];
            long j30 = jArr[i12 + 1];
            long j31 = j12;
            long j32 = j17;
            j17 = j16;
            j16 = j15;
            j15 = j14;
            j14 = j13;
            long j33 = j31;
            while (i11 < 64) {
                long j34 = j33;
                long j35 = -(j29 & 1);
                j29 >>>= 1;
                j19 ^= j11 & j35;
                long j36 = j14;
                long j37 = -(j30 & 1);
                j30 >>>= 1;
                j22 = (j22 ^ (j34 & j35)) ^ (j11 & j37);
                j23 = (j23 ^ (j14 & j35)) ^ (j34 & j37);
                j24 = (j24 ^ (j15 & j35)) ^ (j36 & j37);
                j25 = (j25 ^ (j16 & j35)) ^ (j15 & j37);
                j26 = (j26 ^ (j17 & j35)) ^ (j16 & j37);
                j27 = (j27 ^ (j32 & j35)) ^ (j17 & j37);
                j28 = (j28 ^ (j18 & j35)) ^ (j32 & j37);
                j21 ^= j18 & j37;
                long j38 = j18 >> 63;
                j18 = (j18 << 1) | (j32 >>> 63);
                j32 = (j32 << 1) | (j17 >>> 63);
                j17 = (j17 << 1) | (j16 >>> 63);
                j16 = (j16 << 1) | (j15 >>> 63);
                j15 = (j15 << 1) | (j36 >>> 63);
                j11 = (j11 << 1) ^ (j38 & 293);
                i11++;
                j33 = (j34 << 1) | (j11 >>> 63);
                j14 = (j36 << 1) | (j34 >>> 63);
            }
            long j39 = j14;
            long j40 = ((j11 ^ (j18 >>> 62)) ^ (j18 >>> 59)) ^ (j18 >>> 56);
            i12 += 2;
            j18 = j32;
            j12 = j40;
            i11 = 0;
            c11 = 2;
            j11 = ((j18 ^ (j18 << 2)) ^ (j18 << 5)) ^ (j18 << 8);
            j13 = j33;
        }
        jArr3[0] = j19 ^ (((j21 ^ (j21 << c11)) ^ (j21 << 5)) ^ (j21 << 8));
        jArr3[1] = j22 ^ (((j21 >>> 62) ^ (j21 >>> 59)) ^ (j21 >>> 56));
        jArr3[2] = j23;
        jArr3[3] = j24;
        jArr3[4] = j25;
        jArr3[5] = j26;
        jArr3[6] = j27;
        jArr3[7] = j28;
    }

    public static void multiplyX(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = jArr[2];
        long j14 = jArr[3];
        long j15 = jArr[4];
        long j16 = jArr[5];
        long j17 = jArr[6];
        long j18 = jArr[7];
        jArr2[0] = (j11 << 1) ^ ((j18 >> 63) & 293);
        jArr2[1] = (j12 << 1) | (j11 >>> 63);
        jArr2[2] = (j13 << 1) | (j12 >>> 63);
        jArr2[3] = (j14 << 1) | (j13 >>> 63);
        jArr2[4] = (j15 << 1) | (j14 >>> 63);
        jArr2[5] = (j16 << 1) | (j15 >>> 63);
        jArr2[6] = (j17 << 1) | (j16 >>> 63);
        jArr2[7] = (j18 << 1) | (j17 >>> 63);
    }

    public static void multiplyX8(long[] jArr, long[] jArr2) {
        long j11 = jArr[0];
        long j12 = jArr[1];
        long j13 = jArr[2];
        long j14 = jArr[3];
        long j15 = jArr[4];
        long j16 = jArr[5];
        long j17 = jArr[6];
        long j18 = jArr[7];
        long j19 = j18 >>> 56;
        jArr2[0] = ((((j11 << 8) ^ j19) ^ (j19 << 2)) ^ (j19 << 5)) ^ (j19 << 8);
        jArr2[1] = (j12 << 8) | (j11 >>> 56);
        jArr2[2] = (j13 << 8) | (j12 >>> 56);
        jArr2[3] = (j14 << 8) | (j13 >>> 56);
        jArr2[4] = (j15 << 8) | (j14 >>> 56);
        jArr2[5] = (j16 << 8) | (j15 >>> 56);
        jArr2[6] = (j17 << 8) | (j16 >>> 56);
        jArr2[7] = (j18 << 8) | (j17 >>> 56);
    }

    public static void one(long[] jArr) {
        jArr[0] = 1;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
        jArr[4] = 0;
        jArr[5] = 0;
        jArr[6] = 0;
        jArr[7] = 0;
    }

    public static void square(long[] jArr, long[] jArr2) {
        int i11 = 16;
        long[] jArr3 = new long[16];
        for (int i12 = 0; i12 < 8; i12++) {
            Interleave.expand64To128(jArr[i12], jArr3, i12 << 1);
        }
        while (true) {
            i11--;
            if (i11 >= 8) {
                long j11 = jArr3[i11];
                int i13 = i11 - 8;
                jArr3[i13] = jArr3[i13] ^ ((((j11 << 2) ^ j11) ^ (j11 << 5)) ^ (j11 << 8));
                int i14 = i13 + 1;
                jArr3[i14] = ((j11 >>> 56) ^ ((j11 >>> 62) ^ (j11 >>> 59))) ^ jArr3[i14];
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
        jArr[4] = 0;
        jArr[5] = 0;
        jArr[6] = 0;
        jArr[7] = 0;
    }

    public static void zero(long[] jArr) {
        jArr[0] = 0;
        jArr[1] = 0;
        jArr[2] = 0;
        jArr[3] = 0;
        jArr[4] = 0;
        jArr[5] = 0;
        jArr[6] = 0;
        jArr[7] = 0;
    }
}
